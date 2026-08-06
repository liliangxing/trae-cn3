package com.bytedance.trae.update;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* compiled from: AppUpdateChecker.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/update/AppUpdateChecker;", "", "<init>", "()V", "manualUpdateEnable", "", "checkUpdate", "", "autoCheck", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AppUpdateChecker {
    public static final AppUpdateChecker INSTANCE = new AppUpdateChecker();

    private AppUpdateChecker() {
    }

    public final boolean manualUpdateEnable() {
        IBitsUpdate iBitsUpdate = (IBitsUpdate) ServiceManager.get().getService(IBitsUpdate.class);
        if (iBitsUpdate != null) {
            return iBitsUpdate.manualUpdateEnable();
        }
        return false;
    }

    public final void checkUpdate(boolean autoCheck) {
        IBitsUpdate iBitsUpdate = (IBitsUpdate) ServiceManager.get().getService(IBitsUpdate.class);
        if (iBitsUpdate != null) {
            iBitsUpdate.checkUpdate(autoCheck);
        }
    }
}
