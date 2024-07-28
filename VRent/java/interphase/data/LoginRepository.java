/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.example.interphase.data;

import com.example.interphase.data.LoginDataSource;
import com.example.interphase.data.Result;
import com.example.interphase.data.model.LoggedInUser;

public class LoginRepository {
    private static volatile LoginRepository instance;
    private LoginDataSource dataSource;
    private LoggedInUser user = null;

    private LoginRepository(LoginDataSource loginDataSource) {
        this.dataSource = loginDataSource;
    }

    public static LoginRepository getInstance(LoginDataSource loginDataSource) {
        if (instance == null) {
            instance = new LoginRepository(loginDataSource);
        }
        return instance;
    }

    private void setLoggedInUser(LoggedInUser loggedInUser) {
        this.user = loggedInUser;
    }

    public boolean isLoggedIn() {
        boolean bl = this.user != null;
        return bl;
    }

    public Result<LoggedInUser> login(String object, String string2) {
        if ((object = this.dataSource.login((String)object, string2)) instanceof Result.Success) {
            this.setLoggedInUser((LoggedInUser)((Result.Success)object).getData());
        }
        return object;
    }

    public void logout() {
        this.user = null;
        this.dataSource.logout();
    }
}

