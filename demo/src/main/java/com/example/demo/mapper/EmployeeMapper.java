package com.example.demo.mapper;

import com.example.demo.entity.Employee;
import com.example.demo.dto.EmployeeRequest;
import com.example.demo.dto.EmployeeResponse;

public class EmployeeMapper {

    // từ EmployeeRequest (client gửi lên) sang Entity
    public static Employee toEntity(EmployeeRequest request) {
        if (request == null) {
            return null;
        }
        Employee employee = new Employee();

        employee.setLastName(request.getLastName());
        employee.setFirstName(request.getFirstName());
        employee.setBirthDate(request.getBirthDate());
        employee.setSupervisorId(request.getSupervisorId());

        return employee;
    }

    // từ Entity sang EmployeeResponse (trả về cho client)
    public static EmployeeResponse toDTO(Employee employee) {
        if (employee == null) {
            return null;
        }
        EmployeeResponse dto = new EmployeeResponse();

        dto.setLastName(employee.getLastName());
        dto.setFirstName(employee.getFirstName());
        dto.setBirthDate(employee.getBirthDate());
        dto.setSupervisorId(employee.getSupervisorId());

        return dto;
    }
}