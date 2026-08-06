package com.bytedance.reparo.core.load;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.reparo.core.PatchConfiguration;
import com.bytedance.reparo.core.PatchEventReporter;
import com.bytedance.reparo.core.WandTrick;
import com.bytedance.reparo.core.common.utils.DigestUtils;
import com.bytedance.reparo.core.exception.PatchException;
import com.bytedance.reparo.core.exception.SoLoadException;
import com.bytedance.reparo.core.hook.SoLibraryHooker;
import com.bytedance.reparo.core.parse.SoInfoParser;
import com.bytedance.reparo.core.patch.DurationMetric;
import com.bytedance.reparo.core.patch.SoPatch;
import java.io.File;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SoLoader extends BaseLoader<SoPatch> {
    private static final String TAG = "SoLoader";
    private SoLibraryHooker hooker;

    @Override // com.bytedance.reparo.core.load.BaseLoader
    public void offline() {
    }

    public SoLoader(PatchConfiguration patchConfiguration) {
        super(patchConfiguration);
        this.hooker = new SoLibraryHooker();
    }

    @Override // com.bytedance.reparo.core.load.BaseLoader
    public void load(SoPatch soPatch, AsyncLoadResult asyncLoadResult, DurationMetric durationMetric) throws SoLoadException {
        List<SoInfoParser.SoInfo> soInfoList = soPatch.getSoInfoList();
        checkSoFiles(soPatch);
        for (int size = soInfoList.size() - 1; size >= 0; size--) {
            String str = soInfoList.get(size).name;
            if (!WandTrick.isSelfSo(str) && WandTrick.getInstanceWithoutInit().isSoLoaded(str)) {
                throw new SoLoadException("loadLibrary failed due to loaded!!! : " + str, 301);
            }
        }
        this.hooker.hook(soPatch.getLibraryDir());
        for (int size2 = soInfoList.size() - 1; size2 >= 0; size2--) {
            SoInfoParser.SoInfo soInfo = soInfoList.get(size2);
            String libraryName = getLibraryName(soInfo.name);
            if (!WandTrick.isSelfSo(soInfo.name)) {
                try {
                    System.loadLibrary(libraryName);
                } catch (Throwable th) {
                    throw new SoLoadException(String.format("System.loadLibrary(%s) failed", libraryName), th, PatchException.ERR_LOAD_SO_LOAD_ERR);
                }
            }
        }
        asyncLoadResult.success();
    }

    private void checkSoFiles(SoPatch soPatch) throws SoLoadException {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        List<SoInfoParser.SoInfo> soInfoList = soPatch.getSoInfoList();
        for (SoInfoParser.SoInfo soInfo : soInfoList) {
            File file = new File(soPatch.getLibraryDir(), soInfo.name);
            String md5Hex = DigestUtils.md5Hex(DigestUtils.md5Hex(file));
            String str = soInfo.getKeyMap().get(soPatch.getHostAbi());
            if (!TextUtils.equals(md5Hex, str)) {
                SoLoadException soLoadException = new SoLoadException(String.format("the so file's key is illegal, key=%s, while key in so-info.txt is %s, %s", md5Hex, str, file.getAbsolutePath()), PatchException.ERR_LOAD_SO_MD5_NOT_MATCH);
                PatchEventReporter.obtainSoMd5CheckEvent(TAG, false, soInfoList).startTime(elapsedRealtime).exception(soLoadException).send();
                throw soLoadException;
            }
        }
        PatchEventReporter.obtainSoMd5CheckEvent(TAG, true, soInfoList).startTime(elapsedRealtime).collectDuration().send();
    }

    private String getLibraryName(String str) {
        String substring = str.startsWith(LibrarianImpl.Constants.LIB_PREFIX) ? str.substring(3) : str;
        return str.endsWith(LibrarianImpl.Constants.SO_SUFFIX) ? substring.substring(0, substring.lastIndexOf(LibrarianImpl.Constants.SO_SUFFIX)) : substring;
    }
}
