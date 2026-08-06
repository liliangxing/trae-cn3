package com.bytedance.trae.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.login.DeviceOverLimitDeviceAdapter;
import com.bytedance.trae.login.activity.PhoneBindActivity;
import com.bytedance.trae.login.databinding.TraeItemDeviceOverLimitBinding;
import com.bytedance.trae.login.traeauth.DeviceSummary;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.trae.multilanguage.C0882R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DeviceOverLimitDeviceAdapter.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\b\u0000\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001eB)\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001c\u0010\u0014\u001a\u00020\b2\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\u0017\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0002\u0010\u001dR\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder;", "devices", "", "Lcom/bytedance/trae/login/traeauth/DeviceSummary;", "onLogoutClick", "Lkotlin/Function1;", "", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "", "removeDevice", "deviceId", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "resolveDeviceIcon", "device", "formatTime", "timestampMillis", "", "(Ljava/lang/Long;)Ljava/lang/String;", "DeviceViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DeviceOverLimitDeviceAdapter extends RecyclerView.Adapter<DeviceViewHolder> {
    private final List<DeviceSummary> devices;
    private final Function1<DeviceSummary, Unit> onLogoutClick;

    /* JADX WARN: Multi-variable type inference failed */
    public DeviceOverLimitDeviceAdapter(List<DeviceSummary> list, Function1<? super DeviceSummary, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "devices");
        Intrinsics.checkNotNullParameter(function1, "onLogoutClick");
        this.onLogoutClick = function1;
        this.devices = CollectionsKt.toMutableList(list);
    }

    public final void removeDevice(String deviceId) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Iterator<DeviceSummary> it = this.devices.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getDeviceId(), deviceId)) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            this.devices.remove(i);
            notifyItemRemoved(i);
        }
    }

    public DeviceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        TraeItemDeviceOverLimitBinding inflate = TraeItemDeviceOverLimitBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new DeviceViewHolder(this, inflate);
    }

    public void onBindViewHolder(DeviceViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.devices.get(position), position == this.devices.size() - 1);
    }

    public int getItemCount() {
        return this.devices.size();
    }

    /* compiled from: DeviceOverLimitDeviceAdapter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/bytedance/trae/login/databinding/TraeItemDeviceOverLimitBinding;", "<init>", "(Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;Lcom/bytedance/trae/login/databinding/TraeItemDeviceOverLimitBinding;)V", PhoneBindActivity.MODE_BIND, "", "device", "Lcom/bytedance/trae/login/traeauth/DeviceSummary;", "isLastItem", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public final class DeviceViewHolder extends RecyclerView.ViewHolder {
        private final TraeItemDeviceOverLimitBinding binding;
        final /* synthetic */ DeviceOverLimitDeviceAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeviceViewHolder(DeviceOverLimitDeviceAdapter deviceOverLimitDeviceAdapter, TraeItemDeviceOverLimitBinding traeItemDeviceOverLimitBinding) {
            super(traeItemDeviceOverLimitBinding.getRoot());
            Intrinsics.checkNotNullParameter(traeItemDeviceOverLimitBinding, "binding");
            this.this$0 = deviceOverLimitDeviceAdapter;
            this.binding = traeItemDeviceOverLimitBinding;
        }

        public final void bind(final DeviceSummary device, boolean isLastItem) {
            Intrinsics.checkNotNullParameter(device, "device");
            Context context = this.binding.getRoot().getContext();
            List<String> boundProducts = device.getBoundProducts();
            String joinToString$default = boundProducts != null ? CollectionsKt.joinToString$default(boundProducts, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) : null;
            if (joinToString$default == null) {
                joinToString$default = "";
            }
            String str = joinToString$default;
            if (StringsKt.isBlank(str)) {
                str = context.getString(C0882R.string.trae_device_over_limit_unknown_os);
                Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
            }
            String str2 = str;
            TextView textView = this.binding.tvDeviceName;
            String deviceName = device.getDeviceName();
            if (deviceName == null) {
                deviceName = "";
            }
            String str3 = deviceName;
            if (StringsKt.isBlank(str3)) {
                String deviceModel = device.getDeviceModel();
                str3 = deviceModel != null ? deviceModel : "";
            }
            String str4 = str3;
            if (StringsKt.isBlank(str4)) {
                str4 = context.getString(C0882R.string.trae_device_over_limit_unknown_device);
                Intrinsics.checkNotNullExpressionValue(str4, "getString(...)");
            }
            textView.setText(str4);
            this.binding.tvOsVersion.setText(context.getString(C0882R.string.trae_device_over_limit_app, str2));
            this.binding.tvLoginTime.setText(context.getString(C0882R.string.trae_device_over_limit_login_time, this.this$0.formatTime(device.getLastActiveAt())));
            this.binding.ivDeviceIcon.setImageResource(this.this$0.resolveDeviceIcon(device));
            this.binding.btnLogoutDevice.setVisibility(Intrinsics.areEqual(device.getCurrentDevice(), true) ? 4 : 0);
            TextView textView2 = this.binding.btnLogoutDevice;
            final DeviceOverLimitDeviceAdapter deviceOverLimitDeviceAdapter = this.this$0;
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.DeviceOverLimitDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DeviceOverLimitDeviceAdapter.DeviceViewHolder.bind$lambda$3(DeviceOverLimitDeviceAdapter.this, device, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$3(DeviceOverLimitDeviceAdapter deviceOverLimitDeviceAdapter, DeviceSummary deviceSummary, View view) {
            deviceOverLimitDeviceAdapter.onLogoutClick.invoke(deviceSummary);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int resolveDeviceIcon(DeviceSummary device) {
        String joinToString$default = CollectionsKt.joinToString$default(CollectionsKt.listOf(new String[]{device.getDeviceType(), device.getPlatformCode(), device.getDeviceModel()}), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        String lowerCase = joinToString$default.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str = lowerCase;
        if (StringsKt.contains$default(str, TraeAuthManager.PLATFORM_PHONE, false, 2, (Object) null) || StringsKt.contains$default(str, "mobile", false, 2, (Object) null) || StringsKt.contains$default(str, "android", false, 2, (Object) null) || StringsKt.contains$default(str, "ios", false, 2, (Object) null) || StringsKt.contains$default(str, "iphone", false, 2, (Object) null)) {
            return C0820R.drawable.ic_device_manager_computer_mobile;
        }
        return C0820R.drawable.ic_device_manager_computer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String formatTime(Long timestampMillis) {
        if (timestampMillis == null) {
            return "--";
        }
        long longValue = timestampMillis.longValue();
        if (longValue <= 0) {
            return "--";
        }
        String format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault()).format(new Date(longValue));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}
