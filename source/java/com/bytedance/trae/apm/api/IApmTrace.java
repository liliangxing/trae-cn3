package com.bytedance.trae.apm.api;

import com.bytedance.trae.apm.api.IApmTrace;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: IApmTrace.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J0\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000bH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005H&¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/apm/api/IApmTrace;", "", "addPerfTag", "", "key", "", "value", "addTag", "traceAll", "reportApmEvent", "category", "Lorg/json/JSONObject;", "metric", "extra", "reportTeaEvent", "startApmScene", "scene", "stopApmScene", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IApmTrace {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void addPerfTag(String key, String value);

    void addTag(String key, String value);

    void reportApmEvent(String key, JSONObject category, JSONObject metric, JSONObject extra);

    void reportTeaEvent(String key, JSONObject value);

    void startApmScene(String scene);

    void stopApmScene(String scene);

    void traceAll(String key, String value);

    /* compiled from: IApmTrace.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J,\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\fH\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\fH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/apm/api/IApmTrace$Companion;", "Lcom/bytedance/trae/apm/api/IApmTrace;", "<init>", "()V", "impl", "getImpl", "()Lcom/bytedance/trae/apm/api/IApmTrace;", "impl$delegate", "Lkotlin/Lazy;", "addPerfTag", "", "key", "", "value", "addTag", "traceAll", "reportApmEvent", "category", "Lorg/json/JSONObject;", "metric", "extra", "reportTeaEvent", "startApmScene", "scene", "stopApmScene", "ApmScene", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion implements IApmTrace {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* renamed from: impl$delegate, reason: from kotlin metadata */
        private static final Lazy<IApmTrace> impl = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.apm.api.IApmTrace$Companion$$ExternalSyntheticLambda0
            public final Object invoke() {
                IApmTrace impl_delegate$lambda$0;
                impl_delegate$lambda$0 = IApmTrace.Companion.impl_delegate$lambda$0();
                return impl_delegate$lambda$0;
            }
        });

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: IApmTrace.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;", "", "<init>", "(Ljava/lang/String;I)V", "DORA_QUERY", "TTS_PLAY", "REALTIME_CALL", "NAVIGATION_LOCATING", "MUSIC_PLAY", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class ApmScene {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ ApmScene[] $VALUES;
            public static final ApmScene DORA_QUERY = new ApmScene("DORA_QUERY", 0);
            public static final ApmScene TTS_PLAY = new ApmScene("TTS_PLAY", 1);
            public static final ApmScene REALTIME_CALL = new ApmScene("REALTIME_CALL", 2);
            public static final ApmScene NAVIGATION_LOCATING = new ApmScene("NAVIGATION_LOCATING", 3);
            public static final ApmScene MUSIC_PLAY = new ApmScene("MUSIC_PLAY", 4);

            private static final /* synthetic */ ApmScene[] $values() {
                return new ApmScene[]{DORA_QUERY, TTS_PLAY, REALTIME_CALL, NAVIGATION_LOCATING, MUSIC_PLAY};
            }

            public static EnumEntries<ApmScene> getEntries() {
                return $ENTRIES;
            }

            private ApmScene(String str, int i) {
            }

            static {
                ApmScene[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
            }

            public static ApmScene valueOf(String str) {
                return (ApmScene) Enum.valueOf(ApmScene.class, str);
            }

            public static ApmScene[] values() {
                return (ApmScene[]) $VALUES.clone();
            }
        }

        private Companion() {
        }

        private final IApmTrace getImpl() {
            return (IApmTrace) impl.getValue();
        }

        @Override // com.bytedance.trae.apm.api.IApmTrace
        public void addPerfTag(String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            IApmTrace impl2 = getImpl();
            if (impl2 != null) {
                impl2.addPerfTag(key, value);
            }
        }

        @Override // com.bytedance.trae.apm.api.IApmTrace
        public void addTag(String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            IApmTrace impl2 = getImpl();
            if (impl2 != null) {
                impl2.addTag(key, value);
            }
        }

        @Override // com.bytedance.trae.apm.api.IApmTrace
        public void traceAll(String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            IApmTrace impl2 = getImpl();
            if (impl2 != null) {
                impl2.traceAll(key, value);
            }
        }

        @Override // com.bytedance.trae.apm.api.IApmTrace
        public void reportApmEvent(String key, JSONObject category, JSONObject metric, JSONObject extra) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(category, "category");
            IApmTrace impl2 = getImpl();
            if (impl2 != null) {
                impl2.reportApmEvent(key, category, metric, extra);
            }
        }

        @Override // com.bytedance.trae.apm.api.IApmTrace
        public void reportTeaEvent(String key, JSONObject value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            IApmTrace impl2 = getImpl();
            if (impl2 != null) {
                impl2.reportTeaEvent(key, value);
            }
        }

        @Override // com.bytedance.trae.apm.api.IApmTrace
        public void startApmScene(String scene) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            IApmTrace impl2 = getImpl();
            if (impl2 != null) {
                impl2.startApmScene(scene);
            }
        }

        @Override // com.bytedance.trae.apm.api.IApmTrace
        public void stopApmScene(String scene) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            IApmTrace impl2 = getImpl();
            if (impl2 != null) {
                impl2.stopApmScene(scene);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final IApmTrace impl_delegate$lambda$0() {
            return (IApmTrace) ServiceManager.get().getService(IApmTrace.class);
        }
    }

    /* compiled from: IApmTrace.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void reportApmEvent$default(IApmTrace iApmTrace, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportApmEvent");
            }
            if ((i & 4) != 0) {
                jSONObject2 = null;
            }
            if ((i & 8) != 0) {
                jSONObject3 = null;
            }
            iApmTrace.reportApmEvent(str, jSONObject, jSONObject2, jSONObject3);
        }
    }
}
