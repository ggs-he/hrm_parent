package com.ggs.hrm.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.ggs.hrm.domain.CourseType;
import com.ggs.hrm.mapper.CourseTypeMapper;
import com.ggs.hrm.query.CourseTypeQuery;
import com.ggs.hrm.service.ICourseTypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ggs.hrm.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程目录 服务实现类
 * </p>
 *
 * @author ggs
 * @since 2019-09-01
 */
@Service
public class CourseTypeServiceImpl extends ServiceImpl<CourseTypeMapper, CourseType> implements ICourseTypeService {
    @Autowired
    private CourseTypeMapper courseTypeMapper;


    public PageList<CourseType> selectListPage(CourseTypeQuery query) {
        Page page = new Page(query.getPage(),query.getRows());  // 分页对象
        List<CourseType> courseTypes = courseTypeMapper.loadListPage(page, query);
        return new PageList<CourseType>(page.getTotal(),courseTypes);
    }
}
