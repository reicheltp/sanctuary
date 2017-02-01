package sanctuary.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import sanctuary.capability.spirit.CapabilitySpirit;
import sanctuary.capability.spirit.ISpiritHandler;
import sanctuary.capability.spirit.Spirit;

public class ItemHolyCross extends ItemSanctuary {
    public ItemHolyCross(String name) {
        super(name);
        this.setMaxStackSize(1);
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        // Temporarily use the cross to display the players spirit in chat

        final ISpiritHandler spirit = CapabilitySpirit.getSpirit(playerIn);

        if(spirit == null)
            return EnumActionResult.FAIL;

        if(worldIn.isRemote){
            playerIn.addChatComponentMessage(new TextComponentString("(Local) Player has spirit: " + spirit.toString()));
        } else {
            playerIn.addChatComponentMessage(new TextComponentString("(Server) Player has spirit: " + spirit.toString()));
        }

        // spirit.push(Spirit.MOON, 100);

        return EnumActionResult.SUCCESS;
    }
}
