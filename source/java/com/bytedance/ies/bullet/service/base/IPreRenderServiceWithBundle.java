package com.bytedance.ies.bullet.service.base;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.ies.bullet.service.base.IPreRenderService;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IPreRenderService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J(\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/IPreRenderServiceWithBundle;", "Lcom/bytedance/ies/bullet/service/base/IPreRenderService;", "clear", "", "preRender", "schema", "Landroid/net/Uri;", "bundle", "Landroid/os/Bundle;", "context", "Landroid/content/Context;", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/ies/bullet/service/base/IPreRenderCallback;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IPreRenderServiceWithBundle extends IPreRenderService {
    void clear();

    void preRender(Uri schema, Bundle bundle, Context context, IPreRenderCallback callback);

    /* compiled from: IPreRenderService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static void clearCaches(IPreRenderServiceWithBundle iPreRenderServiceWithBundle, HashSet<String> cacheKeys) {
            Intrinsics.checkNotNullParameter(cacheKeys, "cacheKeys");
            IPreRenderService.DefaultImpls.clearCaches(iPreRenderServiceWithBundle, cacheKeys);
        }
    }
}
