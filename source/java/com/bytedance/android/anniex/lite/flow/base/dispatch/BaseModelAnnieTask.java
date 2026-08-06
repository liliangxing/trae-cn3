package com.bytedance.android.anniex.lite.flow.base.dispatch;

import com.bytedance.android.anniex.lite.flow.base.dispatch.IAnnieTask;
import com.bytedance.android.anniex.lite.flow.base.model.AnnieXModelProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: IAnnieXTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/base/dispatch/BaseModelAnnieTask;", "Lcom/bytedance/android/anniex/lite/flow/base/dispatch/IAnnieTask;", "Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModelProvider;", "config", "Lcom/bytedance/android/anniex/lite/flow/base/dispatch/LoadFlowTask;", "(Lcom/bytedance/android/anniex/lite/flow/base/dispatch/LoadFlowTask;)V", "getConfig", "()Lcom/bytedance/android/anniex/lite/flow/base/dispatch/LoadFlowTask;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class BaseModelAnnieTask implements IAnnieTask<AnnieXModelProvider> {
    private final LoadFlowTask config;

    public BaseModelAnnieTask(LoadFlowTask loadFlowTask) {
        Intrinsics.checkNotNullParameter(loadFlowTask, "config");
        this.config = loadFlowTask;
    }

    public final LoadFlowTask getConfig() {
        return this.config;
    }

    /* renamed from: work, reason: avoid collision after fix types in other method */
    public Object work2(CoroutineScope coroutineScope, AnnieXModelProvider annieXModelProvider, Continuation<? super Unit> continuation) {
        return IAnnieTask.DefaultImpls.work(this, coroutineScope, annieXModelProvider, continuation);
    }

    @Override // com.bytedance.android.anniex.lite.flow.base.dispatch.IAnnieTask
    public /* bridge */ /* synthetic */ Object work(CoroutineScope coroutineScope, AnnieXModelProvider annieXModelProvider, Continuation continuation) {
        return work2(coroutineScope, annieXModelProvider, (Continuation<? super Unit>) continuation);
    }
}
