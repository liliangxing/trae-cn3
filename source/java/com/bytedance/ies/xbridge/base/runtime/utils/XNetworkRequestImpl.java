package com.bytedance.ies.xbridge.base.runtime.utils;

import android.util.Pair;
import android.webkit.MimeTypeMap;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.ies.bullet.service.sdk.param.StringListParam;
import com.bytedance.ies.xbridge.base.runtime.api.IHostNetworkRuntimeApi;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostNetworkDepend;
import com.bytedance.ies.xbridge.base.runtime.depend.XIRetrofit;
import com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection;
import com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection;
import com.bytedance.ies.xbridge.base.runtime.network.HttpRequest;
import com.bytedance.ies.xbridge.base.runtime.network.RequestMethod;
import com.bytedance.ies.xbridge.utils.XLog;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.retrofit2.mime.TypedString;
import com.bytedance.ttnet.http.RequestContext;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* compiled from: XNetworkRequestImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002J>\u0010\r\u001a0\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00100\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\t\u001a\u00020\nH\u0002J\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001eJ\u001e\u0010\u001f\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/utils/XNetworkRequestImpl;", "", "()V", "CONTENT_ENCODING", "", "CONTENT_TYPE", "TAG", "createRequestContext", "Lcom/bytedance/ttnet/http/RequestContext;", "request", "Lcom/bytedance/ies/xbridge/base/runtime/network/HttpRequest;", "getMimeType", "url", "parseBaseInfo", "Lkotlin/Triple;", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "parseHeaderList", "", "Lcom/bytedance/retrofit2/client/Header;", "parseInternalErrorCode", "", "msg", "parseTypedOutput", "Lcom/bytedance/retrofit2/mime/TypedOutput;", "requestForStream", "Lcom/bytedance/ies/xbridge/base/runtime/network/AbsStreamConnection;", "method", "Lcom/bytedance/ies/xbridge/base/runtime/network/RequestMethod;", "hostNetworkDepend", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostNetworkDepend;", "requestForString", "Lcom/bytedance/ies/xbridge/base/runtime/network/AbsStringConnection;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class XNetworkRequestImpl {
    private static final String CONTENT_ENCODING = "Content-Encoding";
    private static final String CONTENT_TYPE = "Content-Type";
    public static final XNetworkRequestImpl INSTANCE = new XNetworkRequestImpl();
    private static final String TAG = "HostNetworkDependImpl";

    /* compiled from: XNetworkRequestImpl.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RequestMethod.values().length];
            try {
                iArr[RequestMethod.GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RequestMethod.POST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RequestMethod.PUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RequestMethod.DELETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RequestMethod.DOWNLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private XNetworkRequestImpl() {
    }

    private final Triple<String, String, LinkedHashMap<String, String>> parseBaseInfo(HttpRequest request) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Pair parseUrl = UrlUtils.parseUrl(new UrlBuilder(request.getUrl()).build(), linkedHashMap);
        return new Triple<>((String) parseUrl.first, (String) parseUrl.second, linkedHashMap);
    }

    private final List<Header> parseHeaderList(HttpRequest request) {
        ArrayList arrayList = new ArrayList();
        LinkedHashMap<String, String> headers = request.getHeaders();
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                arrayList.add(new Header(entry.getKey(), entry.getValue()));
            }
        }
        String contentEncoding = request.getContentEncoding();
        if (contentEncoding != null) {
            arrayList.add(new Header(CONTENT_ENCODING, contentEncoding));
        }
        String contentType = request.getContentType();
        if (contentType != null) {
            arrayList.add(new Header("Content-Type", contentType));
        }
        return arrayList;
    }

    private final RequestContext createRequestContext(HttpRequest request) {
        RequestContext requestContext = new RequestContext();
        requestContext.timeout_connect = request.getConnectTimeOut();
        requestContext.timeout_read = request.getReadTimeOut();
        requestContext.timeout_write = request.getWriteTimeOut();
        requestContext.force_handle_response = !request.getNeedAddCommonParams();
        return requestContext;
    }

    private final TypedOutput parseTypedOutput(HttpRequest request) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        LinkedHashMap<String, File> postFilePart = request.getPostFilePart();
        if (postFilePart != null) {
            if (!(!postFilePart.isEmpty())) {
                postFilePart = null;
            }
            if (postFilePart != null) {
                MultipartTypedOutput multipartTypedOutput = new MultipartTypedOutput();
                Map<String, String> params = request.getParams();
                if (params != null) {
                    for (Map.Entry<String, String> entry : params.entrySet()) {
                        multipartTypedOutput.addPart(entry.getKey(), new TypedString(entry.getValue()));
                    }
                }
                for (Map.Entry<String, File> entry2 : postFilePart.entrySet()) {
                    String key = entry2.getKey();
                    File value = entry2.getValue();
                    multipartTypedOutput.addPart(key, new TypedFile(INSTANCE.getMimeType(value.getPath()), value));
                }
                objectRef.element = multipartTypedOutput;
                return (TypedOutput) objectRef.element;
            }
        }
        if (request.getSendData() != null) {
            objectRef.element = new TypedByteArray(request.getContentType(), request.getSendData(), new String[0]);
        }
        return (TypedOutput) objectRef.element;
    }

    private final String getMimeType(String url) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(url);
        Intrinsics.checkNotNullExpressionValue(fileExtensionFromUrl, "getFileExtensionFromUrl(url)");
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:14|(6:77|17|(9:19|20|21|22|23|24|(4:26|(3:28|(1:30)|31)|32|(5:34|(2:35|(3:37|(2:39|40)(2:42|43)|41)(1:44))|45|46|47))|61|47)(1:74)|(4:49|50|51|52)|57|58)|16|17|(0)(0)|(0)|57|58) */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x02bb, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0293 A[Catch: all -> 0x02bb, TRY_LEAVE, TryCatch #4 {all -> 0x02bb, blocks: (B:49:0x0293, B:68:0x0204, B:70:0x020a, B:63:0x0240, B:24:0x014e, B:26:0x0154, B:28:0x0168, B:30:0x0170, B:31:0x0178, B:32:0x017c, B:34:0x0184, B:35:0x018d, B:37:0x0193, B:41:0x01b3, B:42:0x01ae, B:45:0x01b7), top: B:17:0x0145, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x028e  */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v3, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r5v30, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r5v43 */
    /* JADX WARN: Type inference failed for: r5v44 */
    /* JADX WARN: Type inference failed for: r5v45 */
    /* JADX WARN: Type inference failed for: r5v47 */
    /* JADX WARN: Type inference failed for: r5v48 */
    /* JADX WARN: Type inference failed for: r5v49 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final AbsStringConnection requestForString(RequestMethod method, HttpRequest request, IHostNetworkDepend hostNetworkDepend) {
        String str;
        ?? r5;
        String str2;
        LinkedHashMap linkedHashMap;
        List<Header> parseHeaderList;
        RequestContext createRequestContext;
        IHostNetworkRuntimeApi iHostNetworkRuntimeApi;
        int i;
        char c;
        Call<String> doGetForString;
        Unit unit;
        Unit unit2;
        Ref.ObjectRef objectRef;
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(hostNetworkDepend, "hostNetworkDepend");
        final LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        final Ref.IntRef intRef2 = new Ref.IntRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        objectRef3.element = "";
        Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
        try {
            Triple<String, String, LinkedHashMap<String, String>> parseBaseInfo = parseBaseInfo(request);
            String str3 = (String) parseBaseInfo.getFirst();
            str2 = (String) parseBaseInfo.getSecond();
            linkedHashMap = (LinkedHashMap) parseBaseInfo.getThird();
            parseHeaderList = parseHeaderList(request);
            createRequestContext = createRequestContext(request);
            try {
                XIRetrofit createRetrofit$default = IHostNetworkDepend.DefaultImpls.createRetrofit$default(hostNetworkDepend, str3, false, 2, null);
                iHostNetworkRuntimeApi = createRetrofit$default != null ? (IHostNetworkRuntimeApi) createRetrofit$default.create(IHostNetworkRuntimeApi.class) : null;
                XLog.INSTANCE.info("x.request requestForString method: params:" + method + " baseUrl:" + str3 + ",request:" + request.getInfo());
                i = WhenMappings.$EnumSwitchMapping$0[method.ordinal()];
                c = 1;
                r5 = 1;
                r5 = 1;
                c = 1;
                r5 = 1;
            } catch (Throwable th) {
                th = th;
                str = TAG;
                r5 = objectRef4;
            }
        } catch (Throwable th2) {
            th = th2;
            str = TAG;
            r5 = objectRef4;
        }
        if (i == 1) {
            if (iHostNetworkRuntimeApi != null) {
                doGetForString = iHostNetworkRuntimeApi.doGetForString(request.getNeedAddCommonParams(), -1, str2, linkedHashMap, parseHeaderList, createRequestContext);
                if (doGetForString != null) {
                }
                if (unit == null) {
                }
                final Ref.ObjectRef objectRef5 = r5;
                return new AbsStringConnection() { // from class: com.bytedance.ies.xbridge.base.runtime.utils.XNetworkRequestImpl$requestForString$3
                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                    public LinkedHashMap<String, String> getResponseHeader() {
                        return linkedHashMap2;
                    }

                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                    public Integer getResponseCode() {
                        return Integer.valueOf(intRef.element);
                    }

                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                    public String getStringResponseBody() {
                        return (String) objectRef2.element;
                    }

                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                    public String getErrorMsg() {
                        return (String) objectRef3.element;
                    }

                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                    public Throwable getException() {
                        return (Throwable) objectRef5.element;
                    }

                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                    public Integer getClientCode() {
                        return Integer.valueOf(intRef2.element);
                    }
                };
            }
            doGetForString = null;
            r5 = c;
            if (doGetForString != null) {
            }
            if (unit == null) {
            }
            final Ref.ObjectRef<Throwable> objectRef52 = r5;
            return new AbsStringConnection() { // from class: com.bytedance.ies.xbridge.base.runtime.utils.XNetworkRequestImpl$requestForString$3
                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                public LinkedHashMap<String, String> getResponseHeader() {
                    return linkedHashMap2;
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                public Integer getResponseCode() {
                    return Integer.valueOf(intRef.element);
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                public String getStringResponseBody() {
                    return (String) objectRef2.element;
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                public String getErrorMsg() {
                    return (String) objectRef3.element;
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                public Throwable getException() {
                    return (Throwable) objectRef52.element;
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                public Integer getClientCode() {
                    return Integer.valueOf(intRef2.element);
                }
            };
        }
        if (i == 2) {
            TypedOutput parseTypedOutput = parseTypedOutput(request);
            if (parseTypedOutput != null) {
                Call<String> doPostForString = iHostNetworkRuntimeApi != null ? iHostNetworkRuntimeApi.doPostForString(request.getNeedAddCommonParams(), -1, str2, linkedHashMap, parseHeaderList, parseTypedOutput, createRequestContext) : null;
                if (doPostForString != null) {
                    doGetForString = doPostForString;
                    if (doGetForString != null) {
                    }
                    if (unit == null) {
                    }
                    final Ref.ObjectRef<Throwable> objectRef522 = r5;
                    return new AbsStringConnection() { // from class: com.bytedance.ies.xbridge.base.runtime.utils.XNetworkRequestImpl$requestForString$3
                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public LinkedHashMap<String, String> getResponseHeader() {
                            return linkedHashMap2;
                        }

                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public Integer getResponseCode() {
                            return Integer.valueOf(intRef.element);
                        }

                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public String getStringResponseBody() {
                            return (String) objectRef2.element;
                        }

                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public String getErrorMsg() {
                            return (String) objectRef3.element;
                        }

                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public Throwable getException() {
                            return (Throwable) objectRef522.element;
                        }

                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public Integer getClientCode() {
                            return Integer.valueOf(intRef2.element);
                        }
                    };
                }
            }
            XNetworkRequestImpl xNetworkRequestImpl = this;
            if (iHostNetworkRuntimeApi != null) {
                doGetForString = iHostNetworkRuntimeApi.doPostForString(request.getNeedAddCommonParams(), -1, str2, linkedHashMap, parseHeaderList, request.getParams(), createRequestContext);
                if (doGetForString != null) {
                }
                if (unit == null) {
                }
                final Ref.ObjectRef<Throwable> objectRef5222 = r5;
                return new AbsStringConnection() { // from class: com.bytedance.ies.xbridge.base.runtime.utils.XNetworkRequestImpl$requestForString$3
                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                    public LinkedHashMap<String, String> getResponseHeader() {
                        return linkedHashMap2;
                    }

                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                    public Integer getResponseCode() {
                        return Integer.valueOf(intRef.element);
                    }

                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                    public String getStringResponseBody() {
                        return (String) objectRef2.element;
                    }

                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                    public String getErrorMsg() {
                        return (String) objectRef3.element;
                    }

                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                    public Throwable getException() {
                        return (Throwable) objectRef5222.element;
                    }

                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                    public Integer getClientCode() {
                        return Integer.valueOf(intRef2.element);
                    }
                };
            }
            doGetForString = null;
            r5 = c;
            if (doGetForString != null) {
            }
            if (unit == null) {
            }
            final Ref.ObjectRef<Throwable> objectRef52222 = r5;
            return new AbsStringConnection() { // from class: com.bytedance.ies.xbridge.base.runtime.utils.XNetworkRequestImpl$requestForString$3
                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                public LinkedHashMap<String, String> getResponseHeader() {
                    return linkedHashMap2;
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                public Integer getResponseCode() {
                    return Integer.valueOf(intRef.element);
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                public String getStringResponseBody() {
                    return (String) objectRef2.element;
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                public String getErrorMsg() {
                    return (String) objectRef3.element;
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                public Throwable getException() {
                    return (Throwable) objectRef52222.element;
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                public Integer getClientCode() {
                    return Integer.valueOf(intRef2.element);
                }
            };
        }
        c = 3;
        r5 = 3;
        if (i == 3) {
            TypedOutput parseTypedOutput2 = parseTypedOutput(request);
            if (iHostNetworkRuntimeApi != null) {
                doGetForString = iHostNetworkRuntimeApi.doPutForString(request.getNeedAddCommonParams(), -1, str2, parseHeaderList, parseTypedOutput2, createRequestContext);
                if (doGetForString != null) {
                }
                if (unit == null) {
                }
                final Ref.ObjectRef<Throwable> objectRef522222 = r5;
                return new AbsStringConnection() { // from class: com.bytedance.ies.xbridge.base.runtime.utils.XNetworkRequestImpl$requestForString$3
                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                    public LinkedHashMap<String, String> getResponseHeader() {
                        return linkedHashMap2;
                    }

                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                    public Integer getResponseCode() {
                        return Integer.valueOf(intRef.element);
                    }

                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                    public String getStringResponseBody() {
                        return (String) objectRef2.element;
                    }

                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                    public String getErrorMsg() {
                        return (String) objectRef3.element;
                    }

                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                    public Throwable getException() {
                        return (Throwable) objectRef522222.element;
                    }

                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                    public Integer getClientCode() {
                        return Integer.valueOf(intRef2.element);
                    }
                };
            }
            doGetForString = null;
            r5 = c;
            if (doGetForString != null) {
            }
            if (unit == null) {
            }
            final Ref.ObjectRef<Throwable> objectRef5222222 = r5;
            return new AbsStringConnection() { // from class: com.bytedance.ies.xbridge.base.runtime.utils.XNetworkRequestImpl$requestForString$3
                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                public LinkedHashMap<String, String> getResponseHeader() {
                    return linkedHashMap2;
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                public Integer getResponseCode() {
                    return Integer.valueOf(intRef.element);
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                public String getStringResponseBody() {
                    return (String) objectRef2.element;
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                public String getErrorMsg() {
                    return (String) objectRef3.element;
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                public Throwable getException() {
                    return (Throwable) objectRef5222222.element;
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                public Integer getClientCode() {
                    return Integer.valueOf(intRef2.element);
                }
            };
        }
        c = 4;
        r5 = 4;
        c = 4;
        if (i == 4 && iHostNetworkRuntimeApi != null) {
            doGetForString = iHostNetworkRuntimeApi.doDeleteForString(request.getNeedAddCommonParams(), -1, str2, parseHeaderList, createRequestContext);
            if (doGetForString != null) {
                try {
                    intRef.element = 0;
                } catch (Throwable th3) {
                    th = th3;
                    r5 = objectRef4;
                    str = TAG;
                    objectRef3.element = "request for string cause exception";
                    ((Ref.ObjectRef) r5).element = th;
                    Logger.e(str, (String) objectRef3.element, th);
                    final Ref.ObjectRef<Throwable> objectRef52222222 = r5;
                    return new AbsStringConnection() { // from class: com.bytedance.ies.xbridge.base.runtime.utils.XNetworkRequestImpl$requestForString$3
                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public LinkedHashMap<String, String> getResponseHeader() {
                            return linkedHashMap2;
                        }

                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public Integer getResponseCode() {
                            return Integer.valueOf(intRef.element);
                        }

                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public String getStringResponseBody() {
                            return (String) objectRef2.element;
                        }

                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public String getErrorMsg() {
                            return (String) objectRef3.element;
                        }

                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public Throwable getException() {
                            return (Throwable) objectRef52222222.element;
                        }

                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public Integer getClientCode() {
                            return Integer.valueOf(intRef2.element);
                        }
                    };
                }
                try {
                    try {
                        SsResponse<String> execute = doGetForString.execute();
                        if (execute != null) {
                            Intrinsics.checkNotNullExpressionValue(execute, "ssResponse");
                            intRef.element = execute.code();
                            String body = execute.body();
                            if (body == null) {
                                StringResponseBodyConverter stringResponseBodyConverter = StringResponseBodyConverter.INSTANCE;
                                TypedInput errorBody = execute.errorBody();
                                if (errorBody == null) {
                                    errorBody = execute.raw().getBody();
                                }
                                body = stringResponseBodyConverter.convert(errorBody);
                            }
                            objectRef2.element = body;
                            List<Header> headers = execute.headers();
                            if (headers != null) {
                                Intrinsics.checkNotNullExpressionValue(headers, "headers()");
                                Iterator<Header> it = headers.iterator();
                                while (true) {
                                    r5 = it.hasNext();
                                    if (r5 == 0) {
                                        break;
                                    }
                                    Header next = it.next();
                                    LinkedHashMap linkedHashMap3 = linkedHashMap2;
                                    String name = next.getName();
                                    Intrinsics.checkNotNullExpressionValue(name, "h.name");
                                    String value = next.getValue();
                                    if (value == null) {
                                        value = "";
                                    } else {
                                        Intrinsics.checkNotNullExpressionValue(value, "h.value ?: \"\"");
                                    }
                                    linkedHashMap3.put(name, value);
                                }
                                unit = Unit.INSTANCE;
                                r5 = objectRef4;
                            }
                        }
                        unit = null;
                        r5 = objectRef4;
                    } catch (HttpResponseException e) {
                        Ref.ObjectRef objectRef6 = objectRef4;
                        objectRef3.element = e.getClass().toString() + ':' + e.getMessage() + StringListParam.SPLIT_DELIMITER + e.getStatusCode();
                        intRef2.element = INSTANCE.parseInternalErrorCode(e.getMessage());
                        intRef.element = e.getStatusCode();
                        objectRef6.element = e;
                        unit2 = Unit.INSTANCE;
                        objectRef = objectRef6;
                        unit = unit2;
                        r5 = objectRef;
                        if (unit == null) {
                        }
                        final Ref.ObjectRef<Throwable> objectRef522222222 = r5;
                        return new AbsStringConnection() { // from class: com.bytedance.ies.xbridge.base.runtime.utils.XNetworkRequestImpl$requestForString$3
                            @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                            public LinkedHashMap<String, String> getResponseHeader() {
                                return linkedHashMap2;
                            }

                            @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                            public Integer getResponseCode() {
                                return Integer.valueOf(intRef.element);
                            }

                            @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                            public String getStringResponseBody() {
                                return (String) objectRef2.element;
                            }

                            @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                            public String getErrorMsg() {
                                return (String) objectRef3.element;
                            }

                            @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                            public Throwable getException() {
                                return (Throwable) objectRef522222222.element;
                            }

                            @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                            public Integer getClientCode() {
                                return Integer.valueOf(intRef2.element);
                            }
                        };
                    }
                } catch (CronetIOException e2) {
                    objectRef3.element = e2.getClass().toString() + ':' + e2.getMessage() + StringListParam.SPLIT_DELIMITER + e2.getStatusCode();
                    intRef2.element = INSTANCE.parseInternalErrorCode(e2.getMessage());
                    intRef.element = e2.getStatusCode();
                    Ref.ObjectRef objectRef7 = objectRef4;
                    objectRef7.element = e2;
                    unit2 = Unit.INSTANCE;
                    objectRef = objectRef7;
                    unit = unit2;
                    r5 = objectRef;
                    if (unit == null) {
                    }
                    final Ref.ObjectRef<Throwable> objectRef5222222222 = r5;
                    return new AbsStringConnection() { // from class: com.bytedance.ies.xbridge.base.runtime.utils.XNetworkRequestImpl$requestForString$3
                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public LinkedHashMap<String, String> getResponseHeader() {
                            return linkedHashMap2;
                        }

                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public Integer getResponseCode() {
                            return Integer.valueOf(intRef.element);
                        }

                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public String getStringResponseBody() {
                            return (String) objectRef2.element;
                        }

                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public String getErrorMsg() {
                            return (String) objectRef3.element;
                        }

                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public Throwable getException() {
                            return (Throwable) objectRef5222222222.element;
                        }

                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public Integer getClientCode() {
                            return Integer.valueOf(intRef2.element);
                        }
                    };
                } catch (NetworkNotAvailabeException e3) {
                    Ref.ObjectRef objectRef8 = objectRef4;
                    objectRef3.element = e3.getClass().toString() + ':' + e3.getMessage() + ",-1001";
                    intRef.element = -1001;
                    objectRef8.element = e3;
                    unit2 = Unit.INSTANCE;
                    objectRef = objectRef8;
                    unit = unit2;
                    r5 = objectRef;
                    if (unit == null) {
                    }
                    final Ref.ObjectRef<Throwable> objectRef52222222222 = r5;
                    return new AbsStringConnection() { // from class: com.bytedance.ies.xbridge.base.runtime.utils.XNetworkRequestImpl$requestForString$3
                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public LinkedHashMap<String, String> getResponseHeader() {
                            return linkedHashMap2;
                        }

                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public Integer getResponseCode() {
                            return Integer.valueOf(intRef.element);
                        }

                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public String getStringResponseBody() {
                            return (String) objectRef2.element;
                        }

                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public String getErrorMsg() {
                            return (String) objectRef3.element;
                        }

                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public Throwable getException() {
                            return (Throwable) objectRef52222222222.element;
                        }

                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public Integer getClientCode() {
                            return Integer.valueOf(intRef2.element);
                        }
                    };
                }
            } else {
                r5 = objectRef4;
                unit = null;
            }
            if (unit == null) {
                XNetworkRequestImpl xNetworkRequestImpl2 = this;
                objectRef3.element = "call is null, method is " + method.name();
                String str4 = (String) objectRef3.element;
                str = TAG;
                try {
                    Logger.d(str, str4);
                } catch (Throwable th4) {
                    th = th4;
                    objectRef3.element = "request for string cause exception";
                    ((Ref.ObjectRef) r5).element = th;
                    Logger.e(str, (String) objectRef3.element, th);
                    final Ref.ObjectRef<Throwable> objectRef522222222222 = r5;
                    return new AbsStringConnection() { // from class: com.bytedance.ies.xbridge.base.runtime.utils.XNetworkRequestImpl$requestForString$3
                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public LinkedHashMap<String, String> getResponseHeader() {
                            return linkedHashMap2;
                        }

                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public Integer getResponseCode() {
                            return Integer.valueOf(intRef.element);
                        }

                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public String getStringResponseBody() {
                            return (String) objectRef2.element;
                        }

                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public String getErrorMsg() {
                            return (String) objectRef3.element;
                        }

                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public Throwable getException() {
                            return (Throwable) objectRef522222222222.element;
                        }

                        @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                        public Integer getClientCode() {
                            return Integer.valueOf(intRef2.element);
                        }
                    };
                }
            }
            final Ref.ObjectRef<Throwable> objectRef5222222222222 = r5;
            return new AbsStringConnection() { // from class: com.bytedance.ies.xbridge.base.runtime.utils.XNetworkRequestImpl$requestForString$3
                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                public LinkedHashMap<String, String> getResponseHeader() {
                    return linkedHashMap2;
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                public Integer getResponseCode() {
                    return Integer.valueOf(intRef.element);
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                public String getStringResponseBody() {
                    return (String) objectRef2.element;
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                public String getErrorMsg() {
                    return (String) objectRef3.element;
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                public Throwable getException() {
                    return (Throwable) objectRef5222222222222.element;
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
                public Integer getClientCode() {
                    return Integer.valueOf(intRef2.element);
                }
            };
        }
        doGetForString = null;
        r5 = c;
        if (doGetForString != null) {
        }
        if (unit == null) {
        }
        final Ref.ObjectRef<Throwable> objectRef52222222222222 = r5;
        return new AbsStringConnection() { // from class: com.bytedance.ies.xbridge.base.runtime.utils.XNetworkRequestImpl$requestForString$3
            @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
            public LinkedHashMap<String, String> getResponseHeader() {
                return linkedHashMap2;
            }

            @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
            public Integer getResponseCode() {
                return Integer.valueOf(intRef.element);
            }

            @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
            public String getStringResponseBody() {
                return (String) objectRef2.element;
            }

            @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
            public String getErrorMsg() {
                return (String) objectRef3.element;
            }

            @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
            public Throwable getException() {
                return (Throwable) objectRef52222222222222.element;
            }

            @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection
            public Integer getClientCode() {
                return Integer.valueOf(intRef2.element);
            }
        };
    }

    private final int parseInternalErrorCode(String msg) {
        if (msg == null) {
            return 0;
        }
        try {
            Result.Companion companion = Result.Companion;
            int lastIndexOf$default = StringsKt.lastIndexOf$default(msg, "InternalErrorCode=", 0, false, 6, (Object) null);
            String substring = msg.substring(lastIndexOf$default + 18, StringsKt.indexOf$default(msg, StringListParam.SPLIT_DELIMITER, lastIndexOf$default, false, 4, (Object) null));
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return Integer.parseInt(substring);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Object obj = Result.constructor-impl(ResultKt.createFailure(th));
            if (Result.isFailure-impl(obj)) {
                obj = 0;
            }
            return ((Number) obj).intValue();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00db A[Catch: all -> 0x01fc, TRY_LEAVE, TryCatch #3 {all -> 0x01fc, blocks: (B:6:0x006e, B:8:0x0074, B:9:0x0081, B:15:0x00db, B:18:0x00e6, B:20:0x00ec, B:22:0x0100, B:23:0x0106, B:25:0x010e, B:26:0x0117, B:28:0x011d, B:32:0x013d, B:33:0x0138, B:36:0x0141, B:39:0x01d4, B:55:0x0147, B:53:0x0188, B:58:0x00b2, B:59:0x00c3, B:62:0x00cb), top: B:5:0x006e, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01d4 A[Catch: all -> 0x01fc, TRY_LEAVE, TryCatch #3 {all -> 0x01fc, blocks: (B:6:0x006e, B:8:0x0074, B:9:0x0081, B:15:0x00db, B:18:0x00e6, B:20:0x00ec, B:22:0x0100, B:23:0x0106, B:25:0x010e, B:26:0x0117, B:28:0x011d, B:32:0x013d, B:33:0x0138, B:36:0x0141, B:39:0x01d4, B:55:0x0147, B:53:0x0188, B:58:0x00b2, B:59:0x00c3, B:62:0x00cb), top: B:5:0x006e, inners: #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final AbsStreamConnection requestForStream(RequestMethod method, HttpRequest request, IHostNetworkDepend hostNetworkDepend) {
        String str;
        String str2;
        LinkedHashMap linkedHashMap;
        List<Header> parseHeaderList;
        RequestContext createRequestContext;
        IHostNetworkRuntimeApi iHostNetworkRuntimeApi;
        int i;
        Call<TypedInput> doPostForStream;
        Unit unit;
        Unit unit2;
        SsResponse<TypedInput> execute;
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(hostNetworkDepend, "hostNetworkDepend");
        final LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        final Ref.IntRef intRef2 = new Ref.IntRef();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = "";
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
        try {
            Triple<String, String, LinkedHashMap<String, String>> parseBaseInfo = parseBaseInfo(request);
            String str3 = (String) parseBaseInfo.getFirst();
            str2 = (String) parseBaseInfo.getSecond();
            linkedHashMap = (LinkedHashMap) parseBaseInfo.getThird();
            parseHeaderList = parseHeaderList(request);
            createRequestContext = createRequestContext(request);
            try {
                XIRetrofit createRetrofit$default = IHostNetworkDepend.DefaultImpls.createRetrofit$default(hostNetworkDepend, str3, false, 2, null);
                iHostNetworkRuntimeApi = createRetrofit$default != null ? (IHostNetworkRuntimeApi) createRetrofit$default.create(IHostNetworkRuntimeApi.class) : null;
                XLog.INSTANCE.info("x.request requestForStream params: baseUrl:" + str3 + ",request:" + request.getInfo());
                i = WhenMappings.$EnumSwitchMapping$0[method.ordinal()];
            } catch (Throwable th) {
                th = th;
                str = TAG;
            }
        } catch (Throwable th2) {
            th = th2;
            str = TAG;
        }
        if (i == 2) {
            TypedOutput parseTypedOutput = parseTypedOutput(request);
            if (parseTypedOutput != null && iHostNetworkRuntimeApi != null) {
                doPostForStream = iHostNetworkRuntimeApi.doPostForStream(request.getNeedAddCommonParams(), -1, str2, linkedHashMap, parseHeaderList, parseTypedOutput, createRequestContext);
                if (doPostForStream != null) {
                }
                unit = null;
                if (unit == null) {
                }
                return new AbsStreamConnection() { // from class: com.bytedance.ies.xbridge.base.runtime.utils.XNetworkRequestImpl$requestForStream$3
                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                    public LinkedHashMap<String, String> getResponseHeader() {
                        return linkedHashMap2;
                    }

                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                    public int getResponseCode() {
                        return intRef.element;
                    }

                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                    public InputStream getInputStreamResponseBody() {
                        return (InputStream) objectRef.element;
                    }

                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                    public String getErrorMsg() {
                        return (String) objectRef2.element;
                    }

                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                    public Throwable getException() {
                        return (Throwable) objectRef3.element;
                    }

                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                    public Integer getClientCode() {
                        return Integer.valueOf(intRef2.element);
                    }

                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                    public void cancel() {
                        Call call;
                        try {
                            InputStream inputStream = (InputStream) objectRef.element;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                        } catch (Throwable th3) {
                            Logger.e("HostNetworkDependImpl", "close inputStream failed", th3);
                        }
                        try {
                            WeakReference weakReference = (WeakReference) objectRef4.element;
                            if (weakReference == null || (call = (Call) weakReference.get()) == null || call.isCanceled()) {
                                return;
                            }
                            call.cancel();
                        } catch (Throwable th4) {
                            Logger.e("HostNetworkDependImpl", "close call failed", th4);
                        }
                    }
                };
            }
            doPostForStream = null;
            if (doPostForStream != null) {
            }
            unit = null;
            if (unit == null) {
            }
            return new AbsStreamConnection() { // from class: com.bytedance.ies.xbridge.base.runtime.utils.XNetworkRequestImpl$requestForStream$3
                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                public LinkedHashMap<String, String> getResponseHeader() {
                    return linkedHashMap2;
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                public int getResponseCode() {
                    return intRef.element;
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                public InputStream getInputStreamResponseBody() {
                    return (InputStream) objectRef.element;
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                public String getErrorMsg() {
                    return (String) objectRef2.element;
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                public Throwable getException() {
                    return (Throwable) objectRef3.element;
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                public Integer getClientCode() {
                    return Integer.valueOf(intRef2.element);
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                public void cancel() {
                    Call call;
                    try {
                        InputStream inputStream = (InputStream) objectRef.element;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (Throwable th3) {
                        Logger.e("HostNetworkDependImpl", "close inputStream failed", th3);
                    }
                    try {
                        WeakReference weakReference = (WeakReference) objectRef4.element;
                        if (weakReference == null || (call = (Call) weakReference.get()) == null || call.isCanceled()) {
                            return;
                        }
                        call.cancel();
                    } catch (Throwable th4) {
                        Logger.e("HostNetworkDependImpl", "close call failed", th4);
                    }
                }
            };
        }
        if (i == 5 && iHostNetworkRuntimeApi != null) {
            doPostForStream = iHostNetworkRuntimeApi.downloadFile(request.getNeedAddCommonParams(), -1, str2, linkedHashMap, parseHeaderList, createRequestContext);
            if (doPostForStream != null) {
                intRef.element = 0;
                objectRef4.element = new WeakReference(doPostForStream);
                try {
                    execute = doPostForStream.execute();
                } catch (HttpResponseException e) {
                    objectRef2.element = e.getClass().toString() + ':' + e.getMessage() + StringListParam.SPLIT_DELIMITER + e.getStatusCode();
                    intRef.element = e.getStatusCode();
                    intRef2.element = INSTANCE.parseInternalErrorCode(e.getMessage());
                    objectRef3.element = e;
                    unit2 = Unit.INSTANCE;
                } catch (CronetIOException e2) {
                    objectRef2.element = e2.getClass().toString() + ':' + e2.getMessage() + ",-1";
                    intRef.element = e2.getStatusCode();
                    intRef2.element = INSTANCE.parseInternalErrorCode(e2.getMessage());
                    objectRef3.element = e2;
                    unit2 = Unit.INSTANCE;
                }
                if (execute != null) {
                    Intrinsics.checkNotNullExpressionValue(execute, "ssResponse");
                    intRef.element = execute.code();
                    TypedInput body = execute.body();
                    objectRef.element = body != null ? body.mo349in() : null;
                    List<Header> headers = execute.headers();
                    if (headers != null) {
                        Intrinsics.checkNotNullExpressionValue(headers, "headers()");
                        for (Header header : headers) {
                            LinkedHashMap linkedHashMap3 = linkedHashMap2;
                            String name = header.getName();
                            Intrinsics.checkNotNullExpressionValue(name, "h.name");
                            String value = header.getValue();
                            if (value == null) {
                                value = "";
                            } else {
                                Intrinsics.checkNotNullExpressionValue(value, "h.value ?: \"\"");
                            }
                            linkedHashMap3.put(name, value);
                        }
                        unit2 = Unit.INSTANCE;
                        unit = unit2;
                        if (unit == null) {
                            XNetworkRequestImpl xNetworkRequestImpl = this;
                            objectRef2.element = "call is null, method is " + method.name();
                            String str4 = (String) objectRef2.element;
                            str = TAG;
                            try {
                                Logger.d(str, str4);
                            } catch (Throwable th3) {
                                th = th3;
                                objectRef2.element = "request for string cause exception";
                                objectRef3.element = th;
                                Logger.e(str, (String) objectRef2.element, th);
                                return new AbsStreamConnection() { // from class: com.bytedance.ies.xbridge.base.runtime.utils.XNetworkRequestImpl$requestForStream$3
                                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                                    public LinkedHashMap<String, String> getResponseHeader() {
                                        return linkedHashMap2;
                                    }

                                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                                    public int getResponseCode() {
                                        return intRef.element;
                                    }

                                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                                    public InputStream getInputStreamResponseBody() {
                                        return (InputStream) objectRef.element;
                                    }

                                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                                    public String getErrorMsg() {
                                        return (String) objectRef2.element;
                                    }

                                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                                    public Throwable getException() {
                                        return (Throwable) objectRef3.element;
                                    }

                                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                                    public Integer getClientCode() {
                                        return Integer.valueOf(intRef2.element);
                                    }

                                    @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                                    public void cancel() {
                                        Call call;
                                        try {
                                            InputStream inputStream = (InputStream) objectRef.element;
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                        } catch (Throwable th32) {
                                            Logger.e("HostNetworkDependImpl", "close inputStream failed", th32);
                                        }
                                        try {
                                            WeakReference weakReference = (WeakReference) objectRef4.element;
                                            if (weakReference == null || (call = (Call) weakReference.get()) == null || call.isCanceled()) {
                                                return;
                                            }
                                            call.cancel();
                                        } catch (Throwable th4) {
                                            Logger.e("HostNetworkDependImpl", "close call failed", th4);
                                        }
                                    }
                                };
                            }
                        }
                        return new AbsStreamConnection() { // from class: com.bytedance.ies.xbridge.base.runtime.utils.XNetworkRequestImpl$requestForStream$3
                            @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                            public LinkedHashMap<String, String> getResponseHeader() {
                                return linkedHashMap2;
                            }

                            @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                            public int getResponseCode() {
                                return intRef.element;
                            }

                            @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                            public InputStream getInputStreamResponseBody() {
                                return (InputStream) objectRef.element;
                            }

                            @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                            public String getErrorMsg() {
                                return (String) objectRef2.element;
                            }

                            @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                            public Throwable getException() {
                                return (Throwable) objectRef3.element;
                            }

                            @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                            public Integer getClientCode() {
                                return Integer.valueOf(intRef2.element);
                            }

                            @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                            public void cancel() {
                                Call call;
                                try {
                                    InputStream inputStream = (InputStream) objectRef.element;
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                } catch (Throwable th32) {
                                    Logger.e("HostNetworkDependImpl", "close inputStream failed", th32);
                                }
                                try {
                                    WeakReference weakReference = (WeakReference) objectRef4.element;
                                    if (weakReference == null || (call = (Call) weakReference.get()) == null || call.isCanceled()) {
                                        return;
                                    }
                                    call.cancel();
                                } catch (Throwable th4) {
                                    Logger.e("HostNetworkDependImpl", "close call failed", th4);
                                }
                            }
                        };
                    }
                }
            }
            unit = null;
            if (unit == null) {
            }
            return new AbsStreamConnection() { // from class: com.bytedance.ies.xbridge.base.runtime.utils.XNetworkRequestImpl$requestForStream$3
                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                public LinkedHashMap<String, String> getResponseHeader() {
                    return linkedHashMap2;
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                public int getResponseCode() {
                    return intRef.element;
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                public InputStream getInputStreamResponseBody() {
                    return (InputStream) objectRef.element;
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                public String getErrorMsg() {
                    return (String) objectRef2.element;
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                public Throwable getException() {
                    return (Throwable) objectRef3.element;
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                public Integer getClientCode() {
                    return Integer.valueOf(intRef2.element);
                }

                @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
                public void cancel() {
                    Call call;
                    try {
                        InputStream inputStream = (InputStream) objectRef.element;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (Throwable th32) {
                        Logger.e("HostNetworkDependImpl", "close inputStream failed", th32);
                    }
                    try {
                        WeakReference weakReference = (WeakReference) objectRef4.element;
                        if (weakReference == null || (call = (Call) weakReference.get()) == null || call.isCanceled()) {
                            return;
                        }
                        call.cancel();
                    } catch (Throwable th4) {
                        Logger.e("HostNetworkDependImpl", "close call failed", th4);
                    }
                }
            };
        }
        doPostForStream = null;
        if (doPostForStream != null) {
        }
        unit = null;
        if (unit == null) {
        }
        return new AbsStreamConnection() { // from class: com.bytedance.ies.xbridge.base.runtime.utils.XNetworkRequestImpl$requestForStream$3
            @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
            public LinkedHashMap<String, String> getResponseHeader() {
                return linkedHashMap2;
            }

            @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
            public int getResponseCode() {
                return intRef.element;
            }

            @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
            public InputStream getInputStreamResponseBody() {
                return (InputStream) objectRef.element;
            }

            @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
            public String getErrorMsg() {
                return (String) objectRef2.element;
            }

            @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
            public Throwable getException() {
                return (Throwable) objectRef3.element;
            }

            @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
            public Integer getClientCode() {
                return Integer.valueOf(intRef2.element);
            }

            @Override // com.bytedance.ies.xbridge.base.runtime.network.AbsStreamConnection
            public void cancel() {
                Call call;
                try {
                    InputStream inputStream = (InputStream) objectRef.element;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th32) {
                    Logger.e("HostNetworkDependImpl", "close inputStream failed", th32);
                }
                try {
                    WeakReference weakReference = (WeakReference) objectRef4.element;
                    if (weakReference == null || (call = (Call) weakReference.get()) == null || call.isCanceled()) {
                        return;
                    }
                    call.cancel();
                } catch (Throwable th4) {
                    Logger.e("HostNetworkDependImpl", "close call failed", th4);
                }
            }
        };
    }
}
