package com.bytedance.reparo.provider;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.bytedance.reparo.PatchUpdateManager;
import com.bytedance.reparo.secondary.Logger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PatchChangeObserver extends ContentObserver {
    private static final String SEPARATOR = ";";
    private static final String TAG = "PatchChangeObserver";

    public PatchChangeObserver(Handler handler) {
        super(handler);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z, Uri uri) {
        try {
            PatchUpdateManager.getInstance().updatePatchStatusForSubProcess();
        } catch (Throwable th) {
            Logger.m327e(TAG, "PatchChangeObserver -> onChanged failed:", th);
        }
    }
}
