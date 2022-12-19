package pl.coderslab.charity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.impl.RoleServiceImpl;
import pl.coderslab.charity.service.impl.UserServiceImpl;

import java.util.Locale;

@SpringBootApplication
public class CharityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CharityApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserServiceImpl userService, RoleServiceImpl roleService) { //funkcja ktora uruchamia sie podczas startu aplikacji (za kazdym razem)
        return (args) -> {

            if (roleService.findByName("ROLE_ADMIN") == null) { //patrzymy czy mamy role admin i jesli nie to ja tworzymy
                Role r = new Role();
                r.setName("ROLE_ADMIN");
                roleService.save(r);
            }
            if (roleService.findByName("ROLE_USER") == null) { //analogicznie do roli wyzej
                Role r = new Role();
                r.setName("ROLE_USER");
                roleService.save(r);
            }
//            if (userService.findByLastName("admin") == null) { //tworze admina
//
//                User user = new User();
//                user.setFirstName("Super user");
//                user.setLastName("admin");
//                user.setPassword("admin");
//                userService.saveAdmin(user);
//            }
        };
    }
}
