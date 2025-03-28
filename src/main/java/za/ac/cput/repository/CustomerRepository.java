package za.ac.cput.repository;

import za.ac.cput.domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {

    private static ICustomerRepository repository = null;
    private List<Customer> customerList;

    private CustomerRepository() {
        customerList = new ArrayList<Customer>();
        System.out.println("Repo Created Successfully");
    }

    public static ICustomerRepository getRepository() {
        if (repository == null) {
            repository = new CustomerRepository();
        }
        return repository;
    }


    @Override
    public Customer addCustomer(Customer customer) {
        boolean success = customerList.add(customer);
        if (success) {
            return customer;
        }
        return null;
    }

    @Override
    public Customer read(String customerName) {
        for (Customer e : customerList) {
            if (e.getCustomerName().equalsIgnoreCase(customerName))
                return e;
        }
        return null;
    }

    @Override
    public Customer update(Customer customer) {
        String customerName = customer.getCustomerName();
        Customer customerOld = read(customerName);
        if (customerOld == null)
            return null;

        boolean success = delete(customerName);
        if (success) {
            if (customerList.add(customer))
                return customer;
        }
        return null;
    }

    @Override
    public boolean delete(String customerName) {
        Customer customerToDelete = read(customerName);
        if (customerToDelete == null)
            return false;
        return (customerList.remove(customerToDelete));
    }

    @Override
    public List<Customer> getAll() {
        return customerList;
    }
}
