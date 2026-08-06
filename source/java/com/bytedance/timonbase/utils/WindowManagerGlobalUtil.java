package com.bytedance.timonbase.utils;

import android.app.Activity;
import android.app.Application;
import android.view.View;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.TMLogger;
import com.bytedance.timonbase.report.TMDataCollector;
import com.bytedance.timonbase.scene.lifecycle.SimpleActivityLifecycleCallbacks;
import com.bytedance.timonbase.utils.WindowManagerGlobalUtil;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowManagerGlobalUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fJ\u0006\u0010\u0018\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0005\u0010\u0007R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/timonbase/utils/WindowManagerGlobalUtil;", "", "()V", "TAG", "", "isHookSuccess", "", "()Z", "isHookSuccess$delegate", "Lkotlin/Lazy;", "mCallbacks", "Ljava/util/ArrayList;", "Lcom/bytedance/timonbase/utils/WindowManagerGlobalUtil$Callback;", "Lkotlin/collections/ArrayList;", "mChangingConfigActivity", "mCurrentActivity", "Landroid/app/Activity;", "mFrontActivityCount", "", "mViewList", "Lcom/bytedance/timonbase/utils/WindowManagerGlobalUtil$ViewList;", "addCallback", "", "callback", "init", "isAppFocused", "removeCallback", "Callback", "ViewList", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class WindowManagerGlobalUtil {
    private static final String TAG = "WindowManagerGlobalUtil";
    private static boolean mChangingConfigActivity;
    private static Activity mCurrentActivity;
    private static int mFrontActivityCount;
    private static ViewList mViewList;
    public static final WindowManagerGlobalUtil INSTANCE = new WindowManagerGlobalUtil();

    /* renamed from: isHookSuccess$delegate, reason: from kotlin metadata */
    private static final Lazy isHookSuccess = LazyKt.lazy(new Function0<Boolean>() { // from class: com.bytedance.timonbase.utils.WindowManagerGlobalUtil$isHookSuccess$2
        public /* bridge */ /* synthetic */ Object invoke() {
            return Boolean.valueOf(m1086invoke());
        }

        /* JADX WARN: Not initialized variable reg: 7, insn: 0x0079: MOVE (r0 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]), block:B:28:0x0078 */
        /* renamed from: invoke, reason: collision with other method in class */
        public final boolean m1086invoke() {
            Throwable th;
            WindowManagerGlobalUtil.ViewList viewList;
            Object invoke;
            Field declaredField;
            Object obj;
            WindowManagerGlobalUtil.ViewList viewList2;
            Throwable th2;
            WindowManagerGlobalUtil.ViewList viewList3 = new WindowManagerGlobalUtil.ViewList(CollectionsKt.emptyList());
            boolean z = false;
            try {
                Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
                invoke = cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                declaredField = cls.getDeclaredField("mViews");
                Intrinsics.checkExpressionValueIsNotNull(declaredField, "mViewsField");
                declaredField.setAccessible(true);
                Field declaredField2 = cls.getDeclaredField("mLock");
                Intrinsics.checkExpressionValueIsNotNull(declaredField2, "mLockField");
                declaredField2.setAccessible(true);
                obj = declaredField2.get(invoke);
                Intrinsics.checkExpressionValueIsNotNull(obj, "lock");
                try {
                } catch (Throwable th3) {
                    th = th3;
                    viewList3 = viewList2;
                    TMDataCollector.reportException$default(TMDataCollector.INSTANCE, "WindowManagerGlobalUtil", th, "WindowManagerGlobalHookFailed", MapsKt.emptyMap(), false, 16, null);
                    viewList = viewList3;
                    WindowManagerGlobalUtil windowManagerGlobalUtil = WindowManagerGlobalUtil.INSTANCE;
                    WindowManagerGlobalUtil.mViewList = viewList;
                    return z;
                }
            } catch (Throwable th4) {
                th = th4;
            }
            synchronized (obj) {
                try {
                    Object obj2 = declaredField.get(invoke);
                    if (obj2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<android.view.View> /* = java.util.ArrayList<android.view.View> */");
                    }
                    viewList = new WindowManagerGlobalUtil.ViewList((ArrayList) obj2);
                    try {
                        declaredField.set(invoke, viewList);
                        Unit unit = Unit.INSTANCE;
                        TMLogger.INSTANCE.m223i("WindowManagerGlobalUtil", "WindowManagerGlobalHookSuccess");
                        z = true;
                        WindowManagerGlobalUtil windowManagerGlobalUtil2 = WindowManagerGlobalUtil.INSTANCE;
                        WindowManagerGlobalUtil.mViewList = viewList;
                        return z;
                    } catch (Throwable th5) {
                        th2 = th5;
                        throw th2;
                    }
                } catch (Throwable th6) {
                    th2 = th6;
                }
            }
        }
    });
    private static final ArrayList<Callback> mCallbacks = new ArrayList<>();

    /* compiled from: WindowManagerGlobalUtil.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/timonbase/utils/WindowManagerGlobalUtil$Callback;", "", "onRootViewAdded", "", "view", "Landroid/view/View;", "onRootViewRemoved", "timonbase_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface Callback {

        /* compiled from: WindowManagerGlobalUtil.kt */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class DefaultImpls {
            public static void onRootViewAdded(Callback callback, View view) {
                Intrinsics.checkParameterIsNotNull(view, "view");
            }

            public static void onRootViewRemoved(Callback callback, View view) {
                Intrinsics.checkParameterIsNotNull(view, "view");
            }
        }

        void onRootViewAdded(View view);

        void onRootViewRemoved(View view);
    }

    public final boolean isHookSuccess() {
        return ((Boolean) isHookSuccess.getValue()).booleanValue();
    }

    static {
        Collection collection = null;
        mViewList = new ViewList(collection, 1, collection);
    }

    private WindowManagerGlobalUtil() {
    }

    public static final /* synthetic */ ArrayList access$getMCallbacks$p(WindowManagerGlobalUtil windowManagerGlobalUtil) {
        return mCallbacks;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WindowManagerGlobalUtil.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0015\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/timonbase/utils/WindowManagerGlobalUtil$ViewList;", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "collection", "", "(Ljava/util/Collection;)V", "add", "", "element", "remove", "timonbase_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class ViewList extends ArrayList<View> {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public ViewList() {
            this(r0, 1, r0);
            Collection collection = null;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewList(Collection<? extends View> collection) {
            super(collection);
            Intrinsics.checkParameterIsNotNull(collection, "collection");
        }

        public /* synthetic */ ViewList(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList);
        }

        public /* bridge */ boolean contains(View view) {
            return super.contains((Object) view);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof View) {
                return contains((View) obj);
            }
            return false;
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ int indexOf(View view) {
            return super.indexOf((Object) view);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof View) {
                return indexOf((View) obj);
            }
            return -1;
        }

        public /* bridge */ int lastIndexOf(View view) {
            return super.lastIndexOf((Object) view);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof View) {
                return lastIndexOf((View) obj);
            }
            return -1;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ View remove(int i) {
            return removeAt(i);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean remove(Object obj) {
            if (obj instanceof View) {
                return remove((View) obj);
            }
            return false;
        }

        public /* bridge */ View removeAt(int i) {
            return (View) super.remove(i);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(View element) {
            Intrinsics.checkParameterIsNotNull(element, "element");
            Iterator it = WindowManagerGlobalUtil.access$getMCallbacks$p(WindowManagerGlobalUtil.INSTANCE).iterator();
            while (it.hasNext()) {
                ((Callback) it.next()).onRootViewAdded(element);
            }
            return super.add((ViewList) element);
        }

        public boolean remove(View element) {
            Intrinsics.checkParameterIsNotNull(element, "element");
            Iterator it = WindowManagerGlobalUtil.access$getMCallbacks$p(WindowManagerGlobalUtil.INSTANCE).iterator();
            while (it.hasNext()) {
                ((Callback) it.next()).onRootViewRemoved(element);
            }
            return super.remove((Object) element);
        }
    }

    public final void init() {
        Application application = TMEnv.INSTANCE.getApplication();
        if (application != null) {
            application.registerActivityLifecycleCallbacks(new SimpleActivityLifecycleCallbacks() { // from class: com.bytedance.timonbase.utils.WindowManagerGlobalUtil$init$1
                @Override // com.bytedance.timonbase.scene.lifecycle.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    boolean z;
                    int i;
                    Intrinsics.checkParameterIsNotNull(activity, "activity");
                    WindowManagerGlobalUtil windowManagerGlobalUtil = WindowManagerGlobalUtil.INSTANCE;
                    z = WindowManagerGlobalUtil.mChangingConfigActivity;
                    if (z) {
                        WindowManagerGlobalUtil windowManagerGlobalUtil2 = WindowManagerGlobalUtil.INSTANCE;
                        WindowManagerGlobalUtil.mChangingConfigActivity = false;
                        return;
                    }
                    WindowManagerGlobalUtil windowManagerGlobalUtil3 = WindowManagerGlobalUtil.INSTANCE;
                    i = WindowManagerGlobalUtil.mFrontActivityCount;
                    WindowManagerGlobalUtil.mFrontActivityCount = i + 1;
                    WindowManagerGlobalUtil windowManagerGlobalUtil4 = WindowManagerGlobalUtil.INSTANCE;
                    WindowManagerGlobalUtil.mCurrentActivity = activity;
                }

                @Override // com.bytedance.timonbase.scene.lifecycle.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    int i;
                    int i2;
                    Intrinsics.checkParameterIsNotNull(activity, "activity");
                    if (activity.isChangingConfigurations()) {
                        WindowManagerGlobalUtil windowManagerGlobalUtil = WindowManagerGlobalUtil.INSTANCE;
                        WindowManagerGlobalUtil.mChangingConfigActivity = true;
                        return;
                    }
                    WindowManagerGlobalUtil windowManagerGlobalUtil2 = WindowManagerGlobalUtil.INSTANCE;
                    i = WindowManagerGlobalUtil.mFrontActivityCount;
                    WindowManagerGlobalUtil.mFrontActivityCount = i - 1;
                    WindowManagerGlobalUtil windowManagerGlobalUtil3 = WindowManagerGlobalUtil.INSTANCE;
                    i2 = WindowManagerGlobalUtil.mFrontActivityCount;
                    if (i2 == 0) {
                        WindowManagerGlobalUtil windowManagerGlobalUtil4 = WindowManagerGlobalUtil.INSTANCE;
                        WindowManagerGlobalUtil.mCurrentActivity = null;
                    }
                }
            });
        }
    }

    public final boolean isAppFocused() {
        Activity activity = mCurrentActivity;
        if ((activity != null ? activity.hasWindowFocus() : false) || !isHookSuccess() || mViewList.isEmpty()) {
            return true;
        }
        Iterator<View> it = mViewList.iterator();
        while (it.hasNext()) {
            if (it.next().hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }

    public final void addCallback(Callback callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        mCallbacks.add(callback);
    }

    public final void removeCallback(Callback callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        mCallbacks.remove(callback);
    }
}
