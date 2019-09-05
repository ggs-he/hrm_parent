package com.ggs.hrm.controller;
import com.ggs.hrm.util.AjaxResult;
import com.ggs.hrm.util.FastDfsApiOpr;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
@RestController
@RequestMapping("/fastdfs")
public class FastDfsController {
    // 准备记录日志
    Logger logger = LoggerFactory.getLogger(FastDfsController.class);
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        try {
            // 获取文件名
            String filename = file.getOriginalFilename();
            // 获取文件后缀名
            String exName = filename.substring(filename.lastIndexOf(".") + 1);
            return FastDfsApiOpr.upload(file.getBytes(), exName);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("出错了..." + e.getMessage());
        }
        return null;
    }
    /**
     * download 下载文件
     *
     * @param path
     */
    @GetMapping("/download")
    public AjaxResult download(@RequestParam("path") String path, HttpServletResponse response) {
        // 去除路径中的第一个"/" : /group1/M00/00/00/wKgZhVkMP4KAZEy-AAA-tCf93Fo973.jpg
        String temPath = path.substring(1); //
        // 获取分组名: group1
        String groupName = temPath.substring(0, temPath.indexOf("/"));
        // 获取相对路径:
        /**
         *   数据库中的相对路径:
         *      group1/M00/00/00/wKgZhVkMP4KAZEy-AAA-tCf93Fo973.jpg
         *   获取的是:
         *      M00/00/00/wKgZhVkMP4KAZEy-AAA-tCf93Fo973.jpg
         */
        String remotePath = temPath.substring(temPath.indexOf("/") + 1);
        // 查看获取的路径
        System.out.println(groupName);
        System.out.println(remotePath);
        // 准备输出流,将文件输出到指定路径
        /**
         *  OutPutStream: 将文件信息写入请求响应中
         */
        OutputStream os = null;

        InputStream is = null;
        try {
            byte[] datas = FastDfsApiOpr.download(groupName, remotePath);
            os = response.getOutputStream();
            is = new ByteInputStream(datas, datas.length);
            IOUtils.copy(is, os);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("报错了..." + e.getMessage());
            return AjaxResult.me().setSuccess(false).setMessage("出错了...");
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (os != null) {
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @DeleteMapping("/delete")
    public AjaxResult delete(@RequestParam("path") String path) {
        ///group1/xxxx
        try {
            String pathTmp = path.substring(1); // goup1/xxxxx/yyyy
            String groupName = pathTmp.substring(0, pathTmp.indexOf("/")); //goup1
            String remotePath = pathTmp.substring(pathTmp.indexOf("/") + 1);// /xxxxx/yyyy
            System.out.println(groupName);
            System.out.println(remotePath);
            FastDfsApiOpr.delete(groupName, remotePath);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("error...." + e.getMessage());
            return AjaxResult.me().setSuccess(false).setMessage(e.getMessage());
        }
    }
}
