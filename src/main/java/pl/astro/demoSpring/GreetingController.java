package pl.astro.demoSpring;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/greet")
class GreetingController {
    @RequestMapping({"", "/{person}"})
    public String greetPerson(@PathVariable(name = "person", required = false) Optional<String> maybePerson) {
        String person = maybePerson.filter(StringUtils::isNotBlank).orElse("unknown person");
        return String.format("Hello %s!", person);
    }
}
