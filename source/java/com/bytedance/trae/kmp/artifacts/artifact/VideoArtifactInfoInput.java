package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArtifactModels.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÇ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0014\u001a\u00020\u0005H×\u0001J\t\u0010\u0015\u001a\u00020\u0003H×\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactInfoInput;", "", "lastFrameUri", "", "durationSeconds", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getLastFrameUri", "()Ljava/lang/String;", "getDurationSeconds", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactInfoInput;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class VideoArtifactInfoInput {
    public static final int $stable = 0;
    private final Integer durationSeconds;
    private final String lastFrameUri;

    public static /* synthetic */ VideoArtifactInfoInput copy$default(VideoArtifactInfoInput videoArtifactInfoInput, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = videoArtifactInfoInput.lastFrameUri;
        }
        if ((i & 2) != 0) {
            num = videoArtifactInfoInput.durationSeconds;
        }
        return videoArtifactInfoInput.copy(str, num);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLastFrameUri() {
        return this.lastFrameUri;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getDurationSeconds() {
        return this.durationSeconds;
    }

    public final VideoArtifactInfoInput copy(String lastFrameUri, Integer durationSeconds) {
        return new VideoArtifactInfoInput(lastFrameUri, durationSeconds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoArtifactInfoInput)) {
            return false;
        }
        VideoArtifactInfoInput videoArtifactInfoInput = (VideoArtifactInfoInput) other;
        return Intrinsics.areEqual(this.lastFrameUri, videoArtifactInfoInput.lastFrameUri) && Intrinsics.areEqual(this.durationSeconds, videoArtifactInfoInput.durationSeconds);
    }

    public int hashCode() {
        String str = this.lastFrameUri;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.durationSeconds;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "VideoArtifactInfoInput(lastFrameUri=" + this.lastFrameUri + ", durationSeconds=" + this.durationSeconds + ')';
    }

    public VideoArtifactInfoInput(String str, Integer num) {
        this.lastFrameUri = str;
        this.durationSeconds = num;
    }

    public final String getLastFrameUri() {
        return this.lastFrameUri;
    }

    public final Integer getDurationSeconds() {
        return this.durationSeconds;
    }
}
