package com.bytedance.push.monitor;

import android.app.NotificationChannel;
import com.bytedance.push.interfaze.IMonitor;

/* loaded from: classes4.dex */
public class MonitorMock implements IMonitor {
    @Override // com.bytedance.push.interfaze.IMonitor
    public void init() {
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void markOuterSwitchStatusFailed(int i, String str) {
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void markOuterSwitchStatusSuccess() {
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void markOuterSwitchUploadFailed(int i, String str) {
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void markOuterSwitchUploadSuccess() {
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void markUpdateSenderFailed(int i, int i2, String str, String str2) {
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void markUpdateSenderSuccess() {
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void monitorDecryptResult(int i, int i2) {
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void monitorEvent(String str, String str2) {
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void monitorHarmonyOs4Compliance(boolean z, int i) {
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void monitorInitTimeCoast(long j) {
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void monitorNotificationCreate(NotificationChannel notificationChannel) {
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void monitorRegisterSender(int i) {
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void monitorRegisterSenderFailed(int i, int i2, String str, String str2) {
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void monitorRegisterSenderSuccess(int i) {
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void monitorSenderSupport(boolean z, String str) {
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void monitorShowEmpty(int i, String str, int i2, int i3) {
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void monitorStart() {
    }
}
