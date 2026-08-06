package com.bytedance.lego.init.util;

import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.config.ProcessMatchMode;
import com.bytedance.lego.init.model.DelayTaskInfo;
import com.bytedance.lego.init.model.InitTaskProcess;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DelayTaskExtend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"supportCurProcess", "", "Lcom/bytedance/lego/init/model/DelayTaskInfo;", "getSupportCurProcess", "(Lcom/bytedance/lego/init/model/DelayTaskInfo;)Z", "initscheduler_release"}, k = 2, mv = {1, 1, 13})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DelayTaskExtendKt {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 13})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProcessMatchMode.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ProcessMatchMode.ENDWITH.ordinal()] = 1;
            iArr[ProcessMatchMode.CONTAIN.ordinal()] = 2;
        }
    }

    public static final boolean getSupportCurProcess(DelayTaskInfo delayTaskInfo) {
        Intrinsics.checkParameterIsNotNull(delayTaskInfo, "receiver$0");
        if (delayTaskInfo.runInProcess.contains("all") || delayTaskInfo.runInProcess.contains(InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName())) {
            return true;
        }
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getIsMainProcess()) {
            return delayTaskInfo.runInProcess.contains("main");
        }
        if (delayTaskInfo.runInProcess.contains(InitTaskProcess.NONMAIN)) {
            return true;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[InitScheduler.INSTANCE.getProcessMatchMode$initscheduler_release().ordinal()];
        if (i == 1) {
            List<String> list = delayTaskInfo.runInProcess;
            Intrinsics.checkExpressionValueIsNotNull(list, "runInProcess");
            for (String str : list) {
                String processName = InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName();
                Intrinsics.checkExpressionValueIsNotNull(str, "it");
                if (StringsKt.endsWith(processName, str, true)) {
                    return true;
                }
            }
            return false;
        }
        if (i != 2) {
            return false;
        }
        List<String> list2 = delayTaskInfo.runInProcess;
        Intrinsics.checkExpressionValueIsNotNull(list2, "runInProcess");
        for (String str2 : list2) {
            String processName2 = InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName();
            Intrinsics.checkExpressionValueIsNotNull(str2, "it");
            if (StringsKt.contains(processName2, str2, true)) {
                return true;
            }
        }
        return false;
    }
}
