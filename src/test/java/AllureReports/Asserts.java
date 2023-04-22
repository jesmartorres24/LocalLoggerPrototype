package AllureReports;

import org.testng.asserts.SoftAssert;

public class Asserts {

	private final static ThreadLocal<SoftAssert> SA_CONTAINER = new ThreadLocal<>();

	public static void clear() {
		SA_CONTAINER.set(new SoftAssert());
	}

	public static SoftAssert save() {
		return SA_CONTAINER.get();
	}

	public static void assertAll() {
		try {
			SA_CONTAINER.get().assertAll();
		} finally {
			clear();
		}
	}
}
