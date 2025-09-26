package com.vipinshivhare.jpahibernate.repository;
// Cascading me esa hia ki tum kisi table ki ID ko another table Foreign key bnaye hai to jab hum
// 2nd table ka data save kr rhe hai to error aa rha hai kuki 1st table ki jo FK use kr rhe hai bo
// bhi to Exits krni chaiye na tabhi to ye save hoga to iske liye CASCADING use krege
// Cascading se jo 1st wali table thi na usme bhi data chla jaiga jab 2nd wale me dalege or kuki
// uski FK lgi hai to jo data 2nd me dala 1st ka wo apne app 1st me chla jaiga and 2nd me to hoga hi save
import com.vipinshivhare.jpahibernate.entity.Course;
import com.vipinshivhare.jpahibernate.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void SaveCourseMaterial(){

        Course course =
                Course.builder()
                        .title(".net")
                        .credit(6)
                        .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.vipin.com")
                        .course(course)
                        .build();
        // this is possible due to cascading
        repository.save(courseMaterial);
    }


    @Test
    public void printAllCoursesMaterials(){
        List<CourseMaterial> courseMaterials =
                repository.findAll();

        System.out.println("CourseMaterials = " + courseMaterials);
    }




}