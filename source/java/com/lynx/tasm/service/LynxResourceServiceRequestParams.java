package com.lynx.tasm.service;

/* loaded from: classes7.dex */
public class LynxResourceServiceRequestParams {
    private LynxServiceScene resourceScene = LynxServiceScene.OTHER;
    private Boolean enableMemoryCache = null;
    private Boolean enableRequestReuse = false;
    private String templateUrl = null;

    /* loaded from: classes7.dex */
    public enum LynxServiceScene {
        LYNX_TEMPLATE,
        LYNX_EXTERNAL_JS,
        LYNX_COMPONENT,
        LYNX_FONT,
        LYNX_I18N,
        LYNX_IMAGE,
        LYNX_LOTTIE,
        LYNX_VIDEO,
        LYNX_SVG,
        LYNX_CHILD_RESOURCE,
        WEB_MAIN_RESOURCE,
        WEB_CHILD_RESOURCE,
        PRELOAD_CONFIG,
        OTHER
    }

    public LynxServiceScene getResourceScene() {
        return this.resourceScene;
    }

    public void setResourceScene(LynxServiceScene lynxServiceScene) {
        this.resourceScene = lynxServiceScene;
    }

    public Boolean getEnableMemoryCache() {
        return this.enableMemoryCache;
    }

    public void setEnableMemoryCache(Boolean bool) {
        this.enableMemoryCache = bool;
    }

    public Boolean getEnableRequestReuse() {
        return this.enableRequestReuse;
    }

    public void setEnableRequestReuse(Boolean bool) {
        this.enableRequestReuse = bool;
    }

    public String getTemplateUrl() {
        return this.templateUrl;
    }

    public void setTemplateUrl(String str) {
        this.templateUrl = str;
    }
}
