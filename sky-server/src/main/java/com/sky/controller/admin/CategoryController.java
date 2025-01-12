package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin/category")
@Api(tags = "菜品分类管理")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 新增分类
     * @param categoryDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增分类")
    public Result<String> save(@RequestBody CategoryDTO categoryDTO) {
        log.info("新增分类：{}", categoryDTO);
        categoryService.save(categoryDTO);
        return Result.success();
    }
    //分页查询
    @GetMapping("/page")
    @ApiOperation("分页查询")
    public Result<Object> page(CategoryPageQueryDTO categoryPageQueryDTO) {
        log.info("分页查询：{}", categoryPageQueryDTO);
        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }


    //修改分类
    @PutMapping
    @ApiOperation("修改分类")
    public Result<String> update(@RequestBody CategoryDTO categoryDTO) {
        log.info("修改分类：{}", categoryDTO);
        categoryService.update(categoryDTO);
        return Result.success();
    }
    //启用禁用分类
    @PostMapping("/status/{status}")
    @ApiOperation("启用禁用分类")
    public Result<String> startorstop(@PathVariable Integer status, Long id) {
        log.info("启用禁用分类：{}", status, id);
        categoryService.startorstop(status, id);
        return Result.success();
    }

    //根据id删除分类
    @DeleteMapping
    @ApiOperation("根据id删除分类")
    public Result<String> delete(Long id) {
        log.info("根据id删除分类：{}", id);
        categoryService.delete(id);
        return Result.success();
    }

    //根据类型查询分类
    @GetMapping("/list")
    @ApiOperation("根据类型查询分类")
    public Result<List<Category>> list(Integer type) {
        log.info("根据类型查询分类：{}", type);
        List<Category> list = categoryService.list(type);
        return Result.success(list);
    }

}
