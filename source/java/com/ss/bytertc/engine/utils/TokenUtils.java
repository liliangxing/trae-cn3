package com.ss.bytertc.engine.utils;

import android.util.Base64;
import com.bytedance.trae.ServiceType;

/* loaded from: classes7.dex */
public class TokenUtils {
    public static String buildToken(String token, String appId, String room, String uid) {
        return (token == null || token.isEmpty()) ? "Basic " + Base64.encodeToString(String.format("%s:%s:%s", appId, room, uid).getBytes(), 2) : token.contains(ServiceType.BASIC_SERVICE) ? token : "Bearer " + token;
    }
}
