package com.bytedance.iesgurd.sync;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SyncMsgModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0017\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J!\u0010\n\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R$\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/iesgurd/sync/SyncUpdateModel;", "", "config", "", "", "Lcom/bytedance/iesgurd/sync/SyncChannelModel;", "(Ljava/util/Map;)V", "getConfig", "()Ljava/util/Map;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final /* data */ class SyncUpdateModel {

    @SerializedName("config")
    private final Map<String, SyncChannelModel> config;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SyncUpdateModel copy$default(SyncUpdateModel syncUpdateModel, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = syncUpdateModel.config;
        }
        return syncUpdateModel.copy(map);
    }

    public final Map<String, SyncChannelModel> component1() {
        return this.config;
    }

    public final SyncUpdateModel copy(Map<String, SyncChannelModel> config) {
        return new SyncUpdateModel(config);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof SyncUpdateModel) && Intrinsics.areEqual(this.config, ((SyncUpdateModel) other).config);
        }
        return true;
    }

    public int hashCode() {
        Map<String, SyncChannelModel> map = this.config;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "SyncUpdateModel(config=" + this.config + ")";
    }

    public SyncUpdateModel(Map<String, SyncChannelModel> map) {
        this.config = map;
    }

    public final Map<String, SyncChannelModel> getConfig() {
        return this.config;
    }
}
