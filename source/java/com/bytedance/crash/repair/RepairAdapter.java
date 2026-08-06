package com.bytedance.crash.repair;

import android.content.Context;
import android.util.Log;
import com.bytedance.crash.Global;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.npth_repair.NpthRepair;
import com.bytedance.crash.npth_repair.monitor.SignalMonitor;
import com.bytedance.crash.npth_repair.nativeCrash.ArtDumpNativeStackFixer;
import com.bytedance.crash.npth_repair.nativeCrash.DvmSuspendTimeOpt;
import com.bytedance.crash.npth_repair.nativeCrash.MTKBufferOpt;
import com.bytedance.crash.npth_repair.nativeCrash.ScudoVmaLeakFixer;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.NpthLog;
import java.util.ArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class RepairAdapter {
    public static final int BIT_FIX_DUMP_NATIVE_STACK = 0;
    public static final int BIT_MAX = 3;
    public static final int BIT_SIGNAL_MONITOR = 2;
    public static final int BIT_SUSPEND_TIME_OPT_4_4 = 1;
    private static final String TAG = "NpthRepairAdapter";
    private static boolean enableFixDumpStack = false;
    private static RepairConfig repairConfig = null;
    private static boolean useConfig = true;
    private boolean mDebuggable;
    private int mDelayedTime;
    private ArrayList<FixExecutor> mExecutorList;
    private boolean mHasInited;
    private int mInitErrno;
    private int mRepairType;
    private static final FixExecutor artDumpNativeStackFixer = new FixExecutor() { // from class: com.bytedance.crash.repair.RepairAdapter.1
        @Override // com.bytedance.crash.repair.RepairAdapter.FixExecutor
        public int startFix(int i) {
            if (RepairAdapter.enableFixDumpStack || (RepairAdapter.useConfig && RepairAdapter.checkBit(i, 0))) {
                return ArtDumpNativeStackFixer.doFixCrash();
            }
            return -1;
        }
    };
    private static final FixExecutor dvmSuspendTimeOpt = new FixExecutor() { // from class: com.bytedance.crash.repair.RepairAdapter.2
        @Override // com.bytedance.crash.repair.RepairAdapter.FixExecutor
        public int startFix(int i) {
            if (RepairAdapter.checkBit(i, 1)) {
                return DvmSuspendTimeOpt.doFixCrash();
            }
            return -1;
        }
    };
    private static final FixExecutor signalMonitor = new FixExecutor() { // from class: com.bytedance.crash.repair.RepairAdapter.3
        @Override // com.bytedance.crash.repair.RepairAdapter.FixExecutor
        public int startFix(int i) {
            if (RepairAdapter.checkBit(i, 2)) {
                return SignalMonitor.getInstance().startMonitor(RepairAdapter.repairConfig.getRepairPortrait());
            }
            return -1;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface FixExecutor {
        int startFix(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean checkBit(int i, int i2) {
        return (i & (1 << i2)) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class AdapterHolder {
        static final RepairAdapter adapter = new RepairAdapter();

        private AdapterHolder() {
        }
    }

    private RepairAdapter() {
        this.mHasInited = false;
        this.mInitErrno = -1;
    }

    private static RepairAdapter get() {
        return AdapterHolder.adapter;
    }

    private void startRepair() {
        this.mRepairType = repairConfig.getRepairType();
        this.mDelayedTime = repairConfig.getDelayedTime();
        this.mDebuggable = repairConfig.getDebuggable();
        NpthLog.m234i(TAG, "type: " + this.mRepairType + " debug: " + this.mDebuggable + " delayedTime: " + this.mDelayedTime);
        if (repairInit()) {
            DefaultWorkThread.postDelayed(new Runnable() { // from class: com.bytedance.crash.repair.RepairAdapter.4
                @Override // java.lang.Runnable
                public void run() {
                    for (int i = 0; i < 3; i++) {
                        try {
                            if (i >= RepairAdapter.this.mExecutorList.size()) {
                                return;
                            }
                            Log.d(RepairAdapter.TAG, "fix ret: " + ((FixExecutor) RepairAdapter.this.mExecutorList.get(i)).startFix(RepairAdapter.this.mRepairType));
                        } catch (Throwable unused) {
                            return;
                        }
                    }
                }
            }, this.mDelayedTime);
        }
    }

    private boolean repairInit() {
        if (this.mHasInited) {
            return this.mInitErrno == 0;
        }
        this.mHasInited = true;
        int initNpthRepair = initNpthRepair(this.mDebuggable);
        this.mInitErrno = initNpthRepair;
        if (initNpthRepair != 0) {
            return false;
        }
        ArrayList<FixExecutor> arrayList = new ArrayList<>();
        this.mExecutorList = arrayList;
        arrayList.add(artDumpNativeStackFixer);
        this.mExecutorList.add(dvmSuspendTimeOpt);
        this.mExecutorList.add(signalMonitor);
        return true;
    }

    private void registerRepairExecutor(FixExecutor fixExecutor) {
        ArrayList<FixExecutor> arrayList = this.mExecutorList;
        if (arrayList != null) {
            arrayList.add(fixExecutor);
        }
    }

    public int dumpRepairInfoInner(int i, String str) {
        if (!checkBit(this.mRepairType, i)) {
            return -1;
        }
        if (i == 2) {
            return SignalMonitor.getInstance().dumpSignalMonitor(str);
        }
        return -2;
    }

    public static synchronized void updateConfig(RepairConfig repairConfig2) {
        synchronized (RepairAdapter.class) {
            if (repairConfig2 == null) {
                return;
            }
            repairConfig = repairConfig2;
            get().startRepair();
        }
    }

    public static synchronized int dumpRepairInfo(int i, String str) {
        int dumpRepairInfoInner;
        synchronized (RepairAdapter.class) {
            dumpRepairInfoInner = get().dumpRepairInfoInner(i, str);
        }
        return dumpRepairInfoInner;
    }

    private static int initNpthRepair(boolean z) {
        Context context = Global.getContext();
        if (context != null) {
            return NpthRepair.init(context, z);
        }
        return -7;
    }

    public static void setFixDumpStack(boolean z) {
        enableFixDumpStack = z;
        useConfig = false;
    }

    public static synchronized int startOptMtkBuffer(int i) {
        synchronized (RepairAdapter.class) {
            int initNpthRepair = initNpthRepair(false);
            if (initNpthRepair != 0) {
                return initNpthRepair;
            }
            return MTKBufferOpt.doOpt(i);
        }
    }

    public static int fixScudoVmaLeak() {
        int initNpthRepair = initNpthRepair(false);
        if (initNpthRepair == 0) {
            initNpthRepair = ScudoVmaLeakFixer.doFixCrash();
            try {
                AppMonitor appMonitor = MonitorManager.getAppMonitor();
                if (appMonitor != null) {
                    appMonitor.addTag("fix_scudo", String.valueOf(initNpthRepair));
                }
            } catch (Throwable unused) {
            }
        }
        return initNpthRepair;
    }

    public static void startFixProcessMangerException() {
        DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.repair.RepairAdapter.5
            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }
}
