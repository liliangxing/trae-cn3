package com.lynx.jsbridge;

import android.text.TextUtils;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.WritableMap;
import com.lynx.tasm.animation.AnimationConstant;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.text.TextHelper;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxTextInfoModule extends LynxContextModule {
    public static final String NAME = "LynxTextInfoModule";

    public LynxTextInfoModule(LynxContext lynxContext) {
        super(lynxContext);
    }

    public LynxTextInfoModule(LynxContext lynxContext, Object obj) {
        super(lynxContext, obj);
    }

    @LynxMethod
    WritableMap getTextInfo(String str, ReadableMap readableMap) {
        String string = readableMap.getString("fontSize");
        if (TextUtils.isEmpty(string)) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            javaOnlyMap.putInt(AnimationConstant.PROP_STR_WIDTH, 0);
            return javaOnlyMap;
        }
        return TextHelper.getTextInfo(str, string, readableMap.getString("fontFamily"), readableMap.getString("maxWidth"), readableMap.hasKey("maxLine") ? readableMap.getInt("maxLine") : 1);
    }
}
