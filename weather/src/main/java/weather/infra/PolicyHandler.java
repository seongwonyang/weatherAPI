package weather.infra;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import weather.config.kafka.KafkaProcessor;
import weather.domain.*;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    WeatherRepository weatherRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {
        System.out.println(eventString);
    }

}
