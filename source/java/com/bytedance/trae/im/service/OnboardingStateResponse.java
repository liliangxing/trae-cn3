package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IListClisService.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/im/service/OnboardingStateResponse;", "", "hasRegisteredWork", "", "hasRegisteredIDE", "hasConversation", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getHasRegisteredWork", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHasRegisteredIDE", "getHasConversation", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/bytedance/trae/im/service/OnboardingStateResponse;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class OnboardingStateResponse {

    @SerializedName("has_conversation")
    private final Boolean hasConversation;

    @SerializedName("has_registered_ide")
    private final Boolean hasRegisteredIDE;

    @SerializedName("has_registered_work")
    private final Boolean hasRegisteredWork;

    public OnboardingStateResponse() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ OnboardingStateResponse copy$default(OnboardingStateResponse onboardingStateResponse, Boolean bool, Boolean bool2, Boolean bool3, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = onboardingStateResponse.hasRegisteredWork;
        }
        if ((i & 2) != 0) {
            bool2 = onboardingStateResponse.hasRegisteredIDE;
        }
        if ((i & 4) != 0) {
            bool3 = onboardingStateResponse.hasConversation;
        }
        return onboardingStateResponse.copy(bool, bool2, bool3);
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getHasRegisteredWork() {
        return this.hasRegisteredWork;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getHasRegisteredIDE() {
        return this.hasRegisteredIDE;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getHasConversation() {
        return this.hasConversation;
    }

    public final OnboardingStateResponse copy(Boolean hasRegisteredWork, Boolean hasRegisteredIDE, Boolean hasConversation) {
        return new OnboardingStateResponse(hasRegisteredWork, hasRegisteredIDE, hasConversation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnboardingStateResponse)) {
            return false;
        }
        OnboardingStateResponse onboardingStateResponse = (OnboardingStateResponse) other;
        return Intrinsics.areEqual(this.hasRegisteredWork, onboardingStateResponse.hasRegisteredWork) && Intrinsics.areEqual(this.hasRegisteredIDE, onboardingStateResponse.hasRegisteredIDE) && Intrinsics.areEqual(this.hasConversation, onboardingStateResponse.hasConversation);
    }

    public int hashCode() {
        Boolean bool = this.hasRegisteredWork;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.hasRegisteredIDE;
        int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.hasConversation;
        return hashCode2 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        return "OnboardingStateResponse(hasRegisteredWork=" + this.hasRegisteredWork + ", hasRegisteredIDE=" + this.hasRegisteredIDE + ", hasConversation=" + this.hasConversation + ')';
    }

    public OnboardingStateResponse(Boolean bool, Boolean bool2, Boolean bool3) {
        this.hasRegisteredWork = bool;
        this.hasRegisteredIDE = bool2;
        this.hasConversation = bool3;
    }

    public /* synthetic */ OnboardingStateResponse(Boolean bool, Boolean bool2, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : bool3);
    }

    public final Boolean getHasRegisteredWork() {
        return this.hasRegisteredWork;
    }

    public final Boolean getHasRegisteredIDE() {
        return this.hasRegisteredIDE;
    }

    public final Boolean getHasConversation() {
        return this.hasConversation;
    }
}
