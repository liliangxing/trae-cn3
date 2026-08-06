package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.keva.KevaImpl;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArtifactModels.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J=\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÇ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0019\u001a\u00020\u001aH×\u0001J\t\u0010\u001b\u001a\u00020\u0003H×\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;", "", "agentRunId", "", "toolName", "resultStatus", KevaImpl.PrivateConstants.FILES_DIR_NAME, "", "Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAgentRunId", "()Ljava/lang/String;", "getToolName", "getResultStatus", "getFiles", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class VideoArtifactPlanItemInput {
    public static final int $stable = 8;
    private final String agentRunId;
    private final List<VideoArtifactFileInput> files;
    private final String resultStatus;
    private final String toolName;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VideoArtifactPlanItemInput copy$default(VideoArtifactPlanItemInput videoArtifactPlanItemInput, String str, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = videoArtifactPlanItemInput.agentRunId;
        }
        if ((i & 2) != 0) {
            str2 = videoArtifactPlanItemInput.toolName;
        }
        if ((i & 4) != 0) {
            str3 = videoArtifactPlanItemInput.resultStatus;
        }
        if ((i & 8) != 0) {
            list = videoArtifactPlanItemInput.files;
        }
        return videoArtifactPlanItemInput.copy(str, str2, str3, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAgentRunId() {
        return this.agentRunId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getResultStatus() {
        return this.resultStatus;
    }

    public final List<VideoArtifactFileInput> component4() {
        return this.files;
    }

    public final VideoArtifactPlanItemInput copy(String agentRunId, String toolName, String resultStatus, List<VideoArtifactFileInput> files) {
        Intrinsics.checkNotNullParameter(files, "files");
        return new VideoArtifactPlanItemInput(agentRunId, toolName, resultStatus, files);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoArtifactPlanItemInput)) {
            return false;
        }
        VideoArtifactPlanItemInput videoArtifactPlanItemInput = (VideoArtifactPlanItemInput) other;
        return Intrinsics.areEqual(this.agentRunId, videoArtifactPlanItemInput.agentRunId) && Intrinsics.areEqual(this.toolName, videoArtifactPlanItemInput.toolName) && Intrinsics.areEqual(this.resultStatus, videoArtifactPlanItemInput.resultStatus) && Intrinsics.areEqual(this.files, videoArtifactPlanItemInput.files);
    }

    public int hashCode() {
        String str = this.agentRunId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.toolName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.resultStatus;
        return ((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.files.hashCode();
    }

    public String toString() {
        return "VideoArtifactPlanItemInput(agentRunId=" + this.agentRunId + ", toolName=" + this.toolName + ", resultStatus=" + this.resultStatus + ", files=" + this.files + ')';
    }

    public VideoArtifactPlanItemInput(String str, String str2, String str3, List<VideoArtifactFileInput> files) {
        Intrinsics.checkNotNullParameter(files, "files");
        this.agentRunId = str;
        this.toolName = str2;
        this.resultStatus = str3;
        this.files = files;
    }

    public final String getAgentRunId() {
        return this.agentRunId;
    }

    public final String getToolName() {
        return this.toolName;
    }

    public final String getResultStatus() {
        return this.resultStatus;
    }

    public final List<VideoArtifactFileInput> getFiles() {
        return this.files;
    }
}
