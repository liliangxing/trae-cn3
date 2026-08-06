package com.bytedance.android.anniex.lite.flow.model;

import com.bytedance.android.anniex.lite.flow.base.BaseAnnieXModel;
import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: AnnieXWebPreloadStateModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u001aR\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/model/AnnieXWebPreloadStateModel;", "Lcom/bytedance/android/anniex/lite/flow/base/BaseAnnieXModel;", "()V", "_schemaUnion", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "_webEngine", "Lcom/bytedance/android/anniex/web/AnnieXWebKit;", "_webModel", "Lcom/bytedance/android/anniex/web/model/AnnieXWebModel;", "schemaModelUnion", "Lkotlinx/coroutines/flow/StateFlow;", "getSchemaModelUnion", "()Lkotlinx/coroutines/flow/StateFlow;", "webEngine", "Lkotlinx/coroutines/flow/SharedFlow;", "getWebEngine", "()Lkotlinx/coroutines/flow/SharedFlow;", "webModel", "getWebModel", "postValue", "", "annieXWebKit", "(Lcom/bytedance/android/anniex/web/AnnieXWebKit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "annieXWebModel", "(Lcom/bytedance/android/anniex/web/model/AnnieXWebModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXWebPreloadStateModel extends BaseAnnieXModel {
    private final MutableStateFlow<SchemaModelUnion> _schemaUnion;
    private final MutableStateFlow<AnnieXWebKit> _webEngine;
    private final MutableStateFlow<AnnieXWebModel> _webModel;
    private final StateFlow<SchemaModelUnion> schemaModelUnion;
    private final SharedFlow<AnnieXWebKit> webEngine;
    private final SharedFlow<AnnieXWebModel> webModel;

    public AnnieXWebPreloadStateModel() {
        MutableStateFlow<SchemaModelUnion> MutableStateFlow = StateFlowKt.MutableStateFlow((Object) null);
        this._schemaUnion = MutableStateFlow;
        this.schemaModelUnion = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<AnnieXWebModel> MutableStateFlow2 = StateFlowKt.MutableStateFlow((Object) null);
        this._webModel = MutableStateFlow2;
        this.webModel = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<AnnieXWebKit> MutableStateFlow3 = StateFlowKt.MutableStateFlow((Object) null);
        this._webEngine = MutableStateFlow3;
        this.webEngine = FlowKt.asStateFlow(MutableStateFlow3);
    }

    public final StateFlow<SchemaModelUnion> getSchemaModelUnion() {
        return this.schemaModelUnion;
    }

    public final SharedFlow<AnnieXWebModel> getWebModel() {
        return this.webModel;
    }

    public final SharedFlow<AnnieXWebKit> getWebEngine() {
        return this.webEngine;
    }

    public final Object postValue(SchemaModelUnion schemaModelUnion, Continuation<? super Unit> continuation) {
        Object emit = this._schemaUnion.emit(schemaModelUnion, continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    public final Object postValue(AnnieXWebModel annieXWebModel, Continuation<? super Unit> continuation) {
        Object emit = this._webModel.emit(annieXWebModel, continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    public final Object postValue(AnnieXWebKit annieXWebKit, Continuation<? super Unit> continuation) {
        Object emit = this._webEngine.emit(annieXWebKit, continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }
}
