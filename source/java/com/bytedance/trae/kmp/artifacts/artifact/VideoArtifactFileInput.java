package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArtifactModels.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÇ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0015\u001a\u00020\u0016H×\u0001J\t\u0010\u0017\u001a\u00020\u0003H×\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;", "", "filePath", "", "fileAction", "videoInfo", "Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactInfoInput;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactInfoInput;)V", "getFilePath", "()Ljava/lang/String;", "getFileAction", "getVideoInfo", "()Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactInfoInput;", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class VideoArtifactFileInput {
    public static final int $stable = 0;
    private final String fileAction;
    private final String filePath;
    private final VideoArtifactInfoInput videoInfo;

    public static /* synthetic */ VideoArtifactFileInput copy$default(VideoArtifactFileInput videoArtifactFileInput, String str, String str2, VideoArtifactInfoInput videoArtifactInfoInput, int i, Object obj) {
        if ((i & 1) != 0) {
            str = videoArtifactFileInput.filePath;
        }
        if ((i & 2) != 0) {
            str2 = videoArtifactFileInput.fileAction;
        }
        if ((i & 4) != 0) {
            videoArtifactInfoInput = videoArtifactFileInput.videoInfo;
        }
        return videoArtifactFileInput.copy(str, str2, videoArtifactInfoInput);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFileAction() {
        return this.fileAction;
    }

    /* renamed from: component3, reason: from getter */
    public final VideoArtifactInfoInput getVideoInfo() {
        return this.videoInfo;
    }

    public final VideoArtifactFileInput copy(String filePath, String fileAction, VideoArtifactInfoInput videoInfo) {
        return new VideoArtifactFileInput(filePath, fileAction, videoInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoArtifactFileInput)) {
            return false;
        }
        VideoArtifactFileInput videoArtifactFileInput = (VideoArtifactFileInput) other;
        return Intrinsics.areEqual(this.filePath, videoArtifactFileInput.filePath) && Intrinsics.areEqual(this.fileAction, videoArtifactFileInput.fileAction) && Intrinsics.areEqual(this.videoInfo, videoArtifactFileInput.videoInfo);
    }

    public int hashCode() {
        String str = this.filePath;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.fileAction;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        VideoArtifactInfoInput videoArtifactInfoInput = this.videoInfo;
        return hashCode2 + (videoArtifactInfoInput != null ? videoArtifactInfoInput.hashCode() : 0);
    }

    public String toString() {
        return "VideoArtifactFileInput(filePath=" + this.filePath + ", fileAction=" + this.fileAction + ", videoInfo=" + this.videoInfo + ')';
    }

    public VideoArtifactFileInput(String str, String str2, VideoArtifactInfoInput videoArtifactInfoInput) {
        this.filePath = str;
        this.fileAction = str2;
        this.videoInfo = videoArtifactInfoInput;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final String getFileAction() {
        return this.fileAction;
    }

    public final VideoArtifactInfoInput getVideoInfo() {
        return this.videoInfo;
    }
}
