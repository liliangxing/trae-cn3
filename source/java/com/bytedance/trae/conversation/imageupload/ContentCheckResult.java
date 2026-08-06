package com.bytedance.trae.conversation.imageupload;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageUploadModels.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/ContentCheckResult;", "", "code", "", "pass", "", "<init>", "(ILjava/lang/Boolean;)V", "getCode", "()I", "getPass", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(ILjava/lang/Boolean;)Lcom/bytedance/trae/conversation/imageupload/ContentCheckResult;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ContentCheckResult {
    private final int code;
    private final Boolean pass;

    public static /* synthetic */ ContentCheckResult copy$default(ContentCheckResult contentCheckResult, int i, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = contentCheckResult.code;
        }
        if ((i2 & 2) != 0) {
            bool = contentCheckResult.pass;
        }
        return contentCheckResult.copy(i, bool);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getPass() {
        return this.pass;
    }

    public final ContentCheckResult copy(int code, Boolean pass) {
        return new ContentCheckResult(code, pass);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContentCheckResult)) {
            return false;
        }
        ContentCheckResult contentCheckResult = (ContentCheckResult) other;
        return this.code == contentCheckResult.code && Intrinsics.areEqual(this.pass, contentCheckResult.pass);
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.code) * 31;
        Boolean bool = this.pass;
        return hashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "ContentCheckResult(code=" + this.code + ", pass=" + this.pass + ')';
    }

    public ContentCheckResult(int i, Boolean bool) {
        this.code = i;
        this.pass = bool;
    }

    public final int getCode() {
        return this.code;
    }

    public final Boolean getPass() {
        return this.pass;
    }
}
