package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.applog.store.p007kv.IKVStore;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.bytedance.tobshadow.bdtracker.d5 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbstractC0410d5 implements IKVStore {

    /* renamed from: a */
    public final AtomicReference<SharedPreferences> f532a;

    /* renamed from: b */
    public final String f533b;

    /* renamed from: c */
    public final Context f534c;

    public AbstractC0410d5(String str, Context context, String str2) {
        AtomicReference<SharedPreferences> atomicReference = new AtomicReference<>();
        this.f532a = atomicReference;
        this.f533b = str;
        this.f534c = context;
        atomicReference.set(C0563z4.m764a(context, str2, 0));
    }

    /* renamed from: a */
    public abstract String mo337a();

    /* renamed from: a */
    public abstract void mo338a(String str);

    /* renamed from: a */
    public abstract void mo339a(String str, int i);

    /* renamed from: a */
    public abstract void mo340a(String str, long j);

    /* renamed from: a */
    public abstract void mo341a(String str, String str2);

    /* renamed from: a */
    public abstract void mo342a(String str, Set<String> set);

    /* renamed from: a */
    public abstract void mo343a(String str, boolean z);

    @Override // com.bytedance.tobshadow.applog.store.p007kv.IKVStore
    public IKVStore clear() {
        SharedPreferences sharedPreferences = this.f532a.get();
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().apply();
        } else {
            LoggerImpl.global().warn("[{}][KVStore]clear failed, preferences == null, key: {}", this.f533b);
        }
        return this;
    }

    @Override // com.bytedance.tobshadow.applog.store.p007kv.IKVStore
    public boolean contains(String str) {
        SharedPreferences sharedPreferences = this.f532a.get();
        if (sharedPreferences != null) {
            return sharedPreferences.contains(mo337a() + str);
        }
        LoggerImpl.global().warn("[{}][KVStore]contains failed, preferences == null, key: {}", this.f533b, str);
        return false;
    }

    @Override // com.bytedance.tobshadow.applog.store.p007kv.IKVStore
    public Map<String, ?> getAll() {
        SharedPreferences sharedPreferences = this.f532a.get();
        if (sharedPreferences != null) {
            return sharedPreferences.getAll();
        }
        LoggerImpl.global().warn("[{}][KVStore]getAll failed, preferences == null, key: {}", this.f533b);
        return null;
    }

    @Override // com.bytedance.tobshadow.applog.store.p007kv.IKVStore
    public IKVStore putBoolean(String str, boolean z) {
        mo338a(str);
        mo343a(str, z);
        return this;
    }

    @Override // com.bytedance.tobshadow.applog.store.p007kv.IKVStore
    public IKVStore putInt(String str, int i) {
        mo338a(str);
        mo339a(str, i);
        return this;
    }

    @Override // com.bytedance.tobshadow.applog.store.p007kv.IKVStore
    public IKVStore putLong(String str, long j) {
        mo338a(str);
        mo340a(str, j);
        return this;
    }

    @Override // com.bytedance.tobshadow.applog.store.p007kv.IKVStore
    public IKVStore putString(String str, String str2) {
        mo338a(str);
        mo341a(str, str2);
        return this;
    }

    @Override // com.bytedance.tobshadow.applog.store.p007kv.IKVStore
    public IKVStore putStringSet(String str, Set<String> set) {
        mo338a(str);
        if (set == null) {
            set = new HashSet<>();
        }
        mo342a(str, set);
        return this;
    }

    @Override // com.bytedance.tobshadow.applog.store.p007kv.IKVStore
    public IKVStore remove(String str) {
        SharedPreferences sharedPreferences = this.f532a.get();
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove(mo337a() + str).apply();
        } else {
            LoggerImpl.global().warn("[{}][KVStore]remove failed, preferences == null, key: {}", this.f533b, str);
        }
        return this;
    }
}
