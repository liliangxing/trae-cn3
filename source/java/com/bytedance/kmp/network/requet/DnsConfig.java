package com.bytedance.kmp.network.requet;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestContext.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/kmp/network/requet/DnsConfig;", "", "()V", "backupIP", "", "getBackupIP", "()Ljava/lang/String;", "setBackupIP", "(Ljava/lang/String;)V", "preferIP", "getPreferIP", "setPreferIP", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DnsConfig {
    private String preferIP = "";
    private String backupIP = "";

    public final String getPreferIP() {
        return this.preferIP;
    }

    public final void setPreferIP(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.preferIP = str;
    }

    public final String getBackupIP() {
        return this.backupIP;
    }

    public final void setBackupIP(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.backupIP = str;
    }
}
