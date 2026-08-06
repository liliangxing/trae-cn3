package com.bytedance.push.settings.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.push.settings.DisableReportTerminateEventConfig;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.settings.logger.SettingsLoggerHelper;
import com.bytedance.push.settings.utils.SettingsUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SettingsFileLockHelper {
    private static final String TAG = "SettingsFileLockHelper";
    private static volatile SettingsFileLockHelper instance;
    private String sFirstProcess;
    private Integer sFirstProcessPid;
    private boolean sHasCheckIsFirst;
    private boolean sIsFirst;
    private final String mLocalSettingsSp = "local_settings_sp";
    private final String KEY_FIRST_PROCESS = "first_process";
    private final String KEY_FIRST_PROCESS_PID = "first_process_pid";
    private final SettingsExclusiveFileLock mIsFirstProcessExclusiveFileLock = new SettingsExclusiveFileLock("bdpush_is_first_process.lock");
    private final SettingsExclusiveFileLock mLocalSettingExclusiveFileLock = new SettingsExclusiveFileLock("bdpush_local_settings_sp.lock");

    public static SettingsFileLockHelper getInstance() {
        if (instance == null) {
            synchronized (SettingsFileLockHelper.class) {
                if (instance == null) {
                    instance = new SettingsFileLockHelper();
                }
            }
        }
        return instance;
    }

    private SettingsFileLockHelper() {
    }

    public boolean curIsFirstProcess(Context context) {
        return onProcessStart(context);
    }

    public boolean onProcessStart(Context context) {
        try {
            SettingsLoggerHelper.getInstance().mo257d(TAG, "curIsFirstProcess called on " + SettingsUtils.getCurProcessName(context) + " process , sHasCheckIsFirst is " + this.sHasCheckIsFirst);
            if (this.sHasCheckIsFirst) {
                return this.sIsFirst;
            }
            this.sHasCheckIsFirst = true;
            this.sIsFirst = this.mIsFirstProcessExclusiveFileLock.isFirstLockFile(context);
            SettingsLoggerHelper.getInstance().mo257d(TAG, "isFirstLockFile: sIsFirst = " + this.sIsFirst + "  process = " + SettingsUtils.getCurProcessName(context));
            if (this.sIsFirst) {
                writeSelfProcessAsFirstProcess(context);
            }
            return this.sIsFirst;
        } catch (Throwable th) {
            th.printStackTrace();
            this.sIsFirst = false;
            return false;
        }
    }

    private void writeSelfProcessAsFirstProcess(Context context) {
        if (this.mLocalSettingExclusiveFileLock.tryLockFile(context)) {
            SharedPreferences.Editor edit = context.getSharedPreferences("local_settings_sp", 0).edit();
            String curProcessName = SettingsUtils.getCurProcessName(context);
            edit.putString("first_process", curProcessName);
            edit.putInt("first_process_pid", Process.myPid());
            edit.apply();
            SettingsLoggerHelper.getInstance().mo257d(TAG, "write  " + curProcessName + "  as first process success on " + SettingsUtils.getCurProcessName(context));
            this.mLocalSettingExclusiveFileLock.releaseLockFile();
        }
    }

    public Integer getFirstProcessPid(Context context) {
        Integer num = this.sFirstProcessPid;
        if (num != null) {
            return num;
        }
        if (this.mLocalSettingExclusiveFileLock.tryLockFile(context)) {
            this.sFirstProcessPid = Integer.valueOf(context.getSharedPreferences("local_settings_sp", 0).getInt("first_process_pid", 0));
            this.mLocalSettingExclusiveFileLock.releaseLockFile();
            SettingsLoggerHelper.getInstance().mo257d(TAG, "read first process pid success , first process pid is:" + this.sFirstProcessPid + " on " + SettingsUtils.getCurProcessName(context));
        }
        return this.sFirstProcessPid;
    }

    public String getFirstProcess(Context context) {
        if (!TextUtils.isEmpty(this.sFirstProcess)) {
            return this.sFirstProcess;
        }
        if (!this.mLocalSettingExclusiveFileLock.tryLockFile(context)) {
            return "";
        }
        this.sFirstProcess = context.getSharedPreferences("local_settings_sp", 0).getString("first_process", "");
        this.mLocalSettingExclusiveFileLock.releaseLockFile();
        SettingsLoggerHelper.getInstance().mo257d(TAG, "read first process success , first process is:" + this.sFirstProcess + " on " + SettingsUtils.getCurProcessName(context));
        return this.sFirstProcess;
    }

    public void writeAllowStartOthersProcess(Context context, boolean z, boolean z2) {
        if (this.mLocalSettingExclusiveFileLock.tryLockFile(context)) {
            SharedPreferences.Editor edit = context.getSharedPreferences("local_settings_sp", 0).edit();
            edit.putBoolean(SccResult.LABEL_ALLOW, z);
            edit.putInt("smp_pid", Process.myPid());
            edit.putBoolean("disable_report_terminate_event", z2);
            edit.apply();
            SettingsLoggerHelper.getInstance().mo257d(TAG, "write allow start other process success , allow is:" + z + " on " + SettingsUtils.getCurProcessName(context));
            this.mLocalSettingExclusiveFileLock.releaseLockFile();
        }
        SettingsManager.allowReadSettingsOnSmp = true;
    }

    public boolean readAllowStartOthersProcess(Context context) {
        if (!this.mLocalSettingExclusiveFileLock.tryLockFile(context)) {
            return true;
        }
        boolean z = context.getSharedPreferences("local_settings_sp", 0).getBoolean(SccResult.LABEL_ALLOW, true);
        SettingsLoggerHelper.getInstance().mo257d(TAG, "read allow start other process success , allow is:" + z + " on " + SettingsUtils.getCurProcessName(context));
        this.mLocalSettingExclusiveFileLock.releaseLockFile();
        return z;
    }

    public DisableReportTerminateEventConfig disableReportTerminateEventConfig(Context context) {
        DisableReportTerminateEventConfig disableReportTerminateEventConfig = new DisableReportTerminateEventConfig();
        if (this.mLocalSettingExclusiveFileLock.tryLockFile(context)) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("local_settings_sp", 0);
            int i = sharedPreferences.getInt("smp_pid", -1);
            boolean z = sharedPreferences.getBoolean("disable_report_terminate_event", false);
            SettingsLoggerHelper.getInstance().mo257d(TAG, "read disable report applog event success , disable is:" + z + " on " + SettingsUtils.getCurProcessName(context));
            this.mLocalSettingExclusiveFileLock.releaseLockFile();
            disableReportTerminateEventConfig.smpPid = i;
            disableReportTerminateEventConfig.disableReportTerminateEvent = z;
        }
        return disableReportTerminateEventConfig;
    }

    public boolean disableReportTerminateEvent(Context context) {
        if (!this.mLocalSettingExclusiveFileLock.tryLockFile(context)) {
            return false;
        }
        boolean z = context.getSharedPreferences("local_settings_sp", 0).getBoolean("disable_report_terminate_event", false);
        SettingsLoggerHelper.getInstance().mo257d(TAG, "read disable report applog event success , disable is:" + z + " on " + SettingsUtils.getCurProcessName(context));
        this.mLocalSettingExclusiveFileLock.releaseLockFile();
        return z;
    }
}
