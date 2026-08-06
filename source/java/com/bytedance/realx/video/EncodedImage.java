package com.bytedance.realx.video;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class EncodedImage {
    public final int actualHeight;
    public final int actualWidth;
    public final ByteBuffer buffer;
    public final long captureTimeMs;
    public final long captureTimeNs;
    public final boolean completeFrame;
    public final long compositionTimeUs;
    public final int encodedHeight;
    public final int encodedWidth;
    public final FrameType frameType;
    public final Integer qp;
    public final int rotation;
    public final int svcLayerNum;

    /* loaded from: classes4.dex */
    public enum FrameType {
        kUnknow(0),
        kIntra(1),
        kPredicted(2),
        kBiPredicted(3),
        kEmpty(4),
        kLtrRecovery(5);

        private final int nativeIndex;

        FrameType(int nativeIndex) {
            this.nativeIndex = nativeIndex;
        }

        public int getNative() {
            return this.nativeIndex;
        }

        static FrameType fromNativeIndex(int nativeIndex) {
            for (FrameType frameType : values()) {
                if (frameType.getNative() == nativeIndex) {
                    return frameType;
                }
            }
            throw new IllegalArgumentException("Unknown native frame type: " + nativeIndex);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static FrameType valueOf(int value) {
            for (FrameType frameType : values()) {
                if (frameType.nativeIndex == value) {
                    return frameType;
                }
            }
            return kUnknow;
        }
    }

    private EncodedImage(ByteBuffer buffer, int encodedWidth, int encodedHeight, int actualWidth, int actualHeight, long captureTimeNs, FrameType frameType, int rotation, boolean completeFrame, Integer qp, int svcLayerNum, long compositionTimeUs) {
        this.buffer = buffer;
        this.encodedWidth = encodedWidth;
        this.encodedHeight = encodedHeight;
        this.actualWidth = actualWidth;
        this.actualHeight = actualHeight;
        this.captureTimeMs = TimeUnit.NANOSECONDS.toMillis(captureTimeNs);
        this.captureTimeNs = captureTimeNs;
        this.frameType = frameType;
        this.rotation = rotation;
        this.completeFrame = completeFrame;
        this.qp = qp;
        this.svcLayerNum = svcLayerNum;
        this.compositionTimeUs = compositionTimeUs;
    }

    private ByteBuffer getBuffer() {
        return this.buffer;
    }

    private int getEncodedWidth() {
        return this.encodedWidth;
    }

    private int getEncodedHeight() {
        return this.encodedHeight;
    }

    private long getCaptureTimeNs() {
        return this.captureTimeNs;
    }

    private int getFrameType() {
        return this.frameType.getNative();
    }

    private int getRotation() {
        return this.rotation;
    }

    private boolean getCompleteFrame() {
        return this.completeFrame;
    }

    private Integer getQp() {
        return this.qp;
    }

    private int getSvcLayerNum() {
        return this.svcLayerNum;
    }

    private long getCompositionTimeUs() {
        return this.compositionTimeUs;
    }

    public static Builder builder() {
        return new Builder();
    }

    /* loaded from: classes4.dex */
    public static class Builder {
        private int actualHeight;
        private int actualWidth;
        private ByteBuffer buffer;
        private long captureTimeNs;
        private boolean completeFrame;
        private long compositionTimeUs;
        private int encodedHeight;
        private int encodedWidth;
        private FrameType frameType;
        private Integer qp;
        private int rotation;
        private int svcLayerNum;

        private Builder() {
            this.qp = -1;
        }

        public Builder setBuffer(ByteBuffer buffer) {
            this.buffer = buffer;
            return this;
        }

        public Builder setEncodedWidth(int encodedWidth) {
            this.encodedWidth = encodedWidth;
            return this;
        }

        public Builder setEncodedHeight(int encodedHeight) {
            this.encodedHeight = encodedHeight;
            return this;
        }

        public Builder setActualWidth(int actualWidth) {
            this.actualWidth = actualWidth;
            return this;
        }

        public Builder setActualHeight(int actualHeight) {
            this.actualHeight = actualHeight;
            return this;
        }

        @Deprecated
        public Builder setCaptureTimeMs(long captureTimeMs) {
            this.captureTimeNs = TimeUnit.MILLISECONDS.toNanos(captureTimeMs);
            return this;
        }

        public Builder setCaptureTimeNs(long captureTimeNs) {
            this.captureTimeNs = captureTimeNs;
            return this;
        }

        public Builder setFrameType(FrameType frameType) {
            this.frameType = frameType;
            return this;
        }

        public Builder setRotation(int rotation) {
            this.rotation = rotation;
            return this;
        }

        public Builder setCompleteFrame(boolean completeFrame) {
            this.completeFrame = completeFrame;
            return this;
        }

        public Builder setQp(Integer qp) {
            this.qp = qp;
            return this;
        }

        public Builder setSvcLayerNum(int svcLayerNum) {
            this.svcLayerNum = svcLayerNum;
            return this;
        }

        public Builder setCompositionTimeUs(long compositionTimeUs) {
            this.compositionTimeUs = compositionTimeUs;
            return this;
        }

        public EncodedImage createEncodedImage() {
            return new EncodedImage(this.buffer, this.encodedWidth, this.encodedHeight, this.actualWidth, this.actualHeight, this.captureTimeNs, this.frameType, this.rotation, this.completeFrame, this.qp, this.svcLayerNum, this.compositionTimeUs);
        }
    }
}
