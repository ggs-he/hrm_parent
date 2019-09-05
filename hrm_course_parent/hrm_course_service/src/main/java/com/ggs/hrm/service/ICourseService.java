package com.ggs.hrm.service;

import com.ggs.hrm.domain.Course;
import com.baomidou.mybatisplus.service.IService;
import com.ggs.hrm.query.CourseQuery;
import com.ggs.hrm.util.PageList;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ggs
 * @since 2019-09-04
 */
public interface ICourseService extends IService<Course> {

    PageList<Course> selectPageList(CourseQuery query);
}
