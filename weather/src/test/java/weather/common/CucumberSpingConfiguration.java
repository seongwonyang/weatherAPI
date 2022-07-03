package weather.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import weather.WeatherApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { WeatherApplication.class })
public class CucumberSpingConfiguration {}
