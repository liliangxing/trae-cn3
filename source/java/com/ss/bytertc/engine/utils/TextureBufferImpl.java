package com.ss.bytertc.engine.utils;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.opengl.EGLContext;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.FilterType;
import com.bytedance.realx.video.RendererCommon;
import com.bytedance.realx.video.VideoFrame;
import com.ss.bytertc.engine.video.ITextureBuffer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TextureBufferImpl implements VideoFrame.TextureBuffer, EglContextCarrier, ITextureBuffer {
    private final int height;

    /* renamed from: id */
    private final int f130id;
    private EglBase.Context mEglBaseContext;
    private int refCount;
    private final Object refCountLock;
    private final Runnable releaseCallback;
    private FilterType scaleFilter;
    private final TextureHelper textureHelper;
    private final Matrix transformMatrix;
    private final VideoFrame.TextureBuffer.Type type;
    private final int width;
    private YuvImage yuvImage;

    public TextureBufferImpl(int width, int height, VideoFrame.TextureBuffer.Type type, int id, Matrix transformMatrix, TextureHelper textureHelper, Runnable releaseCallback) {
        this.refCountLock = new Object();
        this.width = width;
        this.height = height;
        this.type = type;
        this.f130id = id;
        this.transformMatrix = transformMatrix;
        this.textureHelper = textureHelper;
        this.releaseCallback = releaseCallback;
        this.refCount = 1;
    }

    public TextureBufferImpl(int width, int height, int type, final int id, final TextureHelper textureHelper) {
        this.refCountLock = new Object();
        this.width = width;
        this.height = height;
        if (type == VideoFrame.TextureBuffer.Type.OES.getGlTarget()) {
            this.type = VideoFrame.TextureBuffer.Type.OES;
        } else {
            this.type = VideoFrame.TextureBuffer.Type.RGB;
        }
        this.f130id = id;
        Matrix matrix = new Matrix();
        this.transformMatrix = matrix;
        matrix.reset();
        this.textureHelper = textureHelper;
        this.releaseCallback = new Runnable() { // from class: com.ss.bytertc.engine.utils.TextureBufferImpl.1
            @Override // java.lang.Runnable
            public void run() {
                textureHelper.releaseTextureID(id);
            }
        };
        this.refCount = 1;
    }

    public VideoFrame.TextureBuffer.Type getType() {
        return this.type;
    }

    @Override // com.ss.bytertc.engine.video.ITextureBuffer
    public int getTypeGlTarget() {
        return this.type.getGlTarget();
    }

    @Override // com.ss.bytertc.engine.video.ITextureBuffer
    public int getTextureId() {
        return this.f130id;
    }

    public long getNativeEglContext() {
        TextureHelper textureHelper = this.textureHelper;
        if (textureHelper != null) {
            return textureHelper.getNativeEglContext();
        }
        return 0L;
    }

    public EGLContext getEglContext() {
        TextureHelper textureHelper = this.textureHelper;
        if (textureHelper != null) {
            return textureHelper.getEglBaseContext().getEgl14Context();
        }
        return null;
    }

    public Matrix getTransformMatrix() {
        return this.transformMatrix;
    }

    @Override // com.ss.bytertc.engine.video.ITextureBuffer
    public float[] nativeGetTransFormMatrix() {
        return RendererCommon.convertMatrixFromAndroidGraphicsMatrix(this.transformMatrix);
    }

    public void setTransFormMatrix(float[] matrix) {
        RendererCommon.convertMatrixToAndroidGraphicsMatrix(matrix);
    }

    public TextureHelper getTextureHelper() {
        return this.textureHelper;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public FilterType getScaleFilter() {
        return FilterType.Origin;
    }

    public int getUnscaledWidth() {
        return this.width;
    }

    public int getUnscaledHeight() {
        return this.height;
    }

    public VideoFrame.I420Buffer toI420() {
        return this.textureHelper.textureToYuv(this);
    }

    @Override // com.ss.bytertc.engine.video.ITextureBuffer
    public void retain() {
        synchronized (this.refCountLock) {
            this.refCount++;
        }
    }

    @Override // com.ss.bytertc.engine.video.ITextureBuffer
    public void release() {
        Runnable runnable;
        synchronized (this.refCountLock) {
            int i = this.refCount - 1;
            this.refCount = i;
            if (i == 0 && (runnable = this.releaseCallback) != null) {
                runnable.run();
            }
        }
    }

    public VideoFrame.Buffer copyData() {
        int i;
        final int dequeueTexture = this.textureHelper.dequeueTexture();
        if (dequeueTexture == 0) {
            return null;
        }
        if (this.type == VideoFrame.TextureBuffer.Type.RGB) {
            i = 10;
        } else {
            if (this.type != VideoFrame.TextureBuffer.Type.OES) {
                return null;
            }
            i = 11;
        }
        this.textureHelper.drawTexture(i, this.f130id, dequeueTexture);
        return new TextureBufferImpl(this.width, this.height, this.type, this.f130id, this.transformMatrix, this.textureHelper, new Runnable() { // from class: com.ss.bytertc.engine.utils.TextureBufferImpl.2
            @Override // java.lang.Runnable
            public void run() {
                TextureBufferImpl.this.textureHelper.queueTexture(dequeueTexture);
            }
        });
    }

    public VideoFrame.Buffer cropAndScale(int cropX, int cropY, int cropWidth, int cropHeight, int scaleWidth, int scaleHeight) {
        retain();
        Matrix matrix = new Matrix();
        matrix.preTranslate(cropX / this.width, (r1 - (cropY + cropHeight)) / this.height);
        matrix.preScale(cropWidth / this.width, cropHeight / this.height);
        this.scaleFilter = null;
        Matrix matrix2 = new Matrix(this.transformMatrix);
        matrix2.preConcat(matrix);
        return new TextureBufferImpl(scaleWidth, scaleHeight, this.type, this.f130id, matrix2, this.textureHelper, new Runnable() { // from class: com.ss.bytertc.engine.utils.TextureBufferImpl.3
            @Override // java.lang.Runnable
            public void run() {
                TextureBufferImpl.this.release();
            }
        });
    }

    public VideoFrame.Buffer cropAndScaleWithFilter(int cropX, int cropY, int cropWidth, int cropHeight, int scaleWidth, int scaleHeight, int scaleFilter) {
        Matrix matrix = new Matrix();
        matrix.preTranslate(cropX / this.width, (r3 - (cropY + cropHeight)) / this.height);
        matrix.preScale(cropWidth / this.width, cropHeight / this.height);
        this.scaleFilter = FilterType.fromValue(scaleFilter);
        Matrix matrix2 = new Matrix(this.transformMatrix);
        matrix2.preConcat(matrix);
        return new TextureBufferImpl(scaleWidth, scaleHeight, this.type, this.f130id, matrix2, this.textureHelper, new Runnable() { // from class: com.ss.bytertc.engine.utils.TextureBufferImpl.4
            @Override // java.lang.Runnable
            public void run() {
                TextureBufferImpl.this.release();
            }
        });
    }

    public VideoFrame.Buffer scaleAndFill(int dstWidth, int dstHeight, int offsetX, int offsetY) {
        Matrix matrix = new Matrix();
        matrix.preScale(Math.min(dstWidth, (getWidth() * dstHeight) / getHeight()) / getWidth(), Math.min(dstHeight, (getHeight() * dstWidth) / getWidth()) / getHeight());
        matrix.preTranslate(offsetX / dstWidth, (dstHeight - (offsetY + r1)) / dstHeight);
        return new TextureBufferImpl(dstWidth, dstHeight, this.type, this.f130id, matrix, this.textureHelper, new Runnable() { // from class: com.ss.bytertc.engine.utils.TextureBufferImpl.5
            @Override // java.lang.Runnable
            public void run() {
                TextureBufferImpl.this.release();
            }
        });
    }

    public void saveMyBitmap(String filePath, byte[] data, int width, int high) {
        FileOutputStream fileOutputStream;
        LogUtil.m218i("texturebuffer", "saveMyBitmap");
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fileOutputStream = null;
        }
        try {
            new YuvImage(data, 17, this.width, this.height, null).compressToJpeg(new Rect(0, 0, this.width, this.height), 50, fileOutputStream);
        } catch (Exception unused2) {
        }
        try {
            fileOutputStream.flush();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            fileOutputStream.close();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    @Override // com.ss.bytertc.engine.utils.EglContextCarrier
    public void setEglBaseContext(EglBase.Context context) {
        this.mEglBaseContext = context;
    }

    @Override // com.ss.bytertc.engine.utils.EglContextCarrier
    public EglBase.Context getEglBaseContext() {
        return this.mEglBaseContext;
    }
}
