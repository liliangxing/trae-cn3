package com.bytedance.tobshadow.applog.exposure;

import android.app.Activity;
import android.app.Application;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.tobshadow.applog.InitConfig;
import com.bytedance.tobshadow.applog.exposure.scroll.ScrollObserveConfig;
import com.bytedance.tobshadow.bdtracker.C0382a1;
import com.bytedance.tobshadow.bdtracker.C0390b1;
import com.bytedance.tobshadow.bdtracker.C0395b6;
import com.bytedance.tobshadow.bdtracker.C0398c1;
import com.bytedance.tobshadow.bdtracker.C0411e;
import com.bytedance.tobshadow.bdtracker.C0427g1;
import com.bytedance.tobshadow.bdtracker.C0467m;
import com.bytedance.tobshadow.bdtracker.C0469m1;
import com.bytedance.tobshadow.bdtracker.C0493p4;
import com.bytedance.tobshadow.bdtracker.C0545x0;
import com.bytedance.tobshadow.bdtracker.C0559z0;
import com.bytedance.tobshadow.bdtracker.EnumC0406d1;
import com.bytedance.tobshadow.bdtracker.ViewOnAttachStateChangeListenerC0413e1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 22\u00020\u0001:\u00012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u001eJ\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\bJ\b\u0010!\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\"\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\bJ\u001e\u0010\"\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\b2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010$J\u001e\u0010%\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020&2\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020'0$J\u001e\u0010%\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020(2\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020'0$J\u0018\u0010)\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\b2\u0006\u0010*\u001a\u00020\tH\u0002J\b\u0010+\u001a\u00020\u001cH\u0002J\u0018\u0010,\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\b2\u0006\u0010*\u001a\u00020\tH\u0002J\u0010\u0010-\u001a\u00020\u001c2\b\u0010.\u001a\u0004\u0018\u00010/J\u000e\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u000bR&\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/bytedance/tobshadow/applog/exposure/ViewExposureManager;", "", "appLog", "Lcom/bytedance/tobshadow/applog/AppLogInstance;", "(Lcom/bytedance/tobshadow/applog/AppLogInstance;)V", "activitiesMap", "Ljava/util/WeakHashMap;", "Landroid/app/Activity;", "Landroid/view/View;", "Lcom/bytedance/tobshadow/applog/exposure/ViewExposureHolder;", "globalConfig", "Lcom/bytedance/tobshadow/applog/exposure/ViewExposureConfig;", "scrollExposureHelper", "Lcom/bytedance/tobshadow/applog/exposure/scroll/ScrollExposureHelper;", "getScrollExposureHelper", "()Lcom/bytedance/tobshadow/applog/exposure/scroll/ScrollExposureHelper;", "scrollExposureHelper$delegate", "Lkotlin/Lazy;", "started", "", "task", "Lcom/bytedance/tobshadow/applog/exposure/task/ViewExposureTask;", "getTask", "()Lcom/bytedance/tobshadow/applog/exposure/task/ViewExposureTask;", "task$delegate", "viewTreeChangeObserver", "Lcom/bytedance/tobshadow/applog/exposure/ViewTreeChangeObserver;", "checkViewExposureFromActivity", "", "activity", "checkViewExposureFromActivity$agent_liteChinaRelease", "disposeViewExposure", "view", "getCurrActivity", "observeViewExposure", "data", "Lcom/bytedance/tobshadow/applog/exposure/ViewExposureData;", "observeViewScroll", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/bytedance/tobshadow/applog/exposure/scroll/ScrollObserveConfig;", "Landroidx/viewpager/widget/ViewPager;", "sendViewExposureEvent", "holder", "start", "triggeredExposure", "updateExposureCheckStrategy", "exposureCheckType", "Lcom/bytedance/tobshadow/applog/exposure/ExposureCheckType;", "updateViewExposureConfig", "viewExposureConfig", "Companion", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ViewExposureManager {

    /* renamed from: a */
    public final WeakHashMap<Activity, WeakHashMap<View, C0559z0>> f399a;

    /* renamed from: b */
    public boolean f400b;

    /* renamed from: c */
    public ViewOnAttachStateChangeListenerC0413e1 f401c;

    /* renamed from: d */
    public ViewExposureConfig f402d;

    /* renamed from: e */
    public final Lazy f403e;

    /* renamed from: f */
    public final Lazy f404f;

    /* renamed from: g */
    public final C0467m f405g;

    /* renamed from: h */
    public static final /* synthetic */ KProperty[] f397h = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ViewExposureManager.class), "task", "getTask()Lcom/bytedance/tobshadow/applog/exposure/task/ViewExposureTask;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ViewExposureManager.class), "scrollExposureHelper", "getScrollExposureHelper()Lcom/bytedance/tobshadow/applog/exposure/scroll/ScrollExposureHelper;"))};

    /* renamed from: i */
    public static final ViewExposureConfig f398i = new ViewExposureConfig(Float.valueOf(1.0f), null, 0, null, 14, null);

    /* renamed from: com.bytedance.tobshadow.applog.exposure.ViewExposureManager$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C0359b extends Lambda implements Function0<C0427g1> {
        public C0359b() {
            super(0);
        }

        public Object invoke() {
            return new C0427g1(ViewExposureManager.this.f405g);
        }
    }

    /* renamed from: com.bytedance.tobshadow.applog.exposure.ViewExposureManager$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C0360c extends Lambda implements Function0<C0469m1> {
        public C0360c() {
            super(0);
        }

        public Object invoke() {
            return new C0469m1(ViewExposureManager.this);
        }
    }

    public ViewExposureManager(C0467m c0467m) {
        Intrinsics.checkParameterIsNotNull(c0467m, "appLog");
        this.f405g = c0467m;
        this.f399a = new WeakHashMap<>();
        Application application = c0467m.f785n;
        if (application == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.app.Application");
        }
        this.f401c = new ViewOnAttachStateChangeListenerC0413e1(application);
        this.f402d = f398i;
        this.f403e = LazyKt.lazy(new C0360c());
        this.f404f = LazyKt.lazy(new C0359b());
        InitConfig initConfig = c0467m.getInitConfig();
        if (initConfig != null && initConfig.isExposureEnabled()) {
            if (this.f400b) {
                return;
            }
            this.f401c.m385a(new C0390b1(this));
            this.f401c.m386a(new C0398c1(this));
            this.f400b = true;
            return;
        }
        c0467m.f764D.warn("[ViewExposure] init failed isExposureEnabled false.", new Object[0]);
    }

    public static final /* synthetic */ C0469m1 access$getTask$p(ViewExposureManager viewExposureManager) {
        Lazy lazy = viewExposureManager.f403e;
        KProperty kProperty = f397h[0];
        return (C0469m1) lazy.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void observeViewScroll$default(ViewExposureManager viewExposureManager, RecyclerView recyclerView, ViewExposureData viewExposureData, int i, Object obj) {
        if ((i & 2) != 0) {
            viewExposureData = viewExposureManager.m229a().f623b;
        }
        viewExposureManager.observeViewScroll(recyclerView, (ViewExposureData<ScrollObserveConfig>) viewExposureData);
    }

    /* renamed from: a */
    public final C0427g1 m229a() {
        Lazy lazy = this.f404f;
        KProperty kProperty = f397h[1];
        return (C0427g1) lazy.getValue();
    }

    /* renamed from: a */
    public final void m230a(View view, C0559z0 c0559z0) {
        Function1<ViewExposureParam, Boolean> exposureCallback;
        C0467m c0467m = this.f405g;
        try {
            ViewExposureData<ViewExposureConfig> viewExposureData = c0559z0.f1264a;
            String eventName = viewExposureData.getEventName();
            if (eventName == null) {
                eventName = "$bav2b_exposure";
            }
            boolean z = true;
            C0493p4 m345a = C0411e.m345a(view, true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("page_key", m345a.f922v);
                jSONObject.put("page_title", m345a.f923w);
                jSONObject.put("element_path", m345a.f924x);
                jSONObject.put("element_width", m345a.f918C);
                jSONObject.put("element_height", m345a.f919D);
                jSONObject.put("element_id", m345a.f925y);
                jSONObject.put("element_type", m345a.f926z);
                ArrayList<String> arrayList = m345a.f917B;
                if (!(arrayList == null || arrayList.isEmpty())) {
                    jSONObject.put("positions", new JSONArray((Collection) m345a.f917B));
                }
                ArrayList<String> arrayList2 = m345a.f916A;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    z = false;
                }
                if (!z) {
                    jSONObject.put("texts", new JSONArray((Collection) m345a.f916A));
                }
                jSONObject.put("$exposure_type", c0559z0.f1266c.f499a);
                JSONObject properties = viewExposureData.getProperties();
                if (properties != null) {
                    C0411e.m375c(properties, jSONObject);
                }
            } catch (Exception e) {
                this.f405g.f764D.error(7, "[ViewExposure] JSON handle failed", e, new Object[0]);
                this.f405g.m522b().mo639a(e, "sendViewExposureEvent");
            }
            ViewExposureConfig config = viewExposureData.getConfig();
            if (config == null || (exposureCallback = config.getExposureCallback()) == null) {
                exposureCallback = this.f402d.getExposureCallback();
            }
            if (((Boolean) exposureCallback.invoke(new ViewExposureParam(jSONObject))).booleanValue()) {
                this.f405g.onEventV3(eventName, jSONObject, 0);
            } else {
                this.f405g.f764D.warn("[ViewExposure] filter sendViewExposureEvent event " + eventName + ", " + jSONObject, new Object[0]);
            }
        } catch (Throwable th) {
            c0467m.f764D.error(7, "Run task failed", th, new Object[0]);
        }
    }

    /* renamed from: b */
    public final void m231b(View view, C0559z0 c0559z0) {
        EnumC0406d1 enumC0406d1;
        int i = C0382a1.f433a[c0559z0.f1266c.ordinal()];
        if (i == 1) {
            enumC0406d1 = EnumC0406d1.EXPOSURE_ONCE;
        } else {
            if (i != 2) {
                if (i == 3 || i == 4) {
                    m230a(view, c0559z0);
                    c0559z0.m761a(EnumC0406d1.EXPOSURE_MORE_THAN_ONCE);
                    c0559z0.f1265b = true;
                    c0559z0.f1267d = 0L;
                }
                m230a(view, c0559z0);
                c0559z0.f1265b = true;
                c0559z0.f1267d = 0L;
            }
            enumC0406d1 = EnumC0406d1.EXPOSURE_MORE_THAN_ONCE;
        }
        c0559z0.m761a(enumC0406d1);
        m230a(view, c0559z0);
        c0559z0.f1265b = true;
        c0559z0.f1267d = 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0091 A[Catch: all -> 0x0134, TryCatch #0 {all -> 0x0134, blocks: (B:3:0x000d, B:5:0x0017, B:6:0x0024, B:8:0x002a, B:10:0x004c, B:11:0x0052, B:13:0x005e, B:15:0x0069, B:17:0x007f, B:18:0x0085, B:23:0x0091, B:25:0x0097, B:26:0x009d, B:30:0x00a5, B:32:0x00b9, B:37:0x00c6, B:38:0x00d1, B:40:0x00d9, B:41:0x00df, B:43:0x00e9, B:44:0x00ee, B:49:0x00cf), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0024 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void checkViewExposureFromActivity$agent_liteChinaRelease(Activity activity) {
        boolean z;
        long j;
        boolean z2;
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        C0467m c0467m = this.f405g;
        try {
            WeakHashMap<View, C0559z0> weakHashMap = this.f399a.get(activity);
            if (weakHashMap != null) {
                Intrinsics.checkExpressionValueIsNotNull(weakHashMap, "activitiesMap[activity] ?: return@runSafely");
                for (Map.Entry<View, C0559z0> entry : weakHashMap.entrySet()) {
                    View key = entry.getKey();
                    C0559z0 value = entry.getValue();
                    ViewExposureData<ViewExposureConfig> viewExposureData = value.f1264a;
                    Intrinsics.checkExpressionValueIsNotNull(key, "view");
                    ViewExposureConfig config = viewExposureData.getConfig();
                    Float areaRatio = config != null ? config.getAreaRatio() : null;
                    Intrinsics.checkParameterIsNotNull(key, "$this$isVisibleInViewport");
                    if (C0411e.m380e(key)) {
                        if (key.getLocalVisibleRect(new Rect())) {
                            if (r10.height() * r10.width() >= key.getMeasuredWidth() * key.getMeasuredHeight() * (areaRatio != null ? areaRatio.floatValue() : 0.0f)) {
                                z = true;
                                if (z) {
                                    j = 0;
                                } else {
                                    j = value.f1267d;
                                    if (j == 0) {
                                        j = System.currentTimeMillis();
                                    }
                                }
                                value.f1267d = j;
                                z2 = value.f1265b;
                                if (z2 != z) {
                                    if (!z2) {
                                        Intrinsics.checkParameterIsNotNull(viewExposureData, "data");
                                        long currentTimeMillis = System.currentTimeMillis() - value.f1267d;
                                        ViewExposureConfig config2 = viewExposureData.getConfig();
                                        if (currentTimeMillis >= (config2 != null ? config2.getStayTriggerTime() : 0L)) {
                                            Intrinsics.checkExpressionValueIsNotNull(value, "holder");
                                            m231b(key, value);
                                        }
                                    } else {
                                        value.f1265b = false;
                                    }
                                    ViewExposureConfig config3 = viewExposureData.getConfig();
                                    if (Intrinsics.areEqual(config3 != null ? config3.getVisualDiagnosis() : null, true)) {
                                        C0411e.m371b(key, value.f1265b);
                                    }
                                    this.f405g.f764D.debug(7, "[ViewExposure] visible change to " + value.f1265b + ", exposureTriggerType=" + value.f1266c + ", config=" + viewExposureData.getConfig() + " view=" + key, new Object[0]);
                                }
                            }
                        }
                    }
                    z = false;
                    if (z) {
                    }
                    value.f1267d = j;
                    z2 = value.f1265b;
                    if (z2 != z) {
                    }
                }
            }
        } catch (Throwable th) {
            c0467m.f764D.error(7, "Run task failed", th, new Object[0]);
        }
    }

    public final void disposeViewExposure(View view) {
        Activity m344a;
        C0559z0 remove;
        Intrinsics.checkParameterIsNotNull(view, "view");
        C0467m c0467m = this.f405g;
        if (view == null) {
            m344a = null;
        } else {
            try {
                m344a = C0411e.m344a(view.getContext());
            } catch (Throwable th) {
                c0467m.f764D.error(7, "Run task failed", th, new Object[0]);
                return;
            }
        }
        if (m344a != null) {
            Intrinsics.checkExpressionValueIsNotNull(m344a, "ActivityUtil.findActivit…view) ?: return@runSafely");
            WeakHashMap<View, C0559z0> weakHashMap = this.f399a.get(m344a);
            if (weakHashMap == null || (remove = weakHashMap.remove(view)) == null) {
                return;
            }
            Intrinsics.checkExpressionValueIsNotNull(remove, "activitiesMap[activity]?…view) ?: return@runSafely");
            ViewExposureConfig config = remove.f1264a.getConfig();
            if (Intrinsics.areEqual(config != null ? config.getVisualDiagnosis() : null, true)) {
                C0411e.m354a(view);
            }
        }
    }

    public final Activity getCurrActivity() {
        return this.f401c.f540a.get();
    }

    public final void observeViewExposure(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        observeViewExposure(view, null);
    }

    public final void observeViewExposure(View view, ViewExposureData<ViewExposureConfig> data) {
        Float areaRatio;
        Boolean visualDiagnosis;
        Function1<ViewExposureParam, Boolean> exposureCallback;
        Intrinsics.checkParameterIsNotNull(view, "view");
        C0467m c0467m = this.f405g;
        try {
            InitConfig initConfig = c0467m.getInitConfig();
            if (initConfig != null && initConfig.isExposureEnabled()) {
                Activity m344a = view == null ? null : C0411e.m344a(view.getContext());
                if (m344a == null) {
                    this.f405g.f764D.warn(7, "[ViewExposure] observe failed: The view context is not Activity.", new Object[0]);
                    return;
                }
                if (C0395b6.m292b(view)) {
                    this.f405g.f764D.warn(7, "[ViewExposure] observe failed: The view is ignored.", new Object[0]);
                    return;
                }
                WeakHashMap<View, C0559z0> weakHashMap = this.f399a.get(m344a);
                if (weakHashMap == null) {
                    weakHashMap = new WeakHashMap<>();
                    this.f399a.put(m344a, weakHashMap);
                }
                ViewExposureConfig viewExposureConfig = this.f402d;
                ViewExposureConfig config = data != null ? data.getConfig() : null;
                Intrinsics.checkParameterIsNotNull(viewExposureConfig, "$this$copyWith");
                if (config == null || (areaRatio = config.getAreaRatio()) == null) {
                    areaRatio = viewExposureConfig.getAreaRatio();
                }
                Float f = areaRatio;
                if (config == null || (visualDiagnosis = config.getVisualDiagnosis()) == null) {
                    visualDiagnosis = viewExposureConfig.getVisualDiagnosis();
                }
                ViewExposureConfig viewExposureConfig2 = new ViewExposureConfig(f, visualDiagnosis, config != null ? config.getStayTriggerTime() : viewExposureConfig.getStayTriggerTime(), (config == null || (exposureCallback = config.getExposureCallback()) == null) ? viewExposureConfig.getExposureCallback() : exposureCallback);
                weakHashMap.put(view, new C0559z0(new ViewExposureData(data != null ? data.getEventName() : null, data != null ? data.getProperties() : null, viewExposureConfig2), false, null, 0L, 14));
                if (Intrinsics.areEqual(viewExposureConfig2.getVisualDiagnosis(), true)) {
                    Intrinsics.checkParameterIsNotNull(view, "$this$enableViewExposureDebugMode");
                    if (view instanceof ImageView) {
                        ImageView imageView = (ImageView) view;
                        imageView.setImageDrawable(new C0545x0(imageView.getDrawable()));
                    }
                    view.setBackground(new C0545x0(view.getBackground()));
                }
                checkViewExposureFromActivity$agent_liteChinaRelease(m344a);
                this.f401c.m384a(view);
                this.f405g.f764D.debug(7, "[ViewExposure] observe successful, data=" + data + ", view=" + view, new Object[0]);
                return;
            }
            this.f405g.f764D.warn(7, "[ViewExposure] observe failed: InitConfig.exposureEnabled is not true.", new Object[0]);
        } catch (Throwable th) {
            c0467m.f764D.error(7, "Run task failed", th, new Object[0]);
        }
    }

    public final void observeViewScroll(RecyclerView view, ViewExposureData<ScrollObserveConfig> data) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(data, "data");
        m229a().m445a(view, data);
    }

    public final void observeViewScroll(ViewPager view, ViewExposureData<ScrollObserveConfig> data) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(data, "data");
        m229a().m446a(view, data);
    }

    public final void updateExposureCheckStrategy(ExposureCheckType exposureCheckType) {
        Lazy lazy = this.f403e;
        KProperty kProperty = f397h[0];
        ((C0469m1) lazy.getValue()).m527a(exposureCheckType);
    }

    public final void updateViewExposureConfig(ViewExposureConfig viewExposureConfig) {
        Intrinsics.checkParameterIsNotNull(viewExposureConfig, "viewExposureConfig");
        this.f402d = viewExposureConfig;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void observeViewScroll$default(ViewExposureManager viewExposureManager, ViewPager viewPager, ViewExposureData viewExposureData, int i, Object obj) {
        if ((i & 2) != 0) {
            viewExposureData = viewExposureManager.m229a().f623b;
        }
        viewExposureManager.observeViewScroll(viewPager, (ViewExposureData<ScrollObserveConfig>) viewExposureData);
    }
}
