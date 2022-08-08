package me.rominer_11.piglauncher;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static me.rominer_11.piglauncher.Piglauncher.inGame;

public class Play implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {

            int border = Integer.parseInt(args[0]);

            ItemStack gun = new ItemStack(Material.DIAMOND_HOE, 1);
            ItemMeta gunMeta = gun.getItemMeta();
            gunMeta.setDisplayName("e");
            gunMeta.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
            gun.setItemMeta(gunMeta);

            ItemStack glass = new ItemStack(Material.GLASS, 64);

            ItemStack pearls = new ItemStack(Material.ENDER_PEARL, 64);

            ItemStack apples = new ItemStack(Material.GOLDEN_APPLE, 64);

            ItemStack helm = new ItemStack(Material.DIAMOND_HELMET, 1);
            ItemMeta helmMeta = helm.getItemMeta();
            helmMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 2, true);
            helm.setItemMeta(helmMeta);
            ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
            ItemMeta chestMeta = chest.getItemMeta();
            chestMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 2, true);
            chest.setItemMeta(chestMeta);
            ItemStack pants = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
            ItemMeta pantsMeta = pants.getItemMeta();
            pantsMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 2, true);
            pants.setItemMeta(pantsMeta);
            ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS, 1);
            ItemMeta bootsMeta = boots.getItemMeta();
            bootsMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 2, true);
            boots.setItemMeta(bootsMeta);


            for (Player player : Bukkit.getOnlinePlayers()) {
                inGame.add(player);

                player.setHealth(player.getMaxHealth());

                player.getInventory().clear();

                player.getInventory().addItem(gun);
                player.getInventory().addItem(glass);
                player.getInventory().addItem(pearls);
                player.getInventory().addItem(apples);
                player.getInventory().addItem(helm);
                player.getInventory().addItem(chest);
                player.getInventory().addItem(pants);
                player.getInventory().addItem(boots);

                player.setGameMode(GameMode.SURVIVAL);

                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                System.out.println("spreadplayers 0 0 " + (border / 4) + " " + (border / 2) + " true @a");
                Bukkit.getServer().dispatchCommand(console, "spreadplayers 0 0 " + (border / 4) + " " + (border / 2) + " true @a");
                Bukkit.getServer().dispatchCommand(console, "worldborder set " + border);
            }

        }

        return false;
    }
}
