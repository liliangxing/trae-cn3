package com.bytedance.trae.conversation.model;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QueryItem.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/model/ImageData;", "", "imageId", "", "chatSessionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getImageId", "()Ljava/lang/String;", "getChatSessionId", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ImageData {

    @SerializedName("chat_session_id")
    private final String chatSessionId;

    @SerializedName("image_id")
    private final String imageId;

    public static /* synthetic */ ImageData copy$default(ImageData imageData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = imageData.imageId;
        }
        if ((i & 2) != 0) {
            str2 = imageData.chatSessionId;
        }
        return imageData.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getImageId() {
        return this.imageId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getChatSessionId() {
        return this.chatSessionId;
    }

    public final ImageData copy(String imageId, String chatSessionId) {
        Intrinsics.checkNotNullParameter(imageId, "imageId");
        return new ImageData(imageId, chatSessionId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageData)) {
            return false;
        }
        ImageData imageData = (ImageData) other;
        return Intrinsics.areEqual(this.imageId, imageData.imageId) && Intrinsics.areEqual(this.chatSessionId, imageData.chatSessionId);
    }

    public int hashCode() {
        int hashCode = this.imageId.hashCode() * 31;
        String str = this.chatSessionId;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ImageData(imageId=" + this.imageId + ", chatSessionId=" + this.chatSessionId + ')';
    }

    public ImageData(String imageId, String str) {
        Intrinsics.checkNotNullParameter(imageId, "imageId");
        this.imageId = imageId;
        this.chatSessionId = str;
    }

    public /* synthetic */ ImageData(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }

    public final String getImageId() {
        return this.imageId;
    }

    public final String getChatSessionId() {
        return this.chatSessionId;
    }
}
