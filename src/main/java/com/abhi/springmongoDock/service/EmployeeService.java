package com.abhi.springmongoDock.service;

import com.abhi.springmongoDock.model.Employee;
import com.abhi.springmongoDock.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRepository;


    public List<Employee> getAllEmployees() {
        return empRepository.findAll();
    }

    public Employee findEmployee(int id) {
        return validateEmployee(id);
    }

    public String addEmployee(Employee emp) {
        try{
            empRepository.save(emp);
            return "Employee saved successfully ";
        }catch (Exception ex){
            throw new RuntimeException("Error while adding Employee");
        }
    }

    public String updateEmployee(int id,Employee emp) {
        Employee employee = validateEmployee(id);
        employee.setName(emp.getName());
        employee.setDepartement(emp.getDepartement());
        empRepository.save(employee);
        return "Employee updated successfully ";
    }

    public void deleteEmployee(int id) {
        validateEmployee(id);
        empRepository.deleteById(id);
    }

    private Employee validateEmployee(int id){
        return empRepository.findById(id).orElseThrow(() -> new RuntimeException("Bad Request EmpId:"+id+" not found"));
    }
}
