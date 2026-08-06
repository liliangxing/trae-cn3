package com.ss.bytertc.engine.video.converter;

import android.graphics.Matrix;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.realx.video.JavaI420Buffer;
import com.bytedance.realx.video.RendererCommon;
import com.bytedance.realx.video.TextureBufferImpl;
import com.bytedance.realx.video.VideoFrame;
import com.bytedance.realx.video.YuvConverter;
import com.ss.bytertc.engine.data.VideoBufferType;
import com.ss.bytertc.engine.data.VideoPixelFormat;
import com.ss.bytertc.engine.utils.ByteBufferUtils;
import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.engine.video.IVideoFrame;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class WebRTCConverter {
    private static final String TAG = "WebRTCConverter";

    public static VideoFrame convertByteTexFrame2WebrtcTexFrame(IVideoFrame byteVideoFrame, Looper textureProcessLooper) {
        VideoFrame.TextureBuffer.Type type;
        if (byteVideoFrame.bufferType() != VideoBufferType.GL_TEXTURE || textureProcessLooper == null) {
            return null;
        }
        Matrix convertMatrixToAndroidGraphicsMatrix = RendererCommon.convertMatrixToAndroidGraphicsMatrix(byteVideoFrame.textureMatrix());
        if (byteVideoFrame.pixelFormat() == VideoPixelFormat.TEXTURE_2D) {
            type = VideoFrame.TextureBuffer.Type.RGB;
        } else {
            type = VideoFrame.TextureBuffer.Type.OES;
        }
        byteVideoFrame.addRef();
        int width = byteVideoFrame.width();
        int height = byteVideoFrame.height();
        int textureId = byteVideoFrame.textureId();
        Handler handler = new Handler(textureProcessLooper);
        YuvConverter yuvConverter = new YuvConverter();
        Objects.requireNonNull(byteVideoFrame);
        return new VideoFrame(new TextureBufferImpl(width, height, type, textureId, convertMatrixToAndroidGraphicsMatrix, handler, yuvConverter, new WebRTCConverter$$ExternalSyntheticLambda0(byteVideoFrame)), byteVideoFrame.rotation().value(), byteVideoFrame.timestampUs());
    }

    public static VideoFrame convertByteI420Frame2WebrtcI420Frame(IVideoFrame byteVideoFrame) {
        if (byteVideoFrame.bufferType() != VideoBufferType.RAW_MEMORY || byteVideoFrame.pixelFormat() != VideoPixelFormat.I420) {
            return null;
        }
        byteVideoFrame.addRef();
        int width = byteVideoFrame.width();
        int height = byteVideoFrame.height();
        ByteBuffer planeData = byteVideoFrame.planeData(0);
        ByteBuffer planeData2 = byteVideoFrame.planeData(1);
        ByteBuffer planeData3 = byteVideoFrame.planeData(2);
        int planeStride = byteVideoFrame.planeStride(0);
        int planeStride2 = byteVideoFrame.planeStride(1);
        int planeStride3 = byteVideoFrame.planeStride(2);
        try {
            Objects.requireNonNull(byteVideoFrame);
            return new VideoFrame(JavaI420Buffer.wrap(width, height, planeData, planeStride, planeData2, planeStride2, planeData3, planeStride3, new WebRTCConverter$$ExternalSyntheticLambda0(byteVideoFrame)), byteVideoFrame.rotation().value(), byteVideoFrame.timestampUs());
        } catch (IllegalArgumentException e) {
            byteVideoFrame.releaseRef();
            LogUtil.m216e(TAG, "Frame convert failed: " + e.getMessage());
            return null;
        }
    }

    public static VideoFrame convertByteRGBAFrame2WebrtcI420Frame(IVideoFrame byteVideoFrame) {
        if (byteVideoFrame.bufferType() != VideoBufferType.RAW_MEMORY || byteVideoFrame.pixelFormat() != VideoPixelFormat.RGBA) {
            return null;
        }
        int width = byteVideoFrame.width();
        int height = byteVideoFrame.height();
        int planeStride = byteVideoFrame.planeStride(0);
        int i = ((width + 63) / 64) * 64;
        int i2 = (((width >> 1) + 63) / 64) * 64;
        ByteBuffer planeData = byteVideoFrame.planeData(0);
        if (planeData == null) {
            return null;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i * height);
        int i3 = ((height + 1) >> 1) * i2;
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(i3);
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(i3);
        ByteBufferUtils.nativeRGBAToI420(planeData, planeStride, allocateDirect, i, allocateDirect2, i2, allocateDirect3, i2, width, height);
        Objects.requireNonNull(byteVideoFrame);
        return new VideoFrame(JavaI420Buffer.wrap(width, height, allocateDirect, i, allocateDirect2, i2, allocateDirect3, i2, new WebRTCConverter$$ExternalSyntheticLambda0(byteVideoFrame)), byteVideoFrame.rotation().value(), byteVideoFrame.timestampUs());
    }
}
