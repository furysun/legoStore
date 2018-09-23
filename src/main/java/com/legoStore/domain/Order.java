package com.legoStore.domain;

public class Order {
    private long id;
    private String address;
    private boolean completed;
    private long clientId;

    public Order(long id, String adress, boolean completed, long clientId) {
        this.id = id;
        this.address = adress;
        this.completed = completed;
        this.clientId = clientId;
    }

    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }
}
