package com.bytedance.reparo.core.patch;

import com.bytedance.reparo.core.Options;
import com.bytedance.reparo.core.PatchConfiguration;
import com.bytedance.reparo.core.UpdateRequest;
import com.bytedance.reparo.core.common.utils.FileUtils;
import com.bytedance.reparo.core.exception.PatchException;
import com.bytedance.reparo.core.install.PatchInstaller;
import com.bytedance.reparo.core.load.AsyncLoadResult;
import com.bytedance.reparo.core.load.PatchLoader;
import com.bytedance.reparo.core.parse.AbiHelper;
import com.bytedance.reparo.core.parse.PatchRecordInfo;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class Patch extends BasePatch {
    public File installDir;
    public JavaPatch javaPatch;
    private boolean mNeedOffline = false;
    private PatchLoader mPatchLoader;
    private PatchRecordInfo mRecordInfo;
    public SoPatch soPatch;

    private Patch(PatchRecordInfo patchRecordInfo, Options options, PatchConfiguration patchConfiguration, AbiHelper abiHelper) {
        this.mRecordInfo = patchRecordInfo;
        this.installDir = patchRecordInfo.getInstallDir();
        this.mPatchLoader = new PatchLoader(this, options, patchConfiguration, abiHelper);
    }

    public static Patch parse(UpdateRequest updateRequest, PatchInstaller.InstallResult installResult, Options options, PatchConfiguration patchConfiguration, AbiHelper abiHelper) {
        PatchRecordInfo parse = updateRequest.parse();
        parse.setInstallDir(installResult.installDir);
        if (installResult.hasJavaPatch && !FileUtils.isEmpty(installResult.javaPatchRootDir)) {
            parse.setHasJavaPatch(true);
            parse.setJavaPatchRootDir(installResult.javaPatchRootDir);
        }
        if (installResult.hasSoLibraries && FileUtils.isExist(installResult.soInfoFile)) {
            parse.setHasSoLibraries(true);
            parse.setHasNonSelfSo(installResult.hasNonSelfSoLibraries);
            parse.setSoInfoFile(installResult.soInfoFile);
        }
        return obtain(parse, options, patchConfiguration, abiHelper);
    }

    public static Patch obtain(PatchRecordInfo patchRecordInfo, Options options, PatchConfiguration patchConfiguration, AbiHelper abiHelper) {
        Patch patch = new Patch(patchRecordInfo, options, patchConfiguration, abiHelper);
        if (patchRecordInfo.isHasJavaPatch() && !FileUtils.isEmpty(patchRecordInfo.getJavaPatchRootDir())) {
            patch.javaPatch = new JavaPatch(patchRecordInfo.getJavaPatchRootDir(), patch);
        }
        if (patchRecordInfo.isHasSoLibraries() && FileUtils.isExist(patchRecordInfo.getSoInfoFile())) {
            patch.soPatch = new SoPatch(patchRecordInfo.getInstallDir(), patchRecordInfo.getSoInfoFile(), patchConfiguration, abiHelper);
        }
        return patch;
    }

    public void load(AsyncLoadResult asyncLoadResult, DurationMetric durationMetric) {
        try {
            this.mPatchLoader.load(asyncLoadResult, durationMetric);
        } catch (PatchException e) {
            asyncLoadResult.onLoadFailed(e);
        }
    }

    public void offline() {
        this.mPatchLoader.offline();
    }

    public PatchRecordInfo getRecordInfo() {
        return this.mRecordInfo;
    }

    public void needOffline() {
        this.mNeedOffline = true;
    }

    public boolean isNeedOffline() {
        return this.mNeedOffline;
    }
}
