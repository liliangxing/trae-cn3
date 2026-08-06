package com.bytedance.retrofit2;

import com.bytedance.ies.xbridge.base.runtime.utils.XBridgeAPIRequestUtils;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.mime.AbsTypedOutput;
import com.bytedance.retrofit2.mime.FormUrlEncodedTypedOutput;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okio.BufferedSink;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RequestBuilder {
    private boolean addCommonParam;

    @Nullable
    private String apiUrl;

    @Nullable
    private TypedOutput body;
    private int commonParamLevel;
    private String contentTypeHeader;
    private final boolean enableRecordFormFields;
    private Object extraInfo;
    private final FormUrlEncodedTypedOutput formBody;
    private final boolean hasBody;

    @Nullable
    private List<Header> headers;
    private int maxLength;
    private String method;

    @Nullable
    private final MultipartTypedOutput multipartBody;

    @Nullable
    private final MultipartBody.Builder multipartBuilder;
    private int priorityLevel;

    @Nullable
    private String queryObjectParams;

    @Nullable
    private StringBuilder queryParams;

    @Nullable
    private String relativeUrl;

    @Nullable
    private RequestBody requestBody;
    private final int requestPriorityLevel;
    private boolean responseStreaming;
    private final Endpoint server;
    private final String serviceType;
    private final Map<Class<?>, Object> tags = new LinkedHashMap();
    private boolean useRequestBody;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RequestBuilder(String str, Endpoint endpoint, @Nullable String str2, @Nullable List<Header> list, String str3, int i, int i2, boolean z, int i3, boolean z2, int i4, Object obj, boolean z3, boolean z4, boolean z5, String str4, boolean z6) {
        this.method = str;
        this.server = endpoint;
        this.relativeUrl = str2;
        this.contentTypeHeader = str3;
        this.priorityLevel = i;
        this.requestPriorityLevel = i2;
        this.responseStreaming = z;
        this.maxLength = i3;
        this.addCommonParam = z2;
        this.commonParamLevel = i4;
        this.extraInfo = obj;
        this.hasBody = z3;
        this.headers = list;
        this.serviceType = str4;
        this.enableRecordFormFields = z6;
        if (z4) {
            FormUrlEncodedTypedOutput formUrlEncodedTypedOutput = new FormUrlEncodedTypedOutput(z6);
            this.formBody = formUrlEncodedTypedOutput;
            this.multipartBody = null;
            this.body = formUrlEncodedTypedOutput;
            this.multipartBuilder = null;
            return;
        }
        if (z5) {
            this.formBody = null;
            MultipartTypedOutput multipartTypedOutput = new MultipartTypedOutput();
            this.multipartBody = multipartTypedOutput;
            this.body = multipartTypedOutput;
            MultipartBody.Builder builder = new MultipartBody.Builder();
            this.multipartBuilder = builder;
            builder.setType(MultipartBody.FORM);
            return;
        }
        this.formBody = null;
        this.multipartBody = null;
        this.multipartBuilder = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRelativeUrl(Object obj) {
        if (obj == null) {
            throw new NullPointerException("@Url parameter is null.");
        }
        this.relativeUrl = obj.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addHeader(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Header name must not be null.");
        }
        if (XBridgeAPIRequestUtils.CONTENT_TYPE.equalsIgnoreCase(str)) {
            this.contentTypeHeader = str2;
            return;
        }
        List list = this.headers;
        if (list == null) {
            list = new ArrayList(2);
            this.headers = list;
        }
        list.add(new Header(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMethod(String str, String str2) {
        String str3 = this.method;
        if (str3 == null) {
            throw new AssertionError();
        }
        this.method = str3.replace("{" + str + "}", str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addPathParam(String str, String str2, boolean z) {
        String str3 = this.relativeUrl;
        if (str3 == null) {
            throw new AssertionError();
        }
        if (str == null) {
            throw new IllegalArgumentException("Path replacement name must not be null.");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("Path replacement \"" + str + "\" value must not be null.");
        }
        try {
            if (z) {
                this.relativeUrl = this.relativeUrl.replace("{" + str + "}", URLEncoder.encode(String.valueOf(str2), "UTF-8").replace("+", "%20"));
            } else {
                this.relativeUrl = str3.replace("{" + str + "}", String.valueOf(str2));
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unable to convert path parameter \"" + str + "\" value to UTF-8:" + str2, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addQueryParam(String str, String str2, boolean z) {
        if (str == null) {
            throw new IllegalArgumentException("Query param name must not be null.");
        }
        try {
            StringBuilder sb = this.queryParams;
            if (sb == null) {
                sb = new StringBuilder();
                this.queryParams = sb;
            }
            sb.append(sb.length() > 0 ? '&' : '?');
            if (z) {
                str = URLEncoder.encode(str, "UTF-8");
            }
            if (z) {
                str2 = URLEncoder.encode(str2, "UTF-8");
            }
            if (str2 != null && !str2.isEmpty()) {
                sb.append(str).append('=').append(str2);
                return;
            }
            sb.append(str);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unable to convert query parameter \"" + str + "\" value to UTF-8: " + str2, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setQueryObjectParams(String str) {
        this.queryObjectParams = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addFormField(String str, String str2, boolean z) {
        this.formBody.addField(str, z, str2, z);
    }

    public void addPart(String str, TypedOutput typedOutput) {
        this.multipartBody.addPart(str, typedOutput);
    }

    public void addPart(String str, String str2, TypedOutput typedOutput) {
        this.multipartBody.addPart(str, str2, typedOutput);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addPart(Headers headers, RequestBody requestBody) {
        this.multipartBuilder.addPart(headers, requestBody);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addPart(MultipartBody.Part part) {
        this.multipartBuilder.addPart(part);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBody(RequestBody requestBody) {
        this.requestBody = requestBody;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void useRequestBody() {
        this.useRequestBody = true;
    }

    public void setPriorityLevel(int i) {
        this.priorityLevel = i;
    }

    public void setMaxLength(int i) {
        this.maxLength = i;
    }

    public boolean isResponseStreaming() {
        return this.responseStreaming;
    }

    public void setResponseStreaming(boolean z) {
        this.responseStreaming = z;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setAddCommonParam(boolean z) {
        this.addCommonParam = z;
    }

    public boolean isAddCommonParam() {
        return this.addCommonParam;
    }

    public void setCommonParamLevel(int i) {
        this.commonParamLevel = i;
    }

    public void setExtraInfo(Object obj) {
        this.extraInfo = obj;
    }

    public Object getExtraInfo() {
        return this.extraInfo;
    }

    @Nullable
    public String getApiUrl() {
        return this.apiUrl;
    }

    public void setApiUrl(String str) {
        this.apiUrl = str;
    }

    public String getRelativeUrl() {
        return this.relativeUrl;
    }

    public List<Header> getHeaders() {
        return this.headers;
    }

    public void setHeaders(List<Header> list) {
        this.headers = list;
    }

    @Nullable
    public TypedOutput getBody() {
        return this.body;
    }

    public void setBody(TypedOutput typedOutput) {
        this.body = typedOutput;
    }

    public String getServiceType() {
        return this.serviceType;
    }

    public <T> void addTag(Class<? super T> cls, T t) {
        this.tags.put(cls, cls.cast(t));
    }

    private StringBuilder newUrlBuilder(String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        if (str.endsWith("/")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(str2);
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0186  */
    /* JADX WARN: Type inference failed for: r17v0, types: [com.bytedance.retrofit2.RequestBuilder] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.bytedance.retrofit2.mime.FormUrlEncodedTypedOutput] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Request build(ExpandCallback<?> expandCallback) {
        List<Header> list;
        TypedOutput mimeOverridingTypedOutput;
        MultipartBody multipartBody;
        TypedOutput typedOutput;
        String str;
        MultipartTypedOutput multipartTypedOutput = this.multipartBody;
        if (multipartTypedOutput != null && multipartTypedOutput.getPartCount() == 0 && !this.useRequestBody) {
            throw new IllegalStateException("Multipart requests must contain at least one part.");
        }
        ?? url = this.server.getUrl();
        if (Platform.squareRetrofitExists()) {
            HttpUrl parse = HttpUrl.parse((String) url);
            if (parse == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + parse + ", Relative: " + this.relativeUrl);
            }
            if (parse.encodedPath() != null && parse.encodedPath().length() > 0 && "/".equals(this.relativeUrl)) {
                url = newUrlBuilder(url, this.relativeUrl);
            } else {
                HttpUrl resolve = parse.resolve(this.relativeUrl);
                if (resolve == null) {
                    throw new IllegalArgumentException("Malformed URL. Base: " + parse + ", Relative: " + this.relativeUrl);
                }
                url = new StringBuilder(resolve.toString());
            }
        } else {
            try {
                URI create = URI.create(url);
                if (create.getPath() != null && create.getPath().length() >= 1 && "/".equals(this.relativeUrl)) {
                    url = newUrlBuilder(url, this.relativeUrl);
                } else {
                    url = new StringBuilder(create.resolve(this.relativeUrl).toString());
                }
            } catch (Throwable unused) {
                String str2 = this.relativeUrl;
                if (str2 != null && (str2.startsWith("http://") || this.relativeUrl.startsWith("https://"))) {
                    url = new StringBuilder(this.relativeUrl);
                } else {
                    url = newUrlBuilder(url, this.relativeUrl);
                }
            }
        }
        StringBuilder sb = this.queryParams;
        if (sb != null) {
            if ('?' == sb.charAt(0) && (str = this.relativeUrl) != null && str.indexOf(63) != -1) {
                sb.setCharAt(0, '&');
            }
            url.append(sb);
        }
        String str3 = this.queryObjectParams;
        if (str3 != null) {
            url.append(str3);
        }
        this.apiUrl = url.toString();
        if (expandCallback instanceof ExpandCallback) {
            expandCallback.onAsyncPreRequest(this);
        }
        TypedOutput typedOutput2 = this.body;
        List<Header> list2 = this.headers;
        MultipartBody multipartBody2 = this.requestBody;
        MultipartBody multipartBody3 = null;
        if (this.useRequestBody) {
            if (multipartBody2 == null) {
                MultipartBody.Builder builder = this.multipartBuilder;
                if (builder != null) {
                    multipartBody2 = builder.build();
                } else if (this.hasBody) {
                    multipartBody2 = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
            if (multipartBody2 != null && this.contentTypeHeader != null) {
                multipartBody3 = new ContentTypeOverridingRequestBody(multipartBody2, this.contentTypeHeader);
            } else {
                list = list2;
                multipartBody = multipartBody2;
                typedOutput = typedOutput2;
                if (typedOutput == 0 && Utils.requiresRequestBody(this.method) && !this.useRequestBody) {
                    typedOutput = new FormUrlEncodedTypedOutput();
                    typedOutput.addField("body", "null");
                }
                return new Request(this.method, this.apiUrl, list, typedOutput, multipartBody, this.priorityLevel, this.requestPriorityLevel, this.responseStreaming, this.maxLength, this.addCommonParam, this.commonParamLevel, this.extraInfo, this.serviceType, this.tags);
            }
        } else if (this.contentTypeHeader != null) {
            if (typedOutput2 != null) {
                list = list2;
                mimeOverridingTypedOutput = new MimeOverridingTypedOutput(typedOutput2, this.contentTypeHeader);
                multipartBody = multipartBody3;
                typedOutput = mimeOverridingTypedOutput;
                if (typedOutput == 0) {
                    typedOutput = new FormUrlEncodedTypedOutput();
                    typedOutput.addField("body", "null");
                }
                return new Request(this.method, this.apiUrl, list, typedOutput, multipartBody, this.priorityLevel, this.requestPriorityLevel, this.responseStreaming, this.maxLength, this.addCommonParam, this.commonParamLevel, this.extraInfo, this.serviceType, this.tags);
            }
            Header header = new Header(XBridgeAPIRequestUtils.CONTENT_TYPE, this.contentTypeHeader);
            if (list2 == null) {
                list2 = Collections.singletonList(header);
            } else {
                list2.add(header);
            }
        }
        list = list2;
        mimeOverridingTypedOutput = typedOutput2;
        multipartBody = multipartBody3;
        typedOutput = mimeOverridingTypedOutput;
        if (typedOutput == 0) {
        }
        return new Request(this.method, this.apiUrl, list, typedOutput, multipartBody, this.priorityLevel, this.requestPriorityLevel, this.responseStreaming, this.maxLength, this.addCommonParam, this.commonParamLevel, this.extraInfo, this.serviceType, this.tags);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class MimeOverridingTypedOutput extends AbsTypedOutput {
        private final TypedOutput delegate;
        private final String mimeType;

        MimeOverridingTypedOutput(TypedOutput typedOutput, String str) {
            this.delegate = typedOutput;
            this.mimeType = str;
        }

        public TypedOutput getDelegate() {
            return this.delegate;
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
        public String fileName() {
            return this.delegate.fileName();
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
        public String mimeType() {
            return this.mimeType;
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
        public long length() {
            return this.delegate.length();
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
        public void writeTo(OutputStream outputStream) throws IOException {
            this.delegate.writeTo(outputStream);
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
        public String md5Stub() {
            this.mBodyMd5Stub = this.delegate.md5Stub();
            return this.mBodyMd5Stub;
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
        public boolean interceptRequestBody() {
            TypedOutput typedOutput = this.delegate;
            if (typedOutput instanceof AbsTypedOutput) {
                return ((AbsTypedOutput) typedOutput).interceptRequestBody();
            }
            return false;
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
        public TTRequestCompressManager.CompressData compressRequestBody(String str, String str2, boolean z) {
            TypedOutput typedOutput = this.delegate;
            if (typedOutput instanceof AbsTypedOutput) {
                return ((AbsTypedOutput) typedOutput).compressRequestBody(str, str2, z);
            }
            return null;
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
        public String bodyCompressType() {
            TypedOutput typedOutput = this.delegate;
            if (typedOutput instanceof AbsTypedOutput) {
                return ((AbsTypedOutput) typedOutput).bodyCompressType();
            }
            return null;
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
        public byte[] getOriginBody() {
            TypedOutput typedOutput = this.delegate;
            if (typedOutput instanceof AbsTypedOutput) {
                return ((AbsTypedOutput) typedOutput).getOriginBody();
            }
            return null;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class ContentTypeOverridingRequestBody extends RequestBody {
        private final String contentType;
        private final RequestBody delegate;

        ContentTypeOverridingRequestBody(RequestBody requestBody, String str) {
            this.delegate = requestBody;
            this.contentType = str;
        }

        public MediaType contentType() {
            return MediaType.parse(this.contentType);
        }

        public long contentLength() throws IOException {
            return this.delegate.contentLength();
        }

        public void writeTo(BufferedSink bufferedSink) throws IOException {
            this.delegate.writeTo(bufferedSink);
        }
    }
}
