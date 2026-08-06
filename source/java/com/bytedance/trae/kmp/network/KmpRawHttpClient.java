package com.bytedance.trae.kmp.network;

import com.bytedance.android.monitorV2.constant.ReportConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.bouncycastle.cms.CMSAttributeTableGenerator;

/* compiled from: KmpRawHttpClient.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001JF\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000bJB\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/kmp/network/KmpRawHttpClient;", "", "getRaw", "Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;", "url", "", "headers", "", "queries", "options", "Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postRaw", ReportConst.ValidationReport.BODY, CMSAttributeTableGenerator.CONTENT_TYPE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface KmpRawHttpClient {
    Object getRaw(String str, Map<String, String> map, Map<String, String> map2, KmpHttpRequestOptions kmpHttpRequestOptions, Continuation<? super KmpRawHttpResult> continuation);

    Object postRaw(String str, String str2, String str3, Map<String, String> map, KmpHttpRequestOptions kmpHttpRequestOptions, Continuation<? super KmpRawHttpResult> continuation);
}
