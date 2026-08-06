package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.bytedance.tobshadow.bdtracker.e5 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0417e5 extends AbstractC0410d5 {
    public C0417e5(String str, Context context, String str2) {
        super(str, context, str2);
        SharedPreferences m764a = C0563z4.m764a(this.f534c, C0380a.m252a("security_store_").append(this.f533b).toString(), 0);
        if (m764a.contains("sks_kv") || !m764a.contains("sks_hash")) {
            return;
        }
        C0424f5.m440a(this.f532a.get(), this.f533b);
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0410d5
    /* renamed from: a */
    public String mo337a() {
        return "";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0410d5
    /* renamed from: a */
    public void mo338a(String str) {
        SharedPreferences sharedPreferences = this.f532a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]checkHasKVStoreSwitch failed, preferences == null, key: {}", this.f533b, str);
            return;
        }
        String m251a = C0380a.m251a("sks", str);
        if (sharedPreferences.contains(m251a)) {
            sharedPreferences.edit().remove(m251a).apply();
            LoggerImpl.global().debug("[{}][KVStore]BaseKVStore remove raw key: {}", this.f533b, m251a);
        }
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0410d5
    /* renamed from: a */
    public void mo343a(String str, boolean z) {
        SharedPreferences sharedPreferences = this.f532a.get();
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(mo337a() + str, z).apply();
        } else {
            LoggerImpl.global().warn("[{}][KVStore]putBooleanInner failed, preferences == null, key: {}", this.f533b, str);
        }
    }

    @Override // com.bytedance.tobshadow.applog.store.p007kv.IKVStore
    public boolean getBoolean(String str, boolean z) {
        boolean parseBoolean;
        SharedPreferences sharedPreferences = this.f532a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]getBoolean failed, preferences == null, key: {}", this.f533b, str);
            return z;
        }
        SharedPreferences sharedPreferences2 = this.f532a.get();
        if (sharedPreferences2 == null) {
            LoggerImpl.global().warn("[{}][KVStore]checkNeedMigrateKV failed, preferences == null, key: {}", this.f533b, str);
        } else {
            String m251a = C0380a.m251a("sks", str);
            if (sharedPreferences2.contains(m251a)) {
                String string = sharedPreferences2.getString(m251a, null);
                if (!TextUtils.isEmpty(string)) {
                    try {
                        parseBoolean = Boolean.parseBoolean(C0431g5.m447a(string, C0431g5.m448a(this.f534c, this.f533b), this.f533b));
                    } catch (Throwable th) {
                        LoggerImpl.global().error("[{}][KVStore]DefaultKVStore Boolean.parseBoolean failed, key: {}, ", th, this.f533b, str);
                    }
                    sharedPreferences2.edit().remove(m251a).apply();
                    mo338a(str);
                    mo343a(str, parseBoolean);
                    LoggerImpl.global().debug("[{}][KVStore]DefaultKVStore replace raw key: {}", this.f533b, str);
                }
                parseBoolean = z;
                sharedPreferences2.edit().remove(m251a).apply();
                mo338a(str);
                mo343a(str, parseBoolean);
                LoggerImpl.global().debug("[{}][KVStore]DefaultKVStore replace raw key: {}", this.f533b, str);
            }
        }
        return sharedPreferences.getBoolean(mo337a() + str, z);
    }

    @Override // com.bytedance.tobshadow.applog.store.p007kv.IKVStore
    public int getInt(String str, int i) {
        int parseInt;
        SharedPreferences sharedPreferences = this.f532a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]getInt failed, preferences == null, key: {}", this.f533b, str);
            return i;
        }
        SharedPreferences sharedPreferences2 = this.f532a.get();
        if (sharedPreferences2 == null) {
            LoggerImpl.global().warn("[{}][KVStore]checkNeedMigrateKV failed, preferences == null, key: {}", this.f533b, str);
        } else {
            String m251a = C0380a.m251a("sks", str);
            if (sharedPreferences2.contains(m251a)) {
                String string = sharedPreferences2.getString(m251a, null);
                if (!TextUtils.isEmpty(string)) {
                    try {
                        parseInt = Integer.parseInt(C0431g5.m447a(string, C0431g5.m448a(this.f534c, this.f533b), this.f533b));
                    } catch (Throwable th) {
                        LoggerImpl.global().error("[{}][KVStore]DefaultKVStore Integer.parseInt failed, key: {}, ", th, this.f533b, str);
                    }
                    sharedPreferences2.edit().remove(m251a).apply();
                    mo338a(str);
                    mo339a(str, parseInt);
                    LoggerImpl.global().debug("[{}][KVStore]DefaultKVStore replace raw key: {}", this.f533b, str);
                }
                parseInt = i;
                sharedPreferences2.edit().remove(m251a).apply();
                mo338a(str);
                mo339a(str, parseInt);
                LoggerImpl.global().debug("[{}][KVStore]DefaultKVStore replace raw key: {}", this.f533b, str);
            }
        }
        return sharedPreferences.getInt(mo337a() + str, i);
    }

    @Override // com.bytedance.tobshadow.applog.store.p007kv.IKVStore
    public long getLong(String str, long j) {
        long parseLong;
        SharedPreferences sharedPreferences = this.f532a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]getLong failed, preferences == null, key: {}", this.f533b, str);
            return j;
        }
        SharedPreferences sharedPreferences2 = this.f532a.get();
        if (sharedPreferences2 == null) {
            LoggerImpl.global().warn("[{}][KVStore]checkNeedMigrateKV failed, preferences == null, key: {}", this.f533b, str);
        } else {
            String m251a = C0380a.m251a("sks", str);
            if (sharedPreferences2.contains(m251a)) {
                String string = sharedPreferences2.getString(m251a, null);
                if (!TextUtils.isEmpty(string)) {
                    try {
                        parseLong = Long.parseLong(C0431g5.m447a(string, C0431g5.m448a(this.f534c, this.f533b), this.f533b));
                    } catch (Throwable th) {
                        LoggerImpl.global().error("[{}][KVStore]DefaultKVStore Long.parseLong failed, key: {}, ", th, this.f533b, str);
                    }
                    sharedPreferences2.edit().remove(m251a).apply();
                    mo338a(str);
                    mo340a(str, parseLong);
                    LoggerImpl.global().debug("[{}][KVStore]DefaultKVStore replace raw key: {}", this.f533b, str);
                }
                parseLong = j;
                sharedPreferences2.edit().remove(m251a).apply();
                mo338a(str);
                mo340a(str, parseLong);
                LoggerImpl.global().debug("[{}][KVStore]DefaultKVStore replace raw key: {}", this.f533b, str);
            }
        }
        return sharedPreferences.getLong(mo337a() + str, j);
    }

    @Override // com.bytedance.tobshadow.applog.store.p007kv.IKVStore
    public String getString(String str, String str2) {
        SharedPreferences sharedPreferences = this.f532a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]getString failed, preferences == null, key: {}", this.f533b, str);
            return str2;
        }
        SharedPreferences sharedPreferences2 = this.f532a.get();
        if (sharedPreferences2 == null) {
            LoggerImpl.global().warn("[{}][KVStore]checkNeedMigrateKV failed, preferences == null, key: {}", this.f533b, str);
        } else {
            String m251a = C0380a.m251a("sks", str);
            if (sharedPreferences2.contains(m251a)) {
                String string = sharedPreferences2.getString(m251a, null);
                String m447a = TextUtils.isEmpty(string) ? str2 : C0431g5.m447a(string, C0431g5.m448a(this.f534c, this.f533b), this.f533b);
                sharedPreferences2.edit().remove(m251a).apply();
                mo338a(str);
                mo341a(str, m447a);
                LoggerImpl.global().debug("[{}][KVStore]DefaultKVStore replace raw key: {}", this.f533b, str);
            }
        }
        return sharedPreferences.getString(mo337a() + str, str2);
    }

    @Override // com.bytedance.tobshadow.applog.store.p007kv.IKVStore
    public Set<String> getStringSet(String str, Set<String> set) {
        SharedPreferences sharedPreferences = this.f532a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]getStringSet failed, preferences == null, key: {}", this.f533b, str);
            return set;
        }
        SharedPreferences sharedPreferences2 = this.f532a.get();
        if (sharedPreferences2 == null) {
            LoggerImpl.global().warn("[{}][KVStore]checkNeedMigrateKV failed, preferences == null, key: {}", this.f533b, str);
        } else {
            String m251a = C0380a.m251a("sks", str);
            if (sharedPreferences2.contains(m251a)) {
                String string = sharedPreferences2.getString(m251a, null);
                Set<String> m450b = TextUtils.isEmpty(string) ? set : C0431g5.m450b(C0431g5.m447a(string, C0431g5.m448a(this.f534c, this.f533b), this.f533b), this.f533b);
                sharedPreferences2.edit().remove(m251a).apply();
                mo338a(str);
                if (m450b == null) {
                    m450b = new HashSet<>();
                }
                mo342a(str, m450b);
                LoggerImpl.global().debug("[{}][KVStore]DefaultKVStore replace raw key: {}", this.f533b, str);
            }
        }
        return sharedPreferences.getStringSet(mo337a() + str, set);
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0410d5
    /* renamed from: a */
    public void mo339a(String str, int i) {
        SharedPreferences sharedPreferences = this.f532a.get();
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(mo337a() + str, i).apply();
        } else {
            LoggerImpl.global().warn("[{}][KVStore]putIntInner failed, preferences == null, key: {}", this.f533b, str);
        }
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0410d5
    /* renamed from: a */
    public void mo340a(String str, long j) {
        SharedPreferences sharedPreferences = this.f532a.get();
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(mo337a() + str, j).apply();
        } else {
            LoggerImpl.global().warn("[{}][KVStore]putLongInner failed, preferences == null, key: {}", this.f533b, str);
        }
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0410d5
    /* renamed from: a */
    public void mo341a(String str, String str2) {
        if (str2 == null) {
            LoggerImpl.global().warn("[{}][KVStore]putStringInner is null, remove key: {}", this.f533b, str);
            remove(str);
            return;
        }
        SharedPreferences sharedPreferences = this.f532a.get();
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(mo337a() + str, str2).apply();
        } else {
            LoggerImpl.global().warn("[{}][KVStore]putStringInner failed, preferences == null, key: {}", this.f533b, str);
        }
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0410d5
    /* renamed from: a */
    public void mo342a(String str, Set<String> set) {
        if (set == null) {
            LoggerImpl.global().warn("[{}][KVStore]putStringSetInner is null, remove key: {}", this.f533b, str);
            remove(str);
            return;
        }
        SharedPreferences sharedPreferences = this.f532a.get();
        if (sharedPreferences != null) {
            sharedPreferences.edit().putStringSet(mo337a() + str, set).apply();
        } else {
            LoggerImpl.global().warn("[{}][KVStore]putStringSetInner failed, preferences == null, key: {}", this.f533b, str);
        }
    }
}
