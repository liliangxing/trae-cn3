package com.bytedance.geckox;

import android.content.Context;
import android.util.Pair;
import com.bytedance.geckox.BaseGeckoConfig;
import com.bytedance.geckox.net.INetWork;
import com.bytedance.geckox.statistic.IStatisticMonitor;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class GeckoGlobalConfig extends BaseGeckoConfig {
    private final String mAppChannel;
    private final long mAppColdStartTime;
    private final ENVType mEnv;
    private final IMonitorConfig mMonitorConfig;
    private final IRequestTagHeaderProvider mRequestTagHeaderProvider;

    /* loaded from: classes3.dex */
    public interface IMonitorConfig {
        String getChannel();

        Map<String, String> getCommonParams();

        String getMonitorHost();

        String getPackageId();

        String getUpdateVersionCode();

        boolean isOversea();
    }

    /* loaded from: classes3.dex */
    public interface IRequestTagHeaderProvider {
        Pair<String, String> getRequestTagHeader(boolean z);
    }

    private GeckoGlobalConfig(Builder builder) {
        super(builder);
        ENVType eNVType = builder.env;
        this.mEnv = eNVType;
        if (eNVType == null) {
            throw new IllegalArgumentException("env is required");
        }
        this.mRequestTagHeaderProvider = builder.requestTagHeaderProvider;
        this.mMonitorConfig = builder.monitorConfig;
        this.mAppChannel = builder.appChannel;
        if (builder.appColdStartTime == 0) {
            this.mAppColdStartTime = System.currentTimeMillis();
        } else {
            this.mAppColdStartTime = builder.appColdStartTime;
        }
    }

    public ENVType getEnv() {
        return this.mEnv;
    }

    public IRequestTagHeaderProvider getRequestTagHeaderProvider() {
        return this.mRequestTagHeaderProvider;
    }

    @Override // com.bytedance.geckox.BaseGeckoConfig
    public void setDeviceId(String str) {
        this.mDeviceId = str;
    }

    @Override // com.bytedance.geckox.BaseGeckoConfig
    public void setHost(String str) {
        this.mHost = str;
    }

    public IMonitorConfig getMonitorConfig() {
        return this.mMonitorConfig;
    }

    public long getAppColdStartTime() {
        return this.mAppColdStartTime;
    }

    public String getAppChannel() {
        return this.mAppChannel;
    }

    /* loaded from: classes3.dex */
    public static class Builder extends BaseGeckoConfig.BaseGeckoConfigBuilder<Builder> {
        private String appChannel;
        private long appColdStartTime;
        private ENVType env;
        private IMonitorConfig monitorConfig;
        private IRequestTagHeaderProvider requestTagHeaderProvider;

        public Builder(Context context) {
            super(context.getApplicationContext());
        }

        public Builder env(ENVType eNVType) {
            this.env = eNVType;
            return this;
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder netStack(INetWork iNetWork) {
            return (Builder) super.netStack(iNetWork);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder updateExecutor(Executor executor) {
            return (Builder) super.updateExecutor(executor);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder checkUpdateExecutor(Executor executor) {
            return (Builder) super.checkUpdateExecutor(executor);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder appId(long j) {
            return (Builder) super.appId(j);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder appVersion(String str) {
            return (Builder) super.appVersion(str);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder deviceId(String str) {
            return (Builder) super.deviceId(str);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder statisticMonitor(IStatisticMonitor iStatisticMonitor) {
            return (Builder) super.statisticMonitor(iStatisticMonitor);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder host(String str) {
            return (Builder) super.host(str);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder region(String str) {
            return (Builder) super.region(str);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder useMMap(boolean z) {
            return (Builder) super.useMMap(z);
        }

        public Builder requestTagHeaderProvider(IRequestTagHeaderProvider iRequestTagHeaderProvider) {
            this.requestTagHeaderProvider = iRequestTagHeaderProvider;
            return this;
        }

        public Builder monitorConfig(IMonitorConfig iMonitorConfig) {
            this.monitorConfig = iMonitorConfig;
            return this;
        }

        public Builder appColdStartTime(long j) {
            this.appColdStartTime = j;
            return this;
        }

        public Builder appChannel(String str) {
            this.appChannel = str;
            return this;
        }

        public GeckoGlobalConfig build() {
            return new GeckoGlobalConfig(this);
        }
    }

    /* loaded from: classes3.dex */
    public enum ENVType {
        BOE(1),
        DEV(1),
        PROD(2);

        private int val;

        public int getVal() {
            return this.val;
        }

        ENVType(int i) {
            this.val = i;
        }
    }
}
