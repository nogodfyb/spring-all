package com.example.springbootaop.service.impl;

import com.example.springbootaop.entity.SysLog;
import com.example.springbootaop.mapper.SysLogMapper;
import com.example.springbootaop.service.ISysLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fyb
 * @since 2020-06-01
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {

}
