package peaksoft.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.Role;
import peaksoft.enums.Specialization;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instructor_gen")
    @SequenceGenerator(name = "instructor_seq",sequenceName = "instructor_gen", allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    @Enumerated(EnumType.STRING)
    private Specialization specialization;
    @Enumerated(EnumType.STRING)
    private Role role;
    //***************************************************
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.REFRESH})
    private List<Company> companies = new ArrayList<>();
    @OneToMany(mappedBy = "instructor",cascade = {CascadeType.DETACH,CascadeType.REFRESH})
    private List<Course> courses = new ArrayList<>();
}