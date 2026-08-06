package com.bytedance.reparo.core.install;

import android.app.Application;
import android.os.SystemClock;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.reparo.core.Options;
import com.bytedance.reparo.core.PatchConfiguration;
import com.bytedance.reparo.core.PatchLogger;
import com.bytedance.reparo.core.common.utils.FileUtils;
import com.bytedance.reparo.core.exception.PatchInstallException;
import com.bytedance.reparo.core.parse.AbiHelper;
import com.bytedance.reparo.core.parse.PatchFileParser;
import com.bytedance.reparo.core.parse.SoFile;
import com.bytedance.reparo.core.parse.SoFileList;
import com.bytedance.thanos.hdiff.HDifferHelper;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PatchInstaller {
    private static final String TAG = "PatchInstaller";
    private AbiHelper abiHelper;
    private Application application;
    private PatchConfiguration configuration;
    private File installDir;
    private Options options;
    private File patchFile;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class InstallResult {
        public boolean hasJavaPatch;
        public boolean hasNonSelfSoLibraries;
        public boolean hasSoLibraries;
        public File installDir;
        public File javaPatchRootDir;
        public String patchMd5;
        public String patchVersion;
        public File soInfoFile;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface PatchInstallListener {
        void onInstallFailed(PatchInstallException patchInstallException);

        void onInstallSuccess(InstallResult installResult);
    }

    private boolean checkSignature(File file) {
        return true;
    }

    public PatchInstaller(Application application, File file, File file2, Options options, AbiHelper abiHelper, PatchConfiguration patchConfiguration) {
        this.application = application;
        this.patchFile = file;
        this.installDir = file2;
        this.options = options;
        this.abiHelper = abiHelper;
        this.configuration = patchConfiguration;
    }

    public void install(PatchInstallListener patchInstallListener) {
        try {
            if (!FileUtils.isExist(this.patchFile)) {
                PatchLogger.m306w(TAG, String.format("patch file %s not exists. install skipped.", this.patchFile.getAbsolutePath()));
                onInstallFailed(patchInstallListener, new PatchInstallException(String.format("patch file %s not exists. install skipped.", this.patchFile.getAbsolutePath())));
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            PatchLogger.m305i(TAG, "start install " + this.patchFile.getName());
            if (!checkSignature(this.patchFile)) {
                onInstallFailed(patchInstallListener, new PatchInstallException("patch's signature is illegal.", 1));
                return;
            }
            FileUtils.delete(this.installDir);
            PatchFileParser patchFileParser = new PatchFileParser(this.patchFile, this.abiHelper, this.installDir, this.options);
            patchFileParser.parse();
            maybeInstallSoLibraries(this.application, patchFileParser, this.options);
            PatchLogger.m305i(TAG, String.format("install " + this.patchFile.getName() + " success, cost %s milliseconds", String.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime)));
            if (patchInstallListener != null) {
                InstallResult installResult = new InstallResult();
                installResult.installDir = this.installDir;
                if (patchFileParser.hasJavaPatchFile()) {
                    installResult.hasJavaPatch = true;
                    installResult.javaPatchRootDir = patchFileParser.getJavaPatchRootDir();
                }
                if (patchFileParser.hasSoLibraries()) {
                    installResult.hasSoLibraries = true;
                    installResult.hasNonSelfSoLibraries = patchFileParser.getTargetAbiSoList().hasNonSelfSo();
                    installResult.soInfoFile = patchFileParser.getSoInfoFile();
                }
                patchInstallListener.onInstallSuccess(installResult);
            }
        } catch (Throwable th) {
            PatchLogger.m304e(TAG, "", th);
            onInstallFailed(patchInstallListener, new PatchInstallException("install failed. ", th));
        }
    }

    private void onInstallFailed(PatchInstallListener patchInstallListener, PatchInstallException patchInstallException) {
        FileUtils.delete(this.installDir);
        if (patchInstallListener != null) {
            patchInstallListener.onInstallFailed(patchInstallException);
        }
    }

    private void maybeInstallSoLibraries(Application application, PatchFileParser patchFileParser, Options options) {
        SoFile soFile;
        if (!options.enableSoFix) {
            PatchLogger.m306w(TAG, "haven't enable so fix feature, install so libraries skipped.");
            return;
        }
        if (!patchFileParser.hasSoLibraries()) {
            PatchLogger.m305i(TAG, String.format("patch %s don't have any so libraries, install so libraries skipped.", this.patchFile.getName()));
            return;
        }
        SoFileList targetAbiSoList = patchFileParser.getTargetAbiSoList();
        if (targetAbiSoList == null || targetAbiSoList.size() == 0) {
            PatchLogger.m306w(TAG, String.format("target abi %s so list is empty, install so libraries failed.", patchFileParser.getHostAbi()));
            return;
        }
        if (!FileUtils.isExist(patchFileParser.getSoInfoFile())) {
            PatchLogger.m306w(TAG, "so-info.txt not exit, install so libraries failed.");
            return;
        }
        HashMap<String, SoFile> soFileMaps = targetAbiSoList.getSoFileMaps();
        try {
            ZipFile zipFile = new ZipFile(new File(application.getApplicationInfo().sourceDir));
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (!nextElement.getName().contains("..") && nextElement.getName().endsWith(LibrarianImpl.Constants.SO_SUFFIX) && (soFile = soFileMaps.get(nextElement.getName())) != null) {
                    soFileMaps.remove(nextElement.getName());
                    if (soFile.isDiff) {
                        hPatchSoLibrary(soFile, zipFile, nextElement);
                    } else {
                        copySoLibrary(soFile);
                    }
                }
            }
            zipFile.close();
            if (soFileMaps.isEmpty()) {
                return;
            }
            Iterator<SoFile> it = soFileMaps.values().iterator();
            while (it.hasNext()) {
                copySoLibrary(it.next());
            }
        } catch (IOException e) {
            throw new PatchInstallException("install so libraries failed.", e);
        }
    }

    public void clear() {
        FileUtils.delete(this.installDir);
    }

    private void hPatchSoLibrary(SoFile soFile, ZipFile zipFile, ZipEntry zipEntry) {
        File sourceSoLibraryTempFile = this.configuration.getSourceSoLibraryTempFile(this.installDir, zipEntry.getName());
        try {
            FileUtils.write(zipFile.getInputStream(zipEntry), sourceSoLibraryTempFile);
            File soLibraryInstallFile = this.configuration.getSoLibraryInstallFile(this.installDir, soFile);
            FileUtils.delete(soLibraryInstallFile);
            FileUtils.ensureParentFileExist(soLibraryInstallFile);
            if (HDifferHelper.hpatch(sourceSoLibraryTempFile.getAbsolutePath(), soFile.outputFile.getAbsolutePath(), soLibraryInstallFile.getAbsolutePath()) != 0) {
                throw new PatchInstallException(String.format("patch source so %s and diff so %s failed.", sourceSoLibraryTempFile.getAbsolutePath(), soFile.outputFile.getAbsolutePath()));
            }
        } catch (IOException e) {
            throw new PatchInstallException(String.format("write source %s so file failed. ", zipEntry.getName()), e);
        }
    }

    private void copySoLibrary(SoFile soFile) {
        File soLibraryInstallFile = this.configuration.getSoLibraryInstallFile(this.installDir, soFile);
        try {
            FileUtils.copy(soFile.outputFile, soLibraryInstallFile);
        } catch (IOException e) {
            throw new PatchInstallException(String.format("copy so file %s to %s failed.", soFile.relativePath, soLibraryInstallFile.getAbsolutePath()), e);
        }
    }
}
