package com.bytedance.trae.platform.model;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpEnvConfig.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/platform/model/HttpEnvConfig;", "", "boeEnable", "", "boeEnv", "", "ppeEnable", "ppeEnv", "<init>", "(ZLjava/lang/String;ZLjava/lang/String;)V", "getBoeEnable", "()Z", "getBoeEnv", "()Ljava/lang/String;", "getPpeEnable", "getPpeEnv", "component1", "component2", "component3", "component4", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "platform_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class HttpEnvConfig {
    private final boolean boeEnable;
    private final String boeEnv;
    private final boolean ppeEnable;
    private final String ppeEnv;

    public HttpEnvConfig() {
        this(false, null, false, null, 15, null);
    }

    public static /* synthetic */ HttpEnvConfig copy$default(HttpEnvConfig httpEnvConfig, boolean z, String str, boolean z2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = httpEnvConfig.boeEnable;
        }
        if ((i & 2) != 0) {
            str = httpEnvConfig.boeEnv;
        }
        if ((i & 4) != 0) {
            z2 = httpEnvConfig.ppeEnable;
        }
        if ((i & 8) != 0) {
            str2 = httpEnvConfig.ppeEnv;
        }
        return httpEnvConfig.copy(z, str, z2, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getBoeEnable() {
        return this.boeEnable;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBoeEnv() {
        return this.boeEnv;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getPpeEnable() {
        return this.ppeEnable;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPpeEnv() {
        return this.ppeEnv;
    }

    public final HttpEnvConfig copy(boolean boeEnable, String boeEnv, boolean ppeEnable, String ppeEnv) {
        Intrinsics.checkNotNullParameter(boeEnv, "boeEnv");
        Intrinsics.checkNotNullParameter(ppeEnv, "ppeEnv");
        return new HttpEnvConfig(boeEnable, boeEnv, ppeEnable, ppeEnv);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HttpEnvConfig)) {
            return false;
        }
        HttpEnvConfig httpEnvConfig = (HttpEnvConfig) other;
        return this.boeEnable == httpEnvConfig.boeEnable && Intrinsics.areEqual(this.boeEnv, httpEnvConfig.boeEnv) && this.ppeEnable == httpEnvConfig.ppeEnable && Intrinsics.areEqual(this.ppeEnv, httpEnvConfig.ppeEnv);
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.boeEnable) * 31) + this.boeEnv.hashCode()) * 31) + Boolean.hashCode(this.ppeEnable)) * 31) + this.ppeEnv.hashCode();
    }

    public String toString() {
        return "HttpEnvConfig(boeEnable=" + this.boeEnable + ", boeEnv=" + this.boeEnv + ", ppeEnable=" + this.ppeEnable + ", ppeEnv=" + this.ppeEnv + ')';
    }

    public HttpEnvConfig(boolean z, String boeEnv, boolean z2, String ppeEnv) {
        Intrinsics.checkNotNullParameter(boeEnv, "boeEnv");
        Intrinsics.checkNotNullParameter(ppeEnv, "ppeEnv");
        this.boeEnable = z;
        this.boeEnv = boeEnv;
        this.ppeEnable = z2;
        this.ppeEnv = ppeEnv;
    }

    public /* synthetic */ HttpEnvConfig(boolean z, String str, boolean z2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? "" : str2);
    }

    public final boolean getBoeEnable() {
        return this.boeEnable;
    }

    public final String getBoeEnv() {
        return this.boeEnv;
    }

    public final boolean getPpeEnable() {
        return this.ppeEnable;
    }

    public final String getPpeEnv() {
        return this.ppeEnv;
    }
}
