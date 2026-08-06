package com.huawei.multimedia.audiokit.interfaces;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.multimedia.audioengine.IHwAudioEngine;
import com.huawei.multimedia.audiokit.config.Version;
import com.huawei.multimedia.audiokit.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class HwAudioKit {
    private static final List<Integer> DEFAULT_FEATURE_LIST = new ArrayList(0);
    private static final int DEFAULT_VALUE = 0;
    private static final String ENGINE_CLASS_NAME = "com.huawei.multimedia.audioengine.HwAudioEngineService";
    private static final String ENGINE_PACKAGE_NAME = "com.huawei.multimedia.audioengine";
    private static final String TAG = "HwAudioKit.HwAudioKit";
    private Context mContext;
    private FeatureKitManager mFeatureKitManager;
    private IHwAudioEngine mIHwAudioEngine = null;
    private boolean mIsServiceConnected = false;
    private IBinder mService = null;
    private ServiceConnection mConnection = new ServiceConnection() { // from class: com.huawei.multimedia.audiokit.interfaces.HwAudioKit.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            HwAudioKit.this.mIHwAudioEngine = IHwAudioEngine.Stub.asInterface(iBinder);
            LogUtils.info(HwAudioKit.TAG, "onServiceConnected");
            if (HwAudioKit.this.mIHwAudioEngine != null) {
                HwAudioKit.this.mIsServiceConnected = true;
                LogUtils.info(HwAudioKit.TAG, "onServiceConnected, mIHwAudioEngine is not null");
                HwAudioKit.this.mFeatureKitManager.onCallBack(0);
                HwAudioKit hwAudioKit = HwAudioKit.this;
                hwAudioKit.serviceInit(hwAudioKit.mContext.getPackageName(), "1.0.3");
                HwAudioKit.this.serviceLinkToDeath(iBinder);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            LogUtils.info(HwAudioKit.TAG, "onServiceDisconnected");
            HwAudioKit.this.mIHwAudioEngine = null;
            HwAudioKit.this.mIsServiceConnected = false;
            HwAudioKit.this.mFeatureKitManager.onCallBack(4);
        }
    };
    private IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() { // from class: com.huawei.multimedia.audiokit.interfaces.HwAudioKit.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            HwAudioKit.this.mService.unlinkToDeath(HwAudioKit.this.mDeathRecipient, 0);
            HwAudioKit.this.mFeatureKitManager.onCallBack(6);
            LogUtils.error(HwAudioKit.TAG, "service binder died");
            HwAudioKit.this.mService = null;
        }
    };

    /* loaded from: classes6.dex */
    public enum FeatureType {
        HWAUDIO_FEATURE_KARAOKE(1);

        private int mFeatureType;

        FeatureType(int i) {
            this.mFeatureType = i;
        }

        public int getFeatureType() {
            return this.mFeatureType;
        }
    }

    public HwAudioKit(Context context, IAudioKitCallback iAudioKitCallback) {
        this.mContext = null;
        FeatureKitManager featureKitManager = FeatureKitManager.getInstance();
        this.mFeatureKitManager = featureKitManager;
        featureKitManager.setCallBack(iAudioKitCallback);
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void serviceLinkToDeath(IBinder iBinder) {
        this.mService = iBinder;
        if (iBinder != null) {
            try {
                iBinder.linkToDeath(this.mDeathRecipient, 0);
            } catch (RemoteException unused) {
                this.mFeatureKitManager.onCallBack(5);
                LogUtils.error(TAG, "serviceLinkToDeath, RemoteException");
            }
        }
    }

    public void initialize() {
        LogUtils.info(TAG, "initialize");
        Context context = this.mContext;
        if (context == null) {
            LogUtils.info(TAG, "mContext is null");
            this.mFeatureKitManager.onCallBack(7);
        } else if (!this.mFeatureKitManager.isAudioKitSupport(context)) {
            LogUtils.info(TAG, "not install AudioKitEngine");
            this.mFeatureKitManager.onCallBack(2);
        } else {
            bindService(this.mContext);
        }
    }

    private void bindService(Context context) {
        LogUtils.info(TAG, "bindService, mIsServiceConnected = " + this.mIsServiceConnected);
        FeatureKitManager featureKitManager = this.mFeatureKitManager;
        if (featureKitManager == null || this.mIsServiceConnected) {
            return;
        }
        featureKitManager.bindService(context, this.mConnection, ENGINE_CLASS_NAME);
    }

    public void destroy() {
        LogUtils.info(TAG, "destroy, mIsServiceConnected = " + this.mIsServiceConnected);
        if (this.mIsServiceConnected) {
            this.mIsServiceConnected = false;
            this.mFeatureKitManager.unbindService(this.mContext, this.mConnection);
        }
    }

    public long getAudioVersion(Context context, String str) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return 0L;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo == null) {
                LogUtils.info(TAG, "packageInfo is null");
                return 0L;
            }
            return packageInfo.getLongVersionCode();
        } catch (PackageManager.NameNotFoundException e) {
            LogUtils.error(TAG, "getAudioVersion Exception e = " + e.getMessage());
            return 0L;
        }
    }

    public boolean isSdkVersionMoreEngineVersion() {
        return Version.SDK_VERSION > getAudioVersion(this.mContext, ENGINE_PACKAGE_NAME);
    }

    public EnhancedDeviceInfo getEnhancedDeviceInfo(int i) throws UnsupportedVersionException {
        if (this.mContext == null) {
            LogUtils.error(TAG, " getEnhancedDeviceInfo mContext is null");
            return null;
        }
        if (i != 4 && i != 3 && i != 11 && i != 22 && i != 8) {
            LogUtils.error(TAG, " getEnhancedDeviceInfo device type is not supported");
            return null;
        }
        if (isSdkVersionMoreEngineVersion()) {
            throw new UnsupportedVersionException();
        }
        return new EnhancedDeviceInfo(this.mContext, i);
    }

    public List<Integer> getSupportedFeatures() {
        LogUtils.info(TAG, "getSupportedFeatures");
        try {
            IHwAudioEngine iHwAudioEngine = this.mIHwAudioEngine;
            if (iHwAudioEngine != null && this.mIsServiceConnected) {
                return iHwAudioEngine.getSupportedFeatures();
            }
        } catch (RemoteException unused) {
            LogUtils.error(TAG, "getSupportedFeatures, createFeature,wait bind service fail");
        }
        LogUtils.info(TAG, "getSupportedFeatures, service not bind");
        return DEFAULT_FEATURE_LIST;
    }

    public boolean isFeatureSupported(FeatureType featureType) {
        if (featureType == null) {
            return false;
        }
        LogUtils.info(TAG, "isFeatureSupported, type = " + featureType.getFeatureType());
        try {
            IHwAudioEngine iHwAudioEngine = this.mIHwAudioEngine;
            if (iHwAudioEngine != null && this.mIsServiceConnected) {
                return iHwAudioEngine.isFeatureSupported(featureType.getFeatureType());
            }
        } catch (RemoteException e) {
            LogUtils.error(TAG, "isFeatureSupported,RemoteException ex : " + e.getMessage());
        }
        return false;
    }

    public <T extends AudioFeaturesKit> T createFeature(FeatureType featureType) {
        FeatureKitManager featureKitManager = this.mFeatureKitManager;
        if (featureKitManager == null || featureType == null) {
            return null;
        }
        return (T) featureKitManager.createFeatureKit(featureType.getFeatureType(), this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void serviceInit(String str, String str2) {
        LogUtils.info(TAG, "serviceInit");
        try {
            IHwAudioEngine iHwAudioEngine = this.mIHwAudioEngine;
            if (iHwAudioEngine == null || !this.mIsServiceConnected) {
                return;
            }
            iHwAudioEngine.init(str, str2);
        } catch (RemoteException e) {
            LogUtils.error(TAG, "isFeatureSupported,RemoteException ex :" + e.getMessage());
        }
    }
}
