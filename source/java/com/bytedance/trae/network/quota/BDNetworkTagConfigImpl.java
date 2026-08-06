package com.bytedance.trae.network.quota;

import android.app.Application;
import com.bytedance.trae.common.apphost.AppHost;
import com.ss.android.ugc.quota.IBDNetworkTagConfig;
import com.ss.android.ugc.quota.IBDNetworkTagDepend;
import kotlin.Metadata;

/* compiled from: BDNetworkTagConfigImpl.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/network/quota/BDNetworkTagConfigImpl;", "Lcom/ss/android/ugc/quota/IBDNetworkTagConfig;", "<init>", "()V", "getApplication", "Landroid/app/Application;", "getTagDepend", "Lcom/ss/android/ugc/quota/IBDNetworkTagDepend;", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BDNetworkTagConfigImpl implements IBDNetworkTagConfig {
    public Application getApplication() {
        return AppHost.Companion.getApplication();
    }

    public IBDNetworkTagDepend getTagDepend() {
        return InitQuotaTaskHelper.getBDNetworkTagDependImpl("open");
    }
}
