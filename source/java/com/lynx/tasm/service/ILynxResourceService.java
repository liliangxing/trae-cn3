package com.lynx.tasm.service;

/* loaded from: classes7.dex */
public interface ILynxResourceService extends IServiceProvider {
    public static final int RESULT_EMPTY_URL = 2;
    public static final int RESULT_EXCEPTION = -1;
    public static final int RESULT_INVALID_URL = 3;
    public static final int RESULT_IS_LOCAL_RESOURCE = 1;
    public static final int RESULT_IS_NOT_LOCAL_RESOURCE = 0;

    void addResourceLoader(Object obj, String str);

    void cancelPreloadMedia(String str, String str2);

    ILynxResourceServiceRequestOperation fetchResourceAsync(String str, LynxResourceServiceRequestParams lynxResourceServiceRequestParams, LynxResourceServiceCallback lynxResourceServiceCallback);

    ILynxResourceServiceResponse fetchResourceSync(String str, LynxResourceServiceRequestParams lynxResourceServiceRequestParams);

    int isLocalResource(String str);

    boolean isReady();

    void preloadMedia(String str, String str2, String str3, long j);

    @Override // com.lynx.tasm.service.IServiceProvider
    default Class<? extends IServiceProvider> getServiceClass() {
        return ILynxResourceService.class;
    }
}
