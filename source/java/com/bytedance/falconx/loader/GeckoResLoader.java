package com.bytedance.falconx.loader;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.falconx.WebOffline;
import com.bytedance.geckox.loader.VersionedResLoader;
import com.bytedance.geckox.logger.GeckoLogger;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

/* loaded from: classes3.dex */
public class GeckoResLoader implements ILoader {
    private VersionedResLoader mLoader;

    public GeckoResLoader(Context context, String str) {
        if (context == null) {
            throw new RuntimeException("context is null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("access key is empty");
        }
        this.mLoader = new VersionedResLoader(context, str);
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

    @Override // com.bytedance.falconx.loader.ILoader
    public InputStream getInputStream(String str) throws Throwable {
        GeckoLogger.d(WebOffline.TAG, "GeckoResLoader ready to load, file:" + str);
        return this.mLoader.getInputStream(str);
    }

    @Override // com.bytedance.falconx.loader.ILoader
    public boolean exist(String str) throws Throwable {
        return this.mLoader.exist(str);
    }

    @Override // com.bytedance.falconx.loader.ILoader
    public String getResRootDir() {
        return this.mLoader.getResRootDir();
    }

    @Override // com.bytedance.falconx.loader.ILoader
    public Map<String, Long> getChannelVersion() {
        return this.mLoader.getChannelVersion();
    }

    @Override // com.bytedance.falconx.loader.ILoader
    public void release() throws Throwable {
        this.mLoader.release();
    }

    protected void finalize() throws Throwable {
        super.finalize();
        try {
            release();
        } catch (Exception e) {
            GeckoLogger.w("finalize:", e);
        }
    }
}
