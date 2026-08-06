package com.bytedance.sdk.xbridge.cn.storage.utils;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserDomainStorageValue.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJV\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\""}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/utils/UserDomainStorageValue;", "", "type", "", "value", "created_name", "", "lastAccessTime", "lastModifiedTime", "expiredTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getCreated_name", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExpiredTime", "getLastAccessTime", "getLastModifiedTime", "getType", "()Ljava/lang/String;", "getValue", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/bytedance/sdk/xbridge/cn/storage/utils/UserDomainStorageValue;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UserDomainStorageValue {

    @SerializedName("created_time")
    private final Long created_name;

    @SerializedName("expired_time")
    private final Long expiredTime;

    @SerializedName("last_access_time")
    private final Long lastAccessTime;

    @SerializedName("last_modified_time")
    private final Long lastModifiedTime;

    @SerializedName("type")
    private final String type;

    @SerializedName("value")
    private final String value;

    public UserDomainStorageValue() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ UserDomainStorageValue copy$default(UserDomainStorageValue userDomainStorageValue, String str, String str2, Long l, Long l2, Long l3, Long l4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userDomainStorageValue.type;
        }
        if ((i & 2) != 0) {
            str2 = userDomainStorageValue.value;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            l = userDomainStorageValue.created_name;
        }
        Long l5 = l;
        if ((i & 8) != 0) {
            l2 = userDomainStorageValue.lastAccessTime;
        }
        Long l6 = l2;
        if ((i & 16) != 0) {
            l3 = userDomainStorageValue.lastModifiedTime;
        }
        Long l7 = l3;
        if ((i & 32) != 0) {
            l4 = userDomainStorageValue.expiredTime;
        }
        return userDomainStorageValue.copy(str, str3, l5, l6, l7, l4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getCreated_name() {
        return this.created_name;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getLastAccessTime() {
        return this.lastAccessTime;
    }

    /* renamed from: component5, reason: from getter */
    public final Long getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    /* renamed from: component6, reason: from getter */
    public final Long getExpiredTime() {
        return this.expiredTime;
    }

    public final UserDomainStorageValue copy(String type, String value, Long created_name, Long lastAccessTime, Long lastModifiedTime, Long expiredTime) {
        return new UserDomainStorageValue(type, value, created_name, lastAccessTime, lastModifiedTime, expiredTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserDomainStorageValue)) {
            return false;
        }
        UserDomainStorageValue userDomainStorageValue = (UserDomainStorageValue) other;
        return Intrinsics.areEqual(this.type, userDomainStorageValue.type) && Intrinsics.areEqual(this.value, userDomainStorageValue.value) && Intrinsics.areEqual(this.created_name, userDomainStorageValue.created_name) && Intrinsics.areEqual(this.lastAccessTime, userDomainStorageValue.lastAccessTime) && Intrinsics.areEqual(this.lastModifiedTime, userDomainStorageValue.lastModifiedTime) && Intrinsics.areEqual(this.expiredTime, userDomainStorageValue.expiredTime);
    }

    public int hashCode() {
        String str = this.type;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.value;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.created_name;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.lastAccessTime;
        int hashCode4 = (hashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.lastModifiedTime;
        int hashCode5 = (hashCode4 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.expiredTime;
        return hashCode5 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        return "UserDomainStorageValue(type=" + this.type + ", value=" + this.value + ", created_name=" + this.created_name + ", lastAccessTime=" + this.lastAccessTime + ", lastModifiedTime=" + this.lastModifiedTime + ", expiredTime=" + this.expiredTime + ')';
    }

    public UserDomainStorageValue(String str, String str2, Long l, Long l2, Long l3, Long l4) {
        this.type = str;
        this.value = str2;
        this.created_name = l;
        this.lastAccessTime = l2;
        this.lastModifiedTime = l3;
        this.expiredTime = l4;
    }

    public /* synthetic */ UserDomainStorageValue(String str, String str2, Long l, Long l2, Long l3, Long l4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : l2, (i & 16) != 0 ? null : l3, (i & 32) != 0 ? null : l4);
    }

    public final String getType() {
        return this.type;
    }

    public final String getValue() {
        return this.value;
    }

    public final Long getCreated_name() {
        return this.created_name;
    }

    public final Long getLastAccessTime() {
        return this.lastAccessTime;
    }

    public final Long getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public final Long getExpiredTime() {
        return this.expiredTime;
    }
}
