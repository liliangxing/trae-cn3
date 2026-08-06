package com.bytedance.ies.bullet.service.base;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: IPreLoadService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0016R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/PreloadStrategy;", "", "()V", "priority", "", "getPriority$annotations", "getPriority", "()I", "setPriority", "(I)V", "session", "", "getSession", "()Ljava/lang/String;", "setSession", "(Ljava/lang/String;)V", "templateStrategy", "getTemplateStrategy$annotations", "getTemplateStrategy", "setTemplateStrategy", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class PreloadStrategy {
    private int priority = 1;
    private String session = "";
    private int templateStrategy;

    @Priority
    public static /* synthetic */ void getPriority$annotations() {
    }

    @TemplateStrategy
    public static /* synthetic */ void getTemplateStrategy$annotations() {
    }

    public final int getPriority() {
        return this.priority;
    }

    public final void setPriority(int i) {
        this.priority = i;
    }

    public final String getSession() {
        return this.session;
    }

    public final void setSession(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.session = str;
    }

    public final int getTemplateStrategy() {
        return this.templateStrategy;
    }

    public final void setTemplateStrategy(int i) {
        this.templateStrategy = i;
    }

    public String toString() {
        return "[priority:" + this.priority + ",session:" + this.session + ",templateStrategy:" + this.templateStrategy + AbstractJsonLexerKt.END_LIST;
    }
}
