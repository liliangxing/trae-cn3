package com.lynx.tasm.resourceprovider;

import com.lynx.tasm.behavior.LynxContext;
import java.util.Map;

/* loaded from: classes7.dex */
public final class LynxResourceRequest {
    private AsyncMode asyncMode;
    private final LynxContext lynxContext;
    private Map<String, Object> params;
    private final LynxResourceType resourceType;
    private final String url;

    /* loaded from: classes7.dex */
    public enum AsyncMode {
        EXACTLY_ASYNC,
        EXACTLY_SYNC,
        MOST_SYNC
    }

    /* loaded from: classes7.dex */
    public enum LynxResourceType {
        LynxResourceTypeGeneric,
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
        LynxResourceTypeExternalJSSource,
        LynxResourceTypeExternalByteCode
    }

    public LynxResourceRequest(String str, LynxResourceType lynxResourceType) {
        this(str, lynxResourceType, null);
    }

    public LynxResourceRequest(String str, LynxResourceType lynxResourceType, LynxContext lynxContext) {
        this.url = str;
        this.resourceType = lynxResourceType;
        this.lynxContext = lynxContext;
    }

    public void setAsyncMode(AsyncMode asyncMode) {
        this.asyncMode = asyncMode;
    }

    public void setParams(Map<String, Object> map) {
        this.params = map;
    }

    public String getUrl() {
        return this.url;
    }

    public LynxResourceType getResourceType() {
        return this.resourceType;
    }

    public AsyncMode getAsyncMode() {
        return this.asyncMode;
    }

    public Map<String, Object> getParams() {
        return this.params;
    }

    public LynxContext getLynxContext() {
        return this.lynxContext;
    }
}
