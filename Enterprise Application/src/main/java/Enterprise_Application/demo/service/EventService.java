package Enterprise_Application.demo.service;

import Enterprise_Application.demo.model.Event;
import Enterprise_Application.demo.repository.EventRepo;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventService {

    private final EventRepo repository;

    public EventService(EventRepo repository) {
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