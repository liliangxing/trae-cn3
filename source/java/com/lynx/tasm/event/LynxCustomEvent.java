package com.lynx.tasm.event;

import com.lynx.tasm.event.LynxEvent;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class LynxCustomEvent extends LynxEvent {
    protected Map<String, Object> mParams;

    public String paramsName() {
        return "params";
    }

    public LynxCustomEvent(int i, String str) {
        super(i, str, LynxEvent.LynxEventType.kCustom);
        this.mParams = new HashMap();
    }

    public LynxCustomEvent(int i, String str, Map<String, Object> map) {
        super(i, str, LynxEvent.LynxEventType.kCustom);
        this.mParams = map;
    }

    public Map<String, Object> eventParams() {
        return this.mParams;
    }

    public void addDetail(String str, Object obj) {
        if (this.mParams == null) {
            this.mParams = new HashMap();
        }
        this.mParams.put(str, obj);
    }
}
