package com.p1nero.tcrcore.block.entity;

import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.p1nero.tcrcore.capability.PlayerDataManager;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;

public class CursedAltarBlockEntity extends AbstractAltarBlockEntity {
    public CursedAltarBlockEntity(BlockPos pos, BlockState blockState) {
        super(TCRBlockEntities.CURSED_ALTAR_BLOCK_ENTITY.get(), pos, blockState, ModItems.CURSED_EYE.get());
    }

    @Override
    public void setActivated(Player player, boolean activated) {
        PlayerDataManager.cursedEyeActivated.put(player, activated);
    }

    @Override
    public boolean isActivated(Player player) {
        return PlayerDataManager.cursedEyeActivated.get(player);
    }

    @Override
    protected ParticleOptions getSpawnerParticle() {
        return ModParticle.CURSED_FLAME.get();
    }

    @Override
    public boolean checkBossKilled(Player player) {
        return PlayerDataManager.cursedEyeKilled.get(player);
    }

    @Override
    public boolean checkEyeFound(Player player) {
        return PlayerDataManager.cursedEyeGotten.get(player);
    }

    @Override
    public int getColor() {
        return ChatFormatting.DARK_GREEN.getColor();
    }
}
