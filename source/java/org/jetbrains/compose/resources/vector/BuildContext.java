package org.jetbrains.compose.resources.vector;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: XmlVectorParser.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lorg/jetbrains/compose/resources/vector/BuildContext;", "", "<init>", "()V", "currentGroups", "", "Lorg/jetbrains/compose/resources/vector/BuildContext$Group;", "getCurrentGroups", "()Ljava/util/List;", "Group", "library_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes9.dex */
final class BuildContext {
    private final List<Group> currentGroups = new ArrayList();

    public final List<Group> getCurrentGroups() {
        return this.currentGroups;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: XmlVectorParser.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lorg/jetbrains/compose/resources/vector/BuildContext$Group;", "", "<init>", "(Ljava/lang/String;I)V", "Real", "Virtual", "library_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Group {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Group[] $VALUES;
        public static final Group Real = new Group("Real", 0);
        public static final Group Virtual = new Group("Virtual", 1);

        private static final /* synthetic */ Group[] $values() {
            return new Group[]{Real, Virtual};
        }

        public static EnumEntries<Group> getEntries() {
            return $ENTRIES;
        }

        private Group(String str, int i) {
        }

        static {
            Group[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static Group valueOf(String str) {
            return (Group) Enum.valueOf(Group.class, str);
        }

        public static Group[] values() {
            return (Group[]) $VALUES.clone();
        }
    }
}
