package com.lynx.tasm.behavior.p000ui.view;

import android.content.Context;
import android.view.ViewGroup;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.p000ui.UIGroup;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class UISimpleView<T extends ViewGroup> extends UIGroup<T> {
    @Deprecated
    public UISimpleView(Context context) {
        this((LynxContext) context);
    }

    public UISimpleView(LynxContext lynxContext) {
        this(lynxContext, null);
    }

    public UISimpleView(LynxContext lynxContext, Object obj) {
        super(lynxContext, obj);
    }
}
