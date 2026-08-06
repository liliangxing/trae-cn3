package com.bytedance.bdturing.livedetect.pty;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.LogUtil;
import com.bytedance.bdturing.livedetect.LiveAuthConfig;
import com.bytedance.bdturing.livedetect.LiveDetectService;
import com.bytedance.pitaya.api.IPitayaCore;
import com.bytedance.pitaya.api.PTYDIDCallback;
import com.bytedance.pitaya.api.PTYPackageCallback;
import com.bytedance.pitaya.api.PTYSetupCallback;
import com.bytedance.pitaya.api.PTYTaskResultCallback;
import com.bytedance.pitaya.api.PTYUIDCallback;
import com.bytedance.pitaya.api.PitayaCoreFactory;
import com.bytedance.pitaya.api.bean.PTYCvMat;
import com.bytedance.pitaya.api.bean.PTYError;
import com.bytedance.pitaya.api.bean.PTYErrorCode;
import com.bytedance.pitaya.api.bean.PTYPackageInfo;
import com.bytedance.pitaya.api.bean.PTYSetupInfo;
import com.bytedance.pitaya.api.bean.PTYTaskConfig;
import com.bytedance.pitaya.api.bean.PTYTaskData;
import com.bytedance.pitaya.api.mutilinstance.HostSetupListener;
import com.bytedance.pitaya.api.mutilinstance.HostSetupWatcher;
import com.bytedance.pitaya.api.mutilinstance.PreHostSetupListener;
import com.bytedance.pitaya.api.mutilinstance.PreHostSetupWatcher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TuringPTYManager {
    private static final String BIZ_NAME_ONLINE = "live_detect";
    private static final String BIZ_NAME_TEST = "live_detect_test";
    private static final int INIT_STATE_0 = 0;
    private static final int INIT_STATE_1 = 1;
    private static final int INIT_STATE_2 = 2;
    private static final int INIT_STATE_3 = 3;
    private static final int INIT_STATE_4 = 4;
    private static final int INIT_STATE_5 = 5;
    private static final int INIT_STATE_6 = 6;
    private static final String SDK_AID = "3216";
    private static final String TAG = "TuringPTYManager";
    private static volatile TuringPTYManager sInstance;
    private IPitayaCore mPTYCore;
    private PTYTaskResultCallback mPTYTaskCallBack;
    private int mInitState = 0;
    private AtomicBoolean mPreheated = new AtomicBoolean(false);
    private AtomicBoolean mIsRunning = new AtomicBoolean(false);
    private AtomicBoolean mPreheating = new AtomicBoolean(false);
    private AtomicBoolean mPkgLoaded = new AtomicBoolean(false);

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface TuringPtyPkgCallBack {
        void onResult(boolean z);
    }

    private TuringPTYManager() {
    }

    public static TuringPTYManager getInstance() {
        if (sInstance == null) {
            synchronized (TuringPTYManager.class) {
                if (sInstance == null) {
                    sInstance = new TuringPTYManager();
                }
            }
        }
        return sInstance;
    }

    public int getInitState() {
        return this.mInitState;
    }

    public void initPTY(final Context context, final PTYInitCallBack pTYInitCallBack, final String str) {
        try {
            if (isPTYReady()) {
                this.mInitState = 6;
                if (pTYInitCallBack != null) {
                    pTYInitCallBack.onResult(true);
                    return;
                }
                return;
            }
            if (!isPTYAvailable()) {
                if (!HostSetupWatcher.INSTANCE.isHostSetup() && !PreHostSetupWatcher.INSTANCE.isPreHostSetup()) {
                    HostSetupWatcher.INSTANCE.registerHostSetupListener(new HostSetupListener() { // from class: com.bytedance.bdturing.livedetect.pty.TuringPTYManager.1
                        public void onHostSetup(boolean z) {
                            LiveAuthConfig.mPtyHostEnable = true;
                            if (z) {
                                TuringPTYManager.this.doPTYInit(context, pTYInitCallBack, str);
                                return;
                            }
                            EventReport.initPTY(false, str);
                            PTYInitCallBack pTYInitCallBack2 = pTYInitCallBack;
                            if (pTYInitCallBack2 != null) {
                                pTYInitCallBack2.onResult(false);
                            }
                        }
                    });
                    PreHostSetupWatcher.INSTANCE.registerListener(new PreHostSetupListener() { // from class: com.bytedance.bdturing.livedetect.pty.TuringPTYManager.2
                        public void onPreHostSetup(boolean z) {
                            LiveAuthConfig.mPtyHostEnable = true;
                            if (z) {
                                TuringPTYManager.this.doPTYInit(context, pTYInitCallBack, str);
                                return;
                            }
                            EventReport.initPTY(false, str);
                            PTYInitCallBack pTYInitCallBack2 = pTYInitCallBack;
                            if (pTYInitCallBack2 != null) {
                                pTYInitCallBack2.onResult(false);
                            }
                        }
                    });
                    this.mInitState = 1;
                    return;
                }
                doPTYInit(context, pTYInitCallBack, str);
                LiveAuthConfig.mPtyHostEnable = true;
                return;
            }
            this.mInitState = 2;
            queryPkg(str, null);
            if (pTYInitCallBack != null) {
                pTYInitCallBack.onResult(false);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            if (pTYInitCallBack != null) {
                pTYInitCallBack.onResult(false);
            }
        }
    }

    public void queryPkg(final String str, final TuringPtyPkgCallBack turingPtyPkgCallBack) {
        if (this.mPTYCore != null) {
            BdTuringConfig config = BdTuring.getInstance().getConfig();
            final String str2 = (config == null || config.getRegionType() != BdTuringConfig.RegionType.REGION_BOE) ? BIZ_NAME_ONLINE : BIZ_NAME_TEST;
            this.mPTYCore.queryPackage(str2, new PTYPackageCallback() { // from class: com.bytedance.bdturing.livedetect.pty.TuringPTYManager.3
                public void onResult(boolean z, PTYError pTYError, PTYPackageInfo pTYPackageInfo) {
                    TuringPTYManager.this.mPkgLoaded.set(z);
                    TuringPtyPkgCallBack turingPtyPkgCallBack2 = turingPtyPkgCallBack;
                    if (turingPtyPkgCallBack2 != null) {
                        turingPtyPkgCallBack2.onResult(z);
                    }
                    if (!z && !BdTuring.class.getName().equals(str)) {
                        EventReport.liveDetectError(BdTuring.PTY_PKG_NOT_READY, "pkg not ready:" + (pTYError != null ? pTYError.toString() : ""), null);
                    }
                    if (z || pTYError == null || PTYErrorCode.PACKAGE_NOT_READY.getCode() != pTYError.getCode()) {
                        return;
                    }
                    TuringPTYManager.this.downLoadPkg(str2);
                }
            });
        } else if (turingPtyPkgCallBack != null) {
            turingPtyPkgCallBack.onResult(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downLoadPkg(String str) {
        try {
            IPitayaCore iPitayaCore = this.mPTYCore;
            if (iPitayaCore != null) {
                iPitayaCore.downloadPackage(str, new PTYPackageCallback() { // from class: com.bytedance.bdturing.livedetect.pty.TuringPTYManager.4
                    public void onResult(boolean z, PTYError pTYError, PTYPackageInfo pTYPackageInfo) {
                        TuringPTYManager.this.mPkgLoaded.set(z);
                        EventReport.liveDetectError(BdTuring.PTY_PKG_DOWNLOAD_FAIL, "pkg download success:" + z + ":errorMsg=" + (pTYError != null ? pTYError.toString() : "") + ":pkgInfo=" + (pTYPackageInfo != null ? pTYPackageInfo.toString() : ""), null);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isPTYReady() {
        return isPTYAvailable() && this.mPkgLoaded.get();
    }

    public boolean isPTYAvailable() {
        IPitayaCore iPitayaCore = this.mPTYCore;
        return iPitayaCore != null && iPitayaCore.isReady();
    }

    public boolean isPkgLoaded() {
        return this.mPkgLoaded.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPTYInit(Context context, final PTYInitCallBack pTYInitCallBack, final String str) {
        try {
            if (isPTYAvailable()) {
                return;
            }
            final BdTuringConfig config = BdTuring.getInstance().getConfig();
            if (config == null) {
                if (pTYInitCallBack != null) {
                    pTYInitCallBack.onResult(false);
                }
            } else {
                PTYSetupInfo.Builder builder = new PTYSetupInfo.Builder();
                builder.aid(SDK_AID).channel(config.getChannel()).uidCallback(new PTYUIDCallback() { // from class: com.bytedance.bdturing.livedetect.pty.TuringPTYManager.6
                    public String getUid() {
                        return "";
                    }
                }).appVersion(config.getAppVersion()).didCallback(new PTYDIDCallback() { // from class: com.bytedance.bdturing.livedetect.pty.TuringPTYManager.5
                    public String getDid() {
                        return config.getDeviceId();
                    }
                }).autoRequestUpdate(true).downloadConcurrency(2);
                IPitayaCore core = PitayaCoreFactory.getCore(SDK_AID);
                this.mPTYCore = core;
                core.setup(context, builder.build(), new PTYSetupCallback() { // from class: com.bytedance.bdturing.livedetect.pty.TuringPTYManager.7
                    public void onResult(boolean z, PTYError pTYError) {
                        if (!z) {
                            TuringPTYManager.this.mInitState = 4;
                            EventReport.liveDetectError(BdTuring.PTY_INIT_FAILED, "pty setup failed:" + (pTYError != null ? pTYError.toString() : ""), null);
                        }
                        TuringPTYManager.this.mInitState = 5;
                        TuringPTYManager.this.queryPkg(str, null);
                        PTYInitCallBack pTYInitCallBack2 = pTYInitCallBack;
                        if (pTYInitCallBack2 != null) {
                            pTYInitCallBack2.onResult(z);
                        }
                    }
                });
                this.mInitState = 3;
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (pTYInitCallBack != null) {
                pTYInitCallBack.onResult(false);
            }
        }
    }

    public void imgIdentify(Bitmap bitmap, ArrayList<Float> arrayList, PTYTaskResultCallback pTYTaskResultCallback) {
        if (this.mIsRunning.get()) {
            if (pTYTaskResultCallback != null) {
                pTYTaskResultCallback.onResult(false, (PTYError) null, (PTYTaskData) null, (PTYPackageInfo) null);
                return;
            }
            return;
        }
        this.mPTYTaskCallBack = pTYTaskResultCallback;
        if (!isPTYReady()) {
            PTYTaskResultCallback pTYTaskResultCallback2 = this.mPTYTaskCallBack;
            if (pTYTaskResultCallback2 != null) {
                pTYTaskResultCallback2.onResult(false, (PTYError) null, (PTYTaskData) null, (PTYPackageInfo) null);
                return;
            }
            return;
        }
        PTYCvMat pTYCvMat = new PTYCvMat();
        pTYCvMat.setBitmap(bitmap);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("image", pTYCvMat);
            JSONArray jSONArray = new JSONArray();
            if (arrayList != null && arrayList.size() > 0) {
                for (int i = 0; i < arrayList.size(); i++) {
                    jSONArray.put(arrayList.get(i));
                }
            }
            jSONObject.put("roi", jSONArray);
            jSONObject.put("cfg", new HashMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        PTYTaskData pTYTaskData = new PTYTaskData(jSONObject);
        BdTuringConfig config = BdTuring.getInstance().getConfig();
        String str = (config == null || config.getRegionType() != BdTuringConfig.RegionType.REGION_BOE) ? BIZ_NAME_ONLINE : BIZ_NAME_TEST;
        LogUtil.m160d(TAG, "===>PTY param:" + jSONObject + ":bizName=" + str);
        this.mIsRunning.set(true);
        try {
            this.mPTYCore.runTask(str, pTYTaskData, new PTYTaskConfig(), new PTYTaskResultCallback() { // from class: com.bytedance.bdturing.livedetect.pty.TuringPTYManager.8
                public void onResult(boolean z, PTYError pTYError, PTYTaskData pTYTaskData2, PTYPackageInfo pTYPackageInfo) {
                    TuringPTYManager.this.mIsRunning.set(false);
                    if (z) {
                        TuringPTYManager.this.mPreheated.set(true);
                    }
                    if (TuringPTYManager.this.mPTYTaskCallBack != null) {
                        TuringPTYManager.this.mPTYTaskCallBack.onResult(z, pTYError, pTYTaskData2, pTYPackageInfo);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            this.mIsRunning.set(false);
            PTYTaskResultCallback pTYTaskResultCallback3 = this.mPTYTaskCallBack;
            if (pTYTaskResultCallback3 != null) {
                pTYTaskResultCallback3.onResult(false, (PTYError) null, (PTYTaskData) null, (PTYPackageInfo) null);
            }
        }
    }

    public void release() {
        this.mIsRunning.set(false);
        this.mPreheating.set(false);
        this.mPTYTaskCallBack = null;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.bdturing.livedetect.pty.TuringPTYManager$9] */
    public void preheatInNeed() {
        if (this.mPreheating.get()) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        if (!isPTYReady() || this.mPreheated.get()) {
            return;
        }
        this.mPreheating.set(true);
        new Thread() { // from class: com.bytedance.bdturing.livedetect.pty.TuringPTYManager.9
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    Bitmap createBitmap = Bitmap.createBitmap(480, 640, Bitmap.Config.ARGB_4444);
                    createBitmap.eraseColor(-16777216);
                    ArrayList<Float> arrayList = new ArrayList<>();
                    arrayList.add(Float.valueOf(0.2f));
                    arrayList.add(Float.valueOf(0.3f));
                    arrayList.add(Float.valueOf(0.8f));
                    arrayList.add(Float.valueOf(0.8f));
                    TuringPTYManager.this.imgIdentify(createBitmap, arrayList, new PTYTaskResultCallback() { // from class: com.bytedance.bdturing.livedetect.pty.TuringPTYManager.9.1
                        public void onResult(boolean z, PTYError pTYError, PTYTaskData pTYTaskData, PTYPackageInfo pTYPackageInfo) {
                            String pTYError2 = pTYError != null ? pTYError.toString() : "";
                            LogUtil.m160d(TuringPTYManager.TAG, "===>preheatIn success=" + z + ":" + pTYError2 + ":timeUse=" + (System.currentTimeMillis() - currentTimeMillis));
                            EventReport.preheatResult(z, "preheat onResult errorMsg=" + pTYError2, LiveDetectService.getInstance().getRequest());
                            if (z) {
                                TuringPTYManager.this.mPreheated.set(true);
                            }
                            TuringPTYManager.this.mPreheating.set(false);
                        }
                    });
                    LogUtil.m160d(TuringPTYManager.TAG, "===>preheatIn end::timeUse=" + (System.currentTimeMillis() - currentTimeMillis));
                } catch (Exception e) {
                    e.printStackTrace();
                    TuringPTYManager.this.mPreheating.set(false);
                }
            }
        }.start();
    }

    public boolean isPreheated() {
        AtomicBoolean atomicBoolean = this.mPreheated;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        return false;
    }
}
