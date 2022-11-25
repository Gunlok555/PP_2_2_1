package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");

      Car car1 = new Car("ВАЗ", 2101);
      Car car2 = new Car("ВАЗ", 2102);
      Car car3 = new Car("ВАЗ", 2103);
      Car car4 = new Car("ВАЗ", 2104);

      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);
      user4.setCar(car4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      System.out.println();
      System.out.println("////////////проверка привязки машины/////////////");
      System.out.println(user1.getCar());
      System.out.println("////////////проверка пройдена/////////////");
      System.out.println();
      System.out.println("////////////найди водилу по машине/////////////");
      System.out.println((carService.getUserByCar("ВАЗ",2103)));
      System.out.println("////////////попался/////////////");
      System.out.println();

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      context.close();
   }
}
