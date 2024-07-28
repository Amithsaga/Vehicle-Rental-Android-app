/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.UUID
 */
package com.example.interphase.data;

import com.example.interphase.data.Result;
import com.example.interphase.data.model.LoggedInUser;
import java.io.IOException;
import java.util.UUID;

public class LoginDataSource {
    public Result<LoggedInUser> login(String success, String string2) {
        try {
            success = new Result.Success<Object>(UUID.randomUUID().toString(), "Jane Doe");
            success = new Result.Success<Object>(success);
            return success;
        }
        catch (Exception exception) {
            return new Result.Error((Exception)new IOException("Error logging in", (Throwable)exception));
        }
    }

    public void logout() {
    }
}

