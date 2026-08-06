package com.bytedance.sdk.open.aweme.core;

import android.content.Context;
import android.util.Pair;
import java.util.List;

/* loaded from: classes5.dex */
public interface OpenSdkTicketService extends IOpenService {
    void enableDefaultTicketGuard();

    String getClientTicket(String str);

    List<Pair<String, String>> getHeaderForCTK(String str, String str2);

    OpenResult<List<Pair<String, String>>> getHeaderForCTKWithRefresh(String str, String str2);

    void initTicketGuard(Context context);

    void removeClientTicket(String str);
}
