package com.bytedance.lynx.scc.cloudservice.network;

/* loaded from: classes4.dex */
public interface ISccNetworkFactory {
    <T> T create(String baseUrl, Class<T> api);
}
