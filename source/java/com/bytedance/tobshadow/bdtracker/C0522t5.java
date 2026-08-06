package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import com.bytedance.tobshadow.applog.store.p007kv.IKVStore;

/* renamed from: com.bytedance.tobshadow.bdtracker.t5 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0522t5 {

    /* renamed from: a */
    public static boolean f1073a;

    /* renamed from: b */
    public static final AbstractC0438h5<IKVStore> f1074b = new a();

    /* renamed from: com.bytedance.tobshadow.bdtracker.t5$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class a extends AbstractC0438h5<IKVStore> {
        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0438h5
        /* renamed from: a */
        public IKVStore mo455a(Object[] objArr) {
            return C0424f5.m438a((Context) objArr[0], "ug_install_settings_pref");
        }
    }

    /* renamed from: a */
    public static boolean m705a(Context context) {
        if (context == null) {
            return false;
        }
        if (f1073a) {
            return true;
        }
        return f1074b.m456b(context).getBoolean("_install_started_v2", false);
    }
}
