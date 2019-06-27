package cn.cncoders.baseproject.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 登录拦截器
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/6/27
 */
public class LoginInHandlerInterceptor implements HandlerInterceptor {


    /**
     * 目标方法执行之前检查
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (null == loginUser) {
            //未登录
            //设置错误消息
            request.setAttribute("msg", "没有权限，请先登录！");
            //跳转到登录页面
            //获取到转发器
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;


        } else {
            //已经登录
            return true;

        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
