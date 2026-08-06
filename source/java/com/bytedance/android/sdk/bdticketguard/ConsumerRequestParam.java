package com.bytedance.android.sdk.bdticketguard;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TicketGuardApiConsumer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B;\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/ConsumerRequestParam;", "Lcom/bytedance/android/sdk/bdticketguard/RequestParam;", "target", "", "host", "path", "ticketName", "reeOnly", "", "needEncrypt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getNeedEncrypt", "()Z", "getReeOnly", "getTarget", "()Ljava/lang/String;", "getTicketName", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public class ConsumerRequestParam extends RequestParam {
    private final boolean needEncrypt;
    private final boolean reeOnly;
    private final String target;
    private final String ticketName;

    public ConsumerRequestParam(String str, String str2, String str3, String str4) {
        this(str, str2, str3, str4, false, false, 48, null);
    }

    public ConsumerRequestParam(String str, String str2, String str3, String str4, boolean z) {
        this(str, str2, str3, str4, z, false, 32, null);
    }

    public final String getTarget() {
        return this.target;
    }

    public final String getTicketName() {
        return this.ticketName;
    }

    public final boolean getReeOnly() {
        return this.reeOnly;
    }

    public /* synthetic */ ConsumerRequestParam(String str, String str2, String str3, String str4, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i & 16) != 0 ? false : z, (i & 32) != 0 ? false : z2);
    }

    public final boolean getNeedEncrypt() {
        return this.needEncrypt;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerRequestParam(String target, String host, String path, String ticketName, boolean z, boolean z2) {
        super(host, path, 0L, 4, null);
        Intrinsics.checkParameterIsNotNull(target, "target");
        Intrinsics.checkParameterIsNotNull(host, "host");
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(ticketName, "ticketName");
        this.target = target;
        this.ticketName = ticketName;
        this.reeOnly = z;
        this.needEncrypt = z2;
    }
}
