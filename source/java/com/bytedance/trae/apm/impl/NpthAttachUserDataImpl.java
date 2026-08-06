package com.bytedance.trae.apm.impl;

import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.bytedance.librarian.Librarian;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.trae.applog.api.IApplog;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NpthAttachUserDataImpl.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0007\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/apm/impl/NpthAttachUserDataImpl;", "Lcom/bytedance/crash/AttachUserData;", "<init>", "()V", "npthUserData", "", "", "getUserData", "", DBData.FIELD_TYPE, "Lcom/bytedance/crash/CrashType;", "appendUserData", "", "appendLibLoadInfo", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class NpthAttachUserDataImpl implements AttachUserData {
    public static final String TAG = "AttachUserDataImpl";
    private final Map<String, String> npthUserData = new ConcurrentHashMap();

    public Map<? extends String, String> getUserData(CrashType type) {
        Intrinsics.checkNotNullParameter(type, DBData.FIELD_TYPE);
        try {
            appendLibLoadInfo();
            appendUserData();
        } catch (Exception unused) {
        }
        return this.npthUserData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void appendUserData() {
        String str;
        Object obj;
        if (!this.npthUserData.containsKey("curDeviceId")) {
            Map<String, String> map = this.npthUserData;
            try {
                Result.Companion companion = Result.Companion;
                NpthAttachUserDataImpl npthAttachUserDataImpl = this;
                obj = Result.constructor-impl(IApplog.INSTANCE.getDeviceId());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = "";
            }
            map.put("curDeviceId", obj);
        }
        if (this.npthUserData.containsKey("curUserId")) {
            return;
        }
        Map<String, String> map2 = this.npthUserData;
        try {
            Result.Companion companion3 = Result.Companion;
            NpthAttachUserDataImpl npthAttachUserDataImpl2 = this;
            str = Result.constructor-impl(IApplog.INSTANCE.getUserID());
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            str = Result.constructor-impl(ResultKt.createFailure(th2));
        }
        map2.put("curUserId", Result.isFailure-impl(str) ? "" : str);
    }

    private final void appendLibLoadInfo() {
        String str;
        Map<String, String> map = this.npthUserData;
        String arrays = Arrays.toString(Librarian.getErrors());
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(...)");
        map.put("librarian", arrays);
        Map<String, String> map2 = this.npthUserData;
        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader == null || (str = classLoader.toString()) == null) {
            str = "No ClassLoader information";
        }
        map2.put("class_loader", str);
    }
}
