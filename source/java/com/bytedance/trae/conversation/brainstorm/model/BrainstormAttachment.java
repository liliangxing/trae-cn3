package com.bytedance.trae.conversation.brainstorm.model;

import androidx.core.app.NotificationCompat;
import com.bytedance.forest.model.PreloadConfig;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BrainstormAttachment.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b-\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0007HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\t\u0010/\u001a\u00020\nHÆ\u0003J\t\u00100\u001a\u00020\rHÆ\u0003J\t\u00101\u001a\u00020\u000fHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00104\u001a\u00020\nHÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u009b\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00108\u001a\u00020\n2\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\u000fHÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0011\u0010\u0012\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR\u0011\u0010\u0013\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018¨\u0006<"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;", "", "attachmentId", "", "displayName", DBDefinition.MIME_TYPE, "sizeBytes", "", "localUri", "isImage", "", "useImageUpload", "state", "Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;", NotificationCompat.CATEGORY_PROGRESS, "", "uploadedRef", "errorMessage", "notifiedToBot", "createdAtMs", "groupId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ZZLcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;ILjava/lang/String;Ljava/lang/String;ZJLjava/lang/String;)V", "getAttachmentId", "()Ljava/lang/String;", "getDisplayName", "getMimeType", "getSizeBytes", "()J", "getLocalUri", "()Z", "getUseImageUpload", "getState", "()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;", "getProgress", "()I", "getUploadedRef", "getErrorMessage", "getNotifiedToBot", "getCreatedAtMs", "getGroupId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BrainstormAttachment {
    private final String attachmentId;
    private final long createdAtMs;
    private final String displayName;
    private final String errorMessage;
    private final String groupId;
    private final boolean isImage;
    private final String localUri;
    private final String mimeType;
    private final boolean notifiedToBot;
    private final int progress;
    private final long sizeBytes;
    private final AttachmentState state;
    private final String uploadedRef;
    private final boolean useImageUpload;

    /* renamed from: component1, reason: from getter */
    public final String getAttachmentId() {
        return this.attachmentId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getUploadedRef() {
        return this.uploadedRef;
    }

    /* renamed from: component11, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getNotifiedToBot() {
        return this.notifiedToBot;
    }

    /* renamed from: component13, reason: from getter */
    public final long getCreatedAtMs() {
        return this.createdAtMs;
    }

    /* renamed from: component14, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    /* renamed from: component4, reason: from getter */
    public final long getSizeBytes() {
        return this.sizeBytes;
    }

    /* renamed from: component5, reason: from getter */
    public final String getLocalUri() {
        return this.localUri;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsImage() {
        return this.isImage;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getUseImageUpload() {
        return this.useImageUpload;
    }

    /* renamed from: component8, reason: from getter */
    public final AttachmentState getState() {
        return this.state;
    }

    /* renamed from: component9, reason: from getter */
    public final int getProgress() {
        return this.progress;
    }

    public final BrainstormAttachment copy(String attachmentId, String displayName, String mimeType, long sizeBytes, String localUri, boolean isImage, boolean useImageUpload, AttachmentState state, int progress, String uploadedRef, String errorMessage, boolean notifiedToBot, long createdAtMs, String groupId) {
        Intrinsics.checkNotNullParameter(attachmentId, "attachmentId");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics.checkNotNullParameter(localUri, "localUri");
        Intrinsics.checkNotNullParameter(state, "state");
        return new BrainstormAttachment(attachmentId, displayName, mimeType, sizeBytes, localUri, isImage, useImageUpload, state, progress, uploadedRef, errorMessage, notifiedToBot, createdAtMs, groupId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BrainstormAttachment)) {
            return false;
        }
        BrainstormAttachment brainstormAttachment = (BrainstormAttachment) other;
        return Intrinsics.areEqual(this.attachmentId, brainstormAttachment.attachmentId) && Intrinsics.areEqual(this.displayName, brainstormAttachment.displayName) && Intrinsics.areEqual(this.mimeType, brainstormAttachment.mimeType) && this.sizeBytes == brainstormAttachment.sizeBytes && Intrinsics.areEqual(this.localUri, brainstormAttachment.localUri) && this.isImage == brainstormAttachment.isImage && this.useImageUpload == brainstormAttachment.useImageUpload && this.state == brainstormAttachment.state && this.progress == brainstormAttachment.progress && Intrinsics.areEqual(this.uploadedRef, brainstormAttachment.uploadedRef) && Intrinsics.areEqual(this.errorMessage, brainstormAttachment.errorMessage) && this.notifiedToBot == brainstormAttachment.notifiedToBot && this.createdAtMs == brainstormAttachment.createdAtMs && Intrinsics.areEqual(this.groupId, brainstormAttachment.groupId);
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((this.attachmentId.hashCode() * 31) + this.displayName.hashCode()) * 31) + this.mimeType.hashCode()) * 31) + Long.hashCode(this.sizeBytes)) * 31) + this.localUri.hashCode()) * 31) + Boolean.hashCode(this.isImage)) * 31) + Boolean.hashCode(this.useImageUpload)) * 31) + this.state.hashCode()) * 31) + Integer.hashCode(this.progress)) * 31;
        String str = this.uploadedRef;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.errorMessage;
        int hashCode3 = (((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Boolean.hashCode(this.notifiedToBot)) * 31) + Long.hashCode(this.createdAtMs)) * 31;
        String str3 = this.groupId;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BrainstormAttachment(attachmentId=");
        sb.append(this.attachmentId).append(", displayName=").append(this.displayName).append(", mimeType=").append(this.mimeType).append(", sizeBytes=").append(this.sizeBytes).append(", localUri=").append(this.localUri).append(", isImage=").append(this.isImage).append(", useImageUpload=").append(this.useImageUpload).append(", state=").append(this.state).append(", progress=").append(this.progress).append(", uploadedRef=").append(this.uploadedRef).append(", errorMessage=").append(this.errorMessage).append(", notifiedToBot=");
        sb.append(this.notifiedToBot).append(", createdAtMs=").append(this.createdAtMs).append(", groupId=").append(this.groupId).append(')');
        return sb.toString();
    }

    public BrainstormAttachment(String attachmentId, String displayName, String mimeType, long j, String localUri, boolean z, boolean z2, AttachmentState state, int i, String str, String str2, boolean z3, long j2, String str3) {
        Intrinsics.checkNotNullParameter(attachmentId, "attachmentId");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics.checkNotNullParameter(localUri, "localUri");
        Intrinsics.checkNotNullParameter(state, "state");
        this.attachmentId = attachmentId;
        this.displayName = displayName;
        this.mimeType = mimeType;
        this.sizeBytes = j;
        this.localUri = localUri;
        this.isImage = z;
        this.useImageUpload = z2;
        this.state = state;
        this.progress = i;
        this.uploadedRef = str;
        this.errorMessage = str2;
        this.notifiedToBot = z3;
        this.createdAtMs = j2;
        this.groupId = str3;
    }

    public /* synthetic */ BrainstormAttachment(String str, String str2, String str3, long j, String str4, boolean z, boolean z2, AttachmentState attachmentState, int i, String str5, String str6, boolean z3, long j2, String str7, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, j, str4, z, z2, attachmentState, (i2 & 256) != 0 ? 0 : i, (i2 & 512) != 0 ? null : str5, (i2 & 1024) != 0 ? null : str6, (i2 & 2048) != 0 ? false : z3, (i2 & 4096) != 0 ? 0L : j2, (i2 & 8192) != 0 ? null : str7);
    }

    public final String getAttachmentId() {
        return this.attachmentId;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final long getSizeBytes() {
        return this.sizeBytes;
    }

    public final String getLocalUri() {
        return this.localUri;
    }

    public final boolean isImage() {
        return this.isImage;
    }

    public final boolean getUseImageUpload() {
        return this.useImageUpload;
    }

    public final AttachmentState getState() {
        return this.state;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final String getUploadedRef() {
        return this.uploadedRef;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final boolean getNotifiedToBot() {
        return this.notifiedToBot;
    }

    public final long getCreatedAtMs() {
        return this.createdAtMs;
    }

    public final String getGroupId() {
        return this.groupId;
    }
}
