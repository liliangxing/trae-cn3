package com.bytedance.realx.video;

import android.opengl.EGLContext;
import com.bytedance.realx.video.memory.RefObject;

/* loaded from: classes4.dex */
public class RXVideoFrameHelper implements RXVideoFrameHelperInterface {
    protected long nativeHandle;
    RefObject refCounted = new RefObject(new Runnable() { // from class: com.bytedance.realx.video.RXVideoFrameHelper$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            RXVideoFrameHelper.this.m7848lambda$new$0$combytedancerealxvideoRXVideoFrameHelper();
        }
    });

    private static native long nativeCreateRXVideoFrameHelperOpenGL(long nativeEGLContext);

    private static native void nativeReleaseVideoFrameHelper(long nativeHandle);

    public static RXVideoFrameHelperInterface createRXVideoFrameHelperOpenGL(EGLContext egl14Context) {
        return new RXVideoFrameHelper(nativeCreateRXVideoFrameHelperOpenGL(EglBaseUtils.getNativeEGLContext(egl14Context)));
    }

    private RXVideoFrameHelper(long nativeHandle) {
        this.nativeHandle = nativeHandle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-bytedance-realx-video-RXVideoFrameHelper, reason: not valid java name */
    public /* synthetic */ void m7848lambda$new$0$combytedancerealxvideoRXVideoFrameHelper() {
        long j = this.nativeHandle;
        if (j != 0) {
            nativeReleaseVideoFrameHelper(j);
            this.nativeHandle = 0L;
        }
    }

    @Override // com.bytedance.realx.video.RXVideoFrameHelperInterface
    public long getNativeHandle() {
        return this.nativeHandle;
    }

    @Override // com.bytedance.realx.video.RXVideoFrameHelperInterface, com.bytedance.realx.base.RefCounted
    public synchronized void retain() {
        this.refCounted.retain();
    }

    @Override // com.bytedance.realx.video.RXVideoFrameHelperInterface, com.bytedance.realx.base.RefCounted
    public synchronized void release() {
        this.refCounted.release();
    }
}
