package com.example.demo.service;

import com.example.demo.SpringDataAPIs_bai1.lab1_Employees.EmployeeRequest;
import com.example.demo.SpringDataAPIs_bai1.lab1_Employees.EmployeeResponse;
import com.example.demo.SpringDataAPIs_bai1.lab1_Employees.Employee;
import com.example.demo.exception.NotFoundException;
import com.example.demo.SpringDataAPIs_bai1.lab1_Employees.EmployeeMapper;
import com.example.demo.SpringDataAPIs_bai1.lab1_Employees.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeResponse> getAllEmployees() {

        return employeeRepository.findAll().stream()
                .map(EmployeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Page<EmployeeResponse> getAllEmployees(Pageable pageable) {

        return employeeRepository.findAll(pageable)
                .map(EmployeeMapper::toDTO);
    }

    public EmployeeResponse getEmployeeById(int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->new NotFoundException(id));

        return EmployeeMapper.toDTO(employee);
    }

    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        Employee employee = EmployeeMapper.toEntity(employeeRequest);
        Employee createEmployee = employeeRepository.save(employee);

        return EmployeeMapper.toDTO(createEmployee);
    }

    public EmployeeResponse updateEmployee(int id, EmployeeRequest employeeRequest) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(id));

        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setBirthDate(employeeRequest.getBirthDate());
        employee.setSupervisorId(employeeRequest.getSupervisorId());

        Employee updateEmployee = employeeRepository.save(employee);
        return EmployeeMapper.toDTO(updateEmployee);
    }

    public void deleteEmployee(int id) {
        if (!employeeRepository.existsById(id)) {
            throw new NotFoundException(id);
        }

        employeeRepository.deleteById(id);
    }
}
