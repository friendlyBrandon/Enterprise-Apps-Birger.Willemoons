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

            // LOCATIONS
            Location l1 = new Location();
            l1.setName("Gemeenschapscentrum Anderlecht");
            l1.setAddress("Bergensesteenweg 100");
            l1.setCapacity(150);

            Location l2 = new Location();
            l2.setName("Campus Kaai");
            l2.setAddress("Nijverheidskaai 170");
            l2.setCapacity(300);

            Location l3 = new Location();
            l3.setName("Wijkhuis Aumale");
            l3.setAddress("Aumalestraat 28");
            l3.setCapacity(90);

            locationRepo.save(l1);
            locationRepo.save(l2);
            locationRepo.save(l3);


            Event e1 = new Event();
            e1.setTitle("Gratis Soep & Brood Namiddag");
            e1.setOrganisation("NGO Anderlecht");
            e1.setDescription("Warme soep, brood en een babbel voor iedereen in de buurt.");
            e1.setContactEmail("info@ngo-anderlecht.be");
            e1.setEventTime(LocalDateTime.now().plusDays(2).withHour(12).withMinute(0));
            e1.setLocation(l1);

            Event e2 = new Event();
            e2.setTitle("Tweedehands Kledingruil");
            e2.setOrganisation("Kringloop+ Brussel");
            e2.setDescription("Breng kleding mee en ruil ze voor iets nieuws (zonder geld).");
            e2.setContactEmail("swap@kringloop.be");
            e2.setEventTime(LocalDateTime.now().plusDays(5).withHour(14).withMinute(0));
            e2.setLocation(l2);

            Event e3 = new Event();
            e3.setTitle("Digitale Stress? Hulp voor Smartphone & Itsme");
            e3.setOrganisation("Digital Inclusion Team");
            e3.setDescription("We helpen je met Itsme, e-mails en online administratie.");
            e3.setContactEmail("help@digital.be");
            e3.setEventTime(LocalDateTime.now().plusDays(6).withHour(10).withMinute(30));
            e3.setLocation(l1);

            Event e4 = new Event();
            e4.setTitle("Kindernamiddag: Spel & Creativiteit");
            e4.setOrganisation("Jeugdwerking Anderlecht");
            e4.setDescription("Knutselen, spelen en tekenen voor kinderen van 6 tot 12 jaar.");
            e4.setContactEmail("jeugd@ngo-anderlecht.be");
            e4.setEventTime(LocalDateTime.now().plusDays(7).withHour(13).withMinute(0));
            e4.setLocation(l3);

            Event e5 = new Event();
            e5.setTitle("Buurt BBQ - Bring Your Own Sauce");
            e5.setOrganisation("Wijkcomité Aumale");
            e5.setDescription("Iedereen brengt iets mee. Grill, muziek en goede sfeer voorzien.");
            e5.setContactEmail("buurt@aumale.be");
            e5.setEventTime(LocalDateTime.now().plusDays(9).withHour(17).withMinute(30));
            e5.setLocation(l3);

            Event e6 = new Event();
            e6.setTitle("CV Workshop & Sollicitatietips");
            e6.setOrganisation("Actiris Partner Network");
            e6.setDescription("Maak je cv sterker en oefen echte sollicitatiegesprekken.");
            e6.setContactEmail("jobs@actiris.be");
            e6.setEventTime(LocalDateTime.now().plusDays(11).withHour(9).withMinute(0));
            e6.setLocation(l2);

            Event e7 = new Event();
            e7.setTitle("Taalcafé Nederlands & Koffie");
            e7.setOrganisation("Integratie Brussel");
            e7.setDescription("Praat Nederlands in een ontspannen sfeer met koffie en koekjes.");
            e7.setContactEmail("taal@brussel.be");
            e7.setEventTime(LocalDateTime.now().plusDays(12).withHour(18).withMinute(0));
            e7.setLocation(l1);

            Event e8 = new Event();
            e8.setTitle("Repair Café: Kapotte spullen fixen");
            e8.setOrganisation("Repair Brussels");
            e8.setDescription("Breng je kapotte toestellen mee en probeer ze samen te herstellen.");
            e8.setContactEmail("repair@brussels.be");
            e8.setEventTime(LocalDateTime.now().plusDays(14).withHour(14).withMinute(0));
            e8.setLocation(l2);

            Event e9 = new Event();
            e9.setTitle("Open Micro Avond: Muziek & Poëzie");
            e9.setOrganisation("Cultuurhuis Anderlecht");
            e9.setDescription("Iedereen mag optreden: muziek, poëzie, comedy of verhalen.");
            e9.setContactEmail("cultuur@anderlecht.be");
            e9.setEventTime(LocalDateTime.now().plusDays(16).withHour(19).withMinute(30));
            e9.setLocation(l1);

            Event e10 = new Event();
            e10.setTitle("Vrijwilligers Bedankingsdag");
            e10.setOrganisation("NGO Anderlecht");
            e10.setDescription("Eten, muziek en dank aan alle vrijwilligers van het jaar.");
            e10.setContactEmail("vrijwilligers@ngo-anderlecht.be");
            e10.setEventTime(LocalDateTime.now().plusDays(20).withHour(18).withMinute(0));
            e10.setLocation(l3);

            eventRepo.save(e1);
            eventRepo.save(e2);
            eventRepo.save(e3);
            eventRepo.save(e4);
            eventRepo.save(e5);
            eventRepo.save(e6);
            eventRepo.save(e7);
            eventRepo.save(e8);
            eventRepo.save(e9);
            eventRepo.save(e10);
        };
    }
}