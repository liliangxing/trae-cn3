package com.bytedance.sync.interfaze;

import android.content.Context;
import java.util.List;

/* loaded from: classes5.dex */
public interface ISyncClient {

    /* loaded from: classes5.dex */
    public static class Data {
        public long cursor;
        public byte[] data;
        public String did;
        public String msgId;
        public long publishTimeStamp;
        public long receiveTimeStamp;
        public String topic;
        public String uid;
    }

    /* loaded from: classes5.dex */
    public static class ReportItem {
        public byte[] data;
        public String msgId;
    }

    void addOnDataUpdateListener(OnDataUpdateListener onDataUpdateListener);

    void addOnSendInterceptor(ISendInterceptor iSendInterceptor);

    void remove();

    void removeOnDataUpdateListener(OnDataUpdateListener onDataUpdateListener);

    void removeOnSendInterceptor(ISendInterceptor iSendInterceptor);

    Result sendMsg(Context context, List<ReportItem> list);

    @Deprecated
    Result sendMsg(Context context, byte[] bArr);

    /* loaded from: classes5.dex */
    public static class Result {
        String errMsg;
        boolean success;

        public Result(boolean z, String str) {
            this.success = z;
            this.errMsg = str;
        }

        public boolean isSuccess() {
            return this.success;
        }

        public String getErrMsg() {
            return this.errMsg;
        }
    }
}
