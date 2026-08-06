package com.bytedance.trae.home.solo.task;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TaskModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0019\u001a\u00020\u001aH×\u0001J\t\u0010\u001b\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/home/solo/task/DeviceInfo;", "", "cliId", "", "name", "type", "isOnline", "", "ideVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getCliId", "()Ljava/lang/String;", "getName", "getType", "()Z", "getIdeVersion", "component1", "component2", "component3", "component4", "component5", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DeviceInfo {
    public static final int $stable = 0;
    private final String cliId;
    private final String ideVersion;
    private final boolean isOnline;
    private final String name;
    private final String type;

    public static /* synthetic */ DeviceInfo copy$default(DeviceInfo deviceInfo, String str, String str2, String str3, boolean z, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceInfo.cliId;
        }
        if ((i & 2) != 0) {
            str2 = deviceInfo.name;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = deviceInfo.type;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            z = deviceInfo.isOnline;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            str4 = deviceInfo.ideVersion;
        }
        return deviceInfo.copy(str, str5, str6, z2, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCliId() {
        return this.cliId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsOnline() {
        return this.isOnline;
    }

    /* renamed from: component5, reason: from getter */
    public final String getIdeVersion() {
        return this.ideVersion;
    }

    public final DeviceInfo copy(String cliId, String name, String type, boolean isOnline, String ideVersion) {
        Intrinsics.checkNotNullParameter(cliId, "cliId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        return new DeviceInfo(cliId, name, type, isOnline, ideVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) other;
        return Intrinsics.areEqual(this.cliId, deviceInfo.cliId) && Intrinsics.areEqual(this.name, deviceInfo.name) && Intrinsics.areEqual(this.type, deviceInfo.type) && this.isOnline == deviceInfo.isOnline && Intrinsics.areEqual(this.ideVersion, deviceInfo.ideVersion);
    }

    public int hashCode() {
        int hashCode = ((((((this.cliId.hashCode() * 31) + this.name.hashCode()) * 31) + this.type.hashCode()) * 31) + Boolean.hashCode(this.isOnline)) * 31;
        String str = this.ideVersion;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "DeviceInfo(cliId=" + this.cliId + ", name=" + this.name + ", type=" + this.type + ", isOnline=" + this.isOnline + ", ideVersion=" + this.ideVersion + ')';
    }

    public DeviceInfo(String cliId, String name, String type, boolean z, String str) {
        Intrinsics.checkNotNullParameter(cliId, "cliId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        this.cliId = cliId;
        this.name = name;
        this.type = type;
        this.isOnline = z;
        this.ideVersion = str;
    }

    public /* synthetic */ DeviceInfo(String str, String str2, String str3, boolean z, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, z, (i & 16) != 0 ? null : str4);
    }

    public final String getCliId() {
        return this.cliId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean isOnline() {
        return this.isOnline;
    }

    public final String getIdeVersion() {
        return this.ideVersion;
    }
}
