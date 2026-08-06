package com.bytedance.android.anniex.container.p025ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.GravityCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.bytedance.android.anniex.C0840R;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.data.IMoreData;
import com.bytedance.android.anniex.base.data.ISearchData;
import com.bytedance.android.anniex.base.monitor.IMonitorCenter;
import com.bytedance.android.anniex.base.monitor.MonitorCenter;
import com.bytedance.android.anniex.base.service.AnnieXActionService;
import com.bytedance.android.anniex.base.service.AnnieXUIService;
import com.bytedance.ies.bullet.core.device.UIUtils;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.sdk.param.UIColorParam;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXTitleBar.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J)\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0001\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0014J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u00122\u0006\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020!H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/android/anniex/container/ui/AnnieXTitleBar;", "Lcom/bytedance/android/anniex/base/service/AnnieXUIService$TitleBar;", "()V", "closeBtn", "Landroid/view/View;", "rightLayout", "Landroid/view/ViewGroup;", "titleView", "Landroid/widget/TextView;", "constructUi", "context", "Landroid/content/Context;", "container", "Lcom/bytedance/android/anniex/base/container/IContainer;", "createBackButton", "createButtonByResId", "Landroidx/appcompat/widget/AppCompatImageView;", "tintColor", "", "resId", "(Landroid/content/Context;Ljava/lang/Integer;I)Landroidx/appcompat/widget/AppCompatImageView;", "createCloseButton", "createMoreButton", "createSearchButton", "createTitleView", "getTitleColor", "(Lcom/bytedance/android/anniex/base/container/IContainer;)Ljava/lang/Integer;", "setTitle", "", "title", "", "showCloseButton", "visible", "", "showOrHideRightButtonLayout", "show", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class AnnieXTitleBar extends AnnieXUIService.TitleBar {
    private static final String BUTTON_BACK = "back";
    private static final String BUTTON_CLOSE = "close";
    private static final String BUTTON_MORE = "more";
    private static final String BUTTON_SEARCH = "search_amplifier";
    private static final String ENTER_FROM = "annie_x_title_bar";
    private static final int TITLE_BAR_BUTTON_PADDING_DP = 8;
    private static final float TITLE_BAR_TEXT_SIZE = 17.0f;
    private View closeBtn;
    private ViewGroup rightLayout;
    private TextView titleView;

    @Override // com.bytedance.android.anniex.base.service.AnnieXUIService.TitleBar
    public View constructUi(Context context, IContainer container) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.addView(createBackButton(context, container));
        View createCloseButton = createCloseButton(context, container);
        if (createCloseButton != null) {
            createCloseButton.setVisibility(4);
            this.closeBtn = createCloseButton;
            linearLayout.addView(createCloseButton);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, GravityCompat.START);
        View createTitleView = createTitleView(context, container);
        this.titleView = createTitleView instanceof TextView ? (TextView) createTitleView : null;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 17);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.addView(createSearchButton(context, container));
        linearLayout2.addView(createMoreButton(context, container));
        this.rightLayout = linearLayout2;
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2, GravityCompat.END);
        MonitorCenter.INSTANCE.instance().onTitleBarConstruct(container.getContainerId(), CollectionsKt.listOf(new String[]{BUTTON_BACK, BUTTON_CLOSE, BUTTON_SEARCH, BUTTON_MORE}));
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.addView(linearLayout, layoutParams);
        TextView textView = this.titleView;
        if (textView != null) {
            frameLayout.addView(textView, layoutParams2);
        }
        frameLayout.addView(this.rightLayout, layoutParams3);
        return frameLayout;
    }

    private final Integer getTitleColor(IContainer container) {
        ISchemaData schemaData = container.getSchemaData();
        if (schemaData != null) {
            return (Integer) new UIColorParam(schemaData, "title_color", (Integer) null).getValue();
        }
        return null;
    }

    private final AppCompatImageView createButtonByResId(Context context, Integer tintColor, int resId) {
        int dpToPx$anniex_release = UIUtils.dpToPx$anniex_release(8, context);
        AppCompatImageView appCompatImageView = new AppCompatImageView(context);
        appCompatImageView.setPadding(dpToPx$anniex_release, dpToPx$anniex_release, dpToPx$anniex_release, dpToPx$anniex_release);
        VectorDrawableCompat create = VectorDrawableCompat.create(context.getResources(), resId, context.getTheme());
        if (tintColor != null) {
            int intValue = tintColor.intValue();
            if (create != null) {
                create.setTint(intValue);
            }
        }
        appCompatImageView.setImageDrawable(create);
        return appCompatImageView;
    }

    @Override // com.bytedance.android.anniex.base.service.AnnieXUIService.TitleBar
    public View createBackButton(Context context, final IContainer container) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        final String containerId = container.getContainerId();
        View createButtonByResId = createButtonByResId(context, getTitleColor(container), C0840R.drawable.title_bar_back_btn);
        createButtonByResId.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.android.anniex.container.ui.AnnieXTitleBar$createBackButton$1$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IContainer.this.goBack();
                IMonitorCenter.DefaultImpls.onEvent$default(MonitorCenter.INSTANCE.instance(), containerId, MapsKt.mapOf(new Pair[]{TuplesKt.to("event_source", "event_source_title_bar"), TuplesKt.to("event_type", "event_type_click"), TuplesKt.to("button_name", "back")}), null, 4, null);
            }
        });
        return createButtonByResId;
    }

    @Override // com.bytedance.android.anniex.base.service.AnnieXUIService.TitleBar
    public View createCloseButton(Context context, final IContainer container) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        final String containerId = container.getContainerId();
        View createButtonByResId = createButtonByResId(context, getTitleColor(container), C0840R.drawable.title_bar_close_btn);
        createButtonByResId.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.android.anniex.container.ui.AnnieXTitleBar$createCloseButton$1$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IContainer.this.close();
                IMonitorCenter.DefaultImpls.onEvent$default(MonitorCenter.INSTANCE.instance(), containerId, MapsKt.mapOf(new Pair[]{TuplesKt.to("event_source", "event_source_title_bar"), TuplesKt.to("event_type", "event_type_click"), TuplesKt.to("button_name", "close")}), null, 4, null);
            }
        });
        return createButtonByResId;
    }

    @Override // com.bytedance.android.anniex.base.service.AnnieXUIService.TitleBar
    public void showCloseButton(boolean visible) {
        View view = this.closeBtn;
        if (view == null) {
            return;
        }
        view.setVisibility(visible ? 0 : 4);
    }

    @Override // com.bytedance.android.anniex.base.service.AnnieXUIService.TitleBar
    public View createTitleView(Context context, IContainer container) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        TextView textView = new TextView(context);
        textView.setTextSize(2, TITLE_BAR_TEXT_SIZE);
        textView.setMaxEms(9);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        Integer titleColor = getTitleColor(container);
        if (titleColor != null) {
            textView.setTextColor(titleColor.intValue());
        }
        return textView;
    }

    @Override // com.bytedance.android.anniex.base.service.AnnieXUIService.TitleBar
    public void setTitle(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        TextView textView = this.titleView;
        if (textView == null) {
            return;
        }
        SpannableString spannableString = new SpannableString(title);
        spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
        textView.setText(spannableString);
    }

    @Override // com.bytedance.android.anniex.base.service.AnnieXUIService.TitleBar
    public View createSearchButton(Context context, final IContainer container) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        final String containerId = container.getContainerId();
        View createButtonByResId = createButtonByResId(context, getTitleColor(container), C0840R.drawable.title_bar_search_btn);
        createButtonByResId.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.android.anniex.container.ui.AnnieXTitleBar$createSearchButton$1$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnnieXActionService annieXActionService = ServiceCenter.Companion.instance().get(IContainer.this.getBid(), AnnieXActionService.class);
                if (annieXActionService != null) {
                    Context context2 = view.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "it.context");
                    annieXActionService.search(context2, new ISearchData.SearchDataBuilder().setEnterFrom("annie_x_title_bar").setEnterMethod("search_amplifier").build());
                }
                IMonitorCenter.DefaultImpls.onEvent$default(MonitorCenter.INSTANCE.instance(), containerId, MapsKt.mapOf(new Pair[]{TuplesKt.to("event_source", "event_source_title_bar"), TuplesKt.to("event_type", "event_type_click"), TuplesKt.to("button_name", "search_amplifier")}), null, 4, null);
            }
        });
        return createButtonByResId;
    }

    @Override // com.bytedance.android.anniex.base.service.AnnieXUIService.TitleBar
    public View createMoreButton(Context context, final IContainer container) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        final String containerId = container.getContainerId();
        View createButtonByResId = createButtonByResId(context, getTitleColor(container), C0840R.drawable.title_bar_more_btn);
        createButtonByResId.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.android.anniex.container.ui.AnnieXTitleBar$createMoreButton$1$1
            /* JADX WARN: Code restructure failed: missing block: B:6:0x002d, code lost:
            
                if (r0 != null) goto L10;
             */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void onClick(View view) {
                List<AnnieXUIService.MorePanelButton> emptyList;
                AnnieXUIService.MorePanel createMorePanel;
                AnnieXUIService annieXUIService = ServiceCenter.Companion.instance().get(IContainer.this.getBid(), AnnieXUIService.class);
                if (annieXUIService != null && (createMorePanel = annieXUIService.createMorePanel(IContainer.this)) != null) {
                    Context context2 = view.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "it.context");
                    emptyList = createMorePanel.constructButtons(context2, IContainer.this);
                }
                emptyList = CollectionsKt.emptyList();
                AnnieXActionService annieXActionService = ServiceCenter.Companion.instance().get(IContainer.this.getBid(), AnnieXActionService.class);
                if (annieXActionService != null) {
                    Context context3 = view.getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "it.context");
                    annieXActionService.more(context3, new IMoreData.MoreDataBuilder().setUrl(IContainer.this.getCurrentUrl()).setEnterFrom("annie_x_title_bar").setSessionId(containerId).setMorePanelButtons(emptyList).build());
                }
                IMonitorCenter.DefaultImpls.onEvent$default(MonitorCenter.INSTANCE.instance(), containerId, MapsKt.mapOf(new Pair[]{TuplesKt.to("event_source", "event_source_title_bar"), TuplesKt.to("event_type", "event_type_click"), TuplesKt.to("button_name", "more")}), null, 4, null);
            }
        });
        return createButtonByResId;
    }

    @Override // com.bytedance.android.anniex.base.service.AnnieXUIService.TitleBar
    public void showOrHideRightButtonLayout(boolean show) {
        if (show) {
            ViewGroup viewGroup = this.rightLayout;
            if (viewGroup == null) {
                return;
            }
            viewGroup.setVisibility(0);
            return;
        }
        ViewGroup viewGroup2 = this.rightLayout;
        if (viewGroup2 == null) {
            return;
        }
        viewGroup2.setVisibility(4);
    }
}
