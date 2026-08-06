package com.lynx.canvas.loader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.lynx.canvas.Krypton;
import com.lynx.canvas.KryptonLLog;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Thread;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes6.dex */
public class KryptonResourceUtils {
    private static final String ASSET_SCHEME_PREFIX = "asset:///";
    private static final String BASE64_PREFIX = "base64,";
    private static final int BUFFER_MAX_SIZE = 65536;
    private static final int BUFFER_MIN_SIZE = 1024;
    private static final String CONTENT_SCHEMA_PREFIX = "content://";
    private static final String DATA_SCHEMA_PREFIX = "data:";
    private static final String FILE_SCHEME_PREFIX = "file://";
    private static final String HTTPS_SCHEME_PREFIX = "https://";
    private static final String HTTP_SCHEME_PREFIX = "http://";
    private static final String RESOURCE_SCHEME_PREFIX = "res:///";
    private static final String TAG = "KryptonResourceUtils";
    private static volatile Executor sBriefIOExecutor;

    /* loaded from: classes6.dex */
    public enum KryptonSchemaType {
        EMPTY,
        INVALID,
        REMOTE,
        LOCAL,
        CONTENT,
        DATAURI
    }

    private static int clamp(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public static Executor getKryptonIOExecutor() {
        if (sBriefIOExecutor == null) {
            synchronized (KryptonResourceUtils.class) {
                if (sBriefIOExecutor == null) {
                    sBriefIOExecutor = getExecutor("krypton-brief-resource-thread", 5, 3);
                }
            }
        }
        return sBriefIOExecutor;
    }

    public static KryptonSchemaType schemaType(String str) {
        if (TextUtils.isEmpty(str)) {
            return KryptonSchemaType.EMPTY;
        }
        if (str.startsWith("http://") || str.startsWith("https://")) {
            return KryptonSchemaType.REMOTE;
        }
        if (str.startsWith("asset:///") || str.startsWith("res:///") || str.startsWith("file://")) {
            return KryptonSchemaType.LOCAL;
        }
        if (str.startsWith(CONTENT_SCHEMA_PREFIX)) {
            return KryptonSchemaType.CONTENT;
        }
        if (str.startsWith(DATA_SCHEMA_PREFIX) && str.contains(BASE64_PREFIX)) {
            return KryptonSchemaType.DATAURI;
        }
        return KryptonSchemaType.INVALID;
    }

    public static InputStream loadResourceFromLocalPath(String str) {
        if (schemaType(str) != KryptonSchemaType.LOCAL) {
            KryptonLLog.e(TAG, "The url is not a local path: " + str);
            return null;
        }
        try {
            Context context = Krypton.inst().getContext();
            if (str.startsWith("asset:///") && str.length() > 9) {
                KryptonLLog.i(TAG, "Load resource from asset: " + str);
                return context.getAssets().open(str.substring(9));
            }
            if (str.startsWith("res:///") && str.length() > 7) {
                KryptonLLog.i(TAG, "Load resource from res: " + str);
                return context.getResources().openRawResource(context.getResources().getIdentifier(str.substring(7), "drawable", context.getPackageCodePath()));
            }
            if (str.startsWith("file://") && str.length() > 7) {
                KryptonLLog.i(TAG, "Load resource from file: " + str);
                String substring = str.substring(7);
                if (!substring.startsWith("/")) {
                    substring = "/" + substring;
                }
                return new FileInputStream(new File(substring));
            }
            KryptonLLog.e(TAG, "the url is not available local path: " + str);
            return null;
        } catch (Exception e) {
            KryptonLLog.e(TAG, "Load stream from resource failed, the resource path is: " + str + " with error: " + e.getMessage());
            return null;
        }
    }

    public static boolean isHeif(byte[] bArr) {
        if (bArr == null || bArr.length < 12 || bArr[4] != 102 || bArr[5] != 116 || bArr[6] != 121 || bArr[7] != 112) {
            return false;
        }
        String str = new String(bArr, 8, 4);
        return str.equals("heic") || str.equals("heix") || str.equals("heim") || str.equals("heis") || str.equals("mif1") || str.equals("msf1");
    }

    public static boolean isDataURI(String str) {
        return schemaType(str) == KryptonSchemaType.DATAURI;
    }

    public static boolean isLocalPath(String str) {
        return schemaType(str) == KryptonSchemaType.LOCAL;
    }

    public static String getTruncatePath(String str) {
        int length = str.length();
        if (length > 500) {
            length = 500;
        }
        return str.substring(0, length);
    }

    public static Bitmap decodeBase64Image(String str) throws IllegalArgumentException {
        if (schemaType(str) == KryptonSchemaType.DATAURI) {
            byte[] decode = Base64.decode(getDataUrlBase64Content(str), 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        }
        throw new IllegalArgumentException("Call decodeBase64Image with invalid path" + str);
    }

    public static byte[] decodeDataURI(String str) throws IllegalArgumentException {
        KryptonSchemaType schemaType = schemaType(str);
        if (schemaType == KryptonSchemaType.DATAURI) {
            return Base64.decode(getDataUrlBase64Content(str), 0);
        }
        if (schemaType == KryptonSchemaType.EMPTY) {
            throw new IllegalArgumentException("Call decodeBase64DataUrl with empty path!");
        }
        throw new IllegalArgumentException("Call decodeBase64DataUrl with invalid path: " + getTruncatePath(str));
    }

    public static int getPreferredBufferSize(int i) {
        return clamp(i, 1024, 65536);
    }

    public static byte[] getByteArrayFromInputStream(InputStream inputStream, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (copyStream(inputStream, byteArrayOutputStream, i)) {
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }

    private static boolean copyStream(InputStream inputStream, OutputStream outputStream, int i) {
        if (inputStream == null || outputStream == null) {
            KryptonLLog.e(TAG, "Invalid input stream or output stream");
            return false;
        }
        try {
            try {
                int clamp = clamp(i, 1024, 65536);
                byte[] bArr = new byte[clamp];
                KryptonLLog.i(TAG, "Start read from stream...");
                while (true) {
                    int read = inputStream.read(bArr, 0, clamp);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        KryptonLLog.i(TAG, "End read from stream, the total stream content is: " + i);
                        closeQuietly(inputStream);
                        closeQuietly(outputStream);
                        return true;
                    }
                }
            } catch (IOException e) {
                KryptonLLog.e(TAG, "Failed to convert to byte array from LynxResResponse: " + e.getMessage());
                closeQuietly(inputStream);
                closeQuietly(outputStream);
                return false;
            }
        } catch (Throwable th) {
            closeQuietly(inputStream);
            closeQuietly(outputStream);
            throw th;
        }
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                KryptonLLog.e(TAG, "Failed to close resource: " + e.getMessage());
            }
        }
    }

    private static String getDataUrlBase64Content(String str) {
        return str.substring(str.indexOf(BASE64_PREFIX) + 7);
    }

    private static Executor getExecutor(final String str, final int i, int i2) {
        try {
            return Executors.newFixedThreadPool(i2, new ThreadFactory() { // from class: com.lynx.canvas.loader.KryptonResourceUtils.1
                private final AtomicInteger threadNumber = new AtomicInteger(1);

                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable, str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.threadNumber.getAndIncrement());
                    if (thread.isDaemon()) {
                        thread.setDaemon(false);
                    }
                    thread.setPriority(i);
                    thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.lynx.canvas.loader.KryptonResourceUtils.1.1
                        @Override // java.lang.Thread.UncaughtExceptionHandler
                        public void uncaughtException(Thread thread2, Throwable th) {
                            KryptonLLog.e(KryptonResourceUtils.TAG, th.toString());
                        }
                    });
                    return thread;
                }
            });
        } catch (Throwable th) {
            KryptonLLog.e(TAG, th.toString());
            return new Executor() { // from class: com.lynx.canvas.loader.KryptonResourceUtils.2
                @Override // java.util.concurrent.Executor
                public void execute(Runnable runnable) {
                }
            };
        }
    }

    public static byte[] mergeArray(byte[]... bArr) {
        int i = 0;
        for (byte[] bArr2 : bArr) {
            i += bArr2.length;
        }
        byte[] bArr3 = new byte[i];
        int i2 = 0;
        for (byte[] bArr4 : bArr) {
            int length = bArr4.length;
            if (length != 0) {
                System.arraycopy(bArr4, 0, bArr3, i2, length);
                i2 += length;
            }
        }
        return bArr3;
    }
}
