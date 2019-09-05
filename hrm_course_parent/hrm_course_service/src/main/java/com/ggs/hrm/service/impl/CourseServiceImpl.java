package com.ggs.hrm.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.ggs.hrm.domain.Course;
import com.ggs.hrm.mapper.CourseMapper;
import com.ggs.hrm.query.CourseQuery;
import com.ggs.hrm.service.ICourseService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ggs.hrm.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ggs
 * @since 2019-09-04
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public PageList<Course> selectPageList(CourseQuery query) {
        // 新建分页对象, 自己的不能实现关联查询和高级查询, 故需要自己覆写方法
        Page page = new Page(query.getPage(),query.getRows());
        // 获取分页数据
        List<Course> courses = courseMapper.loadPageList(page, query);
        // 返回 pageList 对象
        return new PageList(page.getTotal(),courses);
    }
}
