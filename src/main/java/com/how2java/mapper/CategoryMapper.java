package com.how2java.mapper;

import com.how2java.pojo.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Intellij IDEA
 * Copyright (c) CailyPersonal
 * Version: v1.0
 * Author: Caily
 * Date: 29/06/2017
 */


public interface CategoryMapper {

    @Insert("insert into category_ (name) values (#{name})")
    int add(Category category);

    @Delete("delete from category_ where id = #{id}")
    void delete(int id);

    @Select("select * from category_ where id=#{id}")
    Category get(int id);

    @Update("update category_ set name=#{name} where id=#{id}")
    int update(Category category);

    @Select("select * from category_")
    List<Category> list();
}
