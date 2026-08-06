package com.bytedance.kmp.network.p010public;

import kotlin.Metadata;

/* compiled from: KmpNetworkSetting.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/kmp/network/public/KmpNetworkSetting;", "", "()V", "disableTTNetLogReport", "", "getDisableTTNetLogReport", "()Z", "setDisableTTNetLogReport", "(Z)V", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpNetworkSetting {
    public static final KmpNetworkSetting INSTANCE = new KmpNetworkSetting();
    private static boolean disableTTNetLogReport;

    private KmpNetworkSetting() {
    }

    public final boolean getDisableTTNetLogReport() {
        return disableTTNetLogReport;
    }

    public final void setDisableTTNetLogReport(boolean z) {
        disableTTNetLogReport = z;
    }
}
