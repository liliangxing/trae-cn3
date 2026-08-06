package com.bytedance.upc.common.device;

import android.text.TextUtils;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.IDataObserver;
import com.bytedance.upc.Configuration;
import com.bytedance.upc.IDeviceGetter;
import com.bytedance.upc.common.ICommonBusinessService;
import com.bytedance.upc.common.log.LogUtils;
import com.bytedance.upc.common.storage.SpDeviceInfoStorage;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.lynx.tasm.DefaultLogicExecutor;
import com.ss.android.common.applog.TeaAgent;
import com.ss.android.deviceregister.DeviceRegisterManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: DeviceInfoService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u001c\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0002J-\u0010\u001f\u001a\u00020\u00172#\u0010 \u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u0013H\u0016J\b\u0010!\u001a\u00020\u0017H\u0002J\b\u0010\"\u001a\u00020\u0017H\u0002J\b\u0010#\u001a\u00020\u0017H\u0002J&\u0010$\u001a\u00020\u00172\b\u0010%\u001a\u0004\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u00042\b\u0010'\u001a\u0004\u0018\u00010\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u0010\u001a+\u0012'\u0012%\u0012!\u0012\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u00130\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/upc/common/device/DeviceInfoService;", "Lcom/bytedance/upc/common/device/IDeviceInfoService;", "()V", "key_did", "", "key_install", "key_uid", "mConfiguration", "Lcom/bytedance/upc/Configuration;", "getMConfiguration", "()Lcom/bytedance/upc/Configuration;", "mConfiguration$delegate", "Lkotlin/Lazy;", "mDataObserver", "Lcom/bytedance/applog/IDataObserver;", "mDeviceId", "mDeviceLoadListeners", "", "Ljava/lang/ref/WeakReference;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", DefaultLogicExecutor.GLOBAL_EVENT_NAME, "did", "", "mDeviceRegister", "Lcom/ss/android/deviceregister/DeviceRegisterManager$OnDeviceConfigUpdateListener;", "mInstallId", "mUserId", "getDeviceInfo", "Lkotlin/Triple;", "onDeviceLoad", "registerDeviceLoadListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "tryAppLogObserver", "tryRegisterDeviceListener", "tryTeaAgentListener", "updateDeviceInfo", "deviceId", "userId", "installId", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class DeviceInfoService implements IDeviceInfoService {
    private IDataObserver mDataObserver;
    private String mDeviceId;
    private DeviceRegisterManager.OnDeviceConfigUpdateListener mDeviceRegister;
    private String mInstallId;
    private String mUserId;
    private final String key_did = "deviceId";
    private final String key_uid = "userId";
    private final String key_install = "installId";
    private final List<WeakReference<Function1<String, Unit>>> mDeviceLoadListeners = new ArrayList();

    /* renamed from: mConfiguration$delegate, reason: from kotlin metadata */
    private final Lazy mConfiguration = LazyKt.lazy(new Function0<Configuration>() { // from class: com.bytedance.upc.common.device.DeviceInfoService$mConfiguration$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Configuration m2602invoke() {
            return ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration();
        }
    });

    private final Configuration getMConfiguration() {
        return (Configuration) this.mConfiguration.getValue();
    }

    @Override // com.bytedance.upc.common.device.IDeviceInfoService
    public void updateDeviceInfo(String deviceId, String userId, String installId) {
        if (!TextUtils.isEmpty(deviceId)) {
            this.mDeviceId = deviceId;
        }
        this.mUserId = userId;
        if (!TextUtils.isEmpty(installId)) {
            this.mInstallId = this.mInstallId;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(this.key_did, this.mDeviceId);
        jSONObject.put(this.key_uid, this.mUserId);
        jSONObject.put(this.key_install, this.mInstallId);
        SpDeviceInfoStorage.INSTANCE.updateDeviceInfo(jSONObject.toString());
    }

    @Override // com.bytedance.upc.common.device.IDeviceInfoService
    public Triple<String, String, String> getDeviceInfo() {
        IDeviceGetter iDeviceGetter = getMConfiguration().mIDeviceGetter;
        String deviceId = iDeviceGetter != null ? iDeviceGetter.getDeviceId() : null;
        this.mDeviceId = deviceId;
        if (!TextUtils.isEmpty(deviceId)) {
            return new Triple<>(this.mDeviceId, this.mUserId, this.mInstallId);
        }
        if (TextUtils.isEmpty(this.mDeviceId) || TextUtils.isEmpty(this.mUserId) || TextUtils.isEmpty(this.mInstallId)) {
            try {
                tryRegisterDeviceListener();
                String deviceInfo = SpDeviceInfoStorage.INSTANCE.getDeviceInfo();
                if (deviceInfo == null) {
                    deviceInfo = "";
                }
                JSONObject jSONObject = new JSONObject(deviceInfo);
                return new Triple<>(jSONObject.optString(this.key_did), jSONObject.optString(this.key_uid), jSONObject.optString(this.key_install));
            } catch (Throwable unused) {
            }
        }
        return new Triple<>(this.mDeviceId, this.mUserId, this.mInstallId);
    }

    @Override // com.bytedance.upc.common.device.IDeviceInfoService
    public void registerDeviceLoadListener(Function1<? super String, Unit> listener) {
        Intrinsics.checkParameterIsNotNull(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mDeviceLoadListeners.add(new WeakReference<>(listener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDeviceLoad(String did) {
        if (TextUtils.isEmpty(did)) {
            return;
        }
        Iterator<T> it = this.mDeviceLoadListeners.iterator();
        while (it.hasNext()) {
            Function1 function1 = (Function1) ((WeakReference) it.next()).get();
            if (function1 != null) {
            }
        }
    }

    private final void tryRegisterDeviceListener() {
        boolean z;
        try {
            Class.forName("com.ss.android.common.applog.TeaAgent");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        if (z) {
            try {
                tryTeaAgentListener();
                return;
            } catch (Throwable th) {
                LogUtils.m8e(th);
                return;
            }
        }
        try {
            Class.forName("com.bytedance.applog.AppLog");
            tryAppLogObserver();
        } catch (Throwable th2) {
            LogUtils.m8e(th2);
        }
    }

    private final void tryAppLogObserver() {
        String did = AppLog.getDid();
        String str = did;
        if (!(str == null || StringsKt.isBlank(str))) {
            updateDeviceInfo(did, null, null);
        } else if (this.mDataObserver == null) {
            IDataObserver iDataObserver = new IDataObserver() { // from class: com.bytedance.upc.common.device.DeviceInfoService$tryAppLogObserver$1
                public void onAbVidsChange(String vids, String extVids) {
                }

                public void onRemoteAbConfigGet(boolean changed, JSONObject abConfig) {
                }

                public void onRemoteConfigGet(boolean changed, JSONObject config) {
                }

                public void onIdLoaded(String did2, String iid, String ssid) {
                    String str2 = did2;
                    if (str2 == null || StringsKt.isBlank(str2)) {
                        return;
                    }
                    DeviceInfoService.this.updateDeviceInfo(did2, null, null);
                    DeviceInfoService.this.onDeviceLoad(did2);
                }

                public void onRemoteIdGet(boolean changed, String oldDid, String newDid, String oldIid, String newIid, String oldSsid, String newSsid) {
                    String str2 = newDid;
                    if (str2 == null || StringsKt.isBlank(str2)) {
                        return;
                    }
                    DeviceInfoService.this.updateDeviceInfo(newDid, null, null);
                    DeviceInfoService.this.onDeviceLoad(newDid);
                }
            };
            this.mDataObserver = iDataObserver;
            AppLog.addDataObserver(iDataObserver);
        }
    }

    private final void tryTeaAgentListener() {
        String serverDeviceId = TeaAgent.getServerDeviceId();
        String str = serverDeviceId;
        if (!(str == null || StringsKt.isBlank(str))) {
            updateDeviceInfo(serverDeviceId, null, null);
            return;
        }
        DeviceRegisterManager.OnDeviceConfigUpdateListener onDeviceConfigUpdateListener = new DeviceRegisterManager.OnDeviceConfigUpdateListener() { // from class: com.bytedance.upc.common.device.DeviceInfoService$tryTeaAgentListener$1
            public void onRemoteConfigUpdate(boolean success, boolean noPreviousDid) {
            }

            public void onDeviceRegistrationInfoChanged(String did, String iid) {
                DeviceInfoService.this.updateDeviceInfo(did != null ? did : TeaAgent.getServerDeviceId(), null, null);
                DeviceInfoService.this.onDeviceLoad(did);
            }

            public void onDidLoadLocally(boolean success) {
                if (success) {
                    DeviceInfoService.this.updateDeviceInfo(TeaAgent.getServerDeviceId(), null, null);
                    DeviceInfoService.this.onDeviceLoad(TeaAgent.getServerDeviceId());
                }
            }
        };
        this.mDeviceRegister = onDeviceConfigUpdateListener;
        DeviceRegisterManager.addOnDeviceConfigUpdateListener(onDeviceConfigUpdateListener);
    }
}
