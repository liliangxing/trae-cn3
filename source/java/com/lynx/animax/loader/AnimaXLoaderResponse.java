package com.lynx.animax.loader;

/* loaded from: classes6.dex */
public final class AnimaXLoaderResponse<T> {
    private final T mData;
    private final Type mType;

    /* loaded from: classes6.dex */
    public enum Type {
        STRING_FILE_PATH,
        BYTE_ARRAY,
        BITMAP,
        ERROR
    }

    public static AnimaXLoaderResponse<String> createStringFilePathResponse(String str) {
        return new AnimaXLoaderResponse<>(Type.STRING_FILE_PATH, str);
    }

    public static AnimaXLoaderResponse<byte[]> createByteArrayResponse(byte[] bArr) {
        return new AnimaXLoaderResponse<>(Type.BYTE_ARRAY, bArr);
    }

    public static AnimaXLoaderResponse<IAnimaXCloseableBitmapReference> createBitmapResponse(IAnimaXCloseableBitmapReference iAnimaXCloseableBitmapReference) {
        return new AnimaXLoaderResponse<>(Type.BITMAP, iAnimaXCloseableBitmapReference);
    }

    public static AnimaXLoaderResponse<Throwable> createErrorResponse(Throwable th) {
        return new AnimaXLoaderResponse<>(Type.ERROR, th);
    }

    public T getData() {
        return this.mData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Type getType() {
        return this.mType;
    }

    private AnimaXLoaderResponse(Type type, T t) {
        this.mType = type;
        this.mData = t;
    }
}
