package com.bytedance.common.model;

import com.bytedance.common.push.BaseJson;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ClientDisplayFeature extends BaseJson {
    private JSONObject extraParams;
    private String fontScale;
    private Boolean isDarkMode;
    private Boolean isFontFollowSystem;
    private Boolean isLargeMode;

    public ClientDisplayFeature() {
        this("", false, false, false);
    }

    public ClientDisplayFeature(String str, Boolean bool, Boolean bool2, Boolean bool3) {
        this(str, bool, bool2, bool3, new JSONObject());
    }

    public ClientDisplayFeature(String str, Boolean bool, Boolean bool2, Boolean bool3, JSONObject jSONObject) {
        this.fontScale = str;
        this.isFontFollowSystem = bool;
        this.isLargeMode = bool2;
        this.isDarkMode = bool3;
        this.extraParams = jSONObject;
    }

    public void setFontScale(String str) {
        this.fontScale = str;
    }

    public String getFontScale() {
        return this.fontScale;
    }

    public void setFontFollowSystem(Boolean bool) {
        this.isFontFollowSystem = bool;
    }

    public Boolean isFontFollowSystem() {
        return this.isFontFollowSystem;
    }

    public void setLargeMode(Boolean bool) {
        this.isLargeMode = bool;
    }

    public Boolean isLargeMode() {
        return this.isLargeMode;
    }

    public void setDarkMode(Boolean bool) {
        this.isDarkMode = bool;
    }

    public Boolean isDarkMode() {
        return this.isDarkMode;
    }

    public void setExtraParams(JSONObject jSONObject) {
        this.extraParams = jSONObject;
    }

    public JSONObject getExtraParams() {
        return this.extraParams;
    }
}
