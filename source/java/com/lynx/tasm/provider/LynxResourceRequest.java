package com.lynx.tasm.provider;

import com.lynx.tasm.service.LynxResourceServiceRequestParams;

/* loaded from: classes7.dex */
public class LynxResourceRequest<T> {
    private T mRequestParams;
    private LynxResourceType mRequestResourceType;
    private String mUrl;

    /* loaded from: classes7.dex */
    public enum LynxResourceType {
        LynxResourceTypeImage,
        LynxResourceTypeFont,
        LynxResourceTypeLottie,
        LynxResourceTypeVideo,
        LynxResourceTypeSVG,
        LynxResourceTypeTemplate,
        LynxResourceTypeLynxCoreJS,
        LynxResourceTypeDynamicComponent,
        LynxResourceTypeI18NText,
        LynxResourceTypeTheme,
        LynxResourceTypeExternalJSSource
    }

    public LynxResourceRequest(String str) {
        this.mUrl = str;
    }

    public LynxResourceRequest(String str, T t) {
        this.mUrl = str;
        this.mRequestParams = t;
    }

    public LynxResourceRequest(String str, T t, LynxResourceType lynxResourceType) {
        this.mUrl = str;
        this.mRequestParams = t;
        this.mRequestResourceType = lynxResourceType;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public T getRequestParams() {
        return this.mRequestParams;
    }

    public LynxResourceServiceRequestParams getLynxResourceServiceRequestParams() {
        T t = this.mRequestParams;
        if (t == null || !(t instanceof LynxResourceServiceRequestParams)) {
            return null;
        }
        return (LynxResourceServiceRequestParams) t;
    }

    public LynxResourceType getRequestResourceType() {
        return this.mRequestResourceType;
    }
}
