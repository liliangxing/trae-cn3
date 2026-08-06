package com.bytedance.trae.init.task;

import com.bytedance.lego.init.model.IInitTask;
import com.bytedance.trae.FirstInitStyle;
import com.bytedance.trae.ServiceType;
import com.bytedance.trae.init.task.base.IInitReportTask;
import com.larus.init.IAbTestInitiator;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* compiled from: InitAbTestSdkTask.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \r2\u00020\u00012\u00020\u0002:\u0001\rB\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/init/task/InitAbTestSdkTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/bytedance/trae/init/task/base/IInitReportTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "firstStyle", "getFirstStyle", "runInternal", "", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InitAbTestSdkTask implements IInitTask, IInitReportTask {
    public static final int $stable = 0;
    public static final String TAG = "InitAbTestTask";
    private final String scene = ServiceType.BASIC_TEC;
    private final String firstStyle = FirstInitStyle.AsyncThreadWhenFirst;

    @Override // com.bytedance.trae.init.task.base.IInitReportTask
    public boolean checkFirstStartAsyncTaskInit(String str) {
        return IInitReportTask.DefaultImpls.checkFirstStartAsyncTaskInit(this, str);
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
    public String getFirstStyle() {
        return this.firstStyle;
    }

    @Override // com.bytedance.trae.init.task.base.IInitReportTask
    public void runInternal() {
        IAbTestInitiator iAbTestInitiator = (IAbTestInitiator) ServiceManager.get().getService(IAbTestInitiator.class);
        if (iAbTestInitiator != null) {
            iAbTestInitiator.initAbTest();
        }
    }
}
