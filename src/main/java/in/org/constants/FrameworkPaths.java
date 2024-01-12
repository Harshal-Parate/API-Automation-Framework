package in.org.constants;

import lombok.Getter;

public class FrameworkPaths {

	private FrameworkPaths() {}

	@Getter
	protected static final String RESOURCES_PATH = System.getProperty("user.dir") + "/src/test/resources";
}
