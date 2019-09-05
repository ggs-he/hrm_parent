package com.ggs.hrm.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.ggs.hrm.domain.Tenant;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ggs.hrm.query.TenantQuery;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ggs
 * @since 2019-09-02
 */
public interface TenantMapper extends BaseMapper<Tenant> {

    void removeTenantMeal(Serializable id);

    void saveTenantMeals(List<Map<String, Long>> mealsMap);

    List<Tenant> loadPageList(Page page, @Param("query") TenantQuery query);
}
