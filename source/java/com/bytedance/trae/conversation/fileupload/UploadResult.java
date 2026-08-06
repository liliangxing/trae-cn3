package com.bytedance.trae.conversation.fileupload;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceUploadModels.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0013JF\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/bytedance/trae/conversation/fileupload/UploadResult;", "", "oid", "", "success", "", "error", "checksum", "fileSize", "", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getOid", "()Ljava/lang/String;", "getSuccess", "()Z", "getError", "getChecksum", "getFileSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/bytedance/trae/conversation/fileupload/UploadResult;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UploadResult {
    private final String checksum;
    private final String error;
    private final Long fileSize;
    private final String oid;
    private final boolean success;

    public static /* synthetic */ UploadResult copy$default(UploadResult uploadResult, String str, boolean z, String str2, String str3, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = uploadResult.oid;
        }
        if ((i & 2) != 0) {
            z = uploadResult.success;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            str2 = uploadResult.error;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            str3 = uploadResult.checksum;
        }
        String str5 = str3;
        if ((i & 16) != 0) {
            l = uploadResult.fileSize;
        }
        return uploadResult.copy(str, z2, str4, str5, l);
    }

    /* renamed from: component1, reason: from getter */
    public final String getOid() {
        return this.oid;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component3, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* renamed from: component4, reason: from getter */
    public final String getChecksum() {
        return this.checksum;
    }

    /* renamed from: component5, reason: from getter */
    public final Long getFileSize() {
        return this.fileSize;
    }

    public final UploadResult copy(String oid, boolean success, String error, String checksum, Long fileSize) {
        Intrinsics.checkNotNullParameter(oid, "oid");
        return new UploadResult(oid, success, error, checksum, fileSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadResult)) {
            return false;
        }
        UploadResult uploadResult = (UploadResult) other;
        return Intrinsics.areEqual(this.oid, uploadResult.oid) && this.success == uploadResult.success && Intrinsics.areEqual(this.error, uploadResult.error) && Intrinsics.areEqual(this.checksum, uploadResult.checksum) && Intrinsics.areEqual(this.fileSize, uploadResult.fileSize);
    }

    public int hashCode() {
        int hashCode = ((this.oid.hashCode() * 31) + Boolean.hashCode(this.success)) * 31;
        String str = this.error;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.checksum;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.fileSize;
        return hashCode3 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "UploadResult(oid=" + this.oid + ", success=" + this.success + ", error=" + this.error + ", checksum=" + this.checksum + ", fileSize=" + this.fileSize + ')';
    }

    public UploadResult(String oid, boolean z, String str, String str2, Long l) {
        Intrinsics.checkNotNullParameter(oid, "oid");
        this.oid = oid;
        this.success = z;
        this.error = str;
        this.checksum = str2;
        this.fileSize = l;
    }

    public /* synthetic */ UploadResult(String str, boolean z, String str2, String str3, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : l);
    }

    public final String getOid() {
        return this.oid;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final String getError() {
        return this.error;
    }

    public final String getChecksum() {
        return this.checksum;
    }

    public final Long getFileSize() {
        return this.fileSize;
    }
}
