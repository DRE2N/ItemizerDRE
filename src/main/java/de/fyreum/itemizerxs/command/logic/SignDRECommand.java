package de.fyreum.itemizerxs.command.logic;

import de.erethon.commons.chat.MessageUtil;
import de.erethon.commons.command.DRECommand;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class SignDRECommand extends DRECommand {

    public SignDRECommand() {
        setConsoleCommand(false);
        setPlayerCommand(true);
    }

    @Override
    public void onExecute(String[] args, CommandSender sender) {
        Player player = (Player) sender;
        Block target = player.getTargetBlock(8);
        if (target == null || !(target.getState() instanceof Sign sign)) {
            MessageUtil.sendMessage(player, "&eDu musst ein Schild anschauen, um diesen Befehl ausführen zu dürfen");
            return;
        }

        onExecute(args, player, sign);
        sign.update();
    }

    public abstract void onExecute(String[] args, Player player, Sign sign);
}
