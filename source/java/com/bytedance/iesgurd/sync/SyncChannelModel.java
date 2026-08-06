package com.bytedance.iesgurd.sync;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SyncMsgModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/iesgurd/sync/SyncChannelModel;", "", "channels", "", "", "(Ljava/util/List;)V", "getChannels", "()Ljava/util/List;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final /* data */ class SyncChannelModel {

    @SerializedName("target_chs")
    private final List<String> channels;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SyncChannelModel copy$default(SyncChannelModel syncChannelModel, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = syncChannelModel.channels;
        }
        return syncChannelModel.copy(list);
    }

    public final List<String> component1() {
        return this.channels;
    }

    public final SyncChannelModel copy(List<String> channels) {
        return new SyncChannelModel(channels);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof SyncChannelModel) && Intrinsics.areEqual(this.channels, ((SyncChannelModel) other).channels);
        }
        return true;
    }

    public int hashCode() {
        List<String> list = this.channels;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "SyncChannelModel(channels=" + this.channels + ")";
    }

    public SyncChannelModel(List<String> list) {
        this.channels = list;
    }

    public final List<String> getChannels() {
        return this.channels;
    }
}
