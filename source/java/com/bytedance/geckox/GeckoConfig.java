package com.bytedance.geckox;

import android.content.Context;
import com.bytedance.geckox.BaseGeckoConfig;
import com.bytedance.geckox.clean.cache.CacheConfig;
import com.bytedance.geckox.net.INetWork;
import com.bytedance.geckox.statistic.IStatisticMonitor;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

@Deprecated
/* loaded from: classes3.dex */
public class GeckoConfig extends BaseGeckoConfig {
    private final List<String> mAccessKeys;
    private final CacheConfig mCacheConfig;
    private final File resRootDir;

    private GeckoConfig(Builder builder) {
        super(builder);
        List<String> list = builder.mAccessKeys;
        this.mAccessKeys = list;
        this.mCacheConfig = builder.mCacheConfig;
        if (builder.resRootDir == null) {
            this.resRootDir = new File(getContext().getFilesDir(), GeckoClient.GECKO_ROOT_DIR);
        } else {
            this.resRootDir = builder.resRootDir;
        }
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("accessKey is empty");
        }
    }

    public CacheConfig getCacheConfig() {
        return this.mCacheConfig;
    }

    public List<String> getAccessKeys() {
        return this.mAccessKeys;
    }

    public String getAccessKey() {
        return this.mAccessKeys.get(0);
    }

    public File getResRootDir() {
        return this.resRootDir;
    }

    /* loaded from: classes3.dex */
    public static class Builder extends BaseGeckoConfig.BaseGeckoConfigBuilder<Builder> {
        private List<String> mAccessKeys;
        private CacheConfig mCacheConfig;
        private File resRootDir;

        @Deprecated
        public Builder allLocalAccessKeys(String... strArr) {
            return this;
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        @Deprecated
        public Builder appVersion(String str) {
            return this;
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        @Deprecated
        public Builder checkUpdateExecutor(Executor executor) {
            return this;
        }

        @Deprecated
        public Builder isLoopCheck(boolean z) {
            return this;
        }

        @Deprecated
        public Builder needServerMonitor(boolean z) {
            return this;
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        @Deprecated
        public Builder netStack(INetWork iNetWork) {
            return this;
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        @Deprecated
        public Builder region(String str) {
            return this;
        }

        @Deprecated
        public Builder setEnableSync(boolean z) {
            return this;
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        @Deprecated
        public Builder statisticMonitor(IStatisticMonitor iStatisticMonitor) {
            return this;
        }

        @Deprecated
        public Builder uid(String str) {
            return this;
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        @Deprecated
        public Builder updateExecutor(Executor executor) {
            return this;
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        @Deprecated
        public Builder useMMap(boolean z) {
            return this;
        }

        public Builder(Context context) {
            super(context.getApplicationContext());
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder appId(long j) {
            return (Builder) super.appId(j);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder deviceId(String str) {
            return (Builder) super.deviceId(str);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder host(String str) {
            return (Builder) super.host(str);
        }

        public Builder accessKey(String... strArr) {
            if (strArr != null && strArr.length >= 1) {
                this.mAccessKeys = Arrays.asList(strArr);
            }
            return this;
        }

        public Builder cacheConfig(CacheConfig cacheConfig) {
            this.mCacheConfig = cacheConfig;
            return this;
        }

        public Builder resRootDir(File file) {
            this.resRootDir = file;
            return this;
        }

        public GeckoConfig build() {
            return new GeckoConfig(this);
        }
    }
}
