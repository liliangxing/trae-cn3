package com.bytedance.ies.bullet.forest;

import com.bytedance.android.anniex.worker.AnnieXJSWorkerManager;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.bytedance.reparo.core.exception.PatchException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForestAIEventSubscriber.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/bullet/forest/ForestAIEventSubscriber;", "Lcom/bytedance/ies/xbridge/event/JsEventSubscriber;", "()V", "onReceiveJsEvent", "", "jsEvent", "Lcom/bytedance/ies/xbridge/event/Js2NativeEvent;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ForestAIEventSubscriber implements JsEventSubscriber {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TAG = "ForestAIEventSubscriber";

    /* compiled from: ForestAIEventSubscriber.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/bullet/forest/ForestAIEventSubscriber$Companion;", "", "()V", "TAG", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.bytedance.ies.xbridge.event.JsEventSubscriber
    public void onReceiveJsEvent(Js2NativeEvent jsEvent) {
        PreloadType preloadType;
        Map<String, Object> map;
        Intrinsics.checkNotNullParameter(jsEvent, "jsEvent");
        XReadableMap params = jsEvent.getParams();
        Object obj = (params == null || (map = params.toMap()) == null) ? null : map.get("data");
        Map map2 = obj instanceof Map ? (Map) obj : null;
        if (map2 == null || map2.isEmpty()) {
            HybridLogger.w$default(HybridLogger.INSTANCE, TAG, "data from " + jsEvent + " is empty or null!", null, null, 12, null);
            return;
        }
        String str = (String) map2.get("main_url");
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            HybridLogger.w$default(HybridLogger.INSTANCE, TAG, "mainUrl from " + map2 + " is empty!", null, null, 12, null);
            return;
        }
        String str3 = (String) map2.get("engine_type");
        if (Intrinsics.areEqual(str3, "lynx")) {
            preloadType = PreloadType.LYNX;
        } else {
            if (!Intrinsics.areEqual(str3, "web")) {
                HybridLogger.w$default(HybridLogger.INSTANCE, TAG, "engine_type:" + str3 + " from " + map2 + " can not be identified!", null, null, 12, null);
                return;
            }
            preloadType = PreloadType.WEB;
        }
        PreloadType preloadType2 = preloadType;
        String str4 = (String) map2.get("bid");
        if (str4 == null) {
            str4 = "default_bid";
        }
        ForestLoader forestLoader = ForestLoader.INSTANCE;
        TaskConfig taskConfig = new TaskConfig(null, 1, null);
        taskConfig.setCustomMaxAge(Integer.valueOf(PatchException.ERR_LOAD_SO_MD5_NOT_MATCH));
        taskConfig.setInjectedUserAgent(AnnieXJSWorkerManager.INSTANCE.getUaCache(str4));
        Unit unit = Unit.INSTANCE;
        forestLoader.preload((r24 & 1) != 0 ? forestLoader.getDefault() : null, str, true, "", preloadType2, true, "client_ai", (r24 & 128) != 0 ? null : taskConfig, (r24 & 256) != 0 ? false : true, (r24 & 512) != 0 ? null : null);
    }
}
