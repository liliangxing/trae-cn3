package com.bytedance.reparo.core;

import android.app.Application;
import com.bytedance.reparo.core.PatchManager;
import com.bytedance.reparo.core.parse.AbiHelper;
import com.bytedance.reparo.core.parse.AbiHelperImpl;
import com.bytedance.reparo.core.parse.PatchRecordInfo;
import com.bytedance.reparo.core.patch.Patch;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ReparoPatch {
    public static final String FILE_NAME_PATCH_JAR = "app-patched-release-unsigned.patch";
    private static volatile ReparoPatch sInstance;
    private AbiHelper mAbiHelper;
    private Application mApplication;
    private boolean mHasInited;
    private PatchConfiguration mPatchConfig;
    private PatchManager mPatchManager;

    private ReparoPatch() {
    }

    public static ReparoPatch getInstance() {
        if (sInstance == null) {
            synchronized (ReparoPatch.class) {
                sInstance = new ReparoPatch();
            }
        }
        return sInstance;
    }

    public int init(Application application) {
        return init(application, new Options(), "1.0.0", new AbiHelperImpl(application), true, false, true);
    }

    public int init(Application application, Options options, String str, AbiHelper abiHelper, boolean z, boolean z2, boolean z3) {
        if (this.mHasInited) {
            return 0;
        }
        this.mApplication = application;
        this.mAbiHelper = abiHelper;
        PatchConfiguration patchConfiguration = new PatchConfiguration(this.mApplication);
        patchConfiguration.setAllowDebuggable(z2);
        patchConfiguration.setEnableNewAndroid(z3);
        this.mPatchConfig = patchConfiguration;
        PatchManager patchManager = new PatchManager(this.mApplication, patchConfiguration, options, this.mAbiHelper, str, z);
        this.mPatchManager = patchManager;
        patchManager.init();
        this.mHasInited = true;
        return 0;
    }

    private void checkInit() {
        if (!this.mHasInited) {
            throw new IllegalStateException("has not initialized.");
        }
    }

    public int getHostApkAbiBits() {
        checkInit();
        return this.mAbiHelper.getHostApkAbiBits();
    }

    public String getHostApkAbi() {
        checkInit();
        return this.mAbiHelper.getHostAbi();
    }

    public Map<PatchRecordInfo, Patch> queryLocalPatches() {
        checkInit();
        return this.mPatchManager.queryLocalPatches();
    }

    public void maybeOfflineSomePatches() {
        checkInit();
        this.mPatchManager.maybeOfflineSomePatches();
    }

    public void registerOnPatchChangeListener(PatchManager.OnPatchChangeListener onPatchChangeListener) {
        checkInit();
        this.mPatchManager.registerOnPatchChangeListener(onPatchChangeListener);
    }

    public void unregisterOnPatchChangeListener(PatchManager.OnPatchChangeListener onPatchChangeListener) {
        checkInit();
        this.mPatchManager.unregisterOnPatchChangeListener(onPatchChangeListener);
    }

    public void update(UpdateRequest updateRequest) {
        checkInit();
        this.mPatchManager.update(updateRequest);
    }

    public void updatePatchLoadStatus() {
        checkInit();
        this.mPatchManager.loadAllPatches(true);
    }

    public void clearAllPatches() {
        if (this.mHasInited) {
            this.mPatchManager.clearAllPatches(true);
        }
    }

    public boolean hasInit() {
        return this.mHasInited;
    }

    public PatchConfiguration getPatchConfig() {
        return this.mPatchConfig;
    }
}
