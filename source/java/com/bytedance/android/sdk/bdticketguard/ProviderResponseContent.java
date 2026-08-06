package com.bytedance.android.sdk.bdticketguard;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TicketGuardApiProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/ProviderResponseContent;", "Lcom/bytedance/android/sdk/bdticketguard/ResponseContent;", "Lcom/bytedance/android/sdk/bdticketguard/HandleProviderResponseParam;", "handleProviderResponseParam", "logid", "", "serverDataStr", "serverData", "Lcom/bytedance/android/sdk/bdticketguard/ServerData;", "ticketData", "", "Lcom/bytedance/android/sdk/bdticketguard/TicketData;", "responseCert", "(Lcom/bytedance/android/sdk/bdticketguard/HandleProviderResponseParam;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/sdk/bdticketguard/ServerData;Ljava/util/List;Ljava/lang/String;)V", "getResponseCert", "()Ljava/lang/String;", "getServerData", "()Lcom/bytedance/android/sdk/bdticketguard/ServerData;", "getServerDataStr", "getTicketData", "()Ljava/util/List;", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ProviderResponseContent extends ResponseContent<HandleProviderResponseParam> {
    private final String responseCert;
    private final ServerData serverData;
    private final String serverDataStr;
    private final List<TicketData> ticketData;

    public final String getServerDataStr() {
        return this.serverDataStr;
    }

    public final ServerData getServerData() {
        return this.serverData;
    }

    public final List<TicketData> getTicketData() {
        return this.ticketData;
    }

    public final String getResponseCert() {
        return this.responseCert;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProviderResponseContent(HandleProviderResponseParam handleProviderResponseParam, String str, String str2, ServerData serverData, List<TicketData> list, String str3) {
        super(handleProviderResponseParam, str, 0L, 4, null);
        Intrinsics.checkParameterIsNotNull(handleProviderResponseParam, "handleProviderResponseParam");
        Intrinsics.checkParameterIsNotNull(str, "logid");
        Intrinsics.checkParameterIsNotNull(str2, "serverDataStr");
        this.serverDataStr = str2;
        this.serverData = serverData;
        this.ticketData = list;
        this.responseCert = str3;
    }
}
