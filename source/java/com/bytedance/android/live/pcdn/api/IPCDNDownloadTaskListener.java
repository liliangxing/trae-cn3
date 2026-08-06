package com.bytedance.android.live.pcdn.api;

import kotlin.Metadata;

/* compiled from: IPCDNDownloadTaskListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&J\"\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H&J(\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH&¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/pcdn/api/IPCDNDownloadTaskListener;", "", "notifyMsg", "", "task", "Lcom/bytedance/android/live/pcdn/api/IPCDNDownloadTask;", "msgType", "", "msgValue", "notifyTaskComplete", "notifyTaskData", "offset", "", "canReadSize", "notifyTaskError", "errorCode", "", "errorMsg", "notifyTaskProgress", "fileSize", "dloadPos", "dloadSpeed", "livepcdn-api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public interface IPCDNDownloadTaskListener {
    void notifyMsg(IPCDNDownloadTask task, String msgType, String msgValue);

    void notifyTaskComplete(IPCDNDownloadTask task);

    void notifyTaskData(IPCDNDownloadTask task, long offset, long canReadSize);

    void notifyTaskError(IPCDNDownloadTask task, int errorCode, String errorMsg);

    void notifyTaskProgress(IPCDNDownloadTask task, long fileSize, long dloadPos, long dloadSpeed);
}
