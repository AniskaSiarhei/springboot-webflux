package com.example.springboot.service;

import com.example.springboot.dto.EmployeeDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {

    Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto);

    Mono<EmployeeDto> getEmployeeById(String employeeId);

    Flux<EmployeeDto> getAllEmployees();

    Mono<EmployeeDto> updateEmployee(String employeeId, EmployeeDto employeeDto);

    Mono<Void> deleteEmployee(String employeeId);
}
