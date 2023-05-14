package ags.edu.cu.oca.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment {
    private Integer ID;
    private Course course;
    private User applicant;
    private User examineUser;

    /*
     * 1 = Approved
     * 2 = Refused
     * 0 = Submitted but not examined
     */
    private Integer status;
    private String aDate;
    private String eDate;
}