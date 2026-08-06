package com.ss.android.token;

import android.content.Context;
import com.bytedance.android.sdk.bdticketguard.INetwork;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public interface ITokenService {

    /* loaded from: classes7.dex */
    public interface Callback {
        void onError(Response response);

        void onSuccess(Response response);
    }

    Context getApplicationContext();

    JSONObject getSettings();

    INetwork getTicketNetwork();

    String host();

    boolean isLogin();

    void onEvent(String str, JSONObject jSONObject);

    void onSelfCheckError(String str, String str2);

    void request(String str, Map<String, String> map, Map<String, String> map2, boolean z, Callback callback);

    /* loaded from: classes7.dex */
    public static class Response {
        public JSONObject data;
        public int detailErrorCode;
        public String detailErrorMessage;
        public int errorCode;
        public String errorMessage;

        public Response(int i, int i2, String str, String str2, JSONObject jSONObject) {
            this.errorCode = i;
            this.detailErrorCode = i2;
            this.errorMessage = str;
            this.detailErrorMessage = str2;
            this.data = jSONObject;
        }

        public String toString() {
            return "Response{errorCode=" + this.errorCode + ", detailErrorCode=" + this.detailErrorCode + ", errorMessage='" + this.errorMessage + "', detailErrorMessage='" + this.detailErrorMessage + "', data=" + this.data + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
