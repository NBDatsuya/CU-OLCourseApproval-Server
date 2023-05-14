package ags.edu.cu.oca.service;

import ags.edu.cu.oca.bean.Course;
import ags.edu.cu.oca.bean.CourseAvailable;

import java.util.List;

public class CourseService {

    private static CourseService instance;

    public static CourseService getInstance() {
        if (instance == null) instance = new CourseService();
        return instance;
    }

    public List<Course> getCourseList() {
        return null;
    }

    public List<CourseAvailable> getCourseList(String field, String value) {
        return null;
    }

    public List<CourseAvailable> getCourseList(int userID, String field, String value) {
        return null;
    }
}
