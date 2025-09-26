package com.vipinshivhare.jpahibernate.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity //  this userEntity represent the userTable in the DB
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "tbl_student", // create a fresh table for you (update)
        uniqueConstraints = @UniqueConstraint( // for unique email
                name = "emailid_unique",
                columnNames = "email_address"
        )
)
public class Student {


    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(// both for generating the unique id
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long studentId;
    private String firstName;
    private String lastName;

    @Column(
            name = "email_address",
            nullable = false // want everytime unique email otherwise through an exception
    )
    private String emailId;

// as first i defined it as this names so i need to override it name -> guardianName
//    private String guardianName;
//    private String guardianEmail;
//    private String guardianMobile;

    @Embedded
    private Guardian guardian;




}
