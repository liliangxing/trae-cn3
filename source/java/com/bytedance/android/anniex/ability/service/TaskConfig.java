package com.bytedance.android.anniex.ability.service;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAnnieXPitayaProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/anniex/ability/service/TaskConfig;", "", "businessName", "", "sync", "", "entrance", "pendingTimeout", "", "(Ljava/lang/String;ZLjava/lang/String;F)V", "getBusinessName", "()Ljava/lang/String;", "getEntrance", "getPendingTimeout", "()F", "getSync", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class TaskConfig {
    private final String businessName;
    private final String entrance;
    private final float pendingTimeout;
    private final boolean sync;

    public static /* synthetic */ TaskConfig copy$default(TaskConfig taskConfig, String str, boolean z, String str2, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            str = taskConfig.businessName;
        }
        if ((i & 2) != 0) {
            z = taskConfig.sync;
        }
        if ((i & 4) != 0) {
            str2 = taskConfig.entrance;
        }
        if ((i & 8) != 0) {
            f = taskConfig.pendingTimeout;
        }
        return taskConfig.copy(str, z, str2, f);
    }

    /* renamed from: component1, reason: from getter */
    public final String getBusinessName() {
        return this.businessName;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSync() {
        return this.sync;
    }

    /* renamed from: component3, reason: from getter */
    public final String getEntrance() {
        return this.entrance;
    }

    /* renamed from: component4, reason: from getter */
    public final float getPendingTimeout() {
        return this.pendingTimeout;
    }

    public final TaskConfig copy(String businessName, boolean sync, String entrance, float pendingTimeout) {
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        return new TaskConfig(businessName, sync, entrance, pendingTimeout);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskConfig)) {
            return false;
        }
        TaskConfig taskConfig = (TaskConfig) other;
        return Intrinsics.areEqual(this.businessName, taskConfig.businessName) && this.sync == taskConfig.sync && Intrinsics.areEqual(this.entrance, taskConfig.entrance) && Float.compare(this.pendingTimeout, taskConfig.pendingTimeout) == 0;
    }

    public int hashCode() {
        int hashCode = ((this.businessName.hashCode() * 31) + Boolean.hashCode(this.sync)) * 31;
        String str = this.entrance;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Float.hashCode(this.pendingTimeout);
    }

    public String toString() {
        return "TaskConfig(businessName=" + this.businessName + ", sync=" + this.sync + ", entrance=" + this.entrance + ", pendingTimeout=" + this.pendingTimeout + ')';
    }

    public TaskConfig(String businessName, boolean z, String str, float f) {
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        this.businessName = businessName;
        this.sync = z;
        this.entrance = str;
        this.pendingTimeout = f;
    }

    public /* synthetic */ TaskConfig(String str, boolean z, String str2, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? -1.0f : f);
    }

    public final String getBusinessName() {
        return this.businessName;
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
}
