package com.lynx.animax.loader;

import java.util.Map;

/* loaded from: classes6.dex */
public interface IAnimaXLoaderRequest {

    /* loaded from: classes6.dex */
    public interface IImageInfo {
        int getHeight();

        int getWidth();
    }

    IImageInfo getImageInfo();

    Map<String, Object> getParams();

    String getUri();
}
