package com.lynx.tasm.behavior.shadow.text;

import android.util.LruCache;
import com.lynx.tasm.behavior.LynxContext;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TextRendererCache {
    private static final int MAX_SIZE = 500;
    private LruCache<TextRendererKey, TextRenderer> mCache;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class Holder {
        private static TextRendererCache cache = new TextRendererCache();

        private Holder() {
        }
    }

    public static TextRendererCache cache() {
        return Holder.cache;
    }

    private TextRendererCache() {
        this.mCache = new LruCache<>(500);
    }

    public void onLowMemory() {
        this.mCache.evictAll();
    }

    public void clearCache() {
        this.mCache.evictAll();
    }

    public TextRenderer getRenderer(LynxContext lynxContext, TextRendererKey textRendererKey) {
        if (!lynxContext.isTextLayoutCacheEnabled()) {
            return new TextRenderer(lynxContext, textRendererKey);
        }
        TextRenderer textRenderer = this.mCache.get(textRendererKey);
        if (textRenderer != null) {
            return textRenderer;
        }
        TextRenderer textRenderer2 = new TextRenderer(lynxContext, textRendererKey);
        if (textRenderer2.isEnableCache()) {
            this.mCache.put(textRendererKey, textRenderer2);
        }
        return textRenderer2;
    }
}
