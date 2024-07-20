package org.example.employeemanagement.service;

import org.example.employeemanagement.entity.Employee;
import org.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    public void deleteEmployeeByID(int id){
        employeeRepository.deleteById(id);
    }
    public List<Employee> getEmployeeByID(int id) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employeeRepository.findById(id).get());
        return employeeList;
    }
    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }
    public List<Employee> findByPosition(String position) {
        return employeeRepository.findByPosition(position);
    }
}
