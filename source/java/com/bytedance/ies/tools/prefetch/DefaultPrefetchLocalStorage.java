package com.bytedance.ies.tools.prefetch;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Collection;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: Interfaces.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u001e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016R#\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/DefaultPrefetchLocalStorage;", "Lcom/bytedance/ies/tools/prefetch/ILocalStorage;", "context", "Landroid/content/Context;", "spKey", "", "(Landroid/content/Context;Ljava/lang/String;)V", "cacheShared", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getCacheShared", "()Landroid/content/SharedPreferences;", "cacheShared$delegate", "Lkotlin/Lazy;", "getString", "key", "getStringSet", "", "putString", "", "value", "putStringSet", "collection", "remove", "removeAll", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class DefaultPrefetchLocalStorage implements ILocalStorage {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {(KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultPrefetchLocalStorage.class), "cacheShared", "getCacheShared()Landroid/content/SharedPreferences;"))};

    /* renamed from: cacheShared$delegate, reason: from kotlin metadata */
    private final Lazy cacheShared;
    private final Context context;

    private final SharedPreferences getCacheShared() {
        Lazy lazy = this.cacheShared;
        KProperty kProperty = $$delegatedProperties[0];
        return (SharedPreferences) lazy.getValue();
    }

    public DefaultPrefetchLocalStorage(Context context, final String str) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "spKey");
        this.context = context;
        this.cacheShared = LazyKt.lazy(new Function0<SharedPreferences>() { // from class: com.bytedance.ies.tools.prefetch.DefaultPrefetchLocalStorage$cacheShared$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final SharedPreferences m613invoke() {
                Context context2;
                context2 = DefaultPrefetchLocalStorage.this.context;
                return context2.getSharedPreferences(str, 0);
            }
        });
    }

    @Override // com.bytedance.ies.tools.prefetch.ILocalStorage
    public String getString(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return getCacheShared().getString(key, null);
    }

    @Override // com.bytedance.ies.tools.prefetch.ILocalStorage
    public Collection<String> getStringSet(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return getCacheShared().getStringSet(key, null);
    }

    @Override // com.bytedance.ies.tools.prefetch.ILocalStorage
    public void putString(String key, String value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        getCacheShared().edit().putString(key, value).apply();
    }

    @Override // com.bytedance.ies.tools.prefetch.ILocalStorage
    public void putStringSet(String key, Collection<String> collection) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(collection, "collection");
        if (collection instanceof Set) {
            getCacheShared().edit().putStringSet(key, (Set) collection).apply();
        }
    }

    @Override // com.bytedance.ies.tools.prefetch.ILocalStorage
    public void remove(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        getCacheShared().edit().remove(key).apply();
    }

    @Override // com.bytedance.ies.tools.prefetch.ILocalStorage
    public void removeAll() {
        getCacheShared().edit().clear().apply();
    }
}
