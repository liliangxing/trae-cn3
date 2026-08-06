package com.bytedance.webx.seclink.config;

import android.text.TextUtils;
import com.bytedance.security.android.polaris.PolarisUri;
import com.bytedance.trae.utils.LocaleManager;
import com.bytedance.webx.base.report.IReportAgent;
import com.bytedance.webx.seclink.base.IBizInfoProvider;
import com.bytedance.webx.seclink.base.IDeviceProvider;
import com.bytedance.webx.seclink.base.INetApi;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class AppSecConfig {
    private String aid;
    private String appVersion;
    private String channel;
    private String devicePlatform;
    private IDeviceProvider deviceProvider;
    private String did;
    private IBizInfoProvider globalBizInfoProvider;
    private String host;
    private String lang;
    private INetApi netClient;
    private List<String> prefixAllowList;
    IReportAgent reportAgent;
    private long timeout;
    private List<String> verifySchemeList;

    public AppSecConfig() {
        this.lang = LocaleManager.LANGUAGE_ZH;
        this.devicePlatform = "android";
        this.timeout = 1000L;
    }

    public AppSecConfig(Builder builder) {
        this.lang = LocaleManager.LANGUAGE_ZH;
        this.devicePlatform = "android";
        this.timeout = 1000L;
        this.aid = builder.aid;
        this.lang = builder.lang;
        this.did = builder.did;
        this.appVersion = builder.appVersion;
        this.channel = builder.channel;
        setHost(builder.host);
        this.prefixAllowList = builder.prefixAllowList;
        this.timeout = builder.timeout;
        this.verifySchemeList = builder.verifySchemeList;
        this.globalBizInfoProvider = builder.globalBizInfoProvider;
        this.deviceProvider = builder.deviceProvider;
        this.netClient = builder.netClient;
        this.reportAgent = builder.reportAgent;
    }

    public IReportAgent getReportAgent() {
        return this.reportAgent;
    }

    public void setReportAgent(IReportAgent iReportAgent) {
        this.reportAgent = iReportAgent;
    }

    public INetApi getNetClient() {
        return this.netClient;
    }

    public void setNetClient(INetApi iNetApi) {
        this.netClient = iNetApi;
    }

    public String getAid() {
        return this.aid;
    }

    public void setAid(String str) {
        this.aid = str;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public String getHost() {
        return this.host;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public void setTimeout(long j) {
        this.timeout = j;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public String getDid() {
        IDeviceProvider iDeviceProvider;
        if (TextUtils.isEmpty(this.did) && (iDeviceProvider = this.deviceProvider) != null) {
            this.did = iDeviceProvider.deviceId();
        }
        return this.did;
    }

    public void setDid(String str) {
        this.did = str;
    }

    public String getDevicePlatform() {
        return this.devicePlatform;
    }

    public IDeviceProvider getDeviceProvider() {
        return this.deviceProvider;
    }

    public void setDeviceProvider(IDeviceProvider iDeviceProvider) {
        this.deviceProvider = iDeviceProvider;
    }

    public void setHost(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 0 && str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        this.host = str;
    }

    public List<String> getPrefixAllowList() {
        return this.prefixAllowList;
    }

    public void setPrefixAllowList(List<String> list) {
        this.prefixAllowList = list;
    }

    public void addAllowList(String str) {
        if (this.prefixAllowList == null) {
            this.prefixAllowList = new ArrayList();
        }
        this.prefixAllowList.add(str);
    }

    public void addAllowList(List<String> list) {
        if (this.prefixAllowList == null) {
            this.prefixAllowList = new ArrayList();
        }
        this.prefixAllowList.addAll(list);
    }

    public boolean containInAllowList(String str) {
        List<String> list = this.prefixAllowList;
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return PolarisUri.isUriInAllowList(str, this.prefixAllowList);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void removeAllAllowList() {
        List<String> list = this.prefixAllowList;
        if (list == null) {
            return;
        }
        list.clear();
    }

    public void removeAllowList(String str) {
        List<String> list = this.prefixAllowList;
        if (list == null) {
            return;
        }
        list.remove(str);
    }

    public void setVerifySchemeList(List<String> list) {
        this.verifySchemeList = list;
    }

    public List<String> getVerifySchemeList() {
        return this.verifySchemeList;
    }

    public void addVerifyScheme(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.verifySchemeList == null) {
            this.verifySchemeList = new ArrayList();
        }
        this.verifySchemeList.add(str);
    }

    public void addVerifyScheme(List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        if (this.verifySchemeList == null) {
            this.verifySchemeList = new ArrayList();
        }
        this.verifySchemeList.addAll(list);
    }

    public void removeVerifyScheme(String str) {
        List<String> list = this.verifySchemeList;
        if (list == null) {
            return;
        }
        list.remove(str);
    }

    public void removeAllVerifyScheme() {
        List<String> list = this.verifySchemeList;
        if (list == null) {
            return;
        }
        list.clear();
    }

    public IBizInfoProvider getGlobalBizInfoProvider() {
        return this.globalBizInfoProvider;
    }

    public void setGlobalBizInfoProvider(IBizInfoProvider iBizInfoProvider) {
        this.globalBizInfoProvider = iBizInfoProvider;
    }

    /* loaded from: classes6.dex */
    public static class Builder {
        private String aid;
        private String appVersion;
        private String channel;
        private IDeviceProvider deviceProvider;
        private String did;
        private IBizInfoProvider globalBizInfoProvider;
        private String host;
        private INetApi netClient;
        private List<String> prefixAllowList;
        private IReportAgent reportAgent;
        private List<String> verifySchemeList;
        private String lang = LocaleManager.LANGUAGE_ZH;
        private long timeout = 1000;

        public Builder aid(String str) {
            this.aid = str;
            return this;
        }

        public Builder did(String str) {
            this.did = str;
            return this;
        }

        public Builder appVersion(String str) {
            this.appVersion = str;
            return this;
        }

        public Builder channel(String str) {
            this.channel = str;
            return this;
        }

        public Builder lang(String str) {
            this.lang = str;
            return this;
        }

        public Builder host(String str) {
            this.host = str;
            return this;
        }

        public Builder prefixAllowList(List<String> list) {
            this.prefixAllowList = list;
            return this;
        }

        public Builder timeout(long j) {
            this.timeout = j;
            return this;
        }

        public Builder verifySchemeList(List<String> list) {
            this.verifySchemeList = list;
            return this;
        }

        @Deprecated
        public Builder bizInfoProvider(IBizInfoProvider iBizInfoProvider) {
            return globalBizInfoProvider(iBizInfoProvider);
        }

        public Builder globalBizInfoProvider(IBizInfoProvider iBizInfoProvider) {
            this.globalBizInfoProvider = iBizInfoProvider;
            return this;
        }

        public Builder deviceInfoProvide(IDeviceProvider iDeviceProvider) {
            this.deviceProvider = iDeviceProvider;
            return this;
        }

        public Builder netApi(INetApi iNetApi) {
            this.netClient = iNetApi;
            return this;
        }

        public Builder reportAgent(IReportAgent iReportAgent) {
            this.reportAgent = iReportAgent;
            return this;
        }

        public AppSecConfig build() {
            return new AppSecConfig(this);
        }
    }
}
