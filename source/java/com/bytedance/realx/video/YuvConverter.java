package com.bytedance.realx.video;

import android.graphics.Matrix;
import android.opengl.GLES20;
import android.util.Log;
import com.bytedance.realx.base.JniCommon;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.GlGenericDrawer;
import com.bytedance.realx.video.VideoFrame;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class YuvConverter {
    public static final int FORMAT_TEXTURE_2D = 10;
    public static final int FORMAT_TEXTURE_OES = 11;
    private static final String FRAGMENT_SHADER = "uniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      sample(tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      sample(tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      sample(tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      sample(tc + 1.5 * xUnit).rgb);\n}\n";
    private static final int TEXTURE_MAX_COUNT = 45;
    private static float[] TEX_MATRIX = new float[16];
    private final GlGenericDrawer drawer;
    private final GlTextureFrameBuffer i420TextureFrameBuffer;
    private GlRectDrawer mTextureDrawer;
    private final ShaderCallbacks shaderCallbacks;
    private final ThreadUtils.ThreadChecker threadChecker;
    private List<Integer> mTextureFreeQueue = new LinkedList();
    private List<Integer> mTextureUsedQueue = new LinkedList();
    private HashMap<Integer, Integer> mTextureWidthMap = new HashMap<>();
    private HashMap<Integer, Integer> mTextureHeightMap = new HashMap<>();
    private int mTextureCnt = 0;
    private int mFrameBufferId = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class ShaderCallbacks implements GlGenericDrawer.ShaderCallbacks {
        private float[] coeffs;
        private int coeffsLoc;
        private float stepSize;
        private int xUnitLoc;
        private static final float[] yCoeffs = {0.256788f, 0.504129f, 0.0979059f, 0.0627451f};
        private static final float[] uCoeffs = {-0.148223f, -0.290993f, 0.439216f, 0.501961f};
        private static final float[] vCoeffs = {0.439216f, -0.367788f, -0.0714274f, 0.501961f};

        private ShaderCallbacks() {
        }

        public void setPlaneY() {
            this.coeffs = yCoeffs;
            this.stepSize = 1.0f;
        }

        public void setPlaneU() {
            this.coeffs = uCoeffs;
            this.stepSize = 2.0f;
        }

        public void setPlaneV() {
            this.coeffs = vCoeffs;
            this.stepSize = 2.0f;
        }

        @Override // com.bytedance.realx.video.GlGenericDrawer.ShaderCallbacks
        public void onNewShader(GlShader shader) {
            this.xUnitLoc = shader.getUniformLocation("xUnit");
            this.coeffsLoc = shader.getUniformLocation("coeffs");
        }

        @Override // com.bytedance.realx.video.GlGenericDrawer.ShaderCallbacks
        public void onPrepareShader(GlShader shader, float[] texMatrix, int frameWidth, int frameHeight, int viewportWidth, int viewportHeight) {
            GLES20.glUniform4fv(this.coeffsLoc, 1, this.coeffs, 0);
            int i = this.xUnitLoc;
            float f = this.stepSize;
            float f2 = frameWidth;
            GLES20.glUniform2f(i, (texMatrix[0] * f) / f2, (f * texMatrix[1]) / f2);
        }
    }

    public YuvConverter() {
        ThreadUtils.ThreadChecker threadChecker = new ThreadUtils.ThreadChecker();
        this.threadChecker = threadChecker;
        this.i420TextureFrameBuffer = new GlTextureFrameBuffer(6408);
        ShaderCallbacks shaderCallbacks = new ShaderCallbacks();
        this.shaderCallbacks = shaderCallbacks;
        this.drawer = new GlGenericDrawer(FRAGMENT_SHADER, shaderCallbacks);
        threadChecker.detachThread();
    }

    public VideoFrame.I420Buffer convert(VideoFrame.TextureBuffer inputTextureBuffer) {
        return convert(inputTextureBuffer, FilterType.Origin, 0, 0);
    }

    public VideoFrame.I420Buffer convert(VideoFrame.TextureBuffer inputTextureBuffer, FilterType scaleFilter, int unscaleWidth, int unscaleHeight) {
        this.threadChecker.checkIsOnValidThread();
        GlUtil.clearGLES2Error("YUVConverter");
        int width = inputTextureBuffer.getWidth();
        int height = inputTextureBuffer.getHeight();
        int i = ((width + 63) / 64) * 64;
        int i2 = ((width + 7) / 8) * 8;
        int i3 = (height + 1) / 2;
        int i4 = height + i3;
        final ByteBuffer nativeAllocateByteBuffer = JniCommon.nativeAllocateByteBuffer((i * i4) + i);
        if (nativeAllocateByteBuffer == null) {
            return null;
        }
        int i5 = i / 4;
        int i6 = i2 / 4;
        Matrix matrix = new Matrix();
        matrix.preTranslate(0.5f, 0.5f);
        matrix.preScale(1.0f, -1.0f);
        matrix.preTranslate(-0.5f, -0.5f);
        if (i2 != width) {
            matrix.preScale((i2 * 1.0f) / width, 1.0f);
        }
        this.i420TextureFrameBuffer.setSize(i5, i4);
        GLES20.glBindFramebuffer(36160, this.i420TextureFrameBuffer.getFrameBufferId());
        GlUtil.checkNoGLES2Error("glBindFramebuffer");
        this.shaderCallbacks.setPlaneY();
        RTCVideoFrameDrawer.drawTexture(this.drawer, inputTextureBuffer, matrix, width, height, 0, 0, i6, height, scaleFilter, unscaleWidth, unscaleHeight);
        this.shaderCallbacks.setPlaneU();
        int i7 = i6 / 2;
        RTCVideoFrameDrawer.drawTexture(this.drawer, inputTextureBuffer, matrix, width, height, 0, height, i7, i3, scaleFilter, unscaleWidth, unscaleHeight);
        this.shaderCallbacks.setPlaneV();
        RTCVideoFrameDrawer.drawTexture(this.drawer, inputTextureBuffer, matrix, width, height, i5 / 2, height, i7, i3, scaleFilter, unscaleWidth, unscaleHeight);
        GLES20.glReadPixels(0, 0, this.i420TextureFrameBuffer.getWidth(), this.i420TextureFrameBuffer.getHeight(), 6408, 5121, nativeAllocateByteBuffer);
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("YUVConverter", "error: " + glGetError);
            RXLogging.m283e("YUVConverter", "convert i420 failed as opengl error " + glGetError);
            if (1285 != glGetError && 1282 != glGetError) {
                throw new RuntimeException("YuvConverter.convert: GLES20 error: " + glGetError);
            }
            if (nativeAllocateByteBuffer != null) {
                JniCommon.nativeFreeByteBuffer(nativeAllocateByteBuffer);
            }
            return null;
        }
        GLES20.glBindFramebuffer(36160, 0);
        int i8 = (i * height) + 0;
        int i9 = i / 2;
        int i10 = i8 + i9;
        nativeAllocateByteBuffer.position(0);
        nativeAllocateByteBuffer.limit(i8);
        ByteBuffer slice = nativeAllocateByteBuffer.slice();
        nativeAllocateByteBuffer.position(i8);
        int i11 = ((i3 - 1) * i) + i9;
        nativeAllocateByteBuffer.limit(i8 + i11);
        ByteBuffer slice2 = nativeAllocateByteBuffer.slice();
        nativeAllocateByteBuffer.position(i10);
        nativeAllocateByteBuffer.limit(i10 + i11);
        return JavaI420Buffer.wrap(width, height, slice, i, slice2, i, nativeAllocateByteBuffer.slice(), i, new Runnable() { // from class: com.bytedance.realx.video.YuvConverter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                JniCommon.nativeFreeByteBuffer(nativeAllocateByteBuffer);
            }
        });
    }

    public void release() {
        this.threadChecker.checkIsOnValidThread();
        this.drawer.release();
        this.i420TextureFrameBuffer.release();
        GlRectDrawer glRectDrawer = this.mTextureDrawer;
        if (glRectDrawer != null) {
            glRectDrawer.release();
            this.mTextureDrawer = null;
        }
        int i = this.mFrameBufferId;
        if (i > 0) {
            GLES20.glDeleteFramebuffers(1, new int[]{i}, 0);
            this.mFrameBufferId = 0;
        }
        List<Integer> list = this.mTextureFreeQueue;
        if (list != null && list.size() > 0) {
            Iterator<Integer> it = this.mTextureFreeQueue.iterator();
            while (it.hasNext()) {
                GLES20.glDeleteTextures(1, new int[]{it.next().intValue()}, 0);
            }
            this.mTextureFreeQueue.clear();
        }
        List<Integer> list2 = this.mTextureUsedQueue;
        if (list2 != null && list2.size() > 0) {
            Iterator<Integer> it2 = this.mTextureUsedQueue.iterator();
            while (it2.hasNext()) {
                GLES20.glDeleteTextures(1, new int[]{it2.next().intValue()}, 0);
            }
            this.mTextureUsedQueue.clear();
        }
        this.threadChecker.detachThread();
    }

    public int dequeueTexture(int width, int height) {
        int[] iArr = new int[1];
        List<Integer> list = this.mTextureFreeQueue;
        if (list != null) {
            if (list.size() == 0) {
                int generateTexture = generateTexture(3553, width, height);
                iArr[0] = generateTexture;
                if (generateTexture > 0) {
                    this.mTextureUsedQueue.add(Integer.valueOf(generateTexture));
                    this.mTextureWidthMap.put(Integer.valueOf(iArr[0]), Integer.valueOf(width));
                    this.mTextureHeightMap.put(Integer.valueOf(iArr[0]), Integer.valueOf(height));
                }
            } else {
                int i = 0;
                while (true) {
                    if (i >= this.mTextureFreeQueue.size()) {
                        i = -1;
                        break;
                    }
                    int intValue = this.mTextureFreeQueue.get(i).intValue();
                    if (this.mTextureWidthMap.get(Integer.valueOf(intValue)).intValue() == width && this.mTextureHeightMap.get(Integer.valueOf(intValue)).intValue() == height) {
                        break;
                    }
                    i++;
                }
                if (i >= 0) {
                    iArr[0] = this.mTextureFreeQueue.get(i).intValue();
                    this.mTextureFreeQueue.remove(0);
                    this.mTextureUsedQueue.add(Integer.valueOf(iArr[0]));
                } else {
                    int generateTexture2 = generateTexture(3553, width, height);
                    iArr[0] = generateTexture2;
                    if (generateTexture2 > 0) {
                        this.mTextureUsedQueue.add(Integer.valueOf(generateTexture2));
                        this.mTextureWidthMap.put(Integer.valueOf(iArr[0]), Integer.valueOf(width));
                        this.mTextureHeightMap.put(Integer.valueOf(iArr[0]), Integer.valueOf(height));
                    }
                }
            }
        }
        return iArr[0];
    }

    public void queueTexture(int textureId) {
        List<Integer> list = this.mTextureUsedQueue;
        if (list == null || !list.contains(Integer.valueOf(textureId))) {
            return;
        }
        this.mTextureUsedQueue.remove(new Integer(textureId));
        List<Integer> list2 = this.mTextureFreeQueue;
        if (list2 != null) {
            list2.add(Integer.valueOf(textureId));
        }
    }

    private int generateTexture(int type, int width, int height) {
        if (this.mTextureCnt == 45) {
            return 0;
        }
        int generateTexture = GlUtil.generateTexture(type);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, generateTexture);
        GLES20.glTexImage2D(3553, 0, 6408, width, height, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        if (GLES20.glGetError() != 0) {
            return 0;
        }
        this.mTextureCnt++;
        return generateTexture;
    }

    public void drawTexture(int textureType, int srcTextureId, int targetTextureId, int width, int height) {
        if (this.mTextureDrawer == null) {
            this.mTextureDrawer = new GlRectDrawer();
        }
        GlUtil.checkNoGLES2Error("TextureHelper construct");
        android.opengl.Matrix.setIdentityM(TEX_MATRIX, 0);
        if (this.mFrameBufferId == 0) {
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            this.mFrameBufferId = iArr[0];
        }
        GLES20.glBindFramebuffer(36160, this.mFrameBufferId);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, targetTextureId, 0);
        if (textureType == 10) {
            this.mTextureDrawer.drawRgb(srcTextureId, TEX_MATRIX, width, height, 0, 0, width, height);
        } else if (textureType == 11) {
            this.mTextureDrawer.drawOes(srcTextureId, TEX_MATRIX, width, height, 0, 0, width, height);
        }
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glFinish();
        GlUtil.checkNoGLES2Error("TextureHelper drawTexture");
    }
}
