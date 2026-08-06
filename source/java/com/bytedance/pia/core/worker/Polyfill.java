package com.bytedance.pia.core.worker;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.anniex.R;
import com.bytedance.pia.core.api.PiaEnv;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.core.utils.StreamUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class Polyfill {
    static /* synthetic */ String access$100() {
        return buildPolyfill();
    }

    public static String getValue() {
        return LazyPolyfill.INSTANCE;
    }

    private static String buildPolyfill() {
        String str;
        Context applicationContext = PiaEnv.Default.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            str = StreamUtils.readAndClose(applicationContext.getResources().openRawResource(R.raw.pia_worker_polyfill));
        } catch (Throwable th) {
            Logger.m179e("[Worker] load worker polyfill error:", th);
            str = null;
        }
        Logger.m181i("[Worker] load worker polyfill success, cost: " + (System.currentTimeMillis() - currentTimeMillis));
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    public static String buildPolyfillForTesting() {
        return buildPolyfill();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class LazyPolyfill {
        private static final String INSTANCE = Polyfill.access$100();

        private LazyPolyfill() {
        }
    }
}
