package com.bytedance.ies.bullet.service.monitor.reliability;

import android.net.Uri;
import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.utils.BulletLoadUriIdentifier;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: NpthHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/reliability/NpthHelper;", "", "()V", "injectBulletUrl", "", "url", "", "needParse", "", "uninjectBulletUrl", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class NpthHelper {
    public static final NpthHelper INSTANCE = new NpthHelper();

    private NpthHelper() {
    }

    public static /* synthetic */ void injectBulletUrl$default(NpthHelper npthHelper, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        npthHelper.injectBulletUrl(str, z);
    }

    public final void injectBulletUrl(String url, boolean needParse) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            Result.Companion companion = Result.Companion;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = url;
            if (needParse) {
                Uri parse = Uri.parse(url);
                Intrinsics.checkNotNullExpressionValue(parse, "parse(url)");
                objectRef.element = new BulletLoadUriIdentifier(parse).getIdentifierUrl();
            }
            Npth.addAttachUserData(new AttachUserData() { // from class: com.bytedance.ies.bullet.service.monitor.reliability.NpthHelper$injectBulletUrl$1$1
                public final Map<? extends String, ? extends String> getUserData(CrashType crashType) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("bullet_url", objectRef.element);
                    return hashMap;
                }
            }, CrashType.ALL);
            Npth.addTag("bullet_url", (String) objectRef.element);
            BulletLogger.INSTANCE.printLog("injectBulletUrl " + ((String) objectRef.element), LogLevel.I, "NpthHelper");
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public final void uninjectBulletUrl(final String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            Result.Companion companion = Result.Companion;
            Npth.removeAttachUserData(new AttachUserData() { // from class: com.bytedance.ies.bullet.service.monitor.reliability.NpthHelper$uninjectBulletUrl$1$1
                public final Map<? extends String, ? extends String> getUserData(CrashType crashType) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("bullet_url", url);
                    return hashMap;
                }
            }, CrashType.ALL);
            Npth.removeTag("bullet_url");
            BulletLogger.INSTANCE.printLog("uninjectBulletUrl", LogLevel.I, "NpthHelper");
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }
}
