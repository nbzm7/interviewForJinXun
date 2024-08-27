package com.cxh.interview.service.impl;

import com.cxh.interview.entity.Department;
import com.cxh.interview.mapper.DepartmentMapper;
import com.cxh.interview.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

}
