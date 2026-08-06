package com.bytedance.crash.general;

import android.content.Context;
import com.bytedance.crash.Global;
import com.bytedance.crash.util.FileSystemUtils;
import java.io.File;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class GeneralInfoManager {
    private static final String DIRECTORY = "general";
    private static GeneralInfoManager sInstance;
    private AppInfo mAppInfo;
    private final Context mContext;
    private final File mDirectory;
    private HardwareInfo mHardwareInfo;
    private RomInfo mRomInfo;

    public static void init() {
        GeneralInfoManager generalInfoManager = get();
        if (generalInfoManager != null) {
            generalInfoManager.getAppInfo();
        }
    }

    private static GeneralInfoManager get() {
        if (sInstance == null) {
            synchronized (GeneralInfoManager.class) {
                if (sInstance == null) {
                    Context context = Global.getContext();
                    File rootDirectory = Global.getRootDirectory();
                    if (context != null && rootDirectory != null) {
                        sInstance = new GeneralInfoManager(context, rootDirectory);
                    }
                }
            }
        }
        return sInstance;
    }

    private GeneralInfoManager(Context context, File file) {
        this.mDirectory = FileSystemUtils.createDirectory(file, "general");
        this.mContext = context;
    }

    public File getDirectory() {
        return this.mDirectory;
    }

    public static long getJiffy() {
        GeneralInfoManager generalInfoManager = get();
        if (generalInfoManager != null) {
            return generalInfoManager.getHardwareInfo().getJiffy();
        }
        return -1L;
    }

    private HardwareInfo getHardwareInfo() {
        if (this.mHardwareInfo == null) {
            synchronized (this) {
                if (this.mHardwareInfo == null) {
                    this.mHardwareInfo = HardwareInfo.get(this.mContext, this.mDirectory);
                }
            }
        }
        return this.mHardwareInfo;
    }

    private RomInfo getRomInfo() {
        if (this.mRomInfo == null) {
            synchronized (this) {
                if (this.mRomInfo == null) {
                    this.mRomInfo = RomInfo.get(this.mDirectory);
                }
            }
        }
        return this.mRomInfo;
    }

    private AppInfo getAppInfo() {
        if (this.mAppInfo == null) {
            synchronized (this) {
                if (this.mAppInfo == null) {
                    this.mAppInfo = AppInfo.get(this.mContext, this.mDirectory);
                }
            }
        }
        return this.mAppInfo;
    }

    public static void putHardwareInfo(JSONObject jSONObject) {
        GeneralInfoManager generalInfoManager = get();
        if (generalInfoManager != null) {
            generalInfoManager.getHardwareInfo().putTo(jSONObject);
        }
    }

    public static void putRomInfo(JSONObject jSONObject) {
        GeneralInfoManager generalInfoManager = get();
        if (generalInfoManager != null) {
            generalInfoManager.getRomInfo().putTo(jSONObject);
        }
    }

    public static void putAppInfo(JSONObject jSONObject, long j) {
        AppInfo findAppInfo;
        GeneralInfoManager generalInfoManager = get();
        if (generalInfoManager != null) {
            AppInfo appInfo = generalInfoManager.getAppInfo();
            if (j > 0 && j < appInfo.mLastUpdateTime && (findAppInfo = AppInfo.findAppInfo(generalInfoManager.mDirectory, j)) != null) {
                appInfo = findAppInfo;
            }
            appInfo.putTo(jSONObject);
        }
    }

    public static long getLastUpdateTime(long j) {
        GeneralInfoManager generalInfoManager = get();
        if (generalInfoManager != null) {
            if (j == 0) {
                return generalInfoManager.getAppInfo().mLastUpdateTime;
            }
            AppInfo findAppInfo = AppInfo.findAppInfo(generalInfoManager.mDirectory, j);
            if (findAppInfo != null) {
                return findAppInfo.mLastUpdateTime;
            }
        }
        return 0L;
    }

    public static boolean isRoot() {
        return RomInfoHelper.checkRoot();
    }

    public static String getRandomDeviceId() {
        GeneralInfoManager generalInfoManager = get();
        if (generalInfoManager != null) {
            return generalInfoManager.getRomInfo().getRandomDeviceId();
        }
        return RomInfoHelper.getRandomDeviceId();
    }
}
