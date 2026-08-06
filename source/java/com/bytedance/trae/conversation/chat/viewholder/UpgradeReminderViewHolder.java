package com.bytedance.trae.conversation.chat.viewholder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: UpgradeReminderViewHolder.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "card", "Landroid/widget/LinearLayout;", "titleView", "Landroid/widget/TextView;", "bodyView", "buttonView", "<init>", "(Landroid/view/View;Landroid/widget/LinearLayout;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;)V", "bind", "", "conversationId", "", "onClick", "Lkotlin/Function1;", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UpgradeReminderViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG_VIEW_HOLDER = "upgrade_reminder_view_holder";
    private final TextView bodyView;
    private final TextView buttonView;
    private final LinearLayout card;
    private final TextView titleView;

    public /* synthetic */ UpgradeReminderViewHolder(View view, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, linearLayout, textView, textView2, textView3);
    }

    private UpgradeReminderViewHolder(View view, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        super(view);
        this.card = linearLayout;
        this.titleView = textView;
        this.bodyView = textView2;
        this.buttonView = textView3;
    }

    public final void bind(final String conversationId, final Function1<? super String, Unit> onClick) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Context context = this.itemView.getContext();
        this.titleView.setText(context.getString(C0637R.string.trae_upgrade_reminder_title));
        this.bodyView.setText(context.getString(C0637R.string.trae_upgrade_reminder_body));
        this.buttonView.setText(context.getString(C0637R.string.trae_upgrade_reminder_button));
        this.buttonView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.viewholder.UpgradeReminderViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UpgradeReminderViewHolder.bind$lambda$0(onClick, conversationId, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0(Function1 function1, String str, View view) {
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    /* compiled from: UpgradeReminderViewHolder.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;", "", "<init>", "()V", "TAG_VIEW_HOLDER", "", "create", "Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;", "parent", "Landroid/view/ViewGroup;", "createView", "context", "Landroid/content/Context;", "includeHorizontalPadding", "", "fromView", "view", "Landroid/view/View;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UpgradeReminderViewHolder create(ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            return createView$default(this, context, false, 2, null);
        }

        public static /* synthetic */ UpgradeReminderViewHolder createView$default(Companion companion, Context context, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = true;
            }
            return companion.createView(context, z);
        }

        public final UpgradeReminderViewHolder createView(Context context, boolean includeHorizontalPadding) {
            Intrinsics.checkNotNullParameter(context, "context");
            Resources resources = context.getResources();
            int dimensionPixelSize = includeHorizontalPadding ? resources.getDimensionPixelSize(C0637R.dimen.trae_upgrade_reminder_outer_padding_horizontal) : 0;
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setPadding(dimensionPixelSize, resources.getDimensionPixelSize(C0637R.dimen.trae_upgrade_reminder_outer_padding_top), dimensionPixelSize, resources.getDimensionPixelSize(C0637R.dimen.trae_upgrade_reminder_outer_padding_bottom));
            linearLayout.setLayoutParams((ViewGroup.LayoutParams) new RecyclerView.LayoutParams(-1, -2));
            LinearLayout linearLayout2 = new LinearLayout(context);
            linearLayout2.setId(C0637R.id.upgrade_reminder_card);
            linearLayout2.setOrientation(1);
            linearLayout2.setPadding(resources.getDimensionPixelSize(C0637R.dimen.trae_upgrade_reminder_card_padding_horizontal), resources.getDimensionPixelSize(C0637R.dimen.trae_upgrade_reminder_card_padding_vertical), resources.getDimensionPixelSize(C0637R.dimen.trae_upgrade_reminder_card_padding_horizontal), resources.getDimensionPixelSize(C0637R.dimen.trae_upgrade_reminder_card_padding_vertical));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(resources.getDimension(C0637R.dimen.trae_upgrade_reminder_card_radius));
            gradientDrawable.setColor(ContextCompat.getColor(context, C0637R.color.trae_upgrade_reminder_bg));
            gradientDrawable.setStroke(RangesKt.coerceAtLeast(resources.getDimensionPixelSize(C0637R.dimen.trae_upgrade_reminder_card_border_width), 1), ContextCompat.getColor(context, C0637R.color.trae_upgrade_reminder_border));
            linearLayout2.setBackground(gradientDrawable);
            linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
            TextView textView = new TextView(context);
            textView.setTextColor(ContextCompat.getColor(context, C0637R.color.trae_upgrade_reminder_title_text));
            textView.setTextSize(0, resources.getDimension(C0637R.dimen.trae_upgrade_reminder_title_text_size));
            textView.setTypeface(Typeface.create("sans-serif-medium", 0));
            textView.setIncludeFontPadding(true);
            TextViewCompat.setLineHeight(textView, resources.getDimensionPixelSize(C0637R.dimen.trae_upgrade_reminder_title_line_height));
            linearLayout2.addView(textView, new LinearLayout.LayoutParams(-1, -2));
            TextView textView2 = new TextView(context);
            textView2.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary));
            textView2.setTextSize(0, resources.getDimension(C0637R.dimen.trae_upgrade_reminder_body_text_size));
            textView2.setIncludeFontPadding(true);
            TextViewCompat.setLineHeight(textView2, resources.getDimensionPixelSize(C0637R.dimen.trae_upgrade_reminder_body_line_height));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = resources.getDimensionPixelSize(C0637R.dimen.trae_upgrade_reminder_body_margin_top);
            Unit unit = Unit.INSTANCE;
            linearLayout2.addView(textView2, layoutParams);
            LinearLayout linearLayout3 = new LinearLayout(context);
            linearLayout3.setGravity(8388613);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = resources.getDimensionPixelSize(C0637R.dimen.trae_upgrade_reminder_actions_margin_top);
            Unit unit2 = Unit.INSTANCE;
            linearLayout2.addView(linearLayout3, layoutParams2);
            TextView textView3 = new TextView(context);
            textView3.setGravity(17);
            textView3.setMinHeight(resources.getDimensionPixelSize(C0637R.dimen.trae_upgrade_reminder_button_height));
            textView3.setPadding(resources.getDimensionPixelSize(C0637R.dimen.trae_upgrade_reminder_button_padding_horizontal), 0, resources.getDimensionPixelSize(C0637R.dimen.trae_upgrade_reminder_button_padding_horizontal), 0);
            textView3.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_onaccent));
            textView3.setTextSize(0, resources.getDimension(C0637R.dimen.trae_upgrade_reminder_button_text_size));
            textView3.setTypeface(Typeface.create("sans-serif-medium", 0));
            textView3.setIncludeFontPadding(true);
            TextViewCompat.setLineHeight(textView3, resources.getDimensionPixelSize(C0637R.dimen.trae_upgrade_reminder_button_line_height));
            textView3.setClickable(true);
            textView3.setFocusable(true);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(resources.getDimension(C0637R.dimen.trae_upgrade_reminder_button_radius));
            gradientDrawable2.setColor(ContextCompat.getColor(context, C0591R.color.trae_bg_bg_invert));
            textView3.setBackground(gradientDrawable2);
            linearLayout3.addView(textView3, new LinearLayout.LayoutParams(-2, resources.getDimensionPixelSize(C0637R.dimen.trae_upgrade_reminder_button_height)));
            UpgradeReminderViewHolder upgradeReminderViewHolder = new UpgradeReminderViewHolder(linearLayout, linearLayout2, textView, textView2, textView3, null);
            linearLayout.setTag(TuplesKt.to(UpgradeReminderViewHolder.TAG_VIEW_HOLDER, upgradeReminderViewHolder));
            return upgradeReminderViewHolder;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final UpgradeReminderViewHolder fromView(View view) {
            Object obj;
            Intrinsics.checkNotNullParameter(view, "view");
            Object tag = view.getTag();
            Pair pair = tag instanceof Pair ? (Pair) tag : null;
            if (pair != null) {
                if (!Intrinsics.areEqual(pair.getFirst(), UpgradeReminderViewHolder.TAG_VIEW_HOLDER)) {
                    pair = null;
                }
                if (pair != null) {
                    obj = pair.getSecond();
                    if (obj instanceof UpgradeReminderViewHolder) {
                        return null;
                    }
                    return (UpgradeReminderViewHolder) obj;
                }
            }
            obj = null;
            if (obj instanceof UpgradeReminderViewHolder) {
            }
        }
    }
}
