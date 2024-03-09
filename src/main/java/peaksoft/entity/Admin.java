package peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "admin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_gen")
    @SequenceGenerator(name = "admin_seq",sequenceName = "admin_gen", allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
