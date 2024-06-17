package papillon.vulcan.event;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import papillon.vulcan.Vulcan;
import papillon.vulcan.item.ModItems;

public class Event {
    public static boolean IsSlimeRain = false;
    public static boolean SlimeStart = false;
    public static long TimeBeforeSlime = 0;
    public static boolean IsSilverFishInvade = false;
    public static boolean SilverFishStar = false;
    public static long TimeBeforeFish = 0;
    public static boolean IsBloodMon = false;
    public static boolean IsSunOfGod = false;
    public static boolean IsSilverFishInvide = false;
    public static int difficulty = 0;
    public static long time_controle = 0;
    public static World world_;


    public static void upDateWorld(World world) {
        if (world!=null) {
            world_ = world;
        }
    }

    private static boolean hasAHelmet(PlayerEntity player) {
        return !player.getInventory().getArmorStack(3).isEmpty();
    }

    private static boolean hasAChestplate(PlayerEntity player) {
        return !player.getInventory().getArmorStack(2).isEmpty();
    }

    private static boolean hasALegging(PlayerEntity player) {
        return !player.getInventory().getArmorStack(1).isEmpty();
    }

    public static boolean hasABoot(PlayerEntity player) {
        return !player.getInventory().getArmorStack(0).isEmpty();
    }

    private static boolean AsIron(PlayerEntity player) {
        boolean val = false;
        if (hasABoot(player)) {
            val = val || (player.getInventory().getArmorStack(0).getItem() == Items.IRON_BOOTS);
        }
        if (hasALegging(player)) {
            val = val || (player.getInventory().getArmorStack(1).getItem() == Items.IRON_LEGGINGS);
        }
        if (hasAChestplate(player)) {
            val = val || (player.getInventory().getArmorStack(2).getItem() == Items.IRON_CHESTPLATE);
        }
        if (hasAHelmet(player)) {
            val = val || (player.getInventory().getArmorStack(3).getItem() == Items.IRON_HELMET);
        }
         return val;
    }
    
    private static boolean AsDiamond(PlayerEntity player) {
        boolean val = false;
        if(hasABoot(player)){
            val = val || (player.getInventory().getArmorStack(0).getItem() == Items.DIAMOND_BOOTS);
            }
        if(hasALegging(player)){
            val = val || (player.getInventory().getArmorStack(1).getItem() == Items.DIAMOND_LEGGINGS);
        }
        if(hasAChestplate(player)){
            val = val || (player.getInventory().getArmorStack(2).getItem() == Items.DIAMOND_CHESTPLATE);
        }
        if(hasAHelmet(player)){
            val = val || (player.getInventory().getArmorStack(3).getItem() == Items.DIAMOND_HELMET);
        }
        return val;
    }

    private static boolean AsVulcan(PlayerEntity player) {
        boolean val = false;
        if(hasABoot(player)){
            val = val || (player.getInventory().getArmorStack(0).getItem() == ModItems.VULCAN_BOOTS);
        }
        if(hasALegging(player)){
            val = val || (player.getInventory().getArmorStack(1).getItem() == ModItems.VULCAN_LEGGINGS);
        }
        if(hasAChestplate(player)){
            val = val || (player.getInventory().getArmorStack(2).getItem() == ModItems.VULCAN_CHESTPLATE);
        }
        if(hasAHelmet(player)){
            val = val || (player.getInventory().getArmorStack(3).getItem() == ModItems.VULCAN_HELMET);
        }
        return val;
    }

    public static void DifficultyCalcule(PlayerEntity player, World world) {
        upDateWorld(world);
        if (world.getTimeOfDay() % 100 == 0) {
            difficulty = 0;
        }
        if(AsVulcan(player)) {
            difficulty = 3;
        }
        else if(AsDiamond(player)) {
            if(difficulty < 2){
                difficulty = 2;
            }
        }
        else if(AsIron(player)) {
            if(difficulty < 1){
                difficulty = 1;
            }
        }
    }

    public static void DoSlimeFall() {
        if(world_ != null) {
            Vulcan.LOGGER.info("slime");
            SlimeEntity slime = new SlimeEntity(EntityType.SLIME, world_);
            slime.setSize(4, true);
            slime.setPos(100*Math.random(), 0, 100*Math.random()); //@todo modifier y, c'est la hauteur
            slime.setNoGravity(true);
            world_.spawnEntity(slime);
        }
    }

    public static void SlimeRain() {
        if(world_ != null) {
            Vulcan.LOGGER.info("rain");
            if (TimeBeforeSlime == 0) {
                if(!IsSlimeRain) {
                    IsSlimeRain = true;
                }
                else {
                    if (world_.getTimeOfDay() == 0) {
                        SlimeStart = true;
                    }
                    if (world_.getTimeOfDay() >= 0 && world_.getTimeOfDay() <= 13000) {//pnd la journée
                        if (world_.getTimeOfDay() % 100 == 0) {
                            DoSlimeFall();
                        }
                    }
                    if (world_.getTimeOfDay() >= 13000 && SlimeStart) { //fin du jour
                        TimeBeforeSlime = (long) (24000*(1+Math.random()));
                        TimeBeforeSlime = (long) ( 9600*(1+Math.random()));
                        SlimeStart = false;
                    }
                }

            } else {
                TimeBeforeSlime -= 1;
                TimeBeforeFish -= 1;
            }
        }
    }

    public static void SilverFishInvade() {
        if(world_ != null) {
            if (TimeBeforeFish == 0) {
                if (!IsSilverFishInvade) {
                    IsSilverFishInvade = true;
                } else {
                    if (world_.getTimeOfDay() == 0) {
                        SilverFishStar = true;
                    }
                    if (world_.getTimeOfDay() >= 0 && world_.getTimeOfDay() <= 13000) {//pnd la journée
                        if (world_.getTimeOfDay() % 100 == 0) {
                            DoSlimeFall(); //@todo modifer
                        }
                    }
                    if (world_.getTimeOfDay() >= 13000 && SilverFishStar) { //fin du jour
                        SilverFishStar = false;
                    }
                }
            }
        }
    }


}
