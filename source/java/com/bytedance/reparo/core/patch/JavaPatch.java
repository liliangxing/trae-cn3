package com.bytedance.reparo.core.patch;

import com.bytedance.reparo.core.PatchConfigCell;
import com.bytedance.reparo.core.common.utils.FileUtils;
import com.bytedance.reparo.core.exception.JavaPatchParseException;
import com.bytedance.reparo.core.parse.JavaPatchInfoParser;
import com.bytedance.reparo.core.utils.TimesRecorder;
import java.io.File;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class JavaPatch extends BasePatch {
    private final File mJavaPatchRootDir;
    private final JavaPatchInfoParser mParser;
    private Patch mPatch;

    public JavaPatch(File file, Patch patch) {
        this.mJavaPatchRootDir = file;
        this.mParser = new JavaPatchInfoParser(file);
        this.mPatch = patch;
    }

    public Patch getPatch() {
        return this.mPatch;
    }

    public void parse(DurationMetric durationMetric) throws JavaPatchParseException {
        if (this.mParser.hasParsed()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.mParser.parse(durationMetric);
        TimesRecorder.checkParseCost(System.currentTimeMillis() - currentTimeMillis);
    }

    public Map<Class, PatchConfigCell> getPatchClassInfoMap() {
        return this.mParser.getPatchClassInfoMap();
    }

    public List<String> getAddedClassDexPaths() {
        return this.mParser.getAddedClassDexPaths();
    }

    public List<String> getAddedClassNames() {
        return this.mParser.getAddedClassNames();
    }

    public List<Object> getDeoptimizeMethodSet() {
        return this.mParser.getDeoptimizeMethodSet();
    }

    public File getJavaPatchRootDir() {
        return this.mJavaPatchRootDir;
    }

    @Override // com.bytedance.reparo.core.patch.BasePatch
    public boolean isLegal() {
        return !FileUtils.isEmpty(this.mJavaPatchRootDir);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof JavaPatch)) {
            return FileUtils.equals(this.mJavaPatchRootDir, ((JavaPatch) obj).mJavaPatchRootDir);
        }
        return false;
    }
}
