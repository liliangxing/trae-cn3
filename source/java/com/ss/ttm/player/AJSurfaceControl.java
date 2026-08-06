package com.ss.ttm.player;

import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.hardware.SyncFence;
import android.view.SurfaceControl;
import com.ss.ttm.utils.AVLogger;
import java.util.Locale;
import java.util.function.Consumer;

/* loaded from: classes7.dex */
public class AJSurfaceControl {
    private static final String TAG = "AJSurfaceControl";
    private long mNativeHandler;
    private SurfaceControl mSurfaceControl;
    private Rect mSourceCrop = new Rect(0, 0, 0, 0);
    private Rect mDestFrame = new Rect(0, 0, 0, 0);
    private int mBufferTransform = 0;
    private int mDataSpace = 0;
    private SurfaceControl.Transaction mTransaction = new SurfaceControl.Transaction();

    private native void _onBufferRelease(long nativeHandler, long context, SyncFence fence);

    public AJSurfaceControl() {
        AVLogger.Info(TAG, this, "init transaction = " + this.mTransaction);
    }

    public void setCallback(long nativeHandler) {
        AVLogger.Info(TAG, this, "set callback = " + String.format(Locale.US, "%x", Long.valueOf(nativeHandler)));
        this.mNativeHandler = nativeHandler;
    }

    public void reparent(SurfaceControl old, SurfaceControl newParent) {
        AVLogger.Info(TAG, this, "reparent surface control old = " + old + " newParent = " + newParent);
        if (old != null) {
            this.mTransaction.reparent(old, newParent).apply();
        }
    }

    public void update(SurfaceControl surfaceControl) {
        AVLogger.Info(TAG, this, "update surface control = " + surfaceControl);
        if (this.mSurfaceControl != surfaceControl) {
            this.mSourceCrop.setEmpty();
            this.mDestFrame.setEmpty();
            this.mBufferTransform = 0;
            this.mDataSpace = 0;
        }
        this.mSurfaceControl = surfaceControl;
    }

    public void draw(final long context, final HardwareBuffer hardwareBuffer, Rect sourceCrop, Rect destFrame, int bufferTransform, int dataSpace) {
        Rect rect;
        if (this.mSurfaceControl == null || this.mTransaction == null) {
            AVLogger.Error(TAG, this, "draw failed, invalid surface control or transaction");
            _onBufferRelease(this.mNativeHandler, context, null);
            if (hardwareBuffer != null) {
                hardwareBuffer.close();
                return;
            }
            return;
        }
        if ((sourceCrop != null && !this.mSourceCrop.equals(sourceCrop)) || ((destFrame != null && !this.mDestFrame.equals(destFrame)) || this.mBufferTransform != bufferTransform)) {
            if (sourceCrop != null && !sourceCrop.isEmpty()) {
                rect = new Rect(sourceCrop);
                if (bufferTransform == 3) {
                    rect.left = hardwareBuffer.getWidth() - sourceCrop.right;
                    rect.top = hardwareBuffer.getHeight() - sourceCrop.bottom;
                    rect.right = rect.left + sourceCrop.width();
                    rect.bottom = rect.top + sourceCrop.height();
                } else if (bufferTransform == 4) {
                    rect.left = hardwareBuffer.getHeight() - sourceCrop.bottom;
                    rect.top = sourceCrop.left;
                    rect.right = rect.left + sourceCrop.height();
                    rect.bottom = rect.top + sourceCrop.width();
                } else if (bufferTransform == 7) {
                    rect.left = sourceCrop.top;
                    rect.top = hardwareBuffer.getWidth() - sourceCrop.right;
                    rect.right = rect.left + sourceCrop.height();
                    rect.bottom = rect.top + sourceCrop.width();
                }
            } else {
                rect = new Rect(0, 0, hardwareBuffer.getWidth(), hardwareBuffer.getHeight());
                if (bufferTransform == 4 || bufferTransform == 7) {
                    rect.right = hardwareBuffer.getHeight();
                    rect.bottom = hardwareBuffer.getWidth();
                }
            }
            AVLogger.Info(TAG, this, "set crop = " + rect);
            this.mTransaction.setCrop(this.mSurfaceControl, rect);
            if (sourceCrop != null && !sourceCrop.isEmpty()) {
                this.mSourceCrop = new Rect(sourceCrop);
            } else {
                this.mSourceCrop.setEmpty();
            }
            if (destFrame != null && !destFrame.isEmpty()) {
                float width = (destFrame.width() * 1.0f) / rect.width();
                float height = (destFrame.height() * 1.0f) / rect.height();
                AVLogger.Info(TAG, this, "set scale = [" + width + "," + height + "]");
                this.mTransaction.setScale(this.mSurfaceControl, width, height);
                float f = width * rect.left;
                float f2 = height * rect.top;
                AVLogger.Info(TAG, this, "set position = [" + f + "," + f2 + "]");
                this.mTransaction.setPosition(this.mSurfaceControl, destFrame.left - f, destFrame.top - f2);
                AVLogger.Info(TAG, this, "set dest frame = " + destFrame);
                this.mTransaction.setBufferSize(this.mSurfaceControl, destFrame.width(), destFrame.height());
                this.mDestFrame = new Rect(destFrame);
            } else {
                this.mDestFrame.setEmpty();
            }
            AVLogger.Info(TAG, this, "set buffer transform = " + bufferTransform);
            this.mTransaction.setBufferTransform(this.mSurfaceControl, bufferTransform);
            this.mBufferTransform = bufferTransform;
        }
        if (this.mDataSpace != dataSpace) {
            AVLogger.Info(TAG, this, "set data space = " + dataSpace);
            this.mTransaction.setDataSpace(this.mSurfaceControl, dataSpace);
            this.mDataSpace = dataSpace;
        }
        this.mTransaction.setBuffer(this.mSurfaceControl, hardwareBuffer, null, new Consumer() { // from class: com.ss.ttm.player.AJSurfaceControl$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                AJSurfaceControl.this.m9513lambda$draw$0$comssttmplayerAJSurfaceControl(context, hardwareBuffer, (SyncFence) obj);
            }
        }).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$draw$0$com-ss-ttm-player-AJSurfaceControl, reason: not valid java name */
    public /* synthetic */ void m9513lambda$draw$0$comssttmplayerAJSurfaceControl(long j, HardwareBuffer hardwareBuffer, SyncFence syncFence) {
        if (syncFence != null && syncFence.isValid()) {
            _onBufferRelease(this.mNativeHandler, j, syncFence);
        } else {
            _onBufferRelease(this.mNativeHandler, j, null);
        }
        if (hardwareBuffer != null) {
            hardwareBuffer.close();
        }
    }

    public void release() {
        AVLogger.Info(TAG, this, "release transaction = " + this.mTransaction);
        SurfaceControl.Transaction transaction = this.mTransaction;
        if (transaction != null) {
            transaction.close();
            this.mTransaction = null;
        }
        this.mNativeHandler = 0L;
    }
}
