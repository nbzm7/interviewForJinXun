package com.cxh.interview.controller;

import com.cxh.interview.model.RestResp;
import com.cxh.interview.model.dto.*;
import com.cxh.interview.service.IWorkOrderService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
public class WorkOrderController {

    private final IWorkOrderService workOrderService;

    public WorkOrderController(IWorkOrderService workOrderService) {
        this.workOrderService = workOrderService;
    }

    /**
     * 创建工单
     */
    @PostMapping("/order/save")
    public RestResp workOrderSave(@Valid @RequestBody WorkOrderSaveDTO dto) {
        return workOrderService.workOrderSave(dto);
    }

    /**
     * 删除工单
     */
    @PostMapping("/order/delete")
    public RestResp workOrderDelete(@Valid WorkOrderDeleteDTO dto) {
        return workOrderService.workOrderDelete(dto);
    }

    /**
     * 更新工单
     */
    @PostMapping("/order/update")
    public RestResp workOrderUpdate(@RequestBody WorkOrderUpdateDTO dto) {
        return workOrderService.workOrderUpdate(dto);
    }

    /**
     * 搜索工单
     */
    @PostMapping("/order/search")
    public RestResp workOrderSearch(@RequestBody WorkOrderSearchDTO dto) {
        return workOrderService.workOrderSearch(dto);
    }

    /**
     * 分派工单
     */
    @PostMapping("/order/fenpai")
    public RestResp workOrderFenpai(@Valid WorkOrderFenpaiDTO dto) {
        return workOrderService.workOrderFenpai(dto);
    }

    /**
     * 查询7月每天的工单总量、超期率
     */
    @PostMapping("/order/queryOrderAndOverdueRateEveryDay")
    public RestResp queryTotalNumberOfOrderAndOverdueRateEveryDay(@RequestBody TotalNumberOfOrderAndOverdueRateDTO dto) {
        return workOrderService.queryTotalNumberOfOrderAndOverdueRateEveryDay(dto);
    }

    /**
     * 查询7月每个部门的工单总量、超期率
     */
    @PostMapping("/order/queryOrderAndOverdueRateEveryDepartment")
    public RestResp queryTotalNumberOfOrderAndOverdueRateEveryDepartment(@RequestBody TotalNumberOfOrderAndOverdueRateDTO dto) {
        return workOrderService.queryTotalNumberOfOrderAndOverdueRateEveryDepartment(dto);
    }

    /**
     * 查询7月每个工单类型的工单总量、超期率
     */
    @PostMapping("/order/queryOrderAndOverdueRateEveryOrderType")
    public RestResp queryTotalNumberOfOrderAndOverdueRateEveryOrderType(@RequestBody TotalNumberOfOrderAndOverdueRateDTO dto) {
        return workOrderService.queryTotalNumberOfOrderAndOverdueRateEveryOrderType(dto);
    }

}
