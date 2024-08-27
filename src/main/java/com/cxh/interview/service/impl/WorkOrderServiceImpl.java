package com.cxh.interview.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxh.interview.model.RestResp;
import com.cxh.interview.entity.Department;
import com.cxh.interview.entity.WorkOrder;
import com.cxh.interview.exception.CommonErrorCode;
import com.cxh.interview.exception.WorkOrderErrorCode;
import com.cxh.interview.mapper.WorkOrderMapper;
import com.cxh.interview.model.dto.*;
import com.cxh.interview.model.vo.QueryTotalNumberOfOrderAndOverdueRateEveryDayVO;
import com.cxh.interview.model.vo.QueryTotalNumberOfOrderAndOverdueRateEveryDepartmentVO;
import com.cxh.interview.model.vo.QueryTotalNumberOfOrderAndOverdueRateEveryOrderTypeVO;
import com.cxh.interview.service.IDepartmentService;
import com.cxh.interview.service.IWorkOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class WorkOrderServiceImpl extends ServiceImpl<WorkOrderMapper, WorkOrder> implements IWorkOrderService {

    private final IDepartmentService departmentService;

    public WorkOrderServiceImpl(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /**
     * 创建工单
     */
    @Override
    public RestResp workOrderSave(WorkOrderSaveDTO dto) {

        WorkOrder workOrder = new WorkOrder();

        workOrder.setOrderNo(IdUtil.objectId())
                .setOrderType(dto.getOrderType())
                .setTitle(dto.getTitle())
                .setContent(dto.getContent())
                .setCreateTime(DateTime.now().toLocalDateTime());

        return this.save(workOrder) ? RestResp.ok() : RestResp.error();
    }

    /**
     * 删除工单
     */
    @Override
    public RestResp workOrderDelete(WorkOrderDeleteDTO dto) {

        Integer orderId = dto.getId();
        WorkOrder workOrder = this.getById(orderId);

        if (ObjectUtil.isNull(workOrder)) {
            return RestResp.error(WorkOrderErrorCode.WORK_ORDER_NOT_EXISTS);
        }

        return this.removeById(orderId) ? RestResp.ok() : RestResp.error();
    }

    /**
     * 更新工单
     */
    @Override
    public RestResp workOrderUpdate(WorkOrderUpdateDTO dto) {

        Integer orderId = dto.getId();
        WorkOrder workOrder = this.getById(orderId);

        if (ObjectUtil.isNull(workOrder)) {
            return RestResp.error(WorkOrderErrorCode.WORK_ORDER_NOT_EXISTS);
        }


        if (ObjectUtil.isNotNull(dto.getOrderType())) {
            workOrder.setOrderType(dto.getOrderType());
        }
        if (StrUtil.isNotEmpty(dto.getTitle())) {
            workOrder.setTitle(dto.getTitle());
        }
        if (StrUtil.isNotEmpty(dto.getContent())) {
            workOrder.setContent(dto.getContent());
        }

        return this.updateById(workOrder) ? RestResp.ok() : RestResp.error();
    }

    /**
     * 搜索工单
     */
    @Override
    public RestResp workOrderSearch(WorkOrderSearchDTO dto) {
        Page<WorkOrder> page = new Page<>();
        page.setCurrent(dto.getPageNum());
        page.setSize(dto.getPageSize());
        Page<WorkOrder> result = (Page<WorkOrder>) this.getBaseMapper().workOrderSearch(page, dto);

        return RestResp.ok(result);
    }

    /**
     * 分派工单
     */
    @Override
    public RestResp workOrderFenpai(WorkOrderFenpaiDTO dto) {

        Integer orderId = dto.getOrderId();
        Integer handleDeptId = dto.getHandleDeptId();

        WorkOrder workOrder = this.getById(orderId);
        Department department = departmentService.getById(handleDeptId);

        if (ObjectUtil.isNull(workOrder) || ObjectUtil.isNull(department)) {
            return RestResp.error(CommonErrorCode.PARAMS_ERROR);
        }

        workOrder.setHandleDeptId(handleDeptId)
                .setFenpaiTime(DateTime.now().toLocalDateTime());

        return this.updateById(workOrder) ? RestResp.ok() : RestResp.error();
    }

    /**
     * 查询7月每天的工单总量、超期率
     */
    @Override
    public RestResp queryTotalNumberOfOrderAndOverdueRateEveryDay(TotalNumberOfOrderAndOverdueRateDTO dto) {
        List<QueryTotalNumberOfOrderAndOverdueRateEveryDayVO> result = this.getBaseMapper().queryTotalNumberOfOrderAndOverdueRateEveryDay(dto);
        return RestResp.ok(result);
    }

    /**
     * 查询7月每个部门的工单总量、超期率
     */
    @Override
    public RestResp queryTotalNumberOfOrderAndOverdueRateEveryDepartment(TotalNumberOfOrderAndOverdueRateDTO dto) {
        List<QueryTotalNumberOfOrderAndOverdueRateEveryDepartmentVO> result = this.getBaseMapper().queryTotalNumberOfOrderAndOverdueRateEveryDepartment(dto);
        return RestResp.ok(result);

    }

    /**
     * 查询7月每个工单类型的工单总量、超期率
     */
    @Override
    public RestResp queryTotalNumberOfOrderAndOverdueRateEveryOrderType(TotalNumberOfOrderAndOverdueRateDTO dto) {
        List<QueryTotalNumberOfOrderAndOverdueRateEveryOrderTypeVO> result = this.getBaseMapper().queryTotalNumberOfOrderAndOverdueRateEveryOrderType(dto);
        return RestResp.ok(result);
    }
}
