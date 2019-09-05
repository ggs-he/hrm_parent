package com.ggs.hrm.client;

import com.ggs.hrm.util.AjaxResult;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FastDfsClientHystrixFallbackFactory implements FallbackFactory<FastDfsClient> {
    @Override
    public FastDfsClient create(Throwable throwable) {
        return new FastDfsClient() {
            @Override
            public String upload(MultipartFile file) {
                return null;
            }
            @Override
            public void download(String path) {

            }
            @Override
            public AjaxResult delete(String path) {
                return null;
            }
        };
    }
}
