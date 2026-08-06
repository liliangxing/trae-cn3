package com.bytedance.falconx.loader;

import android.content.Context;
import android.content.res.AssetManager;
import com.bytedance.falconx.WebOffline;
import com.bytedance.geckox.logger.GeckoLogger;
import com.lynx.tasm.core.ResManager;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class AssetResLoader implements ILoader {
    private AssetManager mAssetManager;
    private AtomicBoolean mReleased = new AtomicBoolean(false);
    private final File mRootDir;

    public AssetResLoader(Context context, File file) {
        this.mRootDir = file;
        this.mAssetManager = context.getAssets();
    }

    @Override // com.bytedance.falconx.loader.ILoader
    public InputStream getInputStream(String str) throws Exception {
        if (this.mReleased.get()) {
            throw new RuntimeException("released!");
        }
        GeckoLogger.d(WebOffline.TAG, "AssetResLoader ready to load, file:" + str);
        return this.mAssetManager.open(new File(this.mRootDir, str).getPath());
    }

    @Override // com.bytedance.falconx.loader.ILoader
    public boolean exist(String str) throws Exception {
        if (this.mReleased.get()) {
            throw new RuntimeException("released!");
        }
        File file = new File(this.mRootDir, str);
        return Arrays.asList(this.mAssetManager.list(file.getParent())).contains(file.getName());
    }

    @Override // com.bytedance.falconx.loader.ILoader
    public String getResRootDir() {
        return ResManager.LOCAL_ASSET_SCHEME + this.mRootDir;
    }

    @Override // com.bytedance.falconx.loader.ILoader
    public Map<String, Long> getChannelVersion() {
        return Collections.emptyMap();
    }

    @Override // com.bytedance.falconx.loader.ILoader
    public void release() {
        this.mReleased.getAndSet(true);
    }
}
