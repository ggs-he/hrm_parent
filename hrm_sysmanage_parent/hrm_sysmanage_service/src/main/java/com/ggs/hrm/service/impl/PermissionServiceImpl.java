package com.ggs.hrm.service.impl;

import com.ggs.hrm.domain.Permission;
import com.ggs.hrm.mapper.PermissionMapper;
import com.ggs.hrm.service.IPermissionService;
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
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
