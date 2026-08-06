package com.ss.bytertc.engine.video;

import android.opengl.EGLContext;
import com.ss.bytertc.engine.data.CameraId;
import com.ss.bytertc.engine.data.VideoBufferType;
import com.ss.bytertc.engine.data.VideoContentType;
import com.ss.bytertc.engine.data.VideoPixelFormat;
import com.ss.bytertc.engine.data.VideoRotation;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public interface IVideoFrame {
    void addRef();

    VideoBufferType bufferType();

    CameraId cameraId();

    long captureTimestampMs();

    VideoContentType contentType();

    EGLContext eglContext();

    FovVideoFrameInfo fovTileInfo();

    int height();

    int numberOfPlanes();

    VideoPixelFormat pixelFormat();

    ByteBuffer planeData(int planeIndex);

    int planeStride(int planeIndex);

    long releaseRef();

    VideoRotation rotation();

    ByteBuffer seiData();

    int textureId();

    float[] textureMatrix();

    long timestampUs();

    int width();
}
