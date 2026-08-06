package com.lynx.animax.service;

import com.lynx.animax.loader.FrescoUtil;
import com.lynx.animax.loader.IAnimaXLoaderCompletionHandler;
import com.lynx.animax.loader.IAnimaXLoaderRequest;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AnimaXFrescoImageService implements IAnimaXImageService, IAutoRegisterAnimaXService {
    @Override // com.lynx.animax.service.IAnimaXImageService
    public boolean loadImage(IAnimaXLoaderRequest iAnimaXLoaderRequest, IAnimaXLoaderCompletionHandler iAnimaXLoaderCompletionHandler) {
        return FrescoUtil.tryHandleLoaderRequestWithFresco(iAnimaXLoaderRequest, iAnimaXLoaderCompletionHandler);
    }

    @Override // com.lynx.animax.service.IAutoRegisterAnimaXService
    public Class<? extends IAnimaXService> getServiceClass() {
        return IAnimaXImageService.class;
    }
}
