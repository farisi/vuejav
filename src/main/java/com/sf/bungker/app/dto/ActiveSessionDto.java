package com.sf.bungker.app.dto;

import java.util.Date;

public class ActiveSessionDto {
    private String username;
    private Date lastRequest;
    private String sessionId;
    private boolean expired = false;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Date getLastRequest() {
        return lastRequest;
    }
    public void setLastRequest(Date lastRequest) {
        this.lastRequest = lastRequest;
    }
    public String getSessionId() {
        return sessionId;
    }
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    public boolean isExpired() {
        return expired;
    }
    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    
}
