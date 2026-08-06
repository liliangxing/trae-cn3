package com.bytedance.trae.login.enterprise;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterpriseAuthModels.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/login/enterprise/EnterpriseHostInfo;", "", "console", "", "api", "core", "remoteApi", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getConsole", "()Ljava/lang/String;", "getApi", "getCore", "getRemoteApi", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class EnterpriseHostInfo {

    @SerializedName("Api")
    private final String api;

    @SerializedName("Console")
    private final String console;

    @SerializedName("Core")
    private final String core;

    @SerializedName("RemoteApi")
    private final String remoteApi;

    public EnterpriseHostInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ EnterpriseHostInfo copy$default(EnterpriseHostInfo enterpriseHostInfo, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = enterpriseHostInfo.console;
        }
        if ((i & 2) != 0) {
            str2 = enterpriseHostInfo.api;
        }
        if ((i & 4) != 0) {
            str3 = enterpriseHostInfo.core;
        }
        if ((i & 8) != 0) {
            str4 = enterpriseHostInfo.remoteApi;
        }
        return enterpriseHostInfo.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getConsole() {
        return this.console;
    }

    /* renamed from: component2, reason: from getter */
    public final String getApi() {
        return this.api;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCore() {
        return this.core;
    }

    /* renamed from: component4, reason: from getter */
    public final String getRemoteApi() {
        return this.remoteApi;
    }

    public final EnterpriseHostInfo copy(String console, String api, String core, String remoteApi) {
        return new EnterpriseHostInfo(console, api, core, remoteApi);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnterpriseHostInfo)) {
            return false;
        }
        EnterpriseHostInfo enterpriseHostInfo = (EnterpriseHostInfo) other;
        return Intrinsics.areEqual(this.console, enterpriseHostInfo.console) && Intrinsics.areEqual(this.api, enterpriseHostInfo.api) && Intrinsics.areEqual(this.core, enterpriseHostInfo.core) && Intrinsics.areEqual(this.remoteApi, enterpriseHostInfo.remoteApi);
    }

    public int hashCode() {
        String str = this.console;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.api;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.core;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.remoteApi;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "EnterpriseHostInfo(console=" + this.console + ", api=" + this.api + ", core=" + this.core + ", remoteApi=" + this.remoteApi + ')';
    }

    public EnterpriseHostInfo(String str, String str2, String str3, String str4) {
        this.console = str;
        this.api = str2;
        this.core = str3;
        this.remoteApi = str4;
    }

    public /* synthetic */ EnterpriseHostInfo(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    public final String getConsole() {
        return this.console;
    }

    public final String getApi() {
        return this.api;
    }

    public final String getCore() {
        return this.core;
    }

    public final String getRemoteApi() {
        return this.remoteApi;
    }
}
