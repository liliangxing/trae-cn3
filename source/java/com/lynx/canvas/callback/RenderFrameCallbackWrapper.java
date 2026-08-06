package com.lynx.canvas.callback;

/* loaded from: classes6.dex */
public class RenderFrameCallbackWrapper implements RenderFrameCallback {
    private final RenderFrameCallback mCallback;

    public RenderFrameCallbackWrapper(RenderFrameCallback renderFrameCallback) {
        this.mCallback = renderFrameCallback;
    }

    @Override // com.lynx.canvas.callback.RenderFrameCallback
    public void onFrameRender(String str, long j, long j2) {
        this.mCallback.onFrameRender(str, j, j2);
    }
}
