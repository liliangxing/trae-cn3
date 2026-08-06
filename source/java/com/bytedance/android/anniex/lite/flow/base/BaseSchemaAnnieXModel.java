package com.bytedance.android.anniex.lite.flow.base;

import com.bytedance.android.anniex.lite.flow.base.model.AnnieXModel;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: Extensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/base/BaseSchemaAnnieXModel;", "INPUT", "Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", "Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModel;", "()V", "initWithData", "", "input", "(Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BaseSchemaAnnieXModel<INPUT extends ISchemaModel> extends AnnieXModel {
    public Object initWithData(INPUT input, Continuation<? super Unit> continuation) {
        return initWithData$suspendImpl(this, input, continuation);
    }

    static /* synthetic */ <INPUT extends ISchemaModel> Object initWithData$suspendImpl(BaseSchemaAnnieXModel<INPUT> baseSchemaAnnieXModel, INPUT input, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }
}
