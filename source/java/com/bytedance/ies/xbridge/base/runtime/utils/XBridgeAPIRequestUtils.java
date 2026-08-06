package com.bytedance.ies.xbridge.base.runtime.utils;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XCollectionsKt;
import com.bytedance.ies.xbridge.XDynamic;
import com.bytedance.ies.xbridge.XKeyIterator;
import com.bytedance.ies.xbridge.XReadableArray;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostNetworkDepend;
import com.bytedance.ies.xbridge.base.runtime.network.AbsStringConnection;
import com.bytedance.ies.xbridge.base.runtime.network.HttpRequest;
import com.bytedance.ies.xbridge.base.runtime.network.HttpUrlBuilder;
import com.bytedance.ies.xbridge.base.runtime.thread.ThreadUtils;
import com.bytedance.ies.xbridge.utils.XLog;
import com.bytedance.ies.xbridge.utils.XReadableJSONUtils;
import com.bytedance.pia.core.tracing.OnlineTracing;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: XBridgeAPIRequestUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014J6\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u001c\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J(\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00152\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015J<\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u0013\u001a\u00020\u0014JL\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\"\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040 j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`!2\u0006\u0010\u001b\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u0013\u001a\u00020\u0014J,\u0010#\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040 j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`!2\b\u0010$\u001a\u0004\u0018\u00010\u0010J8\u0010#\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040 j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`!2\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015J<\u0010%\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u0013\u001a\u00020\u0014J,\u0010&\u001a\u00020\u00042\"\u0010'\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040 j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`!H\u0002J\u001a\u0010(\u001a\u00020\u00182\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J;\u0010+\u001a\u00020\u00142\b\u0010,\u001a\u0004\u0018\u00010\u00072\b\u0010-\u001a\u0004\u0018\u00010\u00042\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cH\u0002¢\u0006\u0002\u00101JU\u00102\u001a\u00020\u00182\b\u00103\u001a\u0004\u0018\u00010\u00042\"\u00104\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040 j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`!2\b\u00105\u001a\u0004\u0018\u00010\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cH\u0002¢\u0006\u0002\u00106J\u0084\u0001\u00107\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\"\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040 j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`!2\"\u00108\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002090 j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u000209`!2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u0013\u001a\u00020\u0014JL\u00107\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00152\u0006\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u0013\u001a\u00020\u0014JL\u00107\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00152\u0006\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001b\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u0013\u001a\u00020\u0014JL\u00107\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00152\u0006\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u0013\u001a\u00020\u0014JL\u0010>\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00152\u0006\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u0010\u0010?\u001a\u00020\u00042\b\u0010@\u001a\u0004\u0018\u00010\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\u00040\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/utils/XBridgeAPIRequestUtils;", "", "()V", "CONTENT_TYPE", "", "CONTENT_TYPE_JSON", "ERROR_CODE_408", "", "REQUEST_ID_KEY", "REQUEST_TAG_FROM", "TAG", "kotlin.jvm.PlatformType", "X_TT_LOG_ID", "addParametersToUrl", "url", "params", "Lcom/bytedance/ies/xbridge/XReadableMap;", "type", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "addCommonParams", "", "", "convertParamValueToString", "delete", "", "targetUrl", "headers", "callback", "Lcom/bytedance/ies/xbridge/base/runtime/utils/IResponseCallback;", "hostNetworkDepend", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostNetworkDepend;", "downloadFile", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "Lcom/bytedance/ies/xbridge/base/runtime/utils/IStreamResponseCallback;", "filterHeaderEmptyValue", OnlineTracing.HeaderKeys.KEY_SSR_FALLBACK_HEADER, PrefetchRequestConfig.METHOD_GET, "getRequestLogId", "responseHeader", "handleConnection", "connection", "Lcom/bytedance/ies/xbridge/base/runtime/network/AbsStringConnection;", "handleError", "errorCode", "errorMsg", "throwable", "", "clientCode", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Throwable;ILcom/bytedance/ies/xbridge/base/runtime/utils/IResponseCallback;)Z", "handleSuccess", "body", "respHeader", "respCode", "(Ljava/lang/String;Ljava/util/LinkedHashMap;Ljava/lang/Integer;ILcom/bytedance/ies/xbridge/base/runtime/utils/IResponseCallback;)V", PrefetchRequestConfig.METHOD_POST, "postFilePart", "Ljava/io/File;", "contentType", "postData", "", "Lorg/json/JSONObject;", "put", "toStringOrJson", "data", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class XBridgeAPIRequestUtils {
    public static final String CONTENT_TYPE = "Content-Type";
    private static final String CONTENT_TYPE_JSON = "application/json";
    public static final int ERROR_CODE_408 = -408;
    public static final String REQUEST_ID_KEY = "_Header_RequestID";
    public static final String REQUEST_TAG_FROM = "request_tag_from";
    public static final String X_TT_LOG_ID = "x-tt-logid";
    public static final XBridgeAPIRequestUtils INSTANCE = new XBridgeAPIRequestUtils();
    private static String TAG = "XBridgeAPIRequestUtils";

    /* compiled from: XBridgeAPIRequestUtils.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[XReadableType.values().length];
            try {
                iArr[XReadableType.Int.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[XReadableType.Boolean.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[XReadableType.Number.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[XReadableType.String.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[XReadableType.Map.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[XReadableType.Array.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private XBridgeAPIRequestUtils() {
    }

    public final String toStringOrJson(Object data) {
        if (data == null) {
            return "";
        }
        if (data instanceof Map) {
            String jSONObject = new JSONObject((Map) data).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject(data).toString()");
            return jSONObject;
        }
        if (!(data instanceof List)) {
            return data.toString();
        }
        String jSONArray = new JSONArray((Collection) data).toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray, "JSONArray(data).toString()");
        return jSONArray;
    }

    public final LinkedHashMap<String, String> filterHeaderEmptyValue(Map<String, ? extends Object> header) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        if (header != null) {
            for (Map.Entry<String, ? extends Object> entry : header.entrySet()) {
                String stringOrJson = INSTANCE.toStringOrJson(entry.getValue());
                if (stringOrJson.length() > 0) {
                    linkedHashMap.put(entry.getKey(), stringOrJson);
                }
            }
        }
        return linkedHashMap;
    }

    public final LinkedHashMap<String, String> filterHeaderEmptyValue(XReadableMap header) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        if (header != null) {
            XKeyIterator keyIterator = header.keyIterator();
            while (keyIterator.hasNextKey()) {
                String nextKey = keyIterator.nextKey();
                String optString$default = XCollectionsKt.optString$default(header, nextKey, null, 2, null);
                if ((optString$default.length() > 0 ? optString$default : null) != null) {
                    linkedHashMap.put(nextKey, optString$default);
                }
            }
        }
        return linkedHashMap;
    }

    public final Map<String, String> convertParamValueToString(XReadableMap params) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (params != null) {
            XKeyIterator keyIterator = params.keyIterator();
            while (keyIterator.hasNextKey()) {
                String nextKey = keyIterator.nextKey();
                XDynamic xDynamic = params.get(nextKey);
                int i = WhenMappings.$EnumSwitchMapping$0[xDynamic.getType().ordinal()];
                if (i == 1) {
                    linkedHashMap.put(nextKey, String.valueOf(xDynamic.asInt()));
                } else if (i == 2) {
                    linkedHashMap.put(nextKey, String.valueOf(xDynamic.asBoolean()));
                } else if (i == 3) {
                    linkedHashMap.put(nextKey, String.valueOf(xDynamic.asDouble()));
                } else if (i == 4) {
                    linkedHashMap.put(nextKey, xDynamic.asString());
                }
            }
        }
        return linkedHashMap;
    }

    public static /* synthetic */ String addParametersToUrl$default(XBridgeAPIRequestUtils xBridgeAPIRequestUtils, String str, Map map, XBridgePlatformType xBridgePlatformType, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return xBridgeAPIRequestUtils.addParametersToUrl(str, (Map<String, ? extends Object>) map, xBridgePlatformType, z);
    }

    public final String addParametersToUrl(String url, Map<String, ? extends Object> params, XBridgePlatformType type, boolean addCommonParams) {
        String str;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(type, "type");
        HttpUrlBuilder httpUrlBuilder = new HttpUrlBuilder(url);
        if (params != null) {
            for (Map.Entry<String, ? extends Object> entry : params.entrySet()) {
                httpUrlBuilder.addParam(entry.getKey(), INSTANCE.toStringOrJson(entry.getValue()));
            }
        }
        if (addCommonParams) {
            if (type == XBridgePlatformType.WEB) {
                str = "h5";
            } else {
                str = type == XBridgePlatformType.LYNX ? "lynx" : "";
            }
            httpUrlBuilder.addParam(REQUEST_TAG_FROM, str);
        }
        Log.d(TAG, "build url is " + httpUrlBuilder.build());
        return httpUrlBuilder.build();
    }

    public static /* synthetic */ String addParametersToUrl$default(XBridgeAPIRequestUtils xBridgeAPIRequestUtils, String str, XReadableMap xReadableMap, XBridgePlatformType xBridgePlatformType, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return xBridgeAPIRequestUtils.addParametersToUrl(str, xReadableMap, xBridgePlatformType, z);
    }

    public final String addParametersToUrl(String url, XReadableMap params, XBridgePlatformType type, boolean addCommonParams) {
        String str;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(type, "type");
        HttpUrlBuilder httpUrlBuilder = new HttpUrlBuilder(url);
        if (params != null) {
            XKeyIterator keyIterator = params.keyIterator();
            while (keyIterator.hasNextKey()) {
                String nextKey = keyIterator.nextKey();
                XDynamic xDynamic = params.get(nextKey);
                switch (WhenMappings.$EnumSwitchMapping$0[xDynamic.getType().ordinal()]) {
                    case 1:
                        httpUrlBuilder.addParam(nextKey, String.valueOf(xDynamic.asInt()));
                        break;
                    case 2:
                        httpUrlBuilder.addParam(nextKey, String.valueOf(xDynamic.asBoolean()));
                        break;
                    case 3:
                        httpUrlBuilder.addParam(nextKey, String.valueOf(xDynamic.asDouble()));
                        break;
                    case 4:
                        httpUrlBuilder.addParam(nextKey, xDynamic.asString());
                        break;
                    case 5:
                        XReadableJSONUtils xReadableJSONUtils = XReadableJSONUtils.INSTANCE;
                        XReadableMap asMap = xDynamic.asMap();
                        Intrinsics.checkNotNull(asMap);
                        String jSONObject = xReadableJSONUtils.xReadableMapToJSONObject(asMap).toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "XReadableJSONUtils.xRead…lue.asMap()!!).toString()");
                        httpUrlBuilder.addParam(nextKey, jSONObject);
                        break;
                    case 6:
                        XReadableJSONUtils xReadableJSONUtils2 = XReadableJSONUtils.INSTANCE;
                        XReadableArray asArray = xDynamic.asArray();
                        Intrinsics.checkNotNull(asArray);
                        String jSONArray = xReadableJSONUtils2.xReadableArrayToJSONArray(asArray).toString();
                        Intrinsics.checkNotNullExpressionValue(jSONArray, "XReadableJSONUtils.xRead…e.asArray()!!).toString()");
                        httpUrlBuilder.addParam(nextKey, jSONArray);
                        break;
                }
            }
        }
        if (addCommonParams) {
            if (type == XBridgePlatformType.WEB) {
                str = "h5";
            } else {
                str = type == XBridgePlatformType.LYNX ? "lynx" : "";
            }
            httpUrlBuilder.addParam(REQUEST_TAG_FROM, str);
        }
        Log.d(TAG, "build url is " + httpUrlBuilder.build());
        return httpUrlBuilder.build();
    }

    public static /* synthetic */ void get$default(XBridgeAPIRequestUtils xBridgeAPIRequestUtils, String str, Map map, IResponseCallback iResponseCallback, IHostNetworkDepend iHostNetworkDepend, boolean z, int i, Object obj) {
        if ((i & 16) != 0) {
            z = true;
        }
        xBridgeAPIRequestUtils.get(str, map, iResponseCallback, iHostNetworkDepend, z);
    }

    public final void get(String targetUrl, Map<String, String> headers, IResponseCallback callback, IHostNetworkDepend hostNetworkDepend, boolean addCommonParams) {
        Intrinsics.checkNotNullParameter(targetUrl, "targetUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(hostNetworkDepend, "hostNetworkDepend");
        handleConnection(new HttpRequest(targetUrl).headers((LinkedHashMap) headers).needAddCommonParams(addCommonParams).doGetForString(hostNetworkDepend), callback);
    }

    public final void post(String targetUrl, LinkedHashMap<String, String> headers, LinkedHashMap<String, File> postFilePart, Map<String, String> params, IResponseCallback callback, IHostNetworkDepend hostNetworkDepend, boolean addCommonParams) {
        Intrinsics.checkNotNullParameter(targetUrl, "targetUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(postFilePart, "postFilePart");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(hostNetworkDepend, "hostNetworkDepend");
        handleConnection(new HttpRequest(targetUrl).headers(headers).postFilePart(postFilePart).params(params).needAddCommonParams(addCommonParams).doPostForString(hostNetworkDepend), callback);
    }

    public final void post(String targetUrl, Map<String, String> headers, String contentType, byte[] postData, IStreamResponseCallback callback, IHostNetworkDepend hostNetworkDepend, boolean addCommonParams) {
        Intrinsics.checkNotNullParameter(targetUrl, "targetUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(postData, "postData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(hostNetworkDepend, "hostNetworkDepend");
        try {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.putAll(headers);
            callback.handleConnection(new HttpRequest(targetUrl).headers(linkedHashMap).contentType(contentType).needAddCommonParams(addCommonParams).sendData(postData).doPostForStream(hostNetworkDepend));
        } catch (Throwable th) {
            Log.e(TAG, "get failed", th);
        }
    }

    public final void post(String targetUrl, Map<String, String> headers, String contentType, byte[] postData, IResponseCallback callback, IHostNetworkDepend hostNetworkDepend, boolean addCommonParams) {
        Intrinsics.checkNotNullParameter(targetUrl, "targetUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(postData, "postData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(hostNetworkDepend, "hostNetworkDepend");
        try {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.putAll(headers);
            handleConnection(new HttpRequest(targetUrl).headers(linkedHashMap).contentType(contentType).needAddCommonParams(addCommonParams).sendData(postData).doPostForString(hostNetworkDepend), callback);
        } catch (Throwable th) {
            Log.e(TAG, "get failed", th);
        }
    }

    public final void post(String targetUrl, Map<String, String> headers, String contentType, JSONObject postData, IResponseCallback callback, IHostNetworkDepend hostNetworkDepend, boolean addCommonParams) {
        AbsStringConnection doPostForString;
        Intrinsics.checkNotNullParameter(targetUrl, "targetUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(postData, "postData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(hostNetworkDepend, "hostNetworkDepend");
        try {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.putAll(headers);
            if (Intrinsics.areEqual(contentType, CONTENT_TYPE_JSON)) {
                HttpRequest needAddCommonParams = new HttpRequest(targetUrl).headers(linkedHashMap).contentType(contentType).needAddCommonParams(addCommonParams);
                String jSONObject = postData.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "postData.toString()");
                Charset forName = Charset.forName("UTF-8");
                Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(charsetName)");
                byte[] bytes = jSONObject.getBytes(forName);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                doPostForString = needAddCommonParams.sendData(bytes).doPostForString(hostNetworkDepend);
            } else {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                Iterator<String> keys = postData.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String optString = postData.optString(next, "");
                    Intrinsics.checkNotNullExpressionValue(next, "key");
                    Intrinsics.checkNotNullExpressionValue(optString, "value");
                    linkedHashMap2.put(next, optString);
                }
                doPostForString = new HttpRequest(targetUrl).headers(linkedHashMap).params(linkedHashMap2).needAddCommonParams(addCommonParams).doPostForString(hostNetworkDepend);
            }
            handleConnection(doPostForString, callback);
        } catch (Throwable th) {
            Log.e(TAG, "get failed", th);
        }
    }

    public final void put(String targetUrl, Map<String, String> headers, String contentType, JSONObject postData, IResponseCallback callback, IHostNetworkDepend hostNetworkDepend, boolean addCommonParams) {
        Intrinsics.checkNotNullParameter(targetUrl, "targetUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(postData, "postData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(hostNetworkDepend, "hostNetworkDepend");
        HttpRequest needAddCommonParams = new HttpRequest(targetUrl).headers((LinkedHashMap) headers).contentType(contentType).needAddCommonParams(addCommonParams);
        String jSONObject = postData.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "postData.toString()");
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(charsetName)");
        byte[] bytes = jSONObject.getBytes(forName);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        handleConnection(needAddCommonParams.sendData(bytes).doPutForString(hostNetworkDepend), callback);
    }

    public static /* synthetic */ void delete$default(XBridgeAPIRequestUtils xBridgeAPIRequestUtils, String str, Map map, IResponseCallback iResponseCallback, IHostNetworkDepend iHostNetworkDepend, boolean z, int i, Object obj) {
        if ((i & 16) != 0) {
            z = true;
        }
        xBridgeAPIRequestUtils.delete(str, map, iResponseCallback, iHostNetworkDepend, z);
    }

    public final void delete(String targetUrl, Map<String, String> headers, IResponseCallback callback, IHostNetworkDepend hostNetworkDepend, boolean addCommonParams) {
        Intrinsics.checkNotNullParameter(targetUrl, "targetUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(hostNetworkDepend, "hostNetworkDepend");
        handleConnection(new HttpRequest(targetUrl).headers((LinkedHashMap) headers).needAddCommonParams(addCommonParams).doDeleteForString(hostNetworkDepend), callback);
    }

    public static /* synthetic */ void downloadFile$default(XBridgeAPIRequestUtils xBridgeAPIRequestUtils, String str, LinkedHashMap linkedHashMap, IStreamResponseCallback iStreamResponseCallback, IHostNetworkDepend iHostNetworkDepend, boolean z, int i, Object obj) {
        if ((i & 16) != 0) {
            z = true;
        }
        xBridgeAPIRequestUtils.downloadFile(str, linkedHashMap, iStreamResponseCallback, iHostNetworkDepend, z);
    }

    public final void downloadFile(String targetUrl, LinkedHashMap<String, String> headers, IStreamResponseCallback callback, IHostNetworkDepend hostNetworkDepend, boolean addCommonParams) {
        Intrinsics.checkNotNullParameter(targetUrl, "targetUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(hostNetworkDepend, "hostNetworkDepend");
        callback.handleConnection(new HttpRequest(targetUrl).headers(headers).needAddCommonParams(addCommonParams).doDownloadFile(hostNetworkDepend));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getRequestLogId(LinkedHashMap<String, String> responseHeader) {
        String str;
        return (!responseHeader.containsKey("x-tt-logid") || (str = responseHeader.get("x-tt-logid")) == null) ? "" : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleConnection(AbsStringConnection connection, IResponseCallback callback) {
        String str;
        if (connection == null) {
            Log.d(TAG, "connection is null");
            handleError(Integer.valueOf(ERROR_CODE_408), "connection failed", null, 0, callback);
            return;
        }
        String stringResponseBody = connection.getStringResponseBody();
        if (stringResponseBody != null) {
            if (stringResponseBody.length() > 0) {
                str = stringResponseBody;
                Integer clientCode = connection.getClientCode();
                if (str != null) {
                    Log.d(TAG, "response body is null");
                    if (handleError(connection.getResponseCode(), connection.getErrorMsg(), connection.getException(), clientCode != null ? clientCode.intValue() : 0, callback)) {
                        return;
                    }
                    handleSuccess(str, connection.getResponseHeader(), connection.getResponseCode(), clientCode != null ? clientCode.intValue() : 0, callback);
                    return;
                }
                if (handleError(connection.getResponseCode(), connection.getErrorMsg(), connection.getException(), clientCode != null ? clientCode.intValue() : 0, callback)) {
                    return;
                }
                Log.d(TAG, "handle response body");
                handleSuccess(str, connection.getResponseHeader(), connection.getResponseCode(), clientCode != null ? clientCode.intValue() : 0, callback);
                return;
            }
        }
        str = null;
        Integer clientCode2 = connection.getClientCode();
        if (str != null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:
    
        if (r10 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean handleError(final Integer errorCode, String errorMsg, final Throwable throwable, final int clientCode, final IResponseCallback callback) {
        final String str;
        if (throwable == null && TextUtils.isEmpty(errorMsg)) {
            return false;
        }
        if (errorMsg != null) {
            if (!(errorMsg.length() > 0)) {
                errorMsg = null;
            }
        }
        String message = throwable != null ? throwable.getMessage() : null;
        if (message == null) {
            errorMsg = "";
            str = errorMsg;
            ThreadUtils.getMainThreadHandler().post(new Runnable() { // from class: com.bytedance.ies.xbridge.base.runtime.utils.XBridgeAPIRequestUtils$handleError$1
                @Override // java.lang.Runnable
                public final void run() {
                    IResponseCallback iResponseCallback = IResponseCallback.this;
                    Integer num = errorCode;
                    Throwable th = throwable;
                    String str2 = str;
                    int i = clientCode;
                    try {
                        Result.Companion companion = Result.Companion;
                        if (th == null) {
                            th = new Throwable(str2);
                        }
                        iResponseCallback.onFailed(num, th, i);
                        Result.constructor-impl(Unit.INSTANCE);
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                }
            });
            Log.d(TAG, "handle error finish");
            return true;
        }
        str = message;
        ThreadUtils.getMainThreadHandler().post(new Runnable() { // from class: com.bytedance.ies.xbridge.base.runtime.utils.XBridgeAPIRequestUtils$handleError$1
            @Override // java.lang.Runnable
            public final void run() {
                IResponseCallback iResponseCallback = IResponseCallback.this;
                Integer num = errorCode;
                Throwable th = throwable;
                String str2 = str;
                int i = clientCode;
                try {
                    Result.Companion companion = Result.Companion;
                    if (th == null) {
                        th = new Throwable(str2);
                    }
                    iResponseCallback.onFailed(num, th, i);
                    Result.constructor-impl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th2));
                }
            }
        });
        Log.d(TAG, "handle error finish");
        return true;
    }

    private final void handleSuccess(final String body, final LinkedHashMap<String, String> respHeader, final Integer respCode, final int clientCode, final IResponseCallback callback) {
        ThreadUtils.getMainThreadHandler().post(new Runnable() { // from class: com.bytedance.ies.xbridge.base.runtime.utils.XBridgeAPIRequestUtils$handleSuccess$1
            /* JADX WARN: Code restructure failed: missing block: B:29:0x0076, code lost:
            
                r4 = "";
             */
            /* JADX WARN: Removed duplicated region for block: B:23:0x00ce  */
            /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void run() {
                Object obj;
                Throwable th;
                String requestLogId;
                JSONObject jSONObject;
                String str;
                String str2;
                boolean z;
                String str3 = body;
                LinkedHashMap<String, String> linkedHashMap = respHeader;
                IResponseCallback iResponseCallback = callback;
                Integer num = respCode;
                int i = clientCode;
                try {
                    Result.Companion companion = Result.Companion;
                    try {
                        JSONObject jSONObject2 = new JSONObject(str3);
                        str2 = null;
                        str = null;
                        jSONObject = jSONObject2;
                        th = null;
                    } catch (Throwable th2) {
                        th = th2;
                        JSONObject jSONObject3 = new JSONObject();
                        requestLogId = XBridgeAPIRequestUtils.INSTANCE.getRequestLogId(linkedHashMap);
                        JSONObject put = jSONObject3.put(XBridgeAPIRequestUtils.REQUEST_ID_KEY, requestLogId);
                        Intrinsics.checkNotNullExpressionValue(put, "JSONObject().put(REQUEST…RequestLogId(respHeader))");
                        jSONObject = put;
                        str = str3;
                        str2 = th.getClass().toString() + ':' + th.getMessage();
                    }
                    z = false;
                    if (str2 != null) {
                        if (str2.length() > 0) {
                            z = true;
                        }
                    }
                } catch (Throwable th3) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th3));
                }
                if (!z && th == null && str == null) {
                    iResponseCallback.onSuccess(jSONObject, linkedHashMap, num, i);
                    XLog.INSTANCE.info("x.request response:" + jSONObject + " header:" + linkedHashMap + " respCode:" + num);
                    obj = Result.constructor-impl(Unit.INSTANCE);
                    IResponseCallback iResponseCallback2 = callback;
                    LinkedHashMap<String, String> linkedHashMap2 = respHeader;
                    Integer num2 = respCode;
                    int i2 = clientCode;
                    th = Result.exceptionOrNull-impl(obj);
                    if (th != null) {
                        return;
                    }
                    iResponseCallback2.onParsingFailed(new JSONObject(), linkedHashMap2, "", th, num2, i2);
                    return;
                }
                String str4 = str;
                if (th == null) {
                    th = new Throwable(str2);
                }
                iResponseCallback.onParsingFailed(jSONObject, linkedHashMap, str4, th, num, i);
                XLog.INSTANCE.info("x.request response:" + jSONObject + " header:" + linkedHashMap + " respCode:" + num);
                obj = Result.constructor-impl(Unit.INSTANCE);
                IResponseCallback iResponseCallback22 = callback;
                LinkedHashMap<String, String> linkedHashMap22 = respHeader;
                Integer num22 = respCode;
                int i22 = clientCode;
                th = Result.exceptionOrNull-impl(obj);
                if (th != null) {
                }
            }
        });
    }

    public final Map<String, String> convertParamValueToString(Map<String, ? extends Object> params) {
        if (params == null) {
            return MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(params.size()));
        Iterator<T> it = params.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), INSTANCE.toStringOrJson(entry.getValue()));
        }
        return linkedHashMap;
    }
}
