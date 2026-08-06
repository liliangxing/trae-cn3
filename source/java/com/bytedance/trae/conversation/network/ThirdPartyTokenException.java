package com.bytedance.trae.conversation.network;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ThirdPartyTokenRepository.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0003\u0007\b\tB\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "<init>", "(Ljava/lang/String;)V", "ServerError", "HttpError", "DecodingFailed", "Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$DecodingFailed;", "Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$HttpError;", "Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$ServerError;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class ThirdPartyTokenException extends Exception {
    public /* synthetic */ ThirdPartyTokenException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private ThirdPartyTokenException(String str) {
        super(str);
    }

    /* compiled from: ThirdPartyTokenRepository.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$ServerError;", "Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException;", "code", "", "serverMessage", "statusCode", "", "body", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getServerMessage", "getStatusCode", "()I", "getBody", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class ServerError extends ThirdPartyTokenException {
        private final String body;
        private final String code;
        private final String serverMessage;
        private final int statusCode;

        public final String getCode() {
            return this.code;
        }

        public final String getServerMessage() {
            return this.serverMessage;
        }

        public final int getStatusCode() {
            return this.statusCode;
        }

        public final String getBody() {
            return this.body;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ServerError(String str, String str2, int i, String str3) {
            super(StringsKt.trim(CollectionsKt.joinToString$default(CollectionsKt.listOf(new String[]{str, str2}), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)).toString(), null);
            Intrinsics.checkNotNullParameter(str, "code");
            Intrinsics.checkNotNullParameter(str2, "serverMessage");
            this.code = str;
            this.serverMessage = str2;
            this.statusCode = i;
            this.body = str3;
        }
    }

    /* compiled from: ThirdPartyTokenRepository.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$HttpError;", "Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException;", "statusCode", "", "body", "", "<init>", "(ILjava/lang/String;)V", "getStatusCode", "()I", "getBody", "()Ljava/lang/String;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class HttpError extends ThirdPartyTokenException {
        private final String body;
        private final int statusCode;

        public final int getStatusCode() {
            return this.statusCode;
        }

        public final String getBody() {
            return this.body;
        }

        public HttpError(int i, String str) {
            super("HTTP " + i, null);
            this.statusCode = i;
            this.body = str;
        }
    }

    /* compiled from: ThirdPartyTokenRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$DecodingFailed;", "Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException;", "message", "", "<init>", "(Ljava/lang/String;)V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class DecodingFailed extends ThirdPartyTokenException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DecodingFailed(String str) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "message");
        }
    }
}
