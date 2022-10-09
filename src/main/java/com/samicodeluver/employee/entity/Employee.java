package com.samicodeluver.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table( name = "employees" ,
        uniqueConstraints = @UniqueConstraint(name = "uniEmail"  ,
                columnNames = "email"
        ))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {


    @Id
    @SequenceGenerator(name = "seq" , sequenceName = "sequence" , allocationSize = 1)
    @GeneratedValue(generator = "sequence" , strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;

}
