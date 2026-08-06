package com.bytedance.push.monitor;

import com.bytedance.push.utils.Logger;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class DefaultCommonPushSdkMonitorServiceImpl implements ICommonPushSdkMonitorService {
    @Override // com.bytedance.push.monitor.ICommonPushSdkMonitorService
    public void onRequestSuccess(String str, String str2, String str3, long j) {
        Logger.w("DefaultCommonPushSdkMonitorServiceImpl", "onRequestSuccess");
    }

    @Override // com.bytedance.push.monitor.ICommonPushSdkMonitorService
    public void onRequestFailed(String str, String str2, String str3, String str4, long j) {
        Logger.w("DefaultCommonPushSdkMonitorServiceImpl", "onRequestFailed");
    }

    @Override // com.bytedance.push.monitor.ICommonPushSdkMonitorService
    public void onRequestSuccess(String str, String str2, String str3, long j, JSONObject jSONObject) {
        Logger.w("DefaultCommonPushSdkMonitorServiceImpl", "onRequestSuccess v2");
    }

    @Override // com.bytedance.push.monitor.ICommonPushSdkMonitorService
    public void onRequestFailed(String str, String str2, String str3, String str4, long j, JSONObject jSONObject) {
        Logger.w("DefaultCommonPushSdkMonitorServiceImpl", "onRequestFailed v2");
    }
}
