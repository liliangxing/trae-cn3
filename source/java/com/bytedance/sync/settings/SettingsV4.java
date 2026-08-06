package com.bytedance.sync.settings;

import com.bytedance.sync.interfaze.ISettings;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class SettingsV4 implements ISettings {

    @SerializedName("version")
    private int version;

    @SerializedName("channel")
    private int channel = 0;

    @SerializedName("sync")
    private int sync = 60;

    @SerializedName("poll")
    private int poll = 600;

    @SerializedName("background_sync")
    private int backgroundSync = 300;

    @SerializedName("background_poll")
    private int backgroundPoll = 1200;

    @SerializedName("report_size_limit")
    private int reportSizeLimit = 6144;

    @SerializedName("submit_size_limit")
    private int submitSizeLimit = 51200;

    @SerializedName("db_store_size_limit")
    private int dbStoreSizeLimit = 51200;

    @SerializedName("event_change_interval")
    private int eventChangeInterval = 5;

    @SerializedName("is_compress")
    private int isCompress = 1;

    @SerializedName("history_size_limit")
    private int historyLimit = 10;

    @SerializedName("poll_interval_limit")
    private int pollIntervalLimit = 5000;

    @SerializedName("poll_try")
    private int pollTry = 1;

    @SerializedName("switch_sync_poll")
    private boolean switchSyncPoll = false;

    @SerializedName("enable_reconnect_poll")
    private boolean enableReconnectPoll = false;

    @SerializedName("reconnect_poll_interval")
    private int reconnectPollInterval = 3;

    @SerializedName("enable_batch_ack")
    private boolean enableBatchAck = true;

    @SerializedName("batch_ack_interval")
    private int batchAckInterval = 5;

    @SerializedName("batch_ack_count")
    private int batchAckCount = 10;

    @Override // com.bytedance.sync.interfaze.ISettings
    public boolean wsFirst() {
        return this.channel == 0;
    }

    @Override // com.bytedance.sync.interfaze.ISettings
    public int channel() {
        return this.channel;
    }

    @Override // com.bytedance.sync.interfaze.ISettings
    public int sync() {
        return this.sync;
    }

    @Override // com.bytedance.sync.interfaze.ISettings
    public int poll() {
        return this.poll;
    }

    @Override // com.bytedance.sync.interfaze.ISettings
    public int backgroundSync() {
        return this.backgroundSync;
    }

    @Override // com.bytedance.sync.interfaze.ISettings
    public int backgroundPoll() {
        return this.backgroundPoll;
    }

    @Override // com.bytedance.sync.interfaze.ISettings
    public int reportSizeLimit() {
        return this.reportSizeLimit;
    }

    @Override // com.bytedance.sync.interfaze.ISettings
    public int submitSizeLimit() {
        return this.submitSizeLimit;
    }

    @Override // com.bytedance.sync.interfaze.ISettings
    public int dbStoreSizeLimit() {
        return this.dbStoreSizeLimit;
    }

    @Override // com.bytedance.sync.interfaze.ISettings
    public long eventChangeInterval() {
        return this.eventChangeInterval;
    }

    @Override // com.bytedance.sync.interfaze.ISettings
    public boolean enableCompress() {
        return this.isCompress > 0;
    }

    @Override // com.bytedance.sync.interfaze.ISettings
    public int historyLimit() {
        return this.historyLimit;
    }

    @Override // com.bytedance.sync.interfaze.ISettings
    public int pollIntervalLimit() {
        return this.pollIntervalLimit;
    }

    @Override // com.bytedance.sync.interfaze.ISettings
    public int pollTry() {
        return this.pollTry;
    }

    @Override // com.bytedance.sync.interfaze.ISettings
    public boolean switchSyncPoll() {
        return this.switchSyncPoll;
    }

    @Override // com.bytedance.sync.interfaze.ISettings
    public boolean enableReconnectPoll() {
        return this.enableReconnectPoll;
    }

    @Override // com.bytedance.sync.interfaze.ISettings
    public int reconnectPollInterval() {
        return this.reconnectPollInterval;
    }

    @Override // com.bytedance.sync.interfaze.ISettings
    public boolean enableBatchAck() {
        return this.enableBatchAck;
    }

    @Override // com.bytedance.sync.interfaze.ISettings
    public int batchAckInterval() {
        int i = this.batchAckInterval;
        if (i > 0) {
            return i;
        }
        return 5;
    }

    @Override // com.bytedance.sync.interfaze.ISettings
    public int batchAckCount() {
        int i = this.batchAckCount;
        if (i > 0) {
            return i;
        }
        return 1;
    }
}
