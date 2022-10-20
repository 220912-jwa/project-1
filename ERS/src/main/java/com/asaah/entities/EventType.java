package com.asaah.entities;

public enum EventType {

    UNIVERSITYCOURSES(1),
    SEMINARS(2),
    CERTIFICATIONPREPARATION(3),
    CERTICATION(4),
    TECHNICALTRAINING(5),
    OTHER(6);


    private int id;

    private EventType(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;

    }

    public int getReimbursementValue() {
        return this.getReimbursementValue();
    }
}