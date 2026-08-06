package com.lynx.animax.drawable;

import android.view.View;
import com.lynx.animax.drawable.BitmapBuffer;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public class BitmapBufferGroup {
    private final WeakReference<View> mAttachedView;
    private final ConcurrentLinkedQueue<BitmapBuffer> mBackBitmapBufferQueue;
    private final boolean mEnableSoftwareRendering;
    private final AtomicReference<BitmapBuffer> mFrontBitmapBufferRef;
    private final int mMaxCapacity;

    public BitmapBufferGroup(View view, boolean z) {
        this(view, z, 3);
    }

    public BitmapBufferGroup(View view, boolean z, int i) {
        this.mFrontBitmapBufferRef = new AtomicReference<>();
        this.mAttachedView = new WeakReference<>(view);
        this.mEnableSoftwareRendering = z;
        this.mBackBitmapBufferQueue = new ConcurrentLinkedQueue<>();
        this.mMaxCapacity = i;
    }

    public void onBufferUpdate() {
        BitmapBuffer peek = this.mBackBitmapBufferQueue.peek();
        if (peek == null || peek.getState() != BitmapBuffer.BufferState.Ready) {
            return;
        }
        BitmapBuffer andSet = this.mFrontBitmapBufferRef.getAndSet(peek);
        if (andSet != null) {
            andSet.setState(BitmapBuffer.BufferState.NotReady);
            this.mBackBitmapBufferQueue.offer(andSet);
        }
        if (peek.getState() != BitmapBuffer.BufferState.Ready) {
            if (andSet != null) {
                this.mBackBitmapBufferQueue.remove(andSet);
                andSet.release();
            }
            BitmapBuffer andSet2 = this.mFrontBitmapBufferRef.getAndSet(null);
            if (andSet2 != null) {
                andSet2.release();
                return;
            }
            return;
        }
        this.mBackBitmapBufferQueue.remove(peek);
        View view = this.mAttachedView.get();
        if (view != null) {
            view.postInvalidate();
        }
    }

    public BitmapBuffer getBitmapBufferForOffscreenRendering() {
        return this.mBackBitmapBufferQueue.peek();
    }

    public BitmapBuffer swapBitmapBuffer(BitmapBuffer bitmapBuffer) {
        BitmapBuffer bitmapBuffer2 = this.mFrontBitmapBufferRef.get();
        if (bitmapBuffer2 == null || bitmapBuffer2.getState() != BitmapBuffer.BufferState.Ready) {
            return bitmapBuffer;
        }
        if (bitmapBuffer != null) {
            bitmapBuffer.setState(BitmapBuffer.BufferState.NotReady);
            this.mBackBitmapBufferQueue.offer(bitmapBuffer);
        }
        return this.mFrontBitmapBufferRef.getAndSet(null);
    }

    public void setBufferSize(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        release();
        initBuffers(i, i2);
    }

    private void initBuffers(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        for (int i3 = 0; i3 < this.mMaxCapacity; i3++) {
            this.mBackBitmapBufferQueue.offer(BitmapBuffer.create(i, i2, this.mEnableSoftwareRendering));
        }
    }

    public void release() {
        while (true) {
            BitmapBuffer poll = this.mBackBitmapBufferQueue.poll();
            if (poll == null) {
                break;
            } else {
                poll.release();
            }
        }
        BitmapBuffer andSet = this.mFrontBitmapBufferRef.getAndSet(null);
        if (andSet != null) {
            andSet.release();
        }
    }
}
