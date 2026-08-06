package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.ies.argus.strategy.provider.BaseStrategyConfig;
import com.bytedance.ies.argus.util.UrlListVerifyHelper;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WebLoadStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\fR\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR$\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u00118F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000eR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000eR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/WebLoadConfig;", "Lcom/bytedance/ies/argus/strategy/provider/BaseStrategyConfig;", "whiteParentDomainList", "", "", "whiteWholeDomainList", "whiteUrlRegList", "excludeWhiteUrlRegList", "redirectBlackProtocol", "redirectBlackUrlReg", "blackUrlReg", "riskInfoPage", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getBlackUrlReg", "()Ljava/util/List;", "getExcludeWhiteUrlRegList", "<set-?>", "Lcom/bytedance/ies/argus/util/UrlListVerifyHelper$InnerDomainVerifier;", "innerUrlVerifier", "getInnerUrlVerifier", "()Lcom/bytedance/ies/argus/util/UrlListVerifyHelper$InnerDomainVerifier;", "getRedirectBlackProtocol", "getRedirectBlackUrlReg", "getRiskInfoPage", "()Ljava/lang/String;", "getWhiteParentDomainList", "getWhiteUrlRegList", "getWhiteWholeDomainList", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class WebLoadConfig extends BaseStrategyConfig {

    @SerializedName("black_url_reg")
    private final List<String> blackUrlReg;

    @SerializedName("exclude_white_url_reg")
    private final List<String> excludeWhiteUrlRegList;
    private UrlListVerifyHelper.InnerDomainVerifier innerUrlVerifier;

    @SerializedName("redirect_black_protocol")
    private final List<String> redirectBlackProtocol;

    @SerializedName("redirect_black_url_reg")
    private final List<String> redirectBlackUrlReg;

    @SerializedName("risk_info_page")
    private final String riskInfoPage;

    @SerializedName("white_parent_domain")
    private final List<String> whiteParentDomainList;

    @SerializedName("white_url_reg")
    private final List<String> whiteUrlRegList;

    @SerializedName("white_whole_domain")
    private final List<String> whiteWholeDomainList;

    public WebLoadConfig() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public /* synthetic */ WebLoadConfig(List list, List list2, List list3, List list4, List list5, List list6, List list7, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : list3, (i & 8) != 0 ? null : list4, (i & 16) != 0 ? null : list5, (i & 32) != 0 ? null : list6, (i & 64) != 0 ? null : list7, (i & 128) == 0 ? str : null);
    }

    public final List<String> getWhiteParentDomainList() {
        return this.whiteParentDomainList;
    }

    public final List<String> getWhiteWholeDomainList() {
        return this.whiteWholeDomainList;
    }

    public final List<String> getWhiteUrlRegList() {
        return this.whiteUrlRegList;
    }

    public final List<String> getExcludeWhiteUrlRegList() {
        return this.excludeWhiteUrlRegList;
    }

    public final List<String> getRedirectBlackProtocol() {
        return this.redirectBlackProtocol;
    }

    public final List<String> getRedirectBlackUrlReg() {
        return this.redirectBlackUrlReg;
    }

    public final List<String> getBlackUrlReg() {
        return this.blackUrlReg;
    }

    public final String getRiskInfoPage() {
        return this.riskInfoPage;
    }

    public WebLoadConfig(List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, List<String> list7, String str) {
        this.whiteParentDomainList = list;
        this.whiteWholeDomainList = list2;
        this.whiteUrlRegList = list3;
        this.excludeWhiteUrlRegList = list4;
        this.redirectBlackProtocol = list5;
        this.redirectBlackUrlReg = list6;
        this.blackUrlReg = list7;
        this.riskInfoPage = str;
    }

    public final UrlListVerifyHelper.InnerDomainVerifier getInnerUrlVerifier() {
        if (this.innerUrlVerifier == null) {
            this.innerUrlVerifier = new UrlListVerifyHelper.InnerDomainVerifier().addWhiteWholeDomain(this.whiteWholeDomainList).addWhiteParentDomain(this.whiteParentDomainList).addWhiteUrlReg(this.whiteUrlRegList).addExcludeWhiteUrlReg(this.excludeWhiteUrlRegList);
        }
        return this.innerUrlVerifier;
    }
}
