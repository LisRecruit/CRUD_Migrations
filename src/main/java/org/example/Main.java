package org.example;


import org.example.service.ClientService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        System.out.println("Создан SessionFactory с URL: jdbc:h2:~/testdb");

        ClientService clientService = new ClientService(sessionFactory);

        System.out.println(clientService.getById(1));
//        System.out.println(clientService.create("AnotherClient"));
        System.out.println(clientService.getById(8));
        clientService.setName(8, "AnotherUpdate");
        System.out.println(clientService.getById(8));
        clientService.deleteById(8);
        System.out.println(clientService.listAll());


    }

}
