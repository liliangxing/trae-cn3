package com.ss.ttm.utils;

/* loaded from: classes7.dex */
public class UserConfig extends ReuseConfig {
    public UserConfig() {
        super(null, 0);
    }

    private UserConfig(UserConfig user) {
        super(user, 1);
    }

    public UserConfig copy() {
        return new UserConfig(this);
    }
}
