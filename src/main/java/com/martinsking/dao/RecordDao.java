package com.martinsking.dao;
import com.martinsking.dto.RecordDto;

import java.util.List;

public interface RecordDao {

    public List<RecordDto> getAllRecords();

    public void insertRecord (RecordDto recordDto);
}

