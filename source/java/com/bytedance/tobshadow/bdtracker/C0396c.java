package com.bytedance.tobshadow.bdtracker;

import android.text.TextUtils;
import com.bytedance.tobshadow.applog.store.p007kv.IKVStore;
import java.util.UUID;

/* renamed from: com.bytedance.tobshadow.bdtracker.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0396c {

    /* renamed from: a */
    public static AbstractC0388b<String> f476a = new a();

    /* renamed from: com.bytedance.tobshadow.bdtracker.c$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class a extends AbstractC0388b<String> {
        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0388b
        /* renamed from: a */
        public String mo276a(Object[] objArr) {
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
