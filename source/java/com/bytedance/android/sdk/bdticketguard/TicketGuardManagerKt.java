package com.bytedance.android.sdk.bdticketguard;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: TicketGuardManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"REE_RECOVER_ERROR_CODE", "", "", "getREE_RECOVER_ERROR_CODE", "()Ljava/util/List;", "SCENE_INIT", "SCENE_NETWORK", "SCENE_TICKET_NETWORK", "bd_ticket_guard_api_release"}, k = 2, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class TicketGuardManagerKt {
    private static final List<String> REE_RECOVER_ERROR_CODE = CollectionsKt.listOf(new String[]{"1103", "1002", "1003", "1102"});
    public static final String SCENE_INIT = "init";
    public static final String SCENE_NETWORK = "network";
    public static final String SCENE_TICKET_NETWORK = "ticket_network";

    public static final List<String> getREE_RECOVER_ERROR_CODE() {
        return REE_RECOVER_ERROR_CODE;
    }
}
