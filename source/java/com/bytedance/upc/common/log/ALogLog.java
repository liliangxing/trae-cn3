package com.bytedance.upc.common.log;

import android.util.Log;
import com.ss.android.agilelogger.ALog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ALogLog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/upc/common/log/ALogLog;", "Lcom/bytedance/upc/common/log/ILog;", "()V", "d", "", "tag", "", "msg", "e", "i", "v", "w", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class ALogLog implements ILog {
    @Override // com.bytedance.upc.common.log.ILog
    /* renamed from: v */
    public void mo4v(String tag, String msg) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        try {
            Result.Companion companion = Result.Companion;
            Log.v(tag, String.valueOf(msg));
            ALog.v(tag, String.valueOf(msg));
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    @Override // com.bytedance.upc.common.log.ILog
    /* renamed from: d */
    public void mo1d(String tag, String msg) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        try {
            Result.Companion companion = Result.Companion;
            Log.d(tag, String.valueOf(msg));
            ALog.d(tag, String.valueOf(msg));
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    @Override // com.bytedance.upc.common.log.ILog
    /* renamed from: i */
    public void mo3i(String tag, String msg) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        try {
            Result.Companion companion = Result.Companion;
            Log.i(tag, String.valueOf(msg));
            ALog.i(tag, String.valueOf(msg));
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    @Override // com.bytedance.upc.common.log.ILog
    /* renamed from: e */
    public void mo2e(String tag, String msg) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        try {
            Result.Companion companion = Result.Companion;
            Log.e(tag, String.valueOf(msg));
            ALog.e(tag, String.valueOf(msg));
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    @Override // com.bytedance.upc.common.log.ILog
    /* renamed from: w */
    public void mo5w(String tag, String msg) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        try {
            Result.Companion companion = Result.Companion;
            Log.w(tag, String.valueOf(msg));
            ALog.w(tag, String.valueOf(msg));
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }
}
