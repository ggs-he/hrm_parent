package com.ggs;

import com.ggs.hrm.SysManage9001Application;
import com.ggs.hrm.domain.Systemdictionary;
import com.ggs.hrm.service.ISystemdictionaryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SysManage9001Application.class)
public class XxxTest {
    @Autowired
    private ISystemdictionaryService systemdictionaryService;

    @Test
    public void test()throws Exception{
        for (Systemdictionary systemdictionary : systemdictionaryService.selectList(null)) {
            System.out.println(systemdictionary);
        }
    }
}
