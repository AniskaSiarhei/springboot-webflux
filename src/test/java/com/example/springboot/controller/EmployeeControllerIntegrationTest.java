package com.example.springboot.controller;

import com.example.springboot.dto.EmployeeDto;
import com.example.springboot.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Collections;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerIntegrationTest {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private WebTestClient webClient;

    @Test
    public void testSaveEmployee() {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("Serge");
        employeeDto.setLastName("Cina");
        employeeDto.setEmail("serg.cina@gmail.com");

        webClient.post().uri("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(employeeDto), EmployeeDto.class)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.firstName").isEqualTo(employeeDto.getFirstName())
                .jsonPath("$.lastName").isEqualTo(employeeDto.getLastName())
                .jsonPath("$.email").isEqualTo(employeeDto.getEmail());
    }

    @Test
    public void testGetSingleEmployee() {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("Serge");
        employeeDto.setLastName("Cina");
        employeeDto.setEmail("serg.cina@gmail.com");

        EmployeeDto saveEmployee = employeeService.saveEmployee(employeeDto).block();

        webClient.get().uri("/api/employees/{id}", Collections.singletonMap("id", saveEmployee.getId()))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.id").isEqualTo(saveEmployee.getId())
                .jsonPath("$.firstName").isEqualTo(saveEmployee.getFirstName())
                .jsonPath("$.lastName").isEqualTo(saveEmployee.getLastName())
                .jsonPath("$.email").isEqualTo(saveEmployee.getEmail());
    }

    @Test
    public void testGetAllEmployees() {

        EmployeeDto employeeDto1 = new EmployeeDto();
        employeeDto1.setFirstName("Serge");
        employeeDto1.setLastName("Cina");
        employeeDto1.setEmail("serg.cina@gmail.com");

        employeeService.saveEmployee(employeeDto1).block();

        EmployeeDto employeeDto2 = new EmployeeDto();
        employeeDto2.setFirstName("Serge");
        employeeDto2.setLastName("Cina");
        employeeDto2.setEmail("serg.cina@gmail.com");

        employeeService.saveEmployee(employeeDto2).block();

        webClient.get().uri("/api/employees")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(System.out::println);

    }
}