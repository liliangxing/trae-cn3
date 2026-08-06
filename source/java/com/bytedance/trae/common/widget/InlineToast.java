package com.bytedance.trae.common.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InlineToast.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001!B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JJ\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0003\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u0007H\u0007J\u0006\u0010\u001c\u001a\u00020\u0011J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rH\u0002J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/trae/common/widget/InlineToast;", "", "<init>", "()V", "DEFAULT_DURATION_MS", "", "DEFAULT_TOP_MARGIN_DP", "", "FADE_IN_MS", "FADE_OUT_MS", "TAG", "", "currentToastView", "Landroid/view/View;", "currentHideRunnable", "Ljava/lang/Runnable;", "show", "", "container", "Landroid/view/ViewGroup;", "message", "", "iconRes", "durationMs", "topMarginDp", NewTaskTracker.Param.POSITION, "Lcom/bytedance/trae/common/widget/InlineToast$Position;", "bottomMarginDp", "dismiss", "removeFromParent", "view", "resolveAnchor", "NO_ICON", "Position", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InlineToast {
    public static final long DEFAULT_DURATION_MS = 2000;
    private static final int DEFAULT_TOP_MARGIN_DP = 80;
    private static final long FADE_IN_MS = 200;
    private static final long FADE_OUT_MS = 300;
    public static final InlineToast INSTANCE = new InlineToast();
    public static final int NO_ICON = 0;
    private static final String TAG = "InlineToast";
    private static Runnable currentHideRunnable;
    private static View currentToastView;

    /* compiled from: InlineToast.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Position.values().length];
            try {
                iArr[Position.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Position.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final void show(ViewGroup viewGroup, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Intrinsics.checkNotNullParameter(charSequence, "message");
        show$default(this, viewGroup, charSequence, 0, 0L, 0, null, 0, 124, null);
    }

    public final void show(ViewGroup viewGroup, CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Intrinsics.checkNotNullParameter(charSequence, "message");
        show$default(this, viewGroup, charSequence, i, 0L, 0, null, 0, 120, null);
    }

    public final void show(ViewGroup viewGroup, CharSequence charSequence, int i, long j) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Intrinsics.checkNotNullParameter(charSequence, "message");
        show$default(this, viewGroup, charSequence, i, j, 0, null, 0, 112, null);
    }

    public final void show(ViewGroup viewGroup, CharSequence charSequence, int i, long j, int i2) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Intrinsics.checkNotNullParameter(charSequence, "message");
        show$default(this, viewGroup, charSequence, i, j, i2, null, 0, 96, null);
    }

    public final void show(ViewGroup viewGroup, CharSequence charSequence, int i, long j, int i2, Position position) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Intrinsics.checkNotNullParameter(charSequence, "message");
        Intrinsics.checkNotNullParameter(position, NewTaskTracker.Param.POSITION);
        show$default(this, viewGroup, charSequence, i, j, i2, position, 0, 64, null);
    }

    private InlineToast() {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: InlineToast.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/common/widget/InlineToast$Position;", "", "<init>", "(Ljava/lang/String;I)V", "TOP", "BOTTOM", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Position {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Position[] $VALUES;
        public static final Position TOP = new Position("TOP", 0);
        public static final Position BOTTOM = new Position("BOTTOM", 1);

        private static final /* synthetic */ Position[] $values() {
            return new Position[]{TOP, BOTTOM};
        }

        public static EnumEntries<Position> getEntries() {
            return $ENTRIES;
        }

        private Position(String str, int i) {
        }

        static {
            Position[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static Position valueOf(String str) {
            return (Position) Enum.valueOf(Position.class, str);
        }

        public static Position[] values() {
            return (Position[]) $VALUES.clone();
        }
    }

    public static /* synthetic */ void show$default(InlineToast inlineToast, ViewGroup viewGroup, CharSequence charSequence, int i, long j, int i2, Position position, int i3, int i4, Object obj) {
        inlineToast.show(viewGroup, charSequence, (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? 2000L : j, (i4 & 16) != 0 ? 80 : i2, (i4 & 32) != 0 ? Position.TOP : position, (i4 & 64) != 0 ? 80 : i3);
    }

    public final void show(ViewGroup container, CharSequence message, int iconRes, long durationMs, int topMarginDp, Position position, int bottomMarginDp) {
        int i;
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(position, NewTaskTracker.Param.POSITION);
        dismiss();
        ViewGroup resolveAnchor = resolveAnchor(container);
        final View inflate = LayoutInflater.from(resolveAnchor.getContext()).inflate(C0591R.layout.trae_layout_inline_toast, resolveAnchor, false);
        ((TextView) inflate.findViewById(C0591R.id.tv_inline_toast_message)).setText(message);
        ImageView imageView = (ImageView) inflate.findViewById(C0591R.id.iv_inline_toast_icon);
        if (iconRes != 0) {
            imageView.setImageResource(iconRes);
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int i2 = WhenMappings.$EnumSwitchMapping$0[position.ordinal()];
        if (i2 == 1) {
            i = 49;
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i = 81;
        }
        layoutParams.gravity = i;
        int i3 = WhenMappings.$EnumSwitchMapping$0[position.ordinal()];
        if (i3 == 1) {
            layoutParams.topMargin = (int) (topMarginDp * resolveAnchor.getResources().getDisplayMetrics().density);
        } else {
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            layoutParams.bottomMargin = (int) (bottomMarginDp * resolveAnchor.getResources().getDisplayMetrics().density);
        }
        inflate.setAlpha(0.0f);
        resolveAnchor.addView(inflate, layoutParams);
        currentToastView = inflate;
        inflate.animate().alpha(1.0f).setDuration(200L).start();
        Runnable runnable = new Runnable() { // from class: com.bytedance.trae.common.widget.InlineToast$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                InlineToast.show$lambda$2(inflate);
            }
        };
        currentHideRunnable = runnable;
        inflate.postDelayed(runnable, durationMs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$2(final View view) {
        view.animate().alpha(0.0f).setDuration(FADE_OUT_MS).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.trae.common.widget.InlineToast$show$hideRunnable$1$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                InlineToast inlineToast = InlineToast.INSTANCE;
                View view2 = view;
                Intrinsics.checkNotNull(view2);
                inlineToast.removeFromParent(view2);
            }
        }).start();
    }

    public final void dismiss() {
        View view = currentToastView;
        if (view != null) {
            view.animate().cancel();
            Runnable runnable = currentHideRunnable;
            if (runnable != null) {
                view.removeCallbacks(runnable);
            }
            INSTANCE.removeFromParent(view);
        }
        currentHideRunnable = null;
        currentToastView = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeFromParent(View view) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        if (Intrinsics.areEqual(currentToastView, view)) {
            currentToastView = null;
            currentHideRunnable = null;
        }
    }

    private final ViewGroup resolveAnchor(ViewGroup container) {
        if (container instanceof FrameLayout) {
            return container;
        }
        View rootView = container.getRootView();
        ViewGroup viewGroup = rootView != null ? (ViewGroup) rootView.findViewById(R.id.content) : null;
        if (viewGroup instanceof FrameLayout) {
            FLogger.INSTANCE.w(TAG, "container " + container.getClass().getSimpleName() + " is not FrameLayout, fallback to android.R.id.content");
            return viewGroup;
        }
        FLogger.INSTANCE.w(TAG, "container " + container.getClass().getSimpleName() + " is not FrameLayout and no FrameLayout fallback available, layout may be broken");
        return container;
    }
}
