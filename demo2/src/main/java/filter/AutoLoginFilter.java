package filter;

import pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class AutoLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Cookie[] cookies = request.getCookies();
        String autoLogin = null;
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if ("autologin".equals(cookies[i].getName())) {
                autoLogin = cookies[i].getValue();
                break;
            }
        }
        if (autoLogin != null) {
            String[] parts = autoLogin.split("-");
            String username = parts[0];
            String password = parts[1];
            if ("itcast".equals(username) && ("123456").equals(password)) {
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                request.getSession().setAttribute("user", user);
            }
        }
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
