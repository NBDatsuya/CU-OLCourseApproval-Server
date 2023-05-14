package ags.edu.cu.oca.filter;

import ags.edu.cu.oca.util.JSON;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BaseFilter extends HttpFilter {
    protected void json(HttpServletResponse res, Object obj) throws IOException {
        res.setCharacterEncoding("utf-8");
        res.setContentType("application/json");
        JSON.JSONB.toJson(obj, res.getWriter());
    }
}
