package com.bytedance.trae.home.onboarding;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.keva.Keva;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.home.C0820R;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: OnboardingFragment.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0013H\u0002J\b\u0010(\u001a\u00020\u0006H\u0002R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/bytedance/trae/home/onboarding/OnboardingFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "onFinished", "Lkotlin/Function0;", "", "getOnFinished", "()Lkotlin/jvm/functions/Function0;", "setOnFinished", "(Lkotlin/jvm/functions/Function0;)V", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "btnAction", "Landroid/widget/TextView;", "indicators", "", "Landroid/view/View;", "barColor", "", "currentPage", "exposedPositions", "", "pages", "", "Lcom/bytedance/trae/home/onboarding/OnboardingPageData;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "updateButtonStyle", "isLastPage", "", "updateIndicator", "selectedPosition", "updateBarColor", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class OnboardingFragment extends Fragment {
    private static final String KEVA_REPO = "trae_onboarding";
    private static final String KEY_SHOWN = "onboarding_shown";
    private TextView btnAction;
    private int currentPage;
    private Function0<Unit> onFinished;
    private ViewPager2 viewPager;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private final List<View> indicators = new ArrayList();
    private int barColor = -1;
    private final Set<Integer> exposedPositions = new LinkedHashSet();
    private final List<OnboardingPageData> pages = CollectionsKt.listOf(new OnboardingPageData[]{new OnboardingPageData(C0820R.string.onboarding_title_normal_1, C0820R.string.onboarding_title_italic_1, C0820R.drawable.onboarding_page_1, C0820R.string.onboarding_btn_continue, false), new OnboardingPageData(C0820R.string.onboarding_title_normal_2, C0820R.string.onboarding_title_italic_2, C0820R.drawable.onboarding_page_2, C0820R.string.onboarding_btn_continue, false), new OnboardingPageData(C0820R.string.onboarding_title_normal_3, C0820R.string.onboarding_title_italic_3, C0820R.drawable.onboarding_page_3, C0820R.string.onboarding_btn_lets_go, true)});

    /* compiled from: OnboardingFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/home/onboarding/OnboardingFragment$Companion;", "", "<init>", "()V", "KEVA_REPO", "", "KEY_SHOWN", "hasShown", "", "markShown", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean hasShown() {
            return Keva.getRepo(OnboardingFragment.KEVA_REPO).getBoolean(OnboardingFragment.KEY_SHOWN, false);
        }

        public final void markShown() {
            Keva.getRepo(OnboardingFragment.KEVA_REPO).storeBoolean(OnboardingFragment.KEY_SHOWN, true);
        }
    }

    public final Function0<Unit> getOnFinished() {
        return this.onFinished;
    }

    public final void setOnFinished(Function0<Unit> function0) {
        this.onFinished = function0;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        float f = getResources().getDisplayMetrics().density;
        updateBarColor();
        FrameLayout frameLayout = new FrameLayout(requireContext);
        frameLayout.setBackgroundColor(ContextCompat.getColor(requireContext, C0820R.color.onboarding_bg));
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ViewPager2 viewPager2 = new ViewPager2(requireContext);
        viewPager2.setId(View.generateViewId());
        viewPager2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.viewPager = viewPager2;
        viewPager2.setAdapter(new OnboardingPagerAdapter(this.pages, f));
        ViewPager2 viewPager22 = this.viewPager;
        TextView textView = null;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager22 = null;
        }
        frameLayout.addView((View) viewPager22);
        LinearLayout linearLayout = new LinearLayout(requireContext);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        layoutParams.bottomMargin = (int) (58 * f);
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(requireContext);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = (int) (24 * f);
        linearLayout2.setLayoutParams(layoutParams2);
        int size = this.pages.size();
        for (int i = 0; i < size; i++) {
            View view = new View(requireContext);
            view.setBackground(ContextCompat.getDrawable(requireContext, C0820R.drawable.onboarding_indicator_inactive));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((int) (8 * f), (int) (2 * f));
            if (i > 0) {
                layoutParams3.setMarginStart((int) (4 * f));
            }
            view.setLayoutParams(layoutParams3);
            this.indicators.add(view);
            linearLayout2.addView(view);
        }
        linearLayout.addView(linearLayout2);
        TextView textView2 = new TextView(requireContext);
        textView2.setText(getString(this.pages.get(0).getButtonTextResId()));
        textView2.setTextSize(2, 17.0f);
        textView2.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView2.setGravity(17);
        textView2.setLetterSpacing(-0.025294118f);
        textView2.setLayoutParams(new LinearLayout.LayoutParams((int) (345 * f), (int) (48 * f)));
        this.btnAction = textView2;
        updateButtonStyle(false);
        TextView textView3 = this.btnAction;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnAction");
        } else {
            textView = textView3;
        }
        linearLayout.addView(textView);
        frameLayout.addView(linearLayout);
        return frameLayout;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        updateIndicator(0);
        if (this.exposedPositions.add(0)) {
            IApplog.Companion companion = IApplog.INSTANCE;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NewTaskTracker.Param.POSITION, 0);
            Unit unit = Unit.INSTANCE;
            companion.reportEvent("onboarding_page_view", jSONObject);
        }
        ViewPager2 viewPager2 = this.viewPager;
        TextView textView = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.bytedance.trae.home.onboarding.OnboardingFragment$onViewCreated$2
            public void onPageSelected(int position) {
                int i;
                Set set;
                List list;
                TextView textView2;
                i = OnboardingFragment.this.currentPage;
                String str = position > i ? "left" : "right";
                IApplog.Companion companion2 = IApplog.INSTANCE;
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("direction", str);
                Unit unit2 = Unit.INSTANCE;
                companion2.reportEvent("icube_onboarding_slide", jSONObject2);
                set = OnboardingFragment.this.exposedPositions;
                if (set.add(Integer.valueOf(position))) {
                    IApplog.Companion companion3 = IApplog.INSTANCE;
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(NewTaskTracker.Param.POSITION, position);
                    Unit unit3 = Unit.INSTANCE;
                    companion3.reportEvent("onboarding_page_view", jSONObject3);
                }
                OnboardingFragment.this.currentPage = position;
                OnboardingFragment.this.updateIndicator(position);
                list = OnboardingFragment.this.pages;
                OnboardingPageData onboardingPageData = (OnboardingPageData) list.get(position);
                textView2 = OnboardingFragment.this.btnAction;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("btnAction");
                    textView2 = null;
                }
                textView2.setText(OnboardingFragment.this.getString(onboardingPageData.getButtonTextResId()));
                OnboardingFragment.this.updateButtonStyle(onboardingPageData.isLastPage());
            }
        });
        TextView textView2 = this.btnAction;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnAction");
        } else {
            textView = textView2;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.onboarding.OnboardingFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OnboardingFragment.onViewCreated$lambda$10(OnboardingFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$10(OnboardingFragment onboardingFragment, View view) {
        ViewPager2 viewPager2 = onboardingFragment.viewPager;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        int currentItem = viewPager2.getCurrentItem();
        if (currentItem < onboardingFragment.pages.size() - 1) {
            ViewPager2 viewPager23 = onboardingFragment.viewPager;
            if (viewPager23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            } else {
                viewPager22 = viewPager23;
            }
            viewPager22.setCurrentItem(currentItem + 1, true);
            return;
        }
        INSTANCE.markShown();
        Function0<Unit> function0 = onboardingFragment.onFinished;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateButtonStyle(boolean isLastPage) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        TextView textView = null;
        if (isLastPage) {
            TextView textView2 = this.btnAction;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnAction");
                textView2 = null;
            }
            textView2.setTextColor(ContextCompat.getColor(context, C0820R.color.onboarding_btn_text_dark));
            TextView textView3 = this.btnAction;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnAction");
            } else {
                textView = textView3;
            }
            textView.setBackground(ContextCompat.getDrawable(context, C0820R.drawable.onboarding_btn_dark));
            return;
        }
        TextView textView4 = this.btnAction;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnAction");
            textView4 = null;
        }
        textView4.setTextColor(ContextCompat.getColor(context, C0820R.color.onboarding_btn_text_light));
        TextView textView5 = this.btnAction;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnAction");
        } else {
            textView = textView5;
        }
        textView.setBackground(ContextCompat.getDrawable(context, C0820R.drawable.onboarding_btn_light));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateIndicator(int selectedPosition) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        float f = getResources().getDisplayMetrics().density;
        int size = this.indicators.size();
        for (int i = 0; i < size; i++) {
            View view = this.indicators.get(i);
            if (i == selectedPosition) {
                view.setBackground(ContextCompat.getDrawable(context, C0820R.drawable.onboarding_indicator_active));
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.width = (int) (32 * f);
                layoutParams2.height = (int) (2 * f);
                view.setLayoutParams(layoutParams2);
            } else {
                view.setBackground(ContextCompat.getDrawable(context, C0820R.drawable.onboarding_indicator_inactive));
                ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
                layoutParams4.width = (int) (8 * f);
                layoutParams4.height = (int) (2 * f);
                view.setLayoutParams(layoutParams4);
            }
        }
    }

    private final void updateBarColor() {
        if (getActivity() != null) {
            try {
                FragmentActivity activity = getActivity();
                Window window = activity != null ? activity.getWindow() : null;
                if (this.barColor != -1) {
                    if (window != null) {
                        window.clearFlags(Integer.MIN_VALUE);
                    }
                    if (window != null) {
                        Context activity2 = getActivity();
                        Intrinsics.checkNotNull(activity2);
                        window.setStatusBarColor(ContextCompat.getColor(activity2, this.barColor));
                    }
                    if (window != null) {
                        Context activity3 = getActivity();
                        Intrinsics.checkNotNull(activity3);
                        window.setNavigationBarColor(ContextCompat.getColor(activity3, this.barColor));
                        return;
                    }
                    return;
                }
                if (window != null) {
                    window.addFlags(Integer.MIN_VALUE);
                }
                Context activity4 = getActivity();
                Intrinsics.checkNotNull(activity4);
                this.barColor = ContextCompat.getColor(activity4, C0820R.color.onboarding_bg);
                if (window != null) {
                    Context activity5 = getActivity();
                    Intrinsics.checkNotNull(activity5);
                    window.setStatusBarColor(ContextCompat.getColor(activity5, C0820R.color.onboarding_bg));
                }
                if (window != null) {
                    Context activity6 = getActivity();
                    Intrinsics.checkNotNull(activity6);
                    window.setNavigationBarColor(ContextCompat.getColor(activity6, C0820R.color.onboarding_bg));
                }
            } catch (Exception unused) {
            }
        }
    }
}
