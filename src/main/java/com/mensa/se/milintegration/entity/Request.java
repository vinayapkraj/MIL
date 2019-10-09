package com.mensa.se.milintegration.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Objects;

@JacksonXmlRootElement(localName="request")
public class Request {
    @JacksonXmlProperty(isAttribute = true)
    private String id;
    @JacksonXmlProperty(isAttribute = true)
    private String type;
    @JacksonXmlProperty
    private String mem_number;
    @JacksonXmlProperty
    private String mem_fname;
    @JacksonXmlProperty
    private String mem_lname;
    @JacksonXmlProperty
    private String mem_pass;

    public Request(String id, String type, String mem_number, String mem_fname, String mem_lname, String mem_pass) {
        this.id = id;
        this.type = type;
        this.mem_number = mem_number;
        this.mem_fname = mem_fname;
        this.mem_lname = mem_lname;
        this.mem_pass = mem_pass;
    }

    public Request() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMem_number() {
        return mem_number;
    }

    public void setMem_number(String mem_number) {
        this.mem_number = mem_number;
    }

    public String getMem_fname() {
        return mem_fname;
    }

    public void setMem_fname(String mem_fname) {
        this.mem_fname = mem_fname;
    }

    public String getMem_lname() {
        return mem_lname;
    }

    public void setMem_lname(String mem_lname) {
        this.mem_lname = mem_lname;
    }

    public String getMem_pass() {
        return mem_pass;
    }

    public void setMem_pass(String mem_pass) {
        this.mem_pass = mem_pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return getId().equals(request.getId()) &&
                getType().equals(request.getType()) &&
                getMem_number().equals(request.getMem_number()) &&
                getMem_fname().equals(request.getMem_fname()) &&
                getMem_lname().equals(request.getMem_lname()) &&
                getMem_pass().equals(request.getMem_pass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getType(), getMem_number(), getMem_fname(), getMem_lname(), getMem_pass());
    }
}
