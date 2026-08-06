package com.bytedance.trae.conversation.chat.block.renderer;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.im.model.FileDiffInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArtifactsRenderer.kt */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\"\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"com/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$render$TypedFile", "", "file", "Lcom/bytedance/trae/im/model/FileDiffInfo;", "type", "", "<init>", "(Lcom/bytedance/trae/im/model/FileDiffInfo;Ljava/lang/String;)V", "getFile", "()Lcom/bytedance/trae/im/model/FileDiffInfo;", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "(Lcom/bytedance/trae/im/model/FileDiffInfo;Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$render$TypedFile;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ArtifactsRenderer$render$TypedFile {
    private final FileDiffInfo file;
    private final String type;

    public static /* synthetic */ ArtifactsRenderer$render$TypedFile copy$default(ArtifactsRenderer$render$TypedFile artifactsRenderer$render$TypedFile, FileDiffInfo fileDiffInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            fileDiffInfo = artifactsRenderer$render$TypedFile.file;
        }
        if ((i & 2) != 0) {
            str = artifactsRenderer$render$TypedFile.type;
        }
        return artifactsRenderer$render$TypedFile.copy(fileDiffInfo, str);
    }

    /* renamed from: component1, reason: from getter */
    public final FileDiffInfo getFile() {
        return this.file;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final ArtifactsRenderer$render$TypedFile copy(FileDiffInfo file, String type) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(type, "type");
        return new ArtifactsRenderer$render$TypedFile(file, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArtifactsRenderer$render$TypedFile)) {
            return false;
        }
        ArtifactsRenderer$render$TypedFile artifactsRenderer$render$TypedFile = (ArtifactsRenderer$render$TypedFile) other;
        return Intrinsics.areEqual(this.file, artifactsRenderer$render$TypedFile.file) && Intrinsics.areEqual(this.type, artifactsRenderer$render$TypedFile.type);
    }

    public int hashCode() {
        return (this.file.hashCode() * 31) + this.type.hashCode();
    }

    public String toString() {
        return "TypedFile(file=" + this.file + ", type=" + this.type + ')';
    }

    public ArtifactsRenderer$render$TypedFile(FileDiffInfo file, String type) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(type, "type");
        this.file = file;
        this.type = type;
    }

    public final FileDiffInfo getFile() {
        return this.file;
    }

    public final String getType() {
        return this.type;
    }
}
