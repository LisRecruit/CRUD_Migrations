package org.example.service;


import org.example.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


public class ClientService {
    private final SessionFactory sessionFactory;

    public ClientService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public long create(String name) {
        if (!validateName(name)){
            throw new IllegalArgumentException("Wrong name format");
        }
        validateName(name);
        Client client = new Client();
        client.setName(name);
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
            return client.getId();
        }
    }

    public String getById(long id) {
        try (Session session = sessionFactory.openSession()) {
            Client client = session.get(Client.class, id);
            if (client == null) {
                throw new IllegalArgumentException("Client with this ID not found");
            }
            return client != null ? client.getName() : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setName(long id, String name) {
        if (!validateName(name)){
            throw new IllegalArgumentException("Wrong name format");
        }
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            if (client == null) {
                throw new IllegalArgumentException ("Client not found");
            } else {
                client.setName(name);
                session.merge(client);
                transaction.commit();
            }
        }

    }
    public void deleteById (long id){
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            if (client == null) {
                throw new IllegalArgumentException ("Client with this ID not found");
            } else {
                session.remove(client);
                transaction.commit();
            }
        }
    }
    public List<Client> listAll(){
        List<Client> result = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            result = session.createQuery("FROM Client", Client.class).list();
        }
        return result;
    }

    private boolean validateName(String name) {
        if (name == null || name.length() < 2 || name.length() > 1000) {
            return false;
        }
        return true;
    }



}
