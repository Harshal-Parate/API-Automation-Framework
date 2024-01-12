package in.org.allurereport;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;

import java.util.LinkedHashMap;

public final class AllureThreadSafe {

    private AllureThreadSafe() {}

    static AllureLifecycle lifecycle = Allure.getLifecycle();

    private static ThreadLocal<LinkedHashMap<Object, String>> threadSafe = ThreadLocal.withInitial(LinkedHashMap::new);

    public static String getTestCase(Object key) {
        return threadSafe.get().get(key);
    }

    public static String setTestCase(String key, Object testCase) {
        return threadSafe.get().put(key, (String) testCase);
    }

    public void unload() {
        threadSafe.remove();
    }
}