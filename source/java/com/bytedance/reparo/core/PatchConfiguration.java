package com.bytedance.reparo.core;

import android.app.Application;
import android.content.Context;
import com.bytedance.reparo.core.parse.PatchFileParser;
import com.bytedance.reparo.core.parse.SoFile;
import com.bytedance.reparo.core.utils.ProcessUtils;
import java.io.File;

/* loaded from: classes4.dex */
public class PatchConfiguration {
    public static final String INIT_FILE_NAME = "_init.info";
    private static final String INIT_LOCK_FILE_NAME = "init.lock";
    private static final String INSTALL_ROOT_DIR_NAME = "install";
    private static final String JAVA_PATCH_DEX_OPTIMIZATION_DIR_NAME = "optimize";
    private static final String LOCAL_RECORD_FILE_NAME = "local-record.info";
    public static final String PATCH_ROOT_DIR_NAME = "reparo-root";
    private static final String PUBLIC_LOCK_FILE_NAME = "public.lock";
    private static final String SO_INSTALL_ROOT_DIR_NAME = "c";
    private static final String SO_SOURCE_TEMP_ROOT_DIR_NAME = "source";
    private Application application;
    private File initFile;
    private File initLockFile;
    private File localRecordFile;
    private boolean mAllowDebuggable = true;
    private boolean mEnableNewAndroid = false;
    private File mInstallRootDir;
    private File patchRootDir;
    private File publicLockFile;

    public PatchConfiguration(Application application) {
        this.application = application;
    }

    public Application getApplication() {
        return this.application;
    }

    public File getPatchRootDir() {
        if (this.patchRootDir == null) {
            this.patchRootDir = new File(this.application.getFilesDir(), PATCH_ROOT_DIR_NAME);
        }
        return this.patchRootDir;
    }

    public String getJavaDexOptimizationPath(File file) {
        return new File(file, JAVA_PATCH_DEX_OPTIMIZATION_DIR_NAME).getAbsolutePath();
    }

    public File getJavaPatchRootDir(File file) {
        return new File(file, PatchFileParser.JAVA_PATCH_ROOT_DIR_NAME);
    }

    public File getSoInfoFile(File file) {
        return new File(file, PatchFileParser.SO_INFO_FILE_NAME);
    }

    public File getSoLibraryInstallFile(File file, SoFile soFile) {
        return new File(getSoLibraryInstallDir(file), soFile.relativePath);
    }

    private File getSoLibraryInstallDir(File file) {
        return new File(file, "c");
    }

    public File getSourceSoLibraryTempFile(File file, String str) {
        return new File(getSourceSoLibraryTempDir(file), str);
    }

    private File getSourceSoLibraryTempDir(File file) {
        return new File(file, "source");
    }

    public File getSoLibraryDirPath(File file, String str) {
        return new File(getSoLibraryInstallDir(file), "lib/" + str);
    }

    public File getLocalRecordFile() {
        if (this.localRecordFile == null) {
            this.localRecordFile = new File(getPatchRootDir(), LOCAL_RECORD_FILE_NAME);
        }
        return this.localRecordFile;
    }

    public File getPublicLockFile() {
        if (this.publicLockFile == null) {
            this.publicLockFile = new File(getPatchRootDir(), PUBLIC_LOCK_FILE_NAME);
        }
        return this.publicLockFile;
    }

    public File getInitLockFile() {
        if (this.initLockFile == null) {
            this.initLockFile = new File(getPatchRootDir(), INIT_LOCK_FILE_NAME);
        }
        return this.initLockFile;
    }

    public File getInitFile(Context context) {
        if (this.initFile == null) {
            this.initFile = new File(context.getFilesDir(), ProcessUtils.getCurrentProcessName(context) + INIT_FILE_NAME);
        }
        return this.initFile;
    }

    public File getInstallRootDir() {
        if (this.mInstallRootDir == null) {
            this.mInstallRootDir = new File(getPatchRootDir(), INSTALL_ROOT_DIR_NAME);
        }
        return this.mInstallRootDir;
    }

    public File getInstallDir(UpdateRequest updateRequest) {
        return new File(getInstallRootDir(), updateRequest.getPatchId());
    }

    public void setAllowDebuggable(boolean z) {
        this.mAllowDebuggable = z;
    }

    public boolean allowDebuggable() {
        return this.mAllowDebuggable;
    }

    public void setEnableNewAndroid(boolean z) {
        this.mEnableNewAndroid = z;
    }

    public boolean enableNewAndroid() {
        return this.mEnableNewAndroid;
    }
}
