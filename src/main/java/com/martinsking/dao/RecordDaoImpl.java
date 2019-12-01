package com.martinsking.dao;

import com.martinsking.dao.RecordDao;
import com.martinsking.dto.RecordDto;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly =  true)
public class RecordDaoImpl implements RecordDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<RecordDto> getAllRecords() {
        Session session = sessionFactory.openSession();
        String hql = "FROM RecordDto";
        Query query = session.createQuery(hql);
        List<RecordDto> records= query.list();
        return records;
    }

    @Override
    @Transactional(readOnly = false)
    public void insertRecord(RecordDto record) {
        Session session = sessionFactory.openSession();
        session.save(record);
    }
}
