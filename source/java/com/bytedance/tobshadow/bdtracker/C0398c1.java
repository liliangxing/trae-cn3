package com.bytedance.tobshadow.bdtracker;

import android.app.Activity;
import com.bytedance.tobshadow.applog.exposure.ViewExposureManager;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.bytedance.tobshadow.bdtracker.c1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0398c1 extends Lambda implements Function2<Activity, Boolean, Unit> {

    /* renamed from: a */
    public final /* synthetic */ ViewExposureManager f478a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0398c1(ViewExposureManager viewExposureManager) {
        super(2);
        this.f478a = viewExposureManager;
    }

    public Object invoke(Object obj, Object obj2) {
        WeakHashMap weakHashMap;
        Activity activity = (Activity) obj;
        boolean booleanValue = ((Boolean) obj2).booleanValue();
        if (activity != null) {
            weakHashMap = this.f478a.f399a;
            WeakHashMap weakHashMap2 = (WeakHashMap) weakHashMap.get(activity);
            if (weakHashMap2 != null) {
                Intrinsics.checkExpressionValueIsNotNull(weakHashMap2, "activitiesMap[activity] …erActivityStoppedCallback");
                Iterator it = weakHashMap2.entrySet().iterator();
                while (it.hasNext()) {
                    C0559z0 c0559z0 = (C0559z0) ((Map.Entry) it.next()).getValue();
                    if (c0559z0 != null) {
                        EnumC0406d1 enumC0406d1 = c0559z0.f1266c;
                        EnumC0406d1 enumC0406d12 = EnumC0406d1.NOT_EXPOSURE;
                        if (enumC0406d1 != enumC0406d12) {
                            enumC0406d12 = booleanValue ? EnumC0406d1.RESUME_FORM_BACK : EnumC0406d1.RESUME_FORM_PAGE;
                        }
                        c0559z0.f1266c = enumC0406d12;
                        c0559z0.f1265b = false;
                        c0559z0.f1267d = 0L;
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }
}
