package com.bytedance.tobshadow.bdtracker;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.bytedance.tobshadow.applog.C0355R;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u0004\u0018\u00010\nJ\b\u0010#\u001a\u00020\u000eH\u0002J\u0010\u0010$\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u001fH\u0002J\u001a\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\nH\u0016J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\nH\u0016J\u0010\u0010+\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\nH\u0016J\u0018\u0010,\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\n2\u0006\u0010-\u001a\u00020(H\u0016J\u0010\u0010.\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\nH\u0016J\u0010\u0010/\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\nH\u0016J\u0012\u00100\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u00101\u001a\u00020\u000e2\b\u00102\u001a\u0004\u0018\u00010\u001fH\u0016J&\u00103\u001a\u00020\u000e2\u001e\u00104\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u0002`\u000fJ\u001a\u00105\u001a\u00020\u000e2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\u001bJ\u0006\u00106\u001a\u00020\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fj\u0004\u0018\u0001`\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001bj\u0004\u0018\u0001`\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/bytedance/tobshadow/applog/exposure/ViewTreeChangeObserver;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/view/View$OnAttachStateChangeListener;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "getApplication", "()Landroid/app/Application;", "currentActivityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "onActivityStoppedCallback", "Lkotlin/Function2;", "", "", "Lcom/bytedance/tobshadow/applog/exposure/ActivityStoppedCallback;", "onDrawListener", "Landroid/view/ViewTreeObserver$OnDrawListener;", "onGlobalFocusChangeListener", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "onGlobalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onScrollChangedListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "onWindowFocusChangeListener", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "viewTreeChangeCallback", "Lkotlin/Function1;", "Lcom/bytedance/tobshadow/applog/exposure/ViewTreeChangeCallback;", "checkObserveViewTree", "view", "Landroid/view/View;", "disposeViewTree", "rootView", "getCurrentActivity", "invokeCallback", "observeViewTree", "onActivityCreated", "activity", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "onViewAttachedToWindow", "onViewDetachedFromWindow", "v", "registerActivityStoppedCallback", "callback", "subscribe", "unsubscribe", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* renamed from: com.bytedance.tobshadow.bdtracker.e1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ViewOnAttachStateChangeListenerC0413e1 implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener {

    /* renamed from: a */
    public WeakReference<Activity> f540a;

    /* renamed from: b */
    public ViewTreeObserver.OnDrawListener f541b;

    /* renamed from: c */
    public ViewTreeObserver.OnGlobalLayoutListener f542c;

    /* renamed from: d */
    public ViewTreeObserver.OnGlobalFocusChangeListener f543d;

    /* renamed from: e */
    public ViewTreeObserver.OnScrollChangedListener f544e;

    /* renamed from: f */
    public ViewTreeObserver.OnWindowFocusChangeListener f545f;

    /* renamed from: g */
    public Function1<? super Activity, Unit> f546g;

    /* renamed from: h */
    public Function2<? super Activity, ? super Boolean, Unit> f547h;

    /* renamed from: i */
    public final Application f548i;

    /* renamed from: com.bytedance.tobshadow.bdtracker.e1$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class a implements ViewTreeObserver.OnDrawListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public final void onDraw() {
            ViewOnAttachStateChangeListenerC0413e1.this.m383a();
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.e1$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class b implements ViewTreeObserver.OnGlobalFocusChangeListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public final void onGlobalFocusChanged(View view, View view2) {
            ViewOnAttachStateChangeListenerC0413e1.this.m383a();
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.e1$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            ViewOnAttachStateChangeListenerC0413e1.this.m383a();
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.e1$d */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class d implements ViewTreeObserver.OnScrollChangedListener {
        public d() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            ViewOnAttachStateChangeListenerC0413e1.this.m383a();
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.e1$e */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class e implements ViewTreeObserver.OnWindowFocusChangeListener {
        public e() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public final void onWindowFocusChanged(boolean z) {
            ViewOnAttachStateChangeListenerC0413e1.this.m383a();
        }
    }

    public ViewOnAttachStateChangeListenerC0413e1(Application application) {
        Intrinsics.checkParameterIsNotNull(application, "application");
        this.f548i = application;
        this.f540a = new WeakReference<>(null);
        this.f541b = new a();
        this.f542c = new c();
        this.f543d = new b();
        this.f544e = new d();
        this.f545f = new e();
    }

    /* renamed from: a */
    public final void m383a() {
        try {
            Activity activity = this.f540a.get();
            if (activity != null) {
                Intrinsics.checkExpressionValueIsNotNull(activity, "currentActivityRef.get() ?: return");
                Function1<? super Activity, Unit> function1 = this.f546g;
                if (function1 != null) {
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public final void m384a(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        if (!view.isAttachedToWindow()) {
            view.addOnAttachStateChangeListener(this);
            return;
        }
        View rootView = view.getRootView();
        Intrinsics.checkExpressionValueIsNotNull(rootView, "view.rootView");
        m387b(rootView);
    }

    /* renamed from: a */
    public final void m385a(Function1<? super Activity, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "callback");
        if (this.f546g == null) {
            this.f546g = function1;
            this.f548i.registerActivityLifecycleCallbacks(this);
        }
    }

    /* renamed from: a */
    public final void m386a(Function2<? super Activity, ? super Boolean, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "callback");
        this.f547h = function2;
    }

    /* renamed from: b */
    public final void m387b(View view) {
        if (Intrinsics.areEqual(view.getTag(C0355R.id.applog_tag_view_exposure_observe_flag), true)) {
            return;
        }
        view.setTag(C0355R.id.applog_tag_view_exposure_observe_flag, true);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        viewTreeObserver.addOnGlobalFocusChangeListener(this.f543d);
        viewTreeObserver.addOnScrollChangedListener(this.f544e);
        viewTreeObserver.addOnDrawListener(this.f541b);
        viewTreeObserver.addOnGlobalLayoutListener(this.f542c);
        viewTreeObserver.addOnWindowFocusChangeListener(this.f545f);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Window window = activity.getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "activity.window");
        View decorView = window.getDecorView();
        Intrinsics.checkExpressionValueIsNotNull(decorView, "activity.window.decorView");
        if (!Intrinsics.areEqual(decorView.getTag(C0355R.id.applog_tag_view_exposure_observe_flag), true)) {
            return;
        }
        decorView.setTag(C0355R.id.applog_tag_view_exposure_observe_flag, false);
        ViewTreeObserver viewTreeObserver = decorView.getViewTreeObserver();
        viewTreeObserver.removeOnGlobalFocusChangeListener(this.f543d);
        viewTreeObserver.removeOnScrollChangedListener(this.f544e);
        viewTreeObserver.removeOnDrawListener(this.f541b);
        viewTreeObserver.removeOnGlobalLayoutListener(this.f542c);
        viewTreeObserver.removeOnWindowFocusChangeListener(this.f545f);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        this.f540a = new WeakReference<>(activity);
        Window window = activity.getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "activity.window");
        View decorView = window.getDecorView();
        Intrinsics.checkExpressionValueIsNotNull(decorView, "activity.window.decorView");
        m387b(decorView);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Function2<? super Activity, ? super Boolean, Unit> function2;
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Activity activity2 = this.f540a.get();
        if (activity2 == null || (function2 = this.f547h) == null) {
            return;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        if (view != null) {
            View rootView = view.getRootView();
            Intrinsics.checkExpressionValueIsNotNull(rootView, "view.rootView");
            m387b(rootView);
            view.removeOnAttachStateChangeListener(this);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v) {
    }
}
