package com.bytedance.timonbase.pipeline;

import com.bytedance.timon.pipeline.TimonEntity;
import com.bytedance.timon.pipeline.TimonSystem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConditionCheckerSystem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\bJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/timonbase/pipeline/ConditionCheckerSystem;", "Lcom/bytedance/timon/pipeline/TimonSystem;", "name", "", "preInvokeCondition", "Lkotlin/Function0;", "", "postInvokeCondition", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getName", "()Ljava/lang/String;", "getPostInvokeCondition", "()Lkotlin/jvm/functions/Function0;", "getPreInvokeCondition", "postInvoke", "entity", "Lcom/bytedance/timon/pipeline/TimonEntity;", "preInvoke", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConditionCheckerSystem implements TimonSystem {
    private final String name;
    private final Function0<Boolean> postInvokeCondition;
    private final Function0<Boolean> preInvokeCondition;

    public ConditionCheckerSystem(String str, Function0<Boolean> function0, Function0<Boolean> function02) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(function0, "preInvokeCondition");
        Intrinsics.checkParameterIsNotNull(function02, "postInvokeCondition");
        this.name = str;
        this.preInvokeCondition = function0;
        this.postInvokeCondition = function02;
    }

    public final String getName() {
        return this.name;
    }

    public final Function0<Boolean> getPreInvokeCondition() {
        return this.preInvokeCondition;
    }

    public final Function0<Boolean> getPostInvokeCondition() {
        return this.postInvokeCondition;
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public boolean preInvoke(TimonEntity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        return ((Boolean) this.preInvokeCondition.invoke()).booleanValue();
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public boolean postInvoke(TimonEntity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        return ((Boolean) this.postInvokeCondition.invoke()).booleanValue();
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    /* renamed from: name */
    public String get$uniqueName() {
        return this.name;
    }
}
