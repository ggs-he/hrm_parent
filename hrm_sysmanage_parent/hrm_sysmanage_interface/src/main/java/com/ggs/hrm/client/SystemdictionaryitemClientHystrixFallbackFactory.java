package com.ggs.hrm.client;

import com.ggs.hrm.domain.Systemdictionaryitem;
import com.ggs.hrm.query.SystemdictionaryitemQuery;
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
public class SystemdictionaryitemClientHystrixFallbackFactory implements FallbackFactory<SystemdictionaryitemClient> {

    public SystemdictionaryitemClient create(Throwable throwable) {
        return new SystemdictionaryitemClient() {
            public AjaxResult save(Systemdictionaryitem systemdictionaryitem) {
                return null;
            }

            public AjaxResult delete(Integer id) {
                return null;
            }

            public Systemdictionaryitem get(Long id) {
                return null;
            }

            public List<Systemdictionaryitem> list() {
                return null;
            }

            public PageList<Systemdictionaryitem> json(SystemdictionaryitemQuery query) {
                return null;
            }
        };
    }
}
