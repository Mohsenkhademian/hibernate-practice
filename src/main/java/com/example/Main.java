package com.example;


import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import com.example.utils.HibernateUtil;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {

/*        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        UserRepository userRepository = new UserRepository(sessionFactory);
        UserService userService = new UserService(userRepository);


        User user = new User();
        user.setUserName("mamad");
        user.setPassword("password123");
        user.setIsActive(true);


        userService.saveUser(user);

        User newUser = new User();
        newUser.setUserName("mohsen");
        newUser.setPassword("password123");
        newUser.setIsActive(true);
        userService.saveUser(newUser);


        User existingUser = userService.findUserById(newUser.getId());
        if (existingUser != null) {
            existingUser.setUserName("mohsen");
            userService.updateUser(existingUser);
        }*/

       /*
        System.out.println("All Users:");
        userService.findAllUsers().forEach(System.out::println);

        System.out.println(userService.findUserById(newUser.getId()));

        System.out.println(userService.findByUserName("mohsen"));

        System.out.println(userService.findByActiveUser(true));
*/
    }


}