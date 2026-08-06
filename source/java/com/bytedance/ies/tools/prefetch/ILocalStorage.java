package com.bytedance.ies.tools.prefetch;

import java.util.Collection;
import kotlin.Metadata;

/* compiled from: Interfaces.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H&J\u001e\u0010\n\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H&J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/ILocalStorage;", "", "getString", "", "key", "getStringSet", "", "putString", "", "value", "putStringSet", "collection", "remove", "removeAll", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public interface ILocalStorage {

    /* compiled from: Interfaces.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static void removeAll(ILocalStorage iLocalStorage) {
        }
    }

    String getString(String key);

    Collection<String> getStringSet(String key);

    void putString(String key, String value);

    void putStringSet(String key, Collection<String> collection);

    void remove(String key);

    void removeAll();
}
