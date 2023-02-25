package fr.ensicaen.lv223.teams.copilot.robots;

import fr.ensicaen.lv223.model.agent.command.CommandFactory;
import fr.ensicaen.lv223.model.agent.robot.RobotType;
import fr.ensicaen.lv223.model.agent.robot.message.Message;
import fr.ensicaen.lv223.model.agent.robot.specials.OreExtractor;

public class OreExtractorCopilot extends OreExtractor {
    public OreExtractorCopilot(RobotType type, CommandFactory commandFactory) {
        super(type, commandFactory);
    }

    @Override
    public boolean isAvailable( Message m ) {
        return false;
    }
}
