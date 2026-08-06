package com.bytedance.tobshadow.bdtracker;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.tobshadow.applog.network.RangersHttpTimeoutException;
import com.bytedance.tobshadow.bdtracker.y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u0017*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/tobshadow/applog/alink/model/ApiResponse;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/tobshadow/applog/alink/model/BaseData;", "", "()V", "code", "", "getCode", "()I", "setCode", "(I)V", "data", "getData", "()Lcom/bytedance/tobshadow/applog/alink/model/BaseData;", AirActionConstant.ActionId.ACTION_ID_NAME_SET_DATA, "(Lcom/bytedance/tobshadow/applog/alink/model/BaseData;)V", "Lcom/bytedance/tobshadow/applog/alink/model/BaseData;", "message", "", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "Companion", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class v<T extends y> {
    public static final a c = new a(null);
    public String a;
    public T b;

    public final T a() {
        return this.b;
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final <T extends y> v<T> a(String str, Class<T> clazz) {
            Intrinsics.checkParameterIsNotNull(clazz, "clazz");
            JSONObject jSONObject = new JSONObject(str);
            v<T> vVar = new v<>();
            jSONObject.optInt("code");
            vVar.a = jSONObject.optString("message");
            vVar.b = (T) y.a.a(jSONObject.optJSONObject("data"), clazz);
            return vVar;
        }

        public final <T extends y> v<T> a(Throwable throwable) {
            Intrinsics.checkParameterIsNotNull(throwable, "throwable");
            v<T> vVar = new v<>();
            vVar.a = throwable instanceof RangersHttpTimeoutException ? "DDL request timeout" : throwable + " message:" + throwable.getMessage();
            return vVar;
        }
    }
}
