package com.lynx.canvas.loader;

import android.graphics.Bitmap;
import com.lynx.canvas.KryptonLLog;

/* loaded from: classes6.dex */
public class CanvasResourceResolver extends ResourceResolver {
    private static final String TAG = "KryptonCanvasResourceResolver";
    private final long mNativeResolverPtr;
    private final String mUrl;

    private native void nativeReject(String str, long j);

    private native void nativeResolveBytes(byte[] bArr, int i, int i2, long j);

    private native void nativeResolveImage(Bitmap bitmap, long j, boolean z);

    private native void nativeResolveStreamLoadData(byte[] bArr, int i, int i2, long j);

    private native void nativeResolveStreamLoadEnd(boolean z, String str, long j);

    private native void nativeResolveStreamLoadStart(int i, long j);

    private native void nativeResolveText(String str, long j);

    public CanvasResourceResolver(long j, String str) {
        this.mNativeResolverPtr = j;
        this.mUrl = str;
    }

    @Override // com.lynx.canvas.loader.ResourceResolver
    public void resolve(byte[] bArr, int i, int i2) {
        if (getStatus() == ResolverStatus.PENDING) {
            KryptonLLog.i(TAG, "Resource request is resolved with url: " + KryptonResourceUtils.getTruncatePath(this.mUrl));
            nativeResolveBytes(bArr, i, i2, this.mNativeResolverPtr);
        }
        setStatus(ResolverStatus.RESOLVED);
    }

    @Override // com.lynx.canvas.loader.ResourceResolver
    public void resolve(String str) {
        if (getStatus() == ResolverStatus.PENDING) {
            KryptonLLog.i(TAG, "Resource request is resolved with url: " + KryptonResourceUtils.getTruncatePath(this.mUrl));
            nativeResolveText(str, this.mNativeResolverPtr);
        }
        setStatus(ResolverStatus.RESOLVED);
    }

    @Override // com.lynx.canvas.loader.ResourceResolver
    public void resolve(Bitmap bitmap) {
        if (getStatus() == ResolverStatus.PENDING) {
            KryptonLLog.i(TAG, "Image resource request is resolved with url: " + KryptonResourceUtils.getTruncatePath(this.mUrl));
            nativeResolveImage(bitmap, this.mNativeResolverPtr, bitmap.isPremultiplied());
        }
        setStatus(ResolverStatus.RESOLVED);
    }

    @Override // com.lynx.canvas.loader.ResourceResolver
    public void reject(String str) {
        if (getStatus() == ResolverStatus.PENDING) {
            KryptonLLog.i(TAG, "Resource request is rejected with url: " + KryptonResourceUtils.getTruncatePath(this.mUrl));
            nativeReject(str, this.mNativeResolverPtr);
        }
        setStatus(ResolverStatus.REJECTED);
    }

    @Override // com.lynx.canvas.loader.ResourceResolver
    public void resolveStreamLoadStart(int i) {
        nativeResolveStreamLoadStart(i, this.mNativeResolverPtr);
    }

    @Override // com.lynx.canvas.loader.ResourceResolver
    public void resolveStreamLoadData(byte[] bArr, int i, int i2) {
        nativeResolveStreamLoadData(bArr, i, i2, this.mNativeResolverPtr);
    }

    @Override // com.lynx.canvas.loader.ResourceResolver
    public void resolveStreamLoadEnd(boolean z, String str) {
        nativeResolveStreamLoadEnd(z, str, this.mNativeResolverPtr);
    }
}
