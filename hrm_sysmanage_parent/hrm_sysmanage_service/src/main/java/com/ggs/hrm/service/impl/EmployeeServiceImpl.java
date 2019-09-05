package com.ggs.hrm.service.impl;

import com.ggs.hrm.domain.Employee;
import com.ggs.hrm.mapper.EmployeeMapper;
import com.ggs.hrm.service.IEmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ggs
 * @since 2019-09-02
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
