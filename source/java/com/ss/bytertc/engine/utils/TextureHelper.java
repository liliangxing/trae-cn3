package com.ss.bytertc.engine.utils;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.GlRectDrawer;
import com.bytedance.realx.video.GlUtil;
import com.bytedance.realx.video.VideoFrame;
import com.bytedance.realx.video.YuvConverter;
import com.bytedance.realx.video.YuvHelper;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.microedition.khronos.egl.EGLContext;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TextureHelper {
    public static final int FORMAT_TEXTURE_2D = 10;
    public static final int FORMAT_TEXTURE_OES = 11;
    private static final String TAG = "TextureHelper";
    private static final int TEXTURE_MAX_COUNT = 45;
    private static float[] TEX_MATRIX = new float[16];
    private static float[] YUV_TEX_MATRIX = new float[16];
    private final EglBase mEglBase;
    private int mFrameBufferId;
    private final Handler mHandler;
    private int mHeight;
    private boolean mIsQuitting;
    private boolean mIsRelease;
    private boolean mIsTextureInUse;
    private GlRectDrawer mTextureDrawer;
    private int mWidth;
    private YuvConverter mYuvConverter;
    private YuvUploader mYuvUploader;
    private int mTextureCnt = 0;
    private List<Integer> mTextureFreeQueue = new LinkedList();
    private List<Integer> mTextureUsedQueue = new LinkedList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class YuvUploader {
        private ByteBuffer copyBuffer;
        private int[] yuvTextures;

        YuvUploader() {
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
            }
            return this.yuvTextures;
        }

        public int[] uploadFromBuffer(VideoFrame.I420Buffer buffer) {
            return uploadYuvData(buffer.getWidth(), buffer.getHeight(), new int[]{buffer.getStrideY(), buffer.getStrideU(), buffer.getStrideV()}, new ByteBuffer[]{buffer.getDataY(), buffer.getDataU(), buffer.getDataV()});
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

    public static TextureHelper create(final String threadName, final EGLContext sharedContext, final int width, final int height) {
        HandlerThread handlerThread = new HandlerThread(threadName);
        handlerThread.start();
        final Handler handler = new Handler(handlerThread.getLooper());
        return (TextureHelper) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable() { // from class: com.ss.bytertc.engine.utils.TextureHelper$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return TextureHelper.lambda$create$0(sharedContext, handler, width, height, threadName);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TextureHelper lambda$create$0(EGLContext eGLContext, Handler handler, int i, int i2, String str) throws Exception {
        try {
            return new TextureHelper(eGLContext, handler, i, i2);
        } catch (RuntimeException e) {
            LogUtil.m217e(TAG, str + " create failure", e);
            return null;
        }
    }

    public static TextureHelper create(final String threadName, final android.opengl.EGLContext sharedContext, final int width, final int height) {
        HandlerThread handlerThread = new HandlerThread(threadName);
        handlerThread.start();
        final Handler handler = new Handler(handlerThread.getLooper());
        return (TextureHelper) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable() { // from class: com.ss.bytertc.engine.utils.TextureHelper$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return TextureHelper.lambda$create$1(sharedContext, handler, width, height, threadName);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TextureHelper lambda$create$1(android.opengl.EGLContext eGLContext, Handler handler, int i, int i2, String str) throws Exception {
        try {
            return new TextureHelper(eGLContext, handler, i, i2);
        } catch (RuntimeException e) {
            LogUtil.m217e(TAG, str + " create failure", e);
            return null;
        }
    }

    public static TextureHelper create(final String threadName, final EglBase.Context sharedContext, final int width, final int height) {
        HandlerThread handlerThread = new HandlerThread(threadName);
        handlerThread.start();
        final Handler handler = new Handler(handlerThread.getLooper());
        return (TextureHelper) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable() { // from class: com.ss.bytertc.engine.utils.TextureHelper$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return TextureHelper.lambda$create$2(sharedContext, handler, width, height, threadName);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TextureHelper lambda$create$2(EglBase.Context context, Handler handler, int i, int i2, String str) throws Exception {
        try {
            return new TextureHelper(context, handler, i, i2);
        } catch (RuntimeException e) {
            LogUtil.m217e(TAG, str + " create failure", e);
            return null;
        }
    }

    private TextureHelper(Object context, Handler handler, int width, int height) {
        if (handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("TextureHelper must be created on the handler thread");
        }
        this.mWidth = width;
        this.mHeight = height;
        this.mHandler = handler;
        Matrix.setIdentityM(TEX_MATRIX, 0);
        Matrix.setIdentityM(YUV_TEX_MATRIX, 0);
        Matrix.translateM(YUV_TEX_MATRIX, 0, 0.5f, 0.5f, 0.0f);
        Matrix.scaleM(YUV_TEX_MATRIX, 0, 1.0f, -1.0f, 1.0f);
        Matrix.translateM(YUV_TEX_MATRIX, 0, -0.5f, -0.5f, 0.0f);
        if (context instanceof EGLContext) {
            this.mEglBase = EglBase.createEgl10((EGLContext) context, EglBase.CONFIG_PIXEL_BUFFER);
        } else if (context instanceof android.opengl.EGLContext) {
            this.mEglBase = EglBase.createEgl14((android.opengl.EGLContext) context, EglBase.CONFIG_PIXEL_BUFFER);
        } else if (context instanceof EglBase.Context) {
            this.mEglBase = EglBase.create((EglBase.Context) context);
        } else {
            throw new RuntimeException("unknown shareContext:" + context);
        }
        try {
            this.mEglBase.createPbufferSurface(this.mWidth, this.mHeight);
            this.mEglBase.makeCurrent();
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            this.mFrameBufferId = iArr[0];
            this.mTextureDrawer = new GlRectDrawer();
            this.mYuvUploader = new YuvUploader();
            GlUtil.checkNoGLES2Error("TextureHelper construct");
        } catch (RuntimeException e) {
            this.mEglBase.release();
            handler.getLooper().quit();
            throw e;
        }
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public void drawTexture(int textureType, int srcTextureId, int targetTextureId) {
        drawTexture(textureType, srcTextureId, targetTextureId, TEX_MATRIX);
    }

    public void drawTexture(final int textureType, final int srcTextureId, final int targetTextureId, final float[] tex_matrix) {
        ThreadUtils.invokeAtFrontUninterruptibly(this.mHandler, new Runnable() { // from class: com.ss.bytertc.engine.utils.TextureHelper.1
            @Override // java.lang.Runnable
            public void run() {
                if (TextureHelper.this.mTextureDrawer == null) {
                    TextureHelper.this.mTextureDrawer = new GlRectDrawer();
                }
                GlUtil.checkNoGLES2Error("TextureHelper construct");
                GLES20.glBindFramebuffer(36160, TextureHelper.this.mFrameBufferId);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, targetTextureId, 0);
                int i = textureType;
                if (i == 10) {
                    TextureHelper.this.mTextureDrawer.drawRgb(srcTextureId, tex_matrix, TextureHelper.this.mWidth, TextureHelper.this.mHeight, 0, 0, TextureHelper.this.mWidth, TextureHelper.this.mHeight);
                } else if (i == 11) {
                    TextureHelper.this.mTextureDrawer.drawOes(srcTextureId, tex_matrix, TextureHelper.this.mWidth, TextureHelper.this.mHeight, 0, 0, TextureHelper.this.mWidth, TextureHelper.this.mHeight);
                } else {
                    LogUtil.m216e(TextureHelper.TAG, "draw texture type error");
                }
                GLES20.glBindTexture(3553, 0);
                GLES20.glBindFramebuffer(36160, 0);
                GLES20.glFinish();
                GlUtil.checkNoGLES2Error("TextureHelper drawTexture");
            }
        });
    }

    public void yuvToTexture(final VideoFrame.I420Buffer i420Buffer, int targetTextureId) {
        yuvToTexture(i420Buffer, targetTextureId, YUV_TEX_MATRIX);
    }

    public void yuvToTexture(final VideoFrame.I420Buffer i420Buffer, final int targetTextureId, final float[] tex_matrix) {
        ThreadUtils.invokeAtFrontUninterruptibly(this.mHandler, new Runnable() { // from class: com.ss.bytertc.engine.utils.TextureHelper.2
            @Override // java.lang.Runnable
            public void run() {
                if (TextureHelper.this.mTextureDrawer == null || TextureHelper.this.mYuvUploader == null) {
                    throw new IllegalStateException("mTextureDrawer and mYuvUploader can not null.");
                }
                GlUtil.checkNoGLES2Error("TextureHelper construct");
                GLES20.glBindFramebuffer(36160, TextureHelper.this.mFrameBufferId);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, targetTextureId, 0);
                TextureHelper.this.mYuvUploader.uploadFromBuffer(i420Buffer);
                TextureHelper.this.mTextureDrawer.drawYuv(TextureHelper.this.mYuvUploader.getYuvTextures(), tex_matrix, TextureHelper.this.mWidth, TextureHelper.this.mHeight, 0, 0, TextureHelper.this.mWidth, TextureHelper.this.mHeight);
                GLES20.glBindTexture(3553, 0);
                GLES20.glBindFramebuffer(36160, 0);
                GLES20.glFinish();
                GlUtil.checkNoGLES2Error("TextureHelper drawTexture");
            }
        });
    }

    public synchronized VideoFrame.I420Buffer textureToYuv(final VideoFrame.TextureBuffer textureBuffer) {
        final VideoFrame.I420Buffer[] i420BufferArr;
        i420BufferArr = new VideoFrame.I420Buffer[1];
        ThreadUtils.invokeAtFrontUninterruptibly(this.mHandler, new Runnable() { // from class: com.ss.bytertc.engine.utils.TextureHelper.3
            @Override // java.lang.Runnable
            public void run() {
                TextureHelper.this.mIsTextureInUse = true;
                if (TextureHelper.this.mYuvConverter == null) {
                    TextureHelper.this.mYuvConverter = new YuvConverter();
                }
                if (TextureHelper.this.mTextureDrawer == null) {
                    TextureHelper.this.mTextureDrawer = new GlRectDrawer();
                }
                i420BufferArr[0] = TextureHelper.this.mYuvConverter.convert(textureBuffer);
                TextureHelper.this.mIsTextureInUse = false;
                if (TextureHelper.this.mIsQuitting) {
                    TextureHelper.this.release();
                }
            }
        });
        return i420BufferArr[0];
    }

    public int dequeueTexture() {
        final int[] iArr = new int[1];
        ThreadUtils.invokeAtFrontUninterruptibly(this.mHandler, new Runnable() { // from class: com.ss.bytertc.engine.utils.TextureHelper$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                TextureHelper.this.m221x29d7440a(iArr);
            }
        });
        return iArr[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$dequeueTexture$3$com-ss-bytertc-engine-utils-TextureHelper */
    public /* synthetic */ void m221x29d7440a(int[] iArr) {
        List<Integer> list = this.mTextureFreeQueue;
        if (list != null) {
            if (list.size() == 0) {
                int generateTexture = generateTexture(3553, this.mWidth, this.mHeight);
                iArr[0] = generateTexture;
                if (generateTexture > 0) {
                    this.mTextureUsedQueue.add(Integer.valueOf(generateTexture));
                    return;
                }
                return;
            }
            iArr[0] = this.mTextureFreeQueue.get(0).intValue();
            this.mTextureFreeQueue.remove(0);
            this.mTextureUsedQueue.add(Integer.valueOf(iArr[0]));
        }
    }

    public void queueTexture(final int textureId) {
        this.mHandler.post(new Runnable() { // from class: com.ss.bytertc.engine.utils.TextureHelper$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                TextureHelper.this.m4174lambda$queueTexture$4$comssbytertcengineutilsTextureHelper(textureId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$queueTexture$4$com-ss-bytertc-engine-utils-TextureHelper, reason: not valid java name */
    public /* synthetic */ void m4174lambda$queueTexture$4$comssbytertcengineutilsTextureHelper(int i) {
        List<Integer> list = this.mTextureUsedQueue;
        if (list == null || !list.contains(Integer.valueOf(i))) {
            return;
        }
        this.mTextureUsedQueue.remove(new Integer(i));
        List<Integer> list2 = this.mTextureFreeQueue;
        if (list2 != null) {
            list2.add(Integer.valueOf(i));
        }
    }

    public void releaseTextureID(final int textureID) {
        if (textureID <= 0 || this.mIsQuitting || this.mIsRelease) {
            return;
        }
        ThreadUtils.invokeAtFrontUninterruptibly(this.mHandler, new Runnable() { // from class: com.ss.bytertc.engine.utils.TextureHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                GLES20.glDeleteTextures(1, new int[]{textureID}, 0);
            }
        });
    }

    private int generateTexture(final int type, final int width, final int height) {
        if (this.mTextureCnt == 45) {
            return 0;
        }
        return ((Integer) ThreadUtils.invokeAtFrontUninterruptibly(this.mHandler, new Callable() { // from class: com.ss.bytertc.engine.utils.TextureHelper$$ExternalSyntheticLambda7
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return TextureHelper.this.m222xc894d8e(type, width, height);
            }
        })).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$generateTexture$6$com-ss-bytertc-engine-utils-TextureHelper */
    public /* synthetic */ Integer m222xc894d8e(int i, int i2, int i3) throws Exception {
        int generateTexture = GlUtil.generateTexture(i);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, generateTexture);
        GLES20.glTexImage2D(3553, 0, 6408, i2, i3, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        if (GLES20.glGetError() != 0) {
            return 0;
        }
        this.mTextureCnt++;
        return Integer.valueOf(generateTexture);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        if (this.mHandler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Wrong thread.");
        }
        if (!this.mIsTextureInUse && this.mIsQuitting) {
            this.mIsRelease = true;
            YuvConverter yuvConverter = this.mYuvConverter;
            if (yuvConverter != null) {
                yuvConverter.release();
            }
            YuvUploader yuvUploader = this.mYuvUploader;
            if (yuvUploader != null) {
                yuvUploader.release();
            }
            List<Integer> list = this.mTextureFreeQueue;
            if (list != null && list.size() > 0) {
                Iterator<Integer> it = this.mTextureFreeQueue.iterator();
                while (it.hasNext()) {
                    GLES20.glDeleteTextures(1, new int[]{it.next().intValue()}, 0);
                }
            }
            this.mTextureFreeQueue.clear();
            List<Integer> list2 = this.mTextureUsedQueue;
            if (list2 != null && list2.size() > 0) {
                Iterator<Integer> it2 = this.mTextureUsedQueue.iterator();
                while (it2.hasNext()) {
                    GLES20.glDeleteTextures(1, new int[]{it2.next().intValue()}, 0);
                }
            }
            this.mTextureUsedQueue.clear();
            GLES20.glDeleteFramebuffers(1, new int[]{this.mFrameBufferId}, 0);
            this.mFrameBufferId = 0;
            this.mEglBase.release();
            this.mHandler.getLooper().quit();
            return;
        }
        throw new IllegalStateException("Unexpected release.");
    }

    public synchronized void dispose() {
        LogUtil.m215d(TAG, "dispose()");
        ThreadUtils.invokeAtFrontUninterruptibly(this.mHandler, new Runnable() { // from class: com.ss.bytertc.engine.utils.TextureHelper$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                TextureHelper.this.m4173lambda$dispose$7$comssbytertcengineutilsTextureHelper();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$dispose$7$com-ss-bytertc-engine-utils-TextureHelper, reason: not valid java name */
    public /* synthetic */ void m4173lambda$dispose$7$comssbytertcengineutilsTextureHelper() {
        this.mIsQuitting = true;
        if (this.mIsTextureInUse) {
            return;
        }
        release();
    }

    public EglBase.Context getEglBaseContext() {
        EglBase eglBase = this.mEglBase;
        if (eglBase != null) {
            return eglBase.getEglBaseContext();
        }
        return null;
    }

    public long getNativeEglContext() {
        EglBase eglBase = this.mEglBase;
        if (eglBase != null) {
            return eglBase.getEglBaseContext().getNativeEglContext();
        }
        return 0L;
    }

    public void post(Runnable run) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(run);
        }
    }
}
