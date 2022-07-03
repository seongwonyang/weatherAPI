package weather.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import weather.domain.*;

@Component
public class WeatherHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Weather>> {

    @Override
    public EntityModel<Weather> process(EntityModel<Weather> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/search")
                .withRel("search")
        );

        return model;
    }
}
