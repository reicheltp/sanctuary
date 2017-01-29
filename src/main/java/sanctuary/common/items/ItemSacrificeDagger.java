package sanctuary.common.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import sanctuary.common.SanctuaryItems;

public class ItemSacrificeDagger extends Item {
    public ItemSacrificeDagger() {
        this.setMaxStackSize(1);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {

        ItemStack offhand = player.getHeldItemOffhand();

        if(offhand.getItem() == SanctuaryItems.HOLY_CROSS){
            if(entity instanceof EntityChicken){
                entity.setDead();
                double power = player.getEntityData().getDouble("spiritual_power");
                player.getEntityData().setDouble("spiritual_power", power += 100);

                player.addChatComponentMessage(new TextComponentString("spiritual power now: " + power));

                return true;
            }
        }

        return false;
    }
}
