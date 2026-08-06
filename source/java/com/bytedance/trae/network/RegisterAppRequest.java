package com.bytedance.trae.network;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RegisterAppApi.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003Jt\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\nHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0016\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0016\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019¨\u0006-"}, d2 = {"Lcom/bytedance/trae/network/RegisterAppRequest;", "", "id", "", "name", "userId", "frontierid", "", "status", "appId", "", "appRuntimeType", "processId", "productId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;ILjava/lang/String;II)V", "getId", "()Ljava/lang/String;", "getName", "getUserId", "getFrontierid", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStatus", "getAppId", "()I", "getAppRuntimeType", "getProcessId", "getProductId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;ILjava/lang/String;II)Lcom/bytedance/trae/network/RegisterAppRequest;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RegisterAppRequest {

    @SerializedName("app_id")
    private final int appId;

    @SerializedName("app_runtime_type")
    private final String appRuntimeType;

    @SerializedName("frontier_id")
    private final Long frontierid;

    @SerializedName("id")
    private final String id;

    @SerializedName("name")
    private final String name;

    @SerializedName(CrashHianalyticsData.PROCESS_ID)
    private final int processId;

    @SerializedName("product_id")
    private final int productId;

    @SerializedName("status")
    private final String status;

    @SerializedName("user_id")
    private final String userId;

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getFrontierid() {
        return this.frontierid;
    }

    /* renamed from: component5, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component6, reason: from getter */
    public final int getAppId() {
        return this.appId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getAppRuntimeType() {
        return this.appRuntimeType;
    }

    /* renamed from: component8, reason: from getter */
    public final int getProcessId() {
        return this.processId;
    }

    /* renamed from: component9, reason: from getter */
    public final int getProductId() {
        return this.productId;
    }

    public final RegisterAppRequest copy(String id, String name, String userId, Long frontierid, String status, int appId, String appRuntimeType, int processId, int productId) {
        return new RegisterAppRequest(id, name, userId, frontierid, status, appId, appRuntimeType, processId, productId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegisterAppRequest)) {
            return false;
        }
        RegisterAppRequest registerAppRequest = (RegisterAppRequest) other;
        return Intrinsics.areEqual(this.id, registerAppRequest.id) && Intrinsics.areEqual(this.name, registerAppRequest.name) && Intrinsics.areEqual(this.userId, registerAppRequest.userId) && Intrinsics.areEqual(this.frontierid, registerAppRequest.frontierid) && Intrinsics.areEqual(this.status, registerAppRequest.status) && this.appId == registerAppRequest.appId && Intrinsics.areEqual(this.appRuntimeType, registerAppRequest.appRuntimeType) && this.processId == registerAppRequest.processId && this.productId == registerAppRequest.productId;
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.userId;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l = this.frontierid;
        int hashCode4 = (hashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        String str4 = this.status;
        int hashCode5 = (((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + Integer.hashCode(this.appId)) * 31;
        String str5 = this.appRuntimeType;
        return ((((hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31) + Integer.hashCode(this.processId)) * 31) + Integer.hashCode(this.productId);
    }

    public String toString() {
        return "RegisterAppRequest(id=" + this.id + ", name=" + this.name + ", userId=" + this.userId + ", frontierid=" + this.frontierid + ", status=" + this.status + ", appId=" + this.appId + ", appRuntimeType=" + this.appRuntimeType + ", processId=" + this.processId + ", productId=" + this.productId + ')';
    }

    public RegisterAppRequest(String str, String str2, String str3, Long l, String str4, int i, String str5, int i2, int i3) {
        this.id = str;
        this.name = str2;
        this.userId = str3;
        this.frontierid = l;
        this.status = str4;
        this.appId = i;
        this.appRuntimeType = str5;
        this.processId = i2;
        this.productId = i3;
    }

    public /* synthetic */ RegisterAppRequest(String str, String str2, String str3, Long l, String str4, int i, String str5, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) != 0 ? null : str3, (i4 & 8) != 0 ? null : l, (i4 & 16) != 0 ? "online" : str4, i, str5, i2, i3);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final Long getFrontierid() {
        return this.frontierid;
    }

    public final String getStatus() {
        return this.status;
    }

    public final int getAppId() {
        return this.appId;
    }

    public final String getAppRuntimeType() {
        return this.appRuntimeType;
    }

    public final int getProcessId() {
        return this.processId;
    }

    public final int getProductId() {
        return this.productId;
    }
}
