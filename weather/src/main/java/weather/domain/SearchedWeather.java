package weather.domain;

import lombok.Data;
import weather.infra.AbstractEvent;

@Data
public class SearchedWeather extends AbstractEvent {

    private Long id;
    private String date;
    private String location;
    private Double degree;
    private Double precipitation;
    private Double humidity;
    private Double wind;

    public SearchedWeather(Weather aggregate) {
        super(aggregate);
    }

    public SearchedWeather() {
        super();
    }
    // keep

}
