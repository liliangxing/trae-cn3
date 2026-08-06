package com.bytedance.lego.init.util;

import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.InitTaskDispatcherKt;
import com.bytedance.lego.init.config.ProcessMatchMode;
import com.bytedance.lego.init.model.IInitTask;
import com.bytedance.lego.init.model.InitTaskInfo;
import com.bytedance.lego.init.model.InitTaskProcess;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: InitTaskExtend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\b\"\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"initContext", "Lcom/bytedance/lego/init/util/InitContext;", "Lcom/bytedance/lego/init/model/IInitTask;", "getInitContext", "(Lcom/bytedance/lego/init/model/IInitTask;)Lcom/bytedance/lego/init/util/InitContext;", "isInternalTask", "", "Lcom/bytedance/lego/init/model/InitTaskInfo;", "(Lcom/bytedance/lego/init/model/InitTaskInfo;)Z", "supportCurProcess", "getSupportCurProcess", "initscheduler_release"}, k = 2, mv = {1, 1, 13})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class InitTaskExtendKt {

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

    public static final InitContext getInitContext(IInitTask iInitTask) {
        Intrinsics.checkParameterIsNotNull(iInitTask, "receiver$0");
        return InitContext.INSTANCE;
    }

    public static final boolean isInternalTask(InitTaskInfo initTaskInfo) {
        Intrinsics.checkParameterIsNotNull(initTaskInfo, "receiver$0");
        return Intrinsics.areEqual(InitTaskDispatcherKt.INIT_SCHEDULER_INTERNAL_TASK, initTaskInfo.taskClassName);
    }

    public static final boolean getSupportCurProcess(InitTaskInfo initTaskInfo) {
        Intrinsics.checkParameterIsNotNull(initTaskInfo, "receiver$0");
        if (initTaskInfo.runInProcess.contains("all") || initTaskInfo.runInProcess.contains(InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName())) {
            return true;
        }
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getIsMainProcess()) {
            return initTaskInfo.runInProcess.contains("main");
        }
        if (initTaskInfo.runInProcess.contains(InitTaskProcess.NONMAIN)) {
            return true;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[InitScheduler.INSTANCE.getProcessMatchMode$initscheduler_release().ordinal()];
        if (i == 1) {
            List<String> list = initTaskInfo.runInProcess;
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
        List<String> list2 = initTaskInfo.runInProcess;
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
