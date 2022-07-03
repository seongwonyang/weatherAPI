package weather.domain;

import lombok.Data;
import weather.infra.AbstractEvent;

@Data
public class SavedWeather extends AbstractEvent {

    private Long id;
    private String date;
    private String location;
    private Double degree;
    private Double precipitation;
    private Double humidity;
    private Double wind;

    public SavedWeather(Weather aggregate) {
        super(aggregate);
    }

    public SavedWeather() {
        super();
    }
    // keep

}
