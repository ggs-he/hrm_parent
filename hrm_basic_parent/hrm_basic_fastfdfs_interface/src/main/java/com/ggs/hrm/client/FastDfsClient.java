package com.ggs.hrm.client;

import com.ggs.hrm.util.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "ZUUL-GATEWAY", configuration =
        FeignClientsConfiguration.class,
        fallbackFactory = FastDfsClientHystrixFallbackFactory.class)
@RequestMapping("/fastdfs")
public interface FastDfsClient {
    /**
     * 上传图片 : 上传后返回存入分布式文件系统后的相对路径
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    String upload(@RequestBody MultipartFile file);

    /**
     * 下载图片
     */
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    void download(@RequestParam("path") String path);

    /**
     *
     * @param path
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
     AjaxResult delete( @RequestParam("path") String path);
}
