package com.bytedance.timonbase.scene.report;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScenesReportEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/timonbase/scene/report/ScenesReportEvent;", "", "senseType", "", "isMainProcess", "senseState", "callMethodType", "", "useMultiProcess", "(IIILjava/lang/String;I)V", "getCallMethodType", "()Ljava/lang/String;", "()I", "getSenseState", "getSenseType", "getUseMultiProcess", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final /* data */ class ScenesReportEvent {

    @SerializedName("call_method_type")
    private final String callMethodType;

    @SerializedName("is_main_process")
    private final int isMainProcess;

    @SerializedName("sense_state")
    private final int senseState;

    @SerializedName("sense_type")
    private final int senseType;

    @SerializedName("use_multi_process")
    private final int useMultiProcess;

    public ScenesReportEvent() {
        this(0, 0, 0, null, 0, 31, null);
    }

    public static /* synthetic */ ScenesReportEvent copy$default(ScenesReportEvent scenesReportEvent, int i, int i2, int i3, String str, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = scenesReportEvent.senseType;
        }
        if ((i5 & 2) != 0) {
            i2 = scenesReportEvent.isMainProcess;
        }
        int i6 = i2;
        if ((i5 & 4) != 0) {
            i3 = scenesReportEvent.senseState;
        }
        int i7 = i3;
        if ((i5 & 8) != 0) {
            str = scenesReportEvent.callMethodType;
        }
        String str2 = str;
        if ((i5 & 16) != 0) {
            i4 = scenesReportEvent.useMultiProcess;
        }
        return scenesReportEvent.copy(i, i6, i7, str2, i4);
    }

    /* renamed from: component1, reason: from getter */
    public final int getSenseType() {
        return this.senseType;
    }

    /* renamed from: component2, reason: from getter */
    public final int getIsMainProcess() {
        return this.isMainProcess;
    }

    /* renamed from: component3, reason: from getter */
    public final int getSenseState() {
        return this.senseState;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCallMethodType() {
        return this.callMethodType;
    }

    /* renamed from: component5, reason: from getter */
    public final int getUseMultiProcess() {
        return this.useMultiProcess;
    }

    public final ScenesReportEvent copy(int senseType, int isMainProcess, int senseState, String callMethodType, int useMultiProcess) {
        Intrinsics.checkParameterIsNotNull(callMethodType, "callMethodType");
        return new ScenesReportEvent(senseType, isMainProcess, senseState, callMethodType, useMultiProcess);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScenesReportEvent)) {
            return false;
        }
        ScenesReportEvent scenesReportEvent = (ScenesReportEvent) other;
        return this.senseType == scenesReportEvent.senseType && this.isMainProcess == scenesReportEvent.isMainProcess && this.senseState == scenesReportEvent.senseState && Intrinsics.areEqual(this.callMethodType, scenesReportEvent.callMethodType) && this.useMultiProcess == scenesReportEvent.useMultiProcess;
    }

    public int hashCode() {
        int hashCode = ((((Integer.hashCode(this.senseType) * 31) + Integer.hashCode(this.isMainProcess)) * 31) + Integer.hashCode(this.senseState)) * 31;
        String str = this.callMethodType;
        return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + Integer.hashCode(this.useMultiProcess);
    }

    public String toString() {
        return "ScenesReportEvent(senseType=" + this.senseType + ", isMainProcess=" + this.isMainProcess + ", senseState=" + this.senseState + ", callMethodType=" + this.callMethodType + ", useMultiProcess=" + this.useMultiProcess + ")";
    }

    public ScenesReportEvent(int i, int i2, int i3, String callMethodType, int i4) {
        Intrinsics.checkParameterIsNotNull(callMethodType, "callMethodType");
        this.senseType = i;
        this.isMainProcess = i2;
        this.senseState = i3;
        this.callMethodType = callMethodType;
        this.useMultiProcess = i4;
    }

    public final int getSenseType() {
        return this.senseType;
    }

    public final int isMainProcess() {
        return this.isMainProcess;
    }

    public final int getSenseState() {
        return this.senseState;
    }

    public final String getCallMethodType() {
        return this.callMethodType;
    }

    public /* synthetic */ ScenesReportEvent(int i, int i2, int i3, String str, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? -1 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? "" : str, (i5 & 16) == 0 ? i4 : 0);
    }

    public final int getUseMultiProcess() {
        return this.useMultiProcess;
    }
}
