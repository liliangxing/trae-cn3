package com.lynx.tasm.behavior.shadow.text;

import android.graphics.Picture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.Layout;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public class TextLayoutWarmer extends HandlerThread {
    private static final String TAG = "TextLayoutWarmer";
    private volatile Handler mHandler;

    /* loaded from: classes7.dex */
    private static class Holder {
        private static TextLayoutWarmer warmer = new TextLayoutWarmer();

        private Holder() {
        }
    }

    public static TextLayoutWarmer warmer() {
        return Holder.warmer;
    }

    private TextLayoutWarmer() {
        super(TAG, 10);
        start();
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        this.mHandler = new WarmerHandler(Looper.myLooper());
    }

    public void warmLayout(Layout layout) {
        if (this.mHandler != null) {
            this.mHandler.obtainMessage(0, new WeakReference(layout)).sendToTarget();
        }
    }

    /* loaded from: classes7.dex */
    private static final class WarmerHandler extends Handler {
        public static final int WARM_LAYOUT = 0;
        private final Picture mPicture;

        private WarmerHandler(Looper looper) {
            super(looper);
            Picture picture;
            try {
                picture = new Picture();
            } catch (RuntimeException unused) {
                picture = null;
            }
            this.mPicture = picture;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Layout layout;
            if (this.mPicture == null) {
                return;
            }
            try {
                if (message.what != 0 || (layout = (Layout) ((WeakReference) message.obj).get()) == null) {
                    return;
                }
                layout.draw(this.mPicture.beginRecording(layout.getWidth(), layout.getHeight()));
                this.mPicture.endRecording();
            } catch (Exception unused) {
            }
        }
    }
}
