package com.how2java.pojo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Caily on 6/29/2017.
 */
@SpringBootApplication
public class Application {
    public static void main(String... args){
        new SpringApplicationBuilder(Application.class).web(false).run(args);
    }

    @Component
    public static class Startup implements CommandLineRunner{
        @Override
        public void run(String... strings) throws Exception {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = sqlSessionFactory.openSession();
            List<Category> list = session.selectList("listCategory");

            list.stream().forEach(c->System.out.println(c.getName()));

            Category c = new Category();
            c.setName("New insert");
            session.insert("addCategory",c);

            session.commit();

            list = session.selectList("listCategory");
            list.stream().forEach(k->System.out.println(k.getName()));
            session.close();
        }

    }
}
