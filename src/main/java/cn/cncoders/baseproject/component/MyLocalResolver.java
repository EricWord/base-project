package cn.cncoders.baseproject.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @Description 本地区域解析器，可以在链接上携带区域信息，之前都是在请求头中携带区域信息
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/6/27
 */
public class MyLocalResolver implements LocaleResolver {
    /**
     * 解析区域信息
     *
     * @param request 请求
     * @return
     */

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取参数值
        String l = request.getParameter("l");
        //参数中如果没有携带区域信息就使用系统默认的
        Locale locale = Locale.getDefault();

        //检查参数值是否为空
        if (!StringUtils.isEmpty(l)) {
            //不为空
            //根据下划线来分割
            String[] s = l.split("_");
            locale = new Locale(s[0], s[1]);


        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
