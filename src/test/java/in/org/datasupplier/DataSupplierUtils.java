package in.org.datasupplier;

import one.util.streamex.StreamEx;

import java.lang.reflect.Method;

//import static in.karza.datasupplier.DataSupplierService.getDataAsPerFile;
import static in.org.datasupplier.DataSupplierService.getDataAsPerFile;

public final class DataSupplierUtils {

	private DataSupplierUtils() {}

	public static <T> StreamEx<T> getData(
			String validDataFilePath,
			String invalidDataFilePath,
			String invalidOrMissingBodyKeysDataFilePath, String invalidOrMissingHeaderKeysDataFilePath,
			String invalidEndpointFilePath,
			Class<T> className, Method method) {

		if (method.getName().contains("ValidDetails"))
			return getDataAsPerFile(validDataFilePath, className);
		else if (method.getName().contains("InvalidDetails"))
			return getDataAsPerFile(invalidDataFilePath, className);
		else if (method.getName().contains("InvalidOrMissingBodyKeys"))
			return getDataAsPerFile(invalidOrMissingBodyKeysDataFilePath, className);
		else if (method.getName().contains("InvalidOrMissingHeaderKeys"))
			return getDataAsPerFile(invalidOrMissingHeaderKeysDataFilePath, className);
		else if (method.getName().contains("InvalidEndpoint"))
			return getDataAsPerFile(invalidEndpointFilePath, className);
		else
			return null;
	}
}
