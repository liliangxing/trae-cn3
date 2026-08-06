package com.bytedance.iesgurd.sync;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.notification.NotificationDeleteBroadcastReceiver;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SyncMsgModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/bytedance/iesgurd/sync/SyncMsgModel;", "", "msgType", "", "syncTaskId", "timestamp", "", "data", "Lcom/bytedance/iesgurd/sync/SyncDataModel;", "(IIJLcom/bytedance/iesgurd/sync/SyncDataModel;)V", "getData", "()Lcom/bytedance/iesgurd/sync/SyncDataModel;", "getMsgType", "()I", "getSyncTaskId", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final /* data */ class SyncMsgModel {

    @SerializedName("data")
    private final SyncDataModel data;

    @SerializedName(NotificationDeleteBroadcastReceiver.KEY_MSG_TYPE)
    private final int msgType;

    @SerializedName("sync_task_id")
    private final int syncTaskId;

    @SerializedName("timestamp")
    private final long timestamp;

    public static /* synthetic */ SyncMsgModel copy$default(SyncMsgModel syncMsgModel, int i, int i2, long j, SyncDataModel syncDataModel, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = syncMsgModel.msgType;
        }
        if ((i3 & 2) != 0) {
            i2 = syncMsgModel.syncTaskId;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            j = syncMsgModel.timestamp;
        }
        long j2 = j;
        if ((i3 & 8) != 0) {
            syncDataModel = syncMsgModel.data;
        }
        return syncMsgModel.copy(i, i4, j2, syncDataModel);
    }

    /* renamed from: component1, reason: from getter */
    public final int getMsgType() {
        return this.msgType;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSyncTaskId() {
        return this.syncTaskId;
    }

    /* renamed from: component3, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component4, reason: from getter */
    public final SyncDataModel getData() {
        return this.data;
    }

    public final SyncMsgModel copy(int msgType, int syncTaskId, long timestamp, SyncDataModel data) {
        return new SyncMsgModel(msgType, syncTaskId, timestamp, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SyncMsgModel)) {
            return false;
        }
        SyncMsgModel syncMsgModel = (SyncMsgModel) other;
        return this.msgType == syncMsgModel.msgType && this.syncTaskId == syncMsgModel.syncTaskId && this.timestamp == syncMsgModel.timestamp && Intrinsics.areEqual(this.data, syncMsgModel.data);
    }

    public int hashCode() {
        int i = ((this.msgType * 31) + this.syncTaskId) * 31;
        long j = this.timestamp;
        int i2 = (i + ((int) (j ^ (j >>> 32)))) * 31;
        SyncDataModel syncDataModel = this.data;
        return i2 + (syncDataModel != null ? syncDataModel.hashCode() : 0);
    }

    public String toString() {
        return "SyncMsgModel(msgType=" + this.msgType + ", syncTaskId=" + this.syncTaskId + ", timestamp=" + this.timestamp + ", data=" + this.data + ")";
    }

    public SyncMsgModel(int i, int i2, long j, SyncDataModel syncDataModel) {
        this.msgType = i;
        this.syncTaskId = i2;
        this.timestamp = j;
        this.data = syncDataModel;
    }

    public final int getMsgType() {
        return this.msgType;
    }

    public final int getSyncTaskId() {
        return this.syncTaskId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final SyncDataModel getData() {
        return this.data;
    }
}
