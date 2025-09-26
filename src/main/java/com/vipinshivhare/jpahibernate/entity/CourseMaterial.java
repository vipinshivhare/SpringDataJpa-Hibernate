package com.vipinshivhare.jpahibernate.entity;
// Cascading me esa hai ki tum kisi table ki ID ko another table me Foreign key bnaye hai to jab hum
// 2nd table ka data save kr rhe hai to error aa rha hai kuki 1st table ki jo FK use kr rhe hai bo
// bhi to Exits krni chaiye na tabhi to ye save hoga to iske liye CASCADING use krege
// Cascading se jo 1st wali table thi na usme bhi data chla jaiga jab 2nd wale me dalege or kuki
// uski FK lgi hai to jo data 2nd me dala 1st ka wo apne aap 1st me chla jaiga and 2nd me to hoga hi save

// FETCH ko isliye use krte hai ki jab TABLES me apas me Relation hota hai (FK) to usme jb 2nd
// table ko (CourseMaterial) fetch karte hai to kya tumko parent (Course) bhi fetch krna hai sath me
// ya nahi -- uske liye alag alag FETCH type hai isme
// Fetch type (EAGER) will fetch the parent class data also
// Fetch type (Lazy) will not fetch the parent class data also
//👉 Ek aur point:
//@OneToOne aur @ManyToOne ka default EAGER hota hai.
//@OneToMany aur @ManyToMany ka default LAZY hota hai.
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {
    
    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator ="course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL, // imp in term for FK , for creating parent also
            fetch = FetchType.LAZY, // it will not fetch the parent class data
            optional = false
    )
    @JoinColumn(// this courseMaterial will have a additional column of course bcz we joined so make courseId as foreign key
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;


}
