package peaksoft.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.Role;
import peaksoft.enums.StudyFormat;

@Entity
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_gen")
    @SequenceGenerator(name = "student_seq", sequenceName = "student_gen", allocationSize = 1)
    private Long id;
    private String fullName;
    private String lastName;
    private String phoneNumber;
    private String email;
    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormat;
    @Enumerated(EnumType.STRING)
    private Role role;
    private boolean isBlock = true;
    @ManyToOne(cascade = CascadeType.DETACH)
    private Group group;
}
