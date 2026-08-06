package com.bytedance.trae.conversation.mediachoose.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MediaItem.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\fHÆ\u0003J\t\u0010*\u001a\u00020\fHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0010HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003J{\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0006\u0010/\u001a\u00020\fJ\u0013\u00100\u001a\u00020\u00102\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\fHÖ\u0001J\t\u00104\u001a\u00020\u0007HÖ\u0001J\u0016\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010!R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019¨\u0006:"}, d2 = {"Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;", "Landroid/os/Parcelable;", "id", "", "uri", "Landroid/net/Uri;", DBDefinition.MIME_TYPE, "", "durationMs", "bucketId", "bucketName", "width", "", "height", "sizeBytes", "isVideo", "", "fileName", "<init>", "(JLandroid/net/Uri;Ljava/lang/String;JJLjava/lang/String;IIJZLjava/lang/String;)V", "getId", "()J", "getUri", "()Landroid/net/Uri;", "getMimeType", "()Ljava/lang/String;", "getDurationMs", "getBucketId", "getBucketName", "getWidth", "()I", "getHeight", "getSizeBytes", "()Z", "getFileName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "describeContents", "equals", PreloadConfig.KEY_OTHER, "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", RouterConstants.QUERY_KEY_FLAGS, "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MediaItem implements Parcelable {
    public static final Parcelable.Creator<MediaItem> CREATOR = new Creator();
    private final long bucketId;
    private final String bucketName;
    private final long durationMs;
    private final String fileName;
    private final int height;
    private final long id;
    private final boolean isVideo;
    private final String mimeType;
    private final long sizeBytes;
    private final Uri uri;
    private final int width;

    /* compiled from: MediaItem.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<MediaItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MediaItem createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MediaItem(parcel.readLong(), (Uri) parcel.readParcelable(MediaItem.class.getClassLoader()), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MediaItem[] newArray(int i) {
            return new MediaItem[i];
        }
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsVideo() {
        return this.isVideo;
    }

    /* renamed from: component11, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* renamed from: component2, reason: from getter */
    public final Uri getUri() {
        return this.uri;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    /* renamed from: component4, reason: from getter */
    public final long getDurationMs() {
        return this.durationMs;
    }

    /* renamed from: component5, reason: from getter */
    public final long getBucketId() {
        return this.bucketId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getBucketName() {
        return this.bucketName;
    }

    /* renamed from: component7, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component8, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: component9, reason: from getter */
    public final long getSizeBytes() {
        return this.sizeBytes;
    }

    public final MediaItem copy(long id, Uri uri, String mimeType, long durationMs, long bucketId, String bucketName, int width, int height, long sizeBytes, boolean isVideo, String fileName) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(bucketName, "bucketName");
        return new MediaItem(id, uri, mimeType, durationMs, bucketId, bucketName, width, height, sizeBytes, isVideo, fileName);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaItem)) {
            return false;
        }
        MediaItem mediaItem = (MediaItem) other;
        return this.id == mediaItem.id && Intrinsics.areEqual(this.uri, mediaItem.uri) && Intrinsics.areEqual(this.mimeType, mediaItem.mimeType) && this.durationMs == mediaItem.durationMs && this.bucketId == mediaItem.bucketId && Intrinsics.areEqual(this.bucketName, mediaItem.bucketName) && this.width == mediaItem.width && this.height == mediaItem.height && this.sizeBytes == mediaItem.sizeBytes && this.isVideo == mediaItem.isVideo && Intrinsics.areEqual(this.fileName, mediaItem.fileName);
    }

    public int hashCode() {
        int hashCode = ((Long.hashCode(this.id) * 31) + this.uri.hashCode()) * 31;
        String str = this.mimeType;
        int hashCode2 = (((((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.durationMs)) * 31) + Long.hashCode(this.bucketId)) * 31) + this.bucketName.hashCode()) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31) + Long.hashCode(this.sizeBytes)) * 31) + Boolean.hashCode(this.isVideo)) * 31;
        String str2 = this.fileName;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MediaItem(id=");
        sb.append(this.id).append(", uri=").append(this.uri).append(", mimeType=").append(this.mimeType).append(", durationMs=").append(this.durationMs).append(", bucketId=").append(this.bucketId).append(", bucketName=").append(this.bucketName).append(", width=").append(this.width).append(", height=").append(this.height).append(", sizeBytes=").append(this.sizeBytes).append(", isVideo=").append(this.isVideo).append(", fileName=").append(this.fileName).append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeLong(this.id);
        dest.writeParcelable(this.uri, flags);
        dest.writeString(this.mimeType);
        dest.writeLong(this.durationMs);
        dest.writeLong(this.bucketId);
        dest.writeString(this.bucketName);
        dest.writeInt(this.width);
        dest.writeInt(this.height);
        dest.writeLong(this.sizeBytes);
        dest.writeInt(this.isVideo ? 1 : 0);
        dest.writeString(this.fileName);
    }

    public MediaItem(long j, Uri uri, String str, long j2, long j3, String bucketName, int i, int i2, long j4, boolean z, String str2) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(bucketName, "bucketName");
        this.id = j;
        this.uri = uri;
        this.mimeType = str;
        this.durationMs = j2;
        this.bucketId = j3;
        this.bucketName = bucketName;
        this.width = i;
        this.height = i2;
        this.sizeBytes = j4;
        this.isVideo = z;
        this.fileName = str2;
    }

    public final long getId() {
        return this.id;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final long getDurationMs() {
        return this.durationMs;
    }

    public final long getBucketId() {
        return this.bucketId;
    }

    public final String getBucketName() {
        return this.bucketName;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final long getSizeBytes() {
        return this.sizeBytes;
    }

    public final boolean isVideo() {
        return this.isVideo;
    }

    public final String getFileName() {
        return this.fileName;
    }
}
