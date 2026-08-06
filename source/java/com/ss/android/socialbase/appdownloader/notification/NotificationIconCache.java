package com.ss.android.socialbase.appdownloader.notification;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.AppDownloadUtils;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NotificationIconCache {
    private static int MAX_CACHE_ICON_COUNT = 8;
    private static volatile NotificationIconCache sInstance;
    private IconLRUCache<Integer, Bitmap> mIconCache;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class IconLRUCache<K, T> extends LinkedHashMap<K, T> {
        final int mMaxSize;

        public IconLRUCache(int i, int i2) {
            super(i2, 0.75f, true);
            this.mMaxSize = i;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<K, T> entry) {
            return size() > this.mMaxSize;
        }
    }

    public static NotificationIconCache inst() {
        if (sInstance == null) {
            synchronized (NotificationIconCache.class) {
                if (sInstance == null) {
                    sInstance = new NotificationIconCache();
                }
            }
        }
        return sInstance;
    }

    private NotificationIconCache() {
        this.mIconCache = null;
        int i = MAX_CACHE_ICON_COUNT;
        this.mIconCache = new IconLRUCache<>(i, i / 2);
    }

    public Bitmap getAppIconByInfoId(int i) {
        return this.mIconCache.get(Integer.valueOf(i));
    }

    public void putAppIcon(int i, Bitmap bitmap) {
        this.mIconCache.put(Integer.valueOf(i), bitmap);
    }

    public void parseAndCacheIcon(final int i, final String str) {
        if (TextUtils.isEmpty(str) || getAppIconByInfoId(i) != null) {
            return;
        }
        DownloadComponentManager.getIOThreadExecutor().submit(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.notification.NotificationIconCache.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                ByteArrayOutputStream byteArrayOutputStream;
                ByteArrayInputStream byteArrayInputStream;
                ByteArrayInputStream byteArrayInputStream2;
                Throwable th;
                InputStream inputStream;
                Exception e;
                IDownloadHttpConnection downloadWithConnection;
                int i2 = 4;
                i2 = 4;
                i2 = 4;
                i2 = 4;
                i2 = 4;
                try {
                    try {
                        downloadWithConnection = DownloadComponentManager.downloadWithConnection(true, 0, str, null);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e2) {
                    byteArrayOutputStream = null;
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    e = e2;
                    inputStream = null;
                } catch (Throwable th3) {
                    byteArrayOutputStream = null;
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    th = th3;
                    inputStream = null;
                }
                if (downloadWithConnection != null) {
                    inputStream = downloadWithConnection.getInputStream();
                    try {
                        byteArrayOutputStream = NotificationIconCache.cloneInputStream(inputStream);
                        try {
                            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            try {
                                byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                                try {
                                    BitmapFactory.Options options = new BitmapFactory.Options();
                                    options.inJustDecodeBounds = true;
                                    BitmapFactory.decodeStream(byteArrayInputStream, null, options);
                                    int i3 = options.outWidth;
                                    int i4 = options.outHeight;
                                    int dp2px = AppDownloadUtils.dp2px(DownloadComponentManager.getAppContext(), 44.0f);
                                    options.inSampleSize = NotificationIconCache.getFitInSampleSize(dp2px, dp2px, options);
                                    options.inJustDecodeBounds = false;
                                    NotificationIconCache.this.mIconCache.put(Integer.valueOf(i), BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                                    Closeable[] closeableArr = {inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2};
                                    DownloadUtils.safeClose(closeableArr);
                                    i2 = closeableArr;
                                } catch (Exception e3) {
                                    e = e3;
                                    e.printStackTrace();
                                    Closeable[] closeableArr2 = {inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2};
                                    DownloadUtils.safeClose(closeableArr2);
                                    i2 = closeableArr2;
                                    return;
                                }
                            } catch (Exception e4) {
                                byteArrayInputStream2 = null;
                                e = e4;
                            } catch (Throwable th4) {
                                byteArrayInputStream2 = null;
                                th = th4;
                                Closeable[] closeableArr3 = new Closeable[i2];
                                closeableArr3[0] = inputStream;
                                closeableArr3[1] = byteArrayOutputStream;
                                closeableArr3[2] = byteArrayInputStream;
                                closeableArr3[3] = byteArrayInputStream2;
                                DownloadUtils.safeClose(closeableArr3);
                                throw th;
                            }
                        } catch (Exception e5) {
                            byteArrayInputStream2 = null;
                            e = e5;
                            byteArrayInputStream = null;
                        } catch (Throwable th5) {
                            byteArrayInputStream2 = null;
                            th = th5;
                            byteArrayInputStream = null;
                        }
                    } catch (Exception e6) {
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        e = e6;
                        byteArrayOutputStream = null;
                    } catch (Throwable th6) {
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        th = th6;
                        byteArrayOutputStream = null;
                    }
                    return;
                }
                DownloadUtils.safeClose(null, null, null, null);
            }
        });
    }

    public static int getFitInSampleSize(int i, int i2, BitmapFactory.Options options) {
        if (options.outWidth > i || options.outHeight > i2) {
            return Math.min(Math.round(options.outWidth / i), Math.round(options.outHeight / i2));
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteArrayOutputStream cloneInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream;
            }
        }
    }
}
