package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;

/* loaded from: classes7.dex */
public interface ITempFileSaveCompleteCallback {
    void onFailed(BaseException baseException);

    void onSameTaskSave();

    void onSuccess();
}
