package com.bytedance.trae.conversation.imageupload;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageUploadModels.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/ImageUploadResult;", "", "cdnUrl", "", "tosUri", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getCdnUrl", "()Ljava/lang/String;", "getTosUri", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ImageUploadResult {
    private final String cdnUrl;
    private final String tosUri;

    public static /* synthetic */ ImageUploadResult copy$default(ImageUploadResult imageUploadResult, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = imageUploadResult.cdnUrl;
        }
        if ((i & 2) != 0) {
            str2 = imageUploadResult.tosUri;
        }
        return imageUploadResult.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCdnUrl() {
        return this.cdnUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTosUri() {
        return this.tosUri;
    }

    public final ImageUploadResult copy(String cdnUrl, String tosUri) {
        Intrinsics.checkNotNullParameter(cdnUrl, "cdnUrl");
        Intrinsics.checkNotNullParameter(tosUri, "tosUri");
        return new ImageUploadResult(cdnUrl, tosUri);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageUploadResult)) {
            return false;
        }
        ImageUploadResult imageUploadResult = (ImageUploadResult) other;
        return Intrinsics.areEqual(this.cdnUrl, imageUploadResult.cdnUrl) && Intrinsics.areEqual(this.tosUri, imageUploadResult.tosUri);
    }

    public int hashCode() {
        return (this.cdnUrl.hashCode() * 31) + this.tosUri.hashCode();
    }

    public String toString() {
        return "ImageUploadResult(cdnUrl=" + this.cdnUrl + ", tosUri=" + this.tosUri + ')';
    }

    public ImageUploadResult(String cdnUrl, String tosUri) {
        Intrinsics.checkNotNullParameter(cdnUrl, "cdnUrl");
        Intrinsics.checkNotNullParameter(tosUri, "tosUri");
        this.cdnUrl = cdnUrl;
        this.tosUri = tosUri;
    }

    public final String getCdnUrl() {
        return this.cdnUrl;
    }

    public final String getTosUri() {
        return this.tosUri;
    }
}
