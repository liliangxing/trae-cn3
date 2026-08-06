package com.bytedance.pia.core.api.resource;

import java.io.InputStream;
import java.util.Map;

/* loaded from: classes4.dex */
public interface IResourceResponse {
    InputStream getData();

    String getEncoding();

    Map<String, String> getHeaders();

    LoadFrom getLoadFrom();

    String getMimeType();

    String getReasonPhrase();

    int getStatusCode();
}
