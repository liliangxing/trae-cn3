package com.bytedance.trae.conversation.fileupload;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;

/* compiled from: ResourceUploadUtil.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/fileupload/V2MagicMatch;", "", "payloadOffset", "", "<init>", "(I)V", "getPayloadOffset", "()I", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
final /* data */ class V2MagicMatch {
    private final int payloadOffset;

    public static /* synthetic */ V2MagicMatch copy$default(V2MagicMatch v2MagicMatch, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = v2MagicMatch.payloadOffset;
        }
        return v2MagicMatch.copy(i);
    }

    /* renamed from: component1, reason: from getter */
    public final int getPayloadOffset() {
        return this.payloadOffset;
    }

    public final V2MagicMatch copy(int payloadOffset) {
        return new V2MagicMatch(payloadOffset);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof V2MagicMatch) && this.payloadOffset == ((V2MagicMatch) other).payloadOffset;
    }

    public int hashCode() {
        return Integer.hashCode(this.payloadOffset);
    }

    public String toString() {
        return "V2MagicMatch(payloadOffset=" + this.payloadOffset + ')';
    }

    public V2MagicMatch(int i) {
        this.payloadOffset = i;
    }

    public final int getPayloadOffset() {
        return this.payloadOffset;
    }
}
