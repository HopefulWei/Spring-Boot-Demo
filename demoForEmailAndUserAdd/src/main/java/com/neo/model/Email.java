package com.neo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Email {

    private String recipient;
    private String EmailTilte;
    private String EmailContext;
    private String path;
    private String rcsID;

    public String getRecipient() {
        return recipient;
    }

    public Email setRecipient(String recipient) {
        this.recipient = recipient;
        return this;
    }

    public String getEmailTilte() {
        return EmailTilte;
    }

    public Email setEmailTilte(String EmailTilte) {
        this.EmailTilte = EmailTilte;
        return this;
    }

    public String getEmailContext() {
        return EmailContext;
    }

    public Email setEmailContext(String EmailContext) {
        this.EmailContext = EmailContext;
        return this;
    }

    public String getEmailPath() {
        return path;
    }

    public Email setEmailPath(String EmailPath) {
        this.path = EmailPath;
        return this;
    }

    public String getEmailRcsID() {
        return rcsID;
    }

    public Email setEmailRcsID(String rcsID) {
        this.rcsID = rcsID;
        return this;
    }



}