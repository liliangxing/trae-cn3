package com.bytedance.trae.conversation.brainstorm.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.brainstorm.model.TimeoutState;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

/* compiled from: BrainstormTopBar.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001JB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010-\u001a\u00020\"H\u0002J\b\u0010.\u001a\u00020\u0017H\u0002J\b\u0010/\u001a\u00020\"H\u0014J\b\u00100\u001a\u00020\"H\u0002J0\u00101\u001a\u00020\"2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0014J\b\u00108\u001a\u00020\"H\u0002J\u0018\u00109\u001a\u00020\"2\u0006\u0010:\u001a\u00020\u00172\u0006\u0010;\u001a\u00020<H\u0002J\u000e\u0010=\u001a\u00020\"2\u0006\u0010>\u001a\u000203J\u000e\u0010?\u001a\u00020\"2\u0006\u0010@\u001a\u000203J\u000e\u0010A\u001a\u00020\"2\u0006\u0010B\u001a\u00020CJ\u000e\u0010D\u001a\u00020\"2\u0006\u0010E\u001a\u00020FJ\u0016\u0010G\u001a\u00020\"2\u0006\u0010H\u001a\u00020\u001f2\u0006\u0010I\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\"\u0010*\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&¨\u0006K"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "btnLeft", "Landroid/widget/ImageView;", "timerContainer", "Landroid/widget/LinearLayout;", "tvTimer", "Landroid/widget/TextView;", "tvTimeoutChip", "actionPill", "btnSubtitleToggle", "btnMinimize", "spacePillGap", "Landroid/widget/Space;", "btnLeftShadow", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;", "actionPillShadow", "defaultActionPillWidth", "shadowRadius", "shadowDy", "shadowPaddingTop", "shadowPaddingBottom", "currentTimeoutState", "Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;", "onBackClick", "Lkotlin/Function0;", "", "getOnBackClick", "()Lkotlin/jvm/functions/Function0;", "setOnBackClick", "(Lkotlin/jvm/functions/Function0;)V", "onSubtitleToggleClick", "getOnSubtitleToggleClick", "setOnSubtitleToggleClick", "onMinimizeClick", "getOnMinimizeClick", "setOnMinimizeClick", "applyTopButtonShadows", "createTopButtonShadowView", "onAttachedToWindow", "allowShadowOverflow", "onLayout", "changed", "", "left", "top", "right", "bottom", "updateTopButtonShadows", "updateTopButtonShadow", "shadowView", "target", "Landroid/view/View;", "setSubtitleToggleActive", "active", "setMinimizeVisible", "visible", "setMode", "mode", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$TopBarMode;", "updateTimer", "durationMs", "", "updateTimeoutState", "state", "remainingSeconds", "TopBarMode", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormTopBar extends ConstraintLayout {
    private final LinearLayout actionPill;
    private final BrainstormActionShadowView actionPillShadow;
    private final ImageView btnLeft;
    private final BrainstormActionShadowView btnLeftShadow;
    private final ImageView btnMinimize;
    private final ImageView btnSubtitleToggle;
    private TimeoutState currentTimeoutState;
    private final int defaultActionPillWidth;
    private Function0<Unit> onBackClick;
    private Function0<Unit> onMinimizeClick;
    private Function0<Unit> onSubtitleToggleClick;
    private final int shadowDy;
    private final int shadowPaddingBottom;
    private final int shadowPaddingTop;
    private final int shadowRadius;
    private final Space spacePillGap;
    private final LinearLayout timerContainer;
    private final TextView tvTimeoutChip;
    private final TextView tvTimer;

    /* compiled from: BrainstormTopBar.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TopBarMode.values().length];
            try {
                iArr[TopBarMode.INTRO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TopBarMode.DISCUSSING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[TimeoutState.values().length];
            try {
                iArr2[TimeoutState.Normal.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[TimeoutState.Warning.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[TimeoutState.Expired.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BrainstormTopBar(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BrainstormTopBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ BrainstormTopBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BrainstormTopBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        int dimensionPixelSize = getResources().getDimensionPixelSize(C0591R.dimen.trae_title_bar_shadow_blur_radius);
        this.shadowRadius = dimensionPixelSize;
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(C0591R.dimen.trae_title_bar_shadow_offset_y);
        this.shadowDy = dimensionPixelSize2;
        this.shadowPaddingTop = RangesKt.coerceAtLeast(dimensionPixelSize - dimensionPixelSize2, 0);
        this.shadowPaddingBottom = dimensionPixelSize + dimensionPixelSize2;
        this.currentTimeoutState = TimeoutState.Normal;
        LayoutInflater.from(context).inflate(C0637R.layout.trae_layout_brainstorm_top_bar, (ViewGroup) this, true);
        View findViewById = findViewById(C0637R.id.btn_left);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        ImageView imageView = (ImageView) findViewById;
        this.btnLeft = imageView;
        View findViewById2 = findViewById(C0637R.id.timer_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.timerContainer = (LinearLayout) findViewById2;
        View findViewById3 = findViewById(C0637R.id.tv_timer);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.tvTimer = (TextView) findViewById3;
        View findViewById4 = findViewById(C0637R.id.tv_timeout_chip);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.tvTimeoutChip = (TextView) findViewById4;
        View findViewById5 = findViewById(C0637R.id.action_pill);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        LinearLayout linearLayout = (LinearLayout) findViewById5;
        this.actionPill = linearLayout;
        View findViewById6 = findViewById(C0637R.id.btn_subtitle_toggle);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        ImageView imageView2 = (ImageView) findViewById6;
        this.btnSubtitleToggle = imageView2;
        View findViewById7 = findViewById(C0637R.id.btn_minimize);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        ImageView imageView3 = (ImageView) findViewById7;
        this.btnMinimize = imageView3;
        View findViewById8 = findViewById(C0637R.id.space_pill_gap);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
        this.spacePillGap = (Space) findViewById8;
        this.defaultActionPillWidth = linearLayout.getLayoutParams().width;
        BrainstormActionShadowView createTopButtonShadowView = createTopButtonShadowView();
        this.btnLeftShadow = createTopButtonShadowView;
        BrainstormActionShadowView createTopButtonShadowView2 = createTopButtonShadowView();
        this.actionPillShadow = createTopButtonShadowView2;
        addView(createTopButtonShadowView, 0, new ConstraintLayout.LayoutParams(0, 0));
        addView(createTopButtonShadowView2, 1, new ConstraintLayout.LayoutParams(0, 0));
        applyTopButtonShadows();
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.brainstorm.widget.BrainstormTopBar$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BrainstormTopBar._init_$lambda$0(BrainstormTopBar.this, view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.brainstorm.widget.BrainstormTopBar$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BrainstormTopBar._init_$lambda$1(BrainstormTopBar.this, view);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.brainstorm.widget.BrainstormTopBar$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BrainstormTopBar._init_$lambda$2(BrainstormTopBar.this, view);
            }
        });
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: BrainstormTopBar.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$TopBarMode;", "", "<init>", "(Ljava/lang/String;I)V", "INTRO", "DISCUSSING", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class TopBarMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TopBarMode[] $VALUES;
        public static final TopBarMode INTRO = new TopBarMode("INTRO", 0);
        public static final TopBarMode DISCUSSING = new TopBarMode("DISCUSSING", 1);

        private static final /* synthetic */ TopBarMode[] $values() {
            return new TopBarMode[]{INTRO, DISCUSSING};
        }

        public static EnumEntries<TopBarMode> getEntries() {
            return $ENTRIES;
        }

        private TopBarMode(String str, int i) {
        }

        static {
            TopBarMode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static TopBarMode valueOf(String str) {
            return (TopBarMode) Enum.valueOf(TopBarMode.class, str);
        }

        public static TopBarMode[] values() {
            return (TopBarMode[]) $VALUES.clone();
        }
    }

    public final Function0<Unit> getOnBackClick() {
        return this.onBackClick;
    }

    public final void setOnBackClick(Function0<Unit> function0) {
        this.onBackClick = function0;
    }

    public final Function0<Unit> getOnSubtitleToggleClick() {
        return this.onSubtitleToggleClick;
    }

    public final void setOnSubtitleToggleClick(Function0<Unit> function0) {
        this.onSubtitleToggleClick = function0;
    }

    public final Function0<Unit> getOnMinimizeClick() {
        return this.onMinimizeClick;
    }

    public final void setOnMinimizeClick(Function0<Unit> function0) {
        this.onMinimizeClick = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(BrainstormTopBar brainstormTopBar, View view) {
        Function0<Unit> function0 = brainstormTopBar.onBackClick;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(BrainstormTopBar brainstormTopBar, View view) {
        Function0<Unit> function0 = brainstormTopBar.onSubtitleToggleClick;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(BrainstormTopBar brainstormTopBar, View view) {
        Function0<Unit> function0 = brainstormTopBar.onMinimizeClick;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void applyTopButtonShadows() {
        setClipChildren(false);
        setClipToPadding(false);
        for (View view : CollectionsKt.listOf(new View[]{this.btnLeft, this.actionPill})) {
            view.setElevation(0.0f);
            view.setTranslationZ(0.0f);
            view.setStateListAnimator(null);
        }
    }

    private final BrainstormActionShadowView createTopButtonShadowView() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        BrainstormActionShadowView brainstormActionShadowView = new BrainstormActionShadowView(context, null, 0, 6, null);
        brainstormActionShadowView.configure(ContextCompat.getColor(brainstormActionShadowView.getContext(), C0591R.color.trae_title_bar_shadow), ContextCompat.getColor(brainstormActionShadowView.getContext(), C0591R.color.trae_bg_bg_base_default), this.shadowRadius, this.shadowDy, this.shadowPaddingTop);
        return brainstormActionShadowView;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        allowShadowOverflow();
    }

    private final void allowShadowOverflow() {
        ViewParent parent = getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
        }
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        updateTopButtonShadows();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTopButtonShadows() {
        updateTopButtonShadow(this.btnLeftShadow, this.btnLeft);
        updateTopButtonShadow(this.actionPillShadow, this.actionPill);
    }

    private final void updateTopButtonShadow(BrainstormActionShadowView shadowView, View target) {
        shadowView.setVisibility(target.getVisibility());
        if (!(target.getVisibility() == 0) || target.getWidth() <= 0 || target.getHeight() <= 0) {
            return;
        }
        shadowView.setContentSize(target.getWidth(), target.getHeight());
        int width = target.getWidth() + (this.shadowRadius * 2);
        int height = target.getHeight() + this.shadowPaddingTop + this.shadowPaddingBottom;
        int left = target.getLeft() - this.shadowRadius;
        int top = target.getTop() - this.shadowPaddingTop;
        shadowView.layout(left, top, width + left, height + top);
        shadowView.invalidate();
    }

    public final void setSubtitleToggleActive(boolean active) {
        int i;
        ImageView imageView = this.btnSubtitleToggle;
        if (active) {
            i = C0637R.drawable.trae_ic_brainstorm_subtitle_on;
        } else {
            i = C0637R.drawable.trae_ic_brainstorm_subtitle_off;
        }
        imageView.setImageResource(i);
    }

    public final void setMinimizeVisible(boolean visible) {
        int dimensionPixelSize;
        this.btnMinimize.setVisibility(visible ? 0 : 8);
        this.spacePillGap.setVisibility(visible ? 0 : 8);
        ViewGroup.LayoutParams layoutParams = this.actionPill.getLayoutParams();
        if (visible) {
            dimensionPixelSize = this.defaultActionPillWidth;
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(C0637R.dimen.trae_brainstorm_header_action_button_size);
        }
        if (layoutParams.width != dimensionPixelSize) {
            layoutParams.width = dimensionPixelSize;
            this.actionPill.setLayoutParams(layoutParams);
        }
        this.actionPill.setPadding(0, 0, 0, 0);
        post(new Runnable() { // from class: com.bytedance.trae.conversation.brainstorm.widget.BrainstormTopBar$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                BrainstormTopBar.this.updateTopButtonShadows();
            }
        });
    }

    public final void setMode(TopBarMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
        if (i == 1) {
            this.btnLeft.setImageResource(C0637R.drawable.trae_ic_brainstorm_close);
            this.timerContainer.setVisibility(4);
            this.actionPill.setVisibility(8);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            this.btnLeft.setImageResource(C0637R.drawable.trae_ic_brainstorm_close);
            this.timerContainer.setVisibility(0);
            this.actionPill.setVisibility(0);
        }
        post(new Runnable() { // from class: com.bytedance.trae.conversation.brainstorm.widget.BrainstormTopBar$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                BrainstormTopBar.this.updateTopButtonShadows();
            }
        });
    }

    public final void updateTimer(long durationMs) {
        int i = (int) (durationMs / 1000);
        TextView textView = this.tvTimer;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i % 60)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(format);
    }

    public final void updateTimeoutState(TimeoutState state, int remainingSeconds) {
        String string;
        Intrinsics.checkNotNullParameter(state, "state");
        if (this.currentTimeoutState != state) {
            this.currentTimeoutState = state;
            int i = WhenMappings.$EnumSwitchMapping$1[state.ordinal()];
            if (i == 1) {
                this.tvTimer.setTextColor(ContextCompat.getColor(getContext(), C0591R.color.trae_text_text_default));
                this.tvTimeoutChip.setVisibility(8);
            } else {
                if (i != 2 && i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                this.tvTimer.setTextColor(ContextCompat.getColor(getContext(), C0591R.color.trae_status_error_default));
                this.tvTimeoutChip.setVisibility(0);
            }
        }
        if (state == TimeoutState.Warning && remainingSeconds > 0) {
            int i2 = remainingSeconds / 60;
            int i3 = remainingSeconds % 60;
            if (i2 > 0) {
                string = getContext().getString(C0637R.string.trae_brainstorm_timeout_minutes, Integer.valueOf(i2));
            } else {
                string = getContext().getString(C0637R.string.trae_brainstorm_timeout_seconds, Integer.valueOf(i3));
            }
            Intrinsics.checkNotNull(string);
            this.tvTimeoutChip.setText(string);
            return;
        }
        if (state == TimeoutState.Expired) {
            this.tvTimeoutChip.setText(getContext().getString(C0637R.string.trae_brainstorm_timeout_ending));
        }
    }
}
