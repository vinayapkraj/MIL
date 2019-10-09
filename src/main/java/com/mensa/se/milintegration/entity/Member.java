package com.mensa.se.milintegration.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="Member")
@JacksonXmlRootElement(localName = "response")
public class Member {
    @JacksonXmlProperty
    private String firstName;
    @JacksonXmlProperty
    private String lastName;
    @JacksonXmlProperty
    private String password;
    @JacksonXmlProperty
    private Date expiryDate;
    @JacksonXmlProperty
    @Id
    private String memNumber;

    public Member(String firstName, String lastName, String password, Date expiryDate, String memNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.expiryDate = expiryDate;
        this.memNumber = memNumber;
    }

    public Member() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return getFirstName().equals(member.getFirstName()) &&
                getLastName().equals(member.getLastName()) &&
                getPassword().equals(member.getPassword()) &&
                getExpiryDate().equals(member.getExpiryDate()) &&
                getMemNumber().equals(member.getMemNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getPassword(), getExpiryDate(), getMemNumber());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getMemNumber() {
        return memNumber;
    }

    public void setMemNumber(String memNumber) {
        this.memNumber = memNumber;
    }
}
