package com.example.demo.SpringDataAPIs_bai1.lab1_Employees;

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