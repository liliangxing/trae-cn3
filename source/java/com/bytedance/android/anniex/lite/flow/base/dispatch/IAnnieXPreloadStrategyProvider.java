package com.bytedance.android.anniex.lite.flow.base.dispatch;

import com.bytedance.android.anniex.base.service.IAnnieXService;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAnnieXPreloadStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/base/dispatch/IAnnieXPreloadStrategyProvider;", "Lcom/bytedance/android/anniex/base/service/IAnnieXService;", "getLoadStrategy", "", "Lcom/bytedance/android/anniex/lite/flow/base/dispatch/BaseModelAnnieTask;", "kitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "loadFlowTask", "Lcom/bytedance/android/anniex/lite/flow/base/dispatch/LoadFlowTask;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface IAnnieXPreloadStrategyProvider extends IAnnieXService {

    /* compiled from: IAnnieXPreloadStrategyProvider.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class DefaultImpls {
        public static List<BaseModelAnnieTask> getLoadStrategy(IAnnieXPreloadStrategyProvider iAnnieXPreloadStrategyProvider, KitType kitType, LoadFlowTask loadFlowTask) {
            Intrinsics.checkNotNullParameter(kitType, "kitType");
            Intrinsics.checkNotNullParameter(loadFlowTask, "loadFlowTask");
            return null;
        }
    }

    List<BaseModelAnnieTask> getLoadStrategy(KitType kitType, LoadFlowTask loadFlowTask);
}
