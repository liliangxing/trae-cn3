package com.bytedance.push.settings;

import android.content.Context;

/* loaded from: classes4.dex */
public interface ILocalSettings {
    void registerValChanged(Context context, String str, String str2, IDataChangedListener iDataChangedListener);

    void unregisterValChanged(IDataChangedListener iDataChangedListener);
}
