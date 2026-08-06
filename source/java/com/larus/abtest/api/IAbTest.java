package com.larus.abtest.api;

import com.larus.abtest.api.IAbTest;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: IAbTest.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u0014\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\u000f\u001a\u00020\u0005H&J1\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u000e\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00132\u0006\u0010\u0014\u001a\u0002H\u0011H&¢\u0006\u0002\u0010\u0015J9\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u000e\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00132\u0006\u0010\u0014\u001a\u0002H\u00112\u0006\u0010\u0016\u001a\u00020\u0003H&¢\u0006\u0002\u0010\u0017JA\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u000e\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00132\u0006\u0010\u0014\u001a\u0002H\u00112\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H&¢\u0006\u0002\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/larus/abtest/api/IAbTest;", "", "isInit", "", "refresh", "", "getUserVids", "", "uid", "updateUserId", "userId", "getLibraExperimentCache", "Lorg/json/JSONObject;", "getExposureInfo", "key", "testABTestExperimentFetch", "getExperimentValue", "T", "tClass", "Ljava/lang/Class;", "defaultValue", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;", "withExposure", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;Z)Ljava/lang/Object;", "isSticky", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;ZZ)Ljava/lang/Object;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface IAbTest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    <T> T getExperimentValue(String key, Class<T> tClass, T defaultValue);

    <T> T getExperimentValue(String key, Class<T> tClass, T defaultValue, boolean withExposure);

    <T> T getExperimentValue(String key, Class<T> tClass, T defaultValue, boolean isSticky, boolean withExposure);

    String getExposureInfo(String key);

    JSONObject getLibraExperimentCache();

    String getUserVids();

    String getUserVids(String uid);

    boolean isInit();

    void refresh();

    void testABTestExperimentFetch();

    void updateUserId(String userId);

    /* compiled from: IAbTest.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0016J1\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\u0006\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00192\u0006\u0010\u001a\u001a\u0002H\u0017H\u0016¢\u0006\u0002\u0010\u001bJ9\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\u0006\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00192\u0006\u0010\u001a\u001a\u0002H\u00172\u0006\u0010\u001c\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u001dJA\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\u0006\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00192\u0006\u0010\u001a\u001a\u0002H\u00172\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\fH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006!"}, d2 = {"Lcom/larus/abtest/api/IAbTest$Companion;", "Lcom/larus/abtest/api/IAbTest;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/abtest/api/IAbTest;", "impl$delegate", "Lkotlin/Lazy;", "isInit", "", "refresh", "", "getUserVids", "", "uid", "updateUserId", "userId", "getLibraExperimentCache", "Lorg/json/JSONObject;", "getExposureInfo", "key", "getExperimentValue", "T", "tClass", "Ljava/lang/Class;", "defaultValue", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;", "withExposure", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;Z)Ljava/lang/Object;", "isSticky", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;ZZ)Ljava/lang/Object;", "testABTestExperimentFetch", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion implements IAbTest {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* renamed from: impl$delegate, reason: from kotlin metadata */
        private static final Lazy<IAbTest> impl = LazyKt.lazy(new Function0() { // from class: com.larus.abtest.api.IAbTest$Companion$$ExternalSyntheticLambda0
            public final Object invoke() {
                IAbTest impl_delegate$lambda$0;
                impl_delegate$lambda$0 = IAbTest.Companion.impl_delegate$lambda$0();
                return impl_delegate$lambda$0;
            }
        });

        private Companion() {
        }

        private final IAbTest getImpl() {
            return (IAbTest) impl.getValue();
        }

        @Override // com.larus.abtest.api.IAbTest
        public boolean isInit() {
            IAbTest impl2 = getImpl();
            if (impl2 != null) {
                return impl2.isInit();
            }
            return false;
        }

        @Override // com.larus.abtest.api.IAbTest
        public void refresh() {
            IAbTest impl2 = getImpl();
            if (impl2 != null) {
                impl2.refresh();
            }
        }

        @Override // com.larus.abtest.api.IAbTest
        public String getUserVids() {
            IAbTest impl2 = getImpl();
            if (impl2 != null) {
                return impl2.getUserVids();
            }
            return null;
        }

        @Override // com.larus.abtest.api.IAbTest
        public String getUserVids(String uid) {
            IAbTest impl2 = getImpl();
            if (impl2 != null) {
                return impl2.getUserVids(uid);
            }
            return null;
        }

        @Override // com.larus.abtest.api.IAbTest
        public void updateUserId(String userId) {
            IAbTest impl2 = getImpl();
            if (impl2 != null) {
                impl2.updateUserId(userId);
            }
        }

        @Override // com.larus.abtest.api.IAbTest
        public JSONObject getLibraExperimentCache() {
            IAbTest impl2 = getImpl();
            if (impl2 != null) {
                return impl2.getLibraExperimentCache();
            }
            return null;
        }

        @Override // com.larus.abtest.api.IAbTest
        public String getExposureInfo(String key) {
            IAbTest impl2 = getImpl();
            if (impl2 != null) {
                return impl2.getExposureInfo(key);
            }
            return null;
        }

        @Override // com.larus.abtest.api.IAbTest
        public <T> T getExperimentValue(String key, Class<T> tClass, T defaultValue) {
            T t;
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(tClass, "tClass");
            IAbTest impl2 = getImpl();
            return (impl2 == null || (t = (T) impl2.getExperimentValue(key, tClass, defaultValue)) == null) ? defaultValue : t;
        }

        @Override // com.larus.abtest.api.IAbTest
        public <T> T getExperimentValue(String key, Class<T> tClass, T defaultValue, boolean withExposure) {
            T t;
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(tClass, "tClass");
            IAbTest impl2 = getImpl();
            return (impl2 == null || (t = (T) impl2.getExperimentValue(key, tClass, defaultValue, withExposure)) == null) ? defaultValue : t;
        }

        @Override // com.larus.abtest.api.IAbTest
        public <T> T getExperimentValue(String key, Class<T> tClass, T defaultValue, boolean isSticky, boolean withExposure) {
            T t;
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(tClass, "tClass");
            IAbTest impl2 = getImpl();
            return (impl2 == null || (t = (T) impl2.getExperimentValue(key, tClass, defaultValue, isSticky, withExposure)) == null) ? defaultValue : t;
        }

        @Override // com.larus.abtest.api.IAbTest
        public void testABTestExperimentFetch() {
            IAbTest impl2 = getImpl();
            if (impl2 != null) {
                impl2.testABTestExperimentFetch();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final IAbTest impl_delegate$lambda$0() {
            return (IAbTest) ServiceManager.get().getService(IAbTest.class);
        }
    }
}
