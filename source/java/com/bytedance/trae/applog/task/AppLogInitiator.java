package com.bytedance.trae.applog.task;

import com.bytedance.trae.applog.api.AppLogConfigInfo;
import com.bytedance.trae.applog.impl.AppLogHelper;
import com.bytedance.trae.applog.init.IAppLogInitiator;
import com.bytedance.trae.common.apphost.AppHost;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.applog.ApplogServiceImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppLogInitiator.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/applog/task/AppLogInitiator;", "Lcom/bytedance/trae/applog/init/IAppLogInitiator;", "<init>", "()V", "initAppLog", "", "configInfo", "Lcom/bytedance/trae/applog/api/AppLogConfigInfo;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AppLogInitiator implements IAppLogInitiator {
    @Override // com.bytedance.trae.applog.init.IAppLogInitiator
    public void initAppLog(AppLogConfigInfo configInfo) {
        Intrinsics.checkNotNullParameter(configInfo, "configInfo");
        AppLogHelper.INSTANCE.init(configInfo);
        if (AppHost.INSTANCE.isDebug() || AppHost.INSTANCE.isTestChannel()) {
            AppLogHelper.INSTANCE.openETVerify();
        }
        AppLog.setSwitchToBdtracker(true);
        ApplogServiceImpl.isServicePrepared = true;
        ApplogServiceImpl.handleCachedData();
    }
}
