package com.bytedance.ies.web.jsbridge2;

import android.text.TextUtils;
import com.bytedance.ies.web.jsbridge2.TimeLineEvent;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeCall;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes4.dex */
public class Js2JavaCall {
    private static final int CODE_SUCCEED = 1;
    public final String callbackId;
    public final int code;
    public final String iFrameUrl;
    public final List<TimeLineEvent> jsbCallTimeLineEvents;
    public final String methodName;
    public final String namespace;
    public final String params;
    public final String safeV1AuthUrl;
    public final Boolean shouldHook;
    public final String type;
    public final String version;

    public static Builder builder() {
        return new Builder();
    }

    public static Js2JavaCall invalidCall(String str, int i) {
        return new Js2JavaCall(str, i);
    }

    private Js2JavaCall(String str, int i) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.jsbCallTimeLineEvents = copyOnWriteArrayList;
        this.version = null;
        this.type = null;
        this.methodName = null;
        this.params = null;
        this.callbackId = str;
        this.namespace = null;
        this.code = i;
        this.iFrameUrl = null;
        this.safeV1AuthUrl = null;
        this.shouldHook = false;
        TimeLineEvent.Builder.instance().setExtraItem("callbackId", str).setExtraItem("code", Integer.valueOf(i)).bind(TimeLineEvent.Constants.LABEL_CREATE_JAVA_CALL, copyOnWriteArrayList);
    }

    private Js2JavaCall(Builder builder) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.jsbCallTimeLineEvents = copyOnWriteArrayList;
        String str = builder.version;
        this.version = str;
        String str2 = builder.type;
        this.type = str2;
        String str3 = builder.methodName;
        this.methodName = str3;
        String str4 = builder.params;
        this.params = str4;
        String str5 = builder.callbackId;
        this.callbackId = str5;
        String str6 = builder.namespace;
        this.namespace = str6;
        this.code = 1;
        String str7 = builder.iFrameUrl;
        this.iFrameUrl = str7;
        String str8 = builder.safeV1AuthUrl;
        this.safeV1AuthUrl = str8;
        this.shouldHook = builder.shouldHook;
        TimeLineEvent.Builder.instance().setExtraItem("version", str).setExtraItem("type", str2).setExtraItem("methodName", str3).setExtraItem("params", str4).setExtraItem(LynxBridgeCall.NAME_SPACE, str6).setExtraItem("callbackId", str5).setExtraItem(LynxBridgeCall.NAME_SPACE, str6).setExtraItem("iFrameUrl", str7).setExtraItem("safeV1AuthUrl", str8).bind(TimeLineEvent.Constants.LABEL_CREATE_JAVA_CALL, copyOnWriteArrayList);
    }

    public static boolean isInvalid(Js2JavaCall js2JavaCall) {
        return js2JavaCall == null || js2JavaCall.code != 1 || TextUtils.isEmpty(js2JavaCall.methodName) || TextUtils.isEmpty(js2JavaCall.params);
    }

    public String toString() {
        return "methodName: " + this.methodName + ", params: " + this.params + ", callbackId: " + this.callbackId + ", type: " + this.type + ", iFrameUrl: " + (TextUtils.isEmpty(this.iFrameUrl) ? TimeLineEvent.Constants.NULL : this.iFrameUrl) + ", safeV1AuthUrl: " + (TextUtils.isEmpty(this.safeV1AuthUrl) ? TimeLineEvent.Constants.NULL : this.safeV1AuthUrl) + ", version: " + this.version + ", ";
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        private String callbackId;
        private String iFrameUrl;
        private String methodName;
        private String namespace;
        private String params;
        private String safeV1AuthUrl;
        private Boolean shouldHook;
        private String type;
        private String version;

        private Builder() {
            this.shouldHook = false;
        }

        public Builder shouldHook(Boolean bool) {
            this.shouldHook = bool;
            return this;
        }

        public Builder setVersion(String str) {
            this.version = str;
            return this;
        }

        public Builder setType(String str) {
            this.type = str;
            return this;
        }

        public Builder setMethodName(String str) {
            this.methodName = str;
            return this;
        }

        public Builder setParams(String str) {
            this.params = str;
            return this;
        }

        public Builder setCallbackId(String str) {
            this.callbackId = str;
            return this;
        }

        public Builder setNamespace(String str) {
            this.namespace = str;
            return this;
        }

        public Builder setIFrameUrl(String str) {
            this.iFrameUrl = str;
            return this;
        }

        public Builder setSafeV1AuthUrl(String str) {
            this.safeV1AuthUrl = str;
            return this;
        }

        public Js2JavaCall build() {
            return new Js2JavaCall(this);
        }
    }
}
