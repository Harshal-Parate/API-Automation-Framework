package in.org.constants;

import lombok.Getter;

public final class StringEndpoints {

	private StringEndpoints() {}

	@Getter private static final String validTestApiEndpoint = "/v2/tds";
	@Getter private static final String invalidTestApiEndpoint = "/v2/ifsco";
}