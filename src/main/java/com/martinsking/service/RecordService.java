package com.martinsking.service;

import com.martinsking.dto.RecordDto;

import java.util.List;

public interface RecordService {

    public List<RecordDto> getAllRecords();

    public void insertRecord(RecordDto record);
}
