package com.bytedance.forest.preload;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.forest.model.Response;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PreLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/forest/preload/PreloadResult;", "", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "isWait", "", "(Lcom/bytedance/forest/model/Response;Z)V", "()Z", "getResponse", "()Lcom/bytedance/forest/model/Response;", "component1", "component2", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final /* data */ class PreloadResult {
    private final boolean isWait;
    private final Response response;

    public static /* synthetic */ PreloadResult copy$default(PreloadResult preloadResult, Response response, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            response = preloadResult.response;
        }
        if ((i & 2) != 0) {
            z = preloadResult.isWait;
        }
        return preloadResult.copy(response, z);
    }

    /* renamed from: component1, reason: from getter */
    public final Response getResponse() {
        return this.response;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsWait() {
        return this.isWait;
    }

    public final PreloadResult copy(Response response, boolean isWait) {
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        return new PreloadResult(response, isWait);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreloadResult)) {
            return false;
        }
        PreloadResult preloadResult = (PreloadResult) other;
        return Intrinsics.areEqual(this.response, preloadResult.response) && this.isWait == preloadResult.isWait;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Response response = this.response;
        int hashCode = (response != null ? response.hashCode() : 0) * 31;
        boolean z = this.isWait;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "PreloadResult(response=" + this.response + ", isWait=" + this.isWait + ")";
    }

    public PreloadResult(Response response, boolean z) {
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        this.response = response;
        this.isWait = z;
    }

    public final Response getResponse() {
        return this.response;
    }

    public final boolean isWait() {
        return this.isWait;
    }
}
