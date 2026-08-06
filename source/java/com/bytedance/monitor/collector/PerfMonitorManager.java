package com.bytedance.monitor.collector;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import androidx.fragment.app.Fragment;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.thread.ThreadWithHandler;
import com.bytedance.apm.util.CommonMonitorUtil;
import com.bytedance.apm6.perf.base.model.ThreadStatInfo;
import com.bytedance.monitor.collector.BinderMonitor;
import com.bytedance.monitor.collector.IHyperMonitor;
import com.bytedance.monitor.collector.LooperDispatchMonitor;
import com.bytedance.monitor.util.jni.SafelyLibraryLoader;
import com.bytedance.services.apm.api.IActivityLifeObserver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PerfMonitorManager {
    private static volatile PerfMonitorManager sPerfMonitorManager;
    private static ISoLoader sSoLoader;
    static volatile boolean soLoaded;
    private boolean isEnableCpuOpt;
    private AtraceMonitor mAtraceMonitor;
    private BinderMonitor mBinderMonitor;
    private IHyperMonitor mHyperMonitor;
    private MonitorConfig mInitMonitorConfig;
    private LooperDispatchMonitor mLooperDispatchMonitor;
    private ProcMonitor mProcMonitor;
    private IProfilerMonitor mProfilerMonitor;
    protected ThreadWithHandler mThreadWithHandler;
    private volatile boolean isInited = false;
    private volatile boolean isStarted = false;
    private volatile boolean isHyperMode = false;
    private volatile boolean isConfigReady = false;
    private volatile boolean isEvilMethodEnable = false;
    private volatile boolean isEnableStackSampling = false;
    private volatile boolean isNeedInitAlog = false;
    private boolean isLockStackFetchOpen = false;
    private final List<AbsMonitor> mMonitorList = new CopyOnWriteArrayList();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface ISoLoader {
        void loadLibrary(String str);
    }

    public void setEnableCpuOpt(boolean z) {
        this.isEnableCpuOpt = z;
    }

    public static PerfMonitorManager getInstance() {
        if (sPerfMonitorManager == null) {
            synchronized (PerfMonitorManager.class) {
                if (sPerfMonitorManager == null) {
                    sPerfMonitorManager = new PerfMonitorManager();
                }
            }
        }
        return sPerfMonitorManager;
    }

    public static boolean isSoLoaded() {
        return soLoaded;
    }

    public static synchronized boolean loadLibrary(Context context) {
        boolean z;
        synchronized (PerfMonitorManager.class) {
            if (!soLoaded) {
                ISoLoader iSoLoader = sSoLoader;
                if (iSoLoader != null) {
                    iSoLoader.loadLibrary("monitorcollector-lib");
                    soLoaded = true;
                } else {
                    soLoaded = SafelyLibraryLoader.loadLibrary(context, "monitorcollector-lib");
                }
                ByteHook.init();
            }
            z = soLoaded;
        }
        return z;
    }

    public boolean hasInited() {
        return this.isInited;
    }

    public synchronized void init(Context context, MonitorConfig monitorConfig) {
        if (this.isInited) {
            if (ApmContext.isDebugMode()) {
                Log.w("PerfMonitorManager", "PerfMonitorManager init twice? " + monitorConfig, new Throwable());
            }
            updateConfig(monitorConfig);
        } else {
            if (loadLibrary(context)) {
                ProcMonitor.init();
                updateConfig(monitorConfig);
                this.isInited = true;
            }
        }
    }

    public synchronized boolean updateConfig(MonitorConfig monitorConfig) {
        this.mInitMonitorConfig = monitorConfig;
        if (ApmContext.isDebugMode()) {
            Log.i("PerfMonitorManager", "PerfMonitorManager update config:\n " + monitorConfig);
            doSetDebugMode(true);
        }
        if (!isSoLoaded()) {
            return false;
        }
        this.isEnableStackSampling = monitorConfig.isEnableStackSampling();
        IProfilerMonitor iProfilerMonitor = this.mProfilerMonitor;
        if (iProfilerMonitor != null) {
            iProfilerMonitor.enableEvilMethodCollect(!this.isEvilMethodEnable && this.isEnableStackSampling);
        }
        if (this.mProcMonitor == null) {
            this.mProcMonitor = new ProcMonitor(monitorConfig.getRunMode());
        }
        if (monitorConfig.isEnableBinder()) {
            if (this.mBinderMonitor == null) {
                this.mBinderMonitor = new BinderMonitor(monitorConfig.getRunMode());
            }
            this.mBinderMonitor.enable();
        }
        if (monitorConfig.isEnableAtrace()) {
            if (this.mAtraceMonitor == null) {
                this.mAtraceMonitor = new AtraceMonitor(monitorConfig.getRunMode());
            }
            this.mAtraceMonitor.enableAtrace(monitorConfig.getAtraceTag());
        }
        if (monitorConfig.isEnableLooperMonitor() && this.mLooperDispatchMonitor == null) {
            this.mLooperDispatchMonitor = new LooperDispatchMonitor(monitorConfig.getRunMode(), false);
        }
        return true;
    }

    public MonitorConfig getMonitorConfig() {
        return this.mInitMonitorConfig;
    }

    public void enableAtrace() {
        if (this.isInited) {
            enableAtrace(this.mInitMonitorConfig.getAtraceTag());
        }
    }

    public void enableAtrace(long j) {
        if (this.isInited) {
            if (this.mAtraceMonitor == null) {
                this.mAtraceMonitor = new AtraceMonitor(this.mInitMonitorConfig.getRunMode());
            }
            this.mAtraceMonitor.enableAtrace(j);
        }
    }

    public void disableAtrace() {
        AtraceMonitor atraceMonitor;
        if (this.isInited && (atraceMonitor = this.mAtraceMonitor) != null) {
            atraceMonitor.disableAtrace();
        }
    }

    public void refreshMonitorConfig(int i) {
        if (this.isConfigReady) {
            for (AbsMonitor absMonitor : this.mMonitorList) {
                if (absMonitor != null) {
                    absMonitor.refreshConfig(i);
                }
            }
        }
    }

    public static void setSoLoader(ISoLoader iSoLoader) {
        sSoLoader = iSoLoader;
    }

    public void onReady() {
        this.isConfigReady = true;
    }

    private PerfMonitorManager() {
        ActivityLifeObserver.getInstance().register(new IActivityLifeObserver() { // from class: com.bytedance.monitor.collector.PerfMonitorManager.1
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            public void onActivityPause(Activity activity) {
            }

            public void onActivityResume(Activity activity) {
            }

            public void onActivityStarted(Activity activity) {
            }

            public void onChange(Activity activity, Fragment fragment) {
            }

            public void onFront(Activity activity) {
                PerfMonitorManager.this.startStackSampling();
            }

            public void onBackground(Activity activity) {
                PerfMonitorManager.this.stopStackSampling();
            }
        });
    }

    public void addCollector(AbsMonitor absMonitor) {
        if (absMonitor == null || this.mMonitorList.contains(absMonitor)) {
            return;
        }
        this.mMonitorList.add(absMonitor);
        if (this.isStarted) {
            absMonitor.start();
        }
    }

    public IHyperMonitor.ILogInstance getLogInstance() {
        IHyperMonitor iHyperMonitor = this.mHyperMonitor;
        if (iHyperMonitor == null) {
            return null;
        }
        return iHyperMonitor.getLogInstance();
    }

    public void setHyperMonitor(IHyperMonitor iHyperMonitor) {
        this.mHyperMonitor = iHyperMonitor;
    }

    void setProfilerMonitor(IProfilerMonitor iProfilerMonitor) {
        this.mProfilerMonitor = iProfilerMonitor;
        if (iProfilerMonitor != null) {
            iProfilerMonitor.enableEvilMethodCollect(!this.isEvilMethodEnable && this.isEnableStackSampling);
        }
    }

    public void startStackSampling() {
        if (this.mProfilerMonitor == null || !this.isEnableStackSampling) {
            return;
        }
        this.mProfilerMonitor.start();
    }

    public void stopStackSampling() {
        if (this.mProfilerMonitor == null || !this.isEnableStackSampling) {
            return;
        }
        this.mProfilerMonitor.stop();
    }

    public void setEvilMethodEnable(boolean z) {
        this.isEvilMethodEnable = z;
    }

    public void removeCollector(AbsMonitor absMonitor) {
        if (absMonitor != null) {
            this.mMonitorList.remove(absMonitor);
            absMonitor.destroy();
        }
    }

    public void start() {
        for (int i = 0; i < this.mMonitorList.size(); i++) {
            this.mMonitorList.get(i).start();
        }
        this.isStarted = true;
    }

    public void stop() {
        for (int i = 0; i < this.mMonitorList.size(); i++) {
            this.mMonitorList.get(i).stop();
        }
        this.isStarted = false;
    }

    void doSetDebugMode(boolean z) {
        try {
            if (soLoaded) {
                MonitorJni.doSetDebugMode(z);
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized void initALogInstance() {
        this.isNeedInitAlog = true;
        IHyperMonitor iHyperMonitor = this.mHyperMonitor;
        if (iHyperMonitor != null && iHyperMonitor.getLogInstance() != null) {
            MonitorJni.setAlogInstance(this.mHyperMonitor.getLogInstance().getNativeReference());
        }
    }

    void initProfiler() {
        if (this.mHyperMonitor == null || this.mProfilerMonitor == null || this.isEvilMethodEnable) {
            return;
        }
        if (this.mHyperMonitor.getLogInstance() != null) {
            this.mProfilerMonitor.init(ApmContext.getContext(), this.mHyperMonitor.getLogInstance().getNativeReference());
        }
        startStackSampling();
        if (!this.isNeedInitAlog || this.mHyperMonitor.getLogInstance() == null) {
            return;
        }
        MonitorJni.setAlogInstance(this.mHyperMonitor.getLogInstance().getNativeReference());
    }

    public ThreadWithHandler getThreadWithHandler() {
        return this.mThreadWithHandler;
    }

    synchronized void startHyperMode() {
        if (this.mHyperMonitor == null) {
            return;
        }
        if (this.isHyperMode) {
            return;
        }
        if (this.mHyperMonitor.getLogInstance() != null) {
            MonitorJni.setAlogInstance(this.mHyperMonitor.getLogInstance().getNativeReference());
        }
        if (this.mThreadWithHandler == null) {
            ThreadWithHandler threadWithHandler = new ThreadWithHandler("hyper_mode");
            this.mThreadWithHandler = threadWithHandler;
            threadWithHandler.start();
        }
        if (this.mProfilerMonitor != null && !this.isEvilMethodEnable) {
            this.mProfilerMonitor.start();
        }
        MonitorJni.startHyperMonitor();
        for (int i = 0; i < this.mMonitorList.size(); i++) {
            this.mMonitorList.get(i).startHyperMode();
        }
        this.isHyperMode = true;
    }

    synchronized void stopHyperMode() {
        if (this.isHyperMode) {
            MonitorJni.stopHyperMonitor();
            IProfilerMonitor iProfilerMonitor = this.mProfilerMonitor;
            if (iProfilerMonitor != null) {
                iProfilerMonitor.stop();
            }
            for (int i = 0; i < this.mMonitorList.size(); i++) {
                this.mMonitorList.get(i).stopHyperMode();
            }
            this.isHyperMode = false;
        }
    }

    public void destory() {
        for (int i = 0; i < this.mMonitorList.size(); i++) {
            this.mMonitorList.get(i).destroy();
        }
        this.mMonitorList.clear();
    }

    public synchronized void startLockDetect(long j) {
        LockMonitorManager.setOpenFetchStack(true);
        if (soLoaded) {
            try {
                MonitorJni.enableLock(j);
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized void startLockDetect(long j, boolean z) {
        LockMonitorManager.setOpenFetchStack(true);
        if (soLoaded) {
            try {
                MonitorJni.enableLockAll(j, z);
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized void endLockDetect() {
        LockMonitorManager.setOpenFetchStack(false);
        if (soLoaded) {
            try {
                MonitorJni.disableLock();
            } catch (Throwable unused) {
            }
        }
    }

    public List<BinderMonitor.BinderInfo> dumpBinderInfo() {
        BinderMonitor binderMonitor = this.mBinderMonitor;
        if (binderMonitor != null) {
            return binderMonitor.getBinderInfoListCopy();
        }
        return null;
    }

    public JSONObject dumpInfos() {
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < this.mMonitorList.size(); i++) {
            try {
                Pair<String, ?> dumpInfo = this.mMonitorList.get(i).dumpInfo();
                jSONObject.put((String) dumpInfo.first, dumpInfo.second);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public JSONObject dumpInfos(long j, long j2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < this.mMonitorList.size(); i++) {
            try {
                AbsMonitor absMonitor = this.mMonitorList.get(i);
                if (!z || !(absMonitor instanceof LooperDispatchMonitor)) {
                    Pair<String, ?> dumpInfosRange = absMonitor.dumpInfosRange(j, j2);
                    jSONObject.put((String) dumpInfosRange.first, dumpInfosRange.second);
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public JSONObject dumpInfos(long j, long j2) {
        return dumpInfos(j, j2, false);
    }

    public long dumpTotalCPUTimeByTimeInStat(int i) {
        if (!this.isEnableCpuOpt) {
            return CommonMonitorUtil.getTotalCPUTimeByTimeInStat();
        }
        if (!isSoLoaded()) {
            return 0L;
        }
        try {
            return MonitorJni.getTotalCPUTimeByTimeInStat(i);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public long dumpAppCPUTime() {
        if (!this.isEnableCpuOpt) {
            return CommonMonitorUtil.getAppCPUTime();
        }
        if (!isSoLoaded()) {
            return 0L;
        }
        try {
            return MonitorJni.doGetAppCpuTime();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public ThreadStatInfo dumpThreadStatInfo(int i, int i2) {
        return MonitorJni.getThreadStatInfo(i, i2);
    }

    public int getProcCGroup(int i) {
        return MonitorJni.getProcCGroup(i);
    }

    public boolean readProcFile(String str, int[] iArr, Object[] objArr, long[] jArr, float[] fArr) {
        return MonitorJni.readProcFile(str, iArr, objArr, jArr, fArr);
    }

    public String dumpStackTrace(long j, long j2) {
        if (this.mProfilerMonitor == null || this.isEvilMethodEnable) {
            return null;
        }
        return this.mProfilerMonitor.dumpStack(j, j2);
    }

    public String dumpNativeStackTrace(int i) {
        return MonitorJni.doDumpNativeStack(i);
    }

    public String dumpSortedStackTrace(long j, long j2) {
        if (this.mProfilerMonitor == null || this.isEvilMethodEnable) {
            return null;
        }
        return SamplingStackUtil.getStackString(this.mProfilerMonitor.dumpStack(j, j2));
    }

    public void dumpInfoToALog(long j, long j2, long j3) {
        if (this.isHyperMode) {
            return;
        }
        for (int i = 0; i < this.mMonitorList.size(); i++) {
            try {
                AbsMonitor absMonitor = this.mMonitorList.get(i);
                if (!(absMonitor instanceof LooperDispatchMonitor)) {
                    absMonitor.dumpInfosToALog(j, j2, j3);
                }
            } catch (Exception unused) {
            }
        }
    }

    public Map<String, String> dumpInfosAsMap() {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < this.mMonitorList.size(); i++) {
            try {
                Pair<String, ?> dumpInfo = this.mMonitorList.get(i).dumpInfo();
                hashMap.put(dumpInfo.first, String.valueOf(dumpInfo.second));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }

    public void setProcALogMode(boolean z) {
        ProcMonitor procMonitor = this.mProcMonitor;
        if (procMonitor != null) {
            procMonitor.setALogCollectMode(z);
        }
    }

    public LooperDispatchMonitor.FrameCallback getFrameCallback() {
        LooperDispatchMonitor looperDispatchMonitor = this.mLooperDispatchMonitor;
        if (looperDispatchMonitor == null) {
            return null;
        }
        return looperDispatchMonitor.mFrameCallback;
    }

    public LooperDispatchMonitor.ScheduleItem getLastMessageItem() {
        LooperDispatchMonitor looperDispatchMonitor = this.mLooperDispatchMonitor;
        if (looperDispatchMonitor == null) {
            return null;
        }
        return looperDispatchMonitor.getLastItem();
    }

    public LooperDispatchMonitor getLooperDispatchMonitor() {
        return this.mLooperDispatchMonitor;
    }
}
