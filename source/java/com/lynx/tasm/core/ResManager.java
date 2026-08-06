package com.lynx.tasm.core;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.provider.LynxResCallback;
import com.lynx.tasm.provider.LynxResRequest;
import com.lynx.tasm.provider.LynxResResponse;
import com.lynx.tasm.provider.ResProvider;
import com.ss.android.deviceregister.utils.RomUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ResManager {
    public static final String FILE_SCHEME = "file://";
    public static final String HTTPS_SCHEME = "https://";
    public static final String HTTP_SCHEME = "http://";
    public static final String LOCAL_ASSET_SCHEME = "asset:///";
    public static final String LOCAL_RESOURCE_SCHEME = "res:///";
    private static final int MAX_ID_CACHE_SIZE = 100;
    private static final String TAG = "lynx_ResManager";
    private static ResManager sInstance;
    private LruCache<String, Integer> mIdCache = new LruCache<>(100);

    public static ResManager inst() {
        if (sInstance == null) {
            synchronized (ResManager.class) {
                if (sInstance == null) {
                    sInstance = new ResManager();
                }
            }
        }
        return sInstance;
    }

    private ResManager() {
    }

    public LynxResResponse requestResourceSync(LynxResRequest lynxResRequest) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final LynxResResponse[] lynxResResponseArr = new LynxResResponse[1];
        try {
            requestResource(lynxResRequest, new LynxResCallback() { // from class: com.lynx.tasm.core.ResManager.1
                @Override // com.lynx.tasm.provider.LynxResCallback
                public void onSuccess(LynxResResponse lynxResResponse) {
                    lynxResResponseArr[0] = lynxResResponse;
                    countDownLatch.countDown();
                }

                @Override // com.lynx.tasm.provider.LynxResCallback
                public void onFailed(LynxResResponse lynxResResponse) {
                    lynxResResponseArr[0] = lynxResResponse;
                    countDownLatch.countDown();
                }
            });
        } catch (Throwable unused) {
            countDownLatch.countDown();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            LLog.e(TAG, "sync await failed:" + e.toString());
        }
        return lynxResResponseArr[0];
    }

    public void requestResource(final LynxResRequest lynxResRequest, final LynxResCallback lynxResCallback) {
        final LynxResResponse lynxResResponse = new LynxResResponse();
        final String url = lynxResRequest.getUrl();
        if (TextUtils.isEmpty(url)) {
            lynxResResponse.setReasonPhrase("url is empty!");
            lynxResCallback.onFailed(lynxResResponse);
            LLog.w(TAG, "url:" + url + " is empty!");
            return;
        }
        LynxThreadPool.getBriefIOExecutor().execute(new Runnable() { // from class: com.lynx.tasm.core.ResManager.2
            @Override // java.lang.Runnable
            public void run() {
                if ((url.startsWith(ResManager.HTTP_SCHEME) || url.startsWith("https://")) && url.length() > 8) {
                    ResManager.this.doFetch(lynxResRequest, lynxResCallback);
                    return;
                }
                if (url.startsWith(ResManager.LOCAL_ASSET_SCHEME) && url.length() > 9) {
                    ResManager.this.doFetchAssets(url, lynxResCallback);
                    return;
                }
                if (url.startsWith(ResManager.LOCAL_RESOURCE_SCHEME) && url.length() > 7) {
                    ResManager.this.doFetchRes(url, lynxResCallback);
                    return;
                }
                if (url.startsWith(ResManager.FILE_SCHEME) && url.length() > 7) {
                    ResManager.this.doFetchFile(url, lynxResCallback);
                    return;
                }
                LLog.DTHROW(new RuntimeException("illegal url:" + url));
                lynxResResponse.setReasonPhrase("url is illegal:" + url);
                lynxResCallback.onFailed(lynxResResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doFetch(LynxResRequest lynxResRequest, LynxResCallback lynxResCallback) {
        ResProvider resProvider = LynxEnv.inst().getResProvider();
        LLog.DCHECK(resProvider != null);
        if (resProvider == null) {
            LynxResResponse lynxResResponse = new LynxResResponse();
            lynxResResponse.setReasonPhrase("don't have ResProvider.Can't Get Resource.");
            lynxResCallback.onFailed(lynxResResponse);
            return;
        }
        resProvider.request(lynxResRequest, lynxResCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doFetchAssets(String str, LynxResCallback lynxResCallback) {
        LynxResResponse lynxResResponse = new LynxResResponse();
        InputStream inputStream = null;
        try {
            try {
                inputStream = LynxEnv.inst().getAppContext().getAssets().open(str.substring(9));
                StringBuilder sb = new StringBuilder(inputStream.available());
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        sb.append(new String(bArr, 0, read));
                    }
                }
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(sb.toString().getBytes());
                lynxResResponse.setInputStream(byteArrayInputStream);
                lynxResCallback.onSuccess(lynxResResponse);
                byteArrayInputStream.close();
                if (inputStream == null) {
                    return;
                }
            } catch (IOException e) {
                lynxResResponse.setReasonPhrase(e.toString());
                lynxResCallback.onFailed(lynxResResponse);
                if (inputStream == null) {
                    return;
                }
            }
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doFetchRes(String str, LynxResCallback lynxResCallback) {
        Integer findResId = findResId(LynxEnv.inst().getAppContext(), str.substring(7));
        LynxResResponse lynxResResponse = new LynxResResponse();
        if (findResId != null) {
            InputStream openRawResource = LynxEnv.inst().getAppContext().getResources().openRawResource(findResId.intValue());
            lynxResResponse.setInputStream(openRawResource);
            lynxResCallback.onSuccess(lynxResResponse);
            try {
                openRawResource.close();
                return;
            } catch (IOException unused) {
                return;
            }
        }
        lynxResResponse.setReasonPhrase("resource not found!");
        lynxResCallback.onFailed(lynxResResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doFetchFile(String str, LynxResCallback lynxResCallback) {
        File file;
        String substring = str.substring(7);
        if (substring.startsWith("/")) {
            file = new File(substring);
        } else {
            file = new File(LynxEnv.inst().getAppContext().getFilesDir(), substring);
        }
        LynxResResponse lynxResResponse = new LynxResResponse();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            StringBuilder sb = new StringBuilder(fileInputStream.available());
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    sb.append(new String(bArr, 0, read));
                } else {
                    lynxResResponse.setInputStream(new ByteArrayInputStream(sb.toString().getBytes()));
                    lynxResCallback.onSuccess(lynxResResponse);
                    fileInputStream.close();
                    return;
                }
            }
        } catch (FileNotFoundException unused) {
            lynxResResponse.setReasonPhrase("file not found!");
            lynxResCallback.onFailed(lynxResResponse);
        } catch (IOException unused2) {
            lynxResResponse.setReasonPhrase("IO failed");
            lynxResCallback.onFailed(lynxResResponse);
        }
    }

    public Integer findResId(Context context, String str) {
        if (str != null && !str.isEmpty()) {
            try {
                return Integer.valueOf(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                String replace = str.toLowerCase().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, RomUtils.SEPARATOR);
                Integer num = this.mIdCache.get(replace);
                if (num != null) {
                    return num;
                }
                int indexOf = replace.indexOf(47);
                if (indexOf > 0 && indexOf != replace.length() - 1) {
                    String substring = replace.substring(0, indexOf);
                    String substring2 = replace.substring(indexOf + 1);
                    int lastIndexOf = substring2.lastIndexOf(46);
                    if (lastIndexOf > 0) {
                        substring2 = substring2.substring(0, lastIndexOf);
                    }
                    synchronized (this) {
                        Integer num2 = this.mIdCache.get(replace);
                        if (num2 != null) {
                            return num2;
                        }
                        int identifier = context.getResources().getIdentifier(substring2, substring, context.getPackageName());
                        if (identifier == 0) {
                            return null;
                        }
                        this.mIdCache.put(replace, Integer.valueOf(identifier));
                        return Integer.valueOf(identifier);
                    }
                }
            }
        }
        return null;
    }
}
