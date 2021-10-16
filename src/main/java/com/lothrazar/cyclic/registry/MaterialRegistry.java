package com.lothrazar.cyclic.registry;

import com.lothrazar.cyclic.ModCyclic;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;

public class MaterialRegistry {

  public static final CreativeModeTab BLOCK_GROUP = new CreativeModeTab(ModCyclic.MODID) {

    @Override
    public ItemStack makeIcon() {
      return new ItemStack(BlockRegistry.trash);
    }
  };
  public static final CreativeModeTab ITEM_GROUP = new CreativeModeTab(ModCyclic.MODID + "items") {

    @Override
    public ItemStack makeIcon() {
      return new ItemStack(ItemRegistry.GEM_AMBER.get());
    }
  };

  public static class ArmorMats {

    private static final String EMERALDID = ModCyclic.MODID + ":emerald";
    private static final String CRYSTALID = ModCyclic.MODID + ":crystal";
    private static final String GLOWINGID = ModCyclic.MODID + ":glowing";
    public static final ArmorMaterial EMERALD = new ArmorMaterial() {

      @Override
      public int getDurabilityForSlot(EquipmentSlot slotIn) {
        return (ArmorMaterials.DIAMOND.getDurabilityForSlot(slotIn) + ArmorMaterials.NETHERITE.getDurabilityForSlot(slotIn)) / 2;
      }

      @Override
      public int getDefenseForSlot(EquipmentSlot slot) {
        switch (slot) {
          case CHEST:
            return ArmorMaterials.DIAMOND.getDefenseForSlot(slot) - 2;
          case FEET:
            return ArmorMaterials.DIAMOND.getDefenseForSlot(slot) + 2;
          case HEAD:
            return ArmorMaterials.DIAMOND.getDefenseForSlot(slot) - 1;
          case LEGS:
            return ArmorMaterials.DIAMOND.getDefenseForSlot(slot) + 1;
          case MAINHAND:
          case OFFHAND:
          default:
          break;
        }
        return 0;
      }

      @Override
      public int getEnchantmentValue() {
        return ArmorMaterials.GOLD.getEnchantmentValue() * 4;
      }

      @Override
      public SoundEvent getEquipSound() {
        return SoundRegistry.ITEM_ARMOR_EQUIP_EMERALD;
      }

      @Override
      public Ingredient getRepairIngredient() {
        return Ingredient.of(new ItemStack(Items.EMERALD));
      }

      @Override
      public String getName() {
        return EMERALDID;
      }

      @Override
      public float getToughness() {
        return (ArmorMaterials.DIAMOND.getToughness() + ArmorMaterials.NETHERITE.getToughness()) / 2;
      }

      @Override
      public float getKnockbackResistance() {
        return (ArmorMaterials.DIAMOND.getKnockbackResistance() + ArmorMaterials.NETHERITE.getKnockbackResistance()) / 2;
      }
    };
    public static final ArmorMaterial GEMOBSIDIAN = new ArmorMaterial() {

      @Override
      public int getDurabilityForSlot(EquipmentSlot slotIn) {
        return ArmorMaterials.NETHERITE.getEnchantmentValue() * 2;
      }

      @Override
      public int getDefenseForSlot(EquipmentSlot slot) {
        switch (slot) {
          case CHEST:
            return ArmorMaterials.NETHERITE.getDefenseForSlot(slot) - 1;
          case FEET:
            return ArmorMaterials.NETHERITE.getDefenseForSlot(slot) + 2;
          case HEAD:
            return ArmorMaterials.NETHERITE.getDefenseForSlot(slot) - 2;
          case LEGS:
            return ArmorMaterials.NETHERITE.getDefenseForSlot(slot) + 3;
          case MAINHAND:
          case OFFHAND:
          default:
          break;
        }
        return 0;
      }

      @Override
      public int getEnchantmentValue() {
        return ArmorMaterials.NETHERITE.getEnchantmentValue() + 2;
      }

      @Override
      public SoundEvent getEquipSound() {
        return SoundRegistry.ITEM_ARMOR_EQUIP_EMERALD;
      }

      @Override
      public Ingredient getRepairIngredient() {
        return Ingredient.of(new ItemStack(ItemRegistry.GEM_OBSIDIAN.get()));
      }

      @Override
      public String getName() {
        return CRYSTALID;
      }

      @Override
      public float getToughness() {
        return ArmorMaterials.NETHERITE.getToughness() * 1.5F;
      }

      @Override
      public float getKnockbackResistance() {
        return ArmorMaterials.NETHERITE.getKnockbackResistance();
      }
    };
    public static final ArmorMaterial GLOWING = new ArmorMaterial() {

      ArmorMaterials mimicArmor = ArmorMaterials.IRON;

      @Override
      public int getDurabilityForSlot(EquipmentSlot slotIn) {
        return mimicArmor.getDurabilityForSlot(slotIn);
      }

      @Override
      public int getDefenseForSlot(EquipmentSlot slotIn) {
        return mimicArmor.getDefenseForSlot(slotIn);
      }

      @Override
      public int getEnchantmentValue() {
        return mimicArmor.getEnchantmentValue() + 1;
      }

      @Override
      public SoundEvent getEquipSound() {
        return SoundRegistry.ITEM_ARMOR_EQUIP_EMERALD;
      }

      @Override
      public Ingredient getRepairIngredient() {
        return Ingredient.of(new ItemStack(ItemRegistry.GEM_AMBER.get()));
      }

      @Override
      public String getName() {
        return GLOWINGID;
      }

      @Override
      public float getToughness() {
        return mimicArmor.getToughness();
      }

      @Override
      public float getKnockbackResistance() {
        return mimicArmor.getKnockbackResistance();
      }
    };
  }

  public static class ToolMats {

    public static final Tier GEMOBSIDIAN = new Tier() {

      @Override
      public int getUses() {
        return Tiers.DIAMOND.getUses() * 4;
      }

      @Override
      public float getSpeed() {
        return Tiers.DIAMOND.getSpeed() * 4;
      }

      @Override
      public float getAttackDamageBonus() {
        return Tiers.DIAMOND.getAttackDamageBonus() + 1;
      }

      @Override
      public int getLevel() {
        return Tiers.DIAMOND.getLevel() + 1;
      }

      @Override
      public int getEnchantmentValue() {
        return (Tiers.DIAMOND.getEnchantmentValue() + Tiers.GOLD.getEnchantmentValue()) / 2;
      }

      @Override
      public Ingredient getRepairIngredient() {
        return Ingredient.of(new ItemStack(ItemRegistry.GEM_OBSIDIAN.get()));
      }
    };
    public static final Tier AMETHYST = new Tier() {

      @Override
      public int getUses() {
        return Tiers.IRON.getUses() + 5;
      }

      @Override
      public float getSpeed() {
        return Tiers.IRON.getSpeed() + 0.2F;
      }

      @Override
      public float getAttackDamageBonus() {
        return Tiers.IRON.getAttackDamageBonus() + 0.1F;
      }

      @Override
      public int getLevel() {
        return Tiers.IRON.getLevel();
      }

      @Override
      public int getEnchantmentValue() {
        return Tiers.GOLD.getEnchantmentValue();
      }

      @Override
      public Ingredient getRepairIngredient() {
        return Ingredient.of(new ItemStack(Items.AMETHYST_BLOCK));
      }
    };
    public static final Tier COPPER = new Tier() {

      @Override
      public int getUses() {
        return (Tiers.STONE.getUses() + Tiers.IRON.getUses()) / 2;
      }

      @Override
      public float getSpeed() {
        return (Tiers.STONE.getSpeed() + Tiers.IRON.getSpeed()) / 2;
      }

      @Override
      public float getAttackDamageBonus() {
        return (Tiers.STONE.getAttackDamageBonus() + Tiers.IRON.getAttackDamageBonus()) / 2;
      }

      @Override
      public int getLevel() {
        return Tiers.IRON.getLevel();
      }

      @Override
      public int getEnchantmentValue() {
        return Tiers.DIAMOND.getEnchantmentValue();
      }

      @Override
      public Ingredient getRepairIngredient() {
        return Ingredient.of(new ItemStack(Items.COPPER_INGOT));
      }
    };
    public static final Tier EMERALD = new Tier() {

      @Override
      public int getUses() {
        return (Tiers.DIAMOND.getUses() + Tiers.GOLD.getUses()) / 2;
      }

      @Override
      public float getSpeed() {
        return (Tiers.IRON.getAttackDamageBonus() + Tiers.DIAMOND.getAttackDamageBonus()) / 2;
      }

      @Override
      public float getAttackDamageBonus() {
        return (Tiers.IRON.getAttackDamageBonus() + Tiers.DIAMOND.getAttackDamageBonus()) / 2;
      }

      @Override
      public int getLevel() {
        return Tiers.DIAMOND.getLevel();
      }

      @Override
      public int getEnchantmentValue() {
        return Tiers.GOLD.getEnchantmentValue() + 1;
      }

      @Override
      public Ingredient getRepairIngredient() {
        return Ingredient.of(new ItemStack(Items.EMERALD));
      }
    };
    public static final Tier SANDSTONE = new Tier() {

      @Override
      public int getUses() {
        return Tiers.STONE.getUses() - 2;
      }

      @Override
      public float getSpeed() {
        return Tiers.STONE.getSpeed();
      }

      @Override
      public float getAttackDamageBonus() {
        return (Tiers.WOOD.getAttackDamageBonus() + Tiers.STONE.getAttackDamageBonus()) / 2;
      }

      @Override
      public int getLevel() {
        return Tiers.STONE.getLevel();
      }

      @Override
      public int getEnchantmentValue() {
        return Tiers.STONE.getLevel();
      }

      @Override
      public Ingredient getRepairIngredient() {
        return Ingredient.of(new ItemStack(net.minecraft.world.level.block.Blocks.SANDSTONE));
      }
    };
    public static final Tier NETHERBRICK = new Tier() {

      @Override
      public int getUses() {
        return (Tiers.IRON.getUses() + Tiers.GOLD.getUses()) / 2;
      }

      @Override
      public float getSpeed() {
        return (Tiers.IRON.getSpeed() + Tiers.GOLD.getSpeed()) / 2;
      }

      @Override
      public float getAttackDamageBonus() {
        return (Tiers.IRON.getAttackDamageBonus() + Tiers.GOLD.getAttackDamageBonus()) / 2;
      }

      @Override
      public int getLevel() {
        return Tiers.IRON.getLevel();
      }

      @Override
      public int getEnchantmentValue() {
        return Tiers.GOLD.getEnchantmentValue();
      }

      @Override
      public Ingredient getRepairIngredient() {
        return Ingredient.of(new ItemStack(net.minecraft.world.level.block.Blocks.NETHER_BRICKS));
      }
    };
  }
}
