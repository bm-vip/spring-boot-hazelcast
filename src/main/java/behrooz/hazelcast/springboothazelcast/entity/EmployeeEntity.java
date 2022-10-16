package behrooz.hazelcast.springboothazelcast.entity;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "tbl_employee")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class EmployeeEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_employee", sequenceName = "seq_employee", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_employee")
    private Long id;
    private String name;
}
