package com.ggs.hrm.client;

import com.ggs.hrm.domain.Menu;
import com.ggs.hrm.query.MenuQuery;
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
public class MenuClientHystrixFallbackFactory implements FallbackFactory<MenuClient> {

    @Override
    public MenuClient create(Throwable throwable) {
        return new MenuClient() {
            @Override
            public AjaxResult save(Menu menu) {
                return null;
            }

            @Override
            public AjaxResult delete(Integer id) {
                return null;
            }

            @Override
            public Menu get(Long id) {
                return null;
            }

            @Override
            public List<Menu> list() {
                return null;
            }

            @Override
            public PageList<Menu> json(MenuQuery query) {
                return null;
            }
        };
    }
}
