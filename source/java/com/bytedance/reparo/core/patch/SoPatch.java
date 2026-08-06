package com.bytedance.reparo.core.patch;

import com.bytedance.reparo.core.PatchConfiguration;
import com.bytedance.reparo.core.WandTrick;
import com.bytedance.reparo.core.common.utils.FileUtils;
import com.bytedance.reparo.core.parse.AbiHelper;
import com.bytedance.reparo.core.parse.SoInfoParser;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SoPatch extends BasePatch {
    private AbiHelper mAbiHelper;
    private PatchConfiguration mConfiguration;
    private File mLibraryDir;
    private File mPatchInstallDir;
    private File mSoInfoFile;
    private List<SoInfoParser.SoInfo> mSoInfoList;

    public SoPatch(File file, File file2, PatchConfiguration patchConfiguration, AbiHelper abiHelper) {
        this.mPatchInstallDir = file;
        this.mSoInfoFile = file2;
        this.mConfiguration = patchConfiguration;
        this.mAbiHelper = abiHelper;
    }

    @Override // com.bytedance.reparo.core.patch.BasePatch
    public boolean isLegal() {
        return getSoInfoList().size() > 0 && !FileUtils.isEmpty(getLibraryDir());
    }

    public File getSoInfoFile() {
        return this.mSoInfoFile;
    }

    public File getLibraryDir() {
        if (this.mLibraryDir == null) {
            this.mLibraryDir = this.mConfiguration.getSoLibraryDirPath(this.mPatchInstallDir, getHostAbi());
        }
        return this.mLibraryDir;
    }

    public List<SoInfoParser.SoInfo> getSoInfoList() {
        if (this.mSoInfoList == null) {
            this.mSoInfoList = SoInfoParser.parse(getSoInfoFile());
        }
        if (this.mSoInfoList == null) {
            this.mSoInfoList = new ArrayList();
        }
        return this.mSoInfoList;
    }

    public boolean hasSelfFixSo() {
        Iterator<SoInfoParser.SoInfo> it = getSoInfoList().iterator();
        while (it.hasNext()) {
            if (WandTrick.isSelfSo(it.next().name)) {
                return true;
            }
        }
        return false;
    }

    public String getHostAbi() {
        return this.mAbiHelper.getHostAbi();
    }
}
