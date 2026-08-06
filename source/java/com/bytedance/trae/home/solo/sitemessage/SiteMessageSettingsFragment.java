package com.bytedance.trae.home.solo.sitemessage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.home.C0820R;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: SiteMessageSettingsFragment.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\u0018\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#H\u0002J(\u0010$\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0014H\u0002J\u0010\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020#H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "titleBar", "Lcom/bytedance/trae/common/widget/TraeTitleBar;", "scrollView", "Landroid/widget/ScrollView;", "stackView", "Landroid/widget/LinearLayout;", "loadingView", "Landroid/widget/ProgressBar;", "preferences", "", "", "", "items", "", "Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "fetchLatest", "renderItems", "makeCard", "item", "index", "", "onSwitchToggled", "newValue", "toggle", "Landroidx/appcompat/widget/SwitchCompat;", "card", "dpToPx", "dp", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SiteMessageSettingsFragment extends Fragment {
    private List<SiteMessagePreferencesTypeItem> items;
    private ProgressBar loadingView;
    private Map<String, Boolean> preferences = SiteMessagePreferencesCache.INSTANCE.getCurrentPreferences();
    private ScrollView scrollView;
    private LinearLayout stackView;
    private TraeTitleBar titleBar;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public SiteMessageSettingsFragment() {
        List<SiteMessagePreferencesTypeItem> currentItems = SiteMessagePreferencesCache.INSTANCE.getCurrentItems();
        this.items = currentItems == null ? CollectionsKt.emptyList() : currentItems;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0820R.layout.fragment_site_message_settings, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.titleBar = (TraeTitleBar) view.findViewById(C0820R.id.title_bar);
        this.scrollView = (ScrollView) view.findViewById(C0820R.id.scroll_view);
        this.stackView = (LinearLayout) view.findViewById(C0820R.id.stack_view);
        this.loadingView = (ProgressBar) view.findViewById(C0820R.id.loading);
        TraeTitleBar traeTitleBar = this.titleBar;
        if (traeTitleBar != null) {
            traeTitleBar.setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageSettingsFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SiteMessageSettingsFragment.onViewCreated$lambda$0(SiteMessageSettingsFragment.this, view2);
                }
            });
        }
        SiteMessageTracker.INSTANCE.trackSettingsPageView();
        if (this.items.isEmpty()) {
            ProgressBar progressBar = this.loadingView;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
            ScrollView scrollView = this.scrollView;
            if (scrollView != null) {
                scrollView.setVisibility(8);
            }
        } else {
            renderItems();
        }
        fetchLatest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(SiteMessageSettingsFragment siteMessageSettingsFragment, View view) {
        siteMessageSettingsFragment.getParentFragmentManager().popBackStack();
    }

    private final void fetchLatest() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new SiteMessageSettingsFragment$fetchLatest$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderItems() {
        LinearLayout linearLayout = this.stackView;
        if (linearLayout == null) {
            return;
        }
        linearLayout.removeAllViews();
        Iterator<T> it = this.items.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            linearLayout.addView(makeCard((SiteMessagePreferencesTypeItem) it.next(), i));
            if (i < this.items.size() - 1) {
                View view = new View(requireContext());
                view.setLayoutParams(new LinearLayout.LayoutParams(-1, dpToPx(12)));
                linearLayout.addView(view);
            }
            i = i2;
        }
    }

    private final View makeCard(final SiteMessagePreferencesTypeItem item, int index) {
        String key;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        final LinearLayout linearLayout = new LinearLayout(requireContext);
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundResource(C0820R.drawable.bg_site_message_settings_card);
        linearLayout.setPadding(dpToPx(16), dpToPx(16), dpToPx(4), dpToPx(16));
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setGravity(16);
        LinearLayout linearLayout2 = new LinearLayout(requireContext);
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.setMarginEnd(dpToPx(16));
        linearLayout2.setLayoutParams(layoutParams);
        TextView textView = new TextView(requireContext);
        LocalizedText title = item.getTitle();
        if (title == null || (key = title.getLocalized()) == null) {
            key = item.getKey();
        }
        textView.setText(key);
        textView.setTextColor(ContextCompat.getColor(requireContext, C0591R.color.trae_text_text_default));
        textView.setTextSize(17.0f);
        textView.setLineSpacing(0.0f, 1.0f);
        textView.setIncludeFontPadding(false);
        linearLayout2.addView(textView);
        LocalizedText description = item.getDescription();
        String localized = description != null ? description.getLocalized() : null;
        if (!(localized == null || localized.length() == 0)) {
            View view = new View(requireContext);
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, dpToPx(4)));
            linearLayout2.addView(view);
            TextView textView2 = new TextView(requireContext);
            LocalizedText description2 = item.getDescription();
            String localized2 = description2 != null ? description2.getLocalized() : null;
            if (localized2 == null) {
                localized2 = "";
            }
            textView2.setText(localized2);
            textView2.setTextColor(ContextCompat.getColor(requireContext, C0591R.color.trae_text_text_disabled));
            textView2.setTextSize(13.0f);
            textView2.setLineSpacing(0.0f, 1.0f);
            textView2.setIncludeFontPadding(false);
            linearLayout2.addView(textView2);
        }
        final SwitchCompat switchCompat = new SwitchCompat(requireContext);
        Boolean bool = this.preferences.get(item.getKey());
        switchCompat.setChecked(bool != null ? bool.booleanValue() : true);
        switchCompat.setTrackDrawable(ContextCompat.getDrawable(requireContext, C0820R.drawable.bg_toggle_track));
        switchCompat.setThumbDrawable(ContextCompat.getDrawable(requireContext, C0820R.drawable.bg_toggle_thumb));
        switchCompat.setSwitchMinWidth(dpToPx(52));
        switchCompat.setShowText(false);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(dpToPx(8), dpToPx(8), dpToPx(12), dpToPx(8));
        switchCompat.setLayoutParams(layoutParams2);
        switchCompat.setTag(Integer.valueOf(index));
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageSettingsFragment$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SiteMessageSettingsFragment.makeCard$lambda$8(SiteMessageSettingsFragment.this, item, switchCompat, linearLayout, compoundButton, z);
            }
        });
        linearLayout.addView(linearLayout2);
        linearLayout.addView((View) switchCompat);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageSettingsFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SiteMessageSettingsFragment.makeCard$lambda$9(switchCompat, view2);
            }
        });
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void makeCard$lambda$8(SiteMessageSettingsFragment siteMessageSettingsFragment, SiteMessagePreferencesTypeItem siteMessagePreferencesTypeItem, SwitchCompat switchCompat, LinearLayout linearLayout, CompoundButton compoundButton, boolean z) {
        siteMessageSettingsFragment.onSwitchToggled(siteMessagePreferencesTypeItem, z, switchCompat, linearLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void makeCard$lambda$9(SwitchCompat switchCompat, View view) {
        if (switchCompat.isEnabled()) {
            switchCompat.setChecked(!switchCompat.isChecked());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSwitchToggled(SiteMessagePreferencesTypeItem item, boolean newValue, SwitchCompat toggle, View card) {
        Map map = MapsKt.toMap(this.preferences);
        Map<String, Boolean> mutableMap = MapsKt.toMutableMap(this.preferences);
        mutableMap.put(item.getKey(), Boolean.valueOf(newValue));
        this.preferences = mutableMap;
        SiteMessagePreferencesCache.INSTANCE.save(mutableMap);
        toggle.setEnabled(false);
        card.setClickable(false);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new SiteMessageSettingsFragment$onSwitchToggled$1(item, newValue, this, map, toggle, card, null), 3, (Object) null);
    }

    private final int dpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }

    /* compiled from: SiteMessageSettingsFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SiteMessageSettingsFragment newInstance() {
            return new SiteMessageSettingsFragment();
        }
    }
}
