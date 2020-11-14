package pl.coderslab.workshop2;

import pl.coderslab.entity.*;

import java.util.Arrays;

public class Main01 {
    public static void main(String[] args) {

        UserDao userDao = new UserDao();


        //test create
//        User user1 = new User();
//        user1.setEmail("cvcb@gmail.com");
//        user1.setUserName("mmmmmm");
//        user1.setPassword("f7f77tv");
//        System.out.println(user1);
//        user1=userDao.create(user1);
//        System.out.println(user1);


        //test read - obiekt
//        System.out.println(userDao.read(5)); //ok
//        System.out.println(userDao.read(667)); //null


        //test update
//        User readUser = userDao.read(1);
//        System.out.println(readUser);
//        readUser.setUserName("XXXX");
//        readUser.setEmail("XXXX@DUPA");
//        readUser.setPassword("rtfgvbnm,,");
//        userDao.update(readUser);
//        readUser=userDao.read(1);
//        System.out.println(readUser);


        //test delete
//        userDao.delete(2);


        //test readAll
//        System.out.println(Arrays.toString(userDao.findAll()));

    }
}
