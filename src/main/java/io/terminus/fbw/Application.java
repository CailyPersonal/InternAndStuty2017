package io.terminus.fbw;

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

@SpringBootApplication
public class Application {
    public static void Main(String... args) {
        new SpringApplicationBuilder().web(false).run(args);
    }

    @Component
    public static class Startup implements CommandLineRunner {

        @Override
        public void run(String... strings) throws Exception {

        }
    }
}
