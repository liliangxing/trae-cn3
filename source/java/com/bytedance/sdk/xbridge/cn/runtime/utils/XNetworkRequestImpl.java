package com.bytedance.sdk.xbridge.cn.runtime.utils;

import android.util.Pair;
import android.webkit.MimeTypeMap;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.retrofit2.mime.TypedString;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.xbridge.cn.runtime.api.IHostNetworkRuntimeApi;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDependV2;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XIRetrofit;
import com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection;
import com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection;
import com.bytedance.sdk.xbridge.cn.runtime.network.HttpRequest;
import com.bytedance.sdk.xbridge.cn.runtime.network.RequestMethod;
import com.bytedance.ttnet.http.RequestContext;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002J>\u0010\u000f\u001a0\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0011j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00120\u00102\u0006\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 J\u001e\u0010!\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/utils/XNetworkRequestImpl;", "", "()V", "CONTENT_ENCODING", "", "CONTENT_TYPE", "TAG", "createRequestContext", "Lcom/bytedance/ttnet/http/RequestContext;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/sdk/xbridge/cn/runtime/network/HttpRequest;", "getMimeType", IWeixinService.ResponseConstants.URL, "getNetworkConfig", "", "parseBaseInfo", "Lkotlin/Triple;", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "parseHeaderList", "", "Lcom/bytedance/retrofit2/client/Header;", "parseInternalErrorCode", "", "msg", "parseTypedOutput", "Lcom/bytedance/retrofit2/mime/TypedOutput;", "requestForStream", "Lcom/bytedance/sdk/xbridge/cn/runtime/network/AbsStreamConnection;", "method", "Lcom/bytedance/sdk/xbridge/cn/runtime/network/RequestMethod;", "hostNetworkDepend", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostNetworkDepend;", "requestForString", "Lcom/bytedance/sdk/xbridge/cn/runtime/network/AbsStringConnection;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XNetworkRequestImpl {
    private static final String CONTENT_ENCODING = "Content-Encoding";
    private static final String CONTENT_TYPE = "Content-Type";
    public static final XNetworkRequestImpl INSTANCE = new XNetworkRequestImpl();
    private static final String TAG = "HostNetworkDependImpl";

    /* compiled from: XNetworkRequestImpl.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
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

    /* JADX WARN: Removed duplicated region for block: B:10:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0143 A[Catch: all -> 0x0318, TRY_LEAVE, TryCatch #3 {all -> 0x0318, blocks: (B:3:0x003f, B:5:0x0069, B:7:0x0078, B:8:0x0093, B:18:0x0143, B:21:0x0148, B:23:0x014e, B:25:0x0162, B:27:0x016a, B:28:0x0172, B:29:0x0176, B:31:0x017e, B:32:0x0187, B:34:0x018d, B:37:0x019d, B:39:0x01aa, B:50:0x01b6, B:60:0x01c0, B:53:0x01f1, B:56:0x0207, B:58:0x0204, B:42:0x020c, B:45:0x0222, B:48:0x021f, B:65:0x0227, B:73:0x022d, B:71:0x0276, B:69:0x02a9, B:75:0x02f4, B:81:0x00ac, B:82:0x00c2, B:84:0x00c8, B:85:0x00de, B:88:0x00e6, B:93:0x0105, B:95:0x010a, B:97:0x0129, B:99:0x0081, B:101:0x0089), top: B:2:0x003f, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02f4 A[Catch: all -> 0x0318, TRY_LEAVE, TryCatch #3 {all -> 0x0318, blocks: (B:3:0x003f, B:5:0x0069, B:7:0x0078, B:8:0x0093, B:18:0x0143, B:21:0x0148, B:23:0x014e, B:25:0x0162, B:27:0x016a, B:28:0x0172, B:29:0x0176, B:31:0x017e, B:32:0x0187, B:34:0x018d, B:37:0x019d, B:39:0x01aa, B:50:0x01b6, B:60:0x01c0, B:53:0x01f1, B:56:0x0207, B:58:0x0204, B:42:0x020c, B:45:0x0222, B:48:0x021f, B:65:0x0227, B:73:0x022d, B:71:0x0276, B:69:0x02a9, B:75:0x02f4, B:81:0x00ac, B:82:0x00c2, B:84:0x00c8, B:85:0x00de, B:88:0x00e6, B:93:0x0105, B:95:0x010a, B:97:0x0129, B:99:0x0081, B:101:0x0089), top: B:2:0x003f, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final AbsStringConnection requestForString(RequestMethod method, HttpRequest request, IHostNetworkDepend hostNetworkDepend) {
        String str;
        String str2;
        LinkedHashMap linkedHashMap;
        List<Header> parseHeaderList;
        RequestContext createRequestContext;
        Map<String, Object> networkConfig;
        Unit unit;
        IHostNetworkRuntimeApi iHostNetworkRuntimeApi;
        int i;
        Call<String> doGetForString;
        Unit unit2;
        SsResponse execute;
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(request, OauthTokenTriggerScene.REQUEST);
        Intrinsics.checkNotNullParameter(hostNetworkDepend, "hostNetworkDepend");
        final LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        final Ref.IntRef intRef2 = new Ref.IntRef();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = "";
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        try {
            Triple<String, String, LinkedHashMap<String, String>> parseBaseInfo = parseBaseInfo(request);
            str = (String) parseBaseInfo.getFirst();
            str2 = (String) parseBaseInfo.getSecond();
            linkedHashMap = (LinkedHashMap) parseBaseInfo.getThird();
            parseHeaderList = parseHeaderList(request);
            createRequestContext = createRequestContext(request);
            networkConfig = getNetworkConfig(request);
            unit = null;
        } catch (Throwable th) {
            objectRef2.element = "request for string cause exception";
            objectRef3.element = th;
            Logger.e(TAG, (String) objectRef2.element, th);
        }
        if (hostNetworkDepend instanceof IHostNetworkDependV2) {
            XIRetrofit createRetrofit$default = IHostNetworkDependV2.DefaultImpls.createRetrofit$default((IHostNetworkDependV2) hostNetworkDepend, str, false, networkConfig, 2, null);
            if (createRetrofit$default != null) {
                iHostNetworkRuntimeApi = (IHostNetworkRuntimeApi) createRetrofit$default.create(IHostNetworkRuntimeApi.class);
                i = WhenMappings.$EnumSwitchMapping$0[method.ordinal()];
                if (i != 1) {
                    if (iHostNetworkRuntimeApi != null) {
                        doGetForString = iHostNetworkRuntimeApi.doGetForString(request.getNeedAddCommonParams(), request.getMaxLength(), str2, linkedHashMap, parseHeaderList, createRequestContext);
                        if (doGetForString != null) {
                        }
                        if (unit == null) {
                        }
                        return new AbsStringConnection() { // from class: com.bytedance.sdk.xbridge.cn.runtime.utils.XNetworkRequestImpl$requestForString$3
                            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                            public LinkedHashMap<String, String> getResponseHeader() {
                                return linkedHashMap2;
                            }

                            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                            public Integer getResponseCode() {
                                return Integer.valueOf(intRef.element);
                            }

                            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                            public String getStringResponseBody() {
                                return (String) objectRef.element;
                            }

                            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                            public String getErrorMsg() {
                                return (String) objectRef2.element;
                            }

                            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                            public Throwable getException() {
                                return (Throwable) objectRef3.element;
                            }

                            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                            public Integer getClientCode() {
                                return Integer.valueOf(intRef2.element);
                            }
                        };
                    }
                    doGetForString = null;
                    if (doGetForString != null) {
                    }
                    if (unit == null) {
                    }
                    return new AbsStringConnection() { // from class: com.bytedance.sdk.xbridge.cn.runtime.utils.XNetworkRequestImpl$requestForString$3
                        @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                        public LinkedHashMap<String, String> getResponseHeader() {
                            return linkedHashMap2;
                        }

                        @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                        public Integer getResponseCode() {
                            return Integer.valueOf(intRef.element);
                        }

                        @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                        public String getStringResponseBody() {
                            return (String) objectRef.element;
                        }

                        @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                        public String getErrorMsg() {
                            return (String) objectRef2.element;
                        }

                        @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                        public Throwable getException() {
                            return (Throwable) objectRef3.element;
                        }

                        @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                        public Integer getClientCode() {
                            return Integer.valueOf(intRef2.element);
                        }
                    };
                }
                if (i == 2) {
                    TypedOutput parseTypedOutput = parseTypedOutput(request);
                    if (parseTypedOutput != null) {
                        Call<String> doPostForString = iHostNetworkRuntimeApi != null ? iHostNetworkRuntimeApi.doPostForString(request.getNeedAddCommonParams(), request.getMaxLength(), str2, linkedHashMap, parseHeaderList, parseTypedOutput, createRequestContext) : null;
                        if (doPostForString != null) {
                            doGetForString = doPostForString;
                            if (doGetForString != null) {
                            }
                            if (unit == null) {
                            }
                            return new AbsStringConnection() { // from class: com.bytedance.sdk.xbridge.cn.runtime.utils.XNetworkRequestImpl$requestForString$3
                                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                                public LinkedHashMap<String, String> getResponseHeader() {
                                    return linkedHashMap2;
                                }

                                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                                public Integer getResponseCode() {
                                    return Integer.valueOf(intRef.element);
                                }

                                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                                public String getStringResponseBody() {
                                    return (String) objectRef.element;
                                }

                                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                                public String getErrorMsg() {
                                    return (String) objectRef2.element;
                                }

                                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                                public Throwable getException() {
                                    return (Throwable) objectRef3.element;
                                }

                                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                                public Integer getClientCode() {
                                    return Integer.valueOf(intRef2.element);
                                }
                            };
                        }
                    }
                    XNetworkRequestImpl xNetworkRequestImpl = this;
                    if (iHostNetworkRuntimeApi != null) {
                        doGetForString = iHostNetworkRuntimeApi.doPostForString(request.getNeedAddCommonParams(), request.getMaxLength(), str2, linkedHashMap, parseHeaderList, request.getParams(), createRequestContext);
                        if (doGetForString != null) {
                        }
                        if (unit == null) {
                        }
                        return new AbsStringConnection() { // from class: com.bytedance.sdk.xbridge.cn.runtime.utils.XNetworkRequestImpl$requestForString$3
                            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                            public LinkedHashMap<String, String> getResponseHeader() {
                                return linkedHashMap2;
                            }

                            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                            public Integer getResponseCode() {
                                return Integer.valueOf(intRef.element);
                            }

                            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                            public String getStringResponseBody() {
                                return (String) objectRef.element;
                            }

                            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                            public String getErrorMsg() {
                                return (String) objectRef2.element;
                            }

                            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                            public Throwable getException() {
                                return (Throwable) objectRef3.element;
                            }

                            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                            public Integer getClientCode() {
                                return Integer.valueOf(intRef2.element);
                            }
                        };
                    }
                    doGetForString = null;
                    if (doGetForString != null) {
                    }
                    if (unit == null) {
                    }
                    return new AbsStringConnection() { // from class: com.bytedance.sdk.xbridge.cn.runtime.utils.XNetworkRequestImpl$requestForString$3
                        @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                        public LinkedHashMap<String, String> getResponseHeader() {
                            return linkedHashMap2;
                        }

                        @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                        public Integer getResponseCode() {
                            return Integer.valueOf(intRef.element);
                        }

                        @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                        public String getStringResponseBody() {
                            return (String) objectRef.element;
                        }

                        @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                        public String getErrorMsg() {
                            return (String) objectRef2.element;
                        }

                        @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                        public Throwable getException() {
                            return (Throwable) objectRef3.element;
                        }

                        @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                        public Integer getClientCode() {
                            return Integer.valueOf(intRef2.element);
                        }
                    };
                }
                if (i == 3) {
                    TypedOutput parseTypedOutput2 = parseTypedOutput(request);
                    if (iHostNetworkRuntimeApi != null) {
                        doGetForString = iHostNetworkRuntimeApi.doPutForString(request.getNeedAddCommonParams(), request.getMaxLength(), str2, parseHeaderList, parseTypedOutput2, createRequestContext);
                        if (doGetForString != null) {
                        }
                        if (unit == null) {
                        }
                        return new AbsStringConnection() { // from class: com.bytedance.sdk.xbridge.cn.runtime.utils.XNetworkRequestImpl$requestForString$3
                            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                            public LinkedHashMap<String, String> getResponseHeader() {
                                return linkedHashMap2;
                            }

                            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                            public Integer getResponseCode() {
                                return Integer.valueOf(intRef.element);
                            }

                            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                            public String getStringResponseBody() {
                                return (String) objectRef.element;
                            }

                            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                            public String getErrorMsg() {
                                return (String) objectRef2.element;
                            }

                            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                            public Throwable getException() {
                                return (Throwable) objectRef3.element;
                            }

                            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                            public Integer getClientCode() {
                                return Integer.valueOf(intRef2.element);
                            }
                        };
                    }
                    doGetForString = null;
                    if (doGetForString != null) {
                    }
                    if (unit == null) {
                    }
                    return new AbsStringConnection() { // from class: com.bytedance.sdk.xbridge.cn.runtime.utils.XNetworkRequestImpl$requestForString$3
                        @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                        public LinkedHashMap<String, String> getResponseHeader() {
                            return linkedHashMap2;
                        }

                        @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                        public Integer getResponseCode() {
                            return Integer.valueOf(intRef.element);
                        }

                        @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                        public String getStringResponseBody() {
                            return (String) objectRef.element;
                        }

                        @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                        public String getErrorMsg() {
                            return (String) objectRef2.element;
                        }

                        @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                        public Throwable getException() {
                            return (Throwable) objectRef3.element;
                        }

                        @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                        public Integer getClientCode() {
                            return Integer.valueOf(intRef2.element);
                        }
                    };
                }
                if (i == 4 && iHostNetworkRuntimeApi != null) {
                    doGetForString = iHostNetworkRuntimeApi.doDeleteForString(request.getNeedAddCommonParams(), request.getMaxLength(), str2, parseHeaderList, createRequestContext);
                    if (doGetForString != null) {
                        intRef.element = 0;
                        try {
                            execute = doGetForString.execute();
                        } catch (HttpResponseException e) {
                            objectRef2.element = e.getClass().toString() + ':' + e.getMessage() + ',' + e.getStatusCode();
                            intRef2.element = INSTANCE.parseInternalErrorCode(e.getMessage());
                            intRef.element = e.getStatusCode();
                            objectRef3.element = e;
                            unit2 = Unit.INSTANCE;
                        } catch (NetworkNotAvailabeException e2) {
                            objectRef2.element = e2.getClass().toString() + ':' + e2.getMessage() + ",-1001";
                            intRef.element = -1001;
                            objectRef3.element = e2;
                            unit2 = Unit.INSTANCE;
                        } catch (CronetIOException e3) {
                            objectRef2.element = e3.getClass().toString() + ':' + e3.getMessage() + ',' + e3.getStatusCode();
                            intRef2.element = INSTANCE.parseInternalErrorCode(e3.getMessage());
                            intRef.element = e3.getStatusCode();
                            objectRef3.element = e3;
                            unit2 = Unit.INSTANCE;
                        }
                        if (execute != null) {
                            Intrinsics.checkNotNullExpressionValue(execute, "ssResponse");
                            intRef.element = execute.code();
                            String str3 = (String) execute.body();
                            if (str3 == null) {
                                StringResponseBodyConverter stringResponseBodyConverter = StringResponseBodyConverter.INSTANCE;
                                TypedInput errorBody = execute.errorBody();
                                if (errorBody == null) {
                                    errorBody = execute.raw().getBody();
                                }
                                str3 = stringResponseBodyConverter.convert(errorBody);
                            }
                            objectRef.element = str3;
                            List<Header> headers = execute.headers();
                            if (headers != null) {
                                Intrinsics.checkNotNullExpressionValue(headers, "headers()");
                                for (Header header : headers) {
                                    if (request.getCustomCookie() && (Intrinsics.areEqual(header.getName(), "set-cookie") || Intrinsics.areEqual(header.getName(), "Set-Cookie"))) {
                                        if (linkedHashMap2.containsKey(header.getName())) {
                                            String name = header.getName();
                                            Intrinsics.checkNotNullExpressionValue(name, "name");
                                            linkedHashMap2.put(name, ((String) linkedHashMap2.get(name)) + ", " + header.getValue());
                                        } else {
                                            LinkedHashMap linkedHashMap3 = linkedHashMap2;
                                            String name2 = header.getName();
                                            Intrinsics.checkNotNullExpressionValue(name2, "h.name");
                                            String value = header.getValue();
                                            if (value == null) {
                                                value = "";
                                            } else {
                                                Intrinsics.checkNotNullExpressionValue(value, "h.value ?: \"\"");
                                            }
                                            linkedHashMap3.put(name2, value);
                                        }
                                    } else {
                                        LinkedHashMap linkedHashMap4 = linkedHashMap2;
                                        String name3 = header.getName();
                                        Intrinsics.checkNotNullExpressionValue(name3, "h.name");
                                        String value2 = header.getValue();
                                        if (value2 == null) {
                                            value2 = "";
                                        } else {
                                            Intrinsics.checkNotNullExpressionValue(value2, "h.value ?: \"\"");
                                        }
                                        linkedHashMap4.put(name3, value2);
                                    }
                                }
                                unit2 = Unit.INSTANCE;
                                unit = unit2;
                            }
                        }
                    }
                    if (unit == null) {
                        XNetworkRequestImpl xNetworkRequestImpl2 = this;
                        objectRef2.element = "call is null, method is " + method.name();
                        Logger.d(TAG, (String) objectRef2.element);
                    }
                    return new AbsStringConnection() { // from class: com.bytedance.sdk.xbridge.cn.runtime.utils.XNetworkRequestImpl$requestForString$3
                        @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                        public LinkedHashMap<String, String> getResponseHeader() {
                            return linkedHashMap2;
                        }

                        @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                        public Integer getResponseCode() {
                            return Integer.valueOf(intRef.element);
                        }

                        @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                        public String getStringResponseBody() {
                            return (String) objectRef.element;
                        }

                        @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                        public String getErrorMsg() {
                            return (String) objectRef2.element;
                        }

                        @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                        public Throwable getException() {
                            return (Throwable) objectRef3.element;
                        }

                        @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                        public Integer getClientCode() {
                            return Integer.valueOf(intRef2.element);
                        }
                    };
                }
                doGetForString = null;
                if (doGetForString != null) {
                }
                if (unit == null) {
                }
                return new AbsStringConnection() { // from class: com.bytedance.sdk.xbridge.cn.runtime.utils.XNetworkRequestImpl$requestForString$3
                    @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                    public LinkedHashMap<String, String> getResponseHeader() {
                        return linkedHashMap2;
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                    public Integer getResponseCode() {
                        return Integer.valueOf(intRef.element);
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                    public String getStringResponseBody() {
                        return (String) objectRef.element;
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                    public String getErrorMsg() {
                        return (String) objectRef2.element;
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                    public Throwable getException() {
                        return (Throwable) objectRef3.element;
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                    public Integer getClientCode() {
                        return Integer.valueOf(intRef2.element);
                    }
                };
                objectRef2.element = "request for string cause exception";
                objectRef3.element = th;
                Logger.e(TAG, (String) objectRef2.element, th);
                return new AbsStringConnection() { // from class: com.bytedance.sdk.xbridge.cn.runtime.utils.XNetworkRequestImpl$requestForString$3
                    @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                    public LinkedHashMap<String, String> getResponseHeader() {
                        return linkedHashMap2;
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                    public Integer getResponseCode() {
                        return Integer.valueOf(intRef.element);
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                    public String getStringResponseBody() {
                        return (String) objectRef.element;
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                    public String getErrorMsg() {
                        return (String) objectRef2.element;
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                    public Throwable getException() {
                        return (Throwable) objectRef3.element;
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                    public Integer getClientCode() {
                        return Integer.valueOf(intRef2.element);
                    }
                };
            }
            iHostNetworkRuntimeApi = null;
            i = WhenMappings.$EnumSwitchMapping$0[method.ordinal()];
            if (i != 1) {
            }
            objectRef2.element = "request for string cause exception";
            objectRef3.element = th;
            Logger.e(TAG, (String) objectRef2.element, th);
            return new AbsStringConnection() { // from class: com.bytedance.sdk.xbridge.cn.runtime.utils.XNetworkRequestImpl$requestForString$3
                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                public LinkedHashMap<String, String> getResponseHeader() {
                    return linkedHashMap2;
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                public Integer getResponseCode() {
                    return Integer.valueOf(intRef.element);
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                public String getStringResponseBody() {
                    return (String) objectRef.element;
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                public String getErrorMsg() {
                    return (String) objectRef2.element;
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                public Throwable getException() {
                    return (Throwable) objectRef3.element;
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                public Integer getClientCode() {
                    return Integer.valueOf(intRef2.element);
                }
            };
        }
        XIRetrofit createRetrofit$default2 = IHostNetworkDepend.DefaultImpls.createRetrofit$default(hostNetworkDepend, str, false, 2, null);
        if (createRetrofit$default2 != null) {
            iHostNetworkRuntimeApi = (IHostNetworkRuntimeApi) createRetrofit$default2.create(IHostNetworkRuntimeApi.class);
            i = WhenMappings.$EnumSwitchMapping$0[method.ordinal()];
            if (i != 1) {
            }
            objectRef2.element = "request for string cause exception";
            objectRef3.element = th;
            Logger.e(TAG, (String) objectRef2.element, th);
            return new AbsStringConnection() { // from class: com.bytedance.sdk.xbridge.cn.runtime.utils.XNetworkRequestImpl$requestForString$3
                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                public LinkedHashMap<String, String> getResponseHeader() {
                    return linkedHashMap2;
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                public Integer getResponseCode() {
                    return Integer.valueOf(intRef.element);
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                public String getStringResponseBody() {
                    return (String) objectRef.element;
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                public String getErrorMsg() {
                    return (String) objectRef2.element;
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                public Throwable getException() {
                    return (Throwable) objectRef3.element;
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
                public Integer getClientCode() {
                    return Integer.valueOf(intRef2.element);
                }
            };
        }
        iHostNetworkRuntimeApi = null;
        i = WhenMappings.$EnumSwitchMapping$0[method.ordinal()];
        if (i != 1) {
        }
        objectRef2.element = "request for string cause exception";
        objectRef3.element = th;
        Logger.e(TAG, (String) objectRef2.element, th);
        return new AbsStringConnection() { // from class: com.bytedance.sdk.xbridge.cn.runtime.utils.XNetworkRequestImpl$requestForString$3
            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
            public LinkedHashMap<String, String> getResponseHeader() {
                return linkedHashMap2;
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
            public Integer getResponseCode() {
                return Integer.valueOf(intRef.element);
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
            public String getStringResponseBody() {
                return (String) objectRef.element;
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
            public String getErrorMsg() {
                return (String) objectRef2.element;
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
            public Throwable getException() {
                return (Throwable) objectRef3.element;
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection
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
            int lastIndexOf$default = StringsKt.lastIndexOf$default(msg, "InternalErrorCode=", 0, false, 4, (Object) null);
            String substring = msg.substring(lastIndexOf$default + 18, StringsKt.indexOf$default(msg, ',', lastIndexOf$default, false, 4, (Object) null));
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

    private final Map<String, Object> getNetworkConfig(HttpRequest request) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("isCustomizedCookie", Boolean.valueOf(request.getCustomCookie()));
        linkedHashMap.put("needAddCommonParams", Boolean.valueOf(request.getNeedAddCommonParams()));
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00fd A[Catch: all -> 0x021a, TRY_LEAVE, TryCatch #1 {all -> 0x021a, blocks: (B:3:0x0044, B:5:0x006f, B:7:0x0080, B:9:0x009e, B:17:0x00fd, B:20:0x0109, B:22:0x010f, B:24:0x0123, B:25:0x0129, B:27:0x0131, B:28:0x013a, B:30:0x0140, B:34:0x0160, B:35:0x015b, B:38:0x0164, B:45:0x016a, B:43:0x01ab, B:47:0x01f6, B:53:0x00b3, B:54:0x00c8, B:57:0x00d0, B:59:0x00e7, B:61:0x0089, B:63:0x0091), top: B:2:0x0044, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01f6 A[Catch: all -> 0x021a, TRY_LEAVE, TryCatch #1 {all -> 0x021a, blocks: (B:3:0x0044, B:5:0x006f, B:7:0x0080, B:9:0x009e, B:17:0x00fd, B:20:0x0109, B:22:0x010f, B:24:0x0123, B:25:0x0129, B:27:0x0131, B:28:0x013a, B:30:0x0140, B:34:0x0160, B:35:0x015b, B:38:0x0164, B:45:0x016a, B:43:0x01ab, B:47:0x01f6, B:53:0x00b3, B:54:0x00c8, B:57:0x00d0, B:59:0x00e7, B:61:0x0089, B:63:0x0091), top: B:2:0x0044, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final AbsStreamConnection requestForStream(RequestMethod method, HttpRequest request, IHostNetworkDepend hostNetworkDepend) {
        String str;
        LinkedHashMap linkedHashMap;
        List<Header> parseHeaderList;
        RequestContext createRequestContext;
        Unit unit;
        IHostNetworkRuntimeApi iHostNetworkRuntimeApi;
        IHostNetworkRuntimeApi iHostNetworkRuntimeApi2;
        int i;
        Call<TypedInput> doGetForStream;
        Unit unit2;
        SsResponse execute;
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(request, OauthTokenTriggerScene.REQUEST);
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
            String str2 = (String) parseBaseInfo.getFirst();
            str = (String) parseBaseInfo.getSecond();
            linkedHashMap = (LinkedHashMap) parseBaseInfo.getThird();
            parseHeaderList = parseHeaderList(request);
            createRequestContext = createRequestContext(request);
            Map<String, Object> networkConfig = getNetworkConfig(request);
            unit = null;
            if (hostNetworkDepend instanceof IHostNetworkDependV2) {
                XIRetrofit createRetrofit$default = IHostNetworkDependV2.DefaultImpls.createRetrofit$default((IHostNetworkDependV2) hostNetworkDepend, str2, false, networkConfig, 2, null);
                if (createRetrofit$default != null) {
                    iHostNetworkRuntimeApi = (IHostNetworkRuntimeApi) createRetrofit$default.create(IHostNetworkRuntimeApi.class);
                    iHostNetworkRuntimeApi2 = iHostNetworkRuntimeApi;
                }
                iHostNetworkRuntimeApi2 = null;
            } else {
                XIRetrofit createRetrofit$default2 = IHostNetworkDepend.DefaultImpls.createRetrofit$default(hostNetworkDepend, str2, false, 2, null);
                if (createRetrofit$default2 != null) {
                    iHostNetworkRuntimeApi = (IHostNetworkRuntimeApi) createRetrofit$default2.create(IHostNetworkRuntimeApi.class);
                    iHostNetworkRuntimeApi2 = iHostNetworkRuntimeApi;
                }
                iHostNetworkRuntimeApi2 = null;
            }
            i = WhenMappings.$EnumSwitchMapping$0[method.ordinal()];
        } catch (Throwable th) {
            objectRef2.element = "request for string cause exception";
            objectRef3.element = th;
            Logger.e(TAG, (String) objectRef2.element, th);
        }
        if (i == 1) {
            if (iHostNetworkRuntimeApi2 != null) {
                doGetForStream = iHostNetworkRuntimeApi2.doGetForStream(request.getNeedAddCommonParams(), -1, str, linkedHashMap, parseHeaderList, createRequestContext);
                if (doGetForStream != null) {
                }
                if (unit == null) {
                }
                return new AbsStreamConnection() { // from class: com.bytedance.sdk.xbridge.cn.runtime.utils.XNetworkRequestImpl$requestForStream$3
                    @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                    public LinkedHashMap<String, String> getResponseHeader() {
                        return linkedHashMap2;
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                    public int getResponseCode() {
                        return intRef.element;
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                    public InputStream getInputStreamResponseBody() {
                        return (InputStream) objectRef.element;
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                    public String getErrorMsg() {
                        return (String) objectRef2.element;
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                    public Throwable getException() {
                        return (Throwable) objectRef3.element;
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                    public Integer getClientCode() {
                        return Integer.valueOf(intRef2.element);
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                    public void cancel() {
                        Call call;
                        try {
                            InputStream inputStream = (InputStream) objectRef.element;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                        } catch (Throwable th2) {
                            Logger.e("HostNetworkDependImpl", "close inputStream failed", th2);
                        }
                        try {
                            WeakReference weakReference = (WeakReference) objectRef4.element;
                            if (weakReference == null || (call = (Call) weakReference.get()) == null || call.isCanceled()) {
                                return;
                            }
                            call.cancel();
                        } catch (Throwable th3) {
                            Logger.e("HostNetworkDependImpl", "close call failed", th3);
                        }
                    }
                };
            }
            doGetForStream = null;
            if (doGetForStream != null) {
            }
            if (unit == null) {
            }
            return new AbsStreamConnection() { // from class: com.bytedance.sdk.xbridge.cn.runtime.utils.XNetworkRequestImpl$requestForStream$3
                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                public LinkedHashMap<String, String> getResponseHeader() {
                    return linkedHashMap2;
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                public int getResponseCode() {
                    return intRef.element;
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                public InputStream getInputStreamResponseBody() {
                    return (InputStream) objectRef.element;
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                public String getErrorMsg() {
                    return (String) objectRef2.element;
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                public Throwable getException() {
                    return (Throwable) objectRef3.element;
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                public Integer getClientCode() {
                    return Integer.valueOf(intRef2.element);
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                public void cancel() {
                    Call call;
                    try {
                        InputStream inputStream = (InputStream) objectRef.element;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (Throwable th2) {
                        Logger.e("HostNetworkDependImpl", "close inputStream failed", th2);
                    }
                    try {
                        WeakReference weakReference = (WeakReference) objectRef4.element;
                        if (weakReference == null || (call = (Call) weakReference.get()) == null || call.isCanceled()) {
                            return;
                        }
                        call.cancel();
                    } catch (Throwable th3) {
                        Logger.e("HostNetworkDependImpl", "close call failed", th3);
                    }
                }
            };
        }
        if (i == 2) {
            TypedOutput parseTypedOutput = parseTypedOutput(request);
            if (parseTypedOutput != null && iHostNetworkRuntimeApi2 != null) {
                doGetForStream = iHostNetworkRuntimeApi2.doPostForStream(request.getNeedAddCommonParams(), -1, str, linkedHashMap, parseHeaderList, parseTypedOutput, createRequestContext);
                if (doGetForStream != null) {
                }
                if (unit == null) {
                }
                return new AbsStreamConnection() { // from class: com.bytedance.sdk.xbridge.cn.runtime.utils.XNetworkRequestImpl$requestForStream$3
                    @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                    public LinkedHashMap<String, String> getResponseHeader() {
                        return linkedHashMap2;
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                    public int getResponseCode() {
                        return intRef.element;
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                    public InputStream getInputStreamResponseBody() {
                        return (InputStream) objectRef.element;
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                    public String getErrorMsg() {
                        return (String) objectRef2.element;
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                    public Throwable getException() {
                        return (Throwable) objectRef3.element;
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                    public Integer getClientCode() {
                        return Integer.valueOf(intRef2.element);
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                    public void cancel() {
                        Call call;
                        try {
                            InputStream inputStream = (InputStream) objectRef.element;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                        } catch (Throwable th2) {
                            Logger.e("HostNetworkDependImpl", "close inputStream failed", th2);
                        }
                        try {
                            WeakReference weakReference = (WeakReference) objectRef4.element;
                            if (weakReference == null || (call = (Call) weakReference.get()) == null || call.isCanceled()) {
                                return;
                            }
                            call.cancel();
                        } catch (Throwable th3) {
                            Logger.e("HostNetworkDependImpl", "close call failed", th3);
                        }
                    }
                };
            }
            doGetForStream = null;
            if (doGetForStream != null) {
            }
            if (unit == null) {
            }
            return new AbsStreamConnection() { // from class: com.bytedance.sdk.xbridge.cn.runtime.utils.XNetworkRequestImpl$requestForStream$3
                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                public LinkedHashMap<String, String> getResponseHeader() {
                    return linkedHashMap2;
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                public int getResponseCode() {
                    return intRef.element;
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                public InputStream getInputStreamResponseBody() {
                    return (InputStream) objectRef.element;
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                public String getErrorMsg() {
                    return (String) objectRef2.element;
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                public Throwable getException() {
                    return (Throwable) objectRef3.element;
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                public Integer getClientCode() {
                    return Integer.valueOf(intRef2.element);
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                public void cancel() {
                    Call call;
                    try {
                        InputStream inputStream = (InputStream) objectRef.element;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (Throwable th2) {
                        Logger.e("HostNetworkDependImpl", "close inputStream failed", th2);
                    }
                    try {
                        WeakReference weakReference = (WeakReference) objectRef4.element;
                        if (weakReference == null || (call = (Call) weakReference.get()) == null || call.isCanceled()) {
                            return;
                        }
                        call.cancel();
                    } catch (Throwable th3) {
                        Logger.e("HostNetworkDependImpl", "close call failed", th3);
                    }
                }
            };
        }
        if (i == 5 && iHostNetworkRuntimeApi2 != null) {
            doGetForStream = iHostNetworkRuntimeApi2.downloadFile(request.getNeedAddCommonParams(), -1, str, linkedHashMap, parseHeaderList, createRequestContext);
            if (doGetForStream != null) {
                intRef.element = 0;
                objectRef4.element = new WeakReference(doGetForStream);
                try {
                    execute = doGetForStream.execute();
                } catch (HttpResponseException e) {
                    objectRef2.element = e.getClass().toString() + ':' + e.getMessage() + ',' + e.getStatusCode();
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
                    TypedInput typedInput = (TypedInput) execute.body();
                    objectRef.element = typedInput != null ? typedInput.in() : null;
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
                    }
                }
            }
            if (unit == null) {
                XNetworkRequestImpl xNetworkRequestImpl = this;
                objectRef2.element = "call is null, method is " + method.name();
                Logger.d(TAG, (String) objectRef2.element);
            }
            return new AbsStreamConnection() { // from class: com.bytedance.sdk.xbridge.cn.runtime.utils.XNetworkRequestImpl$requestForStream$3
                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                public LinkedHashMap<String, String> getResponseHeader() {
                    return linkedHashMap2;
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                public int getResponseCode() {
                    return intRef.element;
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                public InputStream getInputStreamResponseBody() {
                    return (InputStream) objectRef.element;
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                public String getErrorMsg() {
                    return (String) objectRef2.element;
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                public Throwable getException() {
                    return (Throwable) objectRef3.element;
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                public Integer getClientCode() {
                    return Integer.valueOf(intRef2.element);
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
                public void cancel() {
                    Call call;
                    try {
                        InputStream inputStream = (InputStream) objectRef.element;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (Throwable th2) {
                        Logger.e("HostNetworkDependImpl", "close inputStream failed", th2);
                    }
                    try {
                        WeakReference weakReference = (WeakReference) objectRef4.element;
                        if (weakReference == null || (call = (Call) weakReference.get()) == null || call.isCanceled()) {
                            return;
                        }
                        call.cancel();
                    } catch (Throwable th3) {
                        Logger.e("HostNetworkDependImpl", "close call failed", th3);
                    }
                }
            };
        }
        doGetForStream = null;
        if (doGetForStream != null) {
        }
        if (unit == null) {
        }
        return new AbsStreamConnection() { // from class: com.bytedance.sdk.xbridge.cn.runtime.utils.XNetworkRequestImpl$requestForStream$3
            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
            public LinkedHashMap<String, String> getResponseHeader() {
                return linkedHashMap2;
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
            public int getResponseCode() {
                return intRef.element;
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
            public InputStream getInputStreamResponseBody() {
                return (InputStream) objectRef.element;
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
            public String getErrorMsg() {
                return (String) objectRef2.element;
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
            public Throwable getException() {
                return (Throwable) objectRef3.element;
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
            public Integer getClientCode() {
                return Integer.valueOf(intRef2.element);
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
            public void cancel() {
                Call call;
                try {
                    InputStream inputStream = (InputStream) objectRef.element;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th2) {
                    Logger.e("HostNetworkDependImpl", "close inputStream failed", th2);
                }
                try {
                    WeakReference weakReference = (WeakReference) objectRef4.element;
                    if (weakReference == null || (call = (Call) weakReference.get()) == null || call.isCanceled()) {
                        return;
                    }
                    call.cancel();
                } catch (Throwable th3) {
                    Logger.e("HostNetworkDependImpl", "close call failed", th3);
                }
            }
        };
        objectRef2.element = "request for string cause exception";
        objectRef3.element = th;
        Logger.e(TAG, (String) objectRef2.element, th);
        return new AbsStreamConnection() { // from class: com.bytedance.sdk.xbridge.cn.runtime.utils.XNetworkRequestImpl$requestForStream$3
            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
            public LinkedHashMap<String, String> getResponseHeader() {
                return linkedHashMap2;
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
            public int getResponseCode() {
                return intRef.element;
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
            public InputStream getInputStreamResponseBody() {
                return (InputStream) objectRef.element;
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
            public String getErrorMsg() {
                return (String) objectRef2.element;
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
            public Throwable getException() {
                return (Throwable) objectRef3.element;
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
            public Integer getClientCode() {
                return Integer.valueOf(intRef2.element);
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection
            public void cancel() {
                Call call;
                try {
                    InputStream inputStream = (InputStream) objectRef.element;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th2) {
                    Logger.e("HostNetworkDependImpl", "close inputStream failed", th2);
                }
                try {
                    WeakReference weakReference = (WeakReference) objectRef4.element;
                    if (weakReference == null || (call = (Call) weakReference.get()) == null || call.isCanceled()) {
                        return;
                    }
                    call.cancel();
                } catch (Throwable th3) {
                    Logger.e("HostNetworkDependImpl", "close call failed", th3);
                }
            }
        };
    }
}
