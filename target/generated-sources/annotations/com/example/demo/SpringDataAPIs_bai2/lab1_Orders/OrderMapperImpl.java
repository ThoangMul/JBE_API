package com.example.demo.SpringDataAPIs_bai2.Order;

import com.example.demo.SpringDataAPIs_bai1.lab1_Employees.Employee;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-10T23:38:21+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDTO toDTO(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setEmployeeId( orderEmployeeId( order ) );
        if ( order.getId() != null ) {
            orderDTO.setId( order.getId() );
        }
        orderDTO.setOrderDate( order.getOrderDate() );

        return orderDTO;
    }

    @Override
    public Order toEntity(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( orderDTO.getId() );
        order.setOrderDate( orderDTO.getOrderDate() );

        return order;
    }

    private int orderEmployeeId(Order order) {
        if ( order == null ) {
            return 0;
        }
        Employee employee = order.getEmployee();
        if ( employee == null ) {
            return 0;
        }
        int id = employee.getId();
        return id;
    }
}
