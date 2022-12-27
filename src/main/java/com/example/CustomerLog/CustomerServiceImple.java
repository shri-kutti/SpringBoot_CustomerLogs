package com.example.CustomerLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class CustomerServiceImple implements CustomerService{

    @Autowired
    private CustomerRepository customerRepo;

    @Override
    public String getCheckIn(String name) {
        LocalDate d=  LocalDate.now();
        LocalTime t = LocalTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String formattedDate = d.format(dateTimeFormatter);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        String formattedTime = t.format(timeFormatter);
        String idn = name.concat(formattedTime);
        String logType="IN";
        Customer cus1 = new Customer(idn,name,logType,formattedDate,formattedTime);
        customerRepo.save(cus1);
        return "In "+formattedTime+" "+formattedDate+" "+idn;

    }

    @Override
    public String getCheckOut(String name) {
        LocalDate d=  LocalDate.now();
        LocalTime t = LocalTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String formattedDate = d.format(dateTimeFormatter);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        String formattedTime = t.format(timeFormatter);
        String idn = name.concat(formattedTime);
        String logType="OUT";
        Customer cus2 = new Customer(idn,name,logType,formattedDate,formattedTime);
        customerRepo.save(cus2);
        return "Out "+ formattedTime+" "+formattedDate+" "+idn;
    }

    @Override
    public List<Customer> getByDate(String date) {
        return customerRepo.findByDate(date);
    }

    @Override
    public List<Customer> getAllLog() {
        return customerRepo.findAll();
    }
}
