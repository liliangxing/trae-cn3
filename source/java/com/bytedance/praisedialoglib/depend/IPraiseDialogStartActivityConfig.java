package com.bytedance.praisedialoglib.depend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes4.dex */
public interface IPraiseDialogStartActivityConfig {
    void startActivity(Context context, Intent intent);

    void startActivityForResult(Activity activity, Intent intent, int i);
}
