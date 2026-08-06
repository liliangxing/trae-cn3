package com.bytedance.android.anniex.lite.flow;

import android.app.Application;
import android.net.Uri;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.lite.base.IAnnieXLynxProcess;
import com.bytedance.android.anniex.lite.flow.base.FlowDispatchConfig;
import com.bytedance.android.anniex.lite.flow.web.AnnieXWebDispatchManagerKt;
import com.bytedance.android.anniex.lite.utils.AnnieXLiteUtilsKt;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.schema.utils.SchemaUtilsKt;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXFlow.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/AnnieXFlow;", "", "()V", "dispatchFlow", "", "application", "Landroid/app/Application;", "bid", StrategyConstants.SCHEMA, "Landroid/net/Uri;", "config", "Lcom/bytedance/android/anniex/lite/flow/base/FlowDispatchConfig;", "dispatchFlow$anniex_release", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXFlow {
    public static final AnnieXFlow INSTANCE = new AnnieXFlow();

    /* compiled from: AnnieXFlow.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KitType.values().length];
            try {
                iArr[KitType.WEB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KitType.LYNX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private AnnieXFlow() {
    }

    public static /* synthetic */ String dispatchFlow$anniex_release$default(AnnieXFlow annieXFlow, Application application, String str, Uri uri, FlowDispatchConfig flowDispatchConfig, int i, Object obj) {
        if ((i & 8) != 0) {
            flowDispatchConfig = null;
        }
        return annieXFlow.dispatchFlow$anniex_release(application, str, uri, flowDispatchConfig);
    }

    public final String dispatchFlow$anniex_release(Application application, String bid, Uri schema, FlowDispatchConfig config) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        String queryParameterSafely = SchemaUtilsKt.getQueryParameterSafely(schema, "__x_session_id");
        if (queryParameterSafely == null) {
            queryParameterSafely = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(queryParameterSafely, "randomUUID().toString()");
        }
        Uri build = schema.buildUpon().appendQueryParameter("__x_session_id", queryParameterSafely).build();
        Intrinsics.checkNotNullExpressionValue(build, "schema.buildUpon().appen…ON_ID, sessionId).build()");
        String str = (String) AnnieXLiteUtilsKt.getAnnieXSchemaModelUnion$default(null, build, queryParameterSafely, config, 1, null).getSchemaData().getQueryItems().get(StreamTrafficObservable.STREAM_URL);
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            schema = Uri.parse(str);
        }
        Intrinsics.checkNotNullExpressionValue(schema, "realUri");
        int i = WhenMappings.$EnumSwitchMapping$0[AnnieXLiteUtilsKt.getKitTypeFromSchema(schema).ordinal()];
        if (i == 1) {
            AnnieXWebDispatchManagerKt.dispatchWebFlow(bid, queryParameterSafely, schema);
        } else if (i == 2) {
            AnnieX.INSTANCE.ensureLynxInitialized(application);
            IAnnieXLynxProcess iAnnieXLynxProcess = (IAnnieXLynxProcess) AnnieXServiceCenter.INSTANCE.getService(bid, IAnnieXLynxProcess.class);
            if (iAnnieXLynxProcess != null) {
                iAnnieXLynxProcess.dispatchFlow(bid, queryParameterSafely, schema);
            }
        }
        return queryParameterSafely;
    }
}
