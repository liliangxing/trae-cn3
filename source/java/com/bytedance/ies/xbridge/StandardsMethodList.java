package com.bytedance.ies.xbridge;

import com.bytedance.sdk.xbridge.cn.pasteboard.idl_bridge.XCopyMethod;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/* compiled from: StandardsMethodList.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/xbridge/StandardsMethodList;", "", "()V", "list", "", "", "getList", "()Ljava/util/Set;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class StandardsMethodList {
    public static final StandardsMethodList INSTANCE = new StandardsMethodList();
    private static final Set<String> list = SetsKt.setOf((Object[]) new String[]{"x.getStorageInfo", "x.setStorageItem", "x.getStorageItem", "x.removeStorageItem", XCopyMethod.METHOD_NAME, "x.publishEvent", "x.getUserInfo", "x.login", "x.logout", "x.subscribeEvent", "x.unsubscribeEvent", "x.canIUse", "x.getContainerID", "x.getAppInfo", "x.getSettings", "x.reportAppLog", "x.reportADLog", "x.reportMonitorLog", "x.reportALog", "x.chooseMedia", "x.uploadImage", "x.downloadFile", "x.getAPIParams", "x.request", "x.scanCode", "x.open", "x.close", "x.allowCaptureScreen", "x.checkPermission", "x.makePhoneCall", "x.sendSMS", "x.setCalendarEvent", "x.removeCalendarEvent", "x.vibrate", "x.configureStatusBar", "x.showLoading", "x.hideLoading", "x.showToast", "x.showModal", "x.showActionSheet", "x.closeSocket", "x.connectSocket", "x.sendSocketData", "x.batchEvents", "x.createCalendarEvent", "x.readCalendarEvent", "x.deleteCalendarEvent", "x.updateGecko", "x.getGeckoInfo", "x.startGyroscope", "x.stopGyroscope", "x.getMethodList", "x.getDebugInfo", "registerBtmPage", "createBtmChain", "createBtmId", "setBcmParams", "getBcmChain", "appendEntranceInfo", "getBcmChainAndCartTrack", "setBcmPageParamsV2", "getBcmChainV2"});

    private StandardsMethodList() {
    }

    public final Set<String> getList() {
        return list;
    }
}
