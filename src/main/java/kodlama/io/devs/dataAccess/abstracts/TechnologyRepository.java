package kodlama.io.devs.dataAccess.abstracts;

import kodlama.io.devs.entities.concretes.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology,Integer> {
    Technology findById(int id);
}
