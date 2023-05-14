package ags.edu.cu.oca.response;

import ags.edu.cu.oca.bean.Course;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder

public class CourseResponse extends BaseResponse {
    List<? extends Course> courseList;
}
