package io.terminus.fbw.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Intellij IDEA
 * Copyright (C) CailyPersonal
 * Version: 1.0
 * Author: caily
 * Date: 28/06/2017
 */


public class A {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public A() {
        logger.debug("");
    }

    public void B(String[] args){
        Arguments.parse(new String[]{});
    }
}
