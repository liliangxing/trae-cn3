package com.bytedance.android.anniex.container.popup;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.lynx.tasm.LynxView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXLynxViewNestedScrollUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/anniex/container/popup/AnnieXLynxViewNestedScrollUtil;", "", "()V", "findViewByRecursive", "Landroid/view/View;", "v", "predicate", "Lkotlin/Function1;", "", "handleNestedScrollWithVp", "", "lynxView", "Lcom/lynx/tasm/LynxView;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXLynxViewNestedScrollUtil {
    public static final AnnieXLynxViewNestedScrollUtil INSTANCE = new AnnieXLynxViewNestedScrollUtil();

    private AnnieXLynxViewNestedScrollUtil() {
    }

    public final void handleNestedScrollWithVp(LynxView lynxView) {
        Intrinsics.checkNotNullParameter(lynxView, "lynxView");
        final View findViewByRecursive = findViewByRecursive((View) lynxView, new Function1<View, Boolean>() { // from class: com.bytedance.android.anniex.container.popup.AnnieXLynxViewNestedScrollUtil$handleNestedScrollWithVp$vp$1
            public final Boolean invoke(View view) {
                Intrinsics.checkNotNullParameter(view, "v");
                return Boolean.valueOf(view instanceof ViewPager);
            }
        });
        boolean z = findViewByRecursive instanceof ViewPager;
        if (z) {
            final ArrayList arrayList = new ArrayList();
            ViewPager viewPager = z ? (ViewPager) findViewByRecursive : null;
            if (viewPager != null) {
                viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.bytedance.android.anniex.container.popup.AnnieXLynxViewNestedScrollUtil$handleNestedScrollWithVp$1
                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageScrollStateChanged(int p0) {
                    }

                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageScrolled(int p0, float p1, int p2) {
                    }

                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageSelected(int p0) {
                        if (arrayList.size() != ((ViewPager) findViewByRecursive).getChildCount()) {
                            arrayList.clear();
                            int childCount = ((ViewPager) findViewByRecursive).getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                List<RecyclerView> list = arrayList;
                                AnnieXLynxViewNestedScrollUtil annieXLynxViewNestedScrollUtil = AnnieXLynxViewNestedScrollUtil.INSTANCE;
                                View childAt = ((ViewPager) findViewByRecursive).getChildAt(i);
                                Intrinsics.checkNotNullExpressionValue(childAt, "vp.getChildAt(i)");
                                View findViewByRecursive2 = annieXLynxViewNestedScrollUtil.findViewByRecursive(childAt, new Function1<View, Boolean>() { // from class: com.bytedance.android.anniex.container.popup.AnnieXLynxViewNestedScrollUtil$handleNestedScrollWithVp$1$onPageSelected$1
                                    public final Boolean invoke(View view) {
                                        Intrinsics.checkNotNullParameter(view, "v");
                                        return Boolean.valueOf(view instanceof RecyclerView);
                                    }
                                });
                                list.add(findViewByRecursive2 instanceof RecyclerView ? (RecyclerView) findViewByRecursive2 : null);
                            }
                        }
                        int i2 = 0;
                        for (Object obj : arrayList) {
                            int i3 = i2 + 1;
                            if (i2 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            RecyclerView recyclerView = (RecyclerView) obj;
                            if (recyclerView != null) {
                                recyclerView.setNestedScrollingEnabled(i2 == p0);
                            }
                            i2 = i3;
                        }
                    }
                });
            }
        }
    }

    public final View findViewByRecursive(View v, Function1<? super View, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if (((Boolean) predicate.invoke(v)).booleanValue()) {
            return v;
        }
        if (!(v instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) v;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "v.getChildAt(i)");
            View findViewByRecursive = findViewByRecursive(childAt, predicate);
            if (findViewByRecursive != null) {
                return findViewByRecursive;
            }
        }
        return null;
    }
}
