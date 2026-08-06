package com.lynx.animax;

import android.content.Context;
import com.lynx.animax.util.AnimaX;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.animax.util.StreamUtil;
import java.io.ByteArrayInputStream;
import java.io.File;

/* loaded from: classes6.dex */
public class AnimaXResourceLoader {
    private static final String TAG = "AnimaXResourceLoader";

    public static String getCacheDirectory() {
        File cacheDir;
        String absolutePath;
        Context appContext = AnimaX.inst().getAppContext();
        if (appContext == null || (cacheDir = appContext.getCacheDir()) == null || (absolutePath = cacheDir.getAbsolutePath()) == null) {
            return null;
        }
        File file = new File(absolutePath, "animax");
        if (!file.exists() && !file.mkdirs()) {
            AnimaXLog.e(TAG, "Failed to make animax cache directory: " + file.getAbsolutePath());
        }
        if (file.exists() && file.isFile()) {
            AnimaXLog.e(TAG, "Failed to make animax cache directory, path is a file: " + file.getAbsolutePath());
        }
        return file.getAbsolutePath();
    }

    public static byte[] readFile(String str) {
        return StreamUtil.getByteArrayFromInputStream(StreamUtil.createFileInputStream(str));
    }

    public static boolean saveByteArrayIntoFile(String str, byte[] bArr) {
        return StreamUtil.saveFileFromInputStream(new ByteArrayInputStream(bArr), str);
    }
}
