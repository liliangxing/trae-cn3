package kotlinx.datetime.internal.format.parser;

import kotlin.Metadata;

/* compiled from: ParserOperation.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b`\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u001f\u0010\u0004\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlinx/datetime/internal/format/parser/AssignableField;", "Object", "Type", "", "trySetWithoutReassigning", "container", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "name", "", "getName", "()Ljava/lang/String;", "kotlinx-datetime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes8.dex */
public interface AssignableField<Object, Type> {
    String getName();

    Type trySetWithoutReassigning(Object container, Type newValue);
}
