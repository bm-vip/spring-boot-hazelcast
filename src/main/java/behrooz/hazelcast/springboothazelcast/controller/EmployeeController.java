package behrooz.hazelcast.springboothazelcast.controller;

import behrooz.hazelcast.springboothazelcast.entity.EmployeeEntity;
import behrooz.hazelcast.springboothazelcast.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService employeeService) {
        this.service = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok(service.getEmployeeById(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<EmployeeEntity>> getAllEmployees(){
        return ResponseEntity.ok(service.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeEntity> saveEmployee(@RequestBody EmployeeEntity employeeEntity){
        return ResponseEntity.ok(service.saveEmployee(employeeEntity));
    }

    @PostMapping("/all")
    public ResponseEntity<Iterable<EmployeeEntity>> saveEmployees(@RequestBody List<EmployeeEntity> employeeEntityList){
        return ResponseEntity.ok(service.saveEmployees(employeeEntityList));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id){
        service.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
