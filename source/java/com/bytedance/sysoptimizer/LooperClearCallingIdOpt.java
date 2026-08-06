package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import com.bytedance.push.settings.pull.PullSettingsModel;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class LooperClearCallingIdOpt {
    private static String TAG = "LooperClearCallingIdOpt";

    private static native void nStart(long j, long j2, long j3, long j4);

    public static void start(Context context) {
        long j;
        long j2;
        long j3;
        long j4;
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/self/maps"));
                j = 0;
                j2 = 0;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.contains("boot-framework.oat") && readLine.contains("r-xp")) {
                            String[] split = readLine.split("\\s+")[0].split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            j = Long.parseLong(split[0], 16);
                            j2 = Long.parseLong(split[1], 16);
                        }
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        j3 = j;
                        long j5 = j2;
                        if (j3 != 0) {
                        }
                        Log.e(TAG, "Failed to find the bootFwOatStartAddr or bootFwOatEndAddr");
                        return;
                    }
                }
                bufferedReader.close();
            } catch (IOException e2) {
                e = e2;
                j = 0;
                j2 = 0;
            }
            j3 = j;
            long j52 = j2;
            if (j3 != 0 || j52 == 0) {
                Log.e(TAG, "Failed to find the bootFwOatStartAddr or bootFwOatEndAddr");
                return;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                try {
                    if (i >= 31) {
                        Method declaredMethod = Looper.class.getDeclaredMethod("loopOnce", Looper.class, Long.TYPE, Integer.TYPE);
                        Field declaredField = Executable.class.getDeclaredField("artMethod");
                        declaredField.setAccessible(true);
                        j4 = declaredField.getLong(declaredMethod);
                    } else {
                        Method declaredMethod2 = Looper.class.getDeclaredMethod(PullSettingsModel.SCENE_LOOP, new Class[0]);
                        Field declaredField2 = Executable.class.getDeclaredField("artMethod");
                        declaredField2.setAccessible(true);
                        j4 = declaredField2.getLong(declaredMethod2);
                    }
                    Method declaredMethod3 = LooperClearCallingIdOpt.class.getDeclaredMethod("nStart", Long.TYPE, Long.TYPE, Long.TYPE, Long.TYPE);
                    Field declaredField3 = Executable.class.getDeclaredField("artMethod");
                    declaredField3.setAccessible(true);
                    long j6 = declaredField3.getLong(declaredMethod3);
                    if (j4 == 0) {
                        Log.e(TAG, "Failed to find targetArtMethod");
                    } else if (j6 == 0) {
                        Log.e(TAG, "Failed to find auxArtMethodAddr");
                    } else {
                        nStart(j3, j52, j4, j6);
                    }
                } catch (Exception e3) {
                    Log.e(TAG, "Exception in reflection operation: ", e3);
                }
            }
        }
    }
}
