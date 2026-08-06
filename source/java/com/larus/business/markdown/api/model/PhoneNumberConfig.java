package com.larus.business.markdown.api.model;

import androidx.autofill.HintConstants;
import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PhoneNumberConfig.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BB\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012%\b\u0002\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003JF\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052%\b\u0002\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR.\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/larus/business/markdown/api/model/PhoneNumberConfig;", "", "enableHighlight", "", "phoneRegex", "", "linkGenerator", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "(ZLjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getEnableHighlight", "()Z", "getLinkGenerator", "()Lkotlin/jvm/functions/Function1;", "getPhoneRegex", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class PhoneNumberConfig {
    private final boolean enableHighlight;
    private final Function1<String, String> linkGenerator;
    private final String phoneRegex;

    public PhoneNumberConfig() {
        this(false, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PhoneNumberConfig copy$default(PhoneNumberConfig phoneNumberConfig, boolean z, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = phoneNumberConfig.enableHighlight;
        }
        if ((i & 2) != 0) {
            str = phoneNumberConfig.phoneRegex;
        }
        if ((i & 4) != 0) {
            function1 = phoneNumberConfig.linkGenerator;
        }
        return phoneNumberConfig.copy(z, str, function1);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnableHighlight() {
        return this.enableHighlight;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPhoneRegex() {
        return this.phoneRegex;
    }

    public final Function1<String, String> component3() {
        return this.linkGenerator;
    }

    public final PhoneNumberConfig copy(boolean enableHighlight, String phoneRegex, Function1<? super String, String> linkGenerator) {
        return new PhoneNumberConfig(enableHighlight, phoneRegex, linkGenerator);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PhoneNumberConfig)) {
            return false;
        }
        PhoneNumberConfig phoneNumberConfig = (PhoneNumberConfig) other;
        return this.enableHighlight == phoneNumberConfig.enableHighlight && Intrinsics.areEqual(this.phoneRegex, phoneNumberConfig.phoneRegex) && Intrinsics.areEqual(this.linkGenerator, phoneNumberConfig.linkGenerator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.enableHighlight;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.phoneRegex;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        Function1<String, String> function1 = this.linkGenerator;
        return hashCode + (function1 != null ? function1.hashCode() : 0);
    }

    public String toString() {
        return "PhoneNumberConfig(enableHighlight=" + this.enableHighlight + ", phoneRegex=" + this.phoneRegex + ", linkGenerator=" + this.linkGenerator + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhoneNumberConfig(boolean z, String str, Function1<? super String, String> function1) {
        this.enableHighlight = z;
        this.phoneRegex = str;
        this.linkGenerator = function1;
    }

    public /* synthetic */ PhoneNumberConfig(boolean z, String str, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : function1);
    }

    public final boolean getEnableHighlight() {
        return this.enableHighlight;
    }

    public final String getPhoneRegex() {
        return this.phoneRegex;
    }

    public final Function1<String, String> getLinkGenerator() {
        return this.linkGenerator;
    }
}
