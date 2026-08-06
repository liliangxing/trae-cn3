package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IChatSessionApi.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/im/service/ChatSessionSource;", "", "repoUrl", "", "ref", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRepoUrl", "()Ljava/lang/String;", "getRef", "getType", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ChatSessionSource {

    @SerializedName("ref")
    private final String ref;

    @SerializedName("repo_url")
    private final String repoUrl;

    @SerializedName("type")
    private final String type;

    public ChatSessionSource() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ChatSessionSource copy$default(ChatSessionSource chatSessionSource, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = chatSessionSource.repoUrl;
        }
        if ((i & 2) != 0) {
            str2 = chatSessionSource.ref;
        }
        if ((i & 4) != 0) {
            str3 = chatSessionSource.type;
        }
        return chatSessionSource.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRepoUrl() {
        return this.repoUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final String getRef() {
        return this.ref;
    }

    /* renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final ChatSessionSource copy(String repoUrl, String ref, String type) {
        return new ChatSessionSource(repoUrl, ref, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatSessionSource)) {
            return false;
        }
        ChatSessionSource chatSessionSource = (ChatSessionSource) other;
        return Intrinsics.areEqual(this.repoUrl, chatSessionSource.repoUrl) && Intrinsics.areEqual(this.ref, chatSessionSource.ref) && Intrinsics.areEqual(this.type, chatSessionSource.type);
    }

    public int hashCode() {
        String str = this.repoUrl;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.ref;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.type;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ChatSessionSource(repoUrl=" + this.repoUrl + ", ref=" + this.ref + ", type=" + this.type + ')';
    }

    public ChatSessionSource(String str, String str2, String str3) {
        this.repoUrl = str;
        this.ref = str2;
        this.type = str3;
    }

    public /* synthetic */ ChatSessionSource(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    public final String getRepoUrl() {
        return this.repoUrl;
    }

    public final String getRef() {
        return this.ref;
    }

    public final String getType() {
        return this.type;
    }
}
