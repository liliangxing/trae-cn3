package com.bytedance.ies.bullet.forest;

import com.bytedance.ies.bullet.base.settings.ForestSettingsConfig;
import com.bytedance.ies.bullet.kit.resourceloader.loader.LoaderUtil;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.schema.ISchemaMutableData;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.SchemaInterceptor;
import com.bytedance.ies.bullet.service.sdk.param.IntegerParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForestSchemaConverter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0017J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/forest/ForestSchemaConverter;", "Lcom/bytedance/ies/bullet/service/sdk/SchemaInterceptor;", "()V", "name", "", "getName", "()Ljava/lang/String;", "convert", "", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaMutableData;", "convertBufferMode", "", "convertPreloadCacheControl", "convertSSRPreload", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ForestSchemaConverter extends SchemaInterceptor {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String PRELOAD_TYPE_MAIN_SSR = "main_ssr";

    @Override // com.bytedance.ies.bullet.service.sdk.SchemaInterceptor, com.bytedance.ies.bullet.service.schema.ISchemaInterceptor
    public String getName() {
        return "forest";
    }

    /* compiled from: ForestSchemaConverter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/bullet/forest/ForestSchemaConverter$Companion;", "", "()V", "PRELOAD_TYPE_MAIN_SSR", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.bytedance.ies.bullet.service.sdk.SchemaInterceptor, com.bytedance.ies.bullet.service.schema.ISchemaInterceptor
    public boolean convert(ISchemaMutableData schemaData) {
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        convertSSRPreload(schemaData);
        convertPreloadCacheControl(schemaData);
        convertBufferMode(schemaData);
        return true;
    }

    private final void convertSSRPreload(ISchemaMutableData schemaData) {
        Map<String, String> queryItems = schemaData.getQueryItems();
        if (!Intrinsics.areEqual(queryItems.get("enable_preload"), PRELOAD_TYPE_MAIN_SSR)) {
            queryItems = null;
        }
        if (queryItems != null) {
            schemaData.addParam(SchemaConstants.LOADER_NAME, new StringParam("forest"), false);
            schemaData.addParam("streaming_load", new IntegerParam(1), false);
            schemaData.addParam("enable_preload", new StringParam("main"), true);
        }
        Map<String, String> queryItems2 = schemaData.getQueryItems();
        String str = queryItems2.get("enable_preload");
        if (str == null) {
            str = ForestLoader.PRELOAD_SCOPE_DISABLE;
        }
        if (!(!Intrinsics.areEqual(str, ForestLoader.PRELOAD_SCOPE_DISABLE))) {
            queryItems2 = null;
        }
        if (queryItems2 != null) {
            if ((Intrinsics.areEqual(queryItems2.get(SchemaConstants.QUERY_KEY_APPEND_COMMON_PARAMS), "1") || LoaderUtil.INSTANCE.isNotNullOrEmpty(queryItems2.get(SchemaConstants.APPEND_GLOBAL_PROPS)) ? queryItems2 : null) != null) {
                schemaData.addParam("delay_preload", new IntegerParam(1), false);
            }
        }
    }

    private final void convertPreloadCacheControl(ISchemaMutableData schemaData) {
        String str = schemaData.getQueryItems().get("enable_preload");
        if (str != null) {
            if (!(str.length() > 0)) {
                str = null;
            }
            if (str != null) {
                if ((Intrinsics.areEqual(str, ForestLoader.PRELOAD_SCOPE_DISABLE) ^ true ? str : null) != null) {
                    schemaData.addParam("forest_max_age", new IntegerParam(5), false);
                }
            }
        }
    }

    private final void convertBufferMode(ISchemaMutableData schemaData) {
        ForestSettingsConfig forestSettingsConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (forestSettingsConfig = (ForestSettingsConfig) iBulletSettingsService.obtainSettings(ForestSettingsConfig.class)) == null || !Intrinsics.areEqual(schemaData.getQueryItems().get(SchemaConstants.LOADER_NAME), "forest")) {
            return;
        }
        String bufferMode = forestSettingsConfig.getBufferMode();
        if (!Intrinsics.areEqual(bufferMode, "concurrent")) {
            bufferMode = null;
        }
        if (bufferMode != null) {
            schemaData.addParam("forest_buffer_mode", new StringParam(bufferMode), false);
        }
    }
}
