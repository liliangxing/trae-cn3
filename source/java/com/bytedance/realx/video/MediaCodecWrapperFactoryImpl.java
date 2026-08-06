package com.bytedance.realx.video;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
class MediaCodecWrapperFactoryImpl implements MediaCodecWrapperFactory {

    /* loaded from: classes4.dex */
    private static class MediaCodecWrapperImpl implements MediaCodecWrapper {
        private final MediaCodec mediaCodec;

        public MediaCodecWrapperImpl(MediaCodec mediaCodec) {
            this.mediaCodec = mediaCodec;
        }

        @Override // com.bytedance.realx.video.MediaCodecWrapper
        public void configure(MediaFormat format, Surface surface, MediaCrypto crypto, int flags) {
            this.mediaCodec.configure(format, surface, crypto, flags);
        }

        @Override // com.bytedance.realx.video.MediaCodecWrapper
        public void start() {
            this.mediaCodec.start();
        }

        @Override // com.bytedance.realx.video.MediaCodecWrapper
        public void flush() {
            this.mediaCodec.flush();
        }

        @Override // com.bytedance.realx.video.MediaCodecWrapper
        public void stop() {
            this.mediaCodec.stop();
        }

        @Override // com.bytedance.realx.video.MediaCodecWrapper
        public void release() {
            this.mediaCodec.release();
        }

        @Override // com.bytedance.realx.video.MediaCodecWrapper
        public MediaCodecInfo getCodecInfo() {
            return this.mediaCodec.getCodecInfo();
        }

        @Override // com.bytedance.realx.video.MediaCodecWrapper
        public int dequeueInputBuffer(long timeoutUs) {
            return this.mediaCodec.dequeueInputBuffer(timeoutUs);
        }

        @Override // com.bytedance.realx.video.MediaCodecWrapper
        public void queueInputBuffer(int index, int offset, int size, long presentationTimeUs, int flags) {
            this.mediaCodec.queueInputBuffer(index, offset, size, presentationTimeUs, flags);
        }

        @Override // com.bytedance.realx.video.MediaCodecWrapper
        public int dequeueOutputBuffer(MediaCodec.BufferInfo info, long timeoutUs) {
            return this.mediaCodec.dequeueOutputBuffer(info, timeoutUs);
        }

        @Override // com.bytedance.realx.video.MediaCodecWrapper
        public void releaseOutputBuffer(int index, boolean render) {
            this.mediaCodec.releaseOutputBuffer(index, render);
        }

        @Override // com.bytedance.realx.video.MediaCodecWrapper
        public void releaseOutputBuffer(int index, long renderTimestampNs) {
            this.mediaCodec.releaseOutputBuffer(index, renderTimestampNs);
        }

        @Override // com.bytedance.realx.video.MediaCodecWrapper
        public void setOutputSurface(Surface surface) {
            this.mediaCodec.setOutputSurface(surface);
        }

        @Override // com.bytedance.realx.video.MediaCodecWrapper
        public MediaFormat getOutputFormat() {
            return this.mediaCodec.getOutputFormat();
        }

        @Override // com.bytedance.realx.video.MediaCodecWrapper
        public MediaFormat getOutputFormat(int index) {
            return this.mediaCodec.getOutputFormat(index);
        }

        @Override // com.bytedance.realx.video.MediaCodecWrapper
        public ByteBuffer[] getInputBuffers() {
            return this.mediaCodec.getInputBuffers();
        }

        @Override // com.bytedance.realx.video.MediaCodecWrapper
        public ByteBuffer[] getOutputBuffers() {
            return this.mediaCodec.getOutputBuffers();
        }

        @Override // com.bytedance.realx.video.MediaCodecWrapper
        public ByteBuffer getInputBuffer(int index) {
            return this.mediaCodec.getInputBuffer(index);
        }

        @Override // com.bytedance.realx.video.MediaCodecWrapper
        public ByteBuffer getOutputBuffer(int index) {
            return this.mediaCodec.getOutputBuffer(index);
        }

        @Override // com.bytedance.realx.video.MediaCodecWrapper
        public Surface createInputSurface() {
            return this.mediaCodec.createInputSurface();
        }

        @Override // com.bytedance.realx.video.MediaCodecWrapper
        public void setParameters(Bundle params) {
            this.mediaCodec.setParameters(params);
        }

        @Override // com.bytedance.realx.video.MediaCodecWrapper
        public void setCallback(MediaCodec.Callback cb, Handler handler) {
            if (handler == null) {
                this.mediaCodec.setCallback(cb);
            } else {
                this.mediaCodec.setCallback(cb, handler);
            }
        }

        @Override // com.bytedance.realx.video.MediaCodecWrapper
        public MediaCodec getRealCodec() {
            return this.mediaCodec;
        }
    }

    @Override // com.bytedance.realx.video.MediaCodecWrapperFactory
    public MediaCodecWrapper createByCodecName(String name) throws IOException {
        return new MediaCodecWrapperImpl(MediaCodec.createByCodecName(name));
    }
}
