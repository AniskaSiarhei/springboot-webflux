package com.example.springboot.controller;

import com.example.springboot.dto.EmployeeDto;
import com.example.springboot.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // build Reactive Save Employee REST API
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.saveEmployee(employeeDto);
    }

    // build Reactive Get Employee REST API
    @GetMapping("/{id}")
    public Mono<EmployeeDto> getEmployeeById(@PathVariable("id") String employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    // build Reactive Get All Employees REST API
    @GetMapping
    public Flux<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // build Reactive Update Employee Rest API
    @PutMapping("/{id}")
    public Mono<EmployeeDto> updateEmployee(@PathVariable("id") String employeeId,
                                            @RequestBody EmployeeDto employeeDto) {

        return employeeService.updateEmployee(employeeId, employeeDto);
    }

    // build Reactive Delete Employee REST API
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteEmployeeById(@PathVariable("id") String employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }

}
