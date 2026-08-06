package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* compiled from: ArgusConstants.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0017\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusWebLoadVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/IArgusVerifyReason;", "code", "", "strValue", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getStrValue", "()Ljava/lang/String;", "BLACK_PROTOCOL", "BLACK_URL_REG", "HIT_SEC_LINK_SCENE", "FORCE_TO_HTTPS", "WHITE_URL", "ALREADY_SEC_LINK_PAGE", "REWRITE_BY_SEC_LINK", "PASS_BY_SEC_LINK_SERVER", "HAS_TRIGGER_CHECK", "REDIRECT_LAST_URL_IS_SEC_LINK_PAGE", "RELOAD_SEC_URL", "REDIRECT_REWRITE_URL", "NO_SEC_LINK_SCENE", "SEC_LINK_HANDLER_IS_NULL", "SEC_LINK_VERIFY_MODE_NOT_ENABLE", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public enum ArgusWebLoadVerifyReason implements IArgusVerifyReason {
    BLACK_PROTOCOL(-1, "hit black protocol"),
    BLACK_URL_REG(-2, "hit black url reg"),
    HIT_SEC_LINK_SCENE(-5, "container context's secLinkScene is"),
    FORCE_TO_HTTPS(-6, "domain in share cookie list and use http is forbidden"),
    WHITE_URL(1, "hit white url"),
    ALREADY_SEC_LINK_PAGE(2, "already secLink page"),
    REWRITE_BY_SEC_LINK(3, "rewrite by secLink"),
    PASS_BY_SEC_LINK_SERVER(4, "pass by secLink server"),
    HAS_TRIGGER_CHECK(5, "has triggered checked"),
    REDIRECT_LAST_URL_IS_SEC_LINK_PAGE(6, "redirect last url is secLink page"),
    RELOAD_SEC_URL(7, "reload sec url"),
    REDIRECT_REWRITE_URL(8, "redirect rewrite url, will trigger reload"),
    NO_SEC_LINK_SCENE(9, "no secLink scene"),
    SEC_LINK_HANDLER_IS_NULL(1001, "secLinkHandler is null"),
    SEC_LINK_VERIFY_MODE_NOT_ENABLE(1002, "secLinkVerifyMode not enable");

    private final int code;
    private final String strValue;

    ArgusWebLoadVerifyReason(int i, String str) {
        this.code = i;
        this.strValue = str;
    }

    @Override // com.bytedance.ies.argus.bean.IArgusVerifyReason
    public int getCode() {
        return this.code;
    }

    @Override // com.bytedance.ies.argus.bean.IArgusVerifyReason
    public String getStrValue() {
        return this.strValue;
    }
}
