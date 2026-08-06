package com.bytedance.geckox;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.geckox.net.DefaultNetWork;
import com.bytedance.geckox.net.INetWork;
import com.bytedance.geckox.statistic.IStatisticMonitor;
import com.bytedance.geckox.utils.AppUtils;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class BaseGeckoConfig {
    protected Long mAppId;
    protected String mAppVersion;
    private final Context mContext;
    protected String mDeviceId;
    protected String mHost;
    protected INetWork mNetWork;
    private final IStatisticMonitor mStatisticMonitor;
    private final boolean mUseMMap;

    @Deprecated
    public String getRegion() {
        return "";
    }

    public BaseGeckoConfig(BaseGeckoConfigBuilder baseGeckoConfigBuilder) {
        Context context = baseGeckoConfigBuilder.context;
        this.mContext = context;
        if (context == null) {
            throw new IllegalArgumentException("context == null");
        }
        this.mAppId = baseGeckoConfigBuilder.appId;
        if (TextUtils.isEmpty(baseGeckoConfigBuilder.appVersion)) {
            this.mAppVersion = AppUtils.getVersion(context);
        } else {
            this.mAppVersion = baseGeckoConfigBuilder.appVersion;
        }
        this.mDeviceId = baseGeckoConfigBuilder.deviceId;
        String str = baseGeckoConfigBuilder.host;
        this.mHost = str;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("host is null");
        }
        if (this.mAppId == null) {
            throw new IllegalArgumentException("appId is null");
        }
        if (TextUtils.isEmpty(this.mDeviceId)) {
            throw new IllegalArgumentException("deviceId key empty");
        }
        if (baseGeckoConfigBuilder.netWork == null) {
            this.mNetWork = new DefaultNetWork();
        } else {
            this.mNetWork = baseGeckoConfigBuilder.netWork;
        }
        this.mUseMMap = baseGeckoConfigBuilder.useMMap;
        this.mStatisticMonitor = baseGeckoConfigBuilder.statisticMonitor;
    }

    public Context getContext() {
        return this.mContext;
    }

    public INetWork getNetWork() {
        return this.mNetWork;
    }

    public String getHost() {
        return this.mHost;
    }

    public long getAppId() {
        return this.mAppId.longValue();
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public void setDeviceId(String str) {
        this.mDeviceId = str;
    }

    public void setAppId(long j) {
        this.mAppId = Long.valueOf(j);
    }

    public void setHost(String str) {
        this.mHost = str;
    }

    public void setNetWork(INetWork iNetWork) {
        this.mNetWork = iNetWork;
    }

    public boolean isUseMMap() {
        return this.mUseMMap;
    }

    public IStatisticMonitor getStatisticMonitor() {
        return this.mStatisticMonitor;
    }

    /* loaded from: classes3.dex */
    public static class BaseGeckoConfigBuilder<T extends BaseGeckoConfigBuilder> {
        private Long appId;
        private String appVersion;
        private Context context;
        private String deviceId;
        private String host;
        private INetWork netWork;
        private IStatisticMonitor statisticMonitor;
        private boolean useMMap = true;

        @Deprecated
        public T checkUpdateExecutor(Executor executor) {
            return this;
        }

        @Deprecated
        public T region(String str) {
            return this;
        }

        @Deprecated
        public T updateExecutor(Executor executor) {
            return this;
        }

        public BaseGeckoConfigBuilder(Context context) {
            this.context = context;
        }

        public T netStack(INetWork iNetWork) {
            this.netWork = iNetWork;
            return this;
        }

        public T appId(long j) {
            this.appId = Long.valueOf(j);
            return this;
        }

        public T appVersion(String str) {
            this.appVersion = str;
            return this;
        }

        public T deviceId(String str) {
            this.deviceId = str;
            return this;
        }

        public T statisticMonitor(IStatisticMonitor iStatisticMonitor) {
            this.statisticMonitor = iStatisticMonitor;
            return this;
        }

        public T host(String str) {
            this.host = str;
            return this;
        }

        public T useMMap(boolean z) {
            this.useMMap = z;
            return this;
        }
    }
}
