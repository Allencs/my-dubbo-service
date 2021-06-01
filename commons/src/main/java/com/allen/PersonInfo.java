package com.allen;

public class PersonInfo {

    private String name;
    private String job;
    private String company;
    private String message;
    private Integer code;
    private String protocol;

    public String getProtocol() {
        return protocol;
    }
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String messjob) {
        this.message = messjob;
    }

//    @Override
//    public String toString() {
//        return "PersonInfo{" +
//                "name='" + name + '\'' +
//                ", job='" + job + '\'' +
//                ", company='" + company + '\'' +
//                ", message='" + message + '\'' +
//                ", code=" + code +
//                ", protocol='" + protocol + '\'' +
//                '}';
//    }
}
