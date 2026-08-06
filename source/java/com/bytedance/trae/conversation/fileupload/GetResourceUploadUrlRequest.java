package com.bytedance.trae.conversation.fileupload;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceUploadModels.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlRequest;", "", "targets", "", "", "bizType", "Lcom/bytedance/trae/conversation/fileupload/BizType;", "<init>", "(Ljava/util/List;Lcom/bytedance/trae/conversation/fileupload/BizType;)V", "getTargets", "()Ljava/util/List;", "getBizType", "()Lcom/bytedance/trae/conversation/fileupload/BizType;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GetResourceUploadUrlRequest {

    @SerializedName("biz_type")
    private final BizType bizType;

    @SerializedName("targets")
    private final List<String> targets;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetResourceUploadUrlRequest copy$default(GetResourceUploadUrlRequest getResourceUploadUrlRequest, List list, BizType bizType, int i, Object obj) {
        if ((i & 1) != 0) {
            list = getResourceUploadUrlRequest.targets;
        }
        if ((i & 2) != 0) {
            bizType = getResourceUploadUrlRequest.bizType;
        }
        return getResourceUploadUrlRequest.copy(list, bizType);
    }

    public final List<String> component1() {
        return this.targets;
    }

    /* renamed from: component2, reason: from getter */
    public final BizType getBizType() {
        return this.bizType;
    }

    public final GetResourceUploadUrlRequest copy(List<String> targets, BizType bizType) {
        Intrinsics.checkNotNullParameter(targets, "targets");
        return new GetResourceUploadUrlRequest(targets, bizType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetResourceUploadUrlRequest)) {
            return false;
        }
        GetResourceUploadUrlRequest getResourceUploadUrlRequest = (GetResourceUploadUrlRequest) other;
        return Intrinsics.areEqual(this.targets, getResourceUploadUrlRequest.targets) && this.bizType == getResourceUploadUrlRequest.bizType;
    }

    public int hashCode() {
        int hashCode = this.targets.hashCode() * 31;
        BizType bizType = this.bizType;
        return hashCode + (bizType == null ? 0 : bizType.hashCode());
    }

    public String toString() {
        return "GetResourceUploadUrlRequest(targets=" + this.targets + ", bizType=" + this.bizType + ')';
    }

    public GetResourceUploadUrlRequest(List<String> targets, BizType bizType) {
        Intrinsics.checkNotNullParameter(targets, "targets");
        this.targets = targets;
        this.bizType = bizType;
    }

    public /* synthetic */ GetResourceUploadUrlRequest(List list, BizType bizType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : bizType);
    }

    public final List<String> getTargets() {
        return this.targets;
    }

    public final BizType getBizType() {
        return this.bizType;
    }
}
