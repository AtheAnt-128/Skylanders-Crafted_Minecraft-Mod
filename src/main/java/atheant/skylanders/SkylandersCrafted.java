package atheant.skylanders;

import atheant.skylanders.init.BlocksInit;
import atheant.skylanders.init.ItemsInit;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SkylandersCrafted implements ModInitializer {
	public static final String MOD_ID = "skylanders";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ItemsInit.initialize();
		BlocksInit.initialize();
	}
}