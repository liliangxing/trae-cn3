package com.ttnet.org.chromium.base;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.text.TextUtils;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.io.IOException;

@JNINamespace("base::android")
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ApkAssets {
    private static final String LOGTAG = "ApkAssets";

    public static long[] open(String str, String str2) {
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            try {
                Context applicationContext = ContextUtils.getApplicationContext();
                if (!TextUtils.isEmpty(str2) && BundleUtils.isIsolatedSplitInstalled(applicationContext, str2)) {
                    applicationContext = BundleUtils.createIsolatedSplitContext(applicationContext, str2);
                }
                assetFileDescriptor = applicationContext.getAssets().openNonAssetFd(str);
                long[] jArr = {assetFileDescriptor.getParcelFileDescriptor().detachFd(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength()};
                if (assetFileDescriptor != null) {
                    try {
                        assetFileDescriptor.close();
                    } catch (IOException e) {
                        android.util.Log.e(LOGTAG, "Unable to close AssetFileDescriptor", e);
                    }
                }
                return jArr;
            } catch (IOException e2) {
                if (!e2.getMessage().equals("") && !e2.getMessage().equals(str)) {
                    android.util.Log.e(LOGTAG, "Error while loading asset " + str + ": " + e2);
                }
                long[] jArr2 = {-1, -1, -1};
                if (assetFileDescriptor != null) {
                    try {
                        assetFileDescriptor.close();
                    } catch (IOException e3) {
                        android.util.Log.e(LOGTAG, "Unable to close AssetFileDescriptor", e3);
                    }
                }
                return jArr2;
            }
        } catch (Throwable th) {
            if (assetFileDescriptor != null) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException e4) {
                    android.util.Log.e(LOGTAG, "Unable to close AssetFileDescriptor", e4);
                }
            }
            throw th;
        }
    }
}
