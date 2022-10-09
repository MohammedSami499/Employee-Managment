package com.samicodeluver.employee.controller;

import com.samicodeluver.employee.entity.Employee;
import com.samicodeluver.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String index(Model model){

        return findPaginated(1 , model, "firstName" , "ASC" );

    }

    @GetMapping("/addEmployee")
    public String addEmployee(Model model){

        Employee employee = new Employee();
        model.addAttribute("employee" , employee);

        return "add_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/employeeToBeUpdated/{id}")
    public String employeeToUpdate(@PathVariable("id") Long id , Model model){

        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee" , employee );

        return "update_employee";
    }

//    @PostMapping("/saveUpdatedEmployee")
//    public String updateEmployee(@ModelAttribute("employee") Employee employee){
//        employeeService.updateEmployee(employee);
//
//        return "update_employee";
//    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee( @PathVariable("id") Long id){

        employeeService.deleteEmployee(id);

        return "redirect:/";
    }


    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable("pageNo") int pageNo ,
                                Model model,
                                @RequestParam("sortField") String sortField ,
                                @RequestParam("sortDirection")  String sortDirection
                                ){
        int pageSize = 5;

        Page<Employee> page = employeeService.findPaginated(pageNo , pageSize , sortField ,sortDirection);
        List<Employee> employeeList = page.getContent( );

        model.addAttribute("totalEmployee" , employeeList);
        model.addAttribute("currentPage" , pageNo);
        model.addAttribute("totalPages" , page.getTotalPages());
        model.addAttribute("totalElements" , page.getTotalElements());

        model.addAttribute("sortField" , sortField);
        model.addAttribute("sortDir" , sortDirection);
        model.addAttribute("reverseSortDir" , sortDirection.equals("ASC")? "DESC" : "ASC");

        return "index";

    }

}
