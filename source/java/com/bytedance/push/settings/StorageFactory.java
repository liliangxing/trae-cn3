package com.bytedance.push.settings;

import android.content.Context;
import com.bytedance.push.settings.storage.Storage;

/* loaded from: classes4.dex */
public interface StorageFactory {
    Storage create(Context context, boolean z, String str, String str2);
}
