package ags.edu.cu.oca.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer ID;
    private String name;
    private String realName;
    private String password;
    private Integer role;

    public static final int ADMIN = 0;
    public static final int TEACHER = 1;
    public static final int STUDENT = 2;

    public String getRoleText() {
        return parseRole(role);
    }

    public static String parseRole(Integer role) {
        switch (role) {
            case 2:
                return "学生";
            case 1:
                return "教师";
            case 0:
                return "管理员";
            default:
                return "未知";
        }
    }
}
