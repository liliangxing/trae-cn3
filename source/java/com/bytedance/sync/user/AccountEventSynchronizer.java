package com.bytedance.sync.user;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sync.SDKMonitor;
import com.bytedance.sync.interfaze.IAccountService;
import com.bytedance.sync.interfaze.IDeviceInfoGetter;
import com.bytedance.sync.settings.SyncSettings;
import com.ss.android.ug.bus.UgCallbackCenter;
import com.ss.android.ug.bus.account.event.OnLoginEvent;
import com.ss.android.ug.bus.account.event.OnLogoutEvent;
import com.ss.android.ug.bus.account.event.OnSwitchEvent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class AccountEventSynchronizer implements IDeviceInfoGetter {
    private final IAccountService accountService;
    private final Context context;
    private String mDeviceId;
    private final List<UgCallbackCenter.Callback<Void>> mCallbacks = new ArrayList();
    private final List<UgCallbackCenter.Callback<Void>> mDeviceIdChangedCallbacks = new ArrayList();

    public AccountEventSynchronizer(Context context, IAccountService iAccountService) {
        this.context = context;
        this.accountService = iAccountService;
    }

    @Override // com.bytedance.sync.interfaze.IDeviceInfoGetter
    public void startListenAccountChangeEvent() {
        this.accountService.registerOnAccountSwitchListener(new UgCallbackCenter.Callback<OnSwitchEvent>() { // from class: com.bytedance.sync.user.AccountEventSynchronizer.1
            public void onCall(OnSwitchEvent onSwitchEvent) {
                AccountEventSynchronizer.this.onAccountChanged(true);
            }
        });
        this.accountService.registerOnLoginListener(new UgCallbackCenter.Callback<OnLoginEvent>() { // from class: com.bytedance.sync.user.AccountEventSynchronizer.2
            public void onCall(OnLoginEvent onLoginEvent) {
                AccountEventSynchronizer.this.onAccountChanged(true);
            }
        });
        this.accountService.registerOnLogoutListener(new UgCallbackCenter.Callback<OnLogoutEvent>() { // from class: com.bytedance.sync.user.AccountEventSynchronizer.3
            public void onCall(OnLogoutEvent onLogoutEvent) {
                AccountEventSynchronizer.this.onAccountChanged(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAccountChanged(boolean z) {
        synchronized (this) {
            for (UgCallbackCenter.Callback<Void> callback : this.mCallbacks) {
                if (callback != null) {
                    callback.onCall((Object) null);
                }
            }
        }
        SDKMonitor.inst().monitorAccountChanged(z);
    }

    @Override // com.bytedance.sync.interfaze.IDeviceInfoGetter
    public void updateDid(String str) {
        this.mDeviceId = str;
        SyncSettings.inst(this.context).setDid(str);
        synchronized (this) {
            for (UgCallbackCenter.Callback<Void> callback : this.mDeviceIdChangedCallbacks) {
                if (callback != null) {
                    callback.onCall((Object) null);
                }
            }
        }
    }

    @Override // com.bytedance.sync.interfaze.IDeviceInfoGetter
    public DeviceInfo getDeviceInfo() {
        String str = this.mDeviceId;
        if (TextUtils.isEmpty(str)) {
            str = SyncSettings.inst(this.context).getSavedDid();
        }
        String secUid = this.accountService.getSecUid();
        if (TextUtils.isEmpty(secUid)) {
            secUid = "0";
        }
        return new DeviceInfo(str, secUid);
    }

    @Override // com.bytedance.sync.interfaze.IDeviceInfoGetter
    public void addAccountLoginOrSwitchEventListener(UgCallbackCenter.Callback<Void> callback) {
        synchronized (this) {
            this.mCallbacks.add(callback);
        }
    }

    @Override // com.bytedance.sync.interfaze.IDeviceInfoGetter
    public void removeAccountLoginOrSwitchEventListener(UgCallbackCenter.Callback<Void> callback) {
        synchronized (this) {
            this.mCallbacks.remove(callback);
        }
    }

    @Override // com.bytedance.sync.interfaze.IDeviceInfoGetter
    public void addDeviceInfoChangedListener(UgCallbackCenter.Callback<Void> callback) {
        synchronized (this) {
            this.mCallbacks.add(callback);
            this.mDeviceIdChangedCallbacks.add(callback);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class DeviceInfo {
        public String did;
        public String uid;

        public DeviceInfo(String str, String str2) {
            this.did = str;
            this.uid = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            DeviceInfo deviceInfo = (DeviceInfo) obj;
            String str = this.did;
            if (str == null ? deviceInfo.did != null : !str.equals(deviceInfo.did)) {
                return false;
            }
            String str2 = this.uid;
            String str3 = deviceInfo.uid;
            return str2 != null ? str2.equals(str3) : str3 == null;
        }

        public int hashCode() {
            String str = this.did;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.uid;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String getDid() {
            return this.did;
        }

        public String getUid() {
            return this.uid;
        }
    }
}
