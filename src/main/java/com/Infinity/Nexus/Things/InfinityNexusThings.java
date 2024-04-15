package com.Infinity.Nexus.Things;

import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(InfinityNexusThings.MOD_ID)
public class InfinityNexusThings
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "infinity_nexus_things";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "infinityNexusThings" namespace
    //public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    // Create a Deferred Register to hold Items which will all be registered under the "infinityNexusThings" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "infinityNexusThings" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    // Creates a new Block with the id "infinityNexusThings:example_block", combining the namespace and path
    //public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));
    // Creates a new BlockItem with the id "infinityNexusThings:example_block", combining the namespace and path
    //public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block", () -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties()));

    // Creates a new food item with the id "infinityNexusThings:example_id", nutrition 1 and saturation 2

    //Vips
    public static final RegistryObject<Item> VIP = ITEMS.register("vip_logo", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> VIP_PLUS = ITEMS.register("vip_plus_logo", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> VIP_NEXUS = ITEMS.register("vip_nexus_logo", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> VIP_INFINITY = ITEMS.register("vip_infinity_logo", () -> new Item(new Item.Properties().stacksTo(1)));

    //Warps
    public static final RegistryObject<Item> RTP = ITEMS.register("rtp", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> EXIT = ITEMS.register("exit", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> MOBS = ITEMS.register("mobs", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> LOJA = ITEMS.register("loja", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BOSSES = ITEMS.register("bosses", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> MINERAR = ITEMS.register("minerar", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> CAIXAS = ITEMS.register("caixas", () -> new Item(new Item.Properties().stacksTo(1)));

    //Kits
    public static final RegistryObject<Item> KIT_NB = ITEMS.register("kit_nb", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> KIT_DIARIO = ITEMS.register("kit_diario", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> KIT_START = ITEMS.register("kit_start", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> KIT_RESET = ITEMS.register("kit_reset", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> KIT_PARTNER = ITEMS.register("kit_partner", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> KIT_APPLIED = ITEMS.register("kit_applied", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> KIT_KEYS = ITEMS.register("kit_keys", () -> new Item(new Item.Properties().stacksTo(1)));



    // Creates a creative tab with the id "infinityNexusThings:example_tab" for the example item, that is placed after the combat tab
    //public static final RegistryObject<CreativeModeTab> INFINITY_NEXUS_THINGS_TAB = CREATIVE_MODE_TABS.register("infinity_nexus_things_tab", () -> CreativeModeTab.builder()
    //        .withTabsBefore(CreativeModeTabs.OP_BLOCKS)
    //        .icon(() -> VIP.get().getDefaultInstance())
    //        .displayItems((parameters, output) -> {
    //            output.accept(VIP.get());
    //        }).build());

    public InfinityNexusThings()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        //BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);


        modEventBus.addListener(this::setup);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.OP_BLOCKS) {
            event.accept(VIP);
            event.accept(VIP_PLUS);
            event.accept(VIP_NEXUS);
            event.accept(VIP_INFINITY);

            event.accept(RTP);
            event.accept(EXIT);
            event.accept(MOBS);
            event.accept(LOJA);
            event.accept(BOSSES);
            event.accept(MINERAR);
            event.accept(CAIXAS);

            event.accept(KIT_NB);
            event.accept(KIT_DIARIO);
            event.accept(KIT_START);
            event.accept(KIT_RESET);
            event.accept(KIT_PARTNER);
            event.accept(KIT_APPLIED);
            event.accept(KIT_KEYS);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("   §4_____§5_   __§9__________§3_   ______§b_______  __");
        LOGGER.info("  §4/_  _§5/ | / §9/ ____/  _§3/ | / /  _§b/_  __| \\/ /");
        LOGGER.info("   §4/ /§5/  |/ §9/ /_   / /§3/  |/ // /  §b/ /   \\  / ");
        LOGGER.info(" §4_/ /§5/ /|  §9/ __/ _/ /§3/ /|  // /  §b/ /    / /  ");
        LOGGER.info("§4/___§5/_/ |_§9/_/   /___§3/_/ |_/___/ §b/_/    /_/   ");
        LOGGER.info("§b          Infinity Nexus Things");
    }
}
