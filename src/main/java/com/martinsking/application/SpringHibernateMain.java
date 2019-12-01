package com.martinsking.application;

import com.martinsking.dto.RecordDto;
import com.martinsking.service.RecordService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHibernateMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/context.xml");
        RecordService recordService = context.getBean("recordServiceImpl", RecordService.class);

        RecordDto record = new RecordDto();
        record.setName("Queen Greates hits 2");
        recordService.insertRecord(record);
        record.setName("Areosmith Big Ones");
        recordService.insertRecord(record);

        for (RecordDto rec : recordService.getAllRecords()) {
            System.out.println(rec);
        }
    }
}
