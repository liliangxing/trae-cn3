package com.bytedance.tobshadow.bdtracker;

import android.os.Handler;
import com.bytedance.applog.aggregation.Metrics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.bytedance.tobshadow.bdtracker.y2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0554y2 extends Lambda implements Function1<List<? extends Metrics>, Unit> {

    /* renamed from: a */
    public final /* synthetic */ C0561z2 f1257a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0554y2(C0561z2 c0561z2) {
        super(1);
        this.f1257a = c0561z2;
    }

    public Object invoke(Object obj) {
        C0475n0 c0475n0;
        C0475n0 c0475n02;
        List<Metrics> list = (List) obj;
        Intrinsics.checkParameterIsNotNull(list, "list");
        ArrayList arrayList = new ArrayList();
        for (Metrics metrics : list) {
            C0394b5 c0394b5 = new C0394b5();
            c0475n0 = this.f1257a.f1272c;
            C0510s0 c0510s0 = c0475n0.f844n;
            c0475n02 = this.f1257a.f1272c;
            c0510s0.m650a(c0475n02.f834d, c0394b5);
            c0394b5.f884o = metrics.toParams();
            arrayList.add(c0394b5);
        }
        Handler handler = this.f1257a.f1270a;
        handler.sendMessage(handler.obtainMessage(1, arrayList));
        this.f1257a.f1270a.sendEmptyMessage(2);
        return Unit.INSTANCE;
    }
}
