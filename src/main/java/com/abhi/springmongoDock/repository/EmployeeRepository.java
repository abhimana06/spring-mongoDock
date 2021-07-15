package com.abhi.springmongoDock.repository;

import com.abhi.springmongoDock.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, Integer> {
}
