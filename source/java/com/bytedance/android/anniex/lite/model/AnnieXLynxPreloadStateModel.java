package com.bytedance.android.anniex.lite.model;

import com.bytedance.android.anniex.engine.AnnieXLynxEngine;
import com.bytedance.android.anniex.lite.flow.base.BaseAnnieXModel;
import com.bytedance.android.anniex.model.AnnieXLynxModel;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: AnnieXLynxPreloadStateModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010 J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010!J$\u0010\u001b\u001a\u00020\u001c2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\u0086@¢\u0006\u0002\u0010\"R\"\u0010\u0003\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\u000f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00050\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0019\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0019\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006#"}, d2 = {"Lcom/bytedance/android/anniex/lite/model/AnnieXLynxPreloadStateModel;", "Lcom/bytedance/android/anniex/lite/flow/base/BaseAnnieXModel;", "()V", "_cacheParam", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "", "", "_lynxEngine", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bytedance/android/anniex/engine/AnnieXLynxEngine;", "_lynxModel", "Lcom/bytedance/android/anniex/model/AnnieXLynxModel;", "_schemaUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "cacheParam", "Lkotlinx/coroutines/flow/SharedFlow;", "getCacheParam", "()Lkotlinx/coroutines/flow/SharedFlow;", "lynxEngine", "getLynxEngine", "lynxModel", "getLynxModel", "schemaModelUnion", "Lkotlinx/coroutines/flow/StateFlow;", "getSchemaModelUnion", "()Lkotlinx/coroutines/flow/StateFlow;", "postValue", "", "annieXLynxEngine", "(Lcom/bytedance/android/anniex/engine/AnnieXLynxEngine;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "annieXLynxModel", "(Lcom/bytedance/android/anniex/model/AnnieXLynxModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXLynxPreloadStateModel extends BaseAnnieXModel {
    private final MutableSharedFlow<Map<String, Object>> _cacheParam;
    private final MutableStateFlow<AnnieXLynxEngine> _lynxEngine;
    private final MutableStateFlow<AnnieXLynxModel> _lynxModel;
    private final MutableStateFlow<SchemaModelUnion> _schemaUnion;
    private final SharedFlow<Map<String, Object>> cacheParam;
    private final SharedFlow<AnnieXLynxEngine> lynxEngine;
    private final SharedFlow<AnnieXLynxModel> lynxModel;
    private final StateFlow<SchemaModelUnion> schemaModelUnion;

    public AnnieXLynxPreloadStateModel() {
        MutableStateFlow<SchemaModelUnion> MutableStateFlow = StateFlowKt.MutableStateFlow((Object) null);
        this._schemaUnion = MutableStateFlow;
        this.schemaModelUnion = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<AnnieXLynxModel> MutableStateFlow2 = StateFlowKt.MutableStateFlow((Object) null);
        this._lynxModel = MutableStateFlow2;
        this.lynxModel = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<AnnieXLynxEngine> MutableStateFlow3 = StateFlowKt.MutableStateFlow((Object) null);
        this._lynxEngine = MutableStateFlow3;
        this.lynxEngine = FlowKt.asStateFlow(MutableStateFlow3);
        MutableSharedFlow<Map<String, Object>> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._cacheParam = MutableSharedFlow$default;
        this.cacheParam = FlowKt.asSharedFlow(MutableSharedFlow$default);
    }

    public final StateFlow<SchemaModelUnion> getSchemaModelUnion() {
        return this.schemaModelUnion;
    }

    public final SharedFlow<AnnieXLynxModel> getLynxModel() {
        return this.lynxModel;
    }

    public final SharedFlow<AnnieXLynxEngine> getLynxEngine() {
        return this.lynxEngine;
    }

    public final SharedFlow<Map<String, Object>> getCacheParam() {
        return this.cacheParam;
    }

    public final Object postValue(SchemaModelUnion schemaModelUnion, Continuation<? super Unit> continuation) {
        Object emit = this._schemaUnion.emit(schemaModelUnion, continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    public final Object postValue(AnnieXLynxModel annieXLynxModel, Continuation<? super Unit> continuation) {
        Object emit = this._lynxModel.emit(annieXLynxModel, continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    public final Object postValue(AnnieXLynxEngine annieXLynxEngine, Continuation<? super Unit> continuation) {
        Object emit = this._lynxEngine.emit(annieXLynxEngine, continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    public final Object postValue(Map<String, ? extends Object> map, Continuation<? super Unit> continuation) {
        Object emit = this._cacheParam.emit(map, continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }
}
