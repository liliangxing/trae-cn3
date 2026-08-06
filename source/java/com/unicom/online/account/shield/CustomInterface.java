package com.unicom.online.account.shield;

import android.content.Context;
import android.content.Intent;
import android.widget.RelativeLayout;

/* loaded from: classes7.dex */
public abstract class CustomInterface {
    public boolean checkBoxUncheckedIndication(Context context) {
        return false;
    }

    public void onActivityResult(Context context, int i, int i2, Intent intent) {
    }

    public void onCheckStateChange(boolean z) {
    }

    public void onCustomLayout(Context context, RelativeLayout relativeLayout) {
    }

    public void onUserClickLoginBtn(Context context, String str) {
    }
}
