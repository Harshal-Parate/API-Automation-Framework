package in.org.datasupplier;

import io.github.sskorol.data.JsonReader;
import one.util.streamex.StreamEx;

import static io.github.sskorol.data.TestDataReader.use;

public final class DataSupplierService {

	private DataSupplierService() {}

	public static <T> StreamEx<T> getDataAsPerFile(String filePath, Class<T> className) {
		return use(JsonReader.class)
				.withTarget(className)
				.withSource(filePath)
				.read();
	}
}
