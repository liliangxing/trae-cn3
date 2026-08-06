package com.bytedance.webx.seclink.request;

import java.util.Map;

/* loaded from: classes6.dex */
public class CheckUrlTask {
    private String aid;
    private String bizTag;
    private CheckUrlCallback callback;
    private Map<String, Object> extraInfo;
    private int grade;
    private String lang;
    private String salt = "seclink_verify";
    private String scene;
    private String target;
    private long ts;
    private boolean useBizConfig;

    public String getAid() {
        return this.aid;
    }

    public String getScene() {
        return this.scene;
    }

    public String getTarget() {
        return this.target;
    }

    public long getTs() {
        return this.ts;
    }

    public String getSalt() {
        return this.salt;
    }

    public String getLang() {
        return this.lang;
    }

    public CheckUrlCallback getCallback() {
        return this.callback;
    }

    public boolean useBizConfig() {
        return this.useBizConfig;
    }

    public int getGrade() {
        return this.grade;
    }

    public Map<String, Object> getExtraInfo() {
        return this.extraInfo;
    }

    public void setExtraInfo(Map<String, Object> map) {
        this.extraInfo = map;
    }

    public String getBizTag() {
        return this.bizTag;
    }

    public void setBizTag(String str) {
        this.bizTag = str;
    }

    /* loaded from: classes6.dex */
    public static class Builder {
        private String aid;
        private String bizTag;
        private CheckUrlCallback callback;
        private Map<String, Object> extraInfo;
        private int grade;
        private String lang;
        private String scene;
        private String target;
        private boolean useBizConfig;

        public Builder setAid(String str) {
            this.aid = str;
            return this;
        }

        public Builder setScene(String str) {
            this.scene = str;
            return this;
        }

        public Builder setTarget(String str) {
            this.target = str;
            return this;
        }

        public Builder setLanguage(String str) {
            this.lang = str;
            return this;
        }

        public Builder setCallback(CheckUrlCallback checkUrlCallback) {
            this.callback = checkUrlCallback;
            return this;
        }

        public Builder setGrade(int i) {
            this.grade = i;
            return this;
        }

        public Builder useBizConfig(boolean z) {
            this.useBizConfig = z;
            return this;
        }

        public Builder extraInfo(Map<String, Object> map) {
            this.extraInfo = map;
            return this;
        }

        public Builder bizTag(String str) {
            this.bizTag = str;
            return this;
        }

        public CheckUrlTask build() {
            CheckUrlTask checkUrlTask = new CheckUrlTask();
            checkUrlTask.aid = this.aid;
            checkUrlTask.scene = this.scene;
            checkUrlTask.target = this.target;
            checkUrlTask.ts = System.currentTimeMillis() / 1000;
            checkUrlTask.lang = this.lang;
            checkUrlTask.callback = this.callback;
            checkUrlTask.grade = this.grade;
            checkUrlTask.useBizConfig = this.useBizConfig;
            checkUrlTask.extraInfo = this.extraInfo;
            checkUrlTask.bizTag = this.bizTag;
            return checkUrlTask;
        }
    }
}
