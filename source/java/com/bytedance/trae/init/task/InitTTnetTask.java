package com.bytedance.trae.init.task;

import com.bytedance.lego.init.model.IInitTask;
import com.bytedance.trae.FirstInitStyle;
import com.bytedance.trae.ServiceType;
import com.bytedance.trae.init.config.TTNetConfig;
import com.bytedance.trae.init.task.base.IInitReportTask;
import com.bytedance.trae.network.ConnectionTypeListener;
import com.bytedance.trae.network.TraeTTNet;
import java.util.List;
import kotlin.Metadata;

/* compiled from: InitTTnetTask.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/init/task/InitTTnetTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/bytedance/trae/init/task/base/IInitReportTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "firstStyle", "getFirstStyle", "runInternal", "", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InitTTnetTask implements IInitTask, IInitReportTask {
    public static final int $stable = 0;
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
        TraeTTNet.init$default(TraeTTNet.INSTANCE, TTNetConfig.INSTANCE.getConfigServers(), TTNetConfig.INSTANCE.getServiceDomainMap(), false, (List) null, 8, (Object) null);
        TraeTTNet.INSTANCE.addConnectionTypeListener(new ConnectionTypeListener() { // from class: com.bytedance.trae.init.task.InitTTnetTask$runInternal$1
            public void onEffectiveConnectionTypeChanged(int type) {
            }
        });
    }
}
