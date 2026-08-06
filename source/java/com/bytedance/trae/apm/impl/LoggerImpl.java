package com.bytedance.trae.apm.impl;

import com.bytedance.trae.utils.logger.ILogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoggerImpl.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00072\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\u0016H\u0016J2\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00072 \u0010\u0018\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u0019H\u0016J6\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\u0016H\u0016J\u001a\u0010\u001f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010 \u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010#\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006$"}, d2 = {"Lcom/bytedance/trae/apm/impl/LoggerImpl;", "Lcom/bytedance/trae/utils/logger/ILogger;", "<init>", "()V", "isDebug", "", "getDirPath", "", "isInitSuccess", "v", "", "tag", "msg", "d", "i", "w", "tr", "", "e", "uploadAllLog", "scene", "unit", "Lkotlin/Function1;", "uploadAllLogV2", "callback", "Lkotlin/Function3;", "", "uploadALog", "startTime", "", "endTime", "perfTraceLog", "perfSceneTraceStart", "sceneName", "uniqId", "perfTSceneTraceEnd", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class LoggerImpl implements ILogger {
    public void perfSceneTraceStart(String tag, String sceneName, String uniqId) {
        Intrinsics.checkNotNullParameter(tag, "tag");
    }

    public void perfTSceneTraceEnd(String tag, String sceneName, String uniqId) {
        Intrinsics.checkNotNullParameter(tag, "tag");
    }

    public void perfTraceLog(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
    }

    public boolean isDebug() {
        return Logger.INSTANCE.isDebug();
    }

    public String getDirPath() {
        return Logger.INSTANCE.getDirPath();
    }

    public boolean isInitSuccess() {
        return Logger.INSTANCE.isInitSuccess();
    }

    /* renamed from: v */
    public void m799v(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Logger.INSTANCE.m791v(tag, msg);
    }

    /* renamed from: d */
    public void m795d(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Logger.INSTANCE.m787d(tag, msg);
    }

    /* renamed from: i */
    public void m798i(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Logger.INSTANCE.m790i(tag, msg);
    }

    /* renamed from: w */
    public void m800w(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Logger.INSTANCE.m792w(tag, msg);
    }

    /* renamed from: w */
    public void m801w(String tag, String msg, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Logger.INSTANCE.m793w(tag, msg, tr);
    }

    /* renamed from: w */
    public void m802w(String tag, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Logger.INSTANCE.m794w(tag, tr);
    }

    /* renamed from: e */
    public void m796e(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Logger.INSTANCE.m788e(tag, msg);
    }

    /* renamed from: e */
    public void m797e(String tag, String msg, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Logger.INSTANCE.m789e(tag, msg, tr);
    }

    public void uploadAllLog(String scene, Function1<? super Boolean, Unit> unit) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Logger.INSTANCE.uploadAllLog(scene, unit);
    }

    public void uploadAllLogV2(String scene, Function3<? super Boolean, ? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Logger.INSTANCE.uploadAllLogV2(scene, callback);
    }

    public void uploadALog(String scene, long startTime, long endTime, Function1<? super Boolean, Unit> unit) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Logger.INSTANCE.uploadALog(scene, startTime, endTime, unit);
    }
}
