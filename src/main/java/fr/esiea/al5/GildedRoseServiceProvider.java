package fr.esiea.al5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled; 
import org.springframework.web.bind.annotation.RestController;

@RestController //Rather not use SOAP Controller, could slip on it
@SpringBootApplication
public class GildedRoseServiceProvider {

    private GildedRose gildedRose = new GildedRose();

    /**
     * Constructor to run the SpringApplication
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(GildedRoseServiceProvider.class, args);
    }

    /**
     * Every 15 minutes : updatesQualityOfTheItems
     */
    @Scheduled(fixedRate = 900000) //It's in milliseconds and according to windows 15 minute = 900 000ms
    public void updateGildedRose() {
        gildedRose.updateQuality();
    }

}
