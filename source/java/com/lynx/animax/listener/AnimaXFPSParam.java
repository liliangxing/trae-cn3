package com.lynx.animax.listener;

import java.util.Map;

/* loaded from: classes6.dex */
public class AnimaXFPSParam extends AnimaXParam {
    private static final String KEY_FPS = "fps";
    private static final String KEY_MAX_DROP_RATE = "max_drop_rate";

    public AnimaXFPSParam(Map<String, Object> map) {
        super(map);
    }

    public float getFPS() {
        return getFloat("fps");
    }

    public float getMaxDropRate() {
        return getFloat(KEY_MAX_DROP_RATE);
    }
}
