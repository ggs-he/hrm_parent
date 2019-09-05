package com.ggs.hrm.client;

import com.ggs.hrm.domain.TenantType;
import com.ggs.hrm.query.TenantTypeQuery;
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
public class TenantTypeClientHystrixFallbackFactory implements FallbackFactory<TenantTypeClient> {

    @Override
    public TenantTypeClient create(Throwable throwable) {
        return new TenantTypeClient() {
            @Override
            public AjaxResult save(TenantType tenantType) {
                return null;
            }

            @Override
            public AjaxResult delete(Integer id) {
                return null;
            }

            @Override
            public TenantType get(Long id) {
                return null;
            }

            @Override
            public List<TenantType> list() {
                return null;
            }

            @Override
            public PageList<TenantType> json(TenantTypeQuery query) {
                return null;
            }
        };
    }
}
