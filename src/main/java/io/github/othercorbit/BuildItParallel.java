package io.github.othercorbit;

import io.github.othercorbit.client.handler.ClientKeybindEventListener;
import io.github.othercorbit.client.renderer.ShapeRenderer;
import io.github.othercorbit.init.ClientProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = BuildItParallel.MODID, name = BuildItParallel.NAME, version = BuildItParallel.VERSION)
public final class BuildItParallel
{
    /**
     * utility options:
     * <ul><li>Nodes and lines</li>
     *
     * <li>F3+N overwrite to use gmc and gmsp (NOT IN THIS VERSION)</li></ul>
     *
     * Resource pack/visual options: (NOT IN THIS VERSION)
     *      <ul><li>smooth text (NOT IN THIS VERSION)</li>
     *      <li>cool gui, maybe change the colors on it (would be cool) (NOT IN THIS VERSION)</li>
     *      <li>all 3D block and item and stuff models, but with fixed lighting (NOT IN THIS VERSION)</li>
     *      <li>1.14 texture changes option (NOT IN THIS VERSION)</li>
     *
     *      <li>hide spawn eggs and illegal items (NOT IN THIS VERSION)</li></ul>
     *
     * <li>store config in .minecraft/bip/config.txt (NOT IN THIS VERSION)</li>
     */

    public static final String MODID = "builditparallel";
    public static final String NAME = "Build It Parallel";
    public static final String VERSION = "1.0.1.1";

    ///////////

    public static Logger logger;

    /**
     * PreInitialization Events:
     * <li>Create logger</li>
     * <li>Initialize keybinds</li>
     * <li>Register keybind listener</li>
     * <li>Register shape renderer</li>
     * <li>create the catcher for F3+N (NOT IN THIS VERSION)</li>
     * @author Corbit
     */

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        ClientProxy.initKeybindings();

        MinecraftForge.EVENT_BUS.register(new ClientKeybindEventListener());
        MinecraftForge.EVENT_BUS.register(new ShapeRenderer());
    }
}