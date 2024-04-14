package com.example.posts.Controller;

import com.example.posts.Models.Employee;
import com.example.posts.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "post/{post_id}/emp")
public class EmpController {
    @Autowired
    private EmpService employeeService;

    @RequestMapping(value = "/{emp_id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> get(@PathVariable("post_id") String post_id,
                                        @PathVariable("emp_id") String emp_id) {
        Employee employee = employeeService.get(post_id, emp_id);
        employee.add(
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmpController.class)
                        .get(post_id, employee.getEmp_id())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmpController.class)
                        .create(post_id, employee)).withRel("Create"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmpController.class)
                        .update(post_id, employee)).withRel("Update"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmpController.class)
                        .delete(post_id, employee.getEmp_id())).withRel("Delete"));
        return ResponseEntity.ok(employee);
    }

    @PutMapping
    public ResponseEntity<String> update(
            @PathVariable("post_id") String post_id,
            @RequestBody Employee request) {
        return ResponseEntity.ok(employeeService.update(request,post_id));
    }

    @PostMapping
    public ResponseEntity<String> create(
            @PathVariable("post_id") String post_id,
            @RequestBody Employee request) {
        return ResponseEntity.ok(employeeService.create(request,post_id));
    }

    @DeleteMapping(value= "/{emp_id}")
    public ResponseEntity<String> delete(
            @PathVariable("post_id") String post_id,
            @PathVariable("emp_id") String emp_id) {
        return ResponseEntity.ok(employeeService.delete(emp_id,post_id));
    }
}
