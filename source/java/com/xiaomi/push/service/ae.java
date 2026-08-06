package com.xiaomi.push.service;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
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

/* loaded from: classes7.dex */
public class ae {
    private static long a;

    /* renamed from: a, reason: collision with other field name */
    private static boolean f967a;
    private static long b;

    /* loaded from: classes7.dex */
    public static class b {
        public long a;

        /* renamed from: a, reason: collision with other field name */
        public Bitmap f969a;

        public b(Bitmap bitmap, long j) {
            this.f969a = bitmap;
            this.a = j;
        }
    }

    public static b a(Context context, String str, boolean z) {
        Bitmap b2;
        ByteArrayInputStream byteArrayInputStream = null;
        b bVar = new b(null, 0L);
        try {
            try {
                b2 = b(context, str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        if (b2 != null) {
            bVar.f969a = b2;
            com.xiaomi.push.v.a((Closeable) null);
            return bVar;
        }
        a a2 = a(str, z);
        if (a2 != null) {
            bVar.a = a2.a;
            byte[] bArr = a2.f968a;
            if (bArr != null) {
                if (z) {
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                    try {
                        int a3 = a(context, byteArrayInputStream2);
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = a3;
                        bVar.f969a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                        byteArrayInputStream = byteArrayInputStream2;
                    } catch (Exception e2) {
                        e = e2;
                        byteArrayInputStream = byteArrayInputStream2;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        com.xiaomi.push.v.a((Closeable) byteArrayInputStream);
                        return bVar;
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayInputStream = byteArrayInputStream2;
                        com.xiaomi.push.v.a((Closeable) byteArrayInputStream);
                        throw th;
                    }
                } else {
                    bVar.f969a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                }
            }
            a(context, a2.f968a, str);
            com.xiaomi.push.v.a((Closeable) byteArrayInputStream);
            return bVar;
        }
        com.xiaomi.push.v.a((Closeable) null);
        return bVar;
    }

    /* loaded from: classes7.dex */
    public static class a {
        int a;

        /* renamed from: a, reason: collision with other field name */
        byte[] f968a;

        public a(byte[] bArr, int i) {
            this.f968a = bArr;
            this.a = i;
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static a a(String str, boolean z) {
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
                com.xiaomi.channel.commonutils.logger.b.m9528a("Bitmap size is too big, max size is 102400  contentLen size is " + contentLength + " from url " + com.xiaomi.push.ba.a(str, 3));
                com.xiaomi.push.v.a((Closeable) null);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return null;
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                com.xiaomi.channel.commonutils.logger.b.m9528a("Invalid Http Response Code " + responseCode + " received");
                com.xiaomi.push.v.a((Closeable) null);
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
                    com.xiaomi.channel.commonutils.logger.b.m9528a("length 102400 exhausted.");
                    a aVar = new a(null, 102400);
                    com.xiaomi.push.v.a((Closeable) inputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return aVar;
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                a aVar2 = new a(byteArray, byteArray.length);
                com.xiaomi.push.v.a((Closeable) inputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return aVar2;
            } catch (SocketTimeoutException unused2) {
                com.xiaomi.channel.commonutils.logger.b.d("Connect timeout to " + str);
                com.xiaomi.push.v.a((Closeable) inputStream);
            } catch (IOException e2) {
                e = e2;
                com.xiaomi.channel.commonutils.logger.b.a(e);
                com.xiaomi.push.v.a((Closeable) inputStream);
            }
        } catch (SocketTimeoutException unused3) {
            inputStream = null;
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            com.xiaomi.push.v.a((Closeable) autoCloseInputStream);
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
    public static Bitmap a(Context context, String str) {
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
            int a2 = a(context, inputStream);
            inputStream2 = context.getContentResolver().openInputStream(parse);
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = a2;
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream2, null, options);
                com.xiaomi.push.v.a((Closeable) inputStream2);
                com.xiaomi.push.v.a((Closeable) inputStream);
                return decodeStream;
            } catch (IOException e2) {
                e = e2;
                com.xiaomi.channel.commonutils.logger.b.a(e);
                com.xiaomi.push.v.a((Closeable) inputStream2);
                com.xiaomi.push.v.a((Closeable) inputStream);
                return null;
            }
        } catch (IOException e3) {
            e = e3;
            inputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            com.xiaomi.push.v.a((Closeable) r0);
            com.xiaomi.push.v.a((Closeable) inputStream);
            throw th;
        }
    }

    private static int a(Context context, InputStream inputStream) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            com.xiaomi.channel.commonutils.logger.b.m9528a("decode dimension failed for bitmap.");
            return 1;
        }
        int round = Math.round((context.getResources().getDisplayMetrics().densityDpi / 160.0f) * 48.0f);
        if (options.outWidth <= round || options.outHeight <= round) {
            return 1;
        }
        return Math.min(options.outWidth / round, options.outHeight / round);
    }

    private static synchronized Bitmap b(Context context, String str) {
        Bitmap bitmap;
        File file;
        synchronized (ae.class) {
            FileInputStream fileInputStream = null;
            Bitmap bitmap2 = null;
            try {
                file = new File(a(context), com.xiaomi.push.ba.a(str));
            } catch (Throwable th) {
                th = th;
                bitmap = null;
            }
            if (!file.exists()) {
                return null;
            }
            if (System.currentTimeMillis() - file.lastModified() > 1209600000) {
                com.xiaomi.channel.commonutils.logger.b.m9528a("The pic cache has expired.");
                return null;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                bitmap2 = BitmapFactory.decodeStream(fileInputStream2);
                file.setLastModified(System.currentTimeMillis());
                com.xiaomi.push.v.a((Closeable) fileInputStream2);
            } catch (Throwable th2) {
                Bitmap bitmap3 = bitmap2;
                fileInputStream = fileInputStream2;
                th = th2;
                bitmap = bitmap3;
                try {
                    com.xiaomi.channel.commonutils.logger.b.d("Load bmp from cache error: " + th);
                    bitmap2 = bitmap;
                    return bitmap2;
                } finally {
                    com.xiaomi.push.v.a((Closeable) fileInputStream);
                }
            }
            return bitmap2;
        }
    }

    private static void a(Context context, byte[] bArr, String str) {
        FileOutputStream fileOutputStream;
        File file;
        BufferedOutputStream bufferedOutputStream;
        if (bArr == null) {
            com.xiaomi.channel.commonutils.logger.b.m9528a("cannot save small icon cause bitmap is null");
            return;
        }
        m10154a(context);
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            File file2 = new File(a(context));
            if (!file2.exists()) {
                file2.mkdirs();
            }
            file = new File(file2, com.xiaomi.push.ba.a(str));
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
            a += file.length();
            long j = b;
            if (j <= 0) {
                b = file.lastModified();
            } else {
                b = Math.min(j, file.lastModified());
            }
            com.xiaomi.push.v.a(bufferedOutputStream);
        } catch (Exception e3) {
            e = e3;
            bufferedOutputStream2 = bufferedOutputStream;
            com.xiaomi.channel.commonutils.logger.b.d("Save pic error: " + e);
            com.xiaomi.push.v.a(bufferedOutputStream2);
            com.xiaomi.push.v.a(fileOutputStream);
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream2 = bufferedOutputStream;
            com.xiaomi.push.v.a(bufferedOutputStream2);
            com.xiaomi.push.v.a(fileOutputStream);
            throw th;
        }
        com.xiaomi.push.v.a(fileOutputStream);
    }

    /* renamed from: a, reason: collision with other method in class */
    private static synchronized void m10154a(Context context) {
        File file;
        long j;
        synchronized (ae.class) {
            b(context);
            if (a >= 62914560 || System.currentTimeMillis() - b >= 1209600000) {
                try {
                    file = new File(a(context));
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.d("Clear pic cache error: " + th);
                }
                if (!file.exists()) {
                    com.xiaomi.channel.commonutils.logger.b.m9528a("The pic cache dir do not exists.");
                    return;
                }
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    a(listFiles);
                    long j2 = a;
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
                    a = Math.max(j2, 0L);
                    b = j;
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m9528a("The pic cache file list is null.");
                }
            }
        }
    }

    private static synchronized void b(Context context) {
        String str;
        File file;
        synchronized (ae.class) {
            if (f967a) {
                return;
            }
            a = 0L;
            b = 0L;
            try {
                file = new File(a(context));
            } catch (Throwable th) {
                try {
                    com.xiaomi.channel.commonutils.logger.b.d("Init pic cache error: " + th);
                    f967a = true;
                    str = "Init pic cache finish.";
                } finally {
                    f967a = true;
                    com.xiaomi.channel.commonutils.logger.b.b("Init pic cache finish.");
                }
            }
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        a += file2.length();
                        long j = b;
                        if (j <= 0) {
                            b = file2.lastModified();
                        } else {
                            b = Math.min(j, file2.lastModified());
                        }
                    }
                }
                f967a = true;
                str = "Init pic cache finish.";
                com.xiaomi.channel.commonutils.logger.b.b(str);
            }
        }
    }

    private static void a(File[] fileArr) {
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
                com.xiaomi.channel.commonutils.logger.b.d("Sort pic cache error: " + th);
            }
        }
    }

    private static String a(Context context) {
        return context.getCacheDir().getPath() + File.separator + "mipush_icon";
    }
}
