package com.larus.business.markdown.api.extplugin.image;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageInfo.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/larus/business/markdown/api/extplugin/image/ImageInfo;", "", "imageUrl", "", "imageUri", "imageThumbUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getImageThumbUrl", "()Ljava/lang/String;", "getImageUri", "getImageUrl", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class ImageInfo {
    private final String imageThumbUrl;
    private final String imageUri;
    private final String imageUrl;

    public static /* synthetic */ ImageInfo copy$default(ImageInfo imageInfo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = imageInfo.imageUrl;
        }
        if ((i & 2) != 0) {
            str2 = imageInfo.imageUri;
        }
        if ((i & 4) != 0) {
            str3 = imageInfo.imageThumbUrl;
        }
        return imageInfo.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final String getImageUri() {
        return this.imageUri;
    }

    /* renamed from: component3, reason: from getter */
    public final String getImageThumbUrl() {
        return this.imageThumbUrl;
    }

    public final ImageInfo copy(String imageUrl, String imageUri, String imageThumbUrl) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        Intrinsics.checkNotNullParameter(imageThumbUrl, "imageThumbUrl");
        return new ImageInfo(imageUrl, imageUri, imageThumbUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageInfo)) {
            return false;
        }
        ImageInfo imageInfo = (ImageInfo) other;
        return Intrinsics.areEqual(this.imageUrl, imageInfo.imageUrl) && Intrinsics.areEqual(this.imageUri, imageInfo.imageUri) && Intrinsics.areEqual(this.imageThumbUrl, imageInfo.imageThumbUrl);
    }

    public int hashCode() {
        return (((this.imageUrl.hashCode() * 31) + this.imageUri.hashCode()) * 31) + this.imageThumbUrl.hashCode();
    }

    public String toString() {
        return "ImageInfo(imageUrl=" + this.imageUrl + ", imageUri=" + this.imageUri + ", imageThumbUrl=" + this.imageThumbUrl + ')';
    }

    public ImageInfo(String imageUrl, String imageUri, String imageThumbUrl) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        Intrinsics.checkNotNullParameter(imageThumbUrl, "imageThumbUrl");
        this.imageUrl = imageUrl;
        this.imageUri = imageUri;
        this.imageThumbUrl = imageThumbUrl;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getImageUri() {
        return this.imageUri;
    }

    public final String getImageThumbUrl() {
        return this.imageThumbUrl;
    }
}
