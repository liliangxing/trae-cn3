package com.bytedance.lynx.service.trail;

import android.net.Uri;
import com.bytedance.lynx.service.trace.TraceEventDef;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.utils.LynxViewBuilderProperty;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: LynxViewConfigProcessor.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ$\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/lynx/service/trail/LynxViewConfigProcessor;", "", "()V", "AUTO_CONCURRENCY", "", "ENABLE_JS_GROUP_THREAD", "ENABLE_MTS_MODULE", "ENABLE_UNIFIED_PIPELINE", "parseLynxViewBuilder", "", "builder", "Lcom/lynx/tasm/LynxViewBuilder;", "setConfig", "key", "value", "toBoolOrNull", "", "(Ljava/lang/String;)Ljava/lang/Boolean;", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxViewConfigProcessor {
    public static final String AUTO_CONCURRENCY = "auto_concurrency";
    public static final String ENABLE_JS_GROUP_THREAD = "enable_js_group_thread";
    public static final String ENABLE_MTS_MODULE = "enable_mts_module";
    public static final String ENABLE_UNIFIED_PIPELINE = "enable_unified_pipeline";
    public static final LynxViewConfigProcessor INSTANCE = new LynxViewConfigProcessor();

    private LynxViewConfigProcessor() {
    }

    public final void parseLynxViewBuilder(LynxViewBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Uri uri = builder.getUri();
        if (uri != null) {
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            Intrinsics.checkNotNullExpressionValue(queryParameterNames, "queryParameterNames");
            for (String str : queryParameterNames) {
                INSTANCE.setConfig(str, uri.getQueryParameter(str), builder);
            }
        }
        Map lynxViewConfig = builder.getLynxViewConfig();
        if (lynxViewConfig != null) {
            TraceEvent.beginSection(TraceEventDef.LYNX_VIEW_CONFIG_PROCESSOR_SET_CONFIG, lynxViewConfig);
            for (Map.Entry entry : lynxViewConfig.entrySet()) {
                INSTANCE.setConfig((String) entry.getKey(), (String) entry.getValue(), builder);
            }
            TraceEvent.endSection(TraceEventDef.LYNX_VIEW_CONFIG_PROCESSOR_SET_CONFIG);
        }
    }

    private final void setConfig(String key, String value, LynxViewBuilder builder) {
        Boolean boolOrNull;
        if (key == null || value == null) {
            return;
        }
        if (Intrinsics.areEqual(key, LynxViewBuilderProperty.PLATFORM_CONFIG.getKey())) {
            builder.insertLynxViewConfig(key, value);
            return;
        }
        if (Intrinsics.areEqual(key, ENABLE_UNIFIED_PIPELINE)) {
            Boolean boolOrNull2 = toBoolOrNull(value);
            if (boolOrNull2 != null) {
                builder.setEnableUnifiedPipeline(boolOrNull2.booleanValue());
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(key, ENABLE_JS_GROUP_THREAD)) {
            Boolean boolOrNull3 = toBoolOrNull(value);
            if (boolOrNull3 != null) {
                boolean booleanValue = boolOrNull3.booleanValue();
                LynxGroup lynxGroup = builder.getLynxGroup();
                if (lynxGroup == null) {
                    lynxGroup = new LynxGroup.LynxGroupBuilder().build();
                }
                lynxGroup.setEnableJSGroupThread(booleanValue);
                builder.setLynxGroup(lynxGroup);
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(key, ENABLE_MTS_MODULE) || (boolOrNull = toBoolOrNull(value)) == null) {
            return;
        }
        builder.setEnableMTSModule(boolOrNull.booleanValue());
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
    
        if (r3.equals("false") == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005e, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
    
        if (r3.equals(com.bytedance.ies.bullet.service.router.RouterConstants.TRUE) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0046, code lost:
    
        if (r3.equals("1") == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0055, code lost:
    
        if (r3.equals(com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge.INVISIBLE) == false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Boolean toBoolOrNull(String value) {
        String lowerCase = StringsKt.trim(value).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        int hashCode = lowerCase.hashCode();
        if (hashCode != 48) {
            if (hashCode != 49) {
                if (hashCode != 3569038) {
                    if (hashCode == 97196323) {
                    }
                }
                return null;
            }
        }
    }
}
