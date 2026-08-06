package com.bytedance.trae.conversation.fileupload;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceUploadModels.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;", "", "uploadHosts", "", "", "storeInfos", "Lcom/bytedance/trae/conversation/fileupload/StoreInfoItem;", "sessionKey", "overrideResourceId", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getUploadHosts", "()Ljava/util/List;", "getStoreInfos", "getSessionKey", "()Ljava/lang/String;", "getOverrideResourceId", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GetResourceUploadUrlResponse {

    @SerializedName("override_resource_id")
    private final String overrideResourceId;

    @SerializedName("session_key")
    private final String sessionKey;

    @SerializedName("store_infos")
    private final List<StoreInfoItem> storeInfos;

    @SerializedName("upload_hosts")
    private final List<String> uploadHosts;

    public GetResourceUploadUrlResponse() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetResourceUploadUrlResponse copy$default(GetResourceUploadUrlResponse getResourceUploadUrlResponse, List list, List list2, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = getResourceUploadUrlResponse.uploadHosts;
        }
        if ((i & 2) != 0) {
            list2 = getResourceUploadUrlResponse.storeInfos;
        }
        if ((i & 4) != 0) {
            str = getResourceUploadUrlResponse.sessionKey;
        }
        if ((i & 8) != 0) {
            str2 = getResourceUploadUrlResponse.overrideResourceId;
        }
        return getResourceUploadUrlResponse.copy(list, list2, str, str2);
    }

    public final List<String> component1() {
        return this.uploadHosts;
    }

    public final List<StoreInfoItem> component2() {
        return this.storeInfos;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSessionKey() {
        return this.sessionKey;
    }

    /* renamed from: component4, reason: from getter */
    public final String getOverrideResourceId() {
        return this.overrideResourceId;
    }

    public final GetResourceUploadUrlResponse copy(List<String> uploadHosts, List<StoreInfoItem> storeInfos, String sessionKey, String overrideResourceId) {
        return new GetResourceUploadUrlResponse(uploadHosts, storeInfos, sessionKey, overrideResourceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetResourceUploadUrlResponse)) {
            return false;
        }
        GetResourceUploadUrlResponse getResourceUploadUrlResponse = (GetResourceUploadUrlResponse) other;
        return Intrinsics.areEqual(this.uploadHosts, getResourceUploadUrlResponse.uploadHosts) && Intrinsics.areEqual(this.storeInfos, getResourceUploadUrlResponse.storeInfos) && Intrinsics.areEqual(this.sessionKey, getResourceUploadUrlResponse.sessionKey) && Intrinsics.areEqual(this.overrideResourceId, getResourceUploadUrlResponse.overrideResourceId);
    }

    public int hashCode() {
        List<String> list = this.uploadHosts;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<StoreInfoItem> list2 = this.storeInfos;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str = this.sessionKey;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.overrideResourceId;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "GetResourceUploadUrlResponse(uploadHosts=" + this.uploadHosts + ", storeInfos=" + this.storeInfos + ", sessionKey=" + this.sessionKey + ", overrideResourceId=" + this.overrideResourceId + ')';
    }

    public GetResourceUploadUrlResponse(List<String> list, List<StoreInfoItem> list2, String str, String str2) {
        this.uploadHosts = list;
        this.storeInfos = list2;
        this.sessionKey = str;
        this.overrideResourceId = str2;
    }

    public /* synthetic */ GetResourceUploadUrlResponse(List list, List list2, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2);
    }

    public final List<String> getUploadHosts() {
        return this.uploadHosts;
    }

    public final List<StoreInfoItem> getStoreInfos() {
        return this.storeInfos;
    }

    public final String getSessionKey() {
        return this.sessionKey;
    }

    public final String getOverrideResourceId() {
        return this.overrideResourceId;
    }
}
