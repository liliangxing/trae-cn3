package com.bytedance.realx.video;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MediaCodecTextureBufferHelper {
    private ReleaseOutPutBuffer mReleaseFunc;
    private boolean render = false;
    private SurfaceTextureHelper mSurfaceTextureHelper = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    @FunctionalInterface
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface ReleaseOutPutBuffer {
        int release(boolean render);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MediaCodecTextureBufferHelper(ReleaseOutPutBuffer func) {
        this.mReleaseFunc = func;
    }

    public void setSurfaceTextureHelper(SurfaceTextureHelper helper) {
        this.mSurfaceTextureHelper = helper;
    }

    public void setRender(boolean render) {
        this.render = render;
    }

    public int runTask(boolean render) {
        return this.mReleaseFunc.release(render);
    }

    public float[] getMatrix() {
        SurfaceTextureHelper surfaceTextureHelper = this.mSurfaceTextureHelper;
        if (surfaceTextureHelper == null) {
            return null;
        }
        return surfaceTextureHelper.getTexMatrix();
    }

    public boolean isAvaliable() {
        SurfaceTextureHelper surfaceTextureHelper = this.mSurfaceTextureHelper;
        if (surfaceTextureHelper == null) {
            return false;
        }
        return surfaceTextureHelper.isAvaliable();
    }

    public void releaseOutputBuffer(boolean render) {
        runTask(render);
    }

    public boolean updateTextureImage() {
        SurfaceTextureHelper surfaceTextureHelper = this.mSurfaceTextureHelper;
        if (surfaceTextureHelper == null) {
            return false;
        }
        surfaceTextureHelper.updateTexImage();
        return true;
    }

    public boolean updateTextureImageAndWait(int timeout) {
        SurfaceTextureHelper surfaceTextureHelper = this.mSurfaceTextureHelper;
        if (surfaceTextureHelper == null) {
            return false;
        }
        return surfaceTextureHelper.updateTexImageAndWait(timeout);
    }
}
