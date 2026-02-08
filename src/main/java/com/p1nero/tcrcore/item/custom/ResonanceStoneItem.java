package com.p1nero.tcrcore.item.custom;

import com.yesman.epicskills.registry.entry.EpicSkillsSounds;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ResonanceStoneItem extends SimpleDescriptionItem{
    public ResonanceStoneItem(Properties properties) {
        super(properties, true);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        if(!level.isClientSide) {
            String dimension = itemStack.getOrCreateTag().getString("target_dimension");
            String targetBoss = itemStack.getOrCreateTag().getString("target_boss");
            ResourceKey<Level> levelResourceKey = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse(dimension));
            if(level.dimension().equals(levelResourceKey)) {
                //TODO 搜结构
                itemStack.shrink(1);
                player.playSound(EpicSkillsSounds.GAIN_ABILITY_POINTS.get(), 1.0F, 1.0F);
            }
        }
        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> list, @NotNull TooltipFlag flag) {
        //TODO 添加目的地描述
        super.appendHoverText(itemStack, level, list, flag);
        if(level != null && level.isClientSide) {
            String dimension = itemStack.getOrCreateTag().getString("target_dimension");
            String targetBoss = itemStack.getOrCreateTag().getString("target_boss");
            //维度：
            //使徒：
        }
    }
}
