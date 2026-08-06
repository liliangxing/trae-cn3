package com.bytedance.android.anniex.lite.flow;

import com.bytedance.android.anniex.lite.flow.base.dispatch.BaseModelAnnieTask;
import com.bytedance.android.anniex.lite.flow.base.dispatch.FlowTaskType;
import com.bytedance.android.anniex.lite.flow.base.dispatch.IAnnieXPreloadStrategyProvider;
import com.bytedance.android.anniex.lite.flow.base.dispatch.LoadFlowTask;
import com.bytedance.android.anniex.lite.flow.web.task.AnnieXWebEnginePreloadTask;
import com.bytedance.android.anniex.lite.flow.web.task.AnnieXWebModelPreloadTask;
import com.bytedance.android.anniex.lite.task.AnnieXCacheParamTask;
import com.bytedance.android.anniex.lite.task.AnnieXLatchTask;
import com.bytedance.android.anniex.lite.task.AnnieXLynxEnginePreloadTask;
import com.bytedance.android.anniex.lite.task.AnnieXLynxModelPreloadTask;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXDefaultPreloadStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/AnnieXDefaultPreloadStrategyProvider;", "Lcom/bytedance/android/anniex/lite/flow/base/dispatch/IAnnieXPreloadStrategyProvider;", "()V", "getLoadStrategy", "", "Lcom/bytedance/android/anniex/lite/flow/base/dispatch/BaseModelAnnieTask;", "kitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "loadFlowTask", "Lcom/bytedance/android/anniex/lite/flow/base/dispatch/LoadFlowTask;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXDefaultPreloadStrategyProvider implements IAnnieXPreloadStrategyProvider {

    /* compiled from: AnnieXDefaultPreloadStrategyProvider.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FlowTaskType.values().length];
            try {
                iArr[FlowTaskType.EnginePreloadTask.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FlowTaskType.RouterInitTask.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.bytedance.android.anniex.lite.flow.base.dispatch.IAnnieXPreloadStrategyProvider
    public List<BaseModelAnnieTask> getLoadStrategy(KitType kitType, LoadFlowTask loadFlowTask) {
        Intrinsics.checkNotNullParameter(kitType, "kitType");
        Intrinsics.checkNotNullParameter(loadFlowTask, "loadFlowTask");
        if (kitType == KitType.LYNX) {
            int i = WhenMappings.$EnumSwitchMapping$0[loadFlowTask.getTaskType().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new AnnieXLatchTask(loadFlowTask));
                    return arrayList;
                }
                throw new NoWhenBranchMatchedException();
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new AnnieXCacheParamTask(loadFlowTask));
            arrayList2.add(new AnnieXLynxModelPreloadTask(loadFlowTask));
            arrayList2.add(new AnnieXLynxEnginePreloadTask(loadFlowTask));
            return arrayList2;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[loadFlowTask.getTaskType().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return new ArrayList();
            }
            throw new NoWhenBranchMatchedException();
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new AnnieXWebModelPreloadTask(loadFlowTask));
        arrayList3.add(new AnnieXWebEnginePreloadTask(loadFlowTask));
        return arrayList3;
    }
}
