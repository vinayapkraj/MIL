package com.mensa.se.milintegration.repository;
import com.mensa.se.milintegration.entity.Member;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class IntegrationRepoTest {
    @Autowired
    private IntegrationRepo integrationRepo;

    public IntegrationRepoTest() {
    }

    @Test
    public void findByMemPass() {
        this.integrationRepo.save(new Member("12345", "abc", "suc", new Date("12/10/2019"),"M76899"));
        Member testMem = new Member("12345", "abc", "suc", new Date("12/10/2019"),"M76899");
        Member memDB = this.integrationRepo.findByMemNumber("M76899");
        Assert.assertEquals(memDB, testMem);
    }
}
