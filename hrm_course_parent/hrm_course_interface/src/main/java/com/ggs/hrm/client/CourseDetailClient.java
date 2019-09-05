package com.ggs.hrm.client;

import com.ggs.hrm.domain.CourseDetail;
import com.ggs.hrm.query.CourseDetailQuery;
import com.ggs.hrm.util.AjaxResult;
import com.ggs.hrm.util.PageList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "ZUUL-GATEWAY",configuration = FeignClientsConfiguration.class,
        fallbackFactory = CourseDetailClientHystrixFallbackFactory.class)
@RequestMapping("/courseDetail")
public interface CourseDetailClient {
    /**
     * 保存和修改公用的
     * @param courseDetail  传递的实体
     * @return Ajaxresult转换结果
     */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    AjaxResult save(CourseDetail courseDetail);

    /**
     * 删除对象信息
     * @param id
     * @return
     */
    @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
    AjaxResult delete(@PathVariable("id") Integer id);

    //获取用户
    @RequestMapping("/{id}")
    CourseDetail get(@RequestParam(value="id",required=true) Long id);


    /**
     * 查看所有的员工信息
     * @return
     */
    @RequestMapping("/list")
    public List<CourseDetail> list();

    /**
     * 分页查询数据
     *
     * @param query 查询对象
     * @return PageList 分页对象
     */
    @RequestMapping(value = "/json",method = RequestMethod.POST)
    PageList<CourseDetail> json(@RequestBody CourseDetailQuery query);
}
