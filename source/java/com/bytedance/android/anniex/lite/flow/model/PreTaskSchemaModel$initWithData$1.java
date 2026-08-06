package com.bytedance.android.anniex.lite.flow.model;

import com.bytedance.android.anniex.lite.flow.schema.BDXPreTaskModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PreTaskSchemaModel.kt */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.android.anniex.lite.flow.model.PreTaskSchemaModel", f = "PreTaskSchemaModel.kt", i = {0, 0, 1, 1}, l = {28, 29, 30}, m = "initWithData", n = {"this", "input", "this", "input"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class PreTaskSchemaModel$initWithData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PreTaskSchemaModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreTaskSchemaModel$initWithData$1(PreTaskSchemaModel preTaskSchemaModel, Continuation<? super PreTaskSchemaModel$initWithData$1> continuation) {
        super(continuation);
        this.this$0 = preTaskSchemaModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.initWithData2((BDXPreTaskModel) null, (Continuation<? super Unit>) this);
    }
}
