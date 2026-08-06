package com.lynx.tasm.navigator;

import java.util.Map;

/* loaded from: classes7.dex */
public class LynxRoute {
    private Map<String, Object> param;
    private String routeName;
    private String templateUrl;

    public LynxRoute(String str, Map<String, Object> map) {
        this.templateUrl = str;
        this.param = map;
        this.routeName = str;
    }

    public LynxRoute(String str, String str2, Map<String, Object> map) {
        this.templateUrl = str;
        this.routeName = str2;
        this.param = map;
    }

    public String getTemplateUrl() {
        return this.templateUrl;
    }

    public String getRouteName() {
        return this.routeName;
    }

    public Map<String, Object> getParam() {
        return this.param;
    }
}
