package com.tencent.mm.opensdk.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.opensdk.utils.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1007b {

    /* renamed from: a */
    public static Context f208a;

    /* renamed from: b */
    public static ThreadPoolExecutor f209b = new ThreadPoolExecutor(5, 9, 1, TimeUnit.SECONDS, new LinkedBlockingDeque());

    /* renamed from: a */
    public static int m274a(ContentResolver contentResolver, Uri uri) {
        Log.m271i("MicroMsg.SDK.Util", "getFileSize with content url");
        if (contentResolver == null || uri == null) {
            Log.m273w("MicroMsg.SDK.Util", "getFileSize fail, resolver or uri is null");
            return 0;
        }
        InputStream inputStream = null;
        try {
            try {
                InputStream openInputStream = contentResolver.openInputStream(uri);
                if (openInputStream == null) {
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (IOException e) {
                            Log.m270e("MicroMsg.SDK.Util", "getFileSize exception: " + e.getMessage());
                        }
                    }
                    return 0;
                }
                int available = openInputStream.available();
                try {
                    openInputStream.close();
                } catch (IOException e2) {
                    Log.m270e("MicroMsg.SDK.Util", "getFileSize exception: " + e2.getMessage());
                }
                return available;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        Log.m270e("MicroMsg.SDK.Util", "getFileSize exception: " + e3.getMessage());
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            Log.m273w("MicroMsg.SDK.Util", "getFileSize fail, " + e4.getMessage());
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    Log.m270e("MicroMsg.SDK.Util", "getFileSize exception: " + e5.getMessage());
                }
            }
            return 0;
        }
    }

    /* renamed from: a */
    public static int m275a(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        if (f208a != null && str.startsWith("content")) {
            try {
                return m274a(f208a.getContentResolver(), Uri.parse(str));
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m276a(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return str.length() <= 0 ? i : Integer.parseInt(str);
        } catch (Exception unused) {
            return i;
        }
    }

    /* renamed from: a */
    public static boolean m277a(int i) {
        return i == 36 || i == 46;
    }

    /* renamed from: b */
    public static boolean m278b(String str) {
        return str == null || str.length() <= 0;
    }
}
