package com.xiaomi.push.service;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1494ba;
import com.xiaomi.push.C1801v;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;

/* renamed from: com.xiaomi.push.service.ae */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1747ae {

    /* renamed from: a */
    private static long f2946a;

    /* renamed from: a */
    private static boolean f2947a;

    /* renamed from: b */
    private static long f2948b;

    /* renamed from: com.xiaomi.push.service.ae$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class b {

        /* renamed from: a */
        public long f2951a;

        /* renamed from: a */
        public Bitmap f2952a;

        public b(Bitmap bitmap, long j) {
            this.f2952a = bitmap;
            this.f2951a = j;
        }
    }

    /* renamed from: a */
    public static b m3615a(Context context, String str, boolean z) {
        Bitmap m3620b;
        ByteArrayInputStream byteArrayInputStream = null;
        b bVar = new b(null, 0L);
        try {
            try {
                m3620b = m3620b(context, str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        if (m3620b != null) {
            bVar.f2952a = m3620b;
            C1801v.m4105a((Closeable) null);
            return bVar;
        }
        a m3614a = m3614a(str, z);
        if (m3614a != null) {
            bVar.f2951a = m3614a.f2949a;
            byte[] bArr = m3614a.f2950a;
            if (bArr != null) {
                if (z) {
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                    try {
                        int m3612a = m3612a(context, byteArrayInputStream2);
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = m3612a;
                        bVar.f2952a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                        byteArrayInputStream = byteArrayInputStream2;
                    } catch (Exception e2) {
                        e = e2;
                        byteArrayInputStream = byteArrayInputStream2;
                        AbstractC1417b.m1093a(e);
                        C1801v.m4105a((Closeable) byteArrayInputStream);
                        return bVar;
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayInputStream = byteArrayInputStream2;
                        C1801v.m4105a((Closeable) byteArrayInputStream);
                        throw th;
                    }
                } else {
                    bVar.f2952a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                }
            }
            m3618a(context, m3614a.f2950a, str);
            C1801v.m4105a((Closeable) byteArrayInputStream);
            return bVar;
        }
        C1801v.m4105a((Closeable) null);
        return bVar;
    }

    /* renamed from: com.xiaomi.push.service.ae$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a {

        /* renamed from: a */
        int f2949a;

        /* renamed from: a */
        byte[] f2950a;

        public a(byte[] bArr, int i) {
            this.f2950a = bArr;
            this.f2949a = i;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0100, code lost:
    
        if (r3 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0103, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e1, code lost:
    
        r3.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00df, code lost:
    
        if (r3 == null) goto L62;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static a m3614a(String str, boolean z) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        AssetFileDescriptor.AutoCloseInputStream autoCloseInputStream = 0;
        autoCloseInputStream = 0;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            } catch (Throwable th) {
                th = th;
                autoCloseInputStream = "Invalid Http Response Code ";
            }
        } catch (SocketTimeoutException unused) {
            inputStream = null;
            httpURLConnection = null;
        } catch (IOException e) {
            e = e;
            inputStream = null;
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
        try {
            httpURLConnection.setConnectTimeout(8000);
            httpURLConnection.setReadTimeout(20000);
            httpURLConnection.setRequestProperty("User-agent", "Mozilla/5.0 (Linux; U;) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/71.0.3578.141 Mobile Safari/537.36 XiaoMi/MiuiBrowser");
            httpURLConnection.connect();
            int contentLength = httpURLConnection.getContentLength();
            if (z && contentLength > 102400) {
                AbstractC1417b.m1089a("Bitmap size is too big, max size is 102400  contentLen size is " + contentLength + " from url " + C1494ba.m1626a(str, 3));
                C1801v.m4105a((Closeable) null);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return null;
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                AbstractC1417b.m1089a("Invalid Http Response Code " + responseCode + " received");
                C1801v.m4105a((Closeable) null);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return null;
            }
            inputStream = httpURLConnection.getInputStream();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int i = z ? 102400 : 2048000;
                byte[] bArr = new byte[1024];
                while (i > 0) {
                    int read = inputStream.read(bArr, 0, 1024);
                    if (read == -1) {
                        break;
                    }
                    i -= read;
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                if (i <= 0) {
                    AbstractC1417b.m1089a("length 102400 exhausted.");
                    a aVar = new a(null, 102400);
                    C1801v.m4105a((Closeable) inputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return aVar;
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                a aVar2 = new a(byteArray, byteArray.length);
                C1801v.m4105a((Closeable) inputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return aVar2;
            } catch (SocketTimeoutException unused2) {
                AbstractC1417b.m1103d("Connect timeout to " + str);
                C1801v.m4105a((Closeable) inputStream);
            } catch (IOException e2) {
                e = e2;
                AbstractC1417b.m1093a(e);
                C1801v.m4105a((Closeable) inputStream);
            }
        } catch (SocketTimeoutException unused3) {
            inputStream = null;
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            C1801v.m4105a((Closeable) autoCloseInputStream);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* renamed from: a */
    public static Bitmap m3613a(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2;
        Uri parse = Uri.parse(str);
        ?? r0 = 0;
        r0 = 0;
        try {
            try {
                inputStream = context.getContentResolver().openInputStream(parse);
            } catch (Throwable th) {
                th = th;
                r0 = context;
            }
        } catch (IOException e) {
            e = e;
            inputStream2 = null;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
        try {
            int m3612a = m3612a(context, inputStream);
            inputStream2 = context.getContentResolver().openInputStream(parse);
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = m3612a;
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream2, null, options);
                C1801v.m4105a((Closeable) inputStream2);
                C1801v.m4105a((Closeable) inputStream);
                return decodeStream;
            } catch (IOException e2) {
                e = e2;
                AbstractC1417b.m1093a(e);
                C1801v.m4105a((Closeable) inputStream2);
                C1801v.m4105a((Closeable) inputStream);
                return null;
            }
        } catch (IOException e3) {
            e = e3;
            inputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            C1801v.m4105a((Closeable) r0);
            C1801v.m4105a((Closeable) inputStream);
            throw th;
        }
    }

    /* renamed from: a */
    private static int m3612a(Context context, InputStream inputStream) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            AbstractC1417b.m1089a("decode dimension failed for bitmap.");
            return 1;
        }
        int round = Math.round((context.getResources().getDisplayMetrics().densityDpi / 160.0f) * 48.0f);
        if (options.outWidth <= round || options.outHeight <= round) {
            return 1;
        }
        return Math.min(options.outWidth / round, options.outHeight / round);
    }

    /* renamed from: b */
    private static synchronized Bitmap m3620b(Context context, String str) {
        Bitmap bitmap;
        File file;
        synchronized (C1747ae.class) {
            FileInputStream fileInputStream = null;
            Bitmap bitmap2 = null;
            try {
                file = new File(m3616a(context), C1494ba.m1625a(str));
            } catch (Throwable th) {
                th = th;
                bitmap = null;
            }
            if (!file.exists()) {
                return null;
            }
            if (System.currentTimeMillis() - file.lastModified() > 1209600000) {
                AbstractC1417b.m1089a("The pic cache has expired.");
                return null;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                bitmap2 = BitmapFactory.decodeStream(fileInputStream2);
                file.setLastModified(System.currentTimeMillis());
                C1801v.m4105a((Closeable) fileInputStream2);
            } catch (Throwable th2) {
                Bitmap bitmap3 = bitmap2;
                fileInputStream = fileInputStream2;
                th = th2;
                bitmap = bitmap3;
                try {
                    AbstractC1417b.m1103d("Load bmp from cache error: " + th);
                    bitmap2 = bitmap;
                    return bitmap2;
                } finally {
                    C1801v.m4105a((Closeable) fileInputStream);
                }
            }
            return bitmap2;
        }
    }

    /* renamed from: a */
    private static void m3618a(Context context, byte[] bArr, String str) {
        FileOutputStream fileOutputStream;
        File file;
        BufferedOutputStream bufferedOutputStream;
        if (bArr == null) {
            AbstractC1417b.m1089a("cannot save small icon cause bitmap is null");
            return;
        }
        m3617a(context);
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            File file2 = new File(m3616a(context));
            if (!file2.exists()) {
                file2.mkdirs();
            }
            file = new File(file2, C1494ba.m1625a(str));
            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            try {
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        try {
            bufferedOutputStream.write(bArr);
            bufferedOutputStream.flush();
            f2946a += file.length();
            long j = f2948b;
            if (j <= 0) {
                f2948b = file.lastModified();
            } else {
                f2948b = Math.min(j, file.lastModified());
            }
            C1801v.m4105a(bufferedOutputStream);
        } catch (Exception e3) {
            e = e3;
            bufferedOutputStream2 = bufferedOutputStream;
            AbstractC1417b.m1103d("Save pic error: " + e);
            C1801v.m4105a(bufferedOutputStream2);
            C1801v.m4105a(fileOutputStream);
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream2 = bufferedOutputStream;
            C1801v.m4105a(bufferedOutputStream2);
            C1801v.m4105a(fileOutputStream);
            throw th;
        }
        C1801v.m4105a(fileOutputStream);
    }

    /* renamed from: a */
    private static synchronized void m3617a(Context context) {
        File file;
        long j;
        synchronized (C1747ae.class) {
            m3621b(context);
            if (f2946a >= 62914560 || System.currentTimeMillis() - f2948b >= 1209600000) {
                try {
                    file = new File(m3616a(context));
                } catch (Throwable th) {
                    AbstractC1417b.m1103d("Clear pic cache error: " + th);
                }
                if (!file.exists()) {
                    AbstractC1417b.m1089a("The pic cache dir do not exists.");
                    return;
                }
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    m3619a(listFiles);
                    long j2 = f2946a;
                    int length = listFiles.length - 1;
                    while (true) {
                        if (length < 0) {
                            j = 0;
                            break;
                        }
                        File file2 = listFiles[length];
                        if (file2 != null) {
                            if (j2 <= 31457280 && System.currentTimeMillis() - file2.lastModified() <= 864000000) {
                                j = file2.lastModified();
                                break;
                            }
                            j2 -= file2.length();
                            file2.delete();
                        }
                        length--;
                    }
                    f2946a = Math.max(j2, 0L);
                    f2948b = j;
                } else {
                    AbstractC1417b.m1089a("The pic cache file list is null.");
                }
            }
        }
    }

    /* renamed from: b */
    private static synchronized void m3621b(Context context) {
        String str;
        File file;
        synchronized (C1747ae.class) {
            if (f2947a) {
                return;
            }
            f2946a = 0L;
            f2948b = 0L;
            try {
                file = new File(m3616a(context));
            } catch (Throwable th) {
                try {
                    AbstractC1417b.m1103d("Init pic cache error: " + th);
                    f2947a = true;
                    str = "Init pic cache finish.";
                } finally {
                    f2947a = true;
                    AbstractC1417b.m1098b("Init pic cache finish.");
                }
            }
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        f2946a += file2.length();
                        long j = f2948b;
                        if (j <= 0) {
                            f2948b = file2.lastModified();
                        } else {
                            f2948b = Math.min(j, file2.lastModified());
                        }
                    }
                }
                f2947a = true;
                str = "Init pic cache finish.";
                AbstractC1417b.m1098b(str);
            }
        }
    }

    /* renamed from: a */
    private static void m3619a(File[] fileArr) {
        if (fileArr != null) {
            try {
                if (fileArr.length > 1) {
                    Arrays.sort(fileArr, new Comparator<File>() { // from class: com.xiaomi.push.service.ae.1
                        @Override // java.util.Comparator
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public int compare(File file, File file2) {
                            if (file == file2) {
                                return 0;
                            }
                            if (file == null) {
                                return 1;
                            }
                            if (file2 == null) {
                                return -1;
                            }
                            long lastModified = file.lastModified() - file2.lastModified();
                            if (lastModified == 0) {
                                return 0;
                            }
                            return lastModified < 0 ? 1 : -1;
                        }
                    });
                }
            } catch (Throwable th) {
                AbstractC1417b.m1103d("Sort pic cache error: " + th);
            }
        }
    }

    /* renamed from: a */
    private static String m3616a(Context context) {
        return context.getCacheDir().getPath() + File.separator + "mipush_icon";
    }
}
