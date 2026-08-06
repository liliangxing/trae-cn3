package com.bytedance.crash.general;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.bytedance.crash.config.BitsConfig;
import com.bytedance.crash.config.NpthBuildConfig;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.AppInfoUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.SerializeFactory;
import java.io.File;
import java.io.FilenameFilter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AppInfo implements Serializable {
    private static final String KEY_APP_DISPLAY_NAME = "display_name";
    private static final String KEY_APP_PACKAGE = "package";
    private static final String KEY_APP_RELEASE_BUILD = "release_build";
    private static final String KEY_APP_VERIFY_INFO = "verify_info";
    private static final String KEY_NPTH_BYTRACE_ID = "bytrace_id";
    public static final String KEY_NPTH_VERSION_CODE = "sdk_version";
    public static final String KEY_NPTH_VERSION_NAME = "sdk_version_name";
    private static final int MAX_FILE_COUNT = 3;
    private static final String SUFFIX = ".aif";
    private static final long TOW_WEEKS = 1209600000;
    private static final long serialVersionUID = 1;
    Map<String, Object> mAppExtension;
    int mAppVersionCode;
    String mAppVersionName;
    String mBitWide;
    String mDisplayName;
    long mLastUpdateTime;
    String mNpthBytraceId;
    int mNpthVersionCode;
    String mNpthVersionName;
    String mPackageName;
    String mReleaseBuild;

    private static File[] getSortedFilesArray(File file) {
        File[] listFiles = file.listFiles(new FilenameFilter() { // from class: com.bytedance.crash.general.AppInfo.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                return str.endsWith(AppInfo.SUFFIX);
            }
        });
        if (listFiles != null) {
            Arrays.sort(listFiles, new Comparator<File>() { // from class: com.bytedance.crash.general.AppInfo.2
                @Override // java.util.Comparator
                public int compare(File file2, File file3) {
                    return Long.compare(AppInfo.getLastUpdateTime(file3), AppInfo.getLastUpdateTime(file2));
                }
            });
        }
        return listFiles;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AppInfo findAppInfo(File file, long j) {
        File[] sortedFilesArray = getSortedFilesArray(file);
        if (sortedFilesArray == null) {
            return null;
        }
        for (File file2 : sortedFilesArray) {
            try {
                AppInfo appInfo = (AppInfo) SerializeFactory.load(file2);
                AppInfo appInfo2 = appInfo;
                if (appInfo != null && j > appInfo.mLastUpdateTime) {
                    return appInfo;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AppInfo get(Context context, File file) {
        File file2;
        PackageInfo packageInfo;
        int i;
        String packageName = context.getPackageName();
        PackageInfo packageInfo2 = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            try {
                file2 = new File(file, packageInfo.lastUpdateTime + SUFFIX);
            } catch (Throwable unused) {
                file2 = null;
            }
            try {
                AppInfo appInfo = (AppInfo) SerializeFactory.load(file2);
                AppInfo appInfo2 = appInfo;
                if (appInfo != null) {
                    return appInfo;
                }
            } catch (Throwable unused2) {
                packageInfo2 = packageInfo;
                packageInfo = packageInfo2;
                AppInfo appInfo3 = new AppInfo();
                appInfo3.mPackageName = packageName;
                appInfo3.mBitWide = !NativeBridge.is64BitRuntime() ? "64" : "32";
                appInfo3.mReleaseBuild = BitsConfig.getReleaseBuild();
                appInfo3.mNpthVersionCode = 4020260;
                appInfo3.mNpthVersionName = NpthBuildConfig.VERSION_NAME;
                appInfo3.mNpthBytraceId = AppInfoUtils.getBytraceId();
                appInfo3.mAppExtension = BitsConfig.getPropertiesMap();
                if (packageInfo != null) {
                }
                if (file2 != null) {
                }
                return appInfo3;
            }
        } catch (Throwable unused3) {
            file2 = null;
        }
        AppInfo appInfo32 = new AppInfo();
        appInfo32.mPackageName = packageName;
        appInfo32.mBitWide = !NativeBridge.is64BitRuntime() ? "64" : "32";
        appInfo32.mReleaseBuild = BitsConfig.getReleaseBuild();
        appInfo32.mNpthVersionCode = 4020260;
        appInfo32.mNpthVersionName = NpthBuildConfig.VERSION_NAME;
        appInfo32.mNpthBytraceId = AppInfoUtils.getBytraceId();
        appInfo32.mAppExtension = BitsConfig.getPropertiesMap();
        if (packageInfo != null) {
            appInfo32.mLastUpdateTime = packageInfo.lastUpdateTime;
            appInfo32.mAppVersionCode = packageInfo.versionCode;
            appInfo32.mAppVersionName = packageInfo.versionName;
            if (packageInfo.applicationInfo != null && (i = packageInfo.applicationInfo.labelRes) > 0) {
                appInfo32.mDisplayName = context.getString(i);
            }
        }
        if (file2 != null) {
            clear(file);
            SerializeFactory.store(file2, appInfo32);
        }
        return appInfo32;
    }

    private static void clear(File file) {
        File[] sortedFilesArray = getSortedFilesArray(file);
        if (sortedFilesArray != null) {
            if (sortedFilesArray.length > 3) {
                long currentTimeMillis = System.currentTimeMillis();
                for (int i = 3; i < sortedFilesArray.length; i++) {
                    long lastUpdateTime = getLastUpdateTime(sortedFilesArray[i]);
                    if (lastUpdateTime < 0 || currentTimeMillis - lastUpdateTime > TOW_WEEKS) {
                        sortedFilesArray[i].delete();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long getLastUpdateTime(File file) {
        try {
            return Long.parseLong(file.getName().substring(0, r2.length() - 4));
        } catch (Throwable unused) {
            return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putTo(JSONObject jSONObject) {
        JSONUtils.put(jSONObject, "package", this.mPackageName);
        JSONUtils.put(jSONObject, "display_name", this.mDisplayName);
        JSONUtils.put(jSONObject, "app_version", this.mAppVersionName);
        JSONUtils.put(jSONObject, "version_code", Integer.valueOf(this.mAppVersionCode));
        JSONUtils.put(jSONObject, "verify_info", this.mBitWide);
        JSONUtils.put(jSONObject, "release_build", this.mReleaseBuild);
        JSONUtils.put(jSONObject, KEY_NPTH_BYTRACE_ID, this.mNpthBytraceId);
        JSONUtils.put(jSONObject, "sdk_version", Integer.valueOf(this.mNpthVersionCode));
        JSONUtils.put(jSONObject, "sdk_version_name", this.mNpthVersionName);
        JSONUtils.put(jSONObject, Header.KEY_APP_LAST_UPDATE_TIME, Long.valueOf(this.mLastUpdateTime));
        Map<String, Object> map = this.mAppExtension;
        if (map != null) {
            for (String str : map.keySet()) {
                JSONUtils.put(jSONObject, str, this.mAppExtension.get(str));
            }
        }
    }
}
