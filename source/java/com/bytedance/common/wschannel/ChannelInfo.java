package com.bytedance.common.wschannel;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.wschannel.server.FrontierMessageManager;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class ChannelInfo {
    int aid;
    String appKey;
    final int channelId;
    String deviceId;
    boolean disableFallbackWs;
    Map<String, String> extra;
    int fpid;
    Map<String, String> headers;
    String installId;
    boolean privateProtocolEnabled;
    String privateProtocolUrl;
    List<Integer> serviceIdList;
    TransportMode transportMode;
    int updateVersionCode;
    List<String> urls;

    public ChannelInfo(int i, int i2, int i3, String str, int i4, String str2, String str3, List<String> list, Map<String, String> map, boolean z, List<Integer> list2, String str4, TransportMode transportMode, boolean z2, Builder builder) {
        this.extra = new HashMap();
        this.headers = new HashMap();
        this.urls = new ArrayList();
        this.serviceIdList = new ArrayList();
        this.channelId = i4;
        this.deviceId = str2;
        this.installId = str3;
        this.updateVersionCode = i3;
        if (list != null) {
            this.urls.addAll(list);
        }
        if (map != null) {
            this.extra.putAll(map);
        }
        if (builder.headers != null) {
            this.headers.putAll(builder.headers);
        }
        if (FrontierMessageManager.isQos2Enabled()) {
            this.headers.put("x-support-qos2", "1");
        }
        this.fpid = i;
        this.aid = i2;
        this.appKey = str;
        this.serviceIdList = list2;
        this.privateProtocolEnabled = z;
        this.privateProtocolUrl = str4;
        this.transportMode = transportMode;
        if (TextUtils.isEmpty(str4)) {
            this.privateProtocolEnabled = false;
        }
        this.disableFallbackWs = z2;
    }

    public ChannelInfo(ChannelInfo channelInfo) {
        this.extra = new HashMap();
        this.headers = new HashMap();
        this.urls = new ArrayList();
        this.serviceIdList = new ArrayList();
        this.channelId = channelInfo.channelId;
        this.deviceId = channelInfo.deviceId;
        this.installId = channelInfo.installId;
        List<String> list = channelInfo.urls;
        if (list != null) {
            this.urls.addAll(list);
        }
        Map<String, String> map = channelInfo.extra;
        if (map != null) {
            this.extra.putAll(map);
        }
        Map<String, String> map2 = channelInfo.headers;
        if (map2 != null) {
            this.headers.putAll(map2);
        }
        this.fpid = channelInfo.fpid;
        this.aid = channelInfo.aid;
        this.appKey = channelInfo.appKey;
        this.updateVersionCode = channelInfo.updateVersionCode;
        this.privateProtocolEnabled = channelInfo.privateProtocolEnabled;
        this.transportMode = channelInfo.transportMode;
        this.privateProtocolUrl = channelInfo.privateProtocolUrl;
        List<Integer> list2 = channelInfo.serviceIdList;
        if (list2 != null) {
            this.serviceIdList.addAll(list2);
        }
        this.disableFallbackWs = channelInfo.disableFallbackWs;
    }

    public String toString() {
        return "ChannelInfo{channelId = " + this.channelId + ", deviceId = " + this.deviceId + ", installId = " + this.installId + ", fpid = " + this.fpid + ", aid = " + this.aid + ", updateVersionCode = " + this.updateVersionCode + ", appKey = " + this.appKey + ", header = " + this.headers + ", extra = " + this.extra + ", urls = " + this.urls + "}";
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        private int aid;
        private int appVersion;
        private String appkey;
        private final int channelId;
        private String deviceId;
        boolean disableFallbackWS;
        private int fpid;
        private String installId;
        boolean privateProtocolEnabled;
        String privateProtocolUrl;
        Map<String, String> extra = new HashMap();
        Map<String, String> headers = new HashMap();
        List<String> urls = new ArrayList();
        List<Integer> serviceIdList = new ArrayList();
        TransportMode transportMode = TransportMode.TUDP;

        Builder(int i) {
            this.channelId = i;
        }

        public static Builder create(int i) {
            return new Builder(i);
        }

        public Builder setFPID(int i) {
            this.fpid = i;
            return this;
        }

        public Builder setAid(int i) {
            this.aid = i;
            return this;
        }

        public Builder setAppVersion(int i) {
            this.appVersion = i;
            return this;
        }

        public Builder setAppKey(String str) {
            this.appkey = str;
            return this;
        }

        public Builder setDeviceId(String str) {
            this.deviceId = str;
            return this;
        }

        public Builder setInstallId(String str) {
            this.installId = str;
            return this;
        }

        public Builder extra(String str, String str2) {
            if (!StringUtils.isEmpty(str)) {
                this.extra.put(str, str2);
            }
            return this;
        }

        public Builder extras(Map<String, String> map) {
            if (map != null) {
                this.extra.putAll(map);
            }
            return this;
        }

        public Builder header(String str, String str2) {
            if (!StringUtils.isEmpty(str)) {
                this.headers.put(str, str2);
            }
            return this;
        }

        public Builder headers(Map<String, String> map) {
            if (map != null) {
                this.headers.putAll(map);
            }
            return this;
        }

        public Builder urls(List<String> list) {
            if (list != null) {
                this.urls.addAll(list);
            }
            return this;
        }

        public Builder enablePrivateProtocol(boolean z) {
            this.privateProtocolEnabled = z;
            return this;
        }

        public Builder uniqueServiceIdList(List<Integer> list) {
            if (list != null) {
                this.serviceIdList.addAll(list);
            }
            return this;
        }

        public Builder urlForPrivateProtocol(String str) {
            try {
                if (str.startsWith("wss:")) {
                    str = "https:" + str.substring(4);
                } else if (str.startsWith("ws:")) {
                    str = "http:" + str.substring(3);
                }
                new URI(str);
                this.privateProtocolUrl = str;
            } catch (Throwable unused) {
                this.privateProtocolUrl = null;
                Logger.e("ChannelInfo", "The private protocol url is invalid.");
            }
            return this;
        }

        public Builder transportModeForPrivateProtocol(TransportMode transportMode) {
            this.transportMode = transportMode;
            return this;
        }

        public Builder disableFallbackWebSocket(boolean z) {
            this.disableFallbackWS = z;
            return this;
        }

        public ChannelInfo builder() {
            return new ChannelInfo(this.fpid, this.aid, this.appVersion, this.appkey, this.channelId, this.deviceId, this.installId, this.urls, this.extra, this.privateProtocolEnabled, this.serviceIdList, this.privateProtocolUrl, this.transportMode, this.disableFallbackWS, this);
        }
    }
}
