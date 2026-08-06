package com.bytedance.sdk.xbridge.cn.calendar.reducer;

import android.database.Cursor;
import com.bytedance.sdk.xbridge.cn.calendar.model.CalendarModel;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* compiled from: CalendarUpdateReducer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlin/sequences/SequenceScope;", "Lcom/bytedance/sdk/xbridge/cn/calendar/model/CalendarModel;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.sdk.xbridge.cn.calendar.reducer.CalendarUpdateReducer$getCalendars$1$1", f = "CalendarUpdateReducer.kt", i = {0}, l = {130}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class CalendarUpdateReducer$getCalendars$1$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super CalendarModel>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Cursor $it;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CalendarUpdateReducer$getCalendars$1$1(Cursor cursor, Continuation<? super CalendarUpdateReducer$getCalendars$1$1> continuation) {
        super(2, continuation);
        this.$it = cursor;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> calendarUpdateReducer$getCalendars$1$1 = new CalendarUpdateReducer$getCalendars$1$1(this.$it, continuation);
        calendarUpdateReducer$getCalendars$1$1.L$0 = obj;
        return calendarUpdateReducer$getCalendars$1$1;
    }

    public final Object invoke(SequenceScope<? super CalendarModel> sequenceScope, Continuation<? super Unit> continuation) {
        return create(sequenceScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.L$0;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            sequenceScope = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        while (this.$it.moveToNext()) {
            long j = this.$it.getLong(0);
            String string = this.$it.getString(1);
            String string2 = this.$it.getString(2);
            String string3 = this.$it.getString(3);
            this.L$0 = sequenceScope;
            this.label = 1;
            if (sequenceScope.yield(new CalendarModel(j, string, string2, this.$it.getString(4), string3, this.$it.getInt(5), this.$it.getString(6), 0, 128, null), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
