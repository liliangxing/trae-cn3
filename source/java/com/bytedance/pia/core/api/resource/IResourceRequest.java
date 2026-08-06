package com.bytedance.pia.core.api.resource;

import android.net.Uri;
import java.util.Map;

/* loaded from: classes4.dex */
public interface IResourceRequest {
    default Map<String, String> getRequestHeaders() {
        return null;
    }

    Uri getUrl();

    default boolean isForMainFrame() {
        return false;
    }
}
