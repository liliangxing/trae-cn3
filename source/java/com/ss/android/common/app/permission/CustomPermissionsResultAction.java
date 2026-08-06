package com.ss.android.common.app.permission;

import android.os.Looper;

/* loaded from: classes7.dex */
public abstract class CustomPermissionsResultAction extends PermissionsResultAction {
    public abstract void onCustomAction(String[] strArr);

    public CustomPermissionsResultAction() {
    }

    public CustomPermissionsResultAction(Looper looper) {
        super(looper);
    }
}
