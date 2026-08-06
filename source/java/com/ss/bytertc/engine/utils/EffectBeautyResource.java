package com.ss.bytertc.engine.utils;

import android.content.Context;
import com.ss.bytertc.base.utils.RtcContextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes7.dex */
public class EffectBeautyResource {
    public static String GetEffectComposeMakeupPath() {
        Context applicationContext = RtcContextUtils.getApplicationContext();
        File file = new File(applicationContext.getFilesDir(), "basic_beauty");
        copyAssetFolder(applicationContext, "basic_beauty", file.getAbsolutePath());
        return file.getAbsolutePath();
    }

    private static boolean copyAssetFolder(Context context, String srcName, String dstName) {
        try {
            String[] list = context.getAssets().list(srcName);
            if (list == null) {
                return false;
            }
            if (list.length == 0) {
                return copyAssetFile(context, srcName, dstName);
            }
            boolean mkdirs = new File(dstName).mkdirs();
            for (String str : list) {
                mkdirs &= copyAssetFolder(context, srcName + File.separator + str, dstName + File.separator + str);
            }
            return mkdirs;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean copyAssetFile(Context context, String srcName, String dstName) {
        try {
            File file = new File(dstName);
            if (file.exists()) {
                return true;
            }
            InputStream open = context.getAssets().open(srcName);
            if (open == null) {
                return false;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    open.close();
                    fileOutputStream.close();
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
