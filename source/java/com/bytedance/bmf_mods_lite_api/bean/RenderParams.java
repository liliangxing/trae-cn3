package com.bytedance.bmf_mods_lite_api.bean;

/* loaded from: classes3.dex */
public class RenderParams {
    private boolean isDrawToScreen;
    private int renderType;
    private float[] textureVertices;
    private int[] viewport;

    public RenderParams() {
        this.isDrawToScreen = false;
        this.renderType = 0;
    }

    public RenderParams(boolean drawToScreen) {
        this.renderType = 0;
        this.isDrawToScreen = drawToScreen;
    }

    public RenderParams(boolean drawToScreen, int renderType, int[] viewport) {
        this.isDrawToScreen = drawToScreen;
        this.renderType = renderType;
        this.viewport = viewport;
    }

    public RenderParams(boolean drawToScreen, int renderType, int[] viewport, float[] textureVertices) {
        this.isDrawToScreen = drawToScreen;
        this.renderType = renderType;
        this.viewport = viewport;
        this.textureVertices = textureVertices;
    }

    public boolean isDrawToScreen() {
        return this.isDrawToScreen;
    }

    public void setDrawToScreen(boolean drawToScreen) {
        this.isDrawToScreen = drawToScreen;
    }

    public int getRenderType() {
        return this.renderType;
    }

    public void setRenderType(int renderType) {
        this.renderType = renderType;
    }

    public void setViewport(int x, int y, int width, int height) {
        this.viewport = new int[]{x, y, width, height};
    }

    public int[] getViewport() {
        return this.viewport;
    }

    public void setTextureVertices(float[] textureVertices) {
        this.textureVertices = textureVertices;
    }

    public float[] getTextureVertices() {
        return this.textureVertices;
    }
}
