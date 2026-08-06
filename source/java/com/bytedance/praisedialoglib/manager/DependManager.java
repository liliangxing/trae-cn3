package com.bytedance.praisedialoglib.manager;

import android.util.Log;
import com.bytedance.praisedialoglib.googleplay.IGooglePlayDepend;

/* loaded from: classes4.dex */
class DependManager {
    DependManager() {
    }

    public static IGooglePlayDepend getGooglePlayDepend() {
        try {
            return (IGooglePlayDepend) Class.forName("com.bytedance.praisedialoglib.googleplay.GooglePlayPraiseDepend").newInstance();
        } catch (Throwable th) {
            Log.e("ContentValues", "getGooglePlayDepend: throwable is ", th);
            return null;
        }
    }
}
