package com.bytedance.tobshadow.bdtracker;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.tobshadow.applog.InitConfig;
import com.bytedance.tobshadow.applog.exposure.ViewExposureData;
import com.bytedance.tobshadow.applog.exposure.ViewExposureParam;
import com.bytedance.tobshadow.applog.exposure.scroll.ScrollObserveConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00102\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J6\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00122\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/tobshadow/applog/exposure/scroll/ScrollExposureHelper;", "", "appLog", "Lcom/bytedance/tobshadow/applog/AppLogInstance;", "(Lcom/bytedance/tobshadow/applog/AppLogInstance;)V", "defaultData", "Lcom/bytedance/tobshadow/applog/exposure/ViewExposureData;", "Lcom/bytedance/tobshadow/applog/exposure/scroll/ScrollObserveConfig;", "getDefaultData", "()Lcom/bytedance/tobshadow/applog/exposure/ViewExposureData;", "globalConfig", "observeViewScroll", "", "view", "Landroidx/recyclerview/widget/RecyclerView;", "data", "Landroidx/viewpager/widget/ViewPager;", "sendScrollExposure", "Landroid/view/View;", "dx", "", "dy", "direction", "", "Companion", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* renamed from: com.bytedance.tobshadow.bdtracker.g1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0427g1 {

    /* renamed from: a */
    public final ScrollObserveConfig f622a;

    /* renamed from: b */
    public final ViewExposureData<ScrollObserveConfig> f623b;

    /* renamed from: c */
    public final C0467m f624c;

    /* renamed from: com.bytedance.tobshadow.bdtracker.g1$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class a extends Lambda implements Function3<Float, Float, Integer, Unit> {

        /* renamed from: b */
        public final /* synthetic */ ViewExposureData f626b;

        /* renamed from: c */
        public final /* synthetic */ RecyclerView f627c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ViewExposureData viewExposureData, RecyclerView recyclerView) {
            super(3);
            this.f626b = viewExposureData;
            this.f627c = recyclerView;
        }

        public Object invoke(Object obj, Object obj2, Object obj3) {
            C0427g1.this.m444a(this.f627c, this.f626b, ((Number) obj).floatValue(), ((Number) obj2).floatValue(), ((Number) obj3).intValue());
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.g1$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class b extends Lambda implements Function3<Float, Float, Integer, Unit> {

        /* renamed from: b */
        public final /* synthetic */ ViewExposureData f629b;

        /* renamed from: c */
        public final /* synthetic */ ViewPager f630c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ViewExposureData viewExposureData, ViewPager viewPager) {
            super(3);
            this.f629b = viewExposureData;
            this.f630c = viewPager;
        }

        public Object invoke(Object obj, Object obj2, Object obj3) {
            C0427g1.this.m444a(this.f630c, this.f629b, ((Number) obj).floatValue(), ((Number) obj2).floatValue(), ((Number) obj3).intValue());
            return Unit.INSTANCE;
        }
    }

    public C0427g1(C0467m c0467m) {
        Intrinsics.checkParameterIsNotNull(c0467m, "appLog");
        this.f624c = c0467m;
        ScrollObserveConfig scrollObserveConfig = new ScrollObserveConfig(0, null, 3, null);
        this.f622a = scrollObserveConfig;
        this.f623b = new ViewExposureData<>(null, null, scrollObserveConfig, 3, null);
    }

    /* renamed from: a */
    public final void m445a(RecyclerView recyclerView, ViewExposureData<ScrollObserveConfig> viewExposureData) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "view");
        Intrinsics.checkParameterIsNotNull(viewExposureData, "data");
        C0467m c0467m = this.f624c;
        try {
            InitConfig initConfig = c0467m.getInitConfig();
            if (initConfig == null || !initConfig.isScrollObserveEnabled()) {
                this.f624c.f764D.warn("[ScrollExposure] observeScrollExposure failed isScrollExposureEnabled false.", new Object[0]);
            } else {
                ScrollObserveConfig config = viewExposureData.getConfig();
                recyclerView.addOnScrollListener(new C0420f1(config != null ? config.getMinOffset() : 30, new a(viewExposureData, recyclerView)));
            }
        } catch (Throwable th) {
            c0467m.f764D.error(7, "Run task failed", th, new Object[0]);
        }
    }

    /* renamed from: a */
    public final void m446a(ViewPager viewPager, ViewExposureData<ScrollObserveConfig> viewExposureData) {
        Intrinsics.checkParameterIsNotNull(viewPager, "view");
        Intrinsics.checkParameterIsNotNull(viewExposureData, "data");
        C0467m c0467m = this.f624c;
        try {
            InitConfig initConfig = c0467m.getInitConfig();
            if (initConfig == null || !initConfig.isScrollObserveEnabled()) {
                this.f624c.f764D.warn("[ScrollExposure] observeScrollExposure failed isScrollExposureEnabled false.", new Object[0]);
            } else {
                ScrollObserveConfig config = viewExposureData.getConfig();
                viewPager.addOnPageChangeListener(new C0434h1(config != null ? config.getMinOffset() : 30, new b(viewExposureData, viewPager)));
            }
        } catch (Throwable th) {
            c0467m.f764D.error(7, "Run task failed", th, new Object[0]);
        }
    }

    /* renamed from: a */
    public final void m444a(View view, ViewExposureData<ScrollObserveConfig> viewExposureData, float f, float f2, int i) {
        Function1<ViewExposureParam, Boolean> scrollCallback;
        String eventName = viewExposureData.getEventName();
        if (eventName == null) {
            eventName = "$bav2b_slide";
        }
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
            jSONObject.put("$offsetX", Float.valueOf(f));
            jSONObject.put("$offsetY", Float.valueOf(f2));
            jSONObject.put("$direction", i);
            JSONObject properties = viewExposureData.getProperties();
            if (properties != null) {
                C0411e.m375c(properties, jSONObject);
            }
        } catch (Exception e) {
            this.f624c.f764D.error(7, "[ScrollExposure] JSON handle failed", e, new Object[0]);
        }
        ScrollObserveConfig config = viewExposureData.getConfig();
        if (config == null || (scrollCallback = config.getScrollCallback()) == null) {
            scrollCallback = this.f622a.getScrollCallback();
        }
        if (((Boolean) scrollCallback.invoke(new ViewExposureParam(jSONObject))).booleanValue()) {
            this.f624c.onEventV3(eventName, jSONObject, 0);
        } else {
            this.f624c.f764D.warn("[ScrollExposure] filter sendScrollExposure event " + eventName + ", " + jSONObject, new Object[0]);
        }
    }
}
