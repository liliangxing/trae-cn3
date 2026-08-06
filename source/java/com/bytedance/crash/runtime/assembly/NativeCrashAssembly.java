package com.bytedance.crash.runtime.assembly;

import android.content.Context;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.entity.CrashBody;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
class NativeCrashAssembly extends BaseAssembly {
    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeCrashAssembly(Context context, ActivityDataManager activityDataManager, BatteryWatcher batteryWatcher) {
        super(CrashType.NATIVE, context, activityDataManager, batteryWatcher);
    }

    @Override // com.bytedance.crash.runtime.assembly.BaseAssembly
    public CrashBody assemblyCrashBodyInner(int i, CrashBody crashBody) {
        return super.assemblyCrashBodyInner(i, crashBody);
    }
}
