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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
public class WorkOrderControllerTest {

    @Autowired
    private WorkOrderController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void workOrderSaveTest() throws Exception {

        String json = "{ \"orderType\": 0, \"title\": \"工单标题\" }";  // 缺少content字段

        mockMvc.perform(post("/order/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
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
