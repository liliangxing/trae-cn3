package com.bytedance.geckox.loader;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.logger.GeckoLogger;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class GeckoResLoader implements ILoader {
    private VersionedResLoader mLoader;

    public GeckoResLoader(Context context, String str) {
        if (context == null) {
            throw new RuntimeException("context is null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("access key is empty");
        }
        String str2 = GeckoGlobalManager.inst().getAccessKeyDirs().get(str);
        if (TextUtils.isEmpty(str2)) {
            this.mLoader = new VersionedResLoader(context, str);
        } else {
            this.mLoader = new VersionedResLoader(context, str, new File(str2));
        }
    }

    public GeckoResLoader(Context context, String str, File file) {
        if (context == null) {
            throw new RuntimeException("context is null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("access key is empty");
        }
        if (file == null) {
            throw new RuntimeException("resRootDir is null");
        }
        this.mLoader = new VersionedResLoader(context, str, file);
    }

    @Override // com.bytedance.geckox.loader.ILoader
    public String getBundlePath(String str) throws Throwable {
        return this.mLoader.getBundlePath(str);
    }

    @Override // com.bytedance.geckox.loader.ILoader
    public InputStream getInputStream(String str) throws Throwable {
        return this.mLoader.getInputStream(str);
    }

    @Override // com.bytedance.geckox.loader.ILoader
    public InputStream getPrefetchData(String str) throws Throwable {
        return this.mLoader.getPrefetchData(str);
    }

    @Override // com.bytedance.geckox.loader.ILoader
    public boolean exist(String str) throws Throwable {
        return this.mLoader.exist(str);
    }

    public String getResRootDir() {
        return this.mLoader.getResRootDir();
    }

    public Map<String, Long> getChannelVersion() {
        return this.mLoader.getChannelVersion();
    }

    public Long getChannelVersion(String str) {
        return this.mLoader.getChannelVersion().get(str);
    }

    @Override // com.bytedance.geckox.loader.ILoader
    public void release() throws Throwable {
        this.mLoader.release();
    }

    protected void finalize() throws Throwable {
        super.finalize();
        GeckoLogger.m296d("gecko loader finalize lock");
        release();
    }
}
