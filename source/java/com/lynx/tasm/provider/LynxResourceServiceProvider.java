package com.lynx.tasm.provider;

import android.text.TextUtils;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.service.ILynxResourceService;
import com.lynx.tasm.service.ILynxResourceServiceResponse;
import com.lynx.tasm.service.LynxResourceServiceCallback;
import com.lynx.tasm.service.LynxResourceServiceRequestParams;
import com.lynx.tasm.service.LynxServiceCenter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxResourceServiceProvider<T> extends LynxResourceFetcher<T> {
    private static final String TAG = "LynxResourceServiceProvider";
    private static volatile ILynxResourceService resourceService;
    private static volatile boolean sInitialized;

    public static synchronized boolean ensureLynxService() {
        boolean z;
        synchronized (LynxResourceServiceProvider.class) {
            if (!sInitialized) {
                resourceService = (ILynxResourceService) LynxServiceCenter.inst().getService(ILynxResourceService.class);
                sInitialized = true;
            }
            z = resourceService == null;
        }
        return z;
    }

    @Override // com.lynx.tasm.provider.LynxResourceFetcher
    public ILynxResourceRequestOperation request(final LynxResourceRequest<T> lynxResourceRequest, final LynxResourceCallback<ILynxResourceResponseDataInfo> lynxResourceCallback) {
        LynxResourceServiceRequestParams lynxResourceServiceRequestParams;
        if (TextUtils.isEmpty(lynxResourceRequest.getUrl())) {
            callbackWithError(lynxResourceCallback, "null", 30301, "The url in LynxResourceRequest is empty.");
            return null;
        }
        if (!ensureLynxService()) {
            callbackWithError(lynxResourceCallback, lynxResourceRequest.getUrl(), 30301, "Lynx resource service init failed");
            return null;
        }
        if (lynxResourceRequest.getLynxResourceServiceRequestParams() != null) {
            lynxResourceServiceRequestParams = lynxResourceRequest.getLynxResourceServiceRequestParams();
        } else {
            lynxResourceServiceRequestParams = new LynxResourceServiceRequestParams();
        }
        return resourceService.fetchResourceAsync(lynxResourceRequest.getUrl(), lynxResourceServiceRequestParams, new LynxResourceServiceCallback() { // from class: com.lynx.tasm.provider.LynxResourceServiceProvider.1
            @Override // com.lynx.tasm.service.LynxResourceServiceCallback
            public void onResponse(ILynxResourceServiceResponse iLynxResourceServiceResponse) {
                if (iLynxResourceServiceResponse == null || !iLynxResourceServiceResponse.isSucceed().booleanValue()) {
                    LynxResourceServiceProvider.this.callbackWithError(lynxResourceCallback, lynxResourceRequest.getUrl(), 30301, iLynxResourceServiceResponse == null ? "Lynx resource service response is null" : iLynxResourceServiceResponse.getErrorInfoString());
                } else {
                    lynxResourceCallback.onResponse(LynxResourceResponse.success(iLynxResourceServiceResponse));
                    LLog.i(LynxResourceServiceProvider.TAG, "Lynx resource service fetchResourceAsync successful, the url is" + lynxResourceRequest.getUrl());
                }
            }
        });
    }

    @Override // com.lynx.tasm.provider.LynxResourceFetcher
    public LynxResourceResponse<ILynxResourceResponseDataInfo> requestSync(LynxResourceRequest<T> lynxResourceRequest) {
        LynxResourceServiceRequestParams lynxResourceServiceRequestParams;
        LynxResourceResponse<ILynxResourceResponseDataInfo> failed;
        if (TextUtils.isEmpty(lynxResourceRequest.getUrl())) {
            return LynxResourceResponse.failed(30301, new Throwable("The url in LynxResourceRequest is empty."));
        }
        if (resourceService == null) {
            return LynxResourceResponse.failed(30301, new Throwable("Lynx resource service init failed"));
        }
        if (lynxResourceRequest.getLynxResourceServiceRequestParams() != null) {
            lynxResourceServiceRequestParams = lynxResourceRequest.getLynxResourceServiceRequestParams();
        } else {
            lynxResourceServiceRequestParams = new LynxResourceServiceRequestParams();
        }
        ILynxResourceServiceResponse fetchResourceSync = resourceService.fetchResourceSync(lynxResourceRequest.getUrl(), lynxResourceServiceRequestParams);
        if (fetchResourceSync == null) {
            LynxResourceResponse<ILynxResourceResponseDataInfo> failed2 = LynxResourceResponse.failed(30301, new Throwable("Lynx resource service response is null"));
            LLog.e(TAG, "Lynx resource service request failed, the url is " + lynxResourceRequest.getUrl() + ", the error code is 30301, and the error message is Lynx resource service response is null.");
            return failed2;
        }
        if (fetchResourceSync.isSucceed().booleanValue()) {
            LynxResourceResponse<ILynxResourceResponseDataInfo> success = LynxResourceResponse.success(fetchResourceSync);
            LLog.i(TAG, "Lynx resource service fetchResourceSync successful, the url is" + lynxResourceRequest.getUrl());
            return success;
        }
        if (fetchResourceSync.getErrorCode().intValue() == -1) {
            failed = LynxResourceResponse.failed(30301, new Throwable(fetchResourceSync.getErrorInfoString()));
            LLog.e(TAG, "Lynx resource service request failed, the url is " + lynxResourceRequest.getUrl() + ", the error code is 30301, and the error message is " + fetchResourceSync.getErrorInfoString());
        } else {
            failed = LynxResourceResponse.failed(30301, new Throwable(fetchResourceSync.getErrorInfoString()));
            LLog.e(TAG, "Lynx resource service request failed, the url is " + lynxResourceRequest.getUrl() + ", the error code is 30301, and the error message is " + fetchResourceSync.getErrorInfoString());
        }
        return failed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackWithError(LynxResourceCallback<ILynxResourceResponseDataInfo> lynxResourceCallback, String str, int i, String str2) {
        LLog.e(TAG, "Lynx resource service request failed, the url is " + str + ", the error code is " + i + ", and the error message is " + str2);
        lynxResourceCallback.onResponse(LynxResourceResponse.failed(i, new Throwable(str2)));
    }
}
