package cityinfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import cityinfo.controllers.CityInfoController;

/**
 * Created by shubham.singhal on 31/07/16.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        log.info("Args passed: " + args.toString());
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if(args.length > 0) {
            CityInfoController.writeCityInfoToCsv(args[0]);
        } else {
            log.error("City Name is not passed");
        }
    }
}