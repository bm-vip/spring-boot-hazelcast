package behrooz.hazelcast.springboothazelcast.service.iml;

import behrooz.hazelcast.springboothazelcast.entity.EmployeeEntity;
import behrooz.hazelcast.springboothazelcast.exception.NotFoundException;
import behrooz.hazelcast.springboothazelcast.repository.EmployeeRepository;
import behrooz.hazelcast.springboothazelcast.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@CacheConfig(cacheNames = "employee")
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;
//    private final HazelcastInstance hazelcastInstance;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    @CacheEvict(value = "employee",allEntries = true)
    public EmployeeEntity saveEmployee(EmployeeEntity employee) {
        log.info("call saveEmployee {}", employee);
        if (employee.getId() != null && employee.getId() > 0L) {
            var entity = repository.findById(employee.getId()).orElseThrow(() -> new NotFoundException("employee not found by id " + employee.getId()));
            entity.setName(employee.getName());
            return repository.save(entity);
        }
        return repository.save(employee);
    }

    @Override
    @CacheEvict(value = "employee", allEntries = true)
    public void deleteEmployee(Long id) {
        log.info("call deleteEmployee {}", id);
        repository.deleteById(id);
    }

    @Override
    @Transactional
    @Cacheable(value = "employee")
    public EmployeeEntity getEmployeeById(Long id) {
        log.info("call getEmployeeById {}", id);
        return repository.findById(id).orElseThrow(()-> new NotFoundException("employee not found by id " + id));
    }

    @Override
    @Cacheable(value = "employee")
    public Iterable<EmployeeEntity> getAllEmployees() {
        log.info("call getAllEmployees");
        return repository.findAll();
    }

    @Override
    @Transactional
    @CacheEvict(value = "employee", allEntries = true)
    public Iterable<EmployeeEntity> saveEmployees(List<EmployeeEntity> employees) {
        log.info("call saveEmployees {}", employees);
        return repository.saveAll(employees);
    }
}
