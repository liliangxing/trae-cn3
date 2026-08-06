package com.lynx.jsbridge;

import android.util.Pair;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxSubErrorCode;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.base.trace.TraceEventDef;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.image.ImageContent;
import com.lynx.tasm.image.model.ImageInfo;
import com.lynx.tasm.image.model.ImageLoadListener;
import com.lynx.tasm.image.model.ImageRequestInfo;
import com.lynx.tasm.service.ILynxImageService;
import com.lynx.tasm.service.ILynxResourceService;
import com.lynx.tasm.service.LynxServiceCenter;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxResourceModule extends LynxContextModule {
    public static final String AUDIO_TYPE = "audio";
    public static final String CODE_KEY = "code";
    public static final String DATA_KEY = "data";
    public static final long DEFAULT_MEDIA_SIZE = 512000;
    public static final String DETAIL_KEY = "details";
    public static final String IMAGE_TYPE = "image";
    public static final String MSG_KEY = "msg";
    public static final String NAME = "LynxResourceModule";
    public static final String PARAMS_KEY = "params";
    public static final String TYPE_KEY = "type";
    public static final String URI_KEY = "uri";
    public static final String VIDEO_TYPE = "video";
    private ILynxImageService mImagePrefetchHelper;

    public LynxResourceModule(LynxContext lynxContext) {
        super(lynxContext);
        ILynxImageService service = LynxServiceCenter.inst().getService(ILynxImageService.class);
        this.mImagePrefetchHelper = service;
        if (service == null) {
            onErrorOccurred(new LynxError(LynxSubErrorCode.E_RESOURCE_MODULE_IMG_PREFETCH_HELPER_NOT_EXIST, "An exception occurred when try to get image prefetch helper.", "An error occurred while attempting to create a Java object ImagePrefetchHelper through reflection. This may be due to a change in the constructor interface of ImagePrefetchHelper, or because ImagePrefetchHelper is located in a plugin that is not ready. If you are unable to resolve this issue, you can seek help from the client RD.", "error"));
        }
    }

    @LynxMethod
    void cancelResourcePrefetch(ReadableMap readableMap, Callback callback) {
        TraceEvent.beginSection(TraceEventDef.CANCEL_RESOURCE_PREFETCH);
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        Pair<Integer, String> resourcePrefetch = resourcePrefetch(readableMap, true, javaOnlyMap);
        Integer num = (Integer) resourcePrefetch.first;
        String str = (String) resourcePrefetch.second;
        TraceEvent.endSection(TraceEventDef.CANCEL_RESOURCE_PREFETCH);
        javaOnlyMap.putInt("code", num.intValue());
        javaOnlyMap.putString("msg", str);
        if (callback != null) {
            callback.invoke(javaOnlyMap);
        }
    }

    @LynxMethod
    void requestResourcePrefetch(ReadableMap readableMap, Callback callback) {
        TraceEvent.beginSection(TraceEventDef.REQUEST_RESOURCE_PREFETCH);
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        Pair<Integer, String> resourcePrefetch = resourcePrefetch(readableMap, false, javaOnlyMap);
        Integer num = (Integer) resourcePrefetch.first;
        String str = (String) resourcePrefetch.second;
        TraceEvent.endSection(TraceEventDef.REQUEST_RESOURCE_PREFETCH);
        javaOnlyMap.putInt("code", num.intValue());
        javaOnlyMap.putString("msg", str);
        if (callback != null) {
            callback.invoke(javaOnlyMap);
        }
    }

    @LynxMethod
    public void requestResourcePrefetchImage(ReadableMap readableMap, final Callback callback) {
        String string = readableMap.getString(URI_KEY, null);
        ReadableMap map = readableMap.getMap("params", null);
        if (string == null) {
            onErrorOccurred(new LynxError(LynxSubErrorCode.E_RESOURCE_MODULE_PARAMS_ERROR, "Parameters error in Lynx resource prefetch module! 'uri' is null.", "Please check the parameters passed to Lynx resource prefetch module.", "error"));
            if (callback != null) {
                JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
                javaOnlyMap.putInt("code", LynxSubErrorCode.E_RESOURCE_MODULE_PARAMS_ERROR);
                javaOnlyMap.putString("msg", "Parameters error in Lynx resource prefetch module! 'uri' is null.");
                callback.invoke(javaOnlyMap);
                return;
            }
            return;
        }
        ILynxImageService iLynxImageService = this.mImagePrefetchHelper;
        if (iLynxImageService == null) {
            onErrorOccurred(new LynxError(LynxSubErrorCode.E_RESOURCE_MODULE_IMG_PREFETCH_HELPER_NOT_EXIST, "Image prefetch helper do not exist!", "If the Resource service does not exist, it may be due to an error that occurred while creating the resource service through reflection. Please contact the client RD for help.", "error"));
            if (callback != null) {
                JavaOnlyMap javaOnlyMap2 = new JavaOnlyMap();
                javaOnlyMap2.putInt("code", LynxSubErrorCode.E_RESOURCE_MODULE_IMG_PREFETCH_HELPER_NOT_EXIST);
                javaOnlyMap2.putString("msg", "Image prefetch helper do not exist!");
                callback.invoke(javaOnlyMap2);
                return;
            }
            return;
        }
        iLynxImageService.prefetchImage(string, this.mLynxContext.getFrescoCallerContext(), (Map) map, new ImageLoadListener() { // from class: com.lynx.jsbridge.LynxResourceModule.1
            public void onImageMonitorInfo(JSONObject jSONObject) {
            }

            public void onRequestSubmit(ImageRequestInfo imageRequestInfo) {
            }

            private void invokeCallback(int i, String str) {
                if (callback != null) {
                    JavaOnlyMap javaOnlyMap3 = new JavaOnlyMap();
                    javaOnlyMap3.putInt("code", i);
                    javaOnlyMap3.putString("msg", str);
                    callback.invoke(javaOnlyMap3);
                }
            }

            public void onSuccess(ImageContent imageContent, ImageRequestInfo imageRequestInfo, ImageInfo imageInfo) {
                invokeCallback(0, "");
            }

            public void onFailure(int i, Throwable th) {
                invokeCallback(i, "prefetch image failed");
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Pair<Integer, String> resourcePrefetch(ReadableMap readableMap, boolean z, JavaOnlyMap javaOnlyMap) {
        String str;
        Integer num;
        String string;
        Integer num2;
        ReadableArray readableArray;
        String str2;
        Pair<Integer, String> requestResourcePrefetchInternal;
        Integer num3;
        int i = 0;
        Integer num4 = 0;
        ReadableArray array = readableMap.getArray("data", null);
        Integer valueOf = Integer.valueOf(LynxSubErrorCode.E_RESOURCE_MODULE_PARAMS_ERROR);
        if (array == null) {
            str = "Parameters error in Lynx resource prefetch module! Value of 'data' should be an array.";
            LynxError lynxError = new LynxError(valueOf.intValue(), "Parameters error in Lynx resource prefetch module! Value of 'data' should be an array.", "Please check the parameters passed to Lynx resource prefetch module.", "error");
            lynxError.addCustomInfo("actionType", z ? "cancel" : "request");
            onErrorOccurred(lynxError);
            num = valueOf;
        } else {
            JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
            int i2 = 0;
            while (i2 < array.size()) {
                Integer.valueOf(i);
                JavaOnlyMap javaOnlyMap2 = new JavaOnlyMap();
                if (array.getType(i2) != ReadableType.Map) {
                    str2 = "Parameters error in Lynx resource prefetch module! The prefetch data should be a map.";
                    num2 = num4;
                    readableArray = array;
                    string = "";
                } else {
                    ReadableMap map = array.getMap(i2);
                    string = map.getString(URI_KEY, null);
                    num2 = num4;
                    String string2 = map.getString("type", null);
                    readableArray = array;
                    ReadableMap map2 = map.getMap("params", null);
                    if (string == null || string2 == null) {
                        str2 = "Parameters error in Lynx resource prefetch module! 'uri' or 'type' is null.";
                    } else {
                        if (z) {
                            requestResourcePrefetchInternal = cancelResourcePrefetchInternal(string, string2, map2);
                        } else {
                            requestResourcePrefetchInternal = requestResourcePrefetchInternal(string, string2, map2);
                        }
                        num3 = (Integer) requestResourcePrefetchInternal.first;
                        String str3 = (String) requestResourcePrefetchInternal.second;
                        javaOnlyMap2.putString(URI_KEY, string);
                        javaOnlyMap2.putString("type", string2);
                        str2 = str3;
                        if (num3.intValue() == 0) {
                            LynxError lynxError2 = new LynxError(num3.intValue(), str2, "If it is a parameter error, please check the parameters passed in. If the Resource service does not exist, it may be due to an error that occurred while creating the resource service through reflection. Please contact the client RD for help.", "error");
                            lynxError2.addCustomInfo("resourceUri", string);
                            lynxError2.addCustomInfo("actionType", z ? "cancel" : "request");
                            onErrorOccurred(lynxError2);
                        }
                        javaOnlyMap2.putInt("code", num3.intValue());
                        javaOnlyMap2.putString("msg", str2);
                        javaOnlyArray.pushMap(javaOnlyMap2);
                        i2++;
                        array = readableArray;
                        num4 = num2;
                        i = 0;
                    }
                }
                num3 = valueOf;
                if (num3.intValue() == 0) {
                }
                javaOnlyMap2.putInt("code", num3.intValue());
                javaOnlyMap2.putString("msg", str2);
                javaOnlyArray.pushMap(javaOnlyMap2);
                i2++;
                array = readableArray;
                num4 = num2;
                i = 0;
            }
            javaOnlyMap.putArray(DETAIL_KEY, javaOnlyArray);
            str = "";
            num = num4;
        }
        return new Pair<>(num, str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x002f, code lost:
    
        if (r14.equals("audio") == false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Pair<Integer, String> requestResourcePrefetchInternal(String str, String str2, ReadableMap readableMap) {
        char c = 0;
        int i = 0;
        str2.hashCode();
        switch (str2.hashCode()) {
            case 93166550:
                break;
            case 100313435:
                if (str2.equals(IMAGE_TYPE)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 112202875:
                if (str2.equals("video")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        String str3 = "";
        switch (c) {
            case 0:
            case 2:
                if (readableMap == null) {
                    i = Integer.valueOf(LynxSubErrorCode.E_RESOURCE_MODULE_PARAMS_ERROR);
                } else {
                    String string = readableMap.getString("preloadKey", null);
                    String string2 = readableMap.getString("videoID", null);
                    long j = readableMap.getLong("size", DEFAULT_MEDIA_SIZE);
                    ILynxResourceService service = LynxServiceCenter.inst().getService(ILynxResourceService.class);
                    if (service != null) {
                        if (string == null) {
                            i = Integer.valueOf(LynxSubErrorCode.E_RESOURCE_MODULE_PARAMS_ERROR);
                        } else {
                            service.preloadMedia(str, string, string2, j);
                            break;
                        }
                    } else {
                        i = Integer.valueOf(LynxSubErrorCode.E_RESOURCE_MODULE_RESOURCE_SERVICE_NOT_EXIST);
                        str3 = "Resource service do not exist!";
                        break;
                    }
                }
                str3 = "missing preloadKey!";
                break;
            case 1:
                ILynxImageService iLynxImageService = this.mImagePrefetchHelper;
                if (iLynxImageService == null) {
                    i = Integer.valueOf(LynxSubErrorCode.E_RESOURCE_MODULE_IMG_PREFETCH_HELPER_NOT_EXIST);
                    str3 = "Image prefetch helper do not exist!";
                    break;
                } else {
                    iLynxImageService.prefetchImage(str, this.mLynxContext.getFrescoCallerContext(), (Map) readableMap);
                    break;
                }
            default:
                i = Integer.valueOf(LynxSubErrorCode.E_RESOURCE_MODULE_PARAMS_ERROR);
                str3 = "Parameters error! Unknown type :" + str2;
                break;
        }
        LLog.m2578i(NAME, "requestResourcePrefetch uri: " + str + " type: " + str2);
        return new Pair<>(i, str3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x002f, code lost:
    
        if (r9.equals("audio") == false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Pair<Integer, String> cancelResourcePrefetchInternal(String str, String str2, ReadableMap readableMap) {
        char c = 0;
        int i = 0;
        str2.hashCode();
        switch (str2.hashCode()) {
            case 93166550:
                break;
            case 100313435:
                if (str2.equals(IMAGE_TYPE)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 112202875:
                if (str2.equals("video")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        String str3 = "";
        switch (c) {
            case 0:
            case 2:
                if (readableMap == null) {
                    i = Integer.valueOf(LynxSubErrorCode.E_RESOURCE_MODULE_PARAMS_ERROR);
                } else {
                    String string = readableMap.getString("preloadKey", null);
                    String string2 = readableMap.getString("videoID", null);
                    ILynxResourceService service = LynxServiceCenter.inst().getService(ILynxResourceService.class);
                    if (service != null) {
                        if (string == null) {
                            i = Integer.valueOf(LynxSubErrorCode.E_RESOURCE_MODULE_PARAMS_ERROR);
                        } else {
                            service.cancelPreloadMedia(string, string2);
                            break;
                        }
                    } else {
                        i = Integer.valueOf(LynxSubErrorCode.E_RESOURCE_MODULE_RESOURCE_SERVICE_NOT_EXIST);
                        str3 = "Resource service do not exist!";
                        break;
                    }
                }
                str3 = "missing preloadKey!";
                break;
            case 1:
                if (this.mImagePrefetchHelper == null) {
                    i = Integer.valueOf(LynxSubErrorCode.E_RESOURCE_MODULE_IMG_PREFETCH_HELPER_NOT_EXIST);
                    str3 = "Image prefetch helper do not exist!";
                    break;
                }
                break;
            default:
                i = Integer.valueOf(LynxSubErrorCode.E_RESOURCE_MODULE_PARAMS_ERROR);
                str3 = "Parameters error! Unknown type :" + str2;
                break;
        }
        LLog.m2578i(NAME, "requestResourcePrefetch uri: " + str + " type: " + str2);
        return new Pair<>(i, str3);
    }

    private void onErrorOccurred(LynxError lynxError) {
        this.mLynxContext.handleLynxError(lynxError);
    }
}
