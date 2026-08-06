package com.bytedance.trae.home.solo.sitemessage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.common.widget.SwipeRevealController;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SiteMessageAdapter.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001)Bw\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b\u0012\"\b\u0002\u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b\u0012\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0018\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aJ\u0014\u0010\u001b\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\tJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\tJ\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\u0006J\b\u0010\"\u001a\u00020\tH\u0016J\u001c\u0010#\u001a\u00060\u0002R\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\tH\u0016J\u001c\u0010'\u001a\u00020\u00062\n\u0010(\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\tH\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0018\u00010\u0002R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;", "onCtaClick", "Lkotlin/Function1;", "Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;", "", "onDeleteClick", "Lkotlin/Function2;", "", "onLongClick", "Lkotlin/Function3;", "Landroid/view/View;", "onItemClick", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;)V", "items", "", "openViewHolder", "isoDateFormat", "Ljava/text/SimpleDateFormat;", "timeFormat", "monthDayFormat", "fullDateFormat", "setData", "list", "", "appendData", "removeAt", NewTaskTracker.Param.POSITION, "getItem", "isEmpty", "", "closeOpenItem", "getItemCount", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "ViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SiteMessageAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    private final SimpleDateFormat fullDateFormat;
    private final SimpleDateFormat isoDateFormat;
    private final List<SiteMessageItem> items;
    private final SimpleDateFormat monthDayFormat;
    private final Function1<SiteMessageItem, Unit> onCtaClick;
    private final Function2<SiteMessageItem, Integer, Unit> onDeleteClick;
    private final Function2<SiteMessageItem, Integer, Unit> onItemClick;
    private final Function3<View, SiteMessageItem, Integer, Unit> onLongClick;
    private ViewHolder openViewHolder;
    private final SimpleDateFormat timeFormat;

    public /* synthetic */ SiteMessageAdapter(Function1 function1, Function2 function2, Function3 function3, Function2 function22, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function2, (i & 4) != 0 ? null : function3, (i & 8) != 0 ? null : function22);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SiteMessageAdapter(Function1<? super SiteMessageItem, Unit> function1, Function2<? super SiteMessageItem, ? super Integer, Unit> function2, Function3<? super View, ? super SiteMessageItem, ? super Integer, Unit> function3, Function2<? super SiteMessageItem, ? super Integer, Unit> function22) {
        Intrinsics.checkNotNullParameter(function1, "onCtaClick");
        Intrinsics.checkNotNullParameter(function2, "onDeleteClick");
        this.onCtaClick = function1;
        this.onDeleteClick = function2;
        this.onLongClick = function3;
        this.onItemClick = function22;
        this.items = new ArrayList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.isoDateFormat = simpleDateFormat;
        this.timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        this.monthDayFormat = new SimpleDateFormat("MM/dd", Locale.getDefault());
        this.fullDateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
    }

    public final void setData(List<SiteMessageItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        List list2 = CollectionsKt.toList(this.items);
        this.items.clear();
        this.items.addAll(list);
        DiffUtil.calculateDiff(new SiteMessageDiffCallback(list2, this.items)).dispatchUpdatesTo(this);
    }

    public final void appendData(List<SiteMessageItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        int size = this.items.size();
        this.items.addAll(list);
        notifyItemRangeInserted(size, list.size());
    }

    public final SiteMessageItem removeAt(int position) {
        if (position < 0 || position >= this.items.size()) {
            return null;
        }
        SiteMessageItem remove = this.items.remove(position);
        notifyItemRemoved(position);
        return remove;
    }

    public final SiteMessageItem getItem(int position) {
        return (SiteMessageItem) CollectionsKt.getOrNull(this.items, position);
    }

    public final boolean isEmpty() {
        return this.items.isEmpty();
    }

    public final void closeOpenItem() {
        ViewHolder viewHolder = this.openViewHolder;
        if (viewHolder != null) {
            viewHolder.animateClose();
        }
        this.openViewHolder = null;
    }

    public int getItemCount() {
        return this.items.size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(C0820R.layout.item_site_message, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new ViewHolder(this, inflate);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.items.get(position), position);
    }

    /* compiled from: SiteMessageAdapter.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0014J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0018\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;Landroid/view/View;)V", "layoutContent", "layoutSwipeActions", "btnDelete", "tvTitle", "Landroid/widget/TextView;", "tvBody", "tvTime", "btnCta", "unreadDot", "currentItem", "Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;", "swipeReveal", "Lcom/bytedance/trae/common/widget/SwipeRevealController;", "bind", "", "item", NewTaskTracker.Param.POSITION, "", "animateClose", "formatRelativeTime", "", "isoString", "isSameDay", "", "c1", "Ljava/util/Calendar;", "c2", "isYesterday", "target", "today", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView btnCta;
        private final View btnDelete;
        private SiteMessageItem currentItem;
        private final View layoutContent;
        private final View layoutSwipeActions;
        private final SwipeRevealController swipeReveal;
        final /* synthetic */ SiteMessageAdapter this$0;
        private final TextView tvBody;
        private final TextView tvTime;
        private final TextView tvTitle;
        private final View unreadDot;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(final SiteMessageAdapter siteMessageAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = siteMessageAdapter;
            View findViewById = view.findViewById(C0820R.id.layout_content);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.layoutContent = findViewById;
            View findViewById2 = view.findViewById(C0820R.id.layout_swipe_actions);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.layoutSwipeActions = findViewById2;
            View findViewById3 = view.findViewById(C0820R.id.btn_delete);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.btnDelete = findViewById3;
            View findViewById4 = view.findViewById(C0820R.id.tv_title);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.tvTitle = (TextView) findViewById4;
            View findViewById5 = view.findViewById(C0820R.id.tv_body);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
            this.tvBody = (TextView) findViewById5;
            View findViewById6 = view.findViewById(C0820R.id.tv_time);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
            this.tvTime = (TextView) findViewById6;
            View findViewById7 = view.findViewById(C0820R.id.btn_cta);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
            this.btnCta = (TextView) findViewById7;
            View findViewById8 = view.findViewById(C0820R.id.v_unread_dot);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
            this.unreadDot = findViewById8;
            SwipeRevealController swipeRevealController = new SwipeRevealController(findViewById, findViewById2, 0, 0L, 0.0f, 0.0f, new Function0() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda3
                public final Object invoke() {
                    Unit swipeReveal$lambda$0;
                    swipeReveal$lambda$0 = SiteMessageAdapter.ViewHolder.swipeReveal$lambda$0(SiteMessageAdapter.this, this);
                    return swipeReveal$lambda$0;
                }
            }, null, new Function0() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda4
                public final Object invoke() {
                    Unit swipeReveal$lambda$1;
                    swipeReveal$lambda$1 = SiteMessageAdapter.ViewHolder.swipeReveal$lambda$1(SiteMessageAdapter.this, this);
                    return swipeReveal$lambda$1;
                }
            }, new Function0() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda5
                public final Object invoke() {
                    Unit swipeReveal$lambda$2;
                    swipeReveal$lambda$2 = SiteMessageAdapter.ViewHolder.swipeReveal$lambda$2(SiteMessageAdapter.this, this);
                    return swipeReveal$lambda$2;
                }
            }, 188, null);
            this.swipeReveal = swipeRevealController;
            swipeRevealController.attachToContentWithTouch(new Function1() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda6
                public final Object invoke(Object obj) {
                    Unit _init_$lambda$4;
                    _init_$lambda$4 = SiteMessageAdapter.ViewHolder._init_$lambda$4(SiteMessageAdapter.ViewHolder.this, siteMessageAdapter, (SwipeRevealController.LongPressTouch) obj);
                    return _init_$lambda$4;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit swipeReveal$lambda$0(SiteMessageAdapter siteMessageAdapter, ViewHolder viewHolder) {
            ViewHolder viewHolder2;
            if (siteMessageAdapter.openViewHolder != null && !Intrinsics.areEqual(siteMessageAdapter.openViewHolder, viewHolder) && (viewHolder2 = siteMessageAdapter.openViewHolder) != null) {
                viewHolder2.animateClose();
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit swipeReveal$lambda$1(SiteMessageAdapter siteMessageAdapter, ViewHolder viewHolder) {
            siteMessageAdapter.openViewHolder = viewHolder;
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit swipeReveal$lambda$2(SiteMessageAdapter siteMessageAdapter, ViewHolder viewHolder) {
            if (Intrinsics.areEqual(siteMessageAdapter.openViewHolder, viewHolder)) {
                siteMessageAdapter.openViewHolder = null;
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit _init_$lambda$4(ViewHolder viewHolder, SiteMessageAdapter siteMessageAdapter, SwipeRevealController.LongPressTouch longPressTouch) {
            Function3 function3;
            Intrinsics.checkNotNullParameter(longPressTouch, "touch");
            int adapterPosition = viewHolder.getAdapterPosition();
            if (adapterPosition == -1) {
                return Unit.INSTANCE;
            }
            SiteMessageItem siteMessageItem = viewHolder.currentItem;
            if (siteMessageItem != null && (function3 = siteMessageAdapter.onLongClick) != null) {
                function3.invoke(viewHolder.layoutContent, siteMessageItem, Integer.valueOf(adapterPosition));
            }
            return Unit.INSTANCE;
        }

        public final void bind(final SiteMessageItem item, int position) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.currentItem = item;
            this.tvTitle.setText(item.getTitle());
            this.tvBody.setText(item.getBody());
            this.tvTime.setText(formatRelativeTime(item.getEffectiveTime()));
            this.unreadDot.setVisibility(Intrinsics.areEqual(item.isRead(), false) ? 0 : 8);
            String actionTitle = item.getActionTitle();
            if (!(actionTitle == null || actionTitle.length() == 0)) {
                this.btnCta.setText(actionTitle);
                this.btnCta.setVisibility(0);
                TextView textView = this.btnCta;
                final SiteMessageAdapter siteMessageAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SiteMessageAdapter.ViewHolder.bind$lambda$5(SiteMessageAdapter.this, item, view);
                    }
                });
            } else {
                this.btnCta.setVisibility(8);
                this.btnCta.setOnClickListener(null);
            }
            this.swipeReveal.reset();
            View view = this.btnDelete;
            final SiteMessageAdapter siteMessageAdapter2 = this.this$0;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SiteMessageAdapter.ViewHolder.bind$lambda$7(SiteMessageAdapter.ViewHolder.this, siteMessageAdapter2, view2);
                }
            });
            View view2 = this.layoutContent;
            final SiteMessageAdapter siteMessageAdapter3 = this.this$0;
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    SiteMessageAdapter.ViewHolder.bind$lambda$9(SiteMessageAdapter.ViewHolder.this, siteMessageAdapter3, view3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$5(SiteMessageAdapter siteMessageAdapter, SiteMessageItem siteMessageItem, View view) {
            siteMessageAdapter.onCtaClick.invoke(siteMessageItem);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$7(ViewHolder viewHolder, SiteMessageAdapter siteMessageAdapter, View view) {
            SiteMessageItem siteMessageItem;
            int adapterPosition = viewHolder.getAdapterPosition();
            if (adapterPosition == -1 || (siteMessageItem = viewHolder.currentItem) == null) {
                return;
            }
            siteMessageAdapter.onDeleteClick.invoke(siteMessageItem, Integer.valueOf(adapterPosition));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$9(ViewHolder viewHolder, SiteMessageAdapter siteMessageAdapter, View view) {
            SiteMessageItem siteMessageItem;
            Function2 function2;
            int adapterPosition = viewHolder.getAdapterPosition();
            if (adapterPosition == -1 || (siteMessageItem = viewHolder.currentItem) == null || (function2 = siteMessageAdapter.onItemClick) == null) {
                return;
            }
            function2.invoke(siteMessageItem, Integer.valueOf(adapterPosition));
        }

        public final void animateClose() {
            this.swipeReveal.animateClose();
        }

        private final String formatRelativeTime(String isoString) {
            Date date;
            String str = isoString;
            if (str == null || str.length() == 0) {
                return "";
            }
            try {
                date = this.this$0.isoDateFormat.parse(isoString);
            } catch (Exception unused) {
                date = null;
            }
            if (date == null) {
                return "";
            }
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar.setTime(date);
            Intrinsics.checkNotNull(calendar);
            Intrinsics.checkNotNull(calendar2);
            if (isSameDay(calendar, calendar2)) {
                String format = this.this$0.timeFormat.format(date);
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                return format;
            }
            if (isYesterday(calendar, calendar2)) {
                String string = this.itemView.getContext().getString(C0820R.string.trae_site_message_yesterday, this.this$0.timeFormat.format(date));
                Intrinsics.checkNotNull(string);
                return string;
            }
            if (calendar.get(1) == calendar2.get(1)) {
                String format2 = this.this$0.monthDayFormat.format(date);
                Intrinsics.checkNotNull(format2);
                return format2;
            }
            String format3 = this.this$0.fullDateFormat.format(date);
            Intrinsics.checkNotNull(format3);
            return format3;
        }

        private final boolean isSameDay(Calendar c1, Calendar c2) {
            return c1.get(1) == c2.get(1) && c1.get(6) == c2.get(6);
        }

        private final boolean isYesterday(Calendar target, Calendar today) {
            Object clone = today.clone();
            Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.Calendar");
            Calendar calendar = (Calendar) clone;
            calendar.add(6, -1);
            return isSameDay(target, calendar);
        }
    }
}
