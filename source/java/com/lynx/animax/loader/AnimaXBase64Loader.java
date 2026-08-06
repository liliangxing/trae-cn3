package com.lynx.animax.loader;

import android.graphics.BitmapFactory;
import android.util.Base64;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AnimaXBase64Loader implements IAnimaXLoader {
    private static final String BASE64_PREFIX = "base64,";

    private static String getDataUrlBase64Content(String str) {
        return str.substring(str.indexOf(BASE64_PREFIX) + 7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.animax.loader.IAnimaXLoader
    public void load(IAnimaXLoaderRequest iAnimaXLoaderRequest, IAnimaXLoaderCompletionHandler iAnimaXLoaderCompletionHandler) {
        AnimaXLoaderResponse createErrorResponse;
        try {
            try {
                byte[] decode = Base64.decode(getDataUrlBase64Content(iAnimaXLoaderRequest.getUri()), 0);
                if (iAnimaXLoaderRequest.getImageInfo() != null) {
                    createErrorResponse = AnimaXLoaderResponse.createBitmapResponse(new SimpleCloseableBitmapReference(BitmapFactory.decodeByteArray(decode, 0, decode.length)));
                } else {
                    createErrorResponse = AnimaXLoaderResponse.createByteArrayResponse(decode);
                }
            } catch (Exception e) {
                createErrorResponse = AnimaXLoaderResponse.createErrorResponse(e);
            }
            iAnimaXLoaderCompletionHandler.onComplete(createErrorResponse);
        } catch (Throwable th) {
            iAnimaXLoaderCompletionHandler.onComplete(null);
            throw th;
        }
    }

    @Override // com.lynx.animax.loader.IAnimaXLoader
    public AnimaXLoaderScheme getScheme() {
        return AnimaXLoaderScheme.DATA_URL;
    }
}
