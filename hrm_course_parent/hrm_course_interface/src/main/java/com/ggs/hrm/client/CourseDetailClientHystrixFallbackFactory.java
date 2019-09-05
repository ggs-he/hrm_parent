package com.ggs.hrm.client;

import com.ggs.hrm.domain.CourseDetail;
import com.ggs.hrm.query.CourseDetailQuery;
import com.ggs.hrm.util.AjaxResult;
import com.ggs.hrm.util.PageList;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yaohuaipeng
 * @date 2018/10/8-16:18
 */
@Component
public class CourseDetailClientHystrixFallbackFactory implements FallbackFactory<CourseDetailClient> {

    @Override
    public CourseDetailClient create(Throwable throwable) {
        return new CourseDetailClient() {
            @Override
            public AjaxResult save(CourseDetail courseDetail) {
                return null;
            }

            @Override
            public AjaxResult delete(Integer id) {
                return null;
            }

            @Override
            public CourseDetail get(Long id) {
                return null;
            }

            @Override
            public List<CourseDetail> list() {
                return null;
            }

            @Override
            public PageList<CourseDetail> json(CourseDetailQuery query) {
                return null;
            }
        };
    }
}
