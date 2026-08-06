package com.lynx.devtoolwrapper;

import android.view.InputEvent;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.recorder.LynxDebugInfoRecorder;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.PageReloadHelper;
import com.lynx.tasm.behavior.LynxUIOwner;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface LynxBaseInspectorOwner {
    void addCDPEventListener(String str, CDPEventListener cDPEventListener);

    void attach(LynxView lynxView);

    void attachLynxUIOwnerToAgent(LynxUIOwner lynxUIOwner);

    void attachToDebugBridge(String str);

    void continueCasting();

    void destroy();

    void endTestbench(String str);

    void getConsoleObject(String str, boolean z, Callback callback);

    String getDebugInfoUrl(String str);

    @Deprecated
    String getGroupID();

    void invokeCDPFromSDK(String str, CDPResultCallback cDPResultCallback);

    void navigate(String str);

    long onBackgroundRuntimeCreated(String str);

    void onGlobalPropsUpdated(TemplateData templateData);

    void onPageUpdate();

    void onPerfMetricsEvent(String str, JSONObject jSONObject);

    void onReceiveMessageEvent(ReadableMap readableMap);

    void onRootViewInputEvent(InputEvent inputEvent);

    void onTemplateAssemblerCreated(long j);

    void onTemplateDataReset(TemplateData templateData);

    void onTemplateDataUpdated(TemplateData templateData);

    void pauseCasting();

    void reload(boolean z);

    void reload(boolean z, String str, boolean z2, int i);

    void reload(boolean z, String str, boolean z2, int i, String str2);

    void removeCDPEventListener(String str);

    void savePostURL(String str);

    void sendConsoleMessage(String str, int i, long j);

    void sendFileByAgent(String str, String str2);

    void sendResponse(String str);

    void setDebugInfoInterceptor(LynxDebugInfoRecorder lynxDebugInfoRecorder);

    void setDebugTag(String str);

    void setDevToolDelegate(IDevToolDelegate iDevToolDelegate);

    void setLynxInspectorConsoleDelegate(Object obj);

    void setReloadHelper(PageReloadHelper pageReloadHelper);

    void showErrorMessageOnConsole(LynxError lynxError);

    void showMessageOnConsole(String str, int i);

    void stopCasting();

    void updateScreenMetrics(int i, int i2, float f);
}
