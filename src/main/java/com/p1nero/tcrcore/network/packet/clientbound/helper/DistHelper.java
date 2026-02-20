package com.p1nero.tcrcore.network.packet.clientbound.helper;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class DistHelper {
    public static void runClient(Supplier<Runnable> runnable) {
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, runnable);
    }

    public static void runServer(Supplier<Runnable> runnable) {
        DistExecutor.unsafeRunWhenOn(Dist.DEDICATED_SERVER, runnable);
    }


    public static void localPlayerDo(Consumer<Player> playerConsumer) {
        runClient(() -> () -> {
            if(Minecraft.getInstance().player != null) {
                playerConsumer.accept(Minecraft.getInstance().player);
            }
        });
    }

}