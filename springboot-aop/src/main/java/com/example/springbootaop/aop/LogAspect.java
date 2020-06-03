package com.example.springbootaop.aop;

import com.example.springbootaop.entity.SysLog;
import com.example.springbootaop.mapper.SysLogMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

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
        Object[] args = point.getArgs();
        try {
            //执行方法
            point.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        //执行方法耗时
        long time = System.currentTimeMillis()-beginTime;
        //保存日志
        saveLog(point,time);
        return null;
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
        System.out.println(sysLog);

    }

}
