@Controller
public class EventController {

    private final EventService eventService;
    private final LocationRepository locationRepository;

    public EventController(
            EventService eventService,
            LocationRepository locationRepository) {

        this.eventService = eventService;
        this.locationRepository = locationRepository;
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
                locationRepository.findAll()
        );

        return "new-event";
    }

    @PostMapping("/events/new")
    public String saveEvent(
            @ModelAttribute Event event,
            @RequestParam Long locationId) {

        Location location =
                locationRepository.findById(locationId)
                        .orElseThrow();

        event.setLocation(location);

        eventService.save(event);

        return "redirect:/";
    }
}