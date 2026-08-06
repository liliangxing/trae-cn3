package com.bytedance.trae.conversation.widget;

import android.net.Uri;
import com.bytedance.forest.model.PreloadConfig;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttachmentItem.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b%\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\fHÆ\u0003J\t\u0010,\u001a\u00020\u000eHÆ\u0003J\t\u0010-\u001a\u00020\u0010HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u007f\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u00101\u001a\u00020\f2\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0010HÖ\u0001J\t\u00104\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001eR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019¨\u00065"}, d2 = {"Lcom/bytedance/trae/conversation/widget/AttachmentItem;", "", "bucketId", "", "id", "fileName", "", "uri", "Landroid/net/Uri;", DBDefinition.MIME_TYPE, "sizeBytes", "isImage", "", "uploadStatus", "Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;", "uploadProgress", "", "uploadedOid", "uploadError", "<init>", "(JJLjava/lang/String;Landroid/net/Uri;Ljava/lang/String;JZLcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;ILjava/lang/String;Ljava/lang/String;)V", "getBucketId", "()J", "getId", "getFileName", "()Ljava/lang/String;", "getUri", "()Landroid/net/Uri;", "getMimeType", "getSizeBytes", "()Z", "getUploadStatus", "()Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;", "getUploadProgress", "()I", "getUploadedOid", "getUploadError", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AttachmentItem {
    private final long bucketId;
    private final String fileName;
    private final long id;
    private final boolean isImage;
    private final String mimeType;
    private final long sizeBytes;
    private final String uploadError;
    private final int uploadProgress;
    private final AttachmentUploadStatus uploadStatus;
    private final String uploadedOid;
    private final Uri uri;

    /* renamed from: component1, reason: from getter */
    public final long getBucketId() {
        return this.bucketId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getUploadedOid() {
        return this.uploadedOid;
    }

    /* renamed from: component11, reason: from getter */
    public final String getUploadError() {
        return this.uploadError;
    }

    /* renamed from: component2, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* renamed from: component4, reason: from getter */
    public final Uri getUri() {
        return this.uri;
    }

    /* renamed from: component5, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    /* renamed from: component6, reason: from getter */
    public final long getSizeBytes() {
        return this.sizeBytes;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsImage() {
        return this.isImage;
    }

    /* renamed from: component8, reason: from getter */
    public final AttachmentUploadStatus getUploadStatus() {
        return this.uploadStatus;
    }

    /* renamed from: component9, reason: from getter */
    public final int getUploadProgress() {
        return this.uploadProgress;
    }

    public final AttachmentItem copy(long bucketId, long id, String fileName, Uri uri, String mimeType, long sizeBytes, boolean isImage, AttachmentUploadStatus uploadStatus, int uploadProgress, String uploadedOid, String uploadError) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(uploadStatus, "uploadStatus");
        return new AttachmentItem(bucketId, id, fileName, uri, mimeType, sizeBytes, isImage, uploadStatus, uploadProgress, uploadedOid, uploadError);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttachmentItem)) {
            return false;
        }
        AttachmentItem attachmentItem = (AttachmentItem) other;
        return this.bucketId == attachmentItem.bucketId && this.id == attachmentItem.id && Intrinsics.areEqual(this.fileName, attachmentItem.fileName) && Intrinsics.areEqual(this.uri, attachmentItem.uri) && Intrinsics.areEqual(this.mimeType, attachmentItem.mimeType) && this.sizeBytes == attachmentItem.sizeBytes && this.isImage == attachmentItem.isImage && this.uploadStatus == attachmentItem.uploadStatus && this.uploadProgress == attachmentItem.uploadProgress && Intrinsics.areEqual(this.uploadedOid, attachmentItem.uploadedOid) && Intrinsics.areEqual(this.uploadError, attachmentItem.uploadError);
    }

    public int hashCode() {
        int hashCode = ((Long.hashCode(this.bucketId) * 31) + Long.hashCode(this.id)) * 31;
        String str = this.fileName;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.uri.hashCode()) * 31;
        String str2 = this.mimeType;
        int hashCode3 = (((((((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Long.hashCode(this.sizeBytes)) * 31) + Boolean.hashCode(this.isImage)) * 31) + this.uploadStatus.hashCode()) * 31) + Integer.hashCode(this.uploadProgress)) * 31;
        String str3 = this.uploadedOid;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.uploadError;
        return hashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AttachmentItem(bucketId=");
        sb.append(this.bucketId).append(", id=").append(this.id).append(", fileName=").append(this.fileName).append(", uri=").append(this.uri).append(", mimeType=").append(this.mimeType).append(", sizeBytes=").append(this.sizeBytes).append(", isImage=").append(this.isImage).append(", uploadStatus=").append(this.uploadStatus).append(", uploadProgress=").append(this.uploadProgress).append(", uploadedOid=").append(this.uploadedOid).append(", uploadError=").append(this.uploadError).append(')');
        return sb.toString();
    }

    public AttachmentItem(long j, long j2, String str, Uri uri, String str2, long j3, boolean z, AttachmentUploadStatus uploadStatus, int i, String str3, String str4) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(uploadStatus, "uploadStatus");
        this.bucketId = j;
        this.id = j2;
        this.fileName = str;
        this.uri = uri;
        this.mimeType = str2;
        this.sizeBytes = j3;
        this.isImage = z;
        this.uploadStatus = uploadStatus;
        this.uploadProgress = i;
        this.uploadedOid = str3;
        this.uploadError = str4;
    }

    public final long getBucketId() {
        return this.bucketId;
    }

    public final long getId() {
        return this.id;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final long getSizeBytes() {
        return this.sizeBytes;
    }

    public final boolean isImage() {
        return this.isImage;
    }

    public /* synthetic */ AttachmentItem(long j, long j2, String str, Uri uri, String str2, long j3, boolean z, AttachmentUploadStatus attachmentUploadStatus, int i, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i2 & 4) != 0 ? null : str, uri, str2, j3, z, (i2 & 128) != 0 ? AttachmentUploadStatus.Pending : attachmentUploadStatus, (i2 & 256) != 0 ? 0 : i, (i2 & 512) != 0 ? null : str3, (i2 & 1024) != 0 ? null : str4);
    }

    public final AttachmentUploadStatus getUploadStatus() {
        return this.uploadStatus;
    }

    public final int getUploadProgress() {
        return this.uploadProgress;
    }

    public final String getUploadedOid() {
        return this.uploadedOid;
    }

    public final String getUploadError() {
        return this.uploadError;
    }
}
