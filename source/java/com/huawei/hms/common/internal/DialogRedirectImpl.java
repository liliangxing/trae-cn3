package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* loaded from: classes6.dex */
public class DialogRedirectImpl extends DialogRedirect {
    private final Activity a;
    private final int b;
    private final Intent c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogRedirectImpl(Intent intent, Activity activity, int i) {
        this.c = intent;
        this.a = activity;
        this.b = i;
    }

    @Override // com.huawei.hms.common.internal.DialogRedirect
    public final void redirect() {
        Activity activity;
        Intent intent = this.c;
        if (intent == null || (activity = this.a) == null) {
            return;
        }
        activity.startActivityForResult(intent, this.b);
    }
}
