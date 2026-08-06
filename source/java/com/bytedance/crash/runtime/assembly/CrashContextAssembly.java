package com.bytedance.crash.runtime.assembly;

import android.content.Context;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.NpthBus;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.runtime.assembly.BaseAssembly;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CrashContextAssembly {
    private static volatile CrashContextAssembly sIns;
    private ActivityDataManager mActivityDataManager;
    private BatteryWatcher mBatteryWatcher;
    private final Context mContext;
    private final Map<CrashType, BaseAssembly> mCrashAssemblyMap = new HashMap();

    private CrashContextAssembly(Context context) {
        this.mContext = context;
        try {
            this.mActivityDataManager = ActivityDataManager.getInstance();
            this.mBatteryWatcher = new BatteryWatcher(context);
        } catch (Throwable th) {
            NpthMonitor.reportInnerException(th);
        }
    }

    public static CrashContextAssembly getInstance() {
        if (sIns == null) {
            Context applicationContext = NpthBus.getApplicationContext();
            if (applicationContext == null) {
                throw new IllegalArgumentException("NpthBus not init");
            }
            sIns = new CrashContextAssembly(applicationContext);
        }
        return sIns;
    }

    private BaseAssembly getAssembly(CrashType crashType) {
        BaseAssembly baseAssembly = this.mCrashAssemblyMap.get(crashType);
        if (baseAssembly != null) {
            return baseAssembly;
        }
        switch (C10032.$SwitchMap$com$bytedance$crash$CrashType[crashType.ordinal()]) {
            case 1:
                baseAssembly = new JavaCrashAssembly(this.mContext, this.mActivityDataManager, this.mBatteryWatcher, false);
                break;
            case 2:
                baseAssembly = new JavaCrashAssembly(this.mContext, this.mActivityDataManager, this.mBatteryWatcher, true);
                break;
            case 3:
                baseAssembly = new NativeCrashAssembly(this.mContext, this.mActivityDataManager, this.mBatteryWatcher);
                break;
            case 4:
                baseAssembly = new BaseCrashAssembly(CrashType.ANR, this.mContext, this.mActivityDataManager, this.mBatteryWatcher);
                break;
            case 5:
                baseAssembly = new BaseCrashAssembly(CrashType.DART, this.mContext, this.mActivityDataManager, this.mBatteryWatcher);
                break;
            case 6:
                baseAssembly = new BaseCrashAssembly(CrashType.GAME, this.mContext, this.mActivityDataManager, this.mBatteryWatcher);
                break;
            case 7:
                baseAssembly = new BaseAssembly(CrashType.ENSURE, this.mContext, this.mActivityDataManager, this.mBatteryWatcher) { // from class: com.bytedance.crash.runtime.assembly.CrashContextAssembly.1
                };
                break;
        }
        if (baseAssembly != null) {
            this.mCrashAssemblyMap.put(crashType, baseAssembly);
        }
        return baseAssembly;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.crash.runtime.assembly.CrashContextAssembly$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static /* synthetic */ class C10032 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$crash$CrashType;

        static {
            int[] iArr = new int[CrashType.values().length];
            $SwitchMap$com$bytedance$crash$CrashType = iArr;
            try {
                iArr[CrashType.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$crash$CrashType[CrashType.LAUNCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$crash$CrashType[CrashType.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bytedance$crash$CrashType[CrashType.ANR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$bytedance$crash$CrashType[CrashType.DART.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$bytedance$crash$CrashType[CrashType.GAME.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$bytedance$crash$CrashType[CrashType.ENSURE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public CrashBody assemblyCrash(CrashType crashType, CrashBody crashBody, BaseAssembly.AssemblyCallback assemblyCallback, boolean z) {
        BaseAssembly assembly;
        return (crashType == null || (assembly = getAssembly(crashType)) == null) ? crashBody : assembly.assemblyCrashBody(crashBody, assemblyCallback, z);
    }

    public CrashBody assemblyCrash(CrashType crashType, CrashBody crashBody) {
        return assemblyCrash(crashType, crashBody, null, false);
    }
}
