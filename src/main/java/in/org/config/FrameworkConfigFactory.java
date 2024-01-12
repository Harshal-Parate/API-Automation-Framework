package in.org.config;

import org.aeonbits.owner.ConfigFactory;

public final class FrameworkConfigFactory {

	private FrameworkConfigFactory() {}

	public static FrameworkConfig createConfigFactory() {
		return ConfigFactory.create(FrameworkConfig.class);
	}
}
