package behrooz.hazelcast.springboothazelcast.service;

import behrooz.hazelcast.springboothazelcast.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    EmployeeEntity saveEmployee(EmployeeEntity emp);
    Iterable<EmployeeEntity> saveEmployees(List<EmployeeEntity> employees);
    void deleteEmployee(Long id);
    Iterable<EmployeeEntity> getAllEmployees();
    EmployeeEntity getEmployeeById(Long empid);
}
