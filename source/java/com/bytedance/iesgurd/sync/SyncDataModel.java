package com.bytedance.iesgurd.sync;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SyncMsgModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/iesgurd/sync/SyncDataModel;", "", "checkUpdateInfo", "Lcom/bytedance/iesgurd/sync/SyncUpdateModel;", "cleanInfo", "", "", "Lcom/bytedance/iesgurd/sync/SyncCleanModel;", "(Lcom/bytedance/iesgurd/sync/SyncUpdateModel;Ljava/util/Map;)V", "getCheckUpdateInfo", "()Lcom/bytedance/iesgurd/sync/SyncUpdateModel;", "getCleanInfo", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final /* data */ class SyncDataModel {

    @SerializedName("check_update_info")
    private final SyncUpdateModel checkUpdateInfo;

    @SerializedName("clean_info")
    private final Map<String, SyncCleanModel> cleanInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SyncDataModel copy$default(SyncDataModel syncDataModel, SyncUpdateModel syncUpdateModel, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            syncUpdateModel = syncDataModel.checkUpdateInfo;
        }
        if ((i & 2) != 0) {
            map = syncDataModel.cleanInfo;
        }
        return syncDataModel.copy(syncUpdateModel, map);
    }

    /* renamed from: component1, reason: from getter */
    public final SyncUpdateModel getCheckUpdateInfo() {
        return this.checkUpdateInfo;
    }

    public final Map<String, SyncCleanModel> component2() {
        return this.cleanInfo;
    }

    public final SyncDataModel copy(SyncUpdateModel checkUpdateInfo, Map<String, SyncCleanModel> cleanInfo) {
        return new SyncDataModel(checkUpdateInfo, cleanInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SyncDataModel)) {
            return false;
        }
        SyncDataModel syncDataModel = (SyncDataModel) other;
        return Intrinsics.areEqual(this.checkUpdateInfo, syncDataModel.checkUpdateInfo) && Intrinsics.areEqual(this.cleanInfo, syncDataModel.cleanInfo);
    }

    public int hashCode() {
        SyncUpdateModel syncUpdateModel = this.checkUpdateInfo;
        int hashCode = (syncUpdateModel != null ? syncUpdateModel.hashCode() : 0) * 31;
        Map<String, SyncCleanModel> map = this.cleanInfo;
        return hashCode + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "SyncDataModel(checkUpdateInfo=" + this.checkUpdateInfo + ", cleanInfo=" + this.cleanInfo + ")";
    }

    public SyncDataModel(SyncUpdateModel syncUpdateModel, Map<String, SyncCleanModel> map) {
        this.checkUpdateInfo = syncUpdateModel;
        this.cleanInfo = map;
    }

    public final SyncUpdateModel getCheckUpdateInfo() {
        return this.checkUpdateInfo;
    }

    public final Map<String, SyncCleanModel> getCleanInfo() {
        return this.cleanInfo;
    }
}
