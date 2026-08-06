package com.bytedance.android.monitorV2.entity;

import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.webview.IHybridMonitor;
import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class CustomInfo {
    private String bid;
    private int canSample;
    private JSONObject category;
    private JSONObject common;
    private String eventName;
    private JSONObject extra;
    private JSONObject metric;

    @Deprecated
    private IHybridMonitor monitor;
    private String monitorId;
    private Map<String, Object> tagsMap;
    private JSONObject timing;
    private String url;
    private String vid;

    private CustomInfo() {
        this.tagsMap = new HashMap();
    }

    public String getUrl() {
        return this.url;
    }

    public String getBid() {
        return this.bid;
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

    public int getCanSample() {
        return this.canSample;
    }

    public Map<String, Object> getTags() {
        return this.tagsMap;
    }

    public void addTag(String str, Object obj) {
        this.tagsMap.put(str, obj);
    }

    @Deprecated
    public IHybridMonitor getMonitor() {
        return this.monitor;
    }

    public String getMonitorId() {
        return this.monitorId;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setBid(String str) {
        this.bid = str;
    }

    public void setVid(String str) {
        this.vid = str;
    }

    @Deprecated
    public void setMonitor(IHybridMonitor iHybridMonitor) {
        this.monitor = iHybridMonitor;
    }

    public void setMonitorId(String str) {
        this.monitorId = str;
    }

    public String toString() {
        return "CustomInfo{url='" + this.url + "', bid='" + this.bid + "', eventName='" + this.eventName + "', vid='" + this.vid + "', canSample=" + this.canSample + ", monitorId=" + this.monitorId + AbstractJsonLexerKt.END_OBJ;
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        private String bid;
        private JSONObject bidInfo;
        private int canSample;
        private JSONObject category;
        private JSONObject common;
        private String eventName;
        private JSONObject extra;
        private JSONObject metric;
        private IHybridMonitor monitor;
        private String monitorId;
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

        public Builder setBid(String str) {
            this.bid = str;
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

        public Builder setBidInfo(JSONObject jSONObject) {
            this.bidInfo = jSONObject;
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

        public Builder setSample(int i) {
            if (i < 0 || i > 8) {
                i = 8;
            }
            this.canSample = i;
            return this;
        }

        @Deprecated
        public Builder setMonitor(IHybridMonitor iHybridMonitor) {
            this.monitor = iHybridMonitor;
            return this;
        }

        public Builder setMonitorId(String str) {
            this.monitorId = str;
            return this;
        }

        public CustomInfo build() {
            CustomInfo customInfo = new CustomInfo();
            customInfo.eventName = this.eventName;
            String str = this.url;
            if (str == null) {
                str = "";
            }
            customInfo.url = str;
            String str2 = this.bid;
            customInfo.bid = str2 != null ? str2 : "";
            JSONObject jSONObject = this.category;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            customInfo.category = jSONObject;
            JSONObject jSONObject2 = this.metric;
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            customInfo.metric = jSONObject2;
            JSONObject jSONObject3 = this.extra;
            if (jSONObject3 == null) {
                jSONObject3 = new JSONObject();
            }
            customInfo.extra = jSONObject3;
            customInfo.canSample = this.canSample;
            JSONObject jSONObject4 = this.timing;
            if (jSONObject4 == null) {
                jSONObject4 = new JSONObject();
            }
            this.timing = jSONObject4;
            customInfo.timing = jSONObject4;
            JSONObject jSONObject5 = this.common;
            if (jSONObject5 == null) {
                jSONObject5 = new JSONObject();
            }
            customInfo.common = jSONObject5;
            customInfo.vid = this.vid;
            customInfo.monitorId = this.monitorId;
            IHybridMonitor iHybridMonitor = this.monitor;
            if (iHybridMonitor == null) {
                iHybridMonitor = HybridMultiMonitor.getInstance().getCustomReportMonitor();
            }
            customInfo.monitor = iHybridMonitor;
            return customInfo;
        }
    }
}
