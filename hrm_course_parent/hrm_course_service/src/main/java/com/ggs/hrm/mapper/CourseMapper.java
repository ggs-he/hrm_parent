package com.ggs.hrm.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.ggs.hrm.domain.Course;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ggs.hrm.query.CourseQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ggs
 * @since 2019-09-04
 */
public interface CourseMapper extends BaseMapper<Course> {
    List<Course> loadPageList(Page<Course> page,@Param("query") CourseQuery query);

}
