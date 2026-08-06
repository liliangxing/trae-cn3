package com.bytedance.mobsec.metasec.ml;

import android.content.Context;
import ms.bd.c.k2;
import ms.bd.c.n;
import ms.bd.c.n2;
import ms.bd.c.p2;

/* loaded from: classes4.dex */
public final class MSManagerUtils {

    /* loaded from: classes4.dex */
    public interface IMsBundleCallback {
        void callBack(int i, String str, String str2);
    }

    /* loaded from: classes4.dex */
    public static class MSBusinessHelper {
        private byte[] data;
        private int event;
        private int type;

        /* loaded from: classes4.dex */
        public static class MSBpEvent {
            public static final int _1f137e7ca8e2b6875b5ff7e05434a31c = 1;
            public static final int _e4589bc87b7549ba5e7875168dd20ddd = 0;
        }

        /* loaded from: classes4.dex */
        public static class MSBpType {
            public static final int _196e216d4eb8fae8f995f75bc16112c2 = 0;
            public static final int _bd7fe0e9fad446f93311fad566672b69 = 1;
        }

        public MSBusinessHelper(int i, int i2, byte[] bArr) {
            this.type = i;
            this.event = i2;
            this.data = bArr;
        }
    }

    /* loaded from: classes4.dex */
    public interface ScenePageNameCallback {
        int getScenePageName();
    }

    public static synchronized MSManager get(String str) {
        MSManager mSManager;
        synchronized (MSManagerUtils.class) {
            k2 a = n2.a(str);
            mSManager = a != null ? new MSManager(a) : null;
        }
        return mSManager;
    }

    public static synchronized boolean init(Context context, MSConfig mSConfig) {
        boolean a;
        synchronized (MSManagerUtils.class) {
            a = n2.a(context, mSConfig.a());
        }
        return a;
    }

    public static int registerScenePageNameCallback(int i, ScenePageNameCallback scenePageNameCallback) {
        if (scenePageNameCallback != null) {
            n.d.put(Integer.valueOf(i), scenePageNameCallback);
            return 0;
        }
        int i2 = n.a;
        return -1;
    }

    public static String versionInfo() {
        boolean z = n2.d;
        return (String) p2.a(67108867, 0, 0L, null, null);
    }
}
