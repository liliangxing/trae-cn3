package com.bytedance.ies.xbridge.base.runtime.depend;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IHostNaviDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/BackPressConfig;", "", "disableBackPress", "", "(Ljava/lang/Integer;)V", "getDisableBackPress", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/bytedance/ies/xbridge/base/runtime/depend/BackPressConfig;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BackPressConfig {
    private final Integer disableBackPress;

    /* JADX WARN: Multi-variable type inference failed */
    public BackPressConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BackPressConfig copy$default(BackPressConfig backPressConfig, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = backPressConfig.disableBackPress;
        }
        return backPressConfig.copy(num);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getDisableBackPress() {
        return this.disableBackPress;
    }

    public final BackPressConfig copy(Integer disableBackPress) {
        return new BackPressConfig(disableBackPress);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof BackPressConfig) && Intrinsics.areEqual(this.disableBackPress, ((BackPressConfig) other).disableBackPress);
    }

    public int hashCode() {
        Integer num = this.disableBackPress;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public String toString() {
        return "BackPressConfig(disableBackPress=" + this.disableBackPress + ')';
    }

    public BackPressConfig(Integer num) {
        this.disableBackPress = num;
    }

    public /* synthetic */ BackPressConfig(Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num);
    }

    public final Integer getDisableBackPress() {
        return this.disableBackPress;
    }
}
