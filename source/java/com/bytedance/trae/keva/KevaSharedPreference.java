package com.bytedance.trae.keva;

import android.content.SharedPreferences;
import com.bytedance.keva.Keva;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KevaSharedPreference.kt */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010#\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0011\u0018\u00002\u00020\u00012\u00020\u0002:\u0001;B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\u001a\u0010\u0018\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u001a\u0010\u001a\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u001eH\u0016JK\u0010\u001f\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00040\u0004 \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00040\u0004\u0018\u00010!0 2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u0010#J)\u0010$\u001a\n \u000b*\u0004\u0018\u00010\u00040\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010%J'\u0010&\u001a\n \u000b*\u0004\u0018\u00010'0'2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010'¢\u0006\u0002\u0010(J\u001a\u0010)\u001a\u00020*2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010+\u001a\u0004\u0018\u00010'JM\u0010,\u001a(\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00040\u0004 \u000b*\u0014\u0012\u000e\b\u0001\u0012\n \u000b*\u0004\u0018\u00010\u00040\u0004\u0018\u00010-0-2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010-¢\u0006\u0002\u0010.J'\u0010/\u001a\u00020*2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0010\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010-¢\u0006\u0002\u00101J\u0012\u00102\u001a\f\u0012\u0004\u0012\u00020\u0004\u0012\u0002\b\u000303H\u0016J\b\u00104\u001a\u000205H\u0016J\u0012\u00106\u001a\u00020*2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0012\u00109\u001a\u00020*2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u001c\u0010:\u001a\u00020*2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0016R#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013¨\u0006<"}, d2 = {"Lcom/bytedance/trae/keva/KevaSharedPreference;", "Landroid/content/SharedPreferences;", "Lcom/bytedance/keva/Keva$OnChangeListener;", "fileName", "", "mode", "", "<init>", "(Ljava/lang/String;I)V", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getKeva", "()Lcom/bytedance/keva/Keva;", "keva$delegate", "Lkotlin/Lazy;", "listeners", "com/bytedance/trae/keva/KevaSharedPreference$listeners$2$1", "getListeners", "()Lcom/bytedance/trae/keva/KevaSharedPreference$listeners$2$1;", "listeners$delegate", "contains", "", "key", "getBoolean", "defValue", "getInt", "getLong", "", "getFloat", "", "getStringSet", "", "", "defValues", "(Ljava/lang/String;Ljava/util/Set;)Ljava/util/Set;", "getString", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "getBytes", "", "(Ljava/lang/String;[B)[B", "putBytes", "", "bytes", "getStringArray", "", "(Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;", "putStringArray", "array", "(Ljava/lang/String;[Ljava/lang/String;)V", "getAll", "", "edit", "Landroid/content/SharedPreferences$Editor;", "registerOnSharedPreferenceChangeListener", "listener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "unregisterOnSharedPreferenceChangeListener", "onChanged", "KevaPrefEdit", "keva_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class KevaSharedPreference implements SharedPreferences, Keva.OnChangeListener {

    /* renamed from: keva$delegate, reason: from kotlin metadata */
    private final Lazy keva;

    /* renamed from: listeners$delegate, reason: from kotlin metadata */
    private final Lazy listeners;

    public KevaSharedPreference(final String str, final int i) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        this.keva = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.keva.KevaSharedPreference$$ExternalSyntheticLambda0
            public final Object invoke() {
                Keva keva_delegate$lambda$0;
                keva_delegate$lambda$0 = KevaSharedPreference.keva_delegate$lambda$0(str, i);
                return keva_delegate$lambda$0;
            }
        });
        this.listeners = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.keva.KevaSharedPreference$$ExternalSyntheticLambda1
            public final Object invoke() {
                KevaSharedPreference$listeners$2$1 listeners_delegate$lambda$1;
                listeners_delegate$lambda$1 = KevaSharedPreference.listeners_delegate$lambda$1(KevaSharedPreference.this);
                return listeners_delegate$lambda$1;
            }
        });
    }

    public /* synthetic */ KevaSharedPreference(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Keva getKeva() {
        return (Keva) this.keva.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Keva keva_delegate$lambda$0(String str, int i) {
        if (i == 4) {
            i = 1;
        }
        return Keva.getRepo(str, i);
    }

    private final KevaSharedPreference$listeners$2$1 getListeners() {
        return (KevaSharedPreference$listeners$2$1) this.listeners.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.trae.keva.KevaSharedPreference$listeners$2$1] */
    public static final KevaSharedPreference$listeners$2$1 listeners_delegate$lambda$1(final KevaSharedPreference kevaSharedPreference) {
        return new SyncWeakListenerRegister<SharedPreferences.OnSharedPreferenceChangeListener>() { // from class: com.bytedance.trae.keva.KevaSharedPreference$listeners$2$1
            @Override // com.bytedance.trae.keva.SyncWeakListenerRegister
            protected void onListenerCountChanged(int size) {
                Keva keva;
                Keva keva2;
                if (size == 0) {
                    keva = KevaSharedPreference.this.getKeva();
                    keva.unRegisterChangeListener(KevaSharedPreference.this);
                } else {
                    if (size != 1) {
                        return;
                    }
                    keva2 = KevaSharedPreference.this.getKeva();
                    keva2.registerChangeListener(KevaSharedPreference.this);
                }
            }
        };
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String key) {
        Keva keva = getKeva();
        if (key == null) {
            key = "";
        }
        return keva.contains(key);
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String key, boolean defValue) {
        Keva keva = getKeva();
        if (key == null) {
            key = "";
        }
        return keva.getBoolean(key, defValue);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String key, int defValue) {
        Keva keva = getKeva();
        if (key == null) {
            key = "";
        }
        return keva.getInt(key, defValue);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String key, long defValue) {
        return getKeva().getLong(key, defValue);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String key, float defValue) {
        Keva keva = getKeva();
        if (key == null) {
            key = "";
        }
        return keva.getFloat(key, defValue);
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String key, Set<String> defValues) {
        Keva keva = getKeva();
        if (key == null) {
            key = "";
        }
        return keva.getStringSet(key, defValues);
    }

    @Override // android.content.SharedPreferences
    public String getString(String key, String defValue) {
        Keva keva = getKeva();
        if (key == null) {
            key = "";
        }
        return keva.getString(key, defValue);
    }

    public final byte[] getBytes(String key, byte[] defValue) {
        Keva keva = getKeva();
        if (key == null) {
            key = "";
        }
        return keva.getBytes(key, defValue);
    }

    public final void putBytes(String key, byte[] bytes) {
        getKeva().storeBytes(key, bytes);
    }

    public final String[] getStringArray(String key, String[] defValue) {
        return getKeva().getStringArray(key, defValue);
    }

    public final void putStringArray(String key, String[] array) {
        getKeva().storeStringArray(key, array);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        Map<String, ?> all = getKeva().getAll();
        Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
        return all;
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        Keva keva = getKeva();
        Intrinsics.checkNotNullExpressionValue(keva, "<get-keva>(...)");
        return new KevaPrefEdit(keva);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        getListeners().registerListener(listener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        getListeners().unregisterListener(listener);
    }

    public void onChanged(Keva keva, String key) {
        Iterator<T> it = getListeners().getListeners().iterator();
        while (it.hasNext()) {
            ((SharedPreferences.OnSharedPreferenceChangeListener) it.next()).onSharedPreferenceChanged(this, key);
        }
    }

    /* compiled from: KevaSharedPreference.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0001H\u0016J\u001a\u0010\u0007\u001a\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u0011\u001a\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0012H\u0016J\"\u0010\u0013\u001a\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/keva/KevaSharedPreference$KevaPrefEdit;", "Landroid/content/SharedPreferences$Editor;", "sp", "Lcom/bytedance/keva/Keva;", "<init>", "(Lcom/bytedance/keva/Keva;)V", "clear", "putLong", "key", "", "value", "", "putInt", "", "putFloat", "", "putString", "putBoolean", "", "putStringSet", "values", "", "remove", "commit", "apply", "", "keva_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    private static final class KevaPrefEdit implements SharedPreferences.Editor {
        private final Keva sp;

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return true;
        }

        public KevaPrefEdit(Keva keva) {
            Intrinsics.checkNotNullParameter(keva, "sp");
            this.sp = keva;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.sp.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String key, long value) {
            Keva keva = this.sp;
            if (key == null) {
                key = "";
            }
            keva.storeLong(key, value);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String key, int value) {
            Keva keva = this.sp;
            if (key == null) {
                key = "";
            }
            keva.storeInt(key, value);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String key, float value) {
            Keva keva = this.sp;
            if (key == null) {
                key = "";
            }
            keva.storeFloat(key, value);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String key, String value) {
            Keva keva = this.sp;
            if (key == null) {
                key = "";
            }
            if (value == null) {
                value = "";
            }
            keva.storeString(key, value);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String key, boolean value) {
            Keva keva = this.sp;
            if (key == null) {
                key = "";
            }
            keva.storeBoolean(key, value);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String key, Set<String> values) {
            Keva keva = this.sp;
            if (key == null) {
                key = "";
            }
            if (values == null) {
                values = new LinkedHashSet();
            }
            keva.storeStringSet(key, values);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String key) {
            this.sp.erase(key);
            return this;
        }
    }
}
