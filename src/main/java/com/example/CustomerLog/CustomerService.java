package com.example.CustomerLog;

import java.util.List;

public interface CustomerService {
    public String getCheckIn(String name);

    public String getCheckOut(String name);

    public List<Customer> getByDate(String date);

    public List<Customer> getAllLog();
}
