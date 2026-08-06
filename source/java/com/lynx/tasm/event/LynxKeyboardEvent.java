package com.lynx.tasm.event;

import java.util.Map;

/* loaded from: classes7.dex */
public class LynxKeyboardEvent extends LynxCustomEvent {
    public static final String KEYBOARD_STATUS_CHANGED = "keyboardstatuschanged";

    public LynxKeyboardEvent(int i, String str, Map<String, Object> map) {
        super(i, str, map);
    }
}
