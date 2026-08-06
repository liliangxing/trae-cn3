package com.bytedance.trae.conversation.brainstorm.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.brainstorm.model.AudioDevice;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AudioDeviceSwitcher.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J\b\u0010 \u001a\u00020\u0007H\u0016J(\u0010!\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%H\u0002R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "onDeviceSelected", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;", "", "getOnDeviceSelected", "()Lkotlin/jvm/functions/Function1;", "setOnDeviceSelected", "(Lkotlin/jvm/functions/Function1;)V", "selectedDevice", "availableDevices", "", "bluetoothDeviceName", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "getDeviceDisplayName", "device", "onStart", "addDeviceItem", "Landroid/widget/LinearLayout;", "label", "isSelected", "", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AudioDeviceSwitcher extends BottomSheetDialogFragment {
    private static final String ARG_AVAILABLE_DEVICES = "arg_available_devices";
    private static final String ARG_BLUETOOTH_NAME = "arg_bluetooth_name";
    private static final String ARG_SELECTED_DEVICE = "arg_selected_device";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String bluetoothDeviceName;
    private Function1<? super AudioDevice, Unit> onDeviceSelected;
    private AudioDevice selectedDevice = AudioDevice.Speaker;
    private List<? extends AudioDevice> availableDevices = CollectionsKt.listOf(new AudioDevice[]{AudioDevice.Speaker, AudioDevice.Earpiece});

    /* compiled from: AudioDeviceSwitcher.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AudioDevice.values().length];
            try {
                iArr[AudioDevice.Speaker.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AudioDevice.Earpiece.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: AudioDeviceSwitcher.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00110\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher$Companion;", "", "<init>", "()V", "ARG_SELECTED_DEVICE", "", "ARG_AVAILABLE_DEVICES", "ARG_BLUETOOTH_NAME", "newInstance", "Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;", "selectedDevice", "Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;", "availableDevices", "", "bluetoothDeviceName", "onDeviceSelected", "Lkotlin/Function1;", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AudioDeviceSwitcher newInstance(AudioDevice selectedDevice, List<? extends AudioDevice> availableDevices, String bluetoothDeviceName, Function1<? super AudioDevice, Unit> onDeviceSelected) {
            Intrinsics.checkNotNullParameter(selectedDevice, "selectedDevice");
            Intrinsics.checkNotNullParameter(availableDevices, "availableDevices");
            Intrinsics.checkNotNullParameter(onDeviceSelected, "onDeviceSelected");
            AudioDeviceSwitcher audioDeviceSwitcher = new AudioDeviceSwitcher();
            Bundle bundle = new Bundle();
            bundle.putString(AudioDeviceSwitcher.ARG_SELECTED_DEVICE, selectedDevice.name());
            List<? extends AudioDevice> list = availableDevices;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((AudioDevice) it.next()).name());
            }
            bundle.putStringArrayList(AudioDeviceSwitcher.ARG_AVAILABLE_DEVICES, new ArrayList<>(arrayList));
            bundle.putString(AudioDeviceSwitcher.ARG_BLUETOOTH_NAME, bluetoothDeviceName);
            audioDeviceSwitcher.setArguments(bundle);
            audioDeviceSwitcher.setOnDeviceSelected(onDeviceSelected);
            return audioDeviceSwitcher;
        }
    }

    public final Function1<AudioDevice, Unit> getOnDeviceSelected() {
        return this.onDeviceSelected;
    }

    public final void setOnDeviceSelected(Function1<? super AudioDevice, Unit> function1) {
        this.onDeviceSelected = function1;
    }

    public void onCreate(Bundle savedInstanceState) {
        AudioDevice audioDevice;
        AudioDevice audioDevice2;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString(ARG_SELECTED_DEVICE);
            if (string != null) {
                try {
                    audioDevice = AudioDevice.valueOf(string);
                } catch (IllegalArgumentException unused) {
                    audioDevice = AudioDevice.Speaker;
                }
                this.selectedDevice = audioDevice;
            }
            ArrayList<String> stringArrayList = arguments.getStringArrayList(ARG_AVAILABLE_DEVICES);
            if (stringArrayList != null) {
                ArrayList arrayList = new ArrayList();
                for (String str : stringArrayList) {
                    try {
                        Intrinsics.checkNotNull(str);
                        audioDevice2 = AudioDevice.valueOf(str);
                    } catch (IllegalArgumentException unused2) {
                        audioDevice2 = null;
                    }
                    if (audioDevice2 != null) {
                        arrayList.add(audioDevice2);
                    }
                }
                this.availableDevices = arrayList;
            }
            this.bluetoothDeviceName = arguments.getString(ARG_BLUETOOTH_NAME);
        }
    }

    public int getTheme() {
        return C0637R.style.Trae_BottomSheetDialog;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0637R.layout.trae_layout_audio_device_switcher, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ((TraeTitleBar) view.findViewById(C0637R.id.title_bar)).setOnRightActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.brainstorm.widget.AudioDeviceSwitcher$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AudioDeviceSwitcher.this.dismiss();
            }
        });
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C0637R.id.device_list_container);
        Iterator<? extends AudioDevice> it = this.availableDevices.iterator();
        while (it.hasNext()) {
            AudioDevice next = it.next();
            String deviceDisplayName = getDeviceDisplayName(next);
            Intrinsics.checkNotNull(linearLayout);
            addDeviceItem(linearLayout, next, deviceDisplayName, next == this.selectedDevice);
        }
    }

    private final String getDeviceDisplayName(AudioDevice device) {
        int i = WhenMappings.$EnumSwitchMapping$0[device.ordinal()];
        if (i == 1) {
            String string = getString(C0637R.string.trae_brainstorm_device_speaker);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        String string2 = getString(C0637R.string.trae_brainstorm_device_earpiece);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return string2;
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        View findViewById = dialog != null ? dialog.findViewById(R.id.design_bottom_sheet) : null;
        if (findViewById != null) {
            int i = (int) (360 * getResources().getDisplayMetrics().density);
            BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
            from.setPeekHeight(i);
            from.setHideable(true);
            from.setState(3);
        }
    }

    private final void addDeviceItem(LinearLayout container, final AudioDevice device, String label, boolean isSelected) {
        View inflate = LayoutInflater.from(requireContext()).inflate(C0637R.layout.trae_item_audio_device, (ViewGroup) container, false);
        if (container.getChildCount() > 0) {
            ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.topMargin = getResources().getDimensionPixelSize(C0637R.dimen.trae_brainstorm_device_item_gap);
            inflate.setLayoutParams(layoutParams2);
        }
        ImageView imageView = (ImageView) inflate.findViewById(C0637R.id.iv_checkbox);
        ((TextView) inflate.findViewById(C0637R.id.tv_device_name)).setText(label);
        if (isSelected) {
            imageView.setImageResource(C0637R.drawable.trae_ic_brainstorm_checkbox_checked);
            inflate.setBackgroundResource(C0637R.drawable.trae_bg_brainstorm_device_item_selected);
        } else {
            imageView.setImageResource(C0637R.drawable.trae_ic_brainstorm_checkbox_unchecked);
            inflate.setBackgroundResource(C0637R.drawable.trae_bg_brainstorm_device_item_normal);
        }
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.brainstorm.widget.AudioDeviceSwitcher$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioDeviceSwitcher.addDeviceItem$lambda$6(AudioDeviceSwitcher.this, device, view);
            }
        });
        container.addView(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addDeviceItem$lambda$6(AudioDeviceSwitcher audioDeviceSwitcher, AudioDevice audioDevice, View view) {
        Function1<? super AudioDevice, Unit> function1 = audioDeviceSwitcher.onDeviceSelected;
        if (function1 != null) {
            function1.invoke(audioDevice);
        }
        audioDeviceSwitcher.dismiss();
    }
}
