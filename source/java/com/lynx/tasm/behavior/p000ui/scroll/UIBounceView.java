package com.lynx.tasm.behavior.p000ui.scroll;

import android.content.Context;
import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.p000ui.view.AndroidView;
import com.lynx.tasm.behavior.p000ui.view.UISimpleView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIBounceView extends UISimpleView<AndroidView> {
    public static final int BOTTOM = 3;
    public static final int LEFT = 1;
    public static final int RIGHT = 0;
    public static final int TOP = 2;
    public int mDirection;

    public UIBounceView(LynxContext lynxContext) {
        this(lynxContext, null);
    }

    public UIBounceView(LynxContext lynxContext, Object obj) {
        super(lynxContext, obj);
        this.mDirection = 0;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI
    public AndroidView createView(Context context) {
        return new AndroidView(context);
    }

    @LynxProp(customType = PropsConstants.HIT_SLOP_RIGHT, name = PropsConstants.DRIECTION)
    public void setDirection(Dynamic dynamic) {
        if (dynamic.getType() == ReadableType.String) {
            String asString = dynamic.asString();
            if (asString.equals(PropsConstants.HIT_SLOP_RIGHT)) {
                this.mDirection = 0;
                return;
            }
            if (asString.equals(PropsConstants.HIT_SLOP_LEFT)) {
                this.mDirection = 1;
            } else if (asString.equals(PropsConstants.HIT_SLOP_TOP)) {
                this.mDirection = 2;
            } else if (asString.equals(PropsConstants.HIT_SLOP_BOTTOM)) {
                this.mDirection = 3;
            }
        }
    }
}
