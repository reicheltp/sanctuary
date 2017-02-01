package sanctuary.util;

import com.google.common.collect.ImmutableSet;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import sanctuary.SanctuaryMod;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Constants {
	public static final String RESOURCE_PREFIX = SanctuaryMod.MODID + ":";

	/**
	 * The armour equipment slots.
	 */
	public static final Set<EntityEquipmentSlot> ARMOUR_SLOTS = ImmutableSet.copyOf(
			Stream.of(EntityEquipmentSlot.values())
					.filter(equipmentSlot -> equipmentSlot.getSlotType() == EntityEquipmentSlot.Type.ARMOR)
					.collect(Collectors.toList())
	);

	/**
	 * {@link AttributeModifier} operation 0.
	 * <p>
	 * Add the modifier's amount to the attribute's amount.
	 */
	public static final int ATTRIBUTE_MODIFIER_OPERATION_ADD = 0;

	/**
	 * {@link AttributeModifier} operation 1.
	 * <p>
	 * Add the result of operation 0 multiplied by the modifier's amount to the attribute's amount.
	 */
	public static final int ATTRIBUTE_MODIFIER_OPERATION_MULTIPLY_OLD_AMOUNT = 1;

	/**
	 * {@link AttributeModifier} operation 2.
	 * <p>
	 * Multiply the attribute's amount by 1.0 + the modifier's amount.
	 */
	public static final int ATTRIBUTE_MODIFIER_OPERATION_MULTIPLY_NEW_AMOUNT = 2;
}
