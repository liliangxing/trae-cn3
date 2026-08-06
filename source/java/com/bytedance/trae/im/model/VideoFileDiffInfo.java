package com.bytedance.trae.im.model;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FinishCardResult.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/im/model/VideoFileDiffInfo;", "", "filePath", "Lcom/google/gson/JsonElement;", "fileAction", "videoInfo", "Lcom/bytedance/trae/im/model/VideoInfoData;", "<init>", "(Lcom/google/gson/JsonElement;Lcom/google/gson/JsonElement;Lcom/bytedance/trae/im/model/VideoInfoData;)V", "getFilePath", "()Lcom/google/gson/JsonElement;", "getFileAction", "getVideoInfo", "()Lcom/bytedance/trae/im/model/VideoInfoData;", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class VideoFileDiffInfo {

    @SerializedName("file_action")
    private final JsonElement fileAction;

    @SerializedName("file_path")
    private final JsonElement filePath;

    @SerializedName("video_info")
    private final VideoInfoData videoInfo;

    public VideoFileDiffInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ VideoFileDiffInfo copy$default(VideoFileDiffInfo videoFileDiffInfo, JsonElement jsonElement, JsonElement jsonElement2, VideoInfoData videoInfoData, int i, Object obj) {
        if ((i & 1) != 0) {
            jsonElement = videoFileDiffInfo.filePath;
        }
        if ((i & 2) != 0) {
            jsonElement2 = videoFileDiffInfo.fileAction;
        }
        if ((i & 4) != 0) {
            videoInfoData = videoFileDiffInfo.videoInfo;
        }
        return videoFileDiffInfo.copy(jsonElement, jsonElement2, videoInfoData);
    }

    /* renamed from: component1, reason: from getter */
    public final JsonElement getFilePath() {
        return this.filePath;
    }

    /* renamed from: component2, reason: from getter */
    public final JsonElement getFileAction() {
        return this.fileAction;
    }

    /* renamed from: component3, reason: from getter */
    public final VideoInfoData getVideoInfo() {
        return this.videoInfo;
    }

    public final VideoFileDiffInfo copy(JsonElement filePath, JsonElement fileAction, VideoInfoData videoInfo) {
        return new VideoFileDiffInfo(filePath, fileAction, videoInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoFileDiffInfo)) {
            return false;
        }
        VideoFileDiffInfo videoFileDiffInfo = (VideoFileDiffInfo) other;
        return Intrinsics.areEqual(this.filePath, videoFileDiffInfo.filePath) && Intrinsics.areEqual(this.fileAction, videoFileDiffInfo.fileAction) && Intrinsics.areEqual(this.videoInfo, videoFileDiffInfo.videoInfo);
    }

    public int hashCode() {
        JsonElement jsonElement = this.filePath;
        int hashCode = (jsonElement == null ? 0 : jsonElement.hashCode()) * 31;
        JsonElement jsonElement2 = this.fileAction;
        int hashCode2 = (hashCode + (jsonElement2 == null ? 0 : jsonElement2.hashCode())) * 31;
        VideoInfoData videoInfoData = this.videoInfo;
        return hashCode2 + (videoInfoData != null ? videoInfoData.hashCode() : 0);
    }

    public String toString() {
        return "VideoFileDiffInfo(filePath=" + this.filePath + ", fileAction=" + this.fileAction + ", videoInfo=" + this.videoInfo + ')';
    }

    public VideoFileDiffInfo(JsonElement jsonElement, JsonElement jsonElement2, VideoInfoData videoInfoData) {
        this.filePath = jsonElement;
        this.fileAction = jsonElement2;
        this.videoInfo = videoInfoData;
    }

    public /* synthetic */ VideoFileDiffInfo(JsonElement jsonElement, JsonElement jsonElement2, VideoInfoData videoInfoData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : jsonElement, (i & 2) != 0 ? null : jsonElement2, (i & 4) != 0 ? null : videoInfoData);
    }

    public final JsonElement getFilePath() {
        return this.filePath;
    }

    public final JsonElement getFileAction() {
        return this.fileAction;
    }

    public final VideoInfoData getVideoInfo() {
        return this.videoInfo;
    }
}
