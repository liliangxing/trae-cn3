package com.bytedance.geckox.loader;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.geckox.GeckoClient;
import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Deprecated
/* loaded from: classes3.dex */
public class VersionedResLoader implements ILoader {
    private String mAccessKey;
    private final Map<String, ChannelVerLoader> mChannelVerLoaderMap;
    private String mResRootDir;

    public VersionedResLoader(Context context, String str) {
        this(context, str, new File(context.getFilesDir(), GeckoClient.GECKO_ROOT_DIR));
    }

    public VersionedResLoader(Context context, String str, File file) {
        this.mChannelVerLoaderMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("access key is empty");
        }
        this.mAccessKey = str;
        if (file == null) {
            this.mResRootDir = new File(context.getFilesDir(), GeckoClient.GECKO_ROOT_DIR + File.separator + str).getAbsolutePath();
        } else {
            this.mResRootDir = new File(file, str).getAbsolutePath();
        }
    }

    public String getResRootDir() {
        return this.mResRootDir;
    }

    @Override // com.bytedance.geckox.loader.ILoader
    public String getBundlePath(String str) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("relativePath is empty");
        }
        return getChannelLoader(str.trim()).getBundlePath(str);
    }

    @Override // com.bytedance.geckox.loader.ILoader
    public InputStream getInputStream(String str) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("relativePath is empty");
        }
        return getChannelLoader(str.trim()).getInputStream(str);
    }

    @Override // com.bytedance.geckox.loader.ILoader
    public InputStream getPrefetchData(String str) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("relativePath is empty");
        }
        return getChannelLoader(str.trim()).getPrefetchData(str);
    }

    @Override // com.bytedance.geckox.loader.ILoader
    public boolean exist(String str) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("relativePath is empty");
        }
        return getChannelLoader(str.trim()).exist(str);
    }

    private ChannelVerLoader getChannelLoader(String str) {
        ChannelVerLoader channelVerLoader;
        int indexOf = str.indexOf("/");
        if (indexOf == -1) {
            throw new RuntimeException("channel is needed：" + str);
        }
        String substring = str.substring(0, indexOf);
        synchronized (this.mChannelVerLoaderMap) {
            channelVerLoader = this.mChannelVerLoaderMap.get(substring);
            if (channelVerLoader == null) {
                channelVerLoader = new ChannelVerLoader(this.mAccessKey, this.mResRootDir, substring);
                this.mChannelVerLoaderMap.put(substring, channelVerLoader);
            }
        }
        return channelVerLoader;
    }

    public Map<String, Long> getChannelVersion() {
        HashMap hashMap = new HashMap();
        synchronized (this.mChannelVerLoaderMap) {
            Collection<ChannelVerLoader> values = this.mChannelVerLoaderMap.values();
            if (values == null) {
                return hashMap;
            }
            for (ChannelVerLoader channelVerLoader : values) {
                hashMap.put(channelVerLoader.getChannel(), channelVerLoader.getVersion());
            }
            return hashMap;
        }
    }

    @Override // com.bytedance.geckox.loader.ILoader
    public void release() throws Throwable {
        clean();
    }

    private void clean() throws Throwable {
        synchronized (this.mChannelVerLoaderMap) {
            Iterator<ChannelVerLoader> it = this.mChannelVerLoaderMap.values().iterator();
            while (it.hasNext()) {
                it.next().release();
            }
            this.mChannelVerLoaderMap.clear();
        }
    }
}
