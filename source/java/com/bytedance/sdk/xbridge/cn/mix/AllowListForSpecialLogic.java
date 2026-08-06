package com.bytedance.sdk.xbridge.cn.mix;

import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.pasteboard.idl_bridge.XCopyMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AllowListForSpecialLogic.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nJ\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/mix/AllowListForSpecialLogic;", "", "()V", "JSB2_DATA", "", "JSB2_IGNORE_ERROR", "specialXBridgeLogicForWebcast", "", "", "dealSpecialDataSwitch", "", "methodName", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "data", "isInSpecialList", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AllowListForSpecialLogic {
    public static final AllowListForSpecialLogic INSTANCE = new AllowListForSpecialLogic();
    public static final String JSB2_DATA = "__jsb2__data__";
    public static final String JSB2_IGNORE_ERROR = "ignoreJSB2Error";
    private static final Map<String, Boolean> specialXBridgeLogicForWebcast;

    private AllowListForSpecialLogic() {
    }

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ttcjpay.bioPaymentShowState", true);
        linkedHashMap.put("ttcjpay.sendDeviceInfo", true);
        linkedHashMap.put("ttcjpay.bindCard", true);
        linkedHashMap.put("ttcjpay.getPhoneInfo", true);
        linkedHashMap.put("ttcjpay.goSettings", true);
        linkedHashMap.put("ttcjpay.ttpay", true);
        linkedHashMap.put("ttcjpay.uploadMedia", true);
        linkedHashMap.put("ttcjpay.openAppByScheme", true);
        linkedHashMap.put("ttcjpay.subscribeEvent", true);
        linkedHashMap.put("ttcjpay.subscribeEvent", true);
        linkedHashMap.put("ttcjpay.deviceInfo", true);
        linkedHashMap.put("ttcjpay.ocr", true);
        linkedHashMap.put("ttcjpay.isAppInstalled", true);
        linkedHashMap.put("ttcjpay.authAlipay", true);
        linkedHashMap.put("ttcjpay.getGeckoInfo", true);
        linkedHashMap.put("ttcjpay.abTest", true);
        linkedHashMap.put("ttcjpay.encrypt", true);
        linkedHashMap.put("ttcjpay.smsVerify", true);
        linkedHashMap.put("ttcjpay.closeCallback", true);
        linkedHashMap.put("ttcjpay.chooseMedia", true);
        linkedHashMap.put("ttcjpay.faceVerification", true);
        linkedHashMap.put("ttcjpay.alog", true);
        linkedHashMap.put("ttcjpay.switchBioPaymentState", true);
        linkedHashMap.put("ttcjpay.decrypt", true);
        linkedHashMap.put("ttcjpay.facepp", true);
        linkedHashMap.put("x.reportADLog", true);
        linkedHashMap.put("x.startGyroscope", true);
        linkedHashMap.put("x.stopGyroscope", true);
        linkedHashMap.put("x.setStorageItem", true);
        linkedHashMap.put(XCopyMethod.METHOD_NAME, true);
        linkedHashMap.put("x.getContainerID", true);
        linkedHashMap.put("x.updateGecko", true);
        linkedHashMap.put("x.getStorageInfo", true);
        linkedHashMap.put("x.vibrate", true);
        linkedHashMap.put("x.request", true);
        linkedHashMap.put("x.close", true);
        linkedHashMap.put("x.hideLoading", true);
        linkedHashMap.put("x.makePhoneCall", true);
        linkedHashMap.put("x.setCalendarEvent", true);
        linkedHashMap.put("x.removeCalendarEvent", true);
        linkedHashMap.put("x.createCalendarEvent", true);
        linkedHashMap.put("x.deleteCalendarEvent", true);
        linkedHashMap.put("x.showToast", true);
        linkedHashMap.put("x.open", true);
        linkedHashMap.put("x.scanCode", true);
        linkedHashMap.put("x.showLoading", true);
        linkedHashMap.put("x.chooseMedia", true);
        linkedHashMap.put("x.getSettings", true);
        linkedHashMap.put("x.reportMonitorLog", true);
        linkedHashMap.put("x.getAPIParams", true);
        linkedHashMap.put("x.getUserInfo", true);
        linkedHashMap.put("x.sendSMS", true);
        linkedHashMap.put("x.getMethodList", true);
        linkedHashMap.put("x.sendSocketData", true);
        linkedHashMap.put("x.configureStatusBar", true);
        linkedHashMap.put("x.showActionSheet", true);
        linkedHashMap.put("x.reportAppLog", true);
        linkedHashMap.put("x.getDebugInfo", true);
        linkedHashMap.put("x.getAppInfo", true);
        linkedHashMap.put("x.batchEvents", true);
        linkedHashMap.put("x.checkPermission", true);
        linkedHashMap.put("x.publishEvent", true);
        linkedHashMap.put("x.subscribeEvent", true);
        linkedHashMap.put("x.unsubscribeEvent", true);
        linkedHashMap.put("x.login", true);
        linkedHashMap.put("x.logout", true);
        linkedHashMap.put("x.showModal", true);
        linkedHashMap.put("x.downloadFile", true);
        linkedHashMap.put("x.uploadImage", true);
        linkedHashMap.put("x.closeSocket", true);
        linkedHashMap.put("x.readCalendarEvent", true);
        linkedHashMap.put("x.removeStorageItem", true);
        linkedHashMap.put("x.connectSocket", true);
        linkedHashMap.put("x.getGeckoInfo", true);
        linkedHashMap.put("x.reportALog", true);
        linkedHashMap.put("x.getStorageItem", true);
        linkedHashMap.put("x.allowCaptureScreen", true);
        linkedHashMap.put("x.uploadFile", true);
        linkedHashMap.put("x.canIUse", true);
        linkedHashMap.put("goLocationSettings", true);
        linkedHashMap.put("appendEntranceInfo", true);
        linkedHashMap.put("getBcmChainAndCartTrack", true);
        linkedHashMap.put("setBcmParams", true);
        linkedHashMap.put("getBcmChain", true);
        linkedHashMap.put("setBcmPageParamsV2", true);
        linkedHashMap.put("getBcmChainV2", true);
        linkedHashMap.put("registerBtmPage", true);
        linkedHashMap.put("createBtmChain", true);
        linkedHashMap.put("obtainEventBtmParams", true);
        linkedHashMap.put("createBtmId", true);
        linkedHashMap.put("willJumpToNextPage", true);
        linkedHashMap.put("sendBstExposureMethod", true);
        linkedHashMap.put("btm.createJumpSourceBtmToken", true);
        linkedHashMap.put("getAddictionInfoCache", true);
        linkedHashMap.put("checkLocationEnable", true);
        linkedHashMap.put("setElderModeState", true);
        linkedHashMap.put("getElderModeState", true);
        linkedHashMap.put("backToF2FCampaignVenue", true);
        linkedHashMap.put("notifyPushPermissionGuideOption", true);
        linkedHashMap.put("read_social_contact_permission", true);
        linkedHashMap.put("social_request_system_contact_permission", true);
        linkedHashMap.put("showInnerPush", true);
        linkedHashMap.put("luckycatRegisterStepListener", true);
        linkedHashMap.put("luckycatApplyStepPermission", true);
        linkedHashMap.put("luckycatGetStepCount", true);
        linkedHashMap.put("luckycatCheckStepPermission", true);
        linkedHashMap.put("luckycatIsStepCountSupport", true);
        linkedHashMap.put("luckycatTryInitPedometerSDK", true);
        linkedHashMap.put("luckycatUnregisterStepListener", true);
        linkedHashMap.put("isF2fFriendsFetchDisallow", true);
        linkedHashMap.put("requestSystemPermission", true);
        linkedHashMap.put("refreshAddictionInfo", true);
        specialXBridgeLogicForWebcast = linkedHashMap;
    }

    private final boolean isInSpecialList(String methodName) {
        Boolean bool = specialXBridgeLogicForWebcast.get(methodName);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final Map<String, Object> dealSpecialDataSwitch(String methodName, IBDXBridgeContext bridgeContext, Map<String, ? extends Object> data) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(data, "data");
        boolean z = false;
        if (Intrinsics.areEqual(bridgeContext.getNamespace(), "webcast") && bridgeContext.getPlatformType() == PlatformType.WEB && isInSpecialList(methodName)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.putAll(data);
            if (data.get("data") instanceof Map) {
                Object obj3 = data.get("code");
                Object obj4 = data.get("data");
                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                for (Map.Entry entry : ((Map) obj4).entrySet()) {
                    Object value = entry.getValue();
                    if (value != null) {
                        linkedHashMap.put(String.valueOf(entry.getKey()), value);
                        if (Intrinsics.areEqual("code", String.valueOf(entry.getKey()))) {
                            linkedHashMap.put("__code", value);
                        } else if (Intrinsics.areEqual("data", String.valueOf(entry.getKey()))) {
                            z = true;
                        }
                    }
                }
                if (!z) {
                    linkedHashMap.remove("data");
                }
                if (IConditionCallKt.enableAnnieXLiveJSBCodeFix()) {
                    if (linkedHashMap.get("__code") == null) {
                        linkedHashMap.put("__code", obj3);
                    }
                } else {
                    linkedHashMap.put("__code", obj3);
                }
            } else if (data.get("__code") == null && (obj2 = data.get("code")) != null) {
                linkedHashMap.put("__code", obj2);
            }
            linkedHashMap.put("code", 1);
            return linkedHashMap;
        }
        if (!Intrinsics.areEqual(bridgeContext.getNamespace(), "webcast") || bridgeContext.getPlatformType() != PlatformType.LYNX || !isInSpecialList(methodName)) {
            return data;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(data);
        linkedHashMap2.put("__msg_type", "callback");
        linkedHashMap2.put("eventId", 0);
        linkedHashMap2.put("__callback_id", "0");
        if (data.get("data") instanceof Map) {
            if (IConditionCallKt.enableAnnieXLiveJSBCodeFix()) {
                Object obj5 = data.get("data");
                Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                Map map = (Map) obj5;
                obj = map.get("__code");
                if (obj == null) {
                    obj = map.get("code");
                }
            } else {
                obj = linkedHashMap2.get("code");
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            Object obj6 = data.get("data");
            Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.Any, kotlin.Any>");
            linkedHashMap3.putAll((Map) obj6);
            if (obj != null) {
                linkedHashMap3.put("__code", obj);
            }
            linkedHashMap2.put("data", linkedHashMap3);
        }
        linkedHashMap2.put("code", 1);
        return linkedHashMap2;
    }
}
