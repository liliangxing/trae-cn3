package com.bytedance.trae.conversation.fileupload;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceUploadModels.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;", "", "success", "", "stage", "Lcom/bytedance/trae/conversation/fileupload/UploadStage;", "error", "", "timings", "Lcom/bytedance/trae/conversation/fileupload/UploadTimings;", "<init>", "(ZLcom/bytedance/trae/conversation/fileupload/UploadStage;Ljava/lang/String;Lcom/bytedance/trae/conversation/fileupload/UploadTimings;)V", "getSuccess", "()Z", "getStage", "()Lcom/bytedance/trae/conversation/fileupload/UploadStage;", "getError", "()Ljava/lang/String;", "getTimings", "()Lcom/bytedance/trae/conversation/fileupload/UploadTimings;", "component1", "component2", "component3", "component4", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UploadFinishInfo {
    private final String error;
    private final UploadStage stage;
    private final boolean success;
    private final UploadTimings timings;

    public static /* synthetic */ UploadFinishInfo copy$default(UploadFinishInfo uploadFinishInfo, boolean z, UploadStage uploadStage, String str, UploadTimings uploadTimings, int i, Object obj) {
        if ((i & 1) != 0) {
            z = uploadFinishInfo.success;
        }
        if ((i & 2) != 0) {
            uploadStage = uploadFinishInfo.stage;
        }
        if ((i & 4) != 0) {
            str = uploadFinishInfo.error;
        }
        if ((i & 8) != 0) {
            uploadTimings = uploadFinishInfo.timings;
        }
        return uploadFinishInfo.copy(z, uploadStage, str, uploadTimings);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2, reason: from getter */
    public final UploadStage getStage() {
        return this.stage;
    }

    /* renamed from: component3, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* renamed from: component4, reason: from getter */
    public final UploadTimings getTimings() {
        return this.timings;
    }

    public final UploadFinishInfo copy(boolean success, UploadStage stage, String error, UploadTimings timings) {
        return new UploadFinishInfo(success, stage, error, timings);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadFinishInfo)) {
            return false;
        }
        UploadFinishInfo uploadFinishInfo = (UploadFinishInfo) other;
        return this.success == uploadFinishInfo.success && this.stage == uploadFinishInfo.stage && Intrinsics.areEqual(this.error, uploadFinishInfo.error) && Intrinsics.areEqual(this.timings, uploadFinishInfo.timings);
    }

    public int hashCode() {
        int hashCode = Boolean.hashCode(this.success) * 31;
        UploadStage uploadStage = this.stage;
        int hashCode2 = (hashCode + (uploadStage == null ? 0 : uploadStage.hashCode())) * 31;
        String str = this.error;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        UploadTimings uploadTimings = this.timings;
        return hashCode3 + (uploadTimings != null ? uploadTimings.hashCode() : 0);
    }

    public String toString() {
        return "UploadFinishInfo(success=" + this.success + ", stage=" + this.stage + ", error=" + this.error + ", timings=" + this.timings + ')';
    }

    public UploadFinishInfo(boolean z, UploadStage uploadStage, String str, UploadTimings uploadTimings) {
        this.success = z;
        this.stage = uploadStage;
        this.error = str;
        this.timings = uploadTimings;
    }

    public /* synthetic */ UploadFinishInfo(boolean z, UploadStage uploadStage, String str, UploadTimings uploadTimings, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : uploadStage, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : uploadTimings);
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final UploadStage getStage() {
        return this.stage;
    }

    public final String getError() {
        return this.error;
    }

    public final UploadTimings getTimings() {
        return this.timings;
    }
}
