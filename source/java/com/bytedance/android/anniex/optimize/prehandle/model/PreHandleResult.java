package com.bytedance.android.anniex.optimize.prehandle.model;

import com.bytedance.forest.model.PreloadConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PreHandleResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/anniex/optimize/prehandle/model/PreHandleResult;", "", "createTimeStamp", "", "result", "", "", "(JLjava/util/Map;)V", "getCreateTimeStamp", "()J", "getResult", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class PreHandleResult {
    private final long createTimeStamp;
    private final Map<String, Object> result;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PreHandleResult copy$default(PreHandleResult preHandleResult, long j, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            j = preHandleResult.createTimeStamp;
        }
        if ((i & 2) != 0) {
            map = preHandleResult.result;
        }
        return preHandleResult.copy(j, map);
    }

    /* renamed from: component1, reason: from getter */
    public final long getCreateTimeStamp() {
        return this.createTimeStamp;
    }

    public final Map<String, Object> component2() {
        return this.result;
    }

    public final PreHandleResult copy(long createTimeStamp, Map<String, ? extends Object> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        return new PreHandleResult(createTimeStamp, result);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreHandleResult)) {
            return false;
        }
        PreHandleResult preHandleResult = (PreHandleResult) other;
        return this.createTimeStamp == preHandleResult.createTimeStamp && Intrinsics.areEqual(this.result, preHandleResult.result);
    }

    public int hashCode() {
        return (Long.hashCode(this.createTimeStamp) * 31) + this.result.hashCode();
    }

    public String toString() {
        return "PreHandleResult(createTimeStamp=" + this.createTimeStamp + ", result=" + this.result + ')';
    }

    public PreHandleResult(long j, Map<String, ? extends Object> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.createTimeStamp = j;
        this.result = result;
    }

    public final long getCreateTimeStamp() {
        return this.createTimeStamp;
    }

    public final Map<String, Object> getResult() {
        return this.result;
    }
}
