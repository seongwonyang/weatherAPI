package weather.domain;

import javax.persistence.*;
import lombok.Data;
import weather.WeatherApplication;

@Entity
@Table(name = "weather")
@Data
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String date;

    private String location;

    private Double degree;

    private Double precipitation;

    private Double humidity;

    private Double wind;

    public static WeatherRepository repository() {
        WeatherRepository weatherRepository = WeatherApplication.applicationContext.getBean(
            WeatherRepository.class
        );
        return weatherRepository;
    }
}
