package com.bytedance.trae.applog.impl;

import com.bytedance.applog.AppLog;
import com.bytedance.applog.IAppLogInstance;
import com.bytedance.trae.applog.api.IMultiInstanceAppLog;
import com.bytedance.trae.applog.api.IMultiInstanceAppLogService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MultiInstanceAppLogServiceImpl.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/applog/impl/MultiInstanceAppLogServiceImpl;", "Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService;", "<init>", "()V", "createInstance", "Lcom/bytedance/trae/applog/api/IMultiInstanceAppLog;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MultiInstanceAppLogServiceImpl implements IMultiInstanceAppLogService {
    @Override // com.bytedance.trae.applog.api.IMultiInstanceAppLogService
    public IMultiInstanceAppLog createInstance() {
        IAppLogInstance newInstance = AppLog.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
        return new MultiInstanceAppLog(newInstance);
    }
}
