package com.lynx.tasm;

import com.lynx.jsbridge.LynxModule;
import com.lynx.jsbridge.ParamWrapper;
import com.lynx.tasm.provider.LynxResourceProvider;
import com.lynx.tasm.resourceprovider.generic.LynxGenericResourceFetcher;
import com.lynx.tasm.resourceprovider.media.LynxMediaResourceFetcher;
import com.lynx.tasm.resourceprovider.template.LynxTemplateResourceFetcher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxBackgroundRuntimeOptions {
    private static int RUNTIME_FLAG_ENABLE_JS_GROUP_THREAD = 2;
    private static int RUNTIME_FLAG_ENABLE_USER_BYTECODE = 1;
    private static int RUNTIME_FLAG_FORCE_RELOAD_CORE_JS = 4;
    private static int RUNTIME_FLAG_FORCE_USE_LIGHT_WEIGHT_JS_ENGINE = 8;
    private static int RUNTIME_FLAG_INIT = 0;
    private static int RUNTIME_FLAG_PENDING_CORE_JS_LOAD = 16;
    private static int RUNTIME_FLAG_PENDING_JS_TASK = 32;
    LynxGenericResourceFetcher genericResourceFetcher;
    private LynxModule.AuthValidator mAuthValidator;
    private String mBytecodeSourceUrl;
    private boolean mEnableUserBytecode;
    private TemplateData mGlobalProps;
    private LynxGroup mLynxGroup;
    private boolean mPendingCoreJsLoad;
    private TemplateData mPresetData;
    LynxMediaResourceFetcher mediaResourceFetcher;
    LynxTemplateResourceFetcher templateResourceFetcher;
    LynxBooleanOption enableGenericResourceFetcher = LynxBooleanOption.UNSET;
    private final Map<String, LynxResourceProvider> mResourceProviders = new HashMap();
    private final List<ParamWrapper> mWrappers = new ArrayList();

    private static int setRuntimeFlag(int i, boolean z, int i2) {
        return z ? i | i2 : i & (~i2);
    }

    public void registerModule(String str, Class<? extends LynxModule> cls, Object obj) {
        ParamWrapper paramWrapper = new ParamWrapper();
        paramWrapper.setModuleClass(cls);
        paramWrapper.setParam(obj);
        paramWrapper.setName(str);
        this.mWrappers.add(paramWrapper);
    }

    public void registerModuleAuthValidator(LynxModule.AuthValidator authValidator) {
        this.mAuthValidator = authValidator;
    }

    public LynxModule.AuthValidator getModuleAuthValidator() {
        return this.mAuthValidator;
    }

    public boolean useQuickJSEngine() {
        LynxGroup lynxGroup = this.mLynxGroup;
        return lynxGroup == null || !lynxGroup.enableV8();
    }

    public boolean isEnableUserBytecode() {
        return this.mEnableUserBytecode;
    }

    public void setEnableUserBytecode(boolean z) {
        this.mEnableUserBytecode = z;
    }

    public String getBytecodeSourceUrl() {
        return this.mBytecodeSourceUrl;
    }

    public void setBytecodeSourceUrl(String str) {
        this.mBytecodeSourceUrl = str;
    }

    public void setPendingCoreJsLoad(boolean z) {
        this.mPendingCoreJsLoad = z;
    }

    public boolean isPendingCoreJsLoad() {
        return this.mPendingCoreJsLoad;
    }

    public LynxGroup getLynxGroup() {
        return this.mLynxGroup;
    }

    public void setLynxGroup(LynxGroup lynxGroup) {
        this.mLynxGroup = lynxGroup;
    }

    public List<ParamWrapper> getWrappers() {
        return this.mWrappers;
    }

    public void setResourceProviders(String str, LynxResourceProvider lynxResourceProvider) {
        this.mResourceProviders.put(str, lynxResourceProvider);
    }

    public LynxResourceProvider getResourceProvidersByKey(String str) {
        return this.mResourceProviders.get(str);
    }

    public Set<Map.Entry<String, LynxResourceProvider>> getAllResourceProviders() {
        return this.mResourceProviders.entrySet();
    }

    public void setPresetData(TemplateData templateData) {
        this.mPresetData = templateData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TemplateData getPresetData() {
        return this.mPresetData;
    }

    public void setGlobalProps(TemplateData templateData) {
        this.mGlobalProps = templateData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TemplateData getGlobalProps() {
        return this.mGlobalProps;
    }

    public void setGenericResourceFetcher(LynxGenericResourceFetcher lynxGenericResourceFetcher) {
        this.genericResourceFetcher = lynxGenericResourceFetcher;
    }

    public LynxGenericResourceFetcher getGenericResourceFetcher() {
        return this.genericResourceFetcher;
    }

    public void setMediaResourceFetcher(LynxMediaResourceFetcher lynxMediaResourceFetcher) {
        this.mediaResourceFetcher = lynxMediaResourceFetcher;
    }

    public LynxMediaResourceFetcher getMediaResourceFetcher() {
        return this.mediaResourceFetcher;
    }

    public void setTemplateResourceFetcher(LynxTemplateResourceFetcher lynxTemplateResourceFetcher) {
        this.templateResourceFetcher = lynxTemplateResourceFetcher;
    }

    public LynxTemplateResourceFetcher getTemplateResourceFetcher() {
        return this.templateResourceFetcher;
    }

    public void setEnableGenericResourceFetcher(LynxBooleanOption lynxBooleanOption) {
        this.enableGenericResourceFetcher = lynxBooleanOption;
    }

    public LynxBooleanOption isEnableGenericResourceFetcher() {
        return this.enableGenericResourceFetcher;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void merge(LynxBackgroundRuntimeOptions lynxBackgroundRuntimeOptions) {
        this.mLynxGroup = lynxBackgroundRuntimeOptions.mLynxGroup;
        this.mEnableUserBytecode = lynxBackgroundRuntimeOptions.mEnableUserBytecode;
        this.mBytecodeSourceUrl = lynxBackgroundRuntimeOptions.mBytecodeSourceUrl;
        this.mPendingCoreJsLoad = false;
        if (this.enableGenericResourceFetcher == LynxBooleanOption.UNSET) {
            this.enableGenericResourceFetcher = lynxBackgroundRuntimeOptions.enableGenericResourceFetcher;
        }
        LynxGenericResourceFetcher lynxGenericResourceFetcher = this.genericResourceFetcher;
        if (lynxGenericResourceFetcher == null) {
            lynxGenericResourceFetcher = lynxBackgroundRuntimeOptions.genericResourceFetcher;
        }
        this.genericResourceFetcher = lynxGenericResourceFetcher;
        LynxMediaResourceFetcher lynxMediaResourceFetcher = this.mediaResourceFetcher;
        if (lynxMediaResourceFetcher == null) {
            lynxMediaResourceFetcher = lynxBackgroundRuntimeOptions.mediaResourceFetcher;
        }
        this.mediaResourceFetcher = lynxMediaResourceFetcher;
        LynxTemplateResourceFetcher lynxTemplateResourceFetcher = this.templateResourceFetcher;
        if (lynxTemplateResourceFetcher == null) {
            lynxTemplateResourceFetcher = lynxBackgroundRuntimeOptions.templateResourceFetcher;
        }
        this.templateResourceFetcher = lynxTemplateResourceFetcher;
        for (Map.Entry<String, LynxResourceProvider> entry : lynxBackgroundRuntimeOptions.mResourceProviders.entrySet()) {
            if (!this.mResourceProviders.containsKey(entry.getKey())) {
                this.mResourceProviders.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public static int calcRuntimeFlags(boolean z, boolean z2, boolean z3, boolean z4, Boolean bool, Boolean bool2) {
        int runtimeFlag = setRuntimeFlag(setRuntimeFlag(setRuntimeFlag(setRuntimeFlag(RUNTIME_FLAG_INIT, z, RUNTIME_FLAG_FORCE_RELOAD_CORE_JS), z2, RUNTIME_FLAG_FORCE_USE_LIGHT_WEIGHT_JS_ENGINE), z3, RUNTIME_FLAG_PENDING_JS_TASK), z4, RUNTIME_FLAG_ENABLE_USER_BYTECODE);
        if (bool != null) {
            runtimeFlag = setRuntimeFlag(runtimeFlag, bool.booleanValue(), RUNTIME_FLAG_ENABLE_JS_GROUP_THREAD);
        }
        return bool2 != null ? setRuntimeFlag(runtimeFlag, bool2.booleanValue(), RUNTIME_FLAG_PENDING_CORE_JS_LOAD) : runtimeFlag;
    }
}
