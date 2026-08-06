package com.bytedance.falconx;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.falconx.statistic.IStatisticMonitor;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.utils.AppUtils;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class WebOfflineConfig {
    private static int mAid;
    private final String mAccessKey;
    private final String mAppVersion;
    private final List<Uri> mCacheDir;
    private final List<Pattern> mCachePrefix;
    private final Context mContext;
    private final String mDeviceId;
    private final String mHost;
    private final boolean mIsNeedServerMonitor;
    private final String mRegion;
    private final List<IRequestIntercept> mRequestIntercepts;
    private final IStatisticMonitor mStatisticMonitor;

    private WebOfflineConfig(Builder builder) {
        if (builder.mContext == null) {
            throw new IllegalArgumentException("context == null");
        }
        Context applicationContext = builder.mContext.getApplicationContext();
        if (applicationContext != null) {
            this.mContext = applicationContext;
        } else {
            this.mContext = builder.mContext;
        }
        if (TextUtils.isEmpty(builder.mAppVersion)) {
            this.mAppVersion = AppUtils.getVersion(this.mContext);
        } else {
            this.mAppVersion = builder.mAppVersion;
        }
        if (TextUtils.isEmpty(builder.mAccessKey)) {
            throw new IllegalArgumentException("accessKey empty");
        }
        this.mAccessKey = builder.mAccessKey;
        if (TextUtils.isEmpty(builder.mHost)) {
            throw new IllegalArgumentException("host empty");
        }
        this.mHost = builder.mHost;
        if (builder.aid != 0) {
            mAid = builder.aid;
        }
        this.mCachePrefix = builder.mCachePrefix;
        this.mRequestIntercepts = builder.mRequestIntercepts;
        if (builder.mCacheDir == null) {
            this.mCacheDir = Arrays.asList(Uri.fromFile(new File(this.mContext.getFilesDir(), GeckoClient.GECKO_ROOT_DIR)));
        } else {
            this.mCacheDir = builder.mCacheDir;
        }
        this.mDeviceId = builder.mDeviceId;
        this.mStatisticMonitor = builder.mStatisticMonitor;
        String str = builder.mRegion;
        this.mRegion = str;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("region == null");
        }
        this.mIsNeedServerMonitor = builder.mIsNeedServerMonitor;
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<Pattern> getCachePrefix() {
        return this.mCachePrefix;
    }

    public List<Uri> getCacheDir() {
        return this.mCacheDir;
    }

    public String getAccessKey() {
        return this.mAccessKey;
    }

    public boolean isNeedServerMonitor() {
        return this.mIsNeedServerMonitor;
    }

    public String getHost() {
        return this.mHost;
    }

    public IStatisticMonitor getStatisticMonitor() {
        return this.mStatisticMonitor;
    }

    public List<IRequestIntercept> getRequestIntercepts() {
        return this.mRequestIntercepts;
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    public String getRegion() {
        return this.mRegion;
    }

    public static int getAid() {
        return mAid;
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        private int aid;
        private String mAccessKey;
        private String mAppVersion;
        private List<Uri> mCacheDir;
        private List<Pattern> mCachePrefix;
        private Context mContext;
        private String mDeviceId;
        private String mHost;
        private boolean mIsNeedServerMonitor = true;
        private String mRegion;
        private List<IRequestIntercept> mRequestIntercepts;
        private IStatisticMonitor mStatisticMonitor;

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder cachePrefix(List<Pattern> list) {
            this.mCachePrefix = list;
            return this;
        }

        public Builder cacheDirs(List<Uri> list) {
            this.mCacheDir = list;
            return this;
        }

        public Builder requestIntercepts(List<IRequestIntercept> list) {
            this.mRequestIntercepts = list;
            return this;
        }

        public Builder statisticMonitor(IStatisticMonitor iStatisticMonitor) {
            this.mStatisticMonitor = iStatisticMonitor;
            return this;
        }

        public Builder needServerMonitor(boolean z) {
            this.mIsNeedServerMonitor = z;
            return this;
        }

        public Builder appVersion(String str) {
            this.mAppVersion = str;
            return this;
        }

        public Builder host(String str) {
            this.mHost = str;
            return this;
        }

        public Builder accessKey(String str) {
            this.mAccessKey = str;
            return this;
        }

        public Builder deviceId(String str) {
            this.mDeviceId = str;
            return this;
        }

        public Builder region(String str) {
            this.mRegion = str;
            return this;
        }

        public Builder aid(int i) {
            this.aid = i;
            return this;
        }

        public WebOfflineConfig build() {
            return new WebOfflineConfig(this);
        }
    }
}
