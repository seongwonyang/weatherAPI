package weather.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "weathers", path = "weathers")
public interface WeatherRepository
    extends JpaRepository<Weather, Long> {
        List<Weather> findByLocation(String location);
    }
