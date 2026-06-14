package Enterprise_Application.demo.config;

import Enterprise_Application.demo.model.Event;
import Enterprise_Application.demo.model.Location;
import Enterprise_Application.demo.repository.EventRepo;
import Enterprise_Application.demo.repository.LocationRepo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedData(
            LocationRepo locationRepo,
            EventRepo eventRepo) {

        return args -> {

            Location l1 = new Location();
            l1.setName("Gemeenschapscentrum Anderlecht");
            l1.setAddress("Bergensesteenweg 100");
            l1.setCapacity(150);

            locationRepo.save(l1);

            Event e1 = new Event();
            e1.setTitle("Voedselinzameling");
            e1.setOrganisation("NGO Anderlecht");
            e1.setDescription("Inzameling van voedsel.");
            e1.setContactEmail("info@ngo.be");
            e1.setEventTime(LocalDateTime.now());
            e1.setLocation(l1);

            eventRepo.save(e1);
        };
    }
}