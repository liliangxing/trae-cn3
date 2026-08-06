package com.bytedance.trae.init.task;

import com.bytedance.lego.init.model.IInitTask;
import com.bytedance.timonbase.TMInitialExtra;
import com.bytedance.timonkit.Timon;
import com.bytedance.trae.ServiceType;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.home.privacy.PrivacyManager;
import com.bytedance.trae.init.task.base.IInitReportTask;
import com.bytedance.upc.Configuration;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: InitTimonTask.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/init/task/InitTimonTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/bytedance/trae/init/task/base/IInitReportTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "runInternal", "", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InitTimonTask implements IInitTask, IInitReportTask {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean runInternal$lambda$0() {
        return PrivacyManager.INSTANCE.checkAgreed();
    }

    @Override // com.bytedance.trae.init.task.base.IInitReportTask
    public void runInternal() {
        Timon.INSTANCE.registerAgreedPrivacyReferee(new Function0() { // from class: com.bytedance.trae.init.task.InitTimonTask$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean runInternal$lambda$0;
                runInternal$lambda$0 = InitTimonTask.runInternal$lambda$0();
                return Boolean.valueOf(runInternal$lambda$0);
            }
        });
        Timon.INSTANCE.enableClipboardCompliance(true);
        Timon.INSTANCE.init(AppHost.INSTANCE.getBuildChannel(), AppHost.INSTANCE.getAppId(), new Function0() { // from class: com.bytedance.trae.init.task.InitTimonTask$$ExternalSyntheticLambda1
            public final Object invoke() {
                String runInternal$lambda$1;
                runInternal$lambda$1 = InitTimonTask.runInternal$lambda$1();
                return runInternal$lambda$1;
            }
        }, AppHost.INSTANCE.getApplication(), new TMInitialExtra(AppHost.INSTANCE.getVersionName(), AppHost.INSTANCE.getVersionCode(), AppHost.INSTANCE.getUpdateVersionCode(), new Configuration.Builder().build(), false, null, null, false, 240, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String runInternal$lambda$1() {
        return IApplog.INSTANCE.getDeviceId();
    }
}
