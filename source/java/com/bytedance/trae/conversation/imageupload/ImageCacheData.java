package com.bytedance.trae.conversation.imageupload;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageUploadModels.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/ImageCacheData;", "", "base64", "", "cdnUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getBase64", "()Ljava/lang/String;", "getCdnUrl", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ImageCacheData {
    private final String base64;
    private final String cdnUrl;

    public static /* synthetic */ ImageCacheData copy$default(ImageCacheData imageCacheData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = imageCacheData.base64;
        }
        if ((i & 2) != 0) {
            str2 = imageCacheData.cdnUrl;
        }
        return imageCacheData.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getBase64() {
        return this.base64;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCdnUrl() {
        return this.cdnUrl;
    }

    public final ImageCacheData copy(String base64, String cdnUrl) {
        Intrinsics.checkNotNullParameter(base64, "base64");
        Intrinsics.checkNotNullParameter(cdnUrl, "cdnUrl");
        return new ImageCacheData(base64, cdnUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageCacheData)) {
            return false;
        }
        ImageCacheData imageCacheData = (ImageCacheData) other;
        return Intrinsics.areEqual(this.base64, imageCacheData.base64) && Intrinsics.areEqual(this.cdnUrl, imageCacheData.cdnUrl);
    }

    public int hashCode() {
        return (this.base64.hashCode() * 31) + this.cdnUrl.hashCode();
    }

    public String toString() {
        return "ImageCacheData(base64=" + this.base64 + ", cdnUrl=" + this.cdnUrl + ')';
    }

    public ImageCacheData(String base64, String cdnUrl) {
        Intrinsics.checkNotNullParameter(base64, "base64");
        Intrinsics.checkNotNullParameter(cdnUrl, "cdnUrl");
        this.base64 = base64;
        this.cdnUrl = cdnUrl;
    }

    public final String getBase64() {
        return this.base64;
    }

    public final String getCdnUrl() {
        return this.cdnUrl;
    }
}
