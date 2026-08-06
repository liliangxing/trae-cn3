package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.util.Constants;
import com.bytedance.tobshadow.applog.store.kv.IKVStore;

/* loaded from: classes5.dex */
public class t5 {
    public static boolean a;
    public static final h5<IKVStore> b = new a();

    /* loaded from: classes5.dex */
    public static class a extends h5<IKVStore> {
        @Override // com.bytedance.tobshadow.bdtracker.h5
        public IKVStore a(Object[] objArr) {
            return f5.a((Context) objArr[0], Constants.SP_INSTALL);
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        if (a) {
            return true;
        }
        return b.b(context).getBoolean(Api.KEY_STARTED, false);
    }
}
