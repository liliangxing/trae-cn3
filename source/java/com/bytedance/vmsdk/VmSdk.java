package com.bytedance.vmsdk;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.mira.Mira;
import com.bytedance.mira.core.SafelyLibraryLoader;
import com.bytedance.mira.helper.PluginDirHelper;
import com.bytedance.mira.pm.PluginPackageManager;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.vmsdk.service.IVmSdkHostService;
import com.bytedance.vmsdk.service.VmSdkServiceManager;
import java.io.File;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class VmSdk {
    private static final String TAG = "VmSdk";

    public static String getVmsdkAndroidVersion() {
        return "2.15.1-alpha.41-inspector";
    }

    public static boolean preloadPlugin(String str) {
        if (!isSettingsEnable()) {
            return false;
        }
        try {
            if (PluginPackageManager.checkPluginInstalled(str)) {
                return true;
            }
            return Mira.loadPlugin(str);
        } catch (Throwable th) {
            Log.e(TAG, "preloadPlugin error: " + th.getMessage());
            return false;
        }
    }

    public static boolean tryLoadPlugin(String str, int i) {
        if (!isSettingsEnable()) {
            return false;
        }
        if (Mira.isPluginLoaded(str)) {
            Log.i(TAG, "tryLoadMiniAppPlugin, plugin is Loaded:" + str);
            return true;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (Mira.loadPlugin(str)) {
                Log.i(TAG, "tryLoadMiniAppPlugin, tryLoadPlugin success," + str + " tryNumber: " + i);
                return true;
            }
            try {
                Thread.sleep(100L);
            } catch (Throwable th) {
                Log.e(TAG, "tryLoadMiniAppPlugin error" + th.getMessage());
            }
        }
        Log.i(TAG, "tryLoadMiniAppPlugin: failed");
        return false;
    }

    public static boolean preloadPluginInHost(String str) {
        IVmSdkHostService iVmSdkHostService;
        if (!isSettingsEnable() || (iVmSdkHostService = (IVmSdkHostService) VmSdkServiceManager.getInstance().getService(IVmSdkHostService.class)) == null) {
            return false;
        }
        if (iVmSdkHostService.isPluginInstalled(str)) {
            return true;
        }
        return iVmSdkHostService.loadPlugin(str);
    }

    public static boolean loadQuickJsLibrary() {
        if (!isSettingsEnable()) {
            return false;
        }
        try {
            System.loadLibrary("quick");
            Log.d(TAG, "loadQuickJsLibrary in host success");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean loadWorkerLibrary(String str) {
        if (!isSettingsEnable()) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            str = getVmSdkPluginName();
        }
        String[] strArr = {"quick", "napi", ErrorType.WORKER};
        for (int i = 0; i < 3; i++) {
            String str2 = strArr[i];
            String pluginLibAbsPath = getPluginLibAbsPath(str, str2);
            if (TextUtils.isEmpty(pluginLibAbsPath)) {
                Log.e(TAG, "loadWorkerLibrary failed: so: " + str2 + ", Plugin: " + str);
                return false;
            }
            try {
                System.load(pluginLibAbsPath);
                Log.d(TAG, "loadWorkerLibrary success: soname :" + pluginLibAbsPath + ", PluginName: " + str);
            } catch (Throwable th) {
                Log.e(TAG, "loadWorkerLibrary failed: soname: " + pluginLibAbsPath + ", PluginName: " + str + "error:" + th.getMessage());
                return false;
            }
        }
        return true;
    }

    public static boolean loadV8Library(String str) {
        if (!isSettingsEnable()) {
            return false;
        }
        String[] strArr = {"v8_libbase.cr", "v8_libplatform.cr", "v8.cr"};
        for (int i = 0; i < 3; i++) {
            String str2 = strArr[i];
            if (!SafelyLibraryLoader.loadLibrary(str, str2)) {
                Log.d(TAG, "loadV8Library failed: soname : lib" + str2 + ".so, PluginName: " + str);
                return false;
            }
        }
        return true;
    }

    public static boolean loadLibrary(String str, String str2) {
        if (!isSettingsEnable()) {
            return false;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Log.e(TAG, "loadLibrary failed: soname : lib" + str2 + ".so, PluginName: " + str);
            return false;
        }
        boolean loadLibrary = SafelyLibraryLoader.loadLibrary(str, str2);
        Log.d(TAG, "loadLibrary: soname : lib" + str2 + ".so, PluginName: " + str + (loadLibrary ? " Success" : " Failed"));
        return loadLibrary;
    }

    public static String getPluginLibAbsPath(String str, String str2) {
        if (!isSettingsEnable()) {
            return "";
        }
        try {
            return new File(PluginDirHelper.getNativeLibraryDir(str, PluginPackageManager.getInstalledPluginVersion(str)), mapLibraryName(str2)).getPath();
        } catch (Throwable th) {
            Log.e(TAG, "getPluginLibAbsPath failed: soname : lib" + str2 + ".so, PluginName: " + str + " error:" + th.getMessage());
            return "";
        }
    }

    private static String mapLibraryName(String str) {
        return !Pattern.compile("lib\\w+\\.so").matcher(str).matches() ? System.mapLibraryName(str) : str;
    }

    public static String getVmSdkPluginName() {
        IVmSdkHostService iVmSdkHostService = (IVmSdkHostService) VmSdkServiceManager.getInstance().getService(IVmSdkHostService.class);
        return iVmSdkHostService == null ? "" : iVmSdkHostService.getVmSdkPluginName();
    }

    public static String getV8PluginName() {
        IVmSdkHostService iVmSdkHostService = (IVmSdkHostService) VmSdkServiceManager.getInstance().getService(IVmSdkHostService.class);
        return iVmSdkHostService == null ? "" : iVmSdkHostService.getV8PluginName();
    }

    public static String getLynxPluginName() {
        IVmSdkHostService iVmSdkHostService = (IVmSdkHostService) VmSdkServiceManager.getInstance().getService(IVmSdkHostService.class);
        return iVmSdkHostService == null ? "" : iVmSdkHostService.getLynxPluginName();
    }

    public static boolean isSettingsEnable() {
        IVmSdkHostService iVmSdkHostService = (IVmSdkHostService) VmSdkServiceManager.getInstance().getService(IVmSdkHostService.class);
        boolean z = iVmSdkHostService != null && iVmSdkHostService.isVmSdkPluginSettingsEnable();
        Log.d(TAG, "isSettingsEnable: " + z);
        return z;
    }
}
