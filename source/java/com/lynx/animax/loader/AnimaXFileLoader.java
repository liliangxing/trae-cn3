package com.lynx.animax.loader;

import com.lynx.animax.service.AnimaXServiceCenter;
import com.lynx.animax.service.IAnimaXImageService;
import com.lynx.animax.util.ResourceUtil;
import com.lynx.animax.util.UriUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AnimaXFileLoader implements IAnimaXLoader {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.animax.loader.IAnimaXLoader
    public void load(IAnimaXLoaderRequest iAnimaXLoaderRequest, IAnimaXLoaderCompletionHandler iAnimaXLoaderCompletionHandler) {
        AnimaXLoaderResponse createErrorResponse;
        IAnimaXImageService iAnimaXImageService = (IAnimaXImageService) AnimaXServiceCenter.inst().getService(IAnimaXImageService.class);
        if (iAnimaXImageService == null || !iAnimaXImageService.loadImage(iAnimaXLoaderRequest, iAnimaXLoaderCompletionHandler)) {
            byte[] byteArrayFromFile = ResourceUtil.getByteArrayFromFile(UriUtil.getLocalFileName(UriUtil.safeParse(iAnimaXLoaderRequest.getUri())));
            if (byteArrayFromFile != null) {
                createErrorResponse = AnimaXLoaderResponse.createByteArrayResponse(byteArrayFromFile);
            } else {
                createErrorResponse = AnimaXLoaderResponse.createErrorResponse(new Throwable("load file failed, getByteArrayFromFile returned null."));
            }
            iAnimaXLoaderCompletionHandler.onComplete(createErrorResponse);
        }
    }

    @Override // com.lynx.animax.loader.IAnimaXLoader
    public AnimaXLoaderScheme getScheme() {
        return AnimaXLoaderScheme.FILE;
    }
}
