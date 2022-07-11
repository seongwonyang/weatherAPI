package weather.infra.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import weather.domain.*;

@Slf4j
@RestController
@RequestMapping(value = "/weathers")
@Transactional
public class WeatherController {

    @Autowired
    WeatherRepository weatherRepository;

    @RequestMapping(
        value = "/search/{location}",
        method = RequestMethod.GET,
        produces = "application/json;charset=UTF-8"
    )
    public List<Weather> searchWeather(
        @PathVariable(value = "location") String location,
        HttpServletRequest request,
        HttpServletResponse response) {

        System.out.println("##### /weather/searchWeather  called #####");
        List<Weather> result = weatherRepository.findByLocation(location);

        log.debug("search Weather processing");
        log.info("search Weather successful");
        log.warn("search Weather have some issue");
        log.error("###### search Weather is failed! ######");
        
        return result;
    }
}
