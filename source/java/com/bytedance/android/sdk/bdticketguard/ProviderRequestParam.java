package com.bytedance.android.sdk.bdticketguard;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TicketGuardApiProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/ProviderRequestParam;", "Lcom/bytedance/android/sdk/bdticketguard/RequestParam;", "host", "", "path", "reeOnly", "", "needEncrypt", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "getNeedEncrypt", "()Z", "getReeOnly", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final class ProviderRequestParam extends RequestParam {
    private final boolean needEncrypt;
    private final boolean reeOnly;

    public ProviderRequestParam(String str, String str2) {
        this(str, str2, false, false, 12, null);
    }

    public ProviderRequestParam(String str, String str2, boolean z) {
        this(str, str2, z, false, 8, null);
    }

    public final boolean getReeOnly() {
        return this.reeOnly;
    }

    public /* synthetic */ ProviderRequestParam(String str, String str2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2);
    }

    public final boolean getNeedEncrypt() {
        return this.needEncrypt;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProviderRequestParam(String host, String path, boolean z, boolean z2) {
        super(host, path, 0L, 4, null);
        Intrinsics.checkParameterIsNotNull(host, "host");
        Intrinsics.checkParameterIsNotNull(path, "path");
        this.reeOnly = z;
        this.needEncrypt = z2;
    }
}
