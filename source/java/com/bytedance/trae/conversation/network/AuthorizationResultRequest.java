package com.bytedance.trae.conversation.network;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/network/AuthorizationResultRequest;", "", "cliId", "", "path", StrategyConstants.ACTION, "mode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCliId", "()Ljava/lang/String;", "getPath", "getAction", "getMode", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AuthorizationResultRequest {

    @SerializedName(StrategyConstants.ACTION)
    private final String action;

    @SerializedName("cli_id")
    private final String cliId;

    @SerializedName("mode")
    private final String mode;

    @SerializedName("path")
    private final String path;

    public static /* synthetic */ AuthorizationResultRequest copy$default(AuthorizationResultRequest authorizationResultRequest, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authorizationResultRequest.cliId;
        }
        if ((i & 2) != 0) {
            str2 = authorizationResultRequest.path;
        }
        if ((i & 4) != 0) {
            str3 = authorizationResultRequest.action;
        }
        if ((i & 8) != 0) {
            str4 = authorizationResultRequest.mode;
        }
        return authorizationResultRequest.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCliId() {
        return this.cliId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    public final AuthorizationResultRequest copy(String cliId, String path, String action, String mode) {
        Intrinsics.checkNotNullParameter(cliId, "cliId");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(mode, "mode");
        return new AuthorizationResultRequest(cliId, path, action, mode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthorizationResultRequest)) {
            return false;
        }
        AuthorizationResultRequest authorizationResultRequest = (AuthorizationResultRequest) other;
        return Intrinsics.areEqual(this.cliId, authorizationResultRequest.cliId) && Intrinsics.areEqual(this.path, authorizationResultRequest.path) && Intrinsics.areEqual(this.action, authorizationResultRequest.action) && Intrinsics.areEqual(this.mode, authorizationResultRequest.mode);
    }

    public int hashCode() {
        return (((((this.cliId.hashCode() * 31) + this.path.hashCode()) * 31) + this.action.hashCode()) * 31) + this.mode.hashCode();
    }

    public String toString() {
        return "AuthorizationResultRequest(cliId=" + this.cliId + ", path=" + this.path + ", action=" + this.action + ", mode=" + this.mode + ')';
    }

    public AuthorizationResultRequest(String cliId, String path, String action, String mode) {
        Intrinsics.checkNotNullParameter(cliId, "cliId");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.cliId = cliId;
        this.path = path;
        this.action = action;
        this.mode = mode;
    }

    public final String getCliId() {
        return this.cliId;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getMode() {
        return this.mode;
    }
}
