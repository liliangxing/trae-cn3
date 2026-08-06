package com.bytedance.trae.home.solo.setting;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.common.widget.SwipeRevealController;
import com.bytedance.trae.common.widget.SwipeRevealGestureState;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.devices.DeviceProductType;
import com.bytedance.trae.conversation.devices.DeviceStatusLabelPolicy;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsDeviceAdapter.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u0000 &2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002&'B\u00ad\u0001\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012$\u0010\u0007\u001a \u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\b\u0012-\u0010\u000b\u001a)\u0012\u0004\u0012\u00020\u0002\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00060\f\u0012-\u0010\u0011\u001a)\u0012\u0004\u0012\u00020\u0002\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00060\f\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u001c\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u001c\u0010!\u001a\u00020\u00062\n\u0010\"\u001a\u00060\u0003R\u00020\u00002\u0006\u0010#\u001a\u00020 H\u0016J\u0006\u0010$\u001a\u00020\u0017J\u0006\u0010%\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0007\u001a \u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R5\u0010\u000b\u001a)\u0012\u0004\u0012\u00020\u0002\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00060\fX\u0082\u0004¢\u0006\u0002\n\u0000R5\u0010\u0011\u001a)\u0012\u0004\u0012\u00020\u0002\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00060\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0018\u00010\u0003R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;", "Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;", "onUnpairedDeviceClick", "Lkotlin/Function1;", "", "onLongPress", "Lkotlin/Function4;", "Landroid/view/View;", "", "onRenameClick", "Lkotlin/Function2;", "Lkotlin/Function0;", "Lkotlin/ParameterName;", "name", "closeAction", "onUnbindClick", "onUnsupportedAction", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "openViewHolder", "showProductType", "", "getShowProductType", "()Z", "setShowProductType", "(Z)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", NewTaskTracker.Param.POSITION, "hasOpenItem", "closeOpenItem", "Companion", "DeviceViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsDeviceAdapter extends ListAdapter<SettingsDeviceItem, DeviceViewHolder> {
    private final Function4<SettingsDeviceItem, View, Float, Float, Unit> onLongPress;
    private final Function2<SettingsDeviceItem, Function0<Unit>, Unit> onRenameClick;
    private final Function2<SettingsDeviceItem, Function0<Unit>, Unit> onUnbindClick;
    private final Function1<SettingsDeviceItem, Unit> onUnpairedDeviceClick;
    private final Function0<Unit> onUnsupportedAction;
    private DeviceViewHolder openViewHolder;
    private boolean showProductType;
    public static final int $stable = 8;
    private static final SettingsDeviceAdapter$Companion$DiffCallback$1 DiffCallback = new DiffUtil.ItemCallback<SettingsDeviceItem>() { // from class: com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$Companion$DiffCallback$1
        public boolean areItemsTheSame(SettingsDeviceItem oldItem, SettingsDeviceItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getId(), newItem.getId());
        }

        public boolean areContentsTheSame(SettingsDeviceItem oldItem, SettingsDeviceItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SettingsDeviceAdapter(Function1<? super SettingsDeviceItem, Unit> function1, Function4<? super SettingsDeviceItem, ? super View, ? super Float, ? super Float, Unit> function4, Function2<? super SettingsDeviceItem, ? super Function0<Unit>, Unit> function2, Function2<? super SettingsDeviceItem, ? super Function0<Unit>, Unit> function22, Function0<Unit> function0) {
        super(DiffCallback);
        Intrinsics.checkNotNullParameter(function1, "onUnpairedDeviceClick");
        Intrinsics.checkNotNullParameter(function4, "onLongPress");
        Intrinsics.checkNotNullParameter(function2, "onRenameClick");
        Intrinsics.checkNotNullParameter(function22, "onUnbindClick");
        Intrinsics.checkNotNullParameter(function0, "onUnsupportedAction");
        this.onUnpairedDeviceClick = function1;
        this.onLongPress = function4;
        this.onRenameClick = function2;
        this.onUnbindClick = function22;
        this.onUnsupportedAction = function0;
        this.showProductType = true;
    }

    public final boolean getShowProductType() {
        return this.showProductType;
    }

    public final void setShowProductType(boolean z) {
        this.showProductType = z;
    }

    public DeviceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(C0820R.layout.item_settings_device, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new DeviceViewHolder(this, inflate);
    }

    public void onBindViewHolder(DeviceViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Object item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind((SettingsDeviceItem) item);
    }

    public final boolean hasOpenItem() {
        return this.openViewHolder != null;
    }

    public final void closeOpenItem() {
        DeviceViewHolder deviceViewHolder = this.openViewHolder;
        if (deviceViewHolder != null) {
            deviceViewHolder.animateClose();
        }
        this.openViewHolder = null;
    }

    /* compiled from: SettingsDeviceAdapter.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0003J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0006\u0010!\u001a\u00020\u0019J\b\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020\u0019H\u0002J\b\u0010$\u001a\u00020\u0019H\u0002J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'H\u0002R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;Landroid/view/View;)V", "layoutContent", "layoutSwipeActions", "btnRename", "btnUnbind", "tvName", "Landroid/widget/TextView;", "llProductType", "Landroid/widget/LinearLayout;", "tvProductType", "tvStatus", "ivIcon", "Landroid/widget/ImageView;", "currentItem", "Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;", "unsupportedActionGestureState", "Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;", "swipeReveal", "Lcom/bytedance/trae/common/widget/SwipeRevealController;", "bind", "", "item", "configureActions", "enabled", "", "handleUnsupportedActionTouch", Fields.EVENT, "Landroid/view/MotionEvent;", "animateClose", "enableContentTapToClose", "disableContentTap", "resetSwipe", "bindProductType", "productType", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public final class DeviceViewHolder extends RecyclerView.ViewHolder {
        private final View btnRename;
        private final View btnUnbind;
        private SettingsDeviceItem currentItem;
        private final ImageView ivIcon;
        private final View layoutContent;
        private final View layoutSwipeActions;
        private final LinearLayout llProductType;
        private final SwipeRevealController swipeReveal;
        final /* synthetic */ SettingsDeviceAdapter this$0;
        private final TextView tvName;
        private final TextView tvProductType;
        private final TextView tvStatus;
        private final SwipeRevealGestureState unsupportedActionGestureState;

        /* compiled from: SettingsDeviceAdapter.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[DeviceProductType.values().length];
                try {
                    iArr[DeviceProductType.WORK.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DeviceProductType.IDE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeviceViewHolder(final SettingsDeviceAdapter settingsDeviceAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = settingsDeviceAdapter;
            View findViewById = view.findViewById(C0820R.id.layout_content);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.layoutContent = findViewById;
            View findViewById2 = view.findViewById(C0820R.id.layout_swipe_actions);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.layoutSwipeActions = findViewById2;
            View findViewById3 = view.findViewById(C0820R.id.btn_rename);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.btnRename = findViewById3;
            View findViewById4 = view.findViewById(C0820R.id.btn_delete);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.btnUnbind = findViewById4;
            View findViewById5 = view.findViewById(C0820R.id.tv_device_name);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
            this.tvName = (TextView) findViewById5;
            View findViewById6 = view.findViewById(C0820R.id.ll_product_type);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
            this.llProductType = (LinearLayout) findViewById6;
            View findViewById7 = view.findViewById(C0820R.id.tv_product_type);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
            this.tvProductType = (TextView) findViewById7;
            View findViewById8 = view.findViewById(C0820R.id.tv_device_status);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
            this.tvStatus = (TextView) findViewById8;
            View findViewById9 = view.findViewById(C0820R.id.iv_device_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
            this.ivIcon = (ImageView) findViewById9;
            this.unsupportedActionGestureState = new SwipeRevealGestureState(ViewConfiguration.get(view.getContext()).getScaledTouchSlop(), 1.0f);
            this.swipeReveal = new SwipeRevealController(findViewById, findViewById2, 0, 0L, 0.0f, 0.0f, new Function0() { // from class: com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda6
                public final Object invoke() {
                    Unit swipeReveal$lambda$0;
                    swipeReveal$lambda$0 = SettingsDeviceAdapter.DeviceViewHolder.swipeReveal$lambda$0(SettingsDeviceAdapter.this, this);
                    return swipeReveal$lambda$0;
                }
            }, null, new Function0() { // from class: com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda7
                public final Object invoke() {
                    Unit swipeReveal$lambda$1;
                    swipeReveal$lambda$1 = SettingsDeviceAdapter.DeviceViewHolder.swipeReveal$lambda$1(SettingsDeviceAdapter.this, this);
                    return swipeReveal$lambda$1;
                }
            }, new Function0() { // from class: com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda8
                public final Object invoke() {
                    Unit swipeReveal$lambda$2;
                    swipeReveal$lambda$2 = SettingsDeviceAdapter.DeviceViewHolder.swipeReveal$lambda$2(SettingsDeviceAdapter.this, this);
                    return swipeReveal$lambda$2;
                }
            }, 188, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit swipeReveal$lambda$0(SettingsDeviceAdapter settingsDeviceAdapter, DeviceViewHolder deviceViewHolder) {
            DeviceViewHolder deviceViewHolder2;
            if (settingsDeviceAdapter.openViewHolder != null && !Intrinsics.areEqual(settingsDeviceAdapter.openViewHolder, deviceViewHolder) && (deviceViewHolder2 = settingsDeviceAdapter.openViewHolder) != null) {
                deviceViewHolder2.animateClose();
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit swipeReveal$lambda$1(SettingsDeviceAdapter settingsDeviceAdapter, DeviceViewHolder deviceViewHolder) {
            settingsDeviceAdapter.openViewHolder = deviceViewHolder;
            deviceViewHolder.enableContentTapToClose();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit swipeReveal$lambda$2(SettingsDeviceAdapter settingsDeviceAdapter, DeviceViewHolder deviceViewHolder) {
            if (Intrinsics.areEqual(settingsDeviceAdapter.openViewHolder, deviceViewHolder)) {
                settingsDeviceAdapter.openViewHolder = null;
            }
            deviceViewHolder.disableContentTap();
            return Unit.INSTANCE;
        }

        public final void bind(SettingsDeviceItem item) {
            int i;
            Intrinsics.checkNotNullParameter(item, "item");
            this.currentItem = item;
            this.tvName.setText(item.getName());
            if (this.this$0.getShowProductType()) {
                this.llProductType.setVisibility(0);
                bindProductType(item.getProductType());
            } else {
                this.llProductType.setVisibility(8);
            }
            this.tvStatus.setText(DeviceStatusLabelPolicy.INSTANCE.resolve(item.isOnline(), item.isPaired()).getTextRes());
            ImageView imageView = this.ivIcon;
            if (item.isOnline()) {
                i = C0820R.drawable.ic_setting_computer_screen;
            } else {
                i = C0820R.drawable.ic_setting_computer_screen_offline;
            }
            imageView.setImageResource(i);
            if (!item.isPaired()) {
                this.tvStatus.setBackgroundResource(C0820R.drawable.bg_setting_device_status_unpaired);
                this.tvStatus.setTextColor(ContextCompat.getColor(this.itemView.getContext(), C0591R.color.trae_special_white));
            } else if (item.isOnline()) {
                this.tvStatus.setBackgroundResource(C0820R.drawable.bg_setting_device_status_online);
                this.tvStatus.setTextColor(ContextCompat.getColor(this.itemView.getContext(), C0591R.color.trae_text_text_white));
            } else {
                this.tvStatus.setBackgroundResource(C0820R.drawable.bg_setting_device_status_offline);
                this.tvStatus.setTextColor(ContextCompat.getColor(this.itemView.getContext(), C0820R.color.trae_setting_device_status_offline_text));
            }
            resetSwipe();
            configureActions(item.isPaired());
            if (item.isPaired()) {
                this.layoutContent.setOnClickListener(null);
                this.layoutContent.setClickable(false);
                this.layoutContent.setFocusable(false);
            } else {
                View view = this.layoutContent;
                final SettingsDeviceAdapter settingsDeviceAdapter = this.this$0;
                view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        SettingsDeviceAdapter.DeviceViewHolder.bind$lambda$4(SettingsDeviceAdapter.DeviceViewHolder.this, settingsDeviceAdapter, view2);
                    }
                });
            }
            if (item.isPaired()) {
                View view2 = this.btnRename;
                final SettingsDeviceAdapter settingsDeviceAdapter2 = this.this$0;
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        SettingsDeviceAdapter.DeviceViewHolder.bind$lambda$7(SettingsDeviceAdapter.DeviceViewHolder.this, settingsDeviceAdapter2, view3);
                    }
                });
                View view3 = this.btnUnbind;
                final SettingsDeviceAdapter settingsDeviceAdapter3 = this.this$0;
                view3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        SettingsDeviceAdapter.DeviceViewHolder.bind$lambda$11(SettingsDeviceAdapter.DeviceViewHolder.this, settingsDeviceAdapter3, view4);
                    }
                });
                return;
            }
            this.btnRename.setOnClickListener(null);
            this.btnUnbind.setOnClickListener(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$4(DeviceViewHolder deviceViewHolder, SettingsDeviceAdapter settingsDeviceAdapter, View view) {
            SettingsDeviceItem settingsDeviceItem = deviceViewHolder.currentItem;
            if (settingsDeviceItem != null) {
                if (!(!settingsDeviceItem.isPaired())) {
                    settingsDeviceItem = null;
                }
                if (settingsDeviceItem != null) {
                    settingsDeviceAdapter.onUnpairedDeviceClick.invoke(settingsDeviceItem);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$7(final DeviceViewHolder deviceViewHolder, SettingsDeviceAdapter settingsDeviceAdapter, View view) {
            SettingsDeviceItem settingsDeviceItem = deviceViewHolder.currentItem;
            if (settingsDeviceItem != null) {
                if (!settingsDeviceItem.isPaired()) {
                    settingsDeviceItem = null;
                }
                if (settingsDeviceItem != null) {
                    settingsDeviceAdapter.onRenameClick.invoke(settingsDeviceItem, new Function0() { // from class: com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit bind$lambda$7$lambda$6$lambda$5;
                            bind$lambda$7$lambda$6$lambda$5 = SettingsDeviceAdapter.DeviceViewHolder.bind$lambda$7$lambda$6$lambda$5(SettingsDeviceAdapter.DeviceViewHolder.this);
                            return bind$lambda$7$lambda$6$lambda$5;
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit bind$lambda$7$lambda$6$lambda$5(DeviceViewHolder deviceViewHolder) {
            deviceViewHolder.animateClose();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$11(final DeviceViewHolder deviceViewHolder, SettingsDeviceAdapter settingsDeviceAdapter, View view) {
            SettingsDeviceItem settingsDeviceItem = deviceViewHolder.currentItem;
            if (settingsDeviceItem != null) {
                if (!settingsDeviceItem.isPaired()) {
                    settingsDeviceItem = null;
                }
                if (settingsDeviceItem != null) {
                    settingsDeviceAdapter.onUnbindClick.invoke(settingsDeviceItem, new Function0() { // from class: com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda9
                        public final Object invoke() {
                            Unit bind$lambda$11$lambda$10$lambda$9;
                            bind$lambda$11$lambda$10$lambda$9 = SettingsDeviceAdapter.DeviceViewHolder.bind$lambda$11$lambda$10$lambda$9(SettingsDeviceAdapter.DeviceViewHolder.this);
                            return bind$lambda$11$lambda$10$lambda$9;
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit bind$lambda$11$lambda$10$lambda$9(DeviceViewHolder deviceViewHolder) {
            deviceViewHolder.animateClose();
            return Unit.INSTANCE;
        }

        private final void configureActions(boolean enabled) {
            if (enabled) {
                SwipeRevealController swipeRevealController = this.swipeReveal;
                final SettingsDeviceAdapter settingsDeviceAdapter = this.this$0;
                swipeRevealController.attachToContentWithTouch(new Function1() { // from class: com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj) {
                        Unit configureActions$lambda$14;
                        configureActions$lambda$14 = SettingsDeviceAdapter.DeviceViewHolder.configureActions$lambda$14(SettingsDeviceAdapter.DeviceViewHolder.this, settingsDeviceAdapter, (SwipeRevealController.LongPressTouch) obj);
                        return configureActions$lambda$14;
                    }
                });
            } else {
                this.layoutSwipeActions.setVisibility(8);
                this.unsupportedActionGestureState.setClosed();
                this.layoutContent.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda11
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        boolean configureActions$lambda$15;
                        configureActions$lambda$15 = SettingsDeviceAdapter.DeviceViewHolder.configureActions$lambda$15(SettingsDeviceAdapter.DeviceViewHolder.this, view, motionEvent);
                        return configureActions$lambda$15;
                    }
                });
                View view = this.layoutContent;
                final SettingsDeviceAdapter settingsDeviceAdapter2 = this.this$0;
                view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view2) {
                        boolean configureActions$lambda$16;
                        configureActions$lambda$16 = SettingsDeviceAdapter.DeviceViewHolder.configureActions$lambda$16(SettingsDeviceAdapter.DeviceViewHolder.this, settingsDeviceAdapter2, view2);
                        return configureActions$lambda$16;
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit configureActions$lambda$14(DeviceViewHolder deviceViewHolder, SettingsDeviceAdapter settingsDeviceAdapter, SwipeRevealController.LongPressTouch longPressTouch) {
            Intrinsics.checkNotNullParameter(longPressTouch, "touch");
            SettingsDeviceItem settingsDeviceItem = deviceViewHolder.currentItem;
            if (settingsDeviceItem != null) {
                if (!settingsDeviceItem.isPaired()) {
                    settingsDeviceItem = null;
                }
                if (settingsDeviceItem != null) {
                    settingsDeviceAdapter.onLongPress.invoke(settingsDeviceItem, deviceViewHolder.layoutContent, Float.valueOf(longPressTouch.getRawX()), Float.valueOf(longPressTouch.getRawY()));
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean configureActions$lambda$15(DeviceViewHolder deviceViewHolder, View view, MotionEvent motionEvent) {
            Intrinsics.checkNotNull(motionEvent);
            return deviceViewHolder.handleUnsupportedActionTouch(motionEvent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean configureActions$lambda$16(DeviceViewHolder deviceViewHolder, SettingsDeviceAdapter settingsDeviceAdapter, View view) {
            SettingsDeviceItem settingsDeviceItem = deviceViewHolder.currentItem;
            boolean z = false;
            if (settingsDeviceItem != null && !settingsDeviceItem.isPaired()) {
                z = true;
            }
            if (z) {
                settingsDeviceAdapter.onUnsupportedAction.invoke();
            }
            return true;
        }

        private final boolean handleUnsupportedActionTouch(MotionEvent event) {
            int actionMasked = event.getActionMasked();
            boolean z = false;
            if (actionMasked == 0) {
                this.unsupportedActionGestureState.onDown(event.getRawX(), event.getRawY());
                return false;
            }
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    SwipeRevealGestureState.MoveResult onMove = this.unsupportedActionGestureState.onMove(event.getRawX(), event.getRawY(), 0.0f);
                    if (onMove.getDragStarted()) {
                        SettingsDeviceItem settingsDeviceItem = this.currentItem;
                        if (settingsDeviceItem != null && !settingsDeviceItem.isPaired()) {
                            z = true;
                        }
                        if (z) {
                            this.layoutContent.cancelLongPress();
                            this.this$0.onUnsupportedAction.invoke();
                        }
                    }
                    return onMove.isDragging();
                }
                if (actionMasked != 3) {
                    return this.unsupportedActionGestureState.getIsDragging();
                }
            }
            return this.unsupportedActionGestureState.onRelease(0.0f).getWasDragging();
        }

        public final void animateClose() {
            this.swipeReveal.animateClose();
        }

        private final void enableContentTapToClose() {
            this.layoutContent.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SettingsDeviceAdapter.DeviceViewHolder.this.animateClose();
                }
            });
        }

        private final void disableContentTap() {
            this.layoutContent.setOnClickListener(null);
            this.layoutContent.setClickable(false);
            this.layoutContent.setFocusable(false);
        }

        private final void resetSwipe() {
            this.swipeReveal.reset();
        }

        private final void bindProductType(DeviceProductType productType) {
            int i = WhenMappings.$EnumSwitchMapping$0[productType.ordinal()];
            if (i == 1) {
                this.tvProductType.setText(this.itemView.getContext().getString(C0637R.string.trae_device_add_target_work));
                this.tvProductType.setBackgroundResource(C0637R.drawable.trae_bg_product_type_work);
                this.tvProductType.setTextColor(ContextCompat.getColor(this.itemView.getContext(), C0591R.color.trae_brand_brand_700));
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                this.tvProductType.setText(this.itemView.getContext().getString(C0637R.string.trae_device_add_target_ide));
                this.tvProductType.setBackgroundResource(C0637R.drawable.trae_bg_product_type_ide);
                this.tvProductType.setTextColor(ContextCompat.getColor(this.itemView.getContext(), C0591R.color.trae_brand_trae_green_900));
            }
        }
    }
}
