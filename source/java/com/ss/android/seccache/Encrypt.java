package com.ss.android.seccache;

import com.ss.android.seccache.Util.DataCache;
import com.ss.android.seccache.Util.DiskCache;
import java.io.InputStream;

/* loaded from: classes7.dex */
public class Encrypt {
    public static boolean encryptFile(String str) {
        return DiskCache.encryptFile(str);
    }

    public static byte[] decryptFile(String str) {
        return DiskCache.decryptFile(str);
    }

    public static InputStream decryptFile2Stream(String str) {
        return DiskCache.decryptFile2Stream(str);
    }

    public static String encryptString(String str) throws Exception {
        return DataCache.encryptString(str);
    }

    public static String decryptString(String str, String str2) throws Exception {
        return DataCache.decryptString(str, str2);
    }
}
