package com.bytedance.android.anniex.base.service;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AnnieXLynxAsyncLoadRunnableMeta.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/anniex/base/service/AnnieXLynxAsyncLoadRunnableMeta;", "", "()V", "<set-?>", "", "enablePreLayoutFutureCache", "getEnablePreLayoutFutureCache", "()Z", "enablePreLayoutViewCache", "getEnablePreLayoutViewCache", "enableUIFlush", "getEnableUIFlush", "", "waitLayoutFinishedTimeout", "getWaitLayoutFinishedTimeout", "()J", "Builder", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class AnnieXLynxAsyncLoadRunnableMeta {
    private boolean enablePreLayoutFutureCache;
    private boolean enablePreLayoutViewCache;
    private boolean enableUIFlush;
    private long waitLayoutFinishedTimeout;

    public /* synthetic */ AnnieXLynxAsyncLoadRunnableMeta(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AnnieXLynxAsyncLoadRunnableMeta() {
        this.enablePreLayoutViewCache = true;
    }

    public final boolean getEnableUIFlush() {
        return this.enableUIFlush;
    }

    public final boolean getEnablePreLayoutFutureCache() {
        return this.enablePreLayoutFutureCache;
    }

    public final long getWaitLayoutFinishedTimeout() {
        return this.waitLayoutFinishedTimeout;
    }

    public final boolean getEnablePreLayoutViewCache() {
        return this.enablePreLayoutViewCache;
    }

    /* compiled from: AnnieXLynxAsyncLoadRunnableMeta.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/anniex/base/service/AnnieXLynxAsyncLoadRunnableMeta$Builder;", "", "()V", "enablePreLayoutFutureCache", "", "enablePreLayoutViewCache", "enableUIFlush", "waitLayoutFinishedTimeout", "", "build", "Lcom/bytedance/android/anniex/base/service/AnnieXLynxAsyncLoadRunnableMeta;", "setEnablePreLayoutFutureCache", "setEnablePreLayoutViewCache", "setEnableUIFlush", "setWaitLayoutFinishedTimeout", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Builder {
        private boolean enablePreLayoutFutureCache;
        private boolean enablePreLayoutViewCache = true;
        private boolean enableUIFlush;
        private long waitLayoutFinishedTimeout;

        public final Builder setEnableUIFlush(boolean enableUIFlush) {
            this.enableUIFlush = enableUIFlush;
            return this;
        }

        public final Builder setEnablePreLayoutFutureCache(boolean enablePreLayoutFutureCache) {
            this.enablePreLayoutFutureCache = enablePreLayoutFutureCache;
            return this;
        }

        public final Builder setWaitLayoutFinishedTimeout(long waitLayoutFinishedTimeout) {
            this.waitLayoutFinishedTimeout = waitLayoutFinishedTimeout;
            return this;
        }

        public final Builder setEnablePreLayoutViewCache(boolean enablePreLayoutViewCache) {
            this.enablePreLayoutViewCache = enablePreLayoutViewCache;
            return this;
        }

        public final AnnieXLynxAsyncLoadRunnableMeta build() {
            AnnieXLynxAsyncLoadRunnableMeta annieXLynxAsyncLoadRunnableMeta = new AnnieXLynxAsyncLoadRunnableMeta(null);
            annieXLynxAsyncLoadRunnableMeta.enableUIFlush = this.enableUIFlush;
            annieXLynxAsyncLoadRunnableMeta.enablePreLayoutFutureCache = this.enablePreLayoutFutureCache;
            annieXLynxAsyncLoadRunnableMeta.waitLayoutFinishedTimeout = this.waitLayoutFinishedTimeout;
            annieXLynxAsyncLoadRunnableMeta.enablePreLayoutViewCache = this.enablePreLayoutFutureCache;
            return annieXLynxAsyncLoadRunnableMeta;
        }
    }
}
