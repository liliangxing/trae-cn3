package com.bytedance.trae.kmp.artifacts.video;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;

/* compiled from: VideoArtifactPreviewViewModel.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0007\u0002\u0003\u0004\u0005\u0006\u0007\b\u0082\u0001\u0007\t\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction;", "", "Reload", "TogglePlayback", "OpenSpeedMenu", "DismissSpeedMenu", "DragTo", "SeekTo", "SelectSpeed", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DismissSpeedMenu;", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DragTo;", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$OpenSpeedMenu;", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$Reload;", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SeekTo;", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SelectSpeed;", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$TogglePlayback;", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface VideoArtifactPreviewAction {

    /* compiled from: VideoArtifactPreviewViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$Reload;", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Reload implements VideoArtifactPreviewAction {
        public static final int $stable = 0;
        public static final Reload INSTANCE = new Reload();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Reload)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1796456518;
        }

        public String toString() {
            return "Reload";
        }

        private Reload() {
        }
    }

    /* compiled from: VideoArtifactPreviewViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$TogglePlayback;", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class TogglePlayback implements VideoArtifactPreviewAction {
        public static final int $stable = 0;
        public static final TogglePlayback INSTANCE = new TogglePlayback();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TogglePlayback)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1215983280;
        }

        public String toString() {
            return "TogglePlayback";
        }

        private TogglePlayback() {
        }
    }

    /* compiled from: VideoArtifactPreviewViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$OpenSpeedMenu;", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class OpenSpeedMenu implements VideoArtifactPreviewAction {
        public static final int $stable = 0;
        public static final OpenSpeedMenu INSTANCE = new OpenSpeedMenu();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OpenSpeedMenu)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 57460187;
        }

        public String toString() {
            return "OpenSpeedMenu";
        }

        private OpenSpeedMenu() {
        }
    }

    /* compiled from: VideoArtifactPreviewViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DismissSpeedMenu;", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class DismissSpeedMenu implements VideoArtifactPreviewAction {
        public static final int $stable = 0;
        public static final DismissSpeedMenu INSTANCE = new DismissSpeedMenu();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DismissSpeedMenu)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -16056387;
        }

        public String toString() {
            return "DismissSpeedMenu";
        }

        private DismissSpeedMenu() {
        }
    }

    /* compiled from: VideoArtifactPreviewViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0011H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DragTo;", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction;", "positionMs", "", "<init>", "(J)V", "getPositionMs", "()J", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class DragTo implements VideoArtifactPreviewAction {
        public static final int $stable = 0;
        private final long positionMs;

        public static /* synthetic */ DragTo copy$default(DragTo dragTo, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = dragTo.positionMs;
            }
            return dragTo.copy(j);
        }

        /* renamed from: component1, reason: from getter */
        public final long getPositionMs() {
            return this.positionMs;
        }

        public final DragTo copy(long positionMs) {
            return new DragTo(positionMs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DragTo) && this.positionMs == ((DragTo) other).positionMs;
        }

        public int hashCode() {
            return Long.hashCode(this.positionMs);
        }

        public String toString() {
            return "DragTo(positionMs=" + this.positionMs + ')';
        }

        public DragTo(long j) {
            this.positionMs = j;
        }

        public final long getPositionMs() {
            return this.positionMs;
        }
    }

    /* compiled from: VideoArtifactPreviewViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0011H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SeekTo;", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction;", "positionMs", "", "<init>", "(J)V", "getPositionMs", "()J", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class SeekTo implements VideoArtifactPreviewAction {
        public static final int $stable = 0;
        private final long positionMs;

        public static /* synthetic */ SeekTo copy$default(SeekTo seekTo, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = seekTo.positionMs;
            }
            return seekTo.copy(j);
        }

        /* renamed from: component1, reason: from getter */
        public final long getPositionMs() {
            return this.positionMs;
        }

        public final SeekTo copy(long positionMs) {
            return new SeekTo(positionMs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SeekTo) && this.positionMs == ((SeekTo) other).positionMs;
        }

        public int hashCode() {
            return Long.hashCode(this.positionMs);
        }

        public String toString() {
            return "SeekTo(positionMs=" + this.positionMs + ')';
        }

        public SeekTo(long j) {
            this.positionMs = j;
        }

        public final long getPositionMs() {
            return this.positionMs;
        }
    }

    /* compiled from: VideoArtifactPreviewViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0011H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SelectSpeed;", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction;", "speed", "", "<init>", "(F)V", "getSpeed", "()F", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class SelectSpeed implements VideoArtifactPreviewAction {
        public static final int $stable = 0;
        private final float speed;

        public static /* synthetic */ SelectSpeed copy$default(SelectSpeed selectSpeed, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = selectSpeed.speed;
            }
            return selectSpeed.copy(f);
        }

        /* renamed from: component1, reason: from getter */
        public final float getSpeed() {
            return this.speed;
        }

        public final SelectSpeed copy(float speed) {
            return new SelectSpeed(speed);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SelectSpeed) && Float.compare(this.speed, ((SelectSpeed) other).speed) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.speed);
        }

        public String toString() {
            return "SelectSpeed(speed=" + this.speed + ')';
        }

        public SelectSpeed(float f) {
            this.speed = f;
        }

        public final float getSpeed() {
            return this.speed;
        }
    }
}
