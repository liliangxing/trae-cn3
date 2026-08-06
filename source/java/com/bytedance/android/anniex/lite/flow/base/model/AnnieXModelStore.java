package com.bytedance.android.anniex.lite.flow.base.model;

import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXModelStore.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0013\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0005H\u0086\u0002J\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0006R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModelStore;", "", "()V", "mMap", "Ljava/util/HashMap;", "", "Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModel;", "Lkotlin/collections/HashMap;", "clear", "", "get", "key", "put", "AnnieXModel", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class AnnieXModelStore {
    private final HashMap<String, AnnieXModel> mMap = new HashMap<>();

    public final void put(String key, AnnieXModel AnnieXModel) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(AnnieXModel, "AnnieXModel");
        AnnieXModel put = this.mMap.put(key, AnnieXModel);
        if (put != null) {
            put.clear();
        }
    }

    public final AnnieXModel get(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mMap.get(key);
    }

    public final void clear() {
        Iterator<AnnieXModel> it = this.mMap.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.mMap.clear();
    }
}
