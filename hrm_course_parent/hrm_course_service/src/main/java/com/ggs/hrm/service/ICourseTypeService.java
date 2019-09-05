package com.ggs.hrm.service;

import com.ggs.hrm.domain.CourseType;
import com.baomidou.mybatisplus.service.IService;
import com.ggs.hrm.query.CourseTypeQuery;
import com.ggs.hrm.util.PageList;

/**
 * <p>
 * 课程目录 服务类
 * </p>
 *
 * @author ggs
 * @since 2019-09-01
 */
public interface ICourseTypeService extends IService<CourseType> {

    PageList<CourseType> selectListPage(CourseTypeQuery query);
}
