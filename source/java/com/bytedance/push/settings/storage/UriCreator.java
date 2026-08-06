package com.bytedance.push.settings.storage;

import android.content.Context;
import android.net.Uri;

/* loaded from: classes4.dex */
public interface UriCreator {
    Uri getContentUri(Context context, Item item);
}
