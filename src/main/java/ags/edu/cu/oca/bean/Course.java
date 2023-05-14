package ags.edu.cu.oca.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Integer ID;
    private String name;
    private String instructor;
    private String schedule;
}