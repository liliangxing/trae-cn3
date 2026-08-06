package com.bytedance.upc;

import com.bytedance.bdturing.methods.JsCallParser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* compiled from: IUpcCertService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H&J,\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\u0005H&¨\u0006\f"}, d2 = {"Lcom/bytedance/upc/IUpcCertBusinessService;", "", "setCertCallback", "", JsCallParser.VALUE_CALLBACK, "Lkotlin/Function1;", "Lorg/json/JSONObject;", "startCert", "identityName", "", "identityNumber", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public interface IUpcCertBusinessService {
    void setCertCallback(Function1<? super JSONObject, Unit> callback);

    void startCert(String identityName, String identityNumber, Function1<? super Long, Unit> callback);
}
