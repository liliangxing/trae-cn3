package com.bytedance.android.monitorV2.jsb;

import android.view.View;
import com.bytedance.android.monitorV2.entity.NativeCommon;

/* loaded from: classes3.dex */
interface Icache {
    NativeCommon getNativeCommon(View view, String str);

    String getUrl(View view);

    boolean isMatch(View view);
}
