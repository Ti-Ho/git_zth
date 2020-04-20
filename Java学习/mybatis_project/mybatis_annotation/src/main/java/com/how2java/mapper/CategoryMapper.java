//package com.how2java.mapper;
//
//import java.util.List;
//
//import org.apache.ibatis.annotations.*;
//
//import com.how2java.pojo.Category;
//
//public interface CategoryMapper {
//    @Insert(" insert into category_ ( name ) values (#{name}) ")
//    public int add(Category category);
//
//    @Delete(" delete from category_ where id= #{id} ")
//    public void delete(int id);
//
//    @Select("select * from category_ where id= #{id} ")
//    public Category get(int id);
//
//    @Update("update category_ set name=#{name} where id=#{id} ")
//    public int update(Category category);
//
//    @Select(" select * from category_ ")
//    public List<Category> list();
//
//    @Select(" select * from category_ ")
//    @Results({
//            @Result(property = "id", column = "id"),
//            @Result(property = "products", javaType = List.class, column = "id", many = @Many(select = "com.how2java.mapper.ProductMapper.listByCategory"))
//    })
//    public List<Category> listAll();
//}


package com.how2java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.how2java.CategoryDynaSqlProvider;
import com.how2java.pojo.Category;

public interface CategoryMapper {

    @InsertProvider(type=CategoryDynaSqlProvider.class,method="add")
    public int add(Category category);

    @DeleteProvider(type=CategoryDynaSqlProvider.class,method="delete")
    public void delete(int id);

    @SelectProvider(type=CategoryDynaSqlProvider.class,method="get")
    public Category get(int id);

    @UpdateProvider(type=CategoryDynaSqlProvider.class,method="update")
    public int update(Category category);

    @SelectProvider(type=CategoryDynaSqlProvider.class,method="list")
    public List<Category> list();
}
