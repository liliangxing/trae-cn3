package com.lynx.tasm.behavior;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import com.lynx.tasm.utils.ContextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class LynxBaseContext extends MutableContextWrapper {
    private boolean mHasAttached;
    private MutableContextWrapper mWrapper;

    public LynxBaseContext(Context context) {
        super(context);
        this.mHasAttached = false;
        MutableContextWrapper mutableContextWrapper = new MutableContextWrapper(null);
        this.mWrapper = mutableContextWrapper;
        mutableContextWrapper.setBaseContext(context);
    }

    @Override // android.content.MutableContextWrapper
    public void setBaseContext(Context context) {
        super.setBaseContext(context);
        this.mWrapper.setBaseContext(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setHasLynxViewAttached(boolean z) {
        this.mHasAttached = z;
    }

    public Context getContext() {
        if (this.mHasAttached) {
            return getBaseContext();
        }
        return this.mWrapper;
    }

    public Activity getActivity() {
        return ContextUtils.getActivity(this);
    }
}
