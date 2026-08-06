package com.bytedance.trae.init.task;

import com.bytedance.lego.init.model.IInitTask;
import com.bytedance.trae.ServiceType;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.applog.api.OnGetAppLogIdListener;
import com.bytedance.trae.hotfix.ReparoHotPatchImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitLoadRemoteHotPatchTask.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/init/task/InitLoadRemoteHotPatchTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "<init>", "()V", "TAG", "", "scene", "getScene", "()Ljava/lang/String;", "run", "", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InitLoadRemoteHotPatchTask implements IInitTask {
    public static final int $stable = 0;
    private final String TAG = "LoadRemoteHotPatch";
    private final String scene = ServiceType.BASIC_TEC;

    public final String getScene() {
        return this.scene;
    }

    public void run() {
        if (IApplog.INSTANCE.getDeviceId().length() > 0) {
            ReparoHotPatchImpl.INSTANCE.loadRemotePatch();
        } else {
            IApplog.INSTANCE.addGetAppLogIdListener(new OnGetAppLogIdListener() { // from class: com.bytedance.trae.init.task.InitLoadRemoteHotPatchTask$run$1
                @Override // com.bytedance.trae.applog.api.OnGetAppLogIdListener
                public void onGetId(String did, String iid, String ssid) {
                    Intrinsics.checkNotNullParameter(did, "did");
                    Intrinsics.checkNotNullParameter(iid, "iid");
                    Intrinsics.checkNotNullParameter(ssid, "ssid");
                    ReparoHotPatchImpl.INSTANCE.loadRemotePatch();
                }
            });
        }
    }
}
