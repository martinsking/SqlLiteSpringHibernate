package com.martinsking.service;

import com.martinsking.dao.RecordDao;
import com.martinsking.dto.RecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordDao recordDao;

    @Override
    public List<RecordDto> getAllRecords() {
        List<RecordDto> records = recordDao.getAllRecords();
        return records;
    }

    @Override
    public void insertRecord(RecordDto record) {
        recordDao.insertRecord(record);
    }
}
