package com.bytedance.trae.conversation.imageupload;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageUploadModels.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "code", "Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;", "message", "", "cause", "", "<init>", "(Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;Ljava/lang/String;Ljava/lang/Throwable;)V", "getCode", "()Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ImageUploadException extends RuntimeException {
    private final ImageUploadErrorCode code;

    public /* synthetic */ ImageUploadException(ImageUploadErrorCode imageUploadErrorCode, String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageUploadErrorCode, str, (i & 4) != 0 ? null : th);
    }

    public final ImageUploadErrorCode getCode() {
        return this.code;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageUploadException(ImageUploadErrorCode code, String message, Throwable th) {
        super(message, th);
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(message, "message");
        this.code = code;
    }
}
