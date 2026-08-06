package com.bytedance.ies.argus.api.params;

import com.bytedance.ies.argus.bean.ArgusSwitch;
import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.strategy.BaseRewritePayload;
import com.bytedance.ies.argus.util.ArgusGsonUtils;
import com.bytedance.webx.seclink.base.SecLinkCheckCallback;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: WebLoadUrlParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016RB\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00118F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010\u001c\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001b¨\u0006#"}, d2 = {"Lcom/bytedance/ies/argus/api/params/WebLoadUrlRewritePayload;", "Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "()V", "value", "", "", "headers", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "secLinkCheckCallback", "Lcom/bytedance/webx/seclink/base/SecLinkCheckCallback;", "getSecLinkCheckCallback", "()Lcom/bytedance/webx/seclink/base/SecLinkCheckCallback;", "setSecLinkCheckCallback", "(Lcom/bytedance/webx/seclink/base/SecLinkCheckCallback;)V", "Lcom/bytedance/ies/argus/bean/ArgusSwitch;", "secLinkMode", "getSecLinkMode", "()Lcom/bytedance/ies/argus/bean/ArgusSwitch;", "setSecLinkMode", "(Lcom/bytedance/ies/argus/bean/ArgusSwitch;)V", "secLinkScene", "getSecLinkScene", "()Ljava/lang/String;", "setSecLinkScene", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "toMonitorObject", "Lorg/json/JSONObject;", "action", "Lcom/bytedance/ies/argus/bean/ArgusVerifyAction;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class WebLoadUrlRewritePayload extends BaseRewritePayload {
    private Map<String, String> headers;
    private SecLinkCheckCallback secLinkCheckCallback;
    private ArgusSwitch secLinkMode;
    private String secLinkScene;
    private String url;

    public final String getUrl() {
        Object obj = getInnerData$anniex_release().get("url");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public final void setUrl(String str) {
        this.url = str;
        if (str != null) {
            getInnerData$anniex_release().put("url", str);
        }
    }

    public final String getSecLinkScene() {
        Object obj = getInnerData$anniex_release().get("sec_link_scene");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public final void setSecLinkScene(String str) {
        this.secLinkScene = str;
        if (str != null) {
            getInnerData$anniex_release().put("sec_link_scene", str);
        }
    }

    public final ArgusSwitch getSecLinkMode() {
        Object obj = getInnerData$anniex_release().get("sec_link_mode");
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        if (num != null) {
            return new ArgusSwitch(Integer.valueOf(num.intValue()));
        }
        return null;
    }

    public final void setSecLinkMode(ArgusSwitch argusSwitch) {
        Integer mode;
        this.secLinkMode = argusSwitch;
        if (argusSwitch == null || (mode = argusSwitch.getMode()) == null) {
            return;
        }
        getInnerData$anniex_release().put("sec_link_mode", Integer.valueOf(mode.intValue()));
    }

    public final SecLinkCheckCallback getSecLinkCheckCallback() {
        return this.secLinkCheckCallback;
    }

    public final void setSecLinkCheckCallback(SecLinkCheckCallback secLinkCheckCallback) {
        this.secLinkCheckCallback = secLinkCheckCallback;
    }

    public final Map<String, String> getHeaders() {
        Object obj = getInnerData$anniex_release().get("headers");
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final void setHeaders(Map<String, String> map) {
        this.headers = map;
        if (map != null) {
            getInnerData$anniex_release().put("headers", map);
        }
    }

    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public JSONObject toMonitorObject(ArgusVerifyAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return ArgusGsonUtils.INSTANCE.safeToJSONObject$anniex_release(getInnerData$anniex_release());
    }
}
