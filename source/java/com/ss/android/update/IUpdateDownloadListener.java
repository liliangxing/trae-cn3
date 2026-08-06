package com.ss.android.update;

/* loaded from: classes7.dex */
public interface IUpdateDownloadListener {
    void downloadResult(boolean z, boolean z2);

    void onPrepare(boolean z);

    void saveDownloadInfo(int i, String str, boolean z);

    void updateProgress(int i, int i2, boolean z);
}
