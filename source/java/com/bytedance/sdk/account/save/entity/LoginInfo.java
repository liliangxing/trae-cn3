package com.bytedance.sdk.account.save.entity;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class LoginInfo {
    private String avatarUrl;
    private Ext ext;
    private String info;
    private String platformAvatarUrl;
    private String platformScreenName;
    private String screenName;
    private String secUid;
    private long time;
    private int type;
    private long uid;

    public LoginInfo(long j, int i, String str, long j2, String str2, String str3, String str4, String str5, String str6, Ext ext) {
        this.time = j;
        this.type = i;
        this.info = str;
        this.uid = j2;
        this.secUid = str2;
        this.avatarUrl = str3;
        this.screenName = str4;
        this.platformAvatarUrl = str5;
        this.platformScreenName = str6;
        this.ext = ext;
    }

    public long getTime() {
        return this.time;
    }

    public int getType() {
        return this.type;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String str) {
        this.info = str;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setType(int i) {
        this.type = i;
    }

    public long getUid() {
        return this.uid;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public String getScreenName() {
        return this.screenName;
    }

    public void setScreenName(String str) {
        this.screenName = str;
    }

    public String getPlatformAvatarUrl() {
        return this.platformAvatarUrl;
    }

    public void setPlatformAvatarUrl(String str) {
        this.platformAvatarUrl = str;
    }

    public String getPlatformScreenName() {
        return this.platformScreenName;
    }

    public void setPlatformScreenName(String str) {
        this.platformScreenName = str;
    }

    public String getSecUid() {
        return this.secUid;
    }

    public void setSecUid(String str) {
        this.secUid = str;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext ext) {
        this.ext = ext;
    }

    public Integer getCountryCode() {
        Ext ext = this.ext;
        if (ext != null) {
            return ext.getCountryCode();
        }
        return null;
    }

    public void setCountryCode(Integer num) {
        if (this.ext == null) {
            this.ext = new Ext();
        }
        this.ext.setCountryCode(num);
    }

    /* loaded from: classes5.dex */
    public static class Builder {
        private String avatarUrl;
        private Ext ext;
        private String info;
        private String platformAvatarUrl;
        private String platformScreenName;
        private String screenName;
        private String secUid;
        private long time;
        private int type;
        private long uid;

        public Builder withTime(long j) {
            this.time = j;
            return this;
        }

        public Builder withType(int i) {
            this.type = i;
            return this;
        }

        public Builder withInfo(String str) {
            this.info = str;
            return this;
        }

        public Builder withUid(long j) {
            this.uid = j;
            return this;
        }

        public Builder withAvatarUrl(String str) {
            this.avatarUrl = str;
            return this;
        }

        public Builder withSecUid(String str) {
            this.secUid = str;
            return this;
        }

        public Builder withScreenName(String str) {
            this.screenName = str;
            return this;
        }

        public Builder withPlatformAvatarUrl(String str) {
            this.platformAvatarUrl = str;
            return this;
        }

        public Builder withPlatformScreenName(String str) {
            this.platformScreenName = str;
            return this;
        }

        public Builder withExt(Ext ext) {
            this.ext = ext;
            return this;
        }

        public Builder withCountryCode(Integer num) {
            if (this.ext == null) {
                this.ext = new Ext();
            }
            this.ext.setCountryCode(num);
            return this;
        }

        public LoginInfo build() {
            return new LoginInfo(this.time, this.type, this.info, this.uid, this.secUid, this.avatarUrl, this.screenName, this.platformAvatarUrl, this.platformScreenName, this.ext);
        }
    }

    public String toString() {
        return "LoginInfo{time=" + this.time + "\n, type=" + this.type + "\n, info='" + this.info + "'\n, uid=" + this.uid + "\n, secUid='" + this.secUid + "'\n, avatarUrl='" + this.avatarUrl + "'\n, screenName='" + this.screenName + "'\n, platformAvatarUrl='" + this.platformAvatarUrl + "'\n, platformScreenName='" + this.platformScreenName + "'\n, ext=" + this.ext + AbstractJsonLexerKt.END_OBJ;
    }
}
