package com.bytedance.pia.core.api.services;

import com.bytedance.pia.core.api.IPiaEnv;
import com.bytedance.pia.core.api.PiaCoreApi;
import com.bytedance.pia.core.api.PiaEnv;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IPiaEnvService {
    @Deprecated
    void initialize(IPiaEnv iPiaEnv) throws NullPointerException;

    void initialize(PiaEnv piaEnv) throws NullPointerException;

    static IPiaEnvService inst() {
        return (IPiaEnvService) PiaCoreApi.get(IPiaEnvService.class);
    }
}
