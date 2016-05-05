package com.lifeix.football.timeline.interceptor;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * 用户授权拦截器，最好不要配置白名单黑名单之类的东西
 * 
 * <pre>
[ INFO ] [2016-04-06 13:59:07] org.apache.catalina.core.ContainerBase.[Tomcat].[localhost].[/designer] [180] - Initializing Spring FrameworkServlet 'dispatcherServlet'
[ INFO ] [2016-04-06 13:59:07] com.lifeix.sports.interceptor.UserSecurityInterceptor [27] - preHandle--->public java.util.List<com.lifeix.sports.model.Post> com.lifeix.sports.module.post.controller.PostController.list(java.lang.String,int,java.lang.Long,java.lang.String)
[ INFO ] [2016-04-06 13:59:07] com.lifeix.sports.module.post.controller.PostController [43] - list authorId = null ,limit = 100, date = null, orderBy = createTime
[ INFO ] [2016-04-06 13:59:07] com.lifeix.sports.module.post.service.impl.PostServiceImpl [42] - list authorId = null ,limit = 100, date = null, orderBy = createTime
[ INFO ] [2016-04-06 13:59:07] com.lifeix.sports.module.post.monitor.PostServiceMonitor [21] - Completed: execution(List com.lifeix.sports.module.post.service.PostService.list(String,int,Date,String))
[ INFO ] [2016-04-06 13:59:07] com.lifeix.sports.interceptor.UserSecurityInterceptor [39] - postHandle--->public java.util.List<com.lifeix.sports.model.Post> com.lifeix.sports.module.post.controller.PostController.list(java.lang.String,int,java.lang.Long,java.lang.String)
[ INFO ] [2016-04-06 13:59:07] com.lifeix.sports.interceptor.UserSecurityInterceptor [45] - afterCompletion--->public java.util.List<com.lifeix.sports.model.Post> com.lifeix.sports.module.post.controller.PostController.list(java.lang.String,int,java.lang.Long,java.lang.String)
[ INFO ] [2016-04-06 13:59:07] com.lifeix.sports.Application [38] - ServletRequestHandledEvent: url=[/designer/posts]; client=[0:0:0:0:0:0:0:1]; method=[GET]; servlet=[dispatcherServlet]; session=[null]; user=[null]; time=[30ms]; status=[OK]
 * </pre>
 */
public class UserSecurityInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(UserSecurityInterceptor.class);

    private ThreadLocal<StopWatch> threadLocal = new ThreadLocal<StopWatch>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        StopWatch watch = new StopWatch();
        threadLocal.set(watch);
        watch.start();
        Map<String, String[]> map = request.getParameterMap();
        Set<String> set = map.keySet();
        for (String key : set) {
            logger.info(key + " - " + Arrays.deepToString(map.get(key)));
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView view) throws Exception {
        logger.info("postHandle--->" + handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception exception) throws Exception {
        StopWatch watch = threadLocal.get();
        watch.stop();
        logger.info("this request used time :--->" + watch.getLastTaskTimeMillis());
        logger.info("afterCompletion--->" + handler);
    }

}
