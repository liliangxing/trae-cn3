package bytedance.resolver;

import bytedance.io.exception.IllegalPathException;

/* loaded from: classes2.dex */
public interface FileResolver {

    /* loaded from: classes2.dex */
    public interface Controller {
        FileHandler handle(FileHandler fileHandler) throws IllegalPathException;

        FileHandler originFile();
    }

    FileHandler resolve(Controller controller) throws IllegalPathException;
}
