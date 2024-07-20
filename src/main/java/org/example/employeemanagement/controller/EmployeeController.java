package org.example.employeemanagement.controller;

import org.example.employeemanagement.entity.Employee;
import org.example.employeemanagement.service.EmployeeService;
import org.example.employeemanagement.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ProvinceService provinceService;
    @GetMapping(value = "/employees")
    public String getAllEmployee(Model model) {
        List<Employee> employeeList = employeeService.getAllEmployee();
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("provinceList", provinceService.getAllProvince());
        return "employee-list";
    }
    @GetMapping("/employees/new")
    public String showCreateForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("provinceList", provinceService.getAllProvince());
        return "create-employee";
    }
    @PostMapping("/employees")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }
    @GetMapping("/employees/delete/{id}")
    public String deleteEmployeeByID(@PathVariable int id) {
        employeeService.deleteEmployeeByID(id);
        return "redirect:/employees";
    }
    @GetMapping("/employees/findbyId")
    public String getEmployeeByID(@RequestParam(name = "id") int id, Model model) {
        model.addAttribute("employeeList", employeeService.getEmployeeByID(id));
        return "search-result";
    }
    @GetMapping("/employees/findbyname")
    public String findByName(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("employeeList", employeeService.findByName(name));
        return "search-result";
    }
    @GetMapping(value = "/employees/findbyposition")
    public String findbyposition(@RequestParam String position, Model model) {
        model.addAttribute("employeeList", employeeService.findByPosition(position));
        return "search-result";
    }
}