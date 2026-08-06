package com.bytedance.apm6.cpu.collect;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Process;
import android.util.Log;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.core.MonitorSharedPreferences;
import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.cpu.CgroupFetcher;
import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.cpu.config.CpuConfig;
import com.bytedance.apm6.cpu.config.CpuConfigService;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.watson.assist.api.AssistStatFactory;
import com.bytedance.watson.assist.api.IAssistStat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CpuCollectManager {
    private static final long PROC_CHECK_TIME = 300000;
    private static final String SPILT = ",";
    private static final String SP_CPU_FRONT = "apm_cpu_front";
    private static final String VALUE_IS_FRONT = "true";
    private IAssistStat assistStat;
    private ApmCpuManager.ICpuDataListener dataListener;
    private ActivityLifecycleService lifecycleService;
    private CpuDataAssembler mDataAssembler;
    private CpuDataCollector mDataCollector;
    private AtomicBoolean mIsInit;
    private SharedPreferences mSp;

    private CpuCollectManager() {
        this.mIsInit = new AtomicBoolean(false);
        try {
            this.assistStat = AssistStatFactory.create(ApmContext.getContext());
        } catch (Throwable unused) {
        }
        this.mDataAssembler = new CpuDataAssembler(this.assistStat);
        this.mDataCollector = new CpuDataCollector(this.mDataAssembler, this.assistStat);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static final class SingletonHolder {
        private static final CpuCollectManager instance = new CpuCollectManager();

        private SingletonHolder() {
        }
    }

    public static CpuCollectManager getInstance() {
        return SingletonHolder.instance;
    }

    public void init() {
        if (this.mIsInit.compareAndSet(false, true)) {
            this.lifecycleService = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);
            this.mSp = MonitorSharedPreferences.getSharedPreferences(com.bytedance.apm6.foundation.context.ApmContext.getContext(), SP_CPU_FRONT);
            if (com.bytedance.apm6.foundation.context.ApmContext.isMainProcess()) {
                checkProcessState();
                AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).sendTask(new AsyncTask(300000L, 300000L) { // from class: com.bytedance.apm6.cpu.collect.CpuCollectManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CpuCollectManager.this.checkProcessState();
                    }
                });
            }
            this.mSp.edit().putString(com.bytedance.apm6.foundation.context.ApmContext.getCurrentProcessName(), Process.myPid() + SPILT + this.lifecycleService.isForeground()).apply();
            this.lifecycleService.register(new IActivityLifecycleObserver() { // from class: com.bytedance.apm6.cpu.collect.CpuCollectManager.2
                @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
                public void onActivityCreated(Activity activity) {
                }

                @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
                public void onActivityPause(Activity activity) {
                }

                @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
                public void onActivityResume(Activity activity) {
                }

                @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
                public void onActivityStarted(Activity activity) {
                }

                @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
                public void onFront(Activity activity) {
                    CpuCollectManager.this.mSp.edit().putString(com.bytedance.apm6.foundation.context.ApmContext.getCurrentProcessName(), Process.myPid() + ",true").apply();
                }

                @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
                public void onBackground(Activity activity) {
                    CpuCollectManager.this.mSp.edit().putString(com.bytedance.apm6.foundation.context.ApmContext.getCurrentProcessName(), Process.myPid() + ",false").apply();
                }
            });
            ServiceManager.getService(CpuConfigService.class);
        }
    }

    public boolean isFront() {
        boolean z;
        if (this.lifecycleService.isForeground()) {
            this.mSp.edit().putString(com.bytedance.apm6.foundation.context.ApmContext.getCurrentProcessName(), Process.myPid() + SPILT + this.lifecycleService.isForeground()).apply();
            return true;
        }
        Map<String, ?> all = this.mSp.getAll();
        if (all != null) {
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                if (((String) it.next().getValue()).split(SPILT)[1].equals(VALUE_IS_FRONT)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        CgroupFetcher.CGROUP_LEVEL groupLevel = CgroupFetcher.getGroupLevel();
        return z || this.lifecycleService.isForeground() || groupLevel == CgroupFetcher.CGROUP_LEVEL.TOP_APP || groupLevel == CgroupFetcher.CGROUP_LEVEL.FOREGROUND;
    }

    public ApmCpuManager.ICpuDataListener getDataListener() {
        return this.dataListener;
    }

    public void setDataListener(ApmCpuManager.ICpuDataListener iCpuDataListener) {
        this.dataListener = iCpuDataListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0076 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void checkProcessState() {
        Map<String, ?> all = this.mSp.getAll();
        if (all != null) {
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                try {
                    String key = entry.getKey();
                    File file = new File("/proc/" + ((String) entry.getValue()).split(SPILT)[0] + "/stat");
                    String str = "";
                    BufferedReader bufferedReader = null;
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file.getPath()), 100);
                        try {
                            str = bufferedReader2.readLine();
                            bufferedReader2.close();
                        } catch (Throwable unused) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (!str.isEmpty()) {
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                    if (!str.isEmpty()) {
                        this.mSp.edit().remove(key).apply();
                    } else {
                        String str2 = str.split(" ")[1];
                        if (!key.endsWith(str2.substring(1, str2.length() - 1))) {
                            this.mSp.edit().remove(key).apply();
                        }
                    }
                } catch (Throwable unused3) {
                }
            }
        }
    }

    public void updateConfig(CpuConfig cpuConfig) {
        if (cpuConfig == null) {
            return;
        }
        InitiativeCpuCollectManager.onConfigReady();
        Log.i(Constants.TAG, "config: " + cpuConfig);
        if ((ApmContext.isMainProcess() || cpuConfig.isCollectAllProcess()) && cpuConfig.isEnableUpload()) {
            this.mDataCollector.start(cpuConfig);
            this.mDataAssembler.start(cpuConfig);
        }
    }

    public void pause() {
        this.mDataCollector.stop();
        this.mDataAssembler.stop();
    }

    public void resume() {
        this.mDataCollector.resume();
        this.mDataAssembler.resume();
    }
}
