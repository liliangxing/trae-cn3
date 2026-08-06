package com.lynx.tasm.rendernode.compat;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.DisplayList;
import android.view.HardwareCanvas;

/* loaded from: classes7.dex */
class RenderNodeV16Impl extends RenderNodeV14Impl {
    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void init() {
        try {
            if (this.sGLESConstructor == null) {
                this.sGLESConstructor = Class.forName("android.view.GLES20DisplayList").getDeclaredConstructor(String.class);
                this.sGLESConstructor.setAccessible(true);
            }
            this.displayList = (DisplayList) this.sGLESConstructor.newInstance("");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public boolean hasDisplayList() {
        return this.displayList.isValid();
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public Canvas beginRecording(int i, int i2) {
        HardwareCanvas start = this.displayList.start();
        setViewport(i, i2, start);
        start.onPreDraw((Rect) null);
        return start;
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas canvas) {
        drawRenderNode(canvas, this.displayList);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas canvas, Object obj) {
        ((HardwareCanvas) canvas).drawDisplayList((DisplayList) obj, (Rect) null, 1);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void endRecording(Canvas canvas) {
        ((HardwareCanvas) canvas).onPostDraw();
        this.displayList.end();
        this.displayList.setCaching(true);
        this.displayList.setLeftTopRightBottom(this.left, this.top, this.right, this.bottom);
    }
}
