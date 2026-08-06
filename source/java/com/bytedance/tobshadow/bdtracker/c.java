package com.bytedance.tobshadow.bdtracker;

import android.text.TextUtils;
import com.bytedance.tobshadow.applog.store.kv.IKVStore;
import java.util.UUID;

/* loaded from: classes5.dex */
public final class c {
    public static b<String> a = new a();

    /* loaded from: classes5.dex */
    public static class a extends b<String> {
        @Override // com.bytedance.tobshadow.bdtracker.b
        public String a(Object[] objArr) {
            IKVStore iKVStore = (IKVStore) objArr[0];
            String string = iKVStore.getString("cdid", "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            String uuid = UUID.randomUUID().toString();
            iKVStore.putString("cdid", uuid);
            return uuid;
        }
    }
}
