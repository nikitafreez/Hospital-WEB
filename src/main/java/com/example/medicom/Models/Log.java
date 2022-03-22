package com.example.medicom.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logText;

    @ManyToOne(optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    private User user_;

    private Date logDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogText() {
        return logText;
    }

    public void setLogText(String logText) {
        this.logText = logText;
    }

    public User getUser_() {
        return user_;
    }

    public void setUser_(User user_) {
        this.user_ = user_;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public Log(String logText, User user_, Date logDate) {
        this.logText = logText;
        this.user_ = user_;
        this.logDate = logDate;
    }

    public Log() {
    }
}
