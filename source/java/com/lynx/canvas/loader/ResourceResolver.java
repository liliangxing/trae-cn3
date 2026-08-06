package com.lynx.canvas.loader;

import android.graphics.Bitmap;

/* loaded from: classes6.dex */
public abstract class ResourceResolver {
    private ResolverStatus mStatus = ResolverStatus.PENDING;

    public void reject(String str) {
    }

    public void resolve(Bitmap bitmap) {
    }

    public void resolve(String str) {
    }

    public void resolve(byte[] bArr, int i, int i2) {
    }

    public void resolveStreamLoadData(byte[] bArr, int i, int i2) {
    }

    public void resolveStreamLoadEnd(boolean z, String str) {
    }

    public void resolveStreamLoadStart(int i) {
    }

    public ResolverStatus getStatus() {
        return this.mStatus;
    }

    public void setStatus(ResolverStatus resolverStatus) {
        this.mStatus = resolverStatus;
    }
}
