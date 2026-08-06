package com.ss.bytertc.engine.utils;

import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.GlShader;
import com.bytedance.realx.video.GlUtil;
import com.bytedance.realx.video.VideoFrame;
import java.nio.FloatBuffer;
import java.util.concurrent.Callable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class GLHepler {
    private static final FloatBuffer DEVICE_RECTANGLE = GlUtil.createFloatBuffer(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
    private static final FloatBuffer TEXTURE_RECTANGLE = GlUtil.createFloatBuffer(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
    private final String TAG;
    private int frameBufferId;
    private Handler handler;
    private boolean mBInit;
    private EglBase mEglBase;
    private final String mFragmentShader;
    private GlShader mGlShader;
    private final String mVertorShader;
    private boolean released;
    private GlShader shader;
    private VideoFrame.TextureBuffer.Type shaderTextureType;
    private final ThreadUtils.ThreadChecker threadChecker;

    public static GLHepler create(final String threadName, final EGLContext eglContext) {
        HandlerThread handlerThread = new HandlerThread(threadName);
        handlerThread.start();
        final Handler handler = new Handler(handlerThread.getLooper());
        return (GLHepler) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<GLHepler>() { // from class: com.ss.bytertc.engine.utils.GLHepler.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public GLHepler call() {
                try {
                    return new GLHepler(eglContext, handler);
                } catch (RuntimeException e) {
                    LogUtil.m217e("TextureHelper", threadName + " create failure", e);
                    return null;
                }
            }
        });
    }

    private GLHepler(EGLContext eglContext, Handler handler) {
        this.TAG = "GLHepler";
        this.mBInit = false;
        this.frameBufferId = 0;
        this.mVertorShader = "attribute vec4 vPosition;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){gl_Position = vPosition;\ntextureCoordinate = inputTextureCoordinate;\n}\n";
        this.mFragmentShader = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 textureCoordinate;\nuniform samplerExternalOES s_texture;\nvoid main() {  gl_FragColor = texture2D( s_texture, textureCoordinate );\n}";
        ThreadUtils.ThreadChecker threadChecker = new ThreadUtils.ThreadChecker();
        this.threadChecker = threadChecker;
        this.released = false;
        this.handler = handler;
        EglBase createEgl14 = EglBase.createEgl14(eglContext, EglBase.CONFIG_PIXEL_BUFFER);
        this.mEglBase = createEgl14;
        try {
            createEgl14.createDummyPbufferSurface();
            this.mEglBase.makeCurrent();
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            this.frameBufferId = iArr[0];
            threadChecker.detachThread();
        } catch (RuntimeException e) {
            this.mEglBase.release();
            handler.getLooper().quit();
            throw e;
        }
    }

    private void initShader(VideoFrame.TextureBuffer.Type textureType) {
        GlShader glShader = this.shader;
        if (glShader != null) {
            glShader.release();
        }
        if (this.mBInit) {
            return;
        }
        this.mBInit = true;
        this.shaderTextureType = textureType;
        GlShader glShader2 = new GlShader("attribute vec4 vPosition;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){gl_Position = vPosition;\ntextureCoordinate = inputTextureCoordinate;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 textureCoordinate;\nuniform samplerExternalOES s_texture;\nvoid main() {  gl_FragColor = texture2D( s_texture, textureCoordinate );\n}");
        this.shader = glShader2;
        glShader2.useProgram();
        GLES20.glUniform1i(this.shader.getUniformLocation("s_texture"), 0);
        GlUtil.checkNoGLES2Error("Initialize fragment shader uniform values.");
        this.shader.setVertexAttribArray("vPosition", 2, DEVICE_RECTANGLE);
        this.shader.setVertexAttribArray("inputTextureCoordinate", 2, TEXTURE_RECTANGLE);
    }

    public void deliverToTexture2D(final int width, final int height, final int srcTextureId, final int dstTextureId, float[] transformMatrix) {
        ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new Runnable() { // from class: com.ss.bytertc.engine.utils.GLHepler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                GLHepler.this.m4172lambda$deliverToTexture2D$0$comssbytertcengineutilsGLHepler(dstTextureId, srcTextureId, width, height);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$deliverToTexture2D$0$com-ss-bytertc-engine-utils-GLHepler, reason: not valid java name */
    public /* synthetic */ void m4172lambda$deliverToTexture2D$0$comssbytertcengineutilsGLHepler(int i, int i2, int i3, int i4) {
        long currentTimeMillis = System.currentTimeMillis();
        this.threadChecker.checkIsOnValidThread();
        if (this.released) {
            throw new IllegalStateException("YuvConverter.convert called on released object");
        }
        if (!this.mBInit) {
            initShader(VideoFrame.TextureBuffer.Type.OES);
            this.shader.useProgram();
            GLES20.glBindFramebuffer(36160, this.frameBufferId);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
        }
        this.shader.useProgram();
        GLES20.glBindFramebuffer(36160, this.frameBufferId);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i2);
        GLES20.glViewport(0, 0, i3, i4);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(36197, 0);
        LogUtil.m218i("opnngl ToTexture2D", "usetime:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void release() {
        this.threadChecker.checkIsOnValidThread();
        this.released = true;
        GlShader glShader = this.shader;
        if (glShader != null) {
            glShader.release();
        }
    }
}
