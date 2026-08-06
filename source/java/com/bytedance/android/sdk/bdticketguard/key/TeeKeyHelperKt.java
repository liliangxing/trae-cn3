package com.bytedance.android.sdk.bdticketguard.key;

import android.util.Base64;
import java.security.Key;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: TeeKeyHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\u0011\u001a&\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"CERTIFICATE_TYPE", "", "CN_PATTERN", "KEY_PAIR_ALGORITHM", "KEY_STORE_PROVIDER_ANDROID", "KEY_STORE_PROVIDER_BC", "MAX_ATTEMPT_COUNT", "", "SIGNATURE_ALGORITHM", "SP_KEY_CLIENT_CERT", "SP_KEY_HAS_EVER_FAIL", "SP_KEY_HAS_LOAD_FROM_ORIGIN_SP", "SP_KEY_PRIVATE_KEY", "SP_KEY_PUBLIC_KEY", "SP_KEY_TEE_CREATE_LOG", "base64EncodeKey", "key", "Ljava/security/Key;", "getPrincipal", "commonName", "organizationUnit", "organization", "country", "bd_ticket_guard_core_release"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final class TeeKeyHelperKt {
    public static final String CERTIFICATE_TYPE = "X.509";
    public static final String CN_PATTERN = "CN=%s, OU=%s, O=%s, C=%s";
    public static final String KEY_PAIR_ALGORITHM = "EC";
    public static final String KEY_STORE_PROVIDER_ANDROID = "AndroidKeyStore";
    public static final String KEY_STORE_PROVIDER_BC = "BC";
    public static final int MAX_ATTEMPT_COUNT = 3;
    public static final String SIGNATURE_ALGORITHM = "SHA256withECDSA";
    public static final String SP_KEY_CLIENT_CERT = "client_cert";
    public static final String SP_KEY_HAS_EVER_FAIL = "has_ever_fail";
    public static final String SP_KEY_HAS_LOAD_FROM_ORIGIN_SP = "sp_key_has_load_from_origin_sp";
    public static final String SP_KEY_PRIVATE_KEY = "sp_key_private_key";
    public static final String SP_KEY_PUBLIC_KEY = "sp_key_public_key";
    public static final String SP_KEY_TEE_CREATE_LOG = "tee_create_key_log";

    public static final String base64EncodeKey(Key key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return Base64.encodeToString(key.getEncoded(), 0);
    }

    public static final String getPrincipal(String commonName, String organizationUnit, String organization, String country) {
        Intrinsics.checkParameterIsNotNull(commonName, "commonName");
        Intrinsics.checkParameterIsNotNull(organizationUnit, "organizationUnit");
        Intrinsics.checkParameterIsNotNull(organization, "organization");
        Intrinsics.checkParameterIsNotNull(country, "country");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(CN_PATTERN, Arrays.copyOf(new Object[]{commonName, organizationUnit, organization, country}, 4));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        return format;
    }
}
