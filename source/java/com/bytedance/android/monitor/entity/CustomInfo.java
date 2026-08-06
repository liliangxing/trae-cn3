package com.bytedance.android.monitor.entity;

import com.bytedance.android.monitor.HybridMonitor;
import com.bytedance.android.monitor.webview.ITTLiveWebViewMonitor;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class CustomInfo {
    private String biz;
    private JSONObject category;
    private JSONObject common;
    private String eventName;
    private JSONObject extra;
    private boolean isSample;
    private JSONObject metric;
    private ITTLiveWebViewMonitor monitor;
    private JSONObject timing;
    private String url;
    private String vid;

    private CustomInfo() {
    }

    public String getUrl() {
        return this.url;
    }

    public String getBiz() {
        return this.biz;
    }

    public String getEventName() {
        return this.eventName;
    }

    public JSONObject getCategory() {
        return this.category;
    }

    public JSONObject getMetric() {
        return this.metric;
    }

    public JSONObject getExtra() {
        return this.extra;
    }

    public JSONObject getTiming() {
        return this.timing;
    }

    public JSONObject getCommon() {
        return this.common;
    }

    public String getVid() {
        return this.vid;
    }

    public boolean isSample() {
        return this.isSample;
    }

    public ITTLiveWebViewMonitor getMonitor() {
        return this.monitor;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setBiz(String str) {
        this.biz = str;
    }

    public void setVid(String str) {
        this.vid = str;
    }

    public void setMonitor(ITTLiveWebViewMonitor iTTLiveWebViewMonitor) {
        this.monitor = iTTLiveWebViewMonitor;
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        private String biz;
        private JSONObject category;
        private JSONObject common;
        private String eventName;
        private JSONObject extra;
        private boolean isSample;
        private JSONObject metric;
        private ITTLiveWebViewMonitor monitor;
        private JSONObject timing;
        private String url;
        private String vid;

        public Builder(String str) {
            this.eventName = str;
        }

        public Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        public Builder setBiz(String str) {
            this.biz = str;
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

        public Builder setExtra(JSONObject jSONObject) {
            this.extra = jSONObject;
            return this;
        }

        public Builder setTiming(JSONObject jSONObject) {
            this.timing = jSONObject;
            return this;
        }

        public Builder setCommon(JSONObject jSONObject) {
            this.common = jSONObject;
            return this;
        }

        public Builder setVirtualAID(String str) {
            this.vid = str;
            return this;
        }

        public Builder setEnableSample(boolean z) {
            this.isSample = z;
            return this;
        }

        public Builder setMonitor(ITTLiveWebViewMonitor iTTLiveWebViewMonitor) {
            this.monitor = iTTLiveWebViewMonitor;
            return this;
        }

        public CustomInfo build() {
            CustomInfo customInfo = new CustomInfo();
            customInfo.eventName = this.eventName;
            customInfo.url = this.url;
            customInfo.biz = this.biz;
            customInfo.category = this.category;
            customInfo.metric = this.metric;
            JSONObject jSONObject = this.extra;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            customInfo.extra = jSONObject;
            customInfo.timing = this.timing;
            JSONObject jSONObject2 = this.common;
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            customInfo.common = jSONObject2;
            customInfo.isSample = this.isSample;
            customInfo.vid = this.vid;
            ITTLiveWebViewMonitor iTTLiveWebViewMonitor = this.monitor;
            if (iTTLiveWebViewMonitor == null) {
                iTTLiveWebViewMonitor = HybridMonitor.getInstance().getCustomReportMonitor();
            }
            customInfo.monitor = iTTLiveWebViewMonitor;
            return customInfo;
        }
    }
}
