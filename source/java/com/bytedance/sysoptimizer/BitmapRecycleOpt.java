package com.bytedance.sysoptimizer;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class BitmapRecycleOpt {
    private static String TAG = "BitmapRecycleOpt";

    private static native int nStart(int i, int i2, long j, long j2, long j3, boolean z);

    public static int start(Context context, boolean z) {
        long j;
        long j2;
        long j3;
        if (!SysOptimizer.loadOptimizerLibrary(context)) {
            return -1;
        }
        try {
            Field declaredField = Field.class.getDeclaredField("offset");
            declaredField.setAccessible(true);
            int i = declaredField.getInt(Bitmap.class.getDeclaredField("mRecycled"));
            int i2 = declaredField.getInt(Bitmap.class.getDeclaredField("mNativePtr"));
            if (Build.VERSION.SDK_INT >= 26) {
                Method declaredMethod = BitmapRecycleOpt.class.getDeclaredMethod("nStart", Integer.TYPE, Integer.TYPE, Long.TYPE, Long.TYPE, Long.TYPE, Boolean.TYPE);
                Field declaredField2 = Executable.class.getDeclaredField("artMethod");
                declaredField2.setAccessible(true);
                j = declaredField2.getLong(declaredMethod);
            } else {
                j = 0;
            }
            if (i == 0) {
                Log.e(TAG, "Failed to find the mRecycled offset of Bitmap");
                return -1;
            }
            if (j == 0) {
                Log.e(TAG, "Failed to find targetArtMethod");
                return -1;
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/self/maps"));
                boolean z2 = false;
                j2 = 0;
                j3 = 0;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            if (!readLine.contains("dalvik-main space")) {
                                if (z2) {
                                    break;
                                }
                            } else {
                                String[] split = readLine.split("\\s+")[0].split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                if (!z2) {
                                    j2 = Long.parseLong(split[0], 16);
                                    z2 = true;
                                }
                                j3 = Long.parseLong(split[1], 16);
                            }
                        } else {
                            break;
                        }
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        if (j2 != 0) {
                        }
                        Log.e(TAG, "Failed to find the mainSpaceStartAddr or mainSpaceEndAddr");
                        return -1;
                    }
                }
                bufferedReader.close();
            } catch (IOException e2) {
                e = e2;
                j2 = 0;
                j3 = 0;
            }
            if (j2 != 0 || j3 == 0) {
                Log.e(TAG, "Failed to find the mainSpaceStartAddr or mainSpaceEndAddr");
                return -1;
            }
            return nStart(i, i2, j2, j3, j, z);
        } catch (Exception e3) {
            Log.e(TAG, "Exception in reflection operation: ", e3);
            return -1;
        }
    }
}
