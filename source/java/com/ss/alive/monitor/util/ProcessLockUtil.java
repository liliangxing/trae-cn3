package com.ss.alive.monitor.util;

import android.content.Context;
import com.bytedance.common.utility.tools.SafelyLibraryLoader;
import com.bytedance.push.utils.Logger;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ProcessLockUtil {
    private static final String TAG = "ProcessLockUtil";
    private static String sFileName = "process.lock";
    private static boolean sHasCheckIsFirst;
    private static boolean sIsFirst;

    private static native boolean isFirstProcess(String str);

    public static boolean checkIsFirstStartProcess(Context context) {
        try {
            SafelyLibraryLoader.loadLibrary(context, "native-lib-process-lock");
            if (sHasCheckIsFirst) {
                return sIsFirst;
            }
            sHasCheckIsFirst = true;
            File file = new File(context.getFilesDir(), sFileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            sIsFirst = isFirstProcess(file.getAbsolutePath());
            if (Logger.debug()) {
                Logger.d(TAG, "isFirstLockFile: sIsFirst = " + sIsFirst + "  process = " + ToolUtils.getCurProcessName(context));
            }
            return sIsFirst;
        } catch (Throwable th) {
            th.printStackTrace();
            sIsFirst = false;
            return false;
        }
    }
}
