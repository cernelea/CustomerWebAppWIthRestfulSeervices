package com.cernelea.DAO;

import com.cernelea.entity.Customer;

import java.util.List;

public interface CustomerDAO<T> {
    List<T> getList();


    void saveCustomer(T t);


    void updateCustomer(T t);

    T getCustomer(int id);

    void deleteCustomer(int id);
}
