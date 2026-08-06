package com.bytedance.ies.bullet.redirect.helper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.ies.bullet.redirect.helper.OptimizeMainThreadScheduler;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OptimizeMainThreadScheduler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u000b\f\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/helper/OptimizeMainThreadScheduler;", "", "()V", "mainThread", "Lio/reactivex/Scheduler;", "getMainThread", "()Lio/reactivex/Scheduler;", "mainThread$delegate", "Lkotlin/Lazy;", "isMainThread", "", "HandlerWorker", "MainThreadHandlerScheduler", "ScheduledRunnable", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class OptimizeMainThreadScheduler {
    public static final OptimizeMainThreadScheduler INSTANCE = new OptimizeMainThreadScheduler();

    /* renamed from: mainThread$delegate, reason: from kotlin metadata */
    private static final Lazy mainThread = LazyKt.lazy(new Function0<MainThreadHandlerScheduler>() { // from class: com.bytedance.ies.bullet.redirect.helper.OptimizeMainThreadScheduler$mainThread$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final OptimizeMainThreadScheduler.MainThreadHandlerScheduler m547invoke() {
            Handler handler = null;
            return new OptimizeMainThreadScheduler.MainThreadHandlerScheduler(handler, 1, handler);
        }
    });

    private OptimizeMainThreadScheduler() {
    }

    public final Scheduler getMainThread() {
        return (Scheduler) mainThread.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OptimizeMainThreadScheduler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/helper/OptimizeMainThreadScheduler$MainThreadHandlerScheduler;", "Lio/reactivex/Scheduler;", "handler", "Landroid/os/Handler;", "(Landroid/os/Handler;)V", "createWorker", "Lio/reactivex/Scheduler$Worker;", "scheduleDirect", "Lio/reactivex/disposables/Disposable;", "run", "Ljava/lang/Runnable;", "delay", "", "unit", "Ljava/util/concurrent/TimeUnit;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class MainThreadHandlerScheduler extends Scheduler {
        private final Handler handler;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public MainThreadHandlerScheduler() {
            this(r0, 1, r0);
            Handler handler = null;
        }

        public /* synthetic */ MainThreadHandlerScheduler(Handler handler, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new Handler(Looper.getMainLooper()) : handler);
        }

        public MainThreadHandlerScheduler(Handler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            this.handler = handler;
        }

        public Disposable scheduleDirect(Runnable run, long delay, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(run, "run");
            Intrinsics.checkNotNullParameter(unit, "unit");
            Runnable onSchedule = RxJavaPlugins.onSchedule(run);
            Intrinsics.checkNotNullExpressionValue(onSchedule, "onSchedule(run)");
            if (OptimizeMainThreadScheduler.INSTANCE.isMainThread() && delay == 0) {
                onSchedule.run();
                Disposable disposed = Disposables.disposed();
                Intrinsics.checkNotNullExpressionValue(disposed, "disposed()");
                return disposed;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(this.handler, onSchedule);
            this.handler.sendMessageDelayed(Message.obtain(this.handler, scheduledRunnable), unit.toMillis(delay));
            return scheduledRunnable;
        }

        public Scheduler.Worker createWorker() {
            return new HandlerWorker(this.handler);
        }
    }

    /* compiled from: OptimizeMainThreadScheduler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/helper/OptimizeMainThreadScheduler$HandlerWorker;", "Lio/reactivex/Scheduler$Worker;", "handler", "Landroid/os/Handler;", "(Landroid/os/Handler;)V", "disposed", "", "dispose", "", "isDisposed", "schedule", "Lio/reactivex/disposables/Disposable;", "run", "Ljava/lang/Runnable;", "delay", "", "unit", "Ljava/util/concurrent/TimeUnit;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static final class HandlerWorker extends Scheduler.Worker {
        private volatile boolean disposed;
        private final Handler handler;

        public HandlerWorker(Handler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            this.handler = handler;
        }

        public Disposable schedule(Runnable run, long delay, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(run, "run");
            Intrinsics.checkNotNullParameter(unit, "unit");
            if (this.disposed) {
                Disposable disposed = Disposables.disposed();
                Intrinsics.checkNotNullExpressionValue(disposed, "disposed()");
                return disposed;
            }
            Runnable onSchedule = RxJavaPlugins.onSchedule(run);
            Intrinsics.checkNotNullExpressionValue(onSchedule, "onSchedule(run)");
            if (OptimizeMainThreadScheduler.INSTANCE.isMainThread() && delay == 0) {
                onSchedule.run();
                Disposable disposed2 = Disposables.disposed();
                Intrinsics.checkNotNullExpressionValue(disposed2, "disposed()");
                return disposed2;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(this.handler, onSchedule);
            ScheduledRunnable scheduledRunnable2 = scheduledRunnable;
            Message obtain = Message.obtain(this.handler, scheduledRunnable2);
            obtain.obj = this;
            this.handler.sendMessageDelayed(obtain, unit.toMillis(delay));
            if (this.disposed) {
                this.handler.removeCallbacks(scheduledRunnable2);
                Disposable disposed3 = Disposables.disposed();
                Intrinsics.checkNotNullExpressionValue(disposed3, "disposed()");
                return disposed3;
            }
            return scheduledRunnable;
        }

        public void dispose() {
            this.disposed = true;
            this.handler.removeCallbacksAndMessages(this);
        }

        /* renamed from: isDisposed, reason: from getter */
        public boolean getDisposed() {
            return this.disposed;
        }
    }

    /* compiled from: OptimizeMainThreadScheduler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/helper/OptimizeMainThreadScheduler$ScheduledRunnable;", "Ljava/lang/Runnable;", "Lio/reactivex/disposables/Disposable;", "handler", "Landroid/os/Handler;", "delegate", "(Landroid/os/Handler;Ljava/lang/Runnable;)V", "disposed", "", "dispose", "", "isDisposed", "run", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static final class ScheduledRunnable implements Runnable, Disposable {
        private final Runnable delegate;
        private volatile boolean disposed;
        private final Handler handler;

        public ScheduledRunnable(Handler handler, Runnable runnable) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(runnable, "delegate");
            this.handler = handler;
            this.delegate = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.delegate.run();
            } catch (Throwable th) {
                RxJavaPlugins.onError(th);
            }
        }

        public void dispose() {
            this.handler.removeCallbacks(this);
            this.disposed = true;
        }

        /* renamed from: isDisposed, reason: from getter */
        public boolean getDisposed() {
            return this.disposed;
        }
    }
}
