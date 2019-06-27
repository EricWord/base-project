package cn.cncoders.baseproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Description 登录控制器
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/6/27
 */
@Controller
public class LoginController {
    /**
     * 登录请求跳转
     *
     * @param username 用户名 从请求参数中获取，如果请求中没有会报错
     * @param password 密码  从请求参数中获取，如果请求中没有会报错
     * @param map      存放错误消息
     * @param session   存放当前已经登录的用户信息
     *
     * @return 去往的页面
     */
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String, Object> map, HttpSession session) {
        //判断是否登录成功
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            //将已经登录的用户名保存到session中
            session.setAttribute("loginUser",username);
            //登录成功后为了防止表单重复提交可以重定向页面

            return "redirect:/main.html";
        } else {
            //登录失败
            map.put("msg", "用户名密码错误！");
            return "login";
        }

    }
}
