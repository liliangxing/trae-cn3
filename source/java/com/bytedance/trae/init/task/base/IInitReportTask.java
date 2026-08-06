package com.bytedance.trae.init.task.base;

import com.bytedance.trae.FirstInitStyle;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.home.privacy.PrivacyManager;
import com.bytedance.trae.init.task.FirstFrameSchedulerExecutors;
import com.bytedance.trae.init.task.base.IInitReportTask;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: IInitReportTask.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/init/task/base/IInitReportTask;", "Ljava/lang/Runnable;", "scene", "", "getScene", "()Ljava/lang/String;", "firstStyle", "getFirstStyle", "run", "", "checkFirstStartAsyncTaskInit", "", "taskName", "runInternal", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IInitReportTask extends Runnable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    boolean checkFirstStartAsyncTaskInit(String taskName);

    String getFirstStyle();

    String getScene();

    @Override // java.lang.Runnable
    void run();

    void runInternal();

    /* compiled from: IInitReportTask.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/init/task/base/IInitReportTask$Companion;", "", "<init>", "()V", "prePrivacyWhiteList", "", "", "getPrePrivacyWhiteList", "()Ljava/util/Set;", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Set<String> prePrivacyWhiteList = SetsKt.emptySet();

        private Companion() {
        }

        public final Set<String> getPrePrivacyWhiteList() {
            return prePrivacyWhiteList;
        }
    }

    /* compiled from: IInitReportTask.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class DefaultImpls {
        public static String getFirstStyle(IInitReportTask iInitReportTask) {
            return "normal";
        }

        public static void run(final IInitReportTask iInitReportTask) {
            InitTaskHelperKt.runWithMonitor(iInitReportTask.getScene(), iInitReportTask.getFirstStyle(), iInitReportTask, new Function0() { // from class: com.bytedance.trae.init.task.base.IInitReportTask$DefaultImpls$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit run$lambda$1;
                    run$lambda$1 = IInitReportTask.DefaultImpls.run$lambda$1(IInitReportTask.this);
                    return run$lambda$1;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Unit run$lambda$1(final IInitReportTask iInitReportTask) {
            if (!AppHost.INSTANCE.isOversea()) {
                String simpleName = Reflection.getOrCreateKotlinClass(iInitReportTask.getClass()).getSimpleName();
                if (simpleName == null) {
                    simpleName = "";
                }
                if (iInitReportTask.checkFirstStartAsyncTaskInit(simpleName) && Intrinsics.areEqual(iInitReportTask.getFirstStyle(), FirstInitStyle.AsyncThreadWhenFirst)) {
                    FirstFrameSchedulerExecutors.INSTANCE.useLaunchBoostExecutor(new Function0() { // from class: com.bytedance.trae.init.task.base.IInitReportTask$DefaultImpls$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit run$lambda$1$lambda$0;
                            run$lambda$1$lambda$0 = IInitReportTask.DefaultImpls.run$lambda$1$lambda$0(IInitReportTask.this);
                            return run$lambda$1$lambda$0;
                        }
                    });
                    return Unit.INSTANCE;
                }
            }
            iInitReportTask.runInternal();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Unit run$lambda$1$lambda$0(IInitReportTask iInitReportTask) {
            iInitReportTask.runInternal();
            return Unit.INSTANCE;
        }

        public static boolean checkFirstStartAsyncTaskInit(IInitReportTask iInitReportTask, String str) {
            Intrinsics.checkNotNullParameter(str, "taskName");
            return PrivacyManager.INSTANCE.isFirstInstallStarting() && !IInitReportTask.INSTANCE.getPrePrivacyWhiteList().contains(str);
        }
    }
}
