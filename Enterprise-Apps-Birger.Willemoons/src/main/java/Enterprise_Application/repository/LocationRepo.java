package Enterprise_Application.demo.repository;

import Enterprise_Application.demo.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LocationRepo extends JpaRepository<Location, Long> {
}