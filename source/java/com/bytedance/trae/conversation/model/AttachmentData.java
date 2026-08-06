package com.bytedance.trae.conversation.model;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import com.optimize.statistics.FrescoMonitorConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QueryItem.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/conversation/model/AttachmentData;", "", "uri", "", "filename", FrescoMonitorConst.FILE_SIZE, "", "chatSessionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getUri", "()Ljava/lang/String;", "getFilename", "getFile_size", "()J", "getChatSessionId", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AttachmentData {

    @SerializedName("chat_session_id")
    private final String chatSessionId;

    @SerializedName(FrescoMonitorConst.FILE_SIZE)
    private final long file_size;

    @SerializedName("filename")
    private final String filename;

    @SerializedName("uri")
    private final String uri;

    public static /* synthetic */ AttachmentData copy$default(AttachmentData attachmentData, String str, String str2, long j, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = attachmentData.uri;
        }
        if ((i & 2) != 0) {
            str2 = attachmentData.filename;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            j = attachmentData.file_size;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            str3 = attachmentData.chatSessionId;
        }
        return attachmentData.copy(str, str4, j2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUri() {
        return this.uri;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFilename() {
        return this.filename;
    }

    /* renamed from: component3, reason: from getter */
    public final long getFile_size() {
        return this.file_size;
    }

    /* renamed from: component4, reason: from getter */
    public final String getChatSessionId() {
        return this.chatSessionId;
    }

    public final AttachmentData copy(String uri, String filename, long file_size, String chatSessionId) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(filename, "filename");
        return new AttachmentData(uri, filename, file_size, chatSessionId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttachmentData)) {
            return false;
        }
        AttachmentData attachmentData = (AttachmentData) other;
        return Intrinsics.areEqual(this.uri, attachmentData.uri) && Intrinsics.areEqual(this.filename, attachmentData.filename) && this.file_size == attachmentData.file_size && Intrinsics.areEqual(this.chatSessionId, attachmentData.chatSessionId);
    }

    public int hashCode() {
        int hashCode = ((((this.uri.hashCode() * 31) + this.filename.hashCode()) * 31) + Long.hashCode(this.file_size)) * 31;
        String str = this.chatSessionId;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "AttachmentData(uri=" + this.uri + ", filename=" + this.filename + ", file_size=" + this.file_size + ", chatSessionId=" + this.chatSessionId + ')';
    }

    public AttachmentData(String uri, String filename, long j, String str) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(filename, "filename");
        this.uri = uri;
        this.filename = filename;
        this.file_size = j;
        this.chatSessionId = str;
    }

    public /* synthetic */ AttachmentData(String str, String str2, long j, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? 0L : j, (i & 8) != 0 ? null : str3);
    }

    public final String getUri() {
        return this.uri;
    }

    public final String getFilename() {
        return this.filename;
    }

    public final long getFile_size() {
        return this.file_size;
    }

    public final String getChatSessionId() {
        return this.chatSessionId;
    }
}
