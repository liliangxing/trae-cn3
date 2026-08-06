package com.bytedance.trae.service;

import com.bytedance.trae.platform.ITraeSdkCommonDepend;
import kotlin.Metadata;

/* compiled from: TraeSdkCommonDependImpl.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/service/TraeSdkCommonDependImpl;", "Lcom/bytedance/trae/platform/ITraeSdkCommonDepend;", "<init>", "()V", "getApplogService", "Lcom/bytedance/trae/service/ApplogServiceImpl;", "getApmService", "Lcom/bytedance/trae/service/ApmServiceImpl;", "getCommonHttpService", "Lcom/bytedance/trae/service/SdkCommonHttpImpl;", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeSdkCommonDependImpl implements ITraeSdkCommonDepend {
    public static final int $stable = 0;

    @Override // com.bytedance.trae.platform.ITraeSdkCommonDepend
    public ApplogServiceImpl getApplogService() {
        return ApplogServiceImpl.INSTANCE;
    }

    @Override // com.bytedance.trae.platform.ITraeSdkCommonDepend
    public ApmServiceImpl getApmService() {
        return ApmServiceImpl.INSTANCE;
    }

    @Override // com.bytedance.trae.platform.ITraeSdkCommonDepend
    public SdkCommonHttpImpl getCommonHttpService() {
        return SdkCommonHttpImpl.INSTANCE;
    }
}
