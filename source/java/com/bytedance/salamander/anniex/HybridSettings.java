package com.bytedance.salamander.anniex;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* compiled from: AnniexMonitorSettingsHybridSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/salamander/anniex/HybridSettings;", "", "()V", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class HybridSettings {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static String cacheKey = "sl_monitor_hybrid_settings";
    private static HybridSettingsResponse hybridSettingsResponse;
    private static String originSettingsData;

    /* compiled from: AnniexMonitorSettingsHybridSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\u0017\u001a\u00020\u00132\n\u0010\u0018\u001a\u00060\u0019j\u0002`\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/salamander/anniex/HybridSettings$Companion;", "", "()V", "cacheKey", "", "getCacheKey", "()Ljava/lang/String;", "setCacheKey", "(Ljava/lang/String;)V", "hybridSettingsResponse", "Lcom/bytedance/salamander/anniex/HybridSettingsResponse;", "getHybridSettingsResponse", "()Lcom/bytedance/salamander/anniex/HybridSettingsResponse;", "setHybridSettingsResponse", "(Lcom/bytedance/salamander/anniex/HybridSettingsResponse;)V", "originSettingsData", "getOriginSettingsData", "setOriginSettingsData", "fetchSettings", "", "config", "Lcom/bytedance/salamander/anniex/SLHybridSettingsConfig;", "getSettingData", "parseSettingsWithV2JSONSettings", "jsonSettings", "Lorg/json/JSONObject;", "Lcom/bytedance/salamander/anniex/AnnieXJSONObject;", "parseSettingsWithV2Response", "settingsString", "safeGetHybridSettingsResponse", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public void fetchSettings(SLHybridSettingsConfig config) {
            Intrinsics.checkNotNullParameter(config, "config");
        }

        private Companion() {
        }

        public String getCacheKey() {
            return HybridSettings.cacheKey;
        }

        public void setCacheKey(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            HybridSettings.cacheKey = str;
        }

        public HybridSettingsResponse getHybridSettingsResponse() {
            return HybridSettings.hybridSettingsResponse;
        }

        public void setHybridSettingsResponse(HybridSettingsResponse hybridSettingsResponse) {
            HybridSettings.hybridSettingsResponse = hybridSettingsResponse;
        }

        public String getOriginSettingsData() {
            return HybridSettings.originSettingsData;
        }

        public void setOriginSettingsData(String str) {
            HybridSettings.originSettingsData = str;
        }

        public void parseSettingsWithV2Response(final String settingsString) {
            Intrinsics.checkNotNullParameter(settingsString, "settingsString");
            if (!SLAnnieXMonitorManager.INSTANCE.getInstance().getSlMonitorHostSwitch()) {
                AnniexMonitorFoundationImplALogImplKt.getALogImpl().mo362i("HybridSettings", "disable parseSettingsWithV2Response");
                return;
            }
            HybridSettings.INSTANCE.setOriginSettingsData(settingsString);
            TaskRunner.INSTANCE.getInstance().runTaskOnMonitorThread(new Function1<Boolean, Unit>() { // from class: com.bytedance.salamander.anniex.HybridSettings$Companion$parseSettingsWithV2Response$task$1
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
                    HybridSettings.INSTANCE.setHybridSettingsResponse(AnniexMonitorUtilsHybridSettingsConvertKt.convertJSONSettings(AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().createJSONObject(settingsString)));
                    AnniexMonitorFoundationImplStorageImplKt.getStorageImpl().putString(HybridSettings.INSTANCE.getCacheKey(), settingsString);
                    AnniexMonitorFoundationImplALogImplKt.getALogImpl().mo360d("HybridSettings", "async parseSettingsWithV2Response: " + settingsString);
                }
            });
        }

        public void parseSettingsWithV2JSONSettings(final JSONObject jsonSettings) {
            Intrinsics.checkNotNullParameter(jsonSettings, "jsonSettings");
            if (!SLAnnieXMonitorManager.INSTANCE.getInstance().getSlMonitorHostSwitch()) {
                AnniexMonitorFoundationImplALogImplKt.getALogImpl().mo362i("HybridSettings", "parse disabled due to salmander monitor disabled");
            } else {
                TaskRunner.INSTANCE.getInstance().runTaskOnMonitorThread(new Function1<Boolean, Unit>() { // from class: com.bytedance.salamander.anniex.HybridSettings$Companion$parseSettingsWithV2JSONSettings$task$1
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
                        AnnieXJSONUtils jSONUtils = AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils();
                        JSONObject jSONObject = jsonSettings;
                        Intrinsics.checkNotNull(jSONObject, "null cannot be cast to non-null type kotlin.Any");
                        String convertMapToJSONString = jSONUtils.convertMapToJSONString(TypeIntrinsics.asMutableMap(jSONObject));
                        HybridSettings.INSTANCE.setOriginSettingsData(convertMapToJSONString);
                        HybridSettings.INSTANCE.setHybridSettingsResponse(AnniexMonitorUtilsHybridSettingsConvertKt.convertJSONSettings(jsonSettings));
                        AnniexMonitorFoundationImplStorageImplKt.getStorageImpl().putString(HybridSettings.INSTANCE.getCacheKey(), convertMapToJSONString);
                        AnniexMonitorFoundationImplALogImplKt.getALogImpl().mo360d("HybridSettings", "async parseSettingsWithV2Response: " + convertMapToJSONString);
                    }
                });
            }
        }

        public String getSettingData() {
            return HybridSettings.INSTANCE.getOriginSettingsData();
        }

        public HybridSettingsResponse safeGetHybridSettingsResponse() {
            if (HybridSettings.INSTANCE.getHybridSettingsResponse() == null) {
                String string = AnniexMonitorFoundationImplStorageImplKt.getStorageImpl().getString(HybridSettings.INSTANCE.getCacheKey(), "{}");
                if (string != null) {
                    JSONObject createJSONObject = AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().createJSONObject(string);
                    Intrinsics.checkNotNull(createJSONObject, "null cannot be cast to non-null type org.json.JSONObject{ com.bytedance.salamander.anniex.AnniexMonitorFoundationInterfaceBasicTypeKt.AnnieXJSONObject }");
                    HybridSettings.INSTANCE.setHybridSettingsResponse(AnniexMonitorUtilsHybridSettingsConvertKt.convertJSONSettings(createJSONObject));
                } else {
                    HybridSettings.INSTANCE.setHybridSettingsResponse(new HybridSettingsResponse());
                }
            }
            HybridSettingsResponse hybridSettingsResponse = HybridSettings.INSTANCE.getHybridSettingsResponse();
            Intrinsics.checkNotNull(hybridSettingsResponse);
            return hybridSettingsResponse;
        }
    }
}
