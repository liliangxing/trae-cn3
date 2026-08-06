package com.bytedance.trae.common.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.core.widget.TextViewCompat;
import com.bytedance.trae.common_ui.C0591R;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: ContextMenuPopupWindow.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u00011B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0003\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bJ\u001e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u0010J\u0016\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\bJ\u000e\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u000eJ\u0018\u0010$\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0006H\u0002J\u0018\u0010&\u001a\u00020'2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0010H\u0002J\u0018\u0010)\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\bH\u0002J\u0018\u0010*\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\bH\u0002J\u001c\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J$\u0010-\u001a\u00020.2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0,H\u0002J\u0010\u00100\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b!\u0010#¨\u00062"}, d2 = {"Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;", "", "context", "Landroid/content/Context;", "items", "", "Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;", "widthRes", "", "<init>", "(Landroid/content/Context;Ljava/util/List;I)V", "popupWindow", "Landroid/widget/PopupWindow;", "showAtLocation", "", "parent", "Landroid/view/View;", "gravity", "x", "y", "showNear", "rawX", "", "rawY", "showAbove", "anchor", "horizontalAnchor", "showBelow", "relativePositionY", "setOnDismissListener", "listener", "Landroid/widget/PopupWindow$OnDismissListener;", "dismiss", "isShowing", "", "()Z", "createItemView", "item", "createShadowRootView", "Landroid/widget/FrameLayout;", "contentView", "adjustXForShadow", "adjustYForShadow", "screenToWindowOffset", "Lkotlin/Pair;", "visibleWindowFrame", "Landroid/graphics/Rect;", "windowOffset", "resolveSelectableItemBackground", "Item", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ContextMenuPopupWindow {
    private final PopupWindow popupWindow;

    public ContextMenuPopupWindow(Context context, List<Item> list, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "items");
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setBackground(ContextCompat.getDrawable(context, C0591R.drawable.trae_bg_context_menu_popup));
        int dimensionPixelSize = linearLayout.getResources().getDimensionPixelSize(C0591R.dimen.trae_context_menu_vertical_padding);
        linearLayout.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            linearLayout.addView(createItemView(context, (Item) it.next()));
        }
        PopupWindow popupWindow = new PopupWindow((View) createShadowRootView(context, linearLayout), context.getResources().getDimensionPixelSize(i) + (context.getResources().getDimensionPixelSize(C0591R.dimen.trae_context_menu_shadow_padding_horizontal) * 2), -2, true);
        popupWindow.setElevation(context.getResources().getDimensionPixelSize(C0591R.dimen.trae_context_menu_elevation));
        popupWindow.setAnimationStyle(R.style.Animation.Dialog);
        popupWindow.setOutsideTouchable(true);
        this.popupWindow = popupWindow;
    }

    public /* synthetic */ ContextMenuPopupWindow(Context context, List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, list, (i2 & 4) != 0 ? C0591R.dimen.trae_context_menu_width : i);
    }

    /* compiled from: ContextMenuPopupWindow.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u001c\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\n\u001a\u00020\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J^\u0010$\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\n\u001a\u00020\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, d2 = {"Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;", "", "iconRes", "", "title", "", "destructive", "", "iconTintRes", "textColorRes", "viewId", "onClick", "Lkotlin/Function0;", "", "<init>", "(ILjava/lang/CharSequence;ZLjava/lang/Integer;Ljava/lang/Integer;ILkotlin/jvm/functions/Function0;)V", "getIconRes", "()I", "getTitle", "()Ljava/lang/CharSequence;", "getDestructive", "()Z", "getIconTintRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTextColorRes", "getViewId", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ILjava/lang/CharSequence;ZLjava/lang/Integer;Ljava/lang/Integer;ILkotlin/jvm/functions/Function0;)Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;", "equals", "other", "hashCode", "toString", "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Item {
        private final boolean destructive;
        private final int iconRes;
        private final Integer iconTintRes;
        private final Function0<Unit> onClick;
        private final Integer textColorRes;
        private final CharSequence title;
        private final int viewId;

        public static /* synthetic */ Item copy$default(Item item, int i, CharSequence charSequence, boolean z, Integer num, Integer num2, int i2, Function0 function0, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = item.iconRes;
            }
            if ((i3 & 2) != 0) {
                charSequence = item.title;
            }
            CharSequence charSequence2 = charSequence;
            if ((i3 & 4) != 0) {
                z = item.destructive;
            }
            boolean z2 = z;
            if ((i3 & 8) != 0) {
                num = item.iconTintRes;
            }
            Integer num3 = num;
            if ((i3 & 16) != 0) {
                num2 = item.textColorRes;
            }
            Integer num4 = num2;
            if ((i3 & 32) != 0) {
                i2 = item.viewId;
            }
            int i4 = i2;
            if ((i3 & 64) != 0) {
                function0 = item.onClick;
            }
            return item.copy(i, charSequence2, z2, num3, num4, i4, function0);
        }

        /* renamed from: component1, reason: from getter */
        public final int getIconRes() {
            return this.iconRes;
        }

        /* renamed from: component2, reason: from getter */
        public final CharSequence getTitle() {
            return this.title;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getDestructive() {
            return this.destructive;
        }

        /* renamed from: component4, reason: from getter */
        public final Integer getIconTintRes() {
            return this.iconTintRes;
        }

        /* renamed from: component5, reason: from getter */
        public final Integer getTextColorRes() {
            return this.textColorRes;
        }

        /* renamed from: component6, reason: from getter */
        public final int getViewId() {
            return this.viewId;
        }

        public final Function0<Unit> component7() {
            return this.onClick;
        }

        public final Item copy(int iconRes, CharSequence title, boolean destructive, Integer iconTintRes, Integer textColorRes, int viewId, Function0<Unit> onClick) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            return new Item(iconRes, title, destructive, iconTintRes, textColorRes, viewId, onClick);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Item)) {
                return false;
            }
            Item item = (Item) other;
            return this.iconRes == item.iconRes && Intrinsics.areEqual(this.title, item.title) && this.destructive == item.destructive && Intrinsics.areEqual(this.iconTintRes, item.iconTintRes) && Intrinsics.areEqual(this.textColorRes, item.textColorRes) && this.viewId == item.viewId && Intrinsics.areEqual(this.onClick, item.onClick);
        }

        public int hashCode() {
            int hashCode = ((((Integer.hashCode(this.iconRes) * 31) + this.title.hashCode()) * 31) + Boolean.hashCode(this.destructive)) * 31;
            Integer num = this.iconTintRes;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.textColorRes;
            return ((((hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31) + Integer.hashCode(this.viewId)) * 31) + this.onClick.hashCode();
        }

        public String toString() {
            return "Item(iconRes=" + this.iconRes + ", title=" + ((Object) this.title) + ", destructive=" + this.destructive + ", iconTintRes=" + this.iconTintRes + ", textColorRes=" + this.textColorRes + ", viewId=" + this.viewId + ", onClick=" + this.onClick + ')';
        }

        public Item(int i, CharSequence charSequence, boolean z, Integer num, Integer num2, int i2, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(charSequence, "title");
            Intrinsics.checkNotNullParameter(function0, "onClick");
            this.iconRes = i;
            this.title = charSequence;
            this.destructive = z;
            this.iconTintRes = num;
            this.textColorRes = num2;
            this.viewId = i2;
            this.onClick = function0;
        }

        public /* synthetic */ Item(int i, CharSequence charSequence, boolean z, Integer num, Integer num2, int i2, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, charSequence, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? null : num, (i3 & 16) != 0 ? null : num2, (i3 & 32) != 0 ? -1 : i2, function0);
        }

        public final int getIconRes() {
            return this.iconRes;
        }

        public final CharSequence getTitle() {
            return this.title;
        }

        public final boolean getDestructive() {
            return this.destructive;
        }

        public final Integer getIconTintRes() {
            return this.iconTintRes;
        }

        public final Integer getTextColorRes() {
            return this.textColorRes;
        }

        public final int getViewId() {
            return this.viewId;
        }

        public final Function0<Unit> getOnClick() {
            return this.onClick;
        }
    }

    public final void showAtLocation(View parent, int gravity, int x, int y) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (this.popupWindow.isShowing()) {
            return;
        }
        PopupWindow popupWindow = this.popupWindow;
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int adjustXForShadow = adjustXForShadow(context, x);
        Context context2 = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        popupWindow.showAtLocation(parent, gravity, adjustXForShadow, adjustYForShadow(context2, y));
    }

    public final void showNear(View parent, float rawX, float rawY) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (this.popupWindow.isShowing()) {
            return;
        }
        View contentView = this.popupWindow.getContentView();
        contentView.measure(View.MeasureSpec.makeMeasureSpec(this.popupWindow.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        int width = this.popupWindow.getWidth();
        int measuredHeight = contentView.getMeasuredHeight();
        Resources resources = parent.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(C0591R.dimen.trae_context_menu_shadow_padding_top);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(C0591R.dimen.trae_context_menu_shadow_padding_bottom);
        Pair<Integer, Integer> screenToWindowOffset = screenToWindowOffset(parent);
        float floatValue = rawX - ((Number) screenToWindowOffset.getFirst()).floatValue();
        float floatValue2 = rawY - ((Number) screenToWindowOffset.getSecond()).floatValue();
        Rect visibleWindowFrame = visibleWindowFrame(parent, screenToWindowOffset);
        this.popupWindow.showAtLocation(parent, 0, RangesKt.coerceIn(MathKt.roundToInt(floatValue - (width / 2.0f)), visibleWindowFrame.left, Math.max(visibleWindowFrame.left, visibleWindowFrame.right - width)), RangesKt.coerceIn(MathKt.roundToInt((floatValue2 - dimensionPixelSize) - (((measuredHeight - dimensionPixelSize) - dimensionPixelSize2) / 2.0f)), visibleWindowFrame.top, Math.max(visibleWindowFrame.top, visibleWindowFrame.bottom - measuredHeight)));
    }

    public static /* synthetic */ void showAbove$default(ContextMenuPopupWindow contextMenuPopupWindow, View view, View view2, int i, Object obj) {
        if ((i & 2) != 0) {
            view2 = view;
        }
        contextMenuPopupWindow.showAbove(view, view2);
    }

    public final void showAbove(View anchor, View horizontalAnchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(horizontalAnchor, "horizontalAnchor");
        if (this.popupWindow.isShowing()) {
            return;
        }
        View contentView = this.popupWindow.getContentView();
        contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = contentView.getMeasuredHeight();
        int measuredWidth = contentView.getMeasuredWidth();
        int[] iArr = new int[2];
        anchor.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        horizontalAnchor.getLocationOnScreen(iArr2);
        int dimensionPixelSize = anchor.getResources().getDimensionPixelSize(C0591R.dimen.trae_context_menu_shadow_padding_horizontal);
        int dimensionPixelSize2 = anchor.getResources().getDimensionPixelSize(C0591R.dimen.trae_context_menu_shadow_padding_top);
        int coerceIn = RangesKt.coerceIn(iArr2[0] - dimensionPixelSize, 0, Math.max(0, anchor.getResources().getDisplayMetrics().widthPixels - measuredWidth));
        int i = anchor.getResources().getDisplayMetrics().heightPixels;
        this.popupWindow.showAtLocation(anchor, 0, coerceIn, RangesKt.coerceIn((iArr[1] - anchor.getResources().getDimensionPixelSize(C0591R.dimen.trae_context_menu_anchor_gap)) - dimensionPixelSize2, 0, Math.max(0, i - measuredHeight)));
    }

    public final void showBelow(View anchor, int relativePositionY) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (this.popupWindow.isShowing()) {
            return;
        }
        View contentView = this.popupWindow.getContentView();
        contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = contentView.getMeasuredHeight();
        int measuredWidth = contentView.getMeasuredWidth();
        int[] iArr = new int[2];
        anchor.getLocationOnScreen(iArr);
        this.popupWindow.showAtLocation(anchor, 48, RangesKt.coerceIn(iArr[0] - anchor.getResources().getDimensionPixelSize(C0591R.dimen.trae_context_menu_shadow_padding_horizontal), 0, Math.max(0, anchor.getResources().getDisplayMetrics().widthPixels - measuredWidth)), RangesKt.coerceIn(iArr[1] + relativePositionY, 0, Math.max(0, anchor.getResources().getDisplayMetrics().heightPixels - measuredHeight)));
    }

    public final void setOnDismissListener(PopupWindow.OnDismissListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.popupWindow.setOnDismissListener(listener);
    }

    public final void dismiss() {
        if (this.popupWindow.isShowing()) {
            this.popupWindow.dismiss();
        }
    }

    public final boolean isShowing() {
        return this.popupWindow.isShowing();
    }

    private final View createItemView(Context context, final Item item) {
        int i;
        int i2;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(item.getViewId());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(C0591R.dimen.trae_context_menu_item_height)));
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C0591R.dimen.trae_context_menu_item_horizontal_padding);
        linearLayout.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        linearLayout.setBackgroundResource(resolveSelectableItemBackground(context));
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.common.widget.ContextMenuPopupWindow$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContextMenuPopupWindow.createItemView$lambda$7$lambda$3(ContextMenuPopupWindow.this, item, view);
            }
        });
        if (item.getDestructive()) {
            i = C0591R.color.trae_status_error_default;
        } else {
            i = C0591R.color.trae_icon_icon_default;
        }
        ImageView imageView = new ImageView(context);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(C0591R.dimen.trae_context_menu_icon_size);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelSize2, dimensionPixelSize2));
        imageView.setImageResource(item.getIconRes());
        Integer iconTintRes = item.getIconTintRes();
        if (iconTintRes != null) {
            i = iconTintRes.intValue();
        }
        ImageViewCompat.setImageTintList(imageView, ContextCompat.getColorStateList(context, i));
        imageView.setImportantForAccessibility(2);
        linearLayout.addView(imageView);
        Integer textColorRes = item.getTextColorRes();
        if (textColorRes != null) {
            i2 = textColorRes.intValue();
        } else if (item.getDestructive()) {
            i2 = C0591R.color.trae_status_error_default;
        } else {
            i2 = C0591R.color.trae_text_text_default;
        }
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.setMarginStart(context.getResources().getDimensionPixelSize(C0591R.dimen.trae_context_menu_text_margin_start));
        textView.setLayoutParams(layoutParams);
        TextViewCompat.setTextAppearance(textView, C0591R.style.Trae_Text_Body_Base);
        textView.setText(item.getTitle());
        textView.setTextColor(ContextCompat.getColor(context, i2));
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        linearLayout.addView(textView);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createItemView$lambda$7$lambda$3(ContextMenuPopupWindow contextMenuPopupWindow, Item item, View view) {
        contextMenuPopupWindow.dismiss();
        item.getOnClick().invoke();
    }

    private final FrameLayout createShadowRootView(Context context, View contentView) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C0591R.dimen.trae_context_menu_shadow_padding_horizontal);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(C0591R.dimen.trae_context_menu_shadow_padding_top);
        int dimensionPixelSize3 = context.getResources().getDimensionPixelSize(C0591R.dimen.trae_context_menu_shadow_padding_bottom);
        int dimensionPixelSize4 = context.getResources().getDimensionPixelSize(C0591R.dimen.trae_context_menu_radius);
        int dimensionPixelSize5 = context.getResources().getDimensionPixelSize(C0591R.dimen.trae_context_menu_shadow_blur_radius);
        int dimensionPixelSize6 = context.getResources().getDimensionPixelSize(C0591R.dimen.trae_context_menu_shadow_offset_y);
        int color = ContextCompat.getColor(context, C0591R.color.trae_context_menu_shadow);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setClipChildren(false);
        frameLayout.setClipToPadding(false);
        frameLayout.setLayerType(1, null);
        frameLayout.setBackground(new ContextMenuShadowDrawable(dimensionPixelSize4, dimensionPixelSize5, dimensionPixelSize6, color, new Rect(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize3)));
        frameLayout.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize3);
        frameLayout.addView(contentView, new FrameLayout.LayoutParams(-1, -2));
        return frameLayout;
    }

    private final int adjustXForShadow(Context context, int x) {
        return x - context.getResources().getDimensionPixelSize(C0591R.dimen.trae_context_menu_shadow_padding_horizontal);
    }

    private final int adjustYForShadow(Context context, int y) {
        return y - context.getResources().getDimensionPixelSize(C0591R.dimen.trae_context_menu_shadow_padding_top);
    }

    private final Pair<Integer, Integer> screenToWindowOffset(View parent) {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        parent.getRootView().getLocationOnScreen(iArr);
        parent.getRootView().getLocationInWindow(iArr2);
        return new Pair<>(Integer.valueOf(iArr[0] - iArr2[0]), Integer.valueOf(iArr[1] - iArr2[1]));
    }

    private final Rect visibleWindowFrame(View parent, Pair<Integer, Integer> windowOffset) {
        Rect rect = new Rect();
        parent.getRootView().getWindowVisibleDisplayFrame(rect);
        if (!rect.isEmpty()) {
            rect.offset(-((Number) windowOffset.getFirst()).intValue(), -((Number) windowOffset.getSecond()).intValue());
            return rect;
        }
        DisplayMetrics displayMetrics = parent.getResources().getDisplayMetrics();
        return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    private final int resolveSelectableItemBackground(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, typedValue, true);
        return typedValue.resourceId;
    }
}
