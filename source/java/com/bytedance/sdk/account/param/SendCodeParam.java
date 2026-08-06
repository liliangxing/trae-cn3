package com.bytedance.sdk.account.param;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class SendCodeParam {
    private static boolean is6Digits;
    public final String authToken;
    public final boolean autoRead;
    public final String captcha;
    public final int checkRegister;
    public final Map<String, String> extraInfo;
    public final String mobile;
    public final String oldMobile;
    public final String sharkTicket;
    public final String ticket;
    public final int type;
    public final boolean unbindExist;
    public final String unusableMobileTicket;

    public static void setIs6Digits(boolean z) {
        is6Digits = z;
    }

    private SendCodeParam(Builder builder) {
        this.mobile = builder.mobile;
        this.oldMobile = builder.oldMobile;
        this.type = builder.type;
        this.captcha = builder.captcha;
        this.unbindExist = builder.unbindExist;
        this.checkRegister = builder.checkRegister;
        this.ticket = builder.ticket;
        this.autoRead = builder.autoRead;
        this.sharkTicket = builder.sharkTicket;
        this.authToken = builder.authToken;
        this.unusableMobileTicket = builder.unusableMobileTicket;
        if (is6Digits) {
            if (builder.extraInfo == null) {
                this.extraInfo = new HashMap();
            } else {
                this.extraInfo = builder.extraInfo;
            }
            this.extraInfo.put("is6Digits", "1");
            return;
        }
        this.extraInfo = builder.extraInfo;
    }

    public static SendCodeParam getLoginParam(String str) {
        return new Builder(str, 24).build();
    }

    public static SendCodeParam getBindParam(String str) {
        return new Builder(str, 8).build();
    }

    /* loaded from: classes5.dex */
    public static class Builder {
        private String authToken;
        private boolean autoRead;
        private String captcha;
        private int checkRegister = -1;
        private Map<String, String> extraInfo;
        private final String mobile;
        private String oldMobile;
        private String sharkTicket;
        private String ticket;
        private final int type;
        private boolean unbindExist;
        private String unusableMobileTicket;

        public Builder(String str, int i) {
            this.mobile = str;
            this.type = i;
        }

        public Builder setOldMobile(String str) {
            this.oldMobile = str;
            return this;
        }

        public Builder setCaptcha(String str) {
            this.captcha = str;
            return this;
        }

        public Builder setUnbindExist(boolean z) {
            this.unbindExist = z;
            return this;
        }

        public Builder setCheckRegister(int i) {
            this.checkRegister = i;
            return this;
        }

        public Builder setTicket(String str) {
            this.ticket = str;
            return this;
        }

        public Builder setAutoRead(boolean z) {
            this.autoRead = z;
            return this;
        }

        public Builder setSharkTicket(String str) {
            this.sharkTicket = str;
            return this;
        }

        public Builder setAuthToken(String str) {
            this.authToken = str;
            return this;
        }

        public Builder setUnusableMobileTicket(String str) {
            this.unusableMobileTicket = str;
            return this;
        }

        public Builder setExtraInfo(Map<String, String> map) {
            this.extraInfo = map;
            return this;
        }

        public SendCodeParam build() {
            return new SendCodeParam(this);
        }
    }
}
