package com.bytedance.trae.conversation.chat.block.renderer;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PureShowWidgetInlineView.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;", "", "heightCss", "", "viewportWidthCss", "<init>", "(FF)V", "getHeightCss", "()F", "getViewportWidthCss", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class HeightMeasurement {
    private final float heightCss;
    private final float viewportWidthCss;

    public static /* synthetic */ HeightMeasurement copy$default(HeightMeasurement heightMeasurement, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = heightMeasurement.heightCss;
        }
        if ((i & 2) != 0) {
            f2 = heightMeasurement.viewportWidthCss;
        }
        return heightMeasurement.copy(f, f2);
    }

    /* renamed from: component1, reason: from getter */
    public final float getHeightCss() {
        return this.heightCss;
    }

    /* renamed from: component2, reason: from getter */
    public final float getViewportWidthCss() {
        return this.viewportWidthCss;
    }

    public final HeightMeasurement copy(float heightCss, float viewportWidthCss) {
        return new HeightMeasurement(heightCss, viewportWidthCss);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HeightMeasurement)) {
            return false;
        }
        HeightMeasurement heightMeasurement = (HeightMeasurement) other;
        return Float.compare(this.heightCss, heightMeasurement.heightCss) == 0 && Float.compare(this.viewportWidthCss, heightMeasurement.viewportWidthCss) == 0;
    }

    public int hashCode() {
        return (Float.hashCode(this.heightCss) * 31) + Float.hashCode(this.viewportWidthCss);
    }

    public String toString() {
        return "HeightMeasurement(heightCss=" + this.heightCss + ", viewportWidthCss=" + this.viewportWidthCss + ')';
    }

    public HeightMeasurement(float f, float f2) {
        this.heightCss = f;
        this.viewportWidthCss = f2;
    }

    public final float getHeightCss() {
        return this.heightCss;
    }

    public final float getViewportWidthCss() {
        return this.viewportWidthCss;
    }
}
