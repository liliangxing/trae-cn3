package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICreateAgentTask.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/im/service/StandardChatMessagePart;", "", "type", "", "text", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getText", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class StandardChatMessagePart {

    @SerializedName("text")
    private final String text;

    @SerializedName("type")
    private final String type;

    public static /* synthetic */ StandardChatMessagePart copy$default(StandardChatMessagePart standardChatMessagePart, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = standardChatMessagePart.type;
        }
        if ((i & 2) != 0) {
            str2 = standardChatMessagePart.text;
        }
        return standardChatMessagePart.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final StandardChatMessagePart copy(String type, String text) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new StandardChatMessagePart(type, text);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StandardChatMessagePart)) {
            return false;
        }
        StandardChatMessagePart standardChatMessagePart = (StandardChatMessagePart) other;
        return Intrinsics.areEqual(this.type, standardChatMessagePart.type) && Intrinsics.areEqual(this.text, standardChatMessagePart.text);
    }

    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        String str = this.text;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "StandardChatMessagePart(type=" + this.type + ", text=" + this.text + ')';
    }

    public StandardChatMessagePart(String type, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.text = str;
    }

    public /* synthetic */ StandardChatMessagePart(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }

    public final String getType() {
        return this.type;
    }

    public final String getText() {
        return this.text;
    }
}
