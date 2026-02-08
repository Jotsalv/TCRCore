package com.p1nero.tcrcore.capability;

import com.p1nero.tcrcore.capability.TCRQuestManager.Quest;
import com.p1nero.tcrcore.entity.TCREntities;
import com.p1nero.tcrcore.utils.WorldUtil;
import com.p1nero.tcrcore.worldgen.TCRDimensions;
import net.minecraft.core.BlockPos;

public class TCRQuests {

    //序章
    public static Quest TALK_TO_AINE_1;
    public static Quest TALK_TO_CHRONOS_1;
    public static Quest TALK_TO_FERRY_GIRL_1;
    public static Quest TALK_TO_ORNN_1;

    //养龙支线
    public static Quest TAME_DRAGON;
    public static Quest TAME_DRAGON_BACK_TO_FERRY_GIRL;

    //前往获取大地之眼
    public static Quest USE_RESONANCE_STONE_1;
    public static Quest GET_DESERT_EYE;

    public static void init() {
        TALK_TO_AINE_1 = TCRQuestManager.create("talk_to_aine_1")
                .shortDescParam(TCREntities.AINE_IRIS.get().getDescription())
                .descParam(TCREntities.AINE_IRIS.get().getDescription(), TCREntities.AINE_IRIS.get().getDescription())
                .withTrackingPos(new BlockPos(WorldUtil.AINE_POS.above(2)), TCRDimensions.SANCTUM_LEVEL_KEY);
        TALK_TO_CHRONOS_1 = TCRQuestManager.create("talk_to_col_1")
                .descParam(TCREntities.AINE_IRIS.get().getDescription(), TCREntities.AINE_IRIS.get().getDescription())
                .withTrackingPos(new BlockPos(WorldUtil.CHRONOS_SOL_BLOCK_POS.above(4)), TCRDimensions.SANCTUM_LEVEL_KEY);
        TALK_TO_FERRY_GIRL_1 = TCRQuestManager.create("talk_to_ferry_girl_1")
                .descParam(TCREntities.FERRY_GIRL.get().getDescription())
                .withTrackingPos(new BlockPos(WorldUtil.FERRY_GIRL_POS.above(1)), TCRDimensions.SANCTUM_LEVEL_KEY);
        TALK_TO_ORNN_1 = TCRQuestManager.create("talk_to_ornn_1")
                .shortDescParam(TCREntities.ORNN.get().getDescription())
                .descParam(TCREntities.CHRONOS_SOL.get().getDescription(), TCREntities.ORNN.get().getDescription())
                .withTrackingPos(new BlockPos(WorldUtil.ORNN_POS.above(3)), TCRDimensions.SANCTUM_LEVEL_KEY);


    }
}
