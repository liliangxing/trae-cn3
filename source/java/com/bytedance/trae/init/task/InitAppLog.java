package com.bytedance.trae.init.task;

import android.text.TextUtils;
import com.bytedance.lego.init.model.IInitTask;
import com.bytedance.trae.ServiceType;
import com.bytedance.trae.applog.api.AppLogConfigInfo;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.applog.api.OnGetAppLogIdListener;
import com.bytedance.trae.applog.init.IAppLogInitiator;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.init.task.base.IInitReportTask;
import com.bytedance.trae.login.traeauth.LazyLoginBindDevice;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitAppLog.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/init/task/InitAppLog;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/bytedance/trae/init/task/base/IInitReportTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "runInternal", "", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InitAppLog implements IInitTask, IInitReportTask {
    public static final int $stable = 0;
    private final String scene = ServiceType.BASIC_TEC;

    @Override // com.bytedance.trae.init.task.base.IInitReportTask
    public boolean checkFirstStartAsyncTaskInit(String str) {
        return IInitReportTask.DefaultImpls.checkFirstStartAsyncTaskInit(this, str);
    }

    @Override // com.bytedance.trae.init.task.base.IInitReportTask
    public String getFirstStyle() {
        return IInitReportTask.DefaultImpls.getFirstStyle(this);
    }

    @Override // com.bytedance.trae.init.task.base.IInitReportTask, java.lang.Runnable
    public void run() {
        IInitReportTask.DefaultImpls.run(this);
    }

    @Override // com.bytedance.trae.init.task.base.IInitReportTask
    public String getScene() {
        return this.scene;
    }

    @Override // com.bytedance.trae.init.task.base.IInitReportTask
    public void runInternal() {
        IApplog.INSTANCE.addGetAppLogIdListener(new OnGetAppLogIdListener() { // from class: com.bytedance.trae.init.task.InitAppLog$runInternal$1
            @Override // com.bytedance.trae.applog.api.OnGetAppLogIdListener
            public void onGetId(String did, String iid, String ssid) {
                Intrinsics.checkNotNullParameter(did, "did");
                Intrinsics.checkNotNullParameter(iid, "iid");
                Intrinsics.checkNotNullParameter(ssid, "ssid");
                if (TextUtils.isEmpty(did)) {
                    return;
                }
                LazyLoginBindDevice.onDidGet();
            }
        });
        IAppLogInitiator iAppLogInitiator = (IAppLogInitiator) ServiceManager.get().getService(IAppLogInitiator.class);
        if (iAppLogInitiator != null) {
            iAppLogInitiator.initAppLog(new AppLogConfigInfo(AppHost.INSTANCE.getAppId(), AppHost.INSTANCE.getAppName(), AppHost.INSTANCE.getVersionCode(), AppHost.INSTANCE.getVersionName(), AppHost.INSTANCE.getUpdateVersionCode(), AppHost.INSTANCE.getBuildChannel(), false, false, false, false, false, false, 100, 5000L, 60000L, false, false, false));
        }
        TrackerCommonParams.INSTANCE.register();
    }
}
