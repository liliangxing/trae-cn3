package com.bytedance.ies.bullet.core;

import com.bytedance.ies.bullet.service.base.resourceloader.config.CustomLoaderConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/bytedance/ies/bullet/core/BulletRLContext;", "", "()V", "customLoaderConfig", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/CustomLoaderConfig;", "getCustomLoaderConfig", "()Lcom/bytedance/ies/bullet/service/base/resourceloader/config/CustomLoaderConfig;", "setCustomLoaderConfig", "(Lcom/bytedance/ies/bullet/service/base/resourceloader/config/CustomLoaderConfig;)V", "resFrom", "", "getResFrom", "()Ljava/lang/String;", "setResFrom", "(Ljava/lang/String;)V", "resMemory", "", "getResMemory", "()Z", "setResMemory", "(Z)V", "resSize", "", "getResSize", "()D", "setResSize", "(D)V", "resVersion", "", "getResVersion", "()J", "setResVersion", "(J)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class BulletRLContext {
    private CustomLoaderConfig customLoaderConfig;
    private String resFrom = "unknown";
    private boolean resMemory;
    private double resSize;
    private long resVersion;

    public final CustomLoaderConfig getCustomLoaderConfig() {
        return this.customLoaderConfig;
    }

    public final void setCustomLoaderConfig(CustomLoaderConfig customLoaderConfig) {
        this.customLoaderConfig = customLoaderConfig;
    }

    public final String getResFrom() {
        return this.resFrom;
    }

    public final void setResFrom(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.resFrom = str;
    }

    public final double getResSize() {
        return this.resSize;
    }

    public final void setResSize(double d) {
        this.resSize = d;
    }

    public final long getResVersion() {
        return this.resVersion;
    }

    public final void setResVersion(long j) {
        this.resVersion = j;
    }

    public final boolean getResMemory() {
        return this.resMemory;
    }

    public final void setResMemory(boolean z) {
        this.resMemory = z;
    }
}
