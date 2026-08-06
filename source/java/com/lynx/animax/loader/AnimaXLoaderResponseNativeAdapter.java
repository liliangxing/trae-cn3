package com.lynx.animax.loader;

import com.lynx.animax.loader.AnimaXLoaderResponse;

/* loaded from: classes6.dex */
public final class AnimaXLoaderResponseNativeAdapter {
    private final AnimaXLoaderResponse<?> mResponse;

    private AnimaXLoaderResponseNativeAdapter(AnimaXLoaderResponse<?> animaXLoaderResponse) {
        this.mResponse = animaXLoaderResponse;
    }

    public static AnimaXLoaderResponseNativeAdapter create(AnimaXLoaderResponse<?> animaXLoaderResponse) {
        return new AnimaXLoaderResponseNativeAdapter(animaXLoaderResponse);
    }

    public int getType() {
        return this.mResponse.getType().ordinal();
    }

    public String getErrorMessage() {
        Throwable th;
        return (this.mResponse.getType() != AnimaXLoaderResponse.Type.ERROR || (th = (Throwable) this.mResponse.getData()) == null) ? "" : th.getMessage();
    }

    public String getFilePath() {
        return (String) this.mResponse.getData();
    }

    public byte[] getData() {
        return (byte[]) this.mResponse.getData();
    }

    public AnimaXCloseableBitmapReferenceNativeAdapter getBitmap() {
        return AnimaXCloseableBitmapReferenceNativeAdapter.create((IAnimaXCloseableBitmapReference) this.mResponse.getData());
    }
}
