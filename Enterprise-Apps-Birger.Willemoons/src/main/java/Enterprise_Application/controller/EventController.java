package Enterprise_Application.demo.controller;

import Enterprise_Application.demo.model.Event;
import Enterprise_Application.demo.model.Location;
import Enterprise_Application.demo.repository.LocationRepo;
import Enterprise_Application.demo.service.EventService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class EventController {

    private final EventService eventService;
    private final LocationRepo locationRepo;

    public EventController(
            EventService eventService,
            LocationRepo locationRepo) {

        this.eventService = eventService;
        this.locationRepo = locationRepo;
    }

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute(
                "events",
                eventService.getLatestEvents()
        );

        return "index";
    }

    @GetMapping("/events/{id}")
    public String details(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "event",
                eventService.getById(id)
        );

        return "details";
    }

    @GetMapping("/events/new")
    public String newEvent(Model model) {

        model.addAttribute("event", new Event());

        model.addAttribute(
                "locations",
                locationRepo.findAll()
        );

        return "new-event";
    }

    @PostMapping("/events/new")
    public String saveEvent(
            @ModelAttribute Event event,
            @RequestParam Long locationId) {

        Location location =
                locationRepo.findById(locationId)
                        .orElseThrow();

        event.setLocation(location);

        eventService.save(event);

        return "redirect:/";
    }

    @GetMapping("/about")
public String about() {
    return "about";
}
}