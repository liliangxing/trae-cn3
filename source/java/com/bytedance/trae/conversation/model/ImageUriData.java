package com.bytedance.trae.conversation.model;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import com.optimize.statistics.FrescoMonitorConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QueryItem.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/conversation/model/ImageUriData;", "", "uri", "", "filename", FrescoMonitorConst.FILE_SIZE, "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getUri", "()Ljava/lang/String;", "getFilename", "getFile_size", "()J", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ImageUriData {

    @SerializedName(FrescoMonitorConst.FILE_SIZE)
    private final long file_size;

    @SerializedName("filename")
    private final String filename;

    @SerializedName("uri")
    private final String uri;

    public static /* synthetic */ ImageUriData copy$default(ImageUriData imageUriData, String str, String str2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = imageUriData.uri;
        }
        if ((i & 2) != 0) {
            str2 = imageUriData.filename;
        }
        if ((i & 4) != 0) {
            j = imageUriData.file_size;
        }
        return imageUriData.copy(str, str2, j);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUri() {
        return this.uri;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFilename() {
        return this.filename;
    }

    /* renamed from: component3, reason: from getter */
    public final long getFile_size() {
        return this.file_size;
    }

    public final ImageUriData copy(String uri, String filename, long file_size) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(filename, "filename");
        return new ImageUriData(uri, filename, file_size);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageUriData)) {
            return false;
        }
        ImageUriData imageUriData = (ImageUriData) other;
        return Intrinsics.areEqual(this.uri, imageUriData.uri) && Intrinsics.areEqual(this.filename, imageUriData.filename) && this.file_size == imageUriData.file_size;
    }

    public int hashCode() {
        return (((this.uri.hashCode() * 31) + this.filename.hashCode()) * 31) + Long.hashCode(this.file_size);
    }

    public String toString() {
        return "ImageUriData(uri=" + this.uri + ", filename=" + this.filename + ", file_size=" + this.file_size + ')';
    }

    public ImageUriData(String uri, String filename, long j) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(filename, "filename");
        this.uri = uri;
        this.filename = filename;
        this.file_size = j;
    }

    public /* synthetic */ ImageUriData(String str, String str2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? 0L : j);
    }

    public final String getUri() {
        return this.uri;
    }

    public final String getFilename() {
        return this.filename;
    }

    public final long getFile_size() {
        return this.file_size;
    }
}
