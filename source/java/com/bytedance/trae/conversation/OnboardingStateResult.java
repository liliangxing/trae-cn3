package com.bytedance.trae.conversation;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CliListRepository.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/conversation/OnboardingStateResult;", "", "state", "Lcom/bytedance/trae/conversation/OnboardingState;", "isSuccess", "", "<init>", "(Lcom/bytedance/trae/conversation/OnboardingState;Z)V", "getState", "()Lcom/bytedance/trae/conversation/OnboardingState;", "()Z", "component1", "component2", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class OnboardingStateResult {
    private final boolean isSuccess;
    private final OnboardingState state;

    public static /* synthetic */ OnboardingStateResult copy$default(OnboardingStateResult onboardingStateResult, OnboardingState onboardingState, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            onboardingState = onboardingStateResult.state;
        }
        if ((i & 2) != 0) {
            z = onboardingStateResult.isSuccess;
        }
        return onboardingStateResult.copy(onboardingState, z);
    }

    /* renamed from: component1, reason: from getter */
    public final OnboardingState getState() {
        return this.state;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    public final OnboardingStateResult copy(OnboardingState state, boolean isSuccess) {
        return new OnboardingStateResult(state, isSuccess);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnboardingStateResult)) {
            return false;
        }
        OnboardingStateResult onboardingStateResult = (OnboardingStateResult) other;
        return Intrinsics.areEqual(this.state, onboardingStateResult.state) && this.isSuccess == onboardingStateResult.isSuccess;
    }

    public int hashCode() {
        OnboardingState onboardingState = this.state;
        return ((onboardingState == null ? 0 : onboardingState.hashCode()) * 31) + Boolean.hashCode(this.isSuccess);
    }

    public String toString() {
        return "OnboardingStateResult(state=" + this.state + ", isSuccess=" + this.isSuccess + ')';
    }

    public OnboardingStateResult(OnboardingState onboardingState, boolean z) {
        this.state = onboardingState;
        this.isSuccess = z;
    }

    public final OnboardingState getState() {
        return this.state;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }
}
