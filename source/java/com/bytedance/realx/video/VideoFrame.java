package com.bytedance.realx.video;

import android.graphics.Matrix;
import android.opengl.EGLContext;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.base.RefCounted;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class VideoFrame implements RefCounted {
    private final Buffer buffer;
    private int colorSpace;
    private final ByteBuffer extendedData;
    private boolean isFlip;
    private int iso;
    private final int rotation;
    private final long timestampNs;

    /* loaded from: classes4.dex */
    public interface I420Buffer extends Buffer {
        @Override // com.bytedance.realx.video.VideoFrame.Buffer
        default int getBufferType() {
            return 3;
        }

        ByteBuffer getDataU();

        ByteBuffer getDataV();

        ByteBuffer getDataY();

        int getStrideU();

        int getStrideV();

        int getStrideY();
    }

    /* loaded from: classes4.dex */
    public interface NV12Buffer extends Buffer {
        @Override // com.bytedance.realx.video.VideoFrame.Buffer
        default int getBufferType() {
            return 1;
        }

        ByteBuffer getDataUV();

        ByteBuffer getDataY();

        int getStrideUV();

        int getStrideY();
    }

    /* loaded from: classes4.dex */
    public interface Buffer extends RefCounted {

        /* loaded from: classes4.dex */
        public interface BufferType {
            public static final int I420 = 3;
            public static final int Null = 0;
            public static final int Nv12 = 1;
            public static final int Nv21 = 2;
            public static final int RGBA = 5;
            public static final int Texture = 4;
        }

        Buffer copyData();

        Buffer cropAndScale(int cropX, int cropY, int cropWidth, int cropHeight, int scaleWidth, int scaleHeight);

        int getBufferType();

        int getHeight();

        int getWidth();

        @Override // com.bytedance.realx.base.RefCounted
        void release();

        @Override // com.bytedance.realx.base.RefCounted
        void retain();

        Buffer scaleAndFill(int dstWidth, int dstHeight, int offsetX, int offsetY);

        I420Buffer toI420();

        default NV12Buffer toNV12() {
            RXLogging.e("VideoFrame", "toNV12 has not been implemented, default return null");
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public interface TextureBuffer extends Buffer {
        Buffer cropAndScaleWithFilter(int cropX, int cropY, int cropWidth, int cropHeight, int scaleWidth, int scaleHeight, int scaleFilter);

        @Override // com.bytedance.realx.video.VideoFrame.Buffer
        default int getBufferType() {
            return 4;
        }

        EGLContext getEglContext();

        long getNativeEglContext();

        FilterType getScaleFilter();

        int getTextureId();

        Matrix getTransformMatrix();

        Type getType();

        int getTypeGlTarget();

        int getUnscaledHeight();

        int getUnscaledWidth();

        float[] nativeGetTransFormMatrix();

        /* loaded from: classes4.dex */
        public enum Type {
            OES(36197),
            RGB(3553);

            private final int glTarget;

            Type(final int glTarget) {
                this.glTarget = glTarget;
            }

            public int getGlTarget() {
                return this.glTarget;
            }
        }
    }

    /* loaded from: classes4.dex */
    public enum ColorSpace {
        kUnknown(0),
        kYCbCrBT601LimitedRange(1),
        kYCbCrBT601FullRange(2),
        kYCbCrBT709LimitedRange(3),
        kYCbCrBT709FullRange(4);

        private int colorSpace;

        ColorSpace(int colorSpace) {
            this.colorSpace = colorSpace;
        }

        public int getColorSpace() {
            return this.colorSpace;
        }
    }

    public VideoFrame(Buffer buffer, int rotation, long timestampNs) {
        this(buffer, (ByteBuffer) null, rotation, timestampNs);
    }

    public VideoFrame(Buffer buffer, int rotation, long timestampNs, boolean isFlip) {
        this.isFlip = false;
        this.colorSpace = 0;
        this.iso = -1;
        if (buffer == null) {
            throw new IllegalArgumentException("buffer not allowed to be null");
        }
        if (rotation % 90 != 0) {
            throw new IllegalArgumentException("rotation must be a multiple of 90");
        }
        this.buffer = buffer;
        this.rotation = rotation;
        this.timestampNs = timestampNs;
        this.extendedData = null;
        this.isFlip = isFlip;
    }

    public VideoFrame(Buffer buffer, ByteBuffer extendedData, int rotation, long timestampNs) {
        this.isFlip = false;
        this.colorSpace = 0;
        this.iso = -1;
        if (buffer == null) {
            throw new IllegalArgumentException("buffer not allowed to be null");
        }
        if (rotation % 90 != 0) {
            throw new IllegalArgumentException("rotation must be a multiple of 90");
        }
        this.buffer = buffer;
        this.rotation = rotation;
        this.timestampNs = timestampNs;
        this.extendedData = extendedData;
    }

    public VideoFrame(Buffer buffer, ByteBuffer extendedData, int rotation, long timestampNs, boolean isFlip) {
        this.isFlip = false;
        this.colorSpace = 0;
        this.iso = -1;
        if (buffer == null) {
            throw new IllegalArgumentException("buffer not allowed to be null");
        }
        if (rotation % 90 != 0) {
            throw new IllegalArgumentException("rotation must be a multiple of 90");
        }
        this.buffer = buffer;
        this.rotation = rotation;
        this.timestampNs = timestampNs;
        this.extendedData = extendedData;
        this.isFlip = isFlip;
    }

    public VideoFrame(Buffer buffer, ByteBuffer extendedData, int rotation, long timestampNs, boolean isFlip, int colorSpace) {
        this.isFlip = false;
        this.colorSpace = 0;
        this.iso = -1;
        if (buffer == null) {
            throw new IllegalArgumentException("buffer not allowed to be null");
        }
        if (rotation % 90 != 0) {
            throw new IllegalArgumentException("rotation must be a multiple of 90");
        }
        this.buffer = buffer;
        this.rotation = rotation;
        this.timestampNs = timestampNs;
        this.extendedData = extendedData;
        this.isFlip = isFlip;
        this.colorSpace = colorSpace;
    }

    public Buffer getBuffer() {
        return this.buffer;
    }

    public ByteBuffer getExtendedData() {
        return this.extendedData;
    }

    public int getRotation() {
        return this.rotation;
    }

    public int getColorSpace() {
        return this.colorSpace;
    }

    public long getTimestampNs() {
        return this.timestampNs;
    }

    public boolean getFlipState() {
        return this.isFlip;
    }

    public void setFlipState(boolean flip) {
        this.isFlip = flip;
    }

    public static ByteBuffer allocateDirectByteBuffer(int capacity) {
        return ByteBuffer.allocateDirect(capacity);
    }

    public int getRotatedWidth() {
        if (this.rotation % 180 == 0) {
            return this.buffer.getWidth();
        }
        return this.buffer.getHeight();
    }

    public int getRotatedHeight() {
        if (this.rotation % 180 == 0) {
            return this.buffer.getHeight();
        }
        return this.buffer.getWidth();
    }

    @Override // com.bytedance.realx.base.RefCounted
    public void retain() {
        this.buffer.retain();
    }

    @Override // com.bytedance.realx.base.RefCounted
    public void release() {
        this.buffer.release();
    }

    public void setIso(int iso) {
        this.iso = iso;
    }

    public int getIso() {
        return this.iso;
    }
}
