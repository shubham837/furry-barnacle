package cityinfo.utils;

import cityinfo.models.City;
import cityinfo.models.GeoPosition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvFileWriter {
    private static final Logger log = LoggerFactory.getLogger(CsvFileWriter.class);

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    public static void writeCsvFile(String fileName, List<City> cities,
                                    String fileHeaders) {

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);

            //Write the CSV file header
            fileWriter.append(fileHeaders.toString());

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            //Write a new student object list to the CSV file
            for (City city : cities) {
                fileWriter.append(String.valueOf(city.get_id()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(city.getName()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(city.getType()));
                fileWriter.append(COMMA_DELIMITER);
                GeoPosition cityGeoPosition = city.getGeo_position();
                String cityLat = null;
                String cityLon = null;
                if(cityGeoPosition != null) {
                    cityLat = String.valueOf(cityGeoPosition.getLatitude());
                    cityLon = String.valueOf(cityGeoPosition.getLongitude());
                }

                fileWriter.append(cityLat);
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(cityLon);
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            log.info("CSV file:" + fileName + " created successfully");

        } catch (Exception e) {
            log.error("Error in CsvFileWriter", e.getMessage());
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                log.error("Error while flushing/closing fileWriter", e.getMessage());
            }

        }
    }
}