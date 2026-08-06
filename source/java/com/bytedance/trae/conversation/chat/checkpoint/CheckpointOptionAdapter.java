package com.bytedance.trae.conversation.chat.checkpoint;

import android.text.Layout;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.checkpoint.CheckpointOptionAdapter;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CheckpointOptionAdapter.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u001e2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001d\u001eB7\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u000f\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u0011J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0011J\u0006\u0010\u0013\u001a\u00020\u0004J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001c\u0010\u0019\u001a\u00020\u00072\n\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;", "multiSelect", "", "onSelectionChanged", "Lkotlin/Function0;", "", "onSingleSelectConfirmed", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;", "<init>", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "items", "", "submitList", "newItems", "", "getSelectedOptions", "clearSelection", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", NewTaskTracker.Param.POSITION, "getItemCount", "OptionViewHolder", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CheckpointOptionAdapter extends RecyclerView.Adapter<OptionViewHolder> {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int SUBTITLE_COLLAPSED_FULL_LINES = 4;

    @Deprecated
    public static final int SUBTITLE_LINE_HEIGHT_DP = 17;

    @Deprecated
    public static final float SUBTITLE_PARTIAL_VISIBLE_LINE_RATIO = 0.75f;
    private final List<CheckpointOption> items;
    private final boolean multiSelect;
    private final Function0<Unit> onSelectionChanged;
    private final Function1<CheckpointOption, Unit> onSingleSelectConfirmed;

    public /* synthetic */ CheckpointOptionAdapter(boolean z, Function0 function0, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, function0, (i & 4) != 0 ? null : function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CheckpointOptionAdapter(boolean z, Function0<Unit> function0, Function1<? super CheckpointOption, Unit> function1) {
        Intrinsics.checkNotNullParameter(function0, "onSelectionChanged");
        this.multiSelect = z;
        this.onSelectionChanged = function0;
        this.onSingleSelectConfirmed = function1;
        this.items = new ArrayList();
    }

    public final void submitList(List<CheckpointOption> newItems) {
        Intrinsics.checkNotNullParameter(newItems, "newItems");
        this.items.clear();
        this.items.addAll(newItems);
        notifyDataSetChanged();
    }

    public final List<CheckpointOption> getSelectedOptions() {
        List<CheckpointOption> list = this.items;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((CheckpointOption) obj).isSelected()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final boolean clearSelection() {
        boolean z = false;
        int i = 0;
        for (Object obj : this.items) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            CheckpointOption checkpointOption = (CheckpointOption) obj;
            if (checkpointOption.isSelected()) {
                checkpointOption.setSelected(false);
                notifyItemChanged(i);
                z = true;
            }
            i = i2;
        }
        return z;
    }

    public OptionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(C0637R.layout.trae_item_checkpoint_option, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new OptionViewHolder(this, inflate);
    }

    public void onBindViewHolder(OptionViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.items.get(position), position);
    }

    public int getItemCount() {
        return this.items.size();
    }

    /* compiled from: CheckpointOptionAdapter.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0019H\u0002J\b\u0010 \u001a\u00020\u0015H\u0002J\b\u0010!\u001a\u00020\u0015H\u0002J\b\u0010\"\u001a\u00020\u0015H\u0002J\b\u0010#\u001a\u00020\u0015H\u0002J\b\u0010$\u001a\u00020\u0019H\u0002J\u0018\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0019H\u0002J\f\u0010\u001f\u001a\u00020\u0019*\u00020\u0019H\u0002R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;Landroid/view/View;)V", "root", "checkboxContainer", "Landroid/widget/FrameLayout;", "ivCheck", "Landroid/widget/ImageView;", "tvOptionIndex", "Landroid/widget/TextView;", "ivSingleCheck", "textContainer", "tvTitle", "subtitleViewport", "tvSubtitle", "subtitleTopFade", "subtitleBottomFade", "bind", "", "option", "Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;", NewTaskTracker.Param.POSITION, "", "selectOption", "updateCheckState", "checked", "", "setBoxSize", "dp", "setupSubtitleScrolling", "applySubtitleViewport", "updateSubtitleFadeVisibility", "hideSubtitleFades", "subtitleCollapsedHeightPx", "setViewHeight", "view", "height", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public final class OptionViewHolder extends RecyclerView.ViewHolder {
        private final FrameLayout checkboxContainer;
        private final ImageView ivCheck;
        private final ImageView ivSingleCheck;
        private final View root;
        private final View subtitleBottomFade;
        private final View subtitleTopFade;
        private final View subtitleViewport;
        private final View textContainer;
        final /* synthetic */ CheckpointOptionAdapter this$0;
        private final TextView tvOptionIndex;
        private final TextView tvSubtitle;
        private final TextView tvTitle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OptionViewHolder(CheckpointOptionAdapter checkpointOptionAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = checkpointOptionAdapter;
            View findViewById = view.findViewById(C0637R.id.option_root);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.root = findViewById;
            View findViewById2 = view.findViewById(C0637R.id.checkbox_container);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.checkboxContainer = (FrameLayout) findViewById2;
            View findViewById3 = view.findViewById(C0637R.id.iv_check);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.ivCheck = (ImageView) findViewById3;
            View findViewById4 = view.findViewById(C0637R.id.tv_option_index);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            TextView textView = (TextView) findViewById4;
            this.tvOptionIndex = textView;
            View findViewById5 = view.findViewById(C0637R.id.iv_option_single_check);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
            this.ivSingleCheck = (ImageView) findViewById5;
            View findViewById6 = view.findViewById(C0637R.id.text_container);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
            this.textContainer = findViewById6;
            View findViewById7 = view.findViewById(C0637R.id.tv_title);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
            TextView textView2 = (TextView) findViewById7;
            this.tvTitle = textView2;
            View findViewById8 = view.findViewById(C0637R.id.subtitle_viewport);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
            this.subtitleViewport = findViewById8;
            View findViewById9 = view.findViewById(C0637R.id.tv_subtitle);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
            TextView textView3 = (TextView) findViewById9;
            this.tvSubtitle = textView3;
            View findViewById10 = view.findViewById(C0637R.id.subtitle_top_fade);
            Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(...)");
            this.subtitleTopFade = findViewById10;
            View findViewById11 = view.findViewById(C0637R.id.subtitle_bottom_fade);
            Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(...)");
            this.subtitleBottomFade = findViewById11;
            float f = view.getResources().getDisplayMetrics().density;
            textView2.setTypeface(CheckpointTypefaces.INSTANCE.defaultSemibold());
            TextViewCompat.setLineHeight(textView2, (int) (22 * f));
            int i = (int) (17 * f);
            TextViewCompat.setLineHeight(textView3, i);
            TextViewCompat.setLineHeight(textView, i);
            setupSubtitleScrolling();
        }

        public final void bind(final CheckpointOption option, int position) {
            Intrinsics.checkNotNullParameter(option, "option");
            this.tvTitle.setText(option.getLabel());
            boolean z = true;
            this.tvOptionIndex.setText(String.valueOf(position + 1));
            String description = option.getDescription();
            if (description != null && description.length() != 0) {
                z = false;
            }
            if (z) {
                this.tvSubtitle.setText((CharSequence) null);
                this.tvSubtitle.scrollTo(0, 0);
                hideSubtitleFades();
                setViewHeight(this.subtitleViewport, -2);
                setViewHeight(this.tvSubtitle, -2);
                this.subtitleViewport.setVisibility(8);
            } else {
                this.tvSubtitle.setText(option.getDescription());
                this.tvSubtitle.scrollTo(0, 0);
                this.tvSubtitle.setMaxLines(Integer.MAX_VALUE);
                hideSubtitleFades();
                setViewHeight(this.subtitleViewport, -2);
                setViewHeight(this.tvSubtitle, -2);
                this.subtitleViewport.setVisibility(0);
                this.tvSubtitle.setVisibility(0);
                final String description2 = option.getDescription();
                this.tvSubtitle.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointOptionAdapter$OptionViewHolder$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        CheckpointOptionAdapter.OptionViewHolder.bind$lambda$0(CheckpointOptionAdapter.OptionViewHolder.this, description2);
                    }
                });
            }
            updateCheckState(option.isSelected());
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointOptionAdapter$OptionViewHolder$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CheckpointOptionAdapter.OptionViewHolder.this.selectOption(option);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(OptionViewHolder optionViewHolder, String str) {
            CharSequence text = optionViewHolder.tvSubtitle.getText();
            if (Intrinsics.areEqual(text != null ? text.toString() : null, str)) {
                optionViewHolder.applySubtitleViewport();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void selectOption(CheckpointOption option) {
            int bindingAdapterPosition = getBindingAdapterPosition();
            if (bindingAdapterPosition == -1) {
                return;
            }
            if (!this.this$0.multiSelect) {
                List list = this.this$0.items;
                CheckpointOptionAdapter checkpointOptionAdapter = this.this$0;
                int i = 0;
                for (Object obj : list) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    CheckpointOption checkpointOption = (CheckpointOption) obj;
                    if (checkpointOption.isSelected() && i != bindingAdapterPosition) {
                        checkpointOption.setSelected(false);
                        checkpointOptionAdapter.notifyItemChanged(i);
                    }
                    i = i2;
                }
                option.setSelected(true);
                updateCheckState(true);
                this.this$0.notifyItemChanged(bindingAdapterPosition);
                this.this$0.onSelectionChanged.invoke();
                Function1 function1 = this.this$0.onSingleSelectConfirmed;
                if (function1 != null) {
                    function1.invoke(option);
                    return;
                }
                return;
            }
            option.setSelected(!option.isSelected());
            updateCheckState(option.isSelected());
            this.this$0.notifyItemChanged(bindingAdapterPosition);
            this.this$0.onSelectionChanged.invoke();
        }

        private final void updateCheckState(boolean checked) {
            int i;
            if (!this.this$0.multiSelect) {
                this.checkboxContainer.setVisibility(0);
                setBoxSize(20);
                this.checkboxContainer.setBackgroundResource(C0637R.drawable.trae_bg_checkpoint_option_index);
                this.tvOptionIndex.setVisibility(0);
                this.ivCheck.setVisibility(8);
                this.ivSingleCheck.setVisibility(checked ? 0 : 8);
                ViewGroup.LayoutParams layoutParams = this.textContainer.getLayoutParams();
                LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 != null) {
                    layoutParams2.setMarginStart(m826dp(12));
                }
            } else {
                this.checkboxContainer.setVisibility(0);
                setBoxSize(16);
                this.tvOptionIndex.setVisibility(8);
                this.ivSingleCheck.setVisibility(8);
                if (checked) {
                    this.checkboxContainer.setBackgroundResource(C0637R.drawable.trae_bg_checkpoint_checkbox_checked);
                    this.ivCheck.setVisibility(0);
                } else {
                    this.checkboxContainer.setBackgroundResource(C0637R.drawable.trae_bg_checkpoint_checkbox_unchecked);
                    this.ivCheck.setVisibility(8);
                }
            }
            View view = this.root;
            if (checked) {
                i = C0637R.drawable.trae_bg_checkpoint_option_selected;
            } else {
                i = C0637R.drawable.trae_bg_checkpoint_option_normal;
            }
            view.setBackgroundResource(i);
        }

        private final void setBoxSize(int dp) {
            ViewGroup.LayoutParams layoutParams = this.checkboxContainer.getLayoutParams();
            int m826dp = m826dp(dp);
            if (layoutParams.width == m826dp && layoutParams.height == m826dp) {
                return;
            }
            layoutParams.width = m826dp;
            layoutParams.height = m826dp;
            this.checkboxContainer.setLayoutParams(layoutParams);
        }

        private final void setupSubtitleScrolling() {
            this.tvSubtitle.setMovementMethod(ScrollingMovementMethod.getInstance());
            this.tvSubtitle.setVerticalScrollBarEnabled(false);
            this.tvSubtitle.setVerticalFadingEdgeEnabled(false);
            this.tvSubtitle.setMaxLines(Integer.MAX_VALUE);
            this.tvSubtitle.setFadingEdgeLength(m826dp(17));
            this.tvSubtitle.setOverScrollMode(1);
            this.tvSubtitle.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointOptionAdapter$OptionViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean z;
                    z = CheckpointOptionAdapter.OptionViewHolder.setupSubtitleScrolling$lambda$3(CheckpointOptionAdapter.OptionViewHolder.this, view, motionEvent);
                    return z;
                }
            });
            this.tvSubtitle.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointOptionAdapter$OptionViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    CheckpointOptionAdapter.OptionViewHolder.this.updateSubtitleFadeVisibility();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean setupSubtitleScrolling$lambda$3(OptionViewHolder optionViewHolder, View view, MotionEvent motionEvent) {
            if (view.canScrollVertically(-1) || view.canScrollVertically(1)) {
                boolean z = (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3) ? false : true;
                ViewParent parent = view.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(z);
                }
                ViewParent parent2 = optionViewHolder.itemView.getParent();
                if (parent2 == null) {
                    return false;
                }
                parent2.requestDisallowInterceptTouchEvent(z);
                return false;
            }
            optionViewHolder.itemView.onTouchEvent(motionEvent);
            return true;
        }

        private final void applySubtitleViewport() {
            Layout layout = this.tvSubtitle.getLayout();
            if ((layout != null ? layout.getLineCount() : this.tvSubtitle.getLineCount()) > 4) {
                setViewHeight(this.subtitleViewport, subtitleCollapsedHeightPx());
                setViewHeight(this.tvSubtitle, subtitleCollapsedHeightPx());
                updateSubtitleFadeVisibility();
                return;
            }
            hideSubtitleFades();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void updateSubtitleFadeVisibility() {
            if (this.subtitleViewport.getVisibility() != 0 || this.tvSubtitle.getHeight() <= 0) {
                hideSubtitleFades();
            } else {
                this.subtitleTopFade.setVisibility(this.tvSubtitle.canScrollVertically(-1) ? 0 : 8);
                this.subtitleBottomFade.setVisibility(this.tvSubtitle.canScrollVertically(1) ? 0 : 8);
            }
        }

        private final void hideSubtitleFades() {
            this.subtitleTopFade.setVisibility(8);
            this.subtitleBottomFade.setVisibility(8);
        }

        private final int subtitleCollapsedHeightPx() {
            return (int) (17 * 4.75f * this.itemView.getResources().getDisplayMetrics().density);
        }

        private final void setViewHeight(View view, int height) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null || layoutParams.height == height) {
                return;
            }
            layoutParams.height = height;
            view.setLayoutParams(layoutParams);
        }

        /* renamed from: dp */
        private final int m826dp(int i) {
            return (int) (i * this.itemView.getResources().getDisplayMetrics().density);
        }
    }

    /* compiled from: CheckpointOptionAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$Companion;", "", "<init>", "()V", "SUBTITLE_LINE_HEIGHT_DP", "", "SUBTITLE_COLLAPSED_FULL_LINES", "SUBTITLE_PARTIAL_VISIBLE_LINE_RATIO", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
