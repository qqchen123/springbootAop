package com.example.aoptest.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.aoptest.entity.Address;
import com.example.aoptest.mapper.AddressMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @PROJECT_NAME: springbootAop
 * @DESCRIPTION:
 * @USER: ejchen
 * @DATE: 2023/5/28 16:54
 */
public class ImportExcelListener<T> extends AnalysisEventListener<T> {

    /**
     * 每隔1000条存储数据库，然后清理list，方便内存回收
     */
    private static final int BATCH_COUNT = 1000;
    /**
     * 临时存储
     */
    private List<T> cachedData = new ArrayList<>(BATCH_COUNT);

    private AddressMapper addressMapper;

    public ImportExcelListener(AddressMapper addressMapper){
        this.addressMapper= addressMapper;
    }


    @Override
    public void invoke(T t, AnalysisContext analysisContext) {
        cachedData.add(t);
        if (cachedData.size()>=BATCH_COUNT)
        {
            batchSaveData();
            cachedData = new ArrayList<>(BATCH_COUNT);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    public void batchSaveData(){
        System.out.println(cachedData);
        addressMapper.batchInsertData((List<Address>) cachedData);
    }

}
