package dk.topdanmark;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CorsFilter", urlPatterns = "/*")
public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        String origin = req.getHeader("Origin");
        if (originIsAllowed(origin)) {
            resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
            resp.setHeader("Access-Control-Allow-Headers", "X-Requested-With, content-type, origin, accept, content-type, If-Modified-Since, Range");
            resp.setHeader("Access-Control-Allow-Origin", origin);
            resp.setHeader("Access-Control-Allow-Credentials", "true");
            if (!req.getMethod().equals("OPTIONS")) {
                chain.doFilter(request, response);
            }
        } else {
            resp.sendError(401);
        }
    }

    private boolean originIsAllowed(String origin) {
        System.out.println("origin = " + origin);
        if (origin == null || origin.contains("127.0.0.1") || origin.contains("localhost"))
            return true;
        return false;
    }

    @Override
    public void destroy() {}

}
