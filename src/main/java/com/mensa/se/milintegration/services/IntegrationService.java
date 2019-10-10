package com.mensa.se.milintegration.services;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.mensa.se.milintegration.entity.Member;
import com.mensa.se.milintegration.entity.Request;
import com.mensa.se.milintegration.repository.IntegrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class IntegrationService {
    @Autowired
    private IntegrationRepo integrationRepo;
    private Member response = new Member();

    @EventListener({ApplicationReadyEvent.class})
    public void init() {
        System.out.println("Init Started");
        this.integrationRepo.save(new Member("12345", "abc", "suc", new Date("12/10/2019"),"M76899"));
        this.integrationRepo.save(new Member("13452", "cat", "dog", new Date("12/10/2021"),"M56418"));
        this.integrationRepo.save(new Member("23451", "me", "mig", new Date("12/10/2040"),"M45367"));
        this.integrationRepo.save(new Member("23145", "you", "du", new Date("12/10/2030"),"M56392"));
        this.integrationRepo.save(new Member("211345", "we", "vi", new Date("12/10/2024"),"M12897"));
        this.integrationRepo.save(new Member("123145", "your", "ni", new Date("12/10/2025"),"M23451"));
        this.integrationRepo.save(new Member("123415", "kdasd", "hjis", new Date("12/10/2026"),"M19087"));
        this.integrationRepo.save(new Member("1234511", "sdas", "ioppo", new Date("12/10/2022"),"M90876"));
    }

    public String getExpiryDate(Request req){
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            Member tempMem = integrationRepo.findByMemNumber(req.getMem_number());
            if(tempMem!=null) {
                response.setExpiryDate(tempMem.getExpiryDate());
                response.setFirstName(tempMem.getFirstName());
               // response.setLastName(null);
               // response.setMemNumber(null);
            }
            return xmlMapper.writeValueAsString(response);
           // return response;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
