package com.bytedance.trae.network.quota;

import com.ss.android.ugc.quota.IBDNetworkTagDepend;
import com.ss.android.ugc.quota.launch.IBDNetworkLaunchMonitor;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitQuotaTaskHelper.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/network/quota/InitQuotaTaskHelper;", "", "<init>", "()V", "getBDNetworkTagDependImpl", "Lcom/ss/android/ugc/quota/IBDNetworkTagDepend;", "lazyType", "", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InitQuotaTaskHelper {
    public static final InitQuotaTaskHelper INSTANCE = new InitQuotaTaskHelper();

    private InitQuotaTaskHelper() {
    }

    @JvmStatic
    public static final IBDNetworkTagDepend getBDNetworkTagDependImpl(String lazyType) {
        Intrinsics.checkNotNullParameter(lazyType, "lazyType");
        return new IBDNetworkTagDepend() { // from class: com.bytedance.trae.network.quota.InitQuotaTaskHelper$getBDNetworkTagDependImpl$1
            @Override // com.ss.android.ugc.quota.IBDNetworkTagDepend
            public boolean enable() {
                return true;
            }

            @Override // com.ss.android.ugc.quota.IBDNetworkTagDepend
            public void onLaunchTypeUpdate(int launchType) {
            }

            @Override // com.ss.android.ugc.quota.IBDNetworkTagDepend
            public boolean isNewInstall() {
                return AppInfoProvider.INSTANCE.isFirstStartApp();
            }

            @Override // com.ss.android.ugc.quota.IBDNetworkTagDepend
            public IBDNetworkLaunchMonitor launchMonitor() {
                return AppStartManager.INSTANCE;
            }
        };
    }
}
