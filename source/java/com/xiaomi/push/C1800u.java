package com.xiaomi.push;

import android.util.Log;
import java.io.File;
import java.util.HashMap;

/* renamed from: com.xiaomi.push.u */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1800u {

    /* renamed from: a */
    private static final HashMap<String, String> f3269a;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f3269a = hashMap;
        hashMap.put("FFD8FF", "jpg");
        hashMap.put("89504E47", "png");
        hashMap.put("47494638", "gif");
        hashMap.put("474946", "gif");
        hashMap.put("424D", "bmp");
    }

    /* renamed from: a */
    public static long m4102a(File file) {
        long length;
        long j = 0;
        try {
            File[] listFiles = file.listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isDirectory()) {
                    length = m4102a(listFiles[i]);
                } else {
                    length = listFiles[i].length();
                }
                j += length;
            }
        } catch (Exception e) {
            Log.e("FileUtils", "Get folder size error: " + e.getMessage());
        }
        return j;
    }

    /* renamed from: a */
    public static boolean m4103a(File file) {
        long length;
        if (file == null) {
            return false;
        }
        try {
            if (!file.exists()) {
                return true;
            }
            if (file.isDirectory()) {
                length = m4102a(file);
            } else {
                length = file.length();
            }
            return length < 104857600;
        } catch (Exception e) {
            Log.e("FileUtils", "Check if internal file can be written error :" + e.getMessage());
            return false;
        }
    }
}
