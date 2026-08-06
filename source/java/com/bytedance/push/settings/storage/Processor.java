package com.bytedance.push.settings.storage;

import android.content.Context;
import android.os.Bundle;

/* loaded from: classes4.dex */
public interface Processor {
    String getMethodName();

    Bundle process(Context context, String str, Bundle bundle, String str2);
}
