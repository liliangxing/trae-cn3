package com.lynx.tasm.behavior.p000ui.view;

import android.content.Context;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ComponentView extends AndroidView {
    private int mPosition;

    public ComponentView(Context context) {
        super(context);
    }

    public int getPosition() {
        return this.mPosition;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }
}
