package com.bytedance.trae.conversation.fileupload;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceUploadUtil.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;", "", "crc32Hex", "", "sha256Hex", "sizeBytes", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getCrc32Hex", "()Ljava/lang/String;", "getSha256Hex", "getSizeBytes", "()J", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ContentChecksums {
    private final String crc32Hex;
    private final String sha256Hex;
    private final long sizeBytes;

    public static /* synthetic */ ContentChecksums copy$default(ContentChecksums contentChecksums, String str, String str2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = contentChecksums.crc32Hex;
        }
        if ((i & 2) != 0) {
            str2 = contentChecksums.sha256Hex;
        }
        if ((i & 4) != 0) {
            j = contentChecksums.sizeBytes;
        }
        return contentChecksums.copy(str, str2, j);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCrc32Hex() {
        return this.crc32Hex;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSha256Hex() {
        return this.sha256Hex;
    }

    /* renamed from: component3, reason: from getter */
    public final long getSizeBytes() {
        return this.sizeBytes;
    }

    public final ContentChecksums copy(String crc32Hex, String sha256Hex, long sizeBytes) {
        Intrinsics.checkNotNullParameter(crc32Hex, "crc32Hex");
        Intrinsics.checkNotNullParameter(sha256Hex, "sha256Hex");
        return new ContentChecksums(crc32Hex, sha256Hex, sizeBytes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContentChecksums)) {
            return false;
        }
        ContentChecksums contentChecksums = (ContentChecksums) other;
        return Intrinsics.areEqual(this.crc32Hex, contentChecksums.crc32Hex) && Intrinsics.areEqual(this.sha256Hex, contentChecksums.sha256Hex) && this.sizeBytes == contentChecksums.sizeBytes;
    }

    public int hashCode() {
        return (((this.crc32Hex.hashCode() * 31) + this.sha256Hex.hashCode()) * 31) + Long.hashCode(this.sizeBytes);
    }

    public String toString() {
        return "ContentChecksums(crc32Hex=" + this.crc32Hex + ", sha256Hex=" + this.sha256Hex + ", sizeBytes=" + this.sizeBytes + ')';
    }

    public ContentChecksums(String crc32Hex, String sha256Hex, long j) {
        Intrinsics.checkNotNullParameter(crc32Hex, "crc32Hex");
        Intrinsics.checkNotNullParameter(sha256Hex, "sha256Hex");
        this.crc32Hex = crc32Hex;
        this.sha256Hex = sha256Hex;
        this.sizeBytes = j;
    }

    public final String getCrc32Hex() {
        return this.crc32Hex;
    }

    public final String getSha256Hex() {
        return this.sha256Hex;
    }

    public final long getSizeBytes() {
        return this.sizeBytes;
    }
}
