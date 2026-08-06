package com.lynx.tasm.event;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class LynxImpressionEvent extends LynxCustomEvent {
    public static final String EVENT_ATTACH = "attach";
    public static final String EVENT_DETACH = "detach";
    private HashMap<String, Object> mParams;
    private String mParamsName;

    public LynxImpressionEvent(int i, String str) {
        super(i, str);
    }

    public static LynxImpressionEvent createAttachEvent(int i) {
        return new LynxImpressionEvent(i, EVENT_ATTACH);
    }

    public static LynxImpressionEvent createDetachEvent(int i) {
        return new LynxImpressionEvent(i, EVENT_DETACH);
    }

    public static LynxImpressionEvent createImpressionEvent(int i, String str) {
        return new LynxImpressionEvent(i, str);
    }

    public void setParmas(String str, HashMap<String, Object> hashMap) {
        this.mParamsName = str;
        this.mParams = hashMap;
    }

    @Override // com.lynx.tasm.event.LynxCustomEvent
    public Map<String, Object> eventParams() {
        HashMap<String, Object> hashMap = this.mParams;
        return hashMap == null ? new HashMap() : hashMap;
    }

    @Override // com.lynx.tasm.event.LynxCustomEvent
    public String paramsName() {
        String str = this.mParamsName;
        return str != null ? str : "params";
    }
}
