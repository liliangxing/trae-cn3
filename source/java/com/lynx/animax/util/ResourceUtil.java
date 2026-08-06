package com.lynx.animax.util;

import android.content.res.AssetManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class ResourceUtil {
    private static final String TAG = "ResourceUtil";

    public static byte[] getByteArrayFromAsset(String str, AssetManager assetManager) {
        try {
            InputStream open = assetManager.open(str);
            return StreamUtil.getByteArrayFromInputStream(open, open.available());
        } catch (IOException e) {
            AnimaXLog.e(TAG, "Failed to open asset: " + str + " , reason: " + e);
            return null;
        }
    }

    public static byte[] getByteArrayFromFile(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            return StreamUtil.getByteArrayFromInputStream(fileInputStream, fileInputStream.available());
        } catch (IOException e) {
            AnimaXLog.e(TAG, "Failed to open local file:" + str + " , reason: " + e);
            return null;
        }
    }
}
