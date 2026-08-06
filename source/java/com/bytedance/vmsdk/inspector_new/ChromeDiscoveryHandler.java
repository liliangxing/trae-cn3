package com.bytedance.vmsdk.inspector_new;

import com.bytedance.vmsdk.inspector_new.server.SocketLike;
import com.bytedance.vmsdk.inspector_new.server.http.ExactPathMatcher;
import com.bytedance.vmsdk.inspector_new.server.http.HandlerRegistry;
import com.bytedance.vmsdk.inspector_new.server.http.HttpHandler;
import com.bytedance.vmsdk.inspector_new.server.http.LightHttpBody;
import com.bytedance.vmsdk.inspector_new.server.http.LightHttpRequest;
import com.bytedance.vmsdk.inspector_new.server.http.LightHttpResponse;
import com.bytedance.vmsdk.utils.ThreadUtils;
import com.heytap.mcssdk.constant.C0879b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ChromeDiscoveryHandler implements HttpHandler {
    private static final String PATH_PAGE_JSON_LIST = "/json/list";
    private static final String PATH_PAGE_LIST = "/json";
    private static final String PATH_VERSION = "/json/version";
    private static final String TAG = "ChromeDiscoveryHandler";
    private final List<InspectorClientNew> mInspectorClients = new ArrayList();
    private LightHttpBody mVersionResponse;

    public void register(HandlerRegistry handlerRegistry) {
        handlerRegistry.register(new ExactPathMatcher(PATH_PAGE_LIST), this);
        handlerRegistry.register(new ExactPathMatcher(PATH_VERSION), this);
        handlerRegistry.register(new ExactPathMatcher(PATH_PAGE_JSON_LIST), this);
    }

    public void addInspectorClient(InspectorClientNew inspectorClientNew) {
        synchronized (this.mInspectorClients) {
            if (!this.mInspectorClients.contains(inspectorClientNew)) {
                this.mInspectorClients.add(inspectorClientNew);
            }
        }
    }

    public void removeInspectorClient(InspectorClientNew inspectorClientNew) {
        synchronized (this.mInspectorClients) {
            this.mInspectorClients.remove(inspectorClientNew);
        }
    }

    @Override // com.bytedance.vmsdk.inspector_new.server.http.HttpHandler
    public boolean handleRequest(SocketLike socketLike, LightHttpRequest lightHttpRequest, LightHttpResponse lightHttpResponse) throws IOException {
        String path = lightHttpRequest.uri.getPath();
        try {
            if (PATH_VERSION.equals(path)) {
                handleVersion(lightHttpResponse);
            } else if (PATH_PAGE_LIST.equals(path)) {
                handlePageList(lightHttpResponse);
            } else if (PATH_PAGE_JSON_LIST.equals(path)) {
                handlePageList(lightHttpResponse);
            } else {
                lightHttpResponse.code = 501;
                lightHttpResponse.reasonPhrase = "Not implemented";
                lightHttpResponse.body = LightHttpBody.create("No support for " + path + "\n", "text/plain");
            }
            return true;
        } catch (JSONException e) {
            lightHttpResponse.code = 500;
            lightHttpResponse.reasonPhrase = "Internal server error";
            lightHttpResponse.body = LightHttpBody.create(e.toString() + "\n", "text/plain");
            return true;
        }
    }

    private void handleVersion(LightHttpResponse lightHttpResponse) throws JSONException {
        if (this.mVersionResponse == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Browser", "VMSDK-Debugger");
            jSONObject.put("Protocol-Version", "1.3");
            jSONObject.put("Android-Package", ThreadUtils.getProcessName());
            jSONObject.put("V8-Version", "7.2.1");
            this.mVersionResponse = LightHttpBody.create(jSONObject.toString(), "application/json");
        }
        setSuccessfulResponse(lightHttpResponse, this.mVersionResponse);
    }

    private void handlePageList(LightHttpResponse lightHttpResponse) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.mInspectorClients) {
            for (int i = 0; i < this.mInspectorClients.size(); i++) {
                InspectorClientNew inspectorClientNew = this.mInspectorClients.get(i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "page");
                jSONObject.put("title", inspectorClientNew.getDisplayName());
                jSONObject.put("id", "" + i);
                jSONObject.put(C0879b.f565i, "");
                jSONObject.put("webSocketDebuggerUrl", "ws://" + inspectorClientNew.getInspectorPath());
                jSONObject.put("devtoolsFrontendUrl", "/devtools/inspector.html?ws=" + inspectorClientNew.getInspectorPath());
                jSONArray.put(jSONObject);
            }
        }
        setSuccessfulResponse(lightHttpResponse, LightHttpBody.create(jSONArray.toString(), "application/json"));
    }

    private static void setSuccessfulResponse(LightHttpResponse lightHttpResponse, LightHttpBody lightHttpBody) {
        lightHttpResponse.code = 200;
        lightHttpResponse.reasonPhrase = "OK";
        lightHttpResponse.body = lightHttpBody;
    }
}
