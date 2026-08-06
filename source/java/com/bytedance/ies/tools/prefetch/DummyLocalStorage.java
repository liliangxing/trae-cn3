package com.bytedance.ies.tools.prefetch;

import com.bytedance.ies.tools.prefetch.ILocalStorage;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Interfaces.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u001e\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/DummyLocalStorage;", "Lcom/bytedance/ies/tools/prefetch/ILocalStorage;", "()V", "getString", "", "key", "getStringSet", "", "putString", "", "value", "putStringSet", "collection", "remove", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public final class DummyLocalStorage implements ILocalStorage {
    @Override // com.bytedance.ies.tools.prefetch.ILocalStorage
    public String getString(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return null;
    }

    @Override // com.bytedance.ies.tools.prefetch.ILocalStorage
    public Collection<String> getStringSet(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return null;
    }

    @Override // com.bytedance.ies.tools.prefetch.ILocalStorage
    public void putString(String key, String value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
    }

    @Override // com.bytedance.ies.tools.prefetch.ILocalStorage
    public void putStringSet(String key, Collection<String> collection) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(collection, "collection");
    }

    @Override // com.bytedance.ies.tools.prefetch.ILocalStorage
    public void remove(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
    }

    @Override // com.bytedance.ies.tools.prefetch.ILocalStorage
    public void removeAll() {
        ILocalStorage.DefaultImpls.removeAll(this);
    }
}
