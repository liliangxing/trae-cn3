package com.bytedance.android.anniex.lite.flow.base.model;

import kotlin.Metadata;

/* compiled from: AnnieXModelStoreOwner.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/base/model/BaseDispatchManager;", "Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModelStoreOwner;", "()V", "mModelStore", "Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModelStore;", "getSchemaModelStore", "release", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public class BaseDispatchManager implements AnnieXModelStoreOwner {
    private final AnnieXModelStore mModelStore = new AnnieXModelStore();

    @Override // com.bytedance.android.anniex.lite.flow.base.model.AnnieXModelStoreOwner
    /* renamed from: getSchemaModelStore, reason: from getter */
    public final AnnieXModelStore getMModelStore() {
        return this.mModelStore;
    }

    public void release() {
        this.mModelStore.clear();
    }
}
