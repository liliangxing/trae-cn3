package com.bytedance.bdinstall.ticket;

import android.util.Pair;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public interface ITicketGuard {
    List<Pair<String, String>> consumerTicketData(String str, String str2, String str3, boolean z);

    byte[] decryptTicket(byte[] bArr);

    Map<String, Long> getTimestamp();

    List<Map<String, String>> handleProviderResponse(long j, String str, String str2, boolean z, List<Pair<String, String>> list, String str3);

    void init(TicketInitCallback ticketInitCallback);

    List<Pair<String, String>> providerTicketHeader(String str, boolean z, boolean z2, String str2);
}
