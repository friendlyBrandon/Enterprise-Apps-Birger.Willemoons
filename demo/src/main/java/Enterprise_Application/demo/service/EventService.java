@Service
public class EventService {

    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public List<Event> getLatestEvents() {
        return repository.findAll(
                PageRequest.of(
                        0,
                        10,
                        Sort.by("eventTime").descending()
                )
        ).getContent();
    }

    public Event getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Event save(Event event) {
        return repository.save(event);
    }
}