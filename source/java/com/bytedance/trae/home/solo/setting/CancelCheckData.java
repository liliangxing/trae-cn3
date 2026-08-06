package com.bytedance.trae.home.solo.setting;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccountCancelApi.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\r\u001a\u00020\u000eH×\u0001J\t\u0010\u000f\u001a\u00020\u0003H×\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/CancelCheckData;", "", "cancelTicket", "", "<init>", "(Ljava/lang/String;)V", "getCancelTicket", "()Ljava/lang/String;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CancelCheckData {
    public static final int $stable = 0;

    @SerializedName("cancel_ticket")
    private final String cancelTicket;

    /* JADX WARN: Multi-variable type inference failed */
    public CancelCheckData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CancelCheckData copy$default(CancelCheckData cancelCheckData, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cancelCheckData.cancelTicket;
        }
        return cancelCheckData.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCancelTicket() {
        return this.cancelTicket;
    }

    public final CancelCheckData copy(String cancelTicket) {
        return new CancelCheckData(cancelTicket);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CancelCheckData) && Intrinsics.areEqual(this.cancelTicket, ((CancelCheckData) other).cancelTicket);
    }

    public int hashCode() {
        String str = this.cancelTicket;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "CancelCheckData(cancelTicket=" + this.cancelTicket + ')';
    }

    public CancelCheckData(String str) {
        this.cancelTicket = str;
    }

    public /* synthetic */ CancelCheckData(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getCancelTicket() {
        return this.cancelTicket;
    }
}
