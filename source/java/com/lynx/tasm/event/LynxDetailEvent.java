package com.lynx.tasm.event;

import java.util.Map;

@Deprecated
/* loaded from: classes7.dex */
public class LynxDetailEvent extends LynxCustomEvent {
    @Override // com.lynx.tasm.event.LynxCustomEvent
    public String paramsName() {
        return "detail";
    }

    public LynxDetailEvent(int i, String str) {
        super(i, str);
    }

    public LynxDetailEvent(int i, String str, Map<String, Object> map) {
        super(i, str, map);
    }

    @Override // com.lynx.tasm.event.LynxCustomEvent
    public Map<String, Object> eventParams() {
        return this.mParams;
    }
}
