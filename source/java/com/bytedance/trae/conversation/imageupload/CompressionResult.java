package com.bytedance.trae.conversation.imageupload;

import com.bytedance.forest.model.PreloadConfig;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageUploadModels.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/CompressionResult;", "", "file", "Ljava/io/File;", "width", "", "height", "originalSize", "", "compressedSize", "wasCompressed", "", "<init>", "(Ljava/io/File;IIJJZ)V", "getFile", "()Ljava/io/File;", "getWidth", "()I", "getHeight", "getOriginalSize", "()J", "getCompressedSize", "getWasCompressed", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CompressionResult {
    private final long compressedSize;
    private final File file;
    private final int height;
    private final long originalSize;
    private final boolean wasCompressed;
    private final int width;

    /* renamed from: component1, reason: from getter */
    public final File getFile() {
        return this.file;
    }

    /* renamed from: component2, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component3, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: component4, reason: from getter */
    public final long getOriginalSize() {
        return this.originalSize;
    }

    /* renamed from: component5, reason: from getter */
    public final long getCompressedSize() {
        return this.compressedSize;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getWasCompressed() {
        return this.wasCompressed;
    }

    public final CompressionResult copy(File file, int width, int height, long originalSize, long compressedSize, boolean wasCompressed) {
        Intrinsics.checkNotNullParameter(file, "file");
        return new CompressionResult(file, width, height, originalSize, compressedSize, wasCompressed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompressionResult)) {
            return false;
        }
        CompressionResult compressionResult = (CompressionResult) other;
        return Intrinsics.areEqual(this.file, compressionResult.file) && this.width == compressionResult.width && this.height == compressionResult.height && this.originalSize == compressionResult.originalSize && this.compressedSize == compressionResult.compressedSize && this.wasCompressed == compressionResult.wasCompressed;
    }

    public int hashCode() {
        return (((((((((this.file.hashCode() * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31) + Long.hashCode(this.originalSize)) * 31) + Long.hashCode(this.compressedSize)) * 31) + Boolean.hashCode(this.wasCompressed);
    }

    public String toString() {
        return "CompressionResult(file=" + this.file + ", width=" + this.width + ", height=" + this.height + ", originalSize=" + this.originalSize + ", compressedSize=" + this.compressedSize + ", wasCompressed=" + this.wasCompressed + ')';
    }

    public CompressionResult(File file, int i, int i2, long j, long j2, boolean z) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.file = file;
        this.width = i;
        this.height = i2;
        this.originalSize = j;
        this.compressedSize = j2;
        this.wasCompressed = z;
    }

    public final File getFile() {
        return this.file;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final long getOriginalSize() {
        return this.originalSize;
    }

    public final long getCompressedSize() {
        return this.compressedSize;
    }

    public final boolean getWasCompressed() {
        return this.wasCompressed;
    }
}
