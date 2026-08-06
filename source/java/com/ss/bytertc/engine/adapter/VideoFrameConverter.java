package com.ss.bytertc.engine.adapter;

import com.bytedance.realx.video.JavaI420Buffer;
import com.bytedance.realx.video.VideoFrame;
import com.ss.bytertc.engine.adapter.VideoFrameConverter;
import com.ss.bytertc.engine.mediaio.CountDownLatchI420Buffer;
import com.ss.bytertc.engine.utils.LogUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class VideoFrameConverter {
    private static int MAX_BYTE_BUFFER_POOL_SIZE = 2;
    private static final String TAG = "VideoFrameConverter";
    private int abandonFrameCount;
    private ArrayList<ByteBufferHolder> byteBufferPool;
    private ByteBuffer[] byteBuffers;
    private boolean isBufferDirect;
    final int[] steps;
    final int[] strides;

    public VideoFrameConverter() {
        this(false);
    }

    public VideoFrameConverter(boolean isBufferDirect) {
        this.byteBuffers = new ByteBuffer[3];
        this.strides = new int[3];
        this.steps = new int[2];
        this.byteBufferPool = new ArrayList<>();
        this.abandonFrameCount = 0;
        for (int i = 0; i < MAX_BYTE_BUFFER_POOL_SIZE; i++) {
            this.byteBufferPool.add(new ByteBufferHolder());
        }
        this.isBufferDirect = isBufferDirect;
    }

    public boolean convertRawYUV2ByteHolder(ByteBufferHolder dest, ByteBuffer y, ByteBuffer u, ByteBuffer v, final int ystride, final int ustride, final int vstride, final int width, int height) {
        checkReuseByteBuffer((width * height) + (((width + 1) / 2) * 2 * height), dest);
        return convertRawYUV2ByteBuffer(dest.byteBuffer, y, u, v, ystride, ustride, vstride, width, height);
    }

    private boolean convertRawYUV2ByteBuffer(ByteBuffer dest, ByteBuffer y, ByteBuffer u, ByteBuffer v, final int ystride, final int ustride, final int vstride, final int width, int height) {
        int[] iArr = this.strides;
        iArr[0] = ystride;
        iArr[1] = ustride;
        iArr[2] = vstride;
        int[] iArr2 = this.steps;
        iArr2[0] = width;
        int i = (width + 1) / 2;
        iArr2[1] = i;
        int i2 = (width * height) + (i * 2 * height);
        y.clear();
        u.clear();
        v.clear();
        if (dest == null || i2 > dest.capacity()) {
            return false;
        }
        dest.clear();
        ByteBuffer[] byteBufferArr = this.byteBuffers;
        byteBufferArr[0] = y;
        byteBufferArr[1] = u;
        byteBufferArr[2] = v;
        int i3 = 0;
        while (true) {
            ByteBuffer[] byteBufferArr2 = this.byteBuffers;
            if (i3 < byteBufferArr2.length) {
                ByteBuffer byteBuffer = byteBufferArr2[i3];
                int i4 = this.strides[i3];
                int[] iArr3 = this.steps;
                int i5 = i3 == 0 ? iArr3[0] : iArr3[1];
                int i6 = i4 - i5;
                if (i4 == i5) {
                    dest.put(byteBuffer);
                } else {
                    while (byteBuffer.hasRemaining() && byteBuffer.position() + i5 <= byteBuffer.capacity()) {
                        byteBuffer.limit(byteBuffer.position() + i5);
                        dest.put(byteBuffer);
                        int position = byteBuffer.position() + i6;
                        if (position <= byteBuffer.capacity()) {
                            byteBuffer.limit(byteBuffer.capacity());
                            byteBuffer.position(position);
                        }
                    }
                }
                i3++;
            } else {
                byteBufferArr2[0] = null;
                byteBufferArr2[1] = null;
                byteBufferArr2[2] = null;
                return true;
            }
        }
    }

    private boolean convertRawYUV2ByteArray(byte[] dest, ByteBuffer y, ByteBuffer u, ByteBuffer v, final int ystride, final int ustride, final int vstride, final int width, int height) {
        int[] iArr = this.strides;
        iArr[0] = ystride;
        iArr[1] = ustride;
        iArr[2] = vstride;
        int[] iArr2 = this.steps;
        iArr2[0] = width;
        int i = (width + 1) / 2;
        iArr2[1] = i;
        int i2 = (width * height) + (i * 2 * height);
        y.clear();
        u.clear();
        v.clear();
        if (dest == null || i2 > dest.length) {
            return false;
        }
        ByteBuffer[] byteBufferArr = this.byteBuffers;
        byteBufferArr[0] = y;
        byteBufferArr[1] = u;
        byteBufferArr[2] = v;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            ByteBuffer[] byteBufferArr2 = this.byteBuffers;
            if (i3 < byteBufferArr2.length) {
                ByteBuffer byteBuffer = byteBufferArr2[i3];
                int i5 = this.strides[i3];
                int[] iArr3 = this.steps;
                int i6 = i3 == 0 ? iArr3[0] : iArr3[1];
                int i7 = i5 - i6;
                if (i5 == i6) {
                    int remaining = byteBuffer.remaining();
                    byteBuffer.get(dest, i4, remaining);
                    i4 += remaining;
                } else {
                    while (byteBuffer.hasRemaining() && byteBuffer.position() + i6 <= byteBuffer.capacity()) {
                        byteBuffer.get(dest, i4, i6);
                        i4 += i6;
                        int position = byteBuffer.position() + i7;
                        if (byteBuffer.hasRemaining() && position <= byteBuffer.capacity()) {
                            byteBuffer.position(position);
                        }
                    }
                }
                i3++;
            } else {
                byteBufferArr2[0] = null;
                byteBufferArr2[1] = null;
                byteBufferArr2[2] = null;
                return true;
            }
        }
    }

    public ByteBuffer convertRawYUV2ByteArray(final byte[] y, final byte[] u, final byte[] v, final int ystride, final int ustride, final int vstride, final int width, final int height) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(y.length);
        allocateDirect.order(ByteOrder.nativeOrder());
        allocateDirect.put(y);
        allocateDirect.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(u.length);
        allocateDirect2.order(ByteOrder.nativeOrder());
        allocateDirect2.put(u);
        allocateDirect2.position(0);
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(v.length);
        allocateDirect3.order(ByteOrder.nativeOrder());
        allocateDirect3.put(v);
        allocateDirect3.position(0);
        ByteBuffer allocate = ByteBuffer.allocate((width * height) + (((width + 1) / 2) * 2 * width));
        allocate.clear();
        convertRawYUV2ByteArray(allocate.array(), allocateDirect, allocateDirect2, allocateDirect3, ystride, ustride, vstride, width, height);
        return allocate;
    }

    public ByteBufferHolder convert2YUV(VideoFrame frame) {
        ByteBufferHolder pendingBuffer = getPendingBuffer();
        if (pendingBuffer == null) {
            return null;
        }
        int width = frame.getBuffer().getWidth();
        int height = frame.getBuffer().getHeight();
        I420BufferWrapper i420BufferWrapper = new I420BufferWrapper(frame);
        VideoFrame.I420Buffer buffer = i420BufferWrapper.getBuffer();
        boolean convertRawYUV2ByteHolder = convertRawYUV2ByteHolder(pendingBuffer, buffer.getDataY(), buffer.getDataU(), buffer.getDataV(), buffer.getStrideY(), buffer.getStrideU(), buffer.getStrideV(), width, height);
        i420BufferWrapper.release();
        if (convertRawYUV2ByteHolder) {
            return pendingBuffer;
        }
        return null;
    }

    public VideoFrame.I420Buffer convertToJavaI420Buffer(ByteBuffer data, int width, int height, boolean useCountDownLatchI420Buffer) {
        if (data == null) {
            return null;
        }
        final ByteBufferHolder pendingBuffer = getPendingBuffer();
        if (pendingBuffer == null) {
            int i = this.abandonFrameCount + 1;
            this.abandonFrameCount = i;
            if (i >= 60) {
                LogUtil.m216e(TAG, "drop frame > 60 !!! please check Buffer for release");
                this.abandonFrameCount = 0;
            }
            return null;
        }
        this.abandonFrameCount = 0;
        int i2 = (height + 1) / 2;
        int i3 = (width + 1) / 2;
        int i4 = width * height;
        int i5 = (i3 * 2 * i2) + i4;
        checkReuseByteBuffer(i5, pendingBuffer);
        ByteBuffer byteBuffer = pendingBuffer.getByteBuffer();
        data.position(0);
        byteBuffer.position(0);
        if (data.limit() > i5) {
            data.limit(i5);
        }
        byteBuffer.limit(i5);
        byteBuffer.put(data);
        int i6 = i4 + 0;
        int i7 = i2 * i3;
        int i8 = i6 + i7;
        byteBuffer.position(0);
        byteBuffer.limit(i6);
        ByteBuffer slice = byteBuffer.slice();
        byteBuffer.position(i6);
        byteBuffer.limit(i8);
        ByteBuffer slice2 = byteBuffer.slice();
        byteBuffer.position(i8);
        byteBuffer.limit(i8 + i7);
        ByteBuffer slice3 = byteBuffer.slice();
        if (useCountDownLatchI420Buffer) {
            return CountDownLatchI420Buffer.wrap(width, height, slice, width, slice2, i3, slice3, i3, new Runnable() { // from class: com.ss.bytertc.engine.adapter.VideoFrameConverter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    VideoFrameConverter.ByteBufferHolder.this.setPending(false);
                }
            });
        }
        return JavaI420Buffer.wrap(width, height, slice, width, slice2, i3, slice3, i3, new Runnable() { // from class: com.ss.bytertc.engine.adapter.VideoFrameConverter$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                VideoFrameConverter.ByteBufferHolder.this.setPending(false);
            }
        });
    }

    public VideoFrame.I420Buffer convertToJavaI420Buffer(byte[] data, int width, int height, boolean useCountDownLatchI420Buffer) {
        if (data == null) {
            return null;
        }
        final ByteBufferHolder pendingBuffer = getPendingBuffer();
        if (pendingBuffer == null) {
            int i = this.abandonFrameCount + 1;
            this.abandonFrameCount = i;
            if (i >= 60) {
                LogUtil.m216e(TAG, "drop frame > 60 !!! please check Buffer for release ");
                this.abandonFrameCount = 0;
            }
            return null;
        }
        this.abandonFrameCount = 0;
        int i2 = (height + 1) / 2;
        int i3 = (width + 1) / 2;
        int i4 = width * height;
        int i5 = (i3 * 2 * i2) + i4;
        checkReuseByteBuffer(i5, pendingBuffer);
        ByteBuffer byteBuffer = pendingBuffer.getByteBuffer();
        byteBuffer.position(0);
        byteBuffer.limit(i5);
        byteBuffer.put(data, 0, Math.min(data.length, i5));
        int i6 = i4 + 0;
        int i7 = i2 * i3;
        int i8 = i6 + i7;
        byteBuffer.position(0);
        byteBuffer.limit(i6);
        ByteBuffer slice = byteBuffer.slice();
        byteBuffer.position(i6);
        byteBuffer.limit(i8);
        ByteBuffer slice2 = byteBuffer.slice();
        byteBuffer.position(i8);
        byteBuffer.limit(i8 + i7);
        ByteBuffer slice3 = byteBuffer.slice();
        if (useCountDownLatchI420Buffer) {
            return CountDownLatchI420Buffer.wrap(width, height, slice, width, slice2, i3, slice3, i3, new Runnable() { // from class: com.ss.bytertc.engine.adapter.VideoFrameConverter$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    VideoFrameConverter.ByteBufferHolder.this.setPending(false);
                }
            });
        }
        return JavaI420Buffer.wrap(width, height, slice, width, slice2, i3, slice3, i3, new Runnable() { // from class: com.ss.bytertc.engine.adapter.VideoFrameConverter$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                VideoFrameConverter.ByteBufferHolder.this.setPending(false);
            }
        });
    }

    public void checkReuseByteBuffer(int minCap, ByteBufferHolder holder) {
        ByteBuffer allocate;
        if (holder.getByteBuffer() == null || holder.getByteBuffer().capacity() < minCap) {
            if (this.isBufferDirect) {
                allocate = ByteBuffer.allocateDirect(minCap);
            } else {
                allocate = ByteBuffer.allocate(minCap);
            }
            allocate.order(ByteOrder.nativeOrder());
            holder.setByteBuffer(allocate);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class I420BufferWrapper {
        private VideoFrame.I420Buffer i420Buffer;
        private boolean needManualRelease;

        public I420BufferWrapper(VideoFrame frame) {
            if (frame.getBuffer() instanceof JavaI420Buffer) {
                this.i420Buffer = frame.getBuffer();
                this.needManualRelease = false;
            } else {
                this.i420Buffer = frame.getBuffer().toI420();
                this.needManualRelease = true;
                frame.getBuffer().release();
            }
        }

        public VideoFrame.I420Buffer getBuffer() {
            return this.i420Buffer;
        }

        public void release() {
            VideoFrame.I420Buffer i420Buffer = this.i420Buffer;
            if ((i420Buffer instanceof JavaI420Buffer) && this.needManualRelease) {
                i420Buffer.release();
            }
        }
    }

    private ByteBufferHolder getPendingBuffer() {
        Iterator<ByteBufferHolder> it = this.byteBufferPool.iterator();
        while (it.hasNext()) {
            ByteBufferHolder next = it.next();
            if (!next.isPending) {
                next.setPending(true);
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class ByteBufferHolder {
        private ByteBuffer byteBuffer;
        private volatile boolean isPending = false;

        protected ByteBufferHolder() {
        }

        public boolean isPending() {
            return this.isPending;
        }

        public void setPending(boolean pending) {
            this.isPending = pending;
        }

        public ByteBuffer getByteBuffer() {
            ByteBuffer byteBuffer = this.byteBuffer;
            if (byteBuffer != null) {
                byteBuffer.clear();
            }
            return this.byteBuffer;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setByteBuffer(ByteBuffer buffer) {
            this.byteBuffer = buffer;
        }

        public byte[] getArray() {
            ByteBuffer byteBuffer = this.byteBuffer;
            if (byteBuffer == null) {
                return null;
            }
            byteBuffer.clear();
            if (this.byteBuffer.hasArray() && this.byteBuffer.arrayOffset() == 0) {
                return this.byteBuffer.array();
            }
            int remaining = this.byteBuffer.remaining();
            byte[] bArr = new byte[remaining];
            this.byteBuffer.get(bArr, 0, remaining);
            return bArr;
        }
    }
}
