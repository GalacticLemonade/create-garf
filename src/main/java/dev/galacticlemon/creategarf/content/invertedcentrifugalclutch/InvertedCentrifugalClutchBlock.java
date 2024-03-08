package dev.galacticlemon.creategarf.content.invertedcentrifugalclutch;

import com.simibubi.create.content.kinetics.RotationPropagator;
import com.simibubi.create.content.kinetics.base.DirectionalKineticBlock;
import com.simibubi.create.foundation.block.IBE;
import dev.galacticlemon.creategarf.CreateGarfBlockEntities;
import dev.galacticlemon.creategarf.content.CGBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.NotNull;

public class InvertedCentrifugalClutchBlock extends DirectionalKineticBlock implements IBE<InvertedCentrifugalClutchBlockEntity> {
    public static final BooleanProperty UNCOUPLED = CGBlockStateProperties.UNCOUPLED;
    public InvertedCentrifugalClutchBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(UNCOUPLED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(UNCOUPLED);
        super.createBlockStateDefinition(builder);
    }

    @Override
    public Class<InvertedCentrifugalClutchBlockEntity> getBlockEntityClass() {
        return InvertedCentrifugalClutchBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends InvertedCentrifugalClutchBlockEntity> getBlockEntityType() {
        return CreateGarfBlockEntities.INVERTED_CENTRIFUGAL_CLUTCH.get();
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        return state.getValue(FACING).getAxis();
    }

    @Override
    public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) {
        return face.getAxis() == state.getValue(FACING).getAxis();
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean hasAnalogOutputSignal(@NotNull BlockState state) {
        return true;
    }

    @SuppressWarnings("deprecation")
    @Override
    public int getAnalogOutputSignal(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos) {
        return pState.getValue(UNCOUPLED) ? 0 : 15;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void tick(@NotNull BlockState pState, @NotNull ServerLevel pLevel, @NotNull BlockPos pPos, @NotNull RandomSource pRandom) {
        BlockEntity be = pLevel.getBlockEntity(pPos);
        if (!(be instanceof InvertedCentrifugalClutchBlockEntity kte))
            return;

        if (kte.reattachNextTick) {
            RotationPropagator.handleRemoved(pLevel, pPos, kte);
        }
    }
}
