package hiber.service;

import hiber.model.User;
import java.util.List;

public interface UserService {
    void add(User user);

    User getUserForCarModelAndSeries(String model, int series);

    List<User> listUsers();
}
