package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IListConversationsService.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006 "}, d2 = {"Lcom/bytedance/trae/im/service/ConversationSource;", "Ljava/io/Serializable;", "repoUrl", "", "repoName", "ref", "type", "localFolder", "remoteFolder", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRepoUrl", "()Ljava/lang/String;", "getRepoName", "getRef", "getType", "getLocalFolder", "getRemoteFolder", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ConversationSource implements Serializable {

    @SerializedName("local_folder")
    private final String localFolder;

    @SerializedName("ref")
    private final String ref;

    @SerializedName("remote_folder")
    private final String remoteFolder;

    @SerializedName("repo_name")
    private final String repoName;

    @SerializedName("repo_url")
    private final String repoUrl;

    @SerializedName("type")
    private final String type;

    public ConversationSource() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ ConversationSource copy$default(ConversationSource conversationSource, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = conversationSource.repoUrl;
        }
        if ((i & 2) != 0) {
            str2 = conversationSource.repoName;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = conversationSource.ref;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = conversationSource.type;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = conversationSource.localFolder;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = conversationSource.remoteFolder;
        }
        return conversationSource.copy(str, str7, str8, str9, str10, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRepoUrl() {
        return this.repoUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final String getRepoName() {
        return this.repoName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getRef() {
        return this.ref;
    }

    /* renamed from: component4, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component5, reason: from getter */
    public final String getLocalFolder() {
        return this.localFolder;
    }

    /* renamed from: component6, reason: from getter */
    public final String getRemoteFolder() {
        return this.remoteFolder;
    }

    public final ConversationSource copy(String repoUrl, String repoName, String ref, String type, String localFolder, String remoteFolder) {
        return new ConversationSource(repoUrl, repoName, ref, type, localFolder, remoteFolder);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationSource)) {
            return false;
        }
        ConversationSource conversationSource = (ConversationSource) other;
        return Intrinsics.areEqual(this.repoUrl, conversationSource.repoUrl) && Intrinsics.areEqual(this.repoName, conversationSource.repoName) && Intrinsics.areEqual(this.ref, conversationSource.ref) && Intrinsics.areEqual(this.type, conversationSource.type) && Intrinsics.areEqual(this.localFolder, conversationSource.localFolder) && Intrinsics.areEqual(this.remoteFolder, conversationSource.remoteFolder);
    }

    public int hashCode() {
        String str = this.repoUrl;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.repoName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.ref;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.type;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.localFolder;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.remoteFolder;
        return hashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "ConversationSource(repoUrl=" + this.repoUrl + ", repoName=" + this.repoName + ", ref=" + this.ref + ", type=" + this.type + ", localFolder=" + this.localFolder + ", remoteFolder=" + this.remoteFolder + ')';
    }

    public ConversationSource(String str, String str2, String str3, String str4, String str5, String str6) {
        this.repoUrl = str;
        this.repoName = str2;
        this.ref = str3;
        this.type = str4;
        this.localFolder = str5;
        this.remoteFolder = str6;
    }

    public /* synthetic */ ConversationSource(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6);
    }

    public final String getRepoUrl() {
        return this.repoUrl;
    }

    public final String getRepoName() {
        return this.repoName;
    }

    public final String getRef() {
        return this.ref;
    }

    public final String getType() {
        return this.type;
    }

    public final String getLocalFolder() {
        return this.localFolder;
    }

    public final String getRemoteFolder() {
        return this.remoteFolder;
    }
}
