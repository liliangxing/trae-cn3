package com.bytedance.trae.kmp.artifacts.video;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VideoArtifactPreviewViewModel.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState;", "", "Preparing", "Ready", "Failed", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Failed;", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Preparing;", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface VideoArtifactPreviewState {

    /* compiled from: VideoArtifactPreviewViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Preparing;", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Preparing implements VideoArtifactPreviewState {
        public static final int $stable = 0;
        public static final Preparing INSTANCE = new Preparing();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Preparing)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -856506416;
        }

        public String toString() {
            return "Preparing";
        }

        private Preparing() {
        }
    }

    /* compiled from: VideoArtifactPreviewViewModel.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\fHÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003JY\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\tHÇ\u0001J\u0013\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010%H×\u0003J\t\u0010&\u001a\u00020'H×\u0001J\t\u0010(\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0016R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016¨\u0006)"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState;", "localSource", "", "durationMs", "", "positionMs", "dragPositionMs", "isDragging", "", "isPlaying", "playbackSpeed", "", "showSpeedMenu", "<init>", "(Ljava/lang/String;JJJZZFZ)V", "getLocalSource", "()Ljava/lang/String;", "getDurationMs", "()J", "getPositionMs", "getDragPositionMs", "()Z", "getPlaybackSpeed", "()F", "getShowSpeedMenu", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Ready implements VideoArtifactPreviewState {
        public static final int $stable = 0;
        private final long dragPositionMs;
        private final long durationMs;
        private final boolean isDragging;
        private final boolean isPlaying;
        private final String localSource;
        private final float playbackSpeed;
        private final long positionMs;
        private final boolean showSpeedMenu;

        /* renamed from: component1, reason: from getter */
        public final String getLocalSource() {
            return this.localSource;
        }

        /* renamed from: component2, reason: from getter */
        public final long getDurationMs() {
            return this.durationMs;
        }

        /* renamed from: component3, reason: from getter */
        public final long getPositionMs() {
            return this.positionMs;
        }

        /* renamed from: component4, reason: from getter */
        public final long getDragPositionMs() {
            return this.dragPositionMs;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsDragging() {
            return this.isDragging;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsPlaying() {
            return this.isPlaying;
        }

        /* renamed from: component7, reason: from getter */
        public final float getPlaybackSpeed() {
            return this.playbackSpeed;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getShowSpeedMenu() {
            return this.showSpeedMenu;
        }

        public final Ready copy(String localSource, long durationMs, long positionMs, long dragPositionMs, boolean isDragging, boolean isPlaying, float playbackSpeed, boolean showSpeedMenu) {
            Intrinsics.checkNotNullParameter(localSource, "localSource");
            return new Ready(localSource, durationMs, positionMs, dragPositionMs, isDragging, isPlaying, playbackSpeed, showSpeedMenu);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Ready)) {
                return false;
            }
            Ready ready = (Ready) other;
            return Intrinsics.areEqual(this.localSource, ready.localSource) && this.durationMs == ready.durationMs && this.positionMs == ready.positionMs && this.dragPositionMs == ready.dragPositionMs && this.isDragging == ready.isDragging && this.isPlaying == ready.isPlaying && Float.compare(this.playbackSpeed, ready.playbackSpeed) == 0 && this.showSpeedMenu == ready.showSpeedMenu;
        }

        public int hashCode() {
            return (((((((((((((this.localSource.hashCode() * 31) + Long.hashCode(this.durationMs)) * 31) + Long.hashCode(this.positionMs)) * 31) + Long.hashCode(this.dragPositionMs)) * 31) + Boolean.hashCode(this.isDragging)) * 31) + Boolean.hashCode(this.isPlaying)) * 31) + Float.hashCode(this.playbackSpeed)) * 31) + Boolean.hashCode(this.showSpeedMenu);
        }

        public String toString() {
            return "Ready(localSource=" + this.localSource + ", durationMs=" + this.durationMs + ", positionMs=" + this.positionMs + ", dragPositionMs=" + this.dragPositionMs + ", isDragging=" + this.isDragging + ", isPlaying=" + this.isPlaying + ", playbackSpeed=" + this.playbackSpeed + ", showSpeedMenu=" + this.showSpeedMenu + ')';
        }

        public Ready(String localSource, long j, long j2, long j3, boolean z, boolean z2, float f, boolean z3) {
            Intrinsics.checkNotNullParameter(localSource, "localSource");
            this.localSource = localSource;
            this.durationMs = j;
            this.positionMs = j2;
            this.dragPositionMs = j3;
            this.isDragging = z;
            this.isPlaying = z2;
            this.playbackSpeed = f;
            this.showSpeedMenu = z3;
        }

        public /* synthetic */ Ready(String str, long j, long j2, long j3, boolean z, boolean z2, float f, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? 0L : j2, (i & 8) == 0 ? j3 : 0L, (i & 16) != 0 ? false : z, (i & 32) != 0 ? false : z2, (i & 64) != 0 ? 1.0f : f, (i & 128) == 0 ? z3 : false);
        }

        public final String getLocalSource() {
            return this.localSource;
        }

        public final long getDurationMs() {
            return this.durationMs;
        }

        public final long getPositionMs() {
            return this.positionMs;
        }

        public final long getDragPositionMs() {
            return this.dragPositionMs;
        }

        public final boolean isDragging() {
            return this.isDragging;
        }

        public final boolean isPlaying() {
            return this.isPlaying;
        }

        public final float getPlaybackSpeed() {
            return this.playbackSpeed;
        }

        public final boolean getShowSpeedMenu() {
            return this.showSpeedMenu;
        }
    }

    /* compiled from: VideoArtifactPreviewViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u0003H×\u0001J\t\u0010\u000f\u001a\u00020\u0010H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Failed;", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState;", "errorCode", "", "<init>", "(I)V", "getErrorCode", "()I", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "toString", "", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Failed implements VideoArtifactPreviewState {
        public static final int $stable = 0;
        private final int errorCode;

        public static /* synthetic */ Failed copy$default(Failed failed, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = failed.errorCode;
            }
            return failed.copy(i);
        }

        /* renamed from: component1, reason: from getter */
        public final int getErrorCode() {
            return this.errorCode;
        }

        public final Failed copy(int errorCode) {
            return new Failed(errorCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Failed) && this.errorCode == ((Failed) other).errorCode;
        }

        public int hashCode() {
            return Integer.hashCode(this.errorCode);
        }

        public String toString() {
            return "Failed(errorCode=" + this.errorCode + ')';
        }

        public Failed(int i) {
            this.errorCode = i;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }
    }
}
