package cityinfo.utils;

import org.apache.http.client.ServiceUnavailableRetryStrategy;
import org.apache.http.protocol.HttpContext;
import org.apache.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by shubham.singhal on 01/08/16.
 */
public class HttpServiceUnavailableRetry implements ServiceUnavailableRetryStrategy {
    private static final Logger log = LoggerFactory.getLogger(HttpServiceUnavailableRetry.class);

    @Override
    public boolean retryRequest(
            final HttpResponse response, final int executionCount, final HttpContext context)
    {
        boolean shouldRetry = false;
        int statusCode = response.getStatusLine().getStatusCode();
        if ((statusCode == 302 || statusCode == 502 || statusCode == 503 || statusCode == 504)
                && executionCount < 2) {
            log.error( "Retrying request due to 302 redirect response" );
            shouldRetry = true;
        }
        return shouldRetry;
    }

    @Override
    public long getRetryInterval() {
        return 50;
    }
}
