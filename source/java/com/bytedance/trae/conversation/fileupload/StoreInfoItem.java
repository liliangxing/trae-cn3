package com.bytedance.trae.conversation.fileupload;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceUploadModels.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/fileupload/StoreInfoItem;", "", "auth", "", "storeUri", "overrideResourceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuth", "()Ljava/lang/String;", "getStoreUri", "getOverrideResourceId", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class StoreInfoItem {

    @SerializedName("auth")
    private final String auth;

    @SerializedName("override_resource_id")
    private final String overrideResourceId;

    @SerializedName("store_uri")
    private final String storeUri;

    public static /* synthetic */ StoreInfoItem copy$default(StoreInfoItem storeInfoItem, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = storeInfoItem.auth;
        }
        if ((i & 2) != 0) {
            str2 = storeInfoItem.storeUri;
        }
        if ((i & 4) != 0) {
            str3 = storeInfoItem.overrideResourceId;
        }
        return storeInfoItem.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAuth() {
        return this.auth;
    }

    /* renamed from: component2, reason: from getter */
    public final String getStoreUri() {
        return this.storeUri;
    }

    /* renamed from: component3, reason: from getter */
    public final String getOverrideResourceId() {
        return this.overrideResourceId;
    }

    public final StoreInfoItem copy(String auth, String storeUri, String overrideResourceId) {
        Intrinsics.checkNotNullParameter(auth, "auth");
        Intrinsics.checkNotNullParameter(storeUri, "storeUri");
        return new StoreInfoItem(auth, storeUri, overrideResourceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreInfoItem)) {
            return false;
        }
        StoreInfoItem storeInfoItem = (StoreInfoItem) other;
        return Intrinsics.areEqual(this.auth, storeInfoItem.auth) && Intrinsics.areEqual(this.storeUri, storeInfoItem.storeUri) && Intrinsics.areEqual(this.overrideResourceId, storeInfoItem.overrideResourceId);
    }

    public int hashCode() {
        int hashCode = ((this.auth.hashCode() * 31) + this.storeUri.hashCode()) * 31;
        String str = this.overrideResourceId;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "StoreInfoItem(auth=" + this.auth + ", storeUri=" + this.storeUri + ", overrideResourceId=" + this.overrideResourceId + ')';
    }

    public StoreInfoItem(String auth, String storeUri, String str) {
        Intrinsics.checkNotNullParameter(auth, "auth");
        Intrinsics.checkNotNullParameter(storeUri, "storeUri");
        this.auth = auth;
        this.storeUri = storeUri;
        this.overrideResourceId = str;
    }

    public /* synthetic */ StoreInfoItem(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3);
    }

    public final String getAuth() {
        return this.auth;
    }

    public final String getStoreUri() {
        return this.storeUri;
    }

    public final String getOverrideResourceId() {
        return this.overrideResourceId;
    }
}
