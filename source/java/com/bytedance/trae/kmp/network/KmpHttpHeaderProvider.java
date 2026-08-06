package com.bytedance.trae.kmp.network;

import java.util.Map;
import kotlin.Metadata;

/* compiled from: KmpHttpEventReporter.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H&¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/kmp/network/KmpHttpHeaderProvider;", "", "headers", "", "", "options", "Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;", "requestHeaders", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface KmpHttpHeaderProvider {
    Map<String, String> headers(KmpHttpRequestOptions options, Map<String, String> requestHeaders);
}
