package com.cernelea.DAO;

import com.cernelea.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CustomerDAOImpl implements CustomerDAO<Customer> {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getList() {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> customerQuery = session.createQuery("from Customer order by lastName", Customer.class);
        List<Customer> customerList = customerQuery.getResultList();

        return customerList;
    }

    @Override
    public void saveCustomer(Customer customer) {


        Session session = sessionFactory.getCurrentSession();
        session.save(customer);


    }

    @Override
    public void updateCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.update(customer);

    }

    @Override
    public Customer getCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, id);
        return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();

        Customer customer = session.get(Customer.class, id);

        session.remove(customer);

    }


}
