package com.bytedance.pitaya.api.bean;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PTYTaskConfig.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\nHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYTaskConfig;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "sync", "", "entrance", "", "pendingTimeout", "", "(ZLjava/lang/String;F)V", "callType", "", "getCallType", "()I", "setCallType", "(I)V", "getEntrance", "()Ljava/lang/String;", "getPendingTimeout", "()F", "getSync", "()Z", "component1", "component2", "component3", "copy", "equals", PreloadConfig.KEY_OTHER, "", "hashCode", "toString", "Companion", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PTYTaskConfig implements ReflectionCall {
    public static final int FORWARD_TYPE_AUTO = 4;
    public static final int FORWARD_TYPE_CORE_ML = 10;
    public static final int FORWARD_TYPE_CPU = 0;
    public static final int FORWARD_TYPE_CUDA = 9;
    public static final int FORWARD_TYPE_DSP = 2;
    public static final int FORWARD_TYPE_GPU = 1;
    public static final int FORWARD_TYPE_METAL = 5;
    public static final int FORWARD_TYPE_NPU = 3;
    public static final int FORWARD_TYPE_OPENCL = 6;
    public static final int FORWARD_TYPE_OPENGL = 7;
    public static final int FORWARD_TYPE_VULKAN = 8;
    public static final int TASK_CALL_API = 1;
    public static final int TASK_CALL_API_CACHED = 14;
    public static final int TASK_CALL_PRELOAD = 13;
    public static final int TASK_CALL_RELEASE_RUNNER_AND_ENGINE = 16;
    public static final int TASK_CALL_UNKNOWN = 0;
    public static final int TASK_PRIORITY_HIGH = 3;
    public static final int TASK_PRIORITY_HIGHEST = 4;
    public static final int TASK_PRIORITY_LOW = 1;
    public static final int TASK_PRIORITY_LOWEST = 0;
    public static final int TASK_PRIORITY_NORMAL = 2;
    private int callType;
    private final String entrance;
    private final float pendingTimeout;
    private final boolean sync;

    public PTYTaskConfig() {
        this(false, null, 0.0f, 7, null);
    }

    public static /* synthetic */ PTYTaskConfig copy$default(PTYTaskConfig pTYTaskConfig, boolean z, String str, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            z = pTYTaskConfig.sync;
        }
        if ((i & 2) != 0) {
            str = pTYTaskConfig.entrance;
        }
        if ((i & 4) != 0) {
            f = pTYTaskConfig.pendingTimeout;
        }
        return pTYTaskConfig.copy(z, str, f);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSync() {
        return this.sync;
    }

    /* renamed from: component2, reason: from getter */
    public final String getEntrance() {
        return this.entrance;
    }

    /* renamed from: component3, reason: from getter */
    public final float getPendingTimeout() {
        return this.pendingTimeout;
    }

    public final PTYTaskConfig copy(boolean sync, String entrance, float pendingTimeout) {
        return new PTYTaskConfig(sync, entrance, pendingTimeout);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PTYTaskConfig)) {
            return false;
        }
        PTYTaskConfig pTYTaskConfig = (PTYTaskConfig) other;
        return this.sync == pTYTaskConfig.sync && Intrinsics.areEqual(this.entrance, pTYTaskConfig.entrance) && Float.compare(this.pendingTimeout, pTYTaskConfig.pendingTimeout) == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.sync;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.entrance;
        return ((i + (str == null ? 0 : str.hashCode())) * 31) + Float.hashCode(this.pendingTimeout);
    }

    public String toString() {
        return "PTYTaskConfig(sync=" + this.sync + ", entrance=" + this.entrance + ", pendingTimeout=" + this.pendingTimeout + ')';
    }

    public PTYTaskConfig(boolean z, String str, float f) {
        this.sync = z;
        this.entrance = str;
        this.pendingTimeout = f;
        this.callType = 1;
    }

    public /* synthetic */ PTYTaskConfig(boolean z, String str, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? -1.0f : f);
    }

    public final boolean getSync() {
        return this.sync;
    }

    public final String getEntrance() {
        return this.entrance;
    }

    public final float getPendingTimeout() {
        return this.pendingTimeout;
    }

    public final int getCallType() {
        return this.callType;
    }

    public final void setCallType(int i) {
        this.callType = i;
    }
}
