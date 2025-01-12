package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    /**
     * 新增分类
     * @param category
     */
    @Insert("insert into sky_take_out.category (type, name, sort, create_time, update_time, create_user, update_user) " +
            "values (#{type}, #{name}, #{sort}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
    void save(Category category);


    /**
     * 分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 修改分类
     * @param category
     */
    void update(Category category);

    /**
     * 根据id删除分类
     * @param id
     */
    void deleteById(Long id);

    /**
     * 根据类型查询分类
     * @param type
     * @return
     */
    List<Category> list(Integer type);
}
