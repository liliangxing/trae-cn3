package com.bytedance.ttnet;

import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.SsHttpCall;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.ttnet.http.RequestContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class TNCRequestFlagHandler implements SsHttpCall.IRequestFlagHandler {
    private static final String TAG = "TNCRequestFlagHandler";
    private static volatile TNCRequestFlagHandler sInstance;
    private final List<SingleRequestFlagConfig> mRequestFlagConfigs = new CopyOnWriteArrayList();
    private final AtomicBoolean mRequestFlagCtlEnabled = new AtomicBoolean(false);

    public static TNCRequestFlagHandler getInstance() {
        if (sInstance == null) {
            synchronized (TNCRequestFlagHandler.class) {
                if (sInstance == null) {
                    sInstance = new TNCRequestFlagHandler();
                    SsHttpCall.setRequestFlagHandler(sInstance);
                }
            }
        }
        return sInstance;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class SingleRequestFlagConfig {
        final List<String> mMatchHosts;
        final List<String> mMatchPaths;
        int mTncRequestCronetFlags;
        int mTncRequestTTNetFlags;

        SingleRequestFlagConfig(int i, int i2, List<String> list, List<String> list2) {
            ArrayList arrayList = new ArrayList();
            this.mMatchHosts = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.mMatchPaths = arrayList2;
            this.mTncRequestCronetFlags = i;
            this.mTncRequestTTNetFlags = i2;
            arrayList.addAll(list);
            arrayList2.addAll(list2);
        }
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IRequestFlagHandler
    public Request handleFlag(Request request) {
        boolean z;
        boolean z2;
        List<String> list;
        if (request == null) {
            return request;
        }
        if (request.getExtraInfo() instanceof BaseRequestContext) {
            int i = ((BaseRequestContext) request.getExtraInfo()).commonParamLevel;
            if (Logger.debug()) {
                Logger.d(TAG, "handleFlag commonParamLevelInCtx: " + i);
            }
            if (i > 0) {
                request.setCommonParamLevel(Math.max(request.getCommonParamLevel(), i));
            }
        }
        if (!this.mRequestFlagCtlEnabled.get()) {
            return request;
        }
        Iterator<SingleRequestFlagConfig> it = this.mRequestFlagConfigs.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SingleRequestFlagConfig next = it.next();
            Iterator<String> it2 = next.mMatchHosts.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z2 = false;
                    break;
                }
                if (UrlUtils.matchPattern(request.getHost(), it2.next())) {
                    z2 = true;
                    break;
                }
            }
            if (z2 && (list = next.mMatchPaths) != null) {
                Iterator<String> it3 = list.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        z = false;
                        break;
                    }
                    String next2 = it3.next();
                    if (request.getPath() != null && request.getPath().startsWith(next2)) {
                        break;
                    }
                }
                if (z) {
                    if (request.getExtraInfo() == null) {
                        Request.Builder newBuilder = request.newBuilder();
                        newBuilder.setExtraInfo(new RequestContext());
                        request = newBuilder.build();
                    }
                    if (request.getExtraInfo() instanceof BaseRequestContext) {
                        BaseRequestContext baseRequestContext = (BaseRequestContext) request.getExtraInfo();
                        baseRequestContext.request_flag |= next.mTncRequestCronetFlags;
                        baseRequestContext.request_type_flags = next.mTncRequestTTNetFlags | baseRequestContext.request_type_flags;
                        Request.Builder newBuilder2 = request.newBuilder();
                        newBuilder2.setExtraInfo(baseRequestContext);
                        request = newBuilder2.build();
                    }
                }
            }
        }
        if (!(request.getExtraInfo() instanceof BaseRequestContext)) {
            return request;
        }
        BaseRequestContext baseRequestContext2 = (BaseRequestContext) request.getExtraInfo();
        boolean z3 = (baseRequestContext2.request_type_flags & 2048) > 0;
        z = (baseRequestContext2.request_type_flags & 4096) > 0;
        if (!z3 && !z) {
            return request;
        }
        Request.Builder newBuilder3 = request.newBuilder();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(request.getHeaders());
        if (z3) {
            arrayList.add(new Header(Request.KEY_BYPASS_TTNET_FEATURES, "1"));
        }
        if (z) {
            arrayList.add(new Header(Request.KEY_BYPASS_DISPATCH, "1"));
        }
        newBuilder3.headers(arrayList);
        return newBuilder3.build();
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IRequestFlagHandler
    public boolean shouldBypassInterceptor(Request request) {
        if (!(request.getExtraInfo() instanceof BaseRequestContext)) {
            return false;
        }
        BaseRequestContext baseRequestContext = (BaseRequestContext) request.getExtraInfo();
        return (baseRequestContext.request_type_flags & 1024) > 0 || (baseRequestContext.request_type_flags & 2048) > 0;
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IRequestFlagHandler
    public int getPriorityInContext(Request request) {
        if (request.getExtraInfo() instanceof BaseRequestContext) {
            return ((BaseRequestContext) request.getExtraInfo()).priorityLevel;
        }
        return -999;
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IRequestFlagHandler
    public boolean shouldUseCustomInterceptor(Request request) {
        return (request.getExtraInfo() instanceof BaseRequestContext) && (((BaseRequestContext) request.getExtraInfo()).request_type_flags & 8192) > 0;
    }

    public void parseJson2Config(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("request_flag_control");
        if (optJSONArray == null) {
            return;
        }
        this.mRequestFlagCtlEnabled.set(false);
        this.mRequestFlagConfigs.clear();
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                int optInt = jSONObject2.optInt("cronet_flags");
                int optInt2 = jSONObject2.optInt("ttnet_flags");
                JSONArray optJSONArray2 = jSONObject2.optJSONArray("prefix_group");
                JSONArray optJSONArray3 = jSONObject2.optJSONArray("host_group");
                ArrayList arrayList2 = new ArrayList();
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        arrayList2.add(optJSONArray2.optString(i2, ""));
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        arrayList3.add(optJSONArray3.optString(i3, ""));
                    }
                }
                if ((optInt > 0 || optInt2 > 0) && !arrayList2.isEmpty() && !arrayList3.isEmpty()) {
                    arrayList.add(new SingleRequestFlagConfig(optInt, optInt2, arrayList3, arrayList2));
                    if (Logger.debug()) {
                        Logger.d(TAG, "paths: " + arrayList2);
                        Logger.d(TAG, "hosts: " + arrayList3);
                        Logger.d(TAG, "flag: " + optInt);
                        Logger.d(TAG, "type flag: " + optInt2);
                    }
                }
            }
            if (jSONObject.optInt("req_flag_ctl_enabled") <= 0 || arrayList.size() <= 0) {
                return;
            }
            this.mRequestFlagConfigs.addAll(arrayList);
            this.mRequestFlagCtlEnabled.set(true);
        } catch (JSONException unused) {
        }
    }
}
