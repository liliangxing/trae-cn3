package com.bytedance.env.api;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* compiled from: EnvManagerApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"DEFAULT_GECKO_LANE", "", "DEFAULT_LANE", "KEVA_REPO_ENV_SDK", "LOG_TAG", "envTypeMap", "", "", "Lcom/bytedance/env/api/EnvType;", "getEnvTypeMap", "()Ljava/util/Map;", "env_platform_api_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class EnvManagerApiKt {
    public static final String DEFAULT_GECKO_LANE = "";
    public static final String DEFAULT_LANE = "prod";
    public static final String KEVA_REPO_ENV_SDK = "keva_repo_env_sdk";
    public static final String LOG_TAG = "env_platform_sdk";
    private static final Map<Integer, EnvType> envTypeMap = MapsKt.mapOf(new Pair[]{TuplesKt.to(0, EnvType.PRODUCT), TuplesKt.to(1, EnvType.CANARY), TuplesKt.to(2, EnvType.PPE), TuplesKt.to(3, EnvType.BOE)});

    public static final Map<Integer, EnvType> getEnvTypeMap() {
        return envTypeMap;
    }
}
