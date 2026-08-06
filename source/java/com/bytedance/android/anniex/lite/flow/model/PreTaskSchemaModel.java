package com.bytedance.android.anniex.lite.flow.model;

import com.bytedance.android.anniex.lite.flow.base.BaseSchemaAnnieXModel;
import com.bytedance.android.anniex.lite.flow.schema.BDXPreTaskModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: PreTaskSchemaModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0096@¢\u0006\u0002\u0010\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/model/PreTaskSchemaModel;", "Lcom/bytedance/android/anniex/lite/flow/base/BaseSchemaAnnieXModel;", "Lcom/bytedance/android/anniex/lite/flow/schema/BDXPreTaskModel;", "()V", "_enableEnginePreload", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_enableModelPreload", "_enablePrefetch", "enableEnginePreload", "Lkotlinx/coroutines/flow/SharedFlow;", "getEnableEnginePreload", "()Lkotlinx/coroutines/flow/SharedFlow;", "enableModelPreload", "getEnableModelPreload", "enablePrefetch", "getEnablePrefetch", "initWithData", "", "input", "(Lcom/bytedance/android/anniex/lite/flow/schema/BDXPreTaskModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class PreTaskSchemaModel extends BaseSchemaAnnieXModel<BDXPreTaskModel> {
    private final MutableStateFlow<Boolean> _enableEnginePreload;
    private final MutableStateFlow<Boolean> _enableModelPreload;
    private final MutableStateFlow<Boolean> _enablePrefetch;
    private final SharedFlow<Boolean> enableEnginePreload;
    private final SharedFlow<Boolean> enableModelPreload;
    private final SharedFlow<Boolean> enablePrefetch;

    public PreTaskSchemaModel() {
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(false);
        this._enablePrefetch = MutableStateFlow;
        this.enablePrefetch = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(false);
        this._enableModelPreload = MutableStateFlow2;
        this.enableModelPreload = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<Boolean> MutableStateFlow3 = StateFlowKt.MutableStateFlow(false);
        this._enableEnginePreload = MutableStateFlow3;
        this.enableEnginePreload = FlowKt.asStateFlow(MutableStateFlow3);
    }

    @Override // com.bytedance.android.anniex.lite.flow.base.BaseSchemaAnnieXModel
    public /* bridge */ /* synthetic */ Object initWithData(BDXPreTaskModel bDXPreTaskModel, Continuation continuation) {
        return initWithData2(bDXPreTaskModel, (Continuation<? super Unit>) continuation);
    }

    public final SharedFlow<Boolean> getEnablePrefetch() {
        return this.enablePrefetch;
    }

    public final SharedFlow<Boolean> getEnableModelPreload() {
        return this.enableModelPreload;
    }

    public final SharedFlow<Boolean> getEnableEnginePreload() {
        return this.enableEnginePreload;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* renamed from: initWithData, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object initWithData2(BDXPreTaskModel bDXPreTaskModel, Continuation<? super Unit> continuation) {
        PreTaskSchemaModel$initWithData$1 preTaskSchemaModel$initWithData$1;
        int i;
        PreTaskSchemaModel preTaskSchemaModel;
        Boolean bool;
        Boolean bool2;
        if (continuation instanceof PreTaskSchemaModel$initWithData$1) {
            preTaskSchemaModel$initWithData$1 = (PreTaskSchemaModel$initWithData$1) continuation;
            if ((preTaskSchemaModel$initWithData$1.label & Integer.MIN_VALUE) != 0) {
                preTaskSchemaModel$initWithData$1.label -= Integer.MIN_VALUE;
                Object obj = preTaskSchemaModel$initWithData$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = preTaskSchemaModel$initWithData$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Boolean bool3 = (Boolean) bDXPreTaskModel.getEnablePrefetch().getValue();
                    if (bool3 != null) {
                        boolean booleanValue = bool3.booleanValue();
                        MutableStateFlow<Boolean> mutableStateFlow = this._enablePrefetch;
                        Boolean boxBoolean = Boxing.boxBoolean(booleanValue);
                        preTaskSchemaModel$initWithData$1.L$0 = this;
                        preTaskSchemaModel$initWithData$1.L$1 = bDXPreTaskModel;
                        preTaskSchemaModel$initWithData$1.label = 1;
                        if (mutableStateFlow.emit(boxBoolean, preTaskSchemaModel$initWithData$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    preTaskSchemaModel = this;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        bDXPreTaskModel = (BDXPreTaskModel) preTaskSchemaModel$initWithData$1.L$1;
                        preTaskSchemaModel = (PreTaskSchemaModel) preTaskSchemaModel$initWithData$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        bool2 = (Boolean) bDXPreTaskModel.getEnableEnginePreload().getValue();
                        if (bool2 != null) {
                            boolean booleanValue2 = bool2.booleanValue();
                            MutableStateFlow<Boolean> mutableStateFlow2 = preTaskSchemaModel._enableEnginePreload;
                            Boolean boxBoolean2 = Boxing.boxBoolean(booleanValue2);
                            preTaskSchemaModel$initWithData$1.L$0 = null;
                            preTaskSchemaModel$initWithData$1.L$1 = null;
                            preTaskSchemaModel$initWithData$1.label = 3;
                            if (mutableStateFlow2.emit(boxBoolean2, preTaskSchemaModel$initWithData$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    bDXPreTaskModel = (BDXPreTaskModel) preTaskSchemaModel$initWithData$1.L$1;
                    preTaskSchemaModel = (PreTaskSchemaModel) preTaskSchemaModel$initWithData$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                bool = (Boolean) bDXPreTaskModel.getEnableModelPreCreate().getValue();
                if (bool != null) {
                    boolean booleanValue3 = bool.booleanValue();
                    MutableStateFlow<Boolean> mutableStateFlow3 = preTaskSchemaModel._enableModelPreload;
                    Boolean boxBoolean3 = Boxing.boxBoolean(booleanValue3);
                    preTaskSchemaModel$initWithData$1.L$0 = preTaskSchemaModel;
                    preTaskSchemaModel$initWithData$1.L$1 = bDXPreTaskModel;
                    preTaskSchemaModel$initWithData$1.label = 2;
                    if (mutableStateFlow3.emit(boxBoolean3, preTaskSchemaModel$initWithData$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                bool2 = (Boolean) bDXPreTaskModel.getEnableEnginePreload().getValue();
                if (bool2 != null) {
                }
                return Unit.INSTANCE;
            }
        }
        preTaskSchemaModel$initWithData$1 = new PreTaskSchemaModel$initWithData$1(this, continuation);
        Object obj2 = preTaskSchemaModel$initWithData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = preTaskSchemaModel$initWithData$1.label;
        if (i != 0) {
        }
        bool = (Boolean) bDXPreTaskModel.getEnableModelPreCreate().getValue();
        if (bool != null) {
        }
        bool2 = (Boolean) bDXPreTaskModel.getEnableEnginePreload().getValue();
        if (bool2 != null) {
        }
        return Unit.INSTANCE;
    }
}
