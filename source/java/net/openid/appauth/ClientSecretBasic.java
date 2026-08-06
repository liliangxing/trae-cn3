package net.openid.appauth;

import android.util.Base64;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Collections;
import java.util.Map;
import net.openid.appauth.internal.UriUtil;

/* loaded from: classes8.dex */
public class ClientSecretBasic implements ClientAuthentication {
    public static final String NAME = "client_secret_basic";
    private String mClientSecret;

    @Override // net.openid.appauth.ClientAuthentication
    public final Map<String, String> getRequestParameters(String str) {
        return null;
    }

    public ClientSecretBasic(String str) {
        this.mClientSecret = (String) Preconditions.checkNotNull(str, "mClientSecret cannot be null");
    }

    @Override // net.openid.appauth.ClientAuthentication
    public final Map<String, String> getRequestHeaders(String str) {
        return Collections.singletonMap("Authorization", "Basic " + Base64.encodeToString((UriUtil.formUrlEncodeValue(str) + Constants.COLON_SEPARATOR + UriUtil.formUrlEncodeValue(this.mClientSecret)).getBytes(), 2));
    }
}
