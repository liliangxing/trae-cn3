package com.bytedance.reparo.core.utils;

import com.bytedance.reparo.core.patch.Patch;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class AutoFailSyncHelper extends TimesRecorder {
    static final String FILE_NAME = "auto_fail_sync";
    static final int MAX_COUNT = 3;
    public static final String TAG = "AutoFailSyncHelper";
    public static boolean mAutoFailThenSyncMode;
    private Patch mPatch;

    public AutoFailSyncHelper(final Patch patch, String str) {
        super(patch.javaPatch.getJavaPatchRootDir(), FILE_NAME, 3, str, new Runnable() { // from class: com.bytedance.reparo.core.utils.AutoFailSyncHelper.1
            @Override // java.lang.Runnable
            public void run() {
                Patch.this.getRecordInfo().setAsyncLoad(false);
            }
        });
        this.mPatch = patch;
    }

    public void fail() {
        if (mAutoFailThenSyncMode) {
            checkOrIncrement();
        }
    }

    public void success() {
        if (mAutoFailThenSyncMode && this.mPatch.getRecordInfo().isAsyncLoad() && !check()) {
            clear();
        }
    }
}
