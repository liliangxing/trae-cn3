package com.bytedance.realx.video;

import android.graphics.Matrix;
import android.graphics.Point;
import android.opengl.GLES20;
import android.util.Log;
import com.bytedance.realx.video.RendererCommon;
import com.bytedance.realx.video.memory.NativeRXByteMemory;
import com.bytedance.realx.video.memory.RXVideoByteMemoryInterface;
import com.bytedance.realx.video.memory.RXVideoFrameInterface;
import com.bytedance.realx.video.memory.RXVideoMemoryInterface;
import com.bytedance.realx.video.memory.RXVideoOpenGLMemoryInterface;
import java.nio.ByteBuffer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class VideoFrameDrawer {
    static final float[] srcPoints = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f};
    private RXVideoFrameInterface lastI420Frame;
    private int renderHeight;
    private int renderWidth;
    private final float[] dstPoints = new float[6];
    private final Point renderSize = new Point();
    private int dstWidth = 0;
    private int dstHeight = 0;
    private final YuvUploader yuvUploader = new YuvUploader(null);
    private final Matrix renderMatrix = new Matrix();

    static void drawTexture(RendererCommon.GlDrawer drawer, RXVideoOpenGLMemoryInterface openglMemory, Matrix renderMatrix, int frameWidth, int frameHeight, int viewportX, int viewportY, int viewportWidth, int viewportHeight, FilterType scaleFilter, int unscaleWidth, int unscaleHeight) {
        Matrix matrix = new Matrix(openglMemory.getAndroidTextureMatrix());
        matrix.preConcat(renderMatrix);
        float[] convertMatrixFromAndroidGraphicsMatrix = RendererCommon.convertMatrixFromAndroidGraphicsMatrix(matrix);
        int i = C07131.$SwitchMap$com$bytedance$realx$video$RXPixelFormat[openglMemory.getTextureTarget().ordinal()];
        if (i == 1) {
            drawer.drawOes(openglMemory.getTextureId(), convertMatrixFromAndroidGraphicsMatrix, frameWidth, frameHeight, viewportX, viewportY, viewportWidth, viewportHeight, scaleFilter, unscaleWidth, unscaleHeight);
        } else {
            if (i == 2) {
                drawer.drawRgb(openglMemory.getTextureId(), convertMatrixFromAndroidGraphicsMatrix, frameWidth, frameHeight, viewportX, viewportY, viewportWidth, viewportHeight, scaleFilter, unscaleWidth, unscaleHeight);
                return;
            }
            throw new RuntimeException("Unknown texture type.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.realx.video.VideoFrameDrawer$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static /* synthetic */ class C07131 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$realx$video$RXPixelFormat;

        static {
            int[] iArr = new int[RXPixelFormat.values().length];
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat = iArr;
            try {
                iArr[RXPixelFormat.kTextureOES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kTexture2D.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static void drawTexture(RendererCommon.GlDrawer drawer, RXVideoOpenGLMemoryInterface openglMemory, Matrix renderMatrix, int frameWidth, int frameHeight, int viewportX, int viewportY, int viewportWidth, int viewportHeight, FilterType scaleFilter, int unscaleWidth, int unscaleHeight, int dstWidth, int dstHeight) {
        Matrix matrix = new Matrix(openglMemory.getAndroidTextureMatrix());
        matrix.preConcat(renderMatrix);
        float[] convertMatrixFromAndroidGraphicsMatrix = RendererCommon.convertMatrixFromAndroidGraphicsMatrix(matrix);
        int i = C07131.$SwitchMap$com$bytedance$realx$video$RXPixelFormat[openglMemory.getTextureTarget().ordinal()];
        if (i == 1) {
            drawer.drawOes(openglMemory.getTextureId(), convertMatrixFromAndroidGraphicsMatrix, frameWidth, frameHeight, viewportX, viewportY, viewportWidth, viewportHeight, scaleFilter, unscaleWidth, unscaleHeight, dstWidth, dstHeight);
        } else {
            if (i == 2) {
                drawer.drawRgb(openglMemory.getTextureId(), convertMatrixFromAndroidGraphicsMatrix, frameWidth, frameHeight, viewportX, viewportY, viewportWidth, viewportHeight, scaleFilter, unscaleWidth, unscaleHeight, dstWidth, dstHeight);
                return;
            }
            throw new RuntimeException("Unknown texture type.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class YuvUploader {
        private ByteBuffer copyBuffer;
        private int[] yuvTextures;

        private YuvUploader() {
        }

        /* synthetic */ YuvUploader(C07131 c07131) {
            this();
        }

        public int[] uploadYuvData(int width, int height, int[] strides, ByteBuffer[] planes) {
            ByteBuffer byteBuffer;
            ByteBuffer byteBuffer2;
            int i = width / 2;
            int[] iArr = {width, i, i};
            int i2 = height / 2;
            int[] iArr2 = {height, i2, i2};
            int i3 = 0;
            for (int i4 = 0; i4 < 3; i4++) {
                int i5 = strides[i4];
                int i6 = iArr[i4];
                if (i5 > i6) {
                    i3 = Math.max(i3, i6 * iArr2[i4]);
                }
            }
            if (i3 > 0 && ((byteBuffer2 = this.copyBuffer) == null || byteBuffer2.capacity() < i3)) {
                this.copyBuffer = ByteBuffer.allocateDirect(i3);
            }
            if (this.yuvTextures == null) {
                this.yuvTextures = new int[3];
                for (int i7 = 0; i7 < 3; i7++) {
                    this.yuvTextures[i7] = GlUtil.generateTexture(3553);
                }
            }
            for (int i8 = 0; i8 < 3; i8++) {
                GLES20.glPixelStorei(3317, 1);
                GLES20.glActiveTexture(33984 + i8);
                GLES20.glBindTexture(3553, this.yuvTextures[i8]);
                int i9 = strides[i8];
                int i10 = iArr[i8];
                if (i9 == i10) {
                    byteBuffer = planes[i8];
                } else {
                    YuvHelper.copyPlane(planes[i8], i9, this.copyBuffer, i10, i10, iArr2[i8]);
                    byteBuffer = this.copyBuffer;
                }
                GLES20.glTexImage2D(3553, 0, 6409, iArr[i8], iArr2[i8], 0, 6409, 5121, byteBuffer);
                GLES20.glPixelStorei(3317, 4);
            }
            return this.yuvTextures;
        }

        public int[] uploadFromBuffer(RXVideoByteMemoryInterface byteMemory) {
            if (byteMemory.getPixelFormat() != RXPixelFormat.kI420) {
                return null;
            }
            return uploadYuvData(byteMemory.getWidth(), byteMemory.getHeight(), new int[]{byteMemory.getPlaneLineSize(0), byteMemory.getPlaneLineSize(1), byteMemory.getPlaneLineSize(2)}, new ByteBuffer[]{byteMemory.getPlaneData(0), byteMemory.getPlaneData(1), byteMemory.getPlaneData(2)});
        }

        public int[] getYuvTextures() {
            return this.yuvTextures;
        }

        public void release() {
            this.copyBuffer = null;
            int[] iArr = this.yuvTextures;
            if (iArr != null) {
                GLES20.glDeleteTextures(3, iArr, 0);
                this.yuvTextures = null;
            }
        }
    }

    private static int distance(float x0, float y0, float x1, float y1) {
        return (int) Math.round(Math.hypot(x1 - x0, y1 - y0));
    }

    private void calculateTransformedRenderSize(int frameWidth, int frameHeight, Matrix renderMatrix) {
        if (renderMatrix == null) {
            this.renderWidth = frameWidth;
            this.renderHeight = frameHeight;
            return;
        }
        renderMatrix.mapPoints(this.dstPoints, srcPoints);
        for (int i = 0; i < 3; i++) {
            float[] fArr = this.dstPoints;
            int i2 = i * 2;
            int i3 = i2 + 0;
            fArr[i3] = fArr[i3] * frameWidth;
            int i4 = i2 + 1;
            fArr[i4] = fArr[i4] * frameHeight;
        }
        float[] fArr2 = this.dstPoints;
        this.renderWidth = distance(fArr2[0], fArr2[1], fArr2[2], fArr2[3]);
        float[] fArr3 = this.dstPoints;
        this.renderHeight = distance(fArr3[0], fArr3[1], fArr3[4], fArr3[5]);
    }

    public void drawFrame(RXVideoFrameInterface frame, RendererCommon.GlDrawer drawer) {
        drawFrame(frame, drawer, null);
    }

    public void drawFrame(RXVideoFrameInterface frame, RendererCommon.GlDrawer drawer, Matrix additionalRenderMatrix) {
        drawFrame(frame, drawer, additionalRenderMatrix, 0, 0, frame.getRotatedWidth(), frame.getRotatedHeight());
    }

    public void drawFrame(RXVideoFrameInterface frame, RendererCommon.GlDrawer drawer, Matrix additionalRenderMatrix, int viewportX, int viewportY, int viewportWidth, int viewportHeight, int dstWidth, int dstHeight) {
        this.dstWidth = dstWidth;
        this.dstHeight = dstHeight;
        drawFrame(frame, drawer, additionalRenderMatrix, viewportX, viewportY, viewportWidth, viewportHeight);
    }

    public void drawFrame(RXVideoFrameInterface frame, RendererCommon.GlDrawer drawer, Matrix additionalRenderMatrix, int viewportX, int viewportY, int viewportWidth, int viewportHeight) {
        if (frame == null) {
            return;
        }
        RXVideoMemoryInterface andRetainVideoFrameMemory = frame.getAndRetainVideoFrameMemory();
        try {
            if (andRetainVideoFrameMemory == null) {
                return;
            }
            try {
                calculateTransformedRenderSize(frame.getRotatedWidth(), frame.getRotatedHeight(), additionalRenderMatrix);
                boolean z = andRetainVideoFrameMemory.getMemoryType() == RXVideoMemoryType.kOPENGL_TEXTURE;
                this.renderMatrix.reset();
                this.renderMatrix.preTranslate(0.5f, 0.5f);
                if (!z) {
                    this.renderMatrix.preScale(1.0f, -1.0f);
                }
                this.renderMatrix.preRotate(frame.getRotation().value());
                this.renderMatrix.preTranslate(-0.5f, -0.5f);
                if (additionalRenderMatrix != null) {
                    this.renderMatrix.preConcat(additionalRenderMatrix);
                }
                if (z && this.renderWidth > 0) {
                    RXVideoOpenGLMemoryInterface rXVideoOpenGLMemoryInterface = (RXVideoOpenGLMemoryInterface) andRetainVideoFrameMemory;
                    FilterType fromValue = FilterType.fromValue(rXVideoOpenGLMemoryInterface.getScaleFilter().value());
                    int unScaledWidth = rXVideoOpenGLMemoryInterface.getUnScaledWidth();
                    int unScaledHeight = rXVideoOpenGLMemoryInterface.getUnScaledHeight();
                    this.lastI420Frame = null;
                    if (fromValue != null && fromValue != FilterType.Origin && unScaledWidth != 0 && unScaledHeight != 0) {
                        drawTexture(drawer, rXVideoOpenGLMemoryInterface, this.renderMatrix, this.renderWidth, this.renderHeight, viewportX, viewportY, viewportWidth, viewportHeight, fromValue, unScaledWidth, unScaledHeight, this.dstWidth, this.dstHeight);
                    } else {
                        drawTexture(drawer, rXVideoOpenGLMemoryInterface, this.renderMatrix, this.renderWidth, this.renderHeight, viewportX, viewportY, viewportWidth, viewportHeight, FilterType.Origin, 0, 0, this.dstWidth, this.dstHeight);
                    }
                } else {
                    if (frame != this.lastI420Frame) {
                        this.lastI420Frame = frame;
                        RXVideoFrameInterface i420 = frame.toI420();
                        if (i420 == null) {
                            return;
                        }
                        RXVideoMemoryInterface andRetainVideoFrameMemory2 = i420.getAndRetainVideoFrameMemory();
                        if (!(andRetainVideoFrameMemory2 instanceof NativeRXByteMemory)) {
                            i420.release();
                            return;
                        } else {
                            this.yuvUploader.uploadFromBuffer((RXVideoByteMemoryInterface) andRetainVideoFrameMemory2);
                            andRetainVideoFrameMemory2.release();
                            i420.release();
                        }
                    }
                    drawer.drawYuv(this.yuvUploader.getYuvTextures(), RendererCommon.convertMatrixFromAndroidGraphicsMatrix(this.renderMatrix), this.renderWidth, this.renderHeight, viewportX, viewportY, viewportWidth, viewportHeight, FilterType.Origin, 0, 0, this.dstWidth, this.dstHeight);
                }
            } catch (Exception e) {
                Log.w("VideoFrameDrawer", "draw frame error", e);
            }
        } finally {
            andRetainVideoFrameMemory.release();
        }
    }

    public void release() {
        this.yuvUploader.release();
        this.lastI420Frame = null;
    }
}
