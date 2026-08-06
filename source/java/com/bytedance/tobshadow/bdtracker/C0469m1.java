package com.bytedance.tobshadow.bdtracker;

import android.app.Activity;
import com.bytedance.tobshadow.applog.exposure.ExposureCheckType;
import com.bytedance.tobshadow.applog.exposure.ViewExposureManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/tobshadow/applog/exposure/task/ViewExposureTask;", "", "manager", "Lcom/bytedance/tobshadow/applog/exposure/ViewExposureManager;", "(Lcom/bytedance/tobshadow/applog/exposure/ViewExposureManager;)V", "checkStrategy", "Lcom/bytedance/tobshadow/applog/exposure/task/BaseCheckExposureStrategy;", "getCheckStrategy", "()Lcom/bytedance/tobshadow/applog/exposure/task/BaseCheckExposureStrategy;", "setCheckStrategy", "(Lcom/bytedance/tobshadow/applog/exposure/task/BaseCheckExposureStrategy;)V", "checkTask", "Ljava/lang/Runnable;", "check", "", "updateExposureCheckStrategy", "exposureCheckType", "Lcom/bytedance/tobshadow/applog/exposure/ExposureCheckType;", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* renamed from: com.bytedance.tobshadow.bdtracker.m1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0469m1 {

    /* renamed from: a */
    public final Runnable f807a;

    /* renamed from: b */
    public AbstractC0441i1 f808b;

    /* renamed from: c */
    public final ViewExposureManager f809c;

    /* renamed from: com.bytedance.tobshadow.bdtracker.m1$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Activity currActivity = C0469m1.this.f809c.getCurrActivity();
            if (currActivity != null) {
                C0469m1.this.f809c.checkViewExposureFromActivity$agent_liteChinaRelease(currActivity);
            }
        }
    }

    public C0469m1(ViewExposureManager viewExposureManager) {
        Intrinsics.checkParameterIsNotNull(viewExposureManager, "manager");
        this.f809c = viewExposureManager;
        a aVar = new a();
        this.f807a = aVar;
        this.f808b = new C0448j1(aVar);
    }

    /* renamed from: a */
    public final void m527a(ExposureCheckType exposureCheckType) {
        this.f808b = (exposureCheckType != null && C0462l1.f736a[exposureCheckType.ordinal()] == 1) ? new C0455k1(this.f807a) : new C0448j1(this.f807a);
    }
}
