package com.bytedance.pia.core.misc;

import com.bytedance.pia.core.api.resource.IResourceResponse;
import com.bytedance.pia.core.api.resource.LoadFrom;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class ResourceResponse implements IResourceResponse {
    private static final String DEFAULT_ENCODING = Charset.defaultCharset().name();
    private static final String DEFAULT_MIME_TYPE = "text/html";
    public final InputStream data;
    public final String encoding;
    public final Map<String, String> headers;
    public final LoadFrom loadFrom;
    public final String mimeType;
    public final String reasonPhrase;
    public final int status;

    public static ResourceResponse safeWrap(IResourceResponse iResourceResponse) {
        String name = Charset.defaultCharset().name();
        try {
            name = Charset.forName(iResourceResponse.getEncoding()).name();
        } catch (Throwable unused) {
        }
        return new ResourceResponse(iResourceResponse.getMimeType(), name, iResourceResponse.getStatusCode(), iResourceResponse.getReasonPhrase(), iResourceResponse.getHeaders(), iResourceResponse.getLoadFrom(), iResourceResponse.getData());
    }

    public ResourceResponse(String str, String str2, int i, String str3, Map<String, String> map, LoadFrom loadFrom, InputStream inputStream) {
        this.mimeType = getOrDefault(str, "text/html");
        this.encoding = getOrDefault(str2, DEFAULT_ENCODING);
        this.status = i;
        this.reasonPhrase = getOrDefault(str3, "");
        if (map == null) {
            this.headers = new HashMap();
        } else {
            this.headers = map;
        }
        this.loadFrom = loadFrom;
        this.data = inputStream;
    }

    private String getOrDefault(String str, String str2) {
        return (str == null || str.isEmpty()) ? str2 : str;
    }

    @Override // com.bytedance.pia.core.api.resource.IResourceResponse
    public String getMimeType() {
        return this.mimeType;
    }

    @Override // com.bytedance.pia.core.api.resource.IResourceResponse
    public String getEncoding() {
        return this.encoding;
    }

    @Override // com.bytedance.pia.core.api.resource.IResourceResponse
    public int getStatusCode() {
        return this.status;
    }

    @Override // com.bytedance.pia.core.api.resource.IResourceResponse
    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    @Override // com.bytedance.pia.core.api.resource.IResourceResponse
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    @Override // com.bytedance.pia.core.api.resource.IResourceResponse
    public LoadFrom getLoadFrom() {
        return this.loadFrom;
    }

    @Override // com.bytedance.pia.core.api.resource.IResourceResponse
    public InputStream getData() {
        return this.data;
    }
}
