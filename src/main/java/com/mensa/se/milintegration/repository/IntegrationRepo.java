package com.mensa.se.milintegration.repository;

import com.mensa.se.milintegration.entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntegrationRepo extends CrudRepository<Member, String> {
    public Member findByMemNumber(String mem_pass);
}
