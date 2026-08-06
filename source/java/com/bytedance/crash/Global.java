package com.bytedance.crash;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import com.bytedance.crash.dumper.AppVersion;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.FileSystemUtils;
import java.io.File;

/* loaded from: classes3.dex */
public class Global {
    public static final String HAS_CRASH = "hasCrash";
    private static ICrashMonitorService crashMonitorService = null;
    private static volatile boolean hasCrashBefore = false;
    private static String sAppVersionString = null;
    private static String sBusiness = "default";
    private static volatile Global sInstance;
    private int appLaunchMode;
    private Application mApplication;
    private Context mContext;
    private File mRootDirectory;
    private long mAppStartTime = System.currentTimeMillis();
    private final long mAppStartUpTime = SystemClock.uptimeMillis();
    private long mInitElapsedRealtime = SystemClock.elapsedRealtime();

    private static Global get() {
        if (sInstance == null) {
            synchronized (Global.class) {
                if (sInstance == null) {
                    sInstance = new Global();
                }
            }
        }
        return sInstance;
    }

    private Global() {
        this.mAppStartTime -= this.mInitElapsedRealtime - Process.getStartElapsedRealtime();
    }

    public static String getBusiness() {
        return sBusiness;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setBusiness(String str) {
        sBusiness = str;
    }

    public static boolean hasCrashBefore() {
        return hasCrashBefore;
    }

    public static void setHasCrashBefore(boolean z) {
        hasCrashBefore = z;
    }

    public static Context getContext() {
        return get().mContext;
    }

    public static Application getApplication() {
        return get().mApplication;
    }

    public static File getRootDirectory() {
        return get().mRootDirectory;
    }

    public static File getRootDirectory(Context context) {
        File rootDirectory = getRootDirectory();
        return rootDirectory == null ? FileSystemUtils.createDirectory(context.getFilesDir(), "npth") : rootDirectory;
    }

    public static String getConfigDir() {
        File file = new File(getRootDirectory(), "configs");
        if (!file.exists()) {
            FileSystemUtils.createDirectory(file);
        }
        return file.getAbsolutePath();
    }

    public static long getAppStartTime() {
        return get().mAppStartTime;
    }

    public static long getInitElapsedRealtime() {
        return get().mInitElapsedRealtime;
    }

    public static void setAppStartTime(Long l) {
        get().mAppStartTime = l.longValue() < get().mAppStartTime ? l.longValue() : get().mAppStartTime;
    }

    public static long getAppStartUpTime() {
        return get().mAppStartUpTime;
    }

    public static void setContext(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null");
        }
        get().setContextInner(context);
    }

    private void setContextInner(Context context) {
        setApplication(context);
        if (this.mContext == null) {
            synchronized (this) {
                if (this.mContext == null) {
                    this.mContext = context;
                }
            }
        }
        if (this.mRootDirectory == null) {
            synchronized (this) {
                if (this.mRootDirectory == null) {
                    this.mRootDirectory = FileSystemUtils.createDirectory(context.getFilesDir(), "npth");
                }
            }
        }
    }

    private void setApplication(Context context) {
        if (this.mApplication == null) {
            if (context instanceof Application) {
                this.mApplication = (Application) context;
            } else {
                this.mApplication = (Application) context.getApplicationContext();
            }
        }
    }

    public static void setApplication(Application application) {
        if (application == null || get().mApplication != null) {
            return;
        }
        get().mApplication = application;
    }

    public static void setAppVersion(long j, long j2, long j3, String str) {
        if (sAppVersionString == null) {
            String jsonString = AppVersion.getJsonString(j, j2, j3, str);
            sAppVersionString = jsonString;
            if (jsonString != null) {
                NativeBridge.setAppVersion(jsonString);
            }
        }
    }

    public static String getNativeAppVersion() {
        return sAppVersionString;
    }

    public static void setAppLaunchMode(int i) {
        get().appLaunchMode = i;
    }

    public static int getAppLaunchMode() {
        return get().appLaunchMode;
    }

    public static void setCrashMonitorService(ICrashMonitorService iCrashMonitorService) {
        crashMonitorService = iCrashMonitorService;
    }

    public static ICrashMonitorService getCrashMonitorService() {
        return crashMonitorService;
    }
}
