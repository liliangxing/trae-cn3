package com.bytedance.push.settings.storage;

import android.net.Uri;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class Item {
    String key;
    String storageKey;
    String type;
    String value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Item(String str, String str2, String str3, String str4) {
        this.storageKey = str;
        this.key = str2;
        this.value = str3;
        this.type = str4;
    }

    public static Item create(Uri uri) {
        List<String> pathSegments;
        if (uri == null || (pathSegments = uri.getPathSegments()) == null || pathSegments.size() < 4) {
            return null;
        }
        return new Item(pathSegments.get(0), pathSegments.get(1), pathSegments.get(2), pathSegments.get(3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Uri toUri(Uri uri) {
        return uri.buildUpon().appendPath(this.storageKey).appendPath(this.key).appendPath(this.value).appendPath(this.type).build();
    }
}
