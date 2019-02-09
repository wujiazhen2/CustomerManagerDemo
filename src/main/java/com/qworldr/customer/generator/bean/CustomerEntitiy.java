package com.qworldr.customer.generator.bean;

import java.io.Serializable;

public class CustomerEntitiy implements Serializable {
    private Integer id;

    private String name;

    private String phone;

    private String description;

    private String address;

    private Boolean deleteflag;

    private Integer deletetime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(Boolean deleteflag) {
        this.deleteflag = deleteflag;
    }

    public Integer getDeletetime() {
        return deletetime;
    }

    public void setDeletetime(Integer deletetime) {
        this.deletetime = deletetime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", description=").append(description);
        sb.append(", address=").append(address);
        sb.append(", deleteflag=").append(deleteflag);
        sb.append(", deletetime=").append(deletetime);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CustomerEntitiy other = (CustomerEntitiy) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getDeleteflag() == null ? other.getDeleteflag() == null : this.getDeleteflag().equals(other.getDeleteflag()))
            && (this.getDeletetime() == null ? other.getDeletetime() == null : this.getDeletetime().equals(other.getDeletetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getDeleteflag() == null) ? 0 : getDeleteflag().hashCode());
        result = prime * result + ((getDeletetime() == null) ? 0 : getDeletetime().hashCode());
        return result;
    }
}