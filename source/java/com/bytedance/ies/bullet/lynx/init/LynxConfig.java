package com.bytedance.ies.bullet.lynx.init;

import android.app.Application;
import com.bytedance.ies.bullet.lynx.model.LynxModuleWrapper;
import com.bytedance.ies.bullet.service.base.lynx.ILynxConfig;
import com.bytedance.memory.api.MemoryApi;
import com.lynx.tasm.INativeLibraryLoader;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.behavior.Behavior;
import com.lynx.tasm.provider.AbsTemplateProvider;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001DB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\f\u001a\u00020\rJ$\u0010\u0011\u001a\u00020\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\b\b\u0002\u0010\f\u001a\u00020\rJ\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\b0\u0017¢\u0006\u0002\b\u0019J\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u001dJ\r\u0010\u001e\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u001fJ\r\u0010 \u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u001fJ\r\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\u0002\u0010#J\r\u0010$\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u001fJ\r\u0010%\u001a\u0004\u0018\u00010\"¢\u0006\u0002\u0010#J\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001dJ\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013J\b\u0010(\u001a\u0004\u0018\u00010)J\u0006\u0010*\u001a\u00020\rJ\b\u0010+\u001a\u0004\u0018\u00010,J\u001f\u0010-\u001a\u00020\b2\u0017\u0010.\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\b0\u0017¢\u0006\u0002\b\u0019J\u000e\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\u001bJ\u000e\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020)J\b\u00103\u001a\u0004\u0018\u000104J\u000e\u00103\u001a\u00020\b2\u0006\u00103\u001a\u000204J\u000e\u00105\u001a\u00020\b2\u0006\u0010*\u001a\u00020\rJ\u000e\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\rJ\u0015\u00108\u001a\u00020\b2\b\u00109\u001a\u0004\u0018\u00010\"¢\u0006\u0002\u0010:J\u000e\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\rJ\u000e\u0010=\u001a\u00020\b2\u0006\u0010+\u001a\u00020,J\u000e\u0010>\u001a\u00020\b2\u0006\u00107\u001a\u00020\rJ\u000e\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020AJ\u0015\u0010B\u001a\u00020\b2\b\u0010C\u001a\u0004\u0018\u00010\"¢\u0006\u0002\u0010:J\b\u0010@\u001a\u0004\u0018\u00010AR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/init/LynxConfig;", "Lcom/bytedance/ies/bullet/service/base/lynx/ILynxConfig;", "context", "Landroid/app/Application;", "builder", "Lcom/bytedance/ies/bullet/lynx/init/LynxConfig$Builder;", "(Landroid/app/Application;Lcom/bytedance/ies/bullet/lynx/init/LynxConfig$Builder;)V", "addBehaviors", "", "behaviors", "", "Lcom/lynx/tasm/behavior/Behavior;", "isAdd", "", "addLynxDevtoolProcessor", "lynxDevtoolProcessor", "Lcom/bytedance/ies/bullet/lynx/init/LynxDevtoolProcessor;", "addLynxModules", "modules", "", "", "Lcom/bytedance/ies/bullet/lynx/model/LynxModuleWrapper;", "additionLynxInit", "Lkotlin/Function1;", "Lcom/lynx/tasm/LynxEnv;", "Lkotlin/ExtensionFunctionType;", "canvasInitConfig", "Lcom/bytedance/ies/bullet/lynx/init/ILynxCanvasConfig;", "devtoolProcessors", "", "getDebug", "()Ljava/lang/Boolean;", "getDevtoolOuterControl", "getFontScale", "", "()Ljava/lang/Float;", "getForceInit", "getViewZoom", "globalBehaviors", "globalModules", "imageInitConfig", "Lcom/bytedance/ies/bullet/lynx/init/ILynxImageConfig;", "isCheckPropsSetter", "libraryLoader", "Lcom/lynx/tasm/INativeLibraryLoader;", "lynxAdditionInit", "addition", "lynxCanvasConfig", "initCanvasConfig", "lynxImageConfig", "initImageConfig", "lynxSdkMonitorConfig", "Lcom/bytedance/ies/bullet/lynx/init/LynxSdkMonitorConfig;", "setCheckPropsSetter", "setDebug", MemoryApi.DEBUG, "setFontScale", "fontScale", "(Ljava/lang/Float;)V", "setForceInit", "forceInit", "setLynxLibraryLoader", "setOuterDevtoolControl", "setTemplateProvider", "templateProvider", "Lcom/lynx/tasm/provider/AbsTemplateProvider;", "setViewZoom", "viewZoom", "Builder", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LynxConfig implements ILynxConfig {
    private final Builder builder;

    public /* synthetic */ LynxConfig(Application application, Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, builder);
    }

    private LynxConfig(Application application, Builder builder) {
        this.builder = builder;
        LynxKitBase.INSTANCE.setContext(application);
    }

    /* compiled from: LynxConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010^\u001a\u00020\u00002\f\u0010_\u001a\b\u0012\u0004\u0012\u00020-0`J\u000e\u0010a\u001a\u00020\u00002\u0006\u0010b\u001a\u00020\u001dJ\u001a\u0010c\u001a\u00020\u00002\u0012\u0010d\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020301J\u0006\u0010e\u001a\u00020fJ\u001f\u0010g\u001a\u00020\u00002\u0017\u0010h\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tJ\u000e\u0010i\u001a\u00020\u00002\u0006\u00108\u001a\u000209J\u000e\u0010j\u001a\u00020\u00002\u0006\u0010>\u001a\u00020?J\u000e\u0010O\u001a\u00020\u00002\u0006\u0010O\u001a\u00020PJ\u000e\u0010k\u001a\u00020\u00002\u0006\u0010D\u001a\u00020\u0012J\u000e\u0010l\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u0015\u0010m\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\u0002\u0010nJ\u000e\u0010o\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0012J\u000e\u0010p\u001a\u00020\u00002\u0006\u0010I\u001a\u00020JJ\u000e\u0010q\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010r\u001a\u00020\u00002\u0006\u0010U\u001a\u00020VJ\u0015\u0010s\u001a\u00020\u00002\b\u0010[\u001a\u0004\u0018\u00010#¢\u0006\u0002\u0010nR+\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0004R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0012X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u0004\u0018\u00010#X\u0080\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010)\u001a\u0004\u0018\u00010\u0012X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R \u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u001cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001f\"\u0004\b/\u0010!R&\u00100\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020301X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u000109X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010>\u001a\u0004\u0018\u00010?X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001c\u0010I\u001a\u0004\u0018\u00010JX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001c\u0010O\u001a\u0004\u0018\u00010PX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001c\u0010U\u001a\u0004\u0018\u00010VX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001e\u0010[\u001a\u0004\u0018\u00010#X\u0080\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b\\\u0010%\"\u0004\b]\u0010'¨\u0006t"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/init/LynxConfig$Builder;", "", "context", "Landroid/app/Application;", "(Landroid/app/Application;)V", "additionInit", "Lkotlin/Function1;", "Lcom/lynx/tasm/LynxEnv;", "", "Lkotlin/ExtensionFunctionType;", "getAdditionInit$anniex_release", "()Lkotlin/jvm/functions/Function1;", "setAdditionInit$anniex_release", "(Lkotlin/jvm/functions/Function1;)V", "getContext", "()Landroid/app/Application;", "setContext", MemoryApi.DEBUG, "", "getDebug$anniex_release", "()Ljava/lang/Boolean;", "setDebug$anniex_release", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "devtoolOuterControl", "getDevtoolOuterControl$anniex_release", "setDevtoolOuterControl$anniex_release", "devtoolProcessors", "", "Lcom/bytedance/ies/bullet/lynx/init/LynxDevtoolProcessor;", "getDevtoolProcessors$anniex_release", "()Ljava/util/List;", "setDevtoolProcessors$anniex_release", "(Ljava/util/List;)V", "fontScale", "", "getFontScale$anniex_release", "()Ljava/lang/Float;", "setFontScale$anniex_release", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "forceInit", "getForceInit$anniex_release", "setForceInit$anniex_release", "globalBehaviors", "Lcom/lynx/tasm/behavior/Behavior;", "getGlobalBehaviors$anniex_release", "setGlobalBehaviors$anniex_release", "globalModules", "", "", "Lcom/bytedance/ies/bullet/lynx/model/LynxModuleWrapper;", "getGlobalModules$anniex_release", "()Ljava/util/Map;", "setGlobalModules$anniex_release", "(Ljava/util/Map;)V", "initCanvasConfig", "Lcom/bytedance/ies/bullet/lynx/init/ILynxCanvasConfig;", "getInitCanvasConfig$anniex_release", "()Lcom/bytedance/ies/bullet/lynx/init/ILynxCanvasConfig;", "setInitCanvasConfig$anniex_release", "(Lcom/bytedance/ies/bullet/lynx/init/ILynxCanvasConfig;)V", "initImageConfig", "Lcom/bytedance/ies/bullet/lynx/init/ILynxImageConfig;", "getInitImageConfig$anniex_release", "()Lcom/bytedance/ies/bullet/lynx/init/ILynxImageConfig;", "setInitImageConfig$anniex_release", "(Lcom/bytedance/ies/bullet/lynx/init/ILynxImageConfig;)V", "isCheckPropsSetter", "isCheckPropsSetter$anniex_release", "()Z", "setCheckPropsSetter$anniex_release", "(Z)V", "libraryLoader", "Lcom/lynx/tasm/INativeLibraryLoader;", "getLibraryLoader$anniex_release", "()Lcom/lynx/tasm/INativeLibraryLoader;", "setLibraryLoader$anniex_release", "(Lcom/lynx/tasm/INativeLibraryLoader;)V", "lynxSdkMonitorConfig", "Lcom/bytedance/ies/bullet/lynx/init/LynxSdkMonitorConfig;", "getLynxSdkMonitorConfig$anniex_release", "()Lcom/bytedance/ies/bullet/lynx/init/LynxSdkMonitorConfig;", "setLynxSdkMonitorConfig$anniex_release", "(Lcom/bytedance/ies/bullet/lynx/init/LynxSdkMonitorConfig;)V", "templateProvider", "Lcom/lynx/tasm/provider/AbsTemplateProvider;", "getTemplateProvider$anniex_release", "()Lcom/lynx/tasm/provider/AbsTemplateProvider;", "setTemplateProvider$anniex_release", "(Lcom/lynx/tasm/provider/AbsTemplateProvider;)V", "viewZoom", "getViewZoom$anniex_release", "setViewZoom$anniex_release", "addBehaviors", "behaviors", "", "addLynxDevtoolProcessor", "lynxDevtoolProcessor", "addLynxModules", "modules", "build", "Lcom/bytedance/ies/bullet/lynx/init/LynxConfig;", "lynxAdditionInit", "addition", "lynxCanvasConfig", "lynxImageConfig", "setCheckPropsSetter", "setDebug", "setFontScale", "(Ljava/lang/Float;)Lcom/bytedance/ies/bullet/lynx/init/LynxConfig$Builder;", "setForceInit", "setLynxLibraryLoader", "setOuterDevtoolControl", "setTemplateProvider", "setViewZoom", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Builder {
        private Function1<? super LynxEnv, Unit> additionInit;
        private Application context;
        private Boolean debug;
        private Boolean devtoolOuterControl;
        private List<LynxDevtoolProcessor> devtoolProcessors;
        private Float fontScale;
        private Boolean forceInit;
        private List<Behavior> globalBehaviors;
        private Map<String, LynxModuleWrapper> globalModules;
        private ILynxCanvasConfig initCanvasConfig;
        private ILynxImageConfig initImageConfig;
        private boolean isCheckPropsSetter;
        private INativeLibraryLoader libraryLoader;
        private LynxSdkMonitorConfig lynxSdkMonitorConfig;
        private AbsTemplateProvider templateProvider;
        private Float viewZoom;

        public Builder(Application application) {
            Intrinsics.checkNotNullParameter(application, "context");
            this.context = application;
            this.isCheckPropsSetter = true;
            this.devtoolProcessors = new ArrayList();
            this.globalBehaviors = new ArrayList();
            this.globalModules = new LinkedHashMap();
            this.additionInit = new Function1<LynxEnv, Unit>() { // from class: com.bytedance.ies.bullet.lynx.init.LynxConfig$Builder$additionInit$1
                public final void invoke(LynxEnv lynxEnv) {
                    Intrinsics.checkNotNullParameter(lynxEnv, "$this$null");
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((LynxEnv) obj);
                    return Unit.INSTANCE;
                }
            };
        }

        public final Application getContext() {
            return this.context;
        }

        public final void setContext(Application application) {
            Intrinsics.checkNotNullParameter(application, "<set-?>");
            this.context = application;
        }

        /* renamed from: isCheckPropsSetter$anniex_release, reason: from getter */
        public final boolean getIsCheckPropsSetter() {
            return this.isCheckPropsSetter;
        }

        public final void setCheckPropsSetter$anniex_release(boolean z) {
            this.isCheckPropsSetter = z;
        }

        public final List<LynxDevtoolProcessor> getDevtoolProcessors$anniex_release() {
            return this.devtoolProcessors;
        }

        public final void setDevtoolProcessors$anniex_release(List<LynxDevtoolProcessor> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.devtoolProcessors = list;
        }

        /* renamed from: getLibraryLoader$anniex_release, reason: from getter */
        public final INativeLibraryLoader getLibraryLoader() {
            return this.libraryLoader;
        }

        public final void setLibraryLoader$anniex_release(INativeLibraryLoader iNativeLibraryLoader) {
            this.libraryLoader = iNativeLibraryLoader;
        }

        /* renamed from: getTemplateProvider$anniex_release, reason: from getter */
        public final AbsTemplateProvider getTemplateProvider() {
            return this.templateProvider;
        }

        public final void setTemplateProvider$anniex_release(AbsTemplateProvider absTemplateProvider) {
            this.templateProvider = absTemplateProvider;
        }

        public final List<Behavior> getGlobalBehaviors$anniex_release() {
            return this.globalBehaviors;
        }

        public final void setGlobalBehaviors$anniex_release(List<Behavior> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.globalBehaviors = list;
        }

        public final Map<String, LynxModuleWrapper> getGlobalModules$anniex_release() {
            return this.globalModules;
        }

        public final void setGlobalModules$anniex_release(Map<String, LynxModuleWrapper> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.globalModules = map;
        }

        /* renamed from: getInitCanvasConfig$anniex_release, reason: from getter */
        public final ILynxCanvasConfig getInitCanvasConfig() {
            return this.initCanvasConfig;
        }

        public final void setInitCanvasConfig$anniex_release(ILynxCanvasConfig iLynxCanvasConfig) {
            this.initCanvasConfig = iLynxCanvasConfig;
        }

        /* renamed from: getInitImageConfig$anniex_release, reason: from getter */
        public final ILynxImageConfig getInitImageConfig() {
            return this.initImageConfig;
        }

        public final void setInitImageConfig$anniex_release(ILynxImageConfig iLynxImageConfig) {
            this.initImageConfig = iLynxImageConfig;
        }

        public final Function1<LynxEnv, Unit> getAdditionInit$anniex_release() {
            return this.additionInit;
        }

        public final void setAdditionInit$anniex_release(Function1<? super LynxEnv, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "<set-?>");
            this.additionInit = function1;
        }

        /* renamed from: getLynxSdkMonitorConfig$anniex_release, reason: from getter */
        public final LynxSdkMonitorConfig getLynxSdkMonitorConfig() {
            return this.lynxSdkMonitorConfig;
        }

        public final void setLynxSdkMonitorConfig$anniex_release(LynxSdkMonitorConfig lynxSdkMonitorConfig) {
            this.lynxSdkMonitorConfig = lynxSdkMonitorConfig;
        }

        /* renamed from: getFontScale$anniex_release, reason: from getter */
        public final Float getFontScale() {
            return this.fontScale;
        }

        public final void setFontScale$anniex_release(Float f) {
            this.fontScale = f;
        }

        /* renamed from: getViewZoom$anniex_release, reason: from getter */
        public final Float getViewZoom() {
            return this.viewZoom;
        }

        public final void setViewZoom$anniex_release(Float f) {
            this.viewZoom = f;
        }

        /* renamed from: getDebug$anniex_release, reason: from getter */
        public final Boolean getDebug() {
            return this.debug;
        }

        public final void setDebug$anniex_release(Boolean bool) {
            this.debug = bool;
        }

        /* renamed from: getDevtoolOuterControl$anniex_release, reason: from getter */
        public final Boolean getDevtoolOuterControl() {
            return this.devtoolOuterControl;
        }

        public final void setDevtoolOuterControl$anniex_release(Boolean bool) {
            this.devtoolOuterControl = bool;
        }

        /* renamed from: getForceInit$anniex_release, reason: from getter */
        public final Boolean getForceInit() {
            return this.forceInit;
        }

        public final void setForceInit$anniex_release(Boolean bool) {
            this.forceInit = bool;
        }

        public final Builder setFontScale(Float fontScale) {
            LynxKitBase.INSTANCE.setFontScale(fontScale);
            this.fontScale = fontScale;
            return this;
        }

        public final Builder setViewZoom(Float viewZoom) {
            LynxKitBase.INSTANCE.setViewZoom(viewZoom);
            this.viewZoom = viewZoom;
            return this;
        }

        public final Builder setDebug(boolean debug) {
            LynxKitBase.INSTANCE.setDebug(debug);
            this.debug = Boolean.valueOf(debug);
            return this;
        }

        public final Builder setOuterDevtoolControl(boolean debug) {
            LynxKitBase.INSTANCE.setDevtoolOuterControl(debug);
            this.devtoolOuterControl = Boolean.valueOf(debug);
            return this;
        }

        public final Builder addLynxDevtoolProcessor(LynxDevtoolProcessor lynxDevtoolProcessor) {
            Intrinsics.checkNotNullParameter(lynxDevtoolProcessor, "lynxDevtoolProcessor");
            this.devtoolProcessors.add(lynxDevtoolProcessor);
            return this;
        }

        public final Builder setLynxLibraryLoader(INativeLibraryLoader libraryLoader) {
            Intrinsics.checkNotNullParameter(libraryLoader, "libraryLoader");
            this.libraryLoader = libraryLoader;
            return this;
        }

        public final Builder setTemplateProvider(AbsTemplateProvider templateProvider) {
            Intrinsics.checkNotNullParameter(templateProvider, "templateProvider");
            this.templateProvider = templateProvider;
            return this;
        }

        public final Builder addBehaviors(List<? extends Behavior> behaviors) {
            Intrinsics.checkNotNullParameter(behaviors, "behaviors");
            this.globalBehaviors.addAll(behaviors);
            return this;
        }

        public final Builder addLynxModules(Map<String, LynxModuleWrapper> modules) {
            Intrinsics.checkNotNullParameter(modules, "modules");
            this.globalModules.putAll(modules);
            return this;
        }

        public final Builder setCheckPropsSetter(boolean isCheckPropsSetter) {
            this.isCheckPropsSetter = isCheckPropsSetter;
            return this;
        }

        public final Builder lynxCanvasConfig(ILynxCanvasConfig initCanvasConfig) {
            Intrinsics.checkNotNullParameter(initCanvasConfig, "initCanvasConfig");
            this.initCanvasConfig = initCanvasConfig;
            return this;
        }

        public final Builder lynxSdkMonitorConfig(LynxSdkMonitorConfig lynxSdkMonitorConfig) {
            Intrinsics.checkNotNullParameter(lynxSdkMonitorConfig, "lynxSdkMonitorConfig");
            this.lynxSdkMonitorConfig = lynxSdkMonitorConfig;
            return this;
        }

        public final Builder lynxImageConfig(ILynxImageConfig initImageConfig) {
            Intrinsics.checkNotNullParameter(initImageConfig, "initImageConfig");
            this.initImageConfig = initImageConfig;
            return this;
        }

        public final Builder lynxAdditionInit(Function1<? super LynxEnv, Unit> addition) {
            Intrinsics.checkNotNullParameter(addition, "addition");
            this.additionInit = addition;
            return this;
        }

        public final Builder setForceInit(boolean forceInit) {
            this.forceInit = Boolean.valueOf(forceInit);
            return this;
        }

        public final LynxConfig build() {
            return new LynxConfig(this.context, this, null);
        }
    }

    public final Function1<LynxEnv, Unit> additionLynxInit() {
        return this.builder.getAdditionInit$anniex_release();
    }

    public final List<LynxDevtoolProcessor> devtoolProcessors() {
        return this.builder.getDevtoolProcessors$anniex_release();
    }

    public final INativeLibraryLoader libraryLoader() {
        return this.builder.getLibraryLoader();
    }

    public final AbsTemplateProvider templateProvider() {
        return this.builder.getTemplateProvider();
    }

    public final List<Behavior> globalBehaviors() {
        return this.builder.getGlobalBehaviors$anniex_release();
    }

    public final Map<String, LynxModuleWrapper> globalModules() {
        return this.builder.getGlobalModules$anniex_release();
    }

    public final boolean isCheckPropsSetter() {
        return this.builder.getIsCheckPropsSetter();
    }

    public final ILynxCanvasConfig canvasInitConfig() {
        return this.builder.getInitCanvasConfig();
    }

    public final ILynxImageConfig imageInitConfig() {
        return this.builder.getInitImageConfig();
    }

    public final LynxSdkMonitorConfig lynxSdkMonitorConfig() {
        return this.builder.getLynxSdkMonitorConfig();
    }

    public final Float getFontScale() {
        return this.builder.getFontScale();
    }

    public final Float getViewZoom() {
        return this.builder.getViewZoom();
    }

    public final Boolean getDebug() {
        return this.builder.getDebug();
    }

    public final Boolean getForceInit() {
        return this.builder.getForceInit();
    }

    public final Boolean getDevtoolOuterControl() {
        return this.builder.getDevtoolOuterControl();
    }

    public final void setFontScale(Float fontScale) {
        LynxKitBase.INSTANCE.setFontScale(fontScale);
        this.builder.setFontScale$anniex_release(fontScale);
    }

    public final void setViewZoom(Float viewZoom) {
        LynxKitBase.INSTANCE.setViewZoom(viewZoom);
        this.builder.setViewZoom$anniex_release(viewZoom);
    }

    public final void setDebug(boolean debug) {
        LynxKitBase.INSTANCE.setDebug(debug);
        this.builder.setDebug$anniex_release(Boolean.valueOf(debug));
    }

    public final void setOuterDevtoolControl(boolean debug) {
        LynxKitBase.INSTANCE.setDevtoolOuterControl(debug);
        this.builder.setDevtoolOuterControl$anniex_release(Boolean.valueOf(debug));
    }

    public static /* synthetic */ void addLynxDevtoolProcessor$default(LynxConfig lynxConfig, LynxDevtoolProcessor lynxDevtoolProcessor, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addLynxDevtoolProcessor");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        lynxConfig.addLynxDevtoolProcessor(lynxDevtoolProcessor, z);
    }

    public final void addLynxDevtoolProcessor(LynxDevtoolProcessor lynxDevtoolProcessor, boolean isAdd) {
        Intrinsics.checkNotNullParameter(lynxDevtoolProcessor, "lynxDevtoolProcessor");
        if (!isAdd) {
            this.builder.getDevtoolProcessors$anniex_release().clear();
        }
        this.builder.getDevtoolProcessors$anniex_release().add(lynxDevtoolProcessor);
    }

    public final void setLynxLibraryLoader(INativeLibraryLoader libraryLoader) {
        Intrinsics.checkNotNullParameter(libraryLoader, "libraryLoader");
        this.builder.setLibraryLoader$anniex_release(libraryLoader);
    }

    public final void setTemplateProvider(AbsTemplateProvider templateProvider) {
        Intrinsics.checkNotNullParameter(templateProvider, "templateProvider");
        this.builder.setTemplateProvider$anniex_release(templateProvider);
    }

    public static /* synthetic */ void addBehaviors$default(LynxConfig lynxConfig, List list, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addBehaviors");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        lynxConfig.addBehaviors(list, z);
    }

    public final void addBehaviors(List<? extends Behavior> behaviors, boolean isAdd) {
        Intrinsics.checkNotNullParameter(behaviors, "behaviors");
        if (!isAdd) {
            this.builder.getGlobalBehaviors$anniex_release().clear();
        }
        this.builder.getGlobalBehaviors$anniex_release().addAll(behaviors);
    }

    public static /* synthetic */ void addLynxModules$default(LynxConfig lynxConfig, Map map, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addLynxModules");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        lynxConfig.addLynxModules(map, z);
    }

    public final void addLynxModules(Map<String, LynxModuleWrapper> modules, boolean isAdd) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        if (!isAdd) {
            this.builder.getGlobalModules$anniex_release().clear();
        }
        this.builder.getGlobalModules$anniex_release().putAll(modules);
    }

    public final void setCheckPropsSetter(boolean isCheckPropsSetter) {
        this.builder.setCheckPropsSetter$anniex_release(isCheckPropsSetter);
    }

    public final void lynxCanvasConfig(ILynxCanvasConfig initCanvasConfig) {
        Intrinsics.checkNotNullParameter(initCanvasConfig, "initCanvasConfig");
        this.builder.setInitCanvasConfig$anniex_release(initCanvasConfig);
    }

    public final void lynxSdkMonitorConfig(LynxSdkMonitorConfig lynxSdkMonitorConfig) {
        Intrinsics.checkNotNullParameter(lynxSdkMonitorConfig, "lynxSdkMonitorConfig");
        this.builder.setLynxSdkMonitorConfig$anniex_release(lynxSdkMonitorConfig);
    }

    public final void lynxImageConfig(ILynxImageConfig initImageConfig) {
        Intrinsics.checkNotNullParameter(initImageConfig, "initImageConfig");
        this.builder.setInitImageConfig$anniex_release(initImageConfig);
    }

    public final void lynxAdditionInit(Function1<? super LynxEnv, Unit> addition) {
        Intrinsics.checkNotNullParameter(addition, "addition");
        this.builder.setAdditionInit$anniex_release(addition);
    }

    public final void setForceInit(boolean forceInit) {
        this.builder.setForceInit$anniex_release(Boolean.valueOf(forceInit));
    }
}
