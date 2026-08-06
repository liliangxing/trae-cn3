package com.bytedance.trae.conversation;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;

/* compiled from: CliListRepository.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/OnboardingState;", "", "hasRegisteredWork", "", "hasRegisteredIDE", "hasConversation", "<init>", "(ZZZ)V", "getHasRegisteredWork", "()Z", "getHasRegisteredIDE", "getHasConversation", "component1", "component2", "component3", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class OnboardingState {
    private final boolean hasConversation;
    private final boolean hasRegisteredIDE;
    private final boolean hasRegisteredWork;

    public static /* synthetic */ OnboardingState copy$default(OnboardingState onboardingState, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = onboardingState.hasRegisteredWork;
        }
        if ((i & 2) != 0) {
            z2 = onboardingState.hasRegisteredIDE;
        }
        if ((i & 4) != 0) {
            z3 = onboardingState.hasConversation;
        }
        return onboardingState.copy(z, z2, z3);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getHasRegisteredWork() {
        return this.hasRegisteredWork;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getHasRegisteredIDE() {
        return this.hasRegisteredIDE;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getHasConversation() {
        return this.hasConversation;
    }

    public final OnboardingState copy(boolean hasRegisteredWork, boolean hasRegisteredIDE, boolean hasConversation) {
        return new OnboardingState(hasRegisteredWork, hasRegisteredIDE, hasConversation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnboardingState)) {
            return false;
        }
        OnboardingState onboardingState = (OnboardingState) other;
        return this.hasRegisteredWork == onboardingState.hasRegisteredWork && this.hasRegisteredIDE == onboardingState.hasRegisteredIDE && this.hasConversation == onboardingState.hasConversation;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.hasRegisteredWork) * 31) + Boolean.hashCode(this.hasRegisteredIDE)) * 31) + Boolean.hashCode(this.hasConversation);
    }

    public String toString() {
        return "OnboardingState(hasRegisteredWork=" + this.hasRegisteredWork + ", hasRegisteredIDE=" + this.hasRegisteredIDE + ", hasConversation=" + this.hasConversation + ')';
    }

    public OnboardingState(boolean z, boolean z2, boolean z3) {
        this.hasRegisteredWork = z;
        this.hasRegisteredIDE = z2;
        this.hasConversation = z3;
    }

    public final boolean getHasRegisteredWork() {
        return this.hasRegisteredWork;
    }

    public final boolean getHasRegisteredIDE() {
        return this.hasRegisteredIDE;
    }

    public final boolean getHasConversation() {
        return this.hasConversation;
    }
}
