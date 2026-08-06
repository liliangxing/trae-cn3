package com.bytedance.trae.conversation.imageupload;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageUploadModels.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;", "", "valid", "", "errorMessage", "", "errorCode", "Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;", "<init>", "(ZLjava/lang/String;Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;)V", "getValid", "()Z", "getErrorMessage", "()Ljava/lang/String;", "getErrorCode", "()Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;", "component1", "component2", "component3", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FileValidationResult {
    private final ImageUploadErrorCode errorCode;
    private final String errorMessage;
    private final boolean valid;

    public static /* synthetic */ FileValidationResult copy$default(FileValidationResult fileValidationResult, boolean z, String str, ImageUploadErrorCode imageUploadErrorCode, int i, Object obj) {
        if ((i & 1) != 0) {
            z = fileValidationResult.valid;
        }
        if ((i & 2) != 0) {
            str = fileValidationResult.errorMessage;
        }
        if ((i & 4) != 0) {
            imageUploadErrorCode = fileValidationResult.errorCode;
        }
        return fileValidationResult.copy(z, str, imageUploadErrorCode);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getValid() {
        return this.valid;
    }

    /* renamed from: component2, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* renamed from: component3, reason: from getter */
    public final ImageUploadErrorCode getErrorCode() {
        return this.errorCode;
    }

    public final FileValidationResult copy(boolean valid, String errorMessage, ImageUploadErrorCode errorCode) {
        return new FileValidationResult(valid, errorMessage, errorCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileValidationResult)) {
            return false;
        }
        FileValidationResult fileValidationResult = (FileValidationResult) other;
        return this.valid == fileValidationResult.valid && Intrinsics.areEqual(this.errorMessage, fileValidationResult.errorMessage) && this.errorCode == fileValidationResult.errorCode;
    }

    public int hashCode() {
        int hashCode = Boolean.hashCode(this.valid) * 31;
        String str = this.errorMessage;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        ImageUploadErrorCode imageUploadErrorCode = this.errorCode;
        return hashCode2 + (imageUploadErrorCode != null ? imageUploadErrorCode.hashCode() : 0);
    }

    public String toString() {
        return "FileValidationResult(valid=" + this.valid + ", errorMessage=" + this.errorMessage + ", errorCode=" + this.errorCode + ')';
    }

    public FileValidationResult(boolean z, String str, ImageUploadErrorCode imageUploadErrorCode) {
        this.valid = z;
        this.errorMessage = str;
        this.errorCode = imageUploadErrorCode;
    }

    public /* synthetic */ FileValidationResult(boolean z, String str, ImageUploadErrorCode imageUploadErrorCode, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : imageUploadErrorCode);
    }

    public final boolean getValid() {
        return this.valid;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final ImageUploadErrorCode getErrorCode() {
        return this.errorCode;
    }
}
