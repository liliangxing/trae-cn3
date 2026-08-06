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
import com.bytedance.trae.conversation.devices.DeviceItemAdapter;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.im.service.CliType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceItemAdapter.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00172\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0017\u0018B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001c\u0010\u0014\u001a\u00020\u00062\n\u0010\u0015\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0013H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/bytedance/trae/conversation/devices/DeviceItem;", "Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;", "onLocationClick", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "showProductType", "", "getShowProductType", "()Z", "setShowProductType", "(Z)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", NewTaskTracker.Param.POSITION, "Companion", "LocationViewHolder", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceItemAdapter extends ListAdapter<DeviceItem, LocationViewHolder> {
    private static final DeviceItemAdapter$Companion$DiffCallback$1 DiffCallback = new DiffUtil.ItemCallback<DeviceItem>() { // from class: com.bytedance.trae.conversation.devices.DeviceItemAdapter$Companion$DiffCallback$1
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
    private final Function1<DeviceItem, Unit> onLocationClick;
    private boolean showProductType;

    public static final /* synthetic */ DeviceItem access$getItem(DeviceItemAdapter deviceItemAdapter, int i) {
        return (DeviceItem) deviceItemAdapter.getItem(i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DeviceItemAdapter(Function1<? super DeviceItem, Unit> function1) {
        super(DiffCallback);
        Intrinsics.checkNotNullParameter(function1, "onLocationClick");
        this.onLocationClick = function1;
    }

    public final boolean getShowProductType() {
        return this.showProductType;
    }

    public final void setShowProductType(boolean z) {
        this.showProductType = z;
    }

    public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(C0637R.layout.trae_item_task_location, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new LocationViewHolder(this, inflate);
    }

    public void onBindViewHolder(LocationViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Object item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind((DeviceItem) item);
    }

    /* compiled from: DeviceItemAdapter.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter;Landroid/view/View;)V", "ivIcon", "Landroid/widget/ImageView;", "tvName", "Landroid/widget/TextView;", "llProductType", "Landroid/widget/LinearLayout;", "tvProductType", "tvStatus", "ivRadio", "bind", "", "location", "Lcom/bytedance/trae/conversation/devices/DeviceItem;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public final class LocationViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivIcon;
        private final ImageView ivRadio;
        private final LinearLayout llProductType;
        final /* synthetic */ DeviceItemAdapter this$0;
        private final TextView tvName;
        private final TextView tvProductType;
        private final TextView tvStatus;

        /* compiled from: DeviceItemAdapter.kt */
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
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LocationViewHolder(final DeviceItemAdapter deviceItemAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = deviceItemAdapter;
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
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.devices.DeviceItemAdapter$LocationViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DeviceItemAdapter.LocationViewHolder._init_$lambda$0(DeviceItemAdapter.LocationViewHolder.this, deviceItemAdapter, view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$0(LocationViewHolder locationViewHolder, DeviceItemAdapter deviceItemAdapter, View view) {
            int adapterPosition = locationViewHolder.getAdapterPosition();
            if (adapterPosition != -1) {
                Function1 function1 = deviceItemAdapter.onLocationClick;
                DeviceItem access$getItem = DeviceItemAdapter.access$getItem(deviceItemAdapter, adapterPosition);
                Intrinsics.checkNotNullExpressionValue(access$getItem, "access$getItem(...)");
                function1.invoke(access$getItem);
            }
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
                i = C0637R.drawable.ic_device_online;
            } else {
                i = C0637R.drawable.ic_device_offline;
            }
            this.ivRadio.setImageResource(i);
            if (location.getType() == CliType.LOCAL && location.isOnline()) {
                i2 = C0637R.drawable.ic_device_computer_online;
            } else {
                i2 = (location.getType() != CliType.LOCAL || location.isOnline()) ? C0637R.drawable.ic_device_select_remote : C0637R.drawable.ic_device_comptuer_offline;
            }
            this.ivIcon.setImageResource(i2);
            this.tvName.setText(location.getName());
            if (this.this$0.getShowProductType()) {
                if (WhenMappings.$EnumSwitchMapping$0[location.getType().ordinal()] == 1) {
                    this.llProductType.setVisibility(0);
                    this.tvProductType.setText("TRAE Work");
                    this.tvProductType.setBackgroundResource(C0637R.drawable.trae_bg_trae_work);
                    this.tvProductType.setTextColor(ContextCompat.getColor(this.itemView.getContext(), C0637R.color.trae_product_type_work_text));
                } else {
                    this.llProductType.setVisibility(8);
                }
            } else {
                this.llProductType.setVisibility(8);
            }
            if (location.getType() == CliType.LOCAL) {
                this.tvStatus.setVisibility(0);
                this.tvStatus.setText(DeviceStatusLabelPolicy.INSTANCE.resolve(location.isOnline(), location.isPaired()).getTextRes());
                if (!location.isPaired()) {
                    this.tvStatus.setBackgroundResource(C0637R.drawable.trae_bg_task_location_status_unpaired);
                    this.tvStatus.setTextColor(ContextCompat.getColor(this.itemView.getContext(), C0591R.color.trae_special_white));
                    return;
                } else if (location.isOnline()) {
                    this.tvStatus.setBackgroundResource(C0637R.drawable.trae_bg_task_location_status_online);
                    this.tvStatus.setTextColor(ContextCompat.getColor(this.itemView.getContext(), C0591R.color.trae_text_text_white));
                    return;
                } else {
                    this.tvStatus.setBackgroundResource(C0637R.drawable.trae_bg_task_location_status_offline);
                    this.tvStatus.setTextColor(ContextCompat.getColor(this.itemView.getContext(), C0591R.color.trae_text_text_secondary));
                    return;
                }
            }
            this.tvStatus.setVisibility(8);
        }
    }
}
