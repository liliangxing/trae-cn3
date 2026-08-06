package com.bytedance.trae.home.solo.setting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.login.api.LoginDeviceInfo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DebugLoginDevicesAdapter.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000f\u0010B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/bytedance/trae/login/api/LoginDeviceInfo;", "Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;", "<init>", "()V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", NewTaskTracker.Param.POSITION, "DeviceViewHolder", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DebugLoginDevicesAdapter extends ListAdapter<LoginDeviceInfo, DeviceViewHolder> {
    public static final int $stable = 0;
    private static final DebugLoginDevicesAdapter$Companion$DiffCallback$1 DiffCallback = new DiffUtil.ItemCallback<LoginDeviceInfo>() { // from class: com.bytedance.trae.home.solo.setting.DebugLoginDevicesAdapter$Companion$DiffCallback$1
        public boolean areItemsTheSame(LoginDeviceInfo oldItem, LoginDeviceInfo newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getDeviceId(), newItem.getDeviceId()) && Intrinsics.areEqual(oldItem.getDeviceName(), newItem.getDeviceName());
        }

        public boolean areContentsTheSame(LoginDeviceInfo oldItem, LoginDeviceInfo newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    public DebugLoginDevicesAdapter() {
        super(DiffCallback);
    }

    public DeviceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(C0820R.layout.item_debug_login_device, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new DeviceViewHolder(inflate);
    }

    public void onBindViewHolder(DeviceViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Object item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind((LoginDeviceInfo) item);
    }

    /* compiled from: DebugLoginDevicesAdapter.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u001a\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "ivIcon", "Landroid/widget/ImageView;", "tvName", "Landroid/widget/TextView;", "tvCurrent", "tvMeta", "tvProducts", "tvFirstBound", "tvLastActive", "formatter", "Ljava/text/SimpleDateFormat;", "bind", "", "item", "Lcom/bytedance/trae/login/api/LoginDeviceInfo;", "setOptionalText", "view", "text", "", "formatTime", ReportConstant.COMMON_TIMESTAMP, "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class DeviceViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final SimpleDateFormat formatter;
        private final ImageView ivIcon;
        private final TextView tvCurrent;
        private final TextView tvFirstBound;
        private final TextView tvLastActive;
        private final TextView tvMeta;
        private final TextView tvName;
        private final TextView tvProducts;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeviceViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            View findViewById = view.findViewById(C0820R.id.iv_device_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.ivIcon = (ImageView) findViewById;
            View findViewById2 = view.findViewById(C0820R.id.tv_device_name);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.tvName = (TextView) findViewById2;
            View findViewById3 = view.findViewById(C0820R.id.tv_current_device);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.tvCurrent = (TextView) findViewById3;
            View findViewById4 = view.findViewById(C0820R.id.tv_device_meta);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.tvMeta = (TextView) findViewById4;
            View findViewById5 = view.findViewById(C0820R.id.tv_bound_products);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
            this.tvProducts = (TextView) findViewById5;
            View findViewById6 = view.findViewById(C0820R.id.tv_first_bound);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
            this.tvFirstBound = (TextView) findViewById6;
            View findViewById7 = view.findViewById(C0820R.id.tv_last_active);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
            this.tvLastActive = (TextView) findViewById7;
            this.formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00f9  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00fc  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0131  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x016c  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0041  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void bind(LoginDeviceInfo item) {
            String str;
            String deviceType;
            String platformCode;
            String deviceModel;
            String osVersion;
            String clientVersion;
            String str2;
            List boundProducts;
            Long firstBoundAt;
            String str3;
            Long lastActiveAt;
            String joinToString$default;
            Intrinsics.checkNotNullParameter(item, "item");
            TextView textView = this.tvName;
            String deviceName = item.getDeviceName();
            String str4 = null;
            if (deviceName != null) {
                if (!(!StringsKt.isBlank(deviceName))) {
                    deviceName = null;
                }
                if (deviceName != null) {
                    str = deviceName;
                    textView.setText(str);
                    this.tvCurrent.setVisibility(!item.getCurrentDevice() ? 0 : 8);
                    this.ivIcon.setImageResource(C0820R.drawable.ic_setting_computer_screen);
                    String[] strArr = new String[5];
                    deviceType = item.getDeviceType();
                    if (deviceType != null || !(!StringsKt.isBlank(deviceType))) {
                        deviceType = null;
                    }
                    strArr[0] = deviceType;
                    platformCode = item.getPlatformCode();
                    if (platformCode != null || !(!StringsKt.isBlank(platformCode))) {
                        platformCode = null;
                    }
                    strArr[1] = platformCode;
                    deviceModel = item.getDeviceModel();
                    if (deviceModel != null || !(!StringsKt.isBlank(deviceModel))) {
                        deviceModel = null;
                    }
                    strArr[2] = deviceModel;
                    osVersion = item.getOsVersion();
                    if (osVersion != null || !(!StringsKt.isBlank(osVersion))) {
                        osVersion = null;
                    }
                    strArr[3] = osVersion;
                    clientVersion = item.getClientVersion();
                    if (clientVersion != null) {
                        if (!(!StringsKt.isBlank(clientVersion))) {
                            clientVersion = null;
                        }
                        if (clientVersion != null) {
                            str2 = this.itemView.getContext().getString(C0820R.string.trae_setting_debug_login_devices_version, clientVersion);
                            strArr[4] = str2;
                            setOptionalText(this.tvMeta, CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(strArr), " · ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
                            TextView textView2 = this.tvProducts;
                            boundProducts = item.getBoundProducts();
                            if (!(!boundProducts.isEmpty())) {
                                boundProducts = null;
                            }
                            setOptionalText(textView2, (boundProducts != null || (joinToString$default = CollectionsKt.joinToString$default(boundProducts, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)) == null) ? null : this.itemView.getContext().getString(C0820R.string.trae_setting_debug_login_devices_products, joinToString$default));
                            TextView textView3 = this.tvFirstBound;
                            firstBoundAt = item.getFirstBoundAt();
                            if (firstBoundAt != null) {
                                if (!(firstBoundAt.longValue() > 0)) {
                                    firstBoundAt = null;
                                }
                                if (firstBoundAt != null) {
                                    str3 = this.itemView.getContext().getString(C0820R.string.trae_setting_debug_login_devices_first_bound, formatTime(firstBoundAt.longValue()));
                                    setOptionalText(textView3, str3);
                                    TextView textView4 = this.tvLastActive;
                                    lastActiveAt = item.getLastActiveAt();
                                    if (lastActiveAt != null) {
                                        if (!(lastActiveAt.longValue() > 0)) {
                                            lastActiveAt = null;
                                        }
                                        if (lastActiveAt != null) {
                                            str4 = this.itemView.getContext().getString(C0820R.string.trae_setting_debug_login_devices_last_active, formatTime(lastActiveAt.longValue()));
                                        }
                                    }
                                    setOptionalText(textView4, str4);
                                }
                            }
                            str3 = null;
                            setOptionalText(textView3, str3);
                            TextView textView42 = this.tvLastActive;
                            lastActiveAt = item.getLastActiveAt();
                            if (lastActiveAt != null) {
                            }
                            setOptionalText(textView42, str4);
                        }
                    }
                    str2 = null;
                    strArr[4] = str2;
                    setOptionalText(this.tvMeta, CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(strArr), " · ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
                    TextView textView22 = this.tvProducts;
                    boundProducts = item.getBoundProducts();
                    if (!(!boundProducts.isEmpty())) {
                    }
                    setOptionalText(textView22, (boundProducts != null || (joinToString$default = CollectionsKt.joinToString$default(boundProducts, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)) == null) ? null : this.itemView.getContext().getString(C0820R.string.trae_setting_debug_login_devices_products, joinToString$default));
                    TextView textView32 = this.tvFirstBound;
                    firstBoundAt = item.getFirstBoundAt();
                    if (firstBoundAt != null) {
                    }
                    str3 = null;
                    setOptionalText(textView32, str3);
                    TextView textView422 = this.tvLastActive;
                    lastActiveAt = item.getLastActiveAt();
                    if (lastActiveAt != null) {
                    }
                    setOptionalText(textView422, str4);
                }
            }
            String string = this.itemView.getContext().getString(C0820R.string.trae_setting_debug_login_devices_unknown);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            str = string;
            textView.setText(str);
            this.tvCurrent.setVisibility(!item.getCurrentDevice() ? 0 : 8);
            this.ivIcon.setImageResource(C0820R.drawable.ic_setting_computer_screen);
            String[] strArr2 = new String[5];
            deviceType = item.getDeviceType();
            if (deviceType != null) {
            }
            deviceType = null;
            strArr2[0] = deviceType;
            platformCode = item.getPlatformCode();
            if (platformCode != null) {
            }
            platformCode = null;
            strArr2[1] = platformCode;
            deviceModel = item.getDeviceModel();
            if (deviceModel != null) {
            }
            deviceModel = null;
            strArr2[2] = deviceModel;
            osVersion = item.getOsVersion();
            if (osVersion != null) {
            }
            osVersion = null;
            strArr2[3] = osVersion;
            clientVersion = item.getClientVersion();
            if (clientVersion != null) {
            }
            str2 = null;
            strArr2[4] = str2;
            setOptionalText(this.tvMeta, CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(strArr2), " · ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
            TextView textView222 = this.tvProducts;
            boundProducts = item.getBoundProducts();
            if (!(!boundProducts.isEmpty())) {
            }
            setOptionalText(textView222, (boundProducts != null || (joinToString$default = CollectionsKt.joinToString$default(boundProducts, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)) == null) ? null : this.itemView.getContext().getString(C0820R.string.trae_setting_debug_login_devices_products, joinToString$default));
            TextView textView322 = this.tvFirstBound;
            firstBoundAt = item.getFirstBoundAt();
            if (firstBoundAt != null) {
            }
            str3 = null;
            setOptionalText(textView322, str3);
            TextView textView4222 = this.tvLastActive;
            lastActiveAt = item.getLastActiveAt();
            if (lastActiveAt != null) {
            }
            setOptionalText(textView4222, str4);
        }

        private final void setOptionalText(TextView view, String text) {
            view.setText(text == null ? "" : text);
            String str = text;
            view.setVisibility(str == null || StringsKt.isBlank(str) ? 8 : 0);
        }

        private final String formatTime(long timestamp) {
            if (timestamp < 10000000000L) {
                timestamp *= 1000;
            }
            String format = this.formatter.format(new Date(timestamp));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        }
    }
}
