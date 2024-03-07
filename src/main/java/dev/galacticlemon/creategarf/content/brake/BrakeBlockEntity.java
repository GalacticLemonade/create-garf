package dev.galacticlemon.creategarf.content.brake;

import com.simibubi.create.content.kinetics.BlockStressValues;
import com.simibubi.create.content.kinetics.transmission.SplitShaftBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import dev.galacticlemon.creategarf.CreateGarfBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.List;

import static dev.galacticlemon.creategarf.content.brake.BrakeBlock.POWERED;
public class BrakeBlockEntity extends SplitShaftBlockEntity {
    private static final int TICK_INTERVAL = 3;
    private static final float MIN_ADVANCEMENT_SPEED = 8;
    private int tickTimer = 0;
    private boolean advancementAwarded = false;


    public BrakeBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public float getRotationSpeedModifier(Direction face) {
        return 1;
    }

    @Override
    public float calculateStressApplied() {
        if (!getBlockState().getValue(POWERED)) {
            return super.calculateStressApplied();
        } else {
            float impact = 1000000000;
            this.lastStressApplied = impact;
            return impact;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (tickTimer-- < 0) {
            tickTimer = TICK_INTERVAL;

            double unpoweredStress = BlockStressValues.getImpact(CreateGarfBlocks.BRAKE.get());
            int poweredStress = 2147483647;
            boolean isBraking = getBlockState().getValue(POWERED) == (poweredStress >= unpoweredStress);
            if (unpoweredStress == poweredStress) {
                isBraking = unpoweredStress > 0;
            }
            float absSpeed = Mth.abs(getSpeed());
            if (level.isClientSide()) {
                if (isBraking && absSpeed > 0) {
                    Vec3 loc = Vec3.atBottomCenterOf(getBlockPos());
                    level.addParticle(ParticleTypes.LARGE_SMOKE, false, loc.x, loc.y + 0.5, loc.z, 0, 0.05, 0);
                }
            }
        }
    }

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
        super.addBehaviours(behaviours);
    }
}
