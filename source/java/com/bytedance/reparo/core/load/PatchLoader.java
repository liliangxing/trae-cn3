package com.bytedance.reparo.core.load;

import com.bytedance.reparo.core.Options;
import com.bytedance.reparo.core.PatchConfiguration;
import com.bytedance.reparo.core.WandTrick;
import com.bytedance.reparo.core.exception.PatchLoadException;
import com.bytedance.reparo.core.parse.AbiHelper;
import com.bytedance.reparo.core.patch.DurationMetric;
import com.bytedance.reparo.core.patch.JavaPatch;
import com.bytedance.reparo.core.patch.Patch;
import com.bytedance.reparo.core.patch.SoPatch;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PatchLoader {
    private AbiHelper mAbiHelper;
    private PatchConfiguration mConfiguration;
    private JavaLoader mJavaLoader;
    private Options mOptions;
    private Patch mPatch;
    private SoLoader mSoLoader;

    public PatchLoader(Patch patch, Options options, PatchConfiguration patchConfiguration, AbiHelper abiHelper) {
        this.mPatch = patch;
        this.mOptions = options;
        this.mConfiguration = patchConfiguration;
        this.mAbiHelper = abiHelper;
        this.mJavaLoader = new JavaLoader(this.mConfiguration);
        this.mSoLoader = new SoLoader(this.mConfiguration);
    }

    public void load(AsyncLoadResult asyncLoadResult, DurationMetric durationMetric) throws PatchLoadException {
        JavaPatch javaPatch = this.mPatch.javaPatch;
        SoPatch soPatch = this.mPatch.soPatch;
        if (soPatch != null && soPatch.hasSelfFixSo() && WandTrick.reparoSoFile == null) {
            WandTrick.reparoSoFile = soPatch.getLibraryDir();
        }
        int i = 0;
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        AsyncLoadResult asyncLoadResult2 = new AsyncLoadResult(asyncLoadResult) { // from class: com.bytedance.reparo.core.load.PatchLoader.1
            @Override // com.bytedance.reparo.core.load.AsyncLoadResult
            public void success() {
                atomicInteger.incrementAndGet();
            }
        };
        if (this.mOptions.enableJavaFix && javaPatch != null && javaPatch.isLegal()) {
            this.mJavaLoader.load(javaPatch, asyncLoadResult2, durationMetric);
            i = 1;
        }
        if (this.mOptions.enableSoFix && soPatch != null && soPatch.isLegal()) {
            this.mSoLoader.load(soPatch, asyncLoadResult2, durationMetric);
            i++;
        }
        if (atomicInteger.get() == i) {
            asyncLoadResult.success();
        }
    }

    public void offline() {
        this.mJavaLoader.offline();
        this.mSoLoader.offline();
    }
}
