package com.bytedance.ies.bullet.lynx.resource.forest;

import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.lynx.tasm.provider.AbsTemplateProvider;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GlobalForestTemplateProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/resource/forest/GlobalForestTemplateProvider;", "Lcom/lynx/tasm/provider/AbsTemplateProvider;", "()V", "loadTemplate", "", "url", "", "callback", "Lcom/lynx/tasm/provider/AbsTemplateProvider$Callback;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class GlobalForestTemplateProvider extends AbsTemplateProvider {
    public void loadTemplate(String url, final AbsTemplateProvider.Callback callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        r1.loadAsync((r22 & 1) != 0 ? ForestLoader.INSTANCE.getDefault() : null, url, (r22 & 4) != 0 ? null : null, Scene.LYNX_TEMPLATE, null, (r22 & 32) != 0 ? null : null, (r22 & 64) != 0 ? false : false, (r22 & 128) != 0 ? null : null, new Function1<Response, Unit>() { // from class: com.bytedance.ies.bullet.lynx.resource.forest.GlobalForestTemplateProvider$loadTemplate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Response) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Response response) {
                Object obj;
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.isSucceed()) {
                    AbsTemplateProvider.Callback callback2 = callback;
                    try {
                        Result.Companion companion = Result.Companion;
                        byte[] provideBytes = response.provideBytes();
                        Unit unit = null;
                        if ((provideBytes != null ? provideBytes.length : -1) > 0) {
                            if (callback2 != null) {
                                callback2.onSuccess(provideBytes);
                                unit = Unit.INSTANCE;
                            }
                        } else if (callback2 != null) {
                            callback2.onFailed("template load error, bytes is empty");
                            unit = Unit.INSTANCE;
                        }
                        obj = Result.constructor-impl(unit);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    AbsTemplateProvider.Callback callback3 = callback;
                    Throwable th2 = Result.exceptionOrNull-impl(obj);
                    if (th2 == null || callback3 == null) {
                        return;
                    }
                    callback3.onFailed("template load error, " + th2.getMessage());
                    return;
                }
                AbsTemplateProvider.Callback callback4 = callback;
                if (callback4 != null) {
                    callback4.onFailed("template load error, " + response.getErrorInfo());
                }
            }
        });
    }
}
