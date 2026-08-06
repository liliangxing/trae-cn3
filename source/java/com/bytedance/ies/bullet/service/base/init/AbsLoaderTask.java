package com.bytedance.ies.bullet.service.base.init;

import android.os.Handler;
import android.os.Message;
import bolts.Task;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.push.event.sync.ISignalReportConstants;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbsLoaderTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006H&J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0010J\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0010J\b\u0010\t\u001a\u00020\u0012H&J\u001a\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/init/AbsLoaderTask;", "", "context", "Lcom/bytedance/ies/bullet/core/BulletContext;", "(Lcom/bytedance/ies/bullet/core/BulletContext;)V", "getInitTask", "Lkotlin/Function1;", "Lcom/bytedance/ies/bullet/service/base/init/ITaskCallBack;", "Lkotlin/ParameterName;", "name", "callBack", "", "getTaskStyle", "Lcom/bytedance/ies/bullet/service/base/init/TaskStyle;", "interceptWhenNotReady", "", "()Ljava/lang/Boolean;", "isTaskAlready", "", "startTask", "handler", "Landroid/os/Handler;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class AbsLoaderTask {
    public static final int TASK_RUN_FAIL_MESSAGE = 2;
    public static final int TASK_RUN_SUCCESS_MESSAGE = 1;
    public static final int TASK_TIME_OUT_MESSAGE = 3;
    private final BulletContext context;

    /* compiled from: AbsLoaderTask.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TaskStyle.values().length];
            try {
                iArr[TaskStyle.Sync.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TaskStyle.Async.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public abstract Function1<ITaskCallBack, Unit> getInitTask();

    public abstract String name();

    public AbsLoaderTask(BulletContext bulletContext) {
        this.context = bulletContext;
    }

    public TaskStyle getTaskStyle() {
        return TaskStyle.Async;
    }

    public Boolean isTaskAlready() {
        return false;
    }

    public Boolean interceptWhenNotReady() {
        return false;
    }

    public void startTask(final BulletContext context, final Handler handler) {
        Intrinsics.checkNotNullParameter(context, "context");
        TaskStyle taskStyle = getTaskStyle();
        int i = taskStyle == null ? -1 : WhenMappings.$EnumSwitchMapping$0[taskStyle.ordinal()];
        if (i == 1 || i == 2) {
            Task.callInBackground(new Callable() { // from class: com.bytedance.ies.bullet.service.base.init.AbsLoaderTask$startTask$1
                @Override // java.util.concurrent.Callable
                public /* bridge */ /* synthetic */ Object call() {
                    call();
                    return Unit.INSTANCE;
                }

                @Override // java.util.concurrent.Callable
                public final void call() {
                    final long currentTimeMillis = System.currentTimeMillis();
                    Function1<ITaskCallBack, Unit> initTask = AbsLoaderTask.this.getInitTask();
                    final BulletContext bulletContext = context;
                    final AbsLoaderTask absLoaderTask = AbsLoaderTask.this;
                    final Handler handler2 = handler;
                    initTask.invoke(new ITaskCallBack() { // from class: com.bytedance.ies.bullet.service.base.init.AbsLoaderTask$startTask$1.1
                        @Override // com.bytedance.ies.bullet.service.base.init.ITaskCallBack
                        public void onInitSuccess() {
                            BulletContext.this.getContainerContext().getLoaderTaskPerfMetric().recordTaskDuration(absLoaderTask.name(), System.currentTimeMillis() - currentTimeMillis);
                            Message obtain = Message.obtain();
                            obtain.what = 1;
                            obtain.obj = new TaskStatus(1, absLoaderTask.name());
                            Handler handler3 = handler2;
                            if (handler3 != null) {
                                handler3.sendMessage(obtain);
                            }
                        }

                        @Override // com.bytedance.ies.bullet.service.base.init.ITaskCallBack
                        public void onInitFailed(int code, String reason) {
                            Intrinsics.checkNotNullParameter(reason, ISignalReportConstants.KEY_REASON);
                            Message obtain = Message.obtain();
                            obtain.what = 2;
                            obtain.obj = new TaskStatus(2, absLoaderTask.name());
                            Handler handler3 = handler2;
                            if (handler3 != null) {
                                handler3.sendMessage(obtain);
                            }
                        }
                    });
                }
            });
        }
    }
}
