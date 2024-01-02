package ca.fxco.memoryleakfix.fabric;

import ca.fxco.memoryleakfix.MemoryLeakFixExpectPlatform;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.Version;
import net.fabricmc.loader.api.VersionParsingException;

public class MemoryLeakFixExpectPlatformImpl implements MemoryLeakFixExpectPlatform {

    public boolean isModLoaded(String id) {
        return FabricLoader.getInstance().isModLoaded(id);
    }

    public int compareMinecraftToVersion(String version) throws VersionParsingException {
        return FabricLoader.getInstance().getModContainer("minecraft").get().getMetadata().getVersion().compareTo(Version.parse(version));
    }

    public String getMappingType() {
        return "fabric";
    }

    public boolean isDevEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }
}
