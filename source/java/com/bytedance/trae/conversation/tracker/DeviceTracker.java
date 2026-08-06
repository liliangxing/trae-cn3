package com.bytedance.trae.conversation.tracker;

import android.util.Log;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.sync.interfaze.IFileDataCacheService;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.DeviceCountSnapshot;
import com.bytedance.trae.conversation.devices.DevicePairingTrigger;
import com.bytedance.trae.conversation.devices.DeviceProductType;
import com.bytedance.trae.conversation.widget.ChatMode;
import com.bytedance.trae.im.service.CliType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: DeviceTracker.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u001d\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ&\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011J\u0016\u0010 \u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ \u0010!\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020#J\u0016\u0010$\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010%\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010&\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010'\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010(\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005J=\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020/2\u0006\u0010\"\u001a\u00020#H\u0000¢\u0006\u0002\b0J&\u00101\u001a\u00020\r2\u0006\u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001aJ&\u00105\u001a\u00020\r2\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\u0011J\u0015\u0010;\u001a\u00020\r2\u0006\u0010<\u001a\u00020=H\u0000¢\u0006\u0002\b>J\u000e\u0010?\u001a\u00020\r2\u0006\u0010@\u001a\u00020\u001dJ\u0017\u0010A\u001a\u00020\r2\b\u0010B\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\bCJ\u000e\u0010D\u001a\u00020\r2\u0006\u0010E\u001a\u00020\u0005J\u001e\u0010F\u001a\u00020\r2\u0006\u0010G\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u001d2\u0006\u0010I\u001a\u00020\u001dJ\u0010\u0010J\u001a\u00020\r2\u0006\u0010K\u001a\u00020LH\u0002J\f\u0010M\u001a\u00020N*\u00020\u000fH\u0002J\f\u0010O\u001a\u00020P*\u00020\u000fH\u0002J\f\u0010O\u001a\u00020P*\u000208H\u0002J\f\u0010Q\u001a\u00020\u0005*\u000208H\u0002J\f\u0010R\u001a\u00020S*\u00020\u001aH\u0002J\f\u0010T\u001a\u00020U*\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/DeviceTracker;", "", "<init>", "()V", "TAG", "", "EVENT_DEVICE_SELECT_PATH", "EVENT_IDE_PROJECT_PAGE_VIEW", "EVENT_OFFLINE_DEVICE_PAGE_VIEW", "appLogSink", "Lcom/bytedance/trae/conversation/tracker/DeviceEventSink;", "testSink", "trackGuideShow", "", "productType", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "workBound", "", "ideBound", "trackGuideClick", "action", "Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;", "trackGuideClick$conversation_mainlandRelease", "trackConnectEntryClick", "enterFrom", "currentMode", "Lcom/bytedance/trae/conversation/widget/ChatMode;", "trackTargetSelectShow", "availableTargetCount", "", "hasWorkDevice", "hasIdeDevice", "trackTargetSelectClick", "trackPairingPageView", "triggerBy", "Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;", "trackPairingStep1Complete", "trackPairingStep2Show", "trackDownloadLinkCopyClick", "trackPairingPageShareClick", "trackShareChannelSelect", Constant.KEY_CHANNEL, "trackPairResult", "durationMillis", "", "isSuccess", "resultDetail", "Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;", "trackPairResult$conversation_mainlandRelease", "trackDevicePickerShow", "deviceCount", "workDeviceCount", "ideDeviceCount", "trackDeviceSelectClick", "deviceId", "cliType", "Lcom/bytedance/trae/im/service/CliType;", "isOnline", "isPaired", "trackDevicePairCount", IFileDataCacheService.TYPE_SNAPSHOT, "Lcom/bytedance/trae/conversation/DeviceCountSnapshot;", "trackDevicePairCount$conversation_mainlandRelease", "trackDeviceSelectPath", "depth", "setTestSink", "sink", "setTestSink$conversation_mainlandRelease", "trackOfflineDevicePageView", "deviceType", "trackIdeProjectPageView", "projectCount", "multiRootSaveProjectCount", "multiRootUnsaveProjectCount", "report", Fields.EVENT, "Lcom/bytedance/trae/conversation/tracker/DeviceEvent;", "toGuideType", "Lcom/bytedance/trae/conversation/tracker/DeviceGuideType;", "toTrackCliType", "Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;", "toLegacyDeviceType", "toTrackMode", "Lcom/bytedance/trae/conversation/tracker/DeviceTrackMode;", "toBindState", "Lcom/bytedance/trae/conversation/tracker/DeviceBindState;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceTracker {
    private static final String EVENT_DEVICE_SELECT_PATH = "icube_path_select_click";
    private static final String EVENT_IDE_PROJECT_PAGE_VIEW = "ide_project_page_view";
    private static final String EVENT_OFFLINE_DEVICE_PAGE_VIEW = "offline_device_page_view";
    private static final String TAG = "DeviceTracker";
    private static volatile DeviceEventSink testSink;
    public static final DeviceTracker INSTANCE = new DeviceTracker();
    private static final DeviceEventSink appLogSink = new DeviceEventSink() { // from class: com.bytedance.trae.conversation.tracker.DeviceTracker$$ExternalSyntheticLambda0
        @Override // com.bytedance.trae.conversation.tracker.DeviceEventSink
        public final void report(DeviceEvent deviceEvent) {
            DeviceTracker.appLogSink$lambda$0(deviceEvent);
        }
    };

    /* compiled from: DeviceTracker.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

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
            int[] iArr2 = new int[CliType.values().length];
            try {
                iArr2[CliType.REMOTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[CliType.LOCAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[CliType.IDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[ChatMode.values().length];
            try {
                iArr3[ChatMode.MTC.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[ChatMode.CODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    private DeviceTracker() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void appLogSink$lambda$0(DeviceEvent deviceEvent) {
        Intrinsics.checkNotNullParameter(deviceEvent, Fields.EVENT);
        JSONObject jSONObject = new JSONObject(deviceEvent.getParams());
        if (AppHost.INSTANCE.isDebug()) {
            Log.d(TAG, "reportEvent: " + deviceEvent.getName() + ", params: " + jSONObject);
        }
        IApplog.INSTANCE.reportEvent(deviceEvent.getName(), jSONObject);
    }

    public final void trackGuideShow(DeviceProductType productType, boolean workBound, boolean ideBound) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        report(DeviceEventFactory.INSTANCE.guideShow(toGuideType(productType), toBindState(workBound), toBindState(ideBound)));
    }

    public final void trackGuideClick$conversation_mainlandRelease(DeviceProductType productType, DeviceGuideAction action) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(action, "action");
        report(DeviceEventFactory.INSTANCE.guideClick(toGuideType(productType), action));
    }

    public final void trackConnectEntryClick(String enterFrom, ChatMode currentMode) {
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        DeviceTrackEnterFrom from = DeviceTrackEnterFrom.INSTANCE.from(enterFrom);
        if (from == null) {
            return;
        }
        report(DeviceEventFactory.INSTANCE.connectEntryClick(from, currentMode != null ? toTrackMode(currentMode) : null));
    }

    public final void trackTargetSelectShow(String enterFrom, int availableTargetCount, boolean hasWorkDevice, boolean hasIdeDevice) {
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        DeviceTrackEnterFrom from = DeviceTrackEnterFrom.INSTANCE.from(enterFrom);
        if (from == null) {
            return;
        }
        report(DeviceEventFactory.INSTANCE.targetSelectShow(from, availableTargetCount, hasWorkDevice, hasIdeDevice));
    }

    public final void trackTargetSelectClick(String enterFrom, DeviceProductType productType) {
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        Intrinsics.checkNotNullParameter(productType, "productType");
        DeviceTrackEnterFrom from = DeviceTrackEnterFrom.INSTANCE.from(enterFrom);
        if (from == null) {
            return;
        }
        report(DeviceEventFactory.INSTANCE.targetSelectClick(from, toTrackCliType(productType)));
    }

    public static /* synthetic */ void trackPairingPageView$default(DeviceTracker deviceTracker, String str, DeviceProductType deviceProductType, DevicePairingTrigger devicePairingTrigger, int i, Object obj) {
        if ((i & 4) != 0) {
            devicePairingTrigger = DevicePairingTrigger.CONNECT_BUTTON;
        }
        deviceTracker.trackPairingPageView(str, deviceProductType, devicePairingTrigger);
    }

    public final void trackPairingPageView(String enterFrom, DeviceProductType productType, DevicePairingTrigger triggerBy) {
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(triggerBy, "triggerBy");
        DeviceTrackEnterFrom from = DeviceTrackEnterFrom.INSTANCE.from(enterFrom);
        if (from == null) {
            return;
        }
        report(DeviceEventFactory.INSTANCE.pairingPageView(from, toTrackCliType(productType), productType.getCliTypeValue(), triggerBy));
    }

    public final void trackPairingStep1Complete(String enterFrom, DeviceProductType productType) {
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        Intrinsics.checkNotNullParameter(productType, "productType");
        DeviceTrackEnterFrom from = DeviceTrackEnterFrom.INSTANCE.from(enterFrom);
        if (from == null) {
            return;
        }
        report(DeviceEventFactory.INSTANCE.pairingStep1Complete(from, toTrackCliType(productType)));
    }

    public final void trackPairingStep2Show(String enterFrom, DeviceProductType productType) {
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        Intrinsics.checkNotNullParameter(productType, "productType");
        DeviceTrackEnterFrom from = DeviceTrackEnterFrom.INSTANCE.from(enterFrom);
        if (from == null) {
            return;
        }
        report(DeviceEventFactory.INSTANCE.pairingStep2Show(from, toTrackCliType(productType)));
    }

    public final void trackDownloadLinkCopyClick(String enterFrom, DeviceProductType productType) {
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        Intrinsics.checkNotNullParameter(productType, "productType");
        DeviceTrackEnterFrom from = DeviceTrackEnterFrom.INSTANCE.from(enterFrom);
        if (from == null) {
            return;
        }
        report(DeviceEventFactory.INSTANCE.downloadLinkCopyClick(from, toTrackCliType(productType)));
    }

    public final void trackPairingPageShareClick(String enterFrom, DeviceProductType productType) {
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        Intrinsics.checkNotNullParameter(productType, "productType");
        DeviceTrackEnterFrom from = DeviceTrackEnterFrom.INSTANCE.from(enterFrom);
        if (from == null) {
            return;
        }
        report(DeviceEventFactory.INSTANCE.pairingPageShareClick(from, toTrackCliType(productType)));
    }

    public final void trackShareChannelSelect(String enterFrom, String channel) {
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        Intrinsics.checkNotNullParameter(channel, Constant.KEY_CHANNEL);
        DeviceTrackEnterFrom from = DeviceTrackEnterFrom.INSTANCE.from(enterFrom);
        if (from == null) {
            return;
        }
        report(DeviceEventFactory.INSTANCE.shareChannelSelect(from, channel));
    }

    public final void trackPairResult$conversation_mainlandRelease(long durationMillis, boolean isSuccess, String enterFrom, DeviceProductType productType, DevicePairResultDetail resultDetail, DevicePairingTrigger triggerBy) {
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(resultDetail, "resultDetail");
        Intrinsics.checkNotNullParameter(triggerBy, "triggerBy");
        DeviceTrackEnterFrom from = DeviceTrackEnterFrom.INSTANCE.from(enterFrom);
        if (from == null) {
            return;
        }
        report(DeviceEventFactory.INSTANCE.pairResult(durationMillis, isSuccess, from, toTrackCliType(productType), resultDetail, triggerBy));
    }

    public final void trackDevicePickerShow(int deviceCount, int workDeviceCount, int ideDeviceCount, ChatMode currentMode) {
        Intrinsics.checkNotNullParameter(currentMode, "currentMode");
        report(DeviceEventFactory.INSTANCE.devicePickerShow(deviceCount, workDeviceCount, ideDeviceCount, toTrackMode(currentMode)));
    }

    public final void trackDeviceSelectClick(String deviceId, CliType cliType, boolean isOnline, boolean isPaired) {
        DeviceTrackOnlineStatus deviceTrackOnlineStatus;
        DeviceRegisterStatus deviceRegisterStatus;
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(cliType, "cliType");
        DeviceEventFactory deviceEventFactory = DeviceEventFactory.INSTANCE;
        String legacyDeviceType = toLegacyDeviceType(cliType);
        DeviceTrackCliType trackCliType = toTrackCliType(cliType);
        if (isOnline) {
            deviceTrackOnlineStatus = DeviceTrackOnlineStatus.ONLINE;
        } else {
            deviceTrackOnlineStatus = DeviceTrackOnlineStatus.OFFLINE;
        }
        DeviceTrackOnlineStatus deviceTrackOnlineStatus2 = deviceTrackOnlineStatus;
        if (isPaired) {
            deviceRegisterStatus = DeviceRegisterStatus.REGISTERED;
        } else {
            deviceRegisterStatus = DeviceRegisterStatus.UNREGISTERED;
        }
        report(deviceEventFactory.deviceSelectClick(deviceId, legacyDeviceType, trackCliType, deviceTrackOnlineStatus2, deviceRegisterStatus));
    }

    public final void trackDevicePairCount$conversation_mainlandRelease(DeviceCountSnapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, IFileDataCacheService.TYPE_SNAPSHOT);
        report(DeviceEventFactory.INSTANCE.pairCount(snapshot.getLegacyTotal(), snapshot.getWorkCount(), snapshot.getIdeCount()));
    }

    public final void trackDeviceSelectPath(int depth) {
        report(new DeviceEvent(EVENT_DEVICE_SELECT_PATH, MapsKt.mapOf(TuplesKt.to("depth", Integer.valueOf(depth)))));
    }

    public final void setTestSink$conversation_mainlandRelease(DeviceEventSink sink) {
        if (!AppHost.INSTANCE.isDebug()) {
            throw new IllegalStateException("Device event test sink is only available in debug builds".toString());
        }
        testSink = sink;
    }

    public final void trackOfflineDevicePageView(String deviceType) {
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        report(new DeviceEvent(EVENT_OFFLINE_DEVICE_PAGE_VIEW, MapsKt.mapOf(TuplesKt.to(Constant.KEY_DEVICE_TYPE, deviceType))));
    }

    public final void trackIdeProjectPageView(int projectCount, int multiRootSaveProjectCount, int multiRootUnsaveProjectCount) {
        report(new DeviceEvent(EVENT_IDE_PROJECT_PAGE_VIEW, MapsKt.mapOf(new Pair[]{TuplesKt.to("project_count", Integer.valueOf(projectCount)), TuplesKt.to("multi_root_save_project_count", Integer.valueOf(multiRootSaveProjectCount)), TuplesKt.to("multi_root_unsave_project_count", Integer.valueOf(multiRootUnsaveProjectCount))})));
    }

    private final void report(DeviceEvent event) {
        Unit unit;
        try {
            Result.Companion companion = Result.Companion;
            DeviceTracker deviceTracker = this;
            appLogSink.report(event);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        try {
            Result.Companion companion3 = Result.Companion;
            DeviceTracker deviceTracker2 = this;
            DeviceEventSink deviceEventSink = testSink;
            if (deviceEventSink != null) {
                deviceEventSink.report(event);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Result.constructor-impl(unit);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th2));
        }
    }

    private final DeviceGuideType toGuideType(DeviceProductType deviceProductType) {
        int i = WhenMappings.$EnumSwitchMapping$0[deviceProductType.ordinal()];
        if (i == 1) {
            return DeviceGuideType.WORK;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return DeviceGuideType.IDE;
    }

    private final DeviceTrackCliType toTrackCliType(DeviceProductType deviceProductType) {
        int i = WhenMappings.$EnumSwitchMapping$0[deviceProductType.ordinal()];
        if (i == 1) {
            return DeviceTrackCliType.LOCAL;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return DeviceTrackCliType.LOCAL_IDE;
    }

    private final DeviceTrackCliType toTrackCliType(CliType cliType) {
        int i = WhenMappings.$EnumSwitchMapping$1[cliType.ordinal()];
        if (i == 1) {
            return DeviceTrackCliType.REMOTE;
        }
        if (i == 2) {
            return DeviceTrackCliType.LOCAL;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return DeviceTrackCliType.LOCAL_IDE;
    }

    private final String toLegacyDeviceType(CliType cliType) {
        return cliType == CliType.REMOTE ? "cloud_sandbox" : "pc";
    }

    private final DeviceTrackMode toTrackMode(ChatMode chatMode) {
        int i = WhenMappings.$EnumSwitchMapping$2[chatMode.ordinal()];
        if (i == 1) {
            return DeviceTrackMode.MTC;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return DeviceTrackMode.CODE;
    }

    private final DeviceBindState toBindState(boolean z) {
        return z ? DeviceBindState.BOUND : DeviceBindState.UNBOUND;
    }
}
