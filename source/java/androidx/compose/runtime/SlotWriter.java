package androidx.compose.runtime;

import androidx.autofill.HintConstants;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: SlotTable.kt */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0001\u0018\u0000 Ø\u00012\u00020\u0001:\u0002Ø\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u00103\u001a\u00020/2\u0006\u00108\u001a\u00020\u0019J\u000e\u0010!\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019J\u000e\u00109\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019J\u0010\u0010:\u001a\u0004\u0018\u00010\u00012\u0006\u00108\u001a\u00020\u0019J\u000e\u0010;\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019J\u0010\u0010<\u001a\u0004\u0018\u00010\u00012\u0006\u00108\u001a\u00020\u0019J\u000e\u0010=\u001a\u00020/2\u0006\u00108\u001a\u00020\u0019J\u000e\u0010>\u001a\u00020/2\u0006\u00108\u001a\u00020\u0019J\u0016\u0010?\u001a\u00020/2\u0006\u00108\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u0019J\u0010\u0010A\u001a\u0004\u0018\u00010\u00012\u0006\u00108\u001a\u00020\u0019J\u0010\u0010A\u001a\u0004\u0018\u00010\u00012\u0006\u0010B\u001a\u00020\u000fJ\u000e\u0010C\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019J\u000e\u0010C\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\u000fJ\u000e\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020/J\u0006\u0010J\u001a\u00020HJ\u0012\u0010K\u001a\u0004\u0018\u00010\u00012\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u0014\u0010L\u001a\u0004\u0018\u00010\u00012\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0002J\u0018\u0010M\u001a\u00020H2\u0006\u0010B\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u000e\u0010N\u001a\u00020H2\u0006\u0010O\u001a\u00020\u0019J\u0010\u0010P\u001a\u00020H2\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u0010\u0010Q\u001a\u00020H2\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u0006\u0010R\u001a\u00020HJ\u000e\u0010S\u001a\u00020H2\u0006\u0010T\u001a\u00020UJ\u0016\u0010V\u001a\u00020H2\u0006\u0010W\u001a\u00020\u00192\u0006\u0010(\u001a\u00020UJ\u0006\u0010X\u001a\u00020HJ\u001c\u0010Y\u001a\u0004\u0018\u00010\u00132\u0006\u0010C\u001a\u00020\u00192\b\u0010T\u001a\u0004\u0018\u00010UH\u0002J\u0010\u0010Z\u001a\u00020H2\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u0018\u0010Z\u001a\u00020H2\u0006\u0010B\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u0010\u0010[\u001a\u00020H2\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\\\u001a\u00020H2\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u001d\u0010\\\u001a\u0004\u0018\u00010\u00012\u0006\u00108\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0086\bJ\u0016\u0010]\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019J\"\u0010\\\u001a\u0004\u0018\u00010\u00012\u0006\u0010@\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u0010\u0010^\u001a\u0004\u0018\u00010\u00012\u0006\u0010_\u001a\u00020\u0019J\b\u0010`\u001a\u0004\u0018\u00010\u0001J\u0018\u0010a\u001a\u0004\u0018\u00010\u00012\u0006\u0010B\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u0019J\u0018\u0010a\u001a\u0004\u0018\u00010\u00012\u0006\u0010b\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019J5\u0010c\u001a\u00020H2\u0006\u0010b\u001a\u00020\u00192\u0006\u0010O\u001a\u00020\u00192\u001a\u0010d\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020H0eH\u0086\bJ\u0015\u0010f\u001a\u00020\u00192\u0006\u0010b\u001a\u00020\u0019H\u0000¢\u0006\u0002\bgJ\u0015\u0010h\u001a\u00020\u00192\u0006\u0010b\u001a\u00020\u0019H\u0000¢\u0006\u0002\biJ\u0015\u0010j\u001a\u00020\u00192\u0006\u0010b\u001a\u00020\u0019H\u0000¢\u0006\u0002\bkJ\u000e\u0010n\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u0019J\u000e\u0010o\u001a\u00020H2\u0006\u0010p\u001a\u00020\u0019J\u000e\u0010q\u001a\u00020H2\u0006\u0010B\u001a\u00020\u000fJ\u0006\u0010r\u001a\u00020HJ\u0006\u0010s\u001a\u00020HJ\u0006\u0010t\u001a\u00020HJ\u0006\u0010u\u001a\u00020HJ\u000e\u0010u\u001a\u00020H2\u0006\u0010W\u001a\u00020\u0019J\u0018\u0010u\u001a\u00020H2\u0006\u0010W\u001a\u00020\u00192\b\u0010v\u001a\u0004\u0018\u00010\u0001J\u0018\u0010w\u001a\u00020H2\u0006\u0010W\u001a\u00020\u00192\b\u0010x\u001a\u0004\u0018\u00010\u0001J\"\u0010w\u001a\u00020H2\u0006\u0010W\u001a\u00020\u00192\b\u0010x\u001a\u0004\u0018\u00010\u00012\b\u0010A\u001a\u0004\u0018\u00010\u0001J\"\u0010y\u001a\u00020H2\u0006\u0010W\u001a\u00020\u00192\b\u0010x\u001a\u0004\u0018\u00010\u00012\b\u0010z\u001a\u0004\u0018\u00010\u0001J\u0018\u0010y\u001a\u00020H2\u0006\u0010W\u001a\u00020\u00192\b\u0010z\u001a\u0004\u0018\u00010\u0001J,\u0010u\u001a\u00020H2\u0006\u0010W\u001a\u00020\u00192\b\u0010x\u001a\u0004\u0018\u00010\u00012\u0006\u00103\u001a\u00020/2\b\u0010z\u001a\u0004\u0018\u00010\u0001H\u0002J\u0006\u0010{\u001a\u00020\u0019J\u000e\u0010|\u001a\u00020H2\u0006\u00108\u001a\u00020\u0019J\u000e\u0010|\u001a\u00020H2\u0006\u0010B\u001a\u00020\u000fJ\u0006\u0010}\u001a\u00020\u0019J\u0006\u0010~\u001a\u00020/J\u000f\u0010\u007f\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0080\u0001JQ\u0010\u0081\u0001\u001a\u00020H2\u0006\u0010@\u001a\u00020\u00192=\u0010d\u001a9\u0012\u0015\u0012\u00130\u0019¢\u0006\u000e\b\u0082\u0001\u0012\t\b\u0083\u0001\u0012\u0004\b\b(8\u0012\u0018\u0012\u0016\u0018\u00010\u0001¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(\u0084\u0001\u0012\u0004\u0012\u00020H0eH\u0086\bJb\u0010\u0085\u0001\u001a\u00020H2\u0006\u0010@\u001a\u00020\u00192&\u0010\u0086\u0001\u001a!\u0012\u0016\u0012\u00140\u0019¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(\u0088\u0001\u0012\u0004\u0012\u00020H0\u0087\u00012&\u0010\u0089\u0001\u001a!\u0012\u0016\u0012\u00140\u0019¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(\u0088\u0001\u0012\u0004\u0012\u00020H0\u0087\u0001H\u0086\bJN\u0010\u008a\u0001\u001a\u00020H2\u0006\u0010@\u001a\u00020\u00192=\u0010d\u001a9\u0012\u0015\u0012\u00130\u0019¢\u0006\u000e\b\u0082\u0001\u0012\t\b\u0083\u0001\u0012\u0004\b\b(8\u0012\u0018\u0012\u0016\u0018\u00010\u0001¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(\u0084\u0001\u0012\u0004\u0012\u00020H0eJ\u0010\u0010\u008b\u0001\u001a\u00020H2\u0007\u0010\u008c\u0001\u001a\u00020\u0019J\u0018\u0010\u008d\u0001\u001a\u00020/2\u0007\u0010\u008e\u0001\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000fJ(\u0010\u008f\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0\u0090\u00012\u0006\u0010B\u001a\u00020\u000f2\u0007\u0010\u008c\u0001\u001a\u00020\u00192\u0007\u0010\u0091\u0001\u001a\u00020\u0000J)\u0010\u0092\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0\u0090\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00192\t\b\u0002\u0010\u0093\u0001\u001a\u00020/J\u0007\u0010\u0094\u0001\u001a\u00020HJ'\u0010\u0095\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0\u0090\u00012\u0007\u0010\u008c\u0001\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0019J\u0010\u0010B\u001a\u00020\u000f2\b\b\u0002\u00108\u001a\u00020\u0019J\u0011\u0010\u0096\u0001\u001a\u00020H2\b\b\u0002\u0010@\u001a\u00020\u0019J\u0011\u0010\u0097\u0001\u001a\u00020/2\u0006\u0010@\u001a\u00020\u0019H\u0002J\u0011\u0010\u0098\u0001\u001a\u00020/2\u0006\u0010@\u001a\u00020\u0019H\u0002J\t\u0010\u009c\u0001\u001a\u00020HH\u0002J\u0011\u0010\u009d\u0001\u001a\u00020H2\u0006\u0010@\u001a\u00020\u0019H\u0002J#\u0010\u009e\u0001\u001a\u00020H2\u0006\u0010@\u001a\u00020\u00192\u0007\u0010\\\u001a\u00030\u009a\u0001H\u0002¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J\u0011\u0010¡\u0001\u001a\u00020/2\u0006\u0010@\u001a\u00020\u0019H\u0002J\u000f\u0010¢\u0001\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\u000fJ\t\u0010£\u0001\u001a\u00020UH\u0016J\t\u0010¤\u0001\u001a\u00020HH\u0002J\t\u0010¥\u0001\u001a\u00020\u0019H\u0002J\"\u0010¦\u0001\u001a\u00020H2\u0006\u0010C\u001a\u00020\u00192\u0006\u0010{\u001a\u00020\u00192\u0007\u0010§\u0001\u001a\u00020\u0019H\u0002J\u0011\u0010¨\u0001\u001a\u00020H2\u0006\u00108\u001a\u00020\u0019H\u0002J\u0019\u0010©\u0001\u001a\u00020H2\u0006\u00108\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u0019H\u0002J\t\u0010ª\u0001\u001a\u00020HH\u0002J\u0012\u0010«\u0001\u001a\u00020H2\u0007\u0010¬\u0001\u001a\u00020\u0019H\u0002J\u001a\u0010\u00ad\u0001\u001a\u00020H2\u0007\u0010¬\u0001\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u0019H\u0002J\u001b\u0010®\u0001\u001a\u00020/2\u0007\u0010¯\u0001\u001a\u00020\u00192\u0007\u0010°\u0001\u001a\u00020\u0019H\u0002J\u0019\u0010±\u0001\u001a\u0004\u0018\u00010\u00132\u0006\u0010@\u001a\u00020\u0019H\u0000¢\u0006\u0003\b²\u0001J\u0019\u0010³\u0001\u001a\u0004\u0018\u00010\u000f2\u0006\u0010@\u001a\u00020\u0019H\u0000¢\u0006\u0003\b´\u0001J#\u0010µ\u0001\u001a\u00020H2\u0007\u0010¯\u0001\u001a\u00020\u00192\u0007\u0010°\u0001\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u0019H\u0002J\u001b\u0010¶\u0001\u001a\u00020H2\u0006\u00108\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0002J\u001b\u0010·\u0001\u001a\u00020H2\u0007\u0010¸\u0001\u001a\u00020\u00192\u0007\u0010¹\u0001\u001a\u00020\u0019H\u0002JC\u0010º\u0001\u001a\u00020/2\u0007\u0010»\u0001\u001a\u00020\u00192\u0007\u0010¬\u0001\u001a\u00020\u00192&\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0014H\u0002J$\u0010¼\u0001\u001a\u00020H2\u0007\u0010½\u0001\u001a\u00020\u00192\u0007\u0010¾\u0001\u001a\u00020\u00192\u0007\u0010¬\u0001\u001a\u00020\u0019H\u0002J\u0007\u0010¿\u0001\u001a\u00020UJ\u001b\u0010À\u0001\u001a\u00020H*\b0Á\u0001j\u0003`Â\u00012\u0006\u00108\u001a\u00020\u0019H\u0002J\u000f\u0010Ã\u0001\u001a\u00020HH\u0000¢\u0006\u0003\bÄ\u0001J\u000f\u0010Å\u0001\u001a\u00020HH\u0000¢\u0006\u0003\bÆ\u0001J\u0011\u0010Ê\u0001\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019H\u0002J\u0012\u0010Ë\u0001\u001a\u00020\u00192\u0007\u0010Ì\u0001\u001a\u00020\u0019H\u0002J\u0014\u0010C\u001a\u00020\u0019*\u00020\t2\u0006\u00108\u001a\u00020\u0019H\u0002J\u0011\u0010Ì\u0001\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019H\u0002J\u0016\u0010Ì\u0001\u001a\u00020\u0019*\u00020\t2\u0007\u0010Í\u0001\u001a\u00020\u0019H\u0002J\u0015\u0010_\u001a\u00020\u0019*\u00020\t2\u0007\u0010Í\u0001\u001a\u00020\u0019H\u0002J\u001f\u0010Î\u0001\u001a\u00020H*\u00020\t2\u0007\u0010Í\u0001\u001a\u00020\u00192\u0007\u0010Ì\u0001\u001a\u00020\u0019H\u0002J\u0016\u0010Ï\u0001\u001a\u00020\u0019*\u00020\t2\u0007\u0010Í\u0001\u001a\u00020\u0019H\u0002J\u0016\u0010Ð\u0001\u001a\u00020\u0019*\u00020\t2\u0007\u0010Í\u0001\u001a\u00020\u0019H\u0002J\u0014\u0010Ñ\u0001\u001a\t\u0012\u0004\u0012\u00020\u00190\u0090\u0001*\u00020\tH\u0002J\u0010\u0010Ò\u0001\u001a\t\u0012\u0004\u0012\u00020\u00190\u0090\u0001H\u0002J,\u0010Ó\u0001\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u00192\u0007\u0010»\u0001\u001a\u00020\u00192\u0007\u0010Ô\u0001\u001a\u00020\u00192\u0007\u0010È\u0001\u001a\u00020\u0019H\u0002J#\u0010Õ\u0001\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\u00192\u0007\u0010Ô\u0001\u001a\u00020\u00192\u0007\u0010È\u0001\u001a\u00020\u0019H\u0002J\u001a\u0010Ö\u0001\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u00192\u0007\u0010»\u0001\u001a\u00020\u0019H\u0002J\u0011\u0010×\u0001\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010'\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001e\u0010,\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u0011\u0010.\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b.\u00100R\u0011\u00101\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b2\u0010+R\u0011\u00103\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b3\u00100R\u0011\u00104\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b5\u00100R\u0011\u00106\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b7\u00100R\u001e\u0010C\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bD\u0010+R\u001e\u0010E\u001a\u00020/2\u0006\u0010(\u001a\u00020/@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bF\u00100R\u0014\u0010l\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bm\u0010+R\u0015\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001X\u0082\u000e¢\u0006\u0005\n\u0003\u0010\u009b\u0001R\u0016\u0010¬\u0001\u001a\u00020\u00198@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bÇ\u0001\u0010+R\u0016\u0010È\u0001\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÉ\u0001\u0010+¨\u0006Ù\u0001"}, d2 = {"Landroidx/compose/runtime/SlotWriter;", "", "table", "Landroidx/compose/runtime/SlotTable;", "<init>", "(Landroidx/compose/runtime/SlotTable;)V", "getTable$runtime", "()Landroidx/compose/runtime/SlotTable;", "groups", "", "slots", "", "[Ljava/lang/Object;", "anchors", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/Anchor;", "Lkotlin/collections/ArrayList;", "sourceInformationMap", "Ljava/util/HashMap;", "Landroidx/compose/runtime/GroupSourceInformation;", "Lkotlin/collections/HashMap;", "calledByMap", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/collection/MutableIntSet;", "groupGapStart", "", "groupGapLen", "currentSlot", "currentSlotEnd", "slotsGapStart", "slotsGapLen", "slotsGapOwner", "insertCount", "nodeCount", "startStack", "Landroidx/compose/runtime/IntStack;", "endStack", "nodeCountStack", "deferredSlotWrites", "Landroidx/collection/MutableObjectList;", "value", "currentGroup", "getCurrentGroup", "()I", "currentGroupEnd", "getCurrentGroupEnd", "isGroupEnd", "", "()Z", "slotsSize", "getSlotsSize", "isNode", "collectingSourceInformation", "getCollectingSourceInformation", "collectingCalledInformation", "getCollectingCalledInformation", "index", "groupKey", "groupObjectKey", "groupSize", "groupAux", "indexInParent", "indexInCurrentGroup", "indexInGroup", "group", "node", "anchor", "parent", "getParent", "closed", "getClosed", "close", "", "normalClose", "reset", "update", "rawUpdate", "appendSlot", "trimTailSlots", "count", "updateAux", "insertAux", "updateToTableMaps", "recordGroupSourceInformation", "sourceInformation", "", "recordGrouplessCallSourceInformationStart", "key", "recordGrouplessCallSourceInformationEnd", "groupSourceInformationFor", "updateNode", "updateParentNode", "set", "slotIndexOfGroupSlotIndex", "clear", "slotIndex", "skip", "slot", "groupIndex", "forEachTailSlot", "block", "Lkotlin/Function2;", "slotsStartIndex", "slotsStartIndex$runtime", "slotsEndIndex", "slotsEndIndex$runtime", "slotsEndAllIndex", "slotsEndAllIndex$runtime", "currentGroupSlotIndex", "getCurrentGroupSlotIndex", "groupSlotIndex", "advanceBy", "amount", "seek", "skipToGroupEnd", "beginInsert", "endInsert", "startGroup", "dataKey", "startNode", "objectKey", "startData", "aux", "endGroup", "ensureStarted", "skipGroup", "removeGroup", "groupSlots", "", "forAllData", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "data", "traverseGroupAndChildren", "enter", "Lkotlin/Function1;", "child", "exit", "forAllDataInRememberOrder", "moveGroup", "offset", "inGroup", "groupAnchor", "moveTo", "", "writer", "moveFrom", "removeSourceGroup", "bashCurrentGroup", "moveIntoGroupFrom", "markGroup", "containsGroupMark", "containsAnyGroupMarks", "pendingRecalculateMarks", "Landroidx/compose/runtime/PrioritySet;", "Landroidx/collection/MutableIntList;", "recalculateMarks", "updateContainsMark", "updateContainsMarkNow", "updateContainsMarkNow-XpTMRCE", "(ILandroidx/collection/MutableIntList;)V", "childContainsAnyMarks", "anchorIndex", "toString", "saveCurrentGroupEnd", "restoreCurrentGroupEnd", "fixParentAnchorsFor", "firstChild", "moveGroupGapTo", "moveSlotGapTo", "clearSlotGap", "insertGroups", "size", "insertSlots", "removeGroups", "start", "len", "sourceInformationOf", "sourceInformationOf$runtime", "tryAnchor", "tryAnchor$runtime", "removeSlots", "updateNodeOfGroup", "updateAnchors", "previousGapStart", "newGapStart", "removeAnchors", "gapStart", "moveAnchors", "originalLocation", "newLocation", "toDebugString", "groupAsString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "verifyDataAnchors", "verifyDataAnchors$runtime", "verifyParentAnchors", "verifyParentAnchors$runtime", "getSize$runtime", "capacity", "getCapacity", "groupIndexToAddress", "dataIndexToDataAddress", "dataIndex", "address", "updateDataIndex", "nodeIndex", "auxIndex", "dataIndexes", "keys", "dataIndexToDataAnchor", "gapLen", "dataAnchorToDataIndex", "parentIndexToAnchor", "parentAnchorToIndex", "Companion", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class SlotWriter {
    private ArrayList<Anchor> anchors;
    private MutableIntObjectMap<MutableIntSet> calledByMap;
    private boolean closed;
    private int currentGroup;
    private int currentGroupEnd;
    private int currentSlot;
    private int currentSlotEnd;
    private MutableIntObjectMap<MutableObjectList<Object>> deferredSlotWrites;
    private int groupGapLen;
    private int groupGapStart;
    private int[] groups;
    private int insertCount;
    private int nodeCount;
    private MutableIntList pendingRecalculateMarks;
    private Object[] slots;
    private int slotsGapLen;
    private int slotsGapOwner;
    private int slotsGapStart;
    private HashMap<Anchor, GroupSourceInformation> sourceInformationMap;
    private final SlotTable table;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private final IntStack startStack = new IntStack();
    private final IntStack endStack = new IntStack();
    private final IntStack nodeCountStack = new IntStack();
    private int parent = -1;

    private final int dataAnchorToDataIndex(int anchor, int gapLen, int capacity) {
        return anchor < 0 ? (capacity - gapLen) + anchor + 1 : anchor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndexToDataAnchor(int index, int gapStart, int gapLen, int capacity) {
        return index > gapStart ? -(((capacity - gapLen) - index) + 1) : index;
    }

    public SlotWriter(SlotTable slotTable) {
        this.table = slotTable;
        this.groups = slotTable.getGroups();
        this.slots = slotTable.getSlots();
        this.anchors = slotTable.getAnchors$runtime();
        this.sourceInformationMap = slotTable.getSourceInformationMap$runtime();
        this.calledByMap = slotTable.getCalledByMap$runtime();
        this.groupGapStart = slotTable.getGroupsSize();
        this.groupGapLen = (this.groups.length / 5) - slotTable.getGroupsSize();
        this.slotsGapStart = slotTable.getSlotsSize();
        this.slotsGapLen = this.slots.length - slotTable.getSlotsSize();
        this.slotsGapOwner = slotTable.getGroupsSize();
        this.currentGroupEnd = slotTable.getGroupsSize();
    }

    /* renamed from: getTable$runtime, reason: from getter */
    public final SlotTable getTable() {
        return this.table;
    }

    public final int getCurrentGroup() {
        return this.currentGroup;
    }

    public final int getCurrentGroupEnd() {
        return this.currentGroupEnd;
    }

    public final boolean isGroupEnd() {
        return this.currentGroup == this.currentGroupEnd;
    }

    public final int getSlotsSize() {
        return this.slots.length - this.slotsGapLen;
    }

    public final boolean isNode() {
        int i = this.currentGroup;
        if (i < this.currentGroupEnd) {
            return (this.groups[(groupIndexToAddress(i) * 5) + 1] & 1073741824) != 0;
        }
        return false;
    }

    public final boolean getCollectingSourceInformation() {
        return this.sourceInformationMap != null;
    }

    public final boolean getCollectingCalledInformation() {
        return this.calledByMap != null;
    }

    public final boolean isNode(int index) {
        return (this.groups[(groupIndexToAddress(index) * 5) + 1] & 1073741824) != 0;
    }

    public final int nodeCount(int index) {
        return this.groups[(groupIndexToAddress(index) * 5) + 1] & 67108863;
    }

    public final int groupKey(int index) {
        return this.groups[groupIndexToAddress(index) * 5];
    }

    public final Object groupObjectKey(int index) {
        int groupIndexToAddress = groupIndexToAddress(index);
        int[] iArr = this.groups;
        if ((iArr[(groupIndexToAddress * 5) + 1] & 536870912) != 0) {
            return this.slots[SlotTableKt.access$objectKeyIndex(iArr, groupIndexToAddress)];
        }
        return null;
    }

    public final int groupSize(int index) {
        return SlotTableKt.access$groupSize(this.groups, groupIndexToAddress(index));
    }

    public final Object groupAux(int index) {
        int groupIndexToAddress = groupIndexToAddress(index);
        int[] iArr = this.groups;
        return (iArr[(groupIndexToAddress * 5) + 1] & 268435456) != 0 ? this.slots[auxIndex(iArr, groupIndexToAddress)] : Composer.INSTANCE.getEmpty();
    }

    public final boolean indexInParent(int index) {
        int i = this.parent;
        return (index > i && index < this.currentGroupEnd) || (i == 0 && index == 0);
    }

    public final boolean indexInCurrentGroup(int index) {
        return indexInGroup(index, this.currentGroup);
    }

    public final boolean indexInGroup(int index, int group) {
        int capacity;
        int groupSize;
        if (group == this.parent) {
            capacity = this.currentGroupEnd;
        } else {
            if (group > this.startStack.peekOr(0)) {
                groupSize = groupSize(group);
            } else {
                int indexOf = this.startStack.indexOf(group);
                if (indexOf < 0) {
                    groupSize = groupSize(group);
                } else {
                    capacity = (getCapacity() - this.groupGapLen) - this.endStack.peek(indexOf);
                }
            }
            capacity = groupSize + group;
        }
        return index > group && index < capacity;
    }

    public final Object node(int index) {
        int groupIndexToAddress = groupIndexToAddress(index);
        int[] iArr = this.groups;
        if ((iArr[(groupIndexToAddress * 5) + 1] & 1073741824) != 0) {
            return this.slots[dataIndexToDataAddress(nodeIndex(iArr, groupIndexToAddress))];
        }
        return null;
    }

    public final Object node(Anchor anchor) {
        return node(anchor.toIndexFor(this));
    }

    public final int getParent() {
        return this.parent;
    }

    public final int parent(int index) {
        return parent(this.groups, index);
    }

    public final int parent(Anchor anchor) {
        if (anchor.getValid()) {
            return parent(this.groups, anchorIndex(anchor));
        }
        return -1;
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final void close(boolean normalClose) {
        this.closed = true;
        if (normalClose) {
            if (this.startStack.tos == 0) {
                moveGroupGapTo(getSize$runtime());
                moveSlotGapTo(this.slots.length - this.slotsGapLen, this.groupGapStart);
                clearSlotGap();
                recalculateMarks();
            }
        }
        this.table.close$runtime(this, this.groups, this.groupGapStart, this.slots, this.slotsGapStart, this.anchors, this.sourceInformationMap, this.calledByMap);
    }

    public final void reset() {
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot reset when inserting");
        }
        recalculateMarks();
        this.currentGroup = 0;
        this.currentGroupEnd = getCapacity() - this.groupGapLen;
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
        this.nodeCount = 0;
    }

    public final Object update(Object value) {
        if (this.insertCount > 0 && this.currentSlot != this.slotsGapStart) {
            MutableIntObjectMap<MutableObjectList<Object>> mutableIntObjectMap = this.deferredSlotWrites;
            DefaultConstructorMarker defaultConstructorMarker = null;
            int i = 1;
            int i2 = 0;
            if (mutableIntObjectMap == null) {
                mutableIntObjectMap = new MutableIntObjectMap<>(i2, i, defaultConstructorMarker);
            }
            this.deferredSlotWrites = mutableIntObjectMap;
            int i3 = this.parent;
            MutableObjectList<Object> mutableObjectList = mutableIntObjectMap.get(i3);
            if (mutableObjectList == null) {
                mutableObjectList = new MutableObjectList<>(i2, i, defaultConstructorMarker);
                mutableIntObjectMap.set(i3, mutableObjectList);
            }
            mutableObjectList.add(value);
            return Composer.INSTANCE.getEmpty();
        }
        return rawUpdate(value);
    }

    private final Object rawUpdate(Object value) {
        Object skip = skip();
        set(value);
        return skip;
    }

    public final void appendSlot(Anchor anchor, Object value) {
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Can only append a slot if not current inserting");
        }
        int i = this.currentSlot;
        int i2 = this.currentSlotEnd;
        int anchorIndex = anchorIndex(anchor);
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(anchorIndex + 1));
        this.currentSlot = dataIndex;
        this.currentSlotEnd = dataIndex;
        insertSlots(1, anchorIndex);
        if (i >= dataIndex) {
            i++;
            i2++;
        }
        this.slots[dataIndex] = value;
        this.currentSlot = i;
        this.currentSlotEnd = i2;
    }

    public final void updateAux(Object value) {
        int groupIndexToAddress = groupIndexToAddress(this.currentGroup);
        if (!((this.groups[(groupIndexToAddress * 5) + 1] & 268435456) != 0)) {
            ComposerKt.composeImmediateRuntimeError("Updating the data of a group that was not created with a data slot");
        }
        this.slots[dataIndexToDataAddress(auxIndex(this.groups, groupIndexToAddress))] = value;
    }

    public final void insertAux(Object value) {
        if (!(this.insertCount >= 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot insert auxiliary data when not inserting");
        }
        int i = this.parent;
        int groupIndexToAddress = groupIndexToAddress(i);
        if (!(!((this.groups[(groupIndexToAddress * 5) + 1] & 268435456) != 0))) {
            ComposerKt.composeImmediateRuntimeError("Group already has auxiliary data");
        }
        insertSlots(1, i);
        int auxIndex = auxIndex(this.groups, groupIndexToAddress);
        int dataIndexToDataAddress = dataIndexToDataAddress(auxIndex);
        int i2 = this.currentSlot;
        if (i2 > auxIndex) {
            int i3 = i2 - auxIndex;
            if (!(i3 < 3)) {
                PreconditionsKt.throwIllegalStateException("Moving more than two slot not supported");
            }
            if (i3 > 1) {
                Object[] objArr = this.slots;
                objArr[dataIndexToDataAddress + 2] = objArr[dataIndexToDataAddress + 1];
            }
            Object[] objArr2 = this.slots;
            objArr2[dataIndexToDataAddress + 1] = objArr2[dataIndexToDataAddress];
        }
        SlotTableKt.access$addAux(this.groups, groupIndexToAddress);
        this.slots[dataIndexToDataAddress] = value;
        this.currentSlot++;
    }

    public final void updateToTableMaps() {
        this.sourceInformationMap = this.table.getSourceInformationMap$runtime();
        this.calledByMap = this.table.getCalledByMap$runtime();
    }

    public final void recordGroupSourceInformation(String sourceInformation) {
        if (this.insertCount > 0) {
            groupSourceInformationFor(this.parent, sourceInformation);
        }
    }

    public final void recordGrouplessCallSourceInformationStart(int key, String value) {
        if (this.insertCount > 0) {
            MutableIntObjectMap<MutableIntSet> mutableIntObjectMap = this.calledByMap;
            if (mutableIntObjectMap != null) {
                SlotTableKt.access$add(mutableIntObjectMap, key, groupKey(this.parent));
            }
            GroupSourceInformation groupSourceInformationFor = groupSourceInformationFor(this.parent, null);
            if (groupSourceInformationFor != null) {
                groupSourceInformationFor.startGrouplessCall(key, value, getCurrentGroupSlotIndex());
            }
        }
    }

    public final void recordGrouplessCallSourceInformationEnd() {
        GroupSourceInformation groupSourceInformationFor;
        if (this.insertCount <= 0 || (groupSourceInformationFor = groupSourceInformationFor(this.parent, null)) == null) {
            return;
        }
        groupSourceInformationFor.endGrouplessCall(getCurrentGroupSlotIndex());
    }

    private final GroupSourceInformation groupSourceInformationFor(int parent, String sourceInformation) {
        HashMap<Anchor, GroupSourceInformation> hashMap = this.sourceInformationMap;
        if (hashMap == null) {
            return null;
        }
        HashMap<Anchor, GroupSourceInformation> hashMap2 = hashMap;
        Anchor anchor = anchor(parent);
        GroupSourceInformation groupSourceInformation = hashMap2.get(anchor);
        if (groupSourceInformation == null) {
            groupSourceInformation = new GroupSourceInformation(0, sourceInformation, 0);
            if (sourceInformation == null) {
                int i = parent + 1;
                int i2 = this.currentGroup;
                while (i < i2) {
                    groupSourceInformation.reportGroup(this, i);
                    i += SlotTableKt.access$groupSize(this.groups, i);
                }
            }
            hashMap2.put(anchor, groupSourceInformation);
        }
        return groupSourceInformation;
    }

    public final void updateNode(Object value) {
        updateNodeOfGroup(this.currentGroup, value);
    }

    public final void updateNode(Anchor anchor, Object value) {
        updateNodeOfGroup(anchor.toIndexFor(this), value);
    }

    public final void updateParentNode(Object value) {
        updateNodeOfGroup(this.parent, value);
    }

    public final void set(Object value) {
        if (!(this.currentSlot <= this.currentSlotEnd)) {
            ComposerKt.composeImmediateRuntimeError("Writing to an invalid slot");
        }
        this.slots[dataIndexToDataAddress(this.currentSlot - 1)] = value;
    }

    public final Object set(int index, Object value) {
        return set(getCurrentGroup(), index, value);
    }

    public final int slotIndexOfGroupSlotIndex(int group, int index) {
        int slotIndex = slotIndex(this.groups, groupIndexToAddress(group));
        int i = slotIndex + index;
        if (!(i >= slotIndex && i < dataIndex(this.groups, groupIndexToAddress(group + 1)))) {
            ComposerKt.composeImmediateRuntimeError("Write to an invalid slot index " + index + " for group " + group);
        }
        return i;
    }

    public final Object set(int group, int index, Object value) {
        int dataIndexToDataAddress = dataIndexToDataAddress(slotIndexOfGroupSlotIndex(group, index));
        Object[] objArr = this.slots;
        Object obj = objArr[dataIndexToDataAddress];
        objArr[dataIndexToDataAddress] = value;
        return obj;
    }

    public final Object clear(int slotIndex) {
        int dataIndexToDataAddress = dataIndexToDataAddress(slotIndex);
        Object[] objArr = this.slots;
        Object obj = objArr[dataIndexToDataAddress];
        objArr[dataIndexToDataAddress] = Composer.INSTANCE.getEmpty();
        return obj;
    }

    public final Object skip() {
        if (this.insertCount > 0) {
            insertSlots(1, this.parent);
        }
        Object[] objArr = this.slots;
        int i = this.currentSlot;
        this.currentSlot = i + 1;
        return objArr[dataIndexToDataAddress(i)];
    }

    public final Object slot(Anchor anchor, int index) {
        return slot(anchorIndex(anchor), index);
    }

    public final Object slot(int groupIndex, int index) {
        int slotIndex = slotIndex(this.groups, groupIndexToAddress(groupIndex));
        int i = index + slotIndex;
        if (!(slotIndex <= i && i < dataIndex(this.groups, groupIndexToAddress(groupIndex + 1)))) {
            return Composer.INSTANCE.getEmpty();
        }
        return this.slots[dataIndexToDataAddress(i)];
    }

    public final void forEachTailSlot(int groupIndex, int count, Function2<? super Integer, Object, Unit> block) {
        int slotsStartIndex$runtime = slotsStartIndex$runtime(groupIndex);
        int slotsEndIndex$runtime = slotsEndIndex$runtime(groupIndex);
        for (int max = Math.max(slotsStartIndex$runtime, slotsEndIndex$runtime - count); max < slotsEndIndex$runtime; max++) {
            block.invoke(Integer.valueOf(max), this.slots[dataIndexToDataAddress(max)]);
        }
    }

    public final int slotsStartIndex$runtime(int groupIndex) {
        return slotIndex(this.groups, groupIndexToAddress(groupIndex));
    }

    public final int slotsEndIndex$runtime(int groupIndex) {
        return dataIndex(this.groups, groupIndexToAddress(groupIndex + 1));
    }

    public final int slotsEndAllIndex$runtime(int groupIndex) {
        return dataIndex(this.groups, groupIndexToAddress(groupIndex + groupSize(groupIndex)));
    }

    private final int getCurrentGroupSlotIndex() {
        return groupSlotIndex(this.parent);
    }

    public final int groupSlotIndex(int group) {
        MutableObjectList<Object> mutableObjectList;
        int slotsStartIndex$runtime = this.currentSlot - slotsStartIndex$runtime(group);
        MutableIntObjectMap<MutableObjectList<Object>> mutableIntObjectMap = this.deferredSlotWrites;
        return slotsStartIndex$runtime + ((mutableIntObjectMap == null || (mutableObjectList = mutableIntObjectMap.get(group)) == null) ? 0 : mutableObjectList.getSize());
    }

    public final void seek(Anchor anchor) {
        advanceBy(anchor.toIndexFor(this) - this.currentGroup);
    }

    public final void skipToGroupEnd() {
        int i = this.currentGroupEnd;
        this.currentGroup = i;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(i));
    }

    public final void beginInsert() {
        int i = this.insertCount;
        this.insertCount = i + 1;
        if (i == 0) {
            saveCurrentGroupEnd();
        }
    }

    public final void endInsert() {
        if (!(this.insertCount > 0)) {
            PreconditionsKt.throwIllegalStateException("Unbalanced begin/end insert");
        }
        int i = this.insertCount - 1;
        this.insertCount = i;
        if (i == 0) {
            if (!(this.nodeCountStack.tos == this.startStack.tos)) {
                ComposerKt.composeImmediateRuntimeError("startGroup/endGroup mismatch while inserting");
            }
            restoreCurrentGroupEnd();
        }
    }

    public final void startGroup() {
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Key must be supplied when inserting");
        }
        startGroup(0, Composer.INSTANCE.getEmpty(), false, Composer.INSTANCE.getEmpty());
    }

    public final void startGroup(int key) {
        startGroup(key, Composer.INSTANCE.getEmpty(), false, Composer.INSTANCE.getEmpty());
    }

    public final void startGroup(int key, Object dataKey) {
        startGroup(key, dataKey, false, Composer.INSTANCE.getEmpty());
    }

    public final void startNode(int key, Object objectKey) {
        startGroup(key, objectKey, true, Composer.INSTANCE.getEmpty());
    }

    public final void startNode(int key, Object objectKey, Object node) {
        startGroup(key, objectKey, true, node);
    }

    public final void startData(int key, Object objectKey, Object aux) {
        startGroup(key, objectKey, false, aux);
    }

    public final void startData(int key, Object aux) {
        startGroup(key, Composer.INSTANCE.getEmpty(), false, aux);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void startGroup(int key, Object objectKey, boolean isNode, Object aux) {
        int access$groupSize;
        GroupSourceInformation sourceInformationOf$runtime;
        int i = this.parent;
        Object[] objArr = this.insertCount > 0;
        this.nodeCountStack.push(this.nodeCount);
        if (objArr != false) {
            int i2 = this.currentGroup;
            int dataIndex = dataIndex(this.groups, groupIndexToAddress(i2));
            insertGroups(1);
            this.currentSlot = dataIndex;
            this.currentSlotEnd = dataIndex;
            int groupIndexToAddress = groupIndexToAddress(i2);
            int i3 = objectKey != Composer.INSTANCE.getEmpty() ? 1 : 0;
            int i4 = (isNode || aux == Composer.INSTANCE.getEmpty()) ? 0 : 1;
            int dataIndexToDataAnchor = dataIndexToDataAnchor(dataIndex, this.slotsGapStart, this.slotsGapLen, this.slots.length);
            if (dataIndexToDataAnchor >= 0 && this.slotsGapOwner < i2) {
                dataIndexToDataAnchor = -(((this.slots.length - this.slotsGapLen) - dataIndexToDataAnchor) + 1);
            }
            SlotTableKt.access$initGroup(this.groups, groupIndexToAddress, key, isNode, i3, i4, this.parent, dataIndexToDataAnchor);
            int i5 = (isNode ? 1 : 0) + i3 + i4;
            if (i5 > 0) {
                insertSlots(i5, i2);
                Object[] objArr2 = this.slots;
                int i6 = this.currentSlot;
                if (isNode) {
                    objArr2[i6] = aux;
                    i6++;
                }
                if (i3 != 0) {
                    objArr2[i6] = objectKey;
                    i6++;
                }
                if (i4 != 0) {
                    objArr2[i6] = aux;
                    i6++;
                }
                this.currentSlot = i6;
            }
            this.nodeCount = 0;
            access$groupSize = i2 + 1;
            this.parent = i2;
            this.currentGroup = access$groupSize;
            if (i >= 0 && (sourceInformationOf$runtime = sourceInformationOf$runtime(i)) != null) {
                sourceInformationOf$runtime.reportGroup(this, i2);
            }
        } else {
            this.startStack.push(i);
            saveCurrentGroupEnd();
            int i7 = this.currentGroup;
            int groupIndexToAddress2 = groupIndexToAddress(i7);
            if (!Intrinsics.areEqual(aux, Composer.INSTANCE.getEmpty())) {
                if (isNode) {
                    updateNode(aux);
                } else {
                    updateAux(aux);
                }
            }
            this.currentSlot = slotIndex(this.groups, groupIndexToAddress2);
            this.currentSlotEnd = dataIndex(this.groups, groupIndexToAddress(this.currentGroup + 1));
            int[] iArr = this.groups;
            this.nodeCount = iArr[(groupIndexToAddress2 * 5) + 1] & 67108863;
            this.parent = i7;
            this.currentGroup = i7 + 1;
            access$groupSize = i7 + SlotTableKt.access$groupSize(iArr, groupIndexToAddress2);
        }
        this.currentGroupEnd = access$groupSize;
    }

    public final int endGroup() {
        MutableObjectList<Object> mutableObjectList;
        boolean z = this.insertCount > 0;
        int i = this.currentGroup;
        int i2 = this.currentGroupEnd;
        int i3 = this.parent;
        int groupIndexToAddress = groupIndexToAddress(i3);
        int i4 = this.nodeCount;
        int i5 = i - i3;
        int i6 = (groupIndexToAddress * 5) + 1;
        boolean z2 = (this.groups[i6] & 1073741824) != 0;
        if (z) {
            MutableIntObjectMap<MutableObjectList<Object>> mutableIntObjectMap = this.deferredSlotWrites;
            if (mutableIntObjectMap != null && (mutableObjectList = mutableIntObjectMap.get(i3)) != null) {
                MutableObjectList<Object> mutableObjectList2 = mutableObjectList;
                Object[] objArr = mutableObjectList2.content;
                int i7 = mutableObjectList2._size;
                for (int i8 = 0; i8 < i7; i8++) {
                    rawUpdate(objArr[i8]);
                }
                mutableIntObjectMap.remove(i3);
            }
            SlotTableKt.access$updateGroupSize(this.groups, groupIndexToAddress, i5);
            SlotTableKt.access$updateNodeCount(this.groups, groupIndexToAddress, i4);
            this.nodeCount = this.nodeCountStack.pop() + (z2 ? 1 : i4);
            int parent = parent(this.groups, i3);
            this.parent = parent;
            int size$runtime = parent < 0 ? getSize$runtime() : groupIndexToAddress(parent + 1);
            int dataIndex = size$runtime >= 0 ? dataIndex(this.groups, size$runtime) : 0;
            this.currentSlot = dataIndex;
            this.currentSlotEnd = dataIndex;
        } else {
            if (!(i == i2)) {
                ComposerKt.composeImmediateRuntimeError("Expected to be at the end of a group");
            }
            int access$groupSize = SlotTableKt.access$groupSize(this.groups, groupIndexToAddress);
            int[] iArr = this.groups;
            int i9 = iArr[i6] & 67108863;
            SlotTableKt.access$updateGroupSize(iArr, groupIndexToAddress, i5);
            SlotTableKt.access$updateNodeCount(this.groups, groupIndexToAddress, i4);
            int pop = this.startStack.pop();
            restoreCurrentGroupEnd();
            this.parent = pop;
            int parent2 = parent(this.groups, i3);
            int pop2 = this.nodeCountStack.pop();
            this.nodeCount = pop2;
            if (parent2 == pop) {
                this.nodeCount = pop2 + (z2 ? 0 : i4 - i9);
            } else {
                int i10 = i5 - access$groupSize;
                int i11 = z2 ? 0 : i4 - i9;
                if (i10 != 0 || i11 != 0) {
                    while (parent2 != 0 && parent2 != pop && (i11 != 0 || i10 != 0)) {
                        int groupIndexToAddress2 = groupIndexToAddress(parent2);
                        if (i10 != 0) {
                            SlotTableKt.access$updateGroupSize(this.groups, groupIndexToAddress2, SlotTableKt.access$groupSize(this.groups, groupIndexToAddress2) + i10);
                        }
                        if (i11 != 0) {
                            int[] iArr2 = this.groups;
                            SlotTableKt.access$updateNodeCount(iArr2, groupIndexToAddress2, (iArr2[(groupIndexToAddress2 * 5) + 1] & 67108863) + i11);
                        }
                        int[] iArr3 = this.groups;
                        if ((iArr3[(groupIndexToAddress2 * 5) + 1] & 1073741824) != 0) {
                            i11 = 0;
                        }
                        parent2 = parent(iArr3, parent2);
                    }
                }
                this.nodeCount += i11;
            }
        }
        return i4;
    }

    public final void ensureStarted(int index) {
        if (!(this.insertCount <= 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot call ensureStarted() while inserting");
        }
        int i = this.parent;
        if (i != index) {
            if (!(index >= i && index < this.currentGroupEnd)) {
                ComposerKt.composeImmediateRuntimeError("Started group at " + index + " must be a subgroup of the group at " + i);
            }
            int i2 = this.currentGroup;
            int i3 = this.currentSlot;
            int i4 = this.currentSlotEnd;
            this.currentGroup = index;
            startGroup();
            this.currentGroup = i2;
            this.currentSlot = i3;
            this.currentSlotEnd = i4;
        }
    }

    public final void ensureStarted(Anchor anchor) {
        ensureStarted(anchor.toIndexFor(this));
    }

    public final int skipGroup() {
        int groupIndexToAddress = groupIndexToAddress(this.currentGroup);
        int access$groupSize = this.currentGroup + SlotTableKt.access$groupSize(this.groups, groupIndexToAddress);
        this.currentGroup = access$groupSize;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(access$groupSize));
        int i = this.groups[(groupIndexToAddress * 5) + 1];
        if ((1073741824 & i) != 0) {
            return 1;
        }
        return i & 67108863;
    }

    public final boolean removeGroup() {
        Anchor tryAnchor$runtime;
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot remove group while inserting");
        }
        int i = this.currentGroup;
        int i2 = this.currentSlot;
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(i));
        int skipGroup = skipGroup();
        GroupSourceInformation sourceInformationOf$runtime = sourceInformationOf$runtime(this.parent);
        if (sourceInformationOf$runtime != null && (tryAnchor$runtime = tryAnchor$runtime(i)) != null) {
            sourceInformationOf$runtime.removeAnchor(tryAnchor$runtime);
        }
        MutableIntList mutableIntList = this.pendingRecalculateMarks;
        if (mutableIntList != null) {
            while (PrioritySet.m4067isNotEmptyimpl(mutableIntList) && PrioritySet.m4068peekimpl(mutableIntList) >= i) {
                PrioritySet.m4069takeMaximpl(mutableIntList);
            }
        }
        boolean removeGroups = removeGroups(i, this.currentGroup - i);
        removeSlots(dataIndex, this.currentSlot - dataIndex, i - 1);
        this.currentGroup = i;
        this.currentSlot = i2;
        this.nodeCount -= skipGroup;
        return removeGroups;
    }

    public final Iterator<Object> groupSlots() {
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(this.currentGroup));
        int[] iArr = this.groups;
        int i = this.currentGroup;
        return new SlotWriter$groupSlots$1(dataIndex, dataIndex(iArr, groupIndexToAddress(i + groupSize(i))), this);
    }

    public final void forAllData(int group, Function2<? super Integer, Object, Unit> block) {
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(getCurrentGroup() + groupSize(getCurrentGroup())));
        for (int dataIndex2 = dataIndex(this.groups, groupIndexToAddress(group)); dataIndex2 < dataIndex; dataIndex2++) {
            block.invoke(Integer.valueOf(dataIndex2), this.slots[dataIndexToDataAddress(dataIndex2)]);
        }
    }

    public final void traverseGroupAndChildren(int group, Function1<? super Integer, Unit> enter, Function1<? super Integer, Unit> exit) {
        int parent = parent(group);
        int size$runtime = getSize$runtime();
        int groupSize = groupSize(group) + group;
        int i = group;
        while (i < groupSize) {
            enter.invoke(Integer.valueOf(i));
            int i2 = i + 1;
            int parent2 = i2 < size$runtime ? parent(i2) : -1;
            if (parent2 != i) {
                while (true) {
                    exit.invoke(Integer.valueOf(i));
                    if (i != group && parent != parent2) {
                        i = parent;
                        parent = parent(parent);
                    }
                }
            }
            i = i2;
            parent = parent2;
        }
    }

    public final void moveGroup(int offset) {
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot move a group while inserting");
        }
        if (!(offset >= 0)) {
            ComposerKt.composeImmediateRuntimeError("Parameter offset is out of bounds");
        }
        if (offset == 0) {
            return;
        }
        int i = this.currentGroup;
        int i2 = this.parent;
        int i3 = this.currentGroupEnd;
        int i4 = i;
        for (int i5 = offset; i5 > 0; i5--) {
            i4 += SlotTableKt.access$groupSize(this.groups, groupIndexToAddress(i4));
            if (!(i4 <= i3)) {
                ComposerKt.composeImmediateRuntimeError("Parameter offset is out of bounds");
            }
        }
        int access$groupSize = SlotTableKt.access$groupSize(this.groups, groupIndexToAddress(i4));
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(this.currentGroup));
        int dataIndex2 = dataIndex(this.groups, groupIndexToAddress(i4));
        int i6 = i4 + access$groupSize;
        int dataIndex3 = dataIndex(this.groups, groupIndexToAddress(i6));
        int i7 = dataIndex3 - dataIndex2;
        insertSlots(i7, Math.max(this.currentGroup - 1, 0));
        insertGroups(access$groupSize);
        int[] iArr = this.groups;
        int groupIndexToAddress = groupIndexToAddress(i6) * 5;
        ArraysKt.copyInto(iArr, iArr, groupIndexToAddress(i) * 5, groupIndexToAddress, (access$groupSize * 5) + groupIndexToAddress);
        if (i7 > 0) {
            Object[] objArr = this.slots;
            int dataIndexToDataAddress = dataIndexToDataAddress(dataIndex2 + i7);
            System.arraycopy(objArr, dataIndexToDataAddress, objArr, dataIndex, dataIndexToDataAddress(dataIndex3 + i7) - dataIndexToDataAddress);
        }
        int i8 = dataIndex2 + i7;
        int i9 = i8 - dataIndex;
        int i10 = this.slotsGapStart;
        int i11 = this.slotsGapLen;
        int length = this.slots.length;
        int i12 = this.slotsGapOwner;
        int i13 = i + access$groupSize;
        int i14 = i;
        while (i14 < i13) {
            int groupIndexToAddress2 = groupIndexToAddress(i14);
            int i15 = i10;
            int i16 = i9;
            updateDataIndex(iArr, groupIndexToAddress2, dataIndexToDataAnchor(dataIndex(iArr, groupIndexToAddress2) - i9, i12 < groupIndexToAddress2 ? 0 : i15, i11, length));
            i14++;
            i10 = i15;
            i9 = i16;
        }
        moveAnchors(i6, i, access$groupSize);
        if (!(!removeGroups(i6, access$groupSize))) {
            ComposerKt.composeImmediateRuntimeError("Unexpectedly removed anchors");
        }
        fixParentAnchorsFor(i2, this.currentGroupEnd, i);
        if (i7 > 0) {
            removeSlots(i8, i7, i6 - 1);
        }
    }

    public final boolean inGroup(Anchor groupAnchor, Anchor anchor) {
        int anchorIndex = anchorIndex(groupAnchor);
        int access$groupSize = SlotTableKt.access$groupSize(this.groups, anchorIndex) + anchorIndex;
        int location = anchor.getLocation();
        return anchorIndex <= location && location < access$groupSize;
    }

    /* compiled from: SlotTable.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\rH\u0002¨\u0006\u0010"}, d2 = {"Landroidx/compose/runtime/SlotWriter$Companion;", "", "<init>", "()V", "moveGroup", "", "Landroidx/compose/runtime/Anchor;", "fromWriter", "Landroidx/compose/runtime/SlotWriter;", "fromIndex", "", "toWriter", "updateFromCursor", "", "updateToCursor", "removeSourceGroup", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        static /* synthetic */ List moveGroup$default(Companion companion, SlotWriter slotWriter, int i, SlotWriter slotWriter2, boolean z, boolean z2, boolean z3, int i2, Object obj) {
            if ((i2 & 32) != 0) {
                z3 = true;
            }
            return companion.moveGroup(slotWriter, i, slotWriter2, z, z2, z3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:56:0x01c9  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x01db  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x01df  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x01ec  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x01f8  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x01e1  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final List<Anchor> moveGroup(SlotWriter fromWriter, int fromIndex, SlotWriter toWriter, boolean updateFromCursor, boolean updateToCursor, boolean removeSourceGroup) {
            ArrayList emptyList;
            int i;
            boolean z;
            int groupSize = fromWriter.groupSize(fromIndex);
            int i2 = fromIndex + groupSize;
            int dataIndex = fromWriter.dataIndex(fromIndex);
            int dataIndex2 = fromWriter.dataIndex(i2);
            int i3 = dataIndex2 - dataIndex;
            boolean containsAnyGroupMarks = fromWriter.containsAnyGroupMarks(fromIndex);
            toWriter.insertGroups(groupSize);
            toWriter.insertSlots(i3, toWriter.getCurrentGroup());
            if (fromWriter.groupGapStart < i2) {
                fromWriter.moveGroupGapTo(i2);
            }
            if (fromWriter.slotsGapStart < dataIndex2) {
                fromWriter.moveSlotGapTo(dataIndex2, i2);
            }
            int[] iArr = toWriter.groups;
            int currentGroup = toWriter.getCurrentGroup();
            int i4 = currentGroup * 5;
            ArraysKt.copyInto(fromWriter.groups, iArr, i4, fromIndex * 5, i2 * 5);
            Object[] objArr = toWriter.slots;
            int i5 = toWriter.currentSlot;
            System.arraycopy(fromWriter.slots, dataIndex, objArr, i5, i3);
            int parent = toWriter.getParent();
            iArr[i4 + 2] = parent;
            int i6 = currentGroup - fromIndex;
            int i7 = currentGroup + groupSize;
            int dataIndex3 = i5 - toWriter.dataIndex(iArr, currentGroup);
            int i8 = toWriter.slotsGapOwner;
            int i9 = toWriter.slotsGapLen;
            int length = objArr.length;
            int i10 = i8;
            int i11 = currentGroup;
            while (true) {
                if (i11 >= i7) {
                    break;
                }
                if (i11 != currentGroup) {
                    int i12 = (i11 * 5) + 2;
                    iArr[i12] = iArr[i12] + i6;
                }
                int i13 = currentGroup;
                int i14 = i7;
                iArr[(i11 * 5) + 4] = toWriter.dataIndexToDataAnchor(toWriter.dataIndex(iArr, i11) + dataIndex3, i10 >= i11 ? toWriter.slotsGapStart : 0, i9, length);
                if (i11 == i10) {
                    i10++;
                }
                i11++;
                i7 = i14;
                currentGroup = i13;
            }
            int i15 = i7;
            toWriter.slotsGapOwner = i10;
            int access$locationOf = SlotTableKt.access$locationOf(fromWriter.anchors, fromIndex, fromWriter.getSize$runtime());
            int access$locationOf2 = SlotTableKt.access$locationOf(fromWriter.anchors, i2, fromWriter.getSize$runtime());
            if (access$locationOf < access$locationOf2) {
                ArrayList arrayList = fromWriter.anchors;
                ArrayList arrayList2 = new ArrayList(access$locationOf2 - access$locationOf);
                for (int i16 = access$locationOf; i16 < access$locationOf2; i16++) {
                    Anchor anchor = (Anchor) arrayList.get(i16);
                    anchor.setLocation$runtime(anchor.getLocation() + i6);
                    arrayList2.add(anchor);
                }
                toWriter.anchors.addAll(SlotTableKt.access$locationOf(toWriter.anchors, toWriter.getCurrentGroup(), toWriter.getSize$runtime()), arrayList2);
                arrayList.subList(access$locationOf, access$locationOf2).clear();
                emptyList = arrayList2;
            } else {
                emptyList = CollectionsKt.emptyList();
            }
            List<Anchor> list = emptyList;
            if (!list.isEmpty()) {
                HashMap hashMap = fromWriter.sourceInformationMap;
                HashMap hashMap2 = toWriter.sourceInformationMap;
                if (hashMap != null && hashMap2 != null) {
                    int size = list.size();
                    for (int i17 = 0; i17 < size; i17++) {
                        Anchor anchor2 = emptyList.get(i17);
                        GroupSourceInformation groupSourceInformation = (GroupSourceInformation) hashMap.get(anchor2);
                        if (groupSourceInformation != null) {
                            hashMap.remove(anchor2);
                            hashMap2.put(anchor2, groupSourceInformation);
                        }
                    }
                }
            }
            int parent2 = toWriter.getParent();
            GroupSourceInformation sourceInformationOf$runtime = toWriter.sourceInformationOf$runtime(parent);
            if (sourceInformationOf$runtime != null) {
                int i18 = parent2 + 1;
                int currentGroup2 = toWriter.getCurrentGroup();
                int i19 = -1;
                while (i18 < currentGroup2) {
                    i19 = i18;
                    i18 = SlotTableKt.access$groupSize(toWriter.groups, i18) + i18;
                }
                sourceInformationOf$runtime.addGroupAfter(toWriter, i19, currentGroup2);
            }
            int parent3 = fromWriter.parent(fromIndex);
            if (!removeSourceGroup) {
                z = false;
            } else {
                if (!updateFromCursor) {
                    boolean removeGroups = fromWriter.removeGroups(fromIndex, groupSize);
                    i = 1;
                    fromWriter.removeSlots(dataIndex, i3, fromIndex - 1);
                    z = removeGroups;
                    if (!(!z)) {
                        ComposerKt.composeImmediateRuntimeError("Unexpectedly removed anchors");
                    }
                    int i20 = toWriter.nodeCount;
                    int i21 = iArr[i4 + 1];
                    toWriter.nodeCount = i20 + (((1073741824 & i21) != 0 ? i : 0) == 0 ? i : i21 & 67108863);
                    if (updateToCursor) {
                        toWriter.currentGroup = i15;
                        toWriter.currentSlot = i5 + i3;
                    }
                    if (containsAnyGroupMarks) {
                        toWriter.updateContainsMark(parent);
                    }
                    return emptyList;
                }
                boolean z2 = parent3 >= 0;
                if (z2) {
                    fromWriter.startGroup();
                    fromWriter.advanceBy(parent3 - fromWriter.getCurrentGroup());
                    fromWriter.startGroup();
                }
                fromWriter.advanceBy(fromIndex - fromWriter.getCurrentGroup());
                z = fromWriter.removeGroup();
                if (z2) {
                    fromWriter.skipToGroupEnd();
                    fromWriter.endGroup();
                    fromWriter.skipToGroupEnd();
                    fromWriter.endGroup();
                }
            }
            i = 1;
            if (!(!z)) {
            }
            int i202 = toWriter.nodeCount;
            int i212 = iArr[i4 + 1];
            toWriter.nodeCount = i202 + (((1073741824 & i212) != 0 ? i : 0) == 0 ? i : i212 & 67108863);
            if (updateToCursor) {
            }
            if (containsAnyGroupMarks) {
            }
            return emptyList;
        }
    }

    public final List<Anchor> moveTo(Anchor anchor, int offset, SlotWriter writer) {
        if (!(writer.insertCount > 0)) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        if (!anchor.getValid()) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        int anchorIndex = anchorIndex(anchor) + offset;
        int i = this.currentGroup;
        if (!(i <= anchorIndex && anchorIndex < this.currentGroupEnd)) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        int parent = parent(anchorIndex);
        int groupSize = groupSize(anchorIndex);
        int nodeCount = isNode(anchorIndex) ? 1 : nodeCount(anchorIndex);
        List<Anchor> moveGroup$default = Companion.moveGroup$default(INSTANCE, this, anchorIndex, writer, false, false, false, 32, null);
        updateContainsMark(parent);
        boolean z = nodeCount > 0;
        while (parent >= i) {
            int groupIndexToAddress = groupIndexToAddress(parent);
            int[] iArr = this.groups;
            SlotTableKt.access$updateGroupSize(iArr, groupIndexToAddress, SlotTableKt.access$groupSize(iArr, groupIndexToAddress) - groupSize);
            if (z) {
                int[] iArr2 = this.groups;
                int i2 = iArr2[(groupIndexToAddress * 5) + 1];
                if ((1073741824 & i2) != 0) {
                    z = false;
                } else {
                    SlotTableKt.access$updateNodeCount(iArr2, groupIndexToAddress, (i2 & 67108863) - nodeCount);
                }
            }
            parent = parent(parent);
        }
        if (z) {
            if (!(this.nodeCount >= nodeCount)) {
                ComposerKt.composeImmediateRuntimeError("Check failed");
            }
            this.nodeCount -= nodeCount;
        }
        return moveGroup$default;
    }

    public static /* synthetic */ List moveFrom$default(SlotWriter slotWriter, SlotTable slotTable, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        return slotWriter.moveFrom(slotTable, i, z);
    }

    public final List<Anchor> moveFrom(SlotTable table, int index, boolean removeSourceGroup) {
        if (!(this.insertCount > 0)) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        if (index == 0 && this.currentGroup == 0 && this.table.getGroupsSize() == 0 && SlotTableKt.access$groupSize(table.getGroups(), index) == table.getGroupsSize()) {
            int[] iArr = this.groups;
            Object[] objArr = this.slots;
            ArrayList<Anchor> arrayList = this.anchors;
            HashMap<Anchor, GroupSourceInformation> hashMap = this.sourceInformationMap;
            MutableIntObjectMap<MutableIntSet> mutableIntObjectMap = this.calledByMap;
            int[] groups = table.getGroups();
            int groupsSize = table.getGroupsSize();
            Object[] slots = table.getSlots();
            int slotsSize = table.getSlotsSize();
            HashMap<Anchor, GroupSourceInformation> sourceInformationMap$runtime = table.getSourceInformationMap$runtime();
            MutableIntObjectMap<MutableIntSet> calledByMap$runtime = table.getCalledByMap$runtime();
            this.groups = groups;
            this.slots = slots;
            this.anchors = table.getAnchors$runtime();
            this.groupGapStart = groupsSize;
            this.groupGapLen = (groups.length / 5) - groupsSize;
            this.slotsGapStart = slotsSize;
            this.slotsGapLen = slots.length - slotsSize;
            this.slotsGapOwner = groupsSize;
            this.sourceInformationMap = sourceInformationMap$runtime;
            this.calledByMap = calledByMap$runtime;
            table.setTo$runtime(iArr, 0, objArr, 0, arrayList, hashMap, mutableIntObjectMap);
            return this.anchors;
        }
        SlotWriter openWriter = table.openWriter();
        try {
            List<Anchor> moveGroup = INSTANCE.moveGroup(openWriter, index, this, true, true, removeSourceGroup);
            openWriter.close(true);
            return moveGroup;
        } catch (Throwable th) {
            openWriter.close(false);
            throw th;
        }
    }

    public final void bashCurrentGroup() {
        SlotTableKt.access$updateGroupKey(this.groups, this.currentGroup, -3);
    }

    public final List<Anchor> moveIntoGroupFrom(int offset, SlotTable table, int index) {
        if (!(this.insertCount <= 0 && groupSize(this.currentGroup + offset) == 1)) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        int i = this.currentGroup;
        int i2 = this.currentSlot;
        int i3 = this.currentSlotEnd;
        advanceBy(offset);
        startGroup();
        beginInsert();
        SlotWriter openWriter = table.openWriter();
        try {
            List<Anchor> moveGroup$default = Companion.moveGroup$default(INSTANCE, openWriter, index, this, false, true, false, 32, null);
            openWriter.close(true);
            endInsert();
            endGroup();
            this.currentGroup = i;
            this.currentSlot = i2;
            this.currentSlotEnd = i3;
            return moveGroup$default;
        } catch (Throwable th) {
            openWriter.close(false);
            throw th;
        }
    }

    public static /* synthetic */ Anchor anchor$default(SlotWriter slotWriter, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = slotWriter.currentGroup;
        }
        return slotWriter.anchor(i);
    }

    public final Anchor anchor(int index) {
        ArrayList<Anchor> arrayList = this.anchors;
        int access$search = SlotTableKt.access$search(arrayList, index, getSize$runtime());
        if (access$search < 0) {
            if (index > this.groupGapStart) {
                index = -(getSize$runtime() - index);
            }
            Anchor anchor = new Anchor(index);
            arrayList.add(-(access$search + 1), anchor);
            return anchor;
        }
        return arrayList.get(access$search);
    }

    public static /* synthetic */ void markGroup$default(SlotWriter slotWriter, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = slotWriter.parent;
        }
        slotWriter.markGroup(i);
    }

    public final void markGroup(int group) {
        int groupIndexToAddress = groupIndexToAddress(group);
        int[] iArr = this.groups;
        int i = (groupIndexToAddress * 5) + 1;
        if ((iArr[i] & 134217728) != 0) {
            return;
        }
        SlotTableKt.access$updateMark(iArr, groupIndexToAddress, true);
        if ((this.groups[i] & 67108864) != 0) {
            return;
        }
        updateContainsMark(parent(group));
    }

    private final boolean containsGroupMark(int group) {
        if (group >= 0) {
            return (this.groups[(groupIndexToAddress(group) * 5) + 1] & 67108864) != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean containsAnyGroupMarks(int group) {
        if (group >= 0) {
            return (this.groups[(groupIndexToAddress(group) * 5) + 1] & 201326592) != 0;
        }
        return false;
    }

    private final void recalculateMarks() {
        MutableIntList mutableIntList = this.pendingRecalculateMarks;
        if (mutableIntList != null) {
            while (PrioritySet.m4067isNotEmptyimpl(mutableIntList)) {
                m4086updateContainsMarkNowXpTMRCE(PrioritySet.m4069takeMaximpl(mutableIntList), mutableIntList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateContainsMark(int group) {
        if (group >= 0) {
            MutableIntList mutableIntList = this.pendingRecalculateMarks;
            if (mutableIntList == null) {
                mutableIntList = PrioritySet.m4062constructorimpl$default(null, 1, null);
                this.pendingRecalculateMarks = mutableIntList;
            }
            PrioritySet.m4059addimpl(mutableIntList, group);
        }
    }

    /* renamed from: updateContainsMarkNow-XpTMRCE, reason: not valid java name */
    private final void m4086updateContainsMarkNowXpTMRCE(int group, MutableIntList set) {
        int groupIndexToAddress = groupIndexToAddress(group);
        boolean childContainsAnyMarks = childContainsAnyMarks(group);
        int[] iArr = this.groups;
        if (((iArr[(groupIndexToAddress * 5) + 1] & 67108864) != 0) != childContainsAnyMarks) {
            SlotTableKt.access$updateContainsMark(iArr, groupIndexToAddress, childContainsAnyMarks);
            int parent = parent(group);
            if (parent >= 0) {
                PrioritySet.m4059addimpl(set, parent);
            }
        }
    }

    private final boolean childContainsAnyMarks(int group) {
        int i = group + 1;
        int groupSize = group + groupSize(group);
        while (true) {
            if (i >= groupSize) {
                return false;
            }
            if ((this.groups[(groupIndexToAddress(i) * 5) + 1] & 201326592) != 0) {
                return true;
            }
            i += groupSize(i);
        }
    }

    public final int anchorIndex(Anchor anchor) {
        int location = anchor.getLocation();
        return location < 0 ? location + getSize$runtime() : location;
    }

    public String toString() {
        return "SlotWriter(current = " + this.currentGroup + " end=" + this.currentGroupEnd + " size = " + getSize$runtime() + " gap=" + this.groupGapStart + '-' + (this.groupGapStart + this.groupGapLen) + ')';
    }

    private final void saveCurrentGroupEnd() {
        this.endStack.push((getCapacity() - this.groupGapLen) - this.currentGroupEnd);
    }

    private final int restoreCurrentGroupEnd() {
        int capacity = (getCapacity() - this.groupGapLen) - this.endStack.pop();
        this.currentGroupEnd = capacity;
        return capacity;
    }

    private final void fixParentAnchorsFor(int parent, int endGroup, int firstChild) {
        int parentIndexToAnchor = parentIndexToAnchor(parent, this.groupGapStart);
        while (firstChild < endGroup) {
            this.groups[(groupIndexToAddress(firstChild) * 5) + 2] = parentIndexToAnchor;
            int access$groupSize = SlotTableKt.access$groupSize(this.groups, groupIndexToAddress(firstChild)) + firstChild;
            fixParentAnchorsFor(firstChild, access$groupSize, firstChild + 1);
            firstChild = access$groupSize;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveGroupGapTo(int index) {
        int i = this.groupGapLen;
        int i2 = this.groupGapStart;
        if (i2 != index) {
            if (!this.anchors.isEmpty()) {
                updateAnchors(i2, index);
            }
            if (i > 0) {
                int[] iArr = this.groups;
                int i3 = index * 5;
                int i4 = i * 5;
                int i5 = i2 * 5;
                if (index < i2) {
                    ArraysKt.copyInto(iArr, iArr, i4 + i3, i3, i5);
                } else {
                    ArraysKt.copyInto(iArr, iArr, i5, i5 + i4, i3 + i4);
                }
            }
            if (index < i2) {
                i2 = index + i;
            }
            int capacity = getCapacity();
            if (!(i2 < capacity)) {
                ComposerKt.composeImmediateRuntimeError("Check failed");
            }
            while (i2 < capacity) {
                int i6 = (i2 * 5) + 2;
                int i7 = this.groups[i6];
                int parentIndexToAnchor = parentIndexToAnchor(parentAnchorToIndex(i7), index);
                if (parentIndexToAnchor != i7) {
                    this.groups[i6] = parentIndexToAnchor;
                }
                i2++;
                if (i2 == index) {
                    i2 += i;
                }
            }
        }
        this.groupGapStart = index;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveSlotGapTo(int index, int group) {
        int i = this.slotsGapLen;
        int i2 = this.slotsGapStart;
        int i3 = this.slotsGapOwner;
        if (i2 != index) {
            Object[] objArr = this.slots;
            if (index < i2) {
                System.arraycopy(objArr, index, objArr, index + i, i2 - index);
            } else {
                int i4 = i2 + i;
                System.arraycopy(objArr, i4, objArr, i2, (index + i) - i4);
            }
        }
        int min = Math.min(group + 1, getSize$runtime());
        if (i3 != min) {
            int length = this.slots.length - i;
            if (min < i3) {
                int groupIndexToAddress = groupIndexToAddress(min);
                int groupIndexToAddress2 = groupIndexToAddress(i3);
                int i5 = this.groupGapStart;
                while (groupIndexToAddress < groupIndexToAddress2) {
                    int i6 = (groupIndexToAddress * 5) + 4;
                    int i7 = this.groups[i6];
                    if (!(i7 >= 0)) {
                        ComposerKt.composeImmediateRuntimeError("Unexpected anchor value, expected a positive anchor");
                    }
                    this.groups[i6] = -((length - i7) + 1);
                    groupIndexToAddress++;
                    if (groupIndexToAddress == i5) {
                        groupIndexToAddress += this.groupGapLen;
                    }
                }
            } else {
                int groupIndexToAddress3 = groupIndexToAddress(i3);
                int groupIndexToAddress4 = groupIndexToAddress(min);
                while (groupIndexToAddress3 < groupIndexToAddress4) {
                    int i8 = (groupIndexToAddress3 * 5) + 4;
                    int i9 = this.groups[i8];
                    if (!(i9 < 0)) {
                        ComposerKt.composeImmediateRuntimeError("Unexpected anchor value, expected a negative anchor");
                    }
                    this.groups[i8] = i9 + length + 1;
                    groupIndexToAddress3++;
                    if (groupIndexToAddress3 == this.groupGapStart) {
                        groupIndexToAddress3 += this.groupGapLen;
                    }
                }
            }
            this.slotsGapOwner = min;
        }
        this.slotsGapStart = index;
    }

    private final void clearSlotGap() {
        int i = this.slotsGapStart;
        ArraysKt.fill(this.slots, (Object) null, i, this.slotsGapLen + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void insertGroups(int size) {
        if (size > 0) {
            int i = this.currentGroup;
            moveGroupGapTo(i);
            int i2 = this.groupGapStart;
            int i3 = this.groupGapLen;
            int[] iArr = this.groups;
            int length = iArr.length / 5;
            int i4 = length - i3;
            if (i3 < size) {
                int max = Math.max(Math.max(length * 2, i4 + size), 32);
                int[] iArr2 = new int[max * 5];
                int i5 = max - i4;
                ArraysKt.copyInto(iArr, iArr2, 0, 0, i2 * 5);
                ArraysKt.copyInto(iArr, iArr2, (i2 + i5) * 5, (i3 + i2) * 5, length * 5);
                this.groups = iArr2;
                i3 = i5;
            }
            int i6 = this.currentGroupEnd;
            if (i6 >= i2) {
                this.currentGroupEnd = i6 + size;
            }
            int i7 = i2 + size;
            this.groupGapStart = i7;
            this.groupGapLen = i3 - size;
            int dataIndexToDataAnchor = dataIndexToDataAnchor(i4 > 0 ? dataIndex(i + size) : 0, this.slotsGapOwner >= i2 ? this.slotsGapStart : 0, this.slotsGapLen, this.slots.length);
            for (int i8 = i2; i8 < i7; i8++) {
                this.groups[(i8 * 5) + 4] = dataIndexToDataAnchor;
            }
            int i9 = this.slotsGapOwner;
            if (i9 >= i2) {
                this.slotsGapOwner = i9 + size;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void insertSlots(int size, int group) {
        if (size > 0) {
            moveSlotGapTo(this.currentSlot, group);
            int i = this.slotsGapStart;
            int i2 = this.slotsGapLen;
            if (i2 < size) {
                Object[] objArr = this.slots;
                int length = objArr.length;
                int i3 = length - i2;
                int max = Math.max(Math.max(length * 2, i3 + size), 32);
                Object[] objArr2 = new Object[max];
                for (int i4 = 0; i4 < max; i4++) {
                    objArr2[i4] = null;
                }
                int i5 = max - i3;
                int i6 = i2 + i;
                System.arraycopy(objArr, 0, objArr2, 0, i + 0);
                System.arraycopy(objArr, i6, objArr2, i + i5, length - i6);
                this.slots = objArr2;
                i2 = i5;
            }
            int i7 = this.currentSlotEnd;
            if (i7 >= i) {
                this.currentSlotEnd = i7 + size;
            }
            this.slotsGapStart = i + size;
            this.slotsGapLen = i2 - size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean removeGroups(int start, int len) {
        if (len > 0) {
            ArrayList<Anchor> arrayList = this.anchors;
            moveGroupGapTo(start);
            r0 = arrayList.isEmpty() ^ true ? removeAnchors(start, len, this.sourceInformationMap) : false;
            this.groupGapStart = start;
            this.groupGapLen += len;
            int i = this.slotsGapOwner;
            if (i > start) {
                this.slotsGapOwner = Math.max(start, i - len);
            }
            int i2 = this.currentGroupEnd;
            if (i2 >= this.groupGapStart) {
                this.currentGroupEnd = i2 - len;
            }
            int i3 = this.parent;
            if (containsGroupMark(i3)) {
                updateContainsMark(i3);
            }
        }
        return r0;
    }

    public final GroupSourceInformation sourceInformationOf$runtime(int group) {
        Anchor tryAnchor$runtime;
        HashMap<Anchor, GroupSourceInformation> hashMap = this.sourceInformationMap;
        if (hashMap == null || (tryAnchor$runtime = tryAnchor$runtime(group)) == null) {
            return null;
        }
        return hashMap.get(tryAnchor$runtime);
    }

    public final Anchor tryAnchor$runtime(int group) {
        boolean z = false;
        if (group >= 0 && group < getSize$runtime()) {
            z = true;
        }
        if (z) {
            return SlotTableKt.access$find(this.anchors, group, getSize$runtime());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeSlots(int start, int len, int group) {
        if (len > 0) {
            int i = this.slotsGapLen;
            int i2 = start + len;
            moveSlotGapTo(i2, group);
            this.slotsGapStart = start;
            this.slotsGapLen = i + len;
            ArraysKt.fill(this.slots, (Object) null, start, i2);
            int i3 = this.currentSlotEnd;
            if (i3 >= start) {
                this.currentSlotEnd = i3 - len;
            }
        }
    }

    private final void updateNodeOfGroup(int index, Object value) {
        int groupIndexToAddress = groupIndexToAddress(index);
        int[] iArr = this.groups;
        boolean z = false;
        if (groupIndexToAddress < iArr.length) {
            if ((iArr[(groupIndexToAddress * 5) + 1] & 1073741824) != 0) {
                z = true;
            }
        }
        if (!z) {
            ComposerKt.composeImmediateRuntimeError("Updating the node of a group at " + index + " that was not created with as a node group");
        }
        this.slots[dataIndexToDataAddress(nodeIndex(this.groups, groupIndexToAddress))] = value;
    }

    private final void updateAnchors(int previousGapStart, int newGapStart) {
        Anchor anchor;
        int location;
        Anchor anchor2;
        int location2;
        int i;
        int capacity = getCapacity() - this.groupGapLen;
        if (previousGapStart < newGapStart) {
            for (int access$locationOf = SlotTableKt.access$locationOf(this.anchors, previousGapStart, capacity); access$locationOf < this.anchors.size() && (location2 = (anchor2 = this.anchors.get(access$locationOf)).getLocation()) < 0 && (i = location2 + capacity) < newGapStart; access$locationOf++) {
                anchor2.setLocation$runtime(i);
            }
            return;
        }
        for (int access$locationOf2 = SlotTableKt.access$locationOf(this.anchors, newGapStart, capacity); access$locationOf2 < this.anchors.size() && (location = (anchor = this.anchors.get(access$locationOf2)).getLocation()) >= 0; access$locationOf2++) {
            anchor.setLocation$runtime(-(capacity - location));
        }
    }

    private final boolean removeAnchors(int gapStart, int size, HashMap<Anchor, GroupSourceInformation> sourceInformationMap) {
        int i = size + gapStart;
        int access$locationOf = SlotTableKt.access$locationOf(this.anchors, i, getCapacity() - this.groupGapLen);
        if (access$locationOf >= this.anchors.size()) {
            access$locationOf--;
        }
        int i2 = access$locationOf + 1;
        int i3 = 0;
        while (access$locationOf >= 0) {
            Anchor anchor = this.anchors.get(access$locationOf);
            int anchorIndex = anchorIndex(anchor);
            if (anchorIndex < gapStart) {
                break;
            }
            if (anchorIndex < i) {
                anchor.setLocation$runtime(Integer.MIN_VALUE);
                if (sourceInformationMap != null) {
                    sourceInformationMap.remove(anchor);
                }
                if (i3 == 0) {
                    i3 = access$locationOf + 1;
                }
                i2 = access$locationOf;
            }
            access$locationOf--;
        }
        boolean z = i2 < i3;
        if (z) {
            this.anchors.subList(i2, i3).clear();
        }
        return z;
    }

    private final void moveAnchors(int originalLocation, int newLocation, int size) {
        Anchor anchor;
        int anchorIndex;
        int i = size + originalLocation;
        int size$runtime = getSize$runtime();
        int access$locationOf = SlotTableKt.access$locationOf(this.anchors, originalLocation, size$runtime);
        ArrayList arrayList = new ArrayList();
        if (access$locationOf >= 0) {
            while (access$locationOf < this.anchors.size() && (anchorIndex = anchorIndex((anchor = this.anchors.get(access$locationOf)))) >= originalLocation && anchorIndex < i) {
                arrayList.add(anchor);
                this.anchors.remove(access$locationOf);
            }
        }
        int i2 = newLocation - originalLocation;
        int size2 = arrayList.size();
        for (int i3 = 0; i3 < size2; i3++) {
            Anchor anchor2 = (Anchor) arrayList.get(i3);
            int anchorIndex2 = anchorIndex(anchor2) + i2;
            if (anchorIndex2 >= this.groupGapStart) {
                anchor2.setLocation$runtime(-(size$runtime - anchorIndex2));
            } else {
                anchor2.setLocation$runtime(anchorIndex2);
            }
            this.anchors.add(SlotTableKt.access$locationOf(this.anchors, anchorIndex2, size$runtime), anchor2);
        }
    }

    public final String toDebugString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder append = sb.append(toString());
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        Intrinsics.checkNotNullExpressionValue(append.append('\n'), "append(...)");
        StringBuilder append2 = sb.append("  parent:    " + this.parent);
        Intrinsics.checkNotNullExpressionValue(append2, "append(...)");
        Intrinsics.checkNotNullExpressionValue(append2.append('\n'), "append(...)");
        StringBuilder append3 = sb.append("  current:   " + this.currentGroup);
        Intrinsics.checkNotNullExpressionValue(append3, "append(...)");
        Intrinsics.checkNotNullExpressionValue(append3.append('\n'), "append(...)");
        StringBuilder append4 = sb.append("  group gap: " + this.groupGapStart + '-' + (this.groupGapStart + this.groupGapLen) + '(' + this.groupGapLen + ')');
        Intrinsics.checkNotNullExpressionValue(append4, "append(...)");
        Intrinsics.checkNotNullExpressionValue(append4.append('\n'), "append(...)");
        StringBuilder append5 = sb.append("  slots gap: " + this.slotsGapStart + '-' + (this.slotsGapStart + this.slotsGapLen) + '(' + this.slotsGapLen + ')');
        Intrinsics.checkNotNullExpressionValue(append5, "append(...)");
        Intrinsics.checkNotNullExpressionValue(append5.append('\n'), "append(...)");
        StringBuilder append6 = sb.append("  gap owner: " + this.slotsGapOwner);
        Intrinsics.checkNotNullExpressionValue(append6, "append(...)");
        Intrinsics.checkNotNullExpressionValue(append6.append('\n'), "append(...)");
        int size$runtime = getSize$runtime();
        for (int i = 0; i < size$runtime; i++) {
            groupAsString(sb, i);
            sb.append('\n');
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    private final void groupAsString(StringBuilder sb, int i) {
        int groupIndexToAddress = groupIndexToAddress(i);
        sb.append("Group(");
        if (i < 10) {
            sb.append(' ');
        }
        if (i < 100) {
            sb.append(' ');
        }
        if (i < 1000) {
            sb.append(' ');
        }
        sb.append(i);
        if (groupIndexToAddress != i) {
            sb.append("(");
            sb.append(groupIndexToAddress);
            sb.append(")");
        }
        sb.append('#');
        sb.append(SlotTableKt.access$groupSize(this.groups, groupIndexToAddress));
        sb.append('^');
        int i2 = groupIndexToAddress * 5;
        int i3 = i2 + 2;
        sb.append(parentAnchorToIndex(this.groups[i3]));
        sb.append(": key=");
        sb.append(this.groups[i2]);
        sb.append(", nodes=");
        int i4 = i2 + 1;
        sb.append(this.groups[i4] & 67108863);
        sb.append(", dataAnchor=");
        sb.append(this.groups[i2 + 4]);
        sb.append(", parentAnchor=");
        sb.append(this.groups[i3]);
        if ((this.groups[i4] & 1073741824) != 0) {
            sb.append(", node=" + SlotTableKt.access$summarize(String.valueOf(this.slots[dataIndexToDataAddress(nodeIndex(this.groups, groupIndexToAddress))]), 10));
        }
        int slotIndex = slotIndex(this.groups, groupIndexToAddress);
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(i + 1));
        if (dataIndex > slotIndex) {
            sb.append(", [");
            for (int i5 = slotIndex; i5 < dataIndex; i5++) {
                if (i5 != slotIndex) {
                    sb.append(", ");
                }
                sb.append(SlotTableKt.access$summarize(String.valueOf(this.slots[dataIndexToDataAddress(i5)]), 10));
            }
            sb.append(']');
        }
        sb.append(")");
    }

    public final void verifyDataAnchors$runtime() {
        int i = this.slotsGapOwner;
        int length = this.slots.length - this.slotsGapLen;
        int size$runtime = getSize$runtime();
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (i2 < size$runtime) {
            int groupIndexToAddress = groupIndexToAddress(i2);
            int[] iArr = this.groups;
            int i4 = iArr[(groupIndexToAddress * 5) + 4];
            int dataIndex = dataIndex(iArr, groupIndexToAddress);
            if (!(dataIndex >= i3)) {
                PreconditionsKt.throwIllegalStateException("Data index out of order at " + i2 + ", previous = " + i3 + ", current = " + dataIndex);
            }
            if (!(dataIndex <= length)) {
                PreconditionsKt.throwIllegalStateException("Data index, " + dataIndex + ", out of bound at " + i2);
            }
            if (i4 < 0 && !z) {
                if (!(i == i2)) {
                    PreconditionsKt.throwIllegalStateException("Expected the slot gap owner to be " + i + " found gap at " + i2);
                }
                z = true;
            }
            i2++;
            i3 = dataIndex;
        }
    }

    public final void verifyParentAnchors$runtime() {
        int i = this.groupGapStart;
        int i2 = this.groupGapLen;
        int capacity = getCapacity();
        int i3 = 0;
        while (true) {
            if (i3 >= i) {
                break;
            }
            if (!(this.groups[(i3 * 5) + 2] > -2)) {
                PreconditionsKt.throwIllegalStateException("Expected a start relative anchor at " + i3);
            }
            i3++;
        }
        for (int i4 = i2 + i; i4 < capacity; i4++) {
            int i5 = this.groups[(i4 * 5) + 2];
            if (parentAnchorToIndex(i5) < i) {
                if (!(i5 > -2)) {
                    PreconditionsKt.throwIllegalStateException("Expected a start relative anchor at " + i4);
                }
            } else if (!(i5 <= -2)) {
                PreconditionsKt.throwIllegalStateException("Expected an end relative anchor at " + i4);
            }
        }
    }

    public final int getSize$runtime() {
        return getCapacity() - this.groupGapLen;
    }

    private final int getCapacity() {
        return this.groups.length / 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int groupIndexToAddress(int index) {
        return index + (this.groupGapLen * (index < this.groupGapStart ? 0 : 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndexToDataAddress(int dataIndex) {
        return dataIndex + (this.slotsGapLen * (dataIndex < this.slotsGapStart ? 0 : 1));
    }

    private final int parent(int[] iArr, int i) {
        return parentAnchorToIndex(iArr[(groupIndexToAddress(i) * 5) + 2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndex(int index) {
        return dataIndex(this.groups, groupIndexToAddress(index));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndex(int[] iArr, int i) {
        return i >= getCapacity() ? this.slots.length - this.slotsGapLen : dataAnchorToDataIndex(iArr[(i * 5) + 4], this.slotsGapLen, this.slots.length);
    }

    private final int slotIndex(int[] iArr, int i) {
        return i >= getCapacity() ? this.slots.length - this.slotsGapLen : dataAnchorToDataIndex(SlotTableKt.access$slotAnchor(iArr, i), this.slotsGapLen, this.slots.length);
    }

    private final void updateDataIndex(int[] iArr, int i, int i2) {
        iArr[(i * 5) + 4] = dataIndexToDataAnchor(i2, this.slotsGapStart, this.slotsGapLen, this.slots.length);
    }

    private final int nodeIndex(int[] iArr, int i) {
        return dataIndex(iArr, i);
    }

    private final int auxIndex(int[] iArr, int i) {
        return dataIndex(iArr, i) + Integer.bitCount(iArr[(i * 5) + 1] >> 29);
    }

    private final List<Integer> dataIndexes(int[] iArr) {
        List dataAnchors$default = SlotTableKt.dataAnchors$default(this.groups, 0, 1, null);
        List plus = CollectionsKt.plus(CollectionsKt.slice(dataAnchors$default, RangesKt.until(0, this.groupGapStart)), CollectionsKt.slice(dataAnchors$default, RangesKt.until(this.groupGapStart + this.groupGapLen, iArr.length / 5)));
        ArrayList arrayList = new ArrayList(plus.size());
        int size = plus.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(Integer.valueOf(dataAnchorToDataIndex(((Number) plus.get(i)).intValue(), this.slotsGapLen, this.slots.length)));
        }
        return arrayList;
    }

    private final List<Integer> keys() {
        List keys$default = SlotTableKt.keys$default(this.groups, 0, 1, null);
        ArrayList arrayList = new ArrayList(keys$default.size());
        int size = keys$default.size();
        int i = 0;
        while (i < size) {
            Object obj = keys$default.get(i);
            ((Number) obj).intValue();
            int i2 = this.groupGapStart;
            if (i < i2 || i >= i2 + this.groupGapLen) {
                arrayList.add(obj);
            }
            i++;
        }
        return arrayList;
    }

    private final int parentIndexToAnchor(int index, int gapStart) {
        return index < gapStart ? index : -((getSize$runtime() - index) + 2);
    }

    private final int parentAnchorToIndex(int index) {
        return index > -2 ? index : getSize$runtime() + index + 2;
    }

    public final void trimTailSlots(int count) {
        if (!(count > 0)) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        int i = this.parent;
        int slotIndex = slotIndex(this.groups, groupIndexToAddress(i));
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(i + 1)) - count;
        if (!(dataIndex >= slotIndex)) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        removeSlots(dataIndex, count, i);
        int i2 = this.currentSlot;
        if (i2 >= slotIndex) {
            this.currentSlot = i2 - count;
        }
    }

    public final void advanceBy(int amount) {
        if (!(amount >= 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot seek backwards");
        }
        if (!(this.insertCount <= 0)) {
            PreconditionsKt.throwIllegalStateException("Cannot call seek() while inserting");
        }
        if (amount == 0) {
            return;
        }
        int i = this.currentGroup + amount;
        if (!(i >= this.parent && i <= this.currentGroupEnd)) {
            ComposerKt.composeImmediateRuntimeError("Cannot seek outside the current group (" + this.parent + '-' + this.currentGroupEnd + ')');
        }
        this.currentGroup = i;
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(i));
        this.currentSlot = dataIndex;
        this.currentSlotEnd = dataIndex;
    }

    public final void forAllDataInRememberOrder(int group, Function2<? super Integer, Object, Unit> block) {
        int i;
        int i2;
        Anchor after;
        Function2<? super Integer, Object, Unit> function2 = block;
        int parent = parent(group);
        int size$runtime = getSize$runtime();
        int groupSize = groupSize(group) + group;
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i3 = group;
        MutableIntSet mutableIntSet = null;
        MutableIntList mutableIntList = null;
        while (i3 < groupSize) {
            int dataIndex = dataIndex(i3);
            int i4 = i3 + 1;
            int dataIndex2 = dataIndex(i4);
            while (true) {
                i = 0;
                if (dataIndex >= dataIndex2) {
                    break;
                }
                Object obj = this.slots[dataIndexToDataAddress(dataIndex)];
                if ((obj instanceof RememberObserverHolder) && (after = ((RememberObserverHolder) obj).getAfter()) != null && after.getValid()) {
                    int anchorIndex = anchorIndex(after);
                    if (mutableIntSet == null) {
                        mutableIntSet = IntSetKt.mutableIntSetOf();
                    }
                    if (mutableIntList == null) {
                        mutableIntList = new MutableIntList(0, 1, defaultConstructorMarker);
                    }
                    mutableIntSet.add(anchorIndex);
                    mutableIntList.add(anchorIndex);
                    mutableIntList.add(dataIndex);
                } else {
                    function2.invoke(Integer.valueOf(dataIndex), obj);
                }
                dataIndex++;
            }
            int parent2 = i4 < size$runtime ? parent(i4) : -1;
            if (parent2 != i3) {
                while (true) {
                    if (mutableIntList == null || mutableIntSet == null || !mutableIntSet.remove(i3)) {
                        i2 = size$runtime;
                    } else {
                        int i5 = mutableIntList._size;
                        int i6 = i5 / 2;
                        int i7 = i;
                        int i8 = i7;
                        while (i8 < i6) {
                            int i9 = i8 * 2;
                            int i10 = size$runtime;
                            int i11 = mutableIntList.get(i9);
                            if (i11 == i3) {
                                int i12 = mutableIntList.get(i9 + 1);
                                function2.invoke(Integer.valueOf(i12), this.slots[dataIndexToDataAddress(i12)]);
                            } else if (i9 != i7) {
                                int i13 = i7 + 1;
                                mutableIntList.set(i7, i11);
                                i7 = i13 + 1;
                                mutableIntList.set(i13, mutableIntList.get(i9 + 1));
                            } else {
                                i7 += 2;
                            }
                            i8++;
                            function2 = block;
                            size$runtime = i10;
                        }
                        i2 = size$runtime;
                        if (i7 != i5) {
                            mutableIntList.removeRange(i7, i5);
                        }
                    }
                    if (i3 != group && parent != parent2) {
                        i3 = parent;
                        size$runtime = i2;
                        i = 0;
                        parent = parent(parent);
                        function2 = block;
                    }
                }
            } else {
                i2 = size$runtime;
            }
            function2 = block;
            parent = parent2;
            i3 = i4;
            size$runtime = i2;
            defaultConstructorMarker = null;
        }
    }
}
