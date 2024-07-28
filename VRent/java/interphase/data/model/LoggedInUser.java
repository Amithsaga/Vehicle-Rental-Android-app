/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.example.interphase.data.model;

public class LoggedInUser {
    private String displayName;
    private String userId;

    public LoggedInUser(String string2, String string3) {
        this.userId = string2;
        this.displayName = string3;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getUserId() {
        return this.userId;
    }
}

