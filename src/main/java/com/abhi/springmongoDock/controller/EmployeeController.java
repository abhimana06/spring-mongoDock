package com.abhi.springmongoDock.controller;


import java.util.List;
import java.util.Optional;

import com.abhi.springmongoDock.model.Employee;
import com.abhi.springmongoDock.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAllEmployees")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/getEmployee/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.findEmployee(id);
    }

    @PostMapping("/addEmployee")
    public String saveEmployee(@RequestBody Employee emp) {
        return employeeService.addEmployee(emp) + emp.getId();
    }

    @PutMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable int id ,@RequestBody Employee emp) {
        return employeeService.updateEmployee(id,emp) + id;

    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "Deleted Employee Successfully::"+id;
    }

}

