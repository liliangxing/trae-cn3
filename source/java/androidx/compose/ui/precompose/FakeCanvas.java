package androidx.compose.ui.precompose;

import android.graphics.Canvas;
import android.graphics.RenderNode;
import kotlin.Metadata;

/* compiled from: PreComposeView.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/precompose/FakeCanvas;", "Landroid/graphics/Canvas;", "enableHardwareAccelerated", "", "<init>", "(Z)V", "getEnableHardwareAccelerated", "()Z", "isHardwareAccelerated", "drawRenderNode", "", "renderNode", "Landroid/graphics/RenderNode;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
final class FakeCanvas extends Canvas {
    private final boolean enableHardwareAccelerated;

    @Override // android.graphics.Canvas
    public void drawRenderNode(RenderNode renderNode) {
    }

    public FakeCanvas(boolean z) {
        this.enableHardwareAccelerated = z;
    }

    public final boolean getEnableHardwareAccelerated() {
        return this.enableHardwareAccelerated;
    }

    @Override // android.graphics.Canvas
    public boolean isHardwareAccelerated() {
        return this.enableHardwareAccelerated;
    }
}
