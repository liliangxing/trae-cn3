package com.bytedance.android.service.manager.push.monitor;

import android.content.Context;
import android.util.Log;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class IPushSdkMonitorServiceImplOfMock implements IPushSdkMonitorService {
    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void initOnApplication(Context context) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onActivityDepthsDeviceStatus(JSONObject jSONObject) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onActivityStartResult(boolean z, int i, String str, String str2, String str3, long j, String str4) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onActivityStartReturnValue(String str, JSONObject jSONObject, int i) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onBadgeOperateFailed(int i, Integer num, String str) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onBadgeOperateSuccess(int i, Integer num) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onContentRequest(String str, int i, int i2) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onContentShow(String str, String str2, int i) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onInvalidMrDepths(Context context, List<String> list) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onKeepAliveFrom(String str, String str2, int i) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onLaunchEvent(boolean z, boolean z2, long j, long j2, int i, int i2, String str) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onMessageArrive(long j) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onMessageShow(long j, long j2) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onProcessStartEvent(boolean z, boolean z2, long j, long j2, int i, int i2, String str, boolean z3) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onProfileIdOperateResult(int i, int i2, int i3, long j, String str) {
    }

    @Override // com.bytedance.push.monitor.ICommonPushSdkMonitorService
    public void onRequestFailed(String str, String str2, String str3, String str4, long j) {
    }

    @Override // com.bytedance.push.monitor.ICommonPushSdkMonitorService
    public void onRequestFailed(String str, String str2, String str3, String str4, long j, JSONObject jSONObject) {
    }

    @Override // com.bytedance.push.monitor.ICommonPushSdkMonitorService
    public void onRequestSuccess(String str, String str2, String str3, long j) {
    }

    @Override // com.bytedance.push.monitor.ICommonPushSdkMonitorService
    public void onRequestSuccess(String str, String str2, String str3, long j, JSONObject jSONObject) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onTokenRetry(int i, String str) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onTokenRetryResult(int i, boolean z, String str) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onTransmitStrategyRequest() {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public boolean curIsDau() {
        Log.w("IPushSdkMonitorService", "cur curIsDau method is empty impl in IPushSdkMonitorServiceImplOfMockClass");
        return false;
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public boolean curIsTransmit() {
        Log.w("IPushSdkMonitorService", "cur curIsTransmit method is empty impl in IPushSdkMonitorServiceImplOfMockClass");
        return false;
    }
}
