package com.ggs.hrm.service;

import com.ggs.hrm.domain.Tenant;
import com.baomidou.mybatisplus.service.IService;
import com.ggs.hrm.query.TenantQuery;
import com.ggs.hrm.util.PageList;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ggs
 * @since 2019-09-02
 */
public interface ITenantService extends IService<Tenant> {

    PageList<Tenant> selectPageList(TenantQuery query);
}
