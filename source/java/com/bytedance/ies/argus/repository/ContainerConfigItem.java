package com.bytedance.ies.argus.repository;

import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.ies.argus.api.interfaces.ArgusInitConfig;
import com.bytedance.ies.argus.base.ArgusLog;
import com.bytedance.ies.argus.bean.ArgusContainerAspect;
import com.bytedance.ies.argus.bean.ArgusGlobalAspect;
import com.bytedance.ies.argus.bean.ArgusLynxViewAspect;
import com.bytedance.ies.argus.bean.ArgusWebViewAspect;
import com.bytedance.ies.argus.bean.AspectConfigItem;
import com.bytedance.ies.argus.bean.BasicConfigModel;
import com.bytedance.ies.argus.bean.IArgusAspect;
import com.bytedance.ies.argus.bean.IEnumClass;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ContainerConfigProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0014B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0004\u001a\u00020\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/argus/repository/ContainerConfigItem;", "", "secCId", "", "aspect", "Lcom/bytedance/ies/argus/bean/BasicConfigModel;", "strategyConf", "plugin", "(Ljava/lang/String;Lcom/bytedance/ies/argus/bean/BasicConfigModel;Lcom/bytedance/ies/argus/bean/BasicConfigModel;Lcom/bytedance/ies/argus/bean/BasicConfigModel;)V", "getAspect", "()Lcom/bytedance/ies/argus/bean/BasicConfigModel;", "aspectConfigMap", "", "Lcom/bytedance/ies/argus/bean/IArgusAspect;", "Lcom/bytedance/ies/argus/bean/AspectConfigItem;", "getPlugin", "getSecCId", "()Ljava/lang/String;", "getStrategyConf", "getAspectRules", "Builder", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ContainerConfigItem {
    private final BasicConfigModel aspect;
    private Map<IArgusAspect, AspectConfigItem> aspectConfigMap;
    private final BasicConfigModel plugin;
    private final String secCId;
    private final BasicConfigModel strategyConf;

    public ContainerConfigItem(String str, BasicConfigModel basicConfigModel, BasicConfigModel basicConfigModel2, BasicConfigModel basicConfigModel3) {
        ArgusGlobalAspect argusGlobalAspect;
        ArgusContainerAspect argusContainerAspect;
        AspectConfigItem build;
        ArgusWebViewAspect argusWebViewAspect;
        ArgusLynxViewAspect argusLynxViewAspect;
        Intrinsics.checkNotNullParameter(str, "secCId");
        Intrinsics.checkNotNullParameter(basicConfigModel, "aspect");
        Intrinsics.checkNotNullParameter(basicConfigModel2, "strategyConf");
        Intrinsics.checkNotNullParameter(basicConfigModel3, "plugin");
        this.secCId = str;
        this.aspect = basicConfigModel;
        this.strategyConf = basicConfigModel2;
        this.plugin = basicConfigModel3;
        this.aspectConfigMap = MapsKt.emptyMap();
        if (basicConfigModel.getConf() != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<String> keys = basicConfigModel.getConf().keys();
            Intrinsics.checkNotNullExpressionValue(keys, "aspect.conf.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                IEnumClass.Companion companion = IEnumClass.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(next, "aspectName");
                ArgusContainerAspect[] values = ArgusContainerAspect.values();
                int length = values.length;
                int i = 0;
                int i2 = 0;
                while (true) {
                    argusGlobalAspect = null;
                    if (i2 >= length) {
                        argusContainerAspect = null;
                        break;
                    }
                    argusContainerAspect = values[i2];
                    if (Intrinsics.areEqual(argusContainerAspect.getStringValue(), next)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                ArgusGlobalAspect argusGlobalAspect2 = argusContainerAspect;
                if (argusGlobalAspect2 == null) {
                    IEnumClass.Companion companion2 = IEnumClass.INSTANCE;
                    ArgusWebViewAspect[] values2 = ArgusWebViewAspect.values();
                    int length2 = values2.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length2) {
                            argusWebViewAspect = null;
                            break;
                        }
                        argusWebViewAspect = values2[i3];
                        if (Intrinsics.areEqual(argusWebViewAspect.getStringValue(), next)) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    argusGlobalAspect2 = argusWebViewAspect;
                    if (argusGlobalAspect2 == null) {
                        IEnumClass.Companion companion3 = IEnumClass.INSTANCE;
                        ArgusLynxViewAspect[] values3 = ArgusLynxViewAspect.values();
                        int length3 = values3.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= length3) {
                                argusLynxViewAspect = null;
                                break;
                            }
                            argusLynxViewAspect = values3[i4];
                            if (Intrinsics.areEqual(argusLynxViewAspect.getStringValue(), next)) {
                                break;
                            } else {
                                i4++;
                            }
                        }
                        argusGlobalAspect2 = argusLynxViewAspect;
                        if (argusGlobalAspect2 == null) {
                            IEnumClass.Companion companion4 = IEnumClass.INSTANCE;
                            ArgusGlobalAspect[] values4 = ArgusGlobalAspect.values();
                            int length4 = values4.length;
                            while (true) {
                                if (i >= length4) {
                                    break;
                                }
                                ArgusGlobalAspect argusGlobalAspect3 = values4[i];
                                if (Intrinsics.areEqual(argusGlobalAspect3.getStringValue(), next)) {
                                    argusGlobalAspect = argusGlobalAspect3;
                                    break;
                                }
                                i++;
                            }
                            argusGlobalAspect2 = argusGlobalAspect;
                        }
                    }
                }
                if (argusGlobalAspect2 == null) {
                    ArgusLog.e$default(ArgusLog.INSTANCE, "ContainerConfigProvider", "aspect type not found: " + next, null, null, 12, null);
                } else {
                    JSONObject optJSONObject = this.aspect.getConf().optJSONObject(next);
                    if (optJSONObject != null && (build = new AspectConfigItem.Builder().build(optJSONObject)) != null) {
                        linkedHashMap.put(argusGlobalAspect2, build);
                    }
                }
            }
            this.aspectConfigMap = MapsKt.toMap(linkedHashMap);
        }
    }

    public final String getSecCId() {
        return this.secCId;
    }

    public final BasicConfigModel getAspect() {
        return this.aspect;
    }

    public final BasicConfigModel getStrategyConf() {
        return this.strategyConf;
    }

    public final BasicConfigModel getPlugin() {
        return this.plugin;
    }

    public final AspectConfigItem getAspectRules(IArgusAspect aspect) {
        Intrinsics.checkNotNullParameter(aspect, "aspect");
        return this.aspectConfigMap.get(aspect);
    }

    /* compiled from: ContainerConfigProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/argus/repository/ContainerConfigItem$Builder;", "", ReportConst.JSBConfigParam.ENV, "Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig$AppEnv;", "constConf", "Lorg/json/JSONObject;", "(Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig$AppEnv;Lorg/json/JSONObject;)V", "build", "Lcom/bytedance/ies/argus/repository/ContainerConfigItem;", "secCId", "", "newConfig", "baseConfig", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Builder {
        private final JSONObject constConf;
        private final ArgusInitConfig.AppEnv env;

        public Builder(ArgusInitConfig.AppEnv appEnv, JSONObject jSONObject) {
            this.env = appEnv;
            this.constConf = jSONObject;
        }

        public final ContainerConfigItem build(String secCId, JSONObject newConfig, JSONObject baseConfig) {
            Intrinsics.checkNotNullParameter(secCId, "secCId");
            if (newConfig == null) {
                return null;
            }
            BasicConfigModel.Builder builder = new BasicConfigModel.Builder();
            int optInt = newConfig.optInt("merge_mode");
            return new ContainerConfigItem(secCId, build$buildBasicConfig(builder, newConfig, baseConfig, "aspect", Integer.valueOf(optInt > 1 ? optInt + 1 : optInt)), build$buildBasicConfig(builder, newConfig, baseConfig, "strategy_conf", Integer.valueOf(optInt)), build$buildBasicConfig(builder, newConfig, baseConfig, "plugin", Integer.valueOf(optInt)));
        }

        private static final BasicConfigModel build$buildBasicConfig(BasicConfigModel.Builder builder, JSONObject jSONObject, JSONObject jSONObject2, String str, Integer num) {
            return builder.init(jSONObject.optJSONObject(str), jSONObject2 != null ? jSONObject2.optJSONObject(str) : null, num).getConfig();
        }
    }
}
