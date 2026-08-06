package com.bytedance.geckox.loader;

import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.GkFSUtils;
import com.bytedance.geckox.utils.FileUtils;
import com.bytedance.gkfs.io.GkFSFileInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class FileLoader implements ILoader {
    private String accessKey;
    private String channel;
    private File mRoot;

    @Override // com.bytedance.geckox.loader.ILoader
    public void release() {
    }

    public void setAccessKey(String str) {
        this.accessKey = str;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public FileLoader(File file) {
        this.mRoot = file;
    }

    @Override // com.bytedance.geckox.loader.ILoader
    public String getBundlePath(String str) throws Throwable {
        return getBundleFile(this.mRoot, str).getAbsolutePath();
    }

    @Override // com.bytedance.geckox.loader.ILoader
    public final InputStream getInputStream(String str) throws IOException {
        File bundleFile = getBundleFile(this.mRoot, str);
        if (GkFSUtils.INSTANCE.isGkFSFile(bundleFile)) {
            if (!bundleFile.exists()) {
                throw new IOException(bundleFile.getAbsolutePath() + " not exists!");
            }
            return new GkFSFileInputStream(bundleFile);
        }
        return new FileInputStream(bundleFile);
    }

    @Override // com.bytedance.geckox.loader.ILoader
    public final boolean exist(String str) throws Throwable {
        return exist(this.mRoot, str);
    }

    @Override // com.bytedance.geckox.loader.ILoader
    public InputStream getPrefetchData(String str) throws Throwable {
        return getInputStream(str);
    }

    protected File getBundleFile(File file, String str) throws IOException {
        File file2 = new File(file, "res" + File.separator + str);
        if (!file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
            throw new IOException("file not found");
        }
        if (AppSettingsManager.inst().isCheckFileBrokenNew() && file2.exists()) {
            FileUtils.INSTANCE.checkLynxFileBroken(file2);
        }
        return file2.getCanonicalFile();
    }

    protected boolean exist(File file, String str) {
        return new File(file, "res" + File.separator + str).exists();
    }
}
