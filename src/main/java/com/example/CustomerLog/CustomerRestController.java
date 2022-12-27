package com.example.CustomerLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @PutMapping("/checkIn")
    public ResponseEntity<String> checkIn(@RequestParam(name= "name") String name)
    {
        String status = customerService.getCheckIn(name);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PutMapping("/checkOut")
    public ResponseEntity<String> checkOut(@RequestParam(name= "name") String name)
    {
        String status = customerService.getCheckOut(name);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/getLog")
    public ResponseEntity<List<Customer>> getDate (@RequestParam(name = "date") String date){
        return new ResponseEntity<>(customerService.getByDate(date),HttpStatus.OK);
    }

    @GetMapping("/getAllLog")
    public ResponseEntity<List<Customer>> getAll()
    {
        List<Customer> status = customerService.getAllLog();
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
