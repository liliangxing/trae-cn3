package com.bytedance.trae.init.task;

import com.bytedance.lego.init.model.IInitTask;
import com.bytedance.trae.ServiceType;
import com.bytedance.trae.hotfix.ReparoHotPatchImpl;
import kotlin.Metadata;

/* compiled from: InitHotPatchTask.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/init/task/InitHotPatchTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "run", "", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InitHotPatchTask implements IInitTask {
    public static final int $stable = 0;
    private final String scene = ServiceType.BASIC_TEC;

    public final String getScene() {
        return this.scene;
    }

    @Override // java.lang.Runnable
    public void run() {
        ReparoHotPatchImpl.INSTANCE.init();
    }
}
