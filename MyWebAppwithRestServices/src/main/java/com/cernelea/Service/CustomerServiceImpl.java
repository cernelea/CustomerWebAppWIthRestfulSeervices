package com.cernelea.Service;

import com.cernelea.DAO.CustomerDAO;
import com.cernelea.DAO.CustomerDAOImpl;
import com.cernelea.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAOImpl customerDAO;


    @Override
    @Transactional
    public List<Customer> getCustomerList() {
        return customerDAO.getList();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public void updateCustomer(Customer customer) {
        customerDAO.updateCustomer(customer);


    }

    @Override
    @Transactional
    public Customer getCustomer(int id) {
        return customerDAO.getCustomer(id);
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {

        customerDAO.deleteCustomer(id);


    }
}
