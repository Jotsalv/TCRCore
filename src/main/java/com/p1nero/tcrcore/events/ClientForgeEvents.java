package com.p1nero.tcrcore.events;

import com.brass_amber.ba_bt.block.blockentity.spawner.BTAbstractSpawnerBlockEntity;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.obscuria.obscureapi.api.BossBarsRenderManager;
import com.p1nero.dialog_lib.client.screen.DialogueScreen;
import com.p1nero.dialog_lib.events.ClientNpcEntityDialogueEvent;
import com.p1nero.tcrcore.TCRCoreMod;
import com.p1nero.tcrcore.client.gui.*;
import com.p1nero.tcrcore.dialog.custom.handler.HandleIronGolemDialog;
import com.p1nero.tcrcore.dialog.custom.handler.HandleVillagerDialog;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.LevelLoadingScreen;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.*;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

import java.util.*;

import static net.minecraft.client.gui.components.BossHealthOverlay.GUI_BARS_LOCATION;

@Mod.EventBusSubscriber(modid = TCRCoreMod.MOD_ID, value = Dist.CLIENT)
public class ClientForgeEvents {

    private static final Set<BlockPos> TARGET_SPAWNER_BLOCKS = new HashSet<>();

    public static void addTargetSpawner(BlockPos pos) {
        TARGET_SPAWNER_BLOCKS.add(pos);
    }

    public static void removeTargetSpawner(BlockPos pos) {
        TARGET_SPAWNER_BLOCKS.remove(pos);
    }

    public static Set<Button> buttonsInCreateWorldScreen = new HashSet<>();

    public static final ResourceLocation BACKGROUND_LOCATION = ResourceLocation.withDefaultNamespace("textures/gui/light_dirt_background.png");

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event){
        if(event.phase == TickEvent.Phase.END) {
            CustomQuestOverlayRenderer.tick();
            if(!buttonsInCreateWorldScreen.isEmpty()) {
                buttonsInCreateWorldScreen.forEach(button -> {
                    if(button.isHovered()) {
                        int dx = (int)(Math.random() * 100) - 50;
                        int dy = (int)(Math.random() * 100) - 50;
                        button.setPosition(button.getX() + dx, button.getY() + dy);
                    }
                });
            }
            if(!TARGET_SPAWNER_BLOCKS.isEmpty() && Minecraft.getInstance().level != null) {
                TARGET_SPAWNER_BLOCKS.removeIf(pos -> !(Minecraft.getInstance().level.getBlockEntity(pos) instanceof BTAbstractSpawnerBlockEntity));
            }
        }

    }

    /**
     * FIXME 官方要改的话记得删
     */
    @SubscribeEvent
    public static void onRenderBossBar(CustomizeGuiOverlayEvent.BossEventProgress event){
        Optional<BossBarsRenderManager.Style> style = BossBarsRenderManager.getStyle(event.getBossEvent().getName());
        if (style.isPresent()) {
            Component component = event.getBossEvent().getName();
            if (style.get().shouldRenderBar()) {
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                RenderSystem.setShaderTexture(0, GUI_BARS_LOCATION);
            }
            Minecraft minecraft = Minecraft.getInstance();
            style.get().getFunction().render(minecraft, event.getGuiGraphics(), event.getX(), event.getY(), event.getBossEvent(), component);
            if (style.get().shouldRenderName()) {
                int x = event.getWindow().getGuiScaledWidth() / 2 - minecraft.font.width(component) / 2;
                int y = event.getY() - 9;
                event.getGuiGraphics().drawString(minecraft.font, component, x, y, 16777215);
            }

            event.setIncrement(style.get().getIncrement(minecraft));
        }
    }

    @SubscribeEvent
    public static void onRenderOverlay(RenderGuiOverlayEvent.Pre event){
        if(Minecraft.getInstance().screen instanceof DialogueScreen) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onRenderGui(RenderGuiEvent.Pre event) {
        if(!Minecraft.getInstance().isPaused() && Minecraft.getInstance().screen == null && Minecraft.getInstance().player != null) {
            CustomQuestOverlayRenderer.render(Minecraft.getInstance().player, event.getGuiGraphics(), event.getPartialTick());
        }
    }

    @SubscribeEvent
    public static void onDialogSend(ClientNpcEntityDialogueEvent event) {
        if(event.getSelf() instanceof Villager villager) {
            HandleVillagerDialog.openDialogScreen(villager, event.getLocalPlayer(), event.getServerData());
        }
        if(event.getSelf() instanceof IronGolem ironGolem) {
            HandleIronGolemDialog.openDialogScreen(ironGolem, event.getLocalPlayer(), event.getServerData());
        }
    }

    @SubscribeEvent
    public static void onRenderBackground(ScreenEvent.BackgroundRendered event) {
        if(Minecraft.getInstance().level == null && !(event.getScreen() instanceof LevelLoadingScreen)) {
            event.getGuiGraphics().blit(BACKGROUND_LOCATION, 0, 0, 0, 0.0F, 0.0F, event.getScreen().width, event.getScreen().height, 32, 32);
//            event.getGuiGraphics().fill(0, 0, event.getScreen().width, event.getScreen().height, FastColor.ABGR32.color(255, 255, 255, 255));
        }

    }


    @SubscribeEvent
    public static void onRenderLevelStage(RenderLevelStageEvent event) {
        if(event.getStage() == RenderLevelStageEvent.Stage.AFTER_LEVEL) {
            for (BlockPos pos : TARGET_SPAWNER_BLOCKS) {

            }
        }

    }

}
