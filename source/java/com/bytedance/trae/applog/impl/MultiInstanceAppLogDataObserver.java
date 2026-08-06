package com.bytedance.trae.applog.impl;

import com.bytedance.applog.IDataObserver;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: MultiInstanceAppLogServiceImpl.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016JL\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/applog/impl/MultiInstanceAppLogDataObserver;", "Lcom/bytedance/applog/IDataObserver;", "<init>", "()V", "onIdLoaded", "", CommonConstants.KEY_DEVICE_ID, "", "iid", "ssid", "onRemoteIdGet", "changed", "", "oldDid", "newDid", "oldIid", "newIid", "oldSsid", "newSsid", "onRemoteConfigGet", "config", "Lorg/json/JSONObject;", "onRemoteAbConfigGet", "abConfig", "onAbVidsChange", "vids", "extVids", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MultiInstanceAppLogDataObserver implements IDataObserver {
    @Override // com.bytedance.applog.IDataObserver
    public void onAbVidsChange(String vids, String extVids) {
    }

    @Override // com.bytedance.applog.IDataObserver
    public void onIdLoaded(String did, String iid, String ssid) {
    }

    @Override // com.bytedance.applog.IDataObserver
    public void onRemoteAbConfigGet(boolean changed, JSONObject abConfig) {
    }

    @Override // com.bytedance.applog.IDataObserver
    public void onRemoteConfigGet(boolean changed, JSONObject config) {
    }

    @Override // com.bytedance.applog.IDataObserver
    public void onRemoteIdGet(boolean changed, String oldDid, String newDid, String oldIid, String newIid, String oldSsid, String newSsid) {
    }
}
