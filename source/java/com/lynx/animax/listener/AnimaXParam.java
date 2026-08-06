package com.lynx.animax.listener;

import java.util.Map;

/* loaded from: classes6.dex */
public class AnimaXParam {
    private static final String KEY_ANIMATION_ID = "animationID";
    private static final String KEY_CURRENT = "current";
    private static final String KEY_ELEMENT_ID = "elementID";
    private static final String KEY_LOOP_INDEX = "loopIndex";
    private static final String KEY_TOTAL = "total";
    private Map<String, Object> mOriginParams;

    public AnimaXParam(Map<String, Object> map) {
        this.mOriginParams = map;
    }

    public String getAnimationID() {
        return getString(KEY_ANIMATION_ID);
    }

    public float getCurrentFrame() {
        return getFloat("current");
    }

    public float getTotalFrame() {
        return getFloat("total");
    }

    public int getLoopIndex() {
        return getInt(KEY_LOOP_INDEX);
    }

    public Map<String, Object> getOriginParams() {
        return this.mOriginParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getInt(String str) {
        Object obj = this.mOriginParams.get(str);
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getFloat(String str) {
        Object obj = this.mOriginParams.get(str);
        if (obj instanceof Number) {
            return ((Number) obj).floatValue();
        }
        return -1.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getString(String str) {
        Object obj = this.mOriginParams.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }
}
