package com.bytedance.trae.conversation.voice.subtitle;

import android.util.Log;
import com.bytedance.trae.conversation.voice.ConversationStateMessage;
import com.bytedance.trae.conversation.voice.VoiceAttemptMetricsTracker;
import com.bytedance.trae.network.TraeHttpConnection;
import com.google.gson.annotations.SerializedName;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;

/* compiled from: SubtitleBinaryProtocol.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u001f B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0011J\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\u0011¢\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0007J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0016\u001a\u00020\u0011J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0016\u001a\u00020\u0011J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;", "", "<init>", "()V", "TAG", "", "HEADER_SIZE", "", "MAGIC_SUBV", "MAGIC_CONV", "debugLogEnabled", "", "getDebugLogEnabled", "()Z", "setDebugLogEnabled", "(Z)V", "buildBinaryMessage", "", "magic", "message", "buildFinishRecognitionCtrlMessage", "readMagic", "packet", "([B)Ljava/lang/Integer;", "unpackPayload", "expectedMagic", "unpackConvMessage", "Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;", "unpackSubvMessage", "Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitlePayload;", "unpackSubvPayload", "SubtitlePayload", "SubtitleItem", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SubtitleBinaryProtocol {
    private static final int HEADER_SIZE = 8;
    public static final SubtitleBinaryProtocol INSTANCE = new SubtitleBinaryProtocol();
    public static final int MAGIC_CONV = 1668247158;
    public static final int MAGIC_SUBV = 1937072758;
    private static final String TAG = "SubtitleBinaryProtocol";
    private static boolean debugLogEnabled;

    private SubtitleBinaryProtocol() {
    }

    public final boolean getDebugLogEnabled() {
        return debugLogEnabled;
    }

    public final void setDebugLogEnabled(boolean z) {
        debugLogEnabled = z;
    }

    public final byte[] buildBinaryMessage(String magic, String message) {
        Intrinsics.checkNotNullParameter(magic, "magic");
        Intrinsics.checkNotNullParameter(message, "message");
        byte[] bytes = magic.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        if (!(bytes.length == 4)) {
            throw new IllegalArgumentException("magic must be 4 bytes".toString());
        }
        byte[] bytes2 = message.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        ByteBuffer order = ByteBuffer.allocate(bytes2.length + 8).order(ByteOrder.BIG_ENDIAN);
        order.put(bytes);
        order.putInt(bytes2.length);
        order.put(bytes2);
        byte[] array = order.array();
        Intrinsics.checkNotNullExpressionValue(array, "array(...)");
        return array;
    }

    public final byte[] buildFinishRecognitionCtrlMessage() {
        return buildBinaryMessage("ctrl", "{\"Command\":\"FinishSpeechRecognition\"}");
    }

    public final Integer readMagic(byte[] packet) {
        Intrinsics.checkNotNullParameter(packet, "packet");
        if (packet.length < 4) {
            return null;
        }
        return Integer.valueOf(ByteBuffer.wrap(packet, 0, 4).order(ByteOrder.BIG_ENDIAN).getInt());
    }

    public final String unpackPayload(byte[] packet, int expectedMagic) {
        Intrinsics.checkNotNullParameter(packet, "packet");
        if (packet.length < 8) {
            if (debugLogEnabled) {
                Log.w(TAG, "unpack failed: packet too small, size=" + packet.length + ", required=8");
            }
            return null;
        }
        ByteBuffer order = ByteBuffer.wrap(packet).order(ByteOrder.BIG_ENDIAN);
        int i = order.getInt();
        if (i != expectedMagic) {
            if (debugLogEnabled) {
                StringBuilder sb = new StringBuilder("unpack failed: magic mismatch, expected=0x");
                String num = Integer.toString(expectedMagic, CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
                StringBuilder append = sb.append(num).append(", actual=0x");
                String num2 = Integer.toString(i, CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(num2, "toString(...)");
                Log.w(TAG, append.append(num2).toString());
            }
            return null;
        }
        int i2 = order.getInt();
        int length = packet.length - 8;
        if (length != i2) {
            if (debugLogEnabled) {
                Log.w(TAG, "unpack failed: length mismatch, header.length=" + i2 + ", actual.payloadSize=" + length);
            }
            return null;
        }
        if (i2 <= 0) {
            return "";
        }
        byte[] bArr = new byte[i2];
        order.get(bArr);
        return new String(bArr, Charsets.UTF_8);
    }

    public final ConversationStateMessage unpackConvMessage(byte[] packet) {
        Intrinsics.checkNotNullParameter(packet, "packet");
        String unpackPayload = unpackPayload(packet, MAGIC_CONV);
        String str = unpackPayload;
        if (str == null || str.length() == 0) {
            Log.w(TAG, "conv unpack failed: size=" + packet.length);
            return null;
        }
        try {
            ConversationStateMessage conversationStateMessage = (ConversationStateMessage) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(unpackPayload, ConversationStateMessage.class);
            Log.d(TAG, "conv state: stage=" + conversationStateMessage.getStage().getCode() + '-' + conversationStateMessage.getStage().getDescription() + ", roundID=" + conversationStateMessage.getRoundID() + ", taskId=" + conversationStateMessage.getTaskId());
            return conversationStateMessage;
        } catch (Throwable th) {
            Log.w(TAG, "conv parse failed: " + unpackPayload, th);
            return null;
        }
    }

    public final SubtitlePayload unpackSubvMessage(byte[] packet) {
        Intrinsics.checkNotNullParameter(packet, "packet");
        String unpackPayload = unpackPayload(packet, MAGIC_SUBV);
        String str = unpackPayload;
        if (str == null || str.length() == 0) {
            Log.w(TAG, "subv unpack failed: size=" + packet.length);
            return null;
        }
        try {
            return (SubtitlePayload) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(unpackPayload, SubtitlePayload.class);
        } catch (Throwable th) {
            Log.w(TAG, "subv parse failed: " + unpackPayload, th);
            return null;
        }
    }

    public final String unpackSubvPayload(byte[] packet) {
        int i;
        Intrinsics.checkNotNullParameter(packet, "packet");
        if (packet.length < 8) {
            return null;
        }
        ByteBuffer order = ByteBuffer.wrap(packet).order(ByteOrder.BIG_ENDIAN);
        if (order.getInt() != 1937072758 || packet.length - 8 != (i = order.getInt())) {
            return null;
        }
        if (i <= 0) {
            return "";
        }
        byte[] bArr = new byte[i];
        order.get(bArr);
        return new String(bArr, Charsets.UTF_8);
    }

    /* compiled from: SubtitleBinaryProtocol.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitlePayload;", "", "data", "", "Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;", "<init>", "(Ljava/util/List;)V", "getData", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class SubtitlePayload {

        @SerializedName("data")
        private final List<SubtitleItem> data;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public SubtitlePayload() {
            this(r0, 1, r0);
            List list = null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SubtitlePayload copy$default(SubtitlePayload subtitlePayload, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = subtitlePayload.data;
            }
            return subtitlePayload.copy(list);
        }

        public final List<SubtitleItem> component1() {
            return this.data;
        }

        public final SubtitlePayload copy(List<SubtitleItem> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new SubtitlePayload(data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SubtitlePayload) && Intrinsics.areEqual(this.data, ((SubtitlePayload) other).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "SubtitlePayload(data=" + this.data + ')';
        }

        public SubtitlePayload(List<SubtitleItem> list) {
            Intrinsics.checkNotNullParameter(list, "data");
            this.data = list;
        }

        public /* synthetic */ SubtitlePayload(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
        }

        public final List<SubtitleItem> getData() {
            return this.data;
        }
    }

    /* compiled from: SubtitleBinaryProtocol.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;", "", "definite", "", "text", "", VoiceAttemptMetricsTracker.FINAL_SOURCE_PARAGRAPH, "userId", "<init>", "(ZLjava/lang/String;ZLjava/lang/String;)V", "getDefinite", "()Z", "getText", "()Ljava/lang/String;", "getParagraph", "getUserId", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class SubtitleItem {

        @SerializedName("definite")
        private final boolean definite;

        @SerializedName(VoiceAttemptMetricsTracker.FINAL_SOURCE_PARAGRAPH)
        private final boolean paragraph;

        @SerializedName("text")
        private final String text;

        @SerializedName("userId")
        private final String userId;

        public SubtitleItem() {
            this(false, null, false, null, 15, null);
        }

        public static /* synthetic */ SubtitleItem copy$default(SubtitleItem subtitleItem, boolean z, String str, boolean z2, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = subtitleItem.definite;
            }
            if ((i & 2) != 0) {
                str = subtitleItem.text;
            }
            if ((i & 4) != 0) {
                z2 = subtitleItem.paragraph;
            }
            if ((i & 8) != 0) {
                str2 = subtitleItem.userId;
            }
            return subtitleItem.copy(z, str, z2, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getDefinite() {
            return this.definite;
        }

        /* renamed from: component2, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getParagraph() {
            return this.paragraph;
        }

        /* renamed from: component4, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        public final SubtitleItem copy(boolean definite, String text, boolean paragraph, String userId) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(userId, "userId");
            return new SubtitleItem(definite, text, paragraph, userId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubtitleItem)) {
                return false;
            }
            SubtitleItem subtitleItem = (SubtitleItem) other;
            return this.definite == subtitleItem.definite && Intrinsics.areEqual(this.text, subtitleItem.text) && this.paragraph == subtitleItem.paragraph && Intrinsics.areEqual(this.userId, subtitleItem.userId);
        }

        public int hashCode() {
            return (((((Boolean.hashCode(this.definite) * 31) + this.text.hashCode()) * 31) + Boolean.hashCode(this.paragraph)) * 31) + this.userId.hashCode();
        }

        public String toString() {
            return "SubtitleItem(definite=" + this.definite + ", text=" + this.text + ", paragraph=" + this.paragraph + ", userId=" + this.userId + ')';
        }

        public SubtitleItem(boolean z, String str, boolean z2, String str2) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(str2, "userId");
            this.definite = z;
            this.text = str;
            this.paragraph = z2;
            this.userId = str2;
        }

        public /* synthetic */ SubtitleItem(boolean z, String str, boolean z2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? "" : str2);
        }

        public final boolean getDefinite() {
            return this.definite;
        }

        public final String getText() {
            return this.text;
        }

        public final boolean getParagraph() {
            return this.paragraph;
        }

        public final String getUserId() {
            return this.userId;
        }
    }
}
