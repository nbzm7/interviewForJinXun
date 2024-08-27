package com.cxh.interview.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxh.interview.entity.WorkOrder;
import com.cxh.interview.model.dto.TotalNumberOfOrderAndOverdueRateDTO;
import com.cxh.interview.model.dto.WorkOrderSearchDTO;
import com.cxh.interview.model.vo.QueryTotalNumberOfOrderAndOverdueRateEveryDayVO;
import com.cxh.interview.model.vo.QueryTotalNumberOfOrderAndOverdueRateEveryDepartmentVO;
import com.cxh.interview.model.vo.QueryTotalNumberOfOrderAndOverdueRateEveryOrderTypeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkOrderMapper extends BaseMapper<WorkOrder> {

    IPage<WorkOrder> workOrderSearch(Page<WorkOrder> page, @Param("order") WorkOrderSearchDTO dto);

    // 查询每天的工作总量和超期率
    List<QueryTotalNumberOfOrderAndOverdueRateEveryDayVO> queryTotalNumberOfOrderAndOverdueRateEveryDay(@Param("param")TotalNumberOfOrderAndOverdueRateDTO dto);

    // 查询每个部门的工单总量和超期率
    List<QueryTotalNumberOfOrderAndOverdueRateEveryDepartmentVO> queryTotalNumberOfOrderAndOverdueRateEveryDepartment(@Param("param") TotalNumberOfOrderAndOverdueRateDTO dto);

    // 查询每个工单类型的工单总量和超期率
    List<QueryTotalNumberOfOrderAndOverdueRateEveryOrderTypeVO> queryTotalNumberOfOrderAndOverdueRateEveryOrderType(@Param("param")TotalNumberOfOrderAndOverdueRateDTO dto);
}
