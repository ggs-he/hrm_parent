package com.ggs.hrm.web.controller;

import com.ggs.hrm.service.ICourseService;
import com.ggs.hrm.domain.Course;
import com.ggs.hrm.query.CourseQuery;
import com.ggs.hrm.util.AjaxResult;
import com.ggs.hrm.util.PageList;
import com.baomidou.mybatisplus.plugins.Page;
import com.ggs.hrm.util.UserInfoHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    public ICourseService courseService;
    /**
    * 保存和修改公用的
    * @param course  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody Course course){
        try {
            // 将冗余字段的值注入到数据库中
            course.setTenantId(UserInfoHolder.getTenant().getId());
            course.setTenantName(UserInfoHolder.getTenant().getCompanyName());
            course.setUserId(UserInfoHolder.getLoginUser().getId());
            course.setUserName(UserInfoHolder.getLoginUser().getRealName());
            if(course.getId()!=null){
                courseService.updateById(course);
            }else{
                courseService.insert(course);
                // 保存时,将关联的对象一起保存
            }
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("保存对象失败！"+e.getMessage());
        }
    }

    /**
    * 删除对象信息
    * @param id
    * @return
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id){
        try {
            courseService.deleteById(id);
            return AjaxResult.me();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败！"+e.getMessage());
        }
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Course get(@PathVariable("id")Long id)
    {
        return courseService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Course> list(){

        return courseService.selectList(null);
    }
    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/json",method = RequestMethod.POST)
    public PageList<Course> json(@RequestBody CourseQuery query)
    {
//        Page<Course> page = new Page<Course>(query.getPage(),query.getRows());
//            page = courseService.selectPage(page);
//            return new PageList<Course>(page.getTotal(),page.getRecords());
        return courseService.selectPageList(query);
    }
}
