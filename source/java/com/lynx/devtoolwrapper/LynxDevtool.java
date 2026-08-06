package com.lynx.devtoolwrapper;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.InputEvent;
import com.lynx.jsbridge.LynxModule;
import com.lynx.jsbridge.LynxModuleFactory;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.ILynxViewStateListener;
import com.lynx.tasm.LynxDevToolDelegateImpl;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.PageReloadHelper;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.base.trace.TraceEventDef;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.provider.LynxResourceCallback;
import com.lynx.tasm.service.ILynxDevToolService;
import com.lynx.tasm.service.LynxServiceCenter;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxDevtool {
    private static final String TAG = "LynxDevtool";
    private static ILynxDevToolService sDevToolService;
    private ILynxViewStateListener mStateListener;
    private LynxBaseInspectorOwnerNG mOwner = null;
    private ILynxLogBox mLogBox = null;
    private PageReloadHelper mReloader = null;
    private WeakReference<LynxView> mView = null;
    private WeakReference<LynxTemplateRender> mRender = null;

    public LynxDevtool(LynxView lynxView, LynxTemplateRender lynxTemplateRender, boolean z) {
        init(lynxView, lynxTemplateRender, z, lynxTemplateRender.getLynxContext().getContext());
    }

    public LynxDevtool(Context context, boolean z) {
        init(null, null, z, context);
    }

    private void init(LynxView lynxView, LynxTemplateRender lynxTemplateRender, boolean z, Context context) {
        ILynxDevToolService iLynxDevToolService;
        ILynxDevToolService iLynxDevToolService2;
        TraceEvent.beginSection(TraceEventDef.DEVTOOL_INIT);
        try {
            LLog.m2578i(TAG, "Initialize LynxDevtool, lynxDebugEnabled:" + LynxEnv.inst().isLynxDebugEnabled());
            this.mView = new WeakReference<>(lynxView);
            this.mRender = new WeakReference<>(lynxTemplateRender);
            if (LynxEnv.inst().isLynxDebugEnabled()) {
                LLog.m2578i(TAG, "devtoolEnabled:" + LynxEnv.inst().isDevtoolEnabled() + ", logBoxEnabled:" + LynxEnv.inst().isLogBoxEnabled() + ", debuggable:" + z);
                sDevToolService = LynxServiceCenter.inst().getService(ILynxDevToolService.class);
                if ((LynxEnv.inst().isDevtoolEnabled() || z) && (iLynxDevToolService = sDevToolService) != null) {
                    LynxBaseInspectorOwnerNG createInspectorOwner = iLynxDevToolService.createInspectorOwner(lynxView, z);
                    this.mOwner = createInspectorOwner;
                    if (createInspectorOwner != null) {
                        LLog.m2578i(TAG, "owner init");
                    }
                }
                if (LynxEnv.inst().isLogBoxEnabled() && (iLynxDevToolService2 = sDevToolService) != null) {
                    this.mLogBox = iLynxDevToolService2.createLogBox(this);
                    LLog.m2578i(TAG, "LogBox init");
                }
                if (lynxTemplateRender != null) {
                    DisplayMetrics screenMetrics = lynxTemplateRender.getLynxContext().getScreenMetrics();
                    updateScreenMetrics(screenMetrics.widthPixels, screenMetrics.heightPixels, screenMetrics.density);
                }
            }
            if (this.mOwner != null || this.mLogBox != null) {
                this.mReloader = new PageReloadHelper(lynxView);
            }
            LynxBaseInspectorOwnerNG lynxBaseInspectorOwnerNG = this.mOwner;
            if (lynxBaseInspectorOwnerNG != null) {
                lynxBaseInspectorOwnerNG.setDevToolDelegate(new LynxDevToolDelegateImpl(lynxTemplateRender));
            }
        } catch (Exception e) {
            LLog.m2577e(TAG, "failed to init LynxDevtool: " + e.toString());
            this.mOwner = null;
            this.mLogBox = null;
            this.mReloader = null;
        }
        TraceEvent.endSection(TraceEventDef.DEVTOOL_INIT);
    }

    public void attachContext(Context context) {
        ILynxLogBox iLynxLogBox = this.mLogBox;
        if (iLynxLogBox != null) {
            iLynxLogBox.attachContext(context);
        }
    }

    public void destroy() {
        ILynxViewStateListener iLynxViewStateListener = this.mStateListener;
        if (iLynxViewStateListener != null) {
            iLynxViewStateListener.onDestroy();
            this.mStateListener = null;
        }
        LynxBaseInspectorOwnerNG lynxBaseInspectorOwnerNG = this.mOwner;
        if (lynxBaseInspectorOwnerNG != null) {
            lynxBaseInspectorOwnerNG.destroy();
            this.mOwner = null;
            LLog.m2578i(TAG, "mOwner = null");
        }
    }

    public void onLoadFromLocalFile(byte[] bArr, TemplateData templateData, String str) {
        PageReloadHelper pageReloadHelper = this.mReloader;
        if (pageReloadHelper != null) {
            pageReloadHelper.loadFromLocalFile(bArr, templateData, str);
        }
        ILynxLogBox iLynxLogBox = this.mLogBox;
        if (iLynxLogBox != null) {
            iLynxLogBox.onLoadTemplate();
        }
    }

    public void onGlobalPropsChanged(TemplateData templateData) {
        LynxBaseInspectorOwnerNG lynxBaseInspectorOwnerNG = this.mOwner;
        if (lynxBaseInspectorOwnerNG != null) {
            lynxBaseInspectorOwnerNG.onGlobalPropsUpdated(templateData);
        }
        PageReloadHelper pageReloadHelper = this.mReloader;
        if (pageReloadHelper != null) {
            pageReloadHelper.onGlobalPropsUpdated(templateData);
        }
    }

    public void onTemplateDataChanged(TemplateData templateData) {
        LynxBaseInspectorOwnerNG lynxBaseInspectorOwnerNG = this.mOwner;
        if (lynxBaseInspectorOwnerNG != null) {
            lynxBaseInspectorOwnerNG.onTemplateDataUpdated(templateData);
        }
        PageReloadHelper pageReloadHelper = this.mReloader;
        if (pageReloadHelper != null) {
            pageReloadHelper.onTemplateDataUpdated(templateData);
        }
    }

    public void onTemplateDataReset(TemplateData templateData) {
        LynxBaseInspectorOwnerNG lynxBaseInspectorOwnerNG = this.mOwner;
        if (lynxBaseInspectorOwnerNG != null) {
            lynxBaseInspectorOwnerNG.onTemplateDataReset(templateData);
        }
        PageReloadHelper pageReloadHelper = this.mReloader;
        if (pageReloadHelper != null) {
            pageReloadHelper.onTemplateDataReset(templateData);
        }
    }

    public void onLoadFromURL(String str, String str2, TemplateData templateData, Map<String, Object> map, String str3) {
        PageReloadHelper pageReloadHelper = this.mReloader;
        if (pageReloadHelper != null) {
            pageReloadHelper.saveURL(str, templateData, map, str3);
        }
        ILynxLogBox iLynxLogBox = this.mLogBox;
        if (iLynxLogBox != null) {
            iLynxLogBox.onLoadTemplate();
        }
    }

    public void onLoadFromBundle(TemplateBundle templateBundle, TemplateData templateData, String str) {
        PageReloadHelper pageReloadHelper = this.mReloader;
        if (pageReloadHelper != null) {
            pageReloadHelper.loadFromBundle(templateBundle, templateData, str);
        }
        ILynxLogBox iLynxLogBox = this.mLogBox;
        if (iLynxLogBox != null) {
            iLynxLogBox.onLoadTemplate();
        }
    }

    public void onRootViewInputEvent(InputEvent inputEvent) {
        LynxBaseInspectorOwnerNG lynxBaseInspectorOwnerNG = this.mOwner;
        if (lynxBaseInspectorOwnerNG != null) {
            lynxBaseInspectorOwnerNG.onRootViewInputEvent(inputEvent);
        }
    }

    public void onTemplateAssemblerCreated(long j) {
        LynxBaseInspectorOwnerNG lynxBaseInspectorOwnerNG = this.mOwner;
        if (lynxBaseInspectorOwnerNG != null) {
            lynxBaseInspectorOwnerNG.onTemplateAssemblerCreated(j);
        }
    }

    public long onBackgroundRuntimeCreated(String str) {
        LynxBaseInspectorOwnerNG lynxBaseInspectorOwnerNG = this.mOwner;
        if (lynxBaseInspectorOwnerNG != null) {
            return lynxBaseInspectorOwnerNG.onBackgroundRuntimeCreated(str);
        }
        return 0L;
    }

    public void onEnterForeground() {
        LynxBaseInspectorOwnerNG lynxBaseInspectorOwnerNG = this.mOwner;
        if (lynxBaseInspectorOwnerNG != null) {
            lynxBaseInspectorOwnerNG.continueCasting();
        }
        ILynxViewStateListener iLynxViewStateListener = this.mStateListener;
        if (iLynxViewStateListener != null) {
            iLynxViewStateListener.onEnterForeground();
        }
    }

    public void onEnterBackground() {
        LynxBaseInspectorOwnerNG lynxBaseInspectorOwnerNG = this.mOwner;
        if (lynxBaseInspectorOwnerNG != null) {
            lynxBaseInspectorOwnerNG.pauseCasting();
        }
        ILynxViewStateListener iLynxViewStateListener = this.mStateListener;
        if (iLynxViewStateListener != null) {
            iLynxViewStateListener.onEnterBackground();
        }
    }

    public void showErrorMessage(LynxError lynxError) {
        ILynxLogBox iLynxLogBox = this.mLogBox;
        if (iLynxLogBox != null) {
            iLynxLogBox.showLogMessage(lynxError);
        }
        LynxBaseInspectorOwnerNG lynxBaseInspectorOwnerNG = this.mOwner;
        if (lynxBaseInspectorOwnerNG != null) {
            lynxBaseInspectorOwnerNG.showErrorMessageOnConsole(lynxError);
        }
    }

    public void onLoadFinished() {
        ILynxViewStateListener iLynxViewStateListener = this.mStateListener;
        if (iLynxViewStateListener != null) {
            iLynxViewStateListener.onLoadFinished();
        }
    }

    public void onRegisterModule(LynxModuleFactory lynxModuleFactory) {
        if (LynxEnv.inst().isLynxDebugEnabled()) {
            ILynxDevToolService iLynxDevToolService = sDevToolService;
            if (iLynxDevToolService == null) {
                LLog.m2577e(TAG, "sDevToolService is null");
                return;
            }
            Class<? extends LynxModule> devToolSetModuleClass = iLynxDevToolService.getDevToolSetModuleClass();
            if (devToolSetModuleClass != null) {
                lynxModuleFactory.registerModule(devToolSetModuleClass.getSimpleName(), devToolSetModuleClass, null);
                LLog.m2578i(TAG, "register LynxDevToolSetModule!");
            }
            Class<? extends LynxModule> devToolWebSocketModuleClass = sDevToolService.getDevToolWebSocketModuleClass();
            if (devToolWebSocketModuleClass != null) {
                lynxModuleFactory.registerModule(devToolWebSocketModuleClass.getSimpleName(), devToolWebSocketModuleClass, null);
                LLog.m2578i(TAG, "register LynxWebSocketModule!");
            }
            Class<? extends LynxModule> lynxTrailModule = sDevToolService.getLynxTrailModule();
            if (lynxTrailModule != null) {
                lynxModuleFactory.registerModule(lynxTrailModule.getSimpleName(), lynxTrailModule, null);
                LLog.m2578i(TAG, "register LynxTrailModule!");
            }
            if (this.mOwner != null) {
                LLog.m2578i(TAG, "owner onRegisterModule");
                this.mOwner.onRegisterModule(lynxModuleFactory);
            }
        }
    }

    public void attach(LynxView lynxView) {
        this.mView = new WeakReference<>(lynxView);
        LynxBaseInspectorOwnerNG lynxBaseInspectorOwnerNG = this.mOwner;
        if (lynxBaseInspectorOwnerNG != null) {
            lynxBaseInspectorOwnerNG.attach(lynxView);
        }
    }

    public void attach(LynxView lynxView, LynxTemplateRender lynxTemplateRender) {
        this.mView = new WeakReference<>(lynxView);
        this.mRender = new WeakReference<>(lynxTemplateRender);
        LynxBaseInspectorOwnerNG lynxBaseInspectorOwnerNG = this.mOwner;
        if (lynxBaseInspectorOwnerNG != null) {
            lynxBaseInspectorOwnerNG.attach(lynxView);
        }
        PageReloadHelper pageReloadHelper = this.mReloader;
        if (pageReloadHelper != null) {
            pageReloadHelper.attach(lynxView);
        }
        LynxBaseInspectorOwnerNG lynxBaseInspectorOwnerNG2 = this.mOwner;
        if (lynxBaseInspectorOwnerNG2 != null) {
            lynxBaseInspectorOwnerNG2.setDevToolDelegate(new LynxDevToolDelegateImpl(lynxTemplateRender));
        }
        DisplayMetrics screenMetrics = lynxTemplateRender.getLynxContext().getScreenMetrics();
        updateScreenMetrics(screenMetrics.widthPixels, screenMetrics.heightPixels, screenMetrics.density);
    }

    public LynxBaseInspectorOwner getBaseInspectorOwner() {
        return this.mOwner;
    }

    public void updateScreenMetrics(int i, int i2, float f) {
        LynxBaseInspectorOwnerNG lynxBaseInspectorOwnerNG = this.mOwner;
        if (lynxBaseInspectorOwnerNG != null) {
            lynxBaseInspectorOwnerNG.updateScreenMetrics(i, i2, f);
        }
    }

    public void attachToDebugBridge(String str) {
        LynxBaseInspectorOwnerNG lynxBaseInspectorOwnerNG = this.mOwner;
        if (lynxBaseInspectorOwnerNG != null) {
            lynxBaseInspectorOwnerNG.attachToDebugBridge(str);
        }
    }

    public void onPageUpdate() {
        LynxBaseInspectorOwnerNG lynxBaseInspectorOwnerNG = this.mOwner;
        if (lynxBaseInspectorOwnerNG != null) {
            lynxBaseInspectorOwnerNG.onPageUpdate();
        }
    }

    public void downloadResource(String str, LynxResourceCallback lynxResourceCallback) {
        LynxBaseInspectorOwnerNG lynxBaseInspectorOwnerNG = this.mOwner;
        if (lynxBaseInspectorOwnerNG != null) {
            lynxBaseInspectorOwnerNG.downloadResource(str, lynxResourceCallback);
        }
    }

    public String getTemplateUrl() {
        LynxTemplateRender lynxTemplateRender = this.mRender.get();
        return lynxTemplateRender == null ? "" : lynxTemplateRender.getTemplateUrl();
    }

    public Map<String, Object> getAllJsSource() {
        LynxTemplateRender lynxTemplateRender = this.mRender.get();
        if (lynxTemplateRender == null) {
            return null;
        }
        return lynxTemplateRender.getAllJsSource();
    }

    public LynxContext getLynxContext() {
        LynxTemplateRender lynxTemplateRender = this.mRender.get();
        if (lynxTemplateRender == null) {
            return null;
        }
        return lynxTemplateRender.getLynxContext();
    }

    public void attachLynxUIOwner(LynxUIOwner lynxUIOwner) {
        LynxBaseInspectorOwnerNG lynxBaseInspectorOwnerNG = this.mOwner;
        if (lynxBaseInspectorOwnerNG != null) {
            lynxBaseInspectorOwnerNG.attachLynxUIOwnerToAgent(lynxUIOwner);
            this.mOwner.setReloadHelper(this.mReloader);
        }
    }

    public void onTemplateLoadSuccess(byte[] bArr) {
        PageReloadHelper pageReloadHelper = this.mReloader;
        if (pageReloadHelper != null) {
            pageReloadHelper.onTemplateLoadSuccess(bArr);
        }
    }

    public void onPerfMetricsEvent(String str, JSONObject jSONObject) {
        LynxBaseInspectorOwnerNG lynxBaseInspectorOwnerNG = this.mOwner;
        if (lynxBaseInspectorOwnerNG != null) {
            lynxBaseInspectorOwnerNG.onPerfMetricsEvent(str, jSONObject);
        }
    }

    public String getDebugInfoUrl(String str) {
        LynxBaseInspectorOwnerNG lynxBaseInspectorOwnerNG = this.mOwner;
        return lynxBaseInspectorOwnerNG != null ? lynxBaseInspectorOwnerNG.getDebugInfoUrl(str) : "";
    }

    public Boolean enableAirStrictMode() {
        LynxTemplateRender lynxTemplateRender = this.mRender.get();
        if (lynxTemplateRender != null) {
            return Boolean.valueOf(lynxTemplateRender.enableAirStrictMode());
        }
        return false;
    }

    public void onReceiveMessageEvent(ReadableMap readableMap) {
        LynxBaseInspectorOwnerNG lynxBaseInspectorOwnerNG = this.mOwner;
        if (lynxBaseInspectorOwnerNG != null) {
            lynxBaseInspectorOwnerNG.onReceiveMessageEvent(readableMap);
        }
    }
}
