package com.personalitytest.aop;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.personalitytest.utils.StringUtils;

@WebFilter("/AcFilter")
public class AcFilter implements Filter {
    private FilterConfig filterConfig;
    
    public FilterConfig getFilterConfig() {  
        System.err.println("...getFilterConfig...");  
        return filterConfig;  
    }  
  
    public void setFilterConfig(FilterConfig filterConfig) {  
        System.err.println("...setFilterConfig...");  
        this.filterConfig = filterConfig;  
    }  
  
    @Override  
    public void destroy() {  
        System.err.println("...filter destroy...");  
        this.filterConfig = null;
    }  
  
    @Override  
    public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException,ServletException {  
        System.err.println("...doFilter...");  
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse) res;
        response.setCharacterEncoding("utf-8");
        // 登录登陆页面
        String logonStrings = filterConfig.getInitParameter("logonStrings");  
        // 过滤资源后缀参数
        String includeStrings = filterConfig.getInitParameter("includeStrings");  
        // 没有登陆转向页面
        String redirectPath = request.getContextPath() + filterConfig.getInitParameter("redirectPath");
        // 过滤器是否有效
        String disabletestfilter = filterConfig.getInitParameter("disabletestfilter");
        String[] logonList = logonStrings.split(";");
        String[] includeList = includeStrings.split(";");
        // 过滤无效
        if("Y".equals(disabletestfilter.toUpperCase())){
            chain.doFilter(request, response);
            return;
        }
        // 只对指定过滤参数后缀进行过滤
        if (!isContains(request.getRequestURI(), includeList)) {
          //传递下一个Filte
            chain.doFilter(request, response);
            return;
        }
        // 对登录页面不进行过滤
        if (isContains(request.getRequestURI(), logonList)) {
            chain.doFilter(request, response);
            return;
        }
        //判断用户是否登录
        String user = String.valueOf(request.getSession().getAttribute("userName"));
        if (StringUtils.isNull(user)) {
            response.sendRedirect(redirectPath);
        } else {
            chain.doFilter(request, response);
            return;
        }
    }  
  
    @Override  
    public void init(FilterConfig filterConfig) throws ServletException {  
        System.err.println("...init Filter...");  
        this.filterConfig = filterConfig;  
    }  
  
    public static boolean isContains(String container, String[] regx) {
        boolean result = false;
        for (int i = 0; i < regx.length; i++) {
            if (container.indexOf(regx[i]) != -1) {
                return true;
            }
        }
        return result;
    }
    
    public static String getCookie(HttpServletRequest request,String cookieName) {
        Cookie[] cookies=request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if(cookieName.equals(cookie.getName())){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
    
}
