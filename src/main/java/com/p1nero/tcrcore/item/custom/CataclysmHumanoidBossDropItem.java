package com.p1nero.tcrcore.item.custom;

import com.p1nero.tcr_bosses.entity.cataclysm.BaseBossEntity;
import com.p1nero.tcrcore.utils.WorldUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CataclysmHumanoidBossDropItem extends SimpleDescriptionItem{
    private final EntityType<? extends BaseBossEntity> entityType;
    public CataclysmHumanoidBossDropItem(Properties properties, EntityType<? extends BaseBossEntity> entityType) {
        super(properties, true);
        this.entityType = entityType;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> list, @NotNull TooltipFlag flag) {
        list.add(Component.translatable(this.getDescriptionId() + ".usage", WorldUtil.SAMSARA_NAME, entityType.getDescription()).withStyle(ChatFormatting.GRAY));
    }
}
