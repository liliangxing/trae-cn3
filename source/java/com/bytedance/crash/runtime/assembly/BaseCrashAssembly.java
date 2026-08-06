package com.bytedance.crash.runtime.assembly;

import android.content.Context;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.entity.CrashBody;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BaseCrashAssembly extends BaseAssembly {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseCrashAssembly(CrashType crashType, Context context, ActivityDataManager activityDataManager, BatteryWatcher batteryWatcher) {
        super(crashType, context, activityDataManager, batteryWatcher);
    }

    @Override // com.bytedance.crash.runtime.assembly.BaseAssembly
    public CrashBody assemblyCrashBody(CrashBody crashBody) {
        return super.assemblyCrashBody(crashBody);
    }
}
