package com.example.springbootaop.aop;

import com.example.springbootaop.entity.SysLog;
import com.example.springbootaop.mapper.SysLogMapper;
import com.example.springbootaop.util.IPUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

@Aspect
@Component
public class LogAspect {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Pointcut("@annotation(com.example.springbootaop.aop.Log)")
    public void pointcut(){}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point){
        long beginTime = System.currentTimeMillis();
        Object result=null;
        try {
            //执行方法
             result = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        //执行方法耗时
        long time = System.currentTimeMillis()-beginTime;
        //保存日志
        saveLog(point,time);
        return result;
    }

    private void saveLog(ProceedingJoinPoint point, long time) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        SysLog sysLog = new SysLog();
        Log annotation = method.getAnnotation(Log.class);
        if(annotation!=null){
            //注解上的描述
            sysLog.setOperation(annotation.value());
        }
        //类名
        String className = point.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className+"."+methodName+"()");
        sysLog.setTime((int) time);
        sysLog.setUsername("fyb");
        // 请求的方法参数值
        Object[] args = point.getArgs();
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null && paramNames != null) {
            String params = "";
            for (int i = 0; i < args.length; i++) {
                params += "  " + paramNames[i] + ": " + args[i];
            }
            sysLog.setParams(params);
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        sysLog.setIp(IPUtils.getIpAddr(request));
        sysLog.setCreateTime(LocalDateTime.now());
        sysLogMapper.insert(sysLog);
    }

}
