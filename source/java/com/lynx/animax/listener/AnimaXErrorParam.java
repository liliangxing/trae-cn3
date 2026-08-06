package com.lynx.animax.listener;

import java.util.Map;

/* loaded from: classes6.dex */
public class AnimaXErrorParam extends AnimaXParam {
    public static final String KEY_CODE = "code";
    public static final String KEY_MESSAGE = "msg";

    public AnimaXErrorParam(Map<String, Object> map) {
        super(map);
    }

    public int getErrorCode() {
        return getInt("code");
    }

    public String getErrorMessage() {
        return getString("msg");
    }
}
