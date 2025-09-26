package com.vipinshivhare.jpahibernate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
// as first i defined it as this guardianName so i need to override it name -> guardianName and all
        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardianName")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "guardianEmail")
        ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "guardianMobile")
        ),

})
public class Guardian {


    private String name;//now it will show as guardianName in DB as rest all
    private String email;
    private String mobile;



}

