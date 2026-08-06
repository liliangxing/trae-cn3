package com.bytedance.tobshadow.bdtracker;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.bytedance.tobshadow.bdtracker.f1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0420f1 extends RecyclerView.OnScrollListener {

    /* renamed from: a */
    public int f579a;

    /* renamed from: b */
    public int f580b;

    /* renamed from: c */
    public final int f581c;

    /* renamed from: d */
    public final Function3<Float, Float, Integer, Unit> f582d;

    /* JADX WARN: Multi-variable type inference failed */
    public C0420f1(int i, Function3<? super Float, ? super Float, ? super Integer, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "sendScrollObserveCallback");
        this.f581c = i;
        this.f582d = function3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
    
        if (r5.f580b > 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0064, code lost:
    
        if (r5.f580b <= 0) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i);
        if (i == 0) {
            if (Math.abs(this.f579a) >= this.f581c || Math.abs(this.f580b) >= this.f581c) {
                Function3<Float, Float, Integer, Unit> function3 = this.f582d;
                Float valueOf = Float.valueOf(this.f579a);
                Float valueOf2 = Float.valueOf(this.f580b);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                int i2 = 1;
                if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager layoutManager2 = recyclerView.getLayoutManager();
                    if (layoutManager2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    }
                    int orientation = layoutManager2.getOrientation();
                    if (orientation != 0) {
                        if (orientation == 1) {
                        }
                        i2 = 2;
                    } else {
                        i2 = this.f579a > 0 ? 4 : 3;
                    }
                } else {
                    if (layoutManager instanceof StaggeredGridLayoutManager) {
                    }
                    i2 = 2;
                }
                function3.invoke(valueOf, valueOf2, Integer.valueOf(i2));
                this.f579a = 0;
                this.f580b = 0;
            }
        }
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        if (Math.abs(i) > this.f581c || Math.abs(i2) > this.f581c) {
            int i3 = this.f579a;
            this.f579a = i > 0 ? Math.max(i3, i) : Math.min(i3, i);
            int i4 = this.f580b;
            this.f580b = i2 > 0 ? Math.max(i4, i2) : Math.min(i4, i2);
        }
    }
}
