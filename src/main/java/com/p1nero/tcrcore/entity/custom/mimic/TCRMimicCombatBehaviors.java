package com.p1nero.tcrcore.entity.custom.mimic;

import com.asanginxst.epicfightx.gameassets.animations.AnimationsX;
import com.merlin204.avalon.entity.ai.AvalonCombatBehaviors;
import com.merlin204.avalon.entity.condition.TargetInGirdCondition;
import org.merlin204.mimic.entity.MimicPatch;
import org.merlin204.mimic.entity.ai.MimicConsumers;
import org.merlin204.mimic.epicfight.MimicAnimations;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;

import java.util.function.Function;

@SuppressWarnings({"unchecked"})
public class TCRMimicCombatBehaviors {

        public static final Function<MimicPatch, Boolean> targetPreAttack = mimicPatch -> {
                if(mimicPatch.getTarget() != null) {
                        LivingEntityPatch<?> livingEntityPatch = EpicFightCapabilities.getEntityPatch(mimicPatch.getTarget(), LivingEntityPatch.class);
                        return livingEntityPatch != null && livingEntityPatch.getEntityState().getLevel() == 1;
                }

                return false;
        };

    public static final AvalonCombatBehaviors.Builder<MimicPatch<?>> PHASE1 = AvalonCombatBehaviors.<MimicPatch>builder()

            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<MimicPatch>builder().weight(10000).cooldown(100).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(AnimationsX.BIPED_STEP_RIGHT)
                                    .custom(targetPreAttack))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(AnimationsX.BIPED_STEP_LEFT)
                                    .custom(targetPreAttack))
            )

            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<MimicPatch>builder().weight(10000).cooldown(100).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(AnimationsX.BIPED_STEP_LEFT)
                                    .custom(targetPreAttack))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(AnimationsX.BIPED_STEP_RIGHT)
                                    .custom(targetPreAttack))
            )

            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<MimicPatch>builder().weight(10000).cooldown(100).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(AnimationsX.BIPED_STEP_BACKWARD)
                                    .custom(targetPreAttack))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(AnimationsX.BIPED_STEP_BACKWARD)
                                    .custom(targetPreAttack))
            )

            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<MimicPatch>builder().weight(10000).cooldown(100).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(AnimationsX.BIPED_STEP_BACKWARD)
                                    .custom(targetPreAttack))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(AnimationsX.BIPED_STEP_BACKWARD)
                                    .custom(targetPreAttack))
            )

            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<MimicPatch>builder().weight(50).cooldown(10).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(MimicAnimations.SKILL_1)
                                    .predicate(new TargetInGirdCondition(new TargetInGirdCondition.Rectangle(5, -5, -5, 5))))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_RANDOM_COPY_WITHOUT_HIT))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(AnimationsX.BIPED_STEP_BACKWARD))
            )

            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<MimicPatch>builder().weight(1).cooldown(10).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(MimicAnimations.SKILL_1).withinDistance(0, 50))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_RANDOM_COPY_WITHOUT_HIT))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_RANDOM_COPY_WITHOUT_HIT))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(AnimationsX.BIPED_STEP_BACKWARD))
            )

            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<MimicPatch>builder().weight(50).cooldown(50).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(MimicAnimations.SKILL_1)
                                    .predicate(new TargetInGirdCondition(new TargetInGirdCondition.Rectangle(20, -20, -20, 20))))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_RANDOM_COPY_WITHOUT_HIT))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_RANDOM_COPY_WITHOUT_HIT))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_RANDOM_COPY_WITHOUT_HIT))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(AnimationsX.BIPED_STEP_BACKWARD))
            )

            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<MimicPatch>builder().weight(10).cooldown(10).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_CAN_HIT_COPY))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_CAN_HIT_COPY))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(AnimationsX.BIPED_STEP_BACKWARD)
                                    .predicate(new TargetInGirdCondition(new TargetInGirdCondition.Rectangle(5, -5, -5, 5))))
            )

            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<MimicPatch>builder().weight(10).cooldown(10).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.TRY_PLAY_COMBO))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.TRY_PLAY_COMBO))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.TRY_PLAY_COMBO))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(AnimationsX.BIPED_STEP_BACKWARD)
                                    .predicate(new TargetInGirdCondition(new TargetInGirdCondition.Rectangle(3, -3, -3, 3))))
            )

            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<MimicPatch>builder().weight(10).cooldown(10).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_CAN_HIT_COPY)
                                    .predicate(new TargetInGirdCondition(new TargetInGirdCondition.Rectangle(3, -3, -3, 3))))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_RANDOM_COPY))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_RANDOM_COPY_WITHOUT_HIT))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_RANDOM_COPY))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_CAN_HIT_COPY))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(AnimationsX.BIPED_STEP_BACKWARD))
            )

            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<MimicPatch>builder().weight(10).cooldown(10).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_CAN_HIT_COPY)
                                    .predicate(new TargetInGirdCondition(new TargetInGirdCondition.Rectangle(3, -3, -3, 3))))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_RANDOM_COPY_WITHOUT_HIT))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(MimicAnimations.SKILL_1))
            )

            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<MimicPatch>builder().weight(10).cooldown(10).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_RANDOM_COPY_WITHOUT_HIT)
                                    .predicate(new TargetInGirdCondition(new TargetInGirdCondition.Rectangle(3, -3, -3, 3))))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_RANDOM_COPY_WITHOUT_HIT))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(MimicAnimations.SKILL_1))
            );

    public static final AvalonCombatBehaviors.Builder<MimicPatch<?>> PHASE3 = AvalonCombatBehaviors.<MimicPatch>builder()
            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<MimicPatch>builder().weight(10000).cooldown(200).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(AnimationsX.BIPED_STEP_RIGHT)
                                    .custom(targetPreAttack))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(AnimationsX.BIPED_STEP_LEFT)
                                    .custom(targetPreAttack))
            )

            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<MimicPatch>builder().weight(10000).cooldown(200).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(AnimationsX.BIPED_STEP_LEFT)
                                    .custom(targetPreAttack))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(AnimationsX.BIPED_STEP_RIGHT)
                                    .custom(targetPreAttack))
            )

            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<MimicPatch>builder().weight(10000).cooldown(200).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(AnimationsX.BIPED_STEP_BACKWARD)
                                    .custom(targetPreAttack))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(AnimationsX.BIPED_STEP_BACKWARD)
                                    .custom(targetPreAttack))
            )

            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<MimicPatch>builder().weight(10000).cooldown(200).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(AnimationsX.BIPED_STEP_BACKWARD)
                                    .custom(targetPreAttack))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(AnimationsX.BIPED_STEP_BACKWARD)
                                    .custom(targetPreAttack))
            )
            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<MimicPatch>builder().weight(500).cooldown(10).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(MimicAnimations.SKILL_1)
                                    .predicate(new TargetInGirdCondition(new TargetInGirdCondition.Rectangle(5, -5, -5, 5))))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_RANDOM_COPY_WITHOUT_HIT))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_CAN_HIT_COPY))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(MimicAnimations.SKILL_1))
            )

            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<MimicPatch>builder().weight(500).cooldown(50).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(MimicAnimations.SKILL_1)
                                    .predicate(new TargetInGirdCondition(new TargetInGirdCondition.Rectangle(20, -20, -20, 20))))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_CAN_HIT_COPY))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_RANDOM_COPY_WITHOUT_HIT))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(MimicAnimations.SKILL_1))
            )

            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<MimicPatch>builder().weight(500).cooldown(50).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(MimicAnimations.SKILL_1)
                                    .predicate(new TargetInGirdCondition(new TargetInGirdCondition.Rectangle(20, -20, -20, 20))))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_RANDOM_COPY_WITHOUT_HIT))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.TRY_PLAY_COMBO))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(MimicAnimations.SKILL_1))
            )

            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<MimicPatch>builder().weight(100).cooldown(10).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_CAN_HIT_COPY))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_CAN_HIT_COPY))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.TRY_PLAY_COMBO))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(MimicAnimations.SKILL_1))
            )

            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<MimicPatch>builder().weight(100).cooldown(10).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.TRY_PLAY_COMBO))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.TRY_PLAY_COMBO))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.TRY_PLAY_COMBO))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(MimicAnimations.SKILL_1))
            )

            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<MimicPatch>builder().weight(100).cooldown(10).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_CAN_HIT_COPY)
                                    .predicate(new TargetInGirdCondition(new TargetInGirdCondition.Rectangle(3, -3, -3, 3))))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_RANDOM_COPY))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_RANDOM_COPY_WITHOUT_HIT))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_CAN_HIT_COPY))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_CAN_HIT_COPY))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(MimicAnimations.SKILL_1))
            )

            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<MimicPatch>builder().weight(100).cooldown(10).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_CAN_HIT_COPY)
                                    .predicate(new TargetInGirdCondition(new TargetInGirdCondition.Rectangle(3, -3, -3, 3))))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_RANDOM_COPY_WITHOUT_HIT))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_CAN_HIT_COPY))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_CAN_HIT_COPY))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().behavior(MimicConsumers.PLAY_RANDOM_COPY_WITHOUT_HIT))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<MimicPatch>builder().animationBehavior(MimicAnimations.SKILL_1))
            );

}