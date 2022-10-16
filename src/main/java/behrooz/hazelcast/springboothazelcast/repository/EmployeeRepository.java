package behrooz.hazelcast.springboothazelcast.repository;

import behrooz.hazelcast.springboothazelcast.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity,Long> {
}
