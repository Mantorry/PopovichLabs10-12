package com.example.posts.Service;

import com.example.posts.Models.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
    public Employee get(String emp_id, String post_id){
        Employee employee= new Employee();
        employee.setEmp_id(emp_id);
        employee.setPost_id(post_id);
        employee.setFio("Попов Валерий Юрьевич");
        employee.setBirth_date("12.06.1997");
        employee.setPhone("89514591817");
        employee.setEmail("popovv@gmail.com");
        return employee;
    }
    public String create(Employee employee, String post_id){
        String responseMessage = null;
        if(employee != null) {
            employee.setPost_id(post_id);
            responseMessage = String.format("Добавлен сотрудник: %s", employee.toString());
        }
        return responseMessage;
    }
    public String update(Employee employee, String post_id){
        String responseMessage = null;
        if (employee != null) {
            employee.setPost_id(post_id);
            responseMessage = String.format("Изменен сотрудник: %s", employee.toString());
        }
        return responseMessage;
    }
    public String delete(String employee_id, String post_id){
        String responseMessage = null;
        responseMessage = String.format("Удаление сотрудника с id %s с должностью %s завершено", employee_id, post_id);
        return responseMessage;
    }
}
