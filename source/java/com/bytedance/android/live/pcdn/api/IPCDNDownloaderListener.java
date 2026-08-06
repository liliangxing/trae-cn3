package com.bytedance.android.live.pcdn.api;

import kotlin.Metadata;

/* compiled from: IPCDNDownloaderListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0007J\u001c\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H&J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H&J\u001a\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/pcdn/api/IPCDNDownloaderListener;", "", "notifyAllCompleteFiles", "", "fileNamesWithPath", "", "", "([Ljava/lang/String;)V", "notifyAllUnfinishedFiles", "notifyMsg", "msgType", "msgValue", "notifyOdlLog", "msgTpye", "", "notifyPointLog", "livepcdn-api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public interface IPCDNDownloaderListener {
    void notifyAllCompleteFiles(String[] fileNamesWithPath);

    void notifyAllUnfinishedFiles(String[] fileNamesWithPath);

    void notifyMsg(String msgType, String msgValue);

    void notifyOdlLog(int msgTpye, String msgValue);

    void notifyPointLog(int msgTpye, String msgValue);
}
