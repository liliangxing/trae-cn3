package com.lynx.tasm.image;

import android.text.TextUtils;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.ReadableType;

/* loaded from: classes7.dex */
public class ImageUtils {

    /* loaded from: classes7.dex */
    public static class LocalCacheState {
        public boolean mUseLocalCache = false;
        public boolean mAwaitLocalCache = false;
    }

    public static LocalCacheState parseLocalCache(Dynamic dynamic) {
        LocalCacheState localCacheState = new LocalCacheState();
        if (dynamic == null) {
            localCacheState.mUseLocalCache = false;
        } else {
            ReadableType type = dynamic.getType();
            if (type == ReadableType.Boolean) {
                localCacheState.mUseLocalCache = dynamic.asBoolean();
                localCacheState.mAwaitLocalCache = false;
            } else if (type == ReadableType.String) {
                String asString = dynamic.asString();
                if (TextUtils.isEmpty(asString) || "none".equals(asString) || "false".equals(asString)) {
                    localCacheState.mUseLocalCache = false;
                    localCacheState.mAwaitLocalCache = false;
                } else if ("default".equals(asString) || RouterConstants.TRUE.equals(asString)) {
                    localCacheState.mUseLocalCache = true;
                    localCacheState.mAwaitLocalCache = false;
                } else if ("await".equals(asString)) {
                    localCacheState.mUseLocalCache = true;
                    localCacheState.mAwaitLocalCache = true;
                }
            }
        }
        return localCacheState;
    }
}
