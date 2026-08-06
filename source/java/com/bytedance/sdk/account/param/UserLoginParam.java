package com.bytedance.sdk.account.param;

import java.util.Map;

/* loaded from: classes5.dex */
public class UserLoginParam {
    public final String account;
    public final String email;
    public final Map<String, String> extraInfo;
    public final String mobile;
    public final String password;
    public final int scene;
    public final String token;
    public final String username;

    private UserLoginParam(Builder builder) {
        this.email = builder.email;
        this.mobile = builder.mobile;
        this.username = builder.username;
        this.account = builder.account;
        this.token = builder.token;
        this.scene = builder.scene;
        this.password = builder.password;
        this.extraInfo = builder.extraInfo;
    }

    /* loaded from: classes5.dex */
    public static class Builder {
        private String account;
        private String email;
        private Map<String, String> extraInfo;
        private String mobile;
        private String password;
        private int scene;
        private String token;
        private String username;

        public Builder setEmail(String str) {
            this.email = str;
            return this;
        }

        public Builder setMobile(String str) {
            this.mobile = str;
            return this;
        }

        public Builder setUsername(String str) {
            this.username = str;
            return this;
        }

        public Builder setAccount(String str) {
            this.account = str;
            return this;
        }

        public Builder setToken(String str) {
            this.token = str;
            return this;
        }

        public Builder setScene(int i) {
            this.scene = i;
            return this;
        }

        public Builder setPassword(String str) {
            this.password = str;
            return this;
        }

        public Builder setExtraInfo(Map<String, String> map) {
            this.extraInfo = map;
            return this;
        }

        public UserLoginParam build() {
            return new UserLoginParam(this);
        }
    }
}
