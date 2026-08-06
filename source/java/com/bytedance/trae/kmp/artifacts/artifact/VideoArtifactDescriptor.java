package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ArtifactModels.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001f\u001a\u00020\u0007H×\u0001J\t\u0010 \u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\fR\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\f¨\u0006!"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;", "", "artifactId", "", "filePath", "lastFrameUri", "durationSeconds", "", "fileAction", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getArtifactId", "()Ljava/lang/String;", "getFilePath", "getLastFrameUri", "getDurationSeconds", "()I", "getFileAction", SchemaConstants.QUERY_KEY_TITLE, "getTitle", "formattedDuration", "getFormattedDuration", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class VideoArtifactDescriptor {
    public static final int $stable = 0;
    private final String artifactId;
    private final int durationSeconds;
    private final String fileAction;
    private final String filePath;
    private final String lastFrameUri;

    public static /* synthetic */ VideoArtifactDescriptor copy$default(VideoArtifactDescriptor videoArtifactDescriptor, String str, String str2, String str3, int i, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = videoArtifactDescriptor.artifactId;
        }
        if ((i2 & 2) != 0) {
            str2 = videoArtifactDescriptor.filePath;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = videoArtifactDescriptor.lastFrameUri;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            i = videoArtifactDescriptor.durationSeconds;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            str4 = videoArtifactDescriptor.fileAction;
        }
        return videoArtifactDescriptor.copy(str, str5, str6, i3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getArtifactId() {
        return this.artifactId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLastFrameUri() {
        return this.lastFrameUri;
    }

    /* renamed from: component4, reason: from getter */
    public final int getDurationSeconds() {
        return this.durationSeconds;
    }

    /* renamed from: component5, reason: from getter */
    public final String getFileAction() {
        return this.fileAction;
    }

    public final VideoArtifactDescriptor copy(String artifactId, String filePath, String lastFrameUri, int durationSeconds, String fileAction) {
        Intrinsics.checkNotNullParameter(artifactId, "artifactId");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return new VideoArtifactDescriptor(artifactId, filePath, lastFrameUri, durationSeconds, fileAction);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoArtifactDescriptor)) {
            return false;
        }
        VideoArtifactDescriptor videoArtifactDescriptor = (VideoArtifactDescriptor) other;
        return Intrinsics.areEqual(this.artifactId, videoArtifactDescriptor.artifactId) && Intrinsics.areEqual(this.filePath, videoArtifactDescriptor.filePath) && Intrinsics.areEqual(this.lastFrameUri, videoArtifactDescriptor.lastFrameUri) && this.durationSeconds == videoArtifactDescriptor.durationSeconds && Intrinsics.areEqual(this.fileAction, videoArtifactDescriptor.fileAction);
    }

    public int hashCode() {
        int hashCode = ((this.artifactId.hashCode() * 31) + this.filePath.hashCode()) * 31;
        String str = this.lastFrameUri;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.durationSeconds)) * 31;
        String str2 = this.fileAction;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "VideoArtifactDescriptor(artifactId=" + this.artifactId + ", filePath=" + this.filePath + ", lastFrameUri=" + this.lastFrameUri + ", durationSeconds=" + this.durationSeconds + ", fileAction=" + this.fileAction + ')';
    }

    public VideoArtifactDescriptor(String str, String str2, String str3, int i, String str4) {
        Intrinsics.checkNotNullParameter(str, "artifactId");
        Intrinsics.checkNotNullParameter(str2, "filePath");
        this.artifactId = str;
        this.filePath = str2;
        this.lastFrameUri = str3;
        this.durationSeconds = i;
        this.fileAction = str4;
    }

    public final String getArtifactId() {
        return this.artifactId;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final String getLastFrameUri() {
        return this.lastFrameUri;
    }

    public final int getDurationSeconds() {
        return this.durationSeconds;
    }

    public final String getFileAction() {
        return this.fileAction;
    }

    public final String getTitle() {
        String substringAfterLast$default = StringsKt.substringAfterLast$default(this.filePath, '/', (String) null, 2, (Object) null);
        if (StringsKt.isBlank(substringAfterLast$default)) {
            substringAfterLast$default = this.filePath;
        }
        return substringAfterLast$default;
    }

    public final String getFormattedDuration() {
        return ArtifactModelsKt.formatVideoDuration(this.durationSeconds);
    }
}
