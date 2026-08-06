package com.bytedance.salamander.anniex;

import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.ies.bullet.kit.resourceloader.monitor.RLMonitorReporter;
import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.push.interfaze.ISignalReportService;
import com.bytedance.rts.foundation.Date;
import com.bytedance.rts.foundation.Float64;
import com.bytedance.rts.foundation.RTSArrayKt;
import com.bytedance.rts.foundation.RTSMapKt;
import com.bytedance.rts.foundation.RTSStringKt;
import com.bytedance.rts.foundation.Type;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* compiled from: AnniexMonitorCoreSLAnnieXMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\u0084\u0001\u0010\u001f\u001a\u00020\u00132\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010 j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`!2V\b\u0002\u0010\"\u001aP\u0012>\u0012<\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010 j\u001d\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`!¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u0013\u0018\u00010#j\u0004\u0018\u0001`'H\u0016J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0003H\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0003H\u0002J\u0018\u0010-\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0003H\u0002J\u0084\u0001\u0010.\u001a\u00020\u00132\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010 j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`!2V\b\u0002\u0010\"\u001aP\u0012>\u0012<\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010 j\u001d\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`!¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u0013\u0018\u00010#j\u0004\u0018\u0001`'H\u0002J\u0010\u0010/\u001a\u00020\u00132\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020\u00132\u0006\u00106\u001a\u000207H\u0002Jf\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020:2T\u0010\"\u001aP\u0012>\u0012<\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010 j\u001d\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`!¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u0013\u0018\u00010#j\u0004\u0018\u0001`'H\u0002J\u0010\u0010;\u001a\u00020\u00132\u0006\u0010<\u001a\u00020=H\u0002J(\u0010>\u001a\u00020\u00132\u0006\u0010<\u001a\u00020=2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010A\u001a\u00020\fH\u0002J\u0018\u0010B\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010C\u001a\u00020+H\u0002J\u0010\u0010D\u001a\u00020\u00132\u0006\u00100\u001a\u000201H\u0016J\u0010\u0010E\u001a\u00020\u00132\u0006\u00103\u001a\u000204H\u0016J\u0010\u0010F\u001a\u00020\u00132\u0006\u00106\u001a\u000207H\u0016Jh\u0010G\u001a\u00020\u00132\u0006\u0010H\u001a\u00020I2V\b\u0002\u0010\"\u001aP\u0012>\u0012<\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010 j\u001d\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`!¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u0013\u0018\u00010#j\u0004\u0018\u0001`'H\u0016J\u0012\u0010J\u001a\u00020\u00132\b\b\u0002\u0010<\u001a\u00020=H\u0016J*\u0010K\u001a\u00020\u00132\b\b\u0002\u0010<\u001a\u00020=2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010L\u001a\u00020\u00132\u0006\u0010M\u001a\u00020\u0003H\u0016J\b\u0010N\u001a\u00020\u0013H\u0002J\u0010\u0010O\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J,\u0010P\u001a\u00020\u00132\"\u0010Q\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030 j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`!H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/bytedance/salamander/anniex/SLAnnieXMonitor;", "", "sessionId", "", "(Ljava/lang/String;)V", "config", "Lcom/bytedance/salamander/anniex/SLMonitorContainerConfig;", "(Ljava/lang/String;Lcom/bytedance/salamander/anniex/SLMonitorContainerConfig;)V", "containerBase", "Lcom/bytedance/salamander/anniex/ContainerBase;", "containerConfig", "currentPVReported", "", "engineType", "Lcom/bytedance/salamander/anniex/ContainerType;", "firstOnPageStart", "jsBase", "Lcom/bytedance/salamander/anniex/JsBase;", "assembleDataPreHandler", "", ISignalReportService.BODY_KEY_EVENT, "Lcom/bytedance/salamander/anniex/SLEvent;", "block", "Lkotlin/Function0;", "checkSwitch", "eventType", "Lcom/bytedance/salamander/anniex/SLEventType;", "collectContainerBaseStringField", "field", "Lcom/bytedance/salamander/anniex/AccessLayerStringField;", "value", "collectJSBaseField", "", "Lcom/bytedance/rts/foundation/RTSMap;", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/bytedance/salamander/anniex/SLMonitorCallback;", "debugLog", "msg", "determineBidConfig", "Lcom/bytedance/salamander/anniex/BidConfig;", "bid", "doCollectContainerBaseStringField", "doCollectJSBaseField", "doReportFetchError", "fetchErrorEventInfo", "Lcom/bytedance/salamander/anniex/SLFetchErrorEventInfo;", "doReportJSBError", "jsbErrorEventInfo", "Lcom/bytedance/salamander/anniex/SLJSBErrorEventInfo;", "doReportJSBPerf", "jsbPerfEventInfo", "Lcom/bytedance/salamander/anniex/SLJSBPerfEventInfo;", "doReportJSException", "jsExceptionEventInfo", "Lcom/bytedance/salamander/anniex/SLJSExceptionEventInfo;", "doReportPV", "pvEventInfo", "Lcom/bytedance/salamander/anniex/SLPVEventInfo;", "doReportReusePV", "url", "schema", "enableMonitor", "hitSample", "bidConfig", "reportFetchError", "reportJSBError", "reportJSBPerf", "reportLynxJSException", "errorParams", "Lcom/bytedance/salamander/anniex/SLLynxJSExceptionParams;", "reportPV", "reportReusePV", "reportWebJSException", "errorMsgJsonString", "resetNavigation", "setConfig", "updateFields", "map", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SLAnnieXMonitor {
    private ContainerBase containerBase;
    private SLMonitorContainerConfig containerConfig;
    private boolean currentPVReported;
    private ContainerType engineType;
    private boolean firstOnPageStart;
    private JsBase jsBase;

    /* compiled from: AnniexMonitorCoreSLAnnieXMonitor.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[AccessLayerStringField.values().length];
            try {
                iArr[AccessLayerStringField.CoreViewType.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AccessLayerStringField.Biz.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AccessLayerStringField.ClientComponent.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AccessLayerStringField.Schema.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AccessLayerStringField.TemplateResType.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AccessLayerStringField.ViewType.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AccessLayerStringField.GeckoId.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[AccessLayerStringField.ContainerType.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[AccessLayerStringField.SdkVersion.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[AccessLayerStringField.Url.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[AccessLayerStringField.WebViewType.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[AccessLayerStringField.WebEngineVersion.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[AccessLayerStringField.LynxVersion.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[AccessLayerStringField.NativePage.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ContainerType.values().length];
            try {
                iArr2[ContainerType.Lynx.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[ContainerType.Web.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[SLEventType.values().length];
            try {
                iArr3[SLEventType.PV.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr3[SLEventType.JSB_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr3[SLEventType.JSB_PERF.ordinal()] = 3;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr3[SLEventType.JS_EXCEPTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr3[SLEventType.FETCH_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused21) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public SLAnnieXMonitor(String str) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        this.containerBase = new ContainerBase();
        this.jsBase = new JsBase();
        this.containerConfig = new SLMonitorContainerConfig(null, false, 3, null);
        this.engineType = ContainerType.Lynx;
        this.firstOnPageStart = true;
        this.containerBase.setNavigation_id(str);
    }

    public SLAnnieXMonitor(String str, SLMonitorContainerConfig sLMonitorContainerConfig) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(sLMonitorContainerConfig, "config");
        this.containerBase = new ContainerBase();
        this.jsBase = new JsBase();
        this.containerConfig = new SLMonitorContainerConfig(null, false, 3, null);
        this.engineType = ContainerType.Lynx;
        this.firstOnPageStart = true;
        this.containerBase.setNavigation_id(str);
        this.containerConfig = sLMonitorContainerConfig;
    }

    public void setConfig(SLMonitorContainerConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.containerConfig = config;
    }

    public void collectContainerBaseStringField(final AccessLayerStringField field, final String value) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(value, "value");
        if (!enableMonitor()) {
            debugLog("collectContainerBaseStringField: monitor is disabled. session_id: " + this.containerBase.getNavigation_id());
        } else {
            TaskRunner.INSTANCE.getInstance().runTaskOnMonitorThread(new Function1<Boolean, Unit>() { // from class: com.bytedance.salamander.anniex.SLAnnieXMonitor$collectContainerBaseStringField$task$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    SLAnnieXMonitor.this.doCollectContainerBaseStringField(field, value);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void doCollectContainerBaseStringField(AccessLayerStringField field, String value) {
        switch (WhenMappings.$EnumSwitchMapping$0[field.ordinal()]) {
            case 1:
                CoreViewType coreViewType = CoreViewType.AnnieXCard;
                int hashCode = value.hashCode();
                if (hashCode != -1791893678) {
                    if (hashCode != -1030849781) {
                        if (hashCode == 476419099 && value.equals("BDXView")) {
                            coreViewType = CoreViewType.BDXView;
                        }
                    } else if (value.equals("AnnieXCard")) {
                        coreViewType = CoreViewType.AnnieXCard;
                    }
                } else if (value.equals("BulletCard")) {
                    coreViewType = CoreViewType.BulletCard;
                }
                this.containerBase.get__internal().setCore_view_type(coreViewType);
                return;
            case 2:
                this.containerBase.get__internal().setBiz(value);
                return;
            case 3:
                ClientComponent clientComponent = ClientComponent.View;
                switch (value.hashCode()) {
                    case -1655966961:
                        if (value.equals("activity")) {
                            clientComponent = ClientComponent.Activity;
                            break;
                        }
                        break;
                    case -1650269616:
                        if (value.equals("fragment")) {
                            clientComponent = ClientComponent.Fragment;
                            break;
                        }
                        break;
                    case -32932936:
                        if (value.equals("dialogFragment")) {
                            clientComponent = ClientComponent.DialogFragment;
                            break;
                        }
                        break;
                    case 3619493:
                        if (value.equals("view")) {
                            clientComponent = ClientComponent.View;
                            break;
                        }
                        break;
                }
                this.containerBase.get__internal().setClient_component(clientComponent);
                return;
            case 4:
                if (this.containerBase.getSchema().length() == 0) {
                    updateFields(AnniexMonitorUtilsUriParamsFinderKt.findSchemaQueryParams(value));
                    String validatedField = AnniexMonitorCoreValidatorKt.getStringFieldValidator().getValidatedField("schema", value);
                    if (validatedField != null) {
                        this.containerBase.setSchema(validatedField);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                TemplateResType templateResType = TemplateResType.Unknown;
                switch (value.hashCode()) {
                    case -1712962585:
                        if (value.equals("template_bundle")) {
                            templateResType = TemplateResType.TemplateBundle;
                            break;
                        }
                        debugLog("collectContainerBaseStringField: illegal TemplateResType: " + value + ". session_id: " + this.containerBase.getNavigation_id());
                        break;
                    case -1548612125:
                        if (value.equals(ResourceInfo.RESOURCE_FROM_OFFLINE)) {
                            templateResType = TemplateResType.Offline;
                            break;
                        }
                        debugLog("collectContainerBaseStringField: illegal TemplateResType: " + value + ". session_id: " + this.containerBase.getNavigation_id());
                        break;
                    case -1513097944:
                        if (value.equals("binary_data")) {
                            templateResType = TemplateResType.BinaryData;
                            break;
                        }
                        debugLog("collectContainerBaseStringField: illegal TemplateResType: " + value + ". session_id: " + this.containerBase.getNavigation_id());
                        break;
                    case -1043866017:
                        if (value.equals(RLMonitorReporter.GECKO_UPDATE)) {
                            templateResType = TemplateResType.GeckoUpdate;
                            break;
                        }
                        debugLog("collectContainerBaseStringField: illegal TemplateResType: " + value + ". session_id: " + this.containerBase.getNavigation_id());
                        break;
                    case 98349:
                        if (value.equals(ResourceInfo.RESOURCE_FROM_CDN)) {
                            templateResType = TemplateResType.CDN;
                            break;
                        }
                        debugLog("collectContainerBaseStringField: illegal TemplateResType: " + value + ". session_id: " + this.containerBase.getNavigation_id());
                        break;
                    case 98230121:
                        if (value.equals(ResourceInfo.RESOURCE_FROM_GECKO)) {
                            templateResType = TemplateResType.Gecko;
                            break;
                        }
                        debugLog("collectContainerBaseStringField: illegal TemplateResType: " + value + ". session_id: " + this.containerBase.getNavigation_id());
                        break;
                    case 230960163:
                        if (value.equals("builtin")) {
                            templateResType = TemplateResType.BuiltIn;
                            break;
                        }
                        debugLog("collectContainerBaseStringField: illegal TemplateResType: " + value + ". session_id: " + this.containerBase.getNavigation_id());
                        break;
                    case 1293352176:
                        if (value.equals("cdn_cache")) {
                            templateResType = TemplateResType.CDNCache;
                            break;
                        }
                        debugLog("collectContainerBaseStringField: illegal TemplateResType: " + value + ". session_id: " + this.containerBase.getNavigation_id());
                        break;
                    default:
                        debugLog("collectContainerBaseStringField: illegal TemplateResType: " + value + ". session_id: " + this.containerBase.getNavigation_id());
                        break;
                }
                this.containerBase.setTemplate_res_type(templateResType);
                return;
            case 6:
                ViewType viewType = ViewType.Page;
                int hashCode2 = value.hashCode();
                if (hashCode2 != 3046160) {
                    if (hashCode2 != 3433103) {
                        if (hashCode2 == 106852524 && value.equals("popup")) {
                            viewType = ViewType.Popup;
                        }
                    } else if (value.equals("page")) {
                        viewType = ViewType.Page;
                    }
                } else if (value.equals("card")) {
                    viewType = ViewType.Card;
                }
                this.containerBase.setView_type(viewType);
                return;
            case 7:
                this.containerBase.setGecko_id(value);
                return;
            case 8:
                ContainerType containerType = ContainerType.Lynx;
                ContainerType containerType2 = Intrinsics.areEqual(value, "lynx") ? ContainerType.Lynx : Intrinsics.areEqual(value, "webview") ? ContainerType.Web : ContainerType.Unknown;
                this.engineType = containerType2;
                this.containerBase.setContainer_type(containerType2);
                return;
            case 9:
                String validatedField2 = AnniexMonitorCoreValidatorKt.getStringFieldValidator().getValidatedField(CommonConstants.SDK_VERSION, value);
                if (validatedField2 != null) {
                    this.containerBase.setSdk_version(validatedField2);
                    return;
                }
                return;
            case 10:
                if (this.containerBase.getUrl() != null) {
                    String url = this.containerBase.getUrl();
                    boolean z = false;
                    if (url != null && url.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        return;
                    }
                }
                String validatedField3 = AnniexMonitorCoreValidatorKt.getStringFieldValidator().getValidatedField("url", value);
                if (validatedField3 != null) {
                    this.containerBase.setUrl(validatedField3);
                    return;
                }
                return;
            case 11:
                WebviewType webviewType = WebviewType.TTWebView;
                this.containerBase.setWebview_type(Intrinsics.areEqual(value, "ttwebview") ? WebviewType.TTWebView : Intrinsics.areEqual(value, "system") ? WebviewType.System : WebviewType.Unknown);
                return;
            case 12:
                this.containerBase.setWeb_engine_version(value);
                return;
            case 13:
                this.containerBase.setLynx_version(value);
                return;
            case 14:
                this.containerBase.setNative_page(value);
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void collectJSBaseField$default(SLAnnieXMonitor sLAnnieXMonitor, Map map, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: collectJSBaseField");
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        sLAnnieXMonitor.collectJSBaseField(map, function1);
    }

    public void collectJSBaseField(final Map<String, Object> config, final Function1<? super Map<String, Object>, Unit> callback) {
        Intrinsics.checkNotNullParameter(config, "config");
        TaskRunner.INSTANCE.getInstance().runTaskOnMonitorThread(new Function1<Boolean, Unit>() { // from class: com.bytedance.salamander.anniex.SLAnnieXMonitor$collectJSBaseField$task$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                SLAnnieXMonitor.this.doCollectJSBaseField(config, callback);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void doCollectJSBaseField$default(SLAnnieXMonitor sLAnnieXMonitor, Map map, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doCollectJSBaseField");
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        sLAnnieXMonitor.doCollectJSBaseField(map, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doCollectJSBaseField(Map<String, Object> config, Function1<? super Map<String, Object>, Unit> callback) {
        Map RTSMap = RTSMapKt.RTSMap();
        RTSMapKt.set(RTSMap, "errorCode", -1);
        RTSMapKt.set(RTSMap, "errorMessage", CDNLoader.PIPELINE_STATUS_FAILED);
        if (!enableMonitor()) {
            debugLog("collectJSBaseField: monitor is disabled. session_id: " + this.containerBase.getNavigation_id());
            RTSMapKt.set(RTSMap, "errorMessage", "monitor is disabled");
            if (callback != null) {
                callback.invoke(RTSMap);
                return;
            }
            return;
        }
        if (!RTSMapKt.has(config, PrefetchRequestConfig.PARAM_TYPE_ENV) && !RTSMapKt.has(config, "release") && !RTSMapKt.has(config, "context")) {
            RTSMapKt.set(RTSMap, "errorCode", -3);
            RTSMapKt.set(RTSMap, "errorMessage", "release、env、context must has at least 1 not be empty");
            if (callback != null) {
                callback.invoke(RTSMap);
                return;
            }
            return;
        }
        if (this.jsBase.getEnv() == null && RTSMapKt.has(config, PrefetchRequestConfig.PARAM_TYPE_ENV)) {
            Object obj = config.get(PrefetchRequestConfig.PARAM_TYPE_ENV);
            Type.Companion companion = Type.INSTANCE;
            Intrinsics.checkNotNull(obj);
            if (!companion.isString(obj)) {
                RTSMapKt.set(RTSMap, "errorCode", -3);
                RTSMapKt.set(RTSMap, "errorMessage", "env must be string");
                if (callback != null) {
                    callback.invoke(RTSMap);
                    return;
                }
                return;
            }
            StringLengthValidator stringFieldValidator = AnniexMonitorCoreValidatorKt.getStringFieldValidator();
            Object obj2 = config.get(PrefetchRequestConfig.PARAM_TYPE_ENV);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            ValidationResult<String> doValidation = stringFieldValidator.doValidation("js_base_env", (String) obj2);
            if (doValidation.isInvalidInput()) {
                RTSMapKt.set(RTSMap, "errorCode", Long.valueOf(doValidation.getCode()));
                RTSMapKt.set(RTSMap, "errorMessage", "env.length must <= " + doValidation.getFieldLength());
                if (callback != null) {
                    callback.invoke(RTSMap);
                    return;
                }
                return;
            }
            this.jsBase.setEnv(doValidation.getValueWhenSuccess());
        }
        if (this.jsBase.getRelease() == null && RTSMapKt.has(config, "release")) {
            Object obj3 = config.get("release");
            Type.Companion companion2 = Type.INSTANCE;
            Intrinsics.checkNotNull(obj3);
            if (!companion2.isString(obj3)) {
                RTSMapKt.set(RTSMap, "errorCode", -3);
                RTSMapKt.set(RTSMap, "errorMessage", "release must be string");
                if (callback != null) {
                    callback.invoke(RTSMap);
                    return;
                }
                return;
            }
            StringLengthValidator stringFieldValidator2 = AnniexMonitorCoreValidatorKt.getStringFieldValidator();
            Object obj4 = config.get("release");
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.String");
            ValidationResult<String> doValidation2 = stringFieldValidator2.doValidation("js_base_release", (String) obj4);
            if (doValidation2.isInvalidInput()) {
                RTSMapKt.set(RTSMap, "errorCode", Long.valueOf(doValidation2.getCode()));
                RTSMapKt.set(RTSMap, "errorMessage", "release.length must <= " + doValidation2.getFieldLength());
                if (callback != null) {
                    callback.invoke(RTSMap);
                    return;
                }
                return;
            }
            this.jsBase.setRelease(doValidation2.getValueWhenSuccess());
        }
        if (RTSMapKt.has(config, "context")) {
            try {
                AnnieXStringUtils stringUtils = AnniexMonitorUtilsStringUtilsKt.getStringUtils();
                Object obj5 = config.get("context");
                Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>{ com.bytedance.rts.foundation.RTSMapKt.RTSMap<kotlin.String, kotlin.Any> }");
                Map<String, String> objectMapToStringMap = stringUtils.objectMapToStringMap(TypeIntrinsics.asMutableMap(obj5));
                Intrinsics.checkNotNull(objectMapToStringMap);
                if (RTSArrayKt.getLength(RTSMapKt.keys(objectMapToStringMap)) > 20) {
                    RTSMapKt.set(RTSMap, "errorCode", -3);
                    RTSMapKt.set(RTSMap, "errorMessage", "size of property in context must <= 20");
                    if (callback != null) {
                        callback.invoke(RTSMap);
                        return;
                    }
                    return;
                }
                if (this.jsBase.getContext() == null) {
                    this.jsBase.setContext(RTSMapKt.RTSMap());
                }
                ArrayList keys = RTSMapKt.keys(objectMapToStringMap);
                for (int i = 0; i < RTSArrayKt.getLength(keys); i++) {
                    Object obj6 = keys.get(i);
                    Intrinsics.checkNotNullExpressionValue(obj6, "keys[i]");
                    String str = (String) obj6;
                    String str2 = objectMapToStringMap.get(str);
                    ValidationResult<String> doValidation3 = AnniexMonitorCoreValidatorKt.getStringFieldValidator().doValidation("js_base_context_key", str);
                    if (doValidation3.isInvalidInput()) {
                        RTSMapKt.set(RTSMap, "errorCode", Long.valueOf(doValidation3.getCode()));
                        RTSMapKt.set(RTSMap, "errorMessage", "property with the longest key in the context must <= " + doValidation3.getFieldLength());
                        if (callback != null) {
                            callback.invoke(RTSMap);
                            return;
                        }
                        return;
                    }
                    StringLengthValidator stringFieldValidator3 = AnniexMonitorCoreValidatorKt.getStringFieldValidator();
                    Intrinsics.checkNotNull(str2);
                    ValidationResult<String> doValidation4 = stringFieldValidator3.doValidation("js_base_context_value", str2);
                    if (doValidation4.isInvalidInput()) {
                        RTSMapKt.set(RTSMap, "errorCode", Long.valueOf(doValidation4.getCode()));
                        RTSMapKt.set(RTSMap, "errorMessage", "property with the longest value in the context must <= " + doValidation4.getFieldLength());
                        if (callback != null) {
                            callback.invoke(RTSMap);
                            return;
                        }
                        return;
                    }
                    if (doValidation3.getValueWhenSuccess() != null && doValidation4.getValueWhenSuccess() != null) {
                        Map<String, String> context = this.jsBase.getContext();
                        Intrinsics.checkNotNull(context);
                        String valueWhenSuccess = doValidation3.getValueWhenSuccess();
                        Intrinsics.checkNotNull(valueWhenSuccess);
                        String valueWhenSuccess2 = doValidation4.getValueWhenSuccess();
                        Intrinsics.checkNotNull(valueWhenSuccess2);
                        RTSMapKt.set(context, valueWhenSuccess, valueWhenSuccess2);
                    }
                }
            } catch (Throwable unused) {
                RTSMapKt.set(RTSMap, "errorCode", -3);
                RTSMapKt.set(RTSMap, "errorMessage", "context must be Map<string, string>");
                if (callback != null) {
                    callback.invoke(RTSMap);
                    return;
                }
                return;
            }
        }
        RTSMapKt.set(RTSMap, "errorCode", 1);
        RTSMapKt.set(RTSMap, "errorMessage", "Success");
        if (callback != null) {
            callback.invoke(RTSMap);
        }
    }

    public void reportJSBPerf(final SLJSBPerfEventInfo jsbPerfEventInfo) {
        Intrinsics.checkNotNullParameter(jsbPerfEventInfo, "jsbPerfEventInfo");
        TaskRunner.INSTANCE.getInstance().runTaskOnMonitorThread(new Function1<Boolean, Unit>() { // from class: com.bytedance.salamander.anniex.SLAnnieXMonitor$reportJSBPerf$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                SLAnnieXMonitor.this.doReportJSBPerf(jsbPerfEventInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doReportJSBPerf(SLJSBPerfEventInfo jsbPerfEventInfo) {
        if (!checkSwitch(SLEventType.JSB_PERF)) {
            debugLog("reportJSBPerf: monitor is disabled. session_id: " + this.containerBase.getNavigation_id());
            return;
        }
        final SLJSBPerfEvent sLJSBPerfEvent = new SLJSBPerfEvent();
        sLJSBPerfEvent.setEvent_info(jsbPerfEventInfo);
        assembleDataPreHandler(sLJSBPerfEvent, new Function0<Unit>() { // from class: com.bytedance.salamander.anniex.SLAnnieXMonitor$doReportJSBPerf$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m839invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m839invoke() {
                AnniexMonitorReportAPMKt.getApmReporter().report(SLJSBPerfEvent.this.eventType(), AnniexMonitorUtilsEventToMapKt.jsbPerfEventToMap(SLJSBPerfEvent.this));
            }
        });
    }

    public void reportJSBError(final SLJSBErrorEventInfo jsbErrorEventInfo) {
        Intrinsics.checkNotNullParameter(jsbErrorEventInfo, "jsbErrorEventInfo");
        TaskRunner.INSTANCE.getInstance().runTaskOnMonitorThread(new Function1<Boolean, Unit>() { // from class: com.bytedance.salamander.anniex.SLAnnieXMonitor$reportJSBError$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                SLAnnieXMonitor.this.doReportJSBError(jsbErrorEventInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doReportJSBError(SLJSBErrorEventInfo jsbErrorEventInfo) {
        if (!checkSwitch(SLEventType.JSB_ERROR)) {
            debugLog("reportJSBError: monitor is disabled. session_id: " + this.containerBase.getNavigation_id());
            return;
        }
        StringLengthValidator stringFieldValidator = AnniexMonitorCoreValidatorKt.getStringFieldValidator();
        String error_message = jsbErrorEventInfo.getError_message();
        Intrinsics.checkNotNull(error_message);
        ValidationResult<String> doValidation = stringFieldValidator.doValidation("jsb_error_error_message", error_message);
        if (doValidation.getValueWhenSuccess() != null) {
            String valueWhenSuccess = doValidation.getValueWhenSuccess();
            Intrinsics.checkNotNull(valueWhenSuccess);
            jsbErrorEventInfo.setError_message(valueWhenSuccess);
        }
        if (jsbErrorEventInfo.getJsb_params() != null) {
            StringLengthValidator stringFieldValidator2 = AnniexMonitorCoreValidatorKt.getStringFieldValidator();
            String jsb_params = jsbErrorEventInfo.getJsb_params();
            Intrinsics.checkNotNull(jsb_params);
            ValidationResult<String> doValidation2 = stringFieldValidator2.doValidation("jsb_error_jsb_params", jsb_params);
            if (doValidation2.getValueWhenSuccess() != null) {
                String valueWhenSuccess2 = doValidation2.getValueWhenSuccess();
                Intrinsics.checkNotNull(valueWhenSuccess2);
                jsbErrorEventInfo.setJsb_params(valueWhenSuccess2);
            } else {
                jsbErrorEventInfo.setJsb_params("{\"status\":\"params length exceeds 1000\"}");
            }
        }
        final SLJSBErrorEvent sLJSBErrorEvent = new SLJSBErrorEvent();
        sLJSBErrorEvent.setEvent_info(jsbErrorEventInfo);
        assembleDataPreHandler(sLJSBErrorEvent, new Function0<Unit>() { // from class: com.bytedance.salamander.anniex.SLAnnieXMonitor$doReportJSBError$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m838invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m838invoke() {
                SLMonitorContainerConfig sLMonitorContainerConfig;
                SLJSBErrorEvent sLJSBErrorEvent2 = SLJSBErrorEvent.this;
                sLMonitorContainerConfig = this.containerConfig;
                AnniexMonitorReportAPMKt.getApmReporter().report(SLJSBErrorEvent.this.eventType(), AnniexMonitorUtilsEventToMapKt.jsbErrorEventInfoToMap(sLJSBErrorEvent2, sLMonitorContainerConfig));
            }
        });
    }

    public static /* synthetic */ void reportPV$default(SLAnnieXMonitor sLAnnieXMonitor, SLPVEventInfo sLPVEventInfo, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportPV");
        }
        if ((i & 1) != 0) {
            sLPVEventInfo = new SLPVEventInfo();
        }
        sLAnnieXMonitor.reportPV(sLPVEventInfo);
    }

    public void reportPV(final SLPVEventInfo pvEventInfo) {
        Intrinsics.checkNotNullParameter(pvEventInfo, "pvEventInfo");
        TaskRunner.INSTANCE.getInstance().runTaskOnMonitorThread(new Function1<Boolean, Unit>() { // from class: com.bytedance.salamander.anniex.SLAnnieXMonitor$reportPV$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                SLAnnieXMonitor.this.doReportPV(pvEventInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doReportPV(SLPVEventInfo pvEventInfo) {
        if (!checkSwitch(SLEventType.PV)) {
            debugLog("reportPV: monitor is disabled. session_id: " + this.containerBase.getNavigation_id());
        } else {
            if (this.currentPVReported) {
                return;
            }
            final SLPVEvent sLPVEvent = new SLPVEvent();
            sLPVEvent.setEvent_info(pvEventInfo);
            assembleDataPreHandler(sLPVEvent, new Function0<Unit>() { // from class: com.bytedance.salamander.anniex.SLAnnieXMonitor$doReportPV$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m841invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m841invoke() {
                    AnniexMonitorReportAPMKt.getApmReporter().report(SLPVEvent.this.eventType(), AnniexMonitorUtilsEventToMapKt.pvEventToMap(SLPVEvent.this));
                }
            });
            this.currentPVReported = true;
        }
    }

    public static /* synthetic */ void reportReusePV$default(SLAnnieXMonitor sLAnnieXMonitor, SLPVEventInfo sLPVEventInfo, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportReusePV");
        }
        if ((i & 1) != 0) {
            sLPVEventInfo = new SLPVEventInfo();
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        sLAnnieXMonitor.reportReusePV(sLPVEventInfo, str, str2);
    }

    public void reportReusePV(final SLPVEventInfo pvEventInfo, final String url, final String schema) {
        Intrinsics.checkNotNullParameter(pvEventInfo, "pvEventInfo");
        TaskRunner.INSTANCE.getInstance().runTaskOnMonitorThread(new Function1<Boolean, Unit>() { // from class: com.bytedance.salamander.anniex.SLAnnieXMonitor$reportReusePV$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                SLAnnieXMonitor.this.doReportReusePV(pvEventInfo, url, schema);
            }
        });
    }

    static /* synthetic */ void doReportReusePV$default(SLAnnieXMonitor sLAnnieXMonitor, SLPVEventInfo sLPVEventInfo, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doReportReusePV");
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        sLAnnieXMonitor.doReportReusePV(sLPVEventInfo, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doReportReusePV(SLPVEventInfo pvEventInfo, String url, String schema) {
        if (!checkSwitch(SLEventType.PV)) {
            debugLog("reportReusePV: monitor is disabled. session_id: " + this.containerBase.getNavigation_id());
            return;
        }
        if (url != null && RTSStringKt.startsWith$default(url, "about:blank", null, 2, null)) {
            return;
        }
        if (this.currentPVReported && this.firstOnPageStart) {
            this.firstOnPageStart = false;
            return;
        }
        this.currentPVReported = true;
        this.firstOnPageStart = false;
        resetNavigation();
        if (url != null) {
            this.containerBase.setUrl(url);
        }
        if (schema != null) {
            this.containerBase.setSchema(schema);
        }
        final SLPVEvent sLPVEvent = new SLPVEvent();
        sLPVEvent.setEvent_info(pvEventInfo);
        assembleDataPreHandler(sLPVEvent, new Function0<Unit>() { // from class: com.bytedance.salamander.anniex.SLAnnieXMonitor$doReportReusePV$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m842invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m842invoke() {
                AnniexMonitorReportAPMKt.getApmReporter().report(SLPVEvent.this.eventType(), AnniexMonitorUtilsEventToMapKt.pvEventToMap(SLPVEvent.this));
            }
        });
    }

    public void reportWebJSException(final String errorMsgJsonString) {
        Intrinsics.checkNotNullParameter(errorMsgJsonString, "errorMsgJsonString");
        TaskRunner.INSTANCE.getInstance().runTaskOnMonitorThread(new Function1<Boolean, Unit>() { // from class: com.bytedance.salamander.anniex.SLAnnieXMonitor$reportWebJSException$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                JSONObject createJSONObject = AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().createJSONObject(errorMsgJsonString);
                String convertJSONObjectTOJSONString = AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().convertJSONObjectTOJSONString(AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().optJSONObjectFromJSONObject(createJSONObject, "rawMessage", AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().createJSONObject()));
                String optStringFromJSONObject = AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().optStringFromJSONObject(createJSONObject, "root_cause", "");
                JSONObject optJSONObjectFromJSONObject = AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().optJSONObjectFromJSONObject(createJSONObject, "context", AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().createJSONObject());
                SLJSExceptionEventInfo sLJSExceptionEventInfo = new SLJSExceptionEventInfo();
                JsInfo jsInfo = new JsInfo();
                if (convertJSONObjectTOJSONString.length() > 0) {
                    jsInfo.setException(convertJSONObjectTOJSONString);
                    sLJSExceptionEventInfo.setJs_info(jsInfo);
                }
                if (optStringFromJSONObject.length() > 0) {
                    sLJSExceptionEventInfo.setRoot_cause(optStringFromJSONObject);
                }
                Map<String, String> RTSMap = RTSMapKt.RTSMap();
                ArrayList<String> jSONObjectKeys = AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().getJSONObjectKeys(optJSONObjectFromJSONObject);
                for (int i = 0; i < RTSArrayKt.getLength(jSONObjectKeys); i++) {
                    String str = jSONObjectKeys.get(i);
                    Intrinsics.checkNotNullExpressionValue(str, "contextKeys[i]");
                    String str2 = str;
                    RTSMapKt.set(RTSMap, str2, AnniexMonitorUtilsStringUtilsKt.getStringUtils().objectToString(AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().optObjectFromJSONObject(optJSONObjectFromJSONObject, str2, AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().createJSONObject())));
                }
                sLJSExceptionEventInfo.setContext(RTSMap);
                sLJSExceptionEventInfo.setError_ts(Float64.INSTANCE.toInt64(Date.INSTANCE.now_v2()));
                this.doReportJSException(sLJSExceptionEventInfo, null);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportLynxJSException$default(SLAnnieXMonitor sLAnnieXMonitor, SLLynxJSExceptionParams sLLynxJSExceptionParams, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportLynxJSException");
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        sLAnnieXMonitor.reportLynxJSException(sLLynxJSExceptionParams, function1);
    }

    public void reportLynxJSException(final SLLynxJSExceptionParams errorParams, final Function1<? super Map<String, Object>, Unit> callback) {
        Intrinsics.checkNotNullParameter(errorParams, "errorParams");
        TaskRunner.INSTANCE.getInstance().runTaskOnMonitorThread(new Function1<Boolean, Unit>() { // from class: com.bytedance.salamander.anniex.SLAnnieXMonitor$reportLynxJSException$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                NativeInfo nativeInfo = new NativeInfo();
                SLJSExceptionEventInfo sLJSExceptionEventInfo = new SLJSExceptionEventInfo();
                String errorMsg = SLLynxJSExceptionParams.this.getErrorMsg();
                nativeInfo.setError_msg(errorMsg);
                JSONObject createJSONObject = AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().createJSONObject(errorMsg);
                String optStringFromJSONObject = AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().optStringFromJSONObject(createJSONObject, "root_cause", "");
                if (optStringFromJSONObject.length() > 0) {
                    sLJSExceptionEventInfo.setRoot_cause(optStringFromJSONObject);
                }
                JSONObject optJSONObjectFromJSONObject = AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().optJSONObjectFromJSONObject(createJSONObject, "context", AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().createJSONObject());
                Map<String, String> RTSMap = RTSMapKt.RTSMap();
                ArrayList<String> jSONObjectKeys = AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().getJSONObjectKeys(optJSONObjectFromJSONObject);
                for (int i = 0; i < RTSArrayKt.getLength(jSONObjectKeys); i++) {
                    String str = jSONObjectKeys.get(i);
                    Intrinsics.checkNotNullExpressionValue(str, "contextKeys[i]");
                    String str2 = str;
                    RTSMapKt.set(RTSMap, str2, AnniexMonitorUtilsStringUtilsKt.getStringUtils().objectToString(AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().optObjectFromJSONObject(optJSONObjectFromJSONObject, str2, AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().createJSONObject())));
                }
                sLJSExceptionEventInfo.setContext(RTSMap);
                int errorCode = SLLynxJSExceptionParams.this.getErrorCode();
                nativeInfo.setError_code(201);
                if (errorCode == 1101) {
                    nativeInfo.setError_code(1101);
                }
                sLJSExceptionEventInfo.setNative_info(nativeInfo);
                sLJSExceptionEventInfo.setError_ts(Float64.INSTANCE.toInt64(Date.INSTANCE.now_v2()));
                this.doReportJSException(sLJSExceptionEventInfo, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doReportJSException(SLJSExceptionEventInfo jsExceptionEventInfo, Function1<? super Map<String, Object>, Unit> callback) {
        Map RTSMap = RTSMapKt.RTSMap();
        RTSMapKt.set(RTSMap, "errorCode", -1);
        RTSMapKt.set(RTSMap, "errorMessage", CDNLoader.PIPELINE_STATUS_FAILED);
        if (!checkSwitch(SLEventType.JS_EXCEPTION)) {
            debugLog("reportJSException: monitor is disabled. session_id: " + this.containerBase.getNavigation_id());
            RTSMapKt.set(RTSMap, "errorMessage", "monitor is disabled");
            if (callback != null) {
                callback.invoke(RTSMap);
            }
        }
        if (this.engineType == ContainerType.Lynx) {
            NativeInfo native_info = jsExceptionEventInfo.getNative_info();
            if ((native_info != null ? native_info.getError_msg() : null) == null) {
                RTSMapKt.set(RTSMap, "errorCode", -3);
                RTSMapKt.set(RTSMap, "errorMessage", "data can not be empty");
                if (callback != null) {
                    callback.invoke(RTSMap);
                    return;
                }
                return;
            }
        }
        if (this.engineType == ContainerType.Web) {
            JsInfo js_info = jsExceptionEventInfo.getJs_info();
            if ((js_info != null ? js_info.getException() : null) == null) {
                RTSMapKt.set(RTSMap, "errorCode", -3);
                RTSMapKt.set(RTSMap, "errorMessage", "rawMessage can not be empty");
                if (callback != null) {
                    callback.invoke(RTSMap);
                    return;
                }
                return;
            }
        }
        JsInfo js_info2 = jsExceptionEventInfo.getJs_info();
        if ((js_info2 != null ? js_info2.getException() : null) != null) {
            JsInfo js_info3 = jsExceptionEventInfo.getJs_info();
            String exception = js_info3 != null ? js_info3.getException() : null;
            Intrinsics.checkNotNull(exception);
            ValidationResult<String> doValidation = AnniexMonitorCoreValidatorKt.getStringFieldValidator().doValidation("js_exception_js_info_exception", exception);
            if (doValidation.isInvalidInput()) {
                RTSMapKt.set(RTSMap, "errorCode", Long.valueOf(doValidation.getCode()));
                RTSMapKt.set(RTSMap, "errorMessage", "JSON.string(rawMessage) length must <= " + doValidation.getFieldLength());
                if (callback != null) {
                    callback.invoke(RTSMap);
                }
                if (callback != null) {
                    return;
                }
                if (doValidation.getValue() != null) {
                    JsInfo js_info4 = jsExceptionEventInfo.getJs_info();
                    Intrinsics.checkNotNull(js_info4);
                    String value = doValidation.getValue();
                    Intrinsics.checkNotNull(value);
                    js_info4.setException(value);
                }
            }
        }
        NativeInfo native_info2 = jsExceptionEventInfo.getNative_info();
        if ((native_info2 != null ? native_info2.getError_msg() : null) != null) {
            NativeInfo native_info3 = jsExceptionEventInfo.getNative_info();
            String error_msg = native_info3 != null ? native_info3.getError_msg() : null;
            Intrinsics.checkNotNull(error_msg);
            ValidationResult<String> doValidation2 = AnniexMonitorCoreValidatorKt.getStringFieldValidator().doValidation("js_exception_native_info_error_msg", error_msg);
            if (doValidation2.isInvalidInput()) {
                RTSMapKt.set(RTSMap, "errorCode", Long.valueOf(doValidation2.getCode()));
                RTSMapKt.set(RTSMap, "errorMessage", "JSON.stringify(data).length must <= " + doValidation2.getFieldLength());
                if (callback != null) {
                    callback.invoke(RTSMap);
                }
                if (callback != null) {
                    return;
                }
                if (doValidation2.getValue() != null) {
                    NativeInfo native_info4 = jsExceptionEventInfo.getNative_info();
                    Intrinsics.checkNotNull(native_info4);
                    String value2 = doValidation2.getValue();
                    Intrinsics.checkNotNull(value2);
                    native_info4.setError_msg(value2);
                }
            }
        }
        if (jsExceptionEventInfo.getRoot_cause() != null) {
            StringLengthValidator stringFieldValidator = AnniexMonitorCoreValidatorKt.getStringFieldValidator();
            String root_cause = jsExceptionEventInfo.getRoot_cause();
            Intrinsics.checkNotNull(root_cause);
            ValidationResult<String> doValidation3 = stringFieldValidator.doValidation("js_exception_root_cause", root_cause);
            if (doValidation3.isInvalidInput()) {
                RTSMapKt.set(RTSMap, "errorCode", Long.valueOf(doValidation3.getCode()));
                RTSMapKt.set(RTSMap, "errorMessage", "root_cause.length must < " + doValidation3.getFieldLength());
                if (callback != null) {
                    callback.invoke(RTSMap);
                }
                if (callback != null) {
                    return;
                }
                if (doValidation3.getValue() != null) {
                    String value3 = doValidation3.getValue();
                    Intrinsics.checkNotNull(value3);
                    jsExceptionEventInfo.setRoot_cause(value3);
                }
            }
        }
        if (jsExceptionEventInfo.getContext() != null) {
            Map<String, String> context = jsExceptionEventInfo.getContext();
            Intrinsics.checkNotNull(context);
            Intrinsics.checkNotNull(context);
            if (RTSArrayKt.getLength(RTSMapKt.keys(context)) > 20) {
                RTSMapKt.set(RTSMap, "errorCode", -3);
                RTSMapKt.set(RTSMap, "errorMessage", "size of property in context must <= 20");
                if (callback != null) {
                    callback.invoke(RTSMap);
                }
                if (callback != null) {
                    return;
                }
            }
            ArrayList keys = RTSMapKt.keys(context);
            for (int i = 0; i < RTSArrayKt.getLength(keys); i++) {
                Object obj = keys.get(i);
                Intrinsics.checkNotNullExpressionValue(obj, "keys[i]");
                String str = (String) obj;
                String str2 = context.get(str);
                ValidationResult<String> doValidation4 = AnniexMonitorCoreValidatorKt.getStringFieldValidator().doValidation("js_base_context_key", str);
                if (doValidation4.isInvalidInput()) {
                    RTSMapKt.set(RTSMap, "errorCode", Long.valueOf(doValidation4.getCode()));
                    RTSMapKt.set(RTSMap, "errorMessage", "property with the longest key in the context must <= " + doValidation4.getFieldLength());
                    if (callback != null) {
                        callback.invoke(RTSMap);
                    }
                    if (callback != null) {
                        return;
                    }
                }
                StringLengthValidator stringFieldValidator2 = AnniexMonitorCoreValidatorKt.getStringFieldValidator();
                Intrinsics.checkNotNull(str2);
                ValidationResult<String> doValidation5 = stringFieldValidator2.doValidation("js_base_context_value", str2);
                if (doValidation5.isInvalidInput()) {
                    RTSMapKt.set(RTSMap, "errorCode", Long.valueOf(doValidation5.getCode()));
                    RTSMapKt.set(RTSMap, "errorMessage", "property with the longest value in the context must <= " + doValidation5.getFieldLength());
                    if (callback != null) {
                        callback.invoke(RTSMap);
                    }
                    if (callback != null) {
                        return;
                    }
                }
            }
        }
        final SLJSExceptionEvent sLJSExceptionEvent = new SLJSExceptionEvent();
        sLJSExceptionEvent.setEvent_info(jsExceptionEventInfo);
        assembleDataPreHandler(sLJSExceptionEvent, new Function0<Unit>() { // from class: com.bytedance.salamander.anniex.SLAnnieXMonitor$doReportJSException$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m840invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m840invoke() {
                AnniexMonitorReportAPMKt.getApmReporter().report(SLJSExceptionEvent.this.eventType(), AnniexMonitorUtilsEventToMapKt.jsExceptionEventInfoToMap(SLJSExceptionEvent.this));
            }
        });
        RTSMapKt.set(RTSMap, "errorCode", 1);
        RTSMapKt.set(RTSMap, "errorMessage", "Success");
        if (callback != null) {
            callback.invoke(RTSMap);
        }
    }

    public void reportFetchError(final SLFetchErrorEventInfo fetchErrorEventInfo) {
        Intrinsics.checkNotNullParameter(fetchErrorEventInfo, "fetchErrorEventInfo");
        TaskRunner.INSTANCE.getInstance().runTaskOnMonitorThread(new Function1<Boolean, Unit>() { // from class: com.bytedance.salamander.anniex.SLAnnieXMonitor$reportFetchError$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                SLAnnieXMonitor.this.doReportFetchError(fetchErrorEventInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doReportFetchError(SLFetchErrorEventInfo fetchErrorEventInfo) {
        if (!checkSwitch(SLEventType.FETCH_ERROR)) {
            debugLog("reportFetchError: monitor is disabled. session_id: " + this.containerBase.getNavigation_id());
            return;
        }
        final SLFetchErrorEvent sLFetchErrorEvent = new SLFetchErrorEvent();
        sLFetchErrorEvent.setEvent_info(fetchErrorEventInfo);
        assembleDataPreHandler(sLFetchErrorEvent, new Function0<Unit>() { // from class: com.bytedance.salamander.anniex.SLAnnieXMonitor$doReportFetchError$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m837invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m837invoke() {
                AnniexMonitorReportAPMKt.getApmReporter().report(SLFetchErrorEvent.this.eventType(), AnniexMonitorUtilsEventToMapKt.fetchErrorEventInfoToMap(SLFetchErrorEvent.this));
            }
        });
    }

    private final boolean enableMonitor() {
        return SLAnnieXMonitorManager.INSTANCE.getInstance().getSlMonitorHostSwitch() && Switches.INSTANCE.getMonitor().isEnabled();
    }

    private final void debugLog(String msg) {
        AnniexMonitorFoundationImplALogImplKt.getALogImpl().mo360d("SLAnnieXMonitor", msg);
    }

    private final void assembleDataPreHandler(SLEvent event, Function0<Unit> block) {
        event.setContainer_base(this.containerBase);
        event.setJs_base(this.jsBase);
        BidConfig determineBidConfig = determineBidConfig(this.containerBase.getBid());
        this.containerBase.get__internal().setHit_sample(determineBidConfig.getHitSample());
        this.containerBase.get__internal().setSetting_id(determineBidConfig.getSettingId());
        this.containerBase.get__internal().setSetting_bid(determineBidConfig.getBid());
        if (hitSample(event, determineBidConfig)) {
            block.invoke();
            return;
        }
        String str = " bid: " + this.containerBase.getBid();
        String str2 = " session_id: " + this.containerBase.getNavigation_id();
        debugLog("assembleDataPreHandler: hitSample is false" + (" event_type: " + AnniexMonitorEventTypingsEventKt.eventTypeToString(event.eventType())) + str + str2 + (" schema: " + this.containerBase.getSchema()));
        ArrayList<ISLMonitorReportListener> reportListeners = SLAnnieXMonitorManager.INSTANCE.getInstance().getReportListeners();
        if (RTSArrayKt.getLength(reportListeners) > 0) {
            String eventTypeToString = AnniexMonitorEventTypingsEventKt.eventTypeToString(event.eventType());
            Map<String, Object> eventToMap = AnniexMonitorUtilsEventToMapKt.eventToMap(event);
            Iterator<T> it = reportListeners.iterator();
            while (it.hasNext()) {
                ((ISLMonitorReportListener) it.next()).onEventReport(eventTypeToString, eventToMap, "event_sampled");
            }
        }
    }

    private final BidConfig determineBidConfig(String bid) {
        return HybridSettings.INSTANCE.safeGetHybridSettingsResponse().getBidInfo().get(bid);
    }

    private final boolean hitSample(SLEvent event, BidConfig bidConfig) {
        int i = WhenMappings.$EnumSwitchMapping$1[event.getContainer_base().getContainer_type().ordinal()];
        if (i == 1) {
            return AnniexMonitorUtilsHybridSettingsConvertKt.isSampleForLynx(event.eventType(), bidConfig);
        }
        if (i != 2) {
            return false;
        }
        return AnniexMonitorUtilsHybridSettingsConvertKt.isSampleForWebSample(event.eventType(), bidConfig);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x003c, code lost:
    
        r4 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean checkSwitch(SLEventType eventType) {
        boolean isEnabled;
        int i = WhenMappings.$EnumSwitchMapping$2[eventType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    isEnabled = this.engineType != ContainerType.Lynx ? false : false;
                } else if (i != 4) {
                    if (i == 5) {
                        if (this.engineType == ContainerType.Lynx) {
                        }
                    }
                } else if (this.engineType == ContainerType.Lynx) {
                    isEnabled = Switches.INSTANCE.getLynxMonitor().isEnabled();
                } else {
                    isEnabled = Switches.INSTANCE.getWebMonitor().isEnabled();
                }
            } else if (this.engineType != ContainerType.Lynx) {
            }
        } else if (this.engineType == ContainerType.Lynx) {
            isEnabled = Switches.INSTANCE.getLynxMonitor().isEnabled();
        } else {
            isEnabled = Switches.INSTANCE.getWebMonitor().isEnabled();
        }
        return SLAnnieXMonitorManager.INSTANCE.getInstance().getSlMonitorHostSwitch() && Switches.INSTANCE.getMonitor().isEnabled() && isEnabled;
    }

    private final void updateFields(Map<String, String> map) {
        if (RTSMapKt.has(map, "bid")) {
            StringLengthValidator stringFieldValidator = AnniexMonitorCoreValidatorKt.getStringFieldValidator();
            String str = map.get("bid");
            Intrinsics.checkNotNull(str);
            String validatedField = stringFieldValidator.getValidatedField("bid", str);
            if (validatedField != null) {
                this.containerBase.setBid(validatedField);
            }
            this.containerBase.setBid_source(BidSource.Schema);
        }
        if (RTSMapKt.has(map, LynxMonitorService.KEY_PID)) {
            StringLengthValidator stringFieldValidator2 = AnniexMonitorCoreValidatorKt.getStringFieldValidator();
            String str2 = map.get(LynxMonitorService.KEY_PID);
            Intrinsics.checkNotNull(str2);
            String validatedField2 = stringFieldValidator2.getValidatedField(LynxMonitorService.KEY_PID, str2);
            if (validatedField2 != null) {
                this.containerBase.setPid(validatedField2);
            }
        }
    }

    private final void resetNavigation() {
        this.jsBase = new JsBase();
        this.containerBase.setNavigation_id(AnniexMonitorFoundationImplUUIDUtilsKt.getUUIDUtils().generateUUID());
        this.containerBase.setContainer_reuse(true);
    }
}
