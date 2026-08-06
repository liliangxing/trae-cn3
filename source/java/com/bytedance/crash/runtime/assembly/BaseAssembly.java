package com.bytedance.crash.runtime.assembly;

import android.content.Context;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.entity.CrashBody;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class BaseAssembly {
    public static final String INTERFACE_ERR_INFO = "Code err:\n";
    protected ICommonParams iCommonParams;
    protected ActivityDataManager mActivityDataManager;
    protected BatteryWatcher mBatteryWatcher;
    protected Context mContext;
    protected CrashType mCrashType;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface AssemblyCallback {
        CrashBody afterAssembly(int i, CrashBody crashBody, boolean z);

        CrashBody beforeAssembly(int i, CrashBody crashBody);

        void onException(Throwable th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CrashBody assemblyCrashBody(CrashBody crashBody) {
        return crashBody;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CrashBody assemblyCrashBodyInner(int i, CrashBody crashBody) {
        return crashBody;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseAssembly(CrashType crashType, Context context, ActivityDataManager activityDataManager, BatteryWatcher batteryWatcher) {
    }

    public CrashBody assemblyCrashBody(CrashBody crashBody, AssemblyCallback assemblyCallback, boolean z) {
        return crashBody == null ? new CrashBody() : crashBody;
    }
}
