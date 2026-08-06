package com.ss.android.common.dialog;

import java.io.Serializable;

/* loaded from: classes7.dex */
public class DialogShowEvent implements Serializable {
    private boolean isShow;
    private Object mValue;

    public DialogShowEvent(boolean z, Object obj) {
        this.isShow = z;
        this.mValue = obj;
    }

    public boolean isShow() {
        return this.isShow;
    }

    public Object getValue() {
        return this.mValue;
    }
}
