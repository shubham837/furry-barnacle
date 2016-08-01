package cityinfo.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cityinfo.models.City;
import cityinfo.utils.CsvFileWriter;
import cityinfo.utils.HttpServiceUnavailableRetry;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Created by shubham.singhal on 31/07/16.
 */
public class CityInfoController {
    private static final Logger log = LoggerFactory.getLogger(CityInfoController.class);

    private static final String CITY_INFO_URL  = "http://api.goeuro.com/api/v2/position/suggest/en/";

    public static void writeCityInfoToCsv(String cityName) {
        List<City> cities = getCityInfos(cityName);
        String fileHeaders = "_id, name, type, latitude, longitude";
        CsvFileWriter.writeCsvFile("/tmp/" + cityName + "_info.csv", cities, fileHeaders);
    }

    private static List<City> getCityInfos(String cityName) {

        HttpClientBuilder httpBuilder = HttpClientBuilder.create().setServiceUnavailableRetryStrategy(
                new HttpServiceUnavailableRetry());
        HttpClient httpClient = httpBuilder.build();

        List<City> cityInfos = new ArrayList<>();
        try {
            HttpGet httpGetRequest = new HttpGet(CITY_INFO_URL + cityName);
            HttpResponse httpResponse = httpClient.execute(httpGetRequest);
            HttpEntity entity = httpResponse.getEntity();
            log.info("HTTP GET Request for CityInfo status code: " + httpResponse.getStatusLine().getStatusCode());
            if (entity != null) {
                String jsonString = EntityUtils.toString(entity);
                log.info("HTTP GET Request for CityInfo Json Response: " + jsonString);
                Gson gson = new GsonBuilder().create();
                City[] cityInfosResponse = gson.fromJson(jsonString, City[].class);
                cityInfos = Arrays.asList(cityInfosResponse);
            }
        } catch (Exception e) {
            log.error("Error in fetching the city Location from api " +
                    CITY_INFO_URL, e.getMessage());
        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpClient.getConnectionManager().shutdown();
        }
        return cityInfos;
    }
}
