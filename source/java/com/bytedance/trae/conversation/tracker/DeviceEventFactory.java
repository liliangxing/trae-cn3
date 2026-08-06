package com.bytedance.trae.conversation.tracker;

import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.conversation.devices.DevicePairingTrigger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: DeviceEvents.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J&\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017J\u0016\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bJ&\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010!\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\"\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010#\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010$\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010%\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u001eJ6\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u001f\u001a\u00020 J&\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012J.\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206J\u001e\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u00020\u0015J\f\u00109\u001a\u00020\u0015*\u00020\u0017H\u0002J\f\u0010:\u001a\u00020\u001e*\u00020 H\u0002¨\u0006;"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;", "", "<init>", "()V", "guideShow", "Lcom/bytedance/trae/conversation/tracker/DeviceEvent;", "guideType", "Lcom/bytedance/trae/conversation/tracker/DeviceGuideType;", "workBindState", "Lcom/bytedance/trae/conversation/tracker/DeviceBindState;", "ideBindState", "guideClick", "action", "Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;", "connectEntryClick", "enterFrom", "Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;", "currentMode", "Lcom/bytedance/trae/conversation/tracker/DeviceTrackMode;", "targetSelectShow", "availableTargetCount", "", "hasWorkDevice", "", "hasIdeDevice", "targetSelectClick", "cliType", "Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;", "pairingPageView", "deviceType", "", "triggerBy", "Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;", "pairingStep1Complete", "pairingStep2Show", "downloadLinkCopyClick", "pairingPageShareClick", "shareChannelSelect", Constant.KEY_CHANNEL, "pairResult", ReportConstant.COMMON_INIT_DURATION, "", "isSuccess", "resultDetail", "Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;", "devicePickerShow", "deviceCount", "workDeviceCount", "ideDeviceCount", "deviceSelectClick", "deviceId", "onlineStatus", "Lcom/bytedance/trae/conversation/tracker/DeviceTrackOnlineStatus;", "registerStatus", "Lcom/bytedance/trae/conversation/tracker/DeviceRegisterStatus;", "pairCount", "localCliCount", "toInt", "trackValue", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceEventFactory {
    public static final DeviceEventFactory INSTANCE = new DeviceEventFactory();

    /* compiled from: DeviceEvents.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DevicePairingTrigger.values().length];
            try {
                iArr[DevicePairingTrigger.CONNECT_BUTTON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DevicePairingTrigger.UNBOUND_DEVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final int toInt(boolean z) {
        return z ? 1 : 0;
    }

    private DeviceEventFactory() {
    }

    public final DeviceEvent guideShow(DeviceGuideType guideType, DeviceBindState workBindState, DeviceBindState ideBindState) {
        Intrinsics.checkNotNullParameter(guideType, "guideType");
        Intrinsics.checkNotNullParameter(workBindState, "workBindState");
        Intrinsics.checkNotNullParameter(ideBindState, "ideBindState");
        return new DeviceEvent("icube_device_guide_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("guide_type", guideType.getValue()), TuplesKt.to("work_bind_state", workBindState.getValue()), TuplesKt.to("ide_bind_state", ideBindState.getValue())}));
    }

    public final DeviceEvent guideClick(DeviceGuideType guideType, DeviceGuideAction action) {
        Intrinsics.checkNotNullParameter(guideType, "guideType");
        Intrinsics.checkNotNullParameter(action, "action");
        return new DeviceEvent("icube_device_guide_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("guide_type", guideType.getValue()), TuplesKt.to("action", action.getValue())}));
    }

    public final DeviceEvent connectEntryClick(DeviceTrackEnterFrom enterFrom, DeviceTrackMode currentMode) {
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        Map createMapBuilder = MapsKt.createMapBuilder();
        createMapBuilder.put("enter_from", enterFrom.getValue());
        if (currentMode != null) {
            createMapBuilder.put("current_mode", currentMode.getValue());
        }
        return new DeviceEvent("icube_device_connect_entry_click", MapsKt.build(createMapBuilder));
    }

    public final DeviceEvent targetSelectShow(DeviceTrackEnterFrom enterFrom, int availableTargetCount, boolean hasWorkDevice, boolean hasIdeDevice) {
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        return new DeviceEvent("icube_device_target_select_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_from", enterFrom.getValue()), TuplesKt.to("available_target_count", Integer.valueOf(availableTargetCount)), TuplesKt.to("has_work_device", Integer.valueOf(toInt(hasWorkDevice))), TuplesKt.to("has_ide_device", Integer.valueOf(toInt(hasIdeDevice)))}));
    }

    public final DeviceEvent targetSelectClick(DeviceTrackEnterFrom enterFrom, DeviceTrackCliType cliType) {
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        Intrinsics.checkNotNullParameter(cliType, "cliType");
        return new DeviceEvent("icube_device_target_select_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_from", enterFrom.getValue()), TuplesKt.to("cli_type", cliType.getValue())}));
    }

    public final DeviceEvent pairingPageView(DeviceTrackEnterFrom enterFrom, DeviceTrackCliType cliType, String deviceType, DevicePairingTrigger triggerBy) {
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        Intrinsics.checkNotNullParameter(cliType, "cliType");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(triggerBy, "triggerBy");
        return new DeviceEvent("device_pairing_page_view", MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_from", enterFrom.getValue()), TuplesKt.to("cli_type", cliType.getValue()), TuplesKt.to(Constant.KEY_DEVICE_TYPE, deviceType), TuplesKt.to("trigger_by", trackValue(triggerBy))}));
    }

    public final DeviceEvent pairingStep1Complete(DeviceTrackEnterFrom enterFrom, DeviceTrackCliType cliType) {
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        Intrinsics.checkNotNullParameter(cliType, "cliType");
        return new DeviceEvent("device_pairing_step1_complete", MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_from", enterFrom.getValue()), TuplesKt.to("cli_type", cliType.getValue())}));
    }

    public final DeviceEvent pairingStep2Show(DeviceTrackEnterFrom enterFrom, DeviceTrackCliType cliType) {
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        Intrinsics.checkNotNullParameter(cliType, "cliType");
        return new DeviceEvent("device_pairing_step2_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_from", enterFrom.getValue()), TuplesKt.to("cli_type", cliType.getValue())}));
    }

    public final DeviceEvent downloadLinkCopyClick(DeviceTrackEnterFrom enterFrom, DeviceTrackCliType cliType) {
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        Intrinsics.checkNotNullParameter(cliType, "cliType");
        return new DeviceEvent("download_link_copy_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_from", enterFrom.getValue()), TuplesKt.to("cli_type", cliType.getValue())}));
    }

    public final DeviceEvent pairingPageShareClick(DeviceTrackEnterFrom enterFrom, DeviceTrackCliType cliType) {
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        Intrinsics.checkNotNullParameter(cliType, "cliType");
        return new DeviceEvent("device_pairing_page_share_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_from", enterFrom.getValue()), TuplesKt.to("cli_type", cliType.getValue())}));
    }

    public final DeviceEvent shareChannelSelect(DeviceTrackEnterFrom enterFrom, String channel) {
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        Intrinsics.checkNotNullParameter(channel, Constant.KEY_CHANNEL);
        return new DeviceEvent("icube_device_share_channel_select", MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_from", enterFrom.getValue()), TuplesKt.to(Constant.KEY_CHANNEL, channel)}));
    }

    public final DeviceEvent pairResult(long duration, boolean isSuccess, DeviceTrackEnterFrom enterFrom, DeviceTrackCliType cliType, DevicePairResultDetail resultDetail, DevicePairingTrigger triggerBy) {
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        Intrinsics.checkNotNullParameter(cliType, "cliType");
        Intrinsics.checkNotNullParameter(resultDetail, "resultDetail");
        Intrinsics.checkNotNullParameter(triggerBy, "triggerBy");
        return new DeviceEvent("icube_device_pair_result", MapsKt.mapOf(new Pair[]{TuplesKt.to(ReportConstant.COMMON_INIT_DURATION, Long.valueOf(RangesKt.coerceAtLeast(duration, 0L))), TuplesKt.to("is_success", Integer.valueOf(toInt(isSuccess))), TuplesKt.to("enter_from", enterFrom.getValue()), TuplesKt.to("cli_type", cliType.getValue()), TuplesKt.to("result_detail", resultDetail.getValue()), TuplesKt.to("trigger_by", trackValue(triggerBy))}));
    }

    public final DeviceEvent devicePickerShow(int deviceCount, int workDeviceCount, int ideDeviceCount, DeviceTrackMode currentMode) {
        Intrinsics.checkNotNullParameter(currentMode, "currentMode");
        return new DeviceEvent("icube_device_picker_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("device_count", Integer.valueOf(deviceCount)), TuplesKt.to("work_device_count", Integer.valueOf(workDeviceCount)), TuplesKt.to("ide_device_count", Integer.valueOf(ideDeviceCount)), TuplesKt.to("current_mode", currentMode.getValue())}));
    }

    public final DeviceEvent deviceSelectClick(String deviceId, String deviceType, DeviceTrackCliType cliType, DeviceTrackOnlineStatus onlineStatus, DeviceRegisterStatus registerStatus) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(cliType, "cliType");
        Intrinsics.checkNotNullParameter(onlineStatus, "onlineStatus");
        Intrinsics.checkNotNullParameter(registerStatus, "registerStatus");
        return new DeviceEvent("icube_device_select_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("device_id", deviceId), TuplesKt.to(Constant.KEY_DEVICE_TYPE, deviceType), TuplesKt.to("cli_type", cliType.getValue()), TuplesKt.to("online_status", onlineStatus.getValue()), TuplesKt.to("register_status", registerStatus.getValue())}));
    }

    public final DeviceEvent pairCount(int localCliCount, int workDeviceCount, int ideDeviceCount) {
        return new DeviceEvent("icube_device_pair_count", MapsKt.mapOf(new Pair[]{TuplesKt.to("local_cli_count", Integer.valueOf(localCliCount)), TuplesKt.to("work_device_count", Integer.valueOf(workDeviceCount)), TuplesKt.to("ide_device_count", Integer.valueOf(ideDeviceCount))}));
    }

    private final String trackValue(DevicePairingTrigger devicePairingTrigger) {
        int i = WhenMappings.$EnumSwitchMapping$0[devicePairingTrigger.ordinal()];
        if (i == 1) {
            return "connect_button";
        }
        if (i == 2) {
            return "unbound_device";
        }
        throw new NoWhenBranchMatchedException();
    }
}
