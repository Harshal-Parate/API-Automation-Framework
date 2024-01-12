package in.org.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
	"system:properties",
	"system:env",
	"file:${user.dir}/src/test/resources/configdata/config.properties"
})

public interface FrameworkConfig extends Config {

	@Key("xkarzakey")
	String xkarzakey();

	String env();

	@Key("${env}baseuri")
	String baseURI();
}
