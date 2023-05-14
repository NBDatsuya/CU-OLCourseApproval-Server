package ags.edu.cu.oca.servlet;

import ags.edu.cu.oca.bean.Course;
import ags.edu.cu.oca.bean.User;
import ags.edu.cu.oca.response.BaseResponse;
import ags.edu.cu.oca.response.CourseResponse;
import ags.edu.cu.oca.service.CourseService;
import ags.edu.cu.oca.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CourseListServlet", value = "/getCourseList")
public class CourseListServlet extends BaseServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userID;
        String field = null;
        String value = null;

        try {
            userID = Integer.parseInt(req.getParameter("userID"));
            field = req.getParameter("field");
            if (field != null && !field.equals("null"))
                value = req.getParameter("value");
        } catch (Exception e) {
            toJson(resp,
                    BaseResponse.builder()
                            .ok(false).msg("参数错误").build());
            return;
        }

        var user = UserService.getInstance().getUserByID(userID);
        var service = CourseService.getInstance();
        List<? extends Course> list;

        if (user == null) {
            toJson(resp,
                    BaseResponse.builder()
                            .ok(false).msg("查询不到该用户").build());
            return;
        }

        if (value != null) {
            list = (user.getRole().equals(User.TEACHER)) ?
                    service.getCourseList(field, value) :
                    service.getCourseList(userID, field, value);
        } else {
            list = (user.getRole().equals(User.TEACHER)) ?
                    service.getCourseList() :
                    service.getCourseList(userID, null, null);
        }

        if (list != null)
            toJson(resp, CourseResponse.builder()
                    .courseList(list).ok(true).build()
            );
    }
}
