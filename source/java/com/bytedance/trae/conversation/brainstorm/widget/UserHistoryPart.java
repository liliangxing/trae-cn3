package com.bytedance.trae.conversation.brainstorm.widget;

import com.bytedance.forest.model.PreloadConfig;
import com.optimize.statistics.FrescoMonitorConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoiceHistoryContentParser.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart;", "", "Text", "Attachment", "Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;", "Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Text;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface UserHistoryPart {

    /* compiled from: VoiceHistoryContentParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Text;", "Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart;", "content", "", "fromMultimodalJson", "", "<init>", "(Ljava/lang/String;Z)V", "getContent", "()Ljava/lang/String;", "getFromMultimodalJson", "()Z", "component1", "component2", "copy", "equals", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Text implements UserHistoryPart {
        private final String content;
        private final boolean fromMultimodalJson;

        public static /* synthetic */ Text copy$default(Text text, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = text.content;
            }
            if ((i & 2) != 0) {
                z = text.fromMultimodalJson;
            }
            return text.copy(str, z);
        }

        /* renamed from: component1, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getFromMultimodalJson() {
            return this.fromMultimodalJson;
        }

        public final Text copy(String content, boolean fromMultimodalJson) {
            Intrinsics.checkNotNullParameter(content, "content");
            return new Text(content, fromMultimodalJson);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Text)) {
                return false;
            }
            Text text = (Text) other;
            return Intrinsics.areEqual(this.content, text.content) && this.fromMultimodalJson == text.fromMultimodalJson;
        }

        public int hashCode() {
            return (this.content.hashCode() * 31) + Boolean.hashCode(this.fromMultimodalJson);
        }

        public String toString() {
            return "Text(content=" + this.content + ", fromMultimodalJson=" + this.fromMultimodalJson + ')';
        }

        public Text(String content, boolean z) {
            Intrinsics.checkNotNullParameter(content, "content");
            this.content = content;
            this.fromMultimodalJson = z;
        }

        public final String getContent() {
            return this.content;
        }

        public final boolean getFromMultimodalJson() {
            return this.fromMultimodalJson;
        }
    }

    /* compiled from: VoiceHistoryContentParser.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003JU\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006%"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;", "Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart;", "uri", "", "filename", "isImage", "", FrescoMonitorConst.FILE_SIZE, "", "previewImageId", "previewResourceUri", "previewChatSessionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUri", "()Ljava/lang/String;", "getFilename", "()Z", "getFile_size", "()J", "getPreviewImageId", "getPreviewResourceUri", "getPreviewChatSessionId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Attachment implements UserHistoryPart {
        private final long file_size;
        private final String filename;
        private final boolean isImage;
        private final String previewChatSessionId;
        private final String previewImageId;
        private final String previewResourceUri;
        private final String uri;

        /* renamed from: component1, reason: from getter */
        public final String getUri() {
            return this.uri;
        }

        /* renamed from: component2, reason: from getter */
        public final String getFilename() {
            return this.filename;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsImage() {
            return this.isImage;
        }

        /* renamed from: component4, reason: from getter */
        public final long getFile_size() {
            return this.file_size;
        }

        /* renamed from: component5, reason: from getter */
        public final String getPreviewImageId() {
            return this.previewImageId;
        }

        /* renamed from: component6, reason: from getter */
        public final String getPreviewResourceUri() {
            return this.previewResourceUri;
        }

        /* renamed from: component7, reason: from getter */
        public final String getPreviewChatSessionId() {
            return this.previewChatSessionId;
        }

        public final Attachment copy(String uri, String filename, boolean isImage, long file_size, String previewImageId, String previewResourceUri, String previewChatSessionId) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(filename, "filename");
            return new Attachment(uri, filename, isImage, file_size, previewImageId, previewResourceUri, previewChatSessionId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Attachment)) {
                return false;
            }
            Attachment attachment = (Attachment) other;
            return Intrinsics.areEqual(this.uri, attachment.uri) && Intrinsics.areEqual(this.filename, attachment.filename) && this.isImage == attachment.isImage && this.file_size == attachment.file_size && Intrinsics.areEqual(this.previewImageId, attachment.previewImageId) && Intrinsics.areEqual(this.previewResourceUri, attachment.previewResourceUri) && Intrinsics.areEqual(this.previewChatSessionId, attachment.previewChatSessionId);
        }

        public int hashCode() {
            int hashCode = ((((((this.uri.hashCode() * 31) + this.filename.hashCode()) * 31) + Boolean.hashCode(this.isImage)) * 31) + Long.hashCode(this.file_size)) * 31;
            String str = this.previewImageId;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.previewResourceUri;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.previewChatSessionId;
            return hashCode3 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "Attachment(uri=" + this.uri + ", filename=" + this.filename + ", isImage=" + this.isImage + ", file_size=" + this.file_size + ", previewImageId=" + this.previewImageId + ", previewResourceUri=" + this.previewResourceUri + ", previewChatSessionId=" + this.previewChatSessionId + ')';
        }

        public Attachment(String uri, String filename, boolean z, long j, String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(filename, "filename");
            this.uri = uri;
            this.filename = filename;
            this.isImage = z;
            this.file_size = j;
            this.previewImageId = str;
            this.previewResourceUri = str2;
            this.previewChatSessionId = str3;
        }

        public /* synthetic */ Attachment(String str, String str2, boolean z, long j, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, z, (i & 8) != 0 ? 0L : j, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5);
        }

        public final String getUri() {
            return this.uri;
        }

        public final String getFilename() {
            return this.filename;
        }

        public final boolean isImage() {
            return this.isImage;
        }

        public final long getFile_size() {
            return this.file_size;
        }

        public final String getPreviewImageId() {
            return this.previewImageId;
        }

        public final String getPreviewResourceUri() {
            return this.previewResourceUri;
        }

        public final String getPreviewChatSessionId() {
            return this.previewChatSessionId;
        }
    }
}
