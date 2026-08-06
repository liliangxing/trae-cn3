package com.bytedance.trae.conversation.devices;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.devices.CodeDeviceItemAdapter;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.im.service.CliType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CodeDeviceItemAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u001d\u001e\u001fB-\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0014H\u0016J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0014H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000e¨\u0006 "}, d2 = {"Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/bytedance/trae/conversation/devices/DeviceItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onLocationClick", "Lkotlin/Function1;", "", "onAddDeviceClick", "Lkotlin/Function0;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "showProductType", "", "getShowProductType", "()Z", "setShowProductType", "(Z)V", "hasFooter", "getHasFooter", "getItemCount", "", "getItemViewType", NewTaskTracker.Param.POSITION, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "Companion", "AddDeviceViewHolder", "DeviceViewHolder", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CodeDeviceItemAdapter extends ListAdapter<DeviceItem, RecyclerView.ViewHolder> {
    private static final CodeDeviceItemAdapter$Companion$DiffCallback$1 DiffCallback = new DiffUtil.ItemCallback<DeviceItem>() { // from class: com.bytedance.trae.conversation.devices.CodeDeviceItemAdapter$Companion$DiffCallback$1
        public boolean areItemsTheSame(DeviceItem oldItem, DeviceItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getId(), newItem.getId());
        }

        public boolean areContentsTheSame(DeviceItem oldItem, DeviceItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };
    private static final int VIEW_TYPE_ADD_DEVICE = 1;
    private static final int VIEW_TYPE_DEVICE = 0;
    private final Function0<Unit> onAddDeviceClick;
    private final Function1<DeviceItem, Unit> onLocationClick;
    private boolean showProductType;

    public /* synthetic */ CodeDeviceItemAdapter(Function1 function1, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i & 2) != 0 ? null : function0);
    }

    public static final /* synthetic */ DeviceItem access$getItem(CodeDeviceItemAdapter codeDeviceItemAdapter, int i) {
        return (DeviceItem) codeDeviceItemAdapter.getItem(i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CodeDeviceItemAdapter(Function1<? super DeviceItem, Unit> function1, Function0<Unit> function0) {
        super(DiffCallback);
        Intrinsics.checkNotNullParameter(function1, "onLocationClick");
        this.onLocationClick = function1;
        this.onAddDeviceClick = function0;
    }

    public final boolean getShowProductType() {
        return this.showProductType;
    }

    public final void setShowProductType(boolean z) {
        this.showProductType = z;
    }

    private final boolean getHasFooter() {
        return this.onAddDeviceClick != null;
    }

    public int getItemCount() {
        int itemCount = super.getItemCount();
        return getHasFooter() ? itemCount + 1 : itemCount;
    }

    public int getItemViewType(int position) {
        return (getHasFooter() && position == super.getItemCount()) ? 1 : 0;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        if (viewType == 1) {
            View inflate = from.inflate(C0637R.layout.trae_item_code_device_add, parent, false);
            Intrinsics.checkNotNull(inflate);
            return new AddDeviceViewHolder(this, inflate);
        }
        View inflate2 = from.inflate(C0637R.layout.trae_item_code_device, parent, false);
        Intrinsics.checkNotNull(inflate2);
        return new DeviceViewHolder(this, inflate2);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof DeviceViewHolder) {
            Object item = getItem(position);
            Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
            ((DeviceViewHolder) holder).bind((DeviceItem) item);
        }
    }

    /* compiled from: CodeDeviceItemAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter$AddDeviceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;Landroid/view/View;)V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public final class AddDeviceViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ CodeDeviceItemAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddDeviceViewHolder(final CodeDeviceItemAdapter codeDeviceItemAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = codeDeviceItemAdapter;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.devices.CodeDeviceItemAdapter$AddDeviceViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CodeDeviceItemAdapter.AddDeviceViewHolder._init_$lambda$0(CodeDeviceItemAdapter.this, view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$0(CodeDeviceItemAdapter codeDeviceItemAdapter, View view) {
            Function0 function0 = codeDeviceItemAdapter.onAddDeviceClick;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    /* compiled from: CodeDeviceItemAdapter.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter$DeviceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;Landroid/view/View;)V", "ivIcon", "Landroid/widget/ImageView;", "tvName", "Landroid/widget/TextView;", "llProductType", "Landroid/widget/LinearLayout;", "tvProductType", "tvStatus", "ivRadio", "bind", "", "location", "Lcom/bytedance/trae/conversation/devices/DeviceItem;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public final class DeviceViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivIcon;
        private final ImageView ivRadio;
        private final LinearLayout llProductType;
        final /* synthetic */ CodeDeviceItemAdapter this$0;
        private final TextView tvName;
        private final TextView tvProductType;
        private final TextView tvStatus;

        /* compiled from: CodeDeviceItemAdapter.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CliType.values().length];
                try {
                    iArr[CliType.LOCAL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[CliType.IDE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeviceViewHolder(final CodeDeviceItemAdapter codeDeviceItemAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = codeDeviceItemAdapter;
            View findViewById = view.findViewById(C0637R.id.iv_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.ivIcon = (ImageView) findViewById;
            View findViewById2 = view.findViewById(C0637R.id.tv_name);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.tvName = (TextView) findViewById2;
            View findViewById3 = view.findViewById(C0637R.id.ll_product_type);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.llProductType = (LinearLayout) findViewById3;
            View findViewById4 = view.findViewById(C0637R.id.tv_product_type);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.tvProductType = (TextView) findViewById4;
            View findViewById5 = view.findViewById(C0637R.id.tv_status);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
            this.tvStatus = (TextView) findViewById5;
            View findViewById6 = view.findViewById(C0637R.id.iv_radio);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
            this.ivRadio = (ImageView) findViewById6;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.devices.CodeDeviceItemAdapter$DeviceViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CodeDeviceItemAdapter.DeviceViewHolder._init_$lambda$0(CodeDeviceItemAdapter.DeviceViewHolder.this, codeDeviceItemAdapter, view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$0(DeviceViewHolder deviceViewHolder, CodeDeviceItemAdapter codeDeviceItemAdapter, View view) {
            int bindingAdapterPosition = deviceViewHolder.getBindingAdapterPosition();
            if (bindingAdapterPosition == -1 || bindingAdapterPosition >= codeDeviceItemAdapter.getCurrentList().size()) {
                return;
            }
            Function1 function1 = codeDeviceItemAdapter.onLocationClick;
            DeviceItem access$getItem = CodeDeviceItemAdapter.access$getItem(codeDeviceItemAdapter, bindingAdapterPosition);
            Intrinsics.checkNotNullExpressionValue(access$getItem, "access$getItem(...)");
            function1.invoke(access$getItem);
        }

        public final void bind(DeviceItem location) {
            int i;
            int i2;
            Intrinsics.checkNotNullParameter(location, "location");
            View findViewById = this.itemView.findViewById(C0637R.id.ll_container);
            if (location.isSelected()) {
                findViewById.setBackgroundResource(C0637R.drawable.trae_bg_task_location_item_selected);
            } else {
                findViewById.setBackgroundResource(C0637R.drawable.trae_bg_task_location_item_unselected);
            }
            if (location.isSelected()) {
                i = C0637R.drawable.ic_device_selected;
            } else if (location.getType() == CliType.REMOTE || location.isOnline()) {
                i = C0637R.drawable.radio_unselected;
            } else {
                i = C0637R.drawable.ic_device_offline;
            }
            this.ivRadio.setImageResource(i);
            if (location.getType() == CliType.REMOTE) {
                i2 = C0637R.drawable.ic_device_select_remote;
            } else {
                i2 = ((location.getType() == CliType.LOCAL || location.getType() == CliType.IDE) && location.isOnline()) ? C0637R.drawable.ic_device_computer_online : C0637R.drawable.ic_device_comptuer_offline;
            }
            this.ivIcon.setImageResource(i2);
            this.tvName.setText(location.getName());
            if (this.this$0.getShowProductType()) {
                int i3 = WhenMappings.$EnumSwitchMapping$0[location.getType().ordinal()];
                if (i3 == 1) {
                    this.llProductType.setVisibility(0);
                    this.tvProductType.setText("TRAE Work");
                    this.tvProductType.setBackgroundResource(C0637R.drawable.trae_bg_trae_work);
                    this.tvProductType.setTextColor(ContextCompat.getColor(this.itemView.getContext(), C0637R.color.trae_product_type_work_text));
                } else if (i3 == 2) {
                    this.llProductType.setVisibility(0);
                    this.tvProductType.setText("TRAE IDE");
                    this.tvProductType.setBackgroundResource(C0637R.drawable.trae_bg_trae_ide);
                    this.tvProductType.setTextColor(ContextCompat.getColor(this.itemView.getContext(), C0637R.color.trae_product_type_ide_text));
                } else {
                    this.llProductType.setVisibility(8);
                }
            } else {
                this.llProductType.setVisibility(8);
            }
            if (CodeDeviceItemAdapterKt.shouldShowStatusChip(location)) {
                this.tvStatus.setVisibility(0);
                this.tvStatus.setText(DeviceStatusLabelPolicy.INSTANCE.resolve(location.isOnline(), location.isPaired()).getTextRes());
                if (!location.isPaired()) {
                    this.tvStatus.setBackgroundResource(C0637R.drawable.trae_bg_task_location_status_unpaired);
                    this.tvStatus.setTextColor(this.itemView.getContext().getColor(C0591R.color.trae_special_white));
                    return;
                } else if (location.isOnline()) {
                    this.tvStatus.setBackgroundResource(C0637R.drawable.trae_bg_task_location_status_online);
                    this.tvStatus.setTextColor(this.itemView.getContext().getColor(C0591R.color.trae_special_white));
                    return;
                } else {
                    this.tvStatus.setBackgroundResource(C0637R.drawable.trae_bg_task_location_status_offline);
                    this.tvStatus.setTextColor(this.itemView.getContext().getColor(C0591R.color.trae_text_text_secondary));
                    return;
                }
            }
            this.tvStatus.setVisibility(8);
        }
    }
}
