# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;
.super Ljava/lang/Object;
.source "SubtitleBinaryProtocol.kt"

.field private static final HEADER_SIZE:I
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;
.field public static final MAGIC_CONV:I
.field public static final MAGIC_SUBV:I
.field private static final TAG:Ljava/lang/String;
.field private static debugLogEnabled:Z


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;
    invoke-direct v0, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final buildBinaryMessage(java.lang.String  java.lang.String)byte[]
    .registers 6
    # ins_size=3
    const-string v0, "magic"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-virtual v4, v0, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B
    move-result-object v4
    const-string v0, "getBytes(...)"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    array-length v1, v4
    const/4 v2, 4
    if-ne v1, v2, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +02ch
    sget-object v1, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-virtual v5, v1, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B
    move-result-object v5
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    array-length v0, v5
    add-int/lit8 v0, v0, 8
    invoke-static v0, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;
    move-result-object v0
    sget-object v1, Ljava/nio/ByteOrder;->BIG_ENDIAN Ljava/nio/ByteOrder;
    invoke-virtual v0, v1, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    move-result-object v0
    invoke-virtual v0, v4, Ljava/nio/ByteBuffer;->put([B)Ljava/nio/ByteBuffer;
    array-length v4, v5
    invoke-virtual v0, v4, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;
    invoke-virtual v0, v5, Ljava/nio/ByteBuffer;->put([B)Ljava/nio/ByteBuffer;
    invoke-virtual v0, Ljava/nio/ByteBuffer;->array()[B
    move-result-object v4
    const-string v5, "array(...)"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v4
    new-instance v4, Ljava/lang/IllegalArgumentException;
    const-string v5, "magic must be 4 bytes"
    invoke-virtual v5, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-direct v4, v5, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V
    throw v4
.end method

.method public final buildFinishRecognitionCtrlMessage()byte[]
    .registers 3
    # ins_size=1
    const-string/jumbo v0, {"Command":"FinishSpeechRecognition"}
    const-string v1, "ctrl"
    invoke-virtual v2, v1, v0, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;->buildBinaryMessage(Ljava/lang/String; Ljava/lang/String;)[B
    move-result-object v0
    return-object v0
.end method

.method public final getDebugLogEnabled()boolean
    .registers 2
    # ins_size=1
    sget-boolean v0, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;->debugLogEnabled Z
    return v0
.end method

.method public final readMagic(byte[])java.lang.Integer
    .registers 4
    # ins_size=2
    const-string v0, "packet"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    array-length v0, v3
    const/4 v1, 4
    if-ge v0, v1, +004h
    const/4 v3, 0
    return-object v3
    const/4 v0, 0
    invoke-static v3, v0, v1, Ljava/nio/ByteBuffer;->wrap([B I I)Ljava/nio/ByteBuffer;
    move-result-object v3
    sget-object v0, Ljava/nio/ByteOrder;->BIG_ENDIAN Ljava/nio/ByteOrder;
    invoke-virtual v3, v0, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    move-result-object v3
    invoke-virtual v3, Ljava/nio/ByteBuffer;->getInt()I
    move-result v3
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    return-object v3
.end method

.method public final setDebugLogEnabled(boolean)void
    .registers 2
    # ins_size=2
    sput-boolean v1, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;->debugLogEnabled Z
    return-void 
.end method

.method public final unpackConvMessage(byte[])com.bytedance.trae.conversation.voice.ConversationStateMessage
    .registers 9
    # ins_size=2
    const-string v0, "conv state: stage="
    const-string v1, "packet"
    invoke-static v8, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const v1, 1668247158
    invoke-virtual v7, v8, v1, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;->unpackPayload([B I)Ljava/lang/String;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    const/4 v2, 1
    const/4 v3, 0
    const-string v4, "SubtitleBinaryProtocol"
    if-eqz v2, +016h
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "conv unpack failed: size="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    array-length v8, v8
    invoke-virtual v0, v8, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-static v4, v8, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String;)I
    return-object v3
    sget-object v8, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v8, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v8
    const-class v2, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;
    invoke-virtual v8, v1, v2, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->getStage()Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;->getCode()I
    move-result v0
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v2, 45
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v8, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->getStage()Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;->getDescription()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, ", roundID="
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v8, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->getRoundID()J
    move-result-wide v5
    invoke-virtual v0, v5, v6, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, ", taskId="
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v8, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->getTaskId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v4, v0, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    move-object v3, v8
    goto +14h
    move-exception v8
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v2, "conv parse failed: "
    invoke-direct v0, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v4, v0, v8, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-object v3
    :try_start_0x36
.end method

.method public final unpackPayload(byte[]  int)java.lang.String
    .registers 8
    # ins_size=3
    const-string v0, "packet"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    array-length v0, v6
    const-string v1, "SubtitleBinaryProtocol"
    const/4 v2, 0
    const/16 v3, 8
    if-ge v0, v3, +021h
    sget-boolean v7, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;->debugLogEnabled Z
    if-eqz v7, +01ch
    new-instance v7, Ljava/lang/StringBuilder;
    const-string/jumbo v0, unpack failed: packet too small, size=
    invoke-direct v7, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    array-length v6, v6
    invoke-virtual v7, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, ", required=8"
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-static v1, v6, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String;)I
    return-object v2
    invoke-static v6, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;
    move-result-object v0
    sget-object v4, Ljava/nio/ByteOrder;->BIG_ENDIAN Ljava/nio/ByteOrder;
    invoke-virtual v0, v4, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    move-result-object v0
    invoke-virtual v0, Ljava/nio/ByteBuffer;->getInt()I
    move-result v4
    if-eq v4, v7, +03fh
    sget-boolean v6, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;->debugLogEnabled Z
    if-eqz v6, +03ah
    new-instance v6, Ljava/lang/StringBuilder;
    const-string/jumbo v0, unpack failed: magic mismatch, expected=0x
    invoke-direct v6, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const/16 v0, 16
    invoke-static v0, Lkotlin/text/CharsKt;->checkRadix(I)I
    move-result v3
    invoke-static v7, v3, Ljava/lang/Integer;->toString(I I)Ljava/lang/String;
    move-result-object v7
    const-string/jumbo v3, toString(...)
    invoke-static v7, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, ", actual=0x"
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-static v0, Lkotlin/text/CharsKt;->checkRadix(I)I
    move-result v7
    invoke-static v4, v7, Ljava/lang/Integer;->toString(I I)Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-static v1, v6, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String;)I
    return-object v2
    invoke-virtual v0, Ljava/nio/ByteBuffer;->getInt()I
    move-result v7
    array-length v6, v6
    sub-int/2addr v6, v3
    if-eq v6, v7, +024h
    sget-boolean v0, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;->debugLogEnabled Z
    if-eqz v0, +01fh
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v3, unpack failed: length mismatch, header.length=
    invoke-direct v0, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v0, ", actual.payloadSize="
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-static v1, v6, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String;)I
    return-object v2
    if-gtz v7, +005h
    const-string v6, ""
    return-object v6
    new-array v6, v7, [B
    invoke-virtual v0, v6, Ljava/nio/ByteBuffer;->get([B)Ljava/nio/ByteBuffer;
    new-instance v7, Ljava/lang/String;
    sget-object v0, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-direct v7, v6, v0, Ljava/lang/String;-><init>([B Ljava/nio/charset/Charset;)V
    return-object v7
.end method

.method public final unpackSubvMessage(byte[])com.bytedance.trae.conversation.voice.subtitle.SubtitleBinaryProtocol$SubtitlePayload
    .registers 7
    # ins_size=2
    const-string v0, "packet"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const v0, 1937072758
    invoke-virtual v5, v6, v0, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;->unpackPayload([B I)Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    const/4 v1, 1
    const/4 v2, 0
    const-string v3, "SubtitleBinaryProtocol"
    if-eqz v1, +017h
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, subv unpack failed: size=
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    array-length v6, v6
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-static v3, v6, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String;)I
    return-object v2
    sget-object v6, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v6, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v6
    const-class v1, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitlePayload;
    invoke-virtual v6, v0, v1, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitlePayload;
    move-object v2, v6
    goto +15h
    move-exception v6
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v4, subv parse failed: 
    invoke-direct v1, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v3, v0, v6, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-object v2
    :try_start_0x35
.end method

.method public final unpackSubvPayload(byte[])java.lang.String
    .registers 7
    # ins_size=2
    const-string v0, "packet"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    array-length v0, v6
    const/4 v1, 0
    const/16 v2, 8
    if-ge v0, v2, +003h
    return-object v1
    invoke-static v6, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;
    move-result-object v0
    sget-object v3, Ljava/nio/ByteOrder;->BIG_ENDIAN Ljava/nio/ByteOrder;
    invoke-virtual v0, v3, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    move-result-object v0
    invoke-virtual v0, Ljava/nio/ByteBuffer;->getInt()I
    move-result v3
    const v4, 1937072758
    if-eq v3, v4, +003h
    return-object v1
    invoke-virtual v0, Ljava/nio/ByteBuffer;->getInt()I
    move-result v3
    array-length v6, v6
    sub-int/2addr v6, v2
    if-eq v6, v3, +003h
    return-object v1
    if-gtz v3, +005h
    const-string v6, ""
    return-object v6
    new-array v6, v3, [B
    invoke-virtual v0, v6, Ljava/nio/ByteBuffer;->get([B)Ljava/nio/ByteBuffer;
    new-instance v0, Ljava/lang/String;
    sget-object v1, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-direct v0, v6, v1, Ljava/lang/String;-><init>([B Ljava/nio/charset/Charset;)V
    return-object v0
.end method
