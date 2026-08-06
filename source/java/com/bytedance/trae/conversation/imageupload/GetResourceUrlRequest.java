package com.bytedance.trae.conversation.imageupload;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageUploadModels.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/GetResourceUrlRequest;", "", "uriList", "", "", "bizType", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getUriList", "()Ljava/util/List;", "getBizType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GetResourceUrlRequest {

    @SerializedName("biz_type")
    private final String bizType;

    @SerializedName("uri_list")
    private final List<String> uriList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetResourceUrlRequest copy$default(GetResourceUrlRequest getResourceUrlRequest, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = getResourceUrlRequest.uriList;
        }
        if ((i & 2) != 0) {
            str = getResourceUrlRequest.bizType;
        }
        return getResourceUrlRequest.copy(list, str);
    }

    public final List<String> component1() {
        return this.uriList;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBizType() {
        return this.bizType;
    }

    public final GetResourceUrlRequest copy(List<String> uriList, String bizType) {
        Intrinsics.checkNotNullParameter(uriList, "uriList");
        return new GetResourceUrlRequest(uriList, bizType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetResourceUrlRequest)) {
            return false;
        }
        GetResourceUrlRequest getResourceUrlRequest = (GetResourceUrlRequest) other;
        return Intrinsics.areEqual(this.uriList, getResourceUrlRequest.uriList) && Intrinsics.areEqual(this.bizType, getResourceUrlRequest.bizType);
    }

    public int hashCode() {
        int hashCode = this.uriList.hashCode() * 31;
        String str = this.bizType;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "GetResourceUrlRequest(uriList=" + this.uriList + ", bizType=" + this.bizType + ')';
    }

    public GetResourceUrlRequest(List<String> uriList, String str) {
        Intrinsics.checkNotNullParameter(uriList, "uriList");
        this.uriList = uriList;
        this.bizType = str;
    }

    public /* synthetic */ GetResourceUrlRequest(List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : str);
    }

    public final List<String> getUriList() {
        return this.uriList;
    }

    public final String getBizType() {
        return this.bizType;
    }
}
