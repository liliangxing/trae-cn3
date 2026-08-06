package com.bytedance.timon.pipeline;

import com.bytedance.timon.pipeline.TimonSystem;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimonSystem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"copy", "Lcom/bytedance/timon/pipeline/TimonSystem;", "uniqueName", "", "only", "invokeType", "Lcom/bytedance/timon/pipeline/TimonSystem$InvokeType;", "pipeline_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class TimonSystemKt {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TimonSystem.InvokeType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[TimonSystem.InvokeType.PRE_INVOKE.ordinal()] = 1;
            iArr[TimonSystem.InvokeType.POST_INVOKE.ordinal()] = 2;
            iArr[TimonSystem.InvokeType.ALL.ordinal()] = 3;
        }
    }

    public static final TimonSystem only(TimonSystem only, TimonSystem.InvokeType invokeType) {
        Intrinsics.checkParameterIsNotNull(only, "$this$only");
        Intrinsics.checkParameterIsNotNull(invokeType, "invokeType");
        int i = WhenMappings.$EnumSwitchMapping$0[invokeType.ordinal()];
        if (i == 1) {
            return new TimonSystem.OnlyPreInvokeSystem(only.get$uniqueName() + "_OnlyPre", only);
        }
        if (i == 2) {
            return new TimonSystem.OnlyPostInvokeSystem(only.get$uniqueName() + "_OnlyPost", only);
        }
        if (i == 3) {
            return only;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final TimonSystem copy(final TimonSystem copy, final String uniqueName) {
        Intrinsics.checkParameterIsNotNull(copy, "$this$copy");
        Intrinsics.checkParameterIsNotNull(uniqueName, "uniqueName");
        return new TimonSystem() { // from class: com.bytedance.timon.pipeline.TimonSystemKt$copy$1
            @Override // com.bytedance.timon.pipeline.TimonSystem
            public boolean preInvoke(TimonEntity entity) {
                Intrinsics.checkParameterIsNotNull(entity, "entity");
                return TimonSystem.this.preInvoke(entity);
            }

            @Override // com.bytedance.timon.pipeline.TimonSystem
            public boolean postInvoke(TimonEntity entity) {
                Intrinsics.checkParameterIsNotNull(entity, "entity");
                return TimonSystem.this.postInvoke(entity);
            }

            @Override // com.bytedance.timon.pipeline.TimonSystem
            /* renamed from: name, reason: from getter */
            public String get$uniqueName() {
                return uniqueName;
            }
        };
    }
}
