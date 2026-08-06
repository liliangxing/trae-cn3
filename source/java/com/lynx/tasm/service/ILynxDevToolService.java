package com.lynx.tasm.service;

import android.content.Context;
import com.lynx.devtoolwrapper.ILynxLogBox;
import com.lynx.devtoolwrapper.LynxBaseInspectorOwnerNG;
import com.lynx.devtoolwrapper.LynxDevtool;
import com.lynx.devtoolwrapper.LynxDevtoolCardListener;
import com.lynx.jsbridge.LynxModule;
import com.lynx.tasm.INativeLibraryLoader;
import com.lynx.tasm.LynxView;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface ILynxDevToolService extends IServiceProvider {
    LynxBaseInspectorOwnerNG createInspectorOwner(LynxView lynxView, boolean z);

    ILynxLogBox createLogBox(LynxDevtool lynxDevtool);

    void devtoolEnvInit(Context context);

    void devtoolEnvSetDevToolLibraryLoader(INativeLibraryLoader iNativeLibraryLoader);

    Class<? extends LynxModule> getDevToolSetModuleClass();

    Class<? extends LynxModule> getDevToolWebSocketModuleClass();

    boolean getDevtoolBooleanEnv(String str, Boolean bool);

    Set<String> getDevtoolGroupEnv(String str);

    Integer getDevtoolIntEnv(String str, Integer num);

    boolean getLoadJsBridge();

    boolean getLogBoxPresetValue();

    boolean getLynxDebugPresetValue();

    Class<? extends LynxModule> getLynxTrailModule();

    void globalDebugBridgeOnPerfMetricsEvent(String str, JSONObject jSONObject, int i);

    Boolean globalDebugBridgePrepareRemoteDebug(String str);

    void globalDebugBridgeRegisterCardListener(LynxDevtoolCardListener lynxDevtoolCardListener);

    void globalDebugBridgeSetAppInfo(Context context, Map<String, String> map);

    void globalDebugBridgeSetContext(Context context);

    Boolean globalDebugBridgeShouldPrepareRemoteDebug(String str);

    void globalDebugBridgeStartRecord();

    boolean isDevtoolAttached();

    void setDevtoolEnv(String str, Object obj);

    void setDevtoolGroupEnv(String str, Set<String> set);

    void setLoadJsBridge(boolean z);

    void setLogBoxPresetValue(boolean z);

    void setLynxDebugPresetValue(boolean z);

    @Override // com.lynx.tasm.service.IServiceProvider
    default Class<? extends IServiceProvider> getServiceClass() {
        return ILynxDevToolService.class;
    }
}
