package io.terminus.fbw;

import io.terminus.fbw.impl.A;
import io.terminus.fbw.impl.Arguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by Intellij IDEA
 * Copyright (c) CailyPersonal
 * Version: v1.0
 * Author: Caily
 * Date: 28/06/2017
 */

//@SpringBootApplication
public class Application {
    public static void main(String... args) {
        new SpringApplicationBuilder(Application.class).web(false).run(args);
    }

    //@Component
    public static class Startup implements CommandLineRunner {

        @Override
        public void run(String... args) throws Exception {
            A a = new A();
            a.B(args);

        }
    }
}
