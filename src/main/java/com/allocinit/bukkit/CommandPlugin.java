package com.allocinit.bukkit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandPlugin extends JavaPlugin implements CommandExecutor {
   private String cmdName;
   private Map<String, SubCommand<?>> commands = new HashMap<>();

   public CommandPlugin(String cmdName) {
      this.cmdName = cmdName;
   }

   public void onEnable() {
      try {
         this.saveDefaultConfig();
      } catch (Exception e) {
      }

      this.getCommand(cmdName).setExecutor(this);
   }

   protected void registerSubCommand(SubCommand<?> cmd) {
      commands.put(cmd.getCommandName(), cmd);
   }

   @Override
   public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
      try {
         if (args.length == 0)
            throw new UsageException();

         SubCommand<?> cmd = commands.get(args[0]);

         if (cmd == null)
            throw new UsageException();

         cmd.doCommand(sender, Arrays.copyOfRange(args, 1, args.length));
      } catch (UsageException e) {
         this.writeUsage(sender);
      } catch (PermissionDeniedException e) {
         sender.sendMessage(ChatColor.RED + "Permission Denied");
      } catch (ErrorException e) {
         sender.sendMessage(ChatColor.RED + e.getMessage());
      } catch (Exception e) {
         sender.sendMessage("Uncaught exception: " + e.getMessage());
      }

      return true;
   }

   public void writeUsage(CommandSender player) {
      player.sendMessage("[" + ChatColor.GOLD + cmdName + ChatColor.WHITE + " usage]");
      for (SubCommand<?> cmd : commands.values())
         cmd.writeUsage(player);
   }
}
