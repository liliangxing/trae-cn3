package com.lynx.animax.loader;

import com.lynx.animax.ability.BaseAbility;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.animax.util.DeviceUtil;
import com.lynx.animax.util.LynxResourceUtil;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.core.ResManager;
import com.lynx.tasm.provider.LynxResCallback;
import com.lynx.tasm.provider.LynxResRequest;
import com.lynx.tasm.provider.LynxResResponse;
import com.lynx.tasm.resourceprovider.LynxResourceCallback;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;
import com.lynx.tasm.resourceprovider.generic.LynxGenericResourceFetcher;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxHttpAnimaXLoader implements IAnimaXLoader {
    private static final String TAG = "LynxHttpAnimaXLoader";
    private final WeakReference<BaseAbility> mAbility;
    private final WeakReference<LynxContext> mLynxContext;
    private final boolean mUseLegacyFetcher;

    public LynxHttpAnimaXLoader(BaseAbility baseAbility, LynxContext lynxContext) {
        this.mAbility = new WeakReference<>(baseAbility);
        this.mLynxContext = new WeakReference<>(lynxContext);
        boolean useLegacyFetcher = DeviceUtil.useLegacyFetcher(baseAbility);
        this.mUseLegacyFetcher = useLegacyFetcher;
        if (useLegacyFetcher || lynxContext.getGenericResourceFetcher() == null) {
            AnimaXLog.m2541i(TAG, "Generic fetcher unavailable, mUseLegacyFetcher: " + useLegacyFetcher + ", genericFetcher is null:" + (lynxContext.getGenericResourceFetcher() == null));
        }
    }

    @Override // com.lynx.animax.loader.IAnimaXLoader
    public void load(IAnimaXLoaderRequest iAnimaXLoaderRequest, IAnimaXLoaderCompletionHandler iAnimaXLoaderCompletionHandler) {
        if (handleImageRequest(iAnimaXLoaderRequest, iAnimaXLoaderCompletionHandler) || tryLoadWithGenericFetcher(iAnimaXLoaderRequest, iAnimaXLoaderCompletionHandler)) {
            return;
        }
        loadWithLegacyLoader(iAnimaXLoaderRequest, iAnimaXLoaderCompletionHandler);
    }

    private boolean handleImageRequest(IAnimaXLoaderRequest iAnimaXLoaderRequest, IAnimaXLoaderCompletionHandler iAnimaXLoaderCompletionHandler) {
        if (iAnimaXLoaderRequest.getImageInfo() == null) {
            return false;
        }
        String uri = iAnimaXLoaderRequest.getUri();
        BaseAbility baseAbility = this.mAbility.get();
        if (baseAbility != null) {
            uri = baseAbility.redirectUrl(uri);
        }
        FrescoUtil.tryHandleLoaderRequestWithFresco(new AnimaXLoaderRequest(uri, iAnimaXLoaderRequest.getParams()), iAnimaXLoaderCompletionHandler);
        return true;
    }

    private boolean tryLoadWithGenericFetcher(IAnimaXLoaderRequest iAnimaXLoaderRequest, final IAnimaXLoaderCompletionHandler iAnimaXLoaderCompletionHandler) {
        if (this.mUseLegacyFetcher) {
            return false;
        }
        LynxContext lynxContext = this.mLynxContext.get();
        if (lynxContext == null) {
            AnimaXLog.m2541i(TAG, "Generic fetcher unavailable: context is null");
            return false;
        }
        LynxGenericResourceFetcher genericResourceFetcher = lynxContext.getGenericResourceFetcher();
        if (genericResourceFetcher == null) {
            return false;
        }
        genericResourceFetcher.fetchResource(new LynxResourceRequest(iAnimaXLoaderRequest.getUri(), LynxResourceRequest.LynxResourceType.LynxResourceTypeLottie), new LynxResourceCallback<byte[]>() { // from class: com.lynx.animax.loader.LynxHttpAnimaXLoader.1
            public void onResponse(LynxResourceResponse<byte[]> lynxResourceResponse) {
                byte[] bArr = (byte[]) lynxResourceResponse.getData();
                if (bArr != null && lynxResourceResponse.getState() == LynxResourceResponse.ResponseState.SUCCESS) {
                    iAnimaXLoaderCompletionHandler.onComplete(AnimaXLoaderResponse.createByteArrayResponse(bArr));
                } else {
                    iAnimaXLoaderCompletionHandler.onComplete(AnimaXLoaderResponse.createErrorResponse(lynxResourceResponse.getError()));
                }
            }
        });
        return true;
    }

    private void loadWithLegacyLoader(IAnimaXLoaderRequest iAnimaXLoaderRequest, final IAnimaXLoaderCompletionHandler iAnimaXLoaderCompletionHandler) {
        LynxContext lynxContext = this.mLynxContext.get();
        ResManager.inst().requestResource(new LynxResRequest(iAnimaXLoaderRequest.getUri(), lynxContext != null ? lynxContext.getLynxExtraData() : null), new LynxResCallback() { // from class: com.lynx.animax.loader.LynxHttpAnimaXLoader.2
            /* JADX WARN: Multi-variable type inference failed */
            public void onSuccess(LynxResResponse lynxResResponse) {
                AnimaXLoaderResponse createErrorResponse;
                byte[] byteArrayFromLynxResResponse = LynxResourceUtil.getByteArrayFromLynxResResponse(lynxResResponse);
                if (byteArrayFromLynxResResponse != null) {
                    createErrorResponse = AnimaXLoaderResponse.createByteArrayResponse(byteArrayFromLynxResResponse);
                } else {
                    createErrorResponse = AnimaXLoaderResponse.createErrorResponse(new Throwable("Failed to load raw data with LynxResRequest"));
                }
                iAnimaXLoaderCompletionHandler.onComplete(createErrorResponse);
            }

            public void onFailed(LynxResResponse lynxResResponse) {
                iAnimaXLoaderCompletionHandler.onComplete(AnimaXLoaderResponse.createErrorResponse(new Throwable("LynxResRequest failed with error: " + lynxResResponse.getReasonPhrase() + "status code: " + lynxResResponse.getStatusCode())));
            }
        });
    }

    @Override // com.lynx.animax.loader.IAnimaXLoader
    public AnimaXLoaderScheme getScheme() {
        return AnimaXLoaderScheme.HTTP;
    }
}
