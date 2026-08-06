package com.bytedance.trae.network.quota;

import com.bytedance.trae.platform.api.ISdkAppStart;
import kotlin.Metadata;

/* compiled from: SdkAppStartServiceImpl.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/network/quota/SdkAppStartServiceImpl;", "Lcom/bytedance/trae/platform/api/ISdkAppStart;", "<init>", "()V", "getLastStartState", "", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SdkAppStartServiceImpl implements ISdkAppStart {
    public static final SdkAppStartServiceImpl INSTANCE = new SdkAppStartServiceImpl();

    private SdkAppStartServiceImpl() {
    }

    @Override // com.bytedance.trae.platform.api.ISdkAppStart
    public boolean isColdLaunch() {
        return ISdkAppStart.DefaultImpls.isColdLaunch(this);
    }

    @Override // com.bytedance.trae.platform.api.ISdkAppStart
    public int getLastStartState() {
        return AppStartManager.INSTANCE.getLastStartState().getValue();
    }
}
