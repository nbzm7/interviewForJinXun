package com.cxh.interview;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxh.interview.model.RestResp;
import com.cxh.interview.controller.WorkOrderController;
import com.cxh.interview.entity.WorkOrder;
import com.cxh.interview.model.dto.*;
import com.cxh.interview.model.vo.QueryTotalNumberOfOrderAndOverdueRateEveryDayVO;
import com.cxh.interview.model.vo.QueryTotalNumberOfOrderAndOverdueRateEveryDepartmentVO;
import com.cxh.interview.model.vo.QueryTotalNumberOfOrderAndOverdueRateEveryOrderTypeVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class WorkOrderControllerTest {

    @Autowired
    private WorkOrderController controller;

    @Test
    void workOrderSaveTest() {
        WorkOrderSaveDTO dto = new WorkOrderSaveDTO();

        dto.setOrderType(0);
//        dto.setOrderType(4);
        dto.setTitle("工单标题");
//        dto.setContent("工单内容");

        RestResp restResp = controller.workOrderSave(dto);

        log.info(restResp.toString());

    }

    @Test
    void workOrderDeleteTest() {
        WorkOrderDeleteDTO dto = new WorkOrderDeleteDTO(2);

        RestResp restResp = controller.workOrderDelete(dto);

        log.info(restResp.toString());

    }

    @Test
    void workOrderUpdateTest() {
        WorkOrderUpdateDTO dto = new WorkOrderUpdateDTO(3);

        dto.setTitle("工单标题修改测试3");
        dto.setContent("工单内容修改测试3");

        RestResp restResp = controller.workOrderUpdate(dto);

        log.info(restResp.toString());

    }

    @Test
    void workOrderSearchTest() {
        WorkOrderSearchDTO dto = new WorkOrderSearchDTO();

        dto.setOrderNo("d5");
        dto.setOrderType(0);
        dto.setTitle("标题");
        dto.setHandleDeptId(1);

        dto.setCreateTimeStart(DateUtil.parseLocalDateTime("2024-08-26 17:52:03"));
        dto.setCreateTimeEnd(DateUtil.parseLocalDateTime("2024-08-26 17:52:05"));

        dto.setFenpaiTimeStart(DateUtil.parseLocalDateTime("2024-08-26 20:15:11"));
        dto.setFenpaiTimeEnd(DateUtil.parseLocalDateTime("2024-08-26 20:15:14"));

        RestResp restResp = controller.workOrderSearch(dto);

        Page<WorkOrder> result = (Page<WorkOrder>) restResp.getData();
        result.getRecords().forEach(r -> Console.log(r));

    }

    @Test
    void workOrderFenpaiTest() {
        WorkOrderFenpaiDTO dto = new WorkOrderFenpaiDTO(5, 1);

        dto.setHandleDeptName("部门名称,随便填");

        RestResp restResp = controller.workOrderFenpai(dto);
        Console.log(restResp);

    }


    private static TotalNumberOfOrderAndOverdueRateDTO dto;

    static {
        dto = new TotalNumberOfOrderAndOverdueRateDTO();
        dto.setStartTime(DateUtil.parseLocalDateTime("2024-07-01 00:00:00"));
        dto.setEndTime(DateUtil.parseLocalDateTime("2024-08-01 00:00:00"));
    }

    @Test
    void queryTotalNumberOfOrderAndOverdueRateEveryDayTest() {
        RestResp restResp = controller.queryTotalNumberOfOrderAndOverdueRateEveryDay(dto);
        List<QueryTotalNumberOfOrderAndOverdueRateEveryDayVO> result = (List<QueryTotalNumberOfOrderAndOverdueRateEveryDayVO>) restResp.getData();
        result.forEach(r -> Console.log(r));
    }

    @Test
    void queryTotalNumberOfOrderAndOverdueRateEveryDepartmentTest() {
        RestResp restResp = controller.queryTotalNumberOfOrderAndOverdueRateEveryDepartment(dto);
        List<QueryTotalNumberOfOrderAndOverdueRateEveryDepartmentVO> result = (List<QueryTotalNumberOfOrderAndOverdueRateEveryDepartmentVO>) restResp.getData();
        result.forEach(r -> Console.log(r));

    }

    @Test
    void queryTotalNumberOfOrderAndOverdueRateEveryOrderTypeTest() {
        RestResp restResp = controller.queryTotalNumberOfOrderAndOverdueRateEveryOrderType(dto);
        List<QueryTotalNumberOfOrderAndOverdueRateEveryOrderTypeVO> result = (List<QueryTotalNumberOfOrderAndOverdueRateEveryOrderTypeVO>) restResp.getData();
        result.forEach(r -> Console.log(r));

    }
}
