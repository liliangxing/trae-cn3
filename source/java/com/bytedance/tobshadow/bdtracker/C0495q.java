package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import com.bytedance.tobshadow.applog.InitConfig;
import com.bytedance.tobshadow.applog.store.p007kv.IKVStore;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ-\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0014¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u0007J\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bJ \u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001a\u001a\u00020\u001bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/tobshadow/applog/alink/ALinkCache;", "", "config", "Lcom/bytedance/tobshadow/applog/InitConfig;", "context", "Landroid/content/Context;", "spName", "", "(Lcom/bytedance/tobshadow/applog/InitConfig;Landroid/content/Context;Ljava/lang/String;)V", "aLinkKVStore", "Lcom/bytedance/tobshadow/applog/store/kv/IKVStore;", "getALinkKVStore", "()Lcom/bytedance/tobshadow/applog/store/kv/IKVStore;", "aLinkKVStore$delegate", "Lkotlin/Lazy;", "getData", "T", "Lcom/bytedance/tobshadow/applog/alink/model/BaseData;", "key", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Lcom/bytedance/tobshadow/applog/alink/model/BaseData;", "getString", "putData", "", "data", "expireTs", "", "putString", "value", "Companion", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* renamed from: com.bytedance.tobshadow.bdtracker.q */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0495q {

    /* renamed from: b */
    public static final /* synthetic */ KProperty[] f929b = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(C0495q.class), "aLinkKVStore", "getALinkKVStore()Lcom/bytedance/tobshadow/applog/store/kv/IKVStore;"))};

    /* renamed from: a */
    public final Lazy f930a;

    /* renamed from: com.bytedance.tobshadow.bdtracker.q$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class a extends Lambda implements Function0<IKVStore> {

        /* renamed from: a */
        public final /* synthetic */ InitConfig f931a;

        /* renamed from: b */
        public final /* synthetic */ Context f932b;

        /* renamed from: c */
        public final /* synthetic */ String f933c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InitConfig initConfig, Context context, String str) {
            super(0);
            this.f931a = initConfig;
            this.f932b = context;
            this.f933c = str;
        }

        public Object invoke() {
            return C0424f5.m439a(this.f931a, this.f932b, this.f933c);
        }
    }

    public C0495q(InitConfig initConfig, Context context, String str) {
        Intrinsics.checkParameterIsNotNull(initConfig, "config");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "spName");
        this.f930a = LazyKt.lazy(new a(initConfig, context, str));
    }

    /* renamed from: a */
    public final IKVStore m608a() {
        Lazy lazy = this.f930a;
        KProperty kProperty = f929b[0];
        return (IKVStore) lazy.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003a A[Catch: all -> 0x0048, TryCatch #0 {all -> 0x0048, blocks: (B:3:0x000b, B:5:0x0015, B:9:0x002c, B:14:0x003a, B:17:0x0041), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0041 A[Catch: all -> 0x0048, TRY_LEAVE, TryCatch #0 {all -> 0x0048, blocks: (B:3:0x000b, B:5:0x0015, B:9:0x002c, B:14:0x003a, B:17:0x0041), top: B:2:0x000b }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T extends AbstractC0551y> T m609a(String str, Class<T> cls) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(cls, "clazz");
        try {
            String string = m608a().getString(str, null);
            if (string == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(string);
            long optLong = jSONObject.optLong("expire_ts");
            if (optLong != -1 && (optLong <= 0 || System.currentTimeMillis() >= optLong)) {
                z = false;
                if (!z) {
                    return (T) AbstractC0551y.f1251a.m755a(jSONObject, cls);
                }
                m608a().remove(str);
                return null;
            }
            z = true;
            if (!z) {
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x0006, B:5:0x0010, B:9:0x0027, B:14:0x0035, B:17:0x003c), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003c A[Catch: all -> 0x0043, TRY_LEAVE, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x0006, B:5:0x0010, B:9:0x0027, B:14:0x0035, B:17:0x003c), top: B:2:0x0006 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String m610a(String str) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(str, "key");
        try {
            String string = m608a().getString(str, null);
            if (string == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(string);
            long optLong = jSONObject.optLong("expire_ts");
            if (optLong != -1 && (optLong <= 0 || System.currentTimeMillis() >= optLong)) {
                z = false;
                if (!z) {
                    return jSONObject.optString("data");
                }
                m608a().remove(str);
                return null;
            }
            z = true;
            if (!z) {
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public final void m611a(String str, AbstractC0551y abstractC0551y, long j) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(abstractC0551y, "data");
        JSONObject mo665a = abstractC0551y.mo665a();
        mo665a.put("expire_ts", j != -1 ? System.currentTimeMillis() + j : -1L);
        m608a().putString(str, mo665a.toString());
    }

    /* renamed from: a */
    public final void m612a(String str, String str2, long j) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", str2);
        jSONObject.put("expire_ts", j != -1 ? System.currentTimeMillis() + j : -1L);
        m608a().putString(str, jSONObject.toString());
    }
}
