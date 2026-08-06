package com.bytedance.services.apm.api;

import org.json.JSONObject;

/* loaded from: classes5.dex */
public class EventConfig {
    private JSONObject category;
    private JSONObject extraLog;
    private boolean isUploadImmediate;
    private JSONObject metric;
    private String serviceName;
    private int status;

    public String getServiceName() {
        return this.serviceName;
    }

    public JSONObject getCategory() {
        return this.category;
    }

    public JSONObject getMetric() {
        return this.metric;
    }

    public int getStatus() {
        return this.status;
    }

    public JSONObject getExtraLog() {
        return this.extraLog;
    }

    public boolean isUploadImmediate() {
        return this.isUploadImmediate;
    }

    public static Builder builder() {
        return new Builder();
    }

    public EventConfig(Builder builder) {
        this.serviceName = builder.serviceName;
        this.status = builder.status;
        this.category = builder.category;
        this.metric = builder.metric;
        this.extraLog = builder.extraLog;
        this.isUploadImmediate = builder.isUploadImmediate;
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        private JSONObject category;
        private JSONObject extraLog;
        private boolean isUploadImmediate;
        private JSONObject metric;
        private String serviceName;
        private int status;

        private Builder() {
        }

        public Builder setServiceName(String str) {
            this.serviceName = str;
            return this;
        }

        public Builder setStatus(int i) {
            this.status = i;
            return this;
        }

        public Builder setCategory(JSONObject jSONObject) {
            this.category = jSONObject;
            return this;
        }

        public Builder setMetric(JSONObject jSONObject) {
            this.metric = jSONObject;
            return this;
        }

        public Builder setExtraLog(JSONObject jSONObject) {
            this.extraLog = jSONObject;
            return this;
        }

        public Builder isUploadImmediate(boolean z) {
            this.isUploadImmediate = z;
            return this;
        }

        public EventConfig build() {
            return new EventConfig(this);
        }
    }
}
