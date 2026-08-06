package com.bytedance.trae.conversation.fileupload;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceUploadModels.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;", "", "oids", "", "", "sessionKey", "bizType", "Lcom/bytedance/trae/conversation/fileupload/BizType;", "<init>", "(Ljava/util/List;Ljava/lang/String;Lcom/bytedance/trae/conversation/fileupload/BizType;)V", "getOids", "()Ljava/util/List;", "getSessionKey", "()Ljava/lang/String;", "getBizType", "()Lcom/bytedance/trae/conversation/fileupload/BizType;", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CommitResourceUploadResultRequest {

    @SerializedName("biz_type")
    private final BizType bizType;

    @SerializedName("oids")
    private final List<String> oids;

    @SerializedName("session_key")
    private final String sessionKey;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommitResourceUploadResultRequest copy$default(CommitResourceUploadResultRequest commitResourceUploadResultRequest, List list, String str, BizType bizType, int i, Object obj) {
        if ((i & 1) != 0) {
            list = commitResourceUploadResultRequest.oids;
        }
        if ((i & 2) != 0) {
            str = commitResourceUploadResultRequest.sessionKey;
        }
        if ((i & 4) != 0) {
            bizType = commitResourceUploadResultRequest.bizType;
        }
        return commitResourceUploadResultRequest.copy(list, str, bizType);
    }

    public final List<String> component1() {
        return this.oids;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSessionKey() {
        return this.sessionKey;
    }

    /* renamed from: component3, reason: from getter */
    public final BizType getBizType() {
        return this.bizType;
    }

    public final CommitResourceUploadResultRequest copy(List<String> oids, String sessionKey, BizType bizType) {
        Intrinsics.checkNotNullParameter(oids, "oids");
        Intrinsics.checkNotNullParameter(sessionKey, "sessionKey");
        return new CommitResourceUploadResultRequest(oids, sessionKey, bizType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommitResourceUploadResultRequest)) {
            return false;
        }
        CommitResourceUploadResultRequest commitResourceUploadResultRequest = (CommitResourceUploadResultRequest) other;
        return Intrinsics.areEqual(this.oids, commitResourceUploadResultRequest.oids) && Intrinsics.areEqual(this.sessionKey, commitResourceUploadResultRequest.sessionKey) && this.bizType == commitResourceUploadResultRequest.bizType;
    }

    public int hashCode() {
        int hashCode = ((this.oids.hashCode() * 31) + this.sessionKey.hashCode()) * 31;
        BizType bizType = this.bizType;
        return hashCode + (bizType == null ? 0 : bizType.hashCode());
    }

    public String toString() {
        return "CommitResourceUploadResultRequest(oids=" + this.oids + ", sessionKey=" + this.sessionKey + ", bizType=" + this.bizType + ')';
    }

    public CommitResourceUploadResultRequest(List<String> oids, String sessionKey, BizType bizType) {
        Intrinsics.checkNotNullParameter(oids, "oids");
        Intrinsics.checkNotNullParameter(sessionKey, "sessionKey");
        this.oids = oids;
        this.sessionKey = sessionKey;
        this.bizType = bizType;
    }

    public /* synthetic */ CommitResourceUploadResultRequest(List list, String str, BizType bizType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, (i & 4) != 0 ? null : bizType);
    }

    public final List<String> getOids() {
        return this.oids;
    }

    public final String getSessionKey() {
        return this.sessionKey;
    }

    public final BizType getBizType() {
        return this.bizType;
    }
}
