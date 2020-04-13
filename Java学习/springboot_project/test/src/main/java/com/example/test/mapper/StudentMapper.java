package com.example.test.mapper;
import com.example.test.pojo.Student;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component   //告诉Spring依赖注入 让容器控制
public interface StudentMapper {
    @Select("SElECT * FROM student")
    List<Student> getAllStudents();
}
