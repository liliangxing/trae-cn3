package com.ss.android.socialbase.downloader.thread;

import android.util.Pair;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import java.util.List;

/* loaded from: classes7.dex */
public interface IDownloadRunnableCallback {
    void checkMaxBytes(long j, int i) throws BaseException;

    void handleFirstConnection(String str, IDownloadHeadHttpConnection iDownloadHeadHttpConnection, long j) throws BaseException;

    boolean onProgress(long j) throws BaseException;

    void onReceiveData(byte[] bArr, int i);

    void onReceiveHeader(List<Pair<String, String>> list);

    void onReceiveRequestLog(String str);

    void onReceiveSegmentData(long j, byte[] bArr, int i);
}
