package com.lynx.animax.loader;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.lynx.animax.service.AnimaXServiceCenter;
import com.lynx.animax.service.IAnimaXImageService;
import com.lynx.animax.util.AnimaX;
import com.lynx.animax.util.ResourceUtil;
import com.lynx.animax.util.UriUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AnimaXAssetLoader implements IAnimaXLoader {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.animax.loader.IAnimaXLoader
    public void load(IAnimaXLoaderRequest iAnimaXLoaderRequest, IAnimaXLoaderCompletionHandler iAnimaXLoaderCompletionHandler) {
        AnimaXLoaderResponse createByteArrayResponse;
        IAnimaXImageService iAnimaXImageService = (IAnimaXImageService) AnimaXServiceCenter.inst().getService(IAnimaXImageService.class);
        if (iAnimaXImageService == null || !iAnimaXImageService.loadImage(iAnimaXLoaderRequest, iAnimaXLoaderCompletionHandler)) {
            Uri safeParse = UriUtil.safeParse(iAnimaXLoaderRequest.getUri());
            Context appContext = AnimaX.inst().getAppContext();
            AssetManager assets = appContext != null ? appContext.getAssets() : null;
            byte[] byteArrayFromAsset = assets != null ? ResourceUtil.getByteArrayFromAsset(UriUtil.getAssetName(safeParse), assets) : null;
            if (byteArrayFromAsset == null) {
                createByteArrayResponse = AnimaXLoaderResponse.createErrorResponse(new Throwable("failed to load asset"));
            } else {
                createByteArrayResponse = AnimaXLoaderResponse.createByteArrayResponse(byteArrayFromAsset);
            }
            iAnimaXLoaderCompletionHandler.onComplete(createByteArrayResponse);
        }
    }

    @Override // com.lynx.animax.loader.IAnimaXLoader
    public AnimaXLoaderScheme getScheme() {
        return AnimaXLoaderScheme.ASSET;
    }
}
