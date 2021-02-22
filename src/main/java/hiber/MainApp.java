package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User testUser1 = new User("Вася", "Пупкин", "вася@kremlin.ру");
        testUser1.setCar(new Car("ОченьКрутаяМашина", 11));
        userService.add(testUser1);

        User testUser2 = new User("Joe", "Doe", "joedoe@gmail.com");
        testUser2.setCar(new Car("VeryCoolCar", 22));
        userService.add(testUser2);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar().getModel() + " " + user.getCar().getSeries());
            System.out.println("------------------");
        }

        User userToSearch = userService.getUserForCarModelAndSeries("VeryCoolCar", 22);
        System.out.println("Searching: ZzzZzZZzZzZzzZzZZzZzZzzZzZZzZzZzzZzZZzZz... ");
        System.out.println("Id = " + userToSearch.getId());
        System.out.println("First Name = " + userToSearch.getFirstName());
        System.out.println("Last Name = " + userToSearch.getLastName());
        System.out.println("Email = " + userToSearch.getEmail());
        System.out.println("Car = " + userToSearch.getCar().getModel() + " " + userToSearch.getCar().getSeries());

        context.close();
    }
}
