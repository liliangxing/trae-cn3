package com.bytedance.android.monitor.standard;

import com.bytedance.android.monitor.entity.ContainerInfo;
import com.bytedance.forest.model.PreloadConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContainerStandardApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u0018\u001a\u00020\u0019J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/monitor/standard/ContainerError;", "", "errCode", "", "errorMsg", "", "virtualAid", "biz", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBiz", "()Ljava/lang/String;", "getErrCode", "()I", "getErrorMsg", "getVirtualAid", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toContainerInfo", "Lcom/bytedance/android/monitor/entity/ContainerInfo;", "toString", "com.bytedance.android.livesdk.monitor.base"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final /* data */ class ContainerError {
    private final String biz;
    private final int errCode;
    private final String errorMsg;
    private final String virtualAid;

    public ContainerError(int i, String str) {
        this(i, str, null, null, 12, null);
    }

    public ContainerError(int i, String str, String str2) {
        this(i, str, str2, null, 8, null);
    }

    public static /* synthetic */ ContainerError copy$default(ContainerError containerError, int i, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = containerError.errCode;
        }
        if ((i2 & 2) != 0) {
            str = containerError.errorMsg;
        }
        if ((i2 & 4) != 0) {
            str2 = containerError.virtualAid;
        }
        if ((i2 & 8) != 0) {
            str3 = containerError.biz;
        }
        return containerError.copy(i, str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getErrCode() {
        return this.errCode;
    }

    /* renamed from: component2, reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    /* renamed from: component3, reason: from getter */
    public final String getVirtualAid() {
        return this.virtualAid;
    }

    /* renamed from: component4, reason: from getter */
    public final String getBiz() {
        return this.biz;
    }

    public final ContainerError copy(int errCode, String errorMsg, String virtualAid, String biz) {
        Intrinsics.checkParameterIsNotNull(errorMsg, "errorMsg");
        Intrinsics.checkParameterIsNotNull(virtualAid, "virtualAid");
        Intrinsics.checkParameterIsNotNull(biz, "biz");
        return new ContainerError(errCode, errorMsg, virtualAid, biz);
    }

    public boolean equals(Object other) {
        if (this != other) {
            if (other instanceof ContainerError) {
                ContainerError containerError = (ContainerError) other;
                if (!(this.errCode == containerError.errCode) || !Intrinsics.areEqual(this.errorMsg, containerError.errorMsg) || !Intrinsics.areEqual(this.virtualAid, containerError.virtualAid) || !Intrinsics.areEqual(this.biz, containerError.biz)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.errCode * 31;
        String str = this.errorMsg;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.virtualAid;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.biz;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ContainerError(errCode=" + this.errCode + ", errorMsg=" + this.errorMsg + ", virtualAid=" + this.virtualAid + ", biz=" + this.biz + ")";
    }

    public ContainerError(int i, String errorMsg, String virtualAid, String biz) {
        Intrinsics.checkParameterIsNotNull(errorMsg, "errorMsg");
        Intrinsics.checkParameterIsNotNull(virtualAid, "virtualAid");
        Intrinsics.checkParameterIsNotNull(biz, "biz");
        this.errCode = i;
        this.errorMsg = errorMsg;
        this.virtualAid = virtualAid;
        this.biz = biz;
    }

    public /* synthetic */ ContainerError(int i, String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3);
    }

    public final String getBiz() {
        return this.biz;
    }

    public final int getErrCode() {
        return this.errCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final String getVirtualAid() {
        return this.virtualAid;
    }

    public final ContainerInfo toContainerInfo() {
        return new ContainerInfo((Map<String, ? extends Object>) MapsKt.mapOf(TuplesKt.to("container_load_error_code", Integer.valueOf(this.errCode)), TuplesKt.to("container_load_error_msg", this.errorMsg)));
    }
}
