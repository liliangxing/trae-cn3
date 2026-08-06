package com.ss.android.update;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes7.dex */
public interface OnDownloadStatusChangedListener extends IUpdateDownloadListener {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface DownloadResultStatus {
        public static final int STATUS_CANCEL = -2;
        public static final int STATUS_FAILURE = -1;
        public static final int STATUS_SUCCESS = 1;
    }

    void onDownloadStatusChanged(int i);
}
