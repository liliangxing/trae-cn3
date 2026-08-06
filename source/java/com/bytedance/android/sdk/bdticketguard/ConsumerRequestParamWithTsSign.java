package com.bytedance.android.sdk.bdticketguard;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TicketGuardApiConsumer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001BC\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/ConsumerRequestParamWithTsSign;", "Lcom/bytedance/android/sdk/bdticketguard/ConsumerRequestParam;", "tsSign", "", "target", "host", "path", "ticketName", "reeOnly", "", "needEncrypt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getTsSign", "()Ljava/lang/String;", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final class ConsumerRequestParamWithTsSign extends ConsumerRequestParam {
    private final String tsSign;

    public ConsumerRequestParamWithTsSign(String str, String str2, String str3, String str4, String str5) {
        this(str, str2, str3, str4, str5, false, false, 96, null);
    }

    public ConsumerRequestParamWithTsSign(String str, String str2, String str3, String str4, String str5, boolean z) {
        this(str, str2, str3, str4, str5, z, false, 64, null);
    }

    public final String getTsSign() {
        return this.tsSign;
    }

    public /* synthetic */ ConsumerRequestParamWithTsSign(String str, String str2, String str3, String str4, String str5, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, (i & 32) != 0 ? false : z, (i & 64) != 0 ? false : z2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerRequestParamWithTsSign(String tsSign, String target, String host, String path, String ticketName, boolean z, boolean z2) {
        super(target, host, path, ticketName, z, z2);
        Intrinsics.checkParameterIsNotNull(tsSign, "tsSign");
        Intrinsics.checkParameterIsNotNull(target, "target");
        Intrinsics.checkParameterIsNotNull(host, "host");
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(ticketName, "ticketName");
        this.tsSign = tsSign;
    }
}
