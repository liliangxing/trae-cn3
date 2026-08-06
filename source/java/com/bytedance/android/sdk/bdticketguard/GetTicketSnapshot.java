package com.bytedance.android.sdk.bdticketguard;

import com.bytedance.android.sdk.bdticketguard.TicketDataBean;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Snapshot.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/GetTicketSnapshot;", "Lcom/bytedance/android/sdk/bdticketguard/CommonSnapshot;", "providerResponseContent", "Lcom/bytedance/android/sdk/bdticketguard/ProviderResponseContent;", "(Lcom/bytedance/android/sdk/bdticketguard/ProviderResponseContent;)V", "response_ticket_data", "", "getResponse_ticket_data", "()Ljava/lang/String;", "server_data", "getServer_data", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GetTicketSnapshot extends CommonSnapshot {

    @SerializedName("response_ticket_data")
    private final String response_ticket_data;

    @SerializedName("server_data")
    private final String server_data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetTicketSnapshot(ProviderResponseContent providerResponseContent) {
        super(providerResponseContent);
        Intrinsics.checkParameterIsNotNull(providerResponseContent, "providerResponseContent");
        this.server_data = SnapshotKt.mask(providerResponseContent.getServerDataStr());
        StringBuilder sb = new StringBuilder();
        List<TicketData> ticketData = providerResponseContent.getTicketData();
        if (ticketData != null) {
            for (TicketData ticketData2 : ticketData) {
                TicketDataBean.CombineTsSign combineTsSign = (TicketDataBean.CombineTsSign) TicketGuardApiKt.getGson().fromJson(ticketData2.getTs_sign(), TicketDataBean.CombineTsSign.class);
                StringBuilder append = new StringBuilder(";").append(SnapshotKt.mask(ticketData2.getTicket())).append(':');
                String ts_sign = combineTsSign.getTs_sign();
                String str = null;
                StringBuilder append2 = append.append(ts_sign != null ? SnapshotKt.mask(ts_sign) : null).append(':');
                String ts_sign_ree = combineTsSign.getTs_sign_ree();
                if (ts_sign_ree != null) {
                    str = SnapshotKt.mask(ts_sign_ree);
                }
                sb.append(append2.append(str).toString());
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "sb.toString()");
        Intrinsics.checkExpressionValueIsNotNull(sb2, "run {\n            val sb…  sb.toString()\n        }");
        this.response_ticket_data = sb2;
    }

    public final String getServer_data() {
        return this.server_data;
    }

    public final String getResponse_ticket_data() {
        return this.response_ticket_data;
    }
}
