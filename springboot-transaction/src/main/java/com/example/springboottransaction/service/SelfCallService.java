package com.example.springboottransaction.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author fyb
 * @since 2021/9/18
 */
public interface SelfCallService {
    @Transactional(propagation = Propagation.REQUIRED)
    void test();
}
