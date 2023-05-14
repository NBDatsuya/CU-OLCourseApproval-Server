package ags.edu.cu.oca.servlet;

import jakarta.json.bind.JsonbException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.io.IOException;
import java.util.Set;

import ags.edu.cu.oca.bean.User;
import ags.edu.cu.oca.util.JSON;
import ags.edu.cu.oca.response.BaseResponse;

public class BaseServlet extends HttpServlet {
    private static final Validator VALIDATOR;

    static {
        try (ValidatorFactory vf = Validation.buildDefaultValidatorFactory()) {
            VALIDATOR = vf.getValidator();
        }
    }

    protected <T> T bind(HttpServletRequest req,
                         HttpServletResponse res,
                         Class<T> type) throws IOException {
        req.setCharacterEncoding("utf-8");
        if (!"application/json".equals(req.getContentType())) {
            toJson(res, BaseResponse.builder()
                    .ok(false).msg("不支持的 Content-Type").build());
            return null;
        }

        T obj;
        try {
            obj = JSON.JSONB.fromJson(req.getReader(), type);
        } catch (JsonbException e) {
            toJson(res, BaseResponse.builder().ok(false).msg("参数错误").build());
            return null;
        }

        Set<ConstraintViolation<T>> violation =
                VALIDATOR.validate(obj);
        if (!violation.isEmpty()) {
            String msg = violation.stream()
                    .findFirst().get().getMessage();
            toJson(res, BaseResponse.builder()
                    .ok(false).msg(msg).build());
            return null;
        }

        return obj;
    }

    protected void toJson(HttpServletResponse res,
                        Object obj) throws IOException {

        res.setCharacterEncoding("utf-8");
        res.setContentType("application/json");
        JSON.JSONB.toJson(obj, res.getWriter());
    }

    protected User userLoggedIn(HttpServletRequest req) {
        return (User) req.getAttribute(
                "user");
    }
}
