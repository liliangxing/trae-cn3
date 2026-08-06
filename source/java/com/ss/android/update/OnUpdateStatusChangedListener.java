package com.ss.android.update;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes7.dex */
public interface OnUpdateStatusChangedListener extends IUpdateDownloadListener {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface UpdateResultStatus {
        public static final int STATUS_AVAILABLE = 1;
        public static final int STATUS_FAILURE = -1;
        public static final int STATUS_NONE = -2;
    }

    void onUpdateStatusChanged(int i);
}
