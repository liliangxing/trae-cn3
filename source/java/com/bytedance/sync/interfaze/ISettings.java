package com.bytedance.sync.interfaze;

/* loaded from: classes5.dex */
public interface ISettings {
    int backgroundPoll();

    int backgroundSync();

    int batchAckCount();

    int batchAckInterval();

    int channel();

    int dbStoreSizeLimit();

    boolean enableBatchAck();

    boolean enableCompress();

    boolean enableReconnectPoll();

    long eventChangeInterval();

    int historyLimit();

    int poll();

    int pollIntervalLimit();

    int pollTry();

    int reconnectPollInterval();

    int reportSizeLimit();

    int submitSizeLimit();

    boolean switchSyncPoll();

    int sync();

    boolean wsFirst();
}
