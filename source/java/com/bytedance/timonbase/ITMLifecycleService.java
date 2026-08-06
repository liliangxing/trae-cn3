package com.bytedance.timonbase;

import android.app.Application;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.timonbase.config.TMConfigService;
import com.bytedance.timonbase.utils.EnumUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;

/* compiled from: ITMLifecycleService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J:\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\b\u0010\u0014\u001a\u00020\u0007H&J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0007H&J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/timonbase/ITMLifecycleService;", "", "configKey", "", "defaultWorkType", "Lcom/bytedance/timonbase/utils/EnumUtils$WorkType;", "delayAsyncInit", "", "enable", "", "init", "appId", "", "channelId", "deviceIdGetter", "Lkotlin/Function0;", "context", "Landroid/app/Application;", "initExtra", "Lcom/bytedance/timonbase/TMInitialExtra;", "onConfigUpdate", "priority", "Lcom/bytedance/timonbase/utils/EnumUtils$Priority;", "release", DBData.FIELD_TYPE, "updateInitConfig", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface ITMLifecycleService {
    String configKey();

    EnumUtils.WorkType defaultWorkType();

    void delayAsyncInit();

    boolean enable();

    void init(int appId, String channelId, Function0<String> deviceIdGetter, Application context, TMInitialExtra initExtra);

    void onConfigUpdate();

    EnumUtils.Priority priority();

    void release();

    EnumUtils.WorkType type();

    void updateInitConfig();

    /* compiled from: ITMLifecycleService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class DefaultImpls {
        public static void delayAsyncInit(ITMLifecycleService iTMLifecycleService) {
        }

        public static void updateInitConfig(ITMLifecycleService iTMLifecycleService) {
        }

        public static /* synthetic */ void init$default(ITMLifecycleService iTMLifecycleService, int i, String str, Function0 function0, Application application, TMInitialExtra tMInitialExtra, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
            }
            if ((i2 & 16) != 0) {
                tMInitialExtra = null;
            }
            iTMLifecycleService.init(i, str, function0, application, tMInitialExtra);
        }

        public static boolean enable(ITMLifecycleService iTMLifecycleService) {
            JsonObject configJson;
            JsonElement jsonElement;
            if (TMEnv.INSTANCE.isInitOpt() || (configJson = TMConfigService.INSTANCE.getConfigJson(iTMLifecycleService.configKey())) == null || (jsonElement = configJson.get("enable")) == null) {
                return true;
            }
            return jsonElement.getAsBoolean();
        }

        public static EnumUtils.Priority priority(ITMLifecycleService iTMLifecycleService) {
            return EnumUtils.Priority.MIDDLE;
        }

        public static EnumUtils.WorkType defaultWorkType(ITMLifecycleService iTMLifecycleService) {
            return EnumUtils.WorkType.BACKGROUND;
        }

        public static EnumUtils.WorkType type(ITMLifecycleService iTMLifecycleService) {
            JsonPrimitive jsonPrimitive;
            JsonObject configJson = TMConfigService.INSTANCE.getConfigJson(iTMLifecycleService.configKey());
            if (configJson == null || (jsonPrimitive = configJson.get("work_type")) == null) {
                return iTMLifecycleService.defaultWorkType();
            }
            if (jsonPrimitive.isJsonPrimitive()) {
                if (jsonPrimitive == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.google.gson.JsonPrimitive");
                }
                JsonPrimitive jsonPrimitive2 = jsonPrimitive;
                if (jsonPrimitive2.isNumber()) {
                    int asInt = jsonPrimitive2.getAsInt();
                    return asInt == EnumUtils.WorkType.MAIN.getValue() ? EnumUtils.WorkType.MAIN : asInt == EnumUtils.WorkType.BACKGROUND.getValue() ? EnumUtils.WorkType.BACKGROUND : iTMLifecycleService.defaultWorkType();
                }
            }
            return iTMLifecycleService.defaultWorkType();
        }
    }
}
