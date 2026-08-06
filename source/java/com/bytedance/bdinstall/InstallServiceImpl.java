package com.bytedance.bdinstall;

import android.accounts.Account;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.callback.CallbackCenter;
import com.bytedance.bdinstall.callback.event.HeaderChangeEvent;
import com.bytedance.bdinstall.loader.DeviceManager;
import com.bytedance.bdinstall.loader.LocaleDeviceManager;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.service.IInstallService;
import com.bytedance.bdinstall.service.INewUserModeService;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.util.Constants;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.bdinstall.util.TimeoutInstallListener;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class InstallServiceImpl implements IInstallService {
    private static final AtomicBoolean mRegistered = new AtomicBoolean(false);
    private IBDInstallApi mBDInstallApi;
    private volatile CallbackCenter mCallbackCenter;
    private volatile DeviceManager mDeviceManager;
    private volatile InstallDispatcher mInstallDispatcher;
    private volatile InstallOptions sOptions;
    private final AtomicBoolean sStarted = new AtomicBoolean(false);

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void setInstallInfo(InstallInfo installInfo) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InstallServiceImpl(IBDInstallApi iBDInstallApi) {
        this.mBDInstallApi = iBDInstallApi;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void init(InstallOptions installOptions, Env env) {
        long currentTimeMillis = System.currentTimeMillis();
        DrLog.m139d("main process install#init：aid: " + installOptions.getAid());
        synchronized (this) {
            if (this.mInstallDispatcher == null) {
                this.sOptions = installOptions;
                if (TextUtils.equals(installOptions.getChannel(), "local_test")) {
                    try {
                        ServiceManager.registerService(INewUserModeService.class, (INewUserModeService) Class.forName(Constants.NAME_NEW_USER_IMPL).getConstructor(InstallOptions.class).newInstance(installOptions), String.valueOf(installOptions.getAid()));
                    } catch (Throwable unused) {
                        DrLog.m140e("not find new user mode impl ,ignore");
                    }
                }
                this.mDeviceManager = new LocaleDeviceManager(installOptions.getContext(), installOptions, env);
                this.mDeviceManager.setCallbackCenter(this.mCallbackCenter);
                this.mInstallDispatcher = new InstallDispatcher(installOptions, this.mDeviceManager, BDInstall.getAppLifeCycleListener(), env);
                this.mInstallDispatcher.setCallbackCenter(this.mCallbackCenter);
                this.mDeviceManager.setEgdiCallback(this.mInstallDispatcher);
                ServiceManager.registerService(DeviceTokenService.class, new DeviceTokenServiceImpl(installOptions, env), String.valueOf(installOptions.getAid()));
            }
        }
        DrLog.m139d("init ：" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void setCallbackCenter(CallbackCenter callbackCenter) {
        this.mCallbackCenter = callbackCenter;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void start() {
        if (!hasInit() || this.sOptions == null) {
            throw new RuntimeException("please init first");
        }
        DrLog.m139d("install#start aid : " + this.sOptions.getAid());
        ExecutorUtil.runOnHandlerThread(this.sOptions.getAidString(), new Runnable() { // from class: com.bytedance.bdinstall.InstallServiceImpl.1
            @Override // java.lang.Runnable
            public void run() {
                InstallServiceImpl.this.doStart(false);
            }
        });
        setStarted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStarted() {
        if (LocalConstants.getCommonSp(this.sOptions.getContext(), this.sOptions).getBoolean(Api.KEY_STARTED, false)) {
            return;
        }
        LocalConstants.getCommonSp(this.sOptions.getContext(), this.sOptions).edit().putBoolean(Api.KEY_STARTED, true).apply();
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void registerLifeCycleListener(Application application) {
        if (application != null && mRegistered.compareAndSet(false, true)) {
            BDInstall.registerLifeCycleListener(application);
        }
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void clearAndSetEnv(final Env env) {
        DrLog.m139d("install#clearInstallInfoWhenSwitchChildMode");
        if (this.mInstallDispatcher != null && this.sOptions != null && this.mDeviceManager != null) {
            DrLog.m139d("clearInstallInfoWhenSwitchChildMode " + env);
            ExecutorUtil.runOnHandlerThread(this.sOptions.getAidString(), new Runnable() { // from class: com.bytedance.bdinstall.InstallServiceImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    InstallServiceImpl.this.mInstallDispatcher.changeEnv(env, false);
                    InstallServiceImpl.this.mDeviceManager.clear();
                    InstallServiceImpl.this.mDeviceManager.loadHeaderAndNotify();
                }
            });
        } else {
            DrLog.ysnp(new RuntimeException("not init yet"));
        }
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void resetAndReInstall(Context context, final Env env, long j, OnResetListener onResetListener) {
        DrLog.m139d("install#resetInstallInfoWhenSwitchChildMode");
        if (this.mInstallDispatcher != null) {
            DrLog.m139d("resetInstallInfoWhenSwitchChildMode " + env);
            TimeoutInstallListener timeoutInstallListener = new TimeoutInstallListener(j, onResetListener, this.sOptions);
            this.mBDInstallApi.addInstallListener(false, timeoutInstallListener);
            timeoutInstallListener.startTiming();
            if (this.sOptions != null) {
                ExecutorUtil.runOnHandlerThread(this.sOptions.getAidString(), new Runnable() { // from class: com.bytedance.bdinstall.InstallServiceImpl.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (InstallServiceImpl.this.sStarted.get()) {
                            InstallServiceImpl.this.mInstallDispatcher.reStart(env, true, false);
                            return;
                        }
                        DrLog.m139d("not start yet,start it " + env);
                        InstallServiceImpl.this.mInstallDispatcher.changeEnv(env, false);
                        InstallServiceImpl.this.doStart(true);
                        InstallServiceImpl.this.setStarted();
                    }
                });
                return;
            }
            return;
        }
        DrLog.ysnp(new RuntimeException("not init yet"));
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void changeUriRuntimeAndReInstall(final Env env) {
        DrLog.m139d("install#changeUriRuntimeAndReInstall");
        if (this.mInstallDispatcher != null && this.sOptions != null) {
            DrLog.m139d("changeUriRuntimeAndReInstall " + env);
            ExecutorUtil.runOnHandlerThread(this.sOptions.getAidString(), new Runnable() { // from class: com.bytedance.bdinstall.InstallServiceImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    if (InstallServiceImpl.this.sStarted.get()) {
                        InstallServiceImpl.this.mInstallDispatcher.reStart(env, false, true);
                        return;
                    }
                    DrLog.m139d("not start yet,start it " + env);
                    InstallServiceImpl.this.mInstallDispatcher.changeEnv(env, true);
                    InstallServiceImpl.this.doStart(true);
                    InstallServiceImpl.this.setStarted();
                }
            });
        } else {
            DrLog.ysnp(new RuntimeException("not init yet"));
        }
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public InstallInfo getInstallInfo() {
        if (this.mDeviceManager == null) {
            return null;
        }
        return this.mDeviceManager.getInstallInfo();
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public String getDid() {
        if (this.mDeviceManager == null) {
            return null;
        }
        return this.mDeviceManager.getDid();
    }

    private boolean hasInit() {
        return this.mInstallDispatcher != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doStart(boolean z) {
        if (!hasInit() || this.sOptions == null) {
            throw new RuntimeException("please init first");
        }
        if (this.sStarted.getAndSet(true)) {
            return;
        }
        INewUserModeService iNewUserModeService = (INewUserModeService) ServiceManager.getService(INewUserModeService.class, this.sOptions.getAidString());
        if (iNewUserModeService != null) {
            iNewUserModeService.start();
        }
        this.mDeviceManager.start();
        this.mInstallDispatcher.start(z);
        OpInstallOptionsHelper opInstallOptionsHelper = new OpInstallOptionsHelper(this.sOptions.getContext());
        opInstallOptionsHelper.setInstallOptions(this.sOptions);
        opInstallOptionsHelper.trySync();
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void updateMemoryHeader(Context context, Map<String, Object> map) {
        boolean z;
        if (this.mDeviceManager != null) {
            loop0: while (true) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    z = this.mDeviceManager.updateHeader(entry.getKey(), entry.getValue()) || z;
                }
            }
            if (!z || this.mCallbackCenter == null) {
                return;
            }
            this.mCallbackCenter.postEvent(new HeaderChangeEvent(this.mDeviceManager.getConstHeader()));
        }
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void updateHeader(Context context, Map<String, String> map, boolean z, boolean z2) {
        SharedPreferences.Editor edit = z ? LocalConstants.getCommonSp(context, this.sOptions).edit() : null;
        boolean z3 = false;
        if (this.mDeviceManager != null) {
            boolean z4 = false;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                z4 = this.mDeviceManager.updateHeader(key, value) || z4;
                if (edit != null) {
                    edit.putString(key, value);
                }
            }
            if (edit != null) {
                edit.apply();
            }
            z3 = z4;
        }
        if (z3 && z2 && this.mInstallDispatcher != null) {
            this.mInstallDispatcher.redoRegister();
        }
        if (!z3 || this.mCallbackCenter == null) {
            return;
        }
        this.mCallbackCenter.postEvent(new HeaderChangeEvent(this.mDeviceManager.getConstHeader()));
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public boolean activeManually() {
        DrLog.m139d("install#activeManually");
        if (!hasInit() || this.sOptions == null) {
            return false;
        }
        ExecutorUtil.runOnHandlerThread(this.sOptions.getAidString(), new Runnable() { // from class: com.bytedance.bdinstall.InstallServiceImpl.5
            @Override // java.lang.Runnable
            public void run() {
                InstallDispatcher installDispatcher = InstallServiceImpl.this.mInstallDispatcher;
                if (installDispatcher != null) {
                    installDispatcher.activeManually();
                } else {
                    DrLog.ysnp(new RuntimeException("active failed"));
                }
            }
        });
        return true;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void setAccount(final Account account) {
        if (this.sOptions == null) {
            return;
        }
        ExecutorUtil.runOnHandlerThread(this.sOptions.getAidString(), new Runnable() { // from class: com.bytedance.bdinstall.InstallServiceImpl.6
            @Override // java.lang.Runnable
            public void run() {
                if (InstallServiceImpl.this.sOptions != null) {
                    InstallServiceImpl.this.sOptions.setAccount(account);
                }
                IInstallParameters iInstallParameters = (IInstallParameters) ServiceManager.getService(IInstallParameters.class, String.valueOf(InstallServiceImpl.this.sOptions.getAid()));
                if (iInstallParameters != null) {
                    iInstallParameters.setAccount(account);
                }
            }
        });
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public JSONObject loadOrGetHeader() {
        if (!hasInit() || this.mDeviceManager == null) {
            return null;
        }
        JSONObject loadOrGetHeader = this.mDeviceManager.loadOrGetHeader();
        JSONObject jSONObject = new JSONObject();
        Utils.copy(jSONObject, loadOrGetHeader);
        return jSONObject;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public boolean getHeader(JSONObject jSONObject) {
        JSONObject header;
        if (this.mDeviceManager == null || (header = this.mDeviceManager.getHeader()) == null) {
            return false;
        }
        Utils.copy(jSONObject, header);
        return true;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public boolean isNewUserFirstLaunch() {
        if (this.mDeviceManager != null) {
            return this.mDeviceManager.isNewUser();
        }
        return false;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public Env getCurEnv() {
        if (this.mDeviceManager == null) {
            return null;
        }
        return this.mDeviceManager.getCurEnv();
    }
}
