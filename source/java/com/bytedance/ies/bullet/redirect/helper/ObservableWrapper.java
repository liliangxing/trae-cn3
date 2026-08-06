package com.bytedance.ies.bullet.redirect.helper;

import com.bytedance.rts.foundation.Int64;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableDistinct;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.operators.observable.ObservableIntervalRange;
import io.reactivex.internal.operators.observable.ObservableRetryBiPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryWhen;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ObservableWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u0018*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0018B\u0015\b\u0002\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J,\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0001\u0010\u00072\u0016\u0010\b\u001a\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\tH\u0007JH\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0001\u0010\u00072\u0016\u0010\b\u001a\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\t2\u001a\u0010\n\u001a\u0016\u0012\u0010\b\u0001\u0012\f\u0012\u0006\b\u0000\u0012\u0002H\u0007\u0018\u00010\f\u0018\u00010\u000bH\u0007J,\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u001c\u0010\u000e\u001a\u0018\u0012\b\b\u0000\u0012\u0004\u0018\u00010\u0010\u0012\b\b\u0000\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u000fH\u0007J\"\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0012\u0010\u000e\u001a\u000e\u0012\b\b\u0000\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0012H\u0007J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J*\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u000e\u001a\u000e\u0012\b\b\u0000\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0012H\u0007J4\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042$\u0010\u0016\u001a \u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0004\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0017\u0018\u00010\tH\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/helper/ObservableWrapper;", "T", "", "mBase", "Lio/reactivex/Observable;", "(Lio/reactivex/Observable;)V", "distinct", "K", "keySelector", "Lio/reactivex/functions/Function;", "collectionSupplier", "Ljava/util/concurrent/Callable;", "", "retry", "predicate", "Lio/reactivex/functions/BiPredicate;", "", "", "Lio/reactivex/functions/Predicate;", "times", "", "retryWhen", "observableSourceFunction", "Lio/reactivex/ObservableSource;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ObservableWrapper<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Observable<T> mBase;

    public /* synthetic */ ObservableWrapper(Observable observable, DefaultConstructorMarker defaultConstructorMarker) {
        this(observable);
    }

    private ObservableWrapper(Observable<T> observable) {
        this.mBase = observable;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> retry(BiPredicate<? super Integer, ? super Throwable> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        Observable<T> onAssembly = RxJavaPlugins.onAssembly(new ObservableRetryBiPredicate(this.mBase, predicate));
        Intrinsics.checkNotNullExpressionValue(onAssembly, "onAssembly(ObservableRet…dicate(mBase, predicate))");
        return onAssembly;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> retry(long times) {
        return retry(times, Functions.alwaysTrue());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> retry(long times, Predicate<? super Throwable> predicate) {
        if (!(times >= 0)) {
            throw new IllegalArgumentException(("times >= 0 required but it was " + times).toString());
        }
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        Observable<T> onAssembly = RxJavaPlugins.onAssembly(new ObservableRetryPredicate(this.mBase, times, predicate));
        Intrinsics.checkNotNullExpressionValue(onAssembly, "onAssembly(ObservableRet…mBase, times, predicate))");
        return onAssembly;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> retry(Predicate<? super Throwable> predicate) {
        return retry(Int64.MAX_VALUE, predicate);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> retryWhen(Function<Observable<Throwable>, ObservableSource<?>> observableSourceFunction) {
        Observable<T> onAssembly = RxJavaPlugins.onAssembly(new ObservableRetryWhen(this.mBase, observableSourceFunction));
        Intrinsics.checkNotNullExpressionValue(onAssembly, "onAssembly(ObservableRet…bservableSourceFunction))");
        return onAssembly;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> Observable<T> distinct(Function<? super T, K> keySelector) {
        return distinct(keySelector, Functions.createHashSet());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> Observable<T> distinct(Function<? super T, K> keySelector, Callable<? extends Collection<? super K>> collectionSupplier) {
        ObjectHelper.requireNonNull(keySelector, "keySelector is null");
        ObjectHelper.requireNonNull(collectionSupplier, "collectionSupplier is null");
        Observable<T> onAssembly = RxJavaPlugins.onAssembly(new ObservableDistinct(this.mBase, keySelector, collectionSupplier));
        Intrinsics.checkNotNullExpressionValue(onAssembly, "onAssembly(ObservableDis…tor, collectionSupplier))");
        return onAssembly;
    }

    /* compiled from: ObservableWrapper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J(\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0007J(\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J0\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0007J8\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J@\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0007J \u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0010\"\u0004\b\u0001\u0010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0004¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/helper/ObservableWrapper$Companion;", "", "()V", EventConstants.PARAM_SOURCE_INTERVAL, "Lio/reactivex/Observable;", "", "period", "unit", "Ljava/util/concurrent/TimeUnit;", "scheduler", "Lio/reactivex/Scheduler;", "initialDelay", "intervalRange", TraeAuthManager.STAGE_START, "count", "wapper", "Lcom/bytedance/ies/bullet/redirect/helper/ObservableWrapper;", "T", "observable", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T> ObservableWrapper<T> wapper(Observable<T> observable) {
            Intrinsics.checkNotNullParameter(observable, "observable");
            return new ObservableWrapper<>(observable, null);
        }

        @SchedulerSupport("io.reactivex:computation")
        @CheckReturnValue
        public final Observable<Long> interval(long initialDelay, long period, TimeUnit unit) {
            Scheduler computation = Schedulers.computation();
            Intrinsics.checkNotNullExpressionValue(computation, "computation()");
            return interval(initialDelay, period, unit, computation);
        }

        @SchedulerSupport("custom")
        @CheckReturnValue
        public final Observable<Long> interval(long initialDelay, long period, TimeUnit unit, Scheduler scheduler) {
            Intrinsics.checkNotNullParameter(scheduler, "scheduler");
            ObjectHelper.requireNonNull(unit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            Observable<Long> onAssembly = RxJavaPlugins.onAssembly(new ObservableInterval(Math.max(0L, initialDelay), Math.max(0L, period), unit, scheduler));
            Intrinsics.checkNotNullExpressionValue(onAssembly, "onAssembly(\n            …          )\n            )");
            return onAssembly;
        }

        @SchedulerSupport("io.reactivex:computation")
        @CheckReturnValue
        public final Observable<Long> interval(long period, TimeUnit unit) {
            Scheduler computation = Schedulers.computation();
            Intrinsics.checkNotNullExpressionValue(computation, "computation()");
            return interval(period, period, unit, computation);
        }

        @SchedulerSupport("custom")
        @CheckReturnValue
        public final Observable<Long> interval(long period, TimeUnit unit, Scheduler scheduler) {
            Intrinsics.checkNotNullParameter(scheduler, "scheduler");
            return interval(period, period, unit, scheduler);
        }

        @SchedulerSupport("io.reactivex:computation")
        @CheckReturnValue
        public final Observable<Long> intervalRange(long start, long count, long initialDelay, long period, TimeUnit unit) {
            Scheduler computation = Schedulers.computation();
            Intrinsics.checkNotNullExpressionValue(computation, "computation()");
            return intervalRange(start, count, initialDelay, period, unit, computation);
        }

        @SchedulerSupport("custom")
        @CheckReturnValue
        public final Observable<Long> intervalRange(long start, long count, long initialDelay, long period, TimeUnit unit, Scheduler scheduler) {
            Intrinsics.checkNotNullParameter(scheduler, "scheduler");
            boolean z = true;
            if (!(count >= 0)) {
                throw new IllegalArgumentException(("count >= 0 required but it was " + count).toString());
            }
            if (count == 0) {
                Observable<Long> delay = Observable.empty().delay(initialDelay, unit, scheduler);
                Intrinsics.checkNotNullExpressionValue(delay, "empty<Long>().delay(initialDelay, unit, scheduler)");
                return delay;
            }
            long j = start + (count - 1);
            if (start > 0 && j < 0) {
                z = false;
            }
            if (!z) {
                throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE".toString());
            }
            ObjectHelper.requireNonNull(unit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            Observable<Long> onAssembly = RxJavaPlugins.onAssembly(new ObservableIntervalRange(start, j, Math.max(0L, initialDelay), Math.max(0L, period), unit, scheduler));
            Intrinsics.checkNotNullExpressionValue(onAssembly, "onAssembly(\n            …          )\n            )");
            return onAssembly;
        }
    }
}
