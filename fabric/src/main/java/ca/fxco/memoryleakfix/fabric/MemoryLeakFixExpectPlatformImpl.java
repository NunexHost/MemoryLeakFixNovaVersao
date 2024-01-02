package ca.fxco.memoryleakfix.fabric;

import ca.fxco.memoryleakfix.MemoryLeakFixExpectPlatform;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.Version;
import net.fabricmc.loader.api.VersionParsingException;

public class MemoryLeakFixExpectPlatformImpl implements MemoryLeakFixExpectPlatform {

    @Override
    public boolean isModLoaded(String id) {
        return FabricLoader.getInstance().isModLoaded(id);
    }

    @Override
    public int compareMinecraftToVersion(String version) throws VersionParsingException {
        return FabricLoader.getInstance().getModContainer("minecraft").get().getMetadata().getVersion().compareTo(Version.parse(version));
    }

    @Override
    public String getMappingType() {
        return "fabric";
    }

    @Override
    public boolean isDevEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }
}
