package com.lynx.tasm.image;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.p000ui.image.ImageUrlRedirectUtils;
import com.lynx.tasm.resourceprovider.LynxResourceCallback;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.media.LynxMediaResourceFetcher;
import com.lynx.tasm.resourceprovider.media.OptionalBool;
import com.lynx.tasm.service.ILynxResourceService;
import com.lynx.tasm.service.LynxServiceCenter;
import java.io.Closeable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxImageMediaFetcherProxy extends LynxMediaResourceFetcher {
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_WIDTH = "width";
    private boolean mAsyncRedirect;
    private LynxContext mContext;
    private LynxMediaResourceFetcher mFetcherDelegate;
    private ILynxResourceService mLynxResourceService;

    @Override // com.lynx.tasm.resourceprovider.media.LynxMediaResourceFetcher
    public void fetchImage(LynxResourceRequest lynxResourceRequest, LynxResourceCallback<Closeable> lynxResourceCallback) {
    }

    public LynxImageMediaFetcherProxy(LynxContext lynxContext) {
        this.mContext = lynxContext;
        this.mAsyncRedirect = lynxContext.isAsyncRedirect() && this.mContext.getAsyncImageInterceptor() != null;
        this.mFetcherDelegate = this.mContext.getMediaResourceFetcher();
        this.mLynxResourceService = (ILynxResourceService) LynxServiceCenter.inst().getService(ILynxResourceService.class);
    }

    @Override // com.lynx.tasm.resourceprovider.media.LynxMediaResourceFetcher
    public String shouldRedirectUrl(LynxResourceRequest lynxResourceRequest) {
        LynxMediaResourceFetcher lynxMediaResourceFetcher = this.mFetcherDelegate;
        if (lynxMediaResourceFetcher != null) {
            return lynxMediaResourceFetcher.shouldRedirectUrl(lynxResourceRequest);
        }
        if (this.mAsyncRedirect) {
            return ImageUrlRedirectUtils.asyncRedirectUrl(this.mContext, lynxResourceRequest.getUrl());
        }
        return ImageUrlRedirectUtils.redirectUrl(this.mContext, lynxResourceRequest.getUrl());
    }

    @Override // com.lynx.tasm.resourceprovider.media.LynxMediaResourceFetcher
    public OptionalBool isLocalResource(String str) {
        LynxMediaResourceFetcher lynxMediaResourceFetcher = this.mFetcherDelegate;
        if (lynxMediaResourceFetcher != null) {
            return lynxMediaResourceFetcher.isLocalResource(str);
        }
        ILynxResourceService iLynxResourceService = this.mLynxResourceService;
        if (iLynxResourceService != null) {
            return convertToOptionalBool(iLynxResourceService.isLocalResource(str));
        }
        return OptionalBool.UNDEFINED;
    }

    private OptionalBool convertToOptionalBool(int i) {
        if (i == -1) {
            return OptionalBool.UNDEFINED;
        }
        if (i == 1) {
            return OptionalBool.TRUE;
        }
        if (i == 0) {
            return OptionalBool.FALSE;
        }
        return OptionalBool.UNDEFINED;
    }
}
