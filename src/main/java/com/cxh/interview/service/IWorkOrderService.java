package com.cxh.interview.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxh.interview.model.RestResp;
import com.cxh.interview.entity.WorkOrder;
import com.cxh.interview.model.dto.*;

public interface IWorkOrderService extends IService<WorkOrder> {

    RestResp workOrderSave(WorkOrderSaveDTO dto);

    RestResp workOrderDelete(WorkOrderDeleteDTO dto);

    RestResp workOrderUpdate(WorkOrderUpdateDTO dto);

    RestResp workOrderSearch(WorkOrderSearchDTO dto);

    RestResp workOrderFenpai(WorkOrderFenpaiDTO dto);

    RestResp queryTotalNumberOfOrderAndOverdueRateEveryDay(TotalNumberOfOrderAndOverdueRateDTO dto);

    RestResp queryTotalNumberOfOrderAndOverdueRateEveryDepartment(TotalNumberOfOrderAndOverdueRateDTO dto);

    RestResp queryTotalNumberOfOrderAndOverdueRateEveryOrderType(TotalNumberOfOrderAndOverdueRateDTO dto);

}
