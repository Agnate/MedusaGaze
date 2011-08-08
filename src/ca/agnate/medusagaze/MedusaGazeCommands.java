package ca.agnate.medusagaze;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MedusaGazeCommands implements CommandExecutor {

    MedusaGaze plugin;

    public MedusaGazeCommands(MedusaGaze plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label == null)
            return true;

        Player p = (sender instanceof Player) ? (Player) sender : null;
        boolean player = p != null;
        String base = label.toLowerCase();
        List<String> argsList = Arrays.asList(args);

        String warningMsg = "WARNING! Allowing Medusa to cast her gaze on your server will CAUSE AN INTENSE AMOUNT OF LAG! To continue, type: /medusagaze turnHerGazeOntoTheWorld YES";
        
        if (base.equals("medusa")  &&  plugin.has(p, MedusaGaze.COMMAND_WORLDGAZE) ) {
            if (argsList.get(0).equalsIgnoreCase("turnHerGazeOntoTheWorld")) {
                if (argsList.size() < 2) {
                    if (player) {
                        p.sendMessage(warningMsg);
                    }
                    else {
                        System.out.println(warningMsg);
                    }
                }
                else if (argsList.get(1).equalsIgnoreCase("YES")) {
                    plugin.releaseMedusaOntoTheWorld();
                }
            }
        }

        return true;
    }

}
