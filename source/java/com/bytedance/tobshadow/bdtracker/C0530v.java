package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.network.RangersHttpTimeoutException;
import com.bytedance.tobshadow.bdtracker.AbstractC0551y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u0017*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/tobshadow/applog/alink/model/ApiResponse;", "T", "Lcom/bytedance/tobshadow/applog/alink/model/BaseData;", "", "()V", "code", "", "getCode", "()I", "setCode", "(I)V", "data", "getData", "()Lcom/bytedance/tobshadow/applog/alink/model/BaseData;", "setData", "(Lcom/bytedance/tobshadow/applog/alink/model/BaseData;)V", "Lcom/bytedance/tobshadow/applog/alink/model/BaseData;", "message", "", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "Companion", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* renamed from: com.bytedance.tobshadow.bdtracker.v */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0530v<T extends AbstractC0551y> {

    /* renamed from: c */
    public static final a f1106c = new a(null);

    /* renamed from: a */
    public String f1107a;

    /* renamed from: b */
    public T f1108b;

    /* renamed from: a */
    public final T m713a() {
        return this.f1108b;
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.v$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public final <T extends AbstractC0551y> C0530v<T> m714a(String str, Class<T> cls) {
            Intrinsics.checkParameterIsNotNull(cls, "clazz");
            JSONObject jSONObject = new JSONObject(str);
            C0530v<T> c0530v = new C0530v<>();
            jSONObject.optInt("code");
            c0530v.f1107a = jSONObject.optString("message");
            c0530v.f1108b = (T) AbstractC0551y.f1251a.m755a(jSONObject.optJSONObject("data"), cls);
            return c0530v;
        }

        /* renamed from: a */
        public final <T extends AbstractC0551y> C0530v<T> m715a(Throwable th) {
            Intrinsics.checkParameterIsNotNull(th, "throwable");
            C0530v<T> c0530v = new C0530v<>();
            c0530v.f1107a = th instanceof RangersHttpTimeoutException ? "DDL request timeout" : th + " message:" + th.getMessage();
            return c0530v;
        }
    }
}
