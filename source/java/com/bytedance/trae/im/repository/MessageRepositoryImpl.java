package com.bytedance.trae.im.repository;

import com.bytedance.trae.im.database.ChatMessageDao;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* compiled from: MessageRepository.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u0014J\u001e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;", "Lcom/bytedance/trae/im/repository/MessageRepository;", "dao", "Lcom/bytedance/trae/im/database/ChatMessageDao;", "batchSize", "", "<init>", "(Lcom/bytedance/trae/im/database/ChatMessageDao;I)V", "singleThreadDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "pendingMap", "Ljava/util/HashMap;", "", "Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;", "Lkotlin/collections/HashMap;", "appendThought", "", "taskId", "messageId", "fragment", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flushThought", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writePending", "pending", "PendingThought", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MessageRepositoryImpl implements MessageRepository {
    public static final int BATCH_SIZE = 20;
    private final int batchSize;
    private final ChatMessageDao dao;
    private final HashMap<String, PendingThought> pendingMap;
    private final CoroutineDispatcher singleThreadDispatcher;

    public MessageRepositoryImpl(ChatMessageDao chatMessageDao, int i) {
        Intrinsics.checkNotNullParameter(chatMessageDao, "dao");
        this.dao = chatMessageDao;
        this.batchSize = i;
        this.singleThreadDispatcher = Dispatchers.getIO().limitedParallelism(1);
        this.pendingMap = new HashMap<>();
    }

    public /* synthetic */ MessageRepositoryImpl(ChatMessageDao chatMessageDao, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(chatMessageDao, (i2 & 2) != 0 ? 20 : i);
    }

    @Override // com.bytedance.trae.im.repository.MessageRepository
    public Object appendThought(String str, String str2, String str3, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.singleThreadDispatcher, new MessageRepositoryImpl$appendThought$2(this, str, str3, str2, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    @Override // com.bytedance.trae.im.repository.MessageRepository
    public Object flushThought(String str, String str2, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.singleThreadDispatcher, new MessageRepositoryImpl$flushThought$2(this, str, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writePending(String taskId, PendingThought pending) {
        ChatMessageDao chatMessageDao = this.dao;
        String messageId = pending.getMessageId();
        int batchIndex = pending.getBatchIndex();
        String sb = pending.getBuffer().toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        chatMessageDao.insert(taskId, messageId, "thought", batchIndex, sb);
        StringsKt.clear(pending.getBuffer());
        pending.setFragmentCount(0);
        pending.setBatchIndex(pending.getBatchIndex() + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MessageRepository.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\b\u001a\u00060\tj\u0002`\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;", "", "messageId", "", "<init>", "(Ljava/lang/String;)V", "getMessageId", "()Ljava/lang/String;", "buffer", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getBuffer", "()Ljava/lang/StringBuilder;", "fragmentCount", "", "getFragmentCount", "()I", "setFragmentCount", "(I)V", "batchIndex", "getBatchIndex", "setBatchIndex", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class PendingThought {
        private int batchIndex;
        private final StringBuilder buffer;
        private int fragmentCount;
        private final String messageId;

        public PendingThought(String str) {
            Intrinsics.checkNotNullParameter(str, "messageId");
            this.messageId = str;
            this.buffer = new StringBuilder();
        }

        public final String getMessageId() {
            return this.messageId;
        }

        public final StringBuilder getBuffer() {
            return this.buffer;
        }

        public final int getFragmentCount() {
            return this.fragmentCount;
        }

        public final void setFragmentCount(int i) {
            this.fragmentCount = i;
        }

        public final int getBatchIndex() {
            return this.batchIndex;
        }

        public final void setBatchIndex(int i) {
            this.batchIndex = i;
        }
    }
}
