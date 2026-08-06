package com.bytedance.sdk.xbridge.cn.storage.utils;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StorageValue.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ.\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/utils/StorageValue;", "", "type", "", "value", "expiredTime", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getExpiredTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getType", "()Ljava/lang/String;", "getValue", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/bytedance/sdk/xbridge/cn/storage/utils/StorageValue;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class StorageValue {

    @SerializedName("expired_time")
    private final Long expiredTime;

    @SerializedName("type")
    private final String type;

    @SerializedName("value")
    private final String value;

    public static /* synthetic */ StorageValue copy$default(StorageValue storageValue, String str, String str2, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = storageValue.type;
        }
        if ((i & 2) != 0) {
            str2 = storageValue.value;
        }
        if ((i & 4) != 0) {
            l = storageValue.expiredTime;
        }
        return storageValue.copy(str, str2, l);
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
    public final Long getExpiredTime() {
        return this.expiredTime;
    }

    public final StorageValue copy(String type, String value, Long expiredTime) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        return new StorageValue(type, value, expiredTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StorageValue)) {
            return false;
        }
        StorageValue storageValue = (StorageValue) other;
        return Intrinsics.areEqual(this.type, storageValue.type) && Intrinsics.areEqual(this.value, storageValue.value) && Intrinsics.areEqual(this.expiredTime, storageValue.expiredTime);
    }

    public int hashCode() {
        int hashCode = ((this.type.hashCode() * 31) + this.value.hashCode()) * 31;
        Long l = this.expiredTime;
        return hashCode + (l == null ? 0 : l.hashCode());
    }

    public String toString() {
        return "StorageValue(type=" + this.type + ", value=" + this.value + ", expiredTime=" + this.expiredTime + ')';
    }

    public StorageValue(String type, String value, Long l) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        this.type = type;
        this.value = value;
        this.expiredTime = l;
    }

    public /* synthetic */ StorageValue(String str, String str2, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : l);
    }

    public final Long getExpiredTime() {
        return this.expiredTime;
    }

    public final String getType() {
        return this.type;
    }

    public final String getValue() {
        return this.value;
    }
}
