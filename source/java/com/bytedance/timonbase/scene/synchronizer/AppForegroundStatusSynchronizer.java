package com.bytedance.timonbase.scene.synchronizer;

import com.bytedance.timonbase.scene.lifecycle.ForegroundHolder;
import com.bytedance.timonbase.scene.lifecycle.ForegroundState;
import kotlin.Metadata;

/* compiled from: AppForegroundStatusSynchronizer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/timonbase/scene/synchronizer/AppForegroundStatusSynchronizer;", "Lcom/bytedance/timonbase/scene/synchronizer/ISenseStatusSynchronizer;", "Lcom/bytedance/timonbase/scene/lifecycle/ForegroundState;", "()V", "TAG", "", "state", "getCurrentSenseStatus", "updateSenseStatus", "", "newStatus", "", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AppForegroundStatusSynchronizer implements ISenseStatusSynchronizer<ForegroundState> {
    public static final AppForegroundStatusSynchronizer INSTANCE = new AppForegroundStatusSynchronizer();
    private static final String TAG = "AppForegroundStatusSync";
    private static ForegroundState state;

    private AppForegroundStatusSynchronizer() {
    }

    @Override // com.bytedance.timonbase.scene.synchronizer.ISenseStatusSynchronizer
    public void updateSenseStatus(Object newStatus) {
        if (newStatus instanceof ForegroundState) {
            state = (ForegroundState) newStatus;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.timonbase.scene.synchronizer.ISenseStatusSynchronizer
    public ForegroundState getCurrentSenseStatus() {
        ForegroundState foregroundState = state;
        if (foregroundState == null) {
            foregroundState = ForegroundHolder.INSTANCE.getForegroundState();
        }
        state = foregroundState;
        return foregroundState;
    }
}
