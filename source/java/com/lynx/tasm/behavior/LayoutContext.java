package com.lynx.tasm.behavior;

import android.util.DisplayMetrics;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import com.lynx.tasm.behavior.p000ui.PropBundle;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class LayoutContext {
    private boolean mDestroyed;
    private long mNativePtr = 0;
    protected long mNativeLayoutContextPtr = 0;

    private native long nativeCreateLayoutContext(Object obj);

    private native void nativeTriggerLayout(long j);

    public abstract void attachLayoutNodeManager(long j);

    public abstract int createNode(int i, String str, PropBundle propBundle, ReadableMapBuffer readableMapBuffer, boolean z);

    public abstract void destroyNodes(int[] iArr);

    public abstract void dispatchOnLayout(int i, int i2, int i3, int i4, int i5);

    public abstract void dispatchOnLayoutBefore(int i);

    public abstract Object getExtraBundle(int i);

    public abstract DisplayMetrics getScreenMetrics();

    public abstract void insertNode(int i, int i2, int i3);

    public abstract void moveNode(int i, int i2, int i3, int i4);

    public abstract void removeNode(int i, int i2, int i3);

    protected abstract void scheduleLayout();

    public abstract void setFontFaces(ReadableMap readableMap);

    public abstract void updateProps(int i, PropBundle propBundle, ReadableMapBuffer readableMapBuffer);

    protected void attachNativePtr(long j) {
        this.mNativePtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void detachNativePtr() {
        this.mNativePtr = 0L;
    }

    public void triggerLayout() {
        long j = this.mNativePtr;
        if (j != 0) {
            nativeTriggerLayout(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void createNativeLayoutContext(Object obj) {
        this.mNativeLayoutContextPtr = nativeCreateLayoutContext(obj);
    }

    public long getNativeLayoutContextPtr() {
        return this.mNativeLayoutContextPtr;
    }

    public void destroy() {
        this.mDestroyed = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isDestroyed() {
        return this.mDestroyed;
    }
}
